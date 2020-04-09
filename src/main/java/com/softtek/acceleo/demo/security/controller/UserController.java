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
import com.softtek.acceleo.demo.domain.UserAuthority;
import com.softtek.acceleo.demo.security.repository.UserAuthorityRepository;
import com.softtek.acceleo.demo.security.service.JwtAuthenticationError;
import com.softtek.acceleo.demo.service.AuthorityService;
import com.softtek.acceleo.demo.service.UserService;



@RestController
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorityService authorityService; 
	
	@Autowired
	private UserAuthorityRepository userAuthorityRepository;
	
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

       		usrMAP.put("id", user.getIdUser().toString());
       		usrMAP.put("username", user.getUserName());
       		usrMAP.put("display_name", user.getFirstname() + " " + user.getLastname());
       		usrMAP.put("email", user.getEmail());
       		usrMAP.put("password", user.getPassword());
       		usrMAP.put("enabled", user.getEnabled().toString());
       		
       		List<Authority> lstAuthority = user.getAuthorities();       		
       		if( lstAuthority != null && !lstAuthority.isEmpty() ) {
       			usrMAP.put("roleId", lstAuthority.get(0).getIdAuthority().toString());
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
	public @ResponseBody  Map<String, String> getUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id) {
		Map<String, String> userMAP = new HashMap<>();
		
		UUID uuid = UUID.fromString(id);
		User user = userService.getUser(uuid);

		userMAP.put("username", user.getUserName());
		userMAP.put("display_name", user.getFirstname() + " " + user.getLastname());
		userMAP.put("email", user.getEmail());
		userMAP.put("password", user.getPassword());
		userMAP.put("enabled", user.getEnabled().toString());
   		
   		List<Authority> lstAuthority = user.getAuthorities();       		
   		if( lstAuthority != null && !lstAuthority.isEmpty() ) {
   			userMAP.put("roleId", lstAuthority.get(0).getIdAuthority().toString());
   		}else {
   			userMAP.put("roleId", "");
   		}
		
		return userMAP;
	}
	
    @RequestMapping(value = "/auth/users", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_USER:CREATE')")
    //public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
    public ResponseEntity<?> createUser(@RequestBody Map<String, Object> userMAP, UriComponentsBuilder ucBuilder) {
    	HttpHeaders headers = new HttpHeaders();
    	
        try {
        	System.out.println("*********************************************** enabled: " + userMAP.get("enabled"));
        	//userMAP.put("enabled", true);
        	User user = new User();
        	user.setUserName((String) userMAP.get("username"));
        	user.setPassword(passwordEncoder.encode((String) userMAP.get("password")));
        	user.setEmail((String) userMAP.get("email"));
        	user.setEnabled((Boolean) userMAP.get("enabled"));
        	user.setCreationDate(new Date());
        	
        	String[] name = ((String) userMAP.get("display_name")).split(" ");
        	if( name.length == 1 ) {
        		user.setFirstname(name[0]);
        		user.setLastname("");
        	}else if( name.length > 1 ) {
        		user.setFirstname(name[0]);
        		user.setLastname(name[1]);
        	}
        	
        	userService.addUser(user);
        	if( user != null && user.getIdUser() != null ) {
        		UUID uuid = UUID.fromString((String) userMAP.get("roleId"));        		
        		Authority authority = authorityService.getAuthority(uuid);
        		
        		UserAuthority userAuthority = new UserAuthority();
        		//userAuthority.setIdUserAuthority(UUID.randomUUID());
        		userAuthority.setIdUser(user);
        		userAuthority.setIdAuthority(authority);
        		userAuthority.setEnabled(Boolean.TRUE);
        		
        		userAuthorityRepository.addUserAuthority(userAuthority);
        		if( userAuthority.getIdUserAuthority() != null ) {
        			logger.info("IdUserAuthority: " + userAuthority.getIdUserAuthority());
        		}
        		
        	}
        	

        	headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(user.getIdUser()).toUri());
            return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);            	
        }catch(HibernateException e) {
        	//headers.set("Exception", "Exception: " + e);
        	//headers.set("Message", "User no se puede agregar la informacion. " + e.getMessage());
        	//return new ResponseEntity<User>(headers,HttpStatus.NOT_ACCEPTABLE);
        	
        	return new ResponseEntity(new JwtAuthenticationError("No se genero la informacion del User. ", 409), HttpStatus.CONFLICT);
        }catch(Exception e) {
        	//headers.set("Exception", "Exception: " + e);
        	//headers.set("Message", "User no se puede agregar la informacion. " + e.getMessage());
            //return new ResponseEntity<User>(headers,HttpStatus.NOT_ACCEPTABLE);		   	
        	
        	return new ResponseEntity(new JwtAuthenticationError("No se genero la informacion del User. ", 409), HttpStatus.CONFLICT);
        }	            
    }
    
    @RequestMapping(value = "/auth/users/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_USER:UPDATE')") 
    public ResponseEntity<?> actualizarUser(@PathVariable("id") String id, @RequestBody Map<String, Object> userMAP) {
    
    	try {
	    	UUID uuid = UUID.fromString(id);
	    	User userFound = userService.getUser(uuid);
			    
		   if( userFound == null ){
		       //return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			   return new ResponseEntity(new JwtAuthenticationError("No se actualizo la informacion del User. ", 404), HttpStatus.NOT_FOUND);
		   }
			
		   userFound.setUserName((String) userMAP.get("username"));
		   userFound.setEmail((String) userMAP.get("email"));
		   userFound.setEnabled((Boolean) userMAP.get("enabled"));
		   userFound.setModifiedDate(new Date());
		   
		   	String[] name = ((String) userMAP.get("display_name")).split(" ");
		   	if( name.length == 1 ) {
		   		userFound.setFirstname(name[0]);
		   		userFound.setLastname("");
		   	}else if( name.length > 1 ) {
		   		userFound.setFirstname(name[0]);
		   		userFound.setLastname(name[1]);
		   	}	   
		   
		   		
		   userService.editUser(userFound);
			
		   HttpHeaders headers = new HttpHeaders();
		   return new ResponseEntity<User>(userFound, headers, HttpStatus.OK);
    	}catch(HibernateException e) {
        	return new ResponseEntity(new JwtAuthenticationError("No se actualizo la informacion del User. ", 409), HttpStatus.CONFLICT);
        }catch(Exception e) {
        	return new ResponseEntity(new JwtAuthenticationError("No se actualizo la informacion del User. ", 409), HttpStatus.CONFLICT);
        }		   
	} 

	@RequestMapping(value = "/auth/users/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_USER:DELETE')")
    public ResponseEntity<User> eliminarUser(@PathVariable("id") String id) {
		
		UUID uuid = UUID.fromString(id);
		User user = userService.getUser(uuid);
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
            UUID uuid = UUID.fromString(privileges);
            
            auth.setIdAuthority(uuid);
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
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
		 
		 UUID uuid = UUID.fromString(id);
         User user = userService.getUser(uuid);
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
	    public ResponseEntity<User> actualizarUser( @RequestBody User user, @PathVariable("id") String id, @PathVariable("username") String username,  
	    		@PathVariable("privileges") String privileges, @PathVariable("flag") Boolean flag) {
	        
		 	UUID uuid = UUID.fromString(id);
	        User userFound = userService.getUser(uuid);
	         
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
                UUID uuidP = UUID.fromString(privileges);
                
                auth.setIdAuthority(uuidP);
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
		        userFound.setIdUser(user.getIdUser());
		        userFound.setPassword(user.getPassword());
		        
		        userService.editUser(userFound);
		        
		        return new ResponseEntity<User>(userFound, HttpStatus.OK);
	        }catch(Exception e) {
	        	return new ResponseEntity<User>(userFound, HttpStatus.NOT_ACCEPTABLE);
	        }
	  } 	
}
