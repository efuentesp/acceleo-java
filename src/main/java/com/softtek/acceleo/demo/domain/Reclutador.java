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
@Table(name = "reclutador")
public class Reclutador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reclutadorId")
	private Integer  reclutadorId;


	@NotNull
	@Column(name = "apellidomaterno") 
	private String apellidomaterno;
	@NotNull
	@Column(name = "nombre") 
	private String nombre;
	@NotNull
	@Column(name = "apellidopaterno") 
	private String apellidopaterno;


	@NotNull
	@Column(name = "generoId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Genero generoId;

	public Integer getReclutadorId() {
		return reclutadorId;
	}

	public void setReclutadorId(Integer reclutadorId) {
		this.reclutadorId = reclutadorId;
	}

	
	public String getApellidomaterno () {
	    return apellidomaterno;  		
    }
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidopaterno () {
	    return apellidopaterno;  		
    }
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public Genero getGeneroId () {
	    return generoId;  		
    }
	public void setGeneroId (Genero generoId) {
		this.generoId = generoId;
	}

}			
