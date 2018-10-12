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

}			
