package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "evento")
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "eventoId")
	private Integer  eventoId;


	@NotNull
	@Column(name = "responsable") 
	private String responsable;
	@NotNull
	@Column(name = "fecha") 
	private Date fecha;
	@NotNull
	@Column(name = "nombre") 
	private String nombre;


	@NotNull
	@Column(name = "tipoeventoId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipoevento tipoeventoId;
	
	@OneToOne
	@JoinColumn(name = "posicionId")
	private Posicion posicion;
	
	@OneToOne
	@JoinColumn(name = "candidatoId")
	private Candidato candidato;
	
	@NotNull
	@Column(name = "estatuseventoId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Estatusevento estatuseventoId;
	@Column(name = "feedback") 
	private String feedback;
	@Column(name = "responsablereal") 
	private String responsablereal;
	@Column(name = "fechareal") 
	private Date fechareal;
	@Column(name = "comentarios") 
	private String comentarios;
	@Column(name = "notas") 
	private String notas;

	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	
	public String getResponsable () {
	    return responsable;  		
    }
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	public Date getFecha () {
	    return fecha;  		
    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tipoevento getTipoeventoId () {
	    return tipoeventoId;  		
    }
	public void setTipoeventoId (Tipoevento tipoeventoId) {
		this.tipoeventoId = tipoeventoId;
	}

	public Estatusevento getEstatuseventoId () {
	    return estatuseventoId;  		
    }
	public void setEstatuseventoId (Estatusevento estatuseventoId) {
		this.estatuseventoId = estatuseventoId;
	}
	public String  getFeedback () {
	    return feedback;  		
    }
	public void setFeedback (String feedback) {
		this.feedback = feedback;
	}
	public String  getResponsablereal () {
	    return responsablereal;  		
    }
	public void setResponsablereal (String responsablereal) {
		this.responsablereal = responsablereal;
	}
	public Date  getFechareal () {
	    return fechareal;  		
    }
	public void setFechareal (Date fechareal) {
		this.fechareal = fechareal;
	}
	public String  getComentarios () {
	    return comentarios;  		
    }
	public void setComentarios (String comentarios) {
		this.comentarios = comentarios;
	}
	public String  getNotas () {
	    return notas;  		
    }
	public void setNotas (String notas) {
		this.notas = notas;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

}			
