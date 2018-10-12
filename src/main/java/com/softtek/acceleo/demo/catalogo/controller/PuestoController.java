/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Puestos. 
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

import com.softtek.acceleo.demo.catalogo.bean.PuestoBean;
import com.softtek.acceleo.demo.domain.Puesto;
import com.softtek.acceleo.demo.service.PuestoService;

/**
 * Clase PuestoController.
 * @author PSG.
 *
 */
@RestController
public class PuestoController {

	@Autowired
	private PuestoService puestoService;
	
	Puesto puesto = new Puesto();

	/************************************** SEARCH
	 * Obtiene informacion de los puestos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Puesto>.
	 */
	@RequestMapping(value = "/puesto", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('PUESTOSEARCH')")
	public @ResponseBody  List<Puesto> getPuestos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Puesto> listPuesto = null;

		if (query==null && _page == 0) {
       		listPuesto = puestoService.listPuestos(puesto);
			rows = puestoService.getTotalRows();
		} else if (query!= null){
			listPuesto = puestoService.listPuestosQuery(puesto, query, _page, 10);
			rows = puestoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listPuesto = puestoService.listPuestosPagination(puesto, _page, 10);
			rows = puestoService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listPuesto;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un puesto.
	 * @param id.
	 * @return Puesto.
	 */
	@RequestMapping(value = "/idpuesto/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('PUESTOSEARCH')")
	    public @ResponseBody  Puesto getPuesto(@PathVariable("id") int id) {	        
	        Puesto puesto = null;
	        
	        puesto = puestoService.getPuesto(id);
			return puesto;
	 }

	/*************************** CREATE
	 * Crea un nuevo puesto.
	 * @param puesto.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/puesto", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('PUESTOCREATE')")
	    public ResponseEntity<Void> createPuesto(@RequestBody Puesto puesto,    UriComponentsBuilder ucBuilder) {
	   
	        puestoService.addPuesto(puesto);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/puesto/{id}").buildAndExpand(puesto.getPuestoId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un puesto.
	  * @param id.
	  * @param puesto.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/puesto/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('PUESTOUPDATE')") 
	    public ResponseEntity<Puesto> actualizarPuesto(
				@PathVariable("id") int id, 
				@RequestBody Puesto puesto) {
	        
	        Puesto puestoFound = puestoService.getPuesto(id);
	         
	        if (puestoFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Puesto>(HttpStatus.NOT_FOUND);
	        }
	
	puestoFound.setDescripcion(puesto.getDescripcion());
	puestoFound.setPuestosId(puesto.getPuestosId());
	puestoFound.setPuestoId(puesto.getPuestoId());

		    puestoService.editPuesto(puestoFound);
	        return new ResponseEntity<Puesto>(puestoFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un puesto.
		 * @param id.
		 * @return ResponseEntity<Puesto>.
		 */
		@RequestMapping(value = "/puesto/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('PUESTODELETE')")  
	    public ResponseEntity<Puesto> deletePuesto(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Puesto puesto = puestoService.getPuesto(id);
	         if (puesto == null) {
	             return new ResponseEntity<Puesto>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             puestoService.deletePuesto(puesto);
	             return new ResponseEntity<Puesto>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Puesto no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Puesto>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Puesto>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un puesto.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/savePuesto", method = RequestMethod.POST)
	@PreAuthorize("hasRole('PUESTO')")  
	public @ResponseBody String savePuesto(
			@ModelAttribute("command") PuestoBean puestoBean) {

		Puesto puesto = prepareModel(puestoBean);
		puestoService.addPuesto(puesto);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un puesto.
	 * @param puestoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editPuesto", method = RequestMethod.POST)
	@PreAuthorize("hasRole('PUESTO')")  
	public @ResponseBody String editPuesto(
			@ModelAttribute("command") PuestoBean puestoBean) {


		Puesto puesto = prepareModel(puestoBean);
		puestoService.editPuesto(puesto);
		return "SUCCESS";
	}

	/**
	 * Agrega un PUESTO.
	 * @param PUESTOBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchPuesto", method = RequestMethod.GET)
	@PreAuthorize("hasRole('PUESTO')")  
	public ModelAndView addPuesto(
			@ModelAttribute("command") PuestoBean puestoBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Puesto puesto = null;
		if (puestoBean != null)
			puesto = prepareModel(puestoBean);
		model.put("puestos",
				prepareListofBean(puestoService.listPuestos(puesto)));
		return new ModelAndView("searchPuesto", model);
	}

	/**
	 * Elimina un puesto.
	 * @param puestoBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deletePuesto", method = RequestMethod.POST)
	@PreAuthorize("hasRole('PUESTO')")  
	public ModelAndView deletePuesto(
			@ModelAttribute("command") PuestoBean puestoBean,
			BindingResult result) {
		System.out.println("delete " + puestoBean.getPuestoId());
		puestoService.deletePuesto(prepareModel(puestoBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("puesto", null);
		model.put("puestos",
				prepareListofBean(puestoService.listPuestos(null)));
		return new ModelAndView("searchPuesto", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryPuesto", method = RequestMethod.GET)
	@PreAuthorize("hasRole('PUESTO')")  
	public ModelAndView entryPuesto() {
		return new ModelAndView("redirect:/searchPuesto");
	}

	private Puesto prepareModel(PuestoBean puestoBean) {
		Puesto puesto = new Puesto();

		//puesto.setRadiopuestosId(puestoBean.getNombreId());
		//puesto.setDisplayresultpuestoId(puestoBean.getPuestoId());
		//puesto.setExposedfilterpuestoId(puestoBean.getPuestoId());
		//puesto.setDisplaymodalpuestoId(puestoBean.getPuestoId());
		//puesto.setEntitynamepuestoId(puestoBean.getPuestoId());
		//puesto.setScaffoldpuestoId(puestoBean.getPuestoId());
		puesto.setDescripcion(puestoBean.getDescripcion());
		puesto.setPuestoId(puestoBean.getPuestoId());
		puestoBean.setPuestoId(null);

		return puesto;
	}

	/**
	 * Convierte un objeto de tipo PuestoBean a un objeto de tipo Puesto.
	 * @param puestoBean.
	 * @return Puesto.
	 */
	private List<PuestoBean> prepareListofBean(List<Puesto> puestos) {
		List<PuestoBean> beans = null;
		if (puestos != null && !puestos.isEmpty()) {
			beans = new ArrayList<PuestoBean>();
			PuestoBean bean = null;
			for (Puesto puesto : puestos) {
				bean = new PuestoBean();

				//bean.setRadiopuestosId(puesto.getNombreId());
				//bean.setDisplayresultpuestoId(puesto.getPuestoId());
				//bean.setExposedfilterpuestoId(puesto.getPuestoId());
				//bean.setDisplaymodalpuestoId(puesto.getPuestoId());
				//bean.setEntitynamepuestoId(puesto.getPuestoId());
				//bean.setScaffoldpuestoId(puesto.getPuestoId());
				bean.setDescripcion(puesto.getDescripcion());
				bean.setPuestoId(puesto.getPuestoId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


