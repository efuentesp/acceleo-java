
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Instruccions. 
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

import com.softtek.acceleo.demo.catalogo.bean.InstruccionBean;
import com.softtek.acceleo.demo.domain.Instruccion;
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.domain.Subfiso;

import com.softtek.acceleo.demo.service.InstruccionService;
import com.softtek.acceleo.demo.service.FideicomisoService;
import com.softtek.acceleo.demo.service.SubfisoService;

/**
 * Clase InstruccionController.
 * @author PSG.
 *
 */
@RestController
public class InstruccionController {

	@Autowired
	private InstruccionService instruccionService;
	
@Autowired
private FideicomisoService fideicomisoService;
@Autowired
private SubfisoService subfisoService;
	
	Instruccion instruccion = new Instruccion();
	/************************************** CREATE  **************************************
	 * Crea un nuevo instruccion.
	 * @param instruccion.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/instruccion", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_INSTRUCCION:CREATE')")
	 public ResponseEntity<Map<String, Object>> createInstruccion(@RequestBody InstruccionBean instruccionBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Instruccion instruccion = new Instruccion();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(instruccionBean.getFideicomisoId());
	   			instruccion.setFideicomisoId(fideicomiso);
	   			Subfiso subfiso = subfisoService.getSubfiso(instruccionBean.getSubfisoId());
	   			instruccion.setSubfisoId(subfiso);
	   		
	instruccion.setFechahoracaptura(instruccionBean.getFechahoracaptura());
	instruccion.setFolio(instruccionBean.getFolio());
	instruccion.setFechadocumeto(instruccionBean.getFechadocumeto());
	instruccion.setClasificacion(instruccionBean.getClasificacion());
	instruccion.setPersonalidadsolicitante(instruccionBean.getPersonalidadsolicitante());
	instruccion.setFechacambioestatus(instruccionBean.getFechacambioestatus());
	instruccion.setSubtipoinstruccion(instruccionBean.getSubtipoinstruccion());
	instruccion.setImporte(instruccionBean.getImporte());
	instruccion.setImporteaplicado(instruccionBean.getImporteaplicado());
	instruccion.setNombrefideicomiso(instruccionBean.getNombrefideicomiso());
	instruccion.setNombresubfiso(instruccionBean.getNombresubfiso());
	instruccion.setTitularfideicomiso(instruccionBean.getTitularfideicomiso());
	instruccion.setFechacompromiso(instruccionBean.getFechacompromiso());
	instruccion.setFormarecepcion(instruccionBean.getFormarecepcion());
	instruccion.setEstatusinstruccion(instruccionBean.getEstatusinstruccion());
	instruccion.setTipoinstruccion(instruccionBean.getTipoinstruccion());
	instruccion.setMoneda(instruccionBean.getMoneda());
	instruccion.setNoeventos(instruccionBean.getNoeventos());
	instruccion.setNoefectuados(instruccionBean.getNoefectuados());
	instruccion.setInfocomplementaria(instruccionBean.getInfocomplementaria());
	   		
	        instruccionService.addInstruccion(instruccion);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> instruccionMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(instruccionMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Instruccion no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un instruccion.
	  * @param id.
	  * @param instruccion.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/instruccion/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_INSTRUCCION:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarInstruccion(
				@PathVariable("id") String id, 
				@RequestBody InstruccionBean instruccionBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Instruccion instruccionFound = instruccionService.getInstruccion(uuid);
	         
	    if (instruccionFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(instruccionBean.getFideicomisoId());
	   			instruccion.setFideicomisoId(fideicomiso);
	   			Subfiso subfiso = subfisoService.getSubfiso(instruccionBean.getSubfisoId());
	   			instruccion.setSubfisoId(subfiso);
	   		
	instruccion.setFechahoracaptura(instruccionBean.getFechahoracaptura());
	instruccion.setFolio(instruccionBean.getFolio());
	instruccion.setFechadocumeto(instruccionBean.getFechadocumeto());
	instruccion.setClasificacion(instruccionBean.getClasificacion());
	instruccion.setPersonalidadsolicitante(instruccionBean.getPersonalidadsolicitante());
	instruccion.setFechacambioestatus(instruccionBean.getFechacambioestatus());
	instruccion.setSubtipoinstruccion(instruccionBean.getSubtipoinstruccion());
	instruccion.setImporte(instruccionBean.getImporte());
	instruccion.setImporteaplicado(instruccionBean.getImporteaplicado());
	instruccion.setNombrefideicomiso(instruccionBean.getNombrefideicomiso());
	instruccion.setNombresubfiso(instruccionBean.getNombresubfiso());
	instruccion.setTitularfideicomiso(instruccionBean.getTitularfideicomiso());
	instruccion.setFechacompromiso(instruccionBean.getFechacompromiso());
	instruccion.setFormarecepcion(instruccionBean.getFormarecepcion());
	instruccion.setEstatusinstruccion(instruccionBean.getEstatusinstruccion());
	instruccion.setTipoinstruccion(instruccionBean.getTipoinstruccion());
	instruccion.setMoneda(instruccionBean.getMoneda());
	instruccion.setNoeventos(instruccionBean.getNoeventos());
	instruccion.setNoefectuados(instruccionBean.getNoefectuados());
	instruccion.setInfocomplementaria(instruccionBean.getInfocomplementaria());
	
		instruccion.setInstruccionId(instruccionFound.getInstruccionId());
		instruccionService.editInstruccion(instruccion);
		
		Map<String, Object> instruccionMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(instruccionMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un instruccion.
	 * @param id.
	 * @return ResponseEntity<Instruccion>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/instruccion/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_INSTRUCCION:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteInstruccion(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Instruccion instruccion = instruccionService.getInstruccion(uuid);
		if (instruccion == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			instruccionService.deleteInstruccion(instruccion);
			
			Map<String, Object> instruccionMAP = new HashMap<>();
			instruccionMAP.put("id", instruccion.getInstruccionId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(instruccionMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Instruccion no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los instruccions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Instruccion>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/instruccion", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_INSTRUCCION:READ')")
	public @ResponseBody  List<Map<String, Object>> getInstruccions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Instruccion> listInstruccion = null;
	
		if (query==null && _page == 0) {
			listInstruccion = instruccionService.listInstruccions(instruccion);
			rows = instruccionService.getTotalRows();
		} else if (query!= null){
			listInstruccion = instruccionService.listInstruccionsQuery(instruccion, query, _page, 10);
			rows = instruccionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listInstruccion = instruccionService.listInstruccionsPagination(instruccion, _page, 10);
			rows = instruccionService.getTotalRows();
		}
		
		List<Map<String, Object>> listInstruccionMAP = new ArrayList<>();
		for( Instruccion instruccion : listInstruccion ){
			Map<String, Object> instruccionMAP = new HashMap<>();
			instruccionMAP.put("id", instruccion.getInstruccionId());
			instruccionMAP.put("fechahoracaptura", instruccion.getFechahoracaptura());
			instruccionMAP.put("folio", instruccion.getFolio());
			instruccionMAP.put("fechadocumeto", instruccion.getFechadocumeto());
			instruccionMAP.put("clasificacion", instruccion.getClasificacion());
			instruccionMAP.put("personalidadsolicitante", instruccion.getPersonalidadsolicitante());
			instruccionMAP.put("fechacambioestatus", instruccion.getFechacambioestatus());
			instruccionMAP.put("subtipoinstruccion", instruccion.getSubtipoinstruccion());
			instruccionMAP.put("importe", instruccion.getImporte());
			instruccionMAP.put("importeaplicado", instruccion.getImporteaplicado());
			instruccionMAP.put("nombrefideicomiso", instruccion.getNombrefideicomiso());
			instruccionMAP.put("nombresubfiso", instruccion.getNombresubfiso());
			instruccionMAP.put("titularfideicomiso", instruccion.getTitularfideicomiso());
			instruccionMAP.put("fechacompromiso", instruccion.getFechacompromiso());
			instruccionMAP.put("formarecepcion", instruccion.getFormarecepcion());
			instruccionMAP.put("estatusinstruccion", instruccion.getEstatusinstruccion());
			instruccionMAP.put("tipoinstruccion", instruccion.getTipoinstruccion());
			instruccionMAP.put("moneda", instruccion.getMoneda());
			instruccionMAP.put("noeventos", instruccion.getNoeventos());
			instruccionMAP.put("noefectuados", instruccion.getNoefectuados());
			instruccionMAP.put("infocomplementaria", instruccion.getInfocomplementaria());
			instruccionMAP.put("fideicomisoId", instruccion.getFideicomisoId().getFideicomisoId());
			instruccionMAP.put("subfisoId", instruccion.getSubfisoId().getSubfisoId());
			
			listInstruccionMAP.add(instruccionMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listInstruccionMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un instruccion.
	 * @param id.
	 * @return Instruccion.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/instruccion/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_INSTRUCCION:READ')")
	public @ResponseBody  Map<String, Object> getInstruccion(@PathVariable("id") String id) {	        
	        Instruccion instruccion = null;
	        
	        UUID uuid = UUID.fromString(id);
	        instruccion = instruccionService.getInstruccion(uuid);
	        
			Map<String, Object> instruccionMAP = new HashMap<>();
			instruccionMAP.put("id", instruccion.getInstruccionId());
			instruccionMAP.put("fechahoracaptura", instruccion.getFechahoracaptura());
			instruccionMAP.put("folio", instruccion.getFolio());
			instruccionMAP.put("fechadocumeto", instruccion.getFechadocumeto());
			instruccionMAP.put("clasificacion", instruccion.getClasificacion());
			instruccionMAP.put("personalidadsolicitante", instruccion.getPersonalidadsolicitante());
			instruccionMAP.put("fechacambioestatus", instruccion.getFechacambioestatus());
			instruccionMAP.put("subtipoinstruccion", instruccion.getSubtipoinstruccion());
			instruccionMAP.put("importe", instruccion.getImporte());
			instruccionMAP.put("importeaplicado", instruccion.getImporteaplicado());
			instruccionMAP.put("nombrefideicomiso", instruccion.getNombrefideicomiso());
			instruccionMAP.put("nombresubfiso", instruccion.getNombresubfiso());
			instruccionMAP.put("titularfideicomiso", instruccion.getTitularfideicomiso());
			instruccionMAP.put("fechacompromiso", instruccion.getFechacompromiso());
			instruccionMAP.put("formarecepcion", instruccion.getFormarecepcion());
			instruccionMAP.put("estatusinstruccion", instruccion.getEstatusinstruccion());
			instruccionMAP.put("tipoinstruccion", instruccion.getTipoinstruccion());
			instruccionMAP.put("moneda", instruccion.getMoneda());
			instruccionMAP.put("noeventos", instruccion.getNoeventos());
			instruccionMAP.put("noefectuados", instruccion.getNoefectuados());
			instruccionMAP.put("infocomplementaria", instruccion.getInfocomplementaria());
			instruccionMAP.put("fideicomisoId", instruccion.getFideicomisoId());
			instruccionMAP.put("subfisoId", instruccion.getSubfisoId());
	        
			return instruccionMAP;
	 }
	
}
