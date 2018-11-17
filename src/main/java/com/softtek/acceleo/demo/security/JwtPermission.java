package com.softtek.acceleo.demo.security;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtPermission {

	@JsonIgnore
	private Long id;
//	private String id;
	
	private String code;
	
	private String description;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
