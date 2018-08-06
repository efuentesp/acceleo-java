/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Applications. 
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

import com.softtek.acceleo.demo.catalogo.bean.ApplicationBean;
import com.softtek.acceleo.demo.domain.Application;
import com.softtek.acceleo.demo.service.ApplicationService;

/**
 * Clase ApplicationController.
 * @author PSG.
 *
 */
@RestController
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;
	
	Application application = new Application();

	/************************************** SEARCH
	 * Obtiene informacion de los applications.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Application>.
	 */
	@RequestMapping(value = "/application", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('APPLICATIONSEARCH')")
	public @ResponseBody  List<Application> getApplications(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Application> listApplication = null;

		if (query==null && _page == 0) {
       		listApplication = applicationService.listApplications(application);
			rows = applicationService.getTotalRows();
		} else if (query!= null){
			listApplication = applicationService.listApplicationsQuery(application, query, _page, 10);
			rows = applicationService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listApplication = applicationService.listApplicationsPagination(application, _page, 10);
			rows = applicationService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listApplication;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un application.
	 * @param id.
	 * @return Application.
	 */
	@RequestMapping(value = "/idapplication/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('APPLICATIONSEARCH')")
	    public @ResponseBody  Application getApplication(@PathVariable("id") int id) {	        
	        Application application = null;
	        
	        application = applicationService.getApplication(id);
			return application;
	 }

	/*************************** CREATE
	 * Crea un nuevo application.
	 * @param application.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/application", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('APPLICATIONCREATE')")
	    public ResponseEntity<Void> createApplication(@RequestBody Application application,    UriComponentsBuilder ucBuilder) {
	   
	        applicationService.addApplication(application);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/application/{id}").buildAndExpand(application.getApplicationId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un application.
	  * @param id.
	  * @param application.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/application/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('APPLICATIONUPDATE')") 
	    public ResponseEntity<Application> actualizarApplication(
				@PathVariable("id") int id, 
				@RequestBody Application application) {
	        
	        Application applicationFound = applicationService.getApplication(id);
	         
	        if (applicationFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Application>(HttpStatus.NOT_FOUND);
	        }
	
	applicationFound.setCode(application.getCode());
	applicationFound.setName(application.getName());
	applicationFound.setApplicationId(application.getApplicationId());

		    applicationService.editApplication(applicationFound);
	        return new ResponseEntity<Application>(applicationFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un application.
		 * @param id.
		 * @return ResponseEntity<Application>.
		 */
		@RequestMapping(value = "/application/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('APPLICATIONDELETE')")  
	    public ResponseEntity<Application> deleteApplication(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Application application = applicationService.getApplication(id);
	         if (application == null) {
	             return new ResponseEntity<Application>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             applicationService.deleteApplication(application);
	             return new ResponseEntity<Application>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Application no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Application>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Application>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un application.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveApplication", method = RequestMethod.POST)
	@PreAuthorize("hasRole('APPLICATION')")  
	public @ResponseBody String saveApplication(
			@ModelAttribute("command") ApplicationBean applicationBean) {

		Application application = prepareModel(applicationBean);
		applicationService.addApplication(application);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un application.
	 * @param applicationBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editApplication", method = RequestMethod.POST)
	@PreAuthorize("hasRole('APPLICATION')")  
	public @ResponseBody String editApplication(
			@ModelAttribute("command") ApplicationBean applicationBean) {


		Application application = prepareModel(applicationBean);
		applicationService.editApplication(application);
		return "SUCCESS";
	}

	/**
	 * Agrega un APPLICATION.
	 * @param APPLICATIONBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchApplication", method = RequestMethod.GET)
	@PreAuthorize("hasRole('APPLICATION')")  
	public ModelAndView addApplication(
			@ModelAttribute("command") ApplicationBean applicationBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Application application = null;
		if (applicationBean != null)
			application = prepareModel(applicationBean);
		model.put("applications",
				prepareListofBean(applicationService.listApplications(application)));
		return new ModelAndView("searchApplication", model);
	}

	/**
	 * Elimina un application.
	 * @param applicationBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteApplication", method = RequestMethod.POST)
	@PreAuthorize("hasRole('APPLICATION')")  
	public ModelAndView deleteApplication(
			@ModelAttribute("command") ApplicationBean applicationBean,
			BindingResult result) {
		System.out.println("delete " + applicationBean.getApplicationId());
		applicationService.deleteApplication(prepareModel(applicationBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("application", null);
		model.put("applications",
				prepareListofBean(applicationService.listApplications(null)));
		return new ModelAndView("searchApplication", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryApplication", method = RequestMethod.GET)
	@PreAuthorize("hasRole('APPLICATION')")  
	public ModelAndView entryApplication() {
		return new ModelAndView("redirect:/searchApplication");
	}

	private Application prepareModel(ApplicationBean applicationBean) {
		Application application = new Application();

		//application.setDisplay_resultapplicationId(applicationBean.getApplicationId());
		//application.setExposed_filterapplicationId(applicationBean.getApplicationId());
		//application.setDisplay_modalapplicationId(applicationBean.getApplicationId());
		//application.setEntity_nameapplicationId(applicationBean.getApplicationId());
		application.setCode(applicationBean.getCode());
		application.setName(applicationBean.getName());
		application.setApplicationId(applicationBean.getApplicationId());
		applicationBean.setApplicationId(null);

		return application;
	}

	/**
	 * Convierte un objeto de tipo ApplicationBean a un objeto de tipo Application.
	 * @param applicationBean.
	 * @return Application.
	 */
	private List<ApplicationBean> prepareListofBean(List<Application> applications) {
		List<ApplicationBean> beans = null;
		if (applications != null && !applications.isEmpty()) {
			beans = new ArrayList<ApplicationBean>();
			ApplicationBean bean = null;
			for (Application application : applications) {
				bean = new ApplicationBean();

				//bean.setDisplay_resultapplicationId(application.getApplicationId());
				//bean.setExposed_filterapplicationId(application.getApplicationId());
				//bean.setDisplay_modalapplicationId(application.getApplicationId());
				//bean.setEntity_nameapplicationId(application.getApplicationId());
				bean.setCode(application.getCode());
				bean.setName(application.getName());
				bean.setApplicationId(application.getApplicationId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


