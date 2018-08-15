/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Cuentabancarias. 
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

import com.softtek.acceleo.demo.catalogo.bean.CuentabancariaBean;
import com.softtek.acceleo.demo.domain.Cuentabancaria;
import com.softtek.acceleo.demo.service.CuentabancariaService;

/**
 * Clase CuentabancariaController.
 * @author PSG.
 *
 */
@RestController
public class CuentabancariaController {

	@Autowired
	private CuentabancariaService cuentabancariaService;
	
	Cuentabancaria cuentabancaria = new Cuentabancaria();

	/************************************** SEARCH
	 * Obtiene informacion de los cuentabancarias.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Cuentabancaria>.
	 */
	@RequestMapping(value = "/cuentabancaria", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('CUENTABANCARIASEARCH')")
	public @ResponseBody  List<Cuentabancaria> getCuentabancarias(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Cuentabancaria> listCuentabancaria = null;

		if (query==null && _page == 0) {
       		listCuentabancaria = cuentabancariaService.listCuentabancarias(cuentabancaria);
			rows = cuentabancariaService.getTotalRows();
		} else if (query!= null){
			listCuentabancaria = cuentabancariaService.listCuentabancariasQuery(cuentabancaria, query, _page, 10);
			rows = cuentabancariaService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listCuentabancaria = cuentabancariaService.listCuentabancariasPagination(cuentabancaria, _page, 10);
			rows = cuentabancariaService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listCuentabancaria;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un cuentabancaria.
	 * @param id.
	 * @return Cuentabancaria.
	 */
	@RequestMapping(value = "/idcuentabancaria/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('CUENTABANCARIASEARCH')")
	    public @ResponseBody  Cuentabancaria getCuentabancaria(@PathVariable("id") int id) {	        
	        Cuentabancaria cuentabancaria = null;
	        
	        cuentabancaria = cuentabancariaService.getCuentabancaria(id);
			return cuentabancaria;
	 }

	/*************************** CREATE
	 * Crea un nuevo cuentabancaria.
	 * @param cuentabancaria.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/cuentabancaria", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('CUENTABANCARIACREATE')")
	    public ResponseEntity<Void> createCuentabancaria(@RequestBody Cuentabancaria cuentabancaria,    UriComponentsBuilder ucBuilder) {
	   
	        cuentabancariaService.addCuentabancaria(cuentabancaria);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/cuentabancaria/{id}").buildAndExpand(cuentabancaria.getCuentabancariaId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un cuentabancaria.
	  * @param id.
	  * @param cuentabancaria.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/cuentabancaria/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('CUENTABANCARIAUPDATE')") 
	    public ResponseEntity<Cuentabancaria> actualizarCuentabancaria(
				@PathVariable("id") int id, 
				@RequestBody Cuentabancaria cuentabancaria) {
	        
	        Cuentabancaria cuentabancariaFound = cuentabancariaService.getCuentabancaria(id);
	         
	        if (cuentabancariaFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Cuentabancaria>(HttpStatus.NOT_FOUND);
	        }
	
	cuentabancariaFound.setClabe(cuentabancaria.getClabe());
	cuentabancariaFound.setCuenta(cuentabancaria.getCuenta());
	cuentabancariaFound.setSocioId(cuentabancaria.getSocioId());
	cuentabancariaFound.setBancoId(cuentabancaria.getBancoId());
	cuentabancariaFound.setCuentabancariaId(cuentabancaria.getCuentabancariaId());

		    cuentabancariaService.editCuentabancaria(cuentabancariaFound);
	        return new ResponseEntity<Cuentabancaria>(cuentabancariaFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un cuentabancaria.
		 * @param id.
		 * @return ResponseEntity<Cuentabancaria>.
		 */
		@RequestMapping(value = "/cuentabancaria/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('CUENTABANCARIADELETE')")  
	    public ResponseEntity<Cuentabancaria> deleteCuentabancaria(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Cuentabancaria cuentabancaria = cuentabancariaService.getCuentabancaria(id);
	         if (cuentabancaria == null) {
	             return new ResponseEntity<Cuentabancaria>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             cuentabancariaService.deleteCuentabancaria(cuentabancaria);
	             return new ResponseEntity<Cuentabancaria>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Cuentabancaria no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Cuentabancaria>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Cuentabancaria>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un cuentabancaria.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveCuentabancaria", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CUENTABANCARIA')")  
	public @ResponseBody String saveCuentabancaria(
			@ModelAttribute("command") CuentabancariaBean cuentabancariaBean) {

		Cuentabancaria cuentabancaria = prepareModel(cuentabancariaBean);
		cuentabancariaService.addCuentabancaria(cuentabancaria);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un cuentabancaria.
	 * @param cuentabancariaBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editCuentabancaria", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CUENTABANCARIA')")  
	public @ResponseBody String editCuentabancaria(
			@ModelAttribute("command") CuentabancariaBean cuentabancariaBean) {


		Cuentabancaria cuentabancaria = prepareModel(cuentabancariaBean);
		cuentabancariaService.editCuentabancaria(cuentabancaria);
		return "SUCCESS";
	}

	/**
	 * Agrega un CUENTABANCARIA.
	 * @param CUENTABANCARIABean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchCuentabancaria", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CUENTABANCARIA')")  
	public ModelAndView addCuentabancaria(
			@ModelAttribute("command") CuentabancariaBean cuentabancariaBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Cuentabancaria cuentabancaria = null;
		if (cuentabancariaBean != null)
			cuentabancaria = prepareModel(cuentabancariaBean);
		model.put("cuentabancarias",
				prepareListofBean(cuentabancariaService.listCuentabancarias(cuentabancaria)));
		return new ModelAndView("searchCuentabancaria", model);
	}

	/**
	 * Elimina un cuentabancaria.
	 * @param cuentabancariaBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteCuentabancaria", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CUENTABANCARIA')")  
	public ModelAndView deleteCuentabancaria(
			@ModelAttribute("command") CuentabancariaBean cuentabancariaBean,
			BindingResult result) {
		System.out.println("delete " + cuentabancariaBean.getCuentabancariaId());
		cuentabancariaService.deleteCuentabancaria(prepareModel(cuentabancariaBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cuentabancaria", null);
		model.put("cuentabancarias",
				prepareListofBean(cuentabancariaService.listCuentabancarias(null)));
		return new ModelAndView("searchCuentabancaria", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryCuentabancaria", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CUENTABANCARIA')")  
	public ModelAndView entryCuentabancaria() {
		return new ModelAndView("redirect:/searchCuentabancaria");
	}

	private Cuentabancaria prepareModel(CuentabancariaBean cuentabancariaBean) {
		Cuentabancaria cuentabancaria = new Cuentabancaria();

		//cuentabancaria.setDeId(cuentabancariaBean.getDeId());
		//cuentabancaria.setHIntegerId(cuentabancariaBean.getCuentaId());
		//cuentabancaria.setHIntegerId(cuentabancariaBean.getClabeId());
		//cuentabancaria.setRadiobancoId(cuentabancariaBean.getEmitidaporId());
		//cuentabancaria.setDisplayresultcuentabancariaId(cuentabancariaBean.getCuentabancariaId());
		//cuentabancaria.setExposedfiltercuentabancariaId(cuentabancariaBean.getCuentabancariaId());
		//cuentabancaria.setDisplaymodalcuentabancariaId(cuentabancariaBean.getCuentabancariaId());
		//cuentabancaria.setEntitynamecuentabancariaId(cuentabancariaBean.getCuentabancariaId());
		//cuentabancaria.setScaffoldcuentabancariaId(cuentabancariaBean.getCuentabancariaId());
		cuentabancaria.setCuentabancariaId(cuentabancariaBean.getCuentabancariaId());
		cuentabancariaBean.setCuentabancariaId(null);

		return cuentabancaria;
	}

	/**
	 * Convierte un objeto de tipo CuentabancariaBean a un objeto de tipo Cuentabancaria.
	 * @param cuentabancariaBean.
	 * @return Cuentabancaria.
	 */
	private List<CuentabancariaBean> prepareListofBean(List<Cuentabancaria> cuentabancarias) {
		List<CuentabancariaBean> beans = null;
		if (cuentabancarias != null && !cuentabancarias.isEmpty()) {
			beans = new ArrayList<CuentabancariaBean>();
			CuentabancariaBean bean = null;
			for (Cuentabancaria cuentabancaria : cuentabancarias) {
				bean = new CuentabancariaBean();

				//bean.setDeId(cuentabancaria.getDeId());
				//bean.setRadiobancoId(cuentabancaria.getEmitidaporId());
				//bean.setDisplayresultcuentabancariaId(cuentabancaria.getCuentabancariaId());
				//bean.setExposedfiltercuentabancariaId(cuentabancaria.getCuentabancariaId());
				//bean.setDisplaymodalcuentabancariaId(cuentabancaria.getCuentabancariaId());
				//bean.setEntitynamecuentabancariaId(cuentabancaria.getCuentabancariaId());
				//bean.setScaffoldcuentabancariaId(cuentabancaria.getCuentabancariaId());
				bean.setCuentabancariaId(cuentabancaria.getCuentabancariaId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


