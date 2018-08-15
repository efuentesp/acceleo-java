/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Socios. 
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

import com.softtek.acceleo.demo.catalogo.bean.SocioBean;
import com.softtek.acceleo.demo.domain.Socio;
import com.softtek.acceleo.demo.service.SocioService;

/**
 * Clase SocioController.
 * @author PSG.
 *
 */
@RestController
public class SocioController {

	@Autowired
	private SocioService socioService;
	
	Socio socio = new Socio();

	/************************************** SEARCH
	 * Obtiene informacion de los socios.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Socio>.
	 */
	@RequestMapping(value = "/socio", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('SOCIOSEARCH')")
	public @ResponseBody  List<Socio> getSocios(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Socio> listSocio = null;

		if (query==null && _page == 0) {
       		listSocio = socioService.listSocios(socio);
			rows = socioService.getTotalRows();
		} else if (query!= null){
			listSocio = socioService.listSociosQuery(socio, query, _page, 10);
			rows = socioService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listSocio = socioService.listSociosPagination(socio, _page, 10);
			rows = socioService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listSocio;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un socio.
	 * @param id.
	 * @return Socio.
	 */
	@RequestMapping(value = "/idsocio/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('SOCIOSEARCH')")
	    public @ResponseBody  Socio getSocio(@PathVariable("id") int id) {	        
	        Socio socio = null;
	        
	        socio = socioService.getSocio(id);
			return socio;
	 }

	/*************************** CREATE
	 * Crea un nuevo socio.
	 * @param socio.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/socio", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('SOCIOCREATE')")
	    public ResponseEntity<Void> createSocio(@RequestBody Socio socio,    UriComponentsBuilder ucBuilder) {
	   
	        socioService.addSocio(socio);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/socio/{id}").buildAndExpand(socio.getSocioId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un socio.
	  * @param id.
	  * @param socio.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/socio/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('SOCIOUPDATE')") 
	    public ResponseEntity<Socio> actualizarSocio(
				@PathVariable("id") int id, 
				@RequestBody Socio socio) {
	        
	        Socio socioFound = socioService.getSocio(id);
	         
	        if (socioFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Socio>(HttpStatus.NOT_FOUND);
	        }
	
	socioFound.setApellidopaterno(socio.getApellidopaterno());
	socioFound.setNumero(socio.getNumero());
	socioFound.setNombre(socio.getNombre());
	socioFound.setApellidomaterno(socio.getApellidomaterno());
	socioFound.setGeneroId(socio.getGeneroId());
	socioFound.setCorreo(socio.getCorreo());
	socioFound.setTelefono(socio.getTelefono());
	socioFound.setCorreo(socio.getCorreo());
	socioFound.setTelefono(socio.getTelefono());
	socioFound.setTipoempleadoId(socio.getTipoempleadoId());
	socioFound.setDepartamentoId(socio.getDepartamentoId());
	socioFound.setPlantaId(socio.getPlantaId());
	socioFound.setSocioId(socio.getSocioId());

		    socioService.editSocio(socioFound);
	        return new ResponseEntity<Socio>(socioFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un socio.
		 * @param id.
		 * @return ResponseEntity<Socio>.
		 */
		@RequestMapping(value = "/socio/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('SOCIODELETE')")  
	    public ResponseEntity<Socio> deleteSocio(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Socio socio = socioService.getSocio(id);
	         if (socio == null) {
	             return new ResponseEntity<Socio>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             socioService.deleteSocio(socio);
	             return new ResponseEntity<Socio>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Socio no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Socio>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Socio>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un socio.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveSocio", method = RequestMethod.POST)
	@PreAuthorize("hasRole('SOCIO')")  
	public @ResponseBody String saveSocio(
			@ModelAttribute("command") SocioBean socioBean) {

		Socio socio = prepareModel(socioBean);
		socioService.addSocio(socio);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un socio.
	 * @param socioBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editSocio", method = RequestMethod.POST)
	@PreAuthorize("hasRole('SOCIO')")  
	public @ResponseBody String editSocio(
			@ModelAttribute("command") SocioBean socioBean) {


		Socio socio = prepareModel(socioBean);
		socioService.editSocio(socio);
		return "SUCCESS";
	}

	/**
	 * Agrega un SOCIO.
	 * @param SOCIOBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchSocio", method = RequestMethod.GET)
	@PreAuthorize("hasRole('SOCIO')")  
	public ModelAndView addSocio(
			@ModelAttribute("command") SocioBean socioBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Socio socio = null;
		if (socioBean != null)
			socio = prepareModel(socioBean);
		model.put("socios",
				prepareListofBean(socioService.listSocios(socio)));
		return new ModelAndView("searchSocio", model);
	}

	/**
	 * Elimina un socio.
	 * @param socioBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteSocio", method = RequestMethod.POST)
	@PreAuthorize("hasRole('SOCIO')")  
	public ModelAndView deleteSocio(
			@ModelAttribute("command") SocioBean socioBean,
			BindingResult result) {
		System.out.println("delete " + socioBean.getSocioId());
		socioService.deleteSocio(prepareModel(socioBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("socio", null);
		model.put("socios",
				prepareListofBean(socioService.listSocios(null)));
		return new ModelAndView("searchSocio", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entrySocio", method = RequestMethod.GET)
	@PreAuthorize("hasRole('SOCIO')")  
	public ModelAndView entrySocio() {
		return new ModelAndView("redirect:/searchSocio");
	}

	private Socio prepareModel(SocioBean socioBean) {
		Socio socio = new Socio();

		//socio.setHIntegerId(socioBean.getNumeroId());
		//socio.setRadiogeneroId(socioBean.getEsId());
		//socio.setNotrequiredsocioId(socioBean.getCorreoId());
		//socio.setNotrequiredsocioId(socioBean.getTelefonoId());
		//socio.setRadiotipoempleadoId(socioBean.getTipoId());
		//socio.setPerteneceId(socioBean.getPerteneceId());
		//socio.setLaboraId(socioBean.getLaboraId());
		//socio.setDisplayresultsocioId(socioBean.getSocioId());
		//socio.setExposedfiltersocioId(socioBean.getSocioId());
		//socio.setDisplaymodalsocioId(socioBean.getSocioId());
		//socio.setEntitynamesocioId(socioBean.getSocioId());
		//socio.setScaffoldsocioId(socioBean.getSocioId());
		socio.setNombre(socioBean.getNombre());
		socio.setApellidopaterno(socioBean.getApellidopaterno());
		socio.setApellidomaterno(socioBean.getApellidomaterno());
		socio.setSocioId(socioBean.getSocioId());
		socioBean.setSocioId(null);

		return socio;
	}

	/**
	 * Convierte un objeto de tipo SocioBean a un objeto de tipo Socio.
	 * @param socioBean.
	 * @return Socio.
	 */
	private List<SocioBean> prepareListofBean(List<Socio> socios) {
		List<SocioBean> beans = null;
		if (socios != null && !socios.isEmpty()) {
			beans = new ArrayList<SocioBean>();
			SocioBean bean = null;
			for (Socio socio : socios) {
				bean = new SocioBean();

				//bean.setRadiogeneroId(socio.getEsId());
				//bean.setNotrequiredsocioId(socio.getCorreoId());
				//bean.setNotrequiredsocioId(socio.getTelefonoId());
				//bean.setRadiotipoempleadoId(socio.getTipoId());
				//bean.setPerteneceId(socio.getPerteneceId());
				//bean.setLaboraId(socio.getLaboraId());
				//bean.setDisplayresultsocioId(socio.getSocioId());
				//bean.setExposedfiltersocioId(socio.getSocioId());
				//bean.setDisplaymodalsocioId(socio.getSocioId());
				//bean.setEntitynamesocioId(socio.getSocioId());
				//bean.setScaffoldsocioId(socio.getSocioId());
				bean.setNombre(socio.getNombre());
				bean.setApellidopaterno(socio.getApellidopaterno());
				bean.setApellidomaterno(socio.getApellidomaterno());
				bean.setSocioId(socio.getSocioId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


