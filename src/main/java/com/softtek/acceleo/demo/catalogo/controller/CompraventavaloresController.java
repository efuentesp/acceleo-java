
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los CompraVentaValoress. 
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

import com.softtek.acceleo.demo.catalogo.bean.CompraventavaloresBean;
import com.softtek.acceleo.demo.domain.Compraventavalores;
import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Contratoinversion;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.CompraventavaloresService;
import com.softtek.acceleo.demo.service.SubfisoService;
import com.softtek.acceleo.demo.service.ContratoinversionService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase CompraventavaloresController.
 * @author PSG.
 *
 */
@RestController
public class CompraventavaloresController {

	@Autowired
	private CompraventavaloresService compraventavaloresService;
	
@Autowired
private SubfisoService subfisoService;
@Autowired
private ContratoinversionService contratoinversionService;
@Autowired
private FideicomisoService fideicomisoService;
	
	Compraventavalores compraventavalores = new Compraventavalores();
	/************************************** CREATE  **************************************
	 * Crea un nuevo compraventavalores.
	 * @param compraventavalores.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/compraventavalores", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_COMPRAVENTAVALORES:CREATE')")
	 public ResponseEntity<Map<String, Object>> createCompraventavalores(@RequestBody CompraventavaloresBean compraventavaloresBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Compraventavalores compraventavalores = new Compraventavalores();
	   	
	   			Subfiso subfiso = subfisoService.getSubfiso(compraventavaloresBean.getSubfisoId());
	   			compraventavalores.setSubfisoId(subfiso);
	   			Contratoinversion contratoinversion = contratoinversionService.getContratoinversion(compraventavaloresBean.getContratoinversionId());
	   			compraventavalores.setContratoinversionId(contratoinversion);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(compraventavaloresBean.getFideicomisoId());
	   			compraventavalores.setFideicomisoId(fideicomiso);
	   		
	compraventavalores.setFechaoperacion(compraventavaloresBean.getFechaoperacion());
	compraventavalores.setGenerooperacion(compraventavaloresBean.getGenerooperacion());
	compraventavalores.setDescripcionoperacion(compraventavaloresBean.getDescripcionoperacion());
	compraventavalores.setOperacion(compraventavaloresBean.getOperacion());
	compraventavalores.setMontooperacion(compraventavaloresBean.getMontooperacion());
	compraventavalores.setIntermediario(compraventavaloresBean.getIntermediario());
	compraventavalores.setDescripcionfideicomiso(compraventavaloresBean.getDescripcionfideicomiso());
	compraventavalores.setPoliticainversion(compraventavaloresBean.getPoliticainversion());
	compraventavalores.setMoneda(compraventavaloresBean.getMoneda());
	compraventavalores.setEmergente(compraventavaloresBean.getEmergente());
	   		
	        compraventavaloresService.addCompraventavalores(compraventavalores);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> compraventavaloresMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(compraventavaloresMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "CompraVentaValores no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un compraventavalores.
	  * @param id.
	  * @param compraventavalores.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/compraventavalores/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_COMPRAVENTAVALORES:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarCompraVentaValores(
				@PathVariable("id") String id, 
				@RequestBody CompraventavaloresBean compraventavaloresBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Compraventavalores compraventavaloresFound = compraventavaloresService.getCompraventavalores(uuid);
	         
	    if (compraventavaloresFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Subfiso subfiso = subfisoService.getSubfiso(compraventavaloresBean.getSubfisoId());
	   			compraventavalores.setSubfisoId(subfiso);
	   			Contratoinversion contratoinversion = contratoinversionService.getContratoinversion(compraventavaloresBean.getContratoinversionId());
	   			compraventavalores.setContratoinversionId(contratoinversion);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(compraventavaloresBean.getFideicomisoId());
	   			compraventavalores.setFideicomisoId(fideicomiso);
	   		
	compraventavalores.setFechaoperacion(compraventavaloresBean.getFechaoperacion());
	compraventavalores.setGenerooperacion(compraventavaloresBean.getGenerooperacion());
	compraventavalores.setDescripcionoperacion(compraventavaloresBean.getDescripcionoperacion());
	compraventavalores.setOperacion(compraventavaloresBean.getOperacion());
	compraventavalores.setMontooperacion(compraventavaloresBean.getMontooperacion());
	compraventavalores.setIntermediario(compraventavaloresBean.getIntermediario());
	compraventavalores.setDescripcionfideicomiso(compraventavaloresBean.getDescripcionfideicomiso());
	compraventavalores.setPoliticainversion(compraventavaloresBean.getPoliticainversion());
	compraventavalores.setMoneda(compraventavaloresBean.getMoneda());
	compraventavalores.setEmergente(compraventavaloresBean.getEmergente());
	
		compraventavalores.setCompraventavaloresId(compraventavaloresFound.getCompraventavaloresId());
		compraventavaloresService.editCompraventavalores(compraventavalores);
		
		Map<String, Object> compraventavaloresMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(compraventavaloresMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un compraventavalores.
	 * @param id.
	 * @return ResponseEntity<Compraventavalores>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/compraventavalores/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_COMPRAVENTAVALORES:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteCompraVentaValores(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Compraventavalores compraventavalores = compraventavaloresService.getCompraventavalores(uuid);
		if (compraventavalores == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			compraventavaloresService.deleteCompraventavalores(compraventavalores);
			
			Map<String, Object> compraventavaloresMAP = new HashMap<>();
			compraventavaloresMAP.put("id", compraventavalores.getCompraventavaloresId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(compraventavaloresMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Compraventavalores no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los compraventavaloress.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Compraventavalores>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/compraventavalores", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_COMPRAVENTAVALORES:READ')")
	public @ResponseBody  List<Map<String, Object>> getCompraVentaValoress(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Compraventavalores> listCompraventavalores = null;
	
		if (query==null && _page == 0) {
			listCompraventavalores = compraventavaloresService.listCompraventavaloress(compraventavalores);
			rows = compraventavaloresService.getTotalRows();
		} else if (query!= null){
			listCompraventavalores = compraventavaloresService.listCompraventavaloressQuery(compraventavalores, query, _page, 10);
			rows = compraventavaloresService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listCompraventavalores = compraventavaloresService.listCompraventavaloressPagination(compraventavalores, _page, 10);
			rows = compraventavaloresService.getTotalRows();
		}
		
		List<Map<String, Object>> listCompraventavaloresMAP = new ArrayList<>();
		for( Compraventavalores compraventavalores : listCompraventavalores ){
			Map<String, Object> compraventavaloresMAP = new HashMap<>();
			compraventavaloresMAP.put("id", compraventavalores.getCompraventavaloresId());
			compraventavaloresMAP.put("fechaoperacion", compraventavalores.getFechaoperacion());
			compraventavaloresMAP.put("generooperacion", compraventavalores.getGenerooperacion());
			compraventavaloresMAP.put("descripcionoperacion", compraventavalores.getDescripcionoperacion());
			compraventavaloresMAP.put("operacion", compraventavalores.getOperacion());
			compraventavaloresMAP.put("montooperacion", compraventavalores.getMontooperacion());
			compraventavaloresMAP.put("intermediario", compraventavalores.getIntermediario());
			compraventavaloresMAP.put("descripcionfideicomiso", compraventavalores.getDescripcionfideicomiso());
			compraventavaloresMAP.put("politicainversion", compraventavalores.getPoliticainversion());
			compraventavaloresMAP.put("moneda", compraventavalores.getMoneda());
			compraventavaloresMAP.put("emergente", compraventavalores.getEmergente());
			compraventavaloresMAP.put("subfisoId", compraventavalores.getSubfisoId().getSubfisoId());
			compraventavaloresMAP.put("contratoinversionId", compraventavalores.getContratoinversionId().getContratoinversionId());
			compraventavaloresMAP.put("fideicomisoId", compraventavalores.getFideicomisoId().getFideicomisoId());
			
			listCompraventavaloresMAP.add(compraventavaloresMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listCompraventavaloresMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un compraventavalores.
	 * @param id.
	 * @return Compraventavalores.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/compraventavalores/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_COMPRAVENTAVALORES:READ')")
	public @ResponseBody  Map<String, Object> getCompraVentaValores(@PathVariable("id") String id) {	        
	        Compraventavalores compraventavalores = null;
	        
	        UUID uuid = UUID.fromString(id);
	        compraventavalores = compraventavaloresService.getCompraventavalores(uuid);
	        
			Map<String, Object> compraventavaloresMAP = new HashMap<>();
			compraventavaloresMAP.put("id", compraventavalores.getCompraventavaloresId());
			compraventavaloresMAP.put("fechaoperacion", compraventavalores.getFechaoperacion());
			compraventavaloresMAP.put("generooperacion", compraventavalores.getGenerooperacion());
			compraventavaloresMAP.put("descripcionoperacion", compraventavalores.getDescripcionoperacion());
			compraventavaloresMAP.put("operacion", compraventavalores.getOperacion());
			compraventavaloresMAP.put("montooperacion", compraventavalores.getMontooperacion());
			compraventavaloresMAP.put("intermediario", compraventavalores.getIntermediario());
			compraventavaloresMAP.put("descripcionfideicomiso", compraventavalores.getDescripcionfideicomiso());
			compraventavaloresMAP.put("politicainversion", compraventavalores.getPoliticainversion());
			compraventavaloresMAP.put("moneda", compraventavalores.getMoneda());
			compraventavaloresMAP.put("emergente", compraventavalores.getEmergente());
			compraventavaloresMAP.put("subfisoId", compraventavalores.getSubfisoId());
			compraventavaloresMAP.put("contratoinversionId", compraventavalores.getContratoinversionId());
			compraventavaloresMAP.put("fideicomisoId", compraventavalores.getFideicomisoId());
	        
			return compraventavaloresMAP;
	 }
	
}
