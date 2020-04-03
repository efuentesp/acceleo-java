
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Fideicomisos. 
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

import com.softtek.acceleo.demo.catalogo.bean.FideicomisoBean;
import com.softtek.acceleo.demo.domain.Fideicomiso;

import com.softtek.acceleo.demo.service.FideicomisoService;

/**
 * Clase FideicomisoController.
 * @author PSG.
 *
 */
@RestController
public class FideicomisoController {

	@Autowired
	private FideicomisoService fideicomisoService;
	
	
	Fideicomiso fideicomiso = new Fideicomiso();
	/************************************** CREATE  **************************************
	 * Crea un nuevo fideicomiso.
	 * @param fideicomiso.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/fiduciarioagrupadores/fideicomiso", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_FIDEICOMISO:CREATE')")
	 public ResponseEntity<Map<String, Object>> createFideicomiso(@RequestBody FideicomisoBean fideicomisoBean, UriComponentsBuilder ucBuilder) {
	   try{
	   	
	Fideicomiso fideicomiso = new Fideicomiso();
	   	
	   		
	fideicomiso.setNumero(fideicomisoBean.getNumero());
	fideicomiso.setNombre(fideicomisoBean.getNombre());
	fideicomiso.setNumerocliente(fideicomisoBean.getNumerocliente());
	fideicomiso.setAdministrador(fideicomisoBean.getAdministrador());
	fideicomiso.setPromotor(fideicomisoBean.getPromotor());
	fideicomiso.setCaracteristicastiponegocio(fideicomisoBean.getCaracteristicas_tiponegocio());
	fideicomiso.setCaracteristicasformamanejo(fideicomisoBean.getCaracteristicas_formamanejo());
	fideicomiso.setCaracteristicasproducto(fideicomisoBean.getCaracteristicas_producto());
	fideicomiso.setCaracteristicasvalfatca(fideicomisoBean.getCaracteristicas_valfatca());
	fideicomiso.setCaracteristicasmontoapertura(fideicomisoBean.getCaracteristicas_montoapertura());
	fideicomiso.setCaracteristicasmanejomanejosubfisos(fideicomisoBean.getCaracteristicas_manejo_manejosubfisos());
	fideicomiso.setCaracteristicasmanejosujetoart151(fideicomisoBean.getCaracteristicas_manejo_sujetoart151());
	fideicomiso.setCaracteristicasmanejocerrado(fideicomisoBean.getCaracteristicas_manejo_cerrado());
	fideicomiso.setCaracteristicasmanejorevocable(fideicomisoBean.getCaracteristicas_manejo_revocable());
	fideicomiso.setCaracteristicasmanejoescontratoeje(fideicomisoBean.getCaracteristicas_manejo_escontratoeje());
	fideicomiso.setCaracteristicasmanejocomitetecnico(fideicomisoBean.getCaracteristicas_manejo_comitetecnico());
	fideicomiso.setCaracteristicasmanejoofibanxico(fideicomisoBean.getCaracteristicas_manejo_ofibanxico());
	fideicomiso.setCaracteristicasmanejomanejamonext(fideicomisoBean.getCaracteristicas_manejo_manejamonext());
	fideicomiso.setCaracteristicasmanejoivafronterizo(fideicomisoBean.getCaracteristicas_manejo_ivafronterizo());
	fideicomiso.setCaracteristicasfechafechaalta(fideicomisoBean.getCaracteristicas_fecha_fechaalta());
	fideicomiso.setCaracteristicasfechafechaconstitucion(fideicomisoBean.getCaracteristicas_fecha_fechaconstitucion());
	fideicomiso.setCaracteristicasfechafechavencimiento(fideicomisoBean.getCaracteristicas_fecha_fechavencimiento());
	fideicomiso.setCaracteristicasfechaestado(fideicomisoBean.getCaracteristicas_fecha_estado());
	fideicomiso.setAdicionalestipofideicomisotipo(fideicomisoBean.getAdicionales_tipofideicomiso_tipo());
	fideicomiso.setAdicionalestipofideicomisotipopersona(fideicomisoBean.getAdicionales_tipofideicomiso_tipopersona());
	fideicomiso.setAdicionalestipofideicomisoconactividadempresarial(fideicomisoBean.getAdicionales_tipofideicomiso_conactividadempresarial());
	fideicomiso.setAdicionalestipofideicomisopermisosre(fideicomisoBean.getAdicionales_tipofideicomiso_permisosre());
	fideicomiso.setAdicionalestipofideicomisofechapermisosre(fideicomisoBean.getAdicionales_tipofideicomiso_fechapermisosre());
	fideicomiso.setAdicionalestipofideicomisoprovsustfiduciaria(fideicomisoBean.getAdicionales_tipofideicomiso_provsustfiduciaria());
	fideicomiso.setAdicionalestipofideicomisofondosinterfaseafore(fideicomisoBean.getAdicionales_tipofideicomiso_fondosinterfaseafore());
	fideicomiso.setAdicionalestipofideicomisoregnalinvext(fideicomisoBean.getAdicionales_tipofideicomiso_regnalinvext());
	fideicomiso.setAdicionalestipofideicomisofechainscripcion(fideicomisoBean.getAdicionales_tipofideicomiso_fechainscripcion());
	fideicomiso.setAdicionalesformalizacioncontratoformalizacioncontrato(fideicomisoBean.getAdicionales_formalizacioncontrato_formalizacioncontrato());
	fideicomiso.setAdicionalesformalizacioncontratonoescritura(fideicomisoBean.getAdicionales_formalizacioncontrato_noescritura());
	fideicomiso.setAdicionalesformalizacioncontratofechaescritura(fideicomisoBean.getAdicionales_formalizacioncontrato_fechaescritura());
	fideicomiso.setAdicionalesformalizacioncontratonombrenotario(fideicomisoBean.getAdicionales_formalizacioncontrato_nombrenotario());
	fideicomiso.setAdicionalesformalizacioncontratononotario(fideicomisoBean.getAdicionales_formalizacioncontrato_nonotario());
	fideicomiso.setAdicionalesformalizacioncontratociudadnotario(fideicomisoBean.getAdicionales_formalizacioncontrato_ciudadnotario());
	fideicomiso.setAdicionalesformalizacioncontratoadministracion(fideicomisoBean.getAdicionales_formalizacioncontrato_administracion());
	fideicomiso.setAdicionalesformalizacioncontratoestadonotario(fideicomisoBean.getAdicionales_formalizacioncontrato_estadonotario());
	fideicomiso.setAdicionalesformalizacioncontratopaisnotario(fideicomisoBean.getAdicionales_formalizacioncontrato_paisnotario());
	fideicomiso.setAdicionalesformalizacioncontratofolioregistropublico(fideicomisoBean.getAdicionales_formalizacioncontrato_folioregistropublico());
	fideicomiso.setAdicionalesformalizacioncontratofechainscripcionregpublico(fideicomisoBean.getAdicionales_formalizacioncontrato_fechainscripcionregpublico());
	fideicomiso.setAdicionalesformalizacioncontratocontabilidaddelegada(fideicomisoBean.getAdicionales_formalizacioncontrato_contabilidaddelegada());
	fideicomiso.setDatosbaxicoactividadeconomica(fideicomisoBean.getDatosbaxico_actividadeconomica());
	fideicomiso.setDatosbaxicofiducuario(fideicomisoBean.getDatosbaxico_fiducuario());
	fideicomiso.setDatosbaxicosectorbancario(fideicomisoBean.getDatosbaxico_sectorbancario());
	fideicomiso.setDatosbaxicolocalidad(fideicomisoBean.getDatosbaxico_localidad());
	fideicomiso.setDatosbaxicocentroresp(fideicomisoBean.getDatosbaxico_centroresp());
	fideicomiso.setDatosbaxiconocr(fideicomisoBean.getDatosbaxico_nocr());
	fideicomiso.setDatosbaxicorfccontrato(fideicomisoBean.getDatosbaxico_rfccontrato());
	   		
	        fideicomisoService.addFideicomiso(fideicomiso);
	        
	        HttpHeaders headers = new HttpHeaders();
	        
			
			Map<String, Object> fideicomisoMAP = new HashMap<>();
			
			return new ResponseEntity<Map<String, Object>>(fideicomisoMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: " + e);
			responseHeaders.set("Message", "Fideicomiso no se puede agregar la informacion. " + e.getMessage());	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un fideicomiso.
	  * @param id.
	  * @param fideicomiso.
	  * @return ResponseEntity.
	  */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomiso/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_FIDEICOMISO:UPDATE')") 
	public ResponseEntity<Map<String, Object>> actualizarFideicomiso(
				@PathVariable("id") String id, 
				@RequestBody FideicomisoBean fideicomisoBean) {
	        
		UUID uuid = UUID.fromString(id);
	    Fideicomiso fideicomisoFound = fideicomisoService.getFideicomiso(uuid);
	         
	    if (fideicomisoFound==null) {
	    	return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	    }
	    
	   		
	fideicomiso.setNumero(fideicomisoBean.getNumero());
	fideicomiso.setNombre(fideicomisoBean.getNombre());
	fideicomiso.setNumerocliente(fideicomisoBean.getNumerocliente());
	fideicomiso.setAdministrador(fideicomisoBean.getAdministrador());
	fideicomiso.setPromotor(fideicomisoBean.getPromotor());
	fideicomiso.setCaracteristicastiponegocio(fideicomisoBean.getCaracteristicas_tiponegocio());
	fideicomiso.setCaracteristicasformamanejo(fideicomisoBean.getCaracteristicas_formamanejo());
	fideicomiso.setCaracteristicasproducto(fideicomisoBean.getCaracteristicas_producto());
	fideicomiso.setCaracteristicasvalfatca(fideicomisoBean.getCaracteristicas_valfatca());
	fideicomiso.setCaracteristicasmontoapertura(fideicomisoBean.getCaracteristicas_montoapertura());
	fideicomiso.setCaracteristicasmanejomanejosubfisos(fideicomisoBean.getCaracteristicas_manejo_manejosubfisos());
	fideicomiso.setCaracteristicasmanejosujetoart151(fideicomisoBean.getCaracteristicas_manejo_sujetoart151());
	fideicomiso.setCaracteristicasmanejocerrado(fideicomisoBean.getCaracteristicas_manejo_cerrado());
	fideicomiso.setCaracteristicasmanejorevocable(fideicomisoBean.getCaracteristicas_manejo_revocable());
	fideicomiso.setCaracteristicasmanejoescontratoeje(fideicomisoBean.getCaracteristicas_manejo_escontratoeje());
	fideicomiso.setCaracteristicasmanejocomitetecnico(fideicomisoBean.getCaracteristicas_manejo_comitetecnico());
	fideicomiso.setCaracteristicasmanejoofibanxico(fideicomisoBean.getCaracteristicas_manejo_ofibanxico());
	fideicomiso.setCaracteristicasmanejomanejamonext(fideicomisoBean.getCaracteristicas_manejo_manejamonext());
	fideicomiso.setCaracteristicasmanejoivafronterizo(fideicomisoBean.getCaracteristicas_manejo_ivafronterizo());
	fideicomiso.setCaracteristicasfechafechaalta(fideicomisoBean.getCaracteristicas_fecha_fechaalta());
	fideicomiso.setCaracteristicasfechafechaconstitucion(fideicomisoBean.getCaracteristicas_fecha_fechaconstitucion());
	fideicomiso.setCaracteristicasfechafechavencimiento(fideicomisoBean.getCaracteristicas_fecha_fechavencimiento());
	fideicomiso.setCaracteristicasfechaestado(fideicomisoBean.getCaracteristicas_fecha_estado());
	fideicomiso.setAdicionalestipofideicomisotipo(fideicomisoBean.getAdicionales_tipofideicomiso_tipo());
	fideicomiso.setAdicionalestipofideicomisotipopersona(fideicomisoBean.getAdicionales_tipofideicomiso_tipopersona());
	fideicomiso.setAdicionalestipofideicomisoconactividadempresarial(fideicomisoBean.getAdicionales_tipofideicomiso_conactividadempresarial());
	fideicomiso.setAdicionalestipofideicomisopermisosre(fideicomisoBean.getAdicionales_tipofideicomiso_permisosre());
	fideicomiso.setAdicionalestipofideicomisofechapermisosre(fideicomisoBean.getAdicionales_tipofideicomiso_fechapermisosre());
	fideicomiso.setAdicionalestipofideicomisoprovsustfiduciaria(fideicomisoBean.getAdicionales_tipofideicomiso_provsustfiduciaria());
	fideicomiso.setAdicionalestipofideicomisofondosinterfaseafore(fideicomisoBean.getAdicionales_tipofideicomiso_fondosinterfaseafore());
	fideicomiso.setAdicionalestipofideicomisoregnalinvext(fideicomisoBean.getAdicionales_tipofideicomiso_regnalinvext());
	fideicomiso.setAdicionalestipofideicomisofechainscripcion(fideicomisoBean.getAdicionales_tipofideicomiso_fechainscripcion());
	fideicomiso.setAdicionalesformalizacioncontratoformalizacioncontrato(fideicomisoBean.getAdicionales_formalizacioncontrato_formalizacioncontrato());
	fideicomiso.setAdicionalesformalizacioncontratonoescritura(fideicomisoBean.getAdicionales_formalizacioncontrato_noescritura());
	fideicomiso.setAdicionalesformalizacioncontratofechaescritura(fideicomisoBean.getAdicionales_formalizacioncontrato_fechaescritura());
	fideicomiso.setAdicionalesformalizacioncontratonombrenotario(fideicomisoBean.getAdicionales_formalizacioncontrato_nombrenotario());
	fideicomiso.setAdicionalesformalizacioncontratononotario(fideicomisoBean.getAdicionales_formalizacioncontrato_nonotario());
	fideicomiso.setAdicionalesformalizacioncontratociudadnotario(fideicomisoBean.getAdicionales_formalizacioncontrato_ciudadnotario());
	fideicomiso.setAdicionalesformalizacioncontratoadministracion(fideicomisoBean.getAdicionales_formalizacioncontrato_administracion());
	fideicomiso.setAdicionalesformalizacioncontratoestadonotario(fideicomisoBean.getAdicionales_formalizacioncontrato_estadonotario());
	fideicomiso.setAdicionalesformalizacioncontratopaisnotario(fideicomisoBean.getAdicionales_formalizacioncontrato_paisnotario());
	fideicomiso.setAdicionalesformalizacioncontratofolioregistropublico(fideicomisoBean.getAdicionales_formalizacioncontrato_folioregistropublico());
	fideicomiso.setAdicionalesformalizacioncontratofechainscripcionregpublico(fideicomisoBean.getAdicionales_formalizacioncontrato_fechainscripcionregpublico());
	fideicomiso.setAdicionalesformalizacioncontratocontabilidaddelegada(fideicomisoBean.getAdicionales_formalizacioncontrato_contabilidaddelegada());
	fideicomiso.setDatosbaxicoactividadeconomica(fideicomisoBean.getDatosbaxico_actividadeconomica());
	fideicomiso.setDatosbaxicofiducuario(fideicomisoBean.getDatosbaxico_fiducuario());
	fideicomiso.setDatosbaxicosectorbancario(fideicomisoBean.getDatosbaxico_sectorbancario());
	fideicomiso.setDatosbaxicolocalidad(fideicomisoBean.getDatosbaxico_localidad());
	fideicomiso.setDatosbaxicocentroresp(fideicomisoBean.getDatosbaxico_centroresp());
	fideicomiso.setDatosbaxiconocr(fideicomisoBean.getDatosbaxico_nocr());
	fideicomiso.setDatosbaxicorfccontrato(fideicomisoBean.getDatosbaxico_rfccontrato());
	
		fideicomiso.setFideicomisoId(fideicomisoFound.getFideicomisoId());
		fideicomisoService.editFideicomiso(fideicomiso);
		
		Map<String, Object> fideicomisoMAP = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(fideicomisoMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un fideicomiso.
	 * @param id.
	 * @return ResponseEntity<Fideicomiso>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomiso/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_FIDEICOMISO:DELETE')")  
	public ResponseEntity<Map<String, Object>> deleteFideicomiso(@PathVariable("id") String id) {
		  
		UUID uuid = UUID.fromString(id);
		Fideicomiso fideicomiso = fideicomisoService.getFideicomiso(uuid);
		if (fideicomiso == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		}
	
		try{
			fideicomisoService.deleteFideicomiso(fideicomiso);
			
			Map<String, Object> fideicomisoMAP = new HashMap<>();
			fideicomisoMAP.put("id", fideicomiso.getFideicomisoId());
	
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, Object>>(fideicomisoMAP, headers, HttpStatus.OK);
		}catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Exception", "Exception: "+e);
			responseHeaders.set("Message", "Fideicomiso no se puede eliminar debido a que esta asociado con otra entidad.");	  
			return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los fideicomisos.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Fideicomiso>.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomiso", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_FIDEICOMISO:READ')")
	public @ResponseBody  List<Map<String, Object>> getFideicomisos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
	
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
	
		List<Fideicomiso> listFideicomiso = null;
	
		if (query==null && _page == 0) {
			listFideicomiso = fideicomisoService.listFideicomisos(fideicomiso);
			rows = fideicomisoService.getTotalRows();
		} else if (query!= null){
			listFideicomiso = fideicomisoService.listFideicomisosQuery(fideicomiso, query, _page, 10);
			rows = fideicomisoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listFideicomiso = fideicomisoService.listFideicomisosPagination(fideicomiso, _page, 10);
			rows = fideicomisoService.getTotalRows();
		}
		
		List<Map<String, Object>> listFideicomisoMAP = new ArrayList<>();
		for( Fideicomiso fideicomiso : listFideicomiso ){
			Map<String, Object> fideicomisoMAP = new HashMap<>();
			fideicomisoMAP.put("id", fideicomiso.getFideicomisoId());
			fideicomisoMAP.put("numero", fideicomiso.getNumero());
			fideicomisoMAP.put("nombre", fideicomiso.getNombre());
			fideicomisoMAP.put("numerocliente", fideicomiso.getNumerocliente());
			fideicomisoMAP.put("administrador", fideicomiso.getAdministrador());
			fideicomisoMAP.put("promotor", fideicomiso.getPromotor());
			fideicomisoMAP.put("caracteristicas_tiponegocio", fideicomiso.getCaracteristicastiponegocio());
			fideicomisoMAP.put("caracteristicas_formamanejo", fideicomiso.getCaracteristicasformamanejo());
			fideicomisoMAP.put("caracteristicas_producto", fideicomiso.getCaracteristicasproducto());
			fideicomisoMAP.put("caracteristicas_valfatca", fideicomiso.getCaracteristicasvalfatca());
			fideicomisoMAP.put("caracteristicas_montoapertura", fideicomiso.getCaracteristicasmontoapertura());
			fideicomisoMAP.put("caracteristicas_manejo_manejosubfisos", fideicomiso.getCaracteristicasmanejomanejosubfisos());
			fideicomisoMAP.put("caracteristicas_manejo_sujetoart151", fideicomiso.getCaracteristicasmanejosujetoart151());
			fideicomisoMAP.put("caracteristicas_manejo_cerrado", fideicomiso.getCaracteristicasmanejocerrado());
			fideicomisoMAP.put("caracteristicas_manejo_revocable", fideicomiso.getCaracteristicasmanejorevocable());
			fideicomisoMAP.put("caracteristicas_manejo_escontratoeje", fideicomiso.getCaracteristicasmanejoescontratoeje());
			fideicomisoMAP.put("caracteristicas_manejo_comitetecnico", fideicomiso.getCaracteristicasmanejocomitetecnico());
			fideicomisoMAP.put("caracteristicas_manejo_ofibanxico", fideicomiso.getCaracteristicasmanejoofibanxico());
			fideicomisoMAP.put("caracteristicas_manejo_manejamonext", fideicomiso.getCaracteristicasmanejomanejamonext());
			fideicomisoMAP.put("caracteristicas_manejo_ivafronterizo", fideicomiso.getCaracteristicasmanejoivafronterizo());
			fideicomisoMAP.put("caracteristicas_fecha_fechaalta", fideicomiso.getCaracteristicasfechafechaalta());
			fideicomisoMAP.put("caracteristicas_fecha_fechaconstitucion", fideicomiso.getCaracteristicasfechafechaconstitucion());
			fideicomisoMAP.put("caracteristicas_fecha_fechavencimiento", fideicomiso.getCaracteristicasfechafechavencimiento());
			fideicomisoMAP.put("caracteristicas_fecha_estado", fideicomiso.getCaracteristicasfechaestado());
			fideicomisoMAP.put("adicionales_tipofideicomiso_tipo", fideicomiso.getAdicionalestipofideicomisotipo());
			fideicomisoMAP.put("adicionales_tipofideicomiso_tipopersona", fideicomiso.getAdicionalestipofideicomisotipopersona());
			fideicomisoMAP.put("adicionales_tipofideicomiso_conactividadempresarial", fideicomiso.getAdicionalestipofideicomisoconactividadempresarial());
			fideicomisoMAP.put("adicionales_tipofideicomiso_permisosre", fideicomiso.getAdicionalestipofideicomisopermisosre());
			fideicomisoMAP.put("adicionales_tipofideicomiso_fechapermisosre", fideicomiso.getAdicionalestipofideicomisofechapermisosre());
			fideicomisoMAP.put("adicionales_tipofideicomiso_provsustfiduciaria", fideicomiso.getAdicionalestipofideicomisoprovsustfiduciaria());
			fideicomisoMAP.put("adicionales_tipofideicomiso_fondosinterfaseafore", fideicomiso.getAdicionalestipofideicomisofondosinterfaseafore());
			fideicomisoMAP.put("adicionales_tipofideicomiso_regnalinvext", fideicomiso.getAdicionalestipofideicomisoregnalinvext());
			fideicomisoMAP.put("adicionales_tipofideicomiso_fechainscripcion", fideicomiso.getAdicionalestipofideicomisofechainscripcion());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_formalizacioncontrato", fideicomiso.getAdicionalesformalizacioncontratoformalizacioncontrato());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_noescritura", fideicomiso.getAdicionalesformalizacioncontratonoescritura());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_fechaescritura", fideicomiso.getAdicionalesformalizacioncontratofechaescritura());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_nombrenotario", fideicomiso.getAdicionalesformalizacioncontratonombrenotario());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_nonotario", fideicomiso.getAdicionalesformalizacioncontratononotario());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_ciudadnotario", fideicomiso.getAdicionalesformalizacioncontratociudadnotario());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_administracion", fideicomiso.getAdicionalesformalizacioncontratoadministracion());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_estadonotario", fideicomiso.getAdicionalesformalizacioncontratoestadonotario());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_paisnotario", fideicomiso.getAdicionalesformalizacioncontratopaisnotario());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_folioregistropublico", fideicomiso.getAdicionalesformalizacioncontratofolioregistropublico());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_fechainscripcionregpublico", fideicomiso.getAdicionalesformalizacioncontratofechainscripcionregpublico());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_contabilidaddelegada", fideicomiso.getAdicionalesformalizacioncontratocontabilidaddelegada());
			fideicomisoMAP.put("datosbaxico_actividadeconomica", fideicomiso.getDatosbaxicoactividadeconomica());
			fideicomisoMAP.put("datosbaxico_fiducuario", fideicomiso.getDatosbaxicofiducuario());
			fideicomisoMAP.put("datosbaxico_sectorbancario", fideicomiso.getDatosbaxicosectorbancario());
			fideicomisoMAP.put("datosbaxico_localidad", fideicomiso.getDatosbaxicolocalidad());
			fideicomisoMAP.put("datosbaxico_centroresp", fideicomiso.getDatosbaxicocentroresp());
			fideicomisoMAP.put("datosbaxico_nocr", fideicomiso.getDatosbaxiconocr());
			fideicomisoMAP.put("datosbaxico_rfccontrato", fideicomiso.getDatosbaxicorfccontrato());
			
			listFideicomisoMAP.add(fideicomisoMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());
		
		return listFideicomisoMAP;
	}
	
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un fideicomiso.
	 * @param id.
	 * @return Fideicomiso.
	 */
	@RequestMapping(value = "/fiduciarioagrupadores/fideicomiso/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_FIDEICOMISO:READ')")
	public @ResponseBody  Map<String, Object> getFideicomiso(@PathVariable("id") String id) {	        
	        Fideicomiso fideicomiso = null;
	        
	        UUID uuid = UUID.fromString(id);
	        fideicomiso = fideicomisoService.getFideicomiso(uuid);
	        
			Map<String, Object> fideicomisoMAP = new HashMap<>();
			fideicomisoMAP.put("id", fideicomiso.getFideicomisoId());
			fideicomisoMAP.put("numero", fideicomiso.getNumero());
			fideicomisoMAP.put("nombre", fideicomiso.getNombre());
			fideicomisoMAP.put("numerocliente", fideicomiso.getNumerocliente());
			fideicomisoMAP.put("administrador", fideicomiso.getAdministrador());
			fideicomisoMAP.put("promotor", fideicomiso.getPromotor());
			fideicomisoMAP.put("caracteristicas_tiponegocio", fideicomiso.getCaracteristicastiponegocio());
			fideicomisoMAP.put("caracteristicas_formamanejo", fideicomiso.getCaracteristicasformamanejo());
			fideicomisoMAP.put("caracteristicas_producto", fideicomiso.getCaracteristicasproducto());
			fideicomisoMAP.put("caracteristicas_valfatca", fideicomiso.getCaracteristicasvalfatca());
			fideicomisoMAP.put("caracteristicas_montoapertura", fideicomiso.getCaracteristicasmontoapertura());
			fideicomisoMAP.put("caracteristicas_manejo_manejosubfisos", fideicomiso.getCaracteristicasmanejomanejosubfisos());
			fideicomisoMAP.put("caracteristicas_manejo_sujetoart151", fideicomiso.getCaracteristicasmanejosujetoart151());
			fideicomisoMAP.put("caracteristicas_manejo_cerrado", fideicomiso.getCaracteristicasmanejocerrado());
			fideicomisoMAP.put("caracteristicas_manejo_revocable", fideicomiso.getCaracteristicasmanejorevocable());
			fideicomisoMAP.put("caracteristicas_manejo_escontratoeje", fideicomiso.getCaracteristicasmanejoescontratoeje());
			fideicomisoMAP.put("caracteristicas_manejo_comitetecnico", fideicomiso.getCaracteristicasmanejocomitetecnico());
			fideicomisoMAP.put("caracteristicas_manejo_ofibanxico", fideicomiso.getCaracteristicasmanejoofibanxico());
			fideicomisoMAP.put("caracteristicas_manejo_manejamonext", fideicomiso.getCaracteristicasmanejomanejamonext());
			fideicomisoMAP.put("caracteristicas_manejo_ivafronterizo", fideicomiso.getCaracteristicasmanejoivafronterizo());
			fideicomisoMAP.put("caracteristicas_fecha_fechaalta", fideicomiso.getCaracteristicasfechafechaalta());
			fideicomisoMAP.put("caracteristicas_fecha_fechaconstitucion", fideicomiso.getCaracteristicasfechafechaconstitucion());
			fideicomisoMAP.put("caracteristicas_fecha_fechavencimiento", fideicomiso.getCaracteristicasfechafechavencimiento());
			fideicomisoMAP.put("caracteristicas_fecha_estado", fideicomiso.getCaracteristicasfechaestado());
			fideicomisoMAP.put("adicionales_tipofideicomiso_tipo", fideicomiso.getAdicionalestipofideicomisotipo());
			fideicomisoMAP.put("adicionales_tipofideicomiso_tipopersona", fideicomiso.getAdicionalestipofideicomisotipopersona());
			fideicomisoMAP.put("adicionales_tipofideicomiso_conactividadempresarial", fideicomiso.getAdicionalestipofideicomisoconactividadempresarial());
			fideicomisoMAP.put("adicionales_tipofideicomiso_permisosre", fideicomiso.getAdicionalestipofideicomisopermisosre());
			fideicomisoMAP.put("adicionales_tipofideicomiso_fechapermisosre", fideicomiso.getAdicionalestipofideicomisofechapermisosre());
			fideicomisoMAP.put("adicionales_tipofideicomiso_provsustfiduciaria", fideicomiso.getAdicionalestipofideicomisoprovsustfiduciaria());
			fideicomisoMAP.put("adicionales_tipofideicomiso_fondosinterfaseafore", fideicomiso.getAdicionalestipofideicomisofondosinterfaseafore());
			fideicomisoMAP.put("adicionales_tipofideicomiso_regnalinvext", fideicomiso.getAdicionalestipofideicomisoregnalinvext());
			fideicomisoMAP.put("adicionales_tipofideicomiso_fechainscripcion", fideicomiso.getAdicionalestipofideicomisofechainscripcion());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_formalizacioncontrato", fideicomiso.getAdicionalesformalizacioncontratoformalizacioncontrato());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_noescritura", fideicomiso.getAdicionalesformalizacioncontratonoescritura());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_fechaescritura", fideicomiso.getAdicionalesformalizacioncontratofechaescritura());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_nombrenotario", fideicomiso.getAdicionalesformalizacioncontratonombrenotario());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_nonotario", fideicomiso.getAdicionalesformalizacioncontratononotario());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_ciudadnotario", fideicomiso.getAdicionalesformalizacioncontratociudadnotario());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_administracion", fideicomiso.getAdicionalesformalizacioncontratoadministracion());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_estadonotario", fideicomiso.getAdicionalesformalizacioncontratoestadonotario());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_paisnotario", fideicomiso.getAdicionalesformalizacioncontratopaisnotario());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_folioregistropublico", fideicomiso.getAdicionalesformalizacioncontratofolioregistropublico());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_fechainscripcionregpublico", fideicomiso.getAdicionalesformalizacioncontratofechainscripcionregpublico());
			fideicomisoMAP.put("adicionales_formalizacioncontrato_contabilidaddelegada", fideicomiso.getAdicionalesformalizacioncontratocontabilidaddelegada());
			fideicomisoMAP.put("datosbaxico_actividadeconomica", fideicomiso.getDatosbaxicoactividadeconomica());
			fideicomisoMAP.put("datosbaxico_fiducuario", fideicomiso.getDatosbaxicofiducuario());
			fideicomisoMAP.put("datosbaxico_sectorbancario", fideicomiso.getDatosbaxicosectorbancario());
			fideicomisoMAP.put("datosbaxico_localidad", fideicomiso.getDatosbaxicolocalidad());
			fideicomisoMAP.put("datosbaxico_centroresp", fideicomiso.getDatosbaxicocentroresp());
			fideicomisoMAP.put("datosbaxico_nocr", fideicomiso.getDatosbaxiconocr());
			fideicomisoMAP.put("datosbaxico_rfccontrato", fideicomiso.getDatosbaxicorfccontrato());
	        
			return fideicomisoMAP;
	 }
	
}
