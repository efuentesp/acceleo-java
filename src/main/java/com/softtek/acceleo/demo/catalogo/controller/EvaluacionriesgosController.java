
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los EvaluacionRiesgoss. 
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

import com.softtek.acceleo.demo.catalogo.bean.EvaluacionriesgosBean;
import com.softtek.acceleo.demo.domain.Evaluacionriesgos;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.EvaluacionriesgosService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase EvaluacionriesgosController.
 * @author PSG.
 *
 */
@RestController
public class EvaluacionriesgosController {

	@Autowired
	private EvaluacionriesgosService evaluacionriesgosService;
	
@Autowired
private FideicomisoService fideicomisoService;
	
	Evaluacionriesgos evaluacionriesgos = new Evaluacionriesgos();
	/************************************** CREATE  **************************************
	 * Crea un nuevo evaluacionriesgos.
	 * @param evaluacionriesgos.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/evaluacionriesgos", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_EVALUACIONRIESGOS:CREATE')")
	 public ResponseEntity<Map<String, Object>> createEvaluacionriesgos(@RequestBody EvaluacionriesgosBean evaluacionriesgosBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Evaluacionriesgos evaluacionriesgos = new Evaluacionriesgos();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(evaluacionriesgosBean.getFideicomisoId());
	   			evaluacionriesgos.setFideicomisoId(fideicomiso);
	   		
	evaluacionriesgos.setCampo(evaluacionriesgosBean.getCampo());
	evaluacionriesgos.setCliente(evaluacionriesgosBean.getCliente());
	evaluacionriesgos.setEstructura(evaluacionriesgosBean.getEstructura());
	evaluacionriesgos.setResultadofinal(evaluacionriesgosBean.getResultadofinal());
	   		
	        evaluacionriesgosService.addEvaluacionriesgos(evaluacionriesgos);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> evaluacionriesgosMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(evaluacionriesgosMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "EvaluacionRiesgos no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un evaluacionriesgos.
	  * @param id.
	  * @param evaluacionriesgos.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/evaluacionriesgos/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_EVALUACIONRIESGOS:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarEvaluacionRiesgos(
				@PathVariable("id") String id, 
				@RequestBody EvaluacionriesgosBean evaluacionriesgosBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Evaluacionriesgos evaluacionriesgosFound = evaluacionriesgosService.getEvaluacionriesgos(uuid);
	         
	    if (evaluacionriesgosFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(evaluacionriesgosBean.getFideicomisoId());
	   			evaluacionriesgos.setFideicomisoId(fideicomiso);
	   		
	evaluacionriesgos.setCampo(evaluacionriesgosBean.getCampo());
	evaluacionriesgos.setCliente(evaluacionriesgosBean.getCliente());
	evaluacionriesgos.setEstructura(evaluacionriesgosBean.getEstructura());
	evaluacionriesgos.setResultadofinal(evaluacionriesgosBean.getResultadofinal());
	
		evaluacionriesgos.setEvaluacionriesgosId(evaluacionriesgosFound.getEvaluacionriesgosId());
		evaluacionriesgosService.editEvaluacionriesgos(evaluacionriesgos);
		
		Map<String, Object> evaluacionriesgosMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(evaluacionriesgosMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un evaluacionriesgos.
	 * @param id.
	 * @return ResponseEntity<Evaluacionriesgos>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/evaluacionriesgos/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_EVALUACIONRIESGOS:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteEvaluacionRiesgos(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Evaluacionriesgos evaluacionriesgos = evaluacionriesgosService.getEvaluacionriesgos(uuid);
		if (evaluacionriesgos == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			evaluacionriesgosService.deleteEvaluacionriesgos(evaluacionriesgos);
			
			Map<String, Object> evaluacionriesgosMAP = new HashMap<>();
			evaluacionriesgosMAP.put("id", evaluacionriesgos.getEvaluacionriesgosId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(evaluacionriesgosMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Evaluacionriesgos no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los evaluacionriesgoss.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Evaluacionriesgos>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/evaluacionriesgos", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_EVALUACIONRIESGOS:READ')")
	public @ResponseBody  List<Map<String, Object>> getEvaluacionRiesgoss(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Evaluacionriesgos> listEvaluacionriesgos = null;
	
		if (query==null && _page == 0) {
			listEvaluacionriesgos = evaluacionriesgosService.listEvaluacionriesgoss(evaluacionriesgos);
			rows = evaluacionriesgosService.getTotalRows();
		} else if (query!= null){
			listEvaluacionriesgos = evaluacionriesgosService.listEvaluacionriesgossQuery(evaluacionriesgos, query, _page, 10);
			rows = evaluacionriesgosService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listEvaluacionriesgos = evaluacionriesgosService.listEvaluacionriesgossPagination(evaluacionriesgos, _page, 10);
			rows = evaluacionriesgosService.getTotalRows();
		}
		
		List<Map<String, Object>> listEvaluacionriesgosMAP = new ArrayList<>();
		for( Evaluacionriesgos evaluacionriesgos : listEvaluacionriesgos ){
			Map<String, Object> evaluacionriesgosMAP = new HashMap<>();
			evaluacionriesgosMAP.put("id", evaluacionriesgos.getEvaluacionriesgosId());
			evaluacionriesgosMAP.put("campo", evaluacionriesgos.getCampo());
			evaluacionriesgosMAP.put("cliente", evaluacionriesgos.getCliente());
			evaluacionriesgosMAP.put("estructura", evaluacionriesgos.getEstructura());
			evaluacionriesgosMAP.put("resultadofinal", evaluacionriesgos.getResultadofinal());
			evaluacionriesgosMAP.put("fideicomisoId", evaluacionriesgos.getFideicomisoId().getFideicomisoId());
			
			listEvaluacionriesgosMAP.add(evaluacionriesgosMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listEvaluacionriesgosMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un evaluacionriesgos.
	 * @param id.
	 * @return Evaluacionriesgos.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/evaluacionriesgos/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_EVALUACIONRIESGOS:READ')")
	public @ResponseBody  Map<String, Object> getEvaluacionRiesgos(@PathVariable("id") String id) {	        
	        Evaluacionriesgos evaluacionriesgos = null;
	        
	        UUID uuid = UUID.fromString(id);
	        evaluacionriesgos = evaluacionriesgosService.getEvaluacionriesgos(uuid);
	        
			Map<String, Object> evaluacionriesgosMAP = new HashMap<>();
			evaluacionriesgosMAP.put("id", evaluacionriesgos.getEvaluacionriesgosId());
			evaluacionriesgosMAP.put("campo", evaluacionriesgos.getCampo());
			evaluacionriesgosMAP.put("cliente", evaluacionriesgos.getCliente());
			evaluacionriesgosMAP.put("estructura", evaluacionriesgos.getEstructura());
			evaluacionriesgosMAP.put("resultadofinal", evaluacionriesgos.getResultadofinal());
			evaluacionriesgosMAP.put("fideicomisoId", evaluacionriesgos.getFideicomisoId());
	        
			return evaluacionriesgosMAP;
	 }
	
}
