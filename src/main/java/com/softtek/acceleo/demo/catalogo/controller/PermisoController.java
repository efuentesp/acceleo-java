/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Permisos. 
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

import com.softtek.acceleo.demo.catalogo.bean.PermisoBean;
import com.softtek.acceleo.demo.domain.Permiso;
import com.softtek.acceleo.demo.service.PermisoService;

/**
 * Clase PermisoController.
 * @author PSG.
 *
 */
@RestController
public class PermisoController {

	@Autowired
	private PermisoService permisoService;
	
	Permiso permiso = new Permiso();
	/************************************** CREATE  **************************************
	 * Crea un nuevo permiso.
	 * @param permiso.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/srp/permiso", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_PERMISO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createPermiso(@RequestBody Permiso permiso,    UriComponentsBuilder ucBuilder) {
	   try{
	        permisoService.addPermiso(permiso);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/permiso/{id}").buildAndExpand(permiso.getPermisoId()).toUri());
	        
		        	Permiso permisoFound = permisoService.getPermiso(permiso.getPermisoId());
	
			Map<String, Object> permisoMAP = new HashMap<>();
			permisoMAP.put("id", permisoFound.getPermisoId());
			/*permisoFound.setRolId(permiso.getRolId());*/
			permisoMAP.put("rolId", permiso.getRolId());
			/*permisoFound.setFuncion(permiso.getFuncion());*/
			permisoMAP.put("funcion", permiso.getFuncion());
			/*permisoFound.setRuta(permiso.getRuta());*/
			permisoMAP.put("ruta", permiso.getRuta());
			/*permisoFound.setNivelpermiso(permiso.getNivelpermiso());*/
			permisoMAP.put("nivelpermiso", permiso.getNivelpermiso());
			
		        	return new ResponseEntity<Map<String, Object>>(permisoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Permiso no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un permiso.
	  * @param id.
	  * @param permiso.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/srp/permiso/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_PERMISO:UPDATE')") 
	    public ResponseEntity<Map<String, Object>> actualizarPermiso(
				@PathVariable("id") String id, 
				@RequestBody Permiso permiso) {
	        
	        UUID uuid = UUID.fromString(id);
	        Permiso permisoFound = permisoService.getPermiso(uuid);
	         
	        if (permisoFound==null) {
	            return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	        }
	
		permiso.setPermisoId(permisoFound.getPermisoId());
		permisoService.editPermiso(permiso);
		
		Map<String, Object> permisoMAP = new HashMap<>();
		permisoMAP.put("id", permisoFound.getPermisoId());
		/*permisoFound.setRolId(permiso.getRolId());*/
		permisoMAP.put("rolId", permiso.getRolId());
		/*permisoFound.setFuncion(permiso.getFuncion());*/
		permisoMAP.put("funcion", permiso.getFuncion());
		/*permisoFound.setRuta(permiso.getRuta());*/
		permisoMAP.put("ruta", permiso.getRuta());
		/*permisoFound.setNivelpermiso(permiso.getNivelpermiso());*/
		permisoMAP.put("nivelpermiso", permiso.getNivelpermiso());
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(permisoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un permiso.
	 * @param id.
	 * @return ResponseEntity<Permiso>.
	 */
	@RequestMapping(value = "/srp/permiso/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_PERMISO:DELETE')")  
		    public ResponseEntity<Map<String, Object>> deletePermiso(@PathVariable("id") String id) {
		  
		    	 UUID uuid = UUID.fromString(id);
		         Permiso permiso = permisoService.getPermiso(uuid);
		         if (permiso == null) {
		             return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		         }
		  
	           	 try{
		             permisoService.deletePermiso(permiso);
		             
			 Map<String, Object> permisoMAP = new HashMap<>();
			 permisoMAP.put("id", permiso.getPermisoId());
	/*permisoFound.setRolId(permiso.getRolId());*/
	permisoMAP.put("rolId", permiso.getRolId());
	/*permisoFound.setFuncion(permiso.getFuncion());*/
	permisoMAP.put("funcion", permiso.getFuncion());
	/*permisoFound.setRuta(permiso.getRuta());*/
	permisoMAP.put("ruta", permiso.getRuta());
	/*permisoFound.setNivelpermiso(permiso.getNivelpermiso());*/
	permisoMAP.put("nivelpermiso", permiso.getNivelpermiso());
		             
		             HttpHeaders headers = new HttpHeaders();
		             return new ResponseEntity<Map<String, Object>>(permisoMAP, headers, HttpStatus.OK);
		         }catch (Exception e) {
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: "+e);
		        	 responseHeaders.set("Message", "Permiso no se puede eliminar debido a que esta asociado con otra entidad.");	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los permisos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Permiso>.
	 */
	 
	@RequestMapping(value = "/srp/permiso", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_PERMISO:READ')")
	public @ResponseBody  List<Map<String, Object>> getPermisos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
		       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
		
		List<Permiso> listPermiso = null;
		
		if (query==null && _page == 0) {
		       		listPermiso = permisoService.listPermisos(permiso);
			rows = permisoService.getTotalRows();
		} else if (query!= null){
			listPermiso = permisoService.listPermisosQuery(permiso, query, _page, 10);
			rows = permisoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listPermiso = permisoService.listPermisosPagination(permiso, _page, 10);
			rows = permisoService.getTotalRows();
		}
		
		List<Map<String, Object>> listPermisoMAP = new ArrayList<>();
		for( Permiso permiso : listPermiso ){
			Map<String, Object> permisoMAP = new HashMap<>();
			permisoMAP.put("id", permiso.getPermisoId());
			/*permisoFound.setRolId(permiso.getRolId());*/
			permisoMAP.put("rolId", permiso.getRolId());
			/*permisoFound.setFuncion(permiso.getFuncion());*/
			permisoMAP.put("funcion", permiso.getFuncion());
			/*permisoFound.setRuta(permiso.getRuta());*/
			permisoMAP.put("ruta", permiso.getRuta());
			/*permisoFound.setNivelpermiso(permiso.getNivelpermiso());*/
			permisoMAP.put("nivelpermiso", permiso.getNivelpermiso());
			
			listPermisoMAP.add(permisoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listPermisoMAP;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un permiso.
	 * @param id.
	 * @return Permiso.
	 */
	@RequestMapping(value = "/srp/permiso/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_PERMISO:READ')")
	public @ResponseBody  Map<String, Object> getPermiso(@PathVariable("id") String id) {	        
	        Permiso permiso = null;
	        
	        UUID uuid = UUID.fromString(id);
	        permiso = permisoService.getPermiso(uuid);
	        
			Map<String, Object> permisoMAP = new HashMap<>();
			permisoMAP.put("id", permiso.getPermisoId());
			/*permisoFound.setRolId(permiso.getRolId());*/
			permisoMAP.put("rolId", permiso.getRolId());
			/*permisoFound.setFuncion(permiso.getFuncion());*/
			permisoMAP.put("funcion", permiso.getFuncion());
			/*permisoFound.setRuta(permiso.getRuta());*/
			permisoMAP.put("ruta", permiso.getRuta());
			/*permisoFound.setNivelpermiso(permiso.getNivelpermiso());*/
			permisoMAP.put("nivelpermiso", permiso.getNivelpermiso());
	        
	        
			return permisoMAP;
	 }
	
}
