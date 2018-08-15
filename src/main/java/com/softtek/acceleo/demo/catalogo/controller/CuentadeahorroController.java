/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Cuentadeahorros. 
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

import com.softtek.acceleo.demo.catalogo.bean.CuentadeahorroBean;
import com.softtek.acceleo.demo.domain.Cuentadeahorro;
import com.softtek.acceleo.demo.service.CuentadeahorroService;

/**
 * Clase CuentadeahorroController.
 * @author PSG.
 *
 */
@RestController
public class CuentadeahorroController {

	@Autowired
	private CuentadeahorroService cuentadeahorroService;
	
	Cuentadeahorro cuentadeahorro = new Cuentadeahorro();

	/************************************** SEARCH
	 * Obtiene informacion de los cuentadeahorros.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Cuentadeahorro>.
	 */
	@RequestMapping(value = "/cuentadeahorro", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('CUENTADEAHORROSEARCH')")
	public @ResponseBody  List<Cuentadeahorro> getCuentadeahorros(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Cuentadeahorro> listCuentadeahorro = null;

		if (query==null && _page == 0) {
       		listCuentadeahorro = cuentadeahorroService.listCuentadeahorros(cuentadeahorro);
			rows = cuentadeahorroService.getTotalRows();
		} else if (query!= null){
			listCuentadeahorro = cuentadeahorroService.listCuentadeahorrosQuery(cuentadeahorro, query, _page, 10);
			rows = cuentadeahorroService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listCuentadeahorro = cuentadeahorroService.listCuentadeahorrosPagination(cuentadeahorro, _page, 10);
			rows = cuentadeahorroService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listCuentadeahorro;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un cuentadeahorro.
	 * @param id.
	 * @return Cuentadeahorro.
	 */
	@RequestMapping(value = "/idcuentadeahorro/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('CUENTADEAHORROSEARCH')")
	    public @ResponseBody  Cuentadeahorro getCuentadeahorro(@PathVariable("id") int id) {	        
	        Cuentadeahorro cuentadeahorro = null;
	        
	        cuentadeahorro = cuentadeahorroService.getCuentadeahorro(id);
			return cuentadeahorro;
	 }

	/*************************** CREATE
	 * Crea un nuevo cuentadeahorro.
	 * @param cuentadeahorro.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/cuentadeahorro", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('CUENTADEAHORROCREATE')")
	    public ResponseEntity<Void> createCuentadeahorro(@RequestBody Cuentadeahorro cuentadeahorro,    UriComponentsBuilder ucBuilder) {
	   
	        cuentadeahorroService.addCuentadeahorro(cuentadeahorro);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/cuentadeahorro/{id}").buildAndExpand(cuentadeahorro.getCuentadeahorroId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un cuentadeahorro.
	  * @param id.
	  * @param cuentadeahorro.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/cuentadeahorro/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('CUENTADEAHORROUPDATE')") 
	    public ResponseEntity<Cuentadeahorro> actualizarCuentadeahorro(
				@PathVariable("id") int id, 
				@RequestBody Cuentadeahorro cuentadeahorro) {
	        
	        Cuentadeahorro cuentadeahorroFound = cuentadeahorroService.getCuentadeahorro(id);
	         
	        if (cuentadeahorroFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Cuentadeahorro>(HttpStatus.NOT_FOUND);
	        }
	
	cuentadeahorroFound.setNumero(cuentadeahorro.getNumero());
	cuentadeahorroFound.setFechadisponibilidad(cuentadeahorro.getFechadisponibilidad());
	cuentadeahorroFound.setFechavencimiento(cuentadeahorro.getFechavencimiento());
	cuentadeahorroFound.setFechacontratacion(cuentadeahorro.getFechacontratacion());
	cuentadeahorroFound.setSocioId(cuentadeahorro.getSocioId());
	cuentadeahorroFound.setTipoahorroId(cuentadeahorro.getTipoahorroId());
	cuentadeahorroFound.setCuentadeahorroId(cuentadeahorro.getCuentadeahorroId());

		    cuentadeahorroService.editCuentadeahorro(cuentadeahorroFound);
	        return new ResponseEntity<Cuentadeahorro>(cuentadeahorroFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un cuentadeahorro.
		 * @param id.
		 * @return ResponseEntity<Cuentadeahorro>.
		 */
		@RequestMapping(value = "/cuentadeahorro/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('CUENTADEAHORRODELETE')")  
	    public ResponseEntity<Cuentadeahorro> deleteCuentadeahorro(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Cuentadeahorro cuentadeahorro = cuentadeahorroService.getCuentadeahorro(id);
	         if (cuentadeahorro == null) {
	             return new ResponseEntity<Cuentadeahorro>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             cuentadeahorroService.deleteCuentadeahorro(cuentadeahorro);
	             return new ResponseEntity<Cuentadeahorro>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Cuentadeahorro no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Cuentadeahorro>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Cuentadeahorro>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un cuentadeahorro.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveCuentadeahorro", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CUENTADEAHORRO')")  
	public @ResponseBody String saveCuentadeahorro(
			@ModelAttribute("command") CuentadeahorroBean cuentadeahorroBean) {

		Cuentadeahorro cuentadeahorro = prepareModel(cuentadeahorroBean);
		cuentadeahorroService.addCuentadeahorro(cuentadeahorro);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un cuentadeahorro.
	 * @param cuentadeahorroBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editCuentadeahorro", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CUENTADEAHORRO')")  
	public @ResponseBody String editCuentadeahorro(
			@ModelAttribute("command") CuentadeahorroBean cuentadeahorroBean) {


		Cuentadeahorro cuentadeahorro = prepareModel(cuentadeahorroBean);
		cuentadeahorroService.editCuentadeahorro(cuentadeahorro);
		return "SUCCESS";
	}

	/**
	 * Agrega un CUENTADEAHORRO.
	 * @param CUENTADEAHORROBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchCuentadeahorro", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CUENTADEAHORRO')")  
	public ModelAndView addCuentadeahorro(
			@ModelAttribute("command") CuentadeahorroBean cuentadeahorroBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Cuentadeahorro cuentadeahorro = null;
		if (cuentadeahorroBean != null)
			cuentadeahorro = prepareModel(cuentadeahorroBean);
		model.put("cuentadeahorros",
				prepareListofBean(cuentadeahorroService.listCuentadeahorros(cuentadeahorro)));
		return new ModelAndView("searchCuentadeahorro", model);
	}

	/**
	 * Elimina un cuentadeahorro.
	 * @param cuentadeahorroBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteCuentadeahorro", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CUENTADEAHORRO')")  
	public ModelAndView deleteCuentadeahorro(
			@ModelAttribute("command") CuentadeahorroBean cuentadeahorroBean,
			BindingResult result) {
		System.out.println("delete " + cuentadeahorroBean.getCuentadeahorroId());
		cuentadeahorroService.deleteCuentadeahorro(prepareModel(cuentadeahorroBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cuentadeahorro", null);
		model.put("cuentadeahorros",
				prepareListofBean(cuentadeahorroService.listCuentadeahorros(null)));
		return new ModelAndView("searchCuentadeahorro", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryCuentadeahorro", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CUENTADEAHORRO')")  
	public ModelAndView entryCuentadeahorro() {
		return new ModelAndView("redirect:/searchCuentadeahorro");
	}

	private Cuentadeahorro prepareModel(CuentadeahorroBean cuentadeahorroBean) {
		Cuentadeahorro cuentadeahorro = new Cuentadeahorro();

		//cuentadeahorro.setDeId(cuentadeahorroBean.getDeId());
		//cuentadeahorro.setHIntegerId(cuentadeahorroBean.getNumeroId());
		//cuentadeahorro.setRadiotipoahorroId(cuentadeahorroBean.getTipoId());
		//cuentadeahorro.setHDateId(cuentadeahorroBean.getFechacontratacionId());
		//cuentadeahorro.setHDateId(cuentadeahorroBean.getFechavencimientoId());
		//cuentadeahorro.setHDateId(cuentadeahorroBean.getFechadisponibilidadId());
		//cuentadeahorro.setDisplayresultcuentadeahorroId(cuentadeahorroBean.getCuentadeahorroId());
		//cuentadeahorro.setExposedfiltercuentadeahorroId(cuentadeahorroBean.getCuentadeahorroId());
		//cuentadeahorro.setDisplaymodalcuentadeahorroId(cuentadeahorroBean.getCuentadeahorroId());
		//cuentadeahorro.setEntitynamecuentadeahorroId(cuentadeahorroBean.getCuentadeahorroId());
		//cuentadeahorro.setScaffoldcuentadeahorroId(cuentadeahorroBean.getCuentadeahorroId());
		cuentadeahorro.setCuentadeahorroId(cuentadeahorroBean.getCuentadeahorroId());
		cuentadeahorroBean.setCuentadeahorroId(null);

		return cuentadeahorro;
	}

	/**
	 * Convierte un objeto de tipo CuentadeahorroBean a un objeto de tipo Cuentadeahorro.
	 * @param cuentadeahorroBean.
	 * @return Cuentadeahorro.
	 */
	private List<CuentadeahorroBean> prepareListofBean(List<Cuentadeahorro> cuentadeahorros) {
		List<CuentadeahorroBean> beans = null;
		if (cuentadeahorros != null && !cuentadeahorros.isEmpty()) {
			beans = new ArrayList<CuentadeahorroBean>();
			CuentadeahorroBean bean = null;
			for (Cuentadeahorro cuentadeahorro : cuentadeahorros) {
				bean = new CuentadeahorroBean();

				//bean.setDeId(cuentadeahorro.getDeId());
				//bean.setRadiotipoahorroId(cuentadeahorro.getTipoId());
				//bean.setDisplayresultcuentadeahorroId(cuentadeahorro.getCuentadeahorroId());
				//bean.setExposedfiltercuentadeahorroId(cuentadeahorro.getCuentadeahorroId());
				//bean.setDisplaymodalcuentadeahorroId(cuentadeahorro.getCuentadeahorroId());
				//bean.setEntitynamecuentadeahorroId(cuentadeahorro.getCuentadeahorroId());
				//bean.setScaffoldcuentadeahorroId(cuentadeahorro.getCuentadeahorroId());
				bean.setCuentadeahorroId(cuentadeahorro.getCuentadeahorroId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


