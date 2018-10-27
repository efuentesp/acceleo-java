/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Filials. 
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

import com.softtek.acceleo.demo.catalogo.bean.FilialBean;
import com.softtek.acceleo.demo.domain.Filial;
import com.softtek.acceleo.demo.domain.Filial;
import com.softtek.acceleo.demo.service.FilialService;

/**
 * Clase FilialController.
 * @author PSG.
 *
 */
@RestController
public class FilialController {

	@Autowired
	private FilialService filialService;
	
	Filial filial = new Filial();

	/************************************** SEARCH
	 * Obtiene informacion de los filials.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Filial>.
	 */
	@RequestMapping(value = "/filial", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('FILIALSEARCH')")
	public @ResponseBody  List<Filial> getFilials(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Filial> listFilial = null;

		if (query==null && _page == 0) {
       		listFilial = filialService.listFilials(filial);
			rows = filialService.getTotalRows();
		} else if (query!= null){
			listFilial = filialService.listFilialsQuery(filial, query, _page, 10);
			rows = filialService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listFilial = filialService.listFilialsPagination(filial, _page, 10);
			rows = filialService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listFilial;
	}

	/************************************** SEARCH
	 * Obtiene informacion de los candidatos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Filial>.
	 */
	@RequestMapping(value = "/filial/candidato/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('DIRECCIONSEARCH')")
	public @ResponseBody  List<Filial> getFilialsByCandidato(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {

		List<Filial> listFilial = null;
		listFilial = filialService.listFilialsByCandidato(filial, id);
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		
		return listFilial;
	}
	
	/************************************* SEARCH
	 * Obtiene informacion de un filial.
	 * @param id.
	 * @return Filial.
	 */
	@RequestMapping(value = "/idfilial/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('FILIALSEARCH')")
	    public @ResponseBody  Filial getFilial(@PathVariable("id") int id) {	        
	        Filial filial = null;
	        
	        filial = filialService.getFilial(id);
			return filial;
	 }

	/*************************** CREATE
	 * Crea un nuevo filial.
	 * @param filial.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/filial", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('FILIALCREATE')")
	    public ResponseEntity<Void> createFilial(@RequestBody Filial filial,    UriComponentsBuilder ucBuilder) {
	   
	        filialService.addFilial(filial);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/filial/{id}").buildAndExpand(filial.getFilialId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un filial.
	  * @param id.
	  * @param filial.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/filial/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('FILIALUPDATE')") 
	    public ResponseEntity<Filial> actualizarFilial(
				@PathVariable("id") int id, 
				@RequestBody Filial filial) {
	        
	        Filial filialFound = filialService.getFilial(id);
	         
	        if (filialFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Filial>(HttpStatus.NOT_FOUND);
	        }
	
	filialFound.setSitio(filial.getSitio());
	filialFound.setTelefono(filial.getTelefono());
	filialFound.setNombre(filial.getNombre());
	filialFound.setCiudad(filial.getCiudad());
	filialFound.setEstado(filial.getEstado());
	filialFound.setUbicacion(filial.getUbicacion());
	filialFound.setContacto(filial.getContacto());
	filialFound.setNotas(filial.getNotas());
	filialFound.setFilialId(filial.getFilialId());

		    filialService.editFilial(filialFound);
	        return new ResponseEntity<Filial>(filialFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un filial.
		 * @param id.
		 * @return ResponseEntity<Filial>.
		 */
		@RequestMapping(value = "/filial/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('FILIALDELETE')")  
	    public ResponseEntity<Filial> deleteFilial(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Filial filial = filialService.getFilial(id);
	         if (filial == null) {
	             return new ResponseEntity<Filial>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             filialService.deleteFilial(filial);
	             return new ResponseEntity<Filial>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Filial no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Filial>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Filial>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un filial.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveFilial", method = RequestMethod.POST)
	@PreAuthorize("hasRole('FILIAL')")  
	public @ResponseBody String saveFilial(
			@ModelAttribute("command") FilialBean filialBean) {

		Filial filial = prepareModel(filialBean);
		filialService.addFilial(filial);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un filial.
	 * @param filialBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editFilial", method = RequestMethod.POST)
	@PreAuthorize("hasRole('FILIAL')")  
	public @ResponseBody String editFilial(
			@ModelAttribute("command") FilialBean filialBean) {


		Filial filial = prepareModel(filialBean);
		filialService.editFilial(filial);
		return "SUCCESS";
	}

	/**
	 * Agrega un FILIAL.
	 * @param FILIALBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchFilial", method = RequestMethod.GET)
	@PreAuthorize("hasRole('FILIAL')")  
	public ModelAndView addFilial(
			@ModelAttribute("command") FilialBean filialBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Filial filial = null;
		if (filialBean != null)
			filial = prepareModel(filialBean);
		model.put("filials",
				prepareListofBean(filialService.listFilials(filial)));
		return new ModelAndView("searchFilial", model);
	}

	/**
	 * Elimina un filial.
	 * @param filialBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteFilial", method = RequestMethod.POST)
	@PreAuthorize("hasRole('FILIAL')")  
	public ModelAndView deleteFilial(
			@ModelAttribute("command") FilialBean filialBean,
			BindingResult result) {
		System.out.println("delete " + filialBean.getFilialId());
		filialService.deleteFilial(prepareModel(filialBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("filial", null);
		model.put("filials",
				prepareListofBean(filialService.listFilials(null)));
		return new ModelAndView("searchFilial", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryFilial", method = RequestMethod.GET)
	@PreAuthorize("hasRole('FILIAL')")  
	public ModelAndView entryFilial() {
		return new ModelAndView("redirect:/searchFilial");
	}

	private Filial prepareModel(FilialBean filialBean) {
		Filial filial = new Filial();

		//filial.setNotrequiredfilialId(filialBean.getNotasId());
		//filial.setDisplayresultfilialId(filialBean.getFilialId());
		//filial.setExposedfilterfilialId(filialBean.getFilialId());
		//filial.setDisplaymodalfilialId(filialBean.getFilialId());
		//filial.setEntitynamefilialId(filialBean.getFilialId());
		//filial.setScaffoldfilialId(filialBean.getFilialId());
		filial.setNombre(filialBean.getNombre());
		filial.setUbicacion(filialBean.getUbicacion());
		filial.setCiudad(filialBean.getCiudad());
		filial.setEstado(filialBean.getEstado());
		filial.setTelefono(filialBean.getTelefono());
		filial.setSitio(filialBean.getSitio());
		filial.setContacto(filialBean.getContacto());
		filial.setFilialId(filialBean.getFilialId());
		filialBean.setFilialId(null);

		return filial;
	}

	/**
	 * Convierte un objeto de tipo FilialBean a un objeto de tipo Filial.
	 * @param filialBean.
	 * @return Filial.
	 */
	private List<FilialBean> prepareListofBean(List<Filial> filials) {
		List<FilialBean> beans = null;
		if (filials != null && !filials.isEmpty()) {
			beans = new ArrayList<FilialBean>();
			FilialBean bean = null;
			for (Filial filial : filials) {
				bean = new FilialBean();

				//bean.setNotrequiredfilialId(filial.getNotasId());
				//bean.setDisplayresultfilialId(filial.getFilialId());
				//bean.setExposedfilterfilialId(filial.getFilialId());
				//bean.setDisplaymodalfilialId(filial.getFilialId());
				//bean.setEntitynamefilialId(filial.getFilialId());
				//bean.setScaffoldfilialId(filial.getFilialId());
				bean.setNombre(filial.getNombre());
				bean.setUbicacion(filial.getUbicacion());
				bean.setCiudad(filial.getCiudad());
				bean.setEstado(filial.getEstado());
				bean.setTelefono(filial.getTelefono());
				bean.setSitio(filial.getSitio());
				bean.setContacto(filial.getContacto());
				bean.setFilialId(filial.getFilialId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


