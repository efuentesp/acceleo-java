/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Modules. 
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

import com.softtek.acceleo.demo.catalogo.bean.ModuleBean;
import com.softtek.acceleo.demo.domain.Module;
import com.softtek.acceleo.demo.service.ModuleService;

/**
 * Clase ModuleController.
 * @author PSG.
 *
 */
@RestController
public class ModuleController {

	@Autowired
	private ModuleService moduleService;
	
	Module module = new Module();

	/************************************** SEARCH
	 * Obtiene informacion de los modules.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Module>.
	 */
	@RequestMapping(value = "/module", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('MODULESEARCH')")
	public @ResponseBody  List<Module> getModules(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Module> listModule = null;

		if (query==null && _page == 0) {
       		listModule = moduleService.listModules(module);
			rows = moduleService.getTotalRows();
		} else if (query!= null){
			listModule = moduleService.listModulesQuery(module, query, _page, 10);
			rows = moduleService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listModule = moduleService.listModulesPagination(module, _page, 10);
			rows = moduleService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listModule;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un module.
	 * @param id.
	 * @return Module.
	 */
	@RequestMapping(value = "/idmodule/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('MODULESEARCH')")
	    public @ResponseBody  Module getModule(@PathVariable("id") int id) {	        
	        Module module = null;
	        
	        module = moduleService.getModule(id);
			return module;
	 }

	/*************************** CREATE
	 * Crea un nuevo module.
	 * @param module.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/module", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('MODULECREATE')")
	    public ResponseEntity<Void> createModule(@RequestBody Module module,    UriComponentsBuilder ucBuilder) {
	   
	        moduleService.addModule(module);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/module/{id}").buildAndExpand(module.getModuleId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un module.
	  * @param id.
	  * @param module.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/module/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('MODULEUPDATE')") 
	    public ResponseEntity<Module> actualizarModule(
				@PathVariable("id") int id, 
				@RequestBody Module module) {
	        
	        Module moduleFound = moduleService.getModule(id);
	         
	        if (moduleFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
	        }
	
	moduleFound.setName(module.getName());
	moduleFound.setCode(module.getCode());
	moduleFound.setApplicationId(module.getApplicationId());
	moduleFound.setModuleId(module.getModuleId());

		    moduleService.editModule(moduleFound);
	        return new ResponseEntity<Module>(moduleFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un module.
		 * @param id.
		 * @return ResponseEntity<Module>.
		 */
		@RequestMapping(value = "/module/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('MODULEDELETE')")  
	    public ResponseEntity<Module> deleteModule(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Module module = moduleService.getModule(id);
	         if (module == null) {
	             return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             moduleService.deleteModule(module);
	             return new ResponseEntity<Module>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Module no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Module>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Module>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un module.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveModule", method = RequestMethod.POST)
	@PreAuthorize("hasRole('MODULE')")  
	public @ResponseBody String saveModule(
			@ModelAttribute("command") ModuleBean moduleBean) {

		Module module = prepareModel(moduleBean);
		moduleService.addModule(module);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un module.
	 * @param moduleBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editModule", method = RequestMethod.POST)
	@PreAuthorize("hasRole('MODULE')")  
	public @ResponseBody String editModule(
			@ModelAttribute("command") ModuleBean moduleBean) {


		Module module = prepareModel(moduleBean);
		moduleService.editModule(module);
		return "SUCCESS";
	}

	/**
	 * Agrega un MODULE.
	 * @param MODULEBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchModule", method = RequestMethod.GET)
	@PreAuthorize("hasRole('MODULE')")  
	public ModelAndView addModule(
			@ModelAttribute("command") ModuleBean moduleBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Module module = null;
		if (moduleBean != null)
			module = prepareModel(moduleBean);
		model.put("modules",
				prepareListofBean(moduleService.listModules(module)));
		return new ModelAndView("searchModule", model);
	}

	/**
	 * Elimina un module.
	 * @param moduleBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteModule", method = RequestMethod.POST)
	@PreAuthorize("hasRole('MODULE')")  
	public ModelAndView deleteModule(
			@ModelAttribute("command") ModuleBean moduleBean,
			BindingResult result) {
		System.out.println("delete " + moduleBean.getModuleId());
		moduleService.deleteModule(prepareModel(moduleBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("module", null);
		model.put("modules",
				prepareListofBean(moduleService.listModules(null)));
		return new ModelAndView("searchModule", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryModule", method = RequestMethod.GET)
	@PreAuthorize("hasRole('MODULE')")  
	public ModelAndView entryModule() {
		return new ModelAndView("redirect:/searchModule");
	}

	private Module prepareModel(ModuleBean moduleBean) {
		Module module = new Module();

		module.setApplicationId(moduleBean.getApplicationId());
		//module.setDisplay_resultmoduleId(moduleBean.getModuleId());
		//module.setExposed_filtermoduleId(moduleBean.getModuleId());
		//module.setDisplay_modalmoduleId(moduleBean.getModuleId());
		//module.setEntity_namemoduleId(moduleBean.getModuleId());
		module.setCode(moduleBean.getCode());
		module.setName(moduleBean.getName());
		module.setModuleId(moduleBean.getModuleId());
		moduleBean.setModuleId(null);

		return module;
	}

	/**
	 * Convierte un objeto de tipo ModuleBean a un objeto de tipo Module.
	 * @param moduleBean.
	 * @return Module.
	 */
	private List<ModuleBean> prepareListofBean(List<Module> modules) {
		List<ModuleBean> beans = null;
		if (modules != null && !modules.isEmpty()) {
			beans = new ArrayList<ModuleBean>();
			ModuleBean bean = null;
			for (Module module : modules) {
				bean = new ModuleBean();

				bean.setApplicationId(module.getApplicationId());
				//bean.setDisplay_resultmoduleId(module.getModuleId());
				//bean.setExposed_filtermoduleId(module.getModuleId());
				//bean.setDisplay_modalmoduleId(module.getModuleId());
				//bean.setEntity_namemoduleId(module.getModuleId());
				bean.setCode(module.getCode());
				bean.setName(module.getName());
				bean.setModuleId(module.getModuleId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


