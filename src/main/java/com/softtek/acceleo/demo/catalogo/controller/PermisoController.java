/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Permisos. 
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

import com.softtek.acceleo.demo.catalogo.bean.PermisoBean;
import com.softtek.acceleo.demo.domain.Permiso;
import com.softtek.acceleo.demo.service.PermisoService;

/**
 * Clase PermisoController.
 * @author PSG.
 *
 */
@RestController
public class PermisoController {

	@Autowired
	private PermisoService permisoService;
	
	Permiso permiso = new Permiso();

	/************************************** SEARCH
	 * Obtiene informacion de los permisos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Permiso>.
	 */
	@RequestMapping(value = "/permiso", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('PERMISOSEARCH')")
	public @ResponseBody  List<Permiso> getPermisos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Permiso> listPermiso = null;

		if (query==null && _page == 0) {
       		listPermiso = permisoService.listPermisos(permiso);
			rows = permisoService.getTotalRows();
		} else if (query!= null){
			listPermiso = permisoService.listPermisosQuery(permiso, query, _page, 10);
			rows = permisoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listPermiso = permisoService.listPermisosPagination(permiso, _page, 10);
			rows = permisoService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listPermiso;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un permiso.
	 * @param id.
	 * @return Permiso.
	 */
	@RequestMapping(value = "/idpermiso/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('PERMISOSEARCH')")
	    public @ResponseBody  Permiso getPermiso(@PathVariable("id") int id) {	        
	        Permiso permiso = null;
	        
	        permiso = permisoService.getPermiso(id);
			return permiso;
	 }

	/*************************** CREATE
	 * Crea un nuevo permiso.
	 * @param permiso.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/permiso", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('PERMISOCREATE')")
	    public ResponseEntity<Void> createPermiso(@RequestBody Permiso permiso,    UriComponentsBuilder ucBuilder) {
	   
	        permisoService.addPermiso(permiso);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/permiso/{id}").buildAndExpand(permiso.getPermisoId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un permiso.
	  * @param id.
	  * @param permiso.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/permiso/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('PERMISOUPDATE')") 
	    public ResponseEntity<Permiso> actualizarPermiso(
				@PathVariable("id") int id, 
				@RequestBody Permiso permiso) {
	        
	        Permiso permisoFound = permisoService.getPermiso(id);
	         
	        if (permisoFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Permiso>(HttpStatus.NOT_FOUND);
	        }
	
	permisoFound.setRuta(permiso.getRuta());
	permisoFound.setFuncion(permiso.getFuncion());
	permisoFound.setNivelpermiso(permiso.getNivelpermiso());
	permisoFound.setRolId(permiso.getRolId());
	permisoFound.setPermisoId(permiso.getPermisoId());

		    permisoService.editPermiso(permisoFound);
	        return new ResponseEntity<Permiso>(permisoFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un permiso.
		 * @param id.
		 * @return ResponseEntity<Permiso>.
		 */
		@RequestMapping(value = "/permiso/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('PERMISODELETE')")  
	    public ResponseEntity<Permiso> deletePermiso(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Permiso permiso = permisoService.getPermiso(id);
	         if (permiso == null) {
	             return new ResponseEntity<Permiso>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             permisoService.deletePermiso(permiso);
	             return new ResponseEntity<Permiso>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Permiso no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Permiso>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Permiso>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un permiso.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/savePermiso", method = RequestMethod.POST)
	@PreAuthorize("hasRole('PERMISO')")  
	public @ResponseBody String savePermiso(
			@ModelAttribute("command") PermisoBean permisoBean) {

		Permiso permiso = prepareModel(permisoBean);
		permisoService.addPermiso(permiso);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un permiso.
	 * @param permisoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editPermiso", method = RequestMethod.POST)
	@PreAuthorize("hasRole('PERMISO')")  
	public @ResponseBody String editPermiso(
			@ModelAttribute("command") PermisoBean permisoBean) {


		Permiso permiso = prepareModel(permisoBean);
		permisoService.editPermiso(permiso);
		return "SUCCESS";
	}

	/**
	 * Agrega un PERMISO.
	 * @param PERMISOBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchPermiso", method = RequestMethod.GET)
	@PreAuthorize("hasRole('PERMISO')")  
	public ModelAndView addPermiso(
			@ModelAttribute("command") PermisoBean permisoBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Permiso permiso = null;
		if (permisoBean != null)
			permiso = prepareModel(permisoBean);
		model.put("permisos",
				prepareListofBean(permisoService.listPermisos(permiso)));
		return new ModelAndView("searchPermiso", model);
	}

	/**
	 * Elimina un permiso.
	 * @param permisoBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deletePermiso", method = RequestMethod.POST)
	@PreAuthorize("hasRole('PERMISO')")  
	public ModelAndView deletePermiso(
			@ModelAttribute("command") PermisoBean permisoBean,
			BindingResult result) {
		System.out.println("delete " + permisoBean.getPermisoId());
		permisoService.deletePermiso(prepareModel(permisoBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("permiso", null);
		model.put("permisos",
				prepareListofBean(permisoService.listPermisos(null)));
		return new ModelAndView("searchPermiso", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryPermiso", method = RequestMethod.GET)
	@PreAuthorize("hasRole('PERMISO')")  
	public ModelAndView entryPermiso() {
		return new ModelAndView("redirect:/searchPermiso");
	}

	private Permiso prepareModel(PermisoBean permisoBean) {
		Permiso permiso = new Permiso();

		//permiso.setRolId(permisoBean.getRolId());
		//permiso.setDisplayresultpermisoId(permisoBean.getPermisoId());
		//permiso.setExposedfilterpermisoId(permisoBean.getPermisoId());
		//permiso.setDisplaymodalpermisoId(permisoBean.getPermisoId());
		//permiso.setEntitynamepermisoId(permisoBean.getPermisoId());
		//permiso.setScaffoldpermisoId(permisoBean.getPermisoId());
		permiso.setFuncion(permisoBean.getFuncion());
		permiso.setRuta(permisoBean.getRuta());
		permiso.setNivelpermiso(permisoBean.getNivelpermiso());
		permiso.setPermisoId(permisoBean.getPermisoId());
		permisoBean.setPermisoId(null);

		return permiso;
	}

	/**
	 * Convierte un objeto de tipo PermisoBean a un objeto de tipo Permiso.
	 * @param permisoBean.
	 * @return Permiso.
	 */
	private List<PermisoBean> prepareListofBean(List<Permiso> permisos) {
		List<PermisoBean> beans = null;
		if (permisos != null && !permisos.isEmpty()) {
			beans = new ArrayList<PermisoBean>();
			PermisoBean bean = null;
			for (Permiso permiso : permisos) {
				bean = new PermisoBean();

				//bean.setRolId(permiso.getRolId());
				//bean.setDisplayresultpermisoId(permiso.getPermisoId());
				//bean.setExposedfilterpermisoId(permiso.getPermisoId());
				//bean.setDisplaymodalpermisoId(permiso.getPermisoId());
				//bean.setEntitynamepermisoId(permiso.getPermisoId());
				//bean.setScaffoldpermisoId(permiso.getPermisoId());
				bean.setFuncion(permiso.getFuncion());
				bean.setRuta(permiso.getRuta());
				bean.setNivelpermiso(permiso.getNivelpermiso());
				bean.setPermisoId(permiso.getPermisoId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


