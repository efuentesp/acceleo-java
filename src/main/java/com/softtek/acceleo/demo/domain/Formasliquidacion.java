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
@Table(name = "formasliquidacion")
public class Formasliquidacion implements Serializable {

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
	@Column(name = "formasliquidacionId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID formasliquidacionId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@Column(name = "participante")
	@JsonProperty("participante")
	private String participante;
	@NotNull
	@JsonProperty("tipo")
	private String tipo;
	@NotNull
	@Column(name = "fideicomisario")
	@JsonProperty("fideicomisario")
	private String fideicomisario;
	@NotNull
	@JsonProperty("formaliquidacion")
	private String formaliquidacion;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@Column(name = "seccuentaseleccionada")
	@JsonProperty("seccuentaseleccionada")
	private String seccuentaseleccionada;
	@NotNull
	@JsonProperty("plprincipal")
	private String plprincipal;
	@NotNull
	@JsonProperty("estado")
	private String estado;
	@NotNull
	@Column(name = "secparamliq")
	@JsonProperty("secparamliq")
	private String secparamliq;

	public UUID getFormasliquidacionId() {
		return formasliquidacionId;
	}

	public void setFormasliquidacionId(UUID formasliquidacionId) {
		this.formasliquidacionId = formasliquidacionId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getParticipante() {
	    return participante;
	}
	public void setParticipante(String participante) {
	this.participante = participante;
	}
	public String getTipo(){
	    return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFideicomisario() {
	    return fideicomisario;
	}
	public void setFideicomisario(String fideicomisario) {
	this.fideicomisario = fideicomisario;
	}
	public String getFormaliquidacion(){
	    return formaliquidacion;
	}
	public void setFormaliquidacion(String formaliquidacion) {
		this.formaliquidacion = formaliquidacion;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getSeccuentaseleccionada() {
	    return seccuentaseleccionada;
	}
	public void setSeccuentaseleccionada(String seccuentaseleccionada) {
	this.seccuentaseleccionada = seccuentaseleccionada;
	}
	public String getPlprincipal(){
	    return plprincipal;
	}
	public void setPlprincipal(String plprincipal) {
		this.plprincipal = plprincipal;
	}
	public String getEstado(){
	    return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSecparamliq() {
	    return secparamliq;
	}
	public void setSecparamliq(String secparamliq) {
	this.secparamliq = secparamliq;
	}

	// Se crea la entidad hija (Embebidos)			


}		
