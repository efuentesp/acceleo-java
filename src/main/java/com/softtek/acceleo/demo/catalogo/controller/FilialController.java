/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Filials. 
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

import com.softtek.acceleo.demo.catalogo.bean.FilialBean;
import com.softtek.acceleo.demo.domain.Filial;
import com.softtek.acceleo.demo.service.FilialService;

/**
 * Clase FilialController.
 * @author PSG.
 *
 */
@RestController
public class FilialController {

	@Autowired
	private FilialService filialService;
	
	Filial filial = new Filial();
	/************************************** CREATE  **************************************
	 * Crea un nuevo filial.
	 * @param filial.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/srp/filial", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_FILIAL:CREATE')")
	 public ResponseEntity<Map<String, Object>> createFilial(@RequestBody Filial filial,    UriComponentsBuilder ucBuilder) {
	   try{
	        filialService.addFilial(filial);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/filial/{id}").buildAndExpand(filial.getFilialId()).toUri());
	        
		        	Filial filialFound = filialService.getFilial(filial.getFilialId());
	
			Map<String, Object> filialMAP = new HashMap<>();
			filialMAP.put("id", filialFound.getFilialId());
			/*filialFound.setNombre(filial.getNombre());*/
			filialMAP.put("nombre", filial.getNombre());
			/*filialFound.setUbicacion(filial.getUbicacion());*/
			filialMAP.put("ubicacion", filial.getUbicacion());
			/*filialFound.setCiudad(filial.getCiudad());*/
			filialMAP.put("ciudad", filial.getCiudad());
			/*filialFound.setEstado(filial.getEstado());*/
			filialMAP.put("estado", filial.getEstado());
			/*filialFound.setTelefono(filial.getTelefono());*/
			filialMAP.put("telefono", filial.getTelefono());
			/*filialFound.setSitio(filial.getSitio());*/
			filialMAP.put("sitio", filial.getSitio());
			/*filialFound.setContacto(filial.getContacto());*/
			filialMAP.put("contacto", filial.getContacto());
			/*filialFound.setNotas(filial.getNotas());*/
			filialMAP.put("notas", filial.getNotas());
			
