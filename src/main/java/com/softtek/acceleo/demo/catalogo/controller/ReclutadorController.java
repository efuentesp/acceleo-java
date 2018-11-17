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
	/************************************** CREATE  **************************************
	 * Crea un nuevo reclutador.
	 * @param reclutador.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/srp/reclutador", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_RECLUTADOR:CREATE')")
	 public ResponseEntity<Map<String, Object>> createReclutador(@RequestBody Reclutador reclutador,    UriComponentsBuilder ucBuilder) {
	   try{
	        reclutadorService.addReclutador(reclutador);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/reclutador/{id}").buildAndExpand(reclutador.getReclutadorId()).toUri());
	        
		        	Reclutador reclutadorFound = reclutadorService.getReclutador(reclutador.getReclutadorId());
	
			Map<String, Object> reclutadorMAP = new HashMap<>();
			reclutadorMAP.put("id", reclutadorFound.getReclutadorId());
			/*reclutadorFound.setNombre(reclutador.getNombre());*/
			reclutadorMAP.put("nombre", reclutador.getNombre());
			/*reclutadorFound.setApellidopaterno(reclutador.getApellidopaterno());*/
			reclutadorMAP.put("apellidopaterno", reclutador.getApellidopaterno());
			/*reclutadorFound.setApellidomaterno(reclutador.getApellidomaterno());*/
			reclutadorMAP.put("apellidomaterno", reclutador.getApellidomaterno());
			/*reclutadorFound.setGenero(reclutador.getGenero());*/
			reclutadorMAP.put("genero", reclutador.getGenero());
			
		        	return new ResponseEntity<Map<String, Object>>(reclutadorMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Reclutador no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un reclutador.
	  * @param id.
	  * @param reclutador.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/srp/reclutador/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_RECLUTADOR:UPDATE')") 
	    public ResponseEntity<Map<String, Object>> actualizarReclutador(
				@PathVariable("id") String id, 
				@RequestBody Reclutador reclutador) {
	        
	        UUID uuid = UUID.fromString(id);
	        Reclutador reclutadorFound = reclutadorService.getReclutador(uuid);
	         
	        if (reclutadorFound==null) {
	            return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	        }
	
		reclutador.setReclutadorId(reclutadorFound.getReclutadorId());
		reclutadorService.editReclutador(reclutador);
		
		Map<String, Object> reclutadorMAP = new HashMap<>();
		reclutadorMAP.put("id", reclutadorFound.getReclutadorId());
		/*reclutadorFound.setNombre(reclutador.getNombre());*/
		reclutadorMAP.put("nombre", reclutador.getNombre());
		/*reclutadorFound.setApellidopaterno(reclutador.getApellidopaterno());*/
		reclutadorMAP.put("apellidopaterno", reclutador.getApellidopaterno());
		/*reclutadorFound.setApellidomaterno(reclutador.getApellidomaterno());*/
		reclutadorMAP.put("apellidomaterno", reclutador.getApellidomaterno());
		/*reclutadorFound.setGenero(reclutador.getGenero());*/
		reclutadorMAP.put("genero", reclutador.getGenero());
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(reclutadorMAP, headers, HttpStatus.OK);
	  } 
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los reclutadors.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Reclutador>.
	 */
	 
	@RequestMapping(value = "/srp/reclutador", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_RECLUTADOR:READ')")
	public @ResponseBody  List<Map<String, Object>> getReclutadors(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
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
		
		List<Map<String, Object>> listReclutadorMAP = new ArrayList<>();
		for( Reclutador reclutador : listReclutador ){
			Map<String, Object> reclutadorMAP = new HashMap<>();
			reclutadorMAP.put("id", reclutador.getReclutadorId());
			/*reclutadorFound.setNombre(reclutador.getNombre());*/
			reclutadorMAP.put("nombre", reclutador.getNombre());
			/*reclutadorFound.setApellidopaterno(reclutador.getApellidopaterno());*/
			reclutadorMAP.put("apellidopaterno", reclutador.getApellidopaterno());
			/*reclutadorFound.setApellidomaterno(reclutador.getApellidomaterno());*/
			reclutadorMAP.put("apellidomaterno", reclutador.getApellidomaterno());
			/*reclutadorFound.setGenero(reclutador.getGenero());*/
			reclutadorMAP.put("genero", reclutador.getGenero());
			
			listReclutadorMAP.add(reclutadorMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listReclutadorMAP;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un reclutador.
	 * @param id.
	 * @return Reclutador.
	 */
	@RequestMapping(value = "/srp/reclutador/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_RECLUTADOR:READ')")
	public @ResponseBody  Map<String, Object> getReclutador(@PathVariable("id") String id) {	        
	        Reclutador reclutador = null;
	        
	        UUID uuid = UUID.fromString(id);
	        reclutador = reclutadorService.getReclutador(uuid);
	        
			Map<String, Object> reclutadorMAP = new HashMap<>();
			reclutadorMAP.put("id", reclutador.getReclutadorId());
			/*reclutadorFound.setNombre(reclutador.getNombre());*/
			reclutadorMAP.put("nombre", reclutador.getNombre());
			/*reclutadorFound.setApellidopaterno(reclutador.getApellidopaterno());*/
			reclutadorMAP.put("apellidopaterno", reclutador.getApellidopaterno());
			/*reclutadorFound.setApellidomaterno(reclutador.getApellidomaterno());*/
			reclutadorMAP.put("apellidomaterno", reclutador.getApellidomaterno());
			/*reclutadorFound.setGenero(reclutador.getGenero());*/
			reclutadorMAP.put("genero", reclutador.getGenero());
	        
	        
			return reclutadorMAP;
	 }
	
}
