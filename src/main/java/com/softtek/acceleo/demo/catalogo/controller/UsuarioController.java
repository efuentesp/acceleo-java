/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Usuarios. 
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

import com.softtek.acceleo.demo.catalogo.bean.UsuarioBean;
import com.softtek.acceleo.demo.domain.Usuario;
import com.softtek.acceleo.demo.service.UsuarioService;

/**
 * Clase UsuarioController.
 * @author PSG.
 *
 */
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	Usuario usuario = new Usuario();

	/************************************** SEARCH
	 * Obtiene informacion de los usuarios.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Usuario>.
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('USUARIOSEARCH')")
	public @ResponseBody  List<Usuario> getUsuarios(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Usuario> listUsuario = null;

		if (query==null && _page == 0) {
       		listUsuario = usuarioService.listUsuarios(usuario);
			rows = usuarioService.getTotalRows();
		} else if (query!= null){
			listUsuario = usuarioService.listUsuariosQuery(usuario, query, _page, 10);
			rows = usuarioService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listUsuario = usuarioService.listUsuariosPagination(usuario, _page, 10);
			rows = usuarioService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listUsuario;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un usuario.
	 * @param id.
	 * @return Usuario.
	 */
	@RequestMapping(value = "/idusuario/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('USUARIOSEARCH')")
	    public @ResponseBody  Usuario getUsuario(@PathVariable("id") int id) {	        
	        Usuario usuario = null;
	        
	        usuario = usuarioService.getUsuario(id);
			return usuario;
	 }

	/*************************** CREATE
	 * Crea un nuevo usuario.
	 * @param usuario.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/usuario", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('USUARIOCREATE')")
	    public ResponseEntity<Void> createUsuario(@RequestBody Usuario usuario,    UriComponentsBuilder ucBuilder) {
	   
	        usuarioService.addUsuario(usuario);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/usuario/{id}").buildAndExpand(usuario.getUsuarioId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un usuario.
	  * @param id.
	  * @param usuario.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('USUARIOUPDATE')") 
	    public ResponseEntity<Usuario> actualizarUsuario(
				@PathVariable("id") int id, 
				@RequestBody Usuario usuario) {
	        
	        Usuario usuarioFound = usuarioService.getUsuario(id);
	         
	        if (usuarioFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	        }
	
	usuarioFound.setActivo(usuario.getActivo());
	usuarioFound.setNombreclave(usuario.getNombreclave());
	usuarioFound.setPassword(usuario.getPassword());
	usuarioFound.setRolId(usuario.getRolId());
	usuarioFound.setUsuarioId(usuario.getUsuarioId());

		    usuarioService.editUsuario(usuarioFound);
	        return new ResponseEntity<Usuario>(usuarioFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un usuario.
		 * @param id.
		 * @return ResponseEntity<Usuario>.
		 */
		@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('USUARIODELETE')")  
	    public ResponseEntity<Usuario> deleteUsuario(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Usuario usuario = usuarioService.getUsuario(id);
	         if (usuario == null) {
	             return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             usuarioService.deleteUsuario(usuario);
	             return new ResponseEntity<Usuario>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Usuario no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Usuario>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Usuario>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un usuario.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USUARIO')")  
	public @ResponseBody String saveUsuario(
			@ModelAttribute("command") UsuarioBean usuarioBean) {

		Usuario usuario = prepareModel(usuarioBean);
		usuarioService.addUsuario(usuario);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un usuario.
	 * @param usuarioBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editUsuario", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USUARIO')")  
	public @ResponseBody String editUsuario(
			@ModelAttribute("command") UsuarioBean usuarioBean) {


		Usuario usuario = prepareModel(usuarioBean);
		usuarioService.editUsuario(usuario);
		return "SUCCESS";
	}

	/**
	 * Agrega un USUARIO.
	 * @param USUARIOBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchUsuario", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USUARIO')")  
	public ModelAndView addUsuario(
			@ModelAttribute("command") UsuarioBean usuarioBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Usuario usuario = null;
		if (usuarioBean != null)
			usuario = prepareModel(usuarioBean);
		model.put("usuarios",
				prepareListofBean(usuarioService.listUsuarios(usuario)));
		return new ModelAndView("searchUsuario", model);
	}

	/**
	 * Elimina un usuario.
	 * @param usuarioBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteUsuario", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USUARIO')")  
	public ModelAndView deleteUsuario(
			@ModelAttribute("command") UsuarioBean usuarioBean,
			BindingResult result) {
		System.out.println("delete " + usuarioBean.getUsuarioId());
		usuarioService.deleteUsuario(prepareModel(usuarioBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("usuario", null);
		model.put("usuarios",
				prepareListofBean(usuarioService.listUsuarios(null)));
		return new ModelAndView("searchUsuario", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryUsuario", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USUARIO')")  
	public ModelAndView entryUsuario() {
		return new ModelAndView("redirect:/searchUsuario");
	}

	private Usuario prepareModel(UsuarioBean usuarioBean) {
		Usuario usuario = new Usuario();

		//usuario.setHIntegerId(usuarioBean.getActivoId());
		//usuario.setRolId(usuarioBean.getRolId());
		//usuario.setDisplayresultusuarioId(usuarioBean.getUsuarioId());
		//usuario.setExposedfilterusuarioId(usuarioBean.getUsuarioId());
		//usuario.setDisplaymodalusuarioId(usuarioBean.getUsuarioId());
		//usuario.setEntitynameusuarioId(usuarioBean.getUsuarioId());
		//usuario.setScaffoldusuarioId(usuarioBean.getUsuarioId());
		usuario.setNombreclave(usuarioBean.getNombreclave());
		usuario.setPassword(usuarioBean.getPassword());
		usuario.setUsuarioId(usuarioBean.getUsuarioId());
		usuarioBean.setUsuarioId(null);

		return usuario;
	}

	/**
	 * Convierte un objeto de tipo UsuarioBean a un objeto de tipo Usuario.
	 * @param usuarioBean.
	 * @return Usuario.
	 */
	private List<UsuarioBean> prepareListofBean(List<Usuario> usuarios) {
		List<UsuarioBean> beans = null;
		if (usuarios != null && !usuarios.isEmpty()) {
			beans = new ArrayList<UsuarioBean>();
			UsuarioBean bean = null;
			for (Usuario usuario : usuarios) {
				bean = new UsuarioBean();

				//bean.setRolId(usuario.getRolId());
				//bean.setDisplayresultusuarioId(usuario.getUsuarioId());
				//bean.setExposedfilterusuarioId(usuario.getUsuarioId());
				//bean.setDisplaymodalusuarioId(usuario.getUsuarioId());
				//bean.setEntitynameusuarioId(usuario.getUsuarioId());
				//bean.setScaffoldusuarioId(usuario.getUsuarioId());
				bean.setNombreclave(usuario.getNombreclave());
				bean.setPassword(usuario.getPassword());
				bean.setUsuarioId(usuario.getUsuarioId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


