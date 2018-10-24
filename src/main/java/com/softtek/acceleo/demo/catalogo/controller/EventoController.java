/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Eventos. 
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

import com.softtek.acceleo.demo.catalogo.bean.EventoBean;
import com.softtek.acceleo.demo.domain.Evento;
import com.softtek.acceleo.demo.domain.Solicitud;
import com.softtek.acceleo.demo.service.EventoService;

/**
 * Clase EventoController.
 * @author PSG.
 *
 */
@RestController
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	Evento evento = new Evento();

	/************************************** SEARCH
	 * Obtiene informacion de los eventos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Evento>.
	 */
	@RequestMapping(value = "/evento", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('EVENTOSEARCH')")
	public @ResponseBody  List<Evento> getEventos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Evento> listEvento = null;

		if (query==null && _page == 0) {
       		listEvento = eventoService.listEventos(evento);
			rows = eventoService.getTotalRows();
		} else if (query!= null){
			listEvento = eventoService.listEventosQuery(evento, query, _page, 10);
			rows = eventoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listEvento = eventoService.listEventosPagination(evento, _page, 10);
			rows = eventoService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listEvento;
	}

	/************************************** SEARCH
	 * Obtiene informacion de los solicitudes por candidato.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Solicitud>.
	 */
	@RequestMapping(value = "/evento/candidato/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('EVENTOSEARCH')")
	public @ResponseBody  List<Evento> getAllEventoByCandidato(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int candidatoId) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Evento> listEvento = null;
		
		if (query==null && _page == 0) {
       		listEvento = eventoService.listEventosByCandidato(evento, candidatoId);
			rows = eventoService.getTotalRows();
		} else if (query!= null){
			listEvento = eventoService.listEventosQuery(evento, query, _page, 10);
			rows = eventoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listEvento = eventoService.listEventosPagination(evento, _page, 10);
			rows = eventoService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listEvento;
	}
	
//	/************************************** SEARCH
//	 * Obtiene informacion de los solicitudes por posicion.
//	 * @param requestParams.
//	 * @param request.
//	 * @param response.
//	 * @return List<Solicitud>.
//	 */
//	@RequestMapping(value = "/evento/posicion/{id}", method = RequestMethod.GET, produces = "application/json")
//	@PreAuthorize("hasRole('EVENTOSEARCH')")
//	public @ResponseBody  List<Evento> getAllEventoByPosicion(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int posicionId) {
//
//       	String query=requestParams.get("q");
//		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
//		long rows = 0;
//
//		List<Evento> listEvento = null;
//
//		if (query==null && _page == 0) {
//			listEvento = eventoService.listSolicitudsByPosicion(evento, posicionId);
//			rows = eventoService.getTotalRows();
//		} else if (query!= null){
//			listEvento = eventoService.listSolicitudsQuery(evento, query, _page, 10);
//			rows = eventoService.getTotalRowsSearch(query);
//		} else if (_page != 0){
//			listEvento = eventoService.listSolicitudsPagination(evento, _page, 10);
//			rows = eventoService.getTotalRows();
//		}
//
//		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
//		response.setHeader("x-total-count", String.valueOf(rows).toString());	
//
//		return listEvento;
//	}
	
	/************************************* SEARCH
	 * Obtiene informacion de un evento.
	 * @param id.
	 * @return Evento.
	 */
	@RequestMapping(value = "/idevento/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('EVENTOSEARCH')")
	    public @ResponseBody  Evento getEvento(@PathVariable("id") int id) {	        
	        Evento evento = null;
	        
	        evento = eventoService.getEvento(id);
			return evento;
	 }

	/*************************** CREATE
	 * Crea un nuevo evento.
	 * @param evento.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/evento", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('EVENTOCREATE')")
	    public ResponseEntity<Void> createEvento(@RequestBody Evento evento,    UriComponentsBuilder ucBuilder) {
	   
	        eventoService.addEvento(evento);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/evento/{id}").buildAndExpand(evento.getEventoId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un evento.
	  * @param id.
	  * @param evento.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/evento/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('EVENTOUPDATE')") 
	    public ResponseEntity<Evento> actualizarEvento(
				@PathVariable("id") int id, 
				@RequestBody Evento evento) {
	        
	        Evento eventoFound = eventoService.getEvento(id);
	         
	        if (eventoFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Evento>(HttpStatus.NOT_FOUND);
	        }
	
	eventoFound.setResponsable(evento.getResponsable());
	eventoFound.setFecha(evento.getFecha());
	eventoFound.setNombre(evento.getNombre());
	eventoFound.setTipoeventoId(evento.getTipoeventoId());
	eventoFound.setPosicion(evento.getPosicion());
	eventoFound.setCandidato(evento.getCandidato());
	eventoFound.setFeedback(evento.getFeedback());
	eventoFound.setResponsablereal(evento.getResponsablereal());
	eventoFound.setComentarios(evento.getComentarios());
	eventoFound.setNotas(evento.getNotas());
	eventoFound.setEstatuseventoId(evento.getEstatuseventoId());
	eventoFound.setEventoId(evento.getEventoId());

		    eventoService.editEvento(eventoFound);
	        return new ResponseEntity<Evento>(eventoFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un evento.
		 * @param id.
		 * @return ResponseEntity<Evento>.
		 */
		@RequestMapping(value = "/evento/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('EVENTODELETE')")  
	    public ResponseEntity<Evento> deleteEvento(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Evento evento = eventoService.getEvento(id);
	         if (evento == null) {
	             return new ResponseEntity<Evento>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             eventoService.deleteEvento(evento);
	             return new ResponseEntity<Evento>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Evento no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Evento>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Evento>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un evento.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveEvento", method = RequestMethod.POST)
	@PreAuthorize("hasRole('EVENTO')")  
	public @ResponseBody String saveEvento(
			@ModelAttribute("command") EventoBean eventoBean) {

		Evento evento = prepareModel(eventoBean);
		eventoService.addEvento(evento);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un evento.
	 * @param eventoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editEvento", method = RequestMethod.POST)
	@PreAuthorize("hasRole('EVENTO')")  
	public @ResponseBody String editEvento(
			@ModelAttribute("command") EventoBean eventoBean) {


		Evento evento = prepareModel(eventoBean);
		eventoService.editEvento(evento);
		return "SUCCESS";
	}

	/**
	 * Agrega un EVENTO.
	 * @param EVENTOBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchEvento", method = RequestMethod.GET)
	@PreAuthorize("hasRole('EVENTO')")  
	public ModelAndView addEvento(
			@ModelAttribute("command") EventoBean eventoBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Evento evento = null;
		if (eventoBean != null)
			evento = prepareModel(eventoBean);
		model.put("eventos",
				prepareListofBean(eventoService.listEventos(evento)));
		return new ModelAndView("searchEvento", model);
	}

	/**
	 * Elimina un evento.
	 * @param eventoBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteEvento", method = RequestMethod.POST)
	@PreAuthorize("hasRole('EVENTO')")  
	public ModelAndView deleteEvento(
			@ModelAttribute("command") EventoBean eventoBean,
			BindingResult result) {
		System.out.println("delete " + eventoBean.getEventoId());
		eventoService.deleteEvento(prepareModel(eventoBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("evento", null);
		model.put("eventos",
				prepareListofBean(eventoService.listEventos(null)));
		return new ModelAndView("searchEvento", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryEvento", method = RequestMethod.GET)
	@PreAuthorize("hasRole('EVENTO')")  
	public ModelAndView entryEvento() {
		return new ModelAndView("redirect:/searchEvento");
	}

	private Evento prepareModel(EventoBean eventoBean) {
		Evento evento = new Evento();

		//evento.setRadiotipoeventoId(eventoBean.getTipoId());
		//evento.setPosicionId(eventoBean.getPosicionId());
		//evento.setCandidatoId(eventoBean.getCandidatoId());
		//evento.setHDateId(eventoBean.getFechaId());
		//evento.setNotrequiredeventoId(eventoBean.getNotasId());
		//evento.setNotrequiredeventoId(eventoBean.getFecharealId());
		//evento.setNotrequiredeventoId(eventoBean.getResponsablerealId());
		//evento.setNotrequiredeventoId(eventoBean.getFeedbackId());
		//evento.setNotrequiredeventoId(eventoBean.getComentariosId());
		//evento.setRadioestatuseventoId(eventoBean.getEstadoId());
		//evento.setDisplayresulteventoId(eventoBean.getEventoId());
		//evento.setExposedfiltereventoId(eventoBean.getEventoId());
		//evento.setDisplaymodaleventoId(eventoBean.getEventoId());
		//evento.setEntitynameeventoId(eventoBean.getEventoId());
		//evento.setScaffoldeventoId(eventoBean.getEventoId());
		evento.setNombre(eventoBean.getNombre());
		evento.setResponsable(eventoBean.getResponsable());
		evento.setEventoId(eventoBean.getEventoId());
		eventoBean.setEventoId(null);

		return evento;
	}

	/**
	 * Convierte un objeto de tipo EventoBean a un objeto de tipo Evento.
	 * @param eventoBean.
	 * @return Evento.
	 */
	private List<EventoBean> prepareListofBean(List<Evento> eventos) {
		List<EventoBean> beans = null;
		if (eventos != null && !eventos.isEmpty()) {
			beans = new ArrayList<EventoBean>();
			EventoBean bean = null;
			for (Evento evento : eventos) {
				bean = new EventoBean();

				//bean.setRadiotipoeventoId(evento.getTipoId());
				//bean.setPosicionId(evento.getPosicionId());
				//bean.setCandidatoId(evento.getCandidatoId());
				//bean.setNotrequiredeventoId(evento.getNotasId());
				//bean.setNotrequiredeventoId(evento.getFecharealId());
				//bean.setNotrequiredeventoId(evento.getResponsablerealId());
				//bean.setNotrequiredeventoId(evento.getFeedbackId());
				//bean.setNotrequiredeventoId(evento.getComentariosId());
				//bean.setRadioestatuseventoId(evento.getEstadoId());
				//bean.setDisplayresulteventoId(evento.getEventoId());
				//bean.setExposedfiltereventoId(evento.getEventoId());
				//bean.setDisplaymodaleventoId(evento.getEventoId());
				//bean.setEntitynameeventoId(evento.getEventoId());
				//bean.setScaffoldeventoId(evento.getEventoId());
				bean.setNombre(evento.getNombre());
				bean.setResponsable(evento.getResponsable());
				bean.setEventoId(evento.getEventoId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


