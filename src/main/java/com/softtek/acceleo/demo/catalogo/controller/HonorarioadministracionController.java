
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los HonorarioAdministracions. 
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

import com.softtek.acceleo.demo.catalogo.bean.HonorarioadministracionBean;
import com.softtek.acceleo.demo.domain.Honorarioadministracion;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.HonorarioadministracionService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase HonorarioadministracionController.
 * @author PSG.
 *
 */
@RestController
public class HonorarioadministracionController {

	@Autowired
	private HonorarioadministracionService honorarioadministracionService;
	
@Autowired
private FideicomisoService fideicomisoService;
	
	Honorarioadministracion honorarioadministracion = new Honorarioadministracion();
	/************************************** CREATE  **************************************
	 * Crea un nuevo honorarioadministracion.
	 * @param honorarioadministracion.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/honorarioadministracion", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_HONORARIOADMINISTRACION:CREATE')")
	 public ResponseEntity<Map<String, Object>> createHonorarioadministracion(@RequestBody HonorarioadministracionBean honorarioadministracionBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Honorarioadministracion honorarioadministracion = new Honorarioadministracion();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(honorarioadministracionBean.getFideicomisoId());
	   			honorarioadministracion.setFideicomisoId(fideicomiso);
	   		
	honorarioadministracion.setPeriodo(honorarioadministracionBean.getPeriodo());
	honorarioadministracion.setMontopatrimonio(honorarioadministracionBean.getMontopatrimonio());
	honorarioadministracion.setDe(honorarioadministracionBean.getDe());
	honorarioadministracion.setDestinatario(honorarioadministracionBean.getDestinatario());
	honorarioadministracion.setHonorarioatual(honorarioadministracionBean.getHonorarioatual());
	honorarioadministracion.setCuotaminima(honorarioadministracionBean.getCuotaminima());
	   		
	        honorarioadministracionService.addHonorarioadministracion(honorarioadministracion);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> honorarioadministracionMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(honorarioadministracionMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "HonorarioAdministracion no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un honorarioadministracion.
	  * @param id.
	  * @param honorarioadministracion.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/honorarioadministracion/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_HONORARIOADMINISTRACION:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarHonorarioAdministracion(
				@PathVariable("id") String id, 
				@RequestBody HonorarioadministracionBean honorarioadministracionBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Honorarioadministracion honorarioadministracionFound = honorarioadministracionService.getHonorarioadministracion(uuid);
	         
	    if (honorarioadministracionFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(honorarioadministracionBean.getFideicomisoId());
	   			honorarioadministracion.setFideicomisoId(fideicomiso);
	   		
	honorarioadministracion.setPeriodo(honorarioadministracionBean.getPeriodo());
	honorarioadministracion.setMontopatrimonio(honorarioadministracionBean.getMontopatrimonio());
	honorarioadministracion.setDe(honorarioadministracionBean.getDe());
	honorarioadministracion.setDestinatario(honorarioadministracionBean.getDestinatario());
	honorarioadministracion.setHonorarioatual(honorarioadministracionBean.getHonorarioatual());
	honorarioadministracion.setCuotaminima(honorarioadministracionBean.getCuotaminima());
	
		honorarioadministracion.setHonorarioadministracionId(honorarioadministracionFound.getHonorarioadministracionId());
		honorarioadministracionService.editHonorarioadministracion(honorarioadministracion);
		
		Map<String, Object> honorarioadministracionMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(honorarioadministracionMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un honorarioadministracion.
	 * @param id.
	 * @return ResponseEntity<Honorarioadministracion>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/honorarioadministracion/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_HONORARIOADMINISTRACION:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteHonorarioAdministracion(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Honorarioadministracion honorarioadministracion = honorarioadministracionService.getHonorarioadministracion(uuid);
		if (honorarioadministracion == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			honorarioadministracionService.deleteHonorarioadministracion(honorarioadministracion);
			
			Map<String, Object> honorarioadministracionMAP = new HashMap<>();
			honorarioadministracionMAP.put("id", honorarioadministracion.getHonorarioadministracionId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(honorarioadministracionMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Honorarioadministracion no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los honorarioadministracions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Honorarioadministracion>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/honorarioadministracion", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_HONORARIOADMINISTRACION:READ')")
	public @ResponseBody  List<Map<String, Object>> getHonorarioAdministracions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Honorarioadministracion> listHonorarioadministracion = null;
	
		if (query==null && _page == 0) {
			listHonorarioadministracion = honorarioadministracionService.listHonorarioadministracions(honorarioadministracion);
			rows = honorarioadministracionService.getTotalRows();
		} else if (query!= null){
			listHonorarioadministracion = honorarioadministracionService.listHonorarioadministracionsQuery(honorarioadministracion, query, _page, 10);
			rows = honorarioadministracionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listHonorarioadministracion = honorarioadministracionService.listHonorarioadministracionsPagination(honorarioadministracion, _page, 10);
			rows = honorarioadministracionService.getTotalRows();
		}
		
		List<Map<String, Object>> listHonorarioadministracionMAP = new ArrayList<>();
		for( Honorarioadministracion honorarioadministracion : listHonorarioadministracion ){
			Map<String, Object> honorarioadministracionMAP = new HashMap<>();
			honorarioadministracionMAP.put("id", honorarioadministracion.getHonorarioadministracionId());
			honorarioadministracionMAP.put("periodo", honorarioadministracion.getPeriodo());
			honorarioadministracionMAP.put("montopatrimonio", honorarioadministracion.getMontopatrimonio());
			honorarioadministracionMAP.put("de", honorarioadministracion.getDe());
			honorarioadministracionMAP.put("destinatario", honorarioadministracion.getDestinatario());
			honorarioadministracionMAP.put("honorarioatual", honorarioadministracion.getHonorarioatual());
			honorarioadministracionMAP.put("cuotaminima", honorarioadministracion.getCuotaminima());
			honorarioadministracionMAP.put("fideicomisoId", honorarioadministracion.getFideicomisoId().getFideicomisoId());
			
			listHonorarioadministracionMAP.add(honorarioadministracionMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listHonorarioadministracionMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un honorarioadministracion.
	 * @param id.
	 * @return Honorarioadministracion.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/honorarioadministracion/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_HONORARIOADMINISTRACION:READ')")
	public @ResponseBody  Map<String, Object> getHonorarioAdministracion(@PathVariable("id") String id) {	        
	        Honorarioadministracion honorarioadministracion = null;
	        
	        UUID uuid = UUID.fromString(id);
	        honorarioadministracion = honorarioadministracionService.getHonorarioadministracion(uuid);
	        
			Map<String, Object> honorarioadministracionMAP = new HashMap<>();
			honorarioadministracionMAP.put("id", honorarioadministracion.getHonorarioadministracionId());
			honorarioadministracionMAP.put("periodo", honorarioadministracion.getPeriodo());
			honorarioadministracionMAP.put("montopatrimonio", honorarioadministracion.getMontopatrimonio());
			honorarioadministracionMAP.put("de", honorarioadministracion.getDe());
			honorarioadministracionMAP.put("destinatario", honorarioadministracion.getDestinatario());
			honorarioadministracionMAP.put("honorarioatual", honorarioadministracion.getHonorarioatual());
			honorarioadministracionMAP.put("cuotaminima", honorarioadministracion.getCuotaminima());
			honorarioadministracionMAP.put("fideicomisoId", honorarioadministracion.getFideicomisoId());
	        
			return honorarioadministracionMAP;
	 }
	
}
