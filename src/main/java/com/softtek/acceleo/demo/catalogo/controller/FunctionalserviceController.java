/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Functionalservices. 
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

import com.softtek.acceleo.demo.catalogo.bean.FunctionalserviceBean;
import com.softtek.acceleo.demo.domain.Functionalservice;
import com.softtek.acceleo.demo.service.FunctionalserviceService;

/**
 * Clase FunctionalserviceController.
 * @author PSG.
 *
 */
@RestController
public class FunctionalserviceController {

	@Autowired
	private FunctionalserviceService functionalserviceService;
	
	Functionalservice functionalservice = new Functionalservice();

	/************************************** SEARCH
	 * Obtiene informacion de los functionalservices.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Functionalservice>.
	 */
	@RequestMapping(value = "/functionalservice", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('FUNCTIONALSERVICESEARCH')")
	public @ResponseBody  List<Functionalservice> getFunctionalservices(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Functionalservice> listFunctionalservice = null;

		if (query==null && _page == 0) {
       		listFunctionalservice = functionalserviceService.listFunctionalservices(functionalservice);
			rows = functionalserviceService.getTotalRows();
		} else if (query!= null){
			listFunctionalservice = functionalserviceService.listFunctionalservicesQuery(functionalservice, query, _page, 10);
			rows = functionalserviceService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listFunctionalservice = functionalserviceService.listFunctionalservicesPagination(functionalservice, _page, 10);
			rows = functionalserviceService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listFunctionalservice;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un functionalservice.
	 * @param id.
	 * @return Functionalservice.
	 */
	@RequestMapping(value = "/idfunctionalservice/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('FUNCTIONALSERVICESEARCH')")
	    public @ResponseBody  Functionalservice getFunctionalservice(@PathVariable("id") int id) {	        
	        Functionalservice functionalservice = null;
	        
	        functionalservice = functionalserviceService.getFunctionalservice(id);
			return functionalservice;
	 }

	/*************************** CREATE
	 * Crea un nuevo functionalservice.
	 * @param functionalservice.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/functionalservice", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('FUNCTIONALSERVICECREATE')")
	    public ResponseEntity<Void> createFunctionalservice(@RequestBody Functionalservice functionalservice,    UriComponentsBuilder ucBuilder) {
	   
	        functionalserviceService.addFunctionalservice(functionalservice);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/functionalservice/{id}").buildAndExpand(functionalservice.getFunctionalserviceId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un functionalservice.
	  * @param id.
	  * @param functionalservice.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/functionalservice/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('FUNCTIONALSERVICEUPDATE')") 
	    public ResponseEntity<Functionalservice> actualizarFunctionalservice(
				@PathVariable("id") int id, 
				@RequestBody Functionalservice functionalservice) {
	        
	        Functionalservice functionalserviceFound = functionalserviceService.getFunctionalservice(id);
	         
	        if (functionalserviceFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Functionalservice>(HttpStatus.NOT_FOUND);
	        }
	
	functionalserviceFound.setSize(functionalservice.getSize());
	functionalserviceFound.setName(functionalservice.getName());
	functionalserviceFound.setCode(functionalservice.getCode());
	functionalserviceFound.setRepetitions(functionalservice.getRepetitions());
	functionalserviceFound.setComments(functionalservice.getComments());
	functionalserviceFound.setMenuId(functionalservice.getMenuId());
	functionalserviceFound.setDescription(functionalservice.getDescription());
	functionalserviceFound.setComplexityId(functionalservice.getComplexityId());
	functionalserviceFound.setRepositoryId(functionalservice.getRepositoryId());
	functionalserviceFound.setDataId(functionalservice.getDataId());
	functionalserviceFound.setAlgorithmtypeId(functionalservice.getAlgorithmtypeId());
	functionalserviceFound.setReusabilityId(functionalservice.getReusabilityId());
	functionalserviceFound.setFunctionalserviceId(functionalservice.getFunctionalserviceId());

		    functionalserviceService.editFunctionalservice(functionalserviceFound);
	        return new ResponseEntity<Functionalservice>(functionalserviceFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un functionalservice.
		 * @param id.
		 * @return ResponseEntity<Functionalservice>.
		 */
		@RequestMapping(value = "/functionalservice/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('FUNCTIONALSERVICEDELETE')")  
	    public ResponseEntity<Functionalservice> deleteFunctionalservice(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Functionalservice functionalservice = functionalserviceService.getFunctionalservice(id);
	         if (functionalservice == null) {
	             return new ResponseEntity<Functionalservice>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             functionalserviceService.deleteFunctionalservice(functionalservice);
	             return new ResponseEntity<Functionalservice>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Functionalservice no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Functionalservice>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Functionalservice>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un functionalservice.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveFunctionalservice", method = RequestMethod.POST)
	@PreAuthorize("hasRole('FUNCTIONALSERVICE')")  
	public @ResponseBody String saveFunctionalservice(
			@ModelAttribute("command") FunctionalserviceBean functionalserviceBean) {

		Functionalservice functionalservice = prepareModel(functionalserviceBean);
		functionalserviceService.addFunctionalservice(functionalservice);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un functionalservice.
	 * @param functionalserviceBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editFunctionalservice", method = RequestMethod.POST)
	@PreAuthorize("hasRole('FUNCTIONALSERVICE')")  
	public @ResponseBody String editFunctionalservice(
			@ModelAttribute("command") FunctionalserviceBean functionalserviceBean) {


		Functionalservice functionalservice = prepareModel(functionalserviceBean);
		functionalserviceService.editFunctionalservice(functionalservice);
		return "SUCCESS";
	}

	/**
	 * Agrega un FUNCTIONALSERVICE.
	 * @param FUNCTIONALSERVICEBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchFunctionalservice", method = RequestMethod.GET)
	@PreAuthorize("hasRole('FUNCTIONALSERVICE')")  
	public ModelAndView addFunctionalservice(
			@ModelAttribute("command") FunctionalserviceBean functionalserviceBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Functionalservice functionalservice = null;
		if (functionalserviceBean != null)
			functionalservice = prepareModel(functionalserviceBean);
		model.put("functionalservices",
				prepareListofBean(functionalserviceService.listFunctionalservices(functionalservice)));
		return new ModelAndView("searchFunctionalservice", model);
	}

	/**
	 * Elimina un functionalservice.
	 * @param functionalserviceBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteFunctionalservice", method = RequestMethod.POST)
	@PreAuthorize("hasRole('FUNCTIONALSERVICE')")  
	public ModelAndView deleteFunctionalservice(
			@ModelAttribute("command") FunctionalserviceBean functionalserviceBean,
			BindingResult result) {
		System.out.println("delete " + functionalserviceBean.getFunctionalserviceId());
		functionalserviceService.deleteFunctionalservice(prepareModel(functionalserviceBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("functionalservice", null);
		model.put("functionalservices",
				prepareListofBean(functionalserviceService.listFunctionalservices(null)));
		return new ModelAndView("searchFunctionalservice", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryFunctionalservice", method = RequestMethod.GET)
	@PreAuthorize("hasRole('FUNCTIONALSERVICE')")  
	public ModelAndView entryFunctionalservice() {
		return new ModelAndView("redirect:/searchFunctionalservice");
	}

	private Functionalservice prepareModel(FunctionalserviceBean functionalserviceBean) {
		Functionalservice functionalservice = new Functionalservice();

		functionalservice.setMenuId(functionalserviceBean.getMenuId());
		//functionalservice.setNotrequiredfunctionalserviceId(functionalserviceBean.getDescriptionId());
		//functionalservice.setHDoubleId(functionalserviceBean.getSizeId());
		//functionalservice.setRadiocomplexityId(functionalserviceBean.getComplexityId());
		//functionalservice.setHIntegerId(functionalserviceBean.getRepetitionsId());
		//functionalservice.setRadiorepositoryId(functionalserviceBean.getRepositoryId());
		//functionalservice.setRadiodataId(functionalserviceBean.getDataId());
		//functionalservice.setRadioalgorithmtypeId(functionalserviceBean.getAlgorithmtypeId());
		//functionalservice.setRadioreusabilityId(functionalserviceBean.getReusabilityId());
		//functionalservice.setHTextLongId(functionalserviceBean.getCommentsId());
		//functionalservice.setDisplay_resultfunctionalserviceId(functionalserviceBean.getFunctionalserviceId());
		//functionalservice.setExposed_filterfunctionalserviceId(functionalserviceBean.getFunctionalserviceId());
		//functionalservice.setDisplay_modalfunctionalserviceId(functionalserviceBean.getFunctionalserviceId());
		//functionalservice.setEntity_namefunctionalserviceId(functionalserviceBean.getFunctionalserviceId());
		functionalservice.setCode(functionalserviceBean.getCode());
		functionalservice.setName(functionalserviceBean.getName());
		functionalservice.setFunctionalserviceId(functionalserviceBean.getFunctionalserviceId());
		functionalserviceBean.setFunctionalserviceId(null);

		return functionalservice;
	}

	/**
	 * Convierte un objeto de tipo FunctionalserviceBean a un objeto de tipo Functionalservice.
	 * @param functionalserviceBean.
	 * @return Functionalservice.
	 */
	private List<FunctionalserviceBean> prepareListofBean(List<Functionalservice> functionalservices) {
		List<FunctionalserviceBean> beans = null;
		if (functionalservices != null && !functionalservices.isEmpty()) {
			beans = new ArrayList<FunctionalserviceBean>();
			FunctionalserviceBean bean = null;
			for (Functionalservice functionalservice : functionalservices) {
				bean = new FunctionalserviceBean();

				bean.setMenuId(functionalservice.getMenuId());
				//bean.setNotrequiredfunctionalserviceId(functionalservice.getDescriptionId());
				//bean.setRadiocomplexityId(functionalservice.getComplexityId());
				//bean.setRadiorepositoryId(functionalservice.getRepositoryId());
				//bean.setRadiodataId(functionalservice.getDataId());
				//bean.setRadioalgorithmtypeId(functionalservice.getAlgorithmtypeId());
				//bean.setRadioreusabilityId(functionalservice.getReusabilityId());
				//bean.setDisplay_resultfunctionalserviceId(functionalservice.getFunctionalserviceId());
				//bean.setExposed_filterfunctionalserviceId(functionalservice.getFunctionalserviceId());
				//bean.setDisplay_modalfunctionalserviceId(functionalservice.getFunctionalserviceId());
				//bean.setEntity_namefunctionalserviceId(functionalservice.getFunctionalserviceId());
				bean.setCode(functionalservice.getCode());
				bean.setName(functionalservice.getName());
				bean.setFunctionalserviceId(functionalservice.getFunctionalserviceId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


