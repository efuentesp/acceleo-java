/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Customers. 
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

import com.softtek.acceleo.demo.catalogo.bean.CustomerBean;
import com.softtek.acceleo.demo.domain.Customer;
import com.softtek.acceleo.demo.service.CustomerService;

/**
 * Clase CustomerController.
 * @author PSG.
 *
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	Customer customer = new Customer();
	/************************************** CREATE  **************************************
	 * Crea un nuevo customer.
	 * @param customer.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/example/customer", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_CUSTOMER:CREATE')")
	 public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer,    UriComponentsBuilder ucBuilder) {
	   try{
	        customerService.addCustomer(customer);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getCustomerId()).toUri());
	        return new ResponseEntity<Customer>(headers, HttpStatus.CREATED);
	   }catch(Exception e){
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Customer no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Customer>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un customer.
	  * @param id.
	  * @param customer.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/example/customer/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_CUSTOMER:UPDATE')") 
	    public ResponseEntity<Customer> actualizarCustomer(
				@PathVariable("id") int id, 
				@RequestBody Customer customer) {
	        
	        Customer customerFound = customerService.getCustomer(id);
	         
	        if (customerFound==null) {
	            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	        }
	
		customerFound.setNumber(customer.getNumber());
		customerFound.setName(customer.getName());
		customerFound.setEmail(customer.getEmail());
		customerFound.setPhotologo(customer.getPhotologo());
		customerFound.setCharterdocument(customer.getCharterdocument());
		customerFound.setDateregistered(customer.getDateregistered());
		customerFound.setComments(customer.getComments());
		
		customerService.editCustomer(customerFound);	
	    return new ResponseEntity<Customer>(customerFound, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un customer.
	 * @param id.
	 * @return ResponseEntity<Customer>.
	 */
	@RequestMapping(value = "/example/customer/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_CUSTOMER:DELETE')")  
		    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id) {
		  
		//try{
		    	 
		         Customer customer = customerService.getCustomer(id);
		         if (customer == null) {
		             return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		         }
		  
	           	 try{
		             customerService.deleteCustomer(customer);
		             return new ResponseEntity<Customer>(HttpStatus.OK);
		         }catch (Exception e) {
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: "+e);
		        	 responseHeaders.set("Message", "Customer no se puede eliminar debido a que esta asociado con otra entidad.");	  
		             return new ResponseEntity<Customer>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	           	//} catch(GenericException e) {
	            //	 return new ResponseEntity<Customer>(HttpStatus.PRECONDITION_FAILED);
	            //}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los customers.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Customer>.
	 */
	 
	@RequestMapping(value = "/example/customer", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_CUSTOMER:READ')")
	public @ResponseBody  List<Customer> getCustomers(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
		       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
		
		List<Customer> listCustomer = null;
		
		if (query==null && _page == 0) {
		       		listCustomer = customerService.listCustomers(customer);
			rows = customerService.getTotalRows();
		} else if (query!= null){
			listCustomer = customerService.listCustomersQuery(customer, query, _page, 10);
			rows = customerService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listCustomer = customerService.listCustomersPagination(customer, _page, 10);
			rows = customerService.getTotalRows();
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listCustomer;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un customer.
	 * @param id.
	 * @return Customer.
	 */
	@RequestMapping(value = "/example/idcustomer/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_CUSTOMER:READ')")
	    public @ResponseBody  Customer getCustomer(@PathVariable("id") int id) {	        
	        Customer customer = null;
	        
	        customer = customerService.getCustomer(id);
			return customer;
	 }
	
}
