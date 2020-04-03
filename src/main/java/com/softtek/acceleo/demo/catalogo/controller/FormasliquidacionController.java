
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los FormasLiquidacions. 
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

import com.softtek.acceleo.demo.catalogo.bean.FormasliquidacionBean;
import com.softtek.acceleo.demo.domain.Formasliquidacion;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.FormasliquidacionService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase FormasliquidacionController.
 * @author PSG.
 *
 */
@RestController
public class FormasliquidacionController {

	@Autowired
	private FormasliquidacionService formasliquidacionService;
	
@Autowired
private FideicomisoService fideicomisoService;
	
	Formasliquidacion formasliquidacion = new Formasliquidacion();
	/************************************** CREATE  **************************************
	 * Crea un nuevo formasliquidacion.
	 * @param formasliquidacion.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/formasliquidacion", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_FORMASLIQUIDACION:CREATE')")
	 public ResponseEntity<Map<String, Object>> createFormasliquidacion(@RequestBody FormasliquidacionBean formasliquidacionBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Formasliquidacion formasliquidacion = new Formasliquidacion();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(formasliquidacionBean.getFideicomisoId());
	   			formasliquidacion.setFideicomisoId(fideicomiso);
	   		
	formasliquidacion.setParticipante(formasliquidacionBean.getParticipante());
	formasliquidacion.setTipo(formasliquidacionBean.getTipo());
	formasliquidacion.setFideicomisario(formasliquidacionBean.getFideicomisario());
	formasliquidacion.setFormaliquidacion(formasliquidacionBean.getFormaliquidacion());
	formasliquidacion.setMoneda(formasliquidacionBean.getMoneda());
	formasliquidacion.setSeccuentaseleccionada(formasliquidacionBean.getSeccuentaseleccionada());
	formasliquidacion.setPlprincipal(formasliquidacionBean.getPlprincipal());
	formasliquidacion.setEstado(formasliquidacionBean.getEstado());
	formasliquidacion.setSecparamliq(formasliquidacionBean.getSecparamliq());
	   		
	        formasliquidacionService.addFormasliquidacion(formasliquidacion);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> formasliquidacionMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(formasliquidacionMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "FormasLiquidacion no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un formasliquidacion.
	  * @param id.
	  * @param formasliquidacion.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/formasliquidacion/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_FORMASLIQUIDACION:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarFormasLiquidacion(
				@PathVariable("id") String id, 
				@RequestBody FormasliquidacionBean formasliquidacionBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Formasliquidacion formasliquidacionFound = formasliquidacionService.getFormasliquidacion(uuid);
	         
	    if (formasliquidacionFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(formasliquidacionBean.getFideicomisoId());
	   			formasliquidacion.setFideicomisoId(fideicomiso);
	   		
	formasliquidacion.setParticipante(formasliquidacionBean.getParticipante());
	formasliquidacion.setTipo(formasliquidacionBean.getTipo());
	formasliquidacion.setFideicomisario(formasliquidacionBean.getFideicomisario());
	formasliquidacion.setFormaliquidacion(formasliquidacionBean.getFormaliquidacion());
	formasliquidacion.setMoneda(formasliquidacionBean.getMoneda());
	formasliquidacion.setSeccuentaseleccionada(formasliquidacionBean.getSeccuentaseleccionada());
	formasliquidacion.setPlprincipal(formasliquidacionBean.getPlprincipal());
	formasliquidacion.setEstado(formasliquidacionBean.getEstado());
	formasliquidacion.setSecparamliq(formasliquidacionBean.getSecparamliq());
	
		formasliquidacion.setFormasliquidacionId(formasliquidacionFound.getFormasliquidacionId());
		formasliquidacionService.editFormasliquidacion(formasliquidacion);
		
		Map<String, Object> formasliquidacionMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(formasliquidacionMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un formasliquidacion.
	 * @param id.
	 * @return ResponseEntity<Formasliquidacion>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/formasliquidacion/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_FORMASLIQUIDACION:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteFormasLiquidacion(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Formasliquidacion formasliquidacion = formasliquidacionService.getFormasliquidacion(uuid);
		if (formasliquidacion == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			formasliquidacionService.deleteFormasliquidacion(formasliquidacion);
			
			Map<String, Object> formasliquidacionMAP = new HashMap<>();
			formasliquidacionMAP.put("id", formasliquidacion.getFormasliquidacionId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(formasliquidacionMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Formasliquidacion no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los formasliquidacions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Formasliquidacion>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/formasliquidacion", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_FORMASLIQUIDACION:READ')")
	public @ResponseBody  List<Map<String, Object>> getFormasLiquidacions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Formasliquidacion> listFormasliquidacion = null;
	
		if (query==null && _page == 0) {
			listFormasliquidacion = formasliquidacionService.listFormasliquidacions(formasliquidacion);
			rows = formasliquidacionService.getTotalRows();
		} else if (query!= null){
			listFormasliquidacion = formasliquidacionService.listFormasliquidacionsQuery(formasliquidacion, query, _page, 10);
			rows = formasliquidacionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listFormasliquidacion = formasliquidacionService.listFormasliquidacionsPagination(formasliquidacion, _page, 10);
			rows = formasliquidacionService.getTotalRows();
		}
		
		List<Map<String, Object>> listFormasliquidacionMAP = new ArrayList<>();
		for( Formasliquidacion formasliquidacion : listFormasliquidacion ){
			Map<String, Object> formasliquidacionMAP = new HashMap<>();
			formasliquidacionMAP.put("id", formasliquidacion.getFormasliquidacionId());
			formasliquidacionMAP.put("participante", formasliquidacion.getParticipante());
			formasliquidacionMAP.put("tipo", formasliquidacion.getTipo());
			formasliquidacionMAP.put("fideicomisario", formasliquidacion.getFideicomisario());
			formasliquidacionMAP.put("formaliquidacion", formasliquidacion.getFormaliquidacion());
			formasliquidacionMAP.put("moneda", formasliquidacion.getMoneda());
			formasliquidacionMAP.put("seccuentaseleccionada", formasliquidacion.getSeccuentaseleccionada());
			formasliquidacionMAP.put("plprincipal", formasliquidacion.getPlprincipal());
			formasliquidacionMAP.put("estado", formasliquidacion.getEstado());
			formasliquidacionMAP.put("secparamliq", formasliquidacion.getSecparamliq());
			formasliquidacionMAP.put("fideicomisoId", formasliquidacion.getFideicomisoId().getFideicomisoId());
			
			listFormasliquidacionMAP.add(formasliquidacionMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listFormasliquidacionMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un formasliquidacion.
	 * @param id.
	 * @return Formasliquidacion.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/formasliquidacion/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_FORMASLIQUIDACION:READ')")
	public @ResponseBody  Map<String, Object> getFormasLiquidacion(@PathVariable("id") String id) {	        
	        Formasliquidacion formasliquidacion = null;
	        
	        UUID uuid = UUID.fromString(id);
	        formasliquidacion = formasliquidacionService.getFormasliquidacion(uuid);
	        
			Map<String, Object> formasliquidacionMAP = new HashMap<>();
			formasliquidacionMAP.put("id", formasliquidacion.getFormasliquidacionId());
			formasliquidacionMAP.put("participante", formasliquidacion.getParticipante());
			formasliquidacionMAP.put("tipo", formasliquidacion.getTipo());
			formasliquidacionMAP.put("fideicomisario", formasliquidacion.getFideicomisario());
			formasliquidacionMAP.put("formaliquidacion", formasliquidacion.getFormaliquidacion());
			formasliquidacionMAP.put("moneda", formasliquidacion.getMoneda());
			formasliquidacionMAP.put("seccuentaseleccionada", formasliquidacion.getSeccuentaseleccionada());
			formasliquidacionMAP.put("plprincipal", formasliquidacion.getPlprincipal());
			formasliquidacionMAP.put("estado", formasliquidacion.getEstado());
			formasliquidacionMAP.put("secparamliq", formasliquidacion.getSecparamliq());
			formasliquidacionMAP.put("fideicomisoId", formasliquidacion.getFideicomisoId());
	        
			return formasliquidacionMAP;
	 }
	
}
