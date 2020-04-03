
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los AsientosContabless. 
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

import com.softtek.acceleo.demo.catalogo.bean.AsientoscontablesBean;
import com.softtek.acceleo.demo.domain.Asientoscontables;
import com.softtek.acceleo.demo.domain.Transaccion;

import com.softtek.acceleo.demo.service.AsientoscontablesService;
import com.softtek.acceleo.demo.service.TransaccionService;

/**
 * Clase AsientoscontablesController.
 * @author PSG.
 *
 */
@RestController
public class AsientoscontablesController {

	@Autowired
	private AsientoscontablesService asientoscontablesService;
	
@Autowired
private TransaccionService transaccionService;
	
	Asientoscontables asientoscontables = new Asientoscontables();
	/************************************** CREATE  **************************************
	 * Crea un nuevo asientoscontables.
	 * @param asientoscontables.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/asientoscontables", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_ASIENTOSCONTABLES:CREATE')")
	 public ResponseEntity<Map<String, Object>> createAsientoscontables(@RequestBody AsientoscontablesBean asientoscontablesBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Asientoscontables asientoscontables = new Asientoscontables();
	   	
	   			Transaccion transaccion = transaccionService.getTransaccion(asientoscontablesBean.getTransaccionId());
	   			asientoscontables.setTransaccionId(transaccion);
	   		
	asientoscontables.setFolio(asientoscontablesBean.getFolio());
	asientoscontables.setOperacion(asientoscontablesBean.getOperacion());
	asientoscontables.setFechaalta(asientoscontablesBean.getFechaalta());
	asientoscontables.setFechacontable(asientoscontablesBean.getFechacontable());
	asientoscontables.setCuenta(asientoscontablesBean.getCuenta());
	asientoscontables.setSct(asientoscontablesBean.getSct());
	asientoscontables.setSsct(asientoscontablesBean.getSsct());
	asientoscontables.setSssct(asientoscontablesBean.getSssct());
	asientoscontables.setSsssct(asientoscontablesBean.getSsssct());
	asientoscontables.setDescripcioncta(asientoscontablesBean.getDescripcioncta());
	asientoscontables.setMoneda(asientoscontablesBean.getMoneda());
	asientoscontables.setAux1(asientoscontablesBean.getAux1());
	asientoscontables.setAux2(asientoscontablesBean.getAux2());
	asientoscontables.setAux3(asientoscontablesBean.getAux3());
	asientoscontables.setCargoabono(asientoscontablesBean.getCargoabono());
	asientoscontables.setImporte(asientoscontablesBean.getImporte());
	asientoscontables.setDescripcion(asientoscontablesBean.getDescripcion());
	   		
	        asientoscontablesService.addAsientoscontables(asientoscontables);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> asientoscontablesMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(asientoscontablesMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "AsientosContables no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un asientoscontables.
	  * @param id.
	  * @param asientoscontables.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/asientoscontables/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_ASIENTOSCONTABLES:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarAsientosContables(
				@PathVariable("id") String id, 
				@RequestBody AsientoscontablesBean asientoscontablesBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Asientoscontables asientoscontablesFound = asientoscontablesService.getAsientoscontables(uuid);
	         
	    if (asientoscontablesFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Transaccion transaccion = transaccionService.getTransaccion(asientoscontablesBean.getTransaccionId());
	   			asientoscontables.setTransaccionId(transaccion);
	   		
	asientoscontables.setFolio(asientoscontablesBean.getFolio());
	asientoscontables.setOperacion(asientoscontablesBean.getOperacion());
	asientoscontables.setFechaalta(asientoscontablesBean.getFechaalta());
	asientoscontables.setFechacontable(asientoscontablesBean.getFechacontable());
	asientoscontables.setCuenta(asientoscontablesBean.getCuenta());
	asientoscontables.setSct(asientoscontablesBean.getSct());
	asientoscontables.setSsct(asientoscontablesBean.getSsct());
	asientoscontables.setSssct(asientoscontablesBean.getSssct());
	asientoscontables.setSsssct(asientoscontablesBean.getSsssct());
	asientoscontables.setDescripcioncta(asientoscontablesBean.getDescripcioncta());
	asientoscontables.setMoneda(asientoscontablesBean.getMoneda());
	asientoscontables.setAux1(asientoscontablesBean.getAux1());
	asientoscontables.setAux2(asientoscontablesBean.getAux2());
	asientoscontables.setAux3(asientoscontablesBean.getAux3());
	asientoscontables.setCargoabono(asientoscontablesBean.getCargoabono());
	asientoscontables.setImporte(asientoscontablesBean.getImporte());
	asientoscontables.setDescripcion(asientoscontablesBean.getDescripcion());
	
		asientoscontables.setAsientoscontablesId(asientoscontablesFound.getAsientoscontablesId());
		asientoscontablesService.editAsientoscontables(asientoscontables);
		
		Map<String, Object> asientoscontablesMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(asientoscontablesMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un asientoscontables.
	 * @param id.
	 * @return ResponseEntity<Asientoscontables>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/asientoscontables/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_ASIENTOSCONTABLES:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteAsientosContables(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Asientoscontables asientoscontables = asientoscontablesService.getAsientoscontables(uuid);
		if (asientoscontables == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			asientoscontablesService.deleteAsientoscontables(asientoscontables);
			
			Map<String, Object> asientoscontablesMAP = new HashMap<>();
			asientoscontablesMAP.put("id", asientoscontables.getAsientoscontablesId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(asientoscontablesMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Asientoscontables no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los asientoscontabless.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Asientoscontables>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/asientoscontables", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ASIENTOSCONTABLES:READ')")
	public @ResponseBody  List<Map<String, Object>> getAsientosContabless(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Asientoscontables> listAsientoscontables = null;
	
		if (query==null && _page == 0) {
			listAsientoscontables = asientoscontablesService.listAsientoscontabless(asientoscontables);
			rows = asientoscontablesService.getTotalRows();
		} else if (query!= null){
			listAsientoscontables = asientoscontablesService.listAsientoscontablessQuery(asientoscontables, query, _page, 10);
			rows = asientoscontablesService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listAsientoscontables = asientoscontablesService.listAsientoscontablessPagination(asientoscontables, _page, 10);
			rows = asientoscontablesService.getTotalRows();
		}
		
		List<Map<String, Object>> listAsientoscontablesMAP = new ArrayList<>();
		for( Asientoscontables asientoscontables : listAsientoscontables ){
			Map<String, Object> asientoscontablesMAP = new HashMap<>();
			asientoscontablesMAP.put("id", asientoscontables.getAsientoscontablesId());
			asientoscontablesMAP.put("folio", asientoscontables.getFolio());
			asientoscontablesMAP.put("operacion", asientoscontables.getOperacion());
			asientoscontablesMAP.put("fechaalta", asientoscontables.getFechaalta());
			asientoscontablesMAP.put("fechacontable", asientoscontables.getFechacontable());
			asientoscontablesMAP.put("cuenta", asientoscontables.getCuenta());
			asientoscontablesMAP.put("sct", asientoscontables.getSct());
			asientoscontablesMAP.put("ssct", asientoscontables.getSsct());
			asientoscontablesMAP.put("sssct", asientoscontables.getSssct());
			asientoscontablesMAP.put("ssssct", asientoscontables.getSsssct());
			asientoscontablesMAP.put("descripcioncta", asientoscontables.getDescripcioncta());
			asientoscontablesMAP.put("moneda", asientoscontables.getMoneda());
			asientoscontablesMAP.put("aux1", asientoscontables.getAux1());
			asientoscontablesMAP.put("aux2", asientoscontables.getAux2());
			asientoscontablesMAP.put("aux3", asientoscontables.getAux3());
			asientoscontablesMAP.put("cargoabono", asientoscontables.getCargoabono());
			asientoscontablesMAP.put("importe", asientoscontables.getImporte());
			asientoscontablesMAP.put("descripcion", asientoscontables.getDescripcion());
			asientoscontablesMAP.put("transaccionId", asientoscontables.getTransaccionId().getTransaccionId());
			
			listAsientoscontablesMAP.add(asientoscontablesMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listAsientoscontablesMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un asientoscontables.
	 * @param id.
	 * @return Asientoscontables.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/asientoscontables/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ASIENTOSCONTABLES:READ')")
	public @ResponseBody  Map<String, Object> getAsientosContables(@PathVariable("id") String id) {	        
	        Asientoscontables asientoscontables = null;
	        
	        UUID uuid = UUID.fromString(id);
	        asientoscontables = asientoscontablesService.getAsientoscontables(uuid);
	        
			Map<String, Object> asientoscontablesMAP = new HashMap<>();
			asientoscontablesMAP.put("id", asientoscontables.getAsientoscontablesId());
			asientoscontablesMAP.put("folio", asientoscontables.getFolio());
			asientoscontablesMAP.put("operacion", asientoscontables.getOperacion());
			asientoscontablesMAP.put("fechaalta", asientoscontables.getFechaalta());
			asientoscontablesMAP.put("fechacontable", asientoscontables.getFechacontable());
			asientoscontablesMAP.put("cuenta", asientoscontables.getCuenta());
			asientoscontablesMAP.put("sct", asientoscontables.getSct());
			asientoscontablesMAP.put("ssct", asientoscontables.getSsct());
			asientoscontablesMAP.put("sssct", asientoscontables.getSssct());
			asientoscontablesMAP.put("ssssct", asientoscontables.getSsssct());
			asientoscontablesMAP.put("descripcioncta", asientoscontables.getDescripcioncta());
			asientoscontablesMAP.put("moneda", asientoscontables.getMoneda());
			asientoscontablesMAP.put("aux1", asientoscontables.getAux1());
			asientoscontablesMAP.put("aux2", asientoscontables.getAux2());
			asientoscontablesMAP.put("aux3", asientoscontables.getAux3());
			asientoscontablesMAP.put("cargoabono", asientoscontables.getCargoabono());
			asientoscontablesMAP.put("importe", asientoscontables.getImporte());
			asientoscontablesMAP.put("descripcion", asientoscontables.getDescripcion());
			asientoscontablesMAP.put("transaccionId", asientoscontables.getTransaccionId());
	        
			return asientoscontablesMAP;
	 }
	
}
