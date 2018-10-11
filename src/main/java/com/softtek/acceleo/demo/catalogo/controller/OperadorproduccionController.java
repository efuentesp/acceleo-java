/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Operadorproduccions. 
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

import com.softtek.acceleo.demo.catalogo.bean.OperadorproduccionBean;
import com.softtek.acceleo.demo.domain.Operadorproduccion;
import com.softtek.acceleo.demo.service.OperadorproduccionService;

/**
 * Clase OperadorproduccionController.
 * @author PSG.
 *
 */
@RestController
public class OperadorproduccionController {

	@Autowired
	private OperadorproduccionService operadorproduccionService;
	
	Operadorproduccion operadorproduccion = new Operadorproduccion();

	/************************************** SEARCH
	 * Obtiene informacion de los operadorproduccions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Operadorproduccion>.
	 */
	@RequestMapping(value = "/operadorproduccion", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('OPERADORPRODUCCIONSEARCH')")
	public @ResponseBody  List<Operadorproduccion> getOperadorproduccions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Operadorproduccion> listOperadorproduccion = null;

		if (query==null && _page == 0) {
       		listOperadorproduccion = operadorproduccionService.listOperadorproduccions(operadorproduccion);
			rows = operadorproduccionService.getTotalRows();
		} else if (query!= null){
			listOperadorproduccion = operadorproduccionService.listOperadorproduccionsQuery(operadorproduccion, query, _page, 10);
			rows = operadorproduccionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listOperadorproduccion = operadorproduccionService.listOperadorproduccionsPagination(operadorproduccion, _page, 10);
			rows = operadorproduccionService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listOperadorproduccion;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un operadorproduccion.
	 * @param id.
	 * @return Operadorproduccion.
	 */
	@RequestMapping(value = "/idoperadorproduccion/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('OPERADORPRODUCCIONSEARCH')")
	    public @ResponseBody  Operadorproduccion getOperadorproduccion(@PathVariable("id") int id) {	        
	        Operadorproduccion operadorproduccion = null;
	        
	        operadorproduccion = operadorproduccionService.getOperadorproduccion(id);
			return operadorproduccion;
	 }

	/*************************** CREATE
	 * Crea un nuevo operadorproduccion.
	 * @param operadorproduccion.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/operadorproduccion", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('OPERADORPRODUCCIONCREATE')")
	    public ResponseEntity<Void> createOperadorproduccion(@RequestBody Operadorproduccion operadorproduccion,    UriComponentsBuilder ucBuilder) {
	   
	        operadorproduccionService.addOperadorproduccion(operadorproduccion);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/operadorproduccion/{id}").buildAndExpand(operadorproduccion.getOperadorproduccionId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un operadorproduccion.
	  * @param id.
	  * @param operadorproduccion.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/operadorproduccion/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('OPERADORPRODUCCIONUPDATE')") 
	    public ResponseEntity<Operadorproduccion> actualizarOperadorproduccion(
				@PathVariable("id") int id, 
				@RequestBody Operadorproduccion operadorproduccion) {
	        
	        Operadorproduccion operadorproduccionFound = operadorproduccionService.getOperadorproduccion(id);
	         
	        if (operadorproduccionFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Operadorproduccion>(HttpStatus.NOT_FOUND);
	        }
	
	operadorproduccionFound.setNombre(operadorproduccion.getNombre());
	operadorproduccionFound.setNumeroempleado(operadorproduccion.getNumeroempleado());
	operadorproduccionFound.setOperadorproduccionId(operadorproduccion.getOperadorproduccionId());

		    operadorproduccionService.editOperadorproduccion(operadorproduccionFound);
	        return new ResponseEntity<Operadorproduccion>(operadorproduccionFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un operadorproduccion.
		 * @param id.
		 * @return ResponseEntity<Operadorproduccion>.
		 */
		@RequestMapping(value = "/operadorproduccion/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('OPERADORPRODUCCIONDELETE')")  
	    public ResponseEntity<Operadorproduccion> deleteOperadorproduccion(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Operadorproduccion operadorproduccion = operadorproduccionService.getOperadorproduccion(id);
	         if (operadorproduccion == null) {
	             return new ResponseEntity<Operadorproduccion>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             operadorproduccionService.deleteOperadorproduccion(operadorproduccion);
	             return new ResponseEntity<Operadorproduccion>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Operadorproduccion no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Operadorproduccion>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Operadorproduccion>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un operadorproduccion.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveOperadorproduccion", method = RequestMethod.POST)
	@PreAuthorize("hasRole('OPERADORPRODUCCION')")  
	public @ResponseBody String saveOperadorproduccion(
			@ModelAttribute("command") OperadorproduccionBean operadorproduccionBean) {

		Operadorproduccion operadorproduccion = prepareModel(operadorproduccionBean);
		operadorproduccionService.addOperadorproduccion(operadorproduccion);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un operadorproduccion.
	 * @param operadorproduccionBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editOperadorproduccion", method = RequestMethod.POST)
	@PreAuthorize("hasRole('OPERADORPRODUCCION')")  
	public @ResponseBody String editOperadorproduccion(
			@ModelAttribute("command") OperadorproduccionBean operadorproduccionBean) {


		Operadorproduccion operadorproduccion = prepareModel(operadorproduccionBean);
		operadorproduccionService.editOperadorproduccion(operadorproduccion);
		return "SUCCESS";
	}

	/**
	 * Agrega un OPERADORPRODUCCION.
	 * @param OPERADORPRODUCCIONBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchOperadorproduccion", method = RequestMethod.GET)
	@PreAuthorize("hasRole('OPERADORPRODUCCION')")  
	public ModelAndView addOperadorproduccion(
			@ModelAttribute("command") OperadorproduccionBean operadorproduccionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Operadorproduccion operadorproduccion = null;
		if (operadorproduccionBean != null)
			operadorproduccion = prepareModel(operadorproduccionBean);
		model.put("operadorproduccions",
				prepareListofBean(operadorproduccionService.listOperadorproduccions(operadorproduccion)));
		return new ModelAndView("searchOperadorproduccion", model);
	}

	/**
	 * Elimina un operadorproduccion.
	 * @param operadorproduccionBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteOperadorproduccion", method = RequestMethod.POST)
	@PreAuthorize("hasRole('OPERADORPRODUCCION')")  
	public ModelAndView deleteOperadorproduccion(
			@ModelAttribute("command") OperadorproduccionBean operadorproduccionBean,
			BindingResult result) {
		System.out.println("delete " + operadorproduccionBean.getOperadorproduccionId());
		operadorproduccionService.deleteOperadorproduccion(prepareModel(operadorproduccionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("operadorproduccion", null);
		model.put("operadorproduccions",
				prepareListofBean(operadorproduccionService.listOperadorproduccions(null)));
		return new ModelAndView("searchOperadorproduccion", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryOperadorproduccion", method = RequestMethod.GET)
	@PreAuthorize("hasRole('OPERADORPRODUCCION')")  
	public ModelAndView entryOperadorproduccion() {
		return new ModelAndView("redirect:/searchOperadorproduccion");
	}

	private Operadorproduccion prepareModel(OperadorproduccionBean operadorproduccionBean) {
		Operadorproduccion operadorproduccion = new Operadorproduccion();

		//operadorproduccion.setHIntegerId(operadorproduccionBean.getNumeroempleadoId());
		//operadorproduccion.setDisplayresultoperadorproduccionId(operadorproduccionBean.getOperadorproduccionId());
		//operadorproduccion.setExposedfilteroperadorproduccionId(operadorproduccionBean.getOperadorproduccionId());
		//operadorproduccion.setDisplaymodaloperadorproduccionId(operadorproduccionBean.getOperadorproduccionId());
		//operadorproduccion.setEntitynameoperadorproduccionId(operadorproduccionBean.getOperadorproduccionId());
		//operadorproduccion.setScaffoldoperadorproduccionId(operadorproduccionBean.getOperadorproduccionId());
		operadorproduccion.setNombre(operadorproduccionBean.getNombre());
		operadorproduccion.setOperadorproduccionId(operadorproduccionBean.getOperadorproduccionId());
		operadorproduccionBean.setOperadorproduccionId(null);

		return operadorproduccion;
	}

	/**
	 * Convierte un objeto de tipo OperadorproduccionBean a un objeto de tipo Operadorproduccion.
	 * @param operadorproduccionBean.
	 * @return Operadorproduccion.
	 */
	private List<OperadorproduccionBean> prepareListofBean(List<Operadorproduccion> operadorproduccions) {
		List<OperadorproduccionBean> beans = null;
		if (operadorproduccions != null && !operadorproduccions.isEmpty()) {
			beans = new ArrayList<OperadorproduccionBean>();
			OperadorproduccionBean bean = null;
			for (Operadorproduccion operadorproduccion : operadorproduccions) {
				bean = new OperadorproduccionBean();

				//bean.setDisplayresultoperadorproduccionId(operadorproduccion.getOperadorproduccionId());
				//bean.setExposedfilteroperadorproduccionId(operadorproduccion.getOperadorproduccionId());
				//bean.setDisplaymodaloperadorproduccionId(operadorproduccion.getOperadorproduccionId());
				//bean.setEntitynameoperadorproduccionId(operadorproduccion.getOperadorproduccionId());
				//bean.setScaffoldoperadorproduccionId(operadorproduccion.getOperadorproduccionId());
				bean.setNombre(operadorproduccion.getNombre());
				bean.setOperadorproduccionId(operadorproduccion.getOperadorproduccionId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


