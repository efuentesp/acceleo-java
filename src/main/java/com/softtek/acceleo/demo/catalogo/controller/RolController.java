/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Rols. 
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

import com.softtek.acceleo.demo.catalogo.bean.RolBean;
import com.softtek.acceleo.demo.domain.Rol;
import com.softtek.acceleo.demo.service.RolService;

/**
 * Clase RolController.
 * @author PSG.
 *
 */
@RestController
public class RolController {

	@Autowired
	private RolService rolService;
	
	Rol rol = new Rol();

	/************************************** SEARCH
	 * Obtiene informacion de los rols.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Rol>.
	 */
	@RequestMapping(value = "/rol", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLSEARCH')")
	public @ResponseBody  List<Rol> getRols(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Rol> listRol = null;

		if (query==null && _page == 0) {
       		listRol = rolService.listRols(rol);
			rows = rolService.getTotalRows();
		} else if (query!= null){
			listRol = rolService.listRolsQuery(rol, query, _page, 10);
			rows = rolService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listRol = rolService.listRolsPagination(rol, _page, 10);
			rows = rolService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listRol;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un rol.
	 * @param id.
	 * @return Rol.
	 */
	@RequestMapping(value = "/idrol/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLSEARCH')")
	    public @ResponseBody  Rol getRol(@PathVariable("id") int id) {	        
	        Rol rol = null;
	        
	        rol = rolService.getRol(id);
			return rol;
	 }

	/*************************** CREATE
	 * Crea un nuevo rol.
	 * @param rol.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/rol", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLCREATE')")
	    public ResponseEntity<Void> createRol(@RequestBody Rol rol,    UriComponentsBuilder ucBuilder) {
	   
	        rolService.addRol(rol);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/rol/{id}").buildAndExpand(rol.getRolId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un rol.
	  * @param id.
	  * @param rol.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/rol/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('ROLUPDATE')") 
	    public ResponseEntity<Rol> actualizarRol(
				@PathVariable("id") int id, 
				@RequestBody Rol rol) {
	        
	        Rol rolFound = rolService.getRol(id);
	         
	        if (rolFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);
	        }
	
	rolFound.setActivo(rol.getActivo());
	rolFound.setClave(rol.getClave());
	rolFound.setNombre(rol.getNombre());
	rolFound.setRolId(rol.getRolId());

		    rolService.editRol(rolFound);
	        return new ResponseEntity<Rol>(rolFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un rol.
		 * @param id.
		 * @return ResponseEntity<Rol>.
		 */
		@RequestMapping(value = "/rol/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('ROLDELETE')")  
	    public ResponseEntity<Rol> deleteRol(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Rol rol = rolService.getRol(id);
	         if (rol == null) {
	             return new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             rolService.deleteRol(rol);
	             return new ResponseEntity<Rol>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Rol no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Rol>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Rol>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un rol.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveRol", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROL')")  
	public @ResponseBody String saveRol(
			@ModelAttribute("command") RolBean rolBean) {

		Rol rol = prepareModel(rolBean);
		rolService.addRol(rol);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un rol.
	 * @param rolBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editRol", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROL')")  
	public @ResponseBody String editRol(
			@ModelAttribute("command") RolBean rolBean) {


		Rol rol = prepareModel(rolBean);
		rolService.editRol(rol);
		return "SUCCESS";
	}

	/**
	 * Agrega un ROL.
	 * @param ROLBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchRol", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROL')")  
	public ModelAndView addRol(
			@ModelAttribute("command") RolBean rolBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Rol rol = null;
		if (rolBean != null)
			rol = prepareModel(rolBean);
		model.put("rols",
				prepareListofBean(rolService.listRols(rol)));
		return new ModelAndView("searchRol", model);
	}

	/**
	 * Elimina un rol.
	 * @param rolBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteRol", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROL')")  
	public ModelAndView deleteRol(
			@ModelAttribute("command") RolBean rolBean,
			BindingResult result) {
		System.out.println("delete " + rolBean.getRolId());
		rolService.deleteRol(prepareModel(rolBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("rol", null);
		model.put("rols",
				prepareListofBean(rolService.listRols(null)));
		return new ModelAndView("searchRol", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryRol", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROL')")  
	public ModelAndView entryRol() {
		return new ModelAndView("redirect:/searchRol");
	}

	private Rol prepareModel(RolBean rolBean) {
		Rol rol = new Rol();

		//rol.setHIntegerId(rolBean.getClaveId());
		//rol.setHIntegerId(rolBean.getActivoId());
		//rol.setDisplayresultrolId(rolBean.getRolId());
		//rol.setExposedfilterrolId(rolBean.getRolId());
		//rol.setDisplaymodalrolId(rolBean.getRolId());
		//rol.setEntitynamerolId(rolBean.getRolId());
		//rol.setScaffoldrolId(rolBean.getRolId());
		rol.setNombre(rolBean.getNombre());
		rol.setRolId(rolBean.getRolId());
		rolBean.setRolId(null);

		return rol;
	}

	/**
	 * Convierte un objeto de tipo RolBean a un objeto de tipo Rol.
	 * @param rolBean.
	 * @return Rol.
	 */
	private List<RolBean> prepareListofBean(List<Rol> rols) {
		List<RolBean> beans = null;
		if (rols != null && !rols.isEmpty()) {
			beans = new ArrayList<RolBean>();
			RolBean bean = null;
			for (Rol rol : rols) {
				bean = new RolBean();

				//bean.setDisplayresultrolId(rol.getRolId());
				//bean.setExposedfilterrolId(rol.getRolId());
				//bean.setDisplaymodalrolId(rol.getRolId());
				//bean.setEntitynamerolId(rol.getRolId());
				//bean.setScaffoldrolId(rol.getRolId());
				bean.setNombre(rol.getNombre());
				bean.setRolId(rol.getRolId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


