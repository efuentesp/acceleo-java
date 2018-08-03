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

	private String name;
	private String code;
	private Integer applicationId;

	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	
	public String getName () {
	    return name;  		
    }
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode () {
	    return code;  		
    }
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getApplicationId () {
	    return applicationId;  		
    }
	public void setApplicationId (Integer applicationId) {
		this.applicationId = applicationId;
	}

}
