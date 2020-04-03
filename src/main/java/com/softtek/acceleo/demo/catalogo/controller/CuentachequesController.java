
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los CuentaChequess. 
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

import com.softtek.acceleo.demo.catalogo.bean.CuentachequesBean;
import com.softtek.acceleo.demo.domain.Cuentacheques;
import com.softtek.acceleo.demo.domain.Fideicomitente;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.CuentachequesService;
import com.softtek.acceleo.demo.service.FideicomitenteService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase CuentachequesController.
 * @author PSG.
 *
 */
@RestController
public class CuentachequesController {

	@Autowired
	private CuentachequesService cuentachequesService;
	
@Autowired
private FideicomitenteService fideicomitenteService;
@Autowired
private FideicomisoService fideicomisoService;
	
	Cuentacheques cuentacheques = new Cuentacheques();
	/************************************** CREATE  **************************************
	 * Crea un nuevo cuentacheques.
	 * @param cuentacheques.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/cuentacheques", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_CUENTACHEQUES:CREATE')")
	 public ResponseEntity<Map<String, Object>> createCuentacheques(@RequestBody CuentachequesBean cuentachequesBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Cuentacheques cuentacheques = new Cuentacheques();
	   	
	   			Fideicomitente fideicomitente = fideicomitenteService.getFideicomitente(cuentachequesBean.getFideicomitenteId());
	   			cuentacheques.setFideicomitenteId(fideicomitente);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(cuentachequesBean.getFideicomisoId());
	   			cuentacheques.setFideicomisoId(fideicomiso);
	   		
	cuentacheques.setTipopersona(cuentachequesBean.getTipopersona());
	cuentacheques.setTipocuenta(cuentachequesBean.getTipocuenta());
	cuentacheques.setTipopago(cuentachequesBean.getTipopago());
	cuentacheques.setBancospei(cuentachequesBean.getBancospei());
	cuentacheques.setBanco(cuentachequesBean.getBanco());
	cuentacheques.setDombanco(cuentachequesBean.getDombanco());
	cuentacheques.setMoneda(cuentachequesBean.getMoneda());
	cuentacheques.setClavevostro(cuentachequesBean.getClavevostro());
	cuentacheques.setNumcuenta(cuentachequesBean.getNumcuenta());
	cuentacheques.setDombeneficiario(cuentachequesBean.getDombeneficiario());
	cuentacheques.setPlazainternacional(cuentachequesBean.getPlazainternacional());
	cuentacheques.setPais(cuentachequesBean.getPais());
	cuentacheques.setClavesiacinst(cuentachequesBean.getClavesiacinst());
	cuentacheques.setConveniociedie(cuentachequesBean.getConveniociedie());
	cuentacheques.setEstatus(cuentachequesBean.getEstatus());
	cuentacheques.setClabe(cuentachequesBean.getClabe());
	cuentacheques.setCuentachequera(cuentachequesBean.getCuentachequera());
	cuentacheques.setFechavence(cuentachequesBean.getFechavence());
	cuentacheques.setNumabbasswift(cuentachequesBean.getNumabbasswift());
	cuentacheques.setConceptosiac(cuentachequesBean.getConceptosiac());
	cuentacheques.setRefciedie(cuentachequesBean.getRefciedie());
	cuentacheques.setAutorizacion(cuentachequesBean.getAutorizacion());
	   		
	        cuentachequesService.addCuentacheques(cuentacheques);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> cuentachequesMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(cuentachequesMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "CuentaCheques no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un cuentacheques.
	  * @param id.
	  * @param cuentacheques.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/cuentacheques/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_CUENTACHEQUES:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarCuentaCheques(
				@PathVariable("id") String id, 
				@RequestBody CuentachequesBean cuentachequesBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Cuentacheques cuentachequesFound = cuentachequesService.getCuentacheques(uuid);
	         
	    if (cuentachequesFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomitente fideicomitente = fideicomitenteService.getFideicomitente(cuentachequesBean.getFideicomitenteId());
	   			cuentacheques.setFideicomitenteId(fideicomitente);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(cuentachequesBean.getFideicomisoId());
	   			cuentacheques.setFideicomisoId(fideicomiso);
	   		
	cuentacheques.setTipopersona(cuentachequesBean.getTipopersona());
	cuentacheques.setTipocuenta(cuentachequesBean.getTipocuenta());
	cuentacheques.setTipopago(cuentachequesBean.getTipopago());
	cuentacheques.setBancospei(cuentachequesBean.getBancospei());
	cuentacheques.setBanco(cuentachequesBean.getBanco());
	cuentacheques.setDombanco(cuentachequesBean.getDombanco());
	cuentacheques.setMoneda(cuentachequesBean.getMoneda());
	cuentacheques.setClavevostro(cuentachequesBean.getClavevostro());
	cuentacheques.setNumcuenta(cuentachequesBean.getNumcuenta());
	cuentacheques.setDombeneficiario(cuentachequesBean.getDombeneficiario());
	cuentacheques.setPlazainternacional(cuentachequesBean.getPlazainternacional());
	cuentacheques.setPais(cuentachequesBean.getPais());
	cuentacheques.setClavesiacinst(cuentachequesBean.getClavesiacinst());
	cuentacheques.setConveniociedie(cuentachequesBean.getConveniociedie());
	cuentacheques.setEstatus(cuentachequesBean.getEstatus());
	cuentacheques.setClabe(cuentachequesBean.getClabe());
	cuentacheques.setCuentachequera(cuentachequesBean.getCuentachequera());
	cuentacheques.setFechavence(cuentachequesBean.getFechavence());
	cuentacheques.setNumabbasswift(cuentachequesBean.getNumabbasswift());
	cuentacheques.setConceptosiac(cuentachequesBean.getConceptosiac());
	cuentacheques.setRefciedie(cuentachequesBean.getRefciedie());
	cuentacheques.setAutorizacion(cuentachequesBean.getAutorizacion());
	
		cuentacheques.setCuentachequesId(cuentachequesFound.getCuentachequesId());
		cuentachequesService.editCuentacheques(cuentacheques);
		
		Map<String, Object> cuentachequesMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(cuentachequesMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un cuentacheques.
	 * @param id.
	 * @return ResponseEntity<Cuentacheques>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/cuentacheques/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_CUENTACHEQUES:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteCuentaCheques(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Cuentacheques cuentacheques = cuentachequesService.getCuentacheques(uuid);
		if (cuentacheques == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			cuentachequesService.deleteCuentacheques(cuentacheques);
			
			Map<String, Object> cuentachequesMAP = new HashMap<>();
			cuentachequesMAP.put("id", cuentacheques.getCuentachequesId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(cuentachequesMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Cuentacheques no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los cuentachequess.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Cuentacheques>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/cuentacheques", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_CUENTACHEQUES:READ')")
	public @ResponseBody  List<Map<String, Object>> getCuentaChequess(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Cuentacheques> listCuentacheques = null;
	
		if (query==null && _page == 0) {
			listCuentacheques = cuentachequesService.listCuentachequess(cuentacheques);
			rows = cuentachequesService.getTotalRows();
		} else if (query!= null){
			listCuentacheques = cuentachequesService.listCuentachequessQuery(cuentacheques, query, _page, 10);
			rows = cuentachequesService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listCuentacheques = cuentachequesService.listCuentachequessPagination(cuentacheques, _page, 10);
			rows = cuentachequesService.getTotalRows();
		}
		
		List<Map<String, Object>> listCuentachequesMAP = new ArrayList<>();
		for( Cuentacheques cuentacheques : listCuentacheques ){
			Map<String, Object> cuentachequesMAP = new HashMap<>();
			cuentachequesMAP.put("id", cuentacheques.getCuentachequesId());
			cuentachequesMAP.put("tipopersona", cuentacheques.getTipopersona());
			cuentachequesMAP.put("tipocuenta", cuentacheques.getTipocuenta());
			cuentachequesMAP.put("tipopago", cuentacheques.getTipopago());
			cuentachequesMAP.put("bancospei", cuentacheques.getBancospei());
			cuentachequesMAP.put("banco", cuentacheques.getBanco());
			cuentachequesMAP.put("dombanco", cuentacheques.getDombanco());
			cuentachequesMAP.put("moneda", cuentacheques.getMoneda());
			cuentachequesMAP.put("clavevostro", cuentacheques.getClavevostro());
			cuentachequesMAP.put("numcuenta", cuentacheques.getNumcuenta());
			cuentachequesMAP.put("dombeneficiario", cuentacheques.getDombeneficiario());
			cuentachequesMAP.put("plazainternacional", cuentacheques.getPlazainternacional());
			cuentachequesMAP.put("pais", cuentacheques.getPais());
			cuentachequesMAP.put("clavesiacinst", cuentacheques.getClavesiacinst());
			cuentachequesMAP.put("conveniociedie", cuentacheques.getConveniociedie());
			cuentachequesMAP.put("estatus", cuentacheques.getEstatus());
			cuentachequesMAP.put("clabe", cuentacheques.getClabe());
			cuentachequesMAP.put("cuentachequera", cuentacheques.getCuentachequera());
			cuentachequesMAP.put("fechavence", cuentacheques.getFechavence());
			cuentachequesMAP.put("numabbasswift", cuentacheques.getNumabbasswift());
			cuentachequesMAP.put("conceptosiac", cuentacheques.getConceptosiac());
			cuentachequesMAP.put("refciedie", cuentacheques.getRefciedie());
			cuentachequesMAP.put("autorizacion", cuentacheques.getAutorizacion());
			cuentachequesMAP.put("fideicomitenteId", cuentacheques.getFideicomitenteId().getFideicomitenteId());
			cuentachequesMAP.put("fideicomisoId", cuentacheques.getFideicomisoId().getFideicomisoId());
			
			listCuentachequesMAP.add(cuentachequesMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listCuentachequesMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un cuentacheques.
	 * @param id.
	 * @return Cuentacheques.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/cuentacheques/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_CUENTACHEQUES:READ')")
	public @ResponseBody  Map<String, Object> getCuentaCheques(@PathVariable("id") String id) {	        
	        Cuentacheques cuentacheques = null;
	        
	        UUID uuid = UUID.fromString(id);
	        cuentacheques = cuentachequesService.getCuentacheques(uuid);
	        
			Map<String, Object> cuentachequesMAP = new HashMap<>();
			cuentachequesMAP.put("id", cuentacheques.getCuentachequesId());
			cuentachequesMAP.put("tipopersona", cuentacheques.getTipopersona());
			cuentachequesMAP.put("tipocuenta", cuentacheques.getTipocuenta());
			cuentachequesMAP.put("tipopago", cuentacheques.getTipopago());
			cuentachequesMAP.put("bancospei", cuentacheques.getBancospei());
			cuentachequesMAP.put("banco", cuentacheques.getBanco());
			cuentachequesMAP.put("dombanco", cuentacheques.getDombanco());
			cuentachequesMAP.put("moneda", cuentacheques.getMoneda());
			cuentachequesMAP.put("clavevostro", cuentacheques.getClavevostro());
			cuentachequesMAP.put("numcuenta", cuentacheques.getNumcuenta());
			cuentachequesMAP.put("dombeneficiario", cuentacheques.getDombeneficiario());
			cuentachequesMAP.put("plazainternacional", cuentacheques.getPlazainternacional());
			cuentachequesMAP.put("pais", cuentacheques.getPais());
			cuentachequesMAP.put("clavesiacinst", cuentacheques.getClavesiacinst());
			cuentachequesMAP.put("conveniociedie", cuentacheques.getConveniociedie());
			cuentachequesMAP.put("estatus", cuentacheques.getEstatus());
			cuentachequesMAP.put("clabe", cuentacheques.getClabe());
			cuentachequesMAP.put("cuentachequera", cuentacheques.getCuentachequera());
			cuentachequesMAP.put("fechavence", cuentacheques.getFechavence());
			cuentachequesMAP.put("numabbasswift", cuentacheques.getNumabbasswift());
			cuentachequesMAP.put("conceptosiac", cuentacheques.getConceptosiac());
			cuentachequesMAP.put("refciedie", cuentacheques.getRefciedie());
			cuentachequesMAP.put("autorizacion", cuentacheques.getAutorizacion());
			cuentachequesMAP.put("fideicomitenteId", cuentacheques.getFideicomitenteId());
			cuentachequesMAP.put("fideicomisoId", cuentacheques.getFideicomisoId());
	        
			return cuentachequesMAP;
	 }
	
}
