
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los AutodeclaracionCrss. 
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

import com.softtek.acceleo.demo.catalogo.bean.AutodeclaracioncrsBean;
import com.softtek.acceleo.demo.domain.Autodeclaracioncrs;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.AutodeclaracioncrsService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase AutodeclaracioncrsController.
 * @author PSG.
 *
 */
@RestController
public class AutodeclaracioncrsController {

	@Autowired
	private AutodeclaracioncrsService autodeclaracioncrsService;
	
@Autowired
private FideicomisoService fideicomisoService;
	
	Autodeclaracioncrs autodeclaracioncrs = new Autodeclaracioncrs();
	/************************************** CREATE  **************************************
	 * Crea un nuevo autodeclaracioncrs.
	 * @param autodeclaracioncrs.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/autodeclaracioncrs", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_AUTODECLARACIONCRS:CREATE')")
	 public ResponseEntity<Map<String, Object>> createAutodeclaracioncrs(@RequestBody AutodeclaracioncrsBean autodeclaracioncrsBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Autodeclaracioncrs autodeclaracioncrs = new Autodeclaracioncrs();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(autodeclaracioncrsBean.getFideicomisoId());
	   			autodeclaracioncrs.setFideicomisoId(fideicomiso);
	   		
	autodeclaracioncrs.setNumero(autodeclaracioncrsBean.getNumero());
	autodeclaracioncrs.setNombre(autodeclaracioncrsBean.getNombre());
	autodeclaracioncrs.setTipopersona(autodeclaracioncrsBean.getTipopersona());
	autodeclaracioncrs.setTipoparticipante(autodeclaracioncrsBean.getTipoparticipante());
	autodeclaracioncrs.setFormatocrs(autodeclaracioncrsBean.getFormatocrs());
	   		
	        autodeclaracioncrsService.addAutodeclaracioncrs(autodeclaracioncrs);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> autodeclaracioncrsMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(autodeclaracioncrsMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "AutodeclaracionCrs no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un autodeclaracioncrs.
	  * @param id.
	  * @param autodeclaracioncrs.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/autodeclaracioncrs/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_AUTODECLARACIONCRS:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarAutodeclaracionCrs(
				@PathVariable("id") String id, 
				@RequestBody AutodeclaracioncrsBean autodeclaracioncrsBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Autodeclaracioncrs autodeclaracioncrsFound = autodeclaracioncrsService.getAutodeclaracioncrs(uuid);
	         
	    if (autodeclaracioncrsFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(autodeclaracioncrsBean.getFideicomisoId());
	   			autodeclaracioncrs.setFideicomisoId(fideicomiso);
	   		
	autodeclaracioncrs.setNumero(autodeclaracioncrsBean.getNumero());
	autodeclaracioncrs.setNombre(autodeclaracioncrsBean.getNombre());
	autodeclaracioncrs.setTipopersona(autodeclaracioncrsBean.getTipopersona());
	autodeclaracioncrs.setTipoparticipante(autodeclaracioncrsBean.getTipoparticipante());
	autodeclaracioncrs.setFormatocrs(autodeclaracioncrsBean.getFormatocrs());
	
		autodeclaracioncrs.setAutodeclaracioncrsId(autodeclaracioncrsFound.getAutodeclaracioncrsId());
		autodeclaracioncrsService.editAutodeclaracioncrs(autodeclaracioncrs);
		
		Map<String, Object> autodeclaracioncrsMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(autodeclaracioncrsMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un autodeclaracioncrs.
	 * @param id.
	 * @return ResponseEntity<Autodeclaracioncrs>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/autodeclaracioncrs/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_AUTODECLARACIONCRS:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteAutodeclaracionCrs(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Autodeclaracioncrs autodeclaracioncrs = autodeclaracioncrsService.getAutodeclaracioncrs(uuid);
		if (autodeclaracioncrs == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			autodeclaracioncrsService.deleteAutodeclaracioncrs(autodeclaracioncrs);
			
			Map<String, Object> autodeclaracioncrsMAP = new HashMap<>();
			autodeclaracioncrsMAP.put("id", autodeclaracioncrs.getAutodeclaracioncrsId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(autodeclaracioncrsMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Autodeclaracioncrs no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los autodeclaracioncrss.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Autodeclaracioncrs>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/autodeclaracioncrs", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_AUTODECLARACIONCRS:READ')")
	public @ResponseBody  List<Map<String, Object>> getAutodeclaracionCrss(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Autodeclaracioncrs> listAutodeclaracioncrs = null;
	
		if (query==null && _page == 0) {
			listAutodeclaracioncrs = autodeclaracioncrsService.listAutodeclaracioncrss(autodeclaracioncrs);
			rows = autodeclaracioncrsService.getTotalRows();
		} else if (query!= null){
			listAutodeclaracioncrs = autodeclaracioncrsService.listAutodeclaracioncrssQuery(autodeclaracioncrs, query, _page, 10);
			rows = autodeclaracioncrsService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listAutodeclaracioncrs = autodeclaracioncrsService.listAutodeclaracioncrssPagination(autodeclaracioncrs, _page, 10);
			rows = autodeclaracioncrsService.getTotalRows();
		}
		
		List<Map<String, Object>> listAutodeclaracioncrsMAP = new ArrayList<>();
		for( Autodeclaracioncrs autodeclaracioncrs : listAutodeclaracioncrs ){
			Map<String, Object> autodeclaracioncrsMAP = new HashMap<>();
			autodeclaracioncrsMAP.put("id", autodeclaracioncrs.getAutodeclaracioncrsId());
			autodeclaracioncrsMAP.put("numero", autodeclaracioncrs.getNumero());
			autodeclaracioncrsMAP.put("nombre", autodeclaracioncrs.getNombre());
			autodeclaracioncrsMAP.put("tipopersona", autodeclaracioncrs.getTipopersona());
			autodeclaracioncrsMAP.put("tipoparticipante", autodeclaracioncrs.getTipoparticipante());
			autodeclaracioncrsMAP.put("formatocrs", autodeclaracioncrs.getFormatocrs());
			autodeclaracioncrsMAP.put("fideicomisoId", autodeclaracioncrs.getFideicomisoId().getFideicomisoId());
			
			listAutodeclaracioncrsMAP.add(autodeclaracioncrsMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listAutodeclaracioncrsMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un autodeclaracioncrs.
	 * @param id.
	 * @return Autodeclaracioncrs.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/autodeclaracioncrs/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_AUTODECLARACIONCRS:READ')")
	public @ResponseBody  Map<String, Object> getAutodeclaracionCrs(@PathVariable("id") String id) {	        
	        Autodeclaracioncrs autodeclaracioncrs = null;
	        
	        UUID uuid = UUID.fromString(id);
	        autodeclaracioncrs = autodeclaracioncrsService.getAutodeclaracioncrs(uuid);
	        
			Map<String, Object> autodeclaracioncrsMAP = new HashMap<>();
			autodeclaracioncrsMAP.put("id", autodeclaracioncrs.getAutodeclaracioncrsId());
			autodeclaracioncrsMAP.put("numero", autodeclaracioncrs.getNumero());
			autodeclaracioncrsMAP.put("nombre", autodeclaracioncrs.getNombre());
			autodeclaracioncrsMAP.put("tipopersona", autodeclaracioncrs.getTipopersona());
			autodeclaracioncrsMAP.put("tipoparticipante", autodeclaracioncrs.getTipoparticipante());
			autodeclaracioncrsMAP.put("formatocrs", autodeclaracioncrs.getFormatocrs());
			autodeclaracioncrsMAP.put("fideicomisoId", autodeclaracioncrs.getFideicomisoId());
	        
			return autodeclaracioncrsMAP;
	 }
	
}
