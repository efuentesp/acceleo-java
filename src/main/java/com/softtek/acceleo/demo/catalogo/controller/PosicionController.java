/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Posicions. 
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

import com.softtek.acceleo.demo.catalogo.bean.PosicionBean;
import com.softtek.acceleo.demo.domain.Posicion;
import com.softtek.acceleo.demo.domain.Posicion;
import com.softtek.acceleo.demo.service.PosicionService;

/**
 * Clase PosicionController.
 * @author PSG.
 *
 */
@RestController
public class PosicionController {

	@Autowired
	private PosicionService posicionService;
	
	Posicion posicion = new Posicion();

	/************************************** SEARCH
	 * Obtiene informacion de los posicions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Posicion>.
	 */
	@RequestMapping(value = "/posicion", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('POSICIONSEARCH')")
	public @ResponseBody  List<Posicion> getPosicions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Posicion> listPosicion = null;

		if (query==null && _page == 0) {
       		listPosicion = posicionService.listPosicions(posicion);
			rows = posicionService.getTotalRows();
		} else if (query!= null){
			listPosicion = posicionService.listPosicionsQuery(posicion, query, _page, 10);
			rows = posicionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listPosicion = posicionService.listPosicionsPagination(posicion, _page, 10);
			rows = posicionService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listPosicion;
	}
	
	/************************************** SEARCH
	 * Obtiene informacion de los candidatos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Posicion>.
	 */
	@RequestMapping(value = "/posicion/candidato/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('POSICIONSEARCH')")
	public @ResponseBody  List<Posicion> getPosicionsByCandidato(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {

		List<Posicion> listPosicion = null;
		listPosicion = posicionService.listPosicionsByCandidato(posicion, id);
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		
		return listPosicion;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un posicion.
	 * @param id.
	 * @return Posicion.
	 */
	@RequestMapping(value = "/idposicion/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('POSICIONSEARCH')")
	    public @ResponseBody  Posicion getPosicion(@PathVariable("id") int id) {	        
	        Posicion posicion = null;
	        
	        posicion = posicionService.getPosicion(id);
			return posicion;
	 }

	/*************************** CREATE
	 * Crea un nuevo posicion.
	 * @param posicion.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/posicion", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('POSICIONCREATE')")
	    public ResponseEntity<Void> createPosicion(@RequestBody Posicion posicion,    UriComponentsBuilder ucBuilder) {
	   
	        posicionService.addPosicion(posicion);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/posicion/{id}").buildAndExpand(posicion.getPosicionId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un posicion.
	  * @param id.
	  * @param posicion.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/posicion/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('POSICIONUPDATE')") 
	    public ResponseEntity<Posicion> actualizarPosicion(
				@PathVariable("id") int id, 
				@RequestBody Posicion posicion) {
	        
	        Posicion posicionFound = posicionService.getPosicion(id);
	         
	        if (posicionFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Posicion>(HttpStatus.NOT_FOUND);
	        }
	
	posicionFound.setDescripcion(posicion.getDescripcion());
	posicionFound.setContacto(posicion.getContacto());
	posicionFound.setSalario(posicion.getSalario());
	posicionFound.setVacantes(posicion.getVacantes());
	posicionFound.setNombre(posicion.getNombre());
	posicionFound.setFecha(posicion.getFecha());
	posicionFound.setFilial(posicion.getFilial());
	posicionFound.setPuesto(posicion.getPuesto());
	posicionFound.setTiponominaId(posicion.getTiponominaId());
	posicionFound.setReclutador(posicion.getReclutador());
	posicionFound.setEstatusposicionId(posicion.getEstatusposicionId());
//	posicionFound.setSolicitudId(posicion.getSolicitudId());
//	posicionFound.setEventoId(posicion.getEventoId());
	posicionFound.setPosicionId(posicion.getPosicionId());

		    posicionService.editPosicion(posicionFound);
	        return new ResponseEntity<Posicion>(posicionFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un posicion.
		 * @param id.
		 * @return ResponseEntity<Posicion>.
		 */
		@RequestMapping(value = "/posicion/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('POSICIONDELETE')")  
	    public ResponseEntity<Posicion> deletePosicion(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Posicion posicion = posicionService.getPosicion(id);
	         if (posicion == null) {
	             return new ResponseEntity<Posicion>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             posicionService.deletePosicion(posicion);
	             return new ResponseEntity<Posicion>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Posicion no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Posicion>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Posicion>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un posicion.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/savePosicion", method = RequestMethod.POST)
	@PreAuthorize("hasRole('POSICION')")  
	public @ResponseBody String savePosicion(
			@ModelAttribute("command") PosicionBean posicionBean) {

		Posicion posicion = prepareModel(posicionBean);
		posicionService.addPosicion(posicion);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un posicion.
	 * @param posicionBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editPosicion", method = RequestMethod.POST)
	@PreAuthorize("hasRole('POSICION')")  
	public @ResponseBody String editPosicion(
			@ModelAttribute("command") PosicionBean posicionBean) {


		Posicion posicion = prepareModel(posicionBean);
		posicionService.editPosicion(posicion);
		return "SUCCESS";
	}

	/**
	 * Agrega un POSICION.
	 * @param POSICIONBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchPosicion", method = RequestMethod.GET)
	@PreAuthorize("hasRole('POSICION')")  
	public ModelAndView addPosicion(
			@ModelAttribute("command") PosicionBean posicionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Posicion posicion = null;
		if (posicionBean != null)
			posicion = prepareModel(posicionBean);
		model.put("posicions",
				prepareListofBean(posicionService.listPosicions(posicion)));
		return new ModelAndView("searchPosicion", model);
	}

	/**
	 * Elimina un posicion.
	 * @param posicionBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deletePosicion", method = RequestMethod.POST)
	@PreAuthorize("hasRole('POSICION')")  
	public ModelAndView deletePosicion(
			@ModelAttribute("command") PosicionBean posicionBean,
			BindingResult result) {
		System.out.println("delete " + posicionBean.getPosicionId());
		posicionService.deletePosicion(prepareModel(posicionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("posicion", null);
		model.put("posicions",
				prepareListofBean(posicionService.listPosicions(null)));
		return new ModelAndView("searchPosicion", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryPosicion", method = RequestMethod.GET)
	@PreAuthorize("hasRole('POSICION')")  
	public ModelAndView entryPosicion() {
		return new ModelAndView("redirect:/searchPosicion");
	}

	private Posicion prepareModel(PosicionBean posicionBean) {
		Posicion posicion = new Posicion();

		//posicion.setFilialId(posicionBean.getFilialId());
		//posicion.setPuestoId(posicionBean.getPuestoId());
		//posicion.setHDateId(posicionBean.getFechaId());
		//posicion.setHCurrencyId(posicionBean.getSalarioId());
		//posicion.setHIntegerId(posicionBean.getVacantesId());
		//posicion.setRadiotiponominaId(posicionBean.getTipoId());
		//posicion.setReclutadorId(posicionBean.getReclutadorId());
		//posicion.setRadioestatusposicionId(posicionBean.getEstadoId());
		//posicion.setSolicitudId(posicionBean.getSolicitudId());
		//posicion.setEventoId(posicionBean.getEventoId());
		//posicion.setDisplayresultposicionId(posicionBean.getPosicionId());
		//posicion.setExposedfilterposicionId(posicionBean.getPosicionId());
		//posicion.setDisplaymodalposicionId(posicionBean.getPosicionId());
		//posicion.setEntitynameposicionId(posicionBean.getPosicionId());
		//posicion.setScaffoldposicionId(posicionBean.getPosicionId());
		posicion.setNombre(posicionBean.getNombre());
		posicion.setDescripcion(posicionBean.getDescripcion());
		posicion.setContacto(posicionBean.getContacto());
		posicion.setPosicionId(posicionBean.getPosicionId());
		posicionBean.setPosicionId(null);

		return posicion;
	}

	/**
	 * Convierte un objeto de tipo PosicionBean a un objeto de tipo Posicion.
	 * @param posicionBean.
	 * @return Posicion.
	 */
	private List<PosicionBean> prepareListofBean(List<Posicion> posicions) {
		List<PosicionBean> beans = null;
		if (posicions != null && !posicions.isEmpty()) {
			beans = new ArrayList<PosicionBean>();
			PosicionBean bean = null;
			for (Posicion posicion : posicions) {
				bean = new PosicionBean();

				//bean.setFilialId(posicion.getFilialId());
				//bean.setPuestoId(posicion.getPuestoId());
				//bean.setRadiotiponominaId(posicion.getTipoId());
				//bean.setReclutadorId(posicion.getReclutadorId());
				//bean.setRadioestatusposicionId(posicion.getEstadoId());
				//bean.setSolicitudId(posicion.getSolicitudId());
				//bean.setEventoId(posicion.getEventoId());
				//bean.setDisplayresultposicionId(posicion.getPosicionId());
				//bean.setExposedfilterposicionId(posicion.getPosicionId());
				//bean.setDisplaymodalposicionId(posicion.getPosicionId());
				//bean.setEntitynameposicionId(posicion.getPosicionId());
				//bean.setScaffoldposicionId(posicion.getPosicionId());
				bean.setNombre(posicion.getNombre());
				bean.setDescripcion(posicion.getDescripcion());
				bean.setContacto(posicion.getContacto());
				bean.setPosicionId(posicion.getPosicionId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


