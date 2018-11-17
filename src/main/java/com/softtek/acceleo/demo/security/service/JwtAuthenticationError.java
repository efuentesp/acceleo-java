package com.softtek.acceleo.demo.security.service;

import java.io.Serializable;

public class JwtAuthenticationError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 95453012352018012L;

    private final String message;
    private final int status;
    //private final HttpStatus status;

    public JwtAuthenticationError(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }	

    public int getStatus() {
    	return this.status;
    }	
}
