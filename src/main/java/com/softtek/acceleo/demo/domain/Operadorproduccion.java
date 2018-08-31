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
@Table(name = "operadorproduccion")
public class Operadorproduccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "operadorproduccionId")
	private Integer  operadorproduccionId;


	@NotNull
	@Column(name = "nombre") 
	private String nombre;
	@NotNull
	@Column(name = "numeroempleado") 
	private Integer numeroempleado;



	public Integer getOperadorproduccionId() {
		return operadorproduccionId;
	}

	public void setOperadorproduccionId(Integer operadorproduccionId) {
		this.operadorproduccionId = operadorproduccionId;
	}

	
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getNumeroempleado () {
	    return numeroempleado;  		
    }
	public void setNumeroempleado(Integer numeroempleado) {
		this.numeroempleado = numeroempleado;
	}

}			
