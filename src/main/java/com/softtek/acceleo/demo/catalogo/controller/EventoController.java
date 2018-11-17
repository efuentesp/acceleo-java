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
import java.util.UUID;

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
	/************************************** CREATE  **************************************
	 * Crea un nuevo evento.
	 * @param evento.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/srp/evento", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_EVENTO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createEvento(@RequestBody Evento evento,    UriComponentsBuilder ucBuilder) {
	   try{
	        eventoService.addEvento(evento);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/evento/{id}").buildAndExpand(evento.getEventoId()).toUri());
	        
		        	Evento eventoFound = eventoService.getEvento(evento.getEventoId());
	
			Map<String, Object> eventoMAP = new HashMap<>();
			eventoMAP.put("id", eventoFound.getEventoId());
			/*eventoFound.setTipoevento(evento.getTipoevento());*/
			eventoMAP.put("tipoevento", evento.getTipoevento());
			/*eventoFound.setNombre(evento.getNombre());*/
			eventoMAP.put("nombre", evento.getNombre());
			/*eventoFound.setPosicionId(evento.getPosicionId());*/
			eventoMAP.put("posicionId", evento.getPosicionId());
			/*eventoFound.setCandidatoId(evento.getCandidatoId());*/
			eventoMAP.put("candidatoId", evento.getCandidatoId());
			/*eventoFound.setFecha(evento.getFecha());*/
			eventoMAP.put("fecha", evento.getFecha());
			/*eventoFound.setResponsable(evento.getResponsable());*/
			eventoMAP.put("responsable", evento.getResponsable());
			/*eventoFound.setNotas(evento.getNotas());*/
			eventoMAP.put("notas", evento.getNotas());
			/*eventoFound.setFechareal(evento.getFechareal());*/
			eventoMAP.put("fechareal", evento.getFechareal());
			/*eventoFound.setResponsablereal(evento.getResponsablereal());*/
			eventoMAP.put("responsablereal", evento.getResponsablereal());
			/*eventoFound.setFeedback(evento.getFeedback());*/
			eventoMAP.put("feedback", evento.getFeedback());
			/*eventoFound.setComentarios(evento.getComentarios());*/
			eventoMAP.put("comentarios", evento.getComentarios());
			/*eventoFound.setEstatusevento(evento.getEstatusevento());*/
			eventoMAP.put("estatusevento", evento.getEstatusevento());
			
		        	return new ResponseEntity<Map<String, Object>>(eventoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Evento no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un evento.
	  * @param id.
	  * @param evento.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/srp/evento/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_EVENTO:UPDATE')") 
	    public ResponseEntity<Map<String, Object>> actualizarEvento(
				@PathVariable("id") String id, 
				@RequestBody Evento evento) {
	        
	        UUID uuid = UUID.fromString(id);
	        Evento eventoFound = eventoService.getEvento(uuid);
	         
	        if (eventoFound==null) {
	            return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	        }
	
		evento.setEventoId(eventoFound.getEventoId());
		eventoService.editEvento(evento);
		
		Map<String, Object> eventoMAP = new HashMap<>();
		eventoMAP.put("id", eventoFound.getEventoId());
		/*eventoFound.setTipoevento(evento.getTipoevento());*/
		eventoMAP.put("tipoevento", evento.getTipoevento());
		/*eventoFound.setNombre(evento.getNombre());*/
		eventoMAP.put("nombre", evento.getNombre());
		/*eventoFound.setPosicionId(evento.getPosicionId());*/
		eventoMAP.put("posicionId", evento.getPosicionId());
		/*eventoFound.setCandidatoId(evento.getCandidatoId());*/
		eventoMAP.put("candidatoId", evento.getCandidatoId());
		/*eventoFound.setFecha(evento.getFecha());*/
		eventoMAP.put("fecha", evento.getFecha());
		/*eventoFound.setResponsable(evento.getResponsable());*/
		eventoMAP.put("responsable", evento.getResponsable());
		/*eventoFound.setNotas(evento.getNotas());*/
		eventoMAP.put("notas", evento.getNotas());
		/*eventoFound.setFechareal(evento.getFechareal());*/
		eventoMAP.put("fechareal", evento.getFechareal());
		/*eventoFound.setResponsablereal(evento.getResponsablereal());*/
		eventoMAP.put("responsablereal", evento.getResponsablereal());
		/*eventoFound.setFeedback(evento.getFeedback());*/
		eventoMAP.put("feedback", evento.getFeedback());
		/*eventoFound.setComentarios(evento.getComentarios());*/
		eventoMAP.put("comentarios", evento.getComentarios());
		/*eventoFound.setEstatusevento(evento.getEstatusevento());*/
		eventoMAP.put("estatusevento", evento.getEstatusevento());
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(eventoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los eventos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Evento>.
	 */
	 
	@RequestMapping(value = "/srp/evento", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_EVENTO:READ')")
	public @ResponseBody  List<Map<String, Object>> getEventos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
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
		
		List<Map<String, Object>> listEventoMAP = new ArrayList<>();
		for( Evento evento : listEvento ){
			Map<String, Object> eventoMAP = new HashMap<>();
			eventoMAP.put("id", evento.getEventoId());
			/*eventoFound.setTipoevento(evento.getTipoevento());*/
			eventoMAP.put("tipoevento", evento.getTipoevento());
			/*eventoFound.setNombre(evento.getNombre());*/
			eventoMAP.put("nombre", evento.getNombre());
			/*eventoFound.setPosicionId(evento.getPosicionId());*/
			eventoMAP.put("posicionId", evento.getPosicionId());
			/*eventoFound.setCandidatoId(evento.getCandidatoId());*/
			eventoMAP.put("candidatoId", evento.getCandidatoId());
			/*eventoFound.setFecha(evento.getFecha());*/
			eventoMAP.put("fecha", evento.getFecha());
			/*eventoFound.setResponsable(evento.getResponsable());*/
			eventoMAP.put("responsable", evento.getResponsable());
			/*eventoFound.setNotas(evento.getNotas());*/
			eventoMAP.put("notas", evento.getNotas());
			/*eventoFound.setFechareal(evento.getFechareal());*/
			eventoMAP.put("fechareal", evento.getFechareal());
			/*eventoFound.setResponsablereal(evento.getResponsablereal());*/
			eventoMAP.put("responsablereal", evento.getResponsablereal());
			/*eventoFound.setFeedback(evento.getFeedback());*/
			eventoMAP.put("feedback", evento.getFeedback());
			/*eventoFound.setComentarios(evento.getComentarios());*/
			eventoMAP.put("comentarios", evento.getComentarios());
			/*eventoFound.setEstatusevento(evento.getEstatusevento());*/
			eventoMAP.put("estatusevento", evento.getEstatusevento());
			
			listEventoMAP.add(eventoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listEventoMAP;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un evento.
	 * @param id.
	 * @return Evento.
	 */
	@RequestMapping(value = "/srp/evento/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_EVENTO:READ')")
	public @ResponseBody  Map<String, Object> getEvento(@PathVariable("id") String id) {	        
	        Evento evento = null;
	        
	        UUID uuid = UUID.fromString(id);
	        evento = eventoService.getEvento(uuid);
	        
			Map<String, Object> eventoMAP = new HashMap<>();
			eventoMAP.put("id", evento.getEventoId());
			/*eventoFound.setTipoevento(evento.getTipoevento());*/
			eventoMAP.put("tipoevento", evento.getTipoevento());
			/*eventoFound.setNombre(evento.getNombre());*/
			eventoMAP.put("nombre", evento.getNombre());
			/*eventoFound.setPosicionId(evento.getPosicionId());*/
			eventoMAP.put("posicionId", evento.getPosicionId());
			/*eventoFound.setCandidatoId(evento.getCandidatoId());*/
			eventoMAP.put("candidatoId", evento.getCandidatoId());
			/*eventoFound.setFecha(evento.getFecha());*/
			eventoMAP.put("fecha", evento.getFecha());
			/*eventoFound.setResponsable(evento.getResponsable());*/
			eventoMAP.put("responsable", evento.getResponsable());
			/*eventoFound.setNotas(evento.getNotas());*/
			eventoMAP.put("notas", evento.getNotas());
			/*eventoFound.setFechareal(evento.getFechareal());*/
			eventoMAP.put("fechareal", evento.getFechareal());
			/*eventoFound.setResponsablereal(evento.getResponsablereal());*/
			eventoMAP.put("responsablereal", evento.getResponsablereal());
			/*eventoFound.setFeedback(evento.getFeedback());*/
			eventoMAP.put("feedback", evento.getFeedback());
			/*eventoFound.setComentarios(evento.getComentarios());*/
			eventoMAP.put("comentarios", evento.getComentarios());
			/*eventoFound.setEstatusevento(evento.getEstatusevento());*/
			eventoMAP.put("estatusevento", evento.getEstatusevento());
	        
	        
			return eventoMAP;
	 }
	
}
