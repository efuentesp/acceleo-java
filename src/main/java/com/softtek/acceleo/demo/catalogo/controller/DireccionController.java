/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Direccions. 
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

import com.softtek.acceleo.demo.catalogo.bean.DireccionBean;
import com.softtek.acceleo.demo.domain.Direccion;
import com.softtek.acceleo.demo.service.DireccionService;

/**
 * Clase DireccionController.
 * @author PSG.
 *
 */
@RestController
public class DireccionController {

	@Autowired
	private DireccionService direccionService;
	
	Direccion direccion = new Direccion();

	/************************************** SEARCH
	 * Obtiene informacion de los direccions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Direccion>.
	 */
	@RequestMapping(value = "/direccion", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('DIRECCIONSEARCH')")
	public @ResponseBody  List<Direccion> getDireccions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Direccion> listDireccion = null;

		if (query==null && _page == 0) {
       		listDireccion = direccionService.listDireccions(direccion);
			rows = direccionService.getTotalRows();
		} else if (query!= null){
			listDireccion = direccionService.listDireccionsQuery(direccion, query, _page, 10);
			rows = direccionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listDireccion = direccionService.listDireccionsPagination(direccion, _page, 10);
			rows = direccionService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listDireccion;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un direccion.
	 * @param id.
	 * @return Direccion.
	 */
	@RequestMapping(value = "/iddireccion/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('DIRECCIONSEARCH')")
	    public @ResponseBody  Direccion getDireccion(@PathVariable("id") int id) {	        
	        Direccion direccion = null;
	        
	        direccion = direccionService.getDireccion(id);
			return direccion;
	 }

	/*************************** CREATE
	 * Crea un nuevo direccion.
	 * @param direccion.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/direccion", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('DIRECCIONCREATE')")
	    public ResponseEntity<Void> createDireccion(@RequestBody Direccion direccion,    UriComponentsBuilder ucBuilder) {
	   
	        direccionService.addDireccion(direccion);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/direccion/{id}").buildAndExpand(direccion.getDireccionId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un direccion.
	  * @param id.
	  * @param direccion.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/direccion/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('DIRECCIONUPDATE')") 
	    public ResponseEntity<Direccion> actualizarDireccion(
				@PathVariable("id") int id, 
				@RequestBody Direccion direccion) {
	        
	        Direccion direccionFound = direccionService.getDireccion(id);
	         
	        if (direccionFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Direccion>(HttpStatus.NOT_FOUND);
	        }
	
	System.out.println("Direccion:"+ direccion);        
	direccionFound.setEstado(direccion.getEstado());
	direccionFound.setCp(direccion.getCp());
	direccionFound.setCiudad(direccion.getCiudad());
	direccionFound.setCalle(direccion.getCalle());
	direccionFound.setCandidato(direccion.getCandidato());
	direccionFound.setDireccionId(direccion.getDireccionId());

		    direccionService.editDireccion(direccionFound);
	        return new ResponseEntity<Direccion>(direccionFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un direccion.
		 * @param id.
		 * @return ResponseEntity<Direccion>.
		 */
		@RequestMapping(value = "/direccion/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('DIRECCIONDELETE')")  
	    public ResponseEntity<Direccion> deleteDireccion(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Direccion direccion = direccionService.getDireccion(id);
	         if (direccion == null) {
	             return new ResponseEntity<Direccion>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             direccionService.deleteDireccion(direccion);
	             return new ResponseEntity<Direccion>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Direccion no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Direccion>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Direccion>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un direccion.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveDireccion", method = RequestMethod.POST)
	@PreAuthorize("hasRole('DIRECCION')")  
	public @ResponseBody String saveDireccion(
			@ModelAttribute("command") DireccionBean direccionBean) {

		Direccion direccion = prepareModel(direccionBean);
		direccionService.addDireccion(direccion);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un direccion.
	 * @param direccionBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editDireccion", method = RequestMethod.POST)
	@PreAuthorize("hasRole('DIRECCION')")  
	public @ResponseBody String editDireccion(
			@ModelAttribute("command") DireccionBean direccionBean) {


		Direccion direccion = prepareModel(direccionBean);
		direccionService.editDireccion(direccion);
		return "SUCCESS";
	}

	/**
	 * Agrega un DIRECCION.
	 * @param DIRECCIONBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchDireccion", method = RequestMethod.GET)
	@PreAuthorize("hasRole('DIRECCION')")  
	public ModelAndView addDireccion(
			@ModelAttribute("command") DireccionBean direccionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Direccion direccion = null;
		if (direccionBean != null)
			direccion = prepareModel(direccionBean);
		model.put("direccions",
				prepareListofBean(direccionService.listDireccions(direccion)));
		return new ModelAndView("searchDireccion", model);
	}

	/**
	 * Elimina un direccion.
	 * @param direccionBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteDireccion", method = RequestMethod.POST)
	@PreAuthorize("hasRole('DIRECCION')")  
	public ModelAndView deleteDireccion(
			@ModelAttribute("command") DireccionBean direccionBean,
			BindingResult result) {
		System.out.println("delete " + direccionBean.getDireccionId());
		direccionService.deleteDireccion(prepareModel(direccionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("direccion", null);
		model.put("direccions",
				prepareListofBean(direccionService.listDireccions(null)));
		return new ModelAndView("searchDireccion", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryDireccion", method = RequestMethod.GET)
	@PreAuthorize("hasRole('DIRECCION')")  
	public ModelAndView entryDireccion() {
		return new ModelAndView("redirect:/searchDireccion");
	}

	private Direccion prepareModel(DireccionBean direccionBean) {
		Direccion direccion = new Direccion();

		//direccion.setCandidatoId(direccionBean.getCandidatoId());
		//direccion.setDisplayresultdireccionId(direccionBean.getDireccionId());
		//direccion.setExposedfilterdireccionId(direccionBean.getDireccionId());
		//direccion.setDisplaymodaldireccionId(direccionBean.getDireccionId());
		//direccion.setEntitynamedireccionId(direccionBean.getDireccionId());
		//direccion.setScaffolddireccionId(direccionBean.getDireccionId());
		direccion.setCalle(direccionBean.getCalle());
		direccion.setCp(direccionBean.getCp());
		direccion.setCiudad(direccionBean.getCiudad());
		direccion.setEstado(direccionBean.getEstado());
		direccion.setDireccionId(direccionBean.getDireccionId());
		direccionBean.setDireccionId(null);

		return direccion;
	}

	/**
	 * Convierte un objeto de tipo DireccionBean a un objeto de tipo Direccion.
	 * @param direccionBean.
	 * @return Direccion.
	 */
	private List<DireccionBean> prepareListofBean(List<Direccion> direccions) {
		List<DireccionBean> beans = null;
		if (direccions != null && !direccions.isEmpty()) {
			beans = new ArrayList<DireccionBean>();
			DireccionBean bean = null;
			for (Direccion direccion : direccions) {
				bean = new DireccionBean();

				//bean.setCandidatoId(direccion.getCandidatoId());
				//bean.setDisplayresultdireccionId(direccion.getDireccionId());
				//bean.setExposedfilterdireccionId(direccion.getDireccionId());
				//bean.setDisplaymodaldireccionId(direccion.getDireccionId());
				//bean.setEntitynamedireccionId(direccion.getDireccionId());
				//bean.setScaffolddireccionId(direccion.getDireccionId());
				bean.setCalle(direccion.getCalle());
				bean.setCp(direccion.getCp());
				bean.setCiudad(direccion.getCiudad());
				bean.setEstado(direccion.getEstado());
				bean.setDireccionId(direccion.getDireccionId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


