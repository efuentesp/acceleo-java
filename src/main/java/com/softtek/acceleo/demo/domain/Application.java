
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
@Table(name = "application")
public class Application implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "applicationId")
	private Integer  applicationId;


	



	@NotNull
	@Column(name = "code") 
	private String code;
	



	@NotNull
	@Column(name = "name") 
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
