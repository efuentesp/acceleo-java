/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Empresas. 
 */
package com.softtek.acceleo.demo.catalogo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.RestController;
import com.softtek.acceleo.demo.exception.GenericException;

import com.softtek.acceleo.demo.catalogo.bean.EmpresaBean;
import com.softtek.acceleo.demo.domain.Empresa;
import com.softtek.acceleo.demo.service.EmpresaService;

/**
 * Clase EmpresaController.
 * @author PSG.
 *
 */
@RestController
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	Empresa empresa = new Empresa();

	/************************************** SEARCH
	 * Obtiene informacion de los empresas.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Empresa>.
	 */
	@RequestMapping(value = "/empresa", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('EMPRESASEARCH')")
	public @ResponseBody  List<Empresa> getEmpresas(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Empresa> listEmpresa = null;

		if (query==null && _page == 0) {
       		listEmpresa = empresaService.listEmpresas(empresa);
			rows = empresaService.getTotalRows();
		} else if (query!= null){
			listEmpresa = empresaService.listEmpresasQuery(empresa, query, _page, 10);
			rows = empresaService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listEmpresa = empresaService.listEmpresasPagination(empresa, _page, 10);
			rows = empresaService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listEmpresa;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un empresa.
	 * @param id.
	 * @return Empresa.
	 */
	@RequestMapping(value = "/idempresa/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('EMPRESASEARCH')")
	    public @ResponseBody  Empresa getEmpresa(@PathVariable("id") int id) {	        
	        Empresa empresa = null;
	        
	        empresa = empresaService.getEmpresa(id);
			return empresa;
	 }

	/*************************** CREATE
	 * Crea un nuevo empresa.
	 * @param empresa.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/empresa", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('EMPRESACREATE')")
	    public ResponseEntity<Void> createEmpresa(@RequestBody Empresa empresa,    UriComponentsBuilder ucBuilder) {
	   
	        empresaService.addEmpresa(empresa);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/empresa/{id}").buildAndExpand(empresa.getEmpresaId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un empresa.
	  * @param id.
	  * @param empresa.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/empresa/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('EMPRESAUPDATE')") 
	    public ResponseEntity<Empresa> actualizarEmpresa(
				@PathVariable("id") int id, 
				@RequestBody Empresa empresa) {
	        
	        Empresa empresaFound = empresaService.getEmpresa(id);
	         
	        if (empresaFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Empresa>(HttpStatus.NOT_FOUND);
	        }
	
	empresaFound.setClave(empresa.getClave());
	empresaFound.setNombrecorto(empresa.getNombrecorto());
	empresaFound.setRazonsocial(empresa.getRazonsocial());
	empresaFound.setEmpresaId(empresa.getEmpresaId());

		    empresaService.editEmpresa(empresaFound);
	        return new ResponseEntity<Empresa>(empresaFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un empresa.
		 * @param id.
		 * @return ResponseEntity<Empresa>.
		 */
		@RequestMapping(value = "/empresa/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('EMPRESADELETE')")  
	    public ResponseEntity<Empresa> deleteEmpresa(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Empresa empresa = empresaService.getEmpresa(id);
	         if (empresa == null) {
	             return new ResponseEntity<Empresa>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             empresaService.deleteEmpresa(empresa);
	             return new ResponseEntity<Empresa>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Empresa no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Empresa>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Empresa>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un empresa.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveEmpresa", method = RequestMethod.POST)
	@PreAuthorize("hasRole('EMPRESA')")  
	public @ResponseBody String saveEmpresa(
			@ModelAttribute("command") EmpresaBean empresaBean) {

		Empresa empresa = prepareModel(empresaBean);
		empresaService.addEmpresa(empresa);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un empresa.
	 * @param empresaBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editEmpresa", method = RequestMethod.POST)
	@PreAuthorize("hasRole('EMPRESA')")  
	public @ResponseBody String editEmpresa(
			@ModelAttribute("command") EmpresaBean empresaBean) {


		Empresa empresa = prepareModel(empresaBean);
		empresaService.editEmpresa(empresa);
		return "SUCCESS";
	}

	/**
	 * Agrega un EMPRESA.
	 * @param EMPRESABean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchEmpresa", method = RequestMethod.GET)
	@PreAuthorize("hasRole('EMPRESA')")  
	public ModelAndView addEmpresa(
			@ModelAttribute("command") EmpresaBean empresaBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Empresa empresa = null;
		if (empresaBean != null)
			empresa = prepareModel(empresaBean);
		model.put("empresas",
				prepareListofBean(empresaService.listEmpresas(empresa)));
		return new ModelAndView("searchEmpresa", model);
	}

	/**
	 * Elimina un empresa.
	 * @param empresaBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteEmpresa", method = RequestMethod.POST)
	@PreAuthorize("hasRole('EMPRESA')")  
	public ModelAndView deleteEmpresa(
			@ModelAttribute("command") EmpresaBean empresaBean,
			BindingResult result) {
		System.out.println("delete " + empresaBean.getEmpresaId());
		empresaService.deleteEmpresa(prepareModel(empresaBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("empresa", null);
		model.put("empresas",
				prepareListofBean(empresaService.listEmpresas(null)));
		return new ModelAndView("searchEmpresa", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryEmpresa", method = RequestMethod.GET)
	@PreAuthorize("hasRole('EMPRESA')")  
	public ModelAndView entryEmpresa() {
		return new ModelAndView("redirect:/searchEmpresa");
	}

	private Empresa prepareModel(EmpresaBean empresaBean) {
		Empresa empresa = new Empresa();

		//empresa.setDisplayresultempresaId(empresaBean.getEmpresaId());
		//empresa.setExposedfilterempresaId(empresaBean.getEmpresaId());
		//empresa.setDisplaymodalempresaId(empresaBean.getEmpresaId());
		//empresa.setEntitynameempresaId(empresaBean.getEmpresaId());
		//empresa.setScaffoldempresaId(empresaBean.getEmpresaId());
		empresa.setClave(empresaBean.getClave());
		empresa.setRazonsocial(empresaBean.getRazonsocial());
		empresa.setNombrecorto(empresaBean.getNombrecorto());
		empresa.setEmpresaId(empresaBean.getEmpresaId());
		empresaBean.setEmpresaId(null);

		return empresa;
	}

	/**
	 * Convierte un objeto de tipo EmpresaBean a un objeto de tipo Empresa.
	 * @param empresaBean.
	 * @return Empresa.
	 */
	private List<EmpresaBean> prepareListofBean(List<Empresa> empresas) {
		List<EmpresaBean> beans = null;
		if (empresas != null && !empresas.isEmpty()) {
			beans = new ArrayList<EmpresaBean>();
			EmpresaBean bean = null;
			for (Empresa empresa : empresas) {
				bean = new EmpresaBean();

				//bean.setDisplayresultempresaId(empresa.getEmpresaId());
				//bean.setExposedfilterempresaId(empresa.getEmpresaId());
				//bean.setDisplaymodalempresaId(empresa.getEmpresaId());
				//bean.setEntitynameempresaId(empresa.getEmpresaId());
				//bean.setScaffoldempresaId(empresa.getEmpresaId());
				bean.setClave(empresa.getClave());
				bean.setRazonsocial(empresa.getRazonsocial());
				bean.setNombrecorto(empresa.getNombrecorto());
				bean.setEmpresaId(empresa.getEmpresaId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


