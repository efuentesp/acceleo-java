
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los DocumentosFideicomisos. 
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

import com.softtek.acceleo.demo.catalogo.bean.DocumentosfideicomisoBean;
import com.softtek.acceleo.demo.domain.Documentosfideicomiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.DocumentosfideicomisoService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase DocumentosfideicomisoController.
 * @author PSG.
 *
 */
@RestController
public class DocumentosfideicomisoController {

	@Autowired
	private DocumentosfideicomisoService documentosfideicomisoService;
	
@Autowired
private FideicomisoService fideicomisoService;
	
	Documentosfideicomiso documentosfideicomiso = new Documentosfideicomiso();
	/************************************** CREATE  **************************************
	 * Crea un nuevo documentosfideicomiso.
	 * @param documentosfideicomiso.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/documentosfideicomiso", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_DOCUMENTOSFIDEICOMISO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createDocumentosfideicomiso(@RequestBody DocumentosfideicomisoBean documentosfideicomisoBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Documentosfideicomiso documentosfideicomiso = new Documentosfideicomiso();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(documentosfideicomisoBean.getFideicomisoId());
	   			documentosfideicomiso.setFideicomisoId(fideicomiso);
	   		
	documentosfideicomiso.setCampo(documentosfideicomisoBean.getCampo());
	documentosfideicomiso.setContratofideicomiso(documentosfideicomisoBean.getContratofideicomiso());
	documentosfideicomiso.setActasconstitutivas(documentosfideicomisoBean.getActasconstitutivas());
	documentosfideicomiso.setCedulafiscal(documentosfideicomisoBean.getCedulafiscal());
	documentosfideicomiso.setPoderes(documentosfideicomisoBean.getPoderes());
	documentosfideicomiso.setIdentificadores(documentosfideicomisoBean.getIdentificadores());
	documentosfideicomiso.setComprobantesdomicilio(documentosfideicomisoBean.getComprobantesdomicilio());
	documentosfideicomiso.setFormatoskyc(documentosfideicomisoBean.getFormatoskyc());
	documentosfideicomiso.setFormatoevaluacionriesgo(documentosfideicomisoBean.getFormatoevaluacionriesgo());
	documentosfideicomiso.setWorldcheck(documentosfideicomisoBean.getWorldcheck());
	documentosfideicomiso.setFormatoinformacion(documentosfideicomisoBean.getFormatoinformacion());
	documentosfideicomiso.setAutorizacioncomite(documentosfideicomisoBean.getAutorizacioncomite());
	documentosfideicomiso.setFirmascomite(documentosfideicomisoBean.getFirmascomite());
	documentosfideicomiso.setCurp(documentosfideicomisoBean.getCurp());
	   		
	        documentosfideicomisoService.addDocumentosfideicomiso(documentosfideicomiso);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> documentosfideicomisoMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(documentosfideicomisoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "DocumentosFideicomiso no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un documentosfideicomiso.
	  * @param id.
	  * @param documentosfideicomiso.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/documentosfideicomiso/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_DOCUMENTOSFIDEICOMISO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarDocumentosFideicomiso(
				@PathVariable("id") String id, 
				@RequestBody DocumentosfideicomisoBean documentosfideicomisoBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Documentosfideicomiso documentosfideicomisoFound = documentosfideicomisoService.getDocumentosfideicomiso(uuid);
	         
	    if (documentosfideicomisoFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(documentosfideicomisoBean.getFideicomisoId());
	   			documentosfideicomiso.setFideicomisoId(fideicomiso);
	   		
	documentosfideicomiso.setCampo(documentosfideicomisoBean.getCampo());
	documentosfideicomiso.setContratofideicomiso(documentosfideicomisoBean.getContratofideicomiso());
	documentosfideicomiso.setActasconstitutivas(documentosfideicomisoBean.getActasconstitutivas());
	documentosfideicomiso.setCedulafiscal(documentosfideicomisoBean.getCedulafiscal());
	documentosfideicomiso.setPoderes(documentosfideicomisoBean.getPoderes());
	documentosfideicomiso.setIdentificadores(documentosfideicomisoBean.getIdentificadores());
	documentosfideicomiso.setComprobantesdomicilio(documentosfideicomisoBean.getComprobantesdomicilio());
	documentosfideicomiso.setFormatoskyc(documentosfideicomisoBean.getFormatoskyc());
	documentosfideicomiso.setFormatoevaluacionriesgo(documentosfideicomisoBean.getFormatoevaluacionriesgo());
	documentosfideicomiso.setWorldcheck(documentosfideicomisoBean.getWorldcheck());
	documentosfideicomiso.setFormatoinformacion(documentosfideicomisoBean.getFormatoinformacion());
	documentosfideicomiso.setAutorizacioncomite(documentosfideicomisoBean.getAutorizacioncomite());
	documentosfideicomiso.setFirmascomite(documentosfideicomisoBean.getFirmascomite());
	documentosfideicomiso.setCurp(documentosfideicomisoBean.getCurp());
	
		documentosfideicomiso.setDocumentosfideicomisoId(documentosfideicomisoFound.getDocumentosfideicomisoId());
		documentosfideicomisoService.editDocumentosfideicomiso(documentosfideicomiso);
		
		Map<String, Object> documentosfideicomisoMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(documentosfideicomisoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un documentosfideicomiso.
	 * @param id.
	 * @return ResponseEntity<Documentosfideicomiso>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/documentosfideicomiso/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_DOCUMENTOSFIDEICOMISO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteDocumentosFideicomiso(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Documentosfideicomiso documentosfideicomiso = documentosfideicomisoService.getDocumentosfideicomiso(uuid);
		if (documentosfideicomiso == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			documentosfideicomisoService.deleteDocumentosfideicomiso(documentosfideicomiso);
			
			Map<String, Object> documentosfideicomisoMAP = new HashMap<>();
			documentosfideicomisoMAP.put("id", documentosfideicomiso.getDocumentosfideicomisoId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(documentosfideicomisoMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Documentosfideicomiso no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los documentosfideicomisos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Documentosfideicomiso>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/documentosfideicomiso", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_DOCUMENTOSFIDEICOMISO:READ')")
	public @ResponseBody  List<Map<String, Object>> getDocumentosFideicomisos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Documentosfideicomiso> listDocumentosfideicomiso = null;
	
		if (query==null && _page == 0) {
			listDocumentosfideicomiso = documentosfideicomisoService.listDocumentosfideicomisos(documentosfideicomiso);
			rows = documentosfideicomisoService.getTotalRows();
		} else if (query!= null){
			listDocumentosfideicomiso = documentosfideicomisoService.listDocumentosfideicomisosQuery(documentosfideicomiso, query, _page, 10);
			rows = documentosfideicomisoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listDocumentosfideicomiso = documentosfideicomisoService.listDocumentosfideicomisosPagination(documentosfideicomiso, _page, 10);
			rows = documentosfideicomisoService.getTotalRows();
		}
		
		List<Map<String, Object>> listDocumentosfideicomisoMAP = new ArrayList<>();
		for( Documentosfideicomiso documentosfideicomiso : listDocumentosfideicomiso ){
			Map<String, Object> documentosfideicomisoMAP = new HashMap<>();
			documentosfideicomisoMAP.put("id", documentosfideicomiso.getDocumentosfideicomisoId());
			documentosfideicomisoMAP.put("campo", documentosfideicomiso.getCampo());
			documentosfideicomisoMAP.put("contratofideicomiso", documentosfideicomiso.getContratofideicomiso());
			documentosfideicomisoMAP.put("actasconstitutivas", documentosfideicomiso.getActasconstitutivas());
			documentosfideicomisoMAP.put("cedulafiscal", documentosfideicomiso.getCedulafiscal());
			documentosfideicomisoMAP.put("poderes", documentosfideicomiso.getPoderes());
			documentosfideicomisoMAP.put("identificadores", documentosfideicomiso.getIdentificadores());
			documentosfideicomisoMAP.put("comprobantesdomicilio", documentosfideicomiso.getComprobantesdomicilio());
			documentosfideicomisoMAP.put("formatoskyc", documentosfideicomiso.getFormatoskyc());
			documentosfideicomisoMAP.put("formatoevaluacionriesgo", documentosfideicomiso.getFormatoevaluacionriesgo());
			documentosfideicomisoMAP.put("worldcheck", documentosfideicomiso.getWorldcheck());
			documentosfideicomisoMAP.put("formatoinformacion", documentosfideicomiso.getFormatoinformacion());
			documentosfideicomisoMAP.put("autorizacioncomite", documentosfideicomiso.getAutorizacioncomite());
			documentosfideicomisoMAP.put("firmascomite", documentosfideicomiso.getFirmascomite());
			documentosfideicomisoMAP.put("curp", documentosfideicomiso.getCurp());
			documentosfideicomisoMAP.put("fideicomisoId", documentosfideicomiso.getFideicomisoId().getFideicomisoId());
			
			listDocumentosfideicomisoMAP.add(documentosfideicomisoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listDocumentosfideicomisoMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un documentosfideicomiso.
	 * @param id.
	 * @return Documentosfideicomiso.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/documentosfideicomiso/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_DOCUMENTOSFIDEICOMISO:READ')")
	public @ResponseBody  Map<String, Object> getDocumentosFideicomiso(@PathVariable("id") String id) {	        
	        Documentosfideicomiso documentosfideicomiso = null;
	        
	        UUID uuid = UUID.fromString(id);
	        documentosfideicomiso = documentosfideicomisoService.getDocumentosfideicomiso(uuid);
	        
			Map<String, Object> documentosfideicomisoMAP = new HashMap<>();
			documentosfideicomisoMAP.put("id", documentosfideicomiso.getDocumentosfideicomisoId());
			documentosfideicomisoMAP.put("campo", documentosfideicomiso.getCampo());
			documentosfideicomisoMAP.put("contratofideicomiso", documentosfideicomiso.getContratofideicomiso());
			documentosfideicomisoMAP.put("actasconstitutivas", documentosfideicomiso.getActasconstitutivas());
			documentosfideicomisoMAP.put("cedulafiscal", documentosfideicomiso.getCedulafiscal());
			documentosfideicomisoMAP.put("poderes", documentosfideicomiso.getPoderes());
			documentosfideicomisoMAP.put("identificadores", documentosfideicomiso.getIdentificadores());
			documentosfideicomisoMAP.put("comprobantesdomicilio", documentosfideicomiso.getComprobantesdomicilio());
			documentosfideicomisoMAP.put("formatoskyc", documentosfideicomiso.getFormatoskyc());
			documentosfideicomisoMAP.put("formatoevaluacionriesgo", documentosfideicomiso.getFormatoevaluacionriesgo());
			documentosfideicomisoMAP.put("worldcheck", documentosfideicomiso.getWorldcheck());
			documentosfideicomisoMAP.put("formatoinformacion", documentosfideicomiso.getFormatoinformacion());
			documentosfideicomisoMAP.put("autorizacioncomite", documentosfideicomiso.getAutorizacioncomite());
			documentosfideicomisoMAP.put("firmascomite", documentosfideicomiso.getFirmascomite());
			documentosfideicomisoMAP.put("curp", documentosfideicomiso.getCurp());
			documentosfideicomisoMAP.put("fideicomisoId", documentosfideicomiso.getFideicomisoId());
	        
			return documentosfideicomisoMAP;
	 }
	
}
