/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Solicituds. 
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

import com.softtek.acceleo.demo.catalogo.bean.SolicitudBean;
import com.softtek.acceleo.demo.domain.Solicitud;
import com.softtek.acceleo.demo.service.SolicitudService;

/**
 * Clase SolicitudController.
 * @author PSG.
 *
 */
@RestController
public class SolicitudController {

	@Autowired
	private SolicitudService solicitudService;
	
	Solicitud solicitud = new Solicitud();
	/************************************** CREATE  **************************************
	 * Crea un nuevo solicitud.
	 * @param solicitud.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/srp/solicitud", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_SOLICITUD:CREATE')")
	 public ResponseEntity<Map<String, Object>> createSolicitud(@RequestBody Solicitud solicitud,    UriComponentsBuilder ucBuilder) {
	   try{
	        solicitudService.addSolicitud(solicitud);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/solicitud/{id}").buildAndExpand(solicitud.getSolicitudId()).toUri());
	        
		        	Solicitud solicitudFound = solicitudService.getSolicitud(solicitud.getSolicitudId());
	
			Map<String, Object> solicitudMAP = new HashMap<>();
			solicitudMAP.put("id", solicitudFound.getSolicitudId());
			/*solicitudFound.setPosicionId(solicitud.getPosicionId());*/
			solicitudMAP.put("posicionId", solicitud.getPosicionId());
			/*solicitudFound.setCandidatoId(solicitud.getCandidatoId());*/
			solicitudMAP.put("candidatoId", solicitud.getCandidatoId());
			/*solicitudFound.setFecha(solicitud.getFecha());*/
			solicitudMAP.put("fecha", solicitud.getFecha());
			/*solicitudFound.setSalario(solicitud.getSalario());*/
			solicitudMAP.put("salario", solicitud.getSalario());
			/*solicitudFound.setCorreo(solicitud.getCorreo());*/
			solicitudMAP.put("correo", solicitud.getCorreo());
			/*solicitudFound.setTelefono(solicitud.getTelefono());*/
			solicitudMAP.put("telefono", solicitud.getTelefono());
			/*solicitudFound.setDireccionId(solicitud.getDireccionId());*/
			solicitudMAP.put("direccionId", solicitud.getDireccionId());
			/*solicitudFound.setTrayectoria(solicitud.getTrayectoria());*/
			solicitudMAP.put("trayectoria", solicitud.getTrayectoria());
			/*solicitudFound.setEstatussolicitud(solicitud.getEstatussolicitud());*/
			solicitudMAP.put("estatussolicitud", solicitud.getEstatussolicitud());
			
