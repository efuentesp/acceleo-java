
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Kycs. 
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

import com.softtek.acceleo.demo.catalogo.bean.KycBean;
import com.softtek.acceleo.demo.domain.Kyc;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.KycService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase KycController.
 * @author PSG.
 *
 */
@RestController
public class KycController {

	@Autowired
	private KycService kycService;
	
@Autowired
private FideicomisoService fideicomisoService;
	
	Kyc kyc = new Kyc();
	/************************************** CREATE  **************************************
	 * Crea un nuevo kyc.
	 * @param kyc.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/kyc", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_KYC:CREATE')")
	 public ResponseEntity<Map<String, Object>> createKyc(@RequestBody KycBean kycBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Kyc kyc = new Kyc();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(kycBean.getFideicomisoId());
	   			kyc.setFideicomisoId(fideicomiso);
	   		
	kyc.setNombre(kycBean.getNombre());
	kyc.setNumregistro(kycBean.getNumregistro());
	kyc.setOficina(kycBean.getOficina());
	kyc.setConceptoimpresion(kycBean.getConceptoimpresion());
	kyc.setCrbanca(kycBean.getCrbanca());
	kyc.setFolio(kycBean.getFolio());
	   		
	        kycService.addKyc(kyc);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> kycMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(kycMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Kyc no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un kyc.
	  * @param id.
	  * @param kyc.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/kyc/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_KYC:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarKyc(
				@PathVariable("id") String id, 
				@RequestBody KycBean kycBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Kyc kycFound = kycService.getKyc(uuid);
	         
	    if (kycFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(kycBean.getFideicomisoId());
	   			kyc.setFideicomisoId(fideicomiso);
	   		
	kyc.setNombre(kycBean.getNombre());
	kyc.setNumregistro(kycBean.getNumregistro());
	kyc.setOficina(kycBean.getOficina());
	kyc.setConceptoimpresion(kycBean.getConceptoimpresion());
	kyc.setCrbanca(kycBean.getCrbanca());
	kyc.setFolio(kycBean.getFolio());
	
		kyc.setKycId(kycFound.getKycId());
		kycService.editKyc(kyc);
		
		Map<String, Object> kycMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(kycMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un kyc.
	 * @param id.
	 * @return ResponseEntity<Kyc>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/kyc/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_KYC:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteKyc(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Kyc kyc = kycService.getKyc(uuid);
		if (kyc == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			kycService.deleteKyc(kyc);
			
			Map<String, Object> kycMAP = new HashMap<>();
			kycMAP.put("id", kyc.getKycId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(kycMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Kyc no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los kycs.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Kyc>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/kyc", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_KYC:READ')")
	public @ResponseBody  List<Map<String, Object>> getKycs(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Kyc> listKyc = null;
	
		if (query==null && _page == 0) {
			listKyc = kycService.listKycs(kyc);
			rows = kycService.getTotalRows();
		} else if (query!= null){
			listKyc = kycService.listKycsQuery(kyc, query, _page, 10);
			rows = kycService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listKyc = kycService.listKycsPagination(kyc, _page, 10);
			rows = kycService.getTotalRows();
		}
		
		List<Map<String, Object>> listKycMAP = new ArrayList<>();
		for( Kyc kyc : listKyc ){
			Map<String, Object> kycMAP = new HashMap<>();
			kycMAP.put("id", kyc.getKycId());
			kycMAP.put("nombre", kyc.getNombre());
			kycMAP.put("numregistro", kyc.getNumregistro());
			kycMAP.put("oficina", kyc.getOficina());
			kycMAP.put("conceptoimpresion", kyc.getConceptoimpresion());
			kycMAP.put("crbanca", kyc.getCrbanca());
			kycMAP.put("folio", kyc.getFolio());
			kycMAP.put("fideicomisoId", kyc.getFideicomisoId().getFideicomisoId());
			
			listKycMAP.add(kycMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listKycMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un kyc.
	 * @param id.
	 * @return Kyc.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/kyc/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_KYC:READ')")
	public @ResponseBody  Map<String, Object> getKyc(@PathVariable("id") String id) {	        
	        Kyc kyc = null;
	        
	        UUID uuid = UUID.fromString(id);
	        kyc = kycService.getKyc(uuid);
	        
			Map<String, Object> kycMAP = new HashMap<>();
			kycMAP.put("id", kyc.getKycId());
			kycMAP.put("nombre", kyc.getNombre());
			kycMAP.put("numregistro", kyc.getNumregistro());
			kycMAP.put("oficina", kyc.getOficina());
			kycMAP.put("conceptoimpresion", kyc.getConceptoimpresion());
			kycMAP.put("crbanca", kyc.getCrbanca());
			kycMAP.put("folio", kyc.getFolio());
			kycMAP.put("fideicomisoId", kyc.getFideicomisoId());
	        
			return kycMAP;
	 }
	
}
