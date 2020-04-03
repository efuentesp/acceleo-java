
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Agendas. 
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

import com.softtek.acceleo.demo.catalogo.bean.AgendaBean;
import com.softtek.acceleo.demo.domain.Agenda;
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.domain.Subfiso;

import com.softtek.acceleo.demo.service.AgendaService;
import com.softtek.acceleo.demo.service.FideicomisoService;
import com.softtek.acceleo.demo.service.SubfisoService;

/**
 * Clase AgendaController.
 * @author PSG.
 *
 */
@RestController
public class AgendaController {

	@Autowired
	private AgendaService agendaService;
	
@Autowired
private FideicomisoService fideicomisoService;
@Autowired
private SubfisoService subfisoService;
	
	Agenda agenda = new Agenda();
	/************************************** CREATE  **************************************
	 * Crea un nuevo agenda.
	 * @param agenda.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/agenda", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_AGENDA:CREATE')")
	 public ResponseEntity<Map<String, Object>> createAgenda(@RequestBody AgendaBean agendaBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Agenda agenda = new Agenda();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(agendaBean.getFideicomisoId());
	   			agenda.setFideicomisoId(fideicomiso);
	   			Subfiso subfiso = subfisoService.getSubfiso(agendaBean.getSubfisoId());
	   			agenda.setSubfisoId(subfiso);
	   		
	agenda.setEvento(agendaBean.getEvento());
	agenda.setFecha(agendaBean.getFecha());
	agenda.setEstatus(agendaBean.getEstatus());
	agenda.setObservacion(agendaBean.getObservacion());
	agenda.setConcovados(agendaBean.getConcovados());
	   		
	        agendaService.addAgenda(agenda);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> agendaMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(agendaMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Agenda no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un agenda.
	  * @param id.
	  * @param agenda.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/agenda/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_AGENDA:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarAgenda(
				@PathVariable("id") String id, 
				@RequestBody AgendaBean agendaBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Agenda agendaFound = agendaService.getAgenda(uuid);
	         
	    if (agendaFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(agendaBean.getFideicomisoId());
	   			agenda.setFideicomisoId(fideicomiso);
	   			Subfiso subfiso = subfisoService.getSubfiso(agendaBean.getSubfisoId());
	   			agenda.setSubfisoId(subfiso);
	   		
	agenda.setEvento(agendaBean.getEvento());
	agenda.setFecha(agendaBean.getFecha());
	agenda.setEstatus(agendaBean.getEstatus());
	agenda.setObservacion(agendaBean.getObservacion());
	agenda.setConcovados(agendaBean.getConcovados());
	
		agenda.setAgendaId(agendaFound.getAgendaId());
		agendaService.editAgenda(agenda);
		
		Map<String, Object> agendaMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(agendaMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un agenda.
	 * @param id.
	 * @return ResponseEntity<Agenda>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/agenda/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_AGENDA:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteAgenda(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Agenda agenda = agendaService.getAgenda(uuid);
		if (agenda == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			agendaService.deleteAgenda(agenda);
			
			Map<String, Object> agendaMAP = new HashMap<>();
			agendaMAP.put("id", agenda.getAgendaId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(agendaMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Agenda no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los agendas.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Agenda>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/agenda", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_AGENDA:READ')")
	public @ResponseBody  List<Map<String, Object>> getAgendas(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Agenda> listAgenda = null;
	
		if (query==null && _page == 0) {
			listAgenda = agendaService.listAgendas(agenda);
			rows = agendaService.getTotalRows();
		} else if (query!= null){
			listAgenda = agendaService.listAgendasQuery(agenda, query, _page, 10);
			rows = agendaService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listAgenda = agendaService.listAgendasPagination(agenda, _page, 10);
			rows = agendaService.getTotalRows();
		}
		
		List<Map<String, Object>> listAgendaMAP = new ArrayList<>();
		for( Agenda agenda : listAgenda ){
			Map<String, Object> agendaMAP = new HashMap<>();
			agendaMAP.put("id", agenda.getAgendaId());
			agendaMAP.put("evento", agenda.getEvento());
			agendaMAP.put("fecha", agenda.getFecha());
			agendaMAP.put("estatus", agenda.getEstatus());
			agendaMAP.put("observacion", agenda.getObservacion());
			agendaMAP.put("concovados", agenda.getConcovados());
			agendaMAP.put("fideicomisoId", agenda.getFideicomisoId().getFideicomisoId());
			agendaMAP.put("subfisoId", agenda.getSubfisoId().getSubfisoId());
			
			listAgendaMAP.add(agendaMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listAgendaMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un agenda.
	 * @param id.
	 * @return Agenda.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/agenda/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_AGENDA:READ')")
	public @ResponseBody  Map<String, Object> getAgenda(@PathVariable("id") String id) {	        
	        Agenda agenda = null;
	        
	        UUID uuid = UUID.fromString(id);
	        agenda = agendaService.getAgenda(uuid);
	        
			Map<String, Object> agendaMAP = new HashMap<>();
			agendaMAP.put("id", agenda.getAgendaId());
			agendaMAP.put("evento", agenda.getEvento());
			agendaMAP.put("fecha", agenda.getFecha());
			agendaMAP.put("estatus", agenda.getEstatus());
			agendaMAP.put("observacion", agenda.getObservacion());
			agendaMAP.put("concovados", agenda.getConcovados());
			agendaMAP.put("fideicomisoId", agenda.getFideicomisoId());
			agendaMAP.put("subfisoId", agenda.getSubfisoId());
	        
			return agendaMAP;
	 }
	
}
