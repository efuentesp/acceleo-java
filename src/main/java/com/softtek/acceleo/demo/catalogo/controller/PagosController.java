
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Pagoss. 
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

import com.softtek.acceleo.demo.catalogo.bean.PagosBean;
import com.softtek.acceleo.demo.domain.Pagos;
import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Instruccion;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.PagosService;
import com.softtek.acceleo.demo.service.SubfisoService;
import com.softtek.acceleo.demo.service.InstruccionService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase PagosController.
 * @author PSG.
 *
 */
@RestController
public class PagosController {

	@Autowired
	private PagosService pagosService;
	
@Autowired
private SubfisoService subfisoService;
@Autowired
private InstruccionService instruccionService;
@Autowired
private FideicomisoService fideicomisoService;
	
	Pagos pagos = new Pagos();
	/************************************** CREATE  **************************************
	 * Crea un nuevo pagos.
	 * @param pagos.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/pagos", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_PAGOS:CREATE')")
	 public ResponseEntity<Map<String, Object>> createPagos(@RequestBody PagosBean pagosBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Pagos pagos = new Pagos();
	   	
	   			Subfiso subfiso = subfisoService.getSubfiso(pagosBean.getSubfisoId());
	   			pagos.setSubfisoId(subfiso);
	   			Instruccion instruccion = instruccionService.getInstruccion(pagosBean.getInstruccionId());
	   			pagos.setInstruccionId(instruccion);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(pagosBean.getFideicomisoId());
	   			pagos.setFideicomisoId(fideicomiso);
	   		
	pagos.setImporteinstruccion(pagosBean.getImporteinstruccion());
	pagos.setMovimientos(pagosBean.getMovimientos());
	pagos.setTipopersona(pagosBean.getTipopersona());
	pagos.setConceptopago(pagosBean.getConceptopago());
	pagos.setClave(pagosBean.getClave());
	pagos.setNombre(pagosBean.getNombre());
	pagos.setFormaliquidacion(pagosBean.getFormaliquidacion());
	pagos.setTipopago(pagosBean.getTipopago());
	pagos.setDatosconcentradora(pagosBean.getDatosconcentradora());
	pagos.setDescripcioncomplementaria(pagosBean.getDescripcioncomplementaria());
	pagos.setImportetotal(pagosBean.getImportetotal());
	pagos.setEstatusoperacion(pagosBean.getEstatusoperacion());
	pagos.setImporte(pagosBean.getImporte());
	pagos.setFechaliquidar(pagosBean.getFechaliquidar());
	pagos.setEstatus(pagosBean.getEstatus());
	   		
	        pagosService.addPagos(pagos);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> pagosMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(pagosMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Pagos no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un pagos.
	  * @param id.
	  * @param pagos.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/pagos/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_PAGOS:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarPagos(
				@PathVariable("id") String id, 
				@RequestBody PagosBean pagosBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Pagos pagosFound = pagosService.getPagos(uuid);
	         
	    if (pagosFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Subfiso subfiso = subfisoService.getSubfiso(pagosBean.getSubfisoId());
	   			pagos.setSubfisoId(subfiso);
	   			Instruccion instruccion = instruccionService.getInstruccion(pagosBean.getInstruccionId());
	   			pagos.setInstruccionId(instruccion);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(pagosBean.getFideicomisoId());
	   			pagos.setFideicomisoId(fideicomiso);
	   		
	pagos.setImporteinstruccion(pagosBean.getImporteinstruccion());
	pagos.setMovimientos(pagosBean.getMovimientos());
	pagos.setTipopersona(pagosBean.getTipopersona());
	pagos.setConceptopago(pagosBean.getConceptopago());
	pagos.setClave(pagosBean.getClave());
	pagos.setNombre(pagosBean.getNombre());
	pagos.setFormaliquidacion(pagosBean.getFormaliquidacion());
	pagos.setTipopago(pagosBean.getTipopago());
	pagos.setDatosconcentradora(pagosBean.getDatosconcentradora());
	pagos.setDescripcioncomplementaria(pagosBean.getDescripcioncomplementaria());
	pagos.setImportetotal(pagosBean.getImportetotal());
	pagos.setEstatusoperacion(pagosBean.getEstatusoperacion());
	pagos.setImporte(pagosBean.getImporte());
	pagos.setFechaliquidar(pagosBean.getFechaliquidar());
	pagos.setEstatus(pagosBean.getEstatus());
	
		pagos.setPagosId(pagosFound.getPagosId());
		pagosService.editPagos(pagos);
		
		Map<String, Object> pagosMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(pagosMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un pagos.
	 * @param id.
	 * @return ResponseEntity<Pagos>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/pagos/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_PAGOS:DELETE')")  
	public ResponseEntity<Map<String, Object>> deletePagos(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Pagos pagos = pagosService.getPagos(uuid);
		if (pagos == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			pagosService.deletePagos(pagos);
			
			Map<String, Object> pagosMAP = new HashMap<>();
			pagosMAP.put("id", pagos.getPagosId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(pagosMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Pagos no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los pagoss.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Pagos>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/pagos", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_PAGOS:READ')")
	public @ResponseBody  List<Map<String, Object>> getPagoss(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Pagos> listPagos = null;
	
		if (query==null && _page == 0) {
			listPagos = pagosService.listPagoss(pagos);
			rows = pagosService.getTotalRows();
		} else if (query!= null){
			listPagos = pagosService.listPagossQuery(pagos, query, _page, 10);
			rows = pagosService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listPagos = pagosService.listPagossPagination(pagos, _page, 10);
			rows = pagosService.getTotalRows();
		}
		
		List<Map<String, Object>> listPagosMAP = new ArrayList<>();
		for( Pagos pagos : listPagos ){
			Map<String, Object> pagosMAP = new HashMap<>();
			pagosMAP.put("id", pagos.getPagosId());
			pagosMAP.put("importeinstruccion", pagos.getImporteinstruccion());
			pagosMAP.put("movimientos", pagos.getMovimientos());
			pagosMAP.put("tipopersona", pagos.getTipopersona());
			pagosMAP.put("conceptopago", pagos.getConceptopago());
			pagosMAP.put("clave", pagos.getClave());
			pagosMAP.put("nombre", pagos.getNombre());
			pagosMAP.put("formaliquidacion", pagos.getFormaliquidacion());
			pagosMAP.put("tipopago", pagos.getTipopago());
			pagosMAP.put("datosconcentradora", pagos.getDatosconcentradora());
			pagosMAP.put("descripcioncomplementaria", pagos.getDescripcioncomplementaria());
			pagosMAP.put("importetotal", pagos.getImportetotal());
			pagosMAP.put("estatusoperacion", pagos.getEstatusoperacion());
			pagosMAP.put("importe", pagos.getImporte());
			pagosMAP.put("fechaliquidar", pagos.getFechaliquidar());
			pagosMAP.put("estatus", pagos.getEstatus());
			pagosMAP.put("subfisoId", pagos.getSubfisoId().getSubfisoId());
			pagosMAP.put("instruccionId", pagos.getInstruccionId().getInstruccionId());
			pagosMAP.put("fideicomisoId", pagos.getFideicomisoId().getFideicomisoId());
			
			listPagosMAP.add(pagosMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listPagosMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un pagos.
	 * @param id.
	 * @return Pagos.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/pagos/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_PAGOS:READ')")
	public @ResponseBody  Map<String, Object> getPagos(@PathVariable("id") String id) {	        
	        Pagos pagos = null;
	        
	        UUID uuid = UUID.fromString(id);
	        pagos = pagosService.getPagos(uuid);
	        
			Map<String, Object> pagosMAP = new HashMap<>();
			pagosMAP.put("id", pagos.getPagosId());
			pagosMAP.put("importeinstruccion", pagos.getImporteinstruccion());
			pagosMAP.put("movimientos", pagos.getMovimientos());
			pagosMAP.put("tipopersona", pagos.getTipopersona());
			pagosMAP.put("conceptopago", pagos.getConceptopago());
			pagosMAP.put("clave", pagos.getClave());
			pagosMAP.put("nombre", pagos.getNombre());
			pagosMAP.put("formaliquidacion", pagos.getFormaliquidacion());
			pagosMAP.put("tipopago", pagos.getTipopago());
			pagosMAP.put("datosconcentradora", pagos.getDatosconcentradora());
			pagosMAP.put("descripcioncomplementaria", pagos.getDescripcioncomplementaria());
			pagosMAP.put("importetotal", pagos.getImportetotal());
			pagosMAP.put("estatusoperacion", pagos.getEstatusoperacion());
			pagosMAP.put("importe", pagos.getImporte());
			pagosMAP.put("fechaliquidar", pagos.getFechaliquidar());
			pagosMAP.put("estatus", pagos.getEstatus());
			pagosMAP.put("subfisoId", pagos.getSubfisoId());
			pagosMAP.put("instruccionId", pagos.getInstruccionId());
			pagosMAP.put("fideicomisoId", pagos.getFideicomisoId());
	        
			return pagosMAP;
	 }
	
}
