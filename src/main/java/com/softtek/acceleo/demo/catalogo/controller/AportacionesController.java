
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Aportacioness. 
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

import com.softtek.acceleo.demo.catalogo.bean.AportacionesBean;
import com.softtek.acceleo.demo.domain.Aportaciones;
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.domain.Instruccion;
import com.softtek.acceleo.demo.domain.Subfiso;

import com.softtek.acceleo.demo.service.AportacionesService;
import com.softtek.acceleo.demo.service.FideicomisoService;
import com.softtek.acceleo.demo.service.InstruccionService;
import com.softtek.acceleo.demo.service.SubfisoService;

/**
 * Clase AportacionesController.
 * @author PSG.
 *
 */
@RestController
public class AportacionesController {

	@Autowired
	private AportacionesService aportacionesService;
	
@Autowired
private FideicomisoService fideicomisoService;
@Autowired
private InstruccionService instruccionService;
@Autowired
private SubfisoService subfisoService;
	
	Aportaciones aportaciones = new Aportaciones();
	/************************************** CREATE  **************************************
	 * Crea un nuevo aportaciones.
	 * @param aportaciones.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/aportaciones", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_APORTACIONES:CREATE')")
	 public ResponseEntity<Map<String, Object>> createAportaciones(@RequestBody AportacionesBean aportacionesBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Aportaciones aportaciones = new Aportaciones();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(aportacionesBean.getFideicomisoId());
	   			aportaciones.setFideicomisoId(fideicomiso);
	   			Instruccion instruccion = instruccionService.getInstruccion(aportacionesBean.getInstruccionId());
	   			aportaciones.setInstruccionId(instruccion);
	   			Subfiso subfiso = subfisoService.getSubfiso(aportacionesBean.getSubfisoId());
	   			aportaciones.setSubfisoId(subfiso);
	   		
	aportaciones.setTotalimporte(aportacionesBean.getTotalimporte());
	aportaciones.setDestinorecepcion(aportacionesBean.getDestinorecepcion());
	aportaciones.setEstatus(aportacionesBean.getEstatus());
	aportaciones.setMoneda(aportacionesBean.getMoneda());
	aportaciones.setFormarecepcion(aportacionesBean.getFormarecepcion());
	aportaciones.setEstatusoperacion(aportacionesBean.getEstatusoperacion());
	aportaciones.setTipopersona(aportacionesBean.getTipopersona());
	aportaciones.setFechacontabilizacion(aportacionesBean.getFechacontabilizacion());
	aportaciones.setNombre(aportacionesBean.getNombre());
	aportaciones.setDescripcioncomplementaria(aportacionesBean.getDescripcioncomplementaria());
	aportaciones.setNombrefideicomiso(aportacionesBean.getNombrefideicomiso());
	aportaciones.setEventos(aportacionesBean.getEventos());
	aportaciones.setTotalaplicado(aportacionesBean.getTotalaplicado());
	aportaciones.setImporterecepcion(aportacionesBean.getImporterecepcion());
	aportaciones.setOrigenrecursos(aportacionesBean.getOrigenrecursos());
	   		
	        aportacionesService.addAportaciones(aportaciones);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> aportacionesMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(aportacionesMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Aportaciones no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un aportaciones.
	  * @param id.
	  * @param aportaciones.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/aportaciones/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_APORTACIONES:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarAportaciones(
				@PathVariable("id") String id, 
				@RequestBody AportacionesBean aportacionesBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Aportaciones aportacionesFound = aportacionesService.getAportaciones(uuid);
	         
	    if (aportacionesFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(aportacionesBean.getFideicomisoId());
	   			aportaciones.setFideicomisoId(fideicomiso);
	   			Instruccion instruccion = instruccionService.getInstruccion(aportacionesBean.getInstruccionId());
	   			aportaciones.setInstruccionId(instruccion);
	   			Subfiso subfiso = subfisoService.getSubfiso(aportacionesBean.getSubfisoId());
	   			aportaciones.setSubfisoId(subfiso);
	   		
	aportaciones.setTotalimporte(aportacionesBean.getTotalimporte());
	aportaciones.setDestinorecepcion(aportacionesBean.getDestinorecepcion());
	aportaciones.setEstatus(aportacionesBean.getEstatus());
	aportaciones.setMoneda(aportacionesBean.getMoneda());
	aportaciones.setFormarecepcion(aportacionesBean.getFormarecepcion());
	aportaciones.setEstatusoperacion(aportacionesBean.getEstatusoperacion());
	aportaciones.setTipopersona(aportacionesBean.getTipopersona());
	aportaciones.setFechacontabilizacion(aportacionesBean.getFechacontabilizacion());
	aportaciones.setNombre(aportacionesBean.getNombre());
	aportaciones.setDescripcioncomplementaria(aportacionesBean.getDescripcioncomplementaria());
	aportaciones.setNombrefideicomiso(aportacionesBean.getNombrefideicomiso());
	aportaciones.setEventos(aportacionesBean.getEventos());
	aportaciones.setTotalaplicado(aportacionesBean.getTotalaplicado());
	aportaciones.setImporterecepcion(aportacionesBean.getImporterecepcion());
	aportaciones.setOrigenrecursos(aportacionesBean.getOrigenrecursos());
	
		aportaciones.setAportacionesId(aportacionesFound.getAportacionesId());
		aportacionesService.editAportaciones(aportaciones);
		
		Map<String, Object> aportacionesMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(aportacionesMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un aportaciones.
	 * @param id.
	 * @return ResponseEntity<Aportaciones>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/aportaciones/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_APORTACIONES:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteAportaciones(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Aportaciones aportaciones = aportacionesService.getAportaciones(uuid);
		if (aportaciones == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			aportacionesService.deleteAportaciones(aportaciones);
			
			Map<String, Object> aportacionesMAP = new HashMap<>();
			aportacionesMAP.put("id", aportaciones.getAportacionesId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(aportacionesMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Aportaciones no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los aportacioness.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Aportaciones>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/aportaciones", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_APORTACIONES:READ')")
	public @ResponseBody  List<Map<String, Object>> getAportacioness(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Aportaciones> listAportaciones = null;
	
		if (query==null && _page == 0) {
			listAportaciones = aportacionesService.listAportacioness(aportaciones);
			rows = aportacionesService.getTotalRows();
		} else if (query!= null){
			listAportaciones = aportacionesService.listAportacionessQuery(aportaciones, query, _page, 10);
			rows = aportacionesService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listAportaciones = aportacionesService.listAportacionessPagination(aportaciones, _page, 10);
			rows = aportacionesService.getTotalRows();
		}
		
		List<Map<String, Object>> listAportacionesMAP = new ArrayList<>();
		for( Aportaciones aportaciones : listAportaciones ){
			Map<String, Object> aportacionesMAP = new HashMap<>();
			aportacionesMAP.put("id", aportaciones.getAportacionesId());
			aportacionesMAP.put("totalimporte", aportaciones.getTotalimporte());
			aportacionesMAP.put("destinorecepcion", aportaciones.getDestinorecepcion());
			aportacionesMAP.put("estatus", aportaciones.getEstatus());
			aportacionesMAP.put("moneda", aportaciones.getMoneda());
			aportacionesMAP.put("formarecepcion", aportaciones.getFormarecepcion());
			aportacionesMAP.put("estatusoperacion", aportaciones.getEstatusoperacion());
			aportacionesMAP.put("tipopersona", aportaciones.getTipopersona());
			aportacionesMAP.put("fechacontabilizacion", aportaciones.getFechacontabilizacion());
			aportacionesMAP.put("nombre", aportaciones.getNombre());
			aportacionesMAP.put("descripcioncomplementaria", aportaciones.getDescripcioncomplementaria());
			aportacionesMAP.put("nombrefideicomiso", aportaciones.getNombrefideicomiso());
			aportacionesMAP.put("eventos", aportaciones.getEventos());
			aportacionesMAP.put("totalaplicado", aportaciones.getTotalaplicado());
			aportacionesMAP.put("importerecepcion", aportaciones.getImporterecepcion());
			aportacionesMAP.put("origenrecursos", aportaciones.getOrigenrecursos());
			aportacionesMAP.put("fideicomisoId", aportaciones.getFideicomisoId().getFideicomisoId());
			aportacionesMAP.put("instruccionId", aportaciones.getInstruccionId().getInstruccionId());
			aportacionesMAP.put("subfisoId", aportaciones.getSubfisoId().getSubfisoId());
			
			listAportacionesMAP.add(aportacionesMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listAportacionesMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un aportaciones.
	 * @param id.
	 * @return Aportaciones.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/aportaciones/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_APORTACIONES:READ')")
	public @ResponseBody  Map<String, Object> getAportaciones(@PathVariable("id") String id) {	        
	        Aportaciones aportaciones = null;
	        
	        UUID uuid = UUID.fromString(id);
	        aportaciones = aportacionesService.getAportaciones(uuid);
	        
			Map<String, Object> aportacionesMAP = new HashMap<>();
			aportacionesMAP.put("id", aportaciones.getAportacionesId());
			aportacionesMAP.put("totalimporte", aportaciones.getTotalimporte());
			aportacionesMAP.put("destinorecepcion", aportaciones.getDestinorecepcion());
			aportacionesMAP.put("estatus", aportaciones.getEstatus());
			aportacionesMAP.put("moneda", aportaciones.getMoneda());
			aportacionesMAP.put("formarecepcion", aportaciones.getFormarecepcion());
			aportacionesMAP.put("estatusoperacion", aportaciones.getEstatusoperacion());
			aportacionesMAP.put("tipopersona", aportaciones.getTipopersona());
			aportacionesMAP.put("fechacontabilizacion", aportaciones.getFechacontabilizacion());
			aportacionesMAP.put("nombre", aportaciones.getNombre());
			aportacionesMAP.put("descripcioncomplementaria", aportaciones.getDescripcioncomplementaria());
			aportacionesMAP.put("nombrefideicomiso", aportaciones.getNombrefideicomiso());
			aportacionesMAP.put("eventos", aportaciones.getEventos());
			aportacionesMAP.put("totalaplicado", aportaciones.getTotalaplicado());
			aportacionesMAP.put("importerecepcion", aportaciones.getImporterecepcion());
			aportacionesMAP.put("origenrecursos", aportaciones.getOrigenrecursos());
			aportacionesMAP.put("fideicomisoId", aportaciones.getFideicomisoId());
			aportacionesMAP.put("instruccionId", aportaciones.getInstruccionId());
			aportacionesMAP.put("subfisoId", aportaciones.getSubfisoId());
	        
			return aportacionesMAP;
	 }
	
}
