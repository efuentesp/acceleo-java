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

	/************************************** SEARCH
	 * Obtiene informacion de los documentos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Documento>.
	 */
	@RequestMapping(value = "/documento", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('DOCUMENTOSEARCH')")
	public @ResponseBody  List<Documento> getDocumentos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

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

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listDocumento;
	}

	/************************************** SEARCH
	 * Obtiene informacion de los candidatos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Documento>.
	 */
	@RequestMapping(value = "/documento/candidato/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('DOCUMENTOSEARCH')")
	public @ResponseBody  List<Documento> getDocumentosByCandidato(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {

		List<Documento> listDocumento = null;
		listDocumento = documentoService.listDocumentosByCandidato(documento, id);
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		
		return listDocumento;
	}
	
	/************************************* SEARCH
	 * Obtiene informacion de un documento.
	 * @param id.
	 * @return Documento.
	 */
	@RequestMapping(value = "/iddocumento/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('DOCUMENTOSEARCH')")
	    public @ResponseBody  Documento getDocumento(@PathVariable("id") int id) {	        
	        Documento documento = null;
	        
	        documento = documentoService.getDocumento(id);
			return documento;
	 }

	/*************************** CREATE
	 * Crea un nuevo documento.
	 * @param documento.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/documento", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('DOCUMENTOCREATE')")
	    public ResponseEntity<Void> createDocumento(@RequestBody Documento documento,    UriComponentsBuilder ucBuilder) {
	   
	        documentoService.addDocumento(documento);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/documento/{id}").buildAndExpand(documento.getDocumentoId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un documento.
	  * @param id.
	  * @param documento.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/documento/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('DOCUMENTOUPDATE')") 
	    public ResponseEntity<Documento> actualizarDocumento(
				@PathVariable("id") int id, 
				@RequestBody Documento documento) {
	        
	        Documento documentoFound = documentoService.getDocumento(id);
	         
	        if (documentoFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Documento>(HttpStatus.NOT_FOUND);
	        }
	
	documentoFound.setNombre(documento.getNombre());
	documentoFound.setDescripcion(documento.getDescripcion());
	documentoFound.setDocumentoId(documento.getDocumentoId());

		    documentoService.editDocumento(documentoFound);
	        return new ResponseEntity<Documento>(documentoFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un documento.
		 * @param id.
		 * @return ResponseEntity<Documento>.
		 */
		@RequestMapping(value = "/documento/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('DOCUMENTODELETE')")  
	    public ResponseEntity<Documento> deleteDocumento(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Documento documento = documentoService.getDocumento(id);
	         if (documento == null) {
	             return new ResponseEntity<Documento>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             documentoService.deleteDocumento(documento);
	             return new ResponseEntity<Documento>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Documento no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Documento>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Documento>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un documento.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveDocumento", method = RequestMethod.POST)
	@PreAuthorize("hasRole('DOCUMENTO')")  
	public @ResponseBody String saveDocumento(
			@ModelAttribute("command") DocumentoBean documentoBean) {

		Documento documento = prepareModel(documentoBean);
		documentoService.addDocumento(documento);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un documento.
	 * @param documentoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editDocumento", method = RequestMethod.POST)
	@PreAuthorize("hasRole('DOCUMENTO')")  
	public @ResponseBody String editDocumento(
			@ModelAttribute("command") DocumentoBean documentoBean) {


		Documento documento = prepareModel(documentoBean);
		documentoService.editDocumento(documento);
		return "SUCCESS";
	}

	/**
	 * Agrega un DOCUMENTO.
	 * @param DOCUMENTOBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchDocumento", method = RequestMethod.GET)
	@PreAuthorize("hasRole('DOCUMENTO')")  
	public ModelAndView addDocumento(
			@ModelAttribute("command") DocumentoBean documentoBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Documento documento = null;
		if (documentoBean != null)
			documento = prepareModel(documentoBean);
		model.put("documentos",
				prepareListofBean(documentoService.listDocumentos(documento)));
		return new ModelAndView("searchDocumento", model);
	}

	/**
	 * Elimina un documento.
	 * @param documentoBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteDocumento", method = RequestMethod.POST)
	@PreAuthorize("hasRole('DOCUMENTO')")  
	public ModelAndView deleteDocumento(
			@ModelAttribute("command") DocumentoBean documentoBean,
			BindingResult result) {
		System.out.println("delete " + documentoBean.getDocumentoId());
		documentoService.deleteDocumento(prepareModel(documentoBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("documento", null);
		model.put("documentos",
				prepareListofBean(documentoService.listDocumentos(null)));
		return new ModelAndView("searchDocumento", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryDocumento", method = RequestMethod.GET)
	@PreAuthorize("hasRole('DOCUMENTO')")  
	public ModelAndView entryDocumento() {
		return new ModelAndView("redirect:/searchDocumento");
	}

	private Documento prepareModel(DocumentoBean documentoBean) {
		Documento documento = new Documento();

		//documento.setNotrequireddocumentoId(documentoBean.getSizeId());
		//documento.setDisplayresultdocumentoId(documentoBean.getDocumentoId());
		//documento.setExposedfilterdocumentoId(documentoBean.getDocumentoId());
		//documento.setDisplaymodaldocumentoId(documentoBean.getDocumentoId());
		//documento.setEntitynamedocumentoId(documentoBean.getDocumentoId());
		//documento.setScaffolddocumentoId(documentoBean.getDocumentoId());
		documento.setNombre(documentoBean.getNombre());
		documento.setDescripcion(documentoBean.getDescripcion());
		documento.setDocumentoId(documentoBean.getDocumentoId());
		documentoBean.setDocumentoId(null);

		return documento;
	}

	/**
	 * Convierte un objeto de tipo DocumentoBean a un objeto de tipo Documento.
	 * @param documentoBean.
	 * @return Documento.
	 */
	private List<DocumentoBean> prepareListofBean(List<Documento> documentos) {
		List<DocumentoBean> beans = null;
		if (documentos != null && !documentos.isEmpty()) {
			beans = new ArrayList<DocumentoBean>();
			DocumentoBean bean = null;
			for (Documento documento : documentos) {
				bean = new DocumentoBean();

				//bean.setNotrequireddocumentoId(documento.getSizeId());
				//bean.setDisplayresultdocumentoId(documento.getDocumentoId());
				//bean.setExposedfilterdocumentoId(documento.getDocumentoId());
				//bean.setDisplaymodaldocumentoId(documento.getDocumentoId());
				//bean.setEntitynamedocumentoId(documento.getDocumentoId());
				//bean.setScaffolddocumentoId(documento.getDocumentoId());
				bean.setNombre(documento.getNombre());
				bean.setDescripcion(documento.getDescripcion());
				bean.setDocumentoId(documento.getDocumentoId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


