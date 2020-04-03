package com.softtek.acceleo.demo.security.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.UserAuthority;
import com.softtek.acceleo.demo.security.repository.AuthorityPrivilegeRepository;
import com.softtek.acceleo.demo.security.repository.UserAuthorityRepository;
import com.softtek.acceleo.demo.service.AuthorityService;

@RestController
public class AuthorityController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private AuthorityPrivilegeRepository authorityPrivilegeRepository;
	
	@Autowired
	private UserAuthorityRepository userAuthorityRepository;
	
	Authority authority = new Authority();
	
	@RequestMapping(value = "/auth/roles", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_PERMISSION:READ')")
	public @ResponseBody  List<Map<String, Object>> getAuthoritys(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Authority> listAuthority = null;

		if (query==null && _page == 0 ) {
			listAuthority = authorityService.listAuthoritys();
			rows = authorityService.getTotalRows();
		} else if (query!= null){
				listAuthority = authorityService.listAuthorityssQuery(authority, query, _page, 10);
				rows = authorityService.getTotalRowsSearch(query);
			
		} else if (_page != 0){
			listAuthority = authorityService.listAuthoritysPagination(authority, _page, 10);
			rows = authorityService.getTotalRows();
		} 	
		
		List<Map<String, Object>> lstRoles = new ArrayList();
		for( Authority authority : listAuthority ) {
			Map<String, Object> authorityMAP = new HashMap<>();
			
			authorityMAP.put("id", authority.getIdAuthority());//Esta linea es la que se debe poner
			authorityMAP.put("name", authority.getName());
			authorityMAP.put("description", authority.getName());
			authorityMAP.put("enabled", authority.getEnabled());
			
			lstRoles.add(authorityMAP);
		}
		
		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());

		return lstRoles;
	}
	
	@RequestMapping(value = "/auth/roles/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAuthority(@PathVariable("id") String id) {
        
		UUID uuid = UUID.fromString(id);
        Authority authority = authorityService.getAuthority(uuid);

		Map<String, Object> authorityMAP = new HashMap<>();
		authorityMAP.put("name", authority.getName());
		authorityMAP.put("description", authority.getName());
		authorityMAP.put("enabled", authority.getEnabled());
        
        
		return authorityMAP;
	}
	
	 @RequestMapping(value = "/auth/roles", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_PERMISSION:CREATE')")
	 public ResponseEntity<Authority> createAuthority(@RequestBody Authority authority,    UriComponentsBuilder ucBuilder) {
		 HttpHeaders headers = new HttpHeaders();
		 
		 try {
			 if( authority.getCreationDate() == null ) {
				authority.setCreationDate(new Date());
			 }
	         authorityService.addAuthority(authority);
	 
	         headers.setLocation(ucBuilder.path("/authority/{id}").buildAndExpand(authority.getIdAuthority()).toUri());	         
	         return new ResponseEntity<Authority>(authority, headers, HttpStatus.CREATED);			 
		 }catch(HibernateException e) {
	        	headers.set("Exception", "Exception: " + e);
	        	headers.set("Message", "Authority no se puede agregar la informacion. " + e.getMessage());
	        	 
	            return new ResponseEntity<Authority>(headers,HttpStatus.NOT_ACCEPTABLE);		   	
        }catch(Exception e) {
        	headers.set("Exception", "Exception: " + e);
        	headers.set("Message", "authority no se puede agregar la informacion. " + e.getMessage());
        	 
            return new ResponseEntity<Authority>(headers,HttpStatus.NOT_ACCEPTABLE);		   	
        }
		 
	 }
	 
	 @RequestMapping(value = "/auth/roles/{id}", method = RequestMethod.PUT)
	 @PreAuthorize("hasRole('ROLE_PERMISSION:UPDATE')")
	 public ResponseEntity<Authority> actualizarAuthority(@PathVariable("id") String id, @RequestBody Authority authority) {
		
		UUID uuid = UUID.fromString(id); 
        Authority authorityFound = authorityService.getAuthority(uuid);
        if( authorityFound == null ) {
            return new ResponseEntity<Authority>(HttpStatus.NOT_FOUND);
        }
        
    	//authorityFound.setIdAuthority(authority.getIdAuthority());
    	authorityFound.setName(authority.getName());
    	authorityFound.setEnabled(authority.getEnabled());
    	authorityFound.setCreationDate(new Date());
    	authorityFound.setModifiedDate(new Date());
        
        authorityService.editAuthority(authorityFound);
        
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Authority>(authorityFound, headers, HttpStatus.OK);
	 }
	 
	@RequestMapping(value = "/auth/roles/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_PERMISSION:DELETE')")
	public ResponseEntity<Authority> deleteAuthority(@PathVariable("id") String id) {
	 
		UUID uuid = UUID.fromString(id);
		Authority authority = authorityService.getAuthority(uuid);
		
		if (authority == null) {
			return new ResponseEntity<Authority>(HttpStatus.NOT_FOUND);
		}else {
		    try {
		    	/**Antes de borrar un authority, se debe validar que no este asociado a usuarios. **/
		    	List<UserAuthority> lstUserAuthority = userAuthorityRepository.findUserAuthorityByIdAuthority(authority);
		 
		    	if( lstUserAuthority == null || lstUserAuthority.isEmpty() ) {
		    		authorityPrivilegeRepository.deleteAuthorities(authority);
			 
		    		authorityService.deleteAuthority(authority);
		    		
		    		HttpHeaders headers = new HttpHeaders();
		    		return new ResponseEntity<Authority>(authority, headers, HttpStatus.OK);		        		 
		    	}else {
		    		logger.error("Error: El Authority no se puede eliminar debido a que esta asociado con usuarios.");
		    		throw new Exception("El Authority no se puede eliminar debido a que esta asociado con usuarios");
		    	}
		    } catch (Exception e) {
		    	logger.error("Error: ", e);
				return new ResponseEntity<Authority>(HttpStatus.PRECONDITION_FAILED);
			}
		}			
	}
	 
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
	
	@PreAuthorize("hasRole('AUTHORITYSEARCH')")
	@RequestMapping(value = "/authority/catalog", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<Authority> getAuthoritysCatalog(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	
		List<Authority> listAuthority = null;

       	listAuthority = authorityService.listAuthorityss(authority);	

		return listAuthority;
	}
	
}


