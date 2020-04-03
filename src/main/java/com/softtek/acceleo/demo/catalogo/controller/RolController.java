/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Rols. 
 */
package com.softtek.acceleo.demo.catalogo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
import com.softtek.acceleo.demo.security.JwtUserFactory;
import com.softtek.acceleo.demo.catalogo.bean.RolBean;
import com.softtek.acceleo.demo.domain.Rol;
import com.softtek.acceleo.demo.service.RolService;

/**
 * Clase RolController.
 * @author PSG.
 *
 */
@RestController
public class RolController {
	private static final Logger logger = Logger.getLogger(RolController.class);
	
	@Autowired
	private RolService rolService;
	
	Rol rol = new Rol();
	/************************************** CREATE  **************************************
	 * Crea un nuevo rol.
	 * @param rol.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/srp/rol", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_ROL:CREATE')")
	 public ResponseEntity<Map<String, Object>> createRol(@RequestBody Rol rol,    UriComponentsBuilder ucBuilder) {
	   try{
	        rolService.addRol(rol);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/rol/{id}").buildAndExpand(rol.getRolId()).toUri());
	        
		        	Rol rolFound = rolService.getRol(rol.getRolId());
	
			Map<String, Object> rolMAP = new HashMap<>();
			rolMAP.put("id", rolFound.getRolId());
			/*rolFound.setClave(rol.getClave());*/
			rolMAP.put("clave", rol.getClave());
			/*rolFound.setNombre(rol.getNombre());*/
			rolMAP.put("nombre", rol.getNombre());
			/*rolFound.setActivo(rol.getActivo());*/
			rolMAP.put("activo", rol.getActivo());
			
		        	return new ResponseEntity<Map<String, Object>>(rolMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Rol no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un rol.
	  * @param id.
	  * @param rol.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/srp/rol/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_ROL:UPDATE')") 
	    public ResponseEntity<Map<String, Object>> actualizarRol(
				@PathVariable("id") String id, 
				@RequestBody Rol rol) {
	        
	        UUID uuid = UUID.fromString(id);
	        Rol rolFound = rolService.getRol(uuid);
	         
	        if (rolFound==null) {
	            return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	        }
	
		rol.setRolId(rolFound.getRolId());
		rolService.editRol(rol);
		
		Map<String, Object> rolMAP = new HashMap<>();
		rolMAP.put("id", rolFound.getRolId());
		/*rolFound.setClave(rol.getClave());*/
		rolMAP.put("clave", rol.getClave());
		/*rolFound.setNombre(rol.getNombre());*/
		rolMAP.put("nombre", rol.getNombre());
		/*rolFound.setActivo(rol.getActivo());*/
		rolMAP.put("activo", rol.getActivo());
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(rolMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un rol.
	 * @param id.
	 * @return ResponseEntity<Rol>.
	 */
	@RequestMapping(value = "/srp/rol/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_ROL:DELETE')")  
		    public ResponseEntity<Map<String, Object>> deleteRol(@PathVariable("id") String id) {
		  
		    	 UUID uuid = UUID.fromString(id);
		         Rol rol = rolService.getRol(uuid);
		         if (rol == null) {
		             return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		         }
		  
	           	 try{
		             rolService.deleteRol(rol);
		             
			 Map<String, Object> rolMAP = new HashMap<>();
			 rolMAP.put("id", rol.getRolId());
	/*rolFound.setClave(rol.getClave());*/
	rolMAP.put("clave", rol.getClave());
	/*rolFound.setNombre(rol.getNombre());*/
	rolMAP.put("nombre", rol.getNombre());
	/*rolFound.setActivo(rol.getActivo());*/
	rolMAP.put("activo", rol.getActivo());
		             
		             HttpHeaders headers = new HttpHeaders();
		             return new ResponseEntity<Map<String, Object>>(rolMAP, headers, HttpStatus.OK);
		         }catch (Exception e) {
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: "+e);
		        	 responseHeaders.set("Message", "Rol no se puede eliminar debido a que esta asociado con otra entidad.");	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los rols.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Rol>.
	 */
	 
	@RequestMapping(value = "/srp/rol", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ROL:READ')")
	public @ResponseBody  List<Map<String, Object>> getRols(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
		
		List<Rol> listRol = null;
		
		if (query==null && _page == 0) {
		       		listRol = rolService.listRols(rol);
			rows = rolService.getTotalRows();
		} else if (query!= null){
			listRol = rolService.listRolsQuery(rol, query, _page, 10);
			rows = rolService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listRol = rolService.listRolsPagination(rol, _page, 10);
			rows = rolService.getTotalRows();
		}
		
		List<Map<String, Object>> listRolMAP = new ArrayList<>();
		for( Rol rol : listRol ){
			Map<String, Object> rolMAP = new HashMap<>();
			rolMAP.put("id", rol.getRolId());
			/*rolFound.setClave(rol.getClave());*/
			rolMAP.put("clave", rol.getClave());
			/*rolFound.setNombre(rol.getNombre());*/
			rolMAP.put("nombre", rol.getNombre());
			/*rolFound.setActivo(rol.getActivo());*/
			rolMAP.put("activo", rol.getActivo());
			
			logger.debug("================JPB================>>>> id: " + rol.getRolId() + "\t Clave: " + rol.getClave() + "\t Nombre: " + rol.getNombre() + "\t Activo: " + rol.getActivo());
			listRolMAP.add(rolMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listRolMAP;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un rol.
	 * @param id.
	 * @return Rol.
	 */
	@RequestMapping(value = "/srp/rol/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ROL:READ')")
	public @ResponseBody  Map<String, Object> getRol(@PathVariable("id") String id) {	        
	        Rol rol = null;
	        
	        UUID uuid = UUID.fromString(id);
	        rol = rolService.getRol(uuid);
	        
			Map<String, Object> rolMAP = new HashMap<>();
			rolMAP.put("id", rol.getRolId());
			/*rolFound.setClave(rol.getClave());*/
			rolMAP.put("clave", rol.getClave());
			/*rolFound.setNombre(rol.getNombre());*/
			rolMAP.put("nombre", rol.getNombre());
			/*rolFound.setActivo(rol.getActivo());*/
			rolMAP.put("activo", rol.getActivo());
	        
	        
			return rolMAP;
	 }
	
}
