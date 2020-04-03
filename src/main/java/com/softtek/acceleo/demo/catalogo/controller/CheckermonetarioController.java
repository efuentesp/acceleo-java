
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los CheckerMonetarios. 
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

import com.softtek.acceleo.demo.catalogo.bean.CheckermonetarioBean;
import com.softtek.acceleo.demo.domain.Checkermonetario;
import com.softtek.acceleo.demo.domain.Transaccion;
import com.softtek.acceleo.demo.domain.Instruccion;
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.domain.Subfiso;

import com.softtek.acceleo.demo.service.CheckermonetarioService;
import com.softtek.acceleo.demo.service.TransaccionService;
import com.softtek.acceleo.demo.service.InstruccionService;
import com.softtek.acceleo.demo.service.FideicomisoService;
import com.softtek.acceleo.demo.service.SubfisoService;

/**
 * Clase CheckermonetarioController.
 * @author PSG.
 *
 */
@RestController
public class CheckermonetarioController {

	@Autowired
	private CheckermonetarioService checkermonetarioService;
	
@Autowired
private TransaccionService transaccionService;
@Autowired
private InstruccionService instruccionService;
@Autowired
private FideicomisoService fideicomisoService;
@Autowired
private SubfisoService subfisoService;
	
	Checkermonetario checkermonetario = new Checkermonetario();
	/************************************** CREATE  **************************************
	 * Crea un nuevo checkermonetario.
	 * @param checkermonetario.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/checkermonetario", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_CHECKERMONETARIO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createCheckermonetario(@RequestBody CheckermonetarioBean checkermonetarioBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Checkermonetario checkermonetario = new Checkermonetario();
	   	
	   			Transaccion transaccion = transaccionService.getTransaccion(checkermonetarioBean.getTransaccionId());
	   			checkermonetario.setTransaccionId(transaccion);
	   			Instruccion instruccion = instruccionService.getInstruccion(checkermonetarioBean.getInstruccionId());
	   			checkermonetario.setInstruccionId(instruccion);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(checkermonetarioBean.getFideicomisoId());
	   			checkermonetario.setFideicomisoId(fideicomiso);
	   			Subfiso subfiso = subfisoService.getSubfiso(checkermonetarioBean.getSubfisoId());
	   			checkermonetario.setSubfisoId(subfiso);
	   		
	checkermonetario.setFoliooperacion(checkermonetarioBean.getFoliooperacion());
	checkermonetario.setOperador(checkermonetarioBean.getOperador());
	checkermonetario.setTipoliquidacion(checkermonetarioBean.getTipoliquidacion());
	checkermonetario.setImporte(checkermonetarioBean.getImporte());
	checkermonetario.setFechapago(checkermonetarioBean.getFechapago());
	checkermonetario.setNumeroliquidaciones(checkermonetarioBean.getNumeroliquidaciones());
	checkermonetario.setMoneda(checkermonetarioBean.getMoneda());
	checkermonetario.setEstatus(checkermonetarioBean.getEstatus());
	checkermonetario.setFecha(checkermonetarioBean.getFecha());
	checkermonetario.setOperado(checkermonetarioBean.getOperado());
	checkermonetario.setAutorizo(checkermonetarioBean.getAutorizo());
	checkermonetario.setFechaautorizado(checkermonetarioBean.getFechaautorizado());
	checkermonetario.setNumerofirma(checkermonetarioBean.getNumerofirma());
	checkermonetario.setNombrefirma(checkermonetarioBean.getNombrefirma());
	checkermonetario.setFechafirma(checkermonetarioBean.getFechafirma());
	   		
	        checkermonetarioService.addCheckermonetario(checkermonetario);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> checkermonetarioMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(checkermonetarioMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "CheckerMonetario no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un checkermonetario.
	  * @param id.
	  * @param checkermonetario.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/checkermonetario/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_CHECKERMONETARIO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarCheckerMonetario(
				@PathVariable("id") String id, 
				@RequestBody CheckermonetarioBean checkermonetarioBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Checkermonetario checkermonetarioFound = checkermonetarioService.getCheckermonetario(uuid);
	         
	    if (checkermonetarioFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Transaccion transaccion = transaccionService.getTransaccion(checkermonetarioBean.getTransaccionId());
	   			checkermonetario.setTransaccionId(transaccion);
	   			Instruccion instruccion = instruccionService.getInstruccion(checkermonetarioBean.getInstruccionId());
	   			checkermonetario.setInstruccionId(instruccion);
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(checkermonetarioBean.getFideicomisoId());
	   			checkermonetario.setFideicomisoId(fideicomiso);
	   			Subfiso subfiso = subfisoService.getSubfiso(checkermonetarioBean.getSubfisoId());
	   			checkermonetario.setSubfisoId(subfiso);
	   		
	checkermonetario.setFoliooperacion(checkermonetarioBean.getFoliooperacion());
	checkermonetario.setOperador(checkermonetarioBean.getOperador());
	checkermonetario.setTipoliquidacion(checkermonetarioBean.getTipoliquidacion());
	checkermonetario.setImporte(checkermonetarioBean.getImporte());
	checkermonetario.setFechapago(checkermonetarioBean.getFechapago());
	checkermonetario.setNumeroliquidaciones(checkermonetarioBean.getNumeroliquidaciones());
	checkermonetario.setMoneda(checkermonetarioBean.getMoneda());
	checkermonetario.setEstatus(checkermonetarioBean.getEstatus());
	checkermonetario.setFecha(checkermonetarioBean.getFecha());
	checkermonetario.setOperado(checkermonetarioBean.getOperado());
	checkermonetario.setAutorizo(checkermonetarioBean.getAutorizo());
	checkermonetario.setFechaautorizado(checkermonetarioBean.getFechaautorizado());
	checkermonetario.setNumerofirma(checkermonetarioBean.getNumerofirma());
	checkermonetario.setNombrefirma(checkermonetarioBean.getNombrefirma());
	checkermonetario.setFechafirma(checkermonetarioBean.getFechafirma());
	
		checkermonetario.setCheckermonetarioId(checkermonetarioFound.getCheckermonetarioId());
		checkermonetarioService.editCheckermonetario(checkermonetario);
		
		Map<String, Object> checkermonetarioMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(checkermonetarioMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un checkermonetario.
	 * @param id.
	 * @return ResponseEntity<Checkermonetario>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/checkermonetario/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_CHECKERMONETARIO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteCheckerMonetario(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Checkermonetario checkermonetario = checkermonetarioService.getCheckermonetario(uuid);
		if (checkermonetario == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			checkermonetarioService.deleteCheckermonetario(checkermonetario);
			
			Map<String, Object> checkermonetarioMAP = new HashMap<>();
			checkermonetarioMAP.put("id", checkermonetario.getCheckermonetarioId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(checkermonetarioMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Checkermonetario no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los checkermonetarios.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Checkermonetario>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/checkermonetario", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_CHECKERMONETARIO:READ')")
	public @ResponseBody  List<Map<String, Object>> getCheckerMonetarios(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Checkermonetario> listCheckermonetario = null;
	
		if (query==null && _page == 0) {
			listCheckermonetario = checkermonetarioService.listCheckermonetarios(checkermonetario);
			rows = checkermonetarioService.getTotalRows();
		} else if (query!= null){
			listCheckermonetario = checkermonetarioService.listCheckermonetariosQuery(checkermonetario, query, _page, 10);
			rows = checkermonetarioService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listCheckermonetario = checkermonetarioService.listCheckermonetariosPagination(checkermonetario, _page, 10);
			rows = checkermonetarioService.getTotalRows();
		}
		
		List<Map<String, Object>> listCheckermonetarioMAP = new ArrayList<>();
		for( Checkermonetario checkermonetario : listCheckermonetario ){
			Map<String, Object> checkermonetarioMAP = new HashMap<>();
			checkermonetarioMAP.put("id", checkermonetario.getCheckermonetarioId());
			checkermonetarioMAP.put("foliooperacion", checkermonetario.getFoliooperacion());
			checkermonetarioMAP.put("operador", checkermonetario.getOperador());
			checkermonetarioMAP.put("tipoliquidacion", checkermonetario.getTipoliquidacion());
			checkermonetarioMAP.put("importe", checkermonetario.getImporte());
			checkermonetarioMAP.put("fechapago", checkermonetario.getFechapago());
			checkermonetarioMAP.put("numeroliquidaciones", checkermonetario.getNumeroliquidaciones());
			checkermonetarioMAP.put("moneda", checkermonetario.getMoneda());
			checkermonetarioMAP.put("estatus", checkermonetario.getEstatus());
			checkermonetarioMAP.put("fecha", checkermonetario.getFecha());
			checkermonetarioMAP.put("operado", checkermonetario.getOperado());
			checkermonetarioMAP.put("autorizo", checkermonetario.getAutorizo());
			checkermonetarioMAP.put("fechaautorizado", checkermonetario.getFechaautorizado());
			checkermonetarioMAP.put("numerofirma", checkermonetario.getNumerofirma());
			checkermonetarioMAP.put("nombrefirma", checkermonetario.getNombrefirma());
			checkermonetarioMAP.put("fechafirma", checkermonetario.getFechafirma());
			checkermonetarioMAP.put("transaccionId", checkermonetario.getTransaccionId().getTransaccionId());
			checkermonetarioMAP.put("instruccionId", checkermonetario.getInstruccionId().getInstruccionId());
			checkermonetarioMAP.put("fideicomisoId", checkermonetario.getFideicomisoId().getFideicomisoId());
			checkermonetarioMAP.put("subfisoId", checkermonetario.getSubfisoId().getSubfisoId());
			
			listCheckermonetarioMAP.add(checkermonetarioMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listCheckermonetarioMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un checkermonetario.
	 * @param id.
	 * @return Checkermonetario.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/checkermonetario/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_CHECKERMONETARIO:READ')")
	public @ResponseBody  Map<String, Object> getCheckerMonetario(@PathVariable("id") String id) {	        
	        Checkermonetario checkermonetario = null;
	        
	        UUID uuid = UUID.fromString(id);
	        checkermonetario = checkermonetarioService.getCheckermonetario(uuid);
	        
			Map<String, Object> checkermonetarioMAP = new HashMap<>();
			checkermonetarioMAP.put("id", checkermonetario.getCheckermonetarioId());
			checkermonetarioMAP.put("foliooperacion", checkermonetario.getFoliooperacion());
			checkermonetarioMAP.put("operador", checkermonetario.getOperador());
			checkermonetarioMAP.put("tipoliquidacion", checkermonetario.getTipoliquidacion());
			checkermonetarioMAP.put("importe", checkermonetario.getImporte());
			checkermonetarioMAP.put("fechapago", checkermonetario.getFechapago());
			checkermonetarioMAP.put("numeroliquidaciones", checkermonetario.getNumeroliquidaciones());
			checkermonetarioMAP.put("moneda", checkermonetario.getMoneda());
			checkermonetarioMAP.put("estatus", checkermonetario.getEstatus());
			checkermonetarioMAP.put("fecha", checkermonetario.getFecha());
			checkermonetarioMAP.put("operado", checkermonetario.getOperado());
			checkermonetarioMAP.put("autorizo", checkermonetario.getAutorizo());
			checkermonetarioMAP.put("fechaautorizado", checkermonetario.getFechaautorizado());
			checkermonetarioMAP.put("numerofirma", checkermonetario.getNumerofirma());
			checkermonetarioMAP.put("nombrefirma", checkermonetario.getNombrefirma());
			checkermonetarioMAP.put("fechafirma", checkermonetario.getFechafirma());
			checkermonetarioMAP.put("transaccionId", checkermonetario.getTransaccionId());
			checkermonetarioMAP.put("instruccionId", checkermonetario.getInstruccionId());
			checkermonetarioMAP.put("fideicomisoId", checkermonetario.getFideicomisoId());
			checkermonetarioMAP.put("subfisoId", checkermonetario.getSubfisoId());
	        
			return checkermonetarioMAP;
	 }
	
}
