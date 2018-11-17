package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "evento")
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@NotNull
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			          name = "UUID", 
	                  strategy = "org.hibernate.id.UUIDGenerator", 
	                  parameters = {
	                		@Parameter( 
	                				name = "uuid_gen_strategy_class", 
	                				value = "org.hibernate.id.uuid.CustomVersionOneStrategy" 
	                		) 
					  } 
					 )
	@Column(name = "eventoId", columnDefinition = "VARBINARY(50)")
	private UUID eventoId;

	@NotNull
	private String tipoevento;
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	private UUID posicionId;
	private UUID candidatoId;
	@NotNull
	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@NotNull
	@Column(name = "responsable")
	private String responsable;
	
	@Column(name = "notas")
	private String notas;
	
	@Column(name = "fechareal")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechareal;
	
	@Column(name = "responsablereal")
	private String responsablereal;
	
	@Column(name = "feedback")
	private String feedback;
	
	@Column(name = "comentarios")
	private String comentarios;
	
	@NotNull
	private String estatusevento;

	public UUID getEventoId() {
		return eventoId;
	}

	public void setEventoId(UUID eventoId) {
		this.eventoId = eventoId;
	}
	
	public String getTipoevento () {
	    return tipoevento;
	    }
	public void setTipoevento(String tipoevento) {
		this.tipoevento = tipoevento;
	}
	public String getNombre () {
	    return nombre;
	    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public UUID getPosicionId () {
	    return posicionId;
	    }
	public void setPosicionId(UUID posicionId) {
		this.posicionId = posicionId;
	}
	public UUID getCandidatoId () {
	    return candidatoId;
	    }
	public void setCandidatoId(UUID candidatoId) {
		this.candidatoId = candidatoId;
	}
	public Date getFecha () {
	    return fecha;
	    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getResponsable () {
	    return responsable;
	    }
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getNotas () {
	    return notas;
	    }
	public void setNotas(String notas) {
		this.notas = notas;
	}
	public Date getFechareal () {
	    return fechareal;
	    }
	public void setFechareal(Date fechareal) {
		this.fechareal = fechareal;
	}
	public String getResponsablereal () {
	    return responsablereal;
	    }
	public void setResponsablereal(String responsablereal) {
		this.responsablereal = responsablereal;
	}
	public String getFeedback () {
	    return feedback;
	    }
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getComentarios () {
	    return comentarios;
	    }
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getEstatusevento () {
	    return estatusevento;
	    }
	public void setEstatusevento(String estatusevento) {
		this.estatusevento = estatusevento;
	}
}		
