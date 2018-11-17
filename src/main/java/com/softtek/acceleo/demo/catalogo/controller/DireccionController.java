/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Direccions. 
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

import com.softtek.acceleo.demo.catalogo.bean.DireccionBean;
import com.softtek.acceleo.demo.domain.Direccion;
import com.softtek.acceleo.demo.service.DireccionService;

/**
 * Clase DireccionController.
 * @author PSG.
 *
 */
@RestController
public class DireccionController {

	@Autowired
	private DireccionService direccionService;
	
	Direccion direccion = new Direccion();
	/************************************** CREATE  **************************************
	 * Crea un nuevo direccion.
	 * @param direccion.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/srp/direccion", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_DIRECCION:CREATE')")
	 public ResponseEntity<Map<String, Object>> createDireccion(@RequestBody Direccion direccion,    UriComponentsBuilder ucBuilder) {
	   try{
	        direccionService.addDireccion(direccion);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/direccion/{id}").buildAndExpand(direccion.getDireccionId()).toUri());
	        
		        	Direccion direccionFound = direccionService.getDireccion(direccion.getDireccionId());
	
			Map<String, Object> direccionMAP = new HashMap<>();
			direccionMAP.put("id", direccionFound.getDireccionId());
			/*direccionFound.setCalle(direccion.getCalle());*/
			direccionMAP.put("calle", direccion.getCalle());
			/*direccionFound.setCp(direccion.getCp());*/
			direccionMAP.put("cp", direccion.getCp());
			/*direccionFound.setCiudad(direccion.getCiudad());*/
			direccionMAP.put("ciudad", direccion.getCiudad());
			/*direccionFound.setEstado(direccion.getEstado());*/
			direccionMAP.put("estado", direccion.getEstado());
			
		        	return new ResponseEntity<Map<String, Object>>(direccionMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Direccion no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un direccion.
	  * @param id.
	  * @param direccion.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/srp/direccion/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_DIRECCION:UPDATE')") 
	    public ResponseEntity<Map<String, Object>> actualizarDireccion(
				@PathVariable("id") String id, 
				@RequestBody Direccion direccion) {
	        
	        UUID uuid = UUID.fromString(id);
	        Direccion direccionFound = direccionService.getDireccion(uuid);
	         
	        if (direccionFound==null) {
	            return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	        }
	
		direccion.setDireccionId(direccionFound.getDireccionId());
		direccionService.editDireccion(direccion);
		
		Map<String, Object> direccionMAP = new HashMap<>();
		direccionMAP.put("id", direccionFound.getDireccionId());
		/*direccionFound.setCalle(direccion.getCalle());*/
		direccionMAP.put("calle", direccion.getCalle());
		/*direccionFound.setCp(direccion.getCp());*/
		direccionMAP.put("cp", direccion.getCp());
		/*direccionFound.setCiudad(direccion.getCiudad());*/
		direccionMAP.put("ciudad", direccion.getCiudad());
		/*direccionFound.setEstado(direccion.getEstado());*/
		direccionMAP.put("estado", direccion.getEstado());
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(direccionMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un direccion.
	 * @param id.
	 * @return ResponseEntity<Direccion>.
	 */
	@RequestMapping(value = "/srp/direccion/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_DIRECCION:DELETE')")  
		    public ResponseEntity<Map<String, Object>> deleteDireccion(@PathVariable("id") String id) {
		  
		    	 UUID uuid = UUID.fromString(id);
		         Direccion direccion = direccionService.getDireccion(uuid);
		         if (direccion == null) {
		             return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		         }
		  
	           	 try{
		             direccionService.deleteDireccion(direccion);
		             
			 Map<String, Object> direccionMAP = new HashMap<>();
			 direccionMAP.put("id", direccion.getDireccionId());
	/*direccionFound.setCalle(direccion.getCalle());*/
	direccionMAP.put("calle", direccion.getCalle());
	/*direccionFound.setCp(direccion.getCp());*/
	direccionMAP.put("cp", direccion.getCp());
	/*direccionFound.setCiudad(direccion.getCiudad());*/
	direccionMAP.put("ciudad", direccion.getCiudad());
	/*direccionFound.setEstado(direccion.getEstado());*/
	direccionMAP.put("estado", direccion.getEstado());
		             
		             HttpHeaders headers = new HttpHeaders();
		             return new ResponseEntity<Map<String, Object>>(direccionMAP, headers, HttpStatus.OK);
		         }catch (Exception e) {
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: "+e);
		        	 responseHeaders.set("Message", "Direccion no se puede eliminar debido a que esta asociado con otra entidad.");	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los direccions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Direccion>.
	 */
	 
	@RequestMapping(value = "/srp/direccion", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_DIRECCION:READ')")
	public @ResponseBody  List<Map<String, Object>> getDireccions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
		       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
		
		List<Direccion> listDireccion = null;
		
		if (query==null && _page == 0) {
		       		listDireccion = direccionService.listDireccions(direccion);
			rows = direccionService.getTotalRows();
		} else if (query!= null){
			listDireccion = direccionService.listDireccionsQuery(direccion, query, _page, 10);
			rows = direccionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listDireccion = direccionService.listDireccionsPagination(direccion, _page, 10);
			rows = direccionService.getTotalRows();
		}
		
		List<Map<String, Object>> listDireccionMAP = new ArrayList<>();
		for( Direccion direccion : listDireccion ){
			Map<String, Object> direccionMAP = new HashMap<>();
			direccionMAP.put("id", direccion.getDireccionId());
			/*direccionFound.setCalle(direccion.getCalle());*/
			direccionMAP.put("calle", direccion.getCalle());
			/*direccionFound.setCp(direccion.getCp());*/
			direccionMAP.put("cp", direccion.getCp());
			/*direccionFound.setCiudad(direccion.getCiudad());*/
			direccionMAP.put("ciudad", direccion.getCiudad());
			/*direccionFound.setEstado(direccion.getEstado());*/
			direccionMAP.put("estado", direccion.getEstado());
			
			listDireccionMAP.add(direccionMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listDireccionMAP;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un direccion.
	 * @param id.
	 * @return Direccion.
	 */
	@RequestMapping(value = "/srp/direccion/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_DIRECCION:READ')")
	public @ResponseBody  Map<String, Object> getDireccion(@PathVariable("id") String id) {	        
	        Direccion direccion = null;
	        
	        UUID uuid = UUID.fromString(id);
	        direccion = direccionService.getDireccion(uuid);
	        
			Map<String, Object> direccionMAP = new HashMap<>();
			direccionMAP.put("id", direccion.getDireccionId());
			/*direccionFound.setCalle(direccion.getCalle());*/
			direccionMAP.put("calle", direccion.getCalle());
			/*direccionFound.setCp(direccion.getCp());*/
			direccionMAP.put("cp", direccion.getCp());
			/*direccionFound.setCiudad(direccion.getCiudad());*/
			direccionMAP.put("ciudad", direccion.getCiudad());
			/*direccionFound.setEstado(direccion.getEstado());*/
			direccionMAP.put("estado", direccion.getEstado());
	        
	        
			return direccionMAP;
	 }
	
}
