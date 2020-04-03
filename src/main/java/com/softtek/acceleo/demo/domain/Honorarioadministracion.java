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
@Table(name = "honorarioadministracion")
public class Honorarioadministracion implements Serializable {

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
	@Column(name = "honorarioadministracionId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID honorarioadministracionId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JsonProperty("periodo")
	private String periodo;
	@NotNull
	@Column(name = "montopatrimonio")
	@JsonProperty("montopatrimonio")
	private String montopatrimonio;
	@NotNull
	@Column(name = "de")
	@JsonProperty("de")
	private String de;
	@NotNull
	@Column(name = "destinatario")
	@JsonProperty("destinatario")
	private String destinatario;
	@NotNull
	@Column(name = "honorarioatual")
	@JsonProperty("honorarioatual")
	private String honorarioatual;
	@NotNull
	@Column(name = "cuotaminima")
	@JsonProperty("cuotaminima")
	private String cuotaminima;

	public UUID getHonorarioadministracionId() {
		return honorarioadministracionId;
	}

	public void setHonorarioadministracionId(UUID honorarioadministracionId) {
		this.honorarioadministracionId = honorarioadministracionId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getPeriodo(){
	    return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getMontopatrimonio() {
	    return montopatrimonio;
	}
	public void setMontopatrimonio(String montopatrimonio) {
	this.montopatrimonio = montopatrimonio;
	}
	public String getDe() {
	    return de;
	}
	public void setDe(String de) {
	this.de = de;
	}
	public String getDestinatario() {
	    return destinatario;
	}
	public void setDestinatario(String destinatario) {
	this.destinatario = destinatario;
	}
	public String getHonorarioatual() {
	    return honorarioatual;
	}
	public void setHonorarioatual(String honorarioatual) {
	this.honorarioatual = honorarioatual;
	}
	public String getCuotaminima() {
	    return cuotaminima;
	}
	public void setCuotaminima(String cuotaminima) {
	this.cuotaminima = cuotaminima;
	}

	// Se crea la entidad hija (Embebidos)			


}		
