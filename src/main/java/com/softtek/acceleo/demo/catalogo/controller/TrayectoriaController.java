/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Trayectorias. 
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

import com.softtek.acceleo.demo.catalogo.bean.TrayectoriaBean;
import com.softtek.acceleo.demo.domain.Trayectoria;
import com.softtek.acceleo.demo.service.TrayectoriaService;

/**
 * Clase TrayectoriaController.
 * @author PSG.
 *
 */
@RestController
public class TrayectoriaController {

	@Autowired
	private TrayectoriaService trayectoriaService;
	
	Trayectoria trayectoria = new Trayectoria();

	/************************************** SEARCH
	 * Obtiene informacion de los trayectorias.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Trayectoria>.
	 */
	@RequestMapping(value = "/trayectoria", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('TRAYECTORIASEARCH')")
	public @ResponseBody  List<Trayectoria> getTrayectorias(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Trayectoria> listTrayectoria = null;

		if (query==null && _page == 0) {
       		listTrayectoria = trayectoriaService.listTrayectorias(trayectoria);
			rows = trayectoriaService.getTotalRows();
		} else if (query!= null){
			listTrayectoria = trayectoriaService.listTrayectoriasQuery(trayectoria, query, _page, 10);
			rows = trayectoriaService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listTrayectoria = trayectoriaService.listTrayectoriasPagination(trayectoria, _page, 10);
			rows = trayectoriaService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listTrayectoria;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un trayectoria.
	 * @param id.
	 * @return Trayectoria.
	 */
	@RequestMapping(value = "/idtrayectoria/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('TRAYECTORIASEARCH')")
	    public @ResponseBody  Trayectoria getTrayectoria(@PathVariable("id") int id) {	        
	        Trayectoria trayectoria = null;
	        
	        trayectoria = trayectoriaService.getTrayectoria(id);
			return trayectoria;
	 }

	/*************************** CREATE
	 * Crea un nuevo trayectoria.
	 * @param trayectoria.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/trayectoria", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('TRAYECTORIACREATE')")
	    public ResponseEntity<Void> createTrayectoria(@RequestBody Trayectoria trayectoria,    UriComponentsBuilder ucBuilder) {
	   
	        trayectoriaService.addTrayectoria(trayectoria);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/trayectoria/{id}").buildAndExpand(trayectoria.getTrayectoriaId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un trayectoria.
	  * @param id.
	  * @param trayectoria.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/trayectoria/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('TRAYECTORIAUPDATE')") 
	    public ResponseEntity<Trayectoria> actualizarTrayectoria(
				@PathVariable("id") int id, 
				@RequestBody Trayectoria trayectoria) {
	        
	        Trayectoria trayectoriaFound = trayectoriaService.getTrayectoria(id);
	         
	        if (trayectoriaFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Trayectoria>(HttpStatus.NOT_FOUND);
	        }
	
	trayectoriaFound.setClave(trayectoria.getClave());
	trayectoriaFound.setDescripcion(trayectoria.getDescripcion());
	trayectoriaFound.setCandidatoId(trayectoria.getCandidatoId());
	trayectoriaFound.setTipotrayectoriaId(trayectoria.getTipotrayectoriaId());
	trayectoriaFound.setDocumentoId(trayectoria.getDocumentoId());
	trayectoriaFound.setTrayectoriaId(trayectoria.getTrayectoriaId());

		    trayectoriaService.editTrayectoria(trayectoriaFound);
	        return new ResponseEntity<Trayectoria>(trayectoriaFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un trayectoria.
		 * @param id.
		 * @return ResponseEntity<Trayectoria>.
		 */
		@RequestMapping(value = "/trayectoria/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('TRAYECTORIADELETE')")  
	    public ResponseEntity<Trayectoria> deleteTrayectoria(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Trayectoria trayectoria = trayectoriaService.getTrayectoria(id);
	         if (trayectoria == null) {
	             return new ResponseEntity<Trayectoria>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             trayectoriaService.deleteTrayectoria(trayectoria);
	             return new ResponseEntity<Trayectoria>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Trayectoria no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Trayectoria>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Trayectoria>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un trayectoria.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveTrayectoria", method = RequestMethod.POST)
	@PreAuthorize("hasRole('TRAYECTORIA')")  
	public @ResponseBody String saveTrayectoria(
			@ModelAttribute("command") TrayectoriaBean trayectoriaBean) {

		Trayectoria trayectoria = prepareModel(trayectoriaBean);
		trayectoriaService.addTrayectoria(trayectoria);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un trayectoria.
	 * @param trayectoriaBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editTrayectoria", method = RequestMethod.POST)
	@PreAuthorize("hasRole('TRAYECTORIA')")  
	public @ResponseBody String editTrayectoria(
			@ModelAttribute("command") TrayectoriaBean trayectoriaBean) {


		Trayectoria trayectoria = prepareModel(trayectoriaBean);
		trayectoriaService.editTrayectoria(trayectoria);
		return "SUCCESS";
	}

	/**
	 * Agrega un TRAYECTORIA.
	 * @param TRAYECTORIABean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchTrayectoria", method = RequestMethod.GET)
	@PreAuthorize("hasRole('TRAYECTORIA')")  
	public ModelAndView addTrayectoria(
			@ModelAttribute("command") TrayectoriaBean trayectoriaBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Trayectoria trayectoria = null;
		if (trayectoriaBean != null)
			trayectoria = prepareModel(trayectoriaBean);
		model.put("trayectorias",
				prepareListofBean(trayectoriaService.listTrayectorias(trayectoria)));
		return new ModelAndView("searchTrayectoria", model);
	}

	/**
	 * Elimina un trayectoria.
	 * @param trayectoriaBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteTrayectoria", method = RequestMethod.POST)
	@PreAuthorize("hasRole('TRAYECTORIA')")  
	public ModelAndView deleteTrayectoria(
			@ModelAttribute("command") TrayectoriaBean trayectoriaBean,
			BindingResult result) {
		System.out.println("delete " + trayectoriaBean.getTrayectoriaId());
		trayectoriaService.deleteTrayectoria(prepareModel(trayectoriaBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trayectoria", null);
		model.put("trayectorias",
				prepareListofBean(trayectoriaService.listTrayectorias(null)));
		return new ModelAndView("searchTrayectoria", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryTrayectoria", method = RequestMethod.GET)
	@PreAuthorize("hasRole('TRAYECTORIA')")  
	public ModelAndView entryTrayectoria() {
		return new ModelAndView("redirect:/searchTrayectoria");
	}

	private Trayectoria prepareModel(TrayectoriaBean trayectoriaBean) {
		Trayectoria trayectoria = new Trayectoria();

		//trayectoria.setCandidatoId(trayectoriaBean.getCandidatoId());
		//trayectoria.setRadiotipotrayectoriaId(trayectoriaBean.getTrayectoriaId());
		//trayectoria.setDocumentoId(trayectoriaBean.getDocumentoId());
		//trayectoria.setDisplayresulttrayectoriaId(trayectoriaBean.getTrayectoriaId());
		//trayectoria.setExposedfiltertrayectoriaId(trayectoriaBean.getTrayectoriaId());
		//trayectoria.setDisplaymodaltrayectoriaId(trayectoriaBean.getTrayectoriaId());
		//trayectoria.setEntitynametrayectoriaId(trayectoriaBean.getTrayectoriaId());
		//trayectoria.setScaffoldtrayectoriaId(trayectoriaBean.getTrayectoriaId());
		trayectoria.setDescripcion(trayectoriaBean.getDescripcion());
		trayectoria.setClave(trayectoriaBean.getClave());
		trayectoria.setTrayectoriaId(trayectoriaBean.getTrayectoriaId());
		trayectoriaBean.setTrayectoriaId(null);

		return trayectoria;
	}

	/**
	 * Convierte un objeto de tipo TrayectoriaBean a un objeto de tipo Trayectoria.
	 * @param trayectoriaBean.
	 * @return Trayectoria.
	 */
	private List<TrayectoriaBean> prepareListofBean(List<Trayectoria> trayectorias) {
		List<TrayectoriaBean> beans = null;
		if (trayectorias != null && !trayectorias.isEmpty()) {
			beans = new ArrayList<TrayectoriaBean>();
			TrayectoriaBean bean = null;
			for (Trayectoria trayectoria : trayectorias) {
				bean = new TrayectoriaBean();

				//bean.setCandidatoId(trayectoria.getCandidatoId());
				//bean.setRadiotipotrayectoriaId(trayectoria.getTrayectoriaId());
				//bean.setDocumentoId(trayectoria.getDocumentoId());
				//bean.setDisplayresulttrayectoriaId(trayectoria.getTrayectoriaId());
				//bean.setExposedfiltertrayectoriaId(trayectoria.getTrayectoriaId());
				//bean.setDisplaymodaltrayectoriaId(trayectoria.getTrayectoriaId());
				//bean.setEntitynametrayectoriaId(trayectoria.getTrayectoriaId());
				//bean.setScaffoldtrayectoriaId(trayectoria.getTrayectoriaId());
				bean.setDescripcion(trayectoria.getDescripcion());
				bean.setClave(trayectoria.getClave());
				bean.setTrayectoriaId(trayectoria.getTrayectoriaId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


