package com.softtek.acceleo.demo.security.controller;

import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.security.JwtAuthenticationRequest;
import com.softtek.acceleo.demo.security.JwtTokenUtil;
import com.softtek.acceleo.demo.security.JwtUser;
import com.softtek.acceleo.demo.security.exception.AuthenticationException;
import com.softtek.acceleo.demo.security.service.JwtAuthenticationError;
import com.softtek.acceleo.demo.security.service.JwtAuthenticationResponse;
import com.softtek.acceleo.demo.service.UserService;

@RestController
@PropertySource("application.properties")
public class AuthenticationRestController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final int HTTP_STATUS_UNAUTHORIZED = 401;
	private final int CERO = 0;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserService userService;         

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)    
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

    	logger.info("Enter createAuthenticationToken");
        try {
	    	List<User> lstUser = userService.consultarUserPorEmail(authenticationRequest.getEmail());
	    	
	    	if( lstUser.isEmpty() || lstUser.get(CERO).getAuthorities().isEmpty() ) {
	    		logger.info("Incorrect email or password");
	    		
	    		return new ResponseEntity(new JwtAuthenticationError("Incorrect email or password", HTTP_STATUS_UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
	    	}else {
		        //authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
	    		//authenticate(lstUser.get(CERO).getUserName(), authenticationRequest.getPassword());
		
		    	logger.info("Out authenticate");
		
		        // Reload password post-security so we can generate the token
		    	final UserDetails userDetails = userDetailsService.loadUserByUsername(lstUser.get(CERO).getUserName());
		    	final String token = jwtTokenUtil.generateToken(lstUser.get(CERO));
		
		        // Return the token
		        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
	    	}
        }catch(AuthenticationException e) {
        	logger.error("error", e);
    		return new ResponseEntity(new JwtAuthenticationError("Incorrect email or password", HTTP_STATUS_UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
    	}catch(UsernameNotFoundException e) {
    		logger.error("error", e);
    		return new ResponseEntity(new JwtAuthenticationError("Incorrect email or password", HTTP_STATUS_UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
    	}
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    /**
     * Authenticates the user. If something is wrong, an {@link AuthenticationException} will be thrown
     */
    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        logger.info("username: "+username);
        logger.info("Password: "+password);

        try {
        	logger.info("Before authenticationManager");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        	logger.info("After authenticationManager");

        } catch (DisabledException e) {
            throw new AuthenticationException("User is disabled!", e);
        } catch (BadCredentialsException e) {
        	e.printStackTrace();
            throw new AuthenticationException("Bad credentials!", e);
        }
    }
}
