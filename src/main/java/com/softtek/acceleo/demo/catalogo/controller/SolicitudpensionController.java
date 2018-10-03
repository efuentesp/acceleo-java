/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Solicitudpensions. 
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

import com.softtek.acceleo.demo.catalogo.bean.SolicitudpensionBean;
import com.softtek.acceleo.demo.domain.Solicitudpension;
import com.softtek.acceleo.demo.service.SolicitudpensionService;

/**
 * Clase SolicitudpensionController.
 * @author PSG.
 *
 */
@RestController
public class SolicitudpensionController {

	@Autowired
	private SolicitudpensionService solicitudpensionService;
	
	Solicitudpension solicitudpension = new Solicitudpension();

	/************************************** SEARCH
	 * Obtiene informacion de los solicitudpensions.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Solicitudpension>.
	 */
	@RequestMapping(value = "/solicitudpension", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('SOLICITUDPENSIONSEARCH')")
	public @ResponseBody  List<Solicitudpension> getSolicitudpensions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Solicitudpension> listSolicitudpension = null;

		if (query==null && _page == 0) {
       		listSolicitudpension = solicitudpensionService.listSolicitudpensions(solicitudpension);
			rows = solicitudpensionService.getTotalRows();
		} else if (query!= null){
			listSolicitudpension = solicitudpensionService.listSolicitudpensionsQuery(solicitudpension, query, _page, 10);
			rows = solicitudpensionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listSolicitudpension = solicitudpensionService.listSolicitudpensionsPagination(solicitudpension, _page, 10);
			rows = solicitudpensionService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listSolicitudpension;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un solicitudpension.
	 * @param id.
	 * @return Solicitudpension.
	 */
	@RequestMapping(value = "/idsolicitudpension/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('SOLICITUDPENSIONSEARCH')")
	    public @ResponseBody  Solicitudpension getSolicitudpension(@PathVariable("id") int id) {	        
	        Solicitudpension solicitudpension = null;
	        
	        solicitudpension = solicitudpensionService.getSolicitudpension(id);
			return solicitudpension;
	 }

	/*************************** CREATE
	 * Crea un nuevo solicitudpension.
	 * @param solicitudpension.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/solicitudpension", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('SOLICITUDPENSIONCREATE')")
	    public ResponseEntity<Void> createSolicitudpension(@RequestBody Solicitudpension solicitudpension,    UriComponentsBuilder ucBuilder) {
	   
	        solicitudpensionService.addSolicitudpension(solicitudpension);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/solicitudpension/{id}").buildAndExpand(solicitudpension.getSolicitudpensionId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un solicitudpension.
	  * @param id.
	  * @param solicitudpension.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/solicitudpension/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('SOLICITUDPENSIONUPDATE')") 
	    public ResponseEntity<Solicitudpension> actualizarSolicitudpension(
				@PathVariable("id") int id, 
				@RequestBody Solicitudpension solicitudpension) {
	        
	        Solicitudpension solicitudpensionFound = solicitudpensionService.getSolicitudpension(id);
	         
	        if (solicitudpensionFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Solicitudpension>(HttpStatus.NOT_FOUND);
	        }
	
	solicitudpensionFound.setNumero(solicitudpension.getNumero());
	solicitudpensionFound.setFecha_solicitud(solicitudpension.getFecha_solicitud());
	solicitudpensionFound.setAfiliadoId(solicitudpension.getAfiliadoId());
	solicitudpensionFound.setTipopensionId(solicitudpension.getTipopensionId());
	solicitudpensionFound.setSolicitudpensionId(solicitudpension.getSolicitudpensionId());

		    solicitudpensionService.editSolicitudpension(solicitudpensionFound);
	        return new ResponseEntity<Solicitudpension>(solicitudpensionFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un solicitudpension.
		 * @param id.
		 * @return ResponseEntity<Solicitudpension>.
		 */
		@RequestMapping(value = "/solicitudpension/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('SOLICITUDPENSIONDELETE')")  
	    public ResponseEntity<Solicitudpension> deleteSolicitudpension(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Solicitudpension solicitudpension = solicitudpensionService.getSolicitudpension(id);
	         if (solicitudpension == null) {
	             return new ResponseEntity<Solicitudpension>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             solicitudpensionService.deleteSolicitudpension(solicitudpension);
	             return new ResponseEntity<Solicitudpension>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Solicitudpension no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Solicitudpension>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Solicitudpension>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un solicitudpension.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveSolicitudpension", method = RequestMethod.POST)
	@PreAuthorize("hasRole('SOLICITUDPENSION')")  
	public @ResponseBody String saveSolicitudpension(
			@ModelAttribute("command") SolicitudpensionBean solicitudpensionBean) {

		Solicitudpension solicitudpension = prepareModel(solicitudpensionBean);
		solicitudpensionService.addSolicitudpension(solicitudpension);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un solicitudpension.
	 * @param solicitudpensionBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editSolicitudpension", method = RequestMethod.POST)
	@PreAuthorize("hasRole('SOLICITUDPENSION')")  
	public @ResponseBody String editSolicitudpension(
			@ModelAttribute("command") SolicitudpensionBean solicitudpensionBean) {


		Solicitudpension solicitudpension = prepareModel(solicitudpensionBean);
		solicitudpensionService.editSolicitudpension(solicitudpension);
		return "SUCCESS";
	}

	/**
	 * Agrega un SOLICITUDPENSION.
	 * @param SOLICITUDPENSIONBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchSolicitudpension", method = RequestMethod.GET)
	@PreAuthorize("hasRole('SOLICITUDPENSION')")  
	public ModelAndView addSolicitudpension(
			@ModelAttribute("command") SolicitudpensionBean solicitudpensionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Solicitudpension solicitudpension = null;
		if (solicitudpensionBean != null)
			solicitudpension = prepareModel(solicitudpensionBean);
		model.put("solicitudpensions",
				prepareListofBean(solicitudpensionService.listSolicitudpensions(solicitudpension)));
		return new ModelAndView("searchSolicitudpension", model);
	}

	/**
	 * Elimina un solicitudpension.
	 * @param solicitudpensionBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteSolicitudpension", method = RequestMethod.POST)
	@PreAuthorize("hasRole('SOLICITUDPENSION')")  
	public ModelAndView deleteSolicitudpension(
			@ModelAttribute("command") SolicitudpensionBean solicitudpensionBean,
			BindingResult result) {
		System.out.println("delete " + solicitudpensionBean.getSolicitudpensionId());
		solicitudpensionService.deleteSolicitudpension(prepareModel(solicitudpensionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("solicitudpension", null);
		model.put("solicitudpensions",
				prepareListofBean(solicitudpensionService.listSolicitudpensions(null)));
		return new ModelAndView("searchSolicitudpension", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entrySolicitudpension", method = RequestMethod.GET)
	@PreAuthorize("hasRole('SOLICITUDPENSION')")  
	public ModelAndView entrySolicitudpension() {
		return new ModelAndView("redirect:/searchSolicitudpension");
	}

	private Solicitudpension prepareModel(SolicitudpensionBean solicitudpensionBean) {
		Solicitudpension solicitudpension = new Solicitudpension();

		//solicitudpension.setHIntegerId(solicitudpensionBean.getNumeroId());
		//solicitudpension.setAfiliadoId(solicitudpensionBean.getAfiliadoId());
		//solicitudpension.setTipoId(solicitudpensionBean.getTipoId());
		//solicitudpension.setHDateId(solicitudpensionBean.getFecha_solicitudId());
		//solicitudpension.setNotrequiredsolicitudpensionId(solicitudpensionBean.getObservacionesId());
		//solicitudpension.setDisplayresultsolicitudpensionId(solicitudpensionBean.getSolicitudpensionId());
		//solicitudpension.setExposedfiltersolicitudpensionId(solicitudpensionBean.getSolicitudpensionId());
		//solicitudpension.setDisplaymodalsolicitudpensionId(solicitudpensionBean.getSolicitudpensionId());
		//solicitudpension.setEntitynamesolicitudpensionId(solicitudpensionBean.getSolicitudpensionId());
		solicitudpension.setSolicitudpensionId(solicitudpensionBean.getSolicitudpensionId());
		solicitudpensionBean.setSolicitudpensionId(null);

		return solicitudpension;
	}

	/**
	 * Convierte un objeto de tipo SolicitudpensionBean a un objeto de tipo Solicitudpension.
	 * @param solicitudpensionBean.
	 * @return Solicitudpension.
	 */
	private List<SolicitudpensionBean> prepareListofBean(List<Solicitudpension> solicitudpensions) {
		List<SolicitudpensionBean> beans = null;
		if (solicitudpensions != null && !solicitudpensions.isEmpty()) {
			beans = new ArrayList<SolicitudpensionBean>();
			SolicitudpensionBean bean = null;
			for (Solicitudpension solicitudpension : solicitudpensions) {
				bean = new SolicitudpensionBean();

				//bean.setAfiliadoId(solicitudpension.getAfiliadoId());
				//bean.setTipoId(solicitudpension.getTipoId());
				//bean.setNotrequiredsolicitudpensionId(solicitudpension.getObservacionesId());
				//bean.setDisplayresultsolicitudpensionId(solicitudpension.getSolicitudpensionId());
				//bean.setExposedfiltersolicitudpensionId(solicitudpension.getSolicitudpensionId());
				//bean.setDisplaymodalsolicitudpensionId(solicitudpension.getSolicitudpensionId());
				//bean.setEntitynamesolicitudpensionId(solicitudpension.getSolicitudpensionId());
				bean.setSolicitudpensionId(solicitudpension.getSolicitudpensionId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


