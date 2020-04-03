
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Terceros. 
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

import com.softtek.acceleo.demo.catalogo.bean.TerceroBean;
import com.softtek.acceleo.demo.domain.Tercero;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.TerceroService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase TerceroController.
 * @author PSG.
 *
 */
@RestController
public class TerceroController {

	@Autowired
	private TerceroService terceroService;
	
@Autowired
private FideicomisoService fideicomisoService;
	
	Tercero tercero = new Tercero();
	/************************************** CREATE  **************************************
	 * Crea un nuevo tercero.
	 * @param tercero.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/tercero", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_TERCERO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createTercero(@RequestBody TerceroBean terceroBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Tercero tercero = new Tercero();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(terceroBean.getFideicomisoId());
	   			tercero.setFideicomisoId(fideicomiso);
	   		
	tercero.setNotercero(terceroBean.getNotercero());
	tercero.setRazonsocial(terceroBean.getRazonsocial());
	tercero.setNacionalidad(terceroBean.getNacionalidad());
	tercero.setActividadeconomica(terceroBean.getActividadeconomica());
	tercero.setEstatus(terceroBean.getEstatus());
	tercero.setFechaverfircosoft(terceroBean.getFechaverfircosoft());
	tercero.setTipopersona(terceroBean.getTipopersona());
	tercero.setRfc(terceroBean.getRfc());
	tercero.setCorreo(terceroBean.getCorreo());
	tercero.setCalidamigratoria(terceroBean.getCalidamigratoria());
	tercero.setTelefonosfideicomitentepaiscasa(terceroBean.getTelefonosfideicomitente_paiscasa());
	tercero.setTelefonosfideicomitentepaisoficina(terceroBean.getTelefonosfideicomitente_paisoficina());
	tercero.setTelefonosfideicomitentepaiscelular(terceroBean.getTelefonosfideicomitente_paiscelular());
	tercero.setTelefonosfideicomitenteladacasa(terceroBean.getTelefonosfideicomitente_ladacasa());
	tercero.setTelefonosfideicomitenteladaoficina(terceroBean.getTelefonosfideicomitente_ladaoficina());
	tercero.setTelefonosfideicomitenteladacelular(terceroBean.getTelefonosfideicomitente_ladacelular());
	tercero.setTelefonosfideicomitentenumerocasa(terceroBean.getTelefonosfideicomitente_numerocasa());
	tercero.setTelefonosfideicomitentenumerooficina(terceroBean.getTelefonosfideicomitente_numerooficina());
	tercero.setTelefonosfideicomitentenumerocelular(terceroBean.getTelefonosfideicomitente_numerocelular());
	tercero.setTelefonosfideicomitenteextoficina(terceroBean.getTelefonosfideicomitente_extoficina());
	tercero.setTelefonosfideicomitenteextcelular(terceroBean.getTelefonosfideicomitente_extcelular());
	   		
	        terceroService.addTercero(tercero);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> terceroMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(terceroMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Tercero no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un tercero.
	  * @param id.
	  * @param tercero.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/tercero/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_TERCERO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarTercero(
				@PathVariable("id") String id, 
				@RequestBody TerceroBean terceroBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Tercero terceroFound = terceroService.getTercero(uuid);
	         
	    if (terceroFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(terceroBean.getFideicomisoId());
	   			tercero.setFideicomisoId(fideicomiso);
	   		
	tercero.setNotercero(terceroBean.getNotercero());
	tercero.setRazonsocial(terceroBean.getRazonsocial());
	tercero.setNacionalidad(terceroBean.getNacionalidad());
	tercero.setActividadeconomica(terceroBean.getActividadeconomica());
	tercero.setEstatus(terceroBean.getEstatus());
	tercero.setFechaverfircosoft(terceroBean.getFechaverfircosoft());
	tercero.setTipopersona(terceroBean.getTipopersona());
	tercero.setRfc(terceroBean.getRfc());
	tercero.setCorreo(terceroBean.getCorreo());
	tercero.setCalidamigratoria(terceroBean.getCalidamigratoria());
	tercero.setTelefonosfideicomitentepaiscasa(terceroBean.getTelefonosfideicomitente_paiscasa());
	tercero.setTelefonosfideicomitentepaisoficina(terceroBean.getTelefonosfideicomitente_paisoficina());
	tercero.setTelefonosfideicomitentepaiscelular(terceroBean.getTelefonosfideicomitente_paiscelular());
	tercero.setTelefonosfideicomitenteladacasa(terceroBean.getTelefonosfideicomitente_ladacasa());
	tercero.setTelefonosfideicomitenteladaoficina(terceroBean.getTelefonosfideicomitente_ladaoficina());
	tercero.setTelefonosfideicomitenteladacelular(terceroBean.getTelefonosfideicomitente_ladacelular());
	tercero.setTelefonosfideicomitentenumerocasa(terceroBean.getTelefonosfideicomitente_numerocasa());
	tercero.setTelefonosfideicomitentenumerooficina(terceroBean.getTelefonosfideicomitente_numerooficina());
	tercero.setTelefonosfideicomitentenumerocelular(terceroBean.getTelefonosfideicomitente_numerocelular());
	tercero.setTelefonosfideicomitenteextoficina(terceroBean.getTelefonosfideicomitente_extoficina());
	tercero.setTelefonosfideicomitenteextcelular(terceroBean.getTelefonosfideicomitente_extcelular());
	
		tercero.setTerceroId(terceroFound.getTerceroId());
		terceroService.editTercero(tercero);
		
		Map<String, Object> terceroMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(terceroMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un tercero.
	 * @param id.
	 * @return ResponseEntity<Tercero>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/tercero/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_TERCERO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteTercero(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Tercero tercero = terceroService.getTercero(uuid);
		if (tercero == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			terceroService.deleteTercero(tercero);
			
			Map<String, Object> terceroMAP = new HashMap<>();
			terceroMAP.put("id", tercero.getTerceroId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(terceroMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Tercero no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los terceros.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Tercero>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/tercero", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_TERCERO:READ')")
	public @ResponseBody  List<Map<String, Object>> getTerceros(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Tercero> listTercero = null;
	
		if (query==null && _page == 0) {
			listTercero = terceroService.listTerceros(tercero);
			rows = terceroService.getTotalRows();
		} else if (query!= null){
			listTercero = terceroService.listTercerosQuery(tercero, query, _page, 10);
			rows = terceroService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listTercero = terceroService.listTercerosPagination(tercero, _page, 10);
			rows = terceroService.getTotalRows();
		}
		
		List<Map<String, Object>> listTerceroMAP = new ArrayList<>();
		for( Tercero tercero : listTercero ){
			Map<String, Object> terceroMAP = new HashMap<>();
			terceroMAP.put("id", tercero.getTerceroId());
			terceroMAP.put("notercero", tercero.getNotercero());
			terceroMAP.put("razonsocial", tercero.getRazonsocial());
			terceroMAP.put("nacionalidad", tercero.getNacionalidad());
			terceroMAP.put("actividadeconomica", tercero.getActividadeconomica());
			terceroMAP.put("estatus", tercero.getEstatus());
			terceroMAP.put("fechaverfircosoft", tercero.getFechaverfircosoft());
			terceroMAP.put("tipopersona", tercero.getTipopersona());
			terceroMAP.put("rfc", tercero.getRfc());
			terceroMAP.put("correo", tercero.getCorreo());
			terceroMAP.put("calidamigratoria", tercero.getCalidamigratoria());
			terceroMAP.put("telefonosfideicomitente_paiscasa", tercero.getTelefonosfideicomitentepaiscasa());
			terceroMAP.put("telefonosfideicomitente_paisoficina", tercero.getTelefonosfideicomitentepaisoficina());
			terceroMAP.put("telefonosfideicomitente_paiscelular", tercero.getTelefonosfideicomitentepaiscelular());
			terceroMAP.put("telefonosfideicomitente_ladacasa", tercero.getTelefonosfideicomitenteladacasa());
			terceroMAP.put("telefonosfideicomitente_ladaoficina", tercero.getTelefonosfideicomitenteladaoficina());
			terceroMAP.put("telefonosfideicomitente_ladacelular", tercero.getTelefonosfideicomitenteladacelular());
			terceroMAP.put("telefonosfideicomitente_numerocasa", tercero.getTelefonosfideicomitentenumerocasa());
			terceroMAP.put("telefonosfideicomitente_numerooficina", tercero.getTelefonosfideicomitentenumerooficina());
			terceroMAP.put("telefonosfideicomitente_numerocelular", tercero.getTelefonosfideicomitentenumerocelular());
			terceroMAP.put("telefonosfideicomitente_extoficina", tercero.getTelefonosfideicomitenteextoficina());
			terceroMAP.put("telefonosfideicomitente_extcelular", tercero.getTelefonosfideicomitenteextcelular());
			terceroMAP.put("fideicomisoId", tercero.getFideicomisoId().getFideicomisoId());
			
			listTerceroMAP.add(terceroMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listTerceroMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un tercero.
	 * @param id.
	 * @return Tercero.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/tercero/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_TERCERO:READ')")
	public @ResponseBody  Map<String, Object> getTercero(@PathVariable("id") String id) {	        
	        Tercero tercero = null;
	        
	        UUID uuid = UUID.fromString(id);
	        tercero = terceroService.getTercero(uuid);
	        
			Map<String, Object> terceroMAP = new HashMap<>();
			terceroMAP.put("id", tercero.getTerceroId());
			terceroMAP.put("notercero", tercero.getNotercero());
			terceroMAP.put("razonsocial", tercero.getRazonsocial());
			terceroMAP.put("nacionalidad", tercero.getNacionalidad());
			terceroMAP.put("actividadeconomica", tercero.getActividadeconomica());
			terceroMAP.put("estatus", tercero.getEstatus());
			terceroMAP.put("fechaverfircosoft", tercero.getFechaverfircosoft());
			terceroMAP.put("tipopersona", tercero.getTipopersona());
			terceroMAP.put("rfc", tercero.getRfc());
			terceroMAP.put("correo", tercero.getCorreo());
			terceroMAP.put("calidamigratoria", tercero.getCalidamigratoria());
			terceroMAP.put("telefonosfideicomitente_paiscasa", tercero.getTelefonosfideicomitentepaiscasa());
			terceroMAP.put("telefonosfideicomitente_paisoficina", tercero.getTelefonosfideicomitentepaisoficina());
			terceroMAP.put("telefonosfideicomitente_paiscelular", tercero.getTelefonosfideicomitentepaiscelular());
			terceroMAP.put("telefonosfideicomitente_ladacasa", tercero.getTelefonosfideicomitenteladacasa());
			terceroMAP.put("telefonosfideicomitente_ladaoficina", tercero.getTelefonosfideicomitenteladaoficina());
			terceroMAP.put("telefonosfideicomitente_ladacelular", tercero.getTelefonosfideicomitenteladacelular());
			terceroMAP.put("telefonosfideicomitente_numerocasa", tercero.getTelefonosfideicomitentenumerocasa());
			terceroMAP.put("telefonosfideicomitente_numerooficina", tercero.getTelefonosfideicomitentenumerooficina());
			terceroMAP.put("telefonosfideicomitente_numerocelular", tercero.getTelefonosfideicomitentenumerocelular());
			terceroMAP.put("telefonosfideicomitente_extoficina", tercero.getTelefonosfideicomitenteextoficina());
			terceroMAP.put("telefonosfideicomitente_extcelular", tercero.getTelefonosfideicomitenteextcelular());
			terceroMAP.put("fideicomisoId", tercero.getFideicomisoId());
	        
			return terceroMAP;
	 }
	
}
