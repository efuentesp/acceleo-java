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
@Table(name = "rol")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rolId")
	private Integer  rolId;


	@NotNull
	@Column(name = "activo") 
	private Integer activo;
	@NotNull
	@Column(name = "clave") 
	private Integer clave;
	@NotNull
	@Column(name = "nombre") 
	private String nombre;



	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	
	public Integer getActivo () {
	    return activo;  		
    }
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	public Integer getClave () {
	    return clave;  		
    }
	public void setClave(Integer clave) {
		this.clave = clave;
	}
	
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}			
