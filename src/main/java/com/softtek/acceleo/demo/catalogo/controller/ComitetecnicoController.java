
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los ComiteTecnicos. 
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

import com.softtek.acceleo.demo.catalogo.bean.ComitetecnicoBean;
import com.softtek.acceleo.demo.domain.Comitetecnico;

import com.softtek.acceleo.demo.service.ComitetecnicoService;

/**
 * Clase ComitetecnicoController.
 * @author PSG.
 *
 */
@RestController
public class ComitetecnicoController {

	@Autowired
	private ComitetecnicoService comitetecnicoService;
	
	
	Comitetecnico comitetecnico = new Comitetecnico();
	/************************************** CREATE  **************************************
	 * Crea un nuevo comitetecnico.
	 * @param comitetecnico.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/comitetecnico", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_COMITETECNICO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createComitetecnico(@RequestBody ComitetecnicoBean comitetecnicoBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Comitetecnico comitetecnico = new Comitetecnico();
	   	
	   		
	comitetecnico.setDummy(comitetecnicoBean.getDummy());
	comitetecnico.setGeneralesnombre(comitetecnicoBean.getGenerales_nombre());
	comitetecnico.setGeneralesintegracion(comitetecnicoBean.getGenerales_integracion());
	comitetecnico.setGeneralesfacultades(comitetecnicoBean.getGenerales_facultades());
	comitetecnico.setGeneralescomentarios(comitetecnicoBean.getGenerales_comentarios());
	comitetecnico.setGeneralesfechaconstitucion(comitetecnicoBean.getGenerales_fechaconstitucion());
	comitetecnico.setGeneralesmiembrosquorum(comitetecnicoBean.getGenerales_miembrosquorum());
	comitetecnico.setGeneralesestatus(comitetecnicoBean.getGenerales_estatus());
	comitetecnico.setPresidentepropietarionombre(comitetecnicoBean.getPresidente_propietario_nombre());
	comitetecnico.setPresidentepropietariopropietario(comitetecnicoBean.getPresidente_propietario_propietario());
	comitetecnico.setPresidentepropietariopropietarionacionalidad(comitetecnicoBean.getPresidente_propietario_propietarionacionalidad());
	comitetecnico.setPresidentepropietariopropietariosino(comitetecnicoBean.getPresidente_propietario_propietariosino());
	comitetecnico.setPresidentesuplentenombre(comitetecnicoBean.getPresidente_suplente_nombre());
	comitetecnico.setPresidentesuplentepropietario(comitetecnicoBean.getPresidente_suplente_propietario());
	comitetecnico.setPresidentesuplentepropietarionacionalidad(comitetecnicoBean.getPresidente_suplente_propietarionacionalidad());
	comitetecnico.setPresidentesuplentepropietariosino(comitetecnicoBean.getPresidente_suplente_propietariosino());
	comitetecnico.setSecretariopropietarionombre(comitetecnicoBean.getSecretario_propietario_nombre());
	comitetecnico.setSecretariopropietariopropietario(comitetecnicoBean.getSecretario_propietario_propietario());
	comitetecnico.setSecretariopropietariopropietarionacionalidad(comitetecnicoBean.getSecretario_propietario_propietarionacionalidad());
	comitetecnico.setSecretariopropietariopropietariosino(comitetecnicoBean.getSecretario_propietario_propietariosino());
	comitetecnico.setSecretariosuplentenombre(comitetecnicoBean.getSecretario_suplente_nombre());
	comitetecnico.setSecretariosuplentepropietario(comitetecnicoBean.getSecretario_suplente_propietario());
	comitetecnico.setSecretariosuplentepropietarionacionalidad(comitetecnicoBean.getSecretario_suplente_propietarionacionalidad());
	comitetecnico.setSecretariosuplentepropietariosino(comitetecnicoBean.getSecretario_suplente_propietariosino());
	comitetecnico.setVocalpropietarionombre(comitetecnicoBean.getVocal_propietario_nombre());
	comitetecnico.setVocalpropietariopropietario(comitetecnicoBean.getVocal_propietario_propietario());
	comitetecnico.setVocalpropietariopropietarionacionalidad(comitetecnicoBean.getVocal_propietario_propietarionacionalidad());
	comitetecnico.setVocalpropietariopropietariosino(comitetecnicoBean.getVocal_propietario_propietariosino());
	comitetecnico.setVocalsuplentenombre(comitetecnicoBean.getVocal_suplente_nombre());
	comitetecnico.setVocalsuplentepropietario(comitetecnicoBean.getVocal_suplente_propietario());
	comitetecnico.setVocalsuplentepropietarionacionalidad(comitetecnicoBean.getVocal_suplente_propietarionacionalidad());
	comitetecnico.setVocalsuplentepropietariosino(comitetecnicoBean.getVocal_suplente_propietariosino());
	   		
	        comitetecnicoService.addComitetecnico(comitetecnico);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> comitetecnicoMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(comitetecnicoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "ComiteTecnico no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un comitetecnico.
	  * @param id.
	  * @param comitetecnico.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/comitetecnico/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_COMITETECNICO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarComiteTecnico(
				@PathVariable("id") String id, 
				@RequestBody ComitetecnicoBean comitetecnicoBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Comitetecnico comitetecnicoFound = comitetecnicoService.getComitetecnico(uuid);
	         
	    if (comitetecnicoFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   		
	comitetecnico.setDummy(comitetecnicoBean.getDummy());
	comitetecnico.setGeneralesnombre(comitetecnicoBean.getGenerales_nombre());
	comitetecnico.setGeneralesintegracion(comitetecnicoBean.getGenerales_integracion());
	comitetecnico.setGeneralesfacultades(comitetecnicoBean.getGenerales_facultades());
	comitetecnico.setGeneralescomentarios(comitetecnicoBean.getGenerales_comentarios());
	comitetecnico.setGeneralesfechaconstitucion(comitetecnicoBean.getGenerales_fechaconstitucion());
	comitetecnico.setGeneralesmiembrosquorum(comitetecnicoBean.getGenerales_miembrosquorum());
	comitetecnico.setGeneralesestatus(comitetecnicoBean.getGenerales_estatus());
	comitetecnico.setPresidentepropietarionombre(comitetecnicoBean.getPresidente_propietario_nombre());
	comitetecnico.setPresidentepropietariopropietario(comitetecnicoBean.getPresidente_propietario_propietario());
	comitetecnico.setPresidentepropietariopropietarionacionalidad(comitetecnicoBean.getPresidente_propietario_propietarionacionalidad());
	comitetecnico.setPresidentepropietariopropietariosino(comitetecnicoBean.getPresidente_propietario_propietariosino());
	comitetecnico.setPresidentesuplentenombre(comitetecnicoBean.getPresidente_suplente_nombre());
	comitetecnico.setPresidentesuplentepropietario(comitetecnicoBean.getPresidente_suplente_propietario());
	comitetecnico.setPresidentesuplentepropietarionacionalidad(comitetecnicoBean.getPresidente_suplente_propietarionacionalidad());
	comitetecnico.setPresidentesuplentepropietariosino(comitetecnicoBean.getPresidente_suplente_propietariosino());
	comitetecnico.setSecretariopropietarionombre(comitetecnicoBean.getSecretario_propietario_nombre());
	comitetecnico.setSecretariopropietariopropietario(comitetecnicoBean.getSecretario_propietario_propietario());
	comitetecnico.setSecretariopropietariopropietarionacionalidad(comitetecnicoBean.getSecretario_propietario_propietarionacionalidad());
	comitetecnico.setSecretariopropietariopropietariosino(comitetecnicoBean.getSecretario_propietario_propietariosino());
	comitetecnico.setSecretariosuplentenombre(comitetecnicoBean.getSecretario_suplente_nombre());
	comitetecnico.setSecretariosuplentepropietario(comitetecnicoBean.getSecretario_suplente_propietario());
	comitetecnico.setSecretariosuplentepropietarionacionalidad(comitetecnicoBean.getSecretario_suplente_propietarionacionalidad());
	comitetecnico.setSecretariosuplentepropietariosino(comitetecnicoBean.getSecretario_suplente_propietariosino());
	comitetecnico.setVocalpropietarionombre(comitetecnicoBean.getVocal_propietario_nombre());
	comitetecnico.setVocalpropietariopropietario(comitetecnicoBean.getVocal_propietario_propietario());
	comitetecnico.setVocalpropietariopropietarionacionalidad(comitetecnicoBean.getVocal_propietario_propietarionacionalidad());
	comitetecnico.setVocalpropietariopropietariosino(comitetecnicoBean.getVocal_propietario_propietariosino());
	comitetecnico.setVocalsuplentenombre(comitetecnicoBean.getVocal_suplente_nombre());
	comitetecnico.setVocalsuplentepropietario(comitetecnicoBean.getVocal_suplente_propietario());
	comitetecnico.setVocalsuplentepropietarionacionalidad(comitetecnicoBean.getVocal_suplente_propietarionacionalidad());
	comitetecnico.setVocalsuplentepropietariosino(comitetecnicoBean.getVocal_suplente_propietariosino());
	
		comitetecnico.setComitetecnicoId(comitetecnicoFound.getComitetecnicoId());
		comitetecnicoService.editComitetecnico(comitetecnico);
		
		Map<String, Object> comitetecnicoMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(comitetecnicoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un comitetecnico.
	 * @param id.
	 * @return ResponseEntity<Comitetecnico>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/comitetecnico/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_COMITETECNICO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteComiteTecnico(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Comitetecnico comitetecnico = comitetecnicoService.getComitetecnico(uuid);
		if (comitetecnico == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			comitetecnicoService.deleteComitetecnico(comitetecnico);
			
			Map<String, Object> comitetecnicoMAP = new HashMap<>();
			comitetecnicoMAP.put("id", comitetecnico.getComitetecnicoId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(comitetecnicoMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Comitetecnico no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los comitetecnicos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Comitetecnico>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/comitetecnico", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_COMITETECNICO:READ')")
	public @ResponseBody  List<Map<String, Object>> getComiteTecnicos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Comitetecnico> listComitetecnico = null;
	
		if (query==null && _page == 0) {
			listComitetecnico = comitetecnicoService.listComitetecnicos(comitetecnico);
			rows = comitetecnicoService.getTotalRows();
		} else if (query!= null){
			listComitetecnico = comitetecnicoService.listComitetecnicosQuery(comitetecnico, query, _page, 10);
			rows = comitetecnicoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listComitetecnico = comitetecnicoService.listComitetecnicosPagination(comitetecnico, _page, 10);
			rows = comitetecnicoService.getTotalRows();
		}
		
		List<Map<String, Object>> listComitetecnicoMAP = new ArrayList<>();
		for( Comitetecnico comitetecnico : listComitetecnico ){
			Map<String, Object> comitetecnicoMAP = new HashMap<>();
			comitetecnicoMAP.put("id", comitetecnico.getComitetecnicoId());
			comitetecnicoMAP.put("dummy", comitetecnico.getDummy());
			comitetecnicoMAP.put("generales_nombre", comitetecnico.getGeneralesnombre());
			comitetecnicoMAP.put("generales_integracion", comitetecnico.getGeneralesintegracion());
			comitetecnicoMAP.put("generales_facultades", comitetecnico.getGeneralesfacultades());
			comitetecnicoMAP.put("generales_comentarios", comitetecnico.getGeneralescomentarios());
			comitetecnicoMAP.put("generales_fechaconstitucion", comitetecnico.getGeneralesfechaconstitucion());
			comitetecnicoMAP.put("generales_miembrosquorum", comitetecnico.getGeneralesmiembrosquorum());
			comitetecnicoMAP.put("generales_estatus", comitetecnico.getGeneralesestatus());
			comitetecnicoMAP.put("presidente_propietario_nombre", comitetecnico.getPresidentepropietarionombre());
			comitetecnicoMAP.put("presidente_propietario_propietario", comitetecnico.getPresidentepropietariopropietario());
			comitetecnicoMAP.put("presidente_propietario_propietarionacionalidad", comitetecnico.getPresidentepropietariopropietarionacionalidad());
			comitetecnicoMAP.put("presidente_propietario_propietariosino", comitetecnico.getPresidentepropietariopropietariosino());
			comitetecnicoMAP.put("presidente_suplente_nombre", comitetecnico.getPresidentesuplentenombre());
			comitetecnicoMAP.put("presidente_suplente_propietario", comitetecnico.getPresidentesuplentepropietario());
			comitetecnicoMAP.put("presidente_suplente_propietarionacionalidad", comitetecnico.getPresidentesuplentepropietarionacionalidad());
			comitetecnicoMAP.put("presidente_suplente_propietariosino", comitetecnico.getPresidentesuplentepropietariosino());
			comitetecnicoMAP.put("secretario_propietario_nombre", comitetecnico.getSecretariopropietarionombre());
			comitetecnicoMAP.put("secretario_propietario_propietario", comitetecnico.getSecretariopropietariopropietario());
			comitetecnicoMAP.put("secretario_propietario_propietarionacionalidad", comitetecnico.getSecretariopropietariopropietarionacionalidad());
			comitetecnicoMAP.put("secretario_propietario_propietariosino", comitetecnico.getSecretariopropietariopropietariosino());
			comitetecnicoMAP.put("secretario_suplente_nombre", comitetecnico.getSecretariosuplentenombre());
			comitetecnicoMAP.put("secretario_suplente_propietario", comitetecnico.getSecretariosuplentepropietario());
			comitetecnicoMAP.put("secretario_suplente_propietarionacionalidad", comitetecnico.getSecretariosuplentepropietarionacionalidad());
			comitetecnicoMAP.put("secretario_suplente_propietariosino", comitetecnico.getSecretariosuplentepropietariosino());
			comitetecnicoMAP.put("vocal_propietario_nombre", comitetecnico.getVocalpropietarionombre());
			comitetecnicoMAP.put("vocal_propietario_propietario", comitetecnico.getVocalpropietariopropietario());
			comitetecnicoMAP.put("vocal_propietario_propietarionacionalidad", comitetecnico.getVocalpropietariopropietarionacionalidad());
			comitetecnicoMAP.put("vocal_propietario_propietariosino", comitetecnico.getVocalpropietariopropietariosino());
			comitetecnicoMAP.put("vocal_suplente_nombre", comitetecnico.getVocalsuplentenombre());
			comitetecnicoMAP.put("vocal_suplente_propietario", comitetecnico.getVocalsuplentepropietario());
			comitetecnicoMAP.put("vocal_suplente_propietarionacionalidad", comitetecnico.getVocalsuplentepropietarionacionalidad());
			comitetecnicoMAP.put("vocal_suplente_propietariosino", comitetecnico.getVocalsuplentepropietariosino());
			
			listComitetecnicoMAP.add(comitetecnicoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listComitetecnicoMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un comitetecnico.
	 * @param id.
	 * @return Comitetecnico.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/comitetecnico/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_COMITETECNICO:READ')")
	public @ResponseBody  Map<String, Object> getComiteTecnico(@PathVariable("id") String id) {	        
	        Comitetecnico comitetecnico = null;
	        
	        UUID uuid = UUID.fromString(id);
	        comitetecnico = comitetecnicoService.getComitetecnico(uuid);
	        
			Map<String, Object> comitetecnicoMAP = new HashMap<>();
			comitetecnicoMAP.put("id", comitetecnico.getComitetecnicoId());
			comitetecnicoMAP.put("dummy", comitetecnico.getDummy());
			comitetecnicoMAP.put("generales_nombre", comitetecnico.getGeneralesnombre());
			comitetecnicoMAP.put("generales_integracion", comitetecnico.getGeneralesintegracion());
			comitetecnicoMAP.put("generales_facultades", comitetecnico.getGeneralesfacultades());
			comitetecnicoMAP.put("generales_comentarios", comitetecnico.getGeneralescomentarios());
			comitetecnicoMAP.put("generales_fechaconstitucion", comitetecnico.getGeneralesfechaconstitucion());
			comitetecnicoMAP.put("generales_miembrosquorum", comitetecnico.getGeneralesmiembrosquorum());
			comitetecnicoMAP.put("generales_estatus", comitetecnico.getGeneralesestatus());
			comitetecnicoMAP.put("presidente_propietario_nombre", comitetecnico.getPresidentepropietarionombre());
			comitetecnicoMAP.put("presidente_propietario_propietario", comitetecnico.getPresidentepropietariopropietario());
			comitetecnicoMAP.put("presidente_propietario_propietarionacionalidad", comitetecnico.getPresidentepropietariopropietarionacionalidad());
			comitetecnicoMAP.put("presidente_propietario_propietariosino", comitetecnico.getPresidentepropietariopropietariosino());
			comitetecnicoMAP.put("presidente_suplente_nombre", comitetecnico.getPresidentesuplentenombre());
			comitetecnicoMAP.put("presidente_suplente_propietario", comitetecnico.getPresidentesuplentepropietario());
			comitetecnicoMAP.put("presidente_suplente_propietarionacionalidad", comitetecnico.getPresidentesuplentepropietarionacionalidad());
			comitetecnicoMAP.put("presidente_suplente_propietariosino", comitetecnico.getPresidentesuplentepropietariosino());
			comitetecnicoMAP.put("secretario_propietario_nombre", comitetecnico.getSecretariopropietarionombre());
			comitetecnicoMAP.put("secretario_propietario_propietario", comitetecnico.getSecretariopropietariopropietario());
			comitetecnicoMAP.put("secretario_propietario_propietarionacionalidad", comitetecnico.getSecretariopropietariopropietarionacionalidad());
			comitetecnicoMAP.put("secretario_propietario_propietariosino", comitetecnico.getSecretariopropietariopropietariosino());
			comitetecnicoMAP.put("secretario_suplente_nombre", comitetecnico.getSecretariosuplentenombre());
			comitetecnicoMAP.put("secretario_suplente_propietario", comitetecnico.getSecretariosuplentepropietario());
			comitetecnicoMAP.put("secretario_suplente_propietarionacionalidad", comitetecnico.getSecretariosuplentepropietarionacionalidad());
			comitetecnicoMAP.put("secretario_suplente_propietariosino", comitetecnico.getSecretariosuplentepropietariosino());
			comitetecnicoMAP.put("vocal_propietario_nombre", comitetecnico.getVocalpropietarionombre());
			comitetecnicoMAP.put("vocal_propietario_propietario", comitetecnico.getVocalpropietariopropietario());
			comitetecnicoMAP.put("vocal_propietario_propietarionacionalidad", comitetecnico.getVocalpropietariopropietarionacionalidad());
			comitetecnicoMAP.put("vocal_propietario_propietariosino", comitetecnico.getVocalpropietariopropietariosino());
			comitetecnicoMAP.put("vocal_suplente_nombre", comitetecnico.getVocalsuplentenombre());
			comitetecnicoMAP.put("vocal_suplente_propietario", comitetecnico.getVocalsuplentepropietario());
			comitetecnicoMAP.put("vocal_suplente_propietarionacionalidad", comitetecnico.getVocalsuplentepropietarionacionalidad());
			comitetecnicoMAP.put("vocal_suplente_propietariosino", comitetecnico.getVocalsuplentepropietariosino());
	        
			return comitetecnicoMAP;
	 }
	
}
