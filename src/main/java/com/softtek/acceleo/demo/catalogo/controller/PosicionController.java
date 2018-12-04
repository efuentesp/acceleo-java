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

import com.softtek.acceleo.demo.catalogo.bean.PosicionBean;
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
	/************************************** CREATE  **************************************
	 * Crea un nuevo posicion.
	 * @param posicion.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/srp/posicion", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_POSICION:CREATE')")
	 public ResponseEntity<Map<String, Object>> createPosicion(@RequestBody Posicion posicion,    UriComponentsBuilder ucBuilder) {
	   try{
	        posicionService.addPosicion(posicion);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/posicion/{id}").buildAndExpand(posicion.getPosicionId()).toUri());
	        
		        	Posicion posicionFound = posicionService.getPosicion(posicion.getPosicionId());
	
			Map<String, Object> posicionMAP = new HashMap<>();
			posicionMAP.put("id", posicionFound.getPosicionId());
			/*posicionFound.setFilialId(posicion.getFilialId());*/
			posicionMAP.put("filialId", posicion.getFilialId());
			/*posicionFound.setPuestos(posicion.getPuestos());*/
			posicionMAP.put("puestos", posicion.getPuestos());
			/*posicionFound.setNombre(posicion.getNombre());*/
			posicionMAP.put("nombre", posicion.getNombre());
			/*posicionFound.setDescripcion(posicion.getDescripcion());*/
			posicionMAP.put("descripcion", posicion.getDescripcion());
			/*posicionFound.setFecha(posicion.getFecha());*/
			posicionMAP.put("fecha", posicion.getFecha());
			/*posicionFound.setContacto(posicion.getContacto());*/
			posicionMAP.put("contacto", posicion.getContacto());
			/*posicionFound.setSalario(posicion.getSalario());*/
			posicionMAP.put("salario", posicion.getSalario());
			/*posicionFound.setVacantes(posicion.getVacantes());*/
			posicionMAP.put("vacantes", posicion.getVacantes());
			/*posicionFound.setTiponomina(posicion.getTiponomina());*/
			posicionMAP.put("tiponomina", posicion.getTiponomina());
			/*posicionFound.setReclutadorId(posicion.getReclutadorId());*/
			posicionMAP.put("reclutadorId", posicion.getReclutadorId());
			/*posicionFound.setEstatusposicion(posicion.getEstatusposicion());*/
			posicionMAP.put("estatusposicion", posicion.getEstatusposicion());
			
		        	return new ResponseEntity<Map<String, Object>>(posicionMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
		   e.printStackTrace();
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Posicion no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un posicion.
	  * @param id.
	  * @param posicion.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/srp/posicion/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_POSICION:UPDATE')") 
	    public ResponseEntity<Map<String, Object>> actualizarPosicion(
				@PathVariable("id") String id, 
				@RequestBody Posicion posicion) {
	        
	        UUID uuid = UUID.fromString(id);
	        Posicion posicionFound = posicionService.getPosicion(uuid);
	         
	        if (posicionFound==null) {
	            return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	        }
	
		posicion.setPosicionId(posicionFound.getPosicionId());
		posicionService.editPosicion(posicion);
		
		Map<String, Object> posicionMAP = new HashMap<>();
		posicionMAP.put("id", posicionFound.getPosicionId());
		/*posicionFound.setFilialId(posicion.getFilialId());*/
		posicionMAP.put("filialId", posicion.getFilialId());
		/*posicionFound.setPuestos(posicion.getPuestos());*/
		posicionMAP.put("puestos", posicion.getPuestos());
		/*posicionFound.setNombre(posicion.getNombre());*/
		posicionMAP.put("nombre", posicion.getNombre());
		/*posicionFound.setDescripcion(posicion.getDescripcion());*/
		posicionMAP.put("descripcion", posicion.getDescripcion());
		/*posicionFound.setFecha(posicion.getFecha());*/
		posicionMAP.put("fecha", posicion.getFecha());
		/*posicionFound.setContacto(posicion.getContacto());*/
		posicionMAP.put("contacto", posicion.getContacto());
		/*posicionFound.setSalario(posicion.getSalario());*/
		posicionMAP.put("salario", posicion.getSalario());
		/*posicionFound.setVacantes(posicion.getVacantes());*/
		posicionMAP.put("vacantes", posicion.getVacantes());
		/*posicionFound.setTiponomina(posicion.getTiponomina());*/
		posicionMAP.put("tiponomina", posicion.getTiponomina());
		/*posicionFound.setReclutadorId(posicion.getReclutadorId());*/
		posicionMAP.put("reclutadorId", posicion.getReclutadorId());
		/*posicionFound.setEstatusposicion(posicion.getEstatusposicion());*/
		posicionMAP.put("estatusposicion", posicion.getEstatusposicion());
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(posicionMAP, headers, HttpStatus.OK);
	  } 
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los posicions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Posicion>.
	 */
	 
	@RequestMapping(value = "/srp/posicion", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_POSICION:READ')")
	public @ResponseBody  List<Map<String, Object>> getPosicions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
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
		
		List<Map<String, Object>> listPosicionMAP = new ArrayList<>();
		for( Posicion posicion : listPosicion ){
			Map<String, Object> posicionMAP = new HashMap<>();
			posicionMAP.put("id", posicion.getPosicionId());
			/*posicionFound.setFilialId(posicion.getFilialId());*/
			posicionMAP.put("filialId", posicion.getFilialId());
			/*posicionFound.setPuestos(posicion.getPuestos());*/
			posicionMAP.put("puestos", posicion.getPuestos());
			/*posicionFound.setNombre(posicion.getNombre());*/
			posicionMAP.put("nombre", posicion.getNombre());
			/*posicionFound.setDescripcion(posicion.getDescripcion());*/
			posicionMAP.put("descripcion", posicion.getDescripcion());
			/*posicionFound.setFecha(posicion.getFecha());*/
			posicionMAP.put("fecha", posicion.getFecha());
			/*posicionFound.setContacto(posicion.getContacto());*/
			posicionMAP.put("contacto", posicion.getContacto());
			/*posicionFound.setSalario(posicion.getSalario());*/
			posicionMAP.put("salario", posicion.getSalario());
			/*posicionFound.setVacantes(posicion.getVacantes());*/
			posicionMAP.put("vacantes", posicion.getVacantes());
			/*posicionFound.setTiponomina(posicion.getTiponomina());*/
			posicionMAP.put("tiponomina", posicion.getTiponomina());
			/*posicionFound.setReclutadorId(posicion.getReclutadorId());*/
			posicionMAP.put("reclutadorId", posicion.getReclutadorId());
			/*posicionFound.setEstatusposicion(posicion.getEstatusposicion());*/
			posicionMAP.put("estatusposicion", posicion.getEstatusposicion());
			
			listPosicionMAP.add(posicionMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listPosicionMAP;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un posicion.
	 * @param id.
	 * @return Posicion.
	 */
	@RequestMapping(value = "/srp/posicion/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_POSICION:READ')")
	public @ResponseBody  Map<String, Object> getPosicion(@PathVariable("id") String id) {	        
	        Posicion posicion = null;
	        
	        UUID uuid = UUID.fromString(id);
	        posicion = posicionService.getPosicion(uuid);
	        
			Map<String, Object> posicionMAP = new HashMap<>();
			posicionMAP.put("id", posicion.getPosicionId());
			/*posicionFound.setFilialId(posicion.getFilialId());*/
			posicionMAP.put("filialId", posicion.getFilialId());
			/*posicionFound.setPuestos(posicion.getPuestos());*/
			posicionMAP.put("puestos", posicion.getPuestos());
			/*posicionFound.setNombre(posicion.getNombre());*/
			posicionMAP.put("nombre", posicion.getNombre());
			/*posicionFound.setDescripcion(posicion.getDescripcion());*/
			posicionMAP.put("descripcion", posicion.getDescripcion());
			/*posicionFound.setFecha(posicion.getFecha());*/
			posicionMAP.put("fecha", posicion.getFecha());
			/*posicionFound.setContacto(posicion.getContacto());*/
			posicionMAP.put("contacto", posicion.getContacto());
			/*posicionFound.setSalario(posicion.getSalario());*/
			posicionMAP.put("salario", posicion.getSalario());
			/*posicionFound.setVacantes(posicion.getVacantes());*/
			posicionMAP.put("vacantes", posicion.getVacantes());
			/*posicionFound.setTiponomina(posicion.getTiponomina());*/
			posicionMAP.put("tiponomina", posicion.getTiponomina());
			/*posicionFound.setReclutadorId(posicion.getReclutadorId());*/
			posicionMAP.put("reclutadorId", posicion.getReclutadorId());
			/*posicionFound.setEstatusposicion(posicion.getEstatusposicion());*/
			posicionMAP.put("estatusposicion", posicion.getEstatusposicion());
	        
	        
			return posicionMAP;
	 }
	
}
