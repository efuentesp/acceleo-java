/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Usuarios. 
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

import com.softtek.acceleo.demo.catalogo.bean.UsuarioBean;
import com.softtek.acceleo.demo.domain.Usuario;
import com.softtek.acceleo.demo.service.UsuarioService;

/**
 * Clase UsuarioController.
 * @author PSG.
 *
 */
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	Usuario usuario = new Usuario();
	/************************************** CREATE  **************************************
	 * Crea un nuevo usuario.
	 * @param usuario.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/srp/usuario", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_USUARIO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createUsuario(@RequestBody Usuario usuario,    UriComponentsBuilder ucBuilder) {
	   try{
	        usuarioService.addUsuario(usuario);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/usuario/{id}").buildAndExpand(usuario.getUsuarioId()).toUri());
	        
		        	Usuario usuarioFound = usuarioService.getUsuario(usuario.getUsuarioId());
	
			Map<String, Object> usuarioMAP = new HashMap<>();
			usuarioMAP.put("id", usuarioFound.getUsuarioId());
			/*usuarioFound.setNombreclave(usuario.getNombreclave());*/
			usuarioMAP.put("nombreclave", usuario.getNombreclave());
			/*usuarioFound.setPassword(usuario.getPassword());*/
			usuarioMAP.put("password", usuario.getPassword());
			/*usuarioFound.setActivo(usuario.getActivo());*/
			usuarioMAP.put("activo", usuario.getActivo());
			/*usuarioFound.setRolId(usuario.getRolId());*/
			usuarioMAP.put("rolId", usuario.getRolId());
			
		        	return new ResponseEntity<Map<String, Object>>(usuarioMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Usuario no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un usuario.
	  * @param id.
	  * @param usuario.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/srp/usuario/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_USUARIO:UPDATE')") 
	    public ResponseEntity<Map<String, Object>> actualizarUsuario(
				@PathVariable("id") String id, 
				@RequestBody Usuario usuario) {
	        
	        UUID uuid = UUID.fromString(id);
	        Usuario usuarioFound = usuarioService.getUsuario(uuid);
	         
	        if (usuarioFound==null) {
	            return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	        }
	
		usuario.setUsuarioId(usuarioFound.getUsuarioId());
		usuarioService.editUsuario(usuario);
		
		Map<String, Object> usuarioMAP = new HashMap<>();
		usuarioMAP.put("id", usuarioFound.getUsuarioId());
		/*usuarioFound.setNombreclave(usuario.getNombreclave());*/
		usuarioMAP.put("nombreclave", usuario.getNombreclave());
		/*usuarioFound.setPassword(usuario.getPassword());*/
		usuarioMAP.put("password", usuario.getPassword());
		/*usuarioFound.setActivo(usuario.getActivo());*/
		usuarioMAP.put("activo", usuario.getActivo());
		/*usuarioFound.setRolId(usuario.getRolId());*/
		usuarioMAP.put("rolId", usuario.getRolId());
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(usuarioMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un usuario.
	 * @param id.
	 * @return ResponseEntity<Usuario>.
	 */
	@RequestMapping(value = "/srp/usuario/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_USUARIO:DELETE')")  
		    public ResponseEntity<Map<String, Object>> deleteUsuario(@PathVariable("id") String id) {
		  
		    	 UUID uuid = UUID.fromString(id);
		         Usuario usuario = usuarioService.getUsuario(uuid);
		         if (usuario == null) {
		             return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		         }
		  
	           	 try{
		             usuarioService.deleteUsuario(usuario);
		             
			 Map<String, Object> usuarioMAP = new HashMap<>();
			 usuarioMAP.put("id", usuario.getUsuarioId());
	/*usuarioFound.setNombreclave(usuario.getNombreclave());*/
	usuarioMAP.put("nombreclave", usuario.getNombreclave());
	/*usuarioFound.setPassword(usuario.getPassword());*/
	usuarioMAP.put("password", usuario.getPassword());
	/*usuarioFound.setActivo(usuario.getActivo());*/
	usuarioMAP.put("activo", usuario.getActivo());
	/*usuarioFound.setRolId(usuario.getRolId());*/
	usuarioMAP.put("rolId", usuario.getRolId());
		             
		             HttpHeaders headers = new HttpHeaders();
		             return new ResponseEntity<Map<String, Object>>(usuarioMAP, headers, HttpStatus.OK);
		         }catch (Exception e) {
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: "+e);
		        	 responseHeaders.set("Message", "Usuario no se puede eliminar debido a que esta asociado con otra entidad.");	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los usuarios.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Usuario>.
	 */
	 
	@RequestMapping(value = "/srp/usuario", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_USUARIO:READ')")
	public @ResponseBody  List<Map<String, Object>> getUsuarios(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
		       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
		
		List<Usuario> listUsuario = null;
		
		if (query==null && _page == 0) {
		       		listUsuario = usuarioService.listUsuarios(usuario);
			rows = usuarioService.getTotalRows();
		} else if (query!= null){
			listUsuario = usuarioService.listUsuariosQuery(usuario, query, _page, 10);
			rows = usuarioService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listUsuario = usuarioService.listUsuariosPagination(usuario, _page, 10);
			rows = usuarioService.getTotalRows();
		}
		
		List<Map<String, Object>> listUsuarioMAP = new ArrayList<>();
		for( Usuario usuario : listUsuario ){
			Map<String, Object> usuarioMAP = new HashMap<>();
			usuarioMAP.put("id", usuario.getUsuarioId());
			/*usuarioFound.setNombreclave(usuario.getNombreclave());*/
			usuarioMAP.put("nombreclave", usuario.getNombreclave());
			/*usuarioFound.setPassword(usuario.getPassword());*/
			usuarioMAP.put("password", usuario.getPassword());
			/*usuarioFound.setActivo(usuario.getActivo());*/
			usuarioMAP.put("activo", usuario.getActivo());
			/*usuarioFound.setRolId(usuario.getRolId());*/
			usuarioMAP.put("rolId", usuario.getRolId());
			
			listUsuarioMAP.add(usuarioMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listUsuarioMAP;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un usuario.
	 * @param id.
	 * @return Usuario.
	 */
	@RequestMapping(value = "/srp/usuario/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_USUARIO:READ')")
	public @ResponseBody  Map<String, Object> getUsuario(@PathVariable("id") String id) {	        
	        Usuario usuario = null;
	        
	        UUID uuid = UUID.fromString(id);
	        usuario = usuarioService.getUsuario(uuid);
	        
			Map<String, Object> usuarioMAP = new HashMap<>();
			usuarioMAP.put("id", usuario.getUsuarioId());
			/*usuarioFound.setNombreclave(usuario.getNombreclave());*/
			usuarioMAP.put("nombreclave", usuario.getNombreclave());
			/*usuarioFound.setPassword(usuario.getPassword());*/
			usuarioMAP.put("password", usuario.getPassword());
			/*usuarioFound.setActivo(usuario.getActivo());*/
			usuarioMAP.put("activo", usuario.getActivo());
			/*usuarioFound.setRolId(usuario.getRolId());*/
			usuarioMAP.put("rolId", usuario.getRolId());
	        
	        
			return usuarioMAP;
	 }
	
}
