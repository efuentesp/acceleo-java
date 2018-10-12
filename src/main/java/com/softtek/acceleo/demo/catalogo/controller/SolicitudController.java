/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Solicituds. 
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

import com.softtek.acceleo.demo.catalogo.bean.SolicitudBean;
import com.softtek.acceleo.demo.domain.Solicitud;
import com.softtek.acceleo.demo.service.SolicitudService;

/**
 * Clase SolicitudController.
 * @author PSG.
 *
 */
@RestController
public class SolicitudController {

	@Autowired
	private SolicitudService solicitudService;
	
	Solicitud solicitud = new Solicitud();

	/************************************** SEARCH
	 * Obtiene informacion de los solicituds.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Solicitud>.
	 */
	@RequestMapping(value = "/solicitud", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('SOLICITUDSEARCH')")
	public @ResponseBody  List<Solicitud> getSolicituds(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Solicitud> listSolicitud = null;

		if (query==null && _page == 0) {
       		listSolicitud = solicitudService.listSolicituds(solicitud);
			rows = solicitudService.getTotalRows();
		} else if (query!= null){
			listSolicitud = solicitudService.listSolicitudsQuery(solicitud, query, _page, 10);
			rows = solicitudService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listSolicitud = solicitudService.listSolicitudsPagination(solicitud, _page, 10);
			rows = solicitudService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listSolicitud;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un solicitud.
	 * @param id.
	 * @return Solicitud.
	 */
	@RequestMapping(value = "/idsolicitud/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('SOLICITUDSEARCH')")
	    public @ResponseBody  Solicitud getSolicitud(@PathVariable("id") int id) {	        
	        Solicitud solicitud = null;
	        
	        solicitud = solicitudService.getSolicitud(id);
			return solicitud;
	 }

	/*************************** CREATE
	 * Crea un nuevo solicitud.
	 * @param solicitud.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/solicitud", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('SOLICITUDCREATE')")
	    public ResponseEntity<Void> createSolicitud(@RequestBody Solicitud solicitud,    UriComponentsBuilder ucBuilder) {
	   
	        solicitudService.addSolicitud(solicitud);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/solicitud/{id}").buildAndExpand(solicitud.getSolicitudId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un solicitud.
	  * @param id.
	  * @param solicitud.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/solicitud/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('SOLICITUDUPDATE')") 
	    public ResponseEntity<Solicitud> actualizarSolicitud(
				@PathVariable("id") int id, 
				@RequestBody Solicitud solicitud) {
	        
	        Solicitud solicitudFound = solicitudService.getSolicitud(id);
	         
	        if (solicitudFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Solicitud>(HttpStatus.NOT_FOUND);
	        }
	
	solicitudFound.setSalario(solicitud.getSalario());
	solicitudFound.setCorreo(solicitud.getCorreo());
	solicitudFound.setTelefono(solicitud.getTelefono());
	solicitudFound.setPosicionId(solicitud.getPosicionId());
	solicitudFound.setCandidatoId(solicitud.getCandidatoId());
	solicitudFound.setEstatussolicitudId(solicitud.getEstatussolicitudId());
	solicitudFound.setSolicitudId(solicitud.getSolicitudId());

		    solicitudService.editSolicitud(solicitudFound);
	        return new ResponseEntity<Solicitud>(solicitudFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un solicitud.
		 * @param id.
		 * @return ResponseEntity<Solicitud>.
		 */
		@RequestMapping(value = "/solicitud/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('SOLICITUDDELETE')")  
	    public ResponseEntity<Solicitud> deleteSolicitud(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Solicitud solicitud = solicitudService.getSolicitud(id);
	         if (solicitud == null) {
	             return new ResponseEntity<Solicitud>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             solicitudService.deleteSolicitud(solicitud);
	             return new ResponseEntity<Solicitud>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Solicitud no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Solicitud>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Solicitud>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un solicitud.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveSolicitud", method = RequestMethod.POST)
	@PreAuthorize("hasRole('SOLICITUD')")  
	public @ResponseBody String saveSolicitud(
			@ModelAttribute("command") SolicitudBean solicitudBean) {

		Solicitud solicitud = prepareModel(solicitudBean);
		solicitudService.addSolicitud(solicitud);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un solicitud.
	 * @param solicitudBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editSolicitud", method = RequestMethod.POST)
	@PreAuthorize("hasRole('SOLICITUD')")  
	public @ResponseBody String editSolicitud(
			@ModelAttribute("command") SolicitudBean solicitudBean) {


		Solicitud solicitud = prepareModel(solicitudBean);
		solicitudService.editSolicitud(solicitud);
		return "SUCCESS";
	}

	/**
	 * Agrega un SOLICITUD.
	 * @param SOLICITUDBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchSolicitud", method = RequestMethod.GET)
	@PreAuthorize("hasRole('SOLICITUD')")  
	public ModelAndView addSolicitud(
			@ModelAttribute("command") SolicitudBean solicitudBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Solicitud solicitud = null;
		if (solicitudBean != null)
			solicitud = prepareModel(solicitudBean);
		model.put("solicituds",
				prepareListofBean(solicitudService.listSolicituds(solicitud)));
		return new ModelAndView("searchSolicitud", model);
	}

	/**
	 * Elimina un solicitud.
	 * @param solicitudBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteSolicitud", method = RequestMethod.POST)
	@PreAuthorize("hasRole('SOLICITUD')")  
	public ModelAndView deleteSolicitud(
			@ModelAttribute("command") SolicitudBean solicitudBean,
			BindingResult result) {
		System.out.println("delete " + solicitudBean.getSolicitudId());
		solicitudService.deleteSolicitud(prepareModel(solicitudBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("solicitud", null);
		model.put("solicituds",
				prepareListofBean(solicitudService.listSolicituds(null)));
		return new ModelAndView("searchSolicitud", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entrySolicitud", method = RequestMethod.GET)
	@PreAuthorize("hasRole('SOLICITUD')")  
	public ModelAndView entrySolicitud() {
		return new ModelAndView("redirect:/searchSolicitud");
	}

	private Solicitud prepareModel(SolicitudBean solicitudBean) {
		Solicitud solicitud = new Solicitud();

		//solicitud.setPosicionId(solicitudBean.getPosicionId());
		//solicitud.setCandidatoId(solicitudBean.getCandidatoId());
		//solicitud.setNotrequiredsolicitudId(solicitudBean.getFechaId());
		//solicitud.setHCurrencyId(solicitudBean.getSalarioId());
		//solicitud.setRadioestatussolicitudId(solicitudBean.getEstadoId());
		//solicitud.setDisplayresultsolicitudId(solicitudBean.getSolicitudId());
		//solicitud.setExposedfiltersolicitudId(solicitudBean.getSolicitudId());
		//solicitud.setDisplaymodalsolicitudId(solicitudBean.getSolicitudId());
		//solicitud.setEntitynamesolicitudId(solicitudBean.getSolicitudId());
		//solicitud.setScaffoldsolicitudId(solicitudBean.getSolicitudId());
		solicitud.setCorreo(solicitudBean.getCorreo());
		solicitud.setTelefono(solicitudBean.getTelefono());
		solicitud.setSolicitudId(solicitudBean.getSolicitudId());
		solicitudBean.setSolicitudId(null);

		return solicitud;
	}

	/**
	 * Convierte un objeto de tipo SolicitudBean a un objeto de tipo Solicitud.
	 * @param solicitudBean.
	 * @return Solicitud.
	 */
	private List<SolicitudBean> prepareListofBean(List<Solicitud> solicituds) {
		List<SolicitudBean> beans = null;
		if (solicituds != null && !solicituds.isEmpty()) {
			beans = new ArrayList<SolicitudBean>();
			SolicitudBean bean = null;
			for (Solicitud solicitud : solicituds) {
				bean = new SolicitudBean();

				//bean.setPosicionId(solicitud.getPosicionId());
				//bean.setCandidatoId(solicitud.getCandidatoId());
				//bean.setNotrequiredsolicitudId(solicitud.getFechaId());
				//bean.setRadioestatussolicitudId(solicitud.getEstadoId());
				//bean.setDisplayresultsolicitudId(solicitud.getSolicitudId());
				//bean.setExposedfiltersolicitudId(solicitud.getSolicitudId());
				//bean.setDisplaymodalsolicitudId(solicitud.getSolicitudId());
				//bean.setEntitynamesolicitudId(solicitud.getSolicitudId());
				//bean.setScaffoldsolicitudId(solicitud.getSolicitudId());
				bean.setCorreo(solicitud.getCorreo());
				bean.setTelefono(solicitud.getTelefono());
				bean.setSolicitudId(solicitud.getSolicitudId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