		        	return new ResponseEntity<Map<String, Object>>(solicitudMAP, headers, HttpStatus.CREATED);
	   }catch(Exception e){
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Solicitud no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un solicitud.
	  * @param id.
	  * @param solicitud.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/srp/solicitud/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_SOLICITUD:UPDATE')") 
	    public ResponseEntity<Map<String, Object>> actualizarSolicitud(
				@PathVariable("id") String id, 
				@RequestBody Solicitud solicitud) {
	        
	        UUID uuid = UUID.fromString(id);
	        Solicitud solicitudFound = solicitudService.getSolicitud(uuid);
	         
	        if (solicitudFound==null) {
	            return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
	        }
	
		solicitud.setSolicitudId(solicitudFound.getSolicitudId());
		solicitudService.editSolicitud(solicitud);
		
		Map<String, Object> solicitudMAP = new HashMap<>();
		solicitudMAP.put("id", solicitudFound.getSolicitudId());
		/*solicitudFound.setPosicionId(solicitud.getPosicionId());*/
		solicitudMAP.put("posicionId", solicitud.getPosicionId());
		/*solicitudFound.setCandidatoId(solicitud.getCandidatoId());*/
		solicitudMAP.put("candidatoId", solicitud.getCandidatoId());
		/*solicitudFound.setFecha(solicitud.getFecha());*/
		solicitudMAP.put("fecha", solicitud.getFecha());
		/*solicitudFound.setSalario(solicitud.getSalario());*/
		solicitudMAP.put("salario", solicitud.getSalario());
		/*solicitudFound.setCorreo(solicitud.getCorreo());*/
		solicitudMAP.put("correo", solicitud.getCorreo());
		/*solicitudFound.setTelefono(solicitud.getTelefono());*/
		solicitudMAP.put("telefono", solicitud.getTelefono());
		/*solicitudFound.setDireccionId(solicitud.getDireccionId());*/
		solicitudMAP.put("direccionId", solicitud.getDireccionId());
		/*solicitudFound.setTrayectoria(solicitud.getTrayectoria());*/
		solicitudMAP.put("trayectoria", solicitud.getTrayectoria());
		/*solicitudFound.setEstatussolicitud(solicitud.getEstatussolicitud());*/
		solicitudMAP.put("estatussolicitud", solicitud.getEstatussolicitud());
		
		HttpHeaders headers = new HttpHeaders();
	    return new ResponseEntity<Map<String, Object>>(solicitudMAP, headers, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un solicitud.
	 * @param id.
	 * @return ResponseEntity<Solicitud>.
	 */
	@RequestMapping(value = "/srp/solicitud/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_SOLICITUD:DELETE')")  
		    public ResponseEntity<Map<String, Object>> deleteSolicitud(@PathVariable("id") String id) {
		  
		    	 UUID uuid = UUID.fromString(id);
		         Solicitud solicitud = solicitudService.getSolicitud(uuid);
		         if (solicitud == null) {
		             return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		         }
		  
	           	 try{
		             solicitudService.deleteSolicitud(solicitud);
		             
			 Map<String, Object> solicitudMAP = new HashMap<>();
			 solicitudMAP.put("id", solicitud.getSolicitudId());
	/*solicitudFound.setPosicionId(solicitud.getPosicionId());*/
	solicitudMAP.put("posicionId", solicitud.getPosicionId());
	/*solicitudFound.setCandidatoId(solicitud.getCandidatoId());*/
	solicitudMAP.put("candidatoId", solicitud.getCandidatoId());
	/*solicitudFound.setFecha(solicitud.getFecha());*/
	solicitudMAP.put("fecha", solicitud.getFecha());
	/*solicitudFound.setSalario(solicitud.getSalario());*/
	solicitudMAP.put("salario", solicitud.getSalario());
	/*solicitudFound.setCorreo(solicitud.getCorreo());*/
	solicitudMAP.put("correo", solicitud.getCorreo());
	/*solicitudFound.setTelefono(solicitud.getTelefono());*/
	solicitudMAP.put("telefono", solicitud.getTelefono());
	/*solicitudFound.setDireccionId(solicitud.getDireccionId());*/
	solicitudMAP.put("direccionId", solicitud.getDireccionId());
	/*solicitudFound.setTrayectoria(solicitud.getTrayectoria());*/
	solicitudMAP.put("trayectoria", solicitud.getTrayectoria());
	/*solicitudFound.setEstatussolicitud(solicitud.getEstatussolicitud());*/
	solicitudMAP.put("estatussolicitud", solicitud.getEstatussolicitud());
		             
		             HttpHeaders headers = new HttpHeaders();
		             return new ResponseEntity<Map<String, Object>>(solicitudMAP, headers, HttpStatus.OK);
		         }catch (Exception e) {
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: "+e);
		        	 responseHeaders.set("Message", "Solicitud no se puede eliminar debido a que esta asociado con otra entidad.");	  
		             return new ResponseEntity<Map<String, Object>>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los solicituds.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Solicitud>.
	 */
	 
	@RequestMapping(value = "/srp/solicitud", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_SOLICITUD:READ')")
	public @ResponseBody  List<Map<String, Object>> getSolicituds(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
		       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
		
		List<Solicitud> listSolicitud = null;
		
		if (query==null && _page == 0) {
		       		listSolicitud = solicitudService.listSolicituds(solicitud);
			rows = solicitudService.getTotalRows();
		} else if (query!= null){
			listSolicitud = solicitudService.listSolicitudsQuery(solicitud, query, _page, 10);
			rows = solicitudService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listSolicitud = solicitudService.listSolicitudsPagination(solicitud, _page, 10);
			rows = solicitudService.getTotalRows();
		}
		
		List<Map<String, Object>> listSolicitudMAP = new ArrayList<>();
		for( Solicitud solicitud : listSolicitud ){
			Map<String, Object> solicitudMAP = new HashMap<>();
			solicitudMAP.put("id", solicitud.getSolicitudId());
			/*solicitudFound.setPosicionId(solicitud.getPosicionId());*/
			solicitudMAP.put("posicionId", solicitud.getPosicionId());
			/*solicitudFound.setCandidatoId(solicitud.getCandidatoId());*/
			solicitudMAP.put("candidatoId", solicitud.getCandidatoId());
			/*solicitudFound.setFecha(solicitud.getFecha());*/
			solicitudMAP.put("fecha", solicitud.getFecha());
			/*solicitudFound.setSalario(solicitud.getSalario());*/
			solicitudMAP.put("salario", solicitud.getSalario());
			/*solicitudFound.setCorreo(solicitud.getCorreo());*/
			solicitudMAP.put("correo", solicitud.getCorreo());
			/*solicitudFound.setTelefono(solicitud.getTelefono());*/
			solicitudMAP.put("telefono", solicitud.getTelefono());
			/*solicitudFound.setDireccionId(solicitud.getDireccionId());*/
			solicitudMAP.put("direccionId", solicitud.getDireccionId());
			/*solicitudFound.setTrayectoria(solicitud.getTrayectoria());*/
			solicitudMAP.put("trayectoria", solicitud.getTrayectoria());
			/*solicitudFound.setEstatussolicitud(solicitud.getEstatussolicitud());*/
			solicitudMAP.put("estatussolicitud", solicitud.getEstatussolicitud());
			
			listSolicitudMAP.add(solicitudMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listSolicitudMAP;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un solicitud.
	 * @param id.
	 * @return Solicitud.
	 */
	@RequestMapping(value = "/srp/solicitud/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_SOLICITUD:READ')")
	public @ResponseBody  Map<String, Object> getSolicitud(@PathVariable("id") String id) {	        
	        Solicitud solicitud = null;
	        
	        UUID uuid = UUID.fromString(id);
	        solicitud = solicitudService.getSolicitud(uuid);
	        
			Map<String, Object> solicitudMAP = new HashMap<>();
			solicitudMAP.put("id", solicitud.getSolicitudId());
			/*solicitudFound.setPosicionId(solicitud.getPosicionId());*/
			solicitudMAP.put("posicionId", solicitud.getPosicionId());
			/*solicitudFound.setCandidatoId(solicitud.getCandidatoId());*/
			solicitudMAP.put("candidatoId", solicitud.getCandidatoId());
			/*solicitudFound.setFecha(solicitud.getFecha());*/
			solicitudMAP.put("fecha", solicitud.getFecha());
			/*solicitudFound.setSalario(solicitud.getSalario());*/
			solicitudMAP.put("salario", solicitud.getSalario());
			/*solicitudFound.setCorreo(solicitud.getCorreo());*/
			solicitudMAP.put("correo", solicitud.getCorreo());
			/*solicitudFound.setTelefono(solicitud.getTelefono());*/
			solicitudMAP.put("telefono", solicitud.getTelefono());
			/*solicitudFound.setDireccionId(solicitud.getDireccionId());*/
			solicitudMAP.put("direccionId", solicitud.getDireccionId());
			/*solicitudFound.setTrayectoria(solicitud.getTrayectoria());*/
			solicitudMAP.put("trayectoria", solicitud.getTrayectoria());
			/*solicitudFound.setEstatussolicitud(solicitud.getEstatussolicitud());*/
			solicitudMAP.put("estatussolicitud", solicitud.getEstatussolicitud());
	        
	        
			return solicitudMAP;
	 }
	
}
