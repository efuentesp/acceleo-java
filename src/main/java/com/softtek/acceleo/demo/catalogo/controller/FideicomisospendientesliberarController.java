
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los FideicomisosPendientesLiberars. 
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

import com.softtek.acceleo.demo.catalogo.bean.FideicomisospendientesliberarBean;
import com.softtek.acceleo.demo.domain.Fideicomisospendientesliberar;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.FideicomisospendientesliberarService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase FideicomisospendientesliberarController.
 * @author PSG.
 *
 */
@RestController
public class FideicomisospendientesliberarController {

	@Autowired
	private FideicomisospendientesliberarService fideicomisospendientesliberarService;
	
@Autowired
private FideicomisoService fideicomisoService;
	
	Fideicomisospendientesliberar fideicomisospendientesliberar = new Fideicomisospendientesliberar();
	/************************************** CREATE  **************************************
	 * Crea un nuevo fideicomisospendientesliberar.
	 * @param fideicomisospendientesliberar.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/fideicomisospendientesliberar", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_FIDEICOMISOSPENDIENTESLIBERAR:CREATE')")
	 public ResponseEntity<Map<String, Object>> createFideicomisospendientesliberar(@RequestBody FideicomisospendientesliberarBean fideicomisospendientesliberarBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Fideicomisospendientesliberar fideicomisospendientesliberar = new Fideicomisospendientesliberar();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(fideicomisospendientesliberarBean.getFideicomisoId());
	   			fideicomisospendientesliberar.setFideicomisoId(fideicomiso);
	   		
	fideicomisospendientesliberar.setNombrefiso(fideicomisospendientesliberarBean.getNombrefiso());
	fideicomisospendientesliberar.setTiponegocio(fideicomisospendientesliberarBean.getTiponegocio());
	fideicomisospendientesliberar.setClasifproducto(fideicomisospendientesliberarBean.getClasifproducto());
	fideicomisospendientesliberar.setManejo(fideicomisospendientesliberarBean.getManejo());
	fideicomisospendientesliberar.setTipopersona(fideicomisospendientesliberarBean.getTipopersona());
	fideicomisospendientesliberar.setEstatus(fideicomisospendientesliberarBean.getEstatus());
	   		
	        fideicomisospendientesliberarService.addFideicomisospendientesliberar(fideicomisospendientesliberar);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> fideicomisospendientesliberarMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(fideicomisospendientesliberarMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "FideicomisosPendientesLiberar no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un fideicomisospendientesliberar.
	  * @param id.
	  * @param fideicomisospendientesliberar.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomisospendientesliberar/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_FIDEICOMISOSPENDIENTESLIBERAR:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarFideicomisosPendientesLiberar(
				@PathVariable("id") String id, 
				@RequestBody FideicomisospendientesliberarBean fideicomisospendientesliberarBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Fideicomisospendientesliberar fideicomisospendientesliberarFound = fideicomisospendientesliberarService.getFideicomisospendientesliberar(uuid);
	         
	    if (fideicomisospendientesliberarFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(fideicomisospendientesliberarBean.getFideicomisoId());
	   			fideicomisospendientesliberar.setFideicomisoId(fideicomiso);
	   		
	fideicomisospendientesliberar.setNombrefiso(fideicomisospendientesliberarBean.getNombrefiso());
	fideicomisospendientesliberar.setTiponegocio(fideicomisospendientesliberarBean.getTiponegocio());
	fideicomisospendientesliberar.setClasifproducto(fideicomisospendientesliberarBean.getClasifproducto());
	fideicomisospendientesliberar.setManejo(fideicomisospendientesliberarBean.getManejo());
	fideicomisospendientesliberar.setTipopersona(fideicomisospendientesliberarBean.getTipopersona());
	fideicomisospendientesliberar.setEstatus(fideicomisospendientesliberarBean.getEstatus());
	
		fideicomisospendientesliberar.setFideicomisospendientesliberarId(fideicomisospendientesliberarFound.getFideicomisospendientesliberarId());
		fideicomisospendientesliberarService.editFideicomisospendientesliberar(fideicomisospendientesliberar);
		
		Map<String, Object> fideicomisospendientesliberarMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(fideicomisospendientesliberarMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un fideicomisospendientesliberar.
	 * @param id.
	 * @return ResponseEntity<Fideicomisospendientesliberar>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomisospendientesliberar/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_FIDEICOMISOSPENDIENTESLIBERAR:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteFideicomisosPendientesLiberar(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Fideicomisospendientesliberar fideicomisospendientesliberar = fideicomisospendientesliberarService.getFideicomisospendientesliberar(uuid);
		if (fideicomisospendientesliberar == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			fideicomisospendientesliberarService.deleteFideicomisospendientesliberar(fideicomisospendientesliberar);
			
			Map<String, Object> fideicomisospendientesliberarMAP = new HashMap<>();
			fideicomisospendientesliberarMAP.put("id", fideicomisospendientesliberar.getFideicomisospendientesliberarId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(fideicomisospendientesliberarMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Fideicomisospendientesliberar no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los fideicomisospendientesliberars.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Fideicomisospendientesliberar>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomisospendientesliberar", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_FIDEICOMISOSPENDIENTESLIBERAR:READ')")
	public @ResponseBody  List<Map<String, Object>> getFideicomisosPendientesLiberars(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Fideicomisospendientesliberar> listFideicomisospendientesliberar = null;
	
		if (query==null && _page == 0) {
			listFideicomisospendientesliberar = fideicomisospendientesliberarService.listFideicomisospendientesliberars(fideicomisospendientesliberar);
			rows = fideicomisospendientesliberarService.getTotalRows();
		} else if (query!= null){
			listFideicomisospendientesliberar = fideicomisospendientesliberarService.listFideicomisospendientesliberarsQuery(fideicomisospendientesliberar, query, _page, 10);
			rows = fideicomisospendientesliberarService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listFideicomisospendientesliberar = fideicomisospendientesliberarService.listFideicomisospendientesliberarsPagination(fideicomisospendientesliberar, _page, 10);
			rows = fideicomisospendientesliberarService.getTotalRows();
		}
		
		List<Map<String, Object>> listFideicomisospendientesliberarMAP = new ArrayList<>();
		for( Fideicomisospendientesliberar fideicomisospendientesliberar : listFideicomisospendientesliberar ){
			Map<String, Object> fideicomisospendientesliberarMAP = new HashMap<>();
			fideicomisospendientesliberarMAP.put("id", fideicomisospendientesliberar.getFideicomisospendientesliberarId());
			fideicomisospendientesliberarMAP.put("nombrefiso", fideicomisospendientesliberar.getNombrefiso());
			fideicomisospendientesliberarMAP.put("tiponegocio", fideicomisospendientesliberar.getTiponegocio());
			fideicomisospendientesliberarMAP.put("clasifproducto", fideicomisospendientesliberar.getClasifproducto());
			fideicomisospendientesliberarMAP.put("manejo", fideicomisospendientesliberar.getManejo());
			fideicomisospendientesliberarMAP.put("tipopersona", fideicomisospendientesliberar.getTipopersona());
			fideicomisospendientesliberarMAP.put("estatus", fideicomisospendientesliberar.getEstatus());
			fideicomisospendientesliberarMAP.put("fideicomisoId", fideicomisospendientesliberar.getFideicomisoId().getFideicomisoId());
			
			listFideicomisospendientesliberarMAP.add(fideicomisospendientesliberarMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listFideicomisospendientesliberarMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un fideicomisospendientesliberar.
	 * @param id.
	 * @return Fideicomisospendientesliberar.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomisospendientesliberar/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_FIDEICOMISOSPENDIENTESLIBERAR:READ')")
	public @ResponseBody  Map<String, Object> getFideicomisosPendientesLiberar(@PathVariable("id") String id) {	        
	        Fideicomisospendientesliberar fideicomisospendientesliberar = null;
	        
	        UUID uuid = UUID.fromString(id);
	        fideicomisospendientesliberar = fideicomisospendientesliberarService.getFideicomisospendientesliberar(uuid);
	        
			Map<String, Object> fideicomisospendientesliberarMAP = new HashMap<>();
			fideicomisospendientesliberarMAP.put("id", fideicomisospendientesliberar.getFideicomisospendientesliberarId());
			fideicomisospendientesliberarMAP.put("nombrefiso", fideicomisospendientesliberar.getNombrefiso());
			fideicomisospendientesliberarMAP.put("tiponegocio", fideicomisospendientesliberar.getTiponegocio());
			fideicomisospendientesliberarMAP.put("clasifproducto", fideicomisospendientesliberar.getClasifproducto());
			fideicomisospendientesliberarMAP.put("manejo", fideicomisospendientesliberar.getManejo());
			fideicomisospendientesliberarMAP.put("tipopersona", fideicomisospendientesliberar.getTipopersona());
			fideicomisospendientesliberarMAP.put("estatus", fideicomisospendientesliberar.getEstatus());
			fideicomisospendientesliberarMAP.put("fideicomisoId", fideicomisospendientesliberar.getFideicomisoId());
	        
			return fideicomisospendientesliberarMAP;
	 }
	
}
