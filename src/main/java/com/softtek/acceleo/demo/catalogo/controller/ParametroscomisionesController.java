
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los ParametrosComisioness. 
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

import com.softtek.acceleo.demo.catalogo.bean.ParametroscomisionesBean;
import com.softtek.acceleo.demo.domain.Parametroscomisiones;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.ParametroscomisionesService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase ParametroscomisionesController.
 * @author PSG.
 *
 */
@RestController
public class ParametroscomisionesController {

	@Autowired
	private ParametroscomisionesService parametroscomisionesService;
	
@Autowired
private FideicomisoService fideicomisoService;
	
	Parametroscomisiones parametroscomisiones = new Parametroscomisiones();
	/************************************** CREATE  **************************************
	 * Crea un nuevo parametroscomisiones.
	 * @param parametroscomisiones.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/parametroscomisiones", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_PARAMETROSCOMISIONES:CREATE')")
	 public ResponseEntity<Map<String, Object>> createParametroscomisiones(@RequestBody ParametroscomisionesBean parametroscomisionesBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Parametroscomisiones parametroscomisiones = new Parametroscomisiones();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(parametroscomisionesBean.getFideicomisoId());
	   			parametroscomisiones.setFideicomisoId(fideicomiso);
	   		
	parametroscomisiones.setTipocalculo(parametroscomisionesBean.getTipocalculo());
	parametroscomisiones.setAquiensecobra(parametroscomisionesBean.getAquiensecobra());
	parametroscomisiones.setMontoaceptacion(parametroscomisionesBean.getMontoaceptacion());
	parametroscomisiones.setImporteanualizado(parametroscomisionesBean.getImporteanualizado());
	parametroscomisiones.setPeriodicidad(parametroscomisionesBean.getPeriodicidad());
	parametroscomisiones.setCalculoaldiaprimero(parametroscomisionesBean.getCalculoaldiaprimero());
	parametroscomisiones.setReevaluacion(parametroscomisionesBean.getReevaluacion());
	parametroscomisiones.setFechaconstitucion(parametroscomisionesBean.getFechaconstitucion());
	parametroscomisiones.setFechapivote(parametroscomisionesBean.getFechapivote());
	parametroscomisiones.setFechaproxcalculo(parametroscomisionesBean.getFechaproxcalculo());
	parametroscomisiones.setMetodopago(parametroscomisionesBean.getMetodopago());
	parametroscomisiones.setAquienfactura(parametroscomisionesBean.getAquienfactura());
	parametroscomisiones.setNombre(parametroscomisionesBean.getNombre());
	parametroscomisiones.setComentario(parametroscomisionesBean.getComentario());
	parametroscomisiones.setEstatus(parametroscomisionesBean.getEstatus());
	parametroscomisiones.setPenasconvencionales(parametroscomisionesBean.getPenasconvencionales());
	parametroscomisiones.setMoneda(parametroscomisionesBean.getMoneda());
	parametroscomisiones.setInteres(parametroscomisionesBean.getInteres());
	parametroscomisiones.setTipoiva(parametroscomisionesBean.getTipoiva());
	parametroscomisiones.setDiacorte(parametroscomisionesBean.getDiacorte());
	parametroscomisiones.setFechaprimercalculo(parametroscomisionesBean.getFechaprimercalculo());
	parametroscomisiones.setFechaultimocalculo(parametroscomisionesBean.getFechaultimocalculo());
	parametroscomisiones.setCuentapago(parametroscomisionesBean.getCuentapago());
	parametroscomisiones.setNumero(parametroscomisionesBean.getNumero());
	parametroscomisiones.setSituacionmorosidad(parametroscomisionesBean.getSituacionmorosidad());
	   		
	        parametroscomisionesService.addParametroscomisiones(parametroscomisiones);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> parametroscomisionesMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(parametroscomisionesMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "ParametrosComisiones no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un parametroscomisiones.
	  * @param id.
	  * @param parametroscomisiones.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/parametroscomisiones/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_PARAMETROSCOMISIONES:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarParametrosComisiones(
				@PathVariable("id") String id, 
				@RequestBody ParametroscomisionesBean parametroscomisionesBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Parametroscomisiones parametroscomisionesFound = parametroscomisionesService.getParametroscomisiones(uuid);
	         
	    if (parametroscomisionesFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(parametroscomisionesBean.getFideicomisoId());
	   			parametroscomisiones.setFideicomisoId(fideicomiso);
	   		
	parametroscomisiones.setTipocalculo(parametroscomisionesBean.getTipocalculo());
	parametroscomisiones.setAquiensecobra(parametroscomisionesBean.getAquiensecobra());
	parametroscomisiones.setMontoaceptacion(parametroscomisionesBean.getMontoaceptacion());
	parametroscomisiones.setImporteanualizado(parametroscomisionesBean.getImporteanualizado());
	parametroscomisiones.setPeriodicidad(parametroscomisionesBean.getPeriodicidad());
	parametroscomisiones.setCalculoaldiaprimero(parametroscomisionesBean.getCalculoaldiaprimero());
	parametroscomisiones.setReevaluacion(parametroscomisionesBean.getReevaluacion());
	parametroscomisiones.setFechaconstitucion(parametroscomisionesBean.getFechaconstitucion());
	parametroscomisiones.setFechapivote(parametroscomisionesBean.getFechapivote());
	parametroscomisiones.setFechaproxcalculo(parametroscomisionesBean.getFechaproxcalculo());
	parametroscomisiones.setMetodopago(parametroscomisionesBean.getMetodopago());
	parametroscomisiones.setAquienfactura(parametroscomisionesBean.getAquienfactura());
	parametroscomisiones.setNombre(parametroscomisionesBean.getNombre());
	parametroscomisiones.setComentario(parametroscomisionesBean.getComentario());
	parametroscomisiones.setEstatus(parametroscomisionesBean.getEstatus());
	parametroscomisiones.setPenasconvencionales(parametroscomisionesBean.getPenasconvencionales());
	parametroscomisiones.setMoneda(parametroscomisionesBean.getMoneda());
	parametroscomisiones.setInteres(parametroscomisionesBean.getInteres());
	parametroscomisiones.setTipoiva(parametroscomisionesBean.getTipoiva());
	parametroscomisiones.setDiacorte(parametroscomisionesBean.getDiacorte());
	parametroscomisiones.setFechaprimercalculo(parametroscomisionesBean.getFechaprimercalculo());
	parametroscomisiones.setFechaultimocalculo(parametroscomisionesBean.getFechaultimocalculo());
	parametroscomisiones.setCuentapago(parametroscomisionesBean.getCuentapago());
	parametroscomisiones.setNumero(parametroscomisionesBean.getNumero());
	parametroscomisiones.setSituacionmorosidad(parametroscomisionesBean.getSituacionmorosidad());
	
		parametroscomisiones.setParametroscomisionesId(parametroscomisionesFound.getParametroscomisionesId());
		parametroscomisionesService.editParametroscomisiones(parametroscomisiones);
		
		Map<String, Object> parametroscomisionesMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(parametroscomisionesMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un parametroscomisiones.
	 * @param id.
	 * @return ResponseEntity<Parametroscomisiones>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/parametroscomisiones/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_PARAMETROSCOMISIONES:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteParametrosComisiones(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Parametroscomisiones parametroscomisiones = parametroscomisionesService.getParametroscomisiones(uuid);
		if (parametroscomisiones == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			parametroscomisionesService.deleteParametroscomisiones(parametroscomisiones);
			
			Map<String, Object> parametroscomisionesMAP = new HashMap<>();
			parametroscomisionesMAP.put("id", parametroscomisiones.getParametroscomisionesId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(parametroscomisionesMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Parametroscomisiones no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los parametroscomisioness.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Parametroscomisiones>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/parametroscomisiones", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_PARAMETROSCOMISIONES:READ')")
	public @ResponseBody  List<Map<String, Object>> getParametrosComisioness(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Parametroscomisiones> listParametroscomisiones = null;
	
		if (query==null && _page == 0) {
			listParametroscomisiones = parametroscomisionesService.listParametroscomisioness(parametroscomisiones);
			rows = parametroscomisionesService.getTotalRows();
		} else if (query!= null){
			listParametroscomisiones = parametroscomisionesService.listParametroscomisionessQuery(parametroscomisiones, query, _page, 10);
			rows = parametroscomisionesService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listParametroscomisiones = parametroscomisionesService.listParametroscomisionessPagination(parametroscomisiones, _page, 10);
			rows = parametroscomisionesService.getTotalRows();
		}
		
		List<Map<String, Object>> listParametroscomisionesMAP = new ArrayList<>();
		for( Parametroscomisiones parametroscomisiones : listParametroscomisiones ){
			Map<String, Object> parametroscomisionesMAP = new HashMap<>();
			parametroscomisionesMAP.put("id", parametroscomisiones.getParametroscomisionesId());
			parametroscomisionesMAP.put("tipocalculo", parametroscomisiones.getTipocalculo());
			parametroscomisionesMAP.put("aquiensecobra", parametroscomisiones.getAquiensecobra());
			parametroscomisionesMAP.put("montoaceptacion", parametroscomisiones.getMontoaceptacion());
			parametroscomisionesMAP.put("importeanualizado", parametroscomisiones.getImporteanualizado());
			parametroscomisionesMAP.put("periodicidad", parametroscomisiones.getPeriodicidad());
			parametroscomisionesMAP.put("calculoaldiaprimero", parametroscomisiones.getCalculoaldiaprimero());
			parametroscomisionesMAP.put("reevaluacion", parametroscomisiones.getReevaluacion());
			parametroscomisionesMAP.put("fechaconstitucion", parametroscomisiones.getFechaconstitucion());
			parametroscomisionesMAP.put("fechapivote", parametroscomisiones.getFechapivote());
			parametroscomisionesMAP.put("fechaproxcalculo", parametroscomisiones.getFechaproxcalculo());
			parametroscomisionesMAP.put("metodopago", parametroscomisiones.getMetodopago());
			parametroscomisionesMAP.put("aquienfactura", parametroscomisiones.getAquienfactura());
			parametroscomisionesMAP.put("nombre", parametroscomisiones.getNombre());
			parametroscomisionesMAP.put("comentario", parametroscomisiones.getComentario());
			parametroscomisionesMAP.put("estatus", parametroscomisiones.getEstatus());
			parametroscomisionesMAP.put("penasconvencionales", parametroscomisiones.getPenasconvencionales());
			parametroscomisionesMAP.put("moneda", parametroscomisiones.getMoneda());
			parametroscomisionesMAP.put("interes", parametroscomisiones.getInteres());
			parametroscomisionesMAP.put("tipoiva", parametroscomisiones.getTipoiva());
			parametroscomisionesMAP.put("diacorte", parametroscomisiones.getDiacorte());
			parametroscomisionesMAP.put("fechaprimercalculo", parametroscomisiones.getFechaprimercalculo());
			parametroscomisionesMAP.put("fechaultimocalculo", parametroscomisiones.getFechaultimocalculo());
			parametroscomisionesMAP.put("cuentapago", parametroscomisiones.getCuentapago());
			parametroscomisionesMAP.put("numero", parametroscomisiones.getNumero());
			parametroscomisionesMAP.put("situacionmorosidad", parametroscomisiones.getSituacionmorosidad());
			parametroscomisionesMAP.put("fideicomisoId", parametroscomisiones.getFideicomisoId().getFideicomisoId());
			
			listParametroscomisionesMAP.add(parametroscomisionesMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listParametroscomisionesMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un parametroscomisiones.
	 * @param id.
	 * @return Parametroscomisiones.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/parametroscomisiones/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_PARAMETROSCOMISIONES:READ')")
	public @ResponseBody  Map<String, Object> getParametrosComisiones(@PathVariable("id") String id) {	        
	        Parametroscomisiones parametroscomisiones = null;
	        
	        UUID uuid = UUID.fromString(id);
	        parametroscomisiones = parametroscomisionesService.getParametroscomisiones(uuid);
	        
			Map<String, Object> parametroscomisionesMAP = new HashMap<>();
			parametroscomisionesMAP.put("id", parametroscomisiones.getParametroscomisionesId());
			parametroscomisionesMAP.put("tipocalculo", parametroscomisiones.getTipocalculo());
			parametroscomisionesMAP.put("aquiensecobra", parametroscomisiones.getAquiensecobra());
			parametroscomisionesMAP.put("montoaceptacion", parametroscomisiones.getMontoaceptacion());
			parametroscomisionesMAP.put("importeanualizado", parametroscomisiones.getImporteanualizado());
			parametroscomisionesMAP.put("periodicidad", parametroscomisiones.getPeriodicidad());
			parametroscomisionesMAP.put("calculoaldiaprimero", parametroscomisiones.getCalculoaldiaprimero());
			parametroscomisionesMAP.put("reevaluacion", parametroscomisiones.getReevaluacion());
			parametroscomisionesMAP.put("fechaconstitucion", parametroscomisiones.getFechaconstitucion());
			parametroscomisionesMAP.put("fechapivote", parametroscomisiones.getFechapivote());
			parametroscomisionesMAP.put("fechaproxcalculo", parametroscomisiones.getFechaproxcalculo());
			parametroscomisionesMAP.put("metodopago", parametroscomisiones.getMetodopago());
			parametroscomisionesMAP.put("aquienfactura", parametroscomisiones.getAquienfactura());
			parametroscomisionesMAP.put("nombre", parametroscomisiones.getNombre());
			parametroscomisionesMAP.put("comentario", parametroscomisiones.getComentario());
			parametroscomisionesMAP.put("estatus", parametroscomisiones.getEstatus());
			parametroscomisionesMAP.put("penasconvencionales", parametroscomisiones.getPenasconvencionales());
			parametroscomisionesMAP.put("moneda", parametroscomisiones.getMoneda());
			parametroscomisionesMAP.put("interes", parametroscomisiones.getInteres());
			parametroscomisionesMAP.put("tipoiva", parametroscomisiones.getTipoiva());
			parametroscomisionesMAP.put("diacorte", parametroscomisiones.getDiacorte());
			parametroscomisionesMAP.put("fechaprimercalculo", parametroscomisiones.getFechaprimercalculo());
			parametroscomisionesMAP.put("fechaultimocalculo", parametroscomisiones.getFechaultimocalculo());
			parametroscomisionesMAP.put("cuentapago", parametroscomisiones.getCuentapago());
			parametroscomisionesMAP.put("numero", parametroscomisiones.getNumero());
			parametroscomisionesMAP.put("situacionmorosidad", parametroscomisiones.getSituacionmorosidad());
			parametroscomisionesMAP.put("fideicomisoId", parametroscomisiones.getFideicomisoId());
	        
			return parametroscomisionesMAP;
	 }
	
}
