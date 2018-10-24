package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
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

	@Column(name = "fecha") 
	private Date fecha;
	
	@NotNull
	@Column(name = "estatussolicitudId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Estatussolicitud estatussolicitudId;

	@OneToOne
	@JoinColumn(name="candidatoId")
	private Candidato candidato;
	
	@OneToOne
	@JoinColumn(name="posicionId")
	private Posicion posicion;

	public Solicitud() {
	
	}
	
	public Solicitud(Integer solicitudId, Double salario, String correo,  String telefono,
			Date fecha,  Estatussolicitud estatussolicitudId, Candidato candidato, Posicion posicion
//			, Set<Candidato> candidatos
			) {
		this.solicitudId = solicitudId;
		this.salario = salario;
		this.correo = correo;
		this.telefono = telefono;
		this.fecha = fecha;
		this.estatussolicitudId = estatussolicitudId;
		this.candidato = candidato;
		this.posicion = posicion;
	}
	
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

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}	

}			
