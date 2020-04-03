
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los AportacionInmuebles. 
 */
package com.softtek.acceleo.demo.catalogo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.softtek.acceleo.demo.catalogo.bean.AportacioninmuebleBean;
import com.softtek.acceleo.demo.domain.Aportacioninmueble;

import com.softtek.acceleo.demo.service.AportacioninmuebleService;

/**
 * Clase AportacioninmuebleController.
 * @author PSG.
 *
 */
@RestController
public class AportacioninmuebleController {

	@Autowired
	private AportacioninmuebleService aportacioninmuebleService;
	
	
	Aportacioninmueble aportacioninmueble = new Aportacioninmueble();
	/************************************** CREATE  **************************************
	 * Crea un nuevo aportacioninmueble.
	 * @param aportacioninmueble.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/aportacioninmueble", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_APORTACIONINMUEBLE:CREATE')")
	 public ResponseEntity<Map<String, Object>> createAportacioninmueble(@RequestBody AportacioninmuebleBean aportacioninmuebleBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Aportacioninmueble aportacioninmueble = new Aportacioninmueble();
	   	
	   		
	aportacioninmueble.setDummy(aportacioninmuebleBean.getDummy());
	aportacioninmueble.setDatosfideicomisotiponegocio(aportacioninmuebleBean.getDatosfideicomiso_tiponegocio());
	aportacioninmueble.setDatosfideicomisoproducto(aportacioninmuebleBean.getDatosfideicomiso_producto());
	aportacioninmueble.setIdentificacioninmuebleidinmueble(aportacioninmuebleBean.getIdentificacioninmueble_idinmueble());
	aportacioninmueble.setIdentificacioninmueblefechaalta(aportacioninmuebleBean.getIdentificacioninmueble_fechaalta());
	aportacioninmueble.setIdentificacioninmuebletipoinmueble(aportacioninmuebleBean.getIdentificacioninmueble_tipoinmueble());
	aportacioninmueble.setIdentificacioninmueblearbol(aportacioninmuebleBean.getIdentificacioninmueble_arbol());
	aportacioninmueble.setIdentificacioninmueblefecharegistro(aportacioninmuebleBean.getIdentificacioninmueble_fecharegistro());
	aportacioninmueble.setIdentificacioninmuebletipofraccion(aportacioninmuebleBean.getIdentificacioninmueble_tipofraccion());
	aportacioninmueble.setIdentificacioninmuebledescripcion(aportacioninmuebleBean.getIdentificacioninmueble_descripcion());
	aportacioninmueble.setGeneralesinmueblevalorinicial(aportacioninmuebleBean.getGeneralesinmueble_valorinicial());
	aportacioninmueble.setGeneralesinmuebleubicacion(aportacioninmuebleBean.getGeneralesinmueble_ubicacion());
	aportacioninmueble.setGeneralesinmuebleestado(aportacioninmuebleBean.getGeneralesinmueble_estado());
	aportacioninmueble.setGeneralesinmueblesuperficie(aportacioninmuebleBean.getGeneralesinmueble_superficie());
	aportacioninmueble.setGeneralesinmuebleindivisos(aportacioninmuebleBean.getGeneralesinmueble_indivisos());
	aportacioninmueble.setGeneralesinmuebledias(aportacioninmuebleBean.getGeneralesinmueble_dias());
	aportacioninmueble.setGeneralesinmuebleproyectoejecutivo(aportacioninmuebleBean.getGeneralesinmueble_proyectoejecutivo());
	aportacioninmueble.setGeneralesinmueblevaloractual(aportacioninmuebleBean.getGeneralesinmueble_valoractual());
	aportacioninmueble.setGeneralesinmuebleciudad(aportacioninmuebleBean.getGeneralesinmueble_ciudad());
	aportacioninmueble.setGeneralesinmueblesuperficieconstruida(aportacioninmuebleBean.getGeneralesinmueble_superficieconstruida());
	aportacioninmueble.setGeneralesinmueblefraccionamientounidad(aportacioninmuebleBean.getGeneralesinmueble_fraccionamientounidad());
	aportacioninmueble.setGeneralesinmuebleclavecatastral(aportacioninmuebleBean.getGeneralesinmueble_clavecatastral());
	aportacioninmueble.setGeneralesinmueblevalor(aportacioninmuebleBean.getGeneralesinmueble_valor());
	aportacioninmueble.setGeneralesinmuebleestatus(aportacioninmuebleBean.getGeneralesinmueble_estatus());
	aportacioninmueble.setDatosconstitucionescritura(aportacioninmuebleBean.getDatosconstitucion_escritura());
	aportacioninmueble.setDatosconstitucionnumescritura(aportacioninmuebleBean.getDatosconstitucion_numescritura());
	aportacioninmueble.setDatosconstitucionnombrenotario(aportacioninmuebleBean.getDatosconstitucion_nombrenotario());
	aportacioninmueble.setDatosconstitucionestadonotario(aportacioninmuebleBean.getDatosconstitucion_estadonotario());
	aportacioninmueble.setDatosconstituciontelefononotario(aportacioninmuebleBean.getDatosconstitucion_telefononotario());
	aportacioninmueble.setDatosconstitucionfecharpp(aportacioninmuebleBean.getDatosconstitucion_fecharpp());
	aportacioninmueble.setDatosconstitucionfechaescritura(aportacioninmuebleBean.getDatosconstitucion_fechaescritura());
	aportacioninmueble.setDatosconstitucionnumnotaria(aportacioninmuebleBean.getDatosconstitucion_numnotaria());
	aportacioninmueble.setDatosconstitucionciudadnotario(aportacioninmuebleBean.getDatosconstitucion_ciudadnotario());
	aportacioninmueble.setDatosconstitucionemailnotario(aportacioninmuebleBean.getDatosconstitucion_emailnotario());
	aportacioninmueble.setDatosconstitucionnumrpp(aportacioninmuebleBean.getDatosconstitucion_numrpp());
	   		
	        aportacioninmuebleService.addAportacioninmueble(aportacioninmueble);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> aportacioninmuebleMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(aportacioninmuebleMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "AportacionInmueble no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un aportacioninmueble.
	  * @param id.
	  * @param aportacioninmueble.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/aportacioninmueble/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_APORTACIONINMUEBLE:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarAportacionInmueble(
				@PathVariable("id") String id, 
				@RequestBody AportacioninmuebleBean aportacioninmuebleBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Aportacioninmueble aportacioninmuebleFound = aportacioninmuebleService.getAportacioninmueble(uuid);
	         
	    if (aportacioninmuebleFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   		
	aportacioninmueble.setDummy(aportacioninmuebleBean.getDummy());
	aportacioninmueble.setDatosfideicomisotiponegocio(aportacioninmuebleBean.getDatosfideicomiso_tiponegocio());
	aportacioninmueble.setDatosfideicomisoproducto(aportacioninmuebleBean.getDatosfideicomiso_producto());
	aportacioninmueble.setIdentificacioninmuebleidinmueble(aportacioninmuebleBean.getIdentificacioninmueble_idinmueble());
	aportacioninmueble.setIdentificacioninmueblefechaalta(aportacioninmuebleBean.getIdentificacioninmueble_fechaalta());
	aportacioninmueble.setIdentificacioninmuebletipoinmueble(aportacioninmuebleBean.getIdentificacioninmueble_tipoinmueble());
	aportacioninmueble.setIdentificacioninmueblearbol(aportacioninmuebleBean.getIdentificacioninmueble_arbol());
	aportacioninmueble.setIdentificacioninmueblefecharegistro(aportacioninmuebleBean.getIdentificacioninmueble_fecharegistro());
	aportacioninmueble.setIdentificacioninmuebletipofraccion(aportacioninmuebleBean.getIdentificacioninmueble_tipofraccion());
	aportacioninmueble.setIdentificacioninmuebledescripcion(aportacioninmuebleBean.getIdentificacioninmueble_descripcion());
	aportacioninmueble.setGeneralesinmueblevalorinicial(aportacioninmuebleBean.getGeneralesinmueble_valorinicial());
	aportacioninmueble.setGeneralesinmuebleubicacion(aportacioninmuebleBean.getGeneralesinmueble_ubicacion());
	aportacioninmueble.setGeneralesinmuebleestado(aportacioninmuebleBean.getGeneralesinmueble_estado());
	aportacioninmueble.setGeneralesinmueblesuperficie(aportacioninmuebleBean.getGeneralesinmueble_superficie());
	aportacioninmueble.setGeneralesinmuebleindivisos(aportacioninmuebleBean.getGeneralesinmueble_indivisos());
	aportacioninmueble.setGeneralesinmuebledias(aportacioninmuebleBean.getGeneralesinmueble_dias());
	aportacioninmueble.setGeneralesinmuebleproyectoejecutivo(aportacioninmuebleBean.getGeneralesinmueble_proyectoejecutivo());
	aportacioninmueble.setGeneralesinmueblevaloractual(aportacioninmuebleBean.getGeneralesinmueble_valoractual());
	aportacioninmueble.setGeneralesinmuebleciudad(aportacioninmuebleBean.getGeneralesinmueble_ciudad());
	aportacioninmueble.setGeneralesinmueblesuperficieconstruida(aportacioninmuebleBean.getGeneralesinmueble_superficieconstruida());
	aportacioninmueble.setGeneralesinmueblefraccionamientounidad(aportacioninmuebleBean.getGeneralesinmueble_fraccionamientounidad());
	aportacioninmueble.setGeneralesinmuebleclavecatastral(aportacioninmuebleBean.getGeneralesinmueble_clavecatastral());
	aportacioninmueble.setGeneralesinmueblevalor(aportacioninmuebleBean.getGeneralesinmueble_valor());
	aportacioninmueble.setGeneralesinmuebleestatus(aportacioninmuebleBean.getGeneralesinmueble_estatus());
	aportacioninmueble.setDatosconstitucionescritura(aportacioninmuebleBean.getDatosconstitucion_escritura());
	aportacioninmueble.setDatosconstitucionnumescritura(aportacioninmuebleBean.getDatosconstitucion_numescritura());
	aportacioninmueble.setDatosconstitucionnombrenotario(aportacioninmuebleBean.getDatosconstitucion_nombrenotario());
	aportacioninmueble.setDatosconstitucionestadonotario(aportacioninmuebleBean.getDatosconstitucion_estadonotario());
	aportacioninmueble.setDatosconstituciontelefononotario(aportacioninmuebleBean.getDatosconstitucion_telefononotario());
	aportacioninmueble.setDatosconstitucionfecharpp(aportacioninmuebleBean.getDatosconstitucion_fecharpp());
	aportacioninmueble.setDatosconstitucionfechaescritura(aportacioninmuebleBean.getDatosconstitucion_fechaescritura());
	aportacioninmueble.setDatosconstitucionnumnotaria(aportacioninmuebleBean.getDatosconstitucion_numnotaria());
	aportacioninmueble.setDatosconstitucionciudadnotario(aportacioninmuebleBean.getDatosconstitucion_ciudadnotario());
	aportacioninmueble.setDatosconstitucionemailnotario(aportacioninmuebleBean.getDatosconstitucion_emailnotario());
	aportacioninmueble.setDatosconstitucionnumrpp(aportacioninmuebleBean.getDatosconstitucion_numrpp());
	
		aportacioninmueble.setAportacioninmuebleId(aportacioninmuebleFound.getAportacioninmuebleId());
		aportacioninmuebleService.editAportacioninmueble(aportacioninmueble);
		
		Map<String, Object> aportacioninmuebleMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(aportacioninmuebleMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un aportacioninmueble.
	 * @param id.
	 * @return ResponseEntity<Aportacioninmueble>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/aportacioninmueble/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_APORTACIONINMUEBLE:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteAportacionInmueble(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Aportacioninmueble aportacioninmueble = aportacioninmuebleService.getAportacioninmueble(uuid);
		if (aportacioninmueble == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			aportacioninmuebleService.deleteAportacioninmueble(aportacioninmueble);
			
			Map<String, Object> aportacioninmuebleMAP = new HashMap<>();
			aportacioninmuebleMAP.put("id", aportacioninmueble.getAportacioninmuebleId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(aportacioninmuebleMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Aportacioninmueble no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los aportacioninmuebles.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Aportacioninmueble>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/aportacioninmueble", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_APORTACIONINMUEBLE:READ')")
	public @ResponseBody  List<Map<String, Object>> getAportacionInmuebles(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Aportacioninmueble> listAportacioninmueble = null;
	
		if (query==null && _page == 0) {
			listAportacioninmueble = aportacioninmuebleService.listAportacioninmuebles(aportacioninmueble);
			rows = aportacioninmuebleService.getTotalRows();
		} else if (query!= null){
			listAportacioninmueble = aportacioninmuebleService.listAportacioninmueblesQuery(aportacioninmueble, query, _page, 10);
			rows = aportacioninmuebleService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listAportacioninmueble = aportacioninmuebleService.listAportacioninmueblesPagination(aportacioninmueble, _page, 10);
			rows = aportacioninmuebleService.getTotalRows();
		}
		
		List<Map<String, Object>> listAportacioninmuebleMAP = new ArrayList<>();
		for( Aportacioninmueble aportacioninmueble : listAportacioninmueble ){
			Map<String, Object> aportacioninmuebleMAP = new HashMap<>();
			aportacioninmuebleMAP.put("id", aportacioninmueble.getAportacioninmuebleId());
			aportacioninmuebleMAP.put("dummy", aportacioninmueble.getDummy());
			aportacioninmuebleMAP.put("datosfideicomiso_tiponegocio", aportacioninmueble.getDatosfideicomisotiponegocio());
			aportacioninmuebleMAP.put("datosfideicomiso_producto", aportacioninmueble.getDatosfideicomisoproducto());
			aportacioninmuebleMAP.put("identificacioninmueble_idinmueble", aportacioninmueble.getIdentificacioninmuebleidinmueble());
			aportacioninmuebleMAP.put("identificacioninmueble_fechaalta", aportacioninmueble.getIdentificacioninmueblefechaalta());
			aportacioninmuebleMAP.put("identificacioninmueble_tipoinmueble", aportacioninmueble.getIdentificacioninmuebletipoinmueble());
			aportacioninmuebleMAP.put("identificacioninmueble_arbol", aportacioninmueble.getIdentificacioninmueblearbol());
			aportacioninmuebleMAP.put("identificacioninmueble_fecharegistro", aportacioninmueble.getIdentificacioninmueblefecharegistro());
			aportacioninmuebleMAP.put("identificacioninmueble_tipofraccion", aportacioninmueble.getIdentificacioninmuebletipofraccion());
			aportacioninmuebleMAP.put("identificacioninmueble_descripcion", aportacioninmueble.getIdentificacioninmuebledescripcion());
			aportacioninmuebleMAP.put("generalesinmueble_valorinicial", aportacioninmueble.getGeneralesinmueblevalorinicial());
			aportacioninmuebleMAP.put("generalesinmueble_ubicacion", aportacioninmueble.getGeneralesinmuebleubicacion());
			aportacioninmuebleMAP.put("generalesinmueble_estado", aportacioninmueble.getGeneralesinmuebleestado());
			aportacioninmuebleMAP.put("generalesinmueble_superficie", aportacioninmueble.getGeneralesinmueblesuperficie());
			aportacioninmuebleMAP.put("generalesinmueble_indivisos", aportacioninmueble.getGeneralesinmuebleindivisos());
			aportacioninmuebleMAP.put("generalesinmueble_dias", aportacioninmueble.getGeneralesinmuebledias());
			aportacioninmuebleMAP.put("generalesinmueble_proyectoejecutivo", aportacioninmueble.getGeneralesinmuebleproyectoejecutivo());
			aportacioninmuebleMAP.put("generalesinmueble_valoractual", aportacioninmueble.getGeneralesinmueblevaloractual());
			aportacioninmuebleMAP.put("generalesinmueble_ciudad", aportacioninmueble.getGeneralesinmuebleciudad());
			aportacioninmuebleMAP.put("generalesinmueble_superficieconstruida", aportacioninmueble.getGeneralesinmueblesuperficieconstruida());
			aportacioninmuebleMAP.put("generalesinmueble_fraccionamientounidad", aportacioninmueble.getGeneralesinmueblefraccionamientounidad());
			aportacioninmuebleMAP.put("generalesinmueble_clavecatastral", aportacioninmueble.getGeneralesinmuebleclavecatastral());
			aportacioninmuebleMAP.put("generalesinmueble_valor", aportacioninmueble.getGeneralesinmueblevalor());
			aportacioninmuebleMAP.put("generalesinmueble_estatus", aportacioninmueble.getGeneralesinmuebleestatus());
			aportacioninmuebleMAP.put("datosconstitucion_escritura", aportacioninmueble.getDatosconstitucionescritura());
			aportacioninmuebleMAP.put("datosconstitucion_numescritura", aportacioninmueble.getDatosconstitucionnumescritura());
			aportacioninmuebleMAP.put("datosconstitucion_nombrenotario", aportacioninmueble.getDatosconstitucionnombrenotario());
			aportacioninmuebleMAP.put("datosconstitucion_estadonotario", aportacioninmueble.getDatosconstitucionestadonotario());
			aportacioninmuebleMAP.put("datosconstitucion_telefononotario", aportacioninmueble.getDatosconstituciontelefononotario());
			aportacioninmuebleMAP.put("datosconstitucion_fecharpp", aportacioninmueble.getDatosconstitucionfecharpp());
			aportacioninmuebleMAP.put("datosconstitucion_fechaescritura", aportacioninmueble.getDatosconstitucionfechaescritura());
			aportacioninmuebleMAP.put("datosconstitucion_numnotaria", aportacioninmueble.getDatosconstitucionnumnotaria());
			aportacioninmuebleMAP.put("datosconstitucion_ciudadnotario", aportacioninmueble.getDatosconstitucionciudadnotario());
			aportacioninmuebleMAP.put("datosconstitucion_emailnotario", aportacioninmueble.getDatosconstitucionemailnotario());
			aportacioninmuebleMAP.put("datosconstitucion_numrpp", aportacioninmueble.getDatosconstitucionnumrpp());
			
			listAportacioninmuebleMAP.add(aportacioninmuebleMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listAportacioninmuebleMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un aportacioninmueble.
	 * @param id.
	 * @return Aportacioninmueble.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/aportacioninmueble/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_APORTACIONINMUEBLE:READ')")
	public @ResponseBody  Map<String, Object> getAportacionInmueble(@PathVariable("id") String id) {	        
	        Aportacioninmueble aportacioninmueble = null;
	        
	        UUID uuid = UUID.fromString(id);
	        aportacioninmueble = aportacioninmuebleService.getAportacioninmueble(uuid);
	        
			Map<String, Object> aportacioninmuebleMAP = new HashMap<>();
			aportacioninmuebleMAP.put("id", aportacioninmueble.getAportacioninmuebleId());
			aportacioninmuebleMAP.put("dummy", aportacioninmueble.getDummy());
			aportacioninmuebleMAP.put("datosfideicomiso_tiponegocio", aportacioninmueble.getDatosfideicomisotiponegocio());
			aportacioninmuebleMAP.put("datosfideicomiso_producto", aportacioninmueble.getDatosfideicomisoproducto());
			aportacioninmuebleMAP.put("identificacioninmueble_idinmueble", aportacioninmueble.getIdentificacioninmuebleidinmueble());
			aportacioninmuebleMAP.put("identificacioninmueble_fechaalta", aportacioninmueble.getIdentificacioninmueblefechaalta());
			aportacioninmuebleMAP.put("identificacioninmueble_tipoinmueble", aportacioninmueble.getIdentificacioninmuebletipoinmueble());
			aportacioninmuebleMAP.put("identificacioninmueble_arbol", aportacioninmueble.getIdentificacioninmueblearbol());
			aportacioninmuebleMAP.put("identificacioninmueble_fecharegistro", aportacioninmueble.getIdentificacioninmueblefecharegistro());
			aportacioninmuebleMAP.put("identificacioninmueble_tipofraccion", aportacioninmueble.getIdentificacioninmuebletipofraccion());
			aportacioninmuebleMAP.put("identificacioninmueble_descripcion", aportacioninmueble.getIdentificacioninmuebledescripcion());
			aportacioninmuebleMAP.put("generalesinmueble_valorinicial", aportacioninmueble.getGeneralesinmueblevalorinicial());
			aportacioninmuebleMAP.put("generalesinmueble_ubicacion", aportacioninmueble.getGeneralesinmuebleubicacion());
			aportacioninmuebleMAP.put("generalesinmueble_estado", aportacioninmueble.getGeneralesinmuebleestado());
			aportacioninmuebleMAP.put("generalesinmueble_superficie", aportacioninmueble.getGeneralesinmueblesuperficie());
			aportacioninmuebleMAP.put("generalesinmueble_indivisos", aportacioninmueble.getGeneralesinmuebleindivisos());
			aportacioninmuebleMAP.put("generalesinmueble_dias", aportacioninmueble.getGeneralesinmuebledias());
			aportacioninmuebleMAP.put("generalesinmueble_proyectoejecutivo", aportacioninmueble.getGeneralesinmuebleproyectoejecutivo());
			aportacioninmuebleMAP.put("generalesinmueble_valoractual", aportacioninmueble.getGeneralesinmueblevaloractual());
			aportacioninmuebleMAP.put("generalesinmueble_ciudad", aportacioninmueble.getGeneralesinmuebleciudad());
			aportacioninmuebleMAP.put("generalesinmueble_superficieconstruida", aportacioninmueble.getGeneralesinmueblesuperficieconstruida());
			aportacioninmuebleMAP.put("generalesinmueble_fraccionamientounidad", aportacioninmueble.getGeneralesinmueblefraccionamientounidad());
			aportacioninmuebleMAP.put("generalesinmueble_clavecatastral", aportacioninmueble.getGeneralesinmuebleclavecatastral());
			aportacioninmuebleMAP.put("generalesinmueble_valor", aportacioninmueble.getGeneralesinmueblevalor());
			aportacioninmuebleMAP.put("generalesinmueble_estatus", aportacioninmueble.getGeneralesinmuebleestatus());
			aportacioninmuebleMAP.put("datosconstitucion_escritura", aportacioninmueble.getDatosconstitucionescritura());
			aportacioninmuebleMAP.put("datosconstitucion_numescritura", aportacioninmueble.getDatosconstitucionnumescritura());
			aportacioninmuebleMAP.put("datosconstitucion_nombrenotario", aportacioninmueble.getDatosconstitucionnombrenotario());
			aportacioninmuebleMAP.put("datosconstitucion_estadonotario", aportacioninmueble.getDatosconstitucionestadonotario());
			aportacioninmuebleMAP.put("datosconstitucion_telefononotario", aportacioninmueble.getDatosconstituciontelefononotario());
			aportacioninmuebleMAP.put("datosconstitucion_fecharpp", aportacioninmueble.getDatosconstitucionfecharpp());
			aportacioninmuebleMAP.put("datosconstitucion_fechaescritura", aportacioninmueble.getDatosconstitucionfechaescritura());
			aportacioninmuebleMAP.put("datosconstitucion_numnotaria", aportacioninmueble.getDatosconstitucionnumnotaria());
			aportacioninmuebleMAP.put("datosconstitucion_ciudadnotario", aportacioninmueble.getDatosconstitucionciudadnotario());
			aportacioninmuebleMAP.put("datosconstitucion_emailnotario", aportacioninmueble.getDatosconstitucionemailnotario());
			aportacioninmuebleMAP.put("datosconstitucion_numrpp", aportacioninmueble.getDatosconstitucionnumrpp());
	        
			return aportacioninmuebleMAP;
	 }
	
}
