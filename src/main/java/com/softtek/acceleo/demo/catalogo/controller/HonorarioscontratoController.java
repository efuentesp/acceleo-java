
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los HonorariosContratos. 
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

import com.softtek.acceleo.demo.catalogo.bean.HonorarioscontratoBean;
import com.softtek.acceleo.demo.domain.Honorarioscontrato;
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.domain.Subfiso;

import com.softtek.acceleo.demo.service.HonorarioscontratoService;
import com.softtek.acceleo.demo.service.FideicomisoService;
import com.softtek.acceleo.demo.service.SubfisoService;

/**
 * Clase HonorarioscontratoController.
 * @author PSG.
 *
 */
@RestController
public class HonorarioscontratoController {

	@Autowired
	private HonorarioscontratoService honorarioscontratoService;
	
@Autowired
private FideicomisoService fideicomisoService;
@Autowired
private SubfisoService subfisoService;
	
	Honorarioscontrato honorarioscontrato = new Honorarioscontrato();
	/************************************** CREATE  **************************************
	 * Crea un nuevo honorarioscontrato.
	 * @param honorarioscontrato.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/honorarioscontrato", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_HONORARIOSCONTRATO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createHonorarioscontrato(@RequestBody HonorarioscontratoBean honorarioscontratoBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Honorarioscontrato honorarioscontrato = new Honorarioscontrato();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(honorarioscontratoBean.getFideicomisoId());
	   			honorarioscontrato.setFideicomisoId(fideicomiso);
	   			Subfiso subfiso = subfisoService.getSubfiso(honorarioscontratoBean.getSubfisoId());
	   			honorarioscontrato.setSubfisoId(subfiso);
	   		
	honorarioscontrato.setNombre(honorarioscontratoBean.getNombre());
	honorarioscontrato.setPersona(honorarioscontratoBean.getPersona());
	honorarioscontrato.setComisiones(honorarioscontratoBean.getComisiones());
	honorarioscontrato.setIva(honorarioscontratoBean.getIva());
	   		
	        honorarioscontratoService.addHonorarioscontrato(honorarioscontrato);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> honorarioscontratoMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(honorarioscontratoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "HonorariosContrato no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un honorarioscontrato.
	  * @param id.
	  * @param honorarioscontrato.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/honorarioscontrato/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_HONORARIOSCONTRATO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarHonorariosContrato(
				@PathVariable("id") String id, 
				@RequestBody HonorarioscontratoBean honorarioscontratoBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Honorarioscontrato honorarioscontratoFound = honorarioscontratoService.getHonorarioscontrato(uuid);
	         
	    if (honorarioscontratoFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(honorarioscontratoBean.getFideicomisoId());
	   			honorarioscontrato.setFideicomisoId(fideicomiso);
	   			Subfiso subfiso = subfisoService.getSubfiso(honorarioscontratoBean.getSubfisoId());
	   			honorarioscontrato.setSubfisoId(subfiso);
	   		
	honorarioscontrato.setNombre(honorarioscontratoBean.getNombre());
	honorarioscontrato.setPersona(honorarioscontratoBean.getPersona());
	honorarioscontrato.setComisiones(honorarioscontratoBean.getComisiones());
	honorarioscontrato.setIva(honorarioscontratoBean.getIva());
	
		honorarioscontrato.setHonorarioscontratoId(honorarioscontratoFound.getHonorarioscontratoId());
		honorarioscontratoService.editHonorarioscontrato(honorarioscontrato);
		
		Map<String, Object> honorarioscontratoMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(honorarioscontratoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un honorarioscontrato.
	 * @param id.
	 * @return ResponseEntity<Honorarioscontrato>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/honorarioscontrato/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_HONORARIOSCONTRATO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteHonorariosContrato(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Honorarioscontrato honorarioscontrato = honorarioscontratoService.getHonorarioscontrato(uuid);
		if (honorarioscontrato == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			honorarioscontratoService.deleteHonorarioscontrato(honorarioscontrato);
			
			Map<String, Object> honorarioscontratoMAP = new HashMap<>();
			honorarioscontratoMAP.put("id", honorarioscontrato.getHonorarioscontratoId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(honorarioscontratoMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Honorarioscontrato no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los honorarioscontratos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Honorarioscontrato>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/honorarioscontrato", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_HONORARIOSCONTRATO:READ')")
	public @ResponseBody  List<Map<String, Object>> getHonorariosContratos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Honorarioscontrato> listHonorarioscontrato = null;
	
		if (query==null && _page == 0) {
			listHonorarioscontrato = honorarioscontratoService.listHonorarioscontratos(honorarioscontrato);
			rows = honorarioscontratoService.getTotalRows();
		} else if (query!= null){
			listHonorarioscontrato = honorarioscontratoService.listHonorarioscontratosQuery(honorarioscontrato, query, _page, 10);
			rows = honorarioscontratoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listHonorarioscontrato = honorarioscontratoService.listHonorarioscontratosPagination(honorarioscontrato, _page, 10);
			rows = honorarioscontratoService.getTotalRows();
		}
		
		List<Map<String, Object>> listHonorarioscontratoMAP = new ArrayList<>();
		for( Honorarioscontrato honorarioscontrato : listHonorarioscontrato ){
			Map<String, Object> honorarioscontratoMAP = new HashMap<>();
			honorarioscontratoMAP.put("id", honorarioscontrato.getHonorarioscontratoId());
			honorarioscontratoMAP.put("nombre", honorarioscontrato.getNombre());
			honorarioscontratoMAP.put("persona", honorarioscontrato.getPersona());
			honorarioscontratoMAP.put("comisiones", honorarioscontrato.getComisiones());
			honorarioscontratoMAP.put("iva", honorarioscontrato.getIva());
			honorarioscontratoMAP.put("fideicomisoId", honorarioscontrato.getFideicomisoId().getFideicomisoId());
			honorarioscontratoMAP.put("subfisoId", honorarioscontrato.getSubfisoId().getSubfisoId());
			
			listHonorarioscontratoMAP.add(honorarioscontratoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listHonorarioscontratoMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un honorarioscontrato.
	 * @param id.
	 * @return Honorarioscontrato.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/honorarioscontrato/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_HONORARIOSCONTRATO:READ')")
	public @ResponseBody  Map<String, Object> getHonorariosContrato(@PathVariable("id") String id) {	        
	        Honorarioscontrato honorarioscontrato = null;
	        
	        UUID uuid = UUID.fromString(id);
	        honorarioscontrato = honorarioscontratoService.getHonorarioscontrato(uuid);
	        
			Map<String, Object> honorarioscontratoMAP = new HashMap<>();
			honorarioscontratoMAP.put("id", honorarioscontrato.getHonorarioscontratoId());
			honorarioscontratoMAP.put("nombre", honorarioscontrato.getNombre());
			honorarioscontratoMAP.put("persona", honorarioscontrato.getPersona());
			honorarioscontratoMAP.put("comisiones", honorarioscontrato.getComisiones());
			honorarioscontratoMAP.put("iva", honorarioscontrato.getIva());
			honorarioscontratoMAP.put("fideicomisoId", honorarioscontrato.getFideicomisoId());
			honorarioscontratoMAP.put("subfisoId", honorarioscontrato.getSubfisoId());
	        
			return honorarioscontratoMAP;
	 }
	
}
