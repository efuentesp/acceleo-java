/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Application.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class ApplicationBean {
/**
 * Clase ApplicationBean.
 * @author PSG.
 *
 */
	private Integer applicationId;

	private String code;
	private String name;

	public Integer getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	
	public String getCode () {
	    return code;  		
    }
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName () {
	    return name;  		
    }
	public void setName(String name) {
		this.name = name;
	}

}
