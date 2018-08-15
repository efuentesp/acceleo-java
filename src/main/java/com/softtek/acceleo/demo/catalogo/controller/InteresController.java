/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Interess. 
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

import com.softtek.acceleo.demo.catalogo.bean.InteresBean;
import com.softtek.acceleo.demo.domain.Interes;
import com.softtek.acceleo.demo.service.InteresService;

/**
 * Clase InteresController.
 * @author PSG.
 *
 */
@RestController
public class InteresController {

	@Autowired
	private InteresService interesService;
	
	Interes interes = new Interes();

	/************************************** SEARCH
	 * Obtiene informacion de los interess.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Interes>.
	 */
	@RequestMapping(value = "/interes", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('INTERESSEARCH')")
	public @ResponseBody  List<Interes> getInteress(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Interes> listInteres = null;

		if (query==null && _page == 0) {
       		listInteres = interesService.listInteress(interes);
			rows = interesService.getTotalRows();
		} else if (query!= null){
			listInteres = interesService.listInteressQuery(interes, query, _page, 10);
			rows = interesService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listInteres = interesService.listInteressPagination(interes, _page, 10);
			rows = interesService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listInteres;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un interes.
	 * @param id.
	 * @return Interes.
	 */
	@RequestMapping(value = "/idinteres/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('INTERESSEARCH')")
	    public @ResponseBody  Interes getInteres(@PathVariable("id") int id) {	        
	        Interes interes = null;
	        
	        interes = interesService.getInteres(id);
			return interes;
	 }

	/*************************** CREATE
	 * Crea un nuevo interes.
	 * @param interes.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/interes", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('INTERESCREATE')")
	    public ResponseEntity<Void> createInteres(@RequestBody Interes interes,    UriComponentsBuilder ucBuilder) {
	   
	        interesService.addInteres(interes);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/interes/{id}").buildAndExpand(interes.getInteresId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un interes.
	  * @param id.
	  * @param interes.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/interes/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('INTERESUPDATE')") 
	    public ResponseEntity<Interes> actualizarInteres(
				@PathVariable("id") int id, 
				@RequestBody Interes interes) {
	        
	        Interes interesFound = interesService.getInteres(id);
	         
	        if (interesFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Interes>(HttpStatus.NOT_FOUND);
	        }
	
	interesFound.setFecha(interes.getFecha());
	interesFound.setMonto(interes.getMonto());
	interesFound.setCuentadeahorroId(interes.getCuentadeahorroId());
	interesFound.setInteresId(interes.getInteresId());

		    interesService.editInteres(interesFound);
	        return new ResponseEntity<Interes>(interesFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un interes.
		 * @param id.
		 * @return ResponseEntity<Interes>.
		 */
		@RequestMapping(value = "/interes/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('INTERESDELETE')")  
	    public ResponseEntity<Interes> deleteInteres(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Interes interes = interesService.getInteres(id);
	         if (interes == null) {
	             return new ResponseEntity<Interes>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             interesService.deleteInteres(interes);
	             return new ResponseEntity<Interes>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Interes no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Interes>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Interes>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un interes.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveInteres", method = RequestMethod.POST)
	@PreAuthorize("hasRole('INTERES')")  
	public @ResponseBody String saveInteres(
			@ModelAttribute("command") InteresBean interesBean) {

		Interes interes = prepareModel(interesBean);
		interesService.addInteres(interes);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un interes.
	 * @param interesBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editInteres", method = RequestMethod.POST)
	@PreAuthorize("hasRole('INTERES')")  
	public @ResponseBody String editInteres(
			@ModelAttribute("command") InteresBean interesBean) {


		Interes interes = prepareModel(interesBean);
		interesService.editInteres(interes);
		return "SUCCESS";
	}

	/**
	 * Agrega un INTERES.
	 * @param INTERESBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchInteres", method = RequestMethod.GET)
	@PreAuthorize("hasRole('INTERES')")  
	public ModelAndView addInteres(
			@ModelAttribute("command") InteresBean interesBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Interes interes = null;
		if (interesBean != null)
			interes = prepareModel(interesBean);
		model.put("interess",
				prepareListofBean(interesService.listInteress(interes)));
		return new ModelAndView("searchInteres", model);
	}

	/**
	 * Elimina un interes.
	 * @param interesBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteInteres", method = RequestMethod.POST)
	@PreAuthorize("hasRole('INTERES')")  
	public ModelAndView deleteInteres(
			@ModelAttribute("command") InteresBean interesBean,
			BindingResult result) {
		System.out.println("delete " + interesBean.getInteresId());
		interesService.deleteInteres(prepareModel(interesBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("interes", null);
		model.put("interess",
				prepareListofBean(interesService.listInteress(null)));
		return new ModelAndView("searchInteres", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryInteres", method = RequestMethod.GET)
	@PreAuthorize("hasRole('INTERES')")  
	public ModelAndView entryInteres() {
		return new ModelAndView("redirect:/searchInteres");
	}

	private Interes prepareModel(InteresBean interesBean) {
		Interes interes = new Interes();

		//interes.setParaId(interesBean.getParaId());
		//interes.setHDateId(interesBean.getFechaId());
		//interes.setHDoubleId(interesBean.getMontoId());
		//interes.setDisplayresultinteresId(interesBean.getInteresId());
		//interes.setExposedfilterinteresId(interesBean.getInteresId());
		//interes.setDisplaymodalinteresId(interesBean.getInteresId());
		//interes.setEntitynameinteresId(interesBean.getInteresId());
		//interes.setScaffoldinteresId(interesBean.getInteresId());
		interes.setInteresId(interesBean.getInteresId());
		interesBean.setInteresId(null);

		return interes;
	}

	/**
	 * Convierte un objeto de tipo InteresBean a un objeto de tipo Interes.
	 * @param interesBean.
	 * @return Interes.
	 */
	private List<InteresBean> prepareListofBean(List<Interes> interess) {
		List<InteresBean> beans = null;
		if (interess != null && !interess.isEmpty()) {
			beans = new ArrayList<InteresBean>();
			InteresBean bean = null;
			for (Interes interes : interess) {
				bean = new InteresBean();

				//bean.setParaId(interes.getParaId());
				//bean.setDisplayresultinteresId(interes.getInteresId());
				//bean.setExposedfilterinteresId(interes.getInteresId());
				//bean.setDisplaymodalinteresId(interes.getInteresId());
				//bean.setEntitynameinteresId(interes.getInteresId());
				//bean.setScaffoldinteresId(interes.getInteresId());
				bean.setInteresId(interes.getInteresId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


