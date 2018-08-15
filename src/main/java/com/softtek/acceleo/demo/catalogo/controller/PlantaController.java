/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Plantas. 
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

import com.softtek.acceleo.demo.catalogo.bean.PlantaBean;
import com.softtek.acceleo.demo.domain.Planta;
import com.softtek.acceleo.demo.service.PlantaService;

/**
 * Clase PlantaController.
 * @author PSG.
 *
 */
@RestController
public class PlantaController {

	@Autowired
	private PlantaService plantaService;
	
	Planta planta = new Planta();

	/************************************** SEARCH
	 * Obtiene informacion de los plantas.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Planta>.
	 */
	@RequestMapping(value = "/planta", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('PLANTASEARCH')")
	public @ResponseBody  List<Planta> getPlantas(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Planta> listPlanta = null;

		if (query==null && _page == 0) {
       		listPlanta = plantaService.listPlantas(planta);
			rows = plantaService.getTotalRows();
		} else if (query!= null){
			listPlanta = plantaService.listPlantasQuery(planta, query, _page, 10);
			rows = plantaService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listPlanta = plantaService.listPlantasPagination(planta, _page, 10);
			rows = plantaService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listPlanta;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un planta.
	 * @param id.
	 * @return Planta.
	 */
	@RequestMapping(value = "/idplanta/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('PLANTASEARCH')")
	    public @ResponseBody  Planta getPlanta(@PathVariable("id") int id) {	        
	        Planta planta = null;
	        
	        planta = plantaService.getPlanta(id);
			return planta;
	 }

	/*************************** CREATE
	 * Crea un nuevo planta.
	 * @param planta.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/planta", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('PLANTACREATE')")
	    public ResponseEntity<Void> createPlanta(@RequestBody Planta planta,    UriComponentsBuilder ucBuilder) {
	   
	        plantaService.addPlanta(planta);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/planta/{id}").buildAndExpand(planta.getPlantaId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un planta.
	  * @param id.
	  * @param planta.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/planta/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('PLANTAUPDATE')") 
	    public ResponseEntity<Planta> actualizarPlanta(
				@PathVariable("id") int id, 
				@RequestBody Planta planta) {
	        
	        Planta plantaFound = plantaService.getPlanta(id);
	         
	        if (plantaFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Planta>(HttpStatus.NOT_FOUND);
	        }
	
	plantaFound.setDireccion(planta.getDireccion());
	plantaFound.setNombreplanta(planta.getNombreplanta());
	plantaFound.setMaximo(planta.getMaximo());
	plantaFound.setDiadepago(planta.getDiadepago());
	plantaFound.setMinimo(planta.getMinimo());
	plantaFound.setEmpresaId(planta.getEmpresaId());
	plantaFound.setPlantaId(planta.getPlantaId());

		    plantaService.editPlanta(plantaFound);
	        return new ResponseEntity<Planta>(plantaFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un planta.
		 * @param id.
		 * @return ResponseEntity<Planta>.
		 */
		@RequestMapping(value = "/planta/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('PLANTADELETE')")  
	    public ResponseEntity<Planta> deletePlanta(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Planta planta = plantaService.getPlanta(id);
	         if (planta == null) {
	             return new ResponseEntity<Planta>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             plantaService.deletePlanta(planta);
	             return new ResponseEntity<Planta>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Planta no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Planta>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Planta>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un planta.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/savePlanta", method = RequestMethod.POST)
	@PreAuthorize("hasRole('PLANTA')")  
	public @ResponseBody String savePlanta(
			@ModelAttribute("command") PlantaBean plantaBean) {

		Planta planta = prepareModel(plantaBean);
		plantaService.addPlanta(planta);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un planta.
	 * @param plantaBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editPlanta", method = RequestMethod.POST)
	@PreAuthorize("hasRole('PLANTA')")  
	public @ResponseBody String editPlanta(
			@ModelAttribute("command") PlantaBean plantaBean) {


		Planta planta = prepareModel(plantaBean);
		plantaService.editPlanta(planta);
		return "SUCCESS";
	}

	/**
	 * Agrega un PLANTA.
	 * @param PLANTABean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchPlanta", method = RequestMethod.GET)
	@PreAuthorize("hasRole('PLANTA')")  
	public ModelAndView addPlanta(
			@ModelAttribute("command") PlantaBean plantaBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Planta planta = null;
		if (plantaBean != null)
			planta = prepareModel(plantaBean);
		model.put("plantas",
				prepareListofBean(plantaService.listPlantas(planta)));
		return new ModelAndView("searchPlanta", model);
	}

	/**
	 * Elimina un planta.
	 * @param plantaBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deletePlanta", method = RequestMethod.POST)
	@PreAuthorize("hasRole('PLANTA')")  
	public ModelAndView deletePlanta(
			@ModelAttribute("command") PlantaBean plantaBean,
			BindingResult result) {
		System.out.println("delete " + plantaBean.getPlantaId());
		plantaService.deletePlanta(prepareModel(plantaBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("planta", null);
		model.put("plantas",
				prepareListofBean(plantaService.listPlantas(null)));
		return new ModelAndView("searchPlanta", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryPlanta", method = RequestMethod.GET)
	@PreAuthorize("hasRole('PLANTA')")  
	public ModelAndView entryPlanta() {
		return new ModelAndView("redirect:/searchPlanta");
	}

	private Planta prepareModel(PlantaBean plantaBean) {
		Planta planta = new Planta();

		//planta.setPerteneceId(plantaBean.getPerteneceId());
		//planta.setHIntegerId(plantaBean.getDiadepagoId());
		//planta.setHDoubleId(plantaBean.getMaximoId());
		//planta.setHDoubleId(plantaBean.getMinimoId());
		//planta.setDisplayresultplantaId(plantaBean.getPlantaId());
		//planta.setExposedfilterplantaId(plantaBean.getPlantaId());
		//planta.setDisplaymodalplantaId(plantaBean.getPlantaId());
		//planta.setEntitynameplantaId(plantaBean.getPlantaId());
		//planta.setScaffoldplantaId(plantaBean.getPlantaId());
		planta.setNombreplanta(plantaBean.getNombreplanta());
		planta.setDireccion(plantaBean.getDireccion());
		planta.setPlantaId(plantaBean.getPlantaId());
		plantaBean.setPlantaId(null);

		return planta;
	}

	/**
	 * Convierte un objeto de tipo PlantaBean a un objeto de tipo Planta.
	 * @param plantaBean.
	 * @return Planta.
	 */
	private List<PlantaBean> prepareListofBean(List<Planta> plantas) {
		List<PlantaBean> beans = null;
		if (plantas != null && !plantas.isEmpty()) {
			beans = new ArrayList<PlantaBean>();
			PlantaBean bean = null;
			for (Planta planta : plantas) {
				bean = new PlantaBean();

				//bean.setPerteneceId(planta.getPerteneceId());
				//bean.setDisplayresultplantaId(planta.getPlantaId());
				//bean.setExposedfilterplantaId(planta.getPlantaId());
				//bean.setDisplaymodalplantaId(planta.getPlantaId());
				//bean.setEntitynameplantaId(planta.getPlantaId());
				//bean.setScaffoldplantaId(planta.getPlantaId());
				bean.setNombreplanta(planta.getNombreplanta());
				bean.setDireccion(planta.getDireccion());
				bean.setPlantaId(planta.getPlantaId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


