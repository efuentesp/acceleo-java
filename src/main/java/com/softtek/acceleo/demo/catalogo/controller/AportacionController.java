/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Aportacions. 
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

import com.softtek.acceleo.demo.catalogo.bean.AportacionBean;
import com.softtek.acceleo.demo.domain.Aportacion;
import com.softtek.acceleo.demo.service.AportacionService;

/**
 * Clase AportacionController.
 * @author PSG.
 *
 */
@RestController
public class AportacionController {

	@Autowired
	private AportacionService aportacionService;
	
	Aportacion aportacion = new Aportacion();

	/************************************** SEARCH
	 * Obtiene informacion de los aportacions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Aportacion>.
	 */
	@RequestMapping(value = "/aportacion", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('APORTACIONSEARCH')")
	public @ResponseBody  List<Aportacion> getAportacions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Aportacion> listAportacion = null;

		if (query==null && _page == 0) {
       		listAportacion = aportacionService.listAportacions(aportacion);
			rows = aportacionService.getTotalRows();
		} else if (query!= null){
			listAportacion = aportacionService.listAportacionsQuery(aportacion, query, _page, 10);
			rows = aportacionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listAportacion = aportacionService.listAportacionsPagination(aportacion, _page, 10);
			rows = aportacionService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listAportacion;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un aportacion.
	 * @param id.
	 * @return Aportacion.
	 */
	@RequestMapping(value = "/idaportacion/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('APORTACIONSEARCH')")
	    public @ResponseBody  Aportacion getAportacion(@PathVariable("id") int id) {	        
	        Aportacion aportacion = null;
	        
	        aportacion = aportacionService.getAportacion(id);
			return aportacion;
	 }

	/*************************** CREATE
	 * Crea un nuevo aportacion.
	 * @param aportacion.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/aportacion", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('APORTACIONCREATE')")
	    public ResponseEntity<Void> createAportacion(@RequestBody Aportacion aportacion,    UriComponentsBuilder ucBuilder) {
	   
	        aportacionService.addAportacion(aportacion);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/aportacion/{id}").buildAndExpand(aportacion.getAportacionId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un aportacion.
	  * @param id.
	  * @param aportacion.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/aportacion/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('APORTACIONUPDATE')") 
	    public ResponseEntity<Aportacion> actualizarAportacion(
				@PathVariable("id") int id, 
				@RequestBody Aportacion aportacion) {
	        
	        Aportacion aportacionFound = aportacionService.getAportacion(id);
	         
	        if (aportacionFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Aportacion>(HttpStatus.NOT_FOUND);
	        }
	
	aportacionFound.setFecha(aportacion.getFecha());
	aportacionFound.setMonto(aportacion.getMonto());
	aportacionFound.setCuentadeahorroId(aportacion.getCuentadeahorroId());
	aportacionFound.setTipoaportacionId(aportacion.getTipoaportacionId());
	aportacionFound.setAportacionId(aportacion.getAportacionId());

		    aportacionService.editAportacion(aportacionFound);
	        return new ResponseEntity<Aportacion>(aportacionFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un aportacion.
		 * @param id.
		 * @return ResponseEntity<Aportacion>.
		 */
		@RequestMapping(value = "/aportacion/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('APORTACIONDELETE')")  
	    public ResponseEntity<Aportacion> deleteAportacion(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Aportacion aportacion = aportacionService.getAportacion(id);
	         if (aportacion == null) {
	             return new ResponseEntity<Aportacion>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             aportacionService.deleteAportacion(aportacion);
	             return new ResponseEntity<Aportacion>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Aportacion no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Aportacion>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Aportacion>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un aportacion.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveAportacion", method = RequestMethod.POST)
	@PreAuthorize("hasRole('APORTACION')")  
	public @ResponseBody String saveAportacion(
			@ModelAttribute("command") AportacionBean aportacionBean) {

		Aportacion aportacion = prepareModel(aportacionBean);
		aportacionService.addAportacion(aportacion);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un aportacion.
	 * @param aportacionBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editAportacion", method = RequestMethod.POST)
	@PreAuthorize("hasRole('APORTACION')")  
	public @ResponseBody String editAportacion(
			@ModelAttribute("command") AportacionBean aportacionBean) {


		Aportacion aportacion = prepareModel(aportacionBean);
		aportacionService.editAportacion(aportacion);
		return "SUCCESS";
	}

	/**
	 * Agrega un APORTACION.
	 * @param APORTACIONBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchAportacion", method = RequestMethod.GET)
	@PreAuthorize("hasRole('APORTACION')")  
	public ModelAndView addAportacion(
			@ModelAttribute("command") AportacionBean aportacionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Aportacion aportacion = null;
		if (aportacionBean != null)
			aportacion = prepareModel(aportacionBean);
		model.put("aportacions",
				prepareListofBean(aportacionService.listAportacions(aportacion)));
		return new ModelAndView("searchAportacion", model);
	}

	/**
	 * Elimina un aportacion.
	 * @param aportacionBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteAportacion", method = RequestMethod.POST)
	@PreAuthorize("hasRole('APORTACION')")  
	public ModelAndView deleteAportacion(
			@ModelAttribute("command") AportacionBean aportacionBean,
			BindingResult result) {
		System.out.println("delete " + aportacionBean.getAportacionId());
		aportacionService.deleteAportacion(prepareModel(aportacionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("aportacion", null);
		model.put("aportacions",
				prepareListofBean(aportacionService.listAportacions(null)));
		return new ModelAndView("searchAportacion", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryAportacion", method = RequestMethod.GET)
	@PreAuthorize("hasRole('APORTACION')")  
	public ModelAndView entryAportacion() {
		return new ModelAndView("redirect:/searchAportacion");
	}

	private Aportacion prepareModel(AportacionBean aportacionBean) {
		Aportacion aportacion = new Aportacion();

		//aportacion.setParaId(aportacionBean.getParaId());
		//aportacion.setHDateId(aportacionBean.getFechaId());
		//aportacion.setRadiotipoaportacionId(aportacionBean.getConceptoId());
		//aportacion.setHDoubleId(aportacionBean.getMontoId());
		//aportacion.setDisplayresultaportacionId(aportacionBean.getAportacionId());
		//aportacion.setExposedfilteraportacionId(aportacionBean.getAportacionId());
		//aportacion.setDisplaymodalaportacionId(aportacionBean.getAportacionId());
		//aportacion.setEntitynameaportacionId(aportacionBean.getAportacionId());
		//aportacion.setScaffoldaportacionId(aportacionBean.getAportacionId());
		aportacion.setAportacionId(aportacionBean.getAportacionId());
		aportacionBean.setAportacionId(null);

		return aportacion;
	}

	/**
	 * Convierte un objeto de tipo AportacionBean a un objeto de tipo Aportacion.
	 * @param aportacionBean.
	 * @return Aportacion.
	 */
	private List<AportacionBean> prepareListofBean(List<Aportacion> aportacions) {
		List<AportacionBean> beans = null;
		if (aportacions != null && !aportacions.isEmpty()) {
			beans = new ArrayList<AportacionBean>();
			AportacionBean bean = null;
			for (Aportacion aportacion : aportacions) {
				bean = new AportacionBean();

				//bean.setParaId(aportacion.getParaId());
				//bean.setRadiotipoaportacionId(aportacion.getConceptoId());
				//bean.setDisplayresultaportacionId(aportacion.getAportacionId());
				//bean.setExposedfilteraportacionId(aportacion.getAportacionId());
				//bean.setDisplaymodalaportacionId(aportacion.getAportacionId());
				//bean.setEntitynameaportacionId(aportacion.getAportacionId());
				//bean.setScaffoldaportacionId(aportacion.getAportacionId());
				bean.setAportacionId(aportacion.getAportacionId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


