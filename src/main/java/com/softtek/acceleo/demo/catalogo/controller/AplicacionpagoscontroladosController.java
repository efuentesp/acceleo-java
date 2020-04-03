
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los AplicacionPagosControladoss. 
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

import com.softtek.acceleo.demo.catalogo.bean.AplicacionpagoscontroladosBean;
import com.softtek.acceleo.demo.domain.Aplicacionpagoscontrolados;
import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.AplicacionpagoscontroladosService;
import com.softtek.acceleo.demo.service.SubfisoService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase AplicacionpagoscontroladosController.
 * @author PSG.
 *
 */
@RestController
public class AplicacionpagoscontroladosController {

	@Autowired
	private AplicacionpagoscontroladosService aplicacionpagoscontroladosService;
	
@Autowired
private SubfisoService subfisoService;
@Autowired
private FideicomisoService fideicomisoService;
	
	Aplicacionpagoscontrolados aplicacionpagoscontrolados = new Aplicacionpagoscontrolados();
	/************************************** CREATE  **************************************
	 * Crea un nuevo aplicacionpagoscontrolados.
	 * @param aplicacionpagoscontrolados.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/aplicacionpagoscontrolados", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_APLICACIONPAGOSCONTROLADOS:CREATE')")
	 public ResponseEntity<Map<String, Object>> createAplicacionpagoscontrolados(@RequestBody AplicacionpagoscontroladosBean aplicacionpagoscontroladosBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Aplicacionpagoscontrolados aplicacionpagoscontrolados = new Aplicacionpagoscontrolados();
	   	
	   			Subfiso subfiso = subfisoService.getSubfiso(aplicacionpagoscontroladosBean.getSubfisoId());
	   			aplicacionpagoscontrolados.setSubfisoId(subfiso);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(aplicacionpagoscontroladosBean.getFideicomisoId());
	   			aplicacionpagoscontrolados.setFideicomisoId(fideicomiso);
	   		
	aplicacionpagoscontrolados.setImporte(aplicacionpagoscontroladosBean.getImporte());
	aplicacionpagoscontrolados.setImportepago(aplicacionpagoscontroladosBean.getImportepago());
	aplicacionpagoscontrolados.setFormapago(aplicacionpagoscontroladosBean.getFormapago());
	aplicacionpagoscontrolados.setTipocomision(aplicacionpagoscontroladosBean.getTipocomision());
	aplicacionpagoscontrolados.setIva(aplicacionpagoscontroladosBean.getIva());
	aplicacionpagoscontrolados.setMoneda(aplicacionpagoscontroladosBean.getMoneda());
	   		
	        aplicacionpagoscontroladosService.addAplicacionpagoscontrolados(aplicacionpagoscontrolados);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> aplicacionpagoscontroladosMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(aplicacionpagoscontroladosMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "AplicacionPagosControlados no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un aplicacionpagoscontrolados.
	  * @param id.
	  * @param aplicacionpagoscontrolados.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/aplicacionpagoscontrolados/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_APLICACIONPAGOSCONTROLADOS:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarAplicacionPagosControlados(
				@PathVariable("id") String id, 
				@RequestBody AplicacionpagoscontroladosBean aplicacionpagoscontroladosBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Aplicacionpagoscontrolados aplicacionpagoscontroladosFound = aplicacionpagoscontroladosService.getAplicacionpagoscontrolados(uuid);
	         
	    if (aplicacionpagoscontroladosFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Subfiso subfiso = subfisoService.getSubfiso(aplicacionpagoscontroladosBean.getSubfisoId());
	   			aplicacionpagoscontrolados.setSubfisoId(subfiso);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(aplicacionpagoscontroladosBean.getFideicomisoId());
	   			aplicacionpagoscontrolados.setFideicomisoId(fideicomiso);
	   		
	aplicacionpagoscontrolados.setImporte(aplicacionpagoscontroladosBean.getImporte());
	aplicacionpagoscontrolados.setImportepago(aplicacionpagoscontroladosBean.getImportepago());
	aplicacionpagoscontrolados.setFormapago(aplicacionpagoscontroladosBean.getFormapago());
	aplicacionpagoscontrolados.setTipocomision(aplicacionpagoscontroladosBean.getTipocomision());
	aplicacionpagoscontrolados.setIva(aplicacionpagoscontroladosBean.getIva());
	aplicacionpagoscontrolados.setMoneda(aplicacionpagoscontroladosBean.getMoneda());
	
		aplicacionpagoscontrolados.setAplicacionpagoscontroladosId(aplicacionpagoscontroladosFound.getAplicacionpagoscontroladosId());
		aplicacionpagoscontroladosService.editAplicacionpagoscontrolados(aplicacionpagoscontrolados);
		
		Map<String, Object> aplicacionpagoscontroladosMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(aplicacionpagoscontroladosMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un aplicacionpagoscontrolados.
	 * @param id.
	 * @return ResponseEntity<Aplicacionpagoscontrolados>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/aplicacionpagoscontrolados/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_APLICACIONPAGOSCONTROLADOS:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteAplicacionPagosControlados(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Aplicacionpagoscontrolados aplicacionpagoscontrolados = aplicacionpagoscontroladosService.getAplicacionpagoscontrolados(uuid);
		if (aplicacionpagoscontrolados == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			aplicacionpagoscontroladosService.deleteAplicacionpagoscontrolados(aplicacionpagoscontrolados);
			
			Map<String, Object> aplicacionpagoscontroladosMAP = new HashMap<>();
			aplicacionpagoscontroladosMAP.put("id", aplicacionpagoscontrolados.getAplicacionpagoscontroladosId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(aplicacionpagoscontroladosMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Aplicacionpagoscontrolados no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los aplicacionpagoscontroladoss.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Aplicacionpagoscontrolados>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/aplicacionpagoscontrolados", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_APLICACIONPAGOSCONTROLADOS:READ')")
	public @ResponseBody  List<Map<String, Object>> getAplicacionPagosControladoss(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Aplicacionpagoscontrolados> listAplicacionpagoscontrolados = null;
	
		if (query==null && _page == 0) {
			listAplicacionpagoscontrolados = aplicacionpagoscontroladosService.listAplicacionpagoscontroladoss(aplicacionpagoscontrolados);
			rows = aplicacionpagoscontroladosService.getTotalRows();
		} else if (query!= null){
			listAplicacionpagoscontrolados = aplicacionpagoscontroladosService.listAplicacionpagoscontroladossQuery(aplicacionpagoscontrolados, query, _page, 10);
			rows = aplicacionpagoscontroladosService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listAplicacionpagoscontrolados = aplicacionpagoscontroladosService.listAplicacionpagoscontroladossPagination(aplicacionpagoscontrolados, _page, 10);
			rows = aplicacionpagoscontroladosService.getTotalRows();
		}
		
		List<Map<String, Object>> listAplicacionpagoscontroladosMAP = new ArrayList<>();
		for( Aplicacionpagoscontrolados aplicacionpagoscontrolados : listAplicacionpagoscontrolados ){
			Map<String, Object> aplicacionpagoscontroladosMAP = new HashMap<>();
			aplicacionpagoscontroladosMAP.put("id", aplicacionpagoscontrolados.getAplicacionpagoscontroladosId());
			aplicacionpagoscontroladosMAP.put("importe", aplicacionpagoscontrolados.getImporte());
			aplicacionpagoscontroladosMAP.put("importepago", aplicacionpagoscontrolados.getImportepago());
			aplicacionpagoscontroladosMAP.put("formapago", aplicacionpagoscontrolados.getFormapago());
			aplicacionpagoscontroladosMAP.put("tipocomision", aplicacionpagoscontrolados.getTipocomision());
			aplicacionpagoscontroladosMAP.put("iva", aplicacionpagoscontrolados.getIva());
			aplicacionpagoscontroladosMAP.put("moneda", aplicacionpagoscontrolados.getMoneda());
			aplicacionpagoscontroladosMAP.put("subfisoId", aplicacionpagoscontrolados.getSubfisoId().getSubfisoId());
			aplicacionpagoscontroladosMAP.put("fideicomisoId", aplicacionpagoscontrolados.getFideicomisoId().getFideicomisoId());
			
			listAplicacionpagoscontroladosMAP.add(aplicacionpagoscontroladosMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listAplicacionpagoscontroladosMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un aplicacionpagoscontrolados.
	 * @param id.
	 * @return Aplicacionpagoscontrolados.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/aplicacionpagoscontrolados/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_APLICACIONPAGOSCONTROLADOS:READ')")
	public @ResponseBody  Map<String, Object> getAplicacionPagosControlados(@PathVariable("id") String id) {	        
	        Aplicacionpagoscontrolados aplicacionpagoscontrolados = null;
	        
	        UUID uuid = UUID.fromString(id);
	        aplicacionpagoscontrolados = aplicacionpagoscontroladosService.getAplicacionpagoscontrolados(uuid);
	        
			Map<String, Object> aplicacionpagoscontroladosMAP = new HashMap<>();
			aplicacionpagoscontroladosMAP.put("id", aplicacionpagoscontrolados.getAplicacionpagoscontroladosId());
			aplicacionpagoscontroladosMAP.put("importe", aplicacionpagoscontrolados.getImporte());
			aplicacionpagoscontroladosMAP.put("importepago", aplicacionpagoscontrolados.getImportepago());
			aplicacionpagoscontroladosMAP.put("formapago", aplicacionpagoscontrolados.getFormapago());
			aplicacionpagoscontroladosMAP.put("tipocomision", aplicacionpagoscontrolados.getTipocomision());
			aplicacionpagoscontroladosMAP.put("iva", aplicacionpagoscontrolados.getIva());
			aplicacionpagoscontroladosMAP.put("moneda", aplicacionpagoscontrolados.getMoneda());
			aplicacionpagoscontroladosMAP.put("subfisoId", aplicacionpagoscontrolados.getSubfisoId());
			aplicacionpagoscontroladosMAP.put("fideicomisoId", aplicacionpagoscontrolados.getFideicomisoId());
	        
			return aplicacionpagoscontroladosMAP;
	 }
	
}
