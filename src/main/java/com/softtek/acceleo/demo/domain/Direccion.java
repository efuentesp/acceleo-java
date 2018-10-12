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


	@NotNull
	@Column(name = "candidatoId") 
	private Integer candidatoId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="candidatoId")
//	@IndexColumn(name="idx")
//	private List<CandidatoId> candidatoList;

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
	//public List<Candidato> getCandidatoList () {
	//    return candidatoList;  		
    //}
	//public void setCandidatoList (List<Candidato> candidatoList) {
	//	this.candidatoList = candidatoList;
	//}
	public Integer getCandidatoId () {
	    return candidatoId;  		
    }
	public void setCandidatoId (Integer candidatoId) {
		this.candidatoId = candidatoId;
	}

}			
