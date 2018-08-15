/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Domicilios. 
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

import com.softtek.acceleo.demo.catalogo.bean.DomicilioBean;
import com.softtek.acceleo.demo.domain.Domicilio;
import com.softtek.acceleo.demo.service.DomicilioService;

/**
 * Clase DomicilioController.
 * @author PSG.
 *
 */
@RestController
public class DomicilioController {

	@Autowired
	private DomicilioService domicilioService;
	
	Domicilio domicilio = new Domicilio();

	/************************************** SEARCH
	 * Obtiene informacion de los domicilios.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Domicilio>.
	 */
	@RequestMapping(value = "/domicilio", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('DOMICILIOSEARCH')")
	public @ResponseBody  List<Domicilio> getDomicilios(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Domicilio> listDomicilio = null;

		if (query==null && _page == 0) {
       		listDomicilio = domicilioService.listDomicilios(domicilio);
			rows = domicilioService.getTotalRows();
		} else if (query!= null){
			listDomicilio = domicilioService.listDomiciliosQuery(domicilio, query, _page, 10);
			rows = domicilioService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listDomicilio = domicilioService.listDomiciliosPagination(domicilio, _page, 10);
			rows = domicilioService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listDomicilio;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un domicilio.
	 * @param id.
	 * @return Domicilio.
	 */
	@RequestMapping(value = "/iddomicilio/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('DOMICILIOSEARCH')")
	    public @ResponseBody  Domicilio getDomicilio(@PathVariable("id") int id) {	        
	        Domicilio domicilio = null;
	        
	        domicilio = domicilioService.getDomicilio(id);
			return domicilio;
	 }

	/*************************** CREATE
	 * Crea un nuevo domicilio.
	 * @param domicilio.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/domicilio", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('DOMICILIOCREATE')")
	    public ResponseEntity<Void> createDomicilio(@RequestBody Domicilio domicilio,    UriComponentsBuilder ucBuilder) {
	   
	        domicilioService.addDomicilio(domicilio);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/domicilio/{id}").buildAndExpand(domicilio.getDomicilioId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un domicilio.
	  * @param id.
	  * @param domicilio.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/domicilio/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('DOMICILIOUPDATE')") 
	    public ResponseEntity<Domicilio> actualizarDomicilio(
				@PathVariable("id") int id, 
				@RequestBody Domicilio domicilio) {
	        
	        Domicilio domicilioFound = domicilioService.getDomicilio(id);
	         
	        if (domicilioFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Domicilio>(HttpStatus.NOT_FOUND);
	        }
	
	domicilioFound.setCiudad(domicilio.getCiudad());
	domicilioFound.setCp(domicilio.getCp());
	domicilioFound.setEstado(domicilio.getEstado());
	domicilioFound.setCalle(domicilio.getCalle());
	domicilioFound.setSocioId(domicilio.getSocioId());
	domicilioFound.setDomicilioId(domicilio.getDomicilioId());

		    domicilioService.editDomicilio(domicilioFound);
	        return new ResponseEntity<Domicilio>(domicilioFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un domicilio.
		 * @param id.
		 * @return ResponseEntity<Domicilio>.
		 */
		@RequestMapping(value = "/domicilio/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('DOMICILIODELETE')")  
	    public ResponseEntity<Domicilio> deleteDomicilio(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Domicilio domicilio = domicilioService.getDomicilio(id);
	         if (domicilio == null) {
	             return new ResponseEntity<Domicilio>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             domicilioService.deleteDomicilio(domicilio);
	             return new ResponseEntity<Domicilio>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Domicilio no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Domicilio>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Domicilio>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un domicilio.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveDomicilio", method = RequestMethod.POST)
	@PreAuthorize("hasRole('DOMICILIO')")  
	public @ResponseBody String saveDomicilio(
			@ModelAttribute("command") DomicilioBean domicilioBean) {

		Domicilio domicilio = prepareModel(domicilioBean);
		domicilioService.addDomicilio(domicilio);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un domicilio.
	 * @param domicilioBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editDomicilio", method = RequestMethod.POST)
	@PreAuthorize("hasRole('DOMICILIO')")  
	public @ResponseBody String editDomicilio(
			@ModelAttribute("command") DomicilioBean domicilioBean) {


		Domicilio domicilio = prepareModel(domicilioBean);
		domicilioService.editDomicilio(domicilio);
		return "SUCCESS";
	}

	/**
	 * Agrega un DOMICILIO.
	 * @param DOMICILIOBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchDomicilio", method = RequestMethod.GET)
	@PreAuthorize("hasRole('DOMICILIO')")  
	public ModelAndView addDomicilio(
			@ModelAttribute("command") DomicilioBean domicilioBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Domicilio domicilio = null;
		if (domicilioBean != null)
			domicilio = prepareModel(domicilioBean);
		model.put("domicilios",
				prepareListofBean(domicilioService.listDomicilios(domicilio)));
		return new ModelAndView("searchDomicilio", model);
	}

	/**
	 * Elimina un domicilio.
	 * @param domicilioBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteDomicilio", method = RequestMethod.POST)
	@PreAuthorize("hasRole('DOMICILIO')")  
	public ModelAndView deleteDomicilio(
			@ModelAttribute("command") DomicilioBean domicilioBean,
			BindingResult result) {
		System.out.println("delete " + domicilioBean.getDomicilioId());
		domicilioService.deleteDomicilio(prepareModel(domicilioBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("domicilio", null);
		model.put("domicilios",
				prepareListofBean(domicilioService.listDomicilios(null)));
		return new ModelAndView("searchDomicilio", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryDomicilio", method = RequestMethod.GET)
	@PreAuthorize("hasRole('DOMICILIO')")  
	public ModelAndView entryDomicilio() {
		return new ModelAndView("redirect:/searchDomicilio");
	}

	private Domicilio prepareModel(DomicilioBean domicilioBean) {
		Domicilio domicilio = new Domicilio();

		//domicilio.setDeId(domicilioBean.getDeId());
		//domicilio.setDisplayresultdomicilioId(domicilioBean.getDomicilioId());
		//domicilio.setExposedfilterdomicilioId(domicilioBean.getDomicilioId());
		//domicilio.setDisplaymodaldomicilioId(domicilioBean.getDomicilioId());
		//domicilio.setEntitynamedomicilioId(domicilioBean.getDomicilioId());
		//domicilio.setScaffolddomicilioId(domicilioBean.getDomicilioId());
		domicilio.setCalle(domicilioBean.getCalle());
		domicilio.setCp(domicilioBean.getCp());
		domicilio.setCiudad(domicilioBean.getCiudad());
		domicilio.setEstado(domicilioBean.getEstado());
		domicilio.setDomicilioId(domicilioBean.getDomicilioId());
		domicilioBean.setDomicilioId(null);

		return domicilio;
	}

	/**
	 * Convierte un objeto de tipo DomicilioBean a un objeto de tipo Domicilio.
	 * @param domicilioBean.
	 * @return Domicilio.
	 */
	private List<DomicilioBean> prepareListofBean(List<Domicilio> domicilios) {
		List<DomicilioBean> beans = null;
		if (domicilios != null && !domicilios.isEmpty()) {
			beans = new ArrayList<DomicilioBean>();
			DomicilioBean bean = null;
			for (Domicilio domicilio : domicilios) {
				bean = new DomicilioBean();

				//bean.setDeId(domicilio.getDeId());
				//bean.setDisplayresultdomicilioId(domicilio.getDomicilioId());
				//bean.setExposedfilterdomicilioId(domicilio.getDomicilioId());
				//bean.setDisplaymodaldomicilioId(domicilio.getDomicilioId());
				//bean.setEntitynamedomicilioId(domicilio.getDomicilioId());
				//bean.setScaffolddomicilioId(domicilio.getDomicilioId());
				bean.setCalle(domicilio.getCalle());
				bean.setCp(domicilio.getCp());
				bean.setCiudad(domicilio.getCiudad());
				bean.setEstado(domicilio.getEstado());
				bean.setDomicilioId(domicilio.getDomicilioId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


