/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Trayectorias. 
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

import com.softtek.acceleo.demo.catalogo.bean.TrayectoriaBean;
import com.softtek.acceleo.demo.domain.Trayectoria;
import com.softtek.acceleo.demo.service.TrayectoriaService;

/**
 * Clase TrayectoriaController.
 * @author PSG.
 *
 */
@RestController
public class TrayectoriaController {

	@Autowired
	private TrayectoriaService trayectoriaService;
	
	Trayectoria trayectoria = new Trayectoria();
	/************************************** CREATE  **************************************
	 * Crea un nuevo trayectoria.
	 * @param trayectoria.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/srp/trayectoria", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_TRAYECTORIA:CREATE')")
	 public ResponseEntity<Map<String, Object>> createTrayectoria(@RequestBody Trayectoria trayectoria,    UriComponentsBuilder ucBuilder) {
	   try{
	        trayectoriaService.addTrayectoria(trayectoria);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/trayectoria/{id}").buildAndExpand(trayectoria.getTrayectoriaId()).toUri());
	        
		        	Trayectoria trayectoriaFound = trayectoriaService.getTrayectoria(trayectoria.getTrayectoriaId());
	
			Map<String, Object> trayectoriaMAP = new HashMap<>();
			trayectoriaMAP.put("id", trayectoriaFound.getTrayectoriaId());
			/*trayectoriaFound.setTrayectoria(trayectoria.getTrayectoria());*/
			trayectoriaMAP.put("trayectoria", trayectoria.getTrayectoria());
			/*trayectoriaFound.setDescripcion(trayectoria.getDescripcion());*/
			trayectoriaMAP.put("descripcion", trayectoria.getDescripcion());
			/*trayectoriaFound.setClave(trayectoria.getClave());*/
			trayectoriaMAP.put("clave", trayectoria.getClave());
			/*trayectoriaFound.setDocumentoId(trayectoria.getDocumentoId());*/
			trayectoriaMAP.put("documentoId", trayectoria.getDocumentoId());
			
