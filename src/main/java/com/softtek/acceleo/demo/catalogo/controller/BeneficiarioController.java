/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Beneficiarios. 
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

import com.softtek.acceleo.demo.catalogo.bean.BeneficiarioBean;
import com.softtek.acceleo.demo.domain.Beneficiario;
import com.softtek.acceleo.demo.service.BeneficiarioService;

/**
 * Clase BeneficiarioController.
 * @author PSG.
 *
 */
@RestController
public class BeneficiarioController {

	@Autowired
	private BeneficiarioService beneficiarioService;
	
	Beneficiario beneficiario = new Beneficiario();

	/************************************** SEARCH
	 * Obtiene informacion de los beneficiarios.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Beneficiario>.
	 */
	@RequestMapping(value = "/beneficiario", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('BENEFICIARIOSEARCH')")
	public @ResponseBody  List<Beneficiario> getBeneficiarios(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Beneficiario> listBeneficiario = null;

		if (query==null && _page == 0) {
       		listBeneficiario = beneficiarioService.listBeneficiarios(beneficiario);
			rows = beneficiarioService.getTotalRows();
		} else if (query!= null){
			listBeneficiario = beneficiarioService.listBeneficiariosQuery(beneficiario, query, _page, 10);
			rows = beneficiarioService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listBeneficiario = beneficiarioService.listBeneficiariosPagination(beneficiario, _page, 10);
			rows = beneficiarioService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listBeneficiario;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un beneficiario.
	 * @param id.
	 * @return Beneficiario.
	 */
	@RequestMapping(value = "/idbeneficiario/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('BENEFICIARIOSEARCH')")
	    public @ResponseBody  Beneficiario getBeneficiario(@PathVariable("id") int id) {	        
	        Beneficiario beneficiario = null;
	        
	        beneficiario = beneficiarioService.getBeneficiario(id);
			return beneficiario;
	 }

	/*************************** CREATE
	 * Crea un nuevo beneficiario.
	 * @param beneficiario.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/beneficiario", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('BENEFICIARIOCREATE')")
	    public ResponseEntity<Void> createBeneficiario(@RequestBody Beneficiario beneficiario,    UriComponentsBuilder ucBuilder) {
	   
	        beneficiarioService.addBeneficiario(beneficiario);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/beneficiario/{id}").buildAndExpand(beneficiario.getBeneficiarioId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un beneficiario.
	  * @param id.
	  * @param beneficiario.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/beneficiario/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('BENEFICIARIOUPDATE')") 
	    public ResponseEntity<Beneficiario> actualizarBeneficiario(
				@PathVariable("id") int id, 
				@RequestBody Beneficiario beneficiario) {
	        
	        Beneficiario beneficiarioFound = beneficiarioService.getBeneficiario(id);
	         
	        if (beneficiarioFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Beneficiario>(HttpStatus.NOT_FOUND);
	        }
	
	beneficiarioFound.setApellido_paterno(beneficiario.getApellido_paterno());
	beneficiarioFound.setApellido_materno(beneficiario.getApellido_materno());
	beneficiarioFound.setCurp(beneficiario.getCurp());
	beneficiarioFound.setFecha_nacimiento(beneficiario.getFecha_nacimiento());
	beneficiarioFound.setNombre(beneficiario.getNombre());
	beneficiarioFound.setParentescoId(beneficiario.getParentescoId());
	beneficiarioFound.setAfiliadoId(beneficiario.getAfiliadoId());
	beneficiarioFound.setBeneficiarioId(beneficiario.getBeneficiarioId());

		    beneficiarioService.editBeneficiario(beneficiarioFound);
	        return new ResponseEntity<Beneficiario>(beneficiarioFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un beneficiario.
		 * @param id.
		 * @return ResponseEntity<Beneficiario>.
		 */
		@RequestMapping(value = "/beneficiario/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('BENEFICIARIODELETE')")  
	    public ResponseEntity<Beneficiario> deleteBeneficiario(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Beneficiario beneficiario = beneficiarioService.getBeneficiario(id);
	         if (beneficiario == null) {
	             return new ResponseEntity<Beneficiario>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             beneficiarioService.deleteBeneficiario(beneficiario);
	             return new ResponseEntity<Beneficiario>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Beneficiario no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Beneficiario>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Beneficiario>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un beneficiario.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveBeneficiario", method = RequestMethod.POST)
	@PreAuthorize("hasRole('BENEFICIARIO')")  
	public @ResponseBody String saveBeneficiario(
			@ModelAttribute("command") BeneficiarioBean beneficiarioBean) {

		Beneficiario beneficiario = prepareModel(beneficiarioBean);
		beneficiarioService.addBeneficiario(beneficiario);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un beneficiario.
	 * @param beneficiarioBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editBeneficiario", method = RequestMethod.POST)
	@PreAuthorize("hasRole('BENEFICIARIO')")  
	public @ResponseBody String editBeneficiario(
			@ModelAttribute("command") BeneficiarioBean beneficiarioBean) {


		Beneficiario beneficiario = prepareModel(beneficiarioBean);
		beneficiarioService.editBeneficiario(beneficiario);
		return "SUCCESS";
	}

	/**
	 * Agrega un BENEFICIARIO.
	 * @param BENEFICIARIOBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchBeneficiario", method = RequestMethod.GET)
	@PreAuthorize("hasRole('BENEFICIARIO')")  
	public ModelAndView addBeneficiario(
			@ModelAttribute("command") BeneficiarioBean beneficiarioBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Beneficiario beneficiario = null;
		if (beneficiarioBean != null)
			beneficiario = prepareModel(beneficiarioBean);
		model.put("beneficiarios",
				prepareListofBean(beneficiarioService.listBeneficiarios(beneficiario)));
		return new ModelAndView("searchBeneficiario", model);
	}

	/**
	 * Elimina un beneficiario.
	 * @param beneficiarioBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteBeneficiario", method = RequestMethod.POST)
	@PreAuthorize("hasRole('BENEFICIARIO')")  
	public ModelAndView deleteBeneficiario(
			@ModelAttribute("command") BeneficiarioBean beneficiarioBean,
			BindingResult result) {
		System.out.println("delete " + beneficiarioBean.getBeneficiarioId());
		beneficiarioService.deleteBeneficiario(prepareModel(beneficiarioBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("beneficiario", null);
		model.put("beneficiarios",
				prepareListofBean(beneficiarioService.listBeneficiarios(null)));
		return new ModelAndView("searchBeneficiario", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryBeneficiario", method = RequestMethod.GET)
	@PreAuthorize("hasRole('BENEFICIARIO')")  
	public ModelAndView entryBeneficiario() {
		return new ModelAndView("redirect:/searchBeneficiario");
	}

	private Beneficiario prepareModel(BeneficiarioBean beneficiarioBean) {
		Beneficiario beneficiario = new Beneficiario();

		//beneficiario.setHDateId(beneficiarioBean.getFecha_nacimientoId());
		//beneficiario.setRadioparentescoId(beneficiarioBean.getParentescoId());
		//beneficiario.setAfiliadoId(beneficiarioBean.getAfiliadoId());
		//beneficiario.setDisplayresultbeneficiarioId(beneficiarioBean.getBeneficiarioId());
		//beneficiario.setExposedfilterbeneficiarioId(beneficiarioBean.getBeneficiarioId());
		//beneficiario.setDisplaymodalbeneficiarioId(beneficiarioBean.getBeneficiarioId());
		//beneficiario.setEntitynamebeneficiarioId(beneficiarioBean.getBeneficiarioId());
		beneficiario.setCurp(beneficiarioBean.getCurp());
		beneficiario.setNombre(beneficiarioBean.getNombre());
		beneficiario.setApellido_paterno(beneficiarioBean.getApellido_paterno());
		beneficiario.setApellido_materno(beneficiarioBean.getApellido_materno());
		beneficiario.setBeneficiarioId(beneficiarioBean.getBeneficiarioId());
		beneficiarioBean.setBeneficiarioId(null);

		return beneficiario;
	}

	/**
	 * Convierte un objeto de tipo BeneficiarioBean a un objeto de tipo Beneficiario.
	 * @param beneficiarioBean.
	 * @return Beneficiario.
	 */
	private List<BeneficiarioBean> prepareListofBean(List<Beneficiario> beneficiarios) {
		List<BeneficiarioBean> beans = null;
		if (beneficiarios != null && !beneficiarios.isEmpty()) {
			beans = new ArrayList<BeneficiarioBean>();
			BeneficiarioBean bean = null;
			for (Beneficiario beneficiario : beneficiarios) {
				bean = new BeneficiarioBean();

				//bean.setRadioparentescoId(beneficiario.getParentescoId());
				//bean.setAfiliadoId(beneficiario.getAfiliadoId());
				//bean.setDisplayresultbeneficiarioId(beneficiario.getBeneficiarioId());
				//bean.setExposedfilterbeneficiarioId(beneficiario.getBeneficiarioId());
				//bean.setDisplaymodalbeneficiarioId(beneficiario.getBeneficiarioId());
				//bean.setEntitynamebeneficiarioId(beneficiario.getBeneficiarioId());
				bean.setCurp(beneficiario.getCurp());
				bean.setNombre(beneficiario.getNombre());
				bean.setApellido_paterno(beneficiario.getApellido_paterno());
				bean.setApellido_materno(beneficiario.getApellido_materno());
				bean.setBeneficiarioId(beneficiario.getBeneficiarioId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


