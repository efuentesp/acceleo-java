/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Candidatos. 
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

import com.softtek.acceleo.demo.catalogo.bean.CandidatoBean;
import com.softtek.acceleo.demo.domain.Candidato;
import com.softtek.acceleo.demo.service.CandidatoService;

/**
 * Clase CandidatoController.
 * @author PSG.
 *
 */
@RestController
public class CandidatoController {

	@Autowired
	private CandidatoService candidatoService;
	
	Candidato candidato = new Candidato();

	/************************************** SEARCH
	 * Obtiene informacion de los candidatos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Candidato>.
	 */
	@RequestMapping(value = "/candidato", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('CANDIDATOSEARCH')")
	public @ResponseBody  List<Candidato> getCandidatos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Candidato> listCandidato = null;

		if (query==null && _page == 0) {
       		listCandidato = candidatoService.listCandidatos(candidato);
			rows = candidatoService.getTotalRows();
		} else if (query!= null){
			listCandidato = candidatoService.listCandidatosQuery(candidato, query, _page, 10);
			rows = candidatoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listCandidato = candidatoService.listCandidatosPagination(candidato, _page, 10);
			rows = candidatoService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listCandidato;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un candidato.
	 * @param id.
	 * @return Candidato.
	 */
	@RequestMapping(value = "/idcandidato/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('CANDIDATOSEARCH')")
	    public @ResponseBody  Candidato getCandidato(@PathVariable("id") int id) {	        
	        Candidato candidato = null;
	        
	        candidato = candidatoService.getCandidato(id);
			return candidato;
	 }

	/*************************** CREATE
	 * Crea un nuevo candidato.
	 * @param candidato.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/candidato", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('CANDIDATOCREATE')")
	    public ResponseEntity<Void> createCandidato(@RequestBody Candidato candidato,    UriComponentsBuilder ucBuilder) {
	   
	        candidatoService.addCandidato(candidato);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/candidato/{id}").buildAndExpand(candidato.getCandidatoId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un candidato.
	  * @param id.
	  * @param candidato.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/candidato/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('CANDIDATOUPDATE')") 
	    public ResponseEntity<Candidato> actualizarCandidato(
				@PathVariable("id") int id, 
				@RequestBody Candidato candidato) {
	        
	        Candidato candidatoFound = candidatoService.getCandidato(id);
	         
	        if (candidatoFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Candidato>(HttpStatus.NOT_FOUND);
	        }
	
	candidatoFound.setFecha(candidato.getFecha());
	candidatoFound.setApellidomaterno(candidato.getApellidomaterno());
	candidatoFound.setApellidopaterno(candidato.getApellidopaterno());
	candidatoFound.setNombre(candidato.getNombre());
	candidatoFound.setGeneroId(candidato.getGeneroId());
	candidatoFound.setEstatuscandidatoId(candidato.getEstatuscandidatoId());
	candidatoFound.setCandidatoId(candidato.getCandidatoId());

		    candidatoService.editCandidato(candidatoFound);
	        return new ResponseEntity<Candidato>(candidatoFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un candidato.
		 * @param id.
		 * @return ResponseEntity<Candidato>.
		 */
		@RequestMapping(value = "/candidato/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('CANDIDATODELETE')")  
	    public ResponseEntity<Candidato> deleteCandidato(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Candidato candidato = candidatoService.getCandidato(id);
	         if (candidato == null) {
	             return new ResponseEntity<Candidato>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             candidatoService.deleteCandidato(candidato);
	             return new ResponseEntity<Candidato>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Candidato no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Candidato>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Candidato>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un candidato.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveCandidato", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CANDIDATO')")  
	public @ResponseBody String saveCandidato(
			@ModelAttribute("command") CandidatoBean candidatoBean) {

		Candidato candidato = prepareModel(candidatoBean);
		candidatoService.addCandidato(candidato);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un candidato.
	 * @param candidatoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editCandidato", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CANDIDATO')")  
	public @ResponseBody String editCandidato(
			@ModelAttribute("command") CandidatoBean candidatoBean) {


		Candidato candidato = prepareModel(candidatoBean);
		candidatoService.editCandidato(candidato);
		return "SUCCESS";
	}

	/**
	 * Agrega un CANDIDATO.
	 * @param CANDIDATOBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchCandidato", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CANDIDATO')")  
	public ModelAndView addCandidato(
			@ModelAttribute("command") CandidatoBean candidatoBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Candidato candidato = null;
		if (candidatoBean != null)
			candidato = prepareModel(candidatoBean);
		model.put("candidatos",
				prepareListofBean(candidatoService.listCandidatos(candidato)));
		return new ModelAndView("searchCandidato", model);
	}

	/**
	 * Elimina un candidato.
	 * @param candidatoBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteCandidato", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CANDIDATO')")  
	public ModelAndView deleteCandidato(
			@ModelAttribute("command") CandidatoBean candidatoBean,
			BindingResult result) {
		System.out.println("delete " + candidatoBean.getCandidatoId());
		candidatoService.deleteCandidato(prepareModel(candidatoBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidato", null);
		model.put("candidatos",
				prepareListofBean(candidatoService.listCandidatos(null)));
		return new ModelAndView("searchCandidato", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryCandidato", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CANDIDATO')")  
	public ModelAndView entryCandidato() {
		return new ModelAndView("redirect:/searchCandidato");
	}

	private Candidato prepareModel(CandidatoBean candidatoBean) {
		Candidato candidato = new Candidato();

		//candidato.setHDateId(candidatoBean.getFechaId());
		//candidato.setRadiogeneroId(candidatoBean.getEsId());
		//candidato.setRadioestatuscandidatoId(candidatoBean.getEstadoId());
		//candidato.setSolicitudId(candidatoBean.getSolicitudId());
		//candidato.setEventoId(candidatoBean.getEventoId());
		//candidato.setDisplayresultcandidatoId(candidatoBean.getCandidatoId());
		//candidato.setExposedfiltercandidatoId(candidatoBean.getCandidatoId());
		//candidato.setDisplaymodalcandidatoId(candidatoBean.getCandidatoId());
		//candidato.setEntitynamecandidatoId(candidatoBean.getCandidatoId());
		//candidato.setScaffoldcandidatoId(candidatoBean.getCandidatoId());
		candidato.setNombre(candidatoBean.getNombre());
		candidato.setApellidopaterno(candidatoBean.getApellidopaterno());
		candidato.setApellidomaterno(candidatoBean.getApellidomaterno());
		candidato.setCandidatoId(candidatoBean.getCandidatoId());
		candidatoBean.setCandidatoId(null);

		return candidato;
	}

	/**
	 * Convierte un objeto de tipo CandidatoBean a un objeto de tipo Candidato.
	 * @param candidatoBean.
	 * @return Candidato.
	 */
	private List<CandidatoBean> prepareListofBean(List<Candidato> candidatos) {
		List<CandidatoBean> beans = null;
		if (candidatos != null && !candidatos.isEmpty()) {
			beans = new ArrayList<CandidatoBean>();
			CandidatoBean bean = null;
			for (Candidato candidato : candidatos) {
				bean = new CandidatoBean();

				//bean.setRadiogeneroId(candidato.getEsId());
				//bean.setRadioestatuscandidatoId(candidato.getEstadoId());
				//bean.setSolicitudId(candidato.getSolicitudId());
				//bean.setEventoId(candidato.getEventoId());
				//bean.setDisplayresultcandidatoId(candidato.getCandidatoId());
				//bean.setExposedfiltercandidatoId(candidato.getCandidatoId());
				//bean.setDisplaymodalcandidatoId(candidato.getCandidatoId());
				//bean.setEntitynamecandidatoId(candidato.getCandidatoId());
				//bean.setScaffoldcandidatoId(candidato.getCandidatoId());
				bean.setNombre(candidato.getNombre());
				bean.setApellidopaterno(candidato.getApellidopaterno());
				bean.setApellidomaterno(candidato.getApellidomaterno());
				bean.setCandidatoId(candidato.getCandidatoId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


