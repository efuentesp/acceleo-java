package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "candidato")
public class Candidato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "candidatoId")
	private Integer  candidatoId;


	@NotNull
	@Column(name = "fecha") 
	private Date fecha;
	@NotNull
	@Column(name = "apellidomaterno") 
	private String apellidomaterno;
	@NotNull
	@Column(name = "apellidopaterno") 
	private String apellidopaterno;
	@NotNull
	@Column(name = "nombre") 
	private String nombre;


	@NotNull
	@Column(name = "generoId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Genero generoId;
	@NotNull
	@Column(name = "estatuscandidatoId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Estatuscandidato estatuscandidatoId;
	
//	@ManyToMany(cascade = {CascadeType.ALL})
//	@JoinTable(name="candidatosolicitud", joinColumns={@JoinColumn(name="candidatoId")}, inverseJoinColumns={@JoinColumn(name="solicitudId")})
//	private Set<Solicitud> solicitudes=new HashSet<>();

//	@OneToOne(mappedBy = "solicitud", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
//	private Solicitud solicitud;
	
	//@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="direccionId")
//	@OneToOne(mappedBy="candidato")
//	@JoinColumn(name="direccionId")
//	private Direccion direccion;
	
//	public Candidato() {} 
//	
//	public Candidato(Integer candidatoId, Date fecha, String apellidomaterno, String apellidopaterno, String nombre, Genero generoId, Estatuscandidato estatuscandidatoId, Set<Solicitud> solicitudes) {
//		this.candidatoId = candidatoId;
//		this.nombre = nombre;
//		this.fecha = fecha;
//		this.apellidomaterno = apellidomaterno;
//		this.apellidopaterno = apellidopaterno;
//		this.generoId = generoId;
//		this.estatuscandidatoId = estatuscandidatoId;
////		this.solicitudes = solicitudes;
//	}
	
	public Integer getCandidatoId() {
		return candidatoId;
	}

	public void setCandidatoId(Integer candidatoId) {
		this.candidatoId = candidatoId;
	}

	
	public Date getFecha () {
	    return fecha;  		
    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getApellidomaterno () {
	    return apellidomaterno;  		
    }
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	
	public String getApellidopaterno () {
	    return apellidopaterno;  		
    }
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Genero getGeneroId () {
	    return generoId;  		
    }
	public void setGeneroId (Genero generoId) {
		this.generoId = generoId;
	}
	public Estatuscandidato getEstatuscandidatoId () {
	    return estatuscandidatoId;  		
    }
	public void setEstatuscandidatoId (Estatuscandidato estatuscandidatoId) {
		this.estatuscandidatoId = estatuscandidatoId;
	}

//	public Direccion getDireccion() {
//		return direccion;
//	}
//
//	public void setDireccion(Direccion direccion) {
//		this.direccion = direccion;
//	}

//	public Set<Solicitud> getSolicitudes() {
//		return solicitudes;
//	}
//
//	public void setSolicitudes(Set<Solicitud> solicitudes) {
//		this.solicitudes = solicitudes;
//	}

//	public Solicitud getSolicitud() {
//		return solicitud;
//	}
//
//	public void setSolicitud(Solicitud solicitud) {
//		this.solicitud = solicitud;
//	}

	
	
}			
