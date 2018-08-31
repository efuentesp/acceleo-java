/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Clientes. 
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

import com.softtek.acceleo.demo.catalogo.bean.ClienteBean;
import com.softtek.acceleo.demo.domain.Cliente;
import com.softtek.acceleo.demo.service.ClienteService;

/**
 * Clase ClienteController.
 * @author PSG.
 *
 */
@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	Cliente cliente = new Cliente();

	/************************************** SEARCH
	 * Obtiene informacion de los clientes.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Cliente>.
	 */
	@RequestMapping(value = "/cliente", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('CLIENTESEARCH')")
	public @ResponseBody  List<Cliente> getClientes(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Cliente> listCliente = null;

		if (query==null && _page == 0) {
       		listCliente = clienteService.listClientes(cliente);
			rows = clienteService.getTotalRows();
		} else if (query!= null){
			listCliente = clienteService.listClientesQuery(cliente, query, _page, 10);
			rows = clienteService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listCliente = clienteService.listClientesPagination(cliente, _page, 10);
			rows = clienteService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listCliente;
	}

	/************************************* SEARCH
	 * Obtiene informacion de un cliente.
	 * @param id.
	 * @return Cliente.
	 */
	@RequestMapping(value = "/idcliente/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('CLIENTESEARCH')")
	    public @ResponseBody  Cliente getCliente(@PathVariable("id") int id) {	        
	        Cliente cliente = null;
	        
	        cliente = clienteService.getCliente(id);
			return cliente;
	 }

	/*************************** CREATE
	 * Crea un nuevo cliente.
	 * @param cliente.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/cliente", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('CLIENTECREATE')")
	    public ResponseEntity<Void> createCliente(@RequestBody Cliente cliente,    UriComponentsBuilder ucBuilder) {
	   
	        clienteService.addCliente(cliente);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/cliente/{id}").buildAndExpand(cliente.getClienteId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /****************************************** UPDATE
	  * Actualiza la informacion de un cliente.
	  * @param id.
	  * @param cliente.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
 	 @PreAuthorize("hasRole('CLIENTEUPDATE')") 
	    public ResponseEntity<Cliente> actualizarCliente(
				@PathVariable("id") int id, 
				@RequestBody Cliente cliente) {
	        
	        Cliente clienteFound = clienteService.getCliente(id);
	         
	        if (clienteFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
	        }
	
	clienteFound.setNombre(cliente.getNombre());
	clienteFound.setClave(cliente.getClave());
	clienteFound.setClienteId(cliente.getClienteId());
//	clienteFound.setEtiquetaasignadaId(cliente.getEtiquetaasignadaId());
//	clienteFound.setOrdensimplificadaId(cliente.getOrdensimplificadaId());
	clienteFound.setClienteId(cliente.getClienteId());

		    clienteService.editCliente(clienteFound);
	        return new ResponseEntity<Cliente>(clienteFound, HttpStatus.OK);
	  } 	
	
		/********************************** DELETE
		 * Elimina un cliente.
		 * @param id.
		 * @return ResponseEntity<Cliente>.
		 */
		@RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('CLIENTEDELETE')")  
	    public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") int id) {
			  
			//try{
	    	 
	         Cliente cliente = clienteService.getCliente(id);
	         if (cliente == null) {
	             return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
	         }
	  
           	 try{
	             clienteService.deleteCliente(cliente);
	             return new ResponseEntity<Cliente>(HttpStatus.OK);
	         }catch (Exception e) {
	        	 HttpHeaders responseHeaders = new HttpHeaders();
	        	 responseHeaders.set("Exception", "Exception: "+e);
	        	 responseHeaders.set("Message", "Cliente no se puede eliminar debido a que esta asociado con otra entidad.");	  
	             return new ResponseEntity<Cliente>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
			}

           	//} catch(GenericException e) {
            //	 return new ResponseEntity<Cliente>(HttpStatus.PRECONDITION_FAILED);
            //}
		}

	/**
	 * Salva informacion de un cliente.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveCliente", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CLIENTE')")  
	public @ResponseBody String saveCliente(
			@ModelAttribute("command") ClienteBean clienteBean) {

		Cliente cliente = prepareModel(clienteBean);
		clienteService.addCliente(cliente);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un cliente.
	 * @param clienteBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editCliente", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CLIENTE')")  
	public @ResponseBody String editCliente(
			@ModelAttribute("command") ClienteBean clienteBean) {


		Cliente cliente = prepareModel(clienteBean);
		clienteService.editCliente(cliente);
		return "SUCCESS";
	}

	/**
	 * Agrega un CLIENTE.
	 * @param CLIENTEBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchCliente", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CLIENTE')")  
	public ModelAndView addCliente(
			@ModelAttribute("command") ClienteBean clienteBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Cliente cliente = null;
		if (clienteBean != null)
			cliente = prepareModel(clienteBean);
		model.put("clientes",
				prepareListofBean(clienteService.listClientes(cliente)));
		return new ModelAndView("searchCliente", model);
	}

	/**
	 * Elimina un cliente.
	 * @param clienteBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteCliente", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CLIENTE')")  
	public ModelAndView deleteCliente(
			@ModelAttribute("command") ClienteBean clienteBean,
			BindingResult result) {
		System.out.println("delete " + clienteBean.getClienteId());
		clienteService.deleteCliente(prepareModel(clienteBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cliente", null);
		model.put("clientes",
				prepareListofBean(clienteService.listClientes(null)));
		return new ModelAndView("searchCliente", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryCliente", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CLIENTE')")  
	public ModelAndView entryCliente() {
		return new ModelAndView("redirect:/searchCliente");
	}

	private Cliente prepareModel(ClienteBean clienteBean) {
		Cliente cliente = new Cliente();

		//cliente.setHIntegerId(clienteBean.getClaveId());
		//cliente.setSociedadId(clienteBean.getSociedadId());
		//cliente.setEsId(clienteBean.getEsId());
		//cliente.setTieneId(clienteBean.getTieneId());
		//cliente.setDisplayresultclienteId(clienteBean.getClienteId());
		//cliente.setExposedfilterclienteId(clienteBean.getClienteId());
		//cliente.setDisplaymodalclienteId(clienteBean.getClienteId());
		//cliente.setEntitynameclienteId(clienteBean.getClienteId());
		//cliente.setScaffoldclienteId(clienteBean.getClienteId());
		cliente.setNombre(clienteBean.getNombre());
		cliente.setClienteId(clienteBean.getClienteId());
		clienteBean.setClienteId(null);

		return cliente;
	}

	/**
	 * Convierte un objeto de tipo ClienteBean a un objeto de tipo Cliente.
	 * @param clienteBean.
	 * @return Cliente.
	 */
	private List<ClienteBean> prepareListofBean(List<Cliente> clientes) {
		List<ClienteBean> beans = null;
		if (clientes != null && !clientes.isEmpty()) {
			beans = new ArrayList<ClienteBean>();
			ClienteBean bean = null;
			for (Cliente cliente : clientes) {
				bean = new ClienteBean();

				//bean.setSociedadId(cliente.getSociedadId());
				//bean.setEsId(cliente.getEsId());
				//bean.setTieneId(cliente.getTieneId());
				//bean.setDisplayresultclienteId(cliente.getClienteId());
				//bean.setExposedfilterclienteId(cliente.getClienteId());
				//bean.setDisplaymodalclienteId(cliente.getClienteId());
				//bean.setEntitynameclienteId(cliente.getClienteId());
				//bean.setScaffoldclienteId(cliente.getClienteId());
				bean.setNombre(cliente.getNombre());
				bean.setClienteId(cliente.getClienteId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


