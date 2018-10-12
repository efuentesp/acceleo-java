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
@Table(name = "puesto")
public class Puesto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "puestoId")
	private Integer  puestoId;


	@NotNull
	@Column(name = "descripcion") 
	private String descripcion;


	@NotNull
	@Column(name = "puestosId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Puestos puestosId;

	public Integer getPuestoId() {
		return puestoId;
	}

	public void setPuestoId(Integer puestoId) {
		this.puestoId = puestoId;
	}

	
	public String getDescripcion () {
	    return descripcion;  		
    }
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Puestos getPuestosId () {
	    return puestosId;  		
    }
	public void setPuestosId (Puestos puestosId) {
		this.puestosId = puestosId;
	}

}			
