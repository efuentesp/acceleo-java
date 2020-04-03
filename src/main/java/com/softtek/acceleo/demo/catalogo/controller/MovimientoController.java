
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Movimientos. 
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

import com.softtek.acceleo.demo.catalogo.bean.MovimientoBean;
import com.softtek.acceleo.demo.domain.Movimiento;
import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.MovimientoService;
import com.softtek.acceleo.demo.service.SubfisoService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase MovimientoController.
 * @author PSG.
 *
 */
@RestController
public class MovimientoController {

	@Autowired
	private MovimientoService movimientoService;
	
@Autowired
private SubfisoService subfisoService;
@Autowired
private FideicomisoService fideicomisoService;
	
	Movimiento movimiento = new Movimiento();
	/************************************** CREATE  **************************************
	 * Crea un nuevo movimiento.
	 * @param movimiento.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/movimiento", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_MOVIMIENTO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createMovimiento(@RequestBody MovimientoBean movimientoBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Movimiento movimiento = new Movimiento();
	   	
	   			Subfiso subfiso = subfisoService.getSubfiso(movimientoBean.getSubfisoId());
	   			movimiento.setSubfisoId(subfiso);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(movimientoBean.getFideicomisoId());
	   			movimiento.setFideicomisoId(fideicomiso);
	   		
	movimiento.setFechacontable(movimientoBean.getFechacontable());
	movimiento.setFechaalta(movimientoBean.getFechaalta());
	movimiento.setOperacion(movimientoBean.getOperacion());
	movimiento.setFolio(movimientoBean.getFolio());
	movimiento.setTransaccion(movimientoBean.getTransaccion());
	movimiento.setDescripcion(movimientoBean.getDescripcion());
	movimiento.setImporte(movimientoBean.getImporte());
	movimiento.setUsuario(movimientoBean.getUsuario());
	movimiento.setEstatus(movimientoBean.getEstatus());
	movimiento.setFactura(movimientoBean.getFactura());
	   		
	        movimientoService.addMovimiento(movimiento);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> movimientoMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(movimientoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Movimiento no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un movimiento.
	  * @param id.
	  * @param movimiento.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/movimiento/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_MOVIMIENTO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarMovimiento(
				@PathVariable("id") String id, 
				@RequestBody MovimientoBean movimientoBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Movimiento movimientoFound = movimientoService.getMovimiento(uuid);
	         
	    if (movimientoFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Subfiso subfiso = subfisoService.getSubfiso(movimientoBean.getSubfisoId());
	   			movimiento.setSubfisoId(subfiso);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(movimientoBean.getFideicomisoId());
	   			movimiento.setFideicomisoId(fideicomiso);
	   		
	movimiento.setFechacontable(movimientoBean.getFechacontable());
	movimiento.setFechaalta(movimientoBean.getFechaalta());
	movimiento.setOperacion(movimientoBean.getOperacion());
	movimiento.setFolio(movimientoBean.getFolio());
	movimiento.setTransaccion(movimientoBean.getTransaccion());
	movimiento.setDescripcion(movimientoBean.getDescripcion());
	movimiento.setImporte(movimientoBean.getImporte());
	movimiento.setUsuario(movimientoBean.getUsuario());
	movimiento.setEstatus(movimientoBean.getEstatus());
	movimiento.setFactura(movimientoBean.getFactura());
	
		movimiento.setMovimientoId(movimientoFound.getMovimientoId());
		movimientoService.editMovimiento(movimiento);
		
		Map<String, Object> movimientoMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(movimientoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un movimiento.
	 * @param id.
	 * @return ResponseEntity<Movimiento>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/movimiento/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_MOVIMIENTO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteMovimiento(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Movimiento movimiento = movimientoService.getMovimiento(uuid);
		if (movimiento == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			movimientoService.deleteMovimiento(movimiento);
			
			Map<String, Object> movimientoMAP = new HashMap<>();
			movimientoMAP.put("id", movimiento.getMovimientoId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(movimientoMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Movimiento no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los movimientos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Movimiento>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/movimiento", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_MOVIMIENTO:READ')")
	public @ResponseBody  List<Map<String, Object>> getMovimientos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Movimiento> listMovimiento = null;
	
		if (query==null && _page == 0) {
			listMovimiento = movimientoService.listMovimientos(movimiento);
			rows = movimientoService.getTotalRows();
		} else if (query!= null){
			listMovimiento = movimientoService.listMovimientosQuery(movimiento, query, _page, 10);
			rows = movimientoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listMovimiento = movimientoService.listMovimientosPagination(movimiento, _page, 10);
			rows = movimientoService.getTotalRows();
		}
		
		List<Map<String, Object>> listMovimientoMAP = new ArrayList<>();
		for( Movimiento movimiento : listMovimiento ){
			Map<String, Object> movimientoMAP = new HashMap<>();
			movimientoMAP.put("id", movimiento.getMovimientoId());
			movimientoMAP.put("fechacontable", movimiento.getFechacontable());
			movimientoMAP.put("fechaalta", movimiento.getFechaalta());
			movimientoMAP.put("operacion", movimiento.getOperacion());
			movimientoMAP.put("folio", movimiento.getFolio());
			movimientoMAP.put("transaccion", movimiento.getTransaccion());
			movimientoMAP.put("descripcion", movimiento.getDescripcion());
			movimientoMAP.put("importe", movimiento.getImporte());
			movimientoMAP.put("usuario", movimiento.getUsuario());
			movimientoMAP.put("estatus", movimiento.getEstatus());
			movimientoMAP.put("factura", movimiento.getFactura());
			movimientoMAP.put("subfisoId", movimiento.getSubfisoId().getSubfisoId());
			movimientoMAP.put("fideicomisoId", movimiento.getFideicomisoId().getFideicomisoId());
			
			listMovimientoMAP.add(movimientoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listMovimientoMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un movimiento.
	 * @param id.
	 * @return Movimiento.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/movimiento/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_MOVIMIENTO:READ')")
	public @ResponseBody  Map<String, Object> getMovimiento(@PathVariable("id") String id) {	        
	        Movimiento movimiento = null;
	        
	        UUID uuid = UUID.fromString(id);
	        movimiento = movimientoService.getMovimiento(uuid);
	        
			Map<String, Object> movimientoMAP = new HashMap<>();
			movimientoMAP.put("id", movimiento.getMovimientoId());
			movimientoMAP.put("fechacontable", movimiento.getFechacontable());
			movimientoMAP.put("fechaalta", movimiento.getFechaalta());
			movimientoMAP.put("operacion", movimiento.getOperacion());
			movimientoMAP.put("folio", movimiento.getFolio());
			movimientoMAP.put("transaccion", movimiento.getTransaccion());
			movimientoMAP.put("descripcion", movimiento.getDescripcion());
			movimientoMAP.put("importe", movimiento.getImporte());
			movimientoMAP.put("usuario", movimiento.getUsuario());
			movimientoMAP.put("estatus", movimiento.getEstatus());
			movimientoMAP.put("factura", movimiento.getFactura());
			movimientoMAP.put("subfisoId", movimiento.getSubfisoId());
			movimientoMAP.put("fideicomisoId", movimiento.getFideicomisoId());
	        
			return movimientoMAP;
	 }
	
}
