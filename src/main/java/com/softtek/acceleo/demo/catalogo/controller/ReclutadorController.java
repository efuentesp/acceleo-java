/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Reclutadors. 
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

import com.softtek.acceleo.demo.catalogo.bean.ReclutadorBean;
import com.softtek.acceleo.demo.domain.Reclutador;
import com.softtek.acceleo.demo.service.ReclutadorService;

/**
 * Clase ReclutadorController.
 * @author PSG.
 *
 */
@RestController
public class ReclutadorController {

	@Autowired
	private ReclutadorService reclutadorService;
	
	Reclutador reclutador = new Reclutador();

	/************************************** SEARCH
	 * Obtiene informacion de los reclutadors.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Reclutador>.
	 */
	@RequestMapping(value = "/reclutador", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('RECLUTADORSEARCH')")
	public @ResponseBody  List<Reclutador> getReclutadors(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Reclutador> listReclutador = null;

		if (query==null && _page == 0) {
       		listReclutador = reclutadorService.listReclutadors(reclutador);
			rows = reclutadorService.getTotalRows();
		} else if (query!= null){
			listReclutador = reclutadorService.listReclutadorsQuery(reclutador, query, _page, 10);
			rows = reclutadorService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listReclutador = reclutadorService.listReclutadorsPagination(reclutador, _page, 10);
			rows = reclutadorService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listReclutador;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un reclutador.
	 * @param id.
	 * @return Reclutador.
	 */
	@RequestMapping(value = "/idreclutador/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('RECLUTADORSEARCH')")
	    public @ResponseBody  Reclutador getReclutador(@PathVariable("id") int id) {	        
	        Reclutador reclutador = null;
	        
	        reclutador = reclutadorService.getReclutador(id);
			return reclutador;
	 }

	/*************************** CREATE
	 * Crea un nuevo reclutador.
	 * @param reclutador.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/reclutador", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('RECLUTADORCREATE')")
	    public ResponseEntity<Void> createReclutador(@RequestBody Reclutador reclutador,    UriComponentsBuilder ucBuilder) {
	   
	        reclutadorService.addReclutador(reclutador);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/reclutador/{id}").buildAndExpand(reclutador.getReclutadorId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un reclutador.
	  * @param id.
	  * @param reclutador.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/reclutador/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('RECLUTADORUPDATE')") 
	    public ResponseEntity<Reclutador> actualizarReclutador(
				@PathVariable("id") int id, 
				@RequestBody Reclutador reclutador) {
	        
	        Reclutador reclutadorFound = reclutadorService.getReclutador(id);
	         
	        if (reclutadorFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Reclutador>(HttpStatus.NOT_FOUND);
	        }
	
	reclutadorFound.setApellidomaterno(reclutador.getApellidomaterno());
	reclutadorFound.setNombre(reclutador.getNombre());
	reclutadorFound.setApellidopaterno(reclutador.getApellidopaterno());
	reclutadorFound.setGeneroId(reclutador.getGeneroId());
	reclutadorFound.setReclutadorId(reclutador.getReclutadorId());

		    reclutadorService.editReclutador(reclutadorFound);
	        return new ResponseEntity<Reclutador>(reclutadorFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un reclutador.
		 * @param id.
		 * @return ResponseEntity<Reclutador>.
		 */
		@RequestMapping(value = "/reclutador/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('RECLUTADORDELETE')")  
	    public ResponseEntity<Reclutador> deleteReclutador(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Reclutador reclutador = reclutadorService.getReclutador(id);
	         if (reclutador == null) {
	             return new ResponseEntity<Reclutador>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             reclutadorService.deleteReclutador(reclutador);
	             return new ResponseEntity<Reclutador>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Reclutador no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Reclutador>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Reclutador>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un reclutador.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveReclutador", method = RequestMethod.POST)
	@PreAuthorize("hasRole('RECLUTADOR')")  
	public @ResponseBody String saveReclutador(
			@ModelAttribute("command") ReclutadorBean reclutadorBean) {

		Reclutador reclutador = prepareModel(reclutadorBean);
		reclutadorService.addReclutador(reclutador);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un reclutador.
	 * @param reclutadorBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editReclutador", method = RequestMethod.POST)
	@PreAuthorize("hasRole('RECLUTADOR')")  
	public @ResponseBody String editReclutador(
			@ModelAttribute("command") ReclutadorBean reclutadorBean) {


		Reclutador reclutador = prepareModel(reclutadorBean);
		reclutadorService.editReclutador(reclutador);
		return "SUCCESS";
	}

	/**
	 * Agrega un RECLUTADOR.
	 * @param RECLUTADORBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchReclutador", method = RequestMethod.GET)
	@PreAuthorize("hasRole('RECLUTADOR')")  
	public ModelAndView addReclutador(
			@ModelAttribute("command") ReclutadorBean reclutadorBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Reclutador reclutador = null;
		if (reclutadorBean != null)
			reclutador = prepareModel(reclutadorBean);
		model.put("reclutadors",
				prepareListofBean(reclutadorService.listReclutadors(reclutador)));
		return new ModelAndView("searchReclutador", model);
	}

	/**
	 * Elimina un reclutador.
	 * @param reclutadorBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteReclutador", method = RequestMethod.POST)
	@PreAuthorize("hasRole('RECLUTADOR')")  
	public ModelAndView deleteReclutador(
			@ModelAttribute("command") ReclutadorBean reclutadorBean,
			BindingResult result) {
		System.out.println("delete " + reclutadorBean.getReclutadorId());
		reclutadorService.deleteReclutador(prepareModel(reclutadorBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("reclutador", null);
		model.put("reclutadors",
				prepareListofBean(reclutadorService.listReclutadors(null)));
		return new ModelAndView("searchReclutador", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryReclutador", method = RequestMethod.GET)
	@PreAuthorize("hasRole('RECLUTADOR')")  
	public ModelAndView entryReclutador() {
		return new ModelAndView("redirect:/searchReclutador");
	}

	private Reclutador prepareModel(ReclutadorBean reclutadorBean) {
		Reclutador reclutador = new Reclutador();

		//reclutador.setRadiogeneroId(reclutadorBean.getEsId());
		//reclutador.setDisplayresultreclutadorId(reclutadorBean.getReclutadorId());
		//reclutador.setExposedfilterreclutadorId(reclutadorBean.getReclutadorId());
		//reclutador.setDisplaymodalreclutadorId(reclutadorBean.getReclutadorId());
		//reclutador.setEntitynamereclutadorId(reclutadorBean.getReclutadorId());
		//reclutador.setScaffoldreclutadorId(reclutadorBean.getReclutadorId());
		reclutador.setNombre(reclutadorBean.getNombre());
		reclutador.setApellidopaterno(reclutadorBean.getApellidopaterno());
		reclutador.setApellidomaterno(reclutadorBean.getApellidomaterno());
		reclutador.setReclutadorId(reclutadorBean.getReclutadorId());
		reclutadorBean.setReclutadorId(null);

		return reclutador;
	}

	/**
	 * Convierte un objeto de tipo ReclutadorBean a un objeto de tipo Reclutador.
	 * @param reclutadorBean.
	 * @return Reclutador.
	 */
	private List<ReclutadorBean> prepareListofBean(List<Reclutador> reclutadors) {
		List<ReclutadorBean> beans = null;
		if (reclutadors != null && !reclutadors.isEmpty()) {
			beans = new ArrayList<ReclutadorBean>();
			ReclutadorBean bean = null;
			for (Reclutador reclutador : reclutadors) {
				bean = new ReclutadorBean();

				//bean.setRadiogeneroId(reclutador.getEsId());
				//bean.setDisplayresultreclutadorId(reclutador.getReclutadorId());
				//bean.setExposedfilterreclutadorId(reclutador.getReclutadorId());
				//bean.setDisplaymodalreclutadorId(reclutador.getReclutadorId());
				//bean.setEntitynamereclutadorId(reclutador.getReclutadorId());
				//bean.setScaffoldreclutadorId(reclutador.getReclutadorId());
				bean.setNombre(reclutador.getNombre());
				bean.setApellidopaterno(reclutador.getApellidopaterno());
				bean.setApellidomaterno(reclutador.getApellidomaterno());
				bean.setReclutadorId(reclutador.getReclutadorId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


