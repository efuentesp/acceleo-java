/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Candidatos. 
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

import com.softtek.acceleo.demo.catalogo.bean.CandidatoBean;
import com.softtek.acceleo.demo.domain.Candidato;
import com.softtek.acceleo.demo.service.CandidatoService;

/**
 * Clase CandidatoController.
 * @author PSG.
 *
 */
@RestController
public class CandidatoController {

	@Autowired
	private CandidatoService candidatoService;
	
	Candidato candidato = new Candidato();
	/************************************** CREATE  **************************************
	 * Crea un nuevo candidato.
	 * @param candidato.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/srp/candidato", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_CANDIDATO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createCandidato(@RequestBody Candidato candidato,    UriComponentsBuilder ucBuilder) {
	   try{
	        candidatoService.addCandidato(candidato);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/candidato/{id}").buildAndExpand(candidato.getCandidatoId()).toUri());
	        
		        	Candidato candidatoFound = candidatoService.getCandidato(candidato.getCandidatoId());
	
			Map<String, Object> candidatoMAP = new HashMap<>();
			candidatoMAP.put("id", candidatoFound.getCandidatoId());
			/*candidatoFound.setNombre(candidato.getNombre());*/
			candidatoMAP.put("nombre", candidato.getNombre());
			/*candidatoFound.setApellidopaterno(candidato.getApellidopaterno());*/
			candidatoMAP.put("apellidopaterno", candidato.getApellidopaterno());
			/*candidatoFound.setApellidomaterno(candidato.getApellidomaterno());*/
			candidatoMAP.put("apellidomaterno", candidato.getApellidomaterno());
			/*candidatoFound.setFecha(candidato.getFecha());*/
			candidatoMAP.put("fecha", candidato.getFecha());
			/*candidatoFound.setGenero(candidato.getGenero());*/
			candidatoMAP.put("genero", candidato.getGenero());
			/*candidatoFound.setEstatuscandidato(candidato.getEstatuscandidato());*/
			candidatoMAP.put("estatuscandidato", candidato.getEstatuscandidato());
			
		        	return new ResponseEntity<Map<String, Object>>(candidatoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
		   e.printStackTrace();
		   
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Candidato no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un candidato.
	  * @param id.
	  * @param candidato.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/srp/candidato/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_CANDIDATO:UPDATE')") 
	    public ResponseEntity<Map<String, Object>> actualizarCandidato(
				@PathVariable("id") String id, 
				@RequestBody Candidato candidato) {
	        
	        UUID uuid = UUID.fromString(id);
	        Candidato candidatoFound = candidatoService.getCandidato(uuid);
	         
	        if (candidatoFound==null) {
	            return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	        }
	
		candidato.setCandidatoId(candidatoFound.getCandidatoId());
		candidatoService.editCandidato(candidato);
		
		Map<String, Object> candidatoMAP = new HashMap<>();
		candidatoMAP.put("id", candidatoFound.getCandidatoId());
		/*candidatoFound.setNombre(candidato.getNombre());*/
		candidatoMAP.put("nombre", candidato.getNombre());
		/*candidatoFound.setApellidopaterno(candidato.getApellidopaterno());*/
		candidatoMAP.put("apellidopaterno", candidato.getApellidopaterno());
		/*candidatoFound.setApellidomaterno(candidato.getApellidomaterno());*/
		candidatoMAP.put("apellidomaterno", candidato.getApellidomaterno());
		/*candidatoFound.setFecha(candidato.getFecha());*/
		candidatoMAP.put("fecha", candidato.getFecha());
		/*candidatoFound.setGenero(candidato.getGenero());*/
		candidatoMAP.put("genero", candidato.getGenero());
		/*candidatoFound.setEstatuscandidato(candidato.getEstatuscandidato());*/
		candidatoMAP.put("estatuscandidato", candidato.getEstatuscandidato());
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(candidatoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los candidatos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Candidato>.
	 */
	 
	@RequestMapping(value = "/srp/candidato", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_CANDIDATO:READ')")
	public @ResponseBody  List<Map<String, Object>> getCandidatos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
		       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
		
		List<Candidato> listCandidato = null;
		
		if (query==null && _page == 0) {
		       		listCandidato = candidatoService.listCandidatos(candidato);
			rows = candidatoService.getTotalRows();
		} else if (query!= null){
			listCandidato = candidatoService.listCandidatosQuery(candidato, query, _page, 10);
			rows = candidatoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listCandidato = candidatoService.listCandidatosPagination(candidato, _page, 10);
			rows = candidatoService.getTotalRows();
		}
		
		List<Map<String, Object>> listCandidatoMAP = new ArrayList<>();
		for( Candidato candidato : listCandidato ){
			Map<String, Object> candidatoMAP = new HashMap<>();
			candidatoMAP.put("id", candidato.getCandidatoId());
			/*candidatoFound.setNombre(candidato.getNombre());*/
			candidatoMAP.put("nombre", candidato.getNombre());
			/*candidatoFound.setApellidopaterno(candidato.getApellidopaterno());*/
			candidatoMAP.put("apellidopaterno", candidato.getApellidopaterno());
			/*candidatoFound.setApellidomaterno(candidato.getApellidomaterno());*/
			candidatoMAP.put("apellidomaterno", candidato.getApellidomaterno());
			/*candidatoFound.setFecha(candidato.getFecha());*/
			candidatoMAP.put("fecha", candidato.getFecha());
			/*candidatoFound.setGenero(candidato.getGenero());*/
			candidatoMAP.put("genero", candidato.getGenero());
			/*candidatoFound.setEstatuscandidato(candidato.getEstatuscandidato());*/
			candidatoMAP.put("estatuscandidato", candidato.getEstatuscandidato());
			
			listCandidatoMAP.add(candidatoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listCandidatoMAP;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un candidato.
	 * @param id.
	 * @return Candidato.
	 */
	@RequestMapping(value = "/srp/candidato/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_CANDIDATO:READ')")
	public @ResponseBody  Map<String, Object> getCandidato(@PathVariable("id") String id) {	        
	        Candidato candidato = null;
	        
	        UUID uuid = UUID.fromString(id);
	        candidato = candidatoService.getCandidato(uuid);
	        
			Map<String, Object> candidatoMAP = new HashMap<>();
			candidatoMAP.put("id", candidato.getCandidatoId());
			/*candidatoFound.setNombre(candidato.getNombre());*/
			candidatoMAP.put("nombre", candidato.getNombre());
			/*candidatoFound.setApellidopaterno(candidato.getApellidopaterno());*/
			candidatoMAP.put("apellidopaterno", candidato.getApellidopaterno());
			/*candidatoFound.setApellidomaterno(candidato.getApellidomaterno());*/
			candidatoMAP.put("apellidomaterno", candidato.getApellidomaterno());
			/*candidatoFound.setFecha(candidato.getFecha());*/
			candidatoMAP.put("fecha", candidato.getFecha());
			/*candidatoFound.setGenero(candidato.getGenero());*/
			candidatoMAP.put("genero", candidato.getGenero());
			/*candidatoFound.setEstatuscandidato(candidato.getEstatuscandidato());*/
			candidatoMAP.put("estatuscandidato", candidato.getEstatuscandidato());
	        
	        
			return candidatoMAP;
	 }
	
}
