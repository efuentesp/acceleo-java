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
@Table(name = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empresaId")
	private Integer  empresaId;


	@NotNull
	@Column(name = "clave") 
	private String clave;
	@NotNull
	@Column(name = "nombrecorto") 
	private String nombrecorto;
	@NotNull
	@Column(name = "razonsocial") 
	private String razonsocial;



	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	
	public String getClave () {
	    return clave;  		
    }
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getNombrecorto () {
	    return nombrecorto;  		
    }
	public void setNombrecorto(String nombrecorto) {
		this.nombrecorto = nombrecorto;
	}
	
	public String getRazonsocial () {
	    return razonsocial;  		
    }
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

}			
