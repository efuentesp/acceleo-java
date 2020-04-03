
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Guias. 
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

import com.softtek.acceleo.demo.catalogo.bean.GuiaBean;
import com.softtek.acceleo.demo.domain.Guia;
import com.softtek.acceleo.demo.domain.Transaccion;

import com.softtek.acceleo.demo.service.GuiaService;
import com.softtek.acceleo.demo.service.TransaccionService;

/**
 * Clase GuiaController.
 * @author PSG.
 *
 */
@RestController
public class GuiaController {

	@Autowired
	private GuiaService guiaService;
	
@Autowired
private TransaccionService transaccionService;
	
	Guia guia = new Guia();
	/************************************** CREATE  **************************************
	 * Crea un nuevo guia.
	 * @param guia.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/guia", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_GUIA:CREATE')")
	 public ResponseEntity<Map<String, Object>> createGuia(@RequestBody GuiaBean guiaBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Guia guia = new Guia();
	   	
	   			Transaccion transaccion = transaccionService.getTransaccion(guiaBean.getTransaccionId());
	   			guia.setTransaccionId(transaccion);
	   		
	guia.setSec(guiaBean.getSec());
	guia.setNombrecuenta(guiaBean.getNombrecuenta());
	guia.setCtamayor(guiaBean.getCtamayor());
	guia.setScta(guiaBean.getScta());
	guia.setSscta(guiaBean.getSscta());
	guia.setSssctacopia(guiaBean.getSssctacopia());
	guia.setSssscta(guiaBean.getSssscta());
	guia.setAuxiliar1(guiaBean.getAuxiliar1());
	guia.setAuxiliar2(guiaBean.getAuxiliar2());
	guia.setAuxiliar3(guiaBean.getAuxiliar3());
	guia.setAplicadato(guiaBean.getAplicadato());
	guia.setCa(guiaBean.getCa());
	guia.setDescripcion(guiaBean.getDescripcion());
	guia.setEstatus(guiaBean.getEstatus());
	   		
	        guiaService.addGuia(guia);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> guiaMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(guiaMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Guia no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un guia.
	  * @param id.
	  * @param guia.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/guia/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_GUIA:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarGuia(
				@PathVariable("id") String id, 
				@RequestBody GuiaBean guiaBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Guia guiaFound = guiaService.getGuia(uuid);
	         
	    if (guiaFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Transaccion transaccion = transaccionService.getTransaccion(guiaBean.getTransaccionId());
	   			guia.setTransaccionId(transaccion);
	   		
	guia.setSec(guiaBean.getSec());
	guia.setNombrecuenta(guiaBean.getNombrecuenta());
	guia.setCtamayor(guiaBean.getCtamayor());
	guia.setScta(guiaBean.getScta());
	guia.setSscta(guiaBean.getSscta());
	guia.setSssctacopia(guiaBean.getSssctacopia());
	guia.setSssscta(guiaBean.getSssscta());
	guia.setAuxiliar1(guiaBean.getAuxiliar1());
	guia.setAuxiliar2(guiaBean.getAuxiliar2());
	guia.setAuxiliar3(guiaBean.getAuxiliar3());
	guia.setAplicadato(guiaBean.getAplicadato());
	guia.setCa(guiaBean.getCa());
	guia.setDescripcion(guiaBean.getDescripcion());
	guia.setEstatus(guiaBean.getEstatus());
	
		guia.setGuiaId(guiaFound.getGuiaId());
		guiaService.editGuia(guia);
		
		Map<String, Object> guiaMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(guiaMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un guia.
	 * @param id.
	 * @return ResponseEntity<Guia>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/guia/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_GUIA:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteGuia(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Guia guia = guiaService.getGuia(uuid);
		if (guia == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			guiaService.deleteGuia(guia);
			
			Map<String, Object> guiaMAP = new HashMap<>();
			guiaMAP.put("id", guia.getGuiaId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(guiaMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Guia no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los guias.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Guia>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/guia", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_GUIA:READ')")
	public @ResponseBody  List<Map<String, Object>> getGuias(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Guia> listGuia = null;
	
		if (query==null && _page == 0) {
			listGuia = guiaService.listGuias(guia);
			rows = guiaService.getTotalRows();
		} else if (query!= null){
			listGuia = guiaService.listGuiasQuery(guia, query, _page, 10);
			rows = guiaService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listGuia = guiaService.listGuiasPagination(guia, _page, 10);
			rows = guiaService.getTotalRows();
		}
		
		List<Map<String, Object>> listGuiaMAP = new ArrayList<>();
		for( Guia guia : listGuia ){
			Map<String, Object> guiaMAP = new HashMap<>();
			guiaMAP.put("id", guia.getGuiaId());
			guiaMAP.put("sec", guia.getSec());
			guiaMAP.put("nombrecuenta", guia.getNombrecuenta());
			guiaMAP.put("ctamayor", guia.getCtamayor());
			guiaMAP.put("scta", guia.getScta());
			guiaMAP.put("sscta", guia.getSscta());
			guiaMAP.put("sssctacopia", guia.getSssctacopia());
			guiaMAP.put("sssscta", guia.getSssscta());
			guiaMAP.put("auxiliar1", guia.getAuxiliar1());
			guiaMAP.put("auxiliar2", guia.getAuxiliar2());
			guiaMAP.put("auxiliar3", guia.getAuxiliar3());
			guiaMAP.put("aplicadato", guia.getAplicadato());
			guiaMAP.put("ca", guia.getCa());
			guiaMAP.put("descripcion", guia.getDescripcion());
			guiaMAP.put("estatus", guia.getEstatus());
			guiaMAP.put("transaccionId", guia.getTransaccionId().getTransaccionId());
			
			listGuiaMAP.add(guiaMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listGuiaMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un guia.
	 * @param id.
	 * @return Guia.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/guia/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_GUIA:READ')")
	public @ResponseBody  Map<String, Object> getGuia(@PathVariable("id") String id) {	        
	        Guia guia = null;
	        
	        UUID uuid = UUID.fromString(id);
	        guia = guiaService.getGuia(uuid);
	        
			Map<String, Object> guiaMAP = new HashMap<>();
			guiaMAP.put("id", guia.getGuiaId());
			guiaMAP.put("sec", guia.getSec());
			guiaMAP.put("nombrecuenta", guia.getNombrecuenta());
			guiaMAP.put("ctamayor", guia.getCtamayor());
			guiaMAP.put("scta", guia.getScta());
			guiaMAP.put("sscta", guia.getSscta());
			guiaMAP.put("sssctacopia", guia.getSssctacopia());
			guiaMAP.put("sssscta", guia.getSssscta());
			guiaMAP.put("auxiliar1", guia.getAuxiliar1());
			guiaMAP.put("auxiliar2", guia.getAuxiliar2());
			guiaMAP.put("auxiliar3", guia.getAuxiliar3());
			guiaMAP.put("aplicadato", guia.getAplicadato());
			guiaMAP.put("ca", guia.getCa());
			guiaMAP.put("descripcion", guia.getDescripcion());
			guiaMAP.put("estatus", guia.getEstatus());
			guiaMAP.put("transaccionId", guia.getTransaccionId());
	        
			return guiaMAP;
	 }
	
}
