/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Departamentos. 
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

import com.softtek.acceleo.demo.catalogo.bean.DepartamentoBean;
import com.softtek.acceleo.demo.domain.Departamento;
import com.softtek.acceleo.demo.service.DepartamentoService;

/**
 * Clase DepartamentoController.
 * @author PSG.
 *
 */
@RestController
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;
	
	Departamento departamento = new Departamento();

	/************************************** SEARCH
	 * Obtiene informacion de los departamentos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Departamento>.
	 */
	@RequestMapping(value = "/departamento", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('DEPARTAMENTOSEARCH')")
	public @ResponseBody  List<Departamento> getDepartamentos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Departamento> listDepartamento = null;

		if (query==null && _page == 0) {
       		listDepartamento = departamentoService.listDepartamentos(departamento);
			rows = departamentoService.getTotalRows();
		} else if (query!= null){
			listDepartamento = departamentoService.listDepartamentosQuery(departamento, query, _page, 10);
			rows = departamentoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listDepartamento = departamentoService.listDepartamentosPagination(departamento, _page, 10);
			rows = departamentoService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listDepartamento;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un departamento.
	 * @param id.
	 * @return Departamento.
	 */
	@RequestMapping(value = "/iddepartamento/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('DEPARTAMENTOSEARCH')")
	    public @ResponseBody  Departamento getDepartamento(@PathVariable("id") int id) {	        
	        Departamento departamento = null;
	        
	        departamento = departamentoService.getDepartamento(id);
			return departamento;
	 }

	/*************************** CREATE
	 * Crea un nuevo departamento.
	 * @param departamento.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/departamento", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('DEPARTAMENTOCREATE')")
	    public ResponseEntity<Void> createDepartamento(@RequestBody Departamento departamento,    UriComponentsBuilder ucBuilder) {
	   
	        departamentoService.addDepartamento(departamento);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/departamento/{id}").buildAndExpand(departamento.getDepartamentoId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un departamento.
	  * @param id.
	  * @param departamento.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/departamento/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('DEPARTAMENTOUPDATE')") 
	    public ResponseEntity<Departamento> actualizarDepartamento(
				@PathVariable("id") int id, 
				@RequestBody Departamento departamento) {
	        
	        Departamento departamentoFound = departamentoService.getDepartamento(id);
	         
	        if (departamentoFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Departamento>(HttpStatus.NOT_FOUND);
	        }
	
	departamentoFound.setRepresentante(departamento.getRepresentante());
	departamentoFound.setNombredepto(departamento.getNombredepto());
	departamentoFound.setEmpresaId(departamento.getEmpresaId());
	departamentoFound.setDepartamentoId(departamento.getDepartamentoId());

		    departamentoService.editDepartamento(departamentoFound);
	        return new ResponseEntity<Departamento>(departamentoFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un departamento.
		 * @param id.
		 * @return ResponseEntity<Departamento>.
		 */
		@RequestMapping(value = "/departamento/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('DEPARTAMENTODELETE')")  
	    public ResponseEntity<Departamento> deleteDepartamento(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Departamento departamento = departamentoService.getDepartamento(id);
	         if (departamento == null) {
	             return new ResponseEntity<Departamento>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             departamentoService.deleteDepartamento(departamento);
	             return new ResponseEntity<Departamento>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Departamento no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Departamento>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Departamento>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un departamento.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveDepartamento", method = RequestMethod.POST)
	@PreAuthorize("hasRole('DEPARTAMENTO')")  
	public @ResponseBody String saveDepartamento(
			@ModelAttribute("command") DepartamentoBean departamentoBean) {

		Departamento departamento = prepareModel(departamentoBean);
		departamentoService.addDepartamento(departamento);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un departamento.
	 * @param departamentoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editDepartamento", method = RequestMethod.POST)
	@PreAuthorize("hasRole('DEPARTAMENTO')")  
	public @ResponseBody String editDepartamento(
			@ModelAttribute("command") DepartamentoBean departamentoBean) {


		Departamento departamento = prepareModel(departamentoBean);
		departamentoService.editDepartamento(departamento);
		return "SUCCESS";
	}

	/**
	 * Agrega un DEPARTAMENTO.
	 * @param DEPARTAMENTOBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchDepartamento", method = RequestMethod.GET)
	@PreAuthorize("hasRole('DEPARTAMENTO')")  
	public ModelAndView addDepartamento(
			@ModelAttribute("command") DepartamentoBean departamentoBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Departamento departamento = null;
		if (departamentoBean != null)
			departamento = prepareModel(departamentoBean);
		model.put("departamentos",
				prepareListofBean(departamentoService.listDepartamentos(departamento)));
		return new ModelAndView("searchDepartamento", model);
	}

	/**
	 * Elimina un departamento.
	 * @param departamentoBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteDepartamento", method = RequestMethod.POST)
	@PreAuthorize("hasRole('DEPARTAMENTO')")  
	public ModelAndView deleteDepartamento(
			@ModelAttribute("command") DepartamentoBean departamentoBean,
			BindingResult result) {
		System.out.println("delete " + departamentoBean.getDepartamentoId());
		departamentoService.deleteDepartamento(prepareModel(departamentoBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("departamento", null);
		model.put("departamentos",
				prepareListofBean(departamentoService.listDepartamentos(null)));
		return new ModelAndView("searchDepartamento", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryDepartamento", method = RequestMethod.GET)
	@PreAuthorize("hasRole('DEPARTAMENTO')")  
	public ModelAndView entryDepartamento() {
		return new ModelAndView("redirect:/searchDepartamento");
	}

	private Departamento prepareModel(DepartamentoBean departamentoBean) {
		Departamento departamento = new Departamento();

		//departamento.setPerteneceId(departamentoBean.getPerteneceId());
		//departamento.setDisplayresultdepartamentoId(departamentoBean.getDepartamentoId());
		//departamento.setExposedfilterdepartamentoId(departamentoBean.getDepartamentoId());
		//departamento.setDisplaymodaldepartamentoId(departamentoBean.getDepartamentoId());
		//departamento.setEntitynamedepartamentoId(departamentoBean.getDepartamentoId());
		//departamento.setScaffolddepartamentoId(departamentoBean.getDepartamentoId());
		departamento.setNombredepto(departamentoBean.getNombredepto());
		departamento.setRepresentante(departamentoBean.getRepresentante());
		departamento.setDepartamentoId(departamentoBean.getDepartamentoId());
		departamentoBean.setDepartamentoId(null);

		return departamento;
	}

	/**
	 * Convierte un objeto de tipo DepartamentoBean a un objeto de tipo Departamento.
	 * @param departamentoBean.
	 * @return Departamento.
	 */
	private List<DepartamentoBean> prepareListofBean(List<Departamento> departamentos) {
		List<DepartamentoBean> beans = null;
		if (departamentos != null && !departamentos.isEmpty()) {
			beans = new ArrayList<DepartamentoBean>();
			DepartamentoBean bean = null;
			for (Departamento departamento : departamentos) {
				bean = new DepartamentoBean();

				//bean.setPerteneceId(departamento.getPerteneceId());
				//bean.setDisplayresultdepartamentoId(departamento.getDepartamentoId());
				//bean.setExposedfilterdepartamentoId(departamento.getDepartamentoId());
				//bean.setDisplaymodaldepartamentoId(departamento.getDepartamentoId());
				//bean.setEntitynamedepartamentoId(departamento.getDepartamentoId());
				//bean.setScaffolddepartamentoId(departamento.getDepartamentoId());
				bean.setNombredepto(departamento.getNombredepto());
				bean.setRepresentante(departamento.getRepresentante());
				bean.setDepartamentoId(departamento.getDepartamentoId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


