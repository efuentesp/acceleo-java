
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los CarteraAdeudos. 
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

import com.softtek.acceleo.demo.catalogo.bean.CarteraadeudoBean;
import com.softtek.acceleo.demo.domain.Carteraadeudo;
import com.softtek.acceleo.demo.domain.Honorarioscontrato;

import com.softtek.acceleo.demo.service.CarteraadeudoService;
import com.softtek.acceleo.demo.service.HonorarioscontratoService;

/**
 * Clase CarteraadeudoController.
 * @author PSG.
 *
 */
@RestController
public class CarteraadeudoController {

	@Autowired
	private CarteraadeudoService carteraadeudoService;
	
@Autowired
private HonorarioscontratoService honorarioscontratoService;
	
	Carteraadeudo carteraadeudo = new Carteraadeudo();
	/************************************** CREATE  **************************************
	 * Crea un nuevo carteraadeudo.
	 * @param carteraadeudo.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/carteraadeudo", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_CARTERAADEUDO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createCarteraadeudo(@RequestBody CarteraadeudoBean carteraadeudoBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Carteraadeudo carteraadeudo = new Carteraadeudo();
	   	
	   			Honorarioscontrato honorarioscontrato = honorarioscontratoService.getHonorarioscontrato(carteraadeudoBean.getHonorarioscontratoId());
	   			carteraadeudo.setHonorarioscontratoId(honorarioscontrato);
	   		
	carteraadeudo.setFolioadeudo(carteraadeudoBean.getFolioadeudo());
	carteraadeudo.setCalificacion(carteraadeudoBean.getCalificacion());
	carteraadeudo.setFechacalculo(carteraadeudoBean.getFechacalculo());
	carteraadeudo.setDel(carteraadeudoBean.getDel());
	carteraadeudo.setAl(carteraadeudoBean.getAl());
	carteraadeudo.setMoneda(carteraadeudoBean.getMoneda());
	carteraadeudo.setImporte(carteraadeudoBean.getImporte());
	   		
	        carteraadeudoService.addCarteraadeudo(carteraadeudo);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> carteraadeudoMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(carteraadeudoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "CarteraAdeudo no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un carteraadeudo.
	  * @param id.
	  * @param carteraadeudo.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/carteraadeudo/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_CARTERAADEUDO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarCarteraAdeudo(
				@PathVariable("id") String id, 
				@RequestBody CarteraadeudoBean carteraadeudoBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Carteraadeudo carteraadeudoFound = carteraadeudoService.getCarteraadeudo(uuid);
	         
	    if (carteraadeudoFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Honorarioscontrato honorarioscontrato = honorarioscontratoService.getHonorarioscontrato(carteraadeudoBean.getHonorarioscontratoId());
	   			carteraadeudo.setHonorarioscontratoId(honorarioscontrato);
	   		
	carteraadeudo.setFolioadeudo(carteraadeudoBean.getFolioadeudo());
	carteraadeudo.setCalificacion(carteraadeudoBean.getCalificacion());
	carteraadeudo.setFechacalculo(carteraadeudoBean.getFechacalculo());
	carteraadeudo.setDel(carteraadeudoBean.getDel());
	carteraadeudo.setAl(carteraadeudoBean.getAl());
	carteraadeudo.setMoneda(carteraadeudoBean.getMoneda());
	carteraadeudo.setImporte(carteraadeudoBean.getImporte());
	
		carteraadeudo.setCarteraadeudoId(carteraadeudoFound.getCarteraadeudoId());
		carteraadeudoService.editCarteraadeudo(carteraadeudo);
		
		Map<String, Object> carteraadeudoMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(carteraadeudoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un carteraadeudo.
	 * @param id.
	 * @return ResponseEntity<Carteraadeudo>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/carteraadeudo/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_CARTERAADEUDO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteCarteraAdeudo(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Carteraadeudo carteraadeudo = carteraadeudoService.getCarteraadeudo(uuid);
		if (carteraadeudo == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			carteraadeudoService.deleteCarteraadeudo(carteraadeudo);
			
			Map<String, Object> carteraadeudoMAP = new HashMap<>();
			carteraadeudoMAP.put("id", carteraadeudo.getCarteraadeudoId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(carteraadeudoMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Carteraadeudo no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los carteraadeudos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Carteraadeudo>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/carteraadeudo", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_CARTERAADEUDO:READ')")
	public @ResponseBody  List<Map<String, Object>> getCarteraAdeudos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Carteraadeudo> listCarteraadeudo = null;
	
		if (query==null && _page == 0) {
			listCarteraadeudo = carteraadeudoService.listCarteraadeudos(carteraadeudo);
			rows = carteraadeudoService.getTotalRows();
		} else if (query!= null){
			listCarteraadeudo = carteraadeudoService.listCarteraadeudosQuery(carteraadeudo, query, _page, 10);
			rows = carteraadeudoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listCarteraadeudo = carteraadeudoService.listCarteraadeudosPagination(carteraadeudo, _page, 10);
			rows = carteraadeudoService.getTotalRows();
		}
		
		List<Map<String, Object>> listCarteraadeudoMAP = new ArrayList<>();
		for( Carteraadeudo carteraadeudo : listCarteraadeudo ){
			Map<String, Object> carteraadeudoMAP = new HashMap<>();
			carteraadeudoMAP.put("id", carteraadeudo.getCarteraadeudoId());
			carteraadeudoMAP.put("folioadeudo", carteraadeudo.getFolioadeudo());
			carteraadeudoMAP.put("calificacion", carteraadeudo.getCalificacion());
			carteraadeudoMAP.put("fechacalculo", carteraadeudo.getFechacalculo());
			carteraadeudoMAP.put("del", carteraadeudo.getDel());
			carteraadeudoMAP.put("al", carteraadeudo.getAl());
			carteraadeudoMAP.put("moneda", carteraadeudo.getMoneda());
			carteraadeudoMAP.put("importe", carteraadeudo.getImporte());
			carteraadeudoMAP.put("honorarioscontratoId", carteraadeudo.getHonorarioscontratoId().getHonorarioscontratoId());
			
			listCarteraadeudoMAP.add(carteraadeudoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listCarteraadeudoMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un carteraadeudo.
	 * @param id.
	 * @return Carteraadeudo.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/carteraadeudo/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_CARTERAADEUDO:READ')")
	public @ResponseBody  Map<String, Object> getCarteraAdeudo(@PathVariable("id") String id) {	        
	        Carteraadeudo carteraadeudo = null;
	        
	        UUID uuid = UUID.fromString(id);
	        carteraadeudo = carteraadeudoService.getCarteraadeudo(uuid);
	        
			Map<String, Object> carteraadeudoMAP = new HashMap<>();
			carteraadeudoMAP.put("id", carteraadeudo.getCarteraadeudoId());
			carteraadeudoMAP.put("folioadeudo", carteraadeudo.getFolioadeudo());
			carteraadeudoMAP.put("calificacion", carteraadeudo.getCalificacion());
			carteraadeudoMAP.put("fechacalculo", carteraadeudo.getFechacalculo());
			carteraadeudoMAP.put("del", carteraadeudo.getDel());
			carteraadeudoMAP.put("al", carteraadeudo.getAl());
			carteraadeudoMAP.put("moneda", carteraadeudo.getMoneda());
			carteraadeudoMAP.put("importe", carteraadeudo.getImporte());
			carteraadeudoMAP.put("honorarioscontratoId", carteraadeudo.getHonorarioscontratoId());
	        
			return carteraadeudoMAP;
	 }
	
}
