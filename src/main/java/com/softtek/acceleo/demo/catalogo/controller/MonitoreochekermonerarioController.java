
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los MonitoreoChekerMonerarios. 
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

import com.softtek.acceleo.demo.catalogo.bean.MonitoreochekermonerarioBean;
import com.softtek.acceleo.demo.domain.Monitoreochekermonerario;
import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.MonitoreochekermonerarioService;
import com.softtek.acceleo.demo.service.SubfisoService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase MonitoreochekermonerarioController.
 * @author PSG.
 *
 */
@RestController
public class MonitoreochekermonerarioController {

	@Autowired
	private MonitoreochekermonerarioService monitoreochekermonerarioService;
	
@Autowired
private SubfisoService subfisoService;
@Autowired
private FideicomisoService fideicomisoService;
	
	Monitoreochekermonerario monitoreochekermonerario = new Monitoreochekermonerario();
	/************************************** CREATE  **************************************
	 * Crea un nuevo monitoreochekermonerario.
	 * @param monitoreochekermonerario.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/monitoreochekermonerario", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_MONITOREOCHEKERMONERARIO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createMonitoreochekermonerario(@RequestBody MonitoreochekermonerarioBean monitoreochekermonerarioBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Monitoreochekermonerario monitoreochekermonerario = new Monitoreochekermonerario();
	   	
	   			Subfiso subfiso = subfisoService.getSubfiso(monitoreochekermonerarioBean.getSubfisoId());
	   			monitoreochekermonerario.setSubfisoId(subfiso);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(monitoreochekermonerarioBean.getFideicomisoId());
	   			monitoreochekermonerario.setFideicomisoId(fideicomiso);
	   		
	monitoreochekermonerario.setFoliooperacion(monitoreochekermonerarioBean.getFoliooperacion());
	monitoreochekermonerario.setImporte(monitoreochekermonerarioBean.getImporte());
	monitoreochekermonerario.setFechaoperacion(monitoreochekermonerarioBean.getFechaoperacion());
	monitoreochekermonerario.setTotalpagos(monitoreochekermonerarioBean.getTotalpagos());
	monitoreochekermonerario.setLiquidados(monitoreochekermonerarioBean.getLiquidados());
	monitoreochekermonerario.setContabilizados(monitoreochekermonerarioBean.getContabilizados());
	monitoreochekermonerario.setPendientes(monitoreochekermonerarioBean.getPendientes());
	monitoreochekermonerario.setError(monitoreochekermonerarioBean.getError());
	monitoreochekermonerario.setEstatus(monitoreochekermonerarioBean.getEstatus());
	   		
	        monitoreochekermonerarioService.addMonitoreochekermonerario(monitoreochekermonerario);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> monitoreochekermonerarioMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(monitoreochekermonerarioMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "MonitoreoChekerMonerario no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un monitoreochekermonerario.
	  * @param id.
	  * @param monitoreochekermonerario.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/monitoreochekermonerario/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_MONITOREOCHEKERMONERARIO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarMonitoreoChekerMonerario(
				@PathVariable("id") String id, 
				@RequestBody MonitoreochekermonerarioBean monitoreochekermonerarioBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Monitoreochekermonerario monitoreochekermonerarioFound = monitoreochekermonerarioService.getMonitoreochekermonerario(uuid);
	         
	    if (monitoreochekermonerarioFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Subfiso subfiso = subfisoService.getSubfiso(monitoreochekermonerarioBean.getSubfisoId());
	   			monitoreochekermonerario.setSubfisoId(subfiso);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(monitoreochekermonerarioBean.getFideicomisoId());
	   			monitoreochekermonerario.setFideicomisoId(fideicomiso);
	   		
	monitoreochekermonerario.setFoliooperacion(monitoreochekermonerarioBean.getFoliooperacion());
	monitoreochekermonerario.setImporte(monitoreochekermonerarioBean.getImporte());
	monitoreochekermonerario.setFechaoperacion(monitoreochekermonerarioBean.getFechaoperacion());
	monitoreochekermonerario.setTotalpagos(monitoreochekermonerarioBean.getTotalpagos());
	monitoreochekermonerario.setLiquidados(monitoreochekermonerarioBean.getLiquidados());
	monitoreochekermonerario.setContabilizados(monitoreochekermonerarioBean.getContabilizados());
	monitoreochekermonerario.setPendientes(monitoreochekermonerarioBean.getPendientes());
	monitoreochekermonerario.setError(monitoreochekermonerarioBean.getError());
	monitoreochekermonerario.setEstatus(monitoreochekermonerarioBean.getEstatus());
	
		monitoreochekermonerario.setMonitoreochekermonerarioId(monitoreochekermonerarioFound.getMonitoreochekermonerarioId());
		monitoreochekermonerarioService.editMonitoreochekermonerario(monitoreochekermonerario);
		
		Map<String, Object> monitoreochekermonerarioMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(monitoreochekermonerarioMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un monitoreochekermonerario.
	 * @param id.
	 * @return ResponseEntity<Monitoreochekermonerario>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/monitoreochekermonerario/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_MONITOREOCHEKERMONERARIO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteMonitoreoChekerMonerario(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Monitoreochekermonerario monitoreochekermonerario = monitoreochekermonerarioService.getMonitoreochekermonerario(uuid);
		if (monitoreochekermonerario == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			monitoreochekermonerarioService.deleteMonitoreochekermonerario(monitoreochekermonerario);
			
			Map<String, Object> monitoreochekermonerarioMAP = new HashMap<>();
			monitoreochekermonerarioMAP.put("id", monitoreochekermonerario.getMonitoreochekermonerarioId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(monitoreochekermonerarioMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Monitoreochekermonerario no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los monitoreochekermonerarios.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Monitoreochekermonerario>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/monitoreochekermonerario", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_MONITOREOCHEKERMONERARIO:READ')")
	public @ResponseBody  List<Map<String, Object>> getMonitoreoChekerMonerarios(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Monitoreochekermonerario> listMonitoreochekermonerario = null;
	
		if (query==null && _page == 0) {
			listMonitoreochekermonerario = monitoreochekermonerarioService.listMonitoreochekermonerarios(monitoreochekermonerario);
			rows = monitoreochekermonerarioService.getTotalRows();
		} else if (query!= null){
			listMonitoreochekermonerario = monitoreochekermonerarioService.listMonitoreochekermonerariosQuery(monitoreochekermonerario, query, _page, 10);
			rows = monitoreochekermonerarioService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listMonitoreochekermonerario = monitoreochekermonerarioService.listMonitoreochekermonerariosPagination(monitoreochekermonerario, _page, 10);
			rows = monitoreochekermonerarioService.getTotalRows();
		}
		
		List<Map<String, Object>> listMonitoreochekermonerarioMAP = new ArrayList<>();
		for( Monitoreochekermonerario monitoreochekermonerario : listMonitoreochekermonerario ){
			Map<String, Object> monitoreochekermonerarioMAP = new HashMap<>();
			monitoreochekermonerarioMAP.put("id", monitoreochekermonerario.getMonitoreochekermonerarioId());
			monitoreochekermonerarioMAP.put("foliooperacion", monitoreochekermonerario.getFoliooperacion());
			monitoreochekermonerarioMAP.put("importe", monitoreochekermonerario.getImporte());
			monitoreochekermonerarioMAP.put("fechaoperacion", monitoreochekermonerario.getFechaoperacion());
			monitoreochekermonerarioMAP.put("totalpagos", monitoreochekermonerario.getTotalpagos());
			monitoreochekermonerarioMAP.put("liquidados", monitoreochekermonerario.getLiquidados());
			monitoreochekermonerarioMAP.put("contabilizados", monitoreochekermonerario.getContabilizados());
			monitoreochekermonerarioMAP.put("pendientes", monitoreochekermonerario.getPendientes());
			monitoreochekermonerarioMAP.put("error", monitoreochekermonerario.getError());
			monitoreochekermonerarioMAP.put("estatus", monitoreochekermonerario.getEstatus());
			monitoreochekermonerarioMAP.put("subfisoId", monitoreochekermonerario.getSubfisoId().getSubfisoId());
			monitoreochekermonerarioMAP.put("fideicomisoId", monitoreochekermonerario.getFideicomisoId().getFideicomisoId());
			
			listMonitoreochekermonerarioMAP.add(monitoreochekermonerarioMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listMonitoreochekermonerarioMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un monitoreochekermonerario.
	 * @param id.
	 * @return Monitoreochekermonerario.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/monitoreochekermonerario/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_MONITOREOCHEKERMONERARIO:READ')")
	public @ResponseBody  Map<String, Object> getMonitoreoChekerMonerario(@PathVariable("id") String id) {	        
	        Monitoreochekermonerario monitoreochekermonerario = null;
	        
	        UUID uuid = UUID.fromString(id);
	        monitoreochekermonerario = monitoreochekermonerarioService.getMonitoreochekermonerario(uuid);
	        
			Map<String, Object> monitoreochekermonerarioMAP = new HashMap<>();
			monitoreochekermonerarioMAP.put("id", monitoreochekermonerario.getMonitoreochekermonerarioId());
			monitoreochekermonerarioMAP.put("foliooperacion", monitoreochekermonerario.getFoliooperacion());
			monitoreochekermonerarioMAP.put("importe", monitoreochekermonerario.getImporte());
			monitoreochekermonerarioMAP.put("fechaoperacion", monitoreochekermonerario.getFechaoperacion());
			monitoreochekermonerarioMAP.put("totalpagos", monitoreochekermonerario.getTotalpagos());
			monitoreochekermonerarioMAP.put("liquidados", monitoreochekermonerario.getLiquidados());
			monitoreochekermonerarioMAP.put("contabilizados", monitoreochekermonerario.getContabilizados());
			monitoreochekermonerarioMAP.put("pendientes", monitoreochekermonerario.getPendientes());
			monitoreochekermonerarioMAP.put("error", monitoreochekermonerario.getError());
			monitoreochekermonerarioMAP.put("estatus", monitoreochekermonerario.getEstatus());
			monitoreochekermonerarioMAP.put("subfisoId", monitoreochekermonerario.getSubfisoId());
			monitoreochekermonerarioMAP.put("fideicomisoId", monitoreochekermonerario.getFideicomisoId());
	        
			return monitoreochekermonerarioMAP;
	 }
	
}
