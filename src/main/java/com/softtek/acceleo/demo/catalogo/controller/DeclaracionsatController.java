
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los DeclaracionSats. 
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

import com.softtek.acceleo.demo.catalogo.bean.DeclaracionsatBean;
import com.softtek.acceleo.demo.domain.Declaracionsat;

import com.softtek.acceleo.demo.service.DeclaracionsatService;

/**
 * Clase DeclaracionsatController.
 * @author PSG.
 *
 */
@RestController
public class DeclaracionsatController {

	@Autowired
	private DeclaracionsatService declaracionsatService;
	
	
	Declaracionsat declaracionsat = new Declaracionsat();
	/************************************** CREATE  **************************************
	 * Crea un nuevo declaracionsat.
	 * @param declaracionsat.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/declaracionsat", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_DECLARACIONSAT:CREATE')")
	 public ResponseEntity<Map<String, Object>> createDeclaracionsat(@RequestBody DeclaracionsatBean declaracionsatBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Declaracionsat declaracionsat = new Declaracionsat();
	   	
	   		
	declaracionsat.setInicioejerciciofiscal(declaracionsatBean.getInicioejerciciofiscal());
	declaracionsat.setTipodeclaracion(declaracionsatBean.getTipodeclaracion());
	declaracionsat.setFinejerciciofiscal(declaracionsatBean.getFinejerciciofiscal());
	declaracionsat.setDeclaracionanteriorfechadeclaracionanterior(declaracionsatBean.getDeclaracionanterior_fechadeclaracionanterior());
	declaracionsat.setDeclaracionanteriorfoliodeclaracionanterior(declaracionsatBean.getDeclaracionanterior_foliodeclaracionanterior());
	declaracionsat.setDeclaracionanteriormensajesproceso(declaracionsatBean.getDeclaracionanterior_mensajesproceso());
	declaracionsat.setDeclaracionanteriorarchivo(declaracionsatBean.getDeclaracionanterior_archivo());
	   		
	        declaracionsatService.addDeclaracionsat(declaracionsat);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> declaracionsatMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(declaracionsatMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "DeclaracionSat no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un declaracionsat.
	  * @param id.
	  * @param declaracionsat.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/declaracionsat/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_DECLARACIONSAT:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarDeclaracionSat(
				@PathVariable("id") String id, 
				@RequestBody DeclaracionsatBean declaracionsatBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Declaracionsat declaracionsatFound = declaracionsatService.getDeclaracionsat(uuid);
	         
	    if (declaracionsatFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   		
	declaracionsat.setInicioejerciciofiscal(declaracionsatBean.getInicioejerciciofiscal());
	declaracionsat.setTipodeclaracion(declaracionsatBean.getTipodeclaracion());
	declaracionsat.setFinejerciciofiscal(declaracionsatBean.getFinejerciciofiscal());
	declaracionsat.setDeclaracionanteriorfechadeclaracionanterior(declaracionsatBean.getDeclaracionanterior_fechadeclaracionanterior());
	declaracionsat.setDeclaracionanteriorfoliodeclaracionanterior(declaracionsatBean.getDeclaracionanterior_foliodeclaracionanterior());
	declaracionsat.setDeclaracionanteriormensajesproceso(declaracionsatBean.getDeclaracionanterior_mensajesproceso());
	declaracionsat.setDeclaracionanteriorarchivo(declaracionsatBean.getDeclaracionanterior_archivo());
	
		declaracionsat.setDeclaracionsatId(declaracionsatFound.getDeclaracionsatId());
		declaracionsatService.editDeclaracionsat(declaracionsat);
		
		Map<String, Object> declaracionsatMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(declaracionsatMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un declaracionsat.
	 * @param id.
	 * @return ResponseEntity<Declaracionsat>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/declaracionsat/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_DECLARACIONSAT:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteDeclaracionSat(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Declaracionsat declaracionsat = declaracionsatService.getDeclaracionsat(uuid);
		if (declaracionsat == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			declaracionsatService.deleteDeclaracionsat(declaracionsat);
			
			Map<String, Object> declaracionsatMAP = new HashMap<>();
			declaracionsatMAP.put("id", declaracionsat.getDeclaracionsatId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(declaracionsatMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Declaracionsat no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los declaracionsats.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Declaracionsat>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/declaracionsat", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_DECLARACIONSAT:READ')")
	public @ResponseBody  List<Map<String, Object>> getDeclaracionSats(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Declaracionsat> listDeclaracionsat = null;
	
		if (query==null && _page == 0) {
			listDeclaracionsat = declaracionsatService.listDeclaracionsats(declaracionsat);
			rows = declaracionsatService.getTotalRows();
		} else if (query!= null){
			listDeclaracionsat = declaracionsatService.listDeclaracionsatsQuery(declaracionsat, query, _page, 10);
			rows = declaracionsatService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listDeclaracionsat = declaracionsatService.listDeclaracionsatsPagination(declaracionsat, _page, 10);
			rows = declaracionsatService.getTotalRows();
		}
		
		List<Map<String, Object>> listDeclaracionsatMAP = new ArrayList<>();
		for( Declaracionsat declaracionsat : listDeclaracionsat ){
			Map<String, Object> declaracionsatMAP = new HashMap<>();
			declaracionsatMAP.put("id", declaracionsat.getDeclaracionsatId());
			declaracionsatMAP.put("inicioejerciciofiscal", declaracionsat.getInicioejerciciofiscal());
			declaracionsatMAP.put("tipodeclaracion", declaracionsat.getTipodeclaracion());
			declaracionsatMAP.put("finejerciciofiscal", declaracionsat.getFinejerciciofiscal());
			declaracionsatMAP.put("declaracionanterior_fechadeclaracionanterior", declaracionsat.getDeclaracionanteriorfechadeclaracionanterior());
			declaracionsatMAP.put("declaracionanterior_foliodeclaracionanterior", declaracionsat.getDeclaracionanteriorfoliodeclaracionanterior());
			declaracionsatMAP.put("declaracionanterior_mensajesproceso", declaracionsat.getDeclaracionanteriormensajesproceso());
			declaracionsatMAP.put("declaracionanterior_archivo", declaracionsat.getDeclaracionanteriorarchivo());
			
			listDeclaracionsatMAP.add(declaracionsatMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listDeclaracionsatMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un declaracionsat.
	 * @param id.
	 * @return Declaracionsat.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/declaracionsat/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_DECLARACIONSAT:READ')")
	public @ResponseBody  Map<String, Object> getDeclaracionSat(@PathVariable("id") String id) {	        
	        Declaracionsat declaracionsat = null;
	        
	        UUID uuid = UUID.fromString(id);
	        declaracionsat = declaracionsatService.getDeclaracionsat(uuid);
	        
			Map<String, Object> declaracionsatMAP = new HashMap<>();
			declaracionsatMAP.put("id", declaracionsat.getDeclaracionsatId());
			declaracionsatMAP.put("inicioejerciciofiscal", declaracionsat.getInicioejerciciofiscal());
			declaracionsatMAP.put("tipodeclaracion", declaracionsat.getTipodeclaracion());
			declaracionsatMAP.put("finejerciciofiscal", declaracionsat.getFinejerciciofiscal());
			declaracionsatMAP.put("declaracionanterior_fechadeclaracionanterior", declaracionsat.getDeclaracionanteriorfechadeclaracionanterior());
			declaracionsatMAP.put("declaracionanterior_foliodeclaracionanterior", declaracionsat.getDeclaracionanteriorfoliodeclaracionanterior());
			declaracionsatMAP.put("declaracionanterior_mensajesproceso", declaracionsat.getDeclaracionanteriormensajesproceso());
			declaracionsatMAP.put("declaracionanterior_archivo", declaracionsat.getDeclaracionanteriorarchivo());
	        
			return declaracionsatMAP;
	 }
	
}
