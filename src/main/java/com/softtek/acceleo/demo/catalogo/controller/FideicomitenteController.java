
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Fideicomitentes. 
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

import com.softtek.acceleo.demo.catalogo.bean.FideicomitenteBean;
import com.softtek.acceleo.demo.domain.Fideicomitente;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.FideicomitenteService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase FideicomitenteController.
 * @author PSG.
 *
 */
@RestController
public class FideicomitenteController {

	@Autowired
	private FideicomitenteService fideicomitenteService;
	
@Autowired
private FideicomisoService fideicomisoService;
	
	Fideicomitente fideicomitente = new Fideicomitente();
	/************************************** CREATE  **************************************
	 * Crea un nuevo fideicomitente.
	 * @param fideicomitente.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/fideicomitente", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_FIDEICOMITENTE:CREATE')")
	 public ResponseEntity<Map<String, Object>> createFideicomitente(@RequestBody FideicomitenteBean fideicomitenteBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Fideicomitente fideicomitente = new Fideicomitente();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(fideicomitenteBean.getFideicomisoId());
	   			fideicomitente.setFideicomisoId(fideicomiso);
	   		
	fideicomitente.setNumerofideicomitente(fideicomitenteBean.getNumerofideicomitente());
	fideicomitente.setTipopersona(fideicomitenteBean.getTipopersona());
	fideicomitente.setParticipante(fideicomitenteBean.getParticipante());
	fideicomitente.setRegimenfiscal(fideicomitenteBean.getRegimenfiscal());
	fideicomitente.setGeneralescontroladorfideicomiso(fideicomitenteBean.getGenerales_controladorfideicomiso());
	fideicomitente.setGeneralesnacionalidad(fideicomitenteBean.getGenerales_nacionalidad());
	fideicomitente.setGeneralespaisorigen(fideicomitenteBean.getGenerales_paisorigen());
	fideicomitente.setGeneralesactividad(fideicomitenteBean.getGenerales_actividad());
	fideicomitente.setGeneralesaportarecursos(fideicomitenteBean.getGenerales_aportarecursos());
	fideicomitente.setGeneralespaisresidencia(fideicomitenteBean.getGenerales_paisresidencia());
	fideicomitente.setGeneralesclientescotiabank(fideicomitenteBean.getGenerales_clientescotiabank());
	fideicomitente.setGeneralespep(fideicomitenteBean.getGenerales_pep());
	fideicomitente.setGeneralesestatus(fideicomitenteBean.getGenerales_estatus());
	fideicomitente.setGeneralesgrupofilial(fideicomitenteBean.getGenerales_grupofilial());
	fideicomitente.setGeneralescalidadmigratoria(fideicomitenteBean.getGenerales_calidadmigratoria());
	fideicomitente.setGeneraleslugaroperacion(fideicomitenteBean.getGenerales_lugaroperacion());
	fideicomitente.setGeneralesoperacuentaterceros(fideicomitenteBean.getGenerales_operacuentaterceros());
	fideicomitente.setGeneralesnivelparticipante(fideicomitenteBean.getGenerales_nivelparticipante());
	fideicomitente.setGeneralesclienterelacionpep(fideicomitenteBean.getGenerales_clienterelacionpep());
	fideicomitente.setGeneralesgrado(fideicomitenteBean.getGenerales_grado());
	fideicomitente.setInformacionpldkychonorarios(fideicomitenteBean.getInformacionpldkyc_honorarios());
	fideicomitente.setInformacionpldkyccomisiones(fideicomitenteBean.getInformacionpldkyc_comisiones());
	fideicomitente.setInformacionpldkycotros(fideicomitenteBean.getInformacionpldkyc_otros());
	fideicomitente.setInformacionpldkycsueldos(fideicomitenteBean.getInformacionpldkyc_sueldos());
	fideicomitente.setInformacionpldkycventa(fideicomitenteBean.getInformacionpldkyc_venta());
	fideicomitente.setInformacionpldkycinversiones(fideicomitenteBean.getInformacionpldkyc_inversiones());
	fideicomitente.setInformacionpldkycarrendamiento(fideicomitenteBean.getInformacionpldkyc_arrendamiento());
	fideicomitente.setInformacionpldkyctipopatrimonio(fideicomitenteBean.getInformacionpldkyc_tipopatrimonio());
	fideicomitente.setInformacionpldkycinstrumento(fideicomitenteBean.getInformacionpldkyc_instrumento());
	fideicomitente.setInformacionpldkycrazonapertura(fideicomitenteBean.getInformacionpldkyc_razonapertura());
	fideicomitente.setInformacionpldkyccomentarios(fideicomitenteBean.getInformacionpldkyc_comentarios());
	fideicomitente.setInformacionpldkycnivelriesgo(fideicomitenteBean.getInformacionpldkyc_nivelriesgo());
	fideicomitente.setInformacionpldkycestatuscalculopld(fideicomitenteBean.getInformacionpldkyc_estatuscalculopld());
	fideicomitente.setInformacionpldkycfechaveriffircosoft(fideicomitenteBean.getInformacionpldkyc_fechaveriffircosoft());
	fideicomitente.setIdentificacionrfc(fideicomitenteBean.getIdentificacion_rfc());
	fideicomitente.setIdentificacioncurp(fideicomitenteBean.getIdentificacion_curp());
	fideicomitente.setIdentificacionnoserieefirma(fideicomitenteBean.getIdentificacion_noserieefirma());
	fideicomitente.setIdentificacioncorreo(fideicomitenteBean.getIdentificacion_correo());
	fideicomitente.setIdentificacionfechaconstitucion(fideicomitenteBean.getIdentificacion_fechaconstitucion());
	fideicomitente.setIdentificacionsexo(fideicomitenteBean.getIdentificacion_sexo());
	fideicomitente.setIdentificacionfechainiciorelneg(fideicomitenteBean.getIdentificacion_fechainiciorelneg());
	fideicomitente.setIdentificacionnoidentificacion(fideicomitenteBean.getIdentificacion_noidentificacion());
	fideicomitente.setIdentificacioncomprobaciondomicilio(fideicomitenteBean.getIdentificacion_comprobaciondomicilio());
	fideicomitente.setIdentificacionactividadempresarial(fideicomitenteBean.getIdentificacion_actividadempresarial());
	fideicomitente.setIdentificacionclasificacionfatca(fideicomitenteBean.getIdentificacion_clasificacionfatca());
	fideicomitente.setIdentificacionidentoficialvig(fideicomitenteBean.getIdentificacion_identoficialvig());
	fideicomitente.setIdentificacionvigencia(fideicomitenteBean.getIdentificacion_vigencia());
	fideicomitente.setIdentificacionresideciafiscalpaisresidfisc1(fideicomitenteBean.getIdentificacion_resideciafiscal_paisresidfisc1());
	fideicomitente.setIdentificacionresideciafiscalidentificacionnoidentfisc1(fideicomitenteBean.getIdentificacion_resideciafiscal_identificacionnoidentfisc1());
	fideicomitente.setIdentificaciontelefonosfideicomitentepaiscasa(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_paiscasa());
	fideicomitente.setIdentificaciontelefonosfideicomitentepaisoficina(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_paisoficina());
	fideicomitente.setIdentificaciontelefonosfideicomitentepaiscelular(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_paiscelular());
	fideicomitente.setIdentificaciontelefonosfideicomitenteladacasa(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_ladacasa());
	fideicomitente.setIdentificaciontelefonosfideicomitenteladaoficina(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_ladaoficina());
	fideicomitente.setIdentificaciontelefonosfideicomitenteladacelular(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_ladacelular());
	fideicomitente.setIdentificaciontelefonosfideicomitentenumerocasa(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_numerocasa());
	fideicomitente.setIdentificaciontelefonosfideicomitentenumerooficina(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_numerooficina());
	fideicomitente.setIdentificaciontelefonosfideicomitentenumerocelular(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_numerocelular());
	fideicomitente.setIdentificaciontelefonosfideicomitenteextoficina(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_extoficina());
	fideicomitente.setIdentificaciontelefonosfideicomitenteextcelular(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_extcelular());
	fideicomitente.setEscrituranoescritura(fideicomitenteBean.getEscritura_noescritura());
	fideicomitente.setEscrituranotario(fideicomitenteBean.getEscritura_notario());
	fideicomitente.setEscrituranonotaria(fideicomitenteBean.getEscritura_nonotaria());
	fideicomitente.setEscrituraciudad(fideicomitenteBean.getEscritura_ciudad());
	fideicomitente.setEscrituraestado(fideicomitenteBean.getEscritura_estado());
	fideicomitente.setEscriturafecha(fideicomitenteBean.getEscritura_fecha());
	fideicomitente.setEscrituratelefono(fideicomitenteBean.getEscritura_telefono());
	fideicomitente.setEscrituracorreo(fideicomitenteBean.getEscritura_correo());
	fideicomitente.set_cuentaskyc(fideicomitenteBean.get_cuentaskyc());
	   		
	        fideicomitenteService.addFideicomitente(fideicomitente);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> fideicomitenteMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(fideicomitenteMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Fideicomitente no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un fideicomitente.
	  * @param id.
	  * @param fideicomitente.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomitente/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_FIDEICOMITENTE:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarFideicomitente(
				@PathVariable("id") String id, 
				@RequestBody FideicomitenteBean fideicomitenteBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Fideicomitente fideicomitenteFound = fideicomitenteService.getFideicomitente(uuid);
	         
	    if (fideicomitenteFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(fideicomitenteBean.getFideicomisoId());
	   			fideicomitente.setFideicomisoId(fideicomiso);
	   		
	fideicomitente.setNumerofideicomitente(fideicomitenteBean.getNumerofideicomitente());
	fideicomitente.setTipopersona(fideicomitenteBean.getTipopersona());
	fideicomitente.setParticipante(fideicomitenteBean.getParticipante());
	fideicomitente.setRegimenfiscal(fideicomitenteBean.getRegimenfiscal());
	fideicomitente.setGeneralescontroladorfideicomiso(fideicomitenteBean.getGenerales_controladorfideicomiso());
	fideicomitente.setGeneralesnacionalidad(fideicomitenteBean.getGenerales_nacionalidad());
	fideicomitente.setGeneralespaisorigen(fideicomitenteBean.getGenerales_paisorigen());
	fideicomitente.setGeneralesactividad(fideicomitenteBean.getGenerales_actividad());
	fideicomitente.setGeneralesaportarecursos(fideicomitenteBean.getGenerales_aportarecursos());
	fideicomitente.setGeneralespaisresidencia(fideicomitenteBean.getGenerales_paisresidencia());
	fideicomitente.setGeneralesclientescotiabank(fideicomitenteBean.getGenerales_clientescotiabank());
	fideicomitente.setGeneralespep(fideicomitenteBean.getGenerales_pep());
	fideicomitente.setGeneralesestatus(fideicomitenteBean.getGenerales_estatus());
	fideicomitente.setGeneralesgrupofilial(fideicomitenteBean.getGenerales_grupofilial());
	fideicomitente.setGeneralescalidadmigratoria(fideicomitenteBean.getGenerales_calidadmigratoria());
	fideicomitente.setGeneraleslugaroperacion(fideicomitenteBean.getGenerales_lugaroperacion());
	fideicomitente.setGeneralesoperacuentaterceros(fideicomitenteBean.getGenerales_operacuentaterceros());
	fideicomitente.setGeneralesnivelparticipante(fideicomitenteBean.getGenerales_nivelparticipante());
	fideicomitente.setGeneralesclienterelacionpep(fideicomitenteBean.getGenerales_clienterelacionpep());
	fideicomitente.setGeneralesgrado(fideicomitenteBean.getGenerales_grado());
	fideicomitente.setInformacionpldkychonorarios(fideicomitenteBean.getInformacionpldkyc_honorarios());
	fideicomitente.setInformacionpldkyccomisiones(fideicomitenteBean.getInformacionpldkyc_comisiones());
	fideicomitente.setInformacionpldkycotros(fideicomitenteBean.getInformacionpldkyc_otros());
	fideicomitente.setInformacionpldkycsueldos(fideicomitenteBean.getInformacionpldkyc_sueldos());
	fideicomitente.setInformacionpldkycventa(fideicomitenteBean.getInformacionpldkyc_venta());
	fideicomitente.setInformacionpldkycinversiones(fideicomitenteBean.getInformacionpldkyc_inversiones());
	fideicomitente.setInformacionpldkycarrendamiento(fideicomitenteBean.getInformacionpldkyc_arrendamiento());
	fideicomitente.setInformacionpldkyctipopatrimonio(fideicomitenteBean.getInformacionpldkyc_tipopatrimonio());
	fideicomitente.setInformacionpldkycinstrumento(fideicomitenteBean.getInformacionpldkyc_instrumento());
	fideicomitente.setInformacionpldkycrazonapertura(fideicomitenteBean.getInformacionpldkyc_razonapertura());
	fideicomitente.setInformacionpldkyccomentarios(fideicomitenteBean.getInformacionpldkyc_comentarios());
	fideicomitente.setInformacionpldkycnivelriesgo(fideicomitenteBean.getInformacionpldkyc_nivelriesgo());
	fideicomitente.setInformacionpldkycestatuscalculopld(fideicomitenteBean.getInformacionpldkyc_estatuscalculopld());
	fideicomitente.setInformacionpldkycfechaveriffircosoft(fideicomitenteBean.getInformacionpldkyc_fechaveriffircosoft());
	fideicomitente.setIdentificacionrfc(fideicomitenteBean.getIdentificacion_rfc());
	fideicomitente.setIdentificacioncurp(fideicomitenteBean.getIdentificacion_curp());
	fideicomitente.setIdentificacionnoserieefirma(fideicomitenteBean.getIdentificacion_noserieefirma());
	fideicomitente.setIdentificacioncorreo(fideicomitenteBean.getIdentificacion_correo());
	fideicomitente.setIdentificacionfechaconstitucion(fideicomitenteBean.getIdentificacion_fechaconstitucion());
	fideicomitente.setIdentificacionsexo(fideicomitenteBean.getIdentificacion_sexo());
	fideicomitente.setIdentificacionfechainiciorelneg(fideicomitenteBean.getIdentificacion_fechainiciorelneg());
	fideicomitente.setIdentificacionnoidentificacion(fideicomitenteBean.getIdentificacion_noidentificacion());
	fideicomitente.setIdentificacioncomprobaciondomicilio(fideicomitenteBean.getIdentificacion_comprobaciondomicilio());
	fideicomitente.setIdentificacionactividadempresarial(fideicomitenteBean.getIdentificacion_actividadempresarial());
	fideicomitente.setIdentificacionclasificacionfatca(fideicomitenteBean.getIdentificacion_clasificacionfatca());
	fideicomitente.setIdentificacionidentoficialvig(fideicomitenteBean.getIdentificacion_identoficialvig());
	fideicomitente.setIdentificacionvigencia(fideicomitenteBean.getIdentificacion_vigencia());
	fideicomitente.setIdentificacionresideciafiscalpaisresidfisc1(fideicomitenteBean.getIdentificacion_resideciafiscal_paisresidfisc1());
	fideicomitente.setIdentificacionresideciafiscalidentificacionnoidentfisc1(fideicomitenteBean.getIdentificacion_resideciafiscal_identificacionnoidentfisc1());
	fideicomitente.setIdentificaciontelefonosfideicomitentepaiscasa(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_paiscasa());
	fideicomitente.setIdentificaciontelefonosfideicomitentepaisoficina(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_paisoficina());
	fideicomitente.setIdentificaciontelefonosfideicomitentepaiscelular(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_paiscelular());
	fideicomitente.setIdentificaciontelefonosfideicomitenteladacasa(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_ladacasa());
	fideicomitente.setIdentificaciontelefonosfideicomitenteladaoficina(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_ladaoficina());
	fideicomitente.setIdentificaciontelefonosfideicomitenteladacelular(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_ladacelular());
	fideicomitente.setIdentificaciontelefonosfideicomitentenumerocasa(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_numerocasa());
	fideicomitente.setIdentificaciontelefonosfideicomitentenumerooficina(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_numerooficina());
	fideicomitente.setIdentificaciontelefonosfideicomitentenumerocelular(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_numerocelular());
	fideicomitente.setIdentificaciontelefonosfideicomitenteextoficina(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_extoficina());
	fideicomitente.setIdentificaciontelefonosfideicomitenteextcelular(fideicomitenteBean.getIdentificacion_telefonosfideicomitente_extcelular());
	fideicomitente.setEscrituranoescritura(fideicomitenteBean.getEscritura_noescritura());
	fideicomitente.setEscrituranotario(fideicomitenteBean.getEscritura_notario());
	fideicomitente.setEscrituranonotaria(fideicomitenteBean.getEscritura_nonotaria());
	fideicomitente.setEscrituraciudad(fideicomitenteBean.getEscritura_ciudad());
	fideicomitente.setEscrituraestado(fideicomitenteBean.getEscritura_estado());
	fideicomitente.setEscriturafecha(fideicomitenteBean.getEscritura_fecha());
	fideicomitente.setEscrituratelefono(fideicomitenteBean.getEscritura_telefono());
	fideicomitente.setEscrituracorreo(fideicomitenteBean.getEscritura_correo());
	fideicomitente.set_cuentaskyc(fideicomitenteBean.get_cuentaskyc());
	
		fideicomitente.setFideicomitenteId(fideicomitenteFound.getFideicomitenteId());
		fideicomitenteService.editFideicomitente(fideicomitente);
		
		Map<String, Object> fideicomitenteMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(fideicomitenteMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un fideicomitente.
	 * @param id.
	 * @return ResponseEntity<Fideicomitente>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomitente/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_FIDEICOMITENTE:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteFideicomitente(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Fideicomitente fideicomitente = fideicomitenteService.getFideicomitente(uuid);
		if (fideicomitente == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			fideicomitenteService.deleteFideicomitente(fideicomitente);
			
			Map<String, Object> fideicomitenteMAP = new HashMap<>();
			fideicomitenteMAP.put("id", fideicomitente.getFideicomitenteId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(fideicomitenteMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Fideicomitente no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los fideicomitentes.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Fideicomitente>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomitente", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_FIDEICOMITENTE:READ')")
	public @ResponseBody  List<Map<String, Object>> getFideicomitentes(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Fideicomitente> listFideicomitente = null;
	
		if (query==null && _page == 0) {
			listFideicomitente = fideicomitenteService.listFideicomitentes(fideicomitente);
			rows = fideicomitenteService.getTotalRows();
		} else if (query!= null){
			listFideicomitente = fideicomitenteService.listFideicomitentesQuery(fideicomitente, query, _page, 10);
			rows = fideicomitenteService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listFideicomitente = fideicomitenteService.listFideicomitentesPagination(fideicomitente, _page, 10);
			rows = fideicomitenteService.getTotalRows();
		}
		
		List<Map<String, Object>> listFideicomitenteMAP = new ArrayList<>();
		for( Fideicomitente fideicomitente : listFideicomitente ){
			Map<String, Object> fideicomitenteMAP = new HashMap<>();
			fideicomitenteMAP.put("id", fideicomitente.getFideicomitenteId());
			fideicomitenteMAP.put("numerofideicomitente", fideicomitente.getNumerofideicomitente());
			fideicomitenteMAP.put("tipopersona", fideicomitente.getTipopersona());
			fideicomitenteMAP.put("participante", fideicomitente.getParticipante());
			fideicomitenteMAP.put("regimenfiscal", fideicomitente.getRegimenfiscal());
			fideicomitenteMAP.put("generales_controladorfideicomiso", fideicomitente.getGeneralescontroladorfideicomiso());
			fideicomitenteMAP.put("generales_nacionalidad", fideicomitente.getGeneralesnacionalidad());
			fideicomitenteMAP.put("generales_paisorigen", fideicomitente.getGeneralespaisorigen());
			fideicomitenteMAP.put("generales_actividad", fideicomitente.getGeneralesactividad());
			fideicomitenteMAP.put("generales_aportarecursos", fideicomitente.getGeneralesaportarecursos());
			fideicomitenteMAP.put("generales_paisresidencia", fideicomitente.getGeneralespaisresidencia());
			fideicomitenteMAP.put("generales_clientescotiabank", fideicomitente.getGeneralesclientescotiabank());
			fideicomitenteMAP.put("generales_pep", fideicomitente.getGeneralespep());
			fideicomitenteMAP.put("generales_estatus", fideicomitente.getGeneralesestatus());
			fideicomitenteMAP.put("generales_grupofilial", fideicomitente.getGeneralesgrupofilial());
			fideicomitenteMAP.put("generales_calidadmigratoria", fideicomitente.getGeneralescalidadmigratoria());
			fideicomitenteMAP.put("generales_lugaroperacion", fideicomitente.getGeneraleslugaroperacion());
			fideicomitenteMAP.put("generales_operacuentaterceros", fideicomitente.getGeneralesoperacuentaterceros());
			fideicomitenteMAP.put("generales_nivelparticipante", fideicomitente.getGeneralesnivelparticipante());
			fideicomitenteMAP.put("generales_clienterelacionpep", fideicomitente.getGeneralesclienterelacionpep());
			fideicomitenteMAP.put("generales_grado", fideicomitente.getGeneralesgrado());
			fideicomitenteMAP.put("informacionpldkyc_honorarios", fideicomitente.getInformacionpldkychonorarios());
			fideicomitenteMAP.put("informacionpldkyc_comisiones", fideicomitente.getInformacionpldkyccomisiones());
			fideicomitenteMAP.put("informacionpldkyc_otros", fideicomitente.getInformacionpldkycotros());
			fideicomitenteMAP.put("informacionpldkyc_sueldos", fideicomitente.getInformacionpldkycsueldos());
			fideicomitenteMAP.put("informacionpldkyc_venta", fideicomitente.getInformacionpldkycventa());
			fideicomitenteMAP.put("informacionpldkyc_inversiones", fideicomitente.getInformacionpldkycinversiones());
			fideicomitenteMAP.put("informacionpldkyc_arrendamiento", fideicomitente.getInformacionpldkycarrendamiento());
			fideicomitenteMAP.put("informacionpldkyc_tipopatrimonio", fideicomitente.getInformacionpldkyctipopatrimonio());
			fideicomitenteMAP.put("informacionpldkyc_instrumento", fideicomitente.getInformacionpldkycinstrumento());
			fideicomitenteMAP.put("informacionpldkyc_razonapertura", fideicomitente.getInformacionpldkycrazonapertura());
			fideicomitenteMAP.put("informacionpldkyc_comentarios", fideicomitente.getInformacionpldkyccomentarios());
			fideicomitenteMAP.put("informacionpldkyc_nivelriesgo", fideicomitente.getInformacionpldkycnivelriesgo());
			fideicomitenteMAP.put("informacionpldkyc_estatuscalculopld", fideicomitente.getInformacionpldkycestatuscalculopld());
			fideicomitenteMAP.put("informacionpldkyc_fechaveriffircosoft", fideicomitente.getInformacionpldkycfechaveriffircosoft());
			fideicomitenteMAP.put("identificacion_rfc", fideicomitente.getIdentificacionrfc());
			fideicomitenteMAP.put("identificacion_curp", fideicomitente.getIdentificacioncurp());
			fideicomitenteMAP.put("identificacion_noserieefirma", fideicomitente.getIdentificacionnoserieefirma());
			fideicomitenteMAP.put("identificacion_correo", fideicomitente.getIdentificacioncorreo());
			fideicomitenteMAP.put("identificacion_fechaconstitucion", fideicomitente.getIdentificacionfechaconstitucion());
			fideicomitenteMAP.put("identificacion_sexo", fideicomitente.getIdentificacionsexo());
			fideicomitenteMAP.put("identificacion_fechainiciorelneg", fideicomitente.getIdentificacionfechainiciorelneg());
			fideicomitenteMAP.put("identificacion_noidentificacion", fideicomitente.getIdentificacionnoidentificacion());
			fideicomitenteMAP.put("identificacion_comprobaciondomicilio", fideicomitente.getIdentificacioncomprobaciondomicilio());
			fideicomitenteMAP.put("identificacion_actividadempresarial", fideicomitente.getIdentificacionactividadempresarial());
			fideicomitenteMAP.put("identificacion_clasificacionfatca", fideicomitente.getIdentificacionclasificacionfatca());
			fideicomitenteMAP.put("identificacion_identoficialvig", fideicomitente.getIdentificacionidentoficialvig());
			fideicomitenteMAP.put("identificacion_vigencia", fideicomitente.getIdentificacionvigencia());
			fideicomitenteMAP.put("identificacion_resideciafiscal_paisresidfisc1", fideicomitente.getIdentificacionresideciafiscalpaisresidfisc1());
			fideicomitenteMAP.put("identificacion_resideciafiscal_identificacionnoidentfisc1", fideicomitente.getIdentificacionresideciafiscalidentificacionnoidentfisc1());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_paiscasa", fideicomitente.getIdentificaciontelefonosfideicomitentepaiscasa());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_paisoficina", fideicomitente.getIdentificaciontelefonosfideicomitentepaisoficina());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_paiscelular", fideicomitente.getIdentificaciontelefonosfideicomitentepaiscelular());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_ladacasa", fideicomitente.getIdentificaciontelefonosfideicomitenteladacasa());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_ladaoficina", fideicomitente.getIdentificaciontelefonosfideicomitenteladaoficina());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_ladacelular", fideicomitente.getIdentificaciontelefonosfideicomitenteladacelular());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_numerocasa", fideicomitente.getIdentificaciontelefonosfideicomitentenumerocasa());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_numerooficina", fideicomitente.getIdentificaciontelefonosfideicomitentenumerooficina());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_numerocelular", fideicomitente.getIdentificaciontelefonosfideicomitentenumerocelular());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_extoficina", fideicomitente.getIdentificaciontelefonosfideicomitenteextoficina());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_extcelular", fideicomitente.getIdentificaciontelefonosfideicomitenteextcelular());
			fideicomitenteMAP.put("escritura_noescritura", fideicomitente.getEscrituranoescritura());
			fideicomitenteMAP.put("escritura_notario", fideicomitente.getEscrituranotario());
			fideicomitenteMAP.put("escritura_nonotaria", fideicomitente.getEscrituranonotaria());
			fideicomitenteMAP.put("escritura_ciudad", fideicomitente.getEscrituraciudad());
			fideicomitenteMAP.put("escritura_estado", fideicomitente.getEscrituraestado());
			fideicomitenteMAP.put("escritura_fecha", fideicomitente.getEscriturafecha());
			fideicomitenteMAP.put("escritura_telefono", fideicomitente.getEscrituratelefono());
			fideicomitenteMAP.put("escritura_correo", fideicomitente.getEscrituracorreo());
			fideicomitenteMAP.put("_cuentaskyc", fideicomitente.get_cuentaskyc());
			fideicomitenteMAP.put("fideicomisoId", fideicomitente.getFideicomisoId().getFideicomisoId());
			
			listFideicomitenteMAP.add(fideicomitenteMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listFideicomitenteMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un fideicomitente.
	 * @param id.
	 * @return Fideicomitente.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomitente/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_FIDEICOMITENTE:READ')")
	public @ResponseBody  Map<String, Object> getFideicomitente(@PathVariable("id") String id) {	        
	        Fideicomitente fideicomitente = null;
	        
	        UUID uuid = UUID.fromString(id);
	        fideicomitente = fideicomitenteService.getFideicomitente(uuid);
	        
			Map<String, Object> fideicomitenteMAP = new HashMap<>();
			fideicomitenteMAP.put("id", fideicomitente.getFideicomitenteId());
			fideicomitenteMAP.put("numerofideicomitente", fideicomitente.getNumerofideicomitente());
			fideicomitenteMAP.put("tipopersona", fideicomitente.getTipopersona());
			fideicomitenteMAP.put("participante", fideicomitente.getParticipante());
			fideicomitenteMAP.put("regimenfiscal", fideicomitente.getRegimenfiscal());
			fideicomitenteMAP.put("generales_controladorfideicomiso", fideicomitente.getGeneralescontroladorfideicomiso());
			fideicomitenteMAP.put("generales_nacionalidad", fideicomitente.getGeneralesnacionalidad());
			fideicomitenteMAP.put("generales_paisorigen", fideicomitente.getGeneralespaisorigen());
			fideicomitenteMAP.put("generales_actividad", fideicomitente.getGeneralesactividad());
			fideicomitenteMAP.put("generales_aportarecursos", fideicomitente.getGeneralesaportarecursos());
			fideicomitenteMAP.put("generales_paisresidencia", fideicomitente.getGeneralespaisresidencia());
			fideicomitenteMAP.put("generales_clientescotiabank", fideicomitente.getGeneralesclientescotiabank());
			fideicomitenteMAP.put("generales_pep", fideicomitente.getGeneralespep());
			fideicomitenteMAP.put("generales_estatus", fideicomitente.getGeneralesestatus());
			fideicomitenteMAP.put("generales_grupofilial", fideicomitente.getGeneralesgrupofilial());
			fideicomitenteMAP.put("generales_calidadmigratoria", fideicomitente.getGeneralescalidadmigratoria());
			fideicomitenteMAP.put("generales_lugaroperacion", fideicomitente.getGeneraleslugaroperacion());
			fideicomitenteMAP.put("generales_operacuentaterceros", fideicomitente.getGeneralesoperacuentaterceros());
			fideicomitenteMAP.put("generales_nivelparticipante", fideicomitente.getGeneralesnivelparticipante());
			fideicomitenteMAP.put("generales_clienterelacionpep", fideicomitente.getGeneralesclienterelacionpep());
			fideicomitenteMAP.put("generales_grado", fideicomitente.getGeneralesgrado());
			fideicomitenteMAP.put("informacionpldkyc_honorarios", fideicomitente.getInformacionpldkychonorarios());
			fideicomitenteMAP.put("informacionpldkyc_comisiones", fideicomitente.getInformacionpldkyccomisiones());
			fideicomitenteMAP.put("informacionpldkyc_otros", fideicomitente.getInformacionpldkycotros());
			fideicomitenteMAP.put("informacionpldkyc_sueldos", fideicomitente.getInformacionpldkycsueldos());
			fideicomitenteMAP.put("informacionpldkyc_venta", fideicomitente.getInformacionpldkycventa());
			fideicomitenteMAP.put("informacionpldkyc_inversiones", fideicomitente.getInformacionpldkycinversiones());
			fideicomitenteMAP.put("informacionpldkyc_arrendamiento", fideicomitente.getInformacionpldkycarrendamiento());
			fideicomitenteMAP.put("informacionpldkyc_tipopatrimonio", fideicomitente.getInformacionpldkyctipopatrimonio());
			fideicomitenteMAP.put("informacionpldkyc_instrumento", fideicomitente.getInformacionpldkycinstrumento());
			fideicomitenteMAP.put("informacionpldkyc_razonapertura", fideicomitente.getInformacionpldkycrazonapertura());
			fideicomitenteMAP.put("informacionpldkyc_comentarios", fideicomitente.getInformacionpldkyccomentarios());
			fideicomitenteMAP.put("informacionpldkyc_nivelriesgo", fideicomitente.getInformacionpldkycnivelriesgo());
			fideicomitenteMAP.put("informacionpldkyc_estatuscalculopld", fideicomitente.getInformacionpldkycestatuscalculopld());
			fideicomitenteMAP.put("informacionpldkyc_fechaveriffircosoft", fideicomitente.getInformacionpldkycfechaveriffircosoft());
			fideicomitenteMAP.put("identificacion_rfc", fideicomitente.getIdentificacionrfc());
			fideicomitenteMAP.put("identificacion_curp", fideicomitente.getIdentificacioncurp());
			fideicomitenteMAP.put("identificacion_noserieefirma", fideicomitente.getIdentificacionnoserieefirma());
			fideicomitenteMAP.put("identificacion_correo", fideicomitente.getIdentificacioncorreo());
			fideicomitenteMAP.put("identificacion_fechaconstitucion", fideicomitente.getIdentificacionfechaconstitucion());
			fideicomitenteMAP.put("identificacion_sexo", fideicomitente.getIdentificacionsexo());
			fideicomitenteMAP.put("identificacion_fechainiciorelneg", fideicomitente.getIdentificacionfechainiciorelneg());
			fideicomitenteMAP.put("identificacion_noidentificacion", fideicomitente.getIdentificacionnoidentificacion());
			fideicomitenteMAP.put("identificacion_comprobaciondomicilio", fideicomitente.getIdentificacioncomprobaciondomicilio());
			fideicomitenteMAP.put("identificacion_actividadempresarial", fideicomitente.getIdentificacionactividadempresarial());
			fideicomitenteMAP.put("identificacion_clasificacionfatca", fideicomitente.getIdentificacionclasificacionfatca());
			fideicomitenteMAP.put("identificacion_identoficialvig", fideicomitente.getIdentificacionidentoficialvig());
			fideicomitenteMAP.put("identificacion_vigencia", fideicomitente.getIdentificacionvigencia());
			fideicomitenteMAP.put("identificacion_resideciafiscal_paisresidfisc1", fideicomitente.getIdentificacionresideciafiscalpaisresidfisc1());
			fideicomitenteMAP.put("identificacion_resideciafiscal_identificacionnoidentfisc1", fideicomitente.getIdentificacionresideciafiscalidentificacionnoidentfisc1());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_paiscasa", fideicomitente.getIdentificaciontelefonosfideicomitentepaiscasa());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_paisoficina", fideicomitente.getIdentificaciontelefonosfideicomitentepaisoficina());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_paiscelular", fideicomitente.getIdentificaciontelefonosfideicomitentepaiscelular());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_ladacasa", fideicomitente.getIdentificaciontelefonosfideicomitenteladacasa());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_ladaoficina", fideicomitente.getIdentificaciontelefonosfideicomitenteladaoficina());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_ladacelular", fideicomitente.getIdentificaciontelefonosfideicomitenteladacelular());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_numerocasa", fideicomitente.getIdentificaciontelefonosfideicomitentenumerocasa());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_numerooficina", fideicomitente.getIdentificaciontelefonosfideicomitentenumerooficina());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_numerocelular", fideicomitente.getIdentificaciontelefonosfideicomitentenumerocelular());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_extoficina", fideicomitente.getIdentificaciontelefonosfideicomitenteextoficina());
			fideicomitenteMAP.put("identificacion_telefonosfideicomitente_extcelular", fideicomitente.getIdentificaciontelefonosfideicomitenteextcelular());
			fideicomitenteMAP.put("escritura_noescritura", fideicomitente.getEscrituranoescritura());
			fideicomitenteMAP.put("escritura_notario", fideicomitente.getEscrituranotario());
			fideicomitenteMAP.put("escritura_nonotaria", fideicomitente.getEscrituranonotaria());
			fideicomitenteMAP.put("escritura_ciudad", fideicomitente.getEscrituraciudad());
			fideicomitenteMAP.put("escritura_estado", fideicomitente.getEscrituraestado());
			fideicomitenteMAP.put("escritura_fecha", fideicomitente.getEscriturafecha());
			fideicomitenteMAP.put("escritura_telefono", fideicomitente.getEscrituratelefono());
			fideicomitenteMAP.put("escritura_correo", fideicomitente.getEscrituracorreo());
			fideicomitenteMAP.put("_cuentaskyc", fideicomitente.get_cuentaskyc());
			fideicomitenteMAP.put("fideicomisoId", fideicomitente.getFideicomisoId());
	        
			return fideicomitenteMAP;
	 }
	
}
