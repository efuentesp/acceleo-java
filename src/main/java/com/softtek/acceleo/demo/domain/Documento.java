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
@Table(name = "documento")
public class Documento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "documentoId")
	private Integer  documentoId;


	@NotNull
	@Column(name = "nombre") 
	private String nombre;
	@NotNull
	@Column(name = "descripcion") 
	private String descripcion;


	@Column(name = "size") 
	private Integer size;

	public Integer getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}

	
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion () {
	    return descripcion;  		
    }
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer  getSize () {
	    return size;  		
    }
	public void setSize (Integer size) {
		this.size = size;
	}

}			
