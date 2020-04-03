
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los VentaDirectos. 
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

import com.softtek.acceleo.demo.catalogo.bean.VentadirectoBean;
import com.softtek.acceleo.demo.domain.Ventadirecto;
import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.domain.Contratoinversion;
import com.softtek.acceleo.demo.domain.Instruccion;

import com.softtek.acceleo.demo.service.VentadirectoService;
import com.softtek.acceleo.demo.service.SubfisoService;
import com.softtek.acceleo.demo.service.FideicomisoService;
import com.softtek.acceleo.demo.service.ContratoinversionService;
import com.softtek.acceleo.demo.service.InstruccionService;

/**
 * Clase VentadirectoController.
 * @author PSG.
 *
 */
@RestController
public class VentadirectoController {

	@Autowired
	private VentadirectoService ventadirectoService;
	
@Autowired
private SubfisoService subfisoService;
@Autowired
private FideicomisoService fideicomisoService;
@Autowired
private ContratoinversionService contratoinversionService;
@Autowired
private InstruccionService instruccionService;
	
	Ventadirecto ventadirecto = new Ventadirecto();
	/************************************** CREATE  **************************************
	 * Crea un nuevo ventadirecto.
	 * @param ventadirecto.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/ventadirecto", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_VENTADIRECTO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createVentadirecto(@RequestBody VentadirectoBean ventadirectoBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Ventadirecto ventadirecto = new Ventadirecto();
	   	
	   			Subfiso subfiso = subfisoService.getSubfiso(ventadirectoBean.getSubfisoId());
	   			ventadirecto.setSubfisoId(subfiso);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(ventadirectoBean.getFideicomisoId());
	   			ventadirecto.setFideicomisoId(fideicomiso);
	   			Contratoinversion contratoinversion = contratoinversionService.getContratoinversion(ventadirectoBean.getContratoinversionId());
	   			ventadirecto.setContratoinversionId(contratoinversion);
	   			Instruccion instruccion = instruccionService.getInstruccion(ventadirectoBean.getInstruccionId());
	   			ventadirecto.setInstruccionId(instruccion);
	   		
	ventadirecto.setFechavalor(ventadirectoBean.getFechavalor());
	ventadirecto.setTitulosgarantia(ventadirectoBean.getTitulosgarantia());
	ventadirecto.setOperacionfutura(ventadirectoBean.getOperacionfutura());
	ventadirecto.setFechaoperacion(ventadirectoBean.getFechaoperacion());
	ventadirecto.setActivos(ventadirectoBean.getActivos());
	ventadirecto.setTipomovimiento(ventadirectoBean.getTipomovimiento());
	ventadirecto.setImporte(ventadirectoBean.getImporte());
	ventadirecto.setCustodio(ventadirectoBean.getCustodio());
	ventadirecto.setComision(ventadirectoBean.getComision());
	ventadirecto.setMercado(ventadirectoBean.getMercado());
	ventadirecto.setInstrumento(ventadirectoBean.getInstrumento());
	ventadirecto.setIsr(ventadirectoBean.getIsr());
	ventadirecto.setMoneda(ventadirectoBean.getMoneda());
	ventadirecto.setFechaliquidacion(ventadirectoBean.getFechaliquidacion());
	ventadirecto.setEmisiones(ventadirectoBean.getEmisiones());
	ventadirecto.setSerie(ventadirectoBean.getSerie());
	ventadirecto.setNotitulos(ventadirectoBean.getNotitulos());
	ventadirecto.setPrecio(ventadirectoBean.getPrecio());
	ventadirecto.setDesccomplementaria(ventadirectoBean.getDesccomplementaria());
	ventadirecto.setIntereses(ventadirectoBean.getIntereses());
	ventadirecto.setPizarra(ventadirectoBean.getPizarra());
	ventadirecto.setCupon(ventadirectoBean.getCupon());
	   		
	        ventadirectoService.addVentadirecto(ventadirecto);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> ventadirectoMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(ventadirectoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "VentaDirecto no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un ventadirecto.
	  * @param id.
	  * @param ventadirecto.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/ventadirecto/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_VENTADIRECTO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarVentaDirecto(
				@PathVariable("id") String id, 
				@RequestBody VentadirectoBean ventadirectoBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Ventadirecto ventadirectoFound = ventadirectoService.getVentadirecto(uuid);
	         
	    if (ventadirectoFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Subfiso subfiso = subfisoService.getSubfiso(ventadirectoBean.getSubfisoId());
	   			ventadirecto.setSubfisoId(subfiso);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(ventadirectoBean.getFideicomisoId());
	   			ventadirecto.setFideicomisoId(fideicomiso);
	   			Contratoinversion contratoinversion = contratoinversionService.getContratoinversion(ventadirectoBean.getContratoinversionId());
	   			ventadirecto.setContratoinversionId(contratoinversion);
	   			Instruccion instruccion = instruccionService.getInstruccion(ventadirectoBean.getInstruccionId());
	   			ventadirecto.setInstruccionId(instruccion);
	   		
	ventadirecto.setFechavalor(ventadirectoBean.getFechavalor());
	ventadirecto.setTitulosgarantia(ventadirectoBean.getTitulosgarantia());
	ventadirecto.setOperacionfutura(ventadirectoBean.getOperacionfutura());
	ventadirecto.setFechaoperacion(ventadirectoBean.getFechaoperacion());
	ventadirecto.setActivos(ventadirectoBean.getActivos());
	ventadirecto.setTipomovimiento(ventadirectoBean.getTipomovimiento());
	ventadirecto.setImporte(ventadirectoBean.getImporte());
	ventadirecto.setCustodio(ventadirectoBean.getCustodio());
	ventadirecto.setComision(ventadirectoBean.getComision());
	ventadirecto.setMercado(ventadirectoBean.getMercado());
	ventadirecto.setInstrumento(ventadirectoBean.getInstrumento());
	ventadirecto.setIsr(ventadirectoBean.getIsr());
	ventadirecto.setMoneda(ventadirectoBean.getMoneda());
	ventadirecto.setFechaliquidacion(ventadirectoBean.getFechaliquidacion());
	ventadirecto.setEmisiones(ventadirectoBean.getEmisiones());
	ventadirecto.setSerie(ventadirectoBean.getSerie());
	ventadirecto.setNotitulos(ventadirectoBean.getNotitulos());
	ventadirecto.setPrecio(ventadirectoBean.getPrecio());
	ventadirecto.setDesccomplementaria(ventadirectoBean.getDesccomplementaria());
	ventadirecto.setIntereses(ventadirectoBean.getIntereses());
	ventadirecto.setPizarra(ventadirectoBean.getPizarra());
	ventadirecto.setCupon(ventadirectoBean.getCupon());
	
		ventadirecto.setVentadirectoId(ventadirectoFound.getVentadirectoId());
		ventadirectoService.editVentadirecto(ventadirecto);
		
		Map<String, Object> ventadirectoMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(ventadirectoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un ventadirecto.
	 * @param id.
	 * @return ResponseEntity<Ventadirecto>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/ventadirecto/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_VENTADIRECTO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteVentaDirecto(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Ventadirecto ventadirecto = ventadirectoService.getVentadirecto(uuid);
		if (ventadirecto == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			ventadirectoService.deleteVentadirecto(ventadirecto);
			
			Map<String, Object> ventadirectoMAP = new HashMap<>();
			ventadirectoMAP.put("id", ventadirecto.getVentadirectoId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(ventadirectoMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Ventadirecto no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los ventadirectos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Ventadirecto>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/ventadirecto", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_VENTADIRECTO:READ')")
	public @ResponseBody  List<Map<String, Object>> getVentaDirectos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Ventadirecto> listVentadirecto = null;
	
		if (query==null && _page == 0) {
			listVentadirecto = ventadirectoService.listVentadirectos(ventadirecto);
			rows = ventadirectoService.getTotalRows();
		} else if (query!= null){
			listVentadirecto = ventadirectoService.listVentadirectosQuery(ventadirecto, query, _page, 10);
			rows = ventadirectoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listVentadirecto = ventadirectoService.listVentadirectosPagination(ventadirecto, _page, 10);
			rows = ventadirectoService.getTotalRows();
		}
		
		List<Map<String, Object>> listVentadirectoMAP = new ArrayList<>();
		for( Ventadirecto ventadirecto : listVentadirecto ){
			Map<String, Object> ventadirectoMAP = new HashMap<>();
			ventadirectoMAP.put("id", ventadirecto.getVentadirectoId());
			ventadirectoMAP.put("fechavalor", ventadirecto.getFechavalor());
			ventadirectoMAP.put("titulosgarantia", ventadirecto.getTitulosgarantia());
			ventadirectoMAP.put("operacionfutura", ventadirecto.getOperacionfutura());
			ventadirectoMAP.put("fechaoperacion", ventadirecto.getFechaoperacion());
			ventadirectoMAP.put("activos", ventadirecto.getActivos());
			ventadirectoMAP.put("tipomovimiento", ventadirecto.getTipomovimiento());
			ventadirectoMAP.put("importe", ventadirecto.getImporte());
			ventadirectoMAP.put("custodio", ventadirecto.getCustodio());
			ventadirectoMAP.put("comision", ventadirecto.getComision());
			ventadirectoMAP.put("mercado", ventadirecto.getMercado());
			ventadirectoMAP.put("instrumento", ventadirecto.getInstrumento());
			ventadirectoMAP.put("isr", ventadirecto.getIsr());
			ventadirectoMAP.put("moneda", ventadirecto.getMoneda());
			ventadirectoMAP.put("fechaliquidacion", ventadirecto.getFechaliquidacion());
			ventadirectoMAP.put("emisiones", ventadirecto.getEmisiones());
			ventadirectoMAP.put("serie", ventadirecto.getSerie());
			ventadirectoMAP.put("notitulos", ventadirecto.getNotitulos());
			ventadirectoMAP.put("precio", ventadirecto.getPrecio());
			ventadirectoMAP.put("desccomplementaria", ventadirecto.getDesccomplementaria());
			ventadirectoMAP.put("intereses", ventadirecto.getIntereses());
			ventadirectoMAP.put("pizarra", ventadirecto.getPizarra());
			ventadirectoMAP.put("cupon", ventadirecto.getCupon());
			ventadirectoMAP.put("subfisoId", ventadirecto.getSubfisoId().getSubfisoId());
			ventadirectoMAP.put("fideicomisoId", ventadirecto.getFideicomisoId().getFideicomisoId());
			ventadirectoMAP.put("contratoinversionId", ventadirecto.getContratoinversionId().getContratoinversionId());
			ventadirectoMAP.put("instruccionId", ventadirecto.getInstruccionId().getInstruccionId());
			
			listVentadirectoMAP.add(ventadirectoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listVentadirectoMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un ventadirecto.
	 * @param id.
	 * @return Ventadirecto.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/ventadirecto/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_VENTADIRECTO:READ')")
	public @ResponseBody  Map<String, Object> getVentaDirecto(@PathVariable("id") String id) {	        
	        Ventadirecto ventadirecto = null;
	        
	        UUID uuid = UUID.fromString(id);
	        ventadirecto = ventadirectoService.getVentadirecto(uuid);
	        
			Map<String, Object> ventadirectoMAP = new HashMap<>();
			ventadirectoMAP.put("id", ventadirecto.getVentadirectoId());
			ventadirectoMAP.put("fechavalor", ventadirecto.getFechavalor());
			ventadirectoMAP.put("titulosgarantia", ventadirecto.getTitulosgarantia());
			ventadirectoMAP.put("operacionfutura", ventadirecto.getOperacionfutura());
			ventadirectoMAP.put("fechaoperacion", ventadirecto.getFechaoperacion());
			ventadirectoMAP.put("activos", ventadirecto.getActivos());
			ventadirectoMAP.put("tipomovimiento", ventadirecto.getTipomovimiento());
			ventadirectoMAP.put("importe", ventadirecto.getImporte());
			ventadirectoMAP.put("custodio", ventadirecto.getCustodio());
			ventadirectoMAP.put("comision", ventadirecto.getComision());
			ventadirectoMAP.put("mercado", ventadirecto.getMercado());
			ventadirectoMAP.put("instrumento", ventadirecto.getInstrumento());
			ventadirectoMAP.put("isr", ventadirecto.getIsr());
			ventadirectoMAP.put("moneda", ventadirecto.getMoneda());
			ventadirectoMAP.put("fechaliquidacion", ventadirecto.getFechaliquidacion());
			ventadirectoMAP.put("emisiones", ventadirecto.getEmisiones());
			ventadirectoMAP.put("serie", ventadirecto.getSerie());
			ventadirectoMAP.put("notitulos", ventadirecto.getNotitulos());
			ventadirectoMAP.put("precio", ventadirecto.getPrecio());
			ventadirectoMAP.put("desccomplementaria", ventadirecto.getDesccomplementaria());
			ventadirectoMAP.put("intereses", ventadirecto.getIntereses());
			ventadirectoMAP.put("pizarra", ventadirecto.getPizarra());
			ventadirectoMAP.put("cupon", ventadirecto.getCupon());
			ventadirectoMAP.put("subfisoId", ventadirecto.getSubfisoId());
			ventadirectoMAP.put("fideicomisoId", ventadirecto.getFideicomisoId());
			ventadirectoMAP.put("contratoinversionId", ventadirecto.getContratoinversionId());
			ventadirectoMAP.put("instruccionId", ventadirecto.getInstruccionId());
	        
			return ventadirectoMAP;
	 }
	
}
