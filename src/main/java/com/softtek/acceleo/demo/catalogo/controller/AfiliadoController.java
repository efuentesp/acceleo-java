/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Afiliados. 
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

import com.softtek.acceleo.demo.catalogo.bean.AfiliadoBean;
import com.softtek.acceleo.demo.domain.Afiliado;
import com.softtek.acceleo.demo.service.AfiliadoService;

/**
 * Clase AfiliadoController.
 * @author PSG.
 *
 */
@RestController
public class AfiliadoController {

	@Autowired
	private AfiliadoService afiliadoService;
	
	Afiliado afiliado = new Afiliado();

	/************************************** SEARCH
	 * Obtiene informacion de los afiliados.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Afiliado>.
	 */
	@RequestMapping(value = "/afiliado", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('AFILIADOSEARCH')")
	public @ResponseBody  List<Afiliado> getAfiliados(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Afiliado> listAfiliado = null;

		if (query==null && _page == 0) {
       		listAfiliado = afiliadoService.listAfiliados(afiliado);
			rows = afiliadoService.getTotalRows();
		} else if (query!= null){
			listAfiliado = afiliadoService.listAfiliadosQuery(afiliado, query, _page, 10);
			rows = afiliadoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listAfiliado = afiliadoService.listAfiliadosPagination(afiliado, _page, 10);
			rows = afiliadoService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listAfiliado;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un afiliado.
	 * @param id.
	 * @return Afiliado.
	 */
	@RequestMapping(value = "/idafiliado/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('AFILIADOSEARCH')")
	    public @ResponseBody  Afiliado getAfiliado(@PathVariable("id") int id) {	        
	        Afiliado afiliado = null;
	        
	        afiliado = afiliadoService.getAfiliado(id);
			return afiliado;
	 }

	/*************************** CREATE
	 * Crea un nuevo afiliado.
	 * @param afiliado.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/afiliado", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('AFILIADOCREATE')")
	    public ResponseEntity<Void> createAfiliado(@RequestBody Afiliado afiliado,    UriComponentsBuilder ucBuilder) {
	   
	        afiliadoService.addAfiliado(afiliado);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/afiliado/{id}").buildAndExpand(afiliado.getAfiliadoId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un afiliado.
	  * @param id.
	  * @param afiliado.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/afiliado/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('AFILIADOUPDATE')") 
	    public ResponseEntity<Afiliado> actualizarAfiliado(
				@PathVariable("id") int id, 
				@RequestBody Afiliado afiliado) {
	        
	        Afiliado afiliadoFound = afiliadoService.getAfiliado(id);
	         
	        if (afiliadoFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Afiliado>(HttpStatus.NOT_FOUND);
	        }
	
	afiliadoFound.setNss(afiliado.getNss());
	afiliadoFound.setNombre(afiliado.getNombre());
	afiliadoFound.setActa_nacimiento(afiliado.getActa_nacimiento());
	afiliadoFound.setNumero(afiliado.getNumero());
	afiliadoFound.setSemanas_cotizadas(afiliado.getSemanas_cotizadas());
	afiliadoFound.setCorreo(afiliado.getCorreo());
	afiliadoFound.setFoto(afiliado.getFoto());
	afiliadoFound.setApellido_materno(afiliado.getApellido_materno());
	afiliadoFound.setApellido_paterno(afiliado.getApellido_paterno());
	afiliadoFound.setFecha_afiliacion(afiliado.getFecha_afiliacion());
	afiliadoFound.setObservaciones(afiliado.getObservaciones());
	afiliadoFound.setGenero1Id(afiliado.getGenero1Id());
	afiliadoFound.setBeneficiario1Id(afiliado.getBeneficiario1Id());
	afiliadoFound.setAfiliadoId(afiliado.getAfiliadoId());

		    afiliadoService.editAfiliado(afiliadoFound);
	        return new ResponseEntity<Afiliado>(afiliadoFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un afiliado.
		 * @param id.
		 * @return ResponseEntity<Afiliado>.
		 */
		@RequestMapping(value = "/afiliado/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('AFILIADODELETE')")  
	    public ResponseEntity<Afiliado> deleteAfiliado(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Afiliado afiliado = afiliadoService.getAfiliado(id);
	         if (afiliado == null) {
	             return new ResponseEntity<Afiliado>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             afiliadoService.deleteAfiliado(afiliado);
	             return new ResponseEntity<Afiliado>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Afiliado no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Afiliado>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Afiliado>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un afiliado.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveAfiliado", method = RequestMethod.POST)
	@PreAuthorize("hasRole('AFILIADO')")  
	public @ResponseBody String saveAfiliado(
			@ModelAttribute("command") AfiliadoBean afiliadoBean) {

		Afiliado afiliado = prepareModel(afiliadoBean);
		afiliadoService.addAfiliado(afiliado);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un afiliado.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editAfiliado", method = RequestMethod.POST)
	@PreAuthorize("hasRole('AFILIADO')")  
	public @ResponseBody String editAfiliado(
			@ModelAttribute("command") AfiliadoBean afiliadoBean) {


		Afiliado afiliado = prepareModel(afiliadoBean);
		afiliadoService.editAfiliado(afiliado);
		return "SUCCESS";
	}

	/**
	 * Agrega un AFILIADO.
	 * @param AFILIADOBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchAfiliado", method = RequestMethod.GET)
	@PreAuthorize("hasRole('AFILIADO')")  
	public ModelAndView addAfiliado(
			@ModelAttribute("command") AfiliadoBean afiliadoBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Afiliado afiliado = null;
		if (afiliadoBean != null)
			afiliado = prepareModel(afiliadoBean);
		model.put("afiliados",
				prepareListofBean(afiliadoService.listAfiliados(afiliado)));
		return new ModelAndView("searchAfiliado", model);
	}

	/**
	 * Elimina un afiliado.
	 * @param afiliadoBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteAfiliado", method = RequestMethod.POST)
	@PreAuthorize("hasRole('AFILIADO')")  
	public ModelAndView deleteAfiliado(
			@ModelAttribute("command") AfiliadoBean afiliadoBean,
			BindingResult result) {
		System.out.println("delete " + afiliadoBean.getAfiliadoId());
		afiliadoService.deleteAfiliado(prepareModel(afiliadoBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("afiliado", null);
		model.put("afiliados",
				prepareListofBean(afiliadoService.listAfiliados(null)));
		return new ModelAndView("searchAfiliado", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryAfiliado", method = RequestMethod.GET)
	@PreAuthorize("hasRole('AFILIADO')")  
	public ModelAndView entryAfiliado() {
		return new ModelAndView("redirect:/searchAfiliado");
	}

	private Afiliado prepareModel(AfiliadoBean afiliadoBean) {
		Afiliado afiliado = new Afiliado();

		//afiliado.setRadiogeneroId(afiliadoBean.getGeneroId());
		//afiliado.setBeneficiariosId(afiliadoBean.getBeneficiariosId());
		//afiliado.setHTextLongId(afiliadoBean.getObservacionesId());
		//afiliado.setHDateId(afiliadoBean.getFecha_afiliacionId());
		//afiliado.setHImageId(afiliadoBean.getFotoId());
		//afiliado.setHFileId(afiliadoBean.getActa_nacimientoId());
		//afiliado.setHEmailId(afiliadoBean.getCorreoId());
		//afiliado.setHIntegerId(afiliadoBean.getSemanas_cotizadasId());
		//afiliado.setHDoubleId(afiliadoBean.getNumeroId());
		//afiliado.setDireccioncorreoId(afiliadoBean.getDireccioncorreoId());
		//afiliado.setDomicilioId(afiliadoBean.getDomicilioId());
		//afiliado.setDisplayresultafiliadoId(afiliadoBean.getAfiliadoId());
		//afiliado.setExposedfilterafiliadoId(afiliadoBean.getAfiliadoId());
		//afiliado.setDisplaymodalafiliadoId(afiliadoBean.getAfiliadoId());
		//afiliado.setEntitynameafiliadoId(afiliadoBean.getAfiliadoId());
		afiliado.setNss(afiliadoBean.getNss());
		afiliado.setNombre(afiliadoBean.getNombre());
		afiliado.setApellido_paterno(afiliadoBean.getApellido_paterno());
		afiliado.setApellido_materno(afiliadoBean.getApellido_materno());
		afiliado.setAfiliadoId(afiliadoBean.getAfiliadoId());
		afiliadoBean.setAfiliadoId(null);

		return afiliado;
	}

	/**
	 * Convierte un objeto de tipo AfiliadoBean a un objeto de tipo Afiliado.
	 * @param afiliadoBean.
	 * @return Afiliado.
	 */
	private List<AfiliadoBean> prepareListofBean(List<Afiliado> afiliados) {
		List<AfiliadoBean> beans = null;
		if (afiliados != null && !afiliados.isEmpty()) {
			beans = new ArrayList<AfiliadoBean>();
			AfiliadoBean bean = null;
			for (Afiliado afiliado : afiliados) {
				bean = new AfiliadoBean();

				//bean.setRadiogeneroId(afiliado.getGeneroId());
				//bean.setBeneficiariosId(afiliado.getBeneficiariosId());
				//bean.setDireccioncorreoId(afiliado.getDireccioncorreoId());
				//bean.setDomicilioId(afiliado.getDomicilioId());
				//bean.setDisplayresultafiliadoId(afiliado.getAfiliadoId());
				//bean.setExposedfilterafiliadoId(afiliado.getAfiliadoId());
				//bean.setDisplaymodalafiliadoId(afiliado.getAfiliadoId());
				//bean.setEntitynameafiliadoId(afiliado.getAfiliadoId());
				bean.setNss(afiliado.getNss());
				bean.setNombre(afiliado.getNombre());
				bean.setApellido_paterno(afiliado.getApellido_paterno());
				bean.setApellido_materno(afiliado.getApellido_materno());
				bean.setAfiliadoId(afiliado.getAfiliadoId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