		        	return new ResponseEntity<Map<String, Object>>(filialMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Filial no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un filial.
	  * @param id.
	  * @param filial.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/srp/filial/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_FILIAL:UPDATE')") 
	    public ResponseEntity<Map<String, Object>> actualizarFilial(
				@PathVariable("id") String id, 
				@RequestBody Filial filial) {
	        
	        UUID uuid = UUID.fromString(id);
	        Filial filialFound = filialService.getFilial(uuid);
	         
	        if (filialFound==null) {
	            return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	        }
	
		filial.setFilialId(filialFound.getFilialId());
		filialService.editFilial(filial);
		
		Map<String, Object> filialMAP = new HashMap<>();
		filialMAP.put("id", filialFound.getFilialId());
		/*filialFound.setNombre(filial.getNombre());*/
		filialMAP.put("nombre", filial.getNombre());
		/*filialFound.setUbicacion(filial.getUbicacion());*/
		filialMAP.put("ubicacion", filial.getUbicacion());
		/*filialFound.setCiudad(filial.getCiudad());*/
		filialMAP.put("ciudad", filial.getCiudad());
		/*filialFound.setEstado(filial.getEstado());*/
		filialMAP.put("estado", filial.getEstado());
		/*filialFound.setTelefono(filial.getTelefono());*/
		filialMAP.put("telefono", filial.getTelefono());
		/*filialFound.setSitio(filial.getSitio());*/
		filialMAP.put("sitio", filial.getSitio());
		/*filialFound.setContacto(filial.getContacto());*/
		filialMAP.put("contacto", filial.getContacto());
		/*filialFound.setNotas(filial.getNotas());*/
		filialMAP.put("notas", filial.getNotas());
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(filialMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un filial.
	 * @param id.
	 * @return ResponseEntity<Filial>.
	 */
	@RequestMapping(value = "/srp/filial/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_FILIAL:DELETE')")  
		    public ResponseEntity<Map<String, Object>> deleteFilial(@PathVariable("id") String id) {
		  
		    	 UUID uuid = UUID.fromString(id);
		         Filial filial = filialService.getFilial(uuid);
		         if (filial == null) {
		             return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		         }
		  
	           	 try{
		             filialService.deleteFilial(filial);
		             
			 Map<String, Object> filialMAP = new HashMap<>();
			 filialMAP.put("id", filial.getFilialId());
	/*filialFound.setNombre(filial.getNombre());*/
	filialMAP.put("nombre", filial.getNombre());
	/*filialFound.setUbicacion(filial.getUbicacion());*/
	filialMAP.put("ubicacion", filial.getUbicacion());
	/*filialFound.setCiudad(filial.getCiudad());*/
	filialMAP.put("ciudad", filial.getCiudad());
	/*filialFound.setEstado(filial.getEstado());*/
	filialMAP.put("estado", filial.getEstado());
	/*filialFound.setTelefono(filial.getTelefono());*/
	filialMAP.put("telefono", filial.getTelefono());
	/*filialFound.setSitio(filial.getSitio());*/
	filialMAP.put("sitio", filial.getSitio());
	/*filialFound.setContacto(filial.getContacto());*/
	filialMAP.put("contacto", filial.getContacto());
	/*filialFound.setNotas(filial.getNotas());*/
	filialMAP.put("notas", filial.getNotas());
		             
		             HttpHeaders headers = new HttpHeaders();
		             return new ResponseEntity<Map<String, Object>>(filialMAP, headers, HttpStatus.OK);
		         }catch (Exception e) {
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: "+e);
		        	 responseHeaders.set("Message", "Filial no se puede eliminar debido a que esta asociado con otra entidad.");	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los filials.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Filial>.
	 */
	 
	@RequestMapping(value = "/srp/filial", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_FILIAL:READ')")
	public @ResponseBody  List<Map<String, Object>> getFilials(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
		       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
		
		List<Filial> listFilial = null;
		
		if (query==null && _page == 0) {
		       		listFilial = filialService.listFilials(filial);
			rows = filialService.getTotalRows();
		} else if (query!= null){
			listFilial = filialService.listFilialsQuery(filial, query, _page, 10);
			rows = filialService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listFilial = filialService.listFilialsPagination(filial, _page, 10);
			rows = filialService.getTotalRows();
		}
		
		List<Map<String, Object>> listFilialMAP = new ArrayList<>();
		for( Filial filial : listFilial ){
			Map<String, Object> filialMAP = new HashMap<>();
			filialMAP.put("id", filial.getFilialId());
			/*filialFound.setNombre(filial.getNombre());*/
			filialMAP.put("nombre", filial.getNombre());
			/*filialFound.setUbicacion(filial.getUbicacion());*/
			filialMAP.put("ubicacion", filial.getUbicacion());
			/*filialFound.setCiudad(filial.getCiudad());*/
			filialMAP.put("ciudad", filial.getCiudad());
			/*filialFound.setEstado(filial.getEstado());*/
			filialMAP.put("estado", filial.getEstado());
			/*filialFound.setTelefono(filial.getTelefono());*/
			filialMAP.put("telefono", filial.getTelefono());
			/*filialFound.setSitio(filial.getSitio());*/
			filialMAP.put("sitio", filial.getSitio());
			/*filialFound.setContacto(filial.getContacto());*/
			filialMAP.put("contacto", filial.getContacto());
			/*filialFound.setNotas(filial.getNotas());*/
			filialMAP.put("notas", filial.getNotas());
			
			listFilialMAP.add(filialMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listFilialMAP;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un filial.
	 * @param id.
	 * @return Filial.
	 */
	@RequestMapping(value = "/srp/filial/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_FILIAL:READ')")
	public @ResponseBody  Map<String, Object> getFilial(@PathVariable("id") String id) {	        
	        Filial filial = null;
	        
	        UUID uuid = UUID.fromString(id);
	        filial = filialService.getFilial(uuid);
	        
			Map<String, Object> filialMAP = new HashMap<>();
			filialMAP.put("id", filial.getFilialId());
			/*filialFound.setNombre(filial.getNombre());*/
			filialMAP.put("nombre", filial.getNombre());
			/*filialFound.setUbicacion(filial.getUbicacion());*/
			filialMAP.put("ubicacion", filial.getUbicacion());
			/*filialFound.setCiudad(filial.getCiudad());*/
			filialMAP.put("ciudad", filial.getCiudad());
			/*filialFound.setEstado(filial.getEstado());*/
			filialMAP.put("estado", filial.getEstado());
			/*filialFound.setTelefono(filial.getTelefono());*/
			filialMAP.put("telefono", filial.getTelefono());
			/*filialFound.setSitio(filial.getSitio());*/
			filialMAP.put("sitio", filial.getSitio());
			/*filialFound.setContacto(filial.getContacto());*/
			filialMAP.put("contacto", filial.getContacto());
			/*filialFound.setNotas(filial.getNotas());*/
			filialMAP.put("notas", filial.getNotas());
	        
	        
			return filialMAP;
	 }
	
}
