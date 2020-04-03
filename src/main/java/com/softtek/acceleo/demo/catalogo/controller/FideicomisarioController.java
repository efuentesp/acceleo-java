
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Fideicomisarios. 
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

import com.softtek.acceleo.demo.catalogo.bean.FideicomisarioBean;
import com.softtek.acceleo.demo.domain.Fideicomisario;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.FideicomisarioService;
import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase FideicomisarioController.
 * @author PSG.
 *
 */
@RestController
public class FideicomisarioController {

	@Autowired
	private FideicomisarioService fideicomisarioService;
	
@Autowired
private FideicomisoService fideicomisoService;
	
	Fideicomisario fideicomisario = new Fideicomisario();
	/************************************** CREATE  **************************************
	 * Crea un nuevo fideicomisario.
	 * @param fideicomisario.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/fideicomisario", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_FIDEICOMISARIO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createFideicomisario(@RequestBody FideicomisarioBean fideicomisarioBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Fideicomisario fideicomisario = new Fideicomisario();
	   	
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(fideicomisarioBean.getFideicomisoId());
	   			fideicomisario.setFideicomisoId(fideicomiso);
	   		
	fideicomisario.setNumerofideicomisario(fideicomisarioBean.getNumerofideicomisario());
	fideicomisario.setTipopersona(fideicomisarioBean.getTipopersona());
	fideicomisario.setParticipante(fideicomisarioBean.getParticipante());
	fideicomisario.setRegimenfiscal(fideicomisarioBean.getRegimenfiscal());
	fideicomisario.setGeneralescontroladorfideicomiso(fideicomisarioBean.getGenerales_controladorfideicomiso());
	fideicomisario.setGeneralesnacionalidad(fideicomisarioBean.getGenerales_nacionalidad());
	fideicomisario.setGeneralespaisorigen(fideicomisarioBean.getGenerales_paisorigen());
	fideicomisario.setGeneralesactividad(fideicomisarioBean.getGenerales_actividad());
	fideicomisario.setGeneralesaportarecursos(fideicomisarioBean.getGenerales_aportarecursos());
	fideicomisario.setGeneralespaisresidencia(fideicomisarioBean.getGenerales_paisresidencia());
	fideicomisario.setGeneralesclientescotiabank(fideicomisarioBean.getGenerales_clientescotiabank());
	fideicomisario.setGeneralespep(fideicomisarioBean.getGenerales_pep());
	fideicomisario.setGeneralesestatus(fideicomisarioBean.getGenerales_estatus());
	fideicomisario.setGeneralesgrupofilial(fideicomisarioBean.getGenerales_grupofilial());
	fideicomisario.setGeneralescalidadmigratoria(fideicomisarioBean.getGenerales_calidadmigratoria());
	fideicomisario.setGeneraleslugaroperacion(fideicomisarioBean.getGenerales_lugaroperacion());
	fideicomisario.setGeneralesoperacuentaterceros(fideicomisarioBean.getGenerales_operacuentaterceros());
	fideicomisario.setGeneralesnivelparticipante(fideicomisarioBean.getGenerales_nivelparticipante());
	fideicomisario.setGeneralesclienterelacionpep(fideicomisarioBean.getGenerales_clienterelacionpep());
	fideicomisario.setGeneralesgrado(fideicomisarioBean.getGenerales_grado());
	fideicomisario.setInformacionpldkychonorarios(fideicomisarioBean.getInformacionpldkyc_honorarios());
	fideicomisario.setInformacionpldkyccomisiones(fideicomisarioBean.getInformacionpldkyc_comisiones());
	fideicomisario.setInformacionpldkycotros(fideicomisarioBean.getInformacionpldkyc_otros());
	fideicomisario.setInformacionpldkycsueldos(fideicomisarioBean.getInformacionpldkyc_sueldos());
	fideicomisario.setInformacionpldkycventa(fideicomisarioBean.getInformacionpldkyc_venta());
	fideicomisario.setInformacionpldkycinversiones(fideicomisarioBean.getInformacionpldkyc_inversiones());
	fideicomisario.setInformacionpldkycarrendamiento(fideicomisarioBean.getInformacionpldkyc_arrendamiento());
	fideicomisario.setInformacionpldkyctipopatrimonio(fideicomisarioBean.getInformacionpldkyc_tipopatrimonio());
	fideicomisario.setInformacionpldkycinstrumento(fideicomisarioBean.getInformacionpldkyc_instrumento());
	fideicomisario.setInformacionpldkycrazonapertura(fideicomisarioBean.getInformacionpldkyc_razonapertura());
	fideicomisario.setInformacionpldkyccomentarios(fideicomisarioBean.getInformacionpldkyc_comentarios());
	fideicomisario.setInformacionpldkycnivelriesgo(fideicomisarioBean.getInformacionpldkyc_nivelriesgo());
	fideicomisario.setInformacionpldkycestatuscalculopld(fideicomisarioBean.getInformacionpldkyc_estatuscalculopld());
	fideicomisario.setInformacionpldkycfechaveriffircosoft(fideicomisarioBean.getInformacionpldkyc_fechaveriffircosoft());
	fideicomisario.setIdentificacionrfc(fideicomisarioBean.getIdentificacion_rfc());
	fideicomisario.setIdentificacioncurp(fideicomisarioBean.getIdentificacion_curp());
	fideicomisario.setIdentificacionnoserieefirma(fideicomisarioBean.getIdentificacion_noserieefirma());
	fideicomisario.setIdentificacioncorreo(fideicomisarioBean.getIdentificacion_correo());
	fideicomisario.setIdentificacionfechaconstitucion(fideicomisarioBean.getIdentificacion_fechaconstitucion());
	fideicomisario.setIdentificacionsexo(fideicomisarioBean.getIdentificacion_sexo());
	fideicomisario.setIdentificacionfechainiciorelneg(fideicomisarioBean.getIdentificacion_fechainiciorelneg());
	fideicomisario.setIdentificacionnoidentificacion(fideicomisarioBean.getIdentificacion_noidentificacion());
	fideicomisario.setIdentificacioncomprobaciondomicilio(fideicomisarioBean.getIdentificacion_comprobaciondomicilio());
	fideicomisario.setIdentificacionactividadempresarial(fideicomisarioBean.getIdentificacion_actividadempresarial());
	fideicomisario.setIdentificacionclasificacionfatca(fideicomisarioBean.getIdentificacion_clasificacionfatca());
	fideicomisario.setIdentificacionidentoficialvig(fideicomisarioBean.getIdentificacion_identoficialvig());
	fideicomisario.setIdentificacionvigencia(fideicomisarioBean.getIdentificacion_vigencia());
	fideicomisario.setIdentificacionresideciafiscalpaisresidfisc1(fideicomisarioBean.getIdentificacion_resideciafiscal_paisresidfisc1());
	fideicomisario.setIdentificacionresideciafiscalidentificacionnoidentfisc1(fideicomisarioBean.getIdentificacion_resideciafiscal_identificacionnoidentfisc1());
	fideicomisario.setIdentificaciontelefonosfideicomitentepaiscasa(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_paiscasa());
	fideicomisario.setIdentificaciontelefonosfideicomitentepaisoficina(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_paisoficina());
	fideicomisario.setIdentificaciontelefonosfideicomitentepaiscelular(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_paiscelular());
	fideicomisario.setIdentificaciontelefonosfideicomitenteladacasa(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_ladacasa());
	fideicomisario.setIdentificaciontelefonosfideicomitenteladaoficina(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_ladaoficina());
	fideicomisario.setIdentificaciontelefonosfideicomitenteladacelular(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_ladacelular());
	fideicomisario.setIdentificaciontelefonosfideicomitentenumerocasa(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_numerocasa());
	fideicomisario.setIdentificaciontelefonosfideicomitentenumerooficina(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_numerooficina());
	fideicomisario.setIdentificaciontelefonosfideicomitentenumerocelular(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_numerocelular());
	fideicomisario.setIdentificaciontelefonosfideicomitenteextoficina(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_extoficina());
	fideicomisario.setIdentificaciontelefonosfideicomitenteextcelular(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_extcelular());
	fideicomisario.setEscrituranoescritura(fideicomisarioBean.getEscritura_noescritura());
	fideicomisario.setEscrituranotario(fideicomisarioBean.getEscritura_notario());
	fideicomisario.setEscrituranonotaria(fideicomisarioBean.getEscritura_nonotaria());
	fideicomisario.setEscrituraciudad(fideicomisarioBean.getEscritura_ciudad());
	fideicomisario.setEscrituraestado(fideicomisarioBean.getEscritura_estado());
	fideicomisario.setEscriturafecha(fideicomisarioBean.getEscritura_fecha());
	fideicomisario.setEscrituratelefono(fideicomisarioBean.getEscritura_telefono());
	fideicomisario.setEscrituracorreo(fideicomisarioBean.getEscritura_correo());
	fideicomisario.set_cuentaskyc(fideicomisarioBean.get_cuentaskyc());
	   		
	        fideicomisarioService.addFideicomisario(fideicomisario);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> fideicomisarioMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(fideicomisarioMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Fideicomisario no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un fideicomisario.
	  * @param id.
	  * @param fideicomisario.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomisario/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_FIDEICOMISARIO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarFideicomisario(
				@PathVariable("id") String id, 
				@RequestBody FideicomisarioBean fideicomisarioBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Fideicomisario fideicomisarioFound = fideicomisarioService.getFideicomisario(uuid);
	         
	    if (fideicomisarioFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   			Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(fideicomisarioBean.getFideicomisoId());
	   			fideicomisario.setFideicomisoId(fideicomiso);
	   		
	fideicomisario.setNumerofideicomisario(fideicomisarioBean.getNumerofideicomisario());
	fideicomisario.setTipopersona(fideicomisarioBean.getTipopersona());
	fideicomisario.setParticipante(fideicomisarioBean.getParticipante());
	fideicomisario.setRegimenfiscal(fideicomisarioBean.getRegimenfiscal());
	fideicomisario.setGeneralescontroladorfideicomiso(fideicomisarioBean.getGenerales_controladorfideicomiso());
	fideicomisario.setGeneralesnacionalidad(fideicomisarioBean.getGenerales_nacionalidad());
	fideicomisario.setGeneralespaisorigen(fideicomisarioBean.getGenerales_paisorigen());
	fideicomisario.setGeneralesactividad(fideicomisarioBean.getGenerales_actividad());
	fideicomisario.setGeneralesaportarecursos(fideicomisarioBean.getGenerales_aportarecursos());
	fideicomisario.setGeneralespaisresidencia(fideicomisarioBean.getGenerales_paisresidencia());
	fideicomisario.setGeneralesclientescotiabank(fideicomisarioBean.getGenerales_clientescotiabank());
	fideicomisario.setGeneralespep(fideicomisarioBean.getGenerales_pep());
	fideicomisario.setGeneralesestatus(fideicomisarioBean.getGenerales_estatus());
	fideicomisario.setGeneralesgrupofilial(fideicomisarioBean.getGenerales_grupofilial());
	fideicomisario.setGeneralescalidadmigratoria(fideicomisarioBean.getGenerales_calidadmigratoria());
	fideicomisario.setGeneraleslugaroperacion(fideicomisarioBean.getGenerales_lugaroperacion());
	fideicomisario.setGeneralesoperacuentaterceros(fideicomisarioBean.getGenerales_operacuentaterceros());
	fideicomisario.setGeneralesnivelparticipante(fideicomisarioBean.getGenerales_nivelparticipante());
	fideicomisario.setGeneralesclienterelacionpep(fideicomisarioBean.getGenerales_clienterelacionpep());
	fideicomisario.setGeneralesgrado(fideicomisarioBean.getGenerales_grado());
	fideicomisario.setInformacionpldkychonorarios(fideicomisarioBean.getInformacionpldkyc_honorarios());
	fideicomisario.setInformacionpldkyccomisiones(fideicomisarioBean.getInformacionpldkyc_comisiones());
	fideicomisario.setInformacionpldkycotros(fideicomisarioBean.getInformacionpldkyc_otros());
	fideicomisario.setInformacionpldkycsueldos(fideicomisarioBean.getInformacionpldkyc_sueldos());
	fideicomisario.setInformacionpldkycventa(fideicomisarioBean.getInformacionpldkyc_venta());
	fideicomisario.setInformacionpldkycinversiones(fideicomisarioBean.getInformacionpldkyc_inversiones());
	fideicomisario.setInformacionpldkycarrendamiento(fideicomisarioBean.getInformacionpldkyc_arrendamiento());
	fideicomisario.setInformacionpldkyctipopatrimonio(fideicomisarioBean.getInformacionpldkyc_tipopatrimonio());
	fideicomisario.setInformacionpldkycinstrumento(fideicomisarioBean.getInformacionpldkyc_instrumento());
	fideicomisario.setInformacionpldkycrazonapertura(fideicomisarioBean.getInformacionpldkyc_razonapertura());
	fideicomisario.setInformacionpldkyccomentarios(fideicomisarioBean.getInformacionpldkyc_comentarios());
	fideicomisario.setInformacionpldkycnivelriesgo(fideicomisarioBean.getInformacionpldkyc_nivelriesgo());
	fideicomisario.setInformacionpldkycestatuscalculopld(fideicomisarioBean.getInformacionpldkyc_estatuscalculopld());
	fideicomisario.setInformacionpldkycfechaveriffircosoft(fideicomisarioBean.getInformacionpldkyc_fechaveriffircosoft());
	fideicomisario.setIdentificacionrfc(fideicomisarioBean.getIdentificacion_rfc());
	fideicomisario.setIdentificacioncurp(fideicomisarioBean.getIdentificacion_curp());
	fideicomisario.setIdentificacionnoserieefirma(fideicomisarioBean.getIdentificacion_noserieefirma());
	fideicomisario.setIdentificacioncorreo(fideicomisarioBean.getIdentificacion_correo());
	fideicomisario.setIdentificacionfechaconstitucion(fideicomisarioBean.getIdentificacion_fechaconstitucion());
	fideicomisario.setIdentificacionsexo(fideicomisarioBean.getIdentificacion_sexo());
	fideicomisario.setIdentificacionfechainiciorelneg(fideicomisarioBean.getIdentificacion_fechainiciorelneg());
	fideicomisario.setIdentificacionnoidentificacion(fideicomisarioBean.getIdentificacion_noidentificacion());
	fideicomisario.setIdentificacioncomprobaciondomicilio(fideicomisarioBean.getIdentificacion_comprobaciondomicilio());
	fideicomisario.setIdentificacionactividadempresarial(fideicomisarioBean.getIdentificacion_actividadempresarial());
	fideicomisario.setIdentificacionclasificacionfatca(fideicomisarioBean.getIdentificacion_clasificacionfatca());
	fideicomisario.setIdentificacionidentoficialvig(fideicomisarioBean.getIdentificacion_identoficialvig());
	fideicomisario.setIdentificacionvigencia(fideicomisarioBean.getIdentificacion_vigencia());
	fideicomisario.setIdentificacionresideciafiscalpaisresidfisc1(fideicomisarioBean.getIdentificacion_resideciafiscal_paisresidfisc1());
	fideicomisario.setIdentificacionresideciafiscalidentificacionnoidentfisc1(fideicomisarioBean.getIdentificacion_resideciafiscal_identificacionnoidentfisc1());
	fideicomisario.setIdentificaciontelefonosfideicomitentepaiscasa(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_paiscasa());
	fideicomisario.setIdentificaciontelefonosfideicomitentepaisoficina(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_paisoficina());
	fideicomisario.setIdentificaciontelefonosfideicomitentepaiscelular(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_paiscelular());
	fideicomisario.setIdentificaciontelefonosfideicomitenteladacasa(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_ladacasa());
	fideicomisario.setIdentificaciontelefonosfideicomitenteladaoficina(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_ladaoficina());
	fideicomisario.setIdentificaciontelefonosfideicomitenteladacelular(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_ladacelular());
	fideicomisario.setIdentificaciontelefonosfideicomitentenumerocasa(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_numerocasa());
	fideicomisario.setIdentificaciontelefonosfideicomitentenumerooficina(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_numerooficina());
	fideicomisario.setIdentificaciontelefonosfideicomitentenumerocelular(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_numerocelular());
	fideicomisario.setIdentificaciontelefonosfideicomitenteextoficina(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_extoficina());
	fideicomisario.setIdentificaciontelefonosfideicomitenteextcelular(fideicomisarioBean.getIdentificacion_telefonosfideicomitente_extcelular());
	fideicomisario.setEscrituranoescritura(fideicomisarioBean.getEscritura_noescritura());
	fideicomisario.setEscrituranotario(fideicomisarioBean.getEscritura_notario());
	fideicomisario.setEscrituranonotaria(fideicomisarioBean.getEscritura_nonotaria());
	fideicomisario.setEscrituraciudad(fideicomisarioBean.getEscritura_ciudad());
	fideicomisario.setEscrituraestado(fideicomisarioBean.getEscritura_estado());
	fideicomisario.setEscriturafecha(fideicomisarioBean.getEscritura_fecha());
	fideicomisario.setEscrituratelefono(fideicomisarioBean.getEscritura_telefono());
	fideicomisario.setEscrituracorreo(fideicomisarioBean.getEscritura_correo());
	fideicomisario.set_cuentaskyc(fideicomisarioBean.get_cuentaskyc());
	
		fideicomisario.setFideicomisarioId(fideicomisarioFound.getFideicomisarioId());
		fideicomisarioService.editFideicomisario(fideicomisario);
		
		Map<String, Object> fideicomisarioMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(fideicomisarioMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un fideicomisario.
	 * @param id.
	 * @return ResponseEntity<Fideicomisario>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomisario/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_FIDEICOMISARIO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteFideicomisario(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Fideicomisario fideicomisario = fideicomisarioService.getFideicomisario(uuid);
		if (fideicomisario == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			fideicomisarioService.deleteFideicomisario(fideicomisario);
			
			Map<String, Object> fideicomisarioMAP = new HashMap<>();
			fideicomisarioMAP.put("id", fideicomisario.getFideicomisarioId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(fideicomisarioMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Fideicomisario no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los fideicomisarios.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Fideicomisario>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomisario", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_FIDEICOMISARIO:READ')")
	public @ResponseBody  List<Map<String, Object>> getFideicomisarios(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Fideicomisario> listFideicomisario = null;
	
		if (query==null && _page == 0) {
			listFideicomisario = fideicomisarioService.listFideicomisarios(fideicomisario);
			rows = fideicomisarioService.getTotalRows();
		} else if (query!= null){
			listFideicomisario = fideicomisarioService.listFideicomisariosQuery(fideicomisario, query, _page, 10);
			rows = fideicomisarioService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listFideicomisario = fideicomisarioService.listFideicomisariosPagination(fideicomisario, _page, 10);
			rows = fideicomisarioService.getTotalRows();
		}
		
		List<Map<String, Object>> listFideicomisarioMAP = new ArrayList<>();
		for( Fideicomisario fideicomisario : listFideicomisario ){
			Map<String, Object> fideicomisarioMAP = new HashMap<>();
			fideicomisarioMAP.put("id", fideicomisario.getFideicomisarioId());
			fideicomisarioMAP.put("numerofideicomisario", fideicomisario.getNumerofideicomisario());
			fideicomisarioMAP.put("tipopersona", fideicomisario.getTipopersona());
			fideicomisarioMAP.put("participante", fideicomisario.getParticipante());
			fideicomisarioMAP.put("regimenfiscal", fideicomisario.getRegimenfiscal());
			fideicomisarioMAP.put("generales_controladorfideicomiso", fideicomisario.getGeneralescontroladorfideicomiso());
			fideicomisarioMAP.put("generales_nacionalidad", fideicomisario.getGeneralesnacionalidad());
			fideicomisarioMAP.put("generales_paisorigen", fideicomisario.getGeneralespaisorigen());
			fideicomisarioMAP.put("generales_actividad", fideicomisario.getGeneralesactividad());
			fideicomisarioMAP.put("generales_aportarecursos", fideicomisario.getGeneralesaportarecursos());
			fideicomisarioMAP.put("generales_paisresidencia", fideicomisario.getGeneralespaisresidencia());
			fideicomisarioMAP.put("generales_clientescotiabank", fideicomisario.getGeneralesclientescotiabank());
			fideicomisarioMAP.put("generales_pep", fideicomisario.getGeneralespep());
			fideicomisarioMAP.put("generales_estatus", fideicomisario.getGeneralesestatus());
			fideicomisarioMAP.put("generales_grupofilial", fideicomisario.getGeneralesgrupofilial());
			fideicomisarioMAP.put("generales_calidadmigratoria", fideicomisario.getGeneralescalidadmigratoria());
			fideicomisarioMAP.put("generales_lugaroperacion", fideicomisario.getGeneraleslugaroperacion());
			fideicomisarioMAP.put("generales_operacuentaterceros", fideicomisario.getGeneralesoperacuentaterceros());
			fideicomisarioMAP.put("generales_nivelparticipante", fideicomisario.getGeneralesnivelparticipante());
			fideicomisarioMAP.put("generales_clienterelacionpep", fideicomisario.getGeneralesclienterelacionpep());
			fideicomisarioMAP.put("generales_grado", fideicomisario.getGeneralesgrado());
			fideicomisarioMAP.put("informacionpldkyc_honorarios", fideicomisario.getInformacionpldkychonorarios());
			fideicomisarioMAP.put("informacionpldkyc_comisiones", fideicomisario.getInformacionpldkyccomisiones());
			fideicomisarioMAP.put("informacionpldkyc_otros", fideicomisario.getInformacionpldkycotros());
			fideicomisarioMAP.put("informacionpldkyc_sueldos", fideicomisario.getInformacionpldkycsueldos());
			fideicomisarioMAP.put("informacionpldkyc_venta", fideicomisario.getInformacionpldkycventa());
			fideicomisarioMAP.put("informacionpldkyc_inversiones", fideicomisario.getInformacionpldkycinversiones());
			fideicomisarioMAP.put("informacionpldkyc_arrendamiento", fideicomisario.getInformacionpldkycarrendamiento());
			fideicomisarioMAP.put("informacionpldkyc_tipopatrimonio", fideicomisario.getInformacionpldkyctipopatrimonio());
			fideicomisarioMAP.put("informacionpldkyc_instrumento", fideicomisario.getInformacionpldkycinstrumento());
			fideicomisarioMAP.put("informacionpldkyc_razonapertura", fideicomisario.getInformacionpldkycrazonapertura());
			fideicomisarioMAP.put("informacionpldkyc_comentarios", fideicomisario.getInformacionpldkyccomentarios());
			fideicomisarioMAP.put("informacionpldkyc_nivelriesgo", fideicomisario.getInformacionpldkycnivelriesgo());
			fideicomisarioMAP.put("informacionpldkyc_estatuscalculopld", fideicomisario.getInformacionpldkycestatuscalculopld());
			fideicomisarioMAP.put("informacionpldkyc_fechaveriffircosoft", fideicomisario.getInformacionpldkycfechaveriffircosoft());
			fideicomisarioMAP.put("identificacion_rfc", fideicomisario.getIdentificacionrfc());
			fideicomisarioMAP.put("identificacion_curp", fideicomisario.getIdentificacioncurp());
			fideicomisarioMAP.put("identificacion_noserieefirma", fideicomisario.getIdentificacionnoserieefirma());
			fideicomisarioMAP.put("identificacion_correo", fideicomisario.getIdentificacioncorreo());
			fideicomisarioMAP.put("identificacion_fechaconstitucion", fideicomisario.getIdentificacionfechaconstitucion());
			fideicomisarioMAP.put("identificacion_sexo", fideicomisario.getIdentificacionsexo());
			fideicomisarioMAP.put("identificacion_fechainiciorelneg", fideicomisario.getIdentificacionfechainiciorelneg());
			fideicomisarioMAP.put("identificacion_noidentificacion", fideicomisario.getIdentificacionnoidentificacion());
			fideicomisarioMAP.put("identificacion_comprobaciondomicilio", fideicomisario.getIdentificacioncomprobaciondomicilio());
			fideicomisarioMAP.put("identificacion_actividadempresarial", fideicomisario.getIdentificacionactividadempresarial());
			fideicomisarioMAP.put("identificacion_clasificacionfatca", fideicomisario.getIdentificacionclasificacionfatca());
			fideicomisarioMAP.put("identificacion_identoficialvig", fideicomisario.getIdentificacionidentoficialvig());
			fideicomisarioMAP.put("identificacion_vigencia", fideicomisario.getIdentificacionvigencia());
			fideicomisarioMAP.put("identificacion_resideciafiscal_paisresidfisc1", fideicomisario.getIdentificacionresideciafiscalpaisresidfisc1());
			fideicomisarioMAP.put("identificacion_resideciafiscal_identificacionnoidentfisc1", fideicomisario.getIdentificacionresideciafiscalidentificacionnoidentfisc1());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_paiscasa", fideicomisario.getIdentificaciontelefonosfideicomitentepaiscasa());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_paisoficina", fideicomisario.getIdentificaciontelefonosfideicomitentepaisoficina());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_paiscelular", fideicomisario.getIdentificaciontelefonosfideicomitentepaiscelular());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_ladacasa", fideicomisario.getIdentificaciontelefonosfideicomitenteladacasa());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_ladaoficina", fideicomisario.getIdentificaciontelefonosfideicomitenteladaoficina());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_ladacelular", fideicomisario.getIdentificaciontelefonosfideicomitenteladacelular());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_numerocasa", fideicomisario.getIdentificaciontelefonosfideicomitentenumerocasa());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_numerooficina", fideicomisario.getIdentificaciontelefonosfideicomitentenumerooficina());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_numerocelular", fideicomisario.getIdentificaciontelefonosfideicomitentenumerocelular());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_extoficina", fideicomisario.getIdentificaciontelefonosfideicomitenteextoficina());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_extcelular", fideicomisario.getIdentificaciontelefonosfideicomitenteextcelular());
			fideicomisarioMAP.put("escritura_noescritura", fideicomisario.getEscrituranoescritura());
			fideicomisarioMAP.put("escritura_notario", fideicomisario.getEscrituranotario());
			fideicomisarioMAP.put("escritura_nonotaria", fideicomisario.getEscrituranonotaria());
			fideicomisarioMAP.put("escritura_ciudad", fideicomisario.getEscrituraciudad());
			fideicomisarioMAP.put("escritura_estado", fideicomisario.getEscrituraestado());
			fideicomisarioMAP.put("escritura_fecha", fideicomisario.getEscriturafecha());
			fideicomisarioMAP.put("escritura_telefono", fideicomisario.getEscrituratelefono());
			fideicomisarioMAP.put("escritura_correo", fideicomisario.getEscrituracorreo());
			fideicomisarioMAP.put("_cuentaskyc", fideicomisario.get_cuentaskyc());
			fideicomisarioMAP.put("fideicomisoId", fideicomisario.getFideicomisoId().getFideicomisoId());
			
			listFideicomisarioMAP.add(fideicomisarioMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listFideicomisarioMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un fideicomisario.
	 * @param id.
	 * @return Fideicomisario.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomisario/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_FIDEICOMISARIO:READ')")
	public @ResponseBody  Map<String, Object> getFideicomisario(@PathVariable("id") String id) {	        
	        Fideicomisario fideicomisario = null;
	        
	        UUID uuid = UUID.fromString(id);
	        fideicomisario = fideicomisarioService.getFideicomisario(uuid);
	        
			Map<String, Object> fideicomisarioMAP = new HashMap<>();
			fideicomisarioMAP.put("id", fideicomisario.getFideicomisarioId());
			fideicomisarioMAP.put("numerofideicomisario", fideicomisario.getNumerofideicomisario());
			fideicomisarioMAP.put("tipopersona", fideicomisario.getTipopersona());
			fideicomisarioMAP.put("participante", fideicomisario.getParticipante());
			fideicomisarioMAP.put("regimenfiscal", fideicomisario.getRegimenfiscal());
			fideicomisarioMAP.put("generales_controladorfideicomiso", fideicomisario.getGeneralescontroladorfideicomiso());
			fideicomisarioMAP.put("generales_nacionalidad", fideicomisario.getGeneralesnacionalidad());
			fideicomisarioMAP.put("generales_paisorigen", fideicomisario.getGeneralespaisorigen());
			fideicomisarioMAP.put("generales_actividad", fideicomisario.getGeneralesactividad());
			fideicomisarioMAP.put("generales_aportarecursos", fideicomisario.getGeneralesaportarecursos());
			fideicomisarioMAP.put("generales_paisresidencia", fideicomisario.getGeneralespaisresidencia());
			fideicomisarioMAP.put("generales_clientescotiabank", fideicomisario.getGeneralesclientescotiabank());
			fideicomisarioMAP.put("generales_pep", fideicomisario.getGeneralespep());
			fideicomisarioMAP.put("generales_estatus", fideicomisario.getGeneralesestatus());
			fideicomisarioMAP.put("generales_grupofilial", fideicomisario.getGeneralesgrupofilial());
			fideicomisarioMAP.put("generales_calidadmigratoria", fideicomisario.getGeneralescalidadmigratoria());
			fideicomisarioMAP.put("generales_lugaroperacion", fideicomisario.getGeneraleslugaroperacion());
			fideicomisarioMAP.put("generales_operacuentaterceros", fideicomisario.getGeneralesoperacuentaterceros());
			fideicomisarioMAP.put("generales_nivelparticipante", fideicomisario.getGeneralesnivelparticipante());
			fideicomisarioMAP.put("generales_clienterelacionpep", fideicomisario.getGeneralesclienterelacionpep());
			fideicomisarioMAP.put("generales_grado", fideicomisario.getGeneralesgrado());
			fideicomisarioMAP.put("informacionpldkyc_honorarios", fideicomisario.getInformacionpldkychonorarios());
			fideicomisarioMAP.put("informacionpldkyc_comisiones", fideicomisario.getInformacionpldkyccomisiones());
			fideicomisarioMAP.put("informacionpldkyc_otros", fideicomisario.getInformacionpldkycotros());
			fideicomisarioMAP.put("informacionpldkyc_sueldos", fideicomisario.getInformacionpldkycsueldos());
			fideicomisarioMAP.put("informacionpldkyc_venta", fideicomisario.getInformacionpldkycventa());
			fideicomisarioMAP.put("informacionpldkyc_inversiones", fideicomisario.getInformacionpldkycinversiones());
			fideicomisarioMAP.put("informacionpldkyc_arrendamiento", fideicomisario.getInformacionpldkycarrendamiento());
			fideicomisarioMAP.put("informacionpldkyc_tipopatrimonio", fideicomisario.getInformacionpldkyctipopatrimonio());
			fideicomisarioMAP.put("informacionpldkyc_instrumento", fideicomisario.getInformacionpldkycinstrumento());
			fideicomisarioMAP.put("informacionpldkyc_razonapertura", fideicomisario.getInformacionpldkycrazonapertura());
			fideicomisarioMAP.put("informacionpldkyc_comentarios", fideicomisario.getInformacionpldkyccomentarios());
			fideicomisarioMAP.put("informacionpldkyc_nivelriesgo", fideicomisario.getInformacionpldkycnivelriesgo());
			fideicomisarioMAP.put("informacionpldkyc_estatuscalculopld", fideicomisario.getInformacionpldkycestatuscalculopld());
			fideicomisarioMAP.put("informacionpldkyc_fechaveriffircosoft", fideicomisario.getInformacionpldkycfechaveriffircosoft());
			fideicomisarioMAP.put("identificacion_rfc", fideicomisario.getIdentificacionrfc());
			fideicomisarioMAP.put("identificacion_curp", fideicomisario.getIdentificacioncurp());
			fideicomisarioMAP.put("identificacion_noserieefirma", fideicomisario.getIdentificacionnoserieefirma());
			fideicomisarioMAP.put("identificacion_correo", fideicomisario.getIdentificacioncorreo());
			fideicomisarioMAP.put("identificacion_fechaconstitucion", fideicomisario.getIdentificacionfechaconstitucion());
			fideicomisarioMAP.put("identificacion_sexo", fideicomisario.getIdentificacionsexo());
			fideicomisarioMAP.put("identificacion_fechainiciorelneg", fideicomisario.getIdentificacionfechainiciorelneg());
			fideicomisarioMAP.put("identificacion_noidentificacion", fideicomisario.getIdentificacionnoidentificacion());
			fideicomisarioMAP.put("identificacion_comprobaciondomicilio", fideicomisario.getIdentificacioncomprobaciondomicilio());
			fideicomisarioMAP.put("identificacion_actividadempresarial", fideicomisario.getIdentificacionactividadempresarial());
			fideicomisarioMAP.put("identificacion_clasificacionfatca", fideicomisario.getIdentificacionclasificacionfatca());
			fideicomisarioMAP.put("identificacion_identoficialvig", fideicomisario.getIdentificacionidentoficialvig());
			fideicomisarioMAP.put("identificacion_vigencia", fideicomisario.getIdentificacionvigencia());
			fideicomisarioMAP.put("identificacion_resideciafiscal_paisresidfisc1", fideicomisario.getIdentificacionresideciafiscalpaisresidfisc1());
			fideicomisarioMAP.put("identificacion_resideciafiscal_identificacionnoidentfisc1", fideicomisario.getIdentificacionresideciafiscalidentificacionnoidentfisc1());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_paiscasa", fideicomisario.getIdentificaciontelefonosfideicomitentepaiscasa());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_paisoficina", fideicomisario.getIdentificaciontelefonosfideicomitentepaisoficina());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_paiscelular", fideicomisario.getIdentificaciontelefonosfideicomitentepaiscelular());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_ladacasa", fideicomisario.getIdentificaciontelefonosfideicomitenteladacasa());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_ladaoficina", fideicomisario.getIdentificaciontelefonosfideicomitenteladaoficina());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_ladacelular", fideicomisario.getIdentificaciontelefonosfideicomitenteladacelular());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_numerocasa", fideicomisario.getIdentificaciontelefonosfideicomitentenumerocasa());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_numerooficina", fideicomisario.getIdentificaciontelefonosfideicomitentenumerooficina());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_numerocelular", fideicomisario.getIdentificaciontelefonosfideicomitentenumerocelular());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_extoficina", fideicomisario.getIdentificaciontelefonosfideicomitenteextoficina());
			fideicomisarioMAP.put("identificacion_telefonosfideicomitente_extcelular", fideicomisario.getIdentificaciontelefonosfideicomitenteextcelular());
			fideicomisarioMAP.put("escritura_noescritura", fideicomisario.getEscrituranoescritura());
			fideicomisarioMAP.put("escritura_notario", fideicomisario.getEscrituranotario());
			fideicomisarioMAP.put("escritura_nonotaria", fideicomisario.getEscrituranonotaria());
			fideicomisarioMAP.put("escritura_ciudad", fideicomisario.getEscrituraciudad());
			fideicomisarioMAP.put("escritura_estado", fideicomisario.getEscrituraestado());
			fideicomisarioMAP.put("escritura_fecha", fideicomisario.getEscriturafecha());
			fideicomisarioMAP.put("escritura_telefono", fideicomisario.getEscrituratelefono());
			fideicomisarioMAP.put("escritura_correo", fideicomisario.getEscrituracorreo());
			fideicomisarioMAP.put("_cuentaskyc", fideicomisario.get_cuentaskyc());
			fideicomisarioMAP.put("fideicomisoId", fideicomisario.getFideicomisoId());
	        
			return fideicomisarioMAP;
	 }
	
}
