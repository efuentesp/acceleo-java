/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Tipopensions. 
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

import com.softtek.acceleo.demo.catalogo.bean.TipopensionBean;
import com.softtek.acceleo.demo.domain.Tipopension;
import com.softtek.acceleo.demo.service.TipopensionService;

/**
 * Clase TipopensionController.
 * @author PSG.
 *
 */
@RestController
public class TipopensionController {

	@Autowired
	private TipopensionService tipopensionService;
	
	Tipopension tipopension = new Tipopension();

	/************************************** SEARCH
	 * Obtiene informacion de los tipopensions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Tipopension>.
	 */
	@RequestMapping(value = "/tipopension", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('TIPOPENSIONSEARCH')")
	public @ResponseBody  List<Tipopension> getTipopensions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Tipopension> listTipopension = null;

		if (query==null && _page == 0) {
       		listTipopension = tipopensionService.listTipopensions(tipopension);
			rows = tipopensionService.getTotalRows();
		} else if (query!= null){
			listTipopension = tipopensionService.listTipopensionsQuery(tipopension, query, _page, 10);
			rows = tipopensionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listTipopension = tipopensionService.listTipopensionsPagination(tipopension, _page, 10);
			rows = tipopensionService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listTipopension;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un tipopension.
	 * @param id.
	 * @return Tipopension.
	 */
	@RequestMapping(value = "/idtipopension/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('TIPOPENSIONSEARCH')")
	    public @ResponseBody  Tipopension getTipopension(@PathVariable("id") int id) {	        
	        Tipopension tipopension = null;
	        
	        tipopension = tipopensionService.getTipopension(id);
			return tipopension;
	 }

	/*************************** CREATE
	 * Crea un nuevo tipopension.
	 * @param tipopension.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/tipopension", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('TIPOPENSIONCREATE')")
	    public ResponseEntity<Void> createTipopension(@RequestBody Tipopension tipopension,    UriComponentsBuilder ucBuilder) {
	   
	        tipopensionService.addTipopension(tipopension);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/tipopension/{id}").buildAndExpand(tipopension.getTipopensionId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un tipopension.
	  * @param id.
	  * @param tipopension.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/tipopension/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('TIPOPENSIONUPDATE')") 
	    public ResponseEntity<Tipopension> actualizarTipopension(
				@PathVariable("id") int id, 
				@RequestBody Tipopension tipopension) {
	        
	        Tipopension tipopensionFound = tipopensionService.getTipopension(id);
	         
	        if (tipopensionFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Tipopension>(HttpStatus.NOT_FOUND);
	        }
	
	tipopensionFound.setClave(tipopension.getClave());
	tipopensionFound.setNombre(tipopension.getNombre());
	tipopensionFound.setTipopensionId(tipopension.getTipopensionId());

		    tipopensionService.editTipopension(tipopensionFound);
	        return new ResponseEntity<Tipopension>(tipopensionFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un tipopension.
		 * @param id.
		 * @return ResponseEntity<Tipopension>.
		 */
		@RequestMapping(value = "/tipopension/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('TIPOPENSIONDELETE')")  
	    public ResponseEntity<Tipopension> deleteTipopension(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Tipopension tipopension = tipopensionService.getTipopension(id);
	         if (tipopension == null) {
	             return new ResponseEntity<Tipopension>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             tipopensionService.deleteTipopension(tipopension);
	             return new ResponseEntity<Tipopension>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Tipopension no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Tipopension>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Tipopension>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un tipopension.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveTipopension", method = RequestMethod.POST)
	@PreAuthorize("hasRole('TIPOPENSION')")  
	public @ResponseBody String saveTipopension(
			@ModelAttribute("command") TipopensionBean tipopensionBean) {

		Tipopension tipopension = prepareModel(tipopensionBean);
		tipopensionService.addTipopension(tipopension);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un tipopension.
	 * @param tipopensionBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editTipopension", method = RequestMethod.POST)
	@PreAuthorize("hasRole('TIPOPENSION')")  
	public @ResponseBody String editTipopension(
			@ModelAttribute("command") TipopensionBean tipopensionBean) {


		Tipopension tipopension = prepareModel(tipopensionBean);
		tipopensionService.editTipopension(tipopension);
		return "SUCCESS";
	}

	/**
	 * Agrega un TIPOPENSION.
	 * @param TIPOPENSIONBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchTipopension", method = RequestMethod.GET)
	@PreAuthorize("hasRole('TIPOPENSION')")  
	public ModelAndView addTipopension(
			@ModelAttribute("command") TipopensionBean tipopensionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Tipopension tipopension = null;
		if (tipopensionBean != null)
			tipopension = prepareModel(tipopensionBean);
		model.put("tipopensions",
				prepareListofBean(tipopensionService.listTipopensions(tipopension)));
		return new ModelAndView("searchTipopension", model);
	}

	/**
	 * Elimina un tipopension.
	 * @param tipopensionBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteTipopension", method = RequestMethod.POST)
	@PreAuthorize("hasRole('TIPOPENSION')")  
	public ModelAndView deleteTipopension(
			@ModelAttribute("command") TipopensionBean tipopensionBean,
			BindingResult result) {
		System.out.println("delete " + tipopensionBean.getTipopensionId());
		tipopensionService.deleteTipopension(prepareModel(tipopensionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tipopension", null);
		model.put("tipopensions",
				prepareListofBean(tipopensionService.listTipopensions(null)));
		return new ModelAndView("searchTipopension", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryTipopension", method = RequestMethod.GET)
	@PreAuthorize("hasRole('TIPOPENSION')")  
	public ModelAndView entryTipopension() {
		return new ModelAndView("redirect:/searchTipopension");
	}

	private Tipopension prepareModel(TipopensionBean tipopensionBean) {
		Tipopension tipopension = new Tipopension();

		//tipopension.setDisplayresulttipopensionId(tipopensionBean.getTipopensionId());
		//tipopension.setExposedfiltertipopensionId(tipopensionBean.getTipopensionId());
		//tipopension.setDisplaymodaltipopensionId(tipopensionBean.getTipopensionId());
		//tipopension.setEntitynametipopensionId(tipopensionBean.getTipopensionId());
		tipopension.setClave(tipopensionBean.getClave());
		tipopension.setNombre(tipopensionBean.getNombre());
		tipopension.setTipopensionId(tipopensionBean.getTipopensionId());
		tipopensionBean.setTipopensionId(null);

		return tipopension;
	}

	/**
	 * Convierte un objeto de tipo TipopensionBean a un objeto de tipo Tipopension.
	 * @param tipopensionBean.
	 * @return Tipopension.
	 */
	private List<TipopensionBean> prepareListofBean(List<Tipopension> tipopensions) {
		List<TipopensionBean> beans = null;
		if (tipopensions != null && !tipopensions.isEmpty()) {
			beans = new ArrayList<TipopensionBean>();
			TipopensionBean bean = null;
			for (Tipopension tipopension : tipopensions) {
				bean = new TipopensionBean();

				//bean.setDisplayresulttipopensionId(tipopension.getTipopensionId());
				//bean.setExposedfiltertipopensionId(tipopension.getTipopensionId());
				//bean.setDisplaymodaltipopensionId(tipopension.getTipopensionId());
				//bean.setEntitynametipopensionId(tipopension.getTipopensionId());
				bean.setClave(tipopension.getClave());
				bean.setNombre(tipopension.getNombre());
				bean.setTipopensionId(tipopension.getTipopensionId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