		        	return new ResponseEntity<Map<String, Object>>(trayectoriaMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Trayectoria no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un trayectoria.
	  * @param id.
	  * @param trayectoria.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/srp/trayectoria/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_TRAYECTORIA:UPDATE')") 
	    public ResponseEntity<Map<String, Object>> actualizarTrayectoria(
				@PathVariable("id") String id, 
				@RequestBody Trayectoria trayectoria) {
	        
	        UUID uuid = UUID.fromString(id);
	        Trayectoria trayectoriaFound = trayectoriaService.getTrayectoria(uuid);
	         
	        if (trayectoriaFound==null) {
	            return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	        }
	
		trayectoria.setTrayectoriaId(trayectoriaFound.getTrayectoriaId());
		trayectoriaService.editTrayectoria(trayectoria);
		
		Map<String, Object> trayectoriaMAP = new HashMap<>();
		trayectoriaMAP.put("id", trayectoriaFound.getTrayectoriaId());
		/*trayectoriaFound.setTrayectoria(trayectoria.getTrayectoria());*/
		trayectoriaMAP.put("trayectoria", trayectoria.getTrayectoria());
		/*trayectoriaFound.setDescripcion(trayectoria.getDescripcion());*/
		trayectoriaMAP.put("descripcion", trayectoria.getDescripcion());
		/*trayectoriaFound.setClave(trayectoria.getClave());*/
		trayectoriaMAP.put("clave", trayectoria.getClave());
		/*trayectoriaFound.setDocumentoId(trayectoria.getDocumentoId());*/
		trayectoriaMAP.put("documentoId", trayectoria.getDocumentoId());
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(trayectoriaMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un trayectoria.
	 * @param id.
	 * @return ResponseEntity<Trayectoria>.
	 */
	@RequestMapping(value = "/srp/trayectoria/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_TRAYECTORIA:DELETE')")  
		    public ResponseEntity<Map<String, Object>> deleteTrayectoria(@PathVariable("id") String id) {
		  
		    	 UUID uuid = UUID.fromString(id);
		         Trayectoria trayectoria = trayectoriaService.getTrayectoria(uuid);
		         if (trayectoria == null) {
		             return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		         }
		  
	           	 try{
		             trayectoriaService.deleteTrayectoria(trayectoria);
		             
			 Map<String, Object> trayectoriaMAP = new HashMap<>();
			 trayectoriaMAP.put("id", trayectoria.getTrayectoriaId());
	/*trayectoriaFound.setTrayectoria(trayectoria.getTrayectoria());*/
	trayectoriaMAP.put("trayectoria", trayectoria.getTrayectoria());
	/*trayectoriaFound.setDescripcion(trayectoria.getDescripcion());*/
	trayectoriaMAP.put("descripcion", trayectoria.getDescripcion());
	/*trayectoriaFound.setClave(trayectoria.getClave());*/
	trayectoriaMAP.put("clave", trayectoria.getClave());
	/*trayectoriaFound.setDocumentoId(trayectoria.getDocumentoId());*/
	trayectoriaMAP.put("documentoId", trayectoria.getDocumentoId());
		             
		             HttpHeaders headers = new HttpHeaders();
		             return new ResponseEntity<Map<String, Object>>(trayectoriaMAP, headers, HttpStatus.OK);
		         }catch (Exception e) {
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: "+e);
		        	 responseHeaders.set("Message", "Trayectoria no se puede eliminar debido a que esta asociado con otra entidad.");	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los trayectorias.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Trayectoria>.
	 */
	 
	@RequestMapping(value = "/srp/trayectoria", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_TRAYECTORIA:READ')")
	public @ResponseBody  List<Map<String, Object>> getTrayectorias(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
		       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
		
		List<Trayectoria> listTrayectoria = null;
		
		if (query==null && _page == 0) {
		       		listTrayectoria = trayectoriaService.listTrayectorias(trayectoria);
			rows = trayectoriaService.getTotalRows();
		} else if (query!= null){
			listTrayectoria = trayectoriaService.listTrayectoriasQuery(trayectoria, query, _page, 10);
			rows = trayectoriaService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listTrayectoria = trayectoriaService.listTrayectoriasPagination(trayectoria, _page, 10);
			rows = trayectoriaService.getTotalRows();
		}
		
		List<Map<String, Object>> listTrayectoriaMAP = new ArrayList<>();
		for( Trayectoria trayectoria : listTrayectoria ){
			Map<String, Object> trayectoriaMAP = new HashMap<>();
			trayectoriaMAP.put("id", trayectoria.getTrayectoriaId());
			/*trayectoriaFound.setTrayectoria(trayectoria.getTrayectoria());*/
			trayectoriaMAP.put("trayectoria", trayectoria.getTrayectoria());
			/*trayectoriaFound.setDescripcion(trayectoria.getDescripcion());*/
			trayectoriaMAP.put("descripcion", trayectoria.getDescripcion());
			/*trayectoriaFound.setClave(trayectoria.getClave());*/
			trayectoriaMAP.put("clave", trayectoria.getClave());
			/*trayectoriaFound.setDocumentoId(trayectoria.getDocumentoId());*/
			trayectoriaMAP.put("documentoId", trayectoria.getDocumentoId());
			
			listTrayectoriaMAP.add(trayectoriaMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listTrayectoriaMAP;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un trayectoria.
	 * @param id.
	 * @return Trayectoria.
	 */
	@RequestMapping(value = "/srp/trayectoria/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_TRAYECTORIA:READ')")
	public @ResponseBody  Map<String, Object> getTrayectoria(@PathVariable("id") String id) {	        
	        Trayectoria trayectoria = null;
	        
	        UUID uuid = UUID.fromString(id);
	        trayectoria = trayectoriaService.getTrayectoria(uuid);
	        
			Map<String, Object> trayectoriaMAP = new HashMap<>();
			trayectoriaMAP.put("id", trayectoria.getTrayectoriaId());
			/*trayectoriaFound.setTrayectoria(trayectoria.getTrayectoria());*/
			trayectoriaMAP.put("trayectoria", trayectoria.getTrayectoria());
			/*trayectoriaFound.setDescripcion(trayectoria.getDescripcion());*/
			trayectoriaMAP.put("descripcion", trayectoria.getDescripcion());
			/*trayectoriaFound.setClave(trayectoria.getClave());*/
			trayectoriaMAP.put("clave", trayectoria.getClave());
			/*trayectoriaFound.setDocumentoId(trayectoria.getDocumentoId());*/
			trayectoriaMAP.put("documentoId", trayectoria.getDocumentoId());
	        
	        
			return trayectoriaMAP;
	 }
	
}
