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
@Table(name = "solicitud")
public class Solicitud implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "solicitudId")
	private Integer  solicitudId;


	@NotNull
	@Column(name = "salario") 
	private Double salario;
	@NotNull
	@Column(name = "correo") 
	private String correo;
	@NotNull
	@Column(name = "telefono") 
	private String telefono;


	@NotNull
	@Column(name = "posicionId") 
	private Integer posicionId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="posicionId")
//	@IndexColumn(name="idx")
//	private List<PosicionId> posicionList;
	@NotNull
	@Column(name = "candidatoId") 
	private Integer candidatoId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="candidatoId")
//	@IndexColumn(name="idx")
//	private List<CandidatoId> candidatoList;
	@NotNull
	@Column(name = "estatussolicitudId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Estatussolicitud estatussolicitudId;
	@Column(name = "fecha") 
	private Date fecha;

	public Integer getSolicitudId() {
		return solicitudId;
	}

	public void setSolicitudId(Integer solicitudId) {
		this.solicitudId = solicitudId;
	}

	
	public Double getSalario () {
	    return salario;  		
    }
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public String getCorreo () {
	    return correo;  		
    }
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getTelefono () {
	    return telefono;  		
    }
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	//public List<Posicion> getPosicionList () {
	//    return posicionList;  		
    //}
	//public void setPosicionList (List<Posicion> posicionList) {
	//	this.posicionList = posicionList;
	//}
	public Integer getPosicionId () {
	    return posicionId;  		
    }
	public void setPosicionId (Integer posicionId) {
		this.posicionId = posicionId;
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
	public Estatussolicitud getEstatussolicitudId () {
	    return estatussolicitudId;  		
    }
	public void setEstatussolicitudId (Estatussolicitud estatussolicitudId) {
		this.estatussolicitudId = estatussolicitudId;
	}
	public Date  getFecha () {
	    return fecha;  		
    }
	public void setFecha (Date fecha) {
		this.fecha = fecha;
	}

}			
