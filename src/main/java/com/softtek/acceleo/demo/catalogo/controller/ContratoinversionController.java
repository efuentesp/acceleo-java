
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los ContratoInversions. 
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

import com.softtek.acceleo.demo.catalogo.bean.ContratoinversionBean;
import com.softtek.acceleo.demo.domain.Contratoinversion;
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.domain.Subfiso;

import com.softtek.acceleo.demo.service.ContratoinversionService;
import com.softtek.acceleo.demo.service.FideicomisoService;
import com.softtek.acceleo.demo.service.SubfisoService;

/**
 * Clase ContratoinversionController.
 * @author PSG.
 *
 */
@RestController
public class ContratoinversionController {

	@Autowired
	private ContratoinversionService contratoinversionService;
	
@Autowired
private FideicomisoService fideicomisoService;
@Autowired
private SubfisoService subfisoService;
	
	Contratoinversion contratoinversion = new Contratoinversion();
	/************************************** CREATE  **************************************
	 * Crea un nuevo contratoinversion.
	 * @param contratoinversion.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/contratoinversion", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_CONTRATOINVERSION:CREATE')")
	 public ResponseEntity<Map<String, Object>> createContratoinversion(@RequestBody ContratoinversionBean contratoinversionBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Contratoinversion contratoinversion = new Contratoinversion();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(contratoinversionBean.getFideicomisoId());
	   			contratoinversion.setFideicomisoId(fideicomiso);
	   			Subfiso subfiso = subfisoService.getSubfiso(contratoinversionBean.getSubfisoId());
	   			contratoinversion.setSubfisoId(subfiso);
	   		
	contratoinversion.setTipocontrato(contratoinversionBean.getTipocontrato());
	contratoinversion.setIntermediario(contratoinversionBean.getIntermediario());
	contratoinversion.setMoneda(contratoinversionBean.getMoneda());
	contratoinversion.setResparamliq(contratoinversionBean.getResparamliq());
	contratoinversion.setEnviorecursosinv(contratoinversionBean.getEnviorecursosinv());
	contratoinversion.setTransferenciarecdesinver(contratoinversionBean.getTransferenciarecdesinver());
	contratoinversion.setRetenerisr(contratoinversionBean.getRetenerisr());
	contratoinversion.setFechavencimiento(contratoinversionBean.getFechavencimiento());
	contratoinversion.setEstatus(contratoinversionBean.getEstatus());
	contratoinversion.setContratoiversion(contratoinversionBean.getContratoiversion());
	contratoinversion.setContratootrasinst(contratoinversionBean.getContratootrasinst());
	contratoinversion.setNombre(contratoinversionBean.getNombre());
	contratoinversion.setCuenta(contratoinversionBean.getCuenta());
	contratoinversion.setTraspasoentresubfiso(contratoinversionBean.getTraspasoentresubfiso());
	contratoinversion.setFechaapertura(contratoinversionBean.getFechaapertura());
	contratoinversion.setOrigenrecursos(contratoinversionBean.getOrigenrecursos());
	contratoinversion.set_contacto(contratoinversionBean.get_contacto());
	   		
	        contratoinversionService.addContratoinversion(contratoinversion);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> contratoinversionMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(contratoinversionMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "ContratoInversion no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un contratoinversion.
	  * @param id.
	  * @param contratoinversion.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/contratoinversion/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_CONTRATOINVERSION:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarContratoInversion(
				@PathVariable("id") String id, 
				@RequestBody ContratoinversionBean contratoinversionBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Contratoinversion contratoinversionFound = contratoinversionService.getContratoinversion(uuid);
	         
	    if (contratoinversionFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(contratoinversionBean.getFideicomisoId());
	   			contratoinversion.setFideicomisoId(fideicomiso);
	   			Subfiso subfiso = subfisoService.getSubfiso(contratoinversionBean.getSubfisoId());
	   			contratoinversion.setSubfisoId(subfiso);
	   		
	contratoinversion.setTipocontrato(contratoinversionBean.getTipocontrato());
	contratoinversion.setIntermediario(contratoinversionBean.getIntermediario());
	contratoinversion.setMoneda(contratoinversionBean.getMoneda());
	contratoinversion.setResparamliq(contratoinversionBean.getResparamliq());
	contratoinversion.setEnviorecursosinv(contratoinversionBean.getEnviorecursosinv());
	contratoinversion.setTransferenciarecdesinver(contratoinversionBean.getTransferenciarecdesinver());
	contratoinversion.setRetenerisr(contratoinversionBean.getRetenerisr());
	contratoinversion.setFechavencimiento(contratoinversionBean.getFechavencimiento());
	contratoinversion.setEstatus(contratoinversionBean.getEstatus());
	contratoinversion.setContratoiversion(contratoinversionBean.getContratoiversion());
	contratoinversion.setContratootrasinst(contratoinversionBean.getContratootrasinst());
	contratoinversion.setNombre(contratoinversionBean.getNombre());
	contratoinversion.setCuenta(contratoinversionBean.getCuenta());
	contratoinversion.setTraspasoentresubfiso(contratoinversionBean.getTraspasoentresubfiso());
	contratoinversion.setFechaapertura(contratoinversionBean.getFechaapertura());
	contratoinversion.setOrigenrecursos(contratoinversionBean.getOrigenrecursos());
	contratoinversion.set_contacto(contratoinversionBean.get_contacto());
	
		contratoinversion.setContratoinversionId(contratoinversionFound.getContratoinversionId());
		contratoinversionService.editContratoinversion(contratoinversion);
		
		Map<String, Object> contratoinversionMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(contratoinversionMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un contratoinversion.
	 * @param id.
	 * @return ResponseEntity<Contratoinversion>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/contratoinversion/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_CONTRATOINVERSION:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteContratoInversion(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Contratoinversion contratoinversion = contratoinversionService.getContratoinversion(uuid);
		if (contratoinversion == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			contratoinversionService.deleteContratoinversion(contratoinversion);
			
			Map<String, Object> contratoinversionMAP = new HashMap<>();
			contratoinversionMAP.put("id", contratoinversion.getContratoinversionId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(contratoinversionMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Contratoinversion no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los contratoinversions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Contratoinversion>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/contratoinversion", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_CONTRATOINVERSION:READ')")
	public @ResponseBody  List<Map<String, Object>> getContratoInversions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Contratoinversion> listContratoinversion = null;
		System.out.println("************************ contratoinversion: " + contratoinversion.getContratoiversion());
		if (query==null && _page == 0) {
			listContratoinversion = contratoinversionService.listContratoinversions(contratoinversion);
			rows = contratoinversionService.getTotalRows();
		} else if (query!= null){
			listContratoinversion = contratoinversionService.listContratoinversionsQuery(contratoinversion, query, _page, 10);
			rows = contratoinversionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listContratoinversion = contratoinversionService.listContratoinversionsPagination(contratoinversion, _page, 10);
			rows = contratoinversionService.getTotalRows();
		}
		
		List<Map<String, Object>> listContratoinversionMAP = new ArrayList<>();
		for( Contratoinversion contratoinversion : listContratoinversion ){
			Map<String, Object> contratoinversionMAP = new HashMap<>();
			contratoinversionMAP.put("id", contratoinversion.getContratoinversionId());
			contratoinversionMAP.put("tipocontrato", contratoinversion.getTipocontrato());
			contratoinversionMAP.put("intermediario", contratoinversion.getIntermediario());
			contratoinversionMAP.put("moneda", contratoinversion.getMoneda());
			contratoinversionMAP.put("resparamliq", contratoinversion.getResparamliq());
			contratoinversionMAP.put("enviorecursosinv", contratoinversion.getEnviorecursosinv());
			contratoinversionMAP.put("transferenciarecdesinver", contratoinversion.getTransferenciarecdesinver());
			contratoinversionMAP.put("retenerisr", contratoinversion.getRetenerisr());
			contratoinversionMAP.put("fechavencimiento", contratoinversion.getFechavencimiento());
			contratoinversionMAP.put("estatus", contratoinversion.getEstatus());
			contratoinversionMAP.put("contratoiversion", contratoinversion.getContratoiversion());
			contratoinversionMAP.put("contratootrasinst", contratoinversion.getContratootrasinst());
			contratoinversionMAP.put("nombre", contratoinversion.getNombre());
			contratoinversionMAP.put("cuenta", contratoinversion.getCuenta());
			contratoinversionMAP.put("traspasoentresubfiso", contratoinversion.getTraspasoentresubfiso());
			contratoinversionMAP.put("fechaapertura", contratoinversion.getFechaapertura());
			contratoinversionMAP.put("origenrecursos", contratoinversion.getOrigenrecursos());
			contratoinversionMAP.put("_contacto", contratoinversion.get_contacto());
			contratoinversionMAP.put("fideicomisoId", contratoinversion.getFideicomisoId().getFideicomisoId());
			contratoinversionMAP.put("subfisoId", contratoinversion.getSubfisoId().getSubfisoId());
			
			listContratoinversionMAP.add(contratoinversionMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listContratoinversionMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un contratoinversion.
	 * @param id.
	 * @return Contratoinversion.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/contratoinversion/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_CONTRATOINVERSION:READ')")
	public @ResponseBody  Map<String, Object> getContratoInversion(@PathVariable("id") String id) {	        
	        Contratoinversion contratoinversion = null;
	        
	        UUID uuid = UUID.fromString(id);
	        contratoinversion = contratoinversionService.getContratoinversion(uuid);
	        
			Map<String, Object> contratoinversionMAP = new HashMap<>();
			contratoinversionMAP.put("id", contratoinversion.getContratoinversionId());
			contratoinversionMAP.put("tipocontrato", contratoinversion.getTipocontrato());
			contratoinversionMAP.put("intermediario", contratoinversion.getIntermediario());
			contratoinversionMAP.put("moneda", contratoinversion.getMoneda());
			contratoinversionMAP.put("resparamliq", contratoinversion.getResparamliq());
			contratoinversionMAP.put("enviorecursosinv", contratoinversion.getEnviorecursosinv());
			contratoinversionMAP.put("transferenciarecdesinver", contratoinversion.getTransferenciarecdesinver());
			contratoinversionMAP.put("retenerisr", contratoinversion.getRetenerisr());
			contratoinversionMAP.put("fechavencimiento", contratoinversion.getFechavencimiento());
			contratoinversionMAP.put("estatus", contratoinversion.getEstatus());
			contratoinversionMAP.put("contratoiversion", contratoinversion.getContratoiversion());
			contratoinversionMAP.put("contratootrasinst", contratoinversion.getContratootrasinst());
			contratoinversionMAP.put("nombre", contratoinversion.getNombre());
			contratoinversionMAP.put("cuenta", contratoinversion.getCuenta());
			contratoinversionMAP.put("traspasoentresubfiso", contratoinversion.getTraspasoentresubfiso());
			contratoinversionMAP.put("fechaapertura", contratoinversion.getFechaapertura());
			contratoinversionMAP.put("origenrecursos", contratoinversion.getOrigenrecursos());
			contratoinversionMAP.put("_contacto", contratoinversion.get_contacto());
			contratoinversionMAP.put("fideicomisoId", contratoinversion.getFideicomisoId());
			contratoinversionMAP.put("subfisoId", contratoinversion.getSubfisoId());
	        
			return contratoinversionMAP;
	 }
	
}
