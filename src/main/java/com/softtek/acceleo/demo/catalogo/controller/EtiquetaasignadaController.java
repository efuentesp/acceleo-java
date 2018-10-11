/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Etiquetaasignadas. 
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

import com.softtek.acceleo.demo.catalogo.bean.EtiquetaasignadaBean;
import com.softtek.acceleo.demo.domain.Etiquetaasignada;
import com.softtek.acceleo.demo.service.EtiquetaasignadaService;

/**
 * Clase EtiquetaasignadaController.
 * @author PSG.
 *
 */
@RestController
public class EtiquetaasignadaController {

	@Autowired
	private EtiquetaasignadaService etiquetaasignadaService;
	
	Etiquetaasignada etiquetaasignada = new Etiquetaasignada();

	/************************************** SEARCH
	 * Obtiene informacion de los etiquetaasignadas.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Etiquetaasignada>.
	 */
	@RequestMapping(value = "/etiquetaasignada", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ETIQUETAASIGNADASEARCH')")
	public @ResponseBody  List<Etiquetaasignada> getEtiquetaasignadas(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Etiquetaasignada> listEtiquetaasignada = null;

		if (query==null && _page == 0) {
       		listEtiquetaasignada = etiquetaasignadaService.listEtiquetaasignadas(etiquetaasignada);
			rows = etiquetaasignadaService.getTotalRows();
		} else if (query!= null){
			listEtiquetaasignada = etiquetaasignadaService.listEtiquetaasignadasQuery(etiquetaasignada, query, _page, 10);
			rows = etiquetaasignadaService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listEtiquetaasignada = etiquetaasignadaService.listEtiquetaasignadasPagination(etiquetaasignada, _page, 10);
			rows = etiquetaasignadaService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listEtiquetaasignada;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un etiquetaasignada.
	 * @param id.
	 * @return Etiquetaasignada.
	 */
	@RequestMapping(value = "/idetiquetaasignada/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ETIQUETAASIGNADASEARCH')")
	    public @ResponseBody  Etiquetaasignada getEtiquetaasignada(@PathVariable("id") int id) {	        
	        Etiquetaasignada etiquetaasignada = null;
	        
	        etiquetaasignada = etiquetaasignadaService.getEtiquetaasignada(id);
			return etiquetaasignada;
	 }

	/*************************** CREATE
	 * Crea un nuevo etiquetaasignada.
	 * @param etiquetaasignada.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/etiquetaasignada", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ETIQUETAASIGNADACREATE')")
	    public ResponseEntity<Void> createEtiquetaasignada(@RequestBody Etiquetaasignada etiquetaasignada,    UriComponentsBuilder ucBuilder) {
	   
	        etiquetaasignadaService.addEtiquetaasignada(etiquetaasignada);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/etiquetaasignada/{id}").buildAndExpand(etiquetaasignada.getEtiquetaasignadaId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un etiquetaasignada.
	  * @param id.
	  * @param etiquetaasignada.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/etiquetaasignada/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('ETIQUETAASIGNADAUPDATE')") 
	    public ResponseEntity<Etiquetaasignada> actualizarEtiquetaasignada(
				@PathVariable("id") int id, 
				@RequestBody Etiquetaasignada etiquetaasignada) {
	        
	        Etiquetaasignada etiquetaasignadaFound = etiquetaasignadaService.getEtiquetaasignada(id);
	         
	        if (etiquetaasignadaFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Etiquetaasignada>(HttpStatus.NOT_FOUND);
	        }
	
	etiquetaasignadaFound.setF5(etiquetaasignada.getF5());
	etiquetaasignadaFound.setSap(etiquetaasignada.getSap());
	etiquetaasignadaFound.setEtiquetaasignadasxpalet(etiquetaasignada.getEtiquetaasignadasxpalet());
	etiquetaasignadaFound.setMultiplo1(etiquetaasignada.getMultiplo1());
	etiquetaasignadaFound.setMultiplo2(etiquetaasignada.getMultiplo2());
	etiquetaasignadaFound.setMultiplo3(etiquetaasignada.getMultiplo3());
//	etiquetaasignadaFound.setClienteId(etiquetaasignada.getClienteId());
//	etiquetaasignadaFound.setOrdensimplificadaId(etiquetaasignada.getOrdensimplificadaId());
//	etiquetaasignadaFound.setEtiquetaasignadaId(etiquetaasignada.getEtiquetaasignadaId());

		    etiquetaasignadaService.editEtiquetaasignada(etiquetaasignadaFound);
	        return new ResponseEntity<Etiquetaasignada>(etiquetaasignadaFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un etiquetaasignada.
		 * @param id.
		 * @return ResponseEntity<Etiquetaasignada>.
		 */
		@RequestMapping(value = "/etiquetaasignada/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('ETIQUETAASIGNADADELETE')")  
	    public ResponseEntity<Etiquetaasignada> deleteEtiquetaasignada(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Etiquetaasignada etiquetaasignada = etiquetaasignadaService.getEtiquetaasignada(id);
	         if (etiquetaasignada == null) {
	             return new ResponseEntity<Etiquetaasignada>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             etiquetaasignadaService.deleteEtiquetaasignada(etiquetaasignada);
	             return new ResponseEntity<Etiquetaasignada>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Etiquetaasignada no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Etiquetaasignada>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Etiquetaasignada>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un etiquetaasignada.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveEtiquetaasignada", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ETIQUETAASIGNADA')")  
	public @ResponseBody String saveEtiquetaasignada(
			@ModelAttribute("command") EtiquetaasignadaBean etiquetaasignadaBean) {

		Etiquetaasignada etiquetaasignada = prepareModel(etiquetaasignadaBean);
		etiquetaasignadaService.addEtiquetaasignada(etiquetaasignada);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un etiquetaasignada.
	 * @param etiquetaasignadaBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editEtiquetaasignada", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ETIQUETAASIGNADA')")  
	public @ResponseBody String editEtiquetaasignada(
			@ModelAttribute("command") EtiquetaasignadaBean etiquetaasignadaBean) {


		Etiquetaasignada etiquetaasignada = prepareModel(etiquetaasignadaBean);
		etiquetaasignadaService.editEtiquetaasignada(etiquetaasignada);
		return "SUCCESS";
	}

	/**
	 * Agrega un ETIQUETAASIGNADA.
	 * @param ETIQUETAASIGNADABean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchEtiquetaasignada", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ETIQUETAASIGNADA')")  
	public ModelAndView addEtiquetaasignada(
			@ModelAttribute("command") EtiquetaasignadaBean etiquetaasignadaBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Etiquetaasignada etiquetaasignada = null;
		if (etiquetaasignadaBean != null)
			etiquetaasignada = prepareModel(etiquetaasignadaBean);
		model.put("etiquetaasignadas",
				prepareListofBean(etiquetaasignadaService.listEtiquetaasignadas(etiquetaasignada)));
		return new ModelAndView("searchEtiquetaasignada", model);
	}

	/**
	 * Elimina un etiquetaasignada.
	 * @param etiquetaasignadaBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteEtiquetaasignada", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ETIQUETAASIGNADA')")  
	public ModelAndView deleteEtiquetaasignada(
			@ModelAttribute("command") EtiquetaasignadaBean etiquetaasignadaBean,
			BindingResult result) {
		System.out.println("delete " + etiquetaasignadaBean.getEtiquetaasignadaId());
		etiquetaasignadaService.deleteEtiquetaasignada(prepareModel(etiquetaasignadaBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("etiquetaasignada", null);
		model.put("etiquetaasignadas",
				prepareListofBean(etiquetaasignadaService.listEtiquetaasignadas(null)));
		return new ModelAndView("searchEtiquetaasignada", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryEtiquetaasignada", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ETIQUETAASIGNADA')")  
	public ModelAndView entryEtiquetaasignada() {
		return new ModelAndView("redirect:/searchEtiquetaasignada");
	}

	private Etiquetaasignada prepareModel(EtiquetaasignadaBean etiquetaasignadaBean) {
		Etiquetaasignada etiquetaasignada = new Etiquetaasignada();

		//etiquetaasignada.setHIntegerId(etiquetaasignadaBean.getSapId());
		//etiquetaasignada.setHIntegerId(etiquetaasignadaBean.getEtiquetaasignadasxpaletId());
		//etiquetaasignada.setHIntegerId(etiquetaasignadaBean.getMultiplo1Id());
		//etiquetaasignada.setHIntegerId(etiquetaasignadaBean.getMultiplo2Id());
		//etiquetaasignada.setHIntegerId(etiquetaasignadaBean.getMultiplo3Id());
		//etiquetaasignada.setHIntegerId(etiquetaasignadaBean.getF5Id());
		//etiquetaasignada.setDeId(etiquetaasignadaBean.getDeId());
		//etiquetaasignada.setParaId(etiquetaasignadaBean.getParaId());
		//etiquetaasignada.setDisplayresultetiquetaasignadaId(etiquetaasignadaBean.getEtiquetaasignadaId());
		//etiquetaasignada.setExposedfilteretiquetaasignadaId(etiquetaasignadaBean.getEtiquetaasignadaId());
		//etiquetaasignada.setDisplaymodaletiquetaasignadaId(etiquetaasignadaBean.getEtiquetaasignadaId());
		//etiquetaasignada.setEntitynameetiquetaasignadaId(etiquetaasignadaBean.getEtiquetaasignadaId());
		//etiquetaasignada.setScaffoldetiquetaasignadaId(etiquetaasignadaBean.getEtiquetaasignadaId());
		etiquetaasignada.setEtiquetaasignadaId(etiquetaasignadaBean.getEtiquetaasignadaId());
		etiquetaasignadaBean.setEtiquetaasignadaId(null);

		return etiquetaasignada;
	}

	/**
	 * Convierte un objeto de tipo EtiquetaasignadaBean a un objeto de tipo Etiquetaasignada.
	 * @param etiquetaasignadaBean.
	 * @return Etiquetaasignada.
	 */
	private List<EtiquetaasignadaBean> prepareListofBean(List<Etiquetaasignada> etiquetaasignadas) {
		List<EtiquetaasignadaBean> beans = null;
		if (etiquetaasignadas != null && !etiquetaasignadas.isEmpty()) {
			beans = new ArrayList<EtiquetaasignadaBean>();
			EtiquetaasignadaBean bean = null;
			for (Etiquetaasignada etiquetaasignada : etiquetaasignadas) {
				bean = new EtiquetaasignadaBean();

				//bean.setDeId(etiquetaasignada.getDeId());
				//bean.setParaId(etiquetaasignada.getParaId());
				//bean.setDisplayresultetiquetaasignadaId(etiquetaasignada.getEtiquetaasignadaId());
				//bean.setExposedfilteretiquetaasignadaId(etiquetaasignada.getEtiquetaasignadaId());
				//bean.setDisplaymodaletiquetaasignadaId(etiquetaasignada.getEtiquetaasignadaId());
				//bean.setEntitynameetiquetaasignadaId(etiquetaasignada.getEtiquetaasignadaId());
				//bean.setScaffoldetiquetaasignadaId(etiquetaasignada.getEtiquetaasignadaId());
				bean.setEtiquetaasignadaId(etiquetaasignada.getEtiquetaasignadaId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


