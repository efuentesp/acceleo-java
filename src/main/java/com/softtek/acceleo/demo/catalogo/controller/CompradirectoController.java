
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los CompraDirectos. 
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

import com.softtek.acceleo.demo.catalogo.bean.CompradirectoBean;
import com.softtek.acceleo.demo.domain.Compradirecto;
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.domain.Instruccion;
import com.softtek.acceleo.demo.domain.Contratoinversion;
import com.softtek.acceleo.demo.domain.Subfiso;

import com.softtek.acceleo.demo.service.CompradirectoService;
import com.softtek.acceleo.demo.service.FideicomisoService;
import com.softtek.acceleo.demo.service.InstruccionService;
import com.softtek.acceleo.demo.service.ContratoinversionService;
import com.softtek.acceleo.demo.service.SubfisoService;

/**
 * Clase CompradirectoController.
 * @author PSG.
 *
 */
@RestController
public class CompradirectoController {

	@Autowired
	private CompradirectoService compradirectoService;
	
@Autowired
private FideicomisoService fideicomisoService;
@Autowired
private InstruccionService instruccionService;
@Autowired
private ContratoinversionService contratoinversionService;
@Autowired
private SubfisoService subfisoService;
	
	Compradirecto compradirecto = new Compradirecto();
	/************************************** CREATE  **************************************
	 * Crea un nuevo compradirecto.
	 * @param compradirecto.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/compradirecto", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_COMPRADIRECTO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createCompradirecto(@RequestBody CompradirectoBean compradirectoBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Compradirecto compradirecto = new Compradirecto();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(compradirectoBean.getFideicomisoId());
	   			compradirecto.setFideicomisoId(fideicomiso);
	   			Instruccion instruccion = instruccionService.getInstruccion(compradirectoBean.getInstruccionId());
	   			compradirecto.setInstruccionId(instruccion);
	   			Contratoinversion contratoinversion = contratoinversionService.getContratoinversion(compradirectoBean.getContratoinversionId());
	   			compradirecto.setContratoinversionId(contratoinversion);
	   			Subfiso subfiso = subfisoService.getSubfiso(compradirectoBean.getSubfisoId());
	   			compradirecto.setSubfisoId(subfiso);
	   		
	compradirecto.setFechavalor(compradirectoBean.getFechavalor());
	compradirecto.setTitulosgarantia(compradirectoBean.getTitulosgarantia());
	compradirecto.setOperacionfutura(compradirectoBean.getOperacionfutura());
	compradirecto.setFechaoperacion(compradirectoBean.getFechaoperacion());
	compradirecto.setActivos(compradirectoBean.getActivos());
	compradirecto.setTipomovimiento(compradirectoBean.getTipomovimiento());
	compradirecto.setImporte(compradirectoBean.getImporte());
	compradirecto.setCustodio(compradirectoBean.getCustodio());
	compradirecto.setComision(compradirectoBean.getComision());
	compradirecto.setMercado(compradirectoBean.getMercado());
	compradirecto.setInstrumento(compradirectoBean.getInstrumento());
	compradirecto.setIsr(compradirectoBean.getIsr());
	compradirecto.setMoneda(compradirectoBean.getMoneda());
	compradirecto.setFechaliquidacion(compradirectoBean.getFechaliquidacion());
	compradirecto.setEmisiones(compradirectoBean.getEmisiones());
	compradirecto.setSerie(compradirectoBean.getSerie());
	compradirecto.setNotitulos(compradirectoBean.getNotitulos());
	compradirecto.setPrecio(compradirectoBean.getPrecio());
	compradirecto.setDesccomplementaria(compradirectoBean.getDesccomplementaria());
	compradirecto.setIntereses(compradirectoBean.getIntereses());
	compradirecto.setPizarra(compradirectoBean.getPizarra());
	compradirecto.setCupon(compradirectoBean.getCupon());
	   		
	        compradirectoService.addCompradirecto(compradirecto);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> compradirectoMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(compradirectoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "CompraDirecto no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un compradirecto.
	  * @param id.
	  * @param compradirecto.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/compradirecto/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_COMPRADIRECTO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarCompraDirecto(
				@PathVariable("id") String id, 
				@RequestBody CompradirectoBean compradirectoBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Compradirecto compradirectoFound = compradirectoService.getCompradirecto(uuid);
	         
	    if (compradirectoFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(compradirectoBean.getFideicomisoId());
	   			compradirecto.setFideicomisoId(fideicomiso);
	   			Instruccion instruccion = instruccionService.getInstruccion(compradirectoBean.getInstruccionId());
	   			compradirecto.setInstruccionId(instruccion);
	   			Contratoinversion contratoinversion = contratoinversionService.getContratoinversion(compradirectoBean.getContratoinversionId());
	   			compradirecto.setContratoinversionId(contratoinversion);
	   			Subfiso subfiso = subfisoService.getSubfiso(compradirectoBean.getSubfisoId());
	   			compradirecto.setSubfisoId(subfiso);
	   		
	compradirecto.setFechavalor(compradirectoBean.getFechavalor());
	compradirecto.setTitulosgarantia(compradirectoBean.getTitulosgarantia());
	compradirecto.setOperacionfutura(compradirectoBean.getOperacionfutura());
	compradirecto.setFechaoperacion(compradirectoBean.getFechaoperacion());
	compradirecto.setActivos(compradirectoBean.getActivos());
	compradirecto.setTipomovimiento(compradirectoBean.getTipomovimiento());
	compradirecto.setImporte(compradirectoBean.getImporte());
	compradirecto.setCustodio(compradirectoBean.getCustodio());
	compradirecto.setComision(compradirectoBean.getComision());
	compradirecto.setMercado(compradirectoBean.getMercado());
	compradirecto.setInstrumento(compradirectoBean.getInstrumento());
	compradirecto.setIsr(compradirectoBean.getIsr());
	compradirecto.setMoneda(compradirectoBean.getMoneda());
	compradirecto.setFechaliquidacion(compradirectoBean.getFechaliquidacion());
	compradirecto.setEmisiones(compradirectoBean.getEmisiones());
	compradirecto.setSerie(compradirectoBean.getSerie());
	compradirecto.setNotitulos(compradirectoBean.getNotitulos());
	compradirecto.setPrecio(compradirectoBean.getPrecio());
	compradirecto.setDesccomplementaria(compradirectoBean.getDesccomplementaria());
	compradirecto.setIntereses(compradirectoBean.getIntereses());
	compradirecto.setPizarra(compradirectoBean.getPizarra());
	compradirecto.setCupon(compradirectoBean.getCupon());
	
		compradirecto.setCompradirectoId(compradirectoFound.getCompradirectoId());
		compradirectoService.editCompradirecto(compradirecto);
		
		Map<String, Object> compradirectoMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(compradirectoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un compradirecto.
	 * @param id.
	 * @return ResponseEntity<Compradirecto>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/compradirecto/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_COMPRADIRECTO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteCompraDirecto(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Compradirecto compradirecto = compradirectoService.getCompradirecto(uuid);
		if (compradirecto == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			compradirectoService.deleteCompradirecto(compradirecto);
			
			Map<String, Object> compradirectoMAP = new HashMap<>();
			compradirectoMAP.put("id", compradirecto.getCompradirectoId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(compradirectoMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Compradirecto no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los compradirectos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Compradirecto>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/compradirecto", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_COMPRADIRECTO:READ')")
	public @ResponseBody  List<Map<String, Object>> getCompraDirectos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Compradirecto> listCompradirecto = null;
	
		if (query==null && _page == 0) {
			listCompradirecto = compradirectoService.listCompradirectos(compradirecto);
			rows = compradirectoService.getTotalRows();
		} else if (query!= null){
			listCompradirecto = compradirectoService.listCompradirectosQuery(compradirecto, query, _page, 10);
			rows = compradirectoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listCompradirecto = compradirectoService.listCompradirectosPagination(compradirecto, _page, 10);
			rows = compradirectoService.getTotalRows();
		}
		
		List<Map<String, Object>> listCompradirectoMAP = new ArrayList<>();
		for( Compradirecto compradirecto : listCompradirecto ){
			Map<String, Object> compradirectoMAP = new HashMap<>();
			compradirectoMAP.put("id", compradirecto.getCompradirectoId());
			compradirectoMAP.put("fechavalor", compradirecto.getFechavalor());
			compradirectoMAP.put("titulosgarantia", compradirecto.getTitulosgarantia());
			compradirectoMAP.put("operacionfutura", compradirecto.getOperacionfutura());
			compradirectoMAP.put("fechaoperacion", compradirecto.getFechaoperacion());
			compradirectoMAP.put("activos", compradirecto.getActivos());
			compradirectoMAP.put("tipomovimiento", compradirecto.getTipomovimiento());
			compradirectoMAP.put("importe", compradirecto.getImporte());
			compradirectoMAP.put("custodio", compradirecto.getCustodio());
			compradirectoMAP.put("comision", compradirecto.getComision());
			compradirectoMAP.put("mercado", compradirecto.getMercado());
			compradirectoMAP.put("instrumento", compradirecto.getInstrumento());
			compradirectoMAP.put("isr", compradirecto.getIsr());
			compradirectoMAP.put("moneda", compradirecto.getMoneda());
			compradirectoMAP.put("fechaliquidacion", compradirecto.getFechaliquidacion());
			compradirectoMAP.put("emisiones", compradirecto.getEmisiones());
			compradirectoMAP.put("serie", compradirecto.getSerie());
			compradirectoMAP.put("notitulos", compradirecto.getNotitulos());
			compradirectoMAP.put("precio", compradirecto.getPrecio());
			compradirectoMAP.put("desccomplementaria", compradirecto.getDesccomplementaria());
			compradirectoMAP.put("intereses", compradirecto.getIntereses());
			compradirectoMAP.put("pizarra", compradirecto.getPizarra());
			compradirectoMAP.put("cupon", compradirecto.getCupon());
			compradirectoMAP.put("fideicomisoId", compradirecto.getFideicomisoId().getFideicomisoId());
			compradirectoMAP.put("instruccionId", compradirecto.getInstruccionId().getInstruccionId());
			compradirectoMAP.put("contratoinversionId", compradirecto.getContratoinversionId().getContratoinversionId());
			compradirectoMAP.put("subfisoId", compradirecto.getSubfisoId().getSubfisoId());
			
			listCompradirectoMAP.add(compradirectoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listCompradirectoMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un compradirecto.
	 * @param id.
	 * @return Compradirecto.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/compradirecto/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_COMPRADIRECTO:READ')")
	public @ResponseBody  Map<String, Object> getCompraDirecto(@PathVariable("id") String id) {	        
	        Compradirecto compradirecto = null;
	        
	        UUID uuid = UUID.fromString(id);
	        compradirecto = compradirectoService.getCompradirecto(uuid);
	        
			Map<String, Object> compradirectoMAP = new HashMap<>();
			compradirectoMAP.put("id", compradirecto.getCompradirectoId());
			compradirectoMAP.put("fechavalor", compradirecto.getFechavalor());
			compradirectoMAP.put("titulosgarantia", compradirecto.getTitulosgarantia());
			compradirectoMAP.put("operacionfutura", compradirecto.getOperacionfutura());
			compradirectoMAP.put("fechaoperacion", compradirecto.getFechaoperacion());
			compradirectoMAP.put("activos", compradirecto.getActivos());
			compradirectoMAP.put("tipomovimiento", compradirecto.getTipomovimiento());
			compradirectoMAP.put("importe", compradirecto.getImporte());
			compradirectoMAP.put("custodio", compradirecto.getCustodio());
			compradirectoMAP.put("comision", compradirecto.getComision());
			compradirectoMAP.put("mercado", compradirecto.getMercado());
			compradirectoMAP.put("instrumento", compradirecto.getInstrumento());
			compradirectoMAP.put("isr", compradirecto.getIsr());
			compradirectoMAP.put("moneda", compradirecto.getMoneda());
			compradirectoMAP.put("fechaliquidacion", compradirecto.getFechaliquidacion());
			compradirectoMAP.put("emisiones", compradirecto.getEmisiones());
			compradirectoMAP.put("serie", compradirecto.getSerie());
			compradirectoMAP.put("notitulos", compradirecto.getNotitulos());
			compradirectoMAP.put("precio", compradirecto.getPrecio());
			compradirectoMAP.put("desccomplementaria", compradirecto.getDesccomplementaria());
			compradirectoMAP.put("intereses", compradirecto.getIntereses());
			compradirectoMAP.put("pizarra", compradirecto.getPizarra());
			compradirectoMAP.put("cupon", compradirecto.getCupon());
			compradirectoMAP.put("fideicomisoId", compradirecto.getFideicomisoId());
			compradirectoMAP.put("instruccionId", compradirecto.getInstruccionId());
			compradirectoMAP.put("contratoinversionId", compradirecto.getContratoinversionId());
			compradirectoMAP.put("subfisoId", compradirecto.getSubfisoId());
	        
			return compradirectoMAP;
	 }
	
}
