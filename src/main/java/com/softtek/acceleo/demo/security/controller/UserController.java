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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.service.UserService;



@RestController
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private UserService userService;
	
	@Autowired
    public PasswordEncoder passwordEncoder;
	
	
	
	
	@RequestMapping(value = "/auth/users", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_USER:READ')")
	//public @ResponseBody  List<User> getUsers(HttpServletRequest request, HttpServletResponse response) {
	public @ResponseBody  List<Map<String, String>> getUsers(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, String>> lstUsers = new ArrayList<>();
		
		List<User> users = userService.listUserss();       	
       	for( User user : users ) {
       		Map<String, String> usrMAP = new HashMap<>();

       		usrMAP.put("username", user.getUserName());
       		usrMAP.put("display_name", user.getFirstname() + " " + user.getLastname());
       		usrMAP.put("email", user.getEmail());
       		usrMAP.put("password", user.getPassword());
       		usrMAP.put("enabled", user.getEnabled().toString());
       		
       		List<Authority> lstAuthority = user.getAuthorities();       		
       		if( lstAuthority != null && !lstAuthority.isEmpty() ) {
       			usrMAP.put("roleId", Long.toString(lstAuthority.get(0).getIdAuthority()));
       		}else {
       			usrMAP.put("roleId", "");
       		}
       		
       		lstUsers.add(usrMAP);
       	}
       	
       	
		logger.info("Conttroller - Cantidad" + lstUsers.size());
		logger.info("Fin Conttroller - userList ");
		
		return lstUsers;
	}
	
	@RequestMapping(value = "/auth/users/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_USER:READ')")
	public @ResponseBody  Map<String, String> getUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
		Map<String, String> userMAP = new HashMap<>();
		
		User user = userService.getUser(new Long(id));

		userMAP.put("username", user.getUserName());
		userMAP.put("display_name", user.getFirstname() + " " + user.getLastname());
		userMAP.put("email", user.getEmail());
		userMAP.put("password", user.getPassword());
		userMAP.put("enabled", user.getEnabled().toString());
   		
   		List<Authority> lstAuthority = user.getAuthorities();       		
   		if( lstAuthority != null && !lstAuthority.isEmpty() ) {
   			userMAP.put("roleId", Long.toString(lstAuthority.get(0).getIdAuthority()));
   		}else {
   			userMAP.put("roleId", "");
   		}
		
		return userMAP;
	}
	
    @RequestMapping(value = "/auth/users", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_USER:CREATE')")
    public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
    	HttpHeaders headers = new HttpHeaders();
    	
        try {
        	user.setPassword(passwordEncoder.encode(user.getPassword()));
        	userService.addUser(user);

        	headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(user.getIdUser()).toUri());
            return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);            	
        }catch(HibernateException e) {
        	headers.set("Exception", "Exception: " + e);
        	headers.set("Message", "User no se puede agregar la informacion. " + e.getMessage());
        	 
            return new ResponseEntity<User>(headers,HttpStatus.NOT_ACCEPTABLE);		   	
        }catch(Exception e) {
        	headers.set("Exception", "Exception: " + e);
        	headers.set("Message", "User no se puede agregar la informacion. " + e.getMessage());
        	 
            return new ResponseEntity<User>(headers,HttpStatus.NOT_ACCEPTABLE);		   	
        }	            
    }
    
    @RequestMapping(value = "/auth/users/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_USER:UPDATE')") 
	public ResponseEntity<User> actualizarUser(@PathVariable("id") int id, @RequestBody User user) {
    	
    	User userFound = userService.getUser(new Long(id));
		    
	   if( userFound == null ){
	       return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	   }
		
	   userFound.setUserName(user.getUserName());
	   //userFound.setPassword(user.getPassword());
	   userFound.setFirstname(user.getFirstname());
	   userFound.setLastname(user.getLastname());
	   userFound.setEmail(user.getEmail());
	   userFound.setEnabled(user.getEnabled());
	   userFound.setAttemps(user.getAttemps());
	   //userFound.setLastPasswordResetDate(user.getLastPasswordResetDate());
	   userFound.setCreationDate(user.getCreationDate());
	   userFound.setModifiedDate(user.getModifiedDate());
	   		
	   userService.editUser(userFound);
		
	   HttpHeaders headers = new HttpHeaders();
	   return new ResponseEntity<User>(userFound, headers, HttpStatus.OK);
	} 

	@RequestMapping(value = "/auth/users/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_USER:DELETE')")
    public ResponseEntity<User> eliminarUser(@PathVariable("id") int id) {
		 
		User user = userService.getUser(new Long(id));
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		try {
			userService.deleteUser(user);
			
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<User>(user, headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.PRECONDITION_FAILED);
		}
		
	}
    
    
    /**
    * Crea un nuevo usuario.
    * @param afiliado.
    * @param ucBuilder.
    * @return ResponseEntity.
    */
    @RequestMapping(value = "/users/{username}/{privileges}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('MANAGESEARCH')")
        public ResponseEntity<Void> createAfiliado(@RequestBody User user, @PathVariable("username") String userName,  @PathVariable("privileges") String privileges, UriComponentsBuilder ucBuilder) {
    	HttpStatus httpStatus = null;
    	
            user.setCreationDate(new Date()); 
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setUserName(userName);
            user.setLastPasswordResetDate(new Date());
            
            List<Authority> auths = new ArrayList<>();
            Authority auth = new Authority();
            auth.setIdAuthority(new Long(privileges));
            auths.add(auth);
            
            user.setAuthorities(auths);
                
            
            try {
            	userService.addUser(user);
            	
            	httpStatus = HttpStatus.CREATED;
            }catch(HibernateException e) {
            	logger.error("---->>> Error: ", e);
            	httpStatus = HttpStatus.NOT_ACCEPTABLE;
            }catch(Exception e) {
            	logger.error("---->>> Error: ", e);
            	httpStatus = HttpStatus.NOT_ACCEPTABLE;
            }	            
     
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(user.getIdUser()).toUri());
            return new ResponseEntity<Void>(headers, httpStatus);
    }
    
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('USERDELETE')")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
		 
         User user = userService.getUser(new Long(id));
         if (user == null) {
             return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
         }
  
         try {
        	 userService.deleteUser(user);
        	 return new ResponseEntity<User>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.PRECONDITION_FAILED);
		}
		
	}
	
	 @RequestMapping(value = "/users/{id}/{username}/{privileges}/{flag}", method = RequestMethod.PUT)
	 @PreAuthorize("hasRole('MANAGESEARCH')")
	    public ResponseEntity<User> actualizarUser( @RequestBody User user, @PathVariable("id") int id, @PathVariable("username") String username,  
	    		@PathVariable("privileges") String privileges, @PathVariable("flag") Boolean flag) {
	        
	        User userFound = userService.getUser(new Long(id));
	         
	        if (userFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }

	        if (flag){
	        	String pass = passwordEncoder.encode(user.getPassword());
	        	user.setPassword(pass);
	        }
	       
	        try {
		        List<Authority> auths = new ArrayList<>();
                Authority auth = new Authority();
                auth.setIdAuthority(new Long(privileges));
                auths.add(auth);
		        
		        userFound.setAuthorities(auths);
		        userFound.setCreationDate(new Date());
		        userFound.setEmail(user.getEmail());
		        userFound.setEnabled(user.getEnabled());
		        userFound.setFirstname(user.getFirstname());
		        userFound.setLastname(user.getLastname());
		        userFound.setLastPasswordResetDate(new Date());
		        userFound.setModifiedDate(new Date());
		        userFound.setUserName(username);
		        userFound.setIdUser(new Long(user.getIdUser()));
		        userFound.setPassword(user.getPassword());
		        
		        userService.editUser(userFound);
		        
		        return new ResponseEntity<User>(userFound, HttpStatus.OK);
	        }catch(Exception e) {
	        	return new ResponseEntity<User>(userFound, HttpStatus.NOT_ACCEPTABLE);
	        }
	  } 	
}
