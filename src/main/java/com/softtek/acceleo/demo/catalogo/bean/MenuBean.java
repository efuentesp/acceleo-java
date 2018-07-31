/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Menu.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class MenuBean {
/**
 * Clase MenuBean.
 * @author PSG.
 *
 */
	private Integer menuId;

	private String path;
	private String code;
	private Integer moduleId;

	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
	public String getPath () {
	    return path;  		
    }
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getCode () {
	    return code;  		
    }
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getModuleId () {
	    return moduleId;  		
    }
	public void setModuleId (Integer moduleId) {
		this.moduleId = moduleId;
	}

}
