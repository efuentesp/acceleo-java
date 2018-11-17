/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Documentos. 
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

import com.softtek.acceleo.demo.catalogo.bean.DocumentoBean;
import com.softtek.acceleo.demo.domain.Documento;
import com.softtek.acceleo.demo.service.DocumentoService;

/**
 * Clase DocumentoController.
 * @author PSG.
 *
 */
@RestController
public class DocumentoController {

	@Autowired
	private DocumentoService documentoService;
	
	Documento documento = new Documento();
	/************************************** CREATE  **************************************
	 * Crea un nuevo documento.
	 * @param documento.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/srp/documento", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_DOCUMENTO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createDocumento(@RequestBody Documento documento,    UriComponentsBuilder ucBuilder) {
	   try{
	        documentoService.addDocumento(documento);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/documento/{id}").buildAndExpand(documento.getDocumentoId()).toUri());
	        
		        	Documento documentoFound = documentoService.getDocumento(documento.getDocumentoId());
	
			Map<String, Object> documentoMAP = new HashMap<>();
			documentoMAP.put("id", documentoFound.getDocumentoId());
			/*documentoFound.setNombre(documento.getNombre());*/
			documentoMAP.put("nombre", documento.getNombre());
			/*documentoFound.setDescripcion(documento.getDescripcion());*/
			documentoMAP.put("descripcion", documento.getDescripcion());
			/*documentoFound.setSize(documento.getSize());*/
			documentoMAP.put("size", documento.getSize());
			
		        	return new ResponseEntity<Map<String, Object>>(documentoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Documento no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un documento.
	  * @param id.
	  * @param documento.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/srp/documento/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_DOCUMENTO:UPDATE')") 
	    public ResponseEntity<Map<String, Object>> actualizarDocumento(
				@PathVariable("id") String id, 
				@RequestBody Documento documento) {
	        
	        UUID uuid = UUID.fromString(id);
	        Documento documentoFound = documentoService.getDocumento(uuid);
	         
	        if (documentoFound==null) {
	            return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	        }
	
		documento.setDocumentoId(documentoFound.getDocumentoId());
		documentoService.editDocumento(documento);
		
		Map<String, Object> documentoMAP = new HashMap<>();
		documentoMAP.put("id", documentoFound.getDocumentoId());
		/*documentoFound.setNombre(documento.getNombre());*/
		documentoMAP.put("nombre", documento.getNombre());
		/*documentoFound.setDescripcion(documento.getDescripcion());*/
		documentoMAP.put("descripcion", documento.getDescripcion());
		/*documentoFound.setSize(documento.getSize());*/
		documentoMAP.put("size", documento.getSize());
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(documentoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un documento.
	 * @param id.
	 * @return ResponseEntity<Documento>.
	 */
	@RequestMapping(value = "/srp/documento/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_DOCUMENTO:DELETE')")  
		    public ResponseEntity<Map<String, Object>> deleteDocumento(@PathVariable("id") String id) {
		  
		    	 UUID uuid = UUID.fromString(id);
		         Documento documento = documentoService.getDocumento(uuid);
		         if (documento == null) {
		             return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		         }
		  
	           	 try{
		             documentoService.deleteDocumento(documento);
		             
			 Map<String, Object> documentoMAP = new HashMap<>();
			 documentoMAP.put("id", documento.getDocumentoId());
	/*documentoFound.setNombre(documento.getNombre());*/
	documentoMAP.put("nombre", documento.getNombre());
	/*documentoFound.setDescripcion(documento.getDescripcion());*/
	documentoMAP.put("descripcion", documento.getDescripcion());
	/*documentoFound.setSize(documento.getSize());*/
	documentoMAP.put("size", documento.getSize());
		             
		             HttpHeaders headers = new HttpHeaders();
		             return new ResponseEntity<Map<String, Object>>(documentoMAP, headers, HttpStatus.OK);
		         }catch (Exception e) {
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: "+e);
		        	 responseHeaders.set("Message", "Documento no se puede eliminar debido a que esta asociado con otra entidad.");	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los documentos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Documento>.
	 */
	 
	@RequestMapping(value = "/srp/documento", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_DOCUMENTO:READ')")
	public @ResponseBody  List<Map<String, Object>> getDocumentos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
		       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
		
		List<Documento> listDocumento = null;
		
		if (query==null && _page == 0) {
		       		listDocumento = documentoService.listDocumentos(documento);
			rows = documentoService.getTotalRows();
		} else if (query!= null){
			listDocumento = documentoService.listDocumentosQuery(documento, query, _page, 10);
			rows = documentoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listDocumento = documentoService.listDocumentosPagination(documento, _page, 10);
			rows = documentoService.getTotalRows();
		}
		
		List<Map<String, Object>> listDocumentoMAP = new ArrayList<>();
		for( Documento documento : listDocumento ){
			Map<String, Object> documentoMAP = new HashMap<>();
			documentoMAP.put("id", documento.getDocumentoId());
			/*documentoFound.setNombre(documento.getNombre());*/
			documentoMAP.put("nombre", documento.getNombre());
			/*documentoFound.setDescripcion(documento.getDescripcion());*/
			documentoMAP.put("descripcion", documento.getDescripcion());
			/*documentoFound.setSize(documento.getSize());*/
			documentoMAP.put("size", documento.getSize());
			
			listDocumentoMAP.add(documentoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listDocumentoMAP;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un documento.
	 * @param id.
	 * @return Documento.
	 */
	@RequestMapping(value = "/srp/documento/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_DOCUMENTO:READ')")
	public @ResponseBody  Map<String, Object> getDocumento(@PathVariable("id") String id) {	        
	        Documento documento = null;
	        
	        UUID uuid = UUID.fromString(id);
	        documento = documentoService.getDocumento(uuid);
	        
			Map<String, Object> documentoMAP = new HashMap<>();
			documentoMAP.put("id", documento.getDocumentoId());
			/*documentoFound.setNombre(documento.getNombre());*/
			documentoMAP.put("nombre", documento.getNombre());
			/*documentoFound.setDescripcion(documento.getDescripcion());*/
			documentoMAP.put("descripcion", documento.getDescripcion());
			/*documentoFound.setSize(documento.getSize());*/
			documentoMAP.put("size", documento.getSize());
	        
	        
			return documentoMAP;
	 }
	
}
