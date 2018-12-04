package com.softtek.acceleo.demo.security.service;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String access_token;

    public JwtAuthenticationResponse(String token) {
        this.access_token = token;
    }

    public String getAccess_token() {
		return access_token;
	}

}
