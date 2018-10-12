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
	@NotNull
	@Column(name = "solicitudId") 
	private Integer solicitudId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="solicitudId")
//	@IndexColumn(name="idx")
//	private List<SolicitudId> solicitudList;
	@NotNull
	@Column(name = "eventoId") 
	private Integer eventoId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="eventoId")
//	@IndexColumn(name="idx")
//	private List<EventoId> eventoList;

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
	//public List<Solicitud> getSolicitudList () {
	//    return solicitudList;  		
    //}
	//public void setSolicitudList (List<Solicitud> solicitudList) {
	//	this.solicitudList = solicitudList;
	//}
	public Integer getSolicitudId () {
	    return solicitudId;  		
    }
	public void setSolicitudId (Integer solicitudId) {
		this.solicitudId = solicitudId;
	}
	//public List<Evento> getEventoList () {
	//    return eventoList;  		
    //}
	//public void setEventoList (List<Evento> eventoList) {
	//	this.eventoList = eventoList;
	//}
	public Integer getEventoId () {
	    return eventoId;  		
    }
	public void setEventoId (Integer eventoId) {
		this.eventoId = eventoId;
	}

}			
