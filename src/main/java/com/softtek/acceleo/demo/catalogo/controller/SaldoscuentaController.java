
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los SaldosCuentas. 
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

import com.softtek.acceleo.demo.catalogo.bean.SaldoscuentaBean;
import com.softtek.acceleo.demo.domain.Saldoscuenta;
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.domain.Subfiso;

import com.softtek.acceleo.demo.service.SaldoscuentaService;
import com.softtek.acceleo.demo.service.FideicomisoService;
import com.softtek.acceleo.demo.service.SubfisoService;

/**
 * Clase SaldoscuentaController.
 * @author PSG.
 *
 */
@RestController
public class SaldoscuentaController {

	@Autowired
	private SaldoscuentaService saldoscuentaService;
	
@Autowired
private FideicomisoService fideicomisoService;
@Autowired
private SubfisoService subfisoService;
	
	Saldoscuenta saldoscuenta = new Saldoscuenta();
	/************************************** CREATE  **************************************
	 * Crea un nuevo saldoscuenta.
	 * @param saldoscuenta.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/saldoscuenta", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_SALDOSCUENTA:CREATE')")
	 public ResponseEntity<Map<String, Object>> createSaldoscuenta(@RequestBody SaldoscuentaBean saldoscuentaBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Saldoscuenta saldoscuenta = new Saldoscuenta();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(saldoscuentaBean.getFideicomisoId());
	   			saldoscuenta.setFideicomisoId(fideicomiso);
	   			Subfiso subfiso = subfisoService.getSubfiso(saldoscuentaBean.getSubfisoId());
	   			saldoscuenta.setSubfisoId(subfiso);
	   		
	saldoscuenta.setCuenta(saldoscuentaBean.getCuenta());
	saldoscuenta.setSct(saldoscuentaBean.getSct());
	saldoscuenta.setSsct(saldoscuentaBean.getSsct());
	saldoscuenta.setSssct(saldoscuentaBean.getSssct());
	saldoscuenta.setSsssct(saldoscuentaBean.getSsssct());
	saldoscuenta.setMoneda(saldoscuentaBean.getMoneda());
	saldoscuenta.setAuxiliar1(saldoscuentaBean.getAuxiliar1());
	saldoscuenta.setAuxiliar2(saldoscuentaBean.getAuxiliar2());
	saldoscuenta.setAuxiliar3(saldoscuentaBean.getAuxiliar3());
	saldoscuenta.setSaldoinicial(saldoscuentaBean.getSaldoinicial());
	saldoscuenta.setCargos(saldoscuentaBean.getCargos());
	saldoscuenta.setAbonos(saldoscuentaBean.getAbonos());
	saldoscuenta.setSaldoactual(saldoscuentaBean.getSaldoactual());
	   		
	        saldoscuentaService.addSaldoscuenta(saldoscuenta);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> saldoscuentaMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(saldoscuentaMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "SaldosCuenta no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un saldoscuenta.
	  * @param id.
	  * @param saldoscuenta.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/saldoscuenta/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_SALDOSCUENTA:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarSaldosCuenta(
				@PathVariable("id") String id, 
				@RequestBody SaldoscuentaBean saldoscuentaBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Saldoscuenta saldoscuentaFound = saldoscuentaService.getSaldoscuenta(uuid);
	         
	    if (saldoscuentaFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(saldoscuentaBean.getFideicomisoId());
	   			saldoscuenta.setFideicomisoId(fideicomiso);
	   			Subfiso subfiso = subfisoService.getSubfiso(saldoscuentaBean.getSubfisoId());
	   			saldoscuenta.setSubfisoId(subfiso);
	   		
	saldoscuenta.setCuenta(saldoscuentaBean.getCuenta());
	saldoscuenta.setSct(saldoscuentaBean.getSct());
	saldoscuenta.setSsct(saldoscuentaBean.getSsct());
	saldoscuenta.setSssct(saldoscuentaBean.getSssct());
	saldoscuenta.setSsssct(saldoscuentaBean.getSsssct());
	saldoscuenta.setMoneda(saldoscuentaBean.getMoneda());
	saldoscuenta.setAuxiliar1(saldoscuentaBean.getAuxiliar1());
	saldoscuenta.setAuxiliar2(saldoscuentaBean.getAuxiliar2());
	saldoscuenta.setAuxiliar3(saldoscuentaBean.getAuxiliar3());
	saldoscuenta.setSaldoinicial(saldoscuentaBean.getSaldoinicial());
	saldoscuenta.setCargos(saldoscuentaBean.getCargos());
	saldoscuenta.setAbonos(saldoscuentaBean.getAbonos());
	saldoscuenta.setSaldoactual(saldoscuentaBean.getSaldoactual());
	
		saldoscuenta.setSaldoscuentaId(saldoscuentaFound.getSaldoscuentaId());
		saldoscuentaService.editSaldoscuenta(saldoscuenta);
		
		Map<String, Object> saldoscuentaMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(saldoscuentaMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un saldoscuenta.
	 * @param id.
	 * @return ResponseEntity<Saldoscuenta>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/saldoscuenta/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_SALDOSCUENTA:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteSaldosCuenta(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Saldoscuenta saldoscuenta = saldoscuentaService.getSaldoscuenta(uuid);
		if (saldoscuenta == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			saldoscuentaService.deleteSaldoscuenta(saldoscuenta);
			
			Map<String, Object> saldoscuentaMAP = new HashMap<>();
			saldoscuentaMAP.put("id", saldoscuenta.getSaldoscuentaId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(saldoscuentaMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Saldoscuenta no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los saldoscuentas.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Saldoscuenta>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/saldoscuenta", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_SALDOSCUENTA:READ')")
	public @ResponseBody  List<Map<String, Object>> getSaldosCuentas(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Saldoscuenta> listSaldoscuenta = null;
	
		if (query==null && _page == 0) {
			listSaldoscuenta = saldoscuentaService.listSaldoscuentas(saldoscuenta);
			rows = saldoscuentaService.getTotalRows();
		} else if (query!= null){
			listSaldoscuenta = saldoscuentaService.listSaldoscuentasQuery(saldoscuenta, query, _page, 10);
			rows = saldoscuentaService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listSaldoscuenta = saldoscuentaService.listSaldoscuentasPagination(saldoscuenta, _page, 10);
			rows = saldoscuentaService.getTotalRows();
		}
		
		List<Map<String, Object>> listSaldoscuentaMAP = new ArrayList<>();
		for( Saldoscuenta saldoscuenta : listSaldoscuenta ){
			Map<String, Object> saldoscuentaMAP = new HashMap<>();
			saldoscuentaMAP.put("id", saldoscuenta.getSaldoscuentaId());
			saldoscuentaMAP.put("cuenta", saldoscuenta.getCuenta());
			saldoscuentaMAP.put("sct", saldoscuenta.getSct());
			saldoscuentaMAP.put("ssct", saldoscuenta.getSsct());
			saldoscuentaMAP.put("sssct", saldoscuenta.getSssct());
			saldoscuentaMAP.put("ssssct", saldoscuenta.getSsssct());
			saldoscuentaMAP.put("moneda", saldoscuenta.getMoneda());
			saldoscuentaMAP.put("auxiliar1", saldoscuenta.getAuxiliar1());
			saldoscuentaMAP.put("auxiliar2", saldoscuenta.getAuxiliar2());
			saldoscuentaMAP.put("auxiliar3", saldoscuenta.getAuxiliar3());
			saldoscuentaMAP.put("saldoinicial", saldoscuenta.getSaldoinicial());
			saldoscuentaMAP.put("cargos", saldoscuenta.getCargos());
			saldoscuentaMAP.put("abonos", saldoscuenta.getAbonos());
			saldoscuentaMAP.put("saldoactual", saldoscuenta.getSaldoactual());
			saldoscuentaMAP.put("fideicomisoId", saldoscuenta.getFideicomisoId().getFideicomisoId());
			saldoscuentaMAP.put("subfisoId", saldoscuenta.getSubfisoId().getSubfisoId());
			
			listSaldoscuentaMAP.add(saldoscuentaMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listSaldoscuentaMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un saldoscuenta.
	 * @param id.
	 * @return Saldoscuenta.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/saldoscuenta/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_SALDOSCUENTA:READ')")
	public @ResponseBody  Map<String, Object> getSaldosCuenta(@PathVariable("id") String id) {	        
	        Saldoscuenta saldoscuenta = null;
	        
	        UUID uuid = UUID.fromString(id);
	        saldoscuenta = saldoscuentaService.getSaldoscuenta(uuid);
	        
			Map<String, Object> saldoscuentaMAP = new HashMap<>();
			saldoscuentaMAP.put("id", saldoscuenta.getSaldoscuentaId());
			saldoscuentaMAP.put("cuenta", saldoscuenta.getCuenta());
			saldoscuentaMAP.put("sct", saldoscuenta.getSct());
			saldoscuentaMAP.put("ssct", saldoscuenta.getSsct());
			saldoscuentaMAP.put("sssct", saldoscuenta.getSssct());
			saldoscuentaMAP.put("ssssct", saldoscuenta.getSsssct());
			saldoscuentaMAP.put("moneda", saldoscuenta.getMoneda());
			saldoscuentaMAP.put("auxiliar1", saldoscuenta.getAuxiliar1());
			saldoscuentaMAP.put("auxiliar2", saldoscuenta.getAuxiliar2());
			saldoscuentaMAP.put("auxiliar3", saldoscuenta.getAuxiliar3());
			saldoscuentaMAP.put("saldoinicial", saldoscuenta.getSaldoinicial());
			saldoscuentaMAP.put("cargos", saldoscuenta.getCargos());
			saldoscuentaMAP.put("abonos", saldoscuenta.getAbonos());
			saldoscuentaMAP.put("saldoactual", saldoscuenta.getSaldoactual());
			saldoscuentaMAP.put("fideicomisoId", saldoscuenta.getFideicomisoId());
			saldoscuentaMAP.put("subfisoId", saldoscuenta.getSubfisoId());
	        
			return saldoscuentaMAP;
	 }
	
}
