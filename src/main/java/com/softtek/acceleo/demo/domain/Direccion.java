package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "direccionId")
	private Integer  direccionId;


	@NotNull
	@Column(name = "estado") 
	private String estado;
	@NotNull
	@Column(name = "cp") 
	private String cp;
	@NotNull
	@Column(name = "ciudad") 
	private String ciudad;
	@NotNull
	@Column(name = "calle") 
	private String calle;

	//@OneToOne(mappedBy="direccion")
	//@JoinColumn(name="candidatoId")
	@OneToOne
	@JoinColumn(name="candidatoId")
	private Candidato candidato;


	public Integer getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}

	
	public String getEstado () {
	    return estado;  		
    }
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCp () {
	    return cp;  		
    }
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	public String getCiudad () {
	    return ciudad;  		
    }
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getCalle () {
	    return calle;  		
    }
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}


	
	

}			
