
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Subfisos. 
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

import com.softtek.acceleo.demo.catalogo.bean.SubfisoBean;
import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.SubfisoService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase SubfisoController.
 * @author PSG.
 *
 */
@RestController
public class SubfisoController {

	@Autowired
	private SubfisoService subfisoService;
	
@Autowired
private FideicomisoService fideicomisoService;
	
	Subfiso subfiso = new Subfiso();
	/************************************** CREATE  **************************************
	 * Crea un nuevo subfiso.
	 * @param subfiso.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/subfiso", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_SUBFISO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createSubfiso(@RequestBody SubfisoBean subfisoBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Subfiso subfiso = new Subfiso();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(subfisoBean.getFideicomisoId());
	   			subfiso.setFideicomisoId(fideicomiso);
	   		
	subfiso.setNumero(subfisoBean.getNumero());
	subfiso.setNombre(subfisoBean.getNombre());
	subfiso.setEstatus(subfisoBean.getEstatus());
	subfiso.setFecharegistro(subfisoBean.getFecharegistro());
	subfiso.setIdentificador(subfisoBean.getIdentificador());
	   		
	        subfisoService.addSubfiso(subfiso);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> subfisoMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(subfisoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Subfiso no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un subfiso.
	  * @param id.
	  * @param subfiso.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/subfiso/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_SUBFISO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarSubfiso(
				@PathVariable("id") String id, 
				@RequestBody SubfisoBean subfisoBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Subfiso subfisoFound = subfisoService.getSubfiso(uuid);
	         
	    if (subfisoFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(subfisoBean.getFideicomisoId());
	   			subfiso.setFideicomisoId(fideicomiso);
	   		
	subfiso.setNumero(subfisoBean.getNumero());
	subfiso.setNombre(subfisoBean.getNombre());
	subfiso.setEstatus(subfisoBean.getEstatus());
	subfiso.setFecharegistro(subfisoBean.getFecharegistro());
	subfiso.setIdentificador(subfisoBean.getIdentificador());
	
		subfiso.setSubfisoId(subfisoFound.getSubfisoId());
		subfisoService.editSubfiso(subfiso);
		
		Map<String, Object> subfisoMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(subfisoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un subfiso.
	 * @param id.
	 * @return ResponseEntity<Subfiso>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/subfiso/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_SUBFISO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteSubfiso(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Subfiso subfiso = subfisoService.getSubfiso(uuid);
		if (subfiso == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			subfisoService.deleteSubfiso(subfiso);
			
			Map<String, Object> subfisoMAP = new HashMap<>();
			subfisoMAP.put("id", subfiso.getSubfisoId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(subfisoMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Subfiso no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los subfisos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Subfiso>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/subfiso", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_SUBFISO:READ')")
	public @ResponseBody  List<Map<String, Object>> getSubfisos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Subfiso> listSubfiso = null;
	
		if (query==null && _page == 0) {
			listSubfiso = subfisoService.listSubfisos(subfiso);
			rows = subfisoService.getTotalRows();
		} else if (query!= null){
			listSubfiso = subfisoService.listSubfisosQuery(subfiso, query, _page, 10);
			rows = subfisoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listSubfiso = subfisoService.listSubfisosPagination(subfiso, _page, 10);
			rows = subfisoService.getTotalRows();
		}
		
		List<Map<String, Object>> listSubfisoMAP = new ArrayList<>();
		for( Subfiso subfiso : listSubfiso ){
			Map<String, Object> subfisoMAP = new HashMap<>();
			subfisoMAP.put("id", subfiso.getSubfisoId());
			subfisoMAP.put("numero", subfiso.getNumero());
			subfisoMAP.put("nombre", subfiso.getNombre());
			subfisoMAP.put("estatus", subfiso.getEstatus());
			subfisoMAP.put("fecharegistro", subfiso.getFecharegistro());
			subfisoMAP.put("identificador", subfiso.getIdentificador());
			subfisoMAP.put("fideicomisoId", subfiso.getFideicomisoId().getFideicomisoId());
			
			listSubfisoMAP.add(subfisoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listSubfisoMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un subfiso.
	 * @param id.
	 * @return Subfiso.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/subfiso/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_SUBFISO:READ')")
	public @ResponseBody  Map<String, Object> getSubfiso(@PathVariable("id") String id) {	        
	        Subfiso subfiso = null;
	        
	        UUID uuid = UUID.fromString(id);
	        subfiso = subfisoService.getSubfiso(uuid);
	        
			Map<String, Object> subfisoMAP = new HashMap<>();
			subfisoMAP.put("id", subfiso.getSubfisoId());
			subfisoMAP.put("numero", subfiso.getNumero());
			subfisoMAP.put("nombre", subfiso.getNombre());
			subfisoMAP.put("estatus", subfiso.getEstatus());
			subfisoMAP.put("fecharegistro", subfiso.getFecharegistro());
			subfisoMAP.put("identificador", subfiso.getIdentificador());
			subfisoMAP.put("fideicomisoId", subfiso.getFideicomisoId());
	        
			return subfisoMAP;
	 }
	
}
