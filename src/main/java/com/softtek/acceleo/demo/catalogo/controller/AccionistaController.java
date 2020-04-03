
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Accionistas. 
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

import com.softtek.acceleo.demo.catalogo.bean.AccionistaBean;
import com.softtek.acceleo.demo.domain.Accionista;

import com.softtek.acceleo.demo.service.AccionistaService;

/**
 * Clase AccionistaController.
 * @author PSG.
 *
 */
@RestController
public class AccionistaController {

	@Autowired
	private AccionistaService accionistaService;
	
	
	Accionista accionista = new Accionista();
	/************************************** CREATE  **************************************
	 * Crea un nuevo accionista.
	 * @param accionista.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/accionista", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_ACCIONISTA:CREATE')")
	 public ResponseEntity<Map<String, Object>> createAccionista(@RequestBody AccionistaBean accionistaBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Accionista accionista = new Accionista();
	   	
	   		
	accionista.setAccionistade(accionistaBean.getAccionistade());
	accionista.setNombre(accionistaBean.getNombre());
	accionista.setRfc(accionistaBean.getRfc());
	accionista.setPorcentajeparticipacionaccionaria(accionistaBean.getPorcentajeparticipacionaccionaria());
	accionista.setTipopersona(accionistaBean.getTipopersona());
	accionista.setNacionalidad(accionistaBean.getNacionalidad());
	accionista.setPep(accionistaBean.getPep());
	   		
	        accionistaService.addAccionista(accionista);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> accionistaMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(accionistaMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Accionista no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un accionista.
	  * @param id.
	  * @param accionista.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/accionista/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_ACCIONISTA:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarAccionista(
				@PathVariable("id") String id, 
				@RequestBody AccionistaBean accionistaBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Accionista accionistaFound = accionistaService.getAccionista(uuid);
	         
	    if (accionistaFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   		
	accionista.setAccionistade(accionistaBean.getAccionistade());
	accionista.setNombre(accionistaBean.getNombre());
	accionista.setRfc(accionistaBean.getRfc());
	accionista.setPorcentajeparticipacionaccionaria(accionistaBean.getPorcentajeparticipacionaccionaria());
	accionista.setTipopersona(accionistaBean.getTipopersona());
	accionista.setNacionalidad(accionistaBean.getNacionalidad());
	accionista.setPep(accionistaBean.getPep());
	
		accionista.setAccionistaId(accionistaFound.getAccionistaId());
		accionistaService.editAccionista(accionista);
		
		Map<String, Object> accionistaMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(accionistaMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un accionista.
	 * @param id.
	 * @return ResponseEntity<Accionista>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/accionista/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_ACCIONISTA:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteAccionista(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Accionista accionista = accionistaService.getAccionista(uuid);
		if (accionista == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			accionistaService.deleteAccionista(accionista);
			
			Map<String, Object> accionistaMAP = new HashMap<>();
			accionistaMAP.put("id", accionista.getAccionistaId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(accionistaMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Accionista no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los accionistas.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Accionista>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/accionista", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ACCIONISTA:READ')")
	public @ResponseBody  List<Map<String, Object>> getAccionistas(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Accionista> listAccionista = null;
	
		if (query==null && _page == 0) {
			listAccionista = accionistaService.listAccionistas(accionista);
			rows = accionistaService.getTotalRows();
		} else if (query!= null){
			listAccionista = accionistaService.listAccionistasQuery(accionista, query, _page, 10);
			rows = accionistaService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listAccionista = accionistaService.listAccionistasPagination(accionista, _page, 10);
			rows = accionistaService.getTotalRows();
		}
		
		List<Map<String, Object>> listAccionistaMAP = new ArrayList<>();
		for( Accionista accionista : listAccionista ){
			Map<String, Object> accionistaMAP = new HashMap<>();
			accionistaMAP.put("id", accionista.getAccionistaId());
			accionistaMAP.put("accionistade", accionista.getAccionistade());
			accionistaMAP.put("nombre", accionista.getNombre());
			accionistaMAP.put("rfc", accionista.getRfc());
			accionistaMAP.put("porcentajeparticipacionaccionaria", accionista.getPorcentajeparticipacionaccionaria());
			accionistaMAP.put("tipopersona", accionista.getTipopersona());
			accionistaMAP.put("nacionalidad", accionista.getNacionalidad());
			accionistaMAP.put("pep", accionista.getPep());
			
			listAccionistaMAP.add(accionistaMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listAccionistaMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un accionista.
	 * @param id.
	 * @return Accionista.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/accionista/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ACCIONISTA:READ')")
	public @ResponseBody  Map<String, Object> getAccionista(@PathVariable("id") String id) {	        
	        Accionista accionista = null;
	        
	        UUID uuid = UUID.fromString(id);
	        accionista = accionistaService.getAccionista(uuid);
	        
			Map<String, Object> accionistaMAP = new HashMap<>();
			accionistaMAP.put("id", accionista.getAccionistaId());
			accionistaMAP.put("accionistade", accionista.getAccionistade());
			accionistaMAP.put("nombre", accionista.getNombre());
			accionistaMAP.put("rfc", accionista.getRfc());
			accionistaMAP.put("porcentajeparticipacionaccionaria", accionista.getPorcentajeparticipacionaccionaria());
			accionistaMAP.put("tipopersona", accionista.getTipopersona());
			accionistaMAP.put("nacionalidad", accionista.getNacionalidad());
			accionistaMAP.put("pep", accionista.getPep());
	        
			return accionistaMAP;
	 }
	
}
