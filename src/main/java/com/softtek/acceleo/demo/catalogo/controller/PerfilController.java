/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Perfils. 
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

import com.softtek.acceleo.demo.catalogo.bean.PerfilBean;
import com.softtek.acceleo.demo.domain.Perfil;
import com.softtek.acceleo.demo.service.PerfilService;

/**
 * Clase PerfilController.
 * @author PSG.
 *
 */
@RestController
public class PerfilController {

	@Autowired
	private PerfilService perfilService;
	
	Perfil perfil = new Perfil();

	/************************************** SEARCH
	 * Obtiene informacion de los perfils.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Perfil>.
	 */
	@RequestMapping(value = "/perfil", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('PERFILSEARCH')")
	public @ResponseBody  List<Perfil> getPerfils(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Perfil> listPerfil = null;

		if (query==null && _page == 0) {
       		listPerfil = perfilService.listPerfils(perfil);
			rows = perfilService.getTotalRows();
		} else if (query!= null){
			listPerfil = perfilService.listPerfilsQuery(perfil, query, _page, 10);
			rows = perfilService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listPerfil = perfilService.listPerfilsPagination(perfil, _page, 10);
			rows = perfilService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listPerfil;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un perfil.
	 * @param id.
	 * @return Perfil.
	 */
	@RequestMapping(value = "/idperfil/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('PERFILSEARCH')")
	    public @ResponseBody  Perfil getPerfil(@PathVariable("id") int id) {	        
	        Perfil perfil = null;
	        
	        perfil = perfilService.getPerfil(id);
			return perfil;
	 }

	/*************************** CREATE
	 * Crea un nuevo perfil.
	 * @param perfil.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/perfil", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('PERFILCREATE')")
	    public ResponseEntity<Void> createPerfil(@RequestBody Perfil perfil,    UriComponentsBuilder ucBuilder) {
	   
	        perfilService.addPerfil(perfil);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/perfil/{id}").buildAndExpand(perfil.getPerfilId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un perfil.
	  * @param id.
	  * @param perfil.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/perfil/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('PERFILUPDATE')") 
	    public ResponseEntity<Perfil> actualizarPerfil(
				@PathVariable("id") int id, 
				@RequestBody Perfil perfil) {
	        
	        Perfil perfilFound = perfilService.getPerfil(id);
	         
	        if (perfilFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Perfil>(HttpStatus.NOT_FOUND);
	        }
	
	perfilFound.setNip(perfil.getNip());
	perfilFound.setUsuario(perfil.getUsuario());
	perfilFound.setSocioId(perfil.getSocioId());
	perfilFound.setPerfilId(perfil.getPerfilId());

		    perfilService.editPerfil(perfilFound);
	        return new ResponseEntity<Perfil>(perfilFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un perfil.
		 * @param id.
		 * @return ResponseEntity<Perfil>.
		 */
		@RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('PERFILDELETE')")  
	    public ResponseEntity<Perfil> deletePerfil(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Perfil perfil = perfilService.getPerfil(id);
	         if (perfil == null) {
	             return new ResponseEntity<Perfil>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             perfilService.deletePerfil(perfil);
	             return new ResponseEntity<Perfil>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Perfil no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Perfil>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Perfil>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un perfil.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/savePerfil", method = RequestMethod.POST)
	@PreAuthorize("hasRole('PERFIL')")  
	public @ResponseBody String savePerfil(
			@ModelAttribute("command") PerfilBean perfilBean) {

		Perfil perfil = prepareModel(perfilBean);
		perfilService.addPerfil(perfil);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un perfil.
	 * @param perfilBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editPerfil", method = RequestMethod.POST)
	@PreAuthorize("hasRole('PERFIL')")  
	public @ResponseBody String editPerfil(
			@ModelAttribute("command") PerfilBean perfilBean) {


		Perfil perfil = prepareModel(perfilBean);
		perfilService.editPerfil(perfil);
		return "SUCCESS";
	}

	/**
	 * Agrega un PERFIL.
	 * @param PERFILBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchPerfil", method = RequestMethod.GET)
	@PreAuthorize("hasRole('PERFIL')")  
	public ModelAndView addPerfil(
			@ModelAttribute("command") PerfilBean perfilBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Perfil perfil = null;
		if (perfilBean != null)
			perfil = prepareModel(perfilBean);
		model.put("perfils",
				prepareListofBean(perfilService.listPerfils(perfil)));
		return new ModelAndView("searchPerfil", model);
	}

	/**
	 * Elimina un perfil.
	 * @param perfilBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deletePerfil", method = RequestMethod.POST)
	@PreAuthorize("hasRole('PERFIL')")  
	public ModelAndView deletePerfil(
			@ModelAttribute("command") PerfilBean perfilBean,
			BindingResult result) {
		System.out.println("delete " + perfilBean.getPerfilId());
		perfilService.deletePerfil(prepareModel(perfilBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("perfil", null);
		model.put("perfils",
				prepareListofBean(perfilService.listPerfils(null)));
		return new ModelAndView("searchPerfil", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryPerfil", method = RequestMethod.GET)
	@PreAuthorize("hasRole('PERFIL')")  
	public ModelAndView entryPerfil() {
		return new ModelAndView("redirect:/searchPerfil");
	}

	private Perfil prepareModel(PerfilBean perfilBean) {
		Perfil perfil = new Perfil();

		//perfil.setDeId(perfilBean.getDeId());
		//perfil.setDisplayresultperfilId(perfilBean.getPerfilId());
		//perfil.setExposedfilterperfilId(perfilBean.getPerfilId());
		//perfil.setDisplaymodalperfilId(perfilBean.getPerfilId());
		//perfil.setEntitynameperfilId(perfilBean.getPerfilId());
		//perfil.setScaffoldperfilId(perfilBean.getPerfilId());
		perfil.setUsuario(perfilBean.getUsuario());
		perfil.setNip(perfilBean.getNip());
		perfil.setPerfilId(perfilBean.getPerfilId());
		perfilBean.setPerfilId(null);

		return perfil;
	}

	/**
	 * Convierte un objeto de tipo PerfilBean a un objeto de tipo Perfil.
	 * @param perfilBean.
	 * @return Perfil.
	 */
	private List<PerfilBean> prepareListofBean(List<Perfil> perfils) {
		List<PerfilBean> beans = null;
		if (perfils != null && !perfils.isEmpty()) {
			beans = new ArrayList<PerfilBean>();
			PerfilBean bean = null;
			for (Perfil perfil : perfils) {
				bean = new PerfilBean();

				//bean.setDeId(perfil.getDeId());
				//bean.setDisplayresultperfilId(perfil.getPerfilId());
				//bean.setExposedfilterperfilId(perfil.getPerfilId());
				//bean.setDisplaymodalperfilId(perfil.getPerfilId());
				//bean.setEntitynameperfilId(perfil.getPerfilId());
				//bean.setScaffoldperfilId(perfil.getPerfilId());
				bean.setUsuario(perfil.getUsuario());
				bean.setNip(perfil.getNip());
				bean.setPerfilId(perfil.getPerfilId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


