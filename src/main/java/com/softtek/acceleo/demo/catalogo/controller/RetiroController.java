
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Retiros. 
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

import com.softtek.acceleo.demo.catalogo.bean.RetiroBean;
import com.softtek.acceleo.demo.domain.Retiro;

import com.softtek.acceleo.demo.service.RetiroService;

/**
 * Clase RetiroController.
 * @author PSG.
 *
 */
@RestController
public class RetiroController {

	@Autowired
	private RetiroService retiroService;
	
	
	Retiro retiro = new Retiro();
	/************************************** CREATE  **************************************
	 * Crea un nuevo retiro.
	 * @param retiro.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/retiro", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_RETIRO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createRetiro(@RequestBody RetiroBean retiroBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Retiro retiro = new Retiro();
	   	
	   		
	retiro.setUsuario(retiroBean.getUsuario());
	retiro.setFechahora(retiroBean.getFechahora());
	retiro.setArchivo(retiroBean.getArchivo());
	   		
	        retiroService.addRetiro(retiro);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> retiroMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(retiroMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Retiro no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un retiro.
	  * @param id.
	  * @param retiro.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/retiro/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_RETIRO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarRetiro(
				@PathVariable("id") String id, 
				@RequestBody RetiroBean retiroBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Retiro retiroFound = retiroService.getRetiro(uuid);
	         
	    if (retiroFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   		
	retiro.setUsuario(retiroBean.getUsuario());
	retiro.setFechahora(retiroBean.getFechahora());
	retiro.setArchivo(retiroBean.getArchivo());
	
		retiro.setRetiroId(retiroFound.getRetiroId());
		retiroService.editRetiro(retiro);
		
		Map<String, Object> retiroMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(retiroMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un retiro.
	 * @param id.
	 * @return ResponseEntity<Retiro>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/retiro/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_RETIRO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteRetiro(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Retiro retiro = retiroService.getRetiro(uuid);
		if (retiro == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			retiroService.deleteRetiro(retiro);
			
			Map<String, Object> retiroMAP = new HashMap<>();
			retiroMAP.put("id", retiro.getRetiroId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(retiroMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Retiro no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los retiros.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Retiro>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/retiro", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_RETIRO:READ')")
	public @ResponseBody  List<Map<String, Object>> getRetiros(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Retiro> listRetiro = null;
	
		if (query==null && _page == 0) {
			listRetiro = retiroService.listRetiros(retiro);
			rows = retiroService.getTotalRows();
		} else if (query!= null){
			listRetiro = retiroService.listRetirosQuery(retiro, query, _page, 10);
			rows = retiroService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listRetiro = retiroService.listRetirosPagination(retiro, _page, 10);
			rows = retiroService.getTotalRows();
		}
		
		List<Map<String, Object>> listRetiroMAP = new ArrayList<>();
		for( Retiro retiro : listRetiro ){
			Map<String, Object> retiroMAP = new HashMap<>();
			retiroMAP.put("id", retiro.getRetiroId());
			retiroMAP.put("usuario", retiro.getUsuario());
			retiroMAP.put("fechahora", retiro.getFechahora());
			retiroMAP.put("archivo", retiro.getArchivo());
			
			listRetiroMAP.add(retiroMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listRetiroMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un retiro.
	 * @param id.
	 * @return Retiro.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/retiro/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_RETIRO:READ')")
	public @ResponseBody  Map<String, Object> getRetiro(@PathVariable("id") String id) {	        
	        Retiro retiro = null;
	        
	        UUID uuid = UUID.fromString(id);
	        retiro = retiroService.getRetiro(uuid);
	        
			Map<String, Object> retiroMAP = new HashMap<>();
			retiroMAP.put("id", retiro.getRetiroId());
			retiroMAP.put("usuario", retiro.getUsuario());
			retiroMAP.put("fechahora", retiro.getFechahora());
			retiroMAP.put("archivo", retiro.getArchivo());
	        
			return retiroMAP;
	 }
	
}
