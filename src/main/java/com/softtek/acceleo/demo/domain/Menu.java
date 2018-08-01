
package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "menuId")
	private Integer  menuId;


	



	@NotNull
	@Column(name = "path") 
	private String path;
	



	@NotNull
	@Column(name = "code") 
	private String code;


	@NotNull
	@Column(name = "moduleId") 
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
