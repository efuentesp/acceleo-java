/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Ordensimplificadas. 
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

import com.softtek.acceleo.demo.catalogo.bean.OrdensimplificadaBean;
import com.softtek.acceleo.demo.domain.Ordensimplificada;
import com.softtek.acceleo.demo.service.OrdensimplificadaService;

/**
 * Clase OrdensimplificadaController.
 * @author PSG.
 *
 */
@RestController
public class OrdensimplificadaController {

	@Autowired
	private OrdensimplificadaService ordensimplificadaService;
	
	Ordensimplificada ordensimplificada = new Ordensimplificada();

	/************************************** SEARCH
	 * Obtiene informacion de los ordensimplificadas.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Ordensimplificada>.
	 */
	@RequestMapping(value = "/ordensimplificada", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ORDENSIMPLIFICADASEARCH')")
	public @ResponseBody  List<Ordensimplificada> getOrdensimplificadas(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Ordensimplificada> listOrdensimplificada = null;

		if (query==null && _page == 0) {
       		listOrdensimplificada = ordensimplificadaService.listOrdensimplificadas(ordensimplificada);
			rows = ordensimplificadaService.getTotalRows();
		} else if (query!= null){
			listOrdensimplificada = ordensimplificadaService.listOrdensimplificadasQuery(ordensimplificada, query, _page, 10);
			rows = ordensimplificadaService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listOrdensimplificada = ordensimplificadaService.listOrdensimplificadasPagination(ordensimplificada, _page, 10);
			rows = ordensimplificadaService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listOrdensimplificada;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un ordensimplificada.
	 * @param id.
	 * @return Ordensimplificada.
	 */
	@RequestMapping(value = "/idordensimplificada/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ORDENSIMPLIFICADASEARCH')")
	    public @ResponseBody  Ordensimplificada getOrdensimplificada(@PathVariable("id") int id) {	        
	        Ordensimplificada ordensimplificada = null;
	        
	        ordensimplificada = ordensimplificadaService.getOrdensimplificada(id);
			return ordensimplificada;
	 }

	/*************************** CREATE
	 * Crea un nuevo ordensimplificada.
	 * @param ordensimplificada.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/ordensimplificada", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ORDENSIMPLIFICADACREATE')")
	    public ResponseEntity<Void> createOrdensimplificada(@RequestBody Ordensimplificada ordensimplificada,    UriComponentsBuilder ucBuilder) {
	   
	        ordensimplificadaService.addOrdensimplificada(ordensimplificada);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/ordensimplificada/{id}").buildAndExpand(ordensimplificada.getOrdensimplificadaId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un ordensimplificada.
	  * @param id.
	  * @param ordensimplificada.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/ordensimplificada/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('ORDENSIMPLIFICADAUPDATE')") 
	    public ResponseEntity<Ordensimplificada> actualizarOrdensimplificada(
				@PathVariable("id") int id, 
				@RequestBody Ordensimplificada ordensimplificada) {
	        
	        Ordensimplificada ordensimplificadaFound = ordensimplificadaService.getOrdensimplificada(id);
	         
	        if (ordensimplificadaFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Ordensimplificada>(HttpStatus.NOT_FOUND);
	        }
	
	ordensimplificadaFound.setSap(ordensimplificada.getSap());
	ordensimplificadaFound.setCantidadprogramada(ordensimplificada.getCantidadprogramada());
	ordensimplificadaFound.setOrdentrabajo(ordensimplificada.getOrdentrabajo());
	ordensimplificadaFound.setFechafinal(ordensimplificada.getFechafinal());
	ordensimplificadaFound.setCantidadproducida(ordensimplificada.getCantidadproducida());
	ordensimplificadaFound.setFechainicial(ordensimplificada.getFechainicial());
	ordensimplificadaFound.setLinea1Id(ordensimplificada.getLinea1Id());
	ordensimplificadaFound.setDestino1Id(ordensimplificada.getDestino1Id());
//	ordensimplificadaFound.setEstadoordenId(ordensimplificada.getEstadoordenId());
//	ordensimplificadaFound.setEstadoordenId(ordensimplificada.getEstadoordenId());
//	ordensimplificadaFound.setOperadorproduccionId(ordensimplificada.getOperadorproduccionId());
//	ordensimplificadaFound.setOperadorproduccionId(ordensimplificada.getOperadorproduccionId());
	ordensimplificadaFound.setComentario(ordensimplificada.getComentario());
//	ordensimplificadaFound.setClienteId(ordensimplificada.getClienteId());
	ordensimplificadaFound.setOrdensimplificadaId(ordensimplificada.getOrdensimplificadaId());

		    ordensimplificadaService.editOrdensimplificada(ordensimplificadaFound);
	        return new ResponseEntity<Ordensimplificada>(ordensimplificadaFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un ordensimplificada.
		 * @param id.
		 * @return ResponseEntity<Ordensimplificada>.
		 */
		@RequestMapping(value = "/ordensimplificada/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('ORDENSIMPLIFICADADELETE')")  
	    public ResponseEntity<Ordensimplificada> deleteOrdensimplificada(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Ordensimplificada ordensimplificada = ordensimplificadaService.getOrdensimplificada(id);
	         if (ordensimplificada == null) {
	             return new ResponseEntity<Ordensimplificada>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             ordensimplificadaService.deleteOrdensimplificada(ordensimplificada);
	             return new ResponseEntity<Ordensimplificada>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Ordensimplificada no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Ordensimplificada>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Ordensimplificada>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un ordensimplificada.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveOrdensimplificada", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ORDENSIMPLIFICADA')")  
	public @ResponseBody String saveOrdensimplificada(
			@ModelAttribute("command") OrdensimplificadaBean ordensimplificadaBean) {

		Ordensimplificada ordensimplificada = prepareModel(ordensimplificadaBean);
		ordensimplificadaService.addOrdensimplificada(ordensimplificada);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un ordensimplificada.
	 * @param ordensimplificadaBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editOrdensimplificada", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ORDENSIMPLIFICADA')")  
	public @ResponseBody String editOrdensimplificada(
			@ModelAttribute("command") OrdensimplificadaBean ordensimplificadaBean) {


		Ordensimplificada ordensimplificada = prepareModel(ordensimplificadaBean);
		ordensimplificadaService.editOrdensimplificada(ordensimplificada);
		return "SUCCESS";
	}

	/**
	 * Agrega un ORDENSIMPLIFICADA.
	 * @param ORDENSIMPLIFICADABean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchOrdensimplificada", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ORDENSIMPLIFICADA')")  
	public ModelAndView addOrdensimplificada(
			@ModelAttribute("command") OrdensimplificadaBean ordensimplificadaBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Ordensimplificada ordensimplificada = null;
		if (ordensimplificadaBean != null)
			ordensimplificada = prepareModel(ordensimplificadaBean);
		model.put("ordensimplificadas",
				prepareListofBean(ordensimplificadaService.listOrdensimplificadas(ordensimplificada)));
		return new ModelAndView("searchOrdensimplificada", model);
	}

	/**
	 * Elimina un ordensimplificada.
	 * @param ordensimplificadaBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteOrdensimplificada", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ORDENSIMPLIFICADA')")  
	public ModelAndView deleteOrdensimplificada(
			@ModelAttribute("command") OrdensimplificadaBean ordensimplificadaBean,
			BindingResult result) {
		System.out.println("delete " + ordensimplificadaBean.getOrdensimplificadaId());
		ordensimplificadaService.deleteOrdensimplificada(prepareModel(ordensimplificadaBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ordensimplificada", null);
		model.put("ordensimplificadas",
				prepareListofBean(ordensimplificadaService.listOrdensimplificadas(null)));
		return new ModelAndView("searchOrdensimplificada", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryOrdensimplificada", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ORDENSIMPLIFICADA')")  
	public ModelAndView entryOrdensimplificada() {
		return new ModelAndView("redirect:/searchOrdensimplificada");
	}

	private Ordensimplificada prepareModel(OrdensimplificadaBean ordensimplificadaBean) {
		Ordensimplificada ordensimplificada = new Ordensimplificada();

		//ordensimplificada.setHIntegerId(ordensimplificadaBean.getOrdentrabajoId());
		//ordensimplificada.setHIntegerId(ordensimplificadaBean.getSapId());
		//ordensimplificada.setRadiolineaId(ordensimplificadaBean.getLineaId());
		//ordensimplificada.setHIntegerId(ordensimplificadaBean.getCantidadprogramadaId());
		//ordensimplificada.setHIntegerId(ordensimplificadaBean.getCantidadproducidaId());
		//ordensimplificada.setHDateId(ordensimplificadaBean.getFechainicialId());
		//ordensimplificada.setHDateId(ordensimplificadaBean.getFechafinalId());
		//ordensimplificada.setRadiodestinoId(ordensimplificadaBean.getDestinomercanciaId());
		//ordensimplificada.setRadioestadoordenId(ordensimplificadaBean.getEstadoId());
		//ordensimplificada.setRadioestadoordenId(ordensimplificadaBean.getEstado2Id());
		//ordensimplificada.setSupervisorId(ordensimplificadaBean.getSupervisorId());
		//ordensimplificada.setOperadorId(ordensimplificadaBean.getOperadorId());
		//ordensimplificada.setNotrequiredordensimplificadaId(ordensimplificadaBean.getComentarioId());
		//ordensimplificada.setDeId(ordensimplificadaBean.getDeId());
		//ordensimplificada.setDisplayresultordensimplificadaId(ordensimplificadaBean.getOrdensimplificadaId());
		//ordensimplificada.setExposedfilterordensimplificadaId(ordensimplificadaBean.getOrdensimplificadaId());
		//ordensimplificada.setDisplaymodalordensimplificadaId(ordensimplificadaBean.getOrdensimplificadaId());
		//ordensimplificada.setEntitynameordensimplificadaId(ordensimplificadaBean.getOrdensimplificadaId());
		//ordensimplificada.setScaffoldordensimplificadaId(ordensimplificadaBean.getOrdensimplificadaId());
		ordensimplificada.setOrdensimplificadaId(ordensimplificadaBean.getOrdensimplificadaId());
		ordensimplificadaBean.setOrdensimplificadaId(null);

		return ordensimplificada;
	}

	/**
	 * Convierte un objeto de tipo OrdensimplificadaBean a un objeto de tipo Ordensimplificada.
	 * @param ordensimplificadaBean.
	 * @return Ordensimplificada.
	 */
	private List<OrdensimplificadaBean> prepareListofBean(List<Ordensimplificada> ordensimplificadas) {
		List<OrdensimplificadaBean> beans = null;
		if (ordensimplificadas != null && !ordensimplificadas.isEmpty()) {
			beans = new ArrayList<OrdensimplificadaBean>();
			OrdensimplificadaBean bean = null;
			for (Ordensimplificada ordensimplificada : ordensimplificadas) {
				bean = new OrdensimplificadaBean();

				//bean.setRadiolineaId(ordensimplificada.getLineaId());
				//bean.setRadiodestinoId(ordensimplificada.getDestinomercanciaId());
				//bean.setRadioestadoordenId(ordensimplificada.getEstadoId());
				//bean.setRadioestadoordenId(ordensimplificada.getEstado2Id());
				//bean.setSupervisorId(ordensimplificada.getSupervisorId());
				//bean.setOperadorId(ordensimplificada.getOperadorId());
				//bean.setNotrequiredordensimplificadaId(ordensimplificada.getComentarioId());
				//bean.setDeId(ordensimplificada.getDeId());
				//bean.setDisplayresultordensimplificadaId(ordensimplificada.getOrdensimplificadaId());
				//bean.setExposedfilterordensimplificadaId(ordensimplificada.getOrdensimplificadaId());
				//bean.setDisplaymodalordensimplificadaId(ordensimplificada.getOrdensimplificadaId());
				//bean.setEntitynameordensimplificadaId(ordensimplificada.getOrdensimplificadaId());
				//bean.setScaffoldordensimplificadaId(ordensimplificada.getOrdensimplificadaId());
				bean.setOrdensimplificadaId(ordensimplificada.getOrdensimplificadaId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


