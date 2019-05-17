/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los PurchaseOrders. 
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

import com.softtek.acceleo.demo.catalogo.bean.PurchaseorderBean;
import com.softtek.acceleo.demo.domain.Purchaseorder;
import com.softtek.acceleo.demo.service.PurchaseorderService;

/**
 * Clase PurchaseorderController.
 * @author PSG.
 *
 */
@RestController
public class PurchaseorderController {

	@Autowired
	private PurchaseorderService purchaseorderService;
	
	Purchaseorder purchaseorder = new Purchaseorder();
	/************************************** CREATE  **************************************
	 * Crea un nuevo purchaseorder.
	 * @param purchaseorder.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/example/purchaseorder", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_PURCHASEORDER:CREATE')")
	 public ResponseEntity<Purchaseorder> createPurchaseorder(@RequestBody Purchaseorder purchaseorder,    UriComponentsBuilder ucBuilder) {
	   try{
	        purchaseorderService.addPurchaseorder(purchaseorder);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/purchaseorder/{id}").buildAndExpand(purchaseorder.getPurchaseorderId()).toUri());
	        return new ResponseEntity<Purchaseorder>(headers, HttpStatus.CREATED);
	   }catch(Exception e){
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: " + e);
		        	 responseHeaders.set("Message", "Purchaseorder no se puede agregar la informacion. " + e.getMessage());	  
		             return new ResponseEntity<Purchaseorder>(responseHeaders,HttpStatus.CONFLICT);		   	
	   }
	 }
	/************************************** UPDATE **************************************
	  * Actualiza la informacion de un purchaseorder.
	  * @param id.
	  * @param purchaseorder.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/example/purchaseorder/{id}", method = RequestMethod.PUT)
		 	 @PreAuthorize("hasRole('ROLE_PURCHASEORDER:UPDATE')") 
	    public ResponseEntity<Purchaseorder> actualizarPurchaseorder(
				@PathVariable("id") int id, 
				@RequestBody Purchaseorder purchaseorder) {
	        
	        Purchaseorder purchaseorderFound = purchaseorderService.getPurchaseorder(id);
	         
	        if (purchaseorderFound==null) {
	            return new ResponseEntity<Purchaseorder>(HttpStatus.NOT_FOUND);
	        }
	
		purchaseorderFound.setNumber(purchaseorder.getNumber());
		purchaseorderFound.setTotalamount(purchaseorder.getTotalamount());
		purchaseorderFound.setTotalweight(purchaseorder.getTotalweight());
		purchaseorderFound.setTotalitems(purchaseorder.getTotalitems());
		
		purchaseorderService.editPurchaseorder(purchaseorderFound);	
	    return new ResponseEntity<Purchaseorder>(purchaseorderFound, HttpStatus.OK);
	  } 
	/************************************** DELETE **************************************
	 * Elimina un purchaseorder.
	 * @param id.
	 * @return ResponseEntity<Purchaseorder>.
	 */
	@RequestMapping(value = "/example/purchaseorder/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_PURCHASEORDER:DELETE')")  
		    public ResponseEntity<Purchaseorder> deletePurchaseorder(@PathVariable("id") int id) {
		  
		//try{
		    	 
		         Purchaseorder purchaseorder = purchaseorderService.getPurchaseorder(id);
		         if (purchaseorder == null) {
		             return new ResponseEntity<Purchaseorder>(HttpStatus.NOT_FOUND);
		         }
		  
	           	 try{
		             purchaseorderService.deletePurchaseorder(purchaseorder);
		             return new ResponseEntity<Purchaseorder>(HttpStatus.OK);
		         }catch (Exception e) {
		        	 HttpHeaders responseHeaders = new HttpHeaders();
		        	 responseHeaders.set("Exception", "Exception: "+e);
		        	 responseHeaders.set("Message", "Purchaseorder no se puede eliminar debido a que esta asociado con otra entidad.");	  
		             return new ResponseEntity<Purchaseorder>(responseHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	           	//} catch(GenericException e) {
	            //	 return new ResponseEntity<Purchaseorder>(HttpStatus.PRECONDITION_FAILED);
	            //}
	}
	/************************************** SEARCH **************************************
	 * Obtiene informacion de los purchaseorders.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Purchaseorder>.
	 */
	 
	@RequestMapping(value = "/example/purchaseorder", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_PURCHASEORDER:READ')")
	public @ResponseBody  List<Purchaseorder> getPurchaseorders(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		
		       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;
		
		List<Purchaseorder> listPurchaseorder = null;
		
		if (query==null && _page == 0) {
		       		listPurchaseorder = purchaseorderService.listPurchaseorders(purchaseorder);
			rows = purchaseorderService.getTotalRows();
		} else if (query!= null){
			listPurchaseorder = purchaseorderService.listPurchaseordersQuery(purchaseorder, query, _page, 10);
			rows = purchaseorderService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listPurchaseorder = purchaseorderService.listPurchaseordersPagination(purchaseorder, _page, 10);
			rows = purchaseorderService.getTotalRows();
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	
		
		return listPurchaseorder;
	}
		
	/************************************** SEARCH **************************************
	 * Obtiene informacion de un purchaseorder.
	 * @param id.
	 * @return Purchaseorder.
	 */
	@RequestMapping(value = "/example/idpurchaseorder/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_PURCHASEORDER:READ')")
	    public @ResponseBody  Purchaseorder getPurchaseorder(@PathVariable("id") int id) {	        
	        Purchaseorder purchaseorder = null;
	        
	        purchaseorder = purchaseorderService.getPurchaseorder(id);
			return purchaseorder;
	 }
	
}
