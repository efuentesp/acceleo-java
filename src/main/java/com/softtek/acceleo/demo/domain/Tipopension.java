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
@Table(name = "tipopension")
public class Tipopension implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tipopensionId")
	private Integer  tipopensionId;


	@NotNull
	@Column(name = "clave") 
	private String clave;
	@NotNull
	@Column(name = "nombre") 
	private String nombre;



	public Integer getTipopensionId() {
		return tipopensionId;
	}

	public void setTipopensionId(Integer tipopensionId) {
		this.tipopensionId = tipopensionId;
	}

	
	public String getClave () {
	    return clave;  		
    }
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}			
