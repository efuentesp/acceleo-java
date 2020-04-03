
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Transaccions. 
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

import com.softtek.acceleo.demo.catalogo.bean.TransaccionBean;
import com.softtek.acceleo.demo.domain.Transaccion;

import com.softtek.acceleo.demo.service.TransaccionService;

/**
 * Clase TransaccionController.
 * @author PSG.
 *
 */
@RestController
public class TransaccionController {

	@Autowired
	private TransaccionService transaccionService;
	
	
	Transaccion transaccion = new Transaccion();
	/************************************** CREATE  **************************************
	 * Crea un nuevo transaccion.
	 * @param transaccion.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/transaccion", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_TRANSACCION:CREATE')")
	 public ResponseEntity<Map<String, Object>> createTransaccion(@RequestBody TransaccionBean transaccionBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Transaccion transaccion = new Transaccion();
	   	
	   		
	transaccion.setNumoperacion(transaccionBean.getNumoperacion());
	transaccion.setModulo(transaccionBean.getModulo());
	transaccion.setNombre(transaccionBean.getNombre());
	transaccion.setCostoejecucion(transaccionBean.getCostoejecucion());
	transaccion.setEstatustrans(transaccionBean.getEstatustrans());
	transaccion.setNotransaccion(transaccionBean.getNotransaccion());
	transaccion.setMoneda(transaccionBean.getMoneda());
	transaccion.setColumedocuenta(transaccionBean.getColumedocuenta());
	transaccion.setHora(transaccionBean.getHora());
	   		
	        transaccionService.addTransaccion(transaccion);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> transaccionMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(transaccionMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Transaccion no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un transaccion.
	  * @param id.
	  * @param transaccion.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/transaccion/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_TRANSACCION:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarTransaccion(
				@PathVariable("id") String id, 
				@RequestBody TransaccionBean transaccionBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Transaccion transaccionFound = transaccionService.getTransaccion(uuid);
	         
	    if (transaccionFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   		
	transaccion.setNumoperacion(transaccionBean.getNumoperacion());
	transaccion.setModulo(transaccionBean.getModulo());
	transaccion.setNombre(transaccionBean.getNombre());
	transaccion.setCostoejecucion(transaccionBean.getCostoejecucion());
	transaccion.setEstatustrans(transaccionBean.getEstatustrans());
	transaccion.setNotransaccion(transaccionBean.getNotransaccion());
	transaccion.setMoneda(transaccionBean.getMoneda());
	transaccion.setColumedocuenta(transaccionBean.getColumedocuenta());
	transaccion.setHora(transaccionBean.getHora());
	
		transaccion.setTransaccionId(transaccionFound.getTransaccionId());
		transaccionService.editTransaccion(transaccion);
		
		Map<String, Object> transaccionMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(transaccionMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un transaccion.
	 * @param id.
	 * @return ResponseEntity<Transaccion>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/transaccion/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_TRANSACCION:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteTransaccion(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Transaccion transaccion = transaccionService.getTransaccion(uuid);
		if (transaccion == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			transaccionService.deleteTransaccion(transaccion);
			
			Map<String, Object> transaccionMAP = new HashMap<>();
			transaccionMAP.put("id", transaccion.getTransaccionId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(transaccionMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Transaccion no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los transaccions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Transaccion>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/transaccion", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_TRANSACCION:READ')")
	public @ResponseBody  List<Map<String, Object>> getTransaccions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Transaccion> listTransaccion = null;
	
		if (query==null && _page == 0) {
			listTransaccion = transaccionService.listTransaccions(transaccion);
			rows = transaccionService.getTotalRows();
		} else if (query!= null){
			listTransaccion = transaccionService.listTransaccionsQuery(transaccion, query, _page, 10);
			rows = transaccionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listTransaccion = transaccionService.listTransaccionsPagination(transaccion, _page, 10);
			rows = transaccionService.getTotalRows();
		}
		
		List<Map<String, Object>> listTransaccionMAP = new ArrayList<>();
		for( Transaccion transaccion : listTransaccion ){
			Map<String, Object> transaccionMAP = new HashMap<>();
			transaccionMAP.put("id", transaccion.getTransaccionId());
			transaccionMAP.put("numoperacion", transaccion.getNumoperacion());
			transaccionMAP.put("modulo", transaccion.getModulo());
			transaccionMAP.put("nombre", transaccion.getNombre());
			transaccionMAP.put("costoejecucion", transaccion.getCostoejecucion());
			transaccionMAP.put("estatustrans", transaccion.getEstatustrans());
			transaccionMAP.put("notransaccion", transaccion.getNotransaccion());
			transaccionMAP.put("moneda", transaccion.getMoneda());
			transaccionMAP.put("columedocuenta", transaccion.getColumedocuenta());
			transaccionMAP.put("hora", transaccion.getHora());
			
			listTransaccionMAP.add(transaccionMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listTransaccionMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un transaccion.
	 * @param id.
	 * @return Transaccion.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/transaccion/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_TRANSACCION:READ')")
	public @ResponseBody  Map<String, Object> getTransaccion(@PathVariable("id") String id) {	        
	        Transaccion transaccion = null;
	        
	        UUID uuid = UUID.fromString(id);
	        transaccion = transaccionService.getTransaccion(uuid);
	        
			Map<String, Object> transaccionMAP = new HashMap<>();
			transaccionMAP.put("id", transaccion.getTransaccionId());
			transaccionMAP.put("numoperacion", transaccion.getNumoperacion());
			transaccionMAP.put("modulo", transaccion.getModulo());
			transaccionMAP.put("nombre", transaccion.getNombre());
			transaccionMAP.put("costoejecucion", transaccion.getCostoejecucion());
			transaccionMAP.put("estatustrans", transaccion.getEstatustrans());
			transaccionMAP.put("notransaccion", transaccion.getNotransaccion());
			transaccionMAP.put("moneda", transaccion.getMoneda());
			transaccionMAP.put("columedocuenta", transaccion.getColumedocuenta());
			transaccionMAP.put("hora", transaccion.getHora());
	        
			return transaccionMAP;
	 }
	
}
