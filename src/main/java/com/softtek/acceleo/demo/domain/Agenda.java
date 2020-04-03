package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.WhereJoinTable;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "agenda")
public class Agenda implements Serializable {

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
	@Column(name = "agendaId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID agendaId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
	@NotNull
	@Column(name = "evento")
	@JsonProperty("evento")
	private String evento;
	@NotNull
	@Column(name = "fecha")
	@JsonProperty("fecha")
	private String fecha;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;
	@NotNull
	@Column(name = "observacion")
	@JsonProperty("observacion")
	private String observacion;
	@Column(name = "concovados")
	@JsonProperty("concovados")
	private String concovados;

	public UUID getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(UUID agendaId) {
		this.agendaId = agendaId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public Subfiso getSubfisoId (){
	    return subfisoId;
	}
	public void setSubfisoId(Subfiso subfisoId) {
		this.subfisoId = subfisoId;
	}
	public String getEvento() {
	    return evento;
	}
	public void setEvento(String evento) {
	this.evento = evento;
	}
	public String getFecha() {
	    return fecha;
	}
	public void setFecha(String fecha) {
	this.fecha = fecha;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getObservacion() {
	    return observacion;
	}
	public void setObservacion(String observacion) {
	this.observacion = observacion;
	}
	public String getConcovados() {
	    return concovados;
	}
	public void setConcovados(String concovados) {
		this.concovados = concovados;
	}

	// Se crea la entidad hija (Embebidos)			


}		
