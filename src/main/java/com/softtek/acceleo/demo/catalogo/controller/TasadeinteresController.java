/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Tasadeinteress. 
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

import com.softtek.acceleo.demo.catalogo.bean.TasadeinteresBean;
import com.softtek.acceleo.demo.domain.Tasadeinteres;
import com.softtek.acceleo.demo.service.TasadeinteresService;

/**
 * Clase TasadeinteresController.
 * @author PSG.
 *
 */
@RestController
public class TasadeinteresController {

	@Autowired
	private TasadeinteresService tasadeinteresService;
	
	Tasadeinteres tasadeinteres = new Tasadeinteres();

	/************************************** SEARCH
	 * Obtiene informacion de los tasadeinteress.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Tasadeinteres>.
	 */
	@RequestMapping(value = "/tasadeinteres", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('TASADEINTERESSEARCH')")
	public @ResponseBody  List<Tasadeinteres> getTasadeinteress(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Tasadeinteres> listTasadeinteres = null;

		if (query==null && _page == 0) {
       		listTasadeinteres = tasadeinteresService.listTasadeinteress(tasadeinteres);
			rows = tasadeinteresService.getTotalRows();
		} else if (query!= null){
			listTasadeinteres = tasadeinteresService.listTasadeinteressQuery(tasadeinteres, query, _page, 10);
			rows = tasadeinteresService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listTasadeinteres = tasadeinteresService.listTasadeinteressPagination(tasadeinteres, _page, 10);
			rows = tasadeinteresService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listTasadeinteres;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un tasadeinteres.
	 * @param id.
	 * @return Tasadeinteres.
	 */
	@RequestMapping(value = "/idtasadeinteres/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('TASADEINTERESSEARCH')")
	    public @ResponseBody  Tasadeinteres getTasadeinteres(@PathVariable("id") int id) {	        
	        Tasadeinteres tasadeinteres = null;
	        
	        tasadeinteres = tasadeinteresService.getTasadeinteres(id);
			return tasadeinteres;
	 }

	/*************************** CREATE
	 * Crea un nuevo tasadeinteres.
	 * @param tasadeinteres.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/tasadeinteres", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('TASADEINTERESCREATE')")
	    public ResponseEntity<Void> createTasadeinteres(@RequestBody Tasadeinteres tasadeinteres,    UriComponentsBuilder ucBuilder) {
	   
	        tasadeinteresService.addTasadeinteres(tasadeinteres);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/tasadeinteres/{id}").buildAndExpand(tasadeinteres.getTasadeinteresId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un tasadeinteres.
	  * @param id.
	  * @param tasadeinteres.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/tasadeinteres/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('TASADEINTERESUPDATE')") 
	    public ResponseEntity<Tasadeinteres> actualizarTasadeinteres(
				@PathVariable("id") int id, 
				@RequestBody Tasadeinteres tasadeinteres) {
	        
	        Tasadeinteres tasadeinteresFound = tasadeinteresService.getTasadeinteres(id);
	         
	        if (tasadeinteresFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Tasadeinteres>(HttpStatus.NOT_FOUND);
	        }
	
	tasadeinteresFound.setFechafin(tasadeinteres.getFechafin());
	tasadeinteresFound.setFechainicio(tasadeinteres.getFechainicio());
	tasadeinteresFound.setTasa(tasadeinteres.getTasa());
	tasadeinteresFound.setEmpresaId(tasadeinteres.getEmpresaId());
	tasadeinteresFound.setTasadeinteresId(tasadeinteres.getTasadeinteresId());

		    tasadeinteresService.editTasadeinteres(tasadeinteresFound);
	        return new ResponseEntity<Tasadeinteres>(tasadeinteresFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un tasadeinteres.
		 * @param id.
		 * @return ResponseEntity<Tasadeinteres>.
		 */
		@RequestMapping(value = "/tasadeinteres/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('TASADEINTERESDELETE')")  
	    public ResponseEntity<Tasadeinteres> deleteTasadeinteres(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Tasadeinteres tasadeinteres = tasadeinteresService.getTasadeinteres(id);
	         if (tasadeinteres == null) {
	             return new ResponseEntity<Tasadeinteres>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             tasadeinteresService.deleteTasadeinteres(tasadeinteres);
	             return new ResponseEntity<Tasadeinteres>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Tasadeinteres no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Tasadeinteres>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Tasadeinteres>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un tasadeinteres.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveTasadeinteres", method = RequestMethod.POST)
	@PreAuthorize("hasRole('TASADEINTERES')")  
	public @ResponseBody String saveTasadeinteres(
			@ModelAttribute("command") TasadeinteresBean tasadeinteresBean) {

		Tasadeinteres tasadeinteres = prepareModel(tasadeinteresBean);
		tasadeinteresService.addTasadeinteres(tasadeinteres);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un tasadeinteres.
	 * @param tasadeinteresBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editTasadeinteres", method = RequestMethod.POST)
	@PreAuthorize("hasRole('TASADEINTERES')")  
	public @ResponseBody String editTasadeinteres(
			@ModelAttribute("command") TasadeinteresBean tasadeinteresBean) {


		Tasadeinteres tasadeinteres = prepareModel(tasadeinteresBean);
		tasadeinteresService.editTasadeinteres(tasadeinteres);
		return "SUCCESS";
	}

	/**
	 * Agrega un TASADEINTERES.
	 * @param TASADEINTERESBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchTasadeinteres", method = RequestMethod.GET)
	@PreAuthorize("hasRole('TASADEINTERES')")  
	public ModelAndView addTasadeinteres(
			@ModelAttribute("command") TasadeinteresBean tasadeinteresBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Tasadeinteres tasadeinteres = null;
		if (tasadeinteresBean != null)
			tasadeinteres = prepareModel(tasadeinteresBean);
		model.put("tasadeinteress",
				prepareListofBean(tasadeinteresService.listTasadeinteress(tasadeinteres)));
		return new ModelAndView("searchTasadeinteres", model);
	}

	/**
	 * Elimina un tasadeinteres.
	 * @param tasadeinteresBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteTasadeinteres", method = RequestMethod.POST)
	@PreAuthorize("hasRole('TASADEINTERES')")  
	public ModelAndView deleteTasadeinteres(
			@ModelAttribute("command") TasadeinteresBean tasadeinteresBean,
			BindingResult result) {
		System.out.println("delete " + tasadeinteresBean.getTasadeinteresId());
		tasadeinteresService.deleteTasadeinteres(prepareModel(tasadeinteresBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tasadeinteres", null);
		model.put("tasadeinteress",
				prepareListofBean(tasadeinteresService.listTasadeinteress(null)));
		return new ModelAndView("searchTasadeinteres", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryTasadeinteres", method = RequestMethod.GET)
	@PreAuthorize("hasRole('TASADEINTERES')")  
	public ModelAndView entryTasadeinteres() {
		return new ModelAndView("redirect:/searchTasadeinteres");
	}

	private Tasadeinteres prepareModel(TasadeinteresBean tasadeinteresBean) {
		Tasadeinteres tasadeinteres = new Tasadeinteres();

		//tasadeinteres.setParaId(tasadeinteresBean.getParaId());
		//tasadeinteres.setHDateId(tasadeinteresBean.getFechainicioId());
		//tasadeinteres.setHDateId(tasadeinteresBean.getFechafinId());
		//tasadeinteres.setHDoubleId(tasadeinteresBean.getTasaId());
		//tasadeinteres.setDisplayresulttasadeinteresId(tasadeinteresBean.getTasadeinteresId());
		//tasadeinteres.setExposedfiltertasadeinteresId(tasadeinteresBean.getTasadeinteresId());
		//tasadeinteres.setDisplaymodaltasadeinteresId(tasadeinteresBean.getTasadeinteresId());
		//tasadeinteres.setEntitynametasadeinteresId(tasadeinteresBean.getTasadeinteresId());
		//tasadeinteres.setScaffoldtasadeinteresId(tasadeinteresBean.getTasadeinteresId());
		tasadeinteres.setTasadeinteresId(tasadeinteresBean.getTasadeinteresId());
		tasadeinteresBean.setTasadeinteresId(null);

		return tasadeinteres;
	}

	/**
	 * Convierte un objeto de tipo TasadeinteresBean a un objeto de tipo Tasadeinteres.
	 * @param tasadeinteresBean.
	 * @return Tasadeinteres.
	 */
	private List<TasadeinteresBean> prepareListofBean(List<Tasadeinteres> tasadeinteress) {
		List<TasadeinteresBean> beans = null;
		if (tasadeinteress != null && !tasadeinteress.isEmpty()) {
			beans = new ArrayList<TasadeinteresBean>();
			TasadeinteresBean bean = null;
			for (Tasadeinteres tasadeinteres : tasadeinteress) {
				bean = new TasadeinteresBean();

				//bean.setParaId(tasadeinteres.getParaId());
				//bean.setDisplayresulttasadeinteresId(tasadeinteres.getTasadeinteresId());
				//bean.setExposedfiltertasadeinteresId(tasadeinteres.getTasadeinteresId());
				//bean.setDisplaymodaltasadeinteresId(tasadeinteres.getTasadeinteresId());
				//bean.setEntitynametasadeinteresId(tasadeinteres.getTasadeinteresId());
				//bean.setScaffoldtasadeinteresId(tasadeinteres.getTasadeinteresId());
				bean.setTasadeinteresId(tasadeinteres.getTasadeinteresId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


