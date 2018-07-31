/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Module.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class ModuleBean {
/**
 * Clase ModuleBean.
 * @author PSG.
 *
 */
	private Integer moduleId;

	private String code;
	private String name;
	private Integer applicationId;

	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
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
	public Integer getApplicationId () {
	    return applicationId;  		
    }
	public void setApplicationId (Integer applicationId) {
		this.applicationId = applicationId;
	}

}
