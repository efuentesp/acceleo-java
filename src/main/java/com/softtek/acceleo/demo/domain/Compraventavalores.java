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
@Table(name = "compraventavalores")
public class Compraventavalores implements Serializable {

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
	@Column(name = "compraventavaloresId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID compraventavaloresId;

	@NotNull
	@Column(name = "fechaoperacion")
	@JsonProperty("fechaoperacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaoperacion;
	@NotNull
	@Column(name = "generooperacion")
	@JsonProperty("generooperacion")
	private String generooperacion;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
	@NotNull
	@JoinColumn(name = "contratoinversionId")
	@OneToOne(fetch = FetchType.EAGER)
	private Contratoinversion contratoinversionId;
	@NotNull
	@Column(name = "descripcionoperacion")
	@JsonProperty("descripcionoperacion")
	private String descripcionoperacion;
	@NotNull
	@JsonProperty("operacion")
	private String operacion;
	@NotNull
	@Column(name = "montooperacion")
	@JsonProperty("montooperacion")
	private String montooperacion;
	@NotNull
	@Column(name = "intermediario")
	@JsonProperty("intermediario")
	private String intermediario;
	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@Column(name = "descripcionfideicomiso")
	@JsonProperty("descripcionfideicomiso")
	private String descripcionfideicomiso;
	@NotNull
	@Column(name = "politicainversion")
	@JsonProperty("politicainversion")
	private String politicainversion;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@JsonProperty("emergente")
	private String emergente;

	public UUID getCompraventavaloresId() {
		return compraventavaloresId;
	}

	public void setCompraventavaloresId(UUID compraventavaloresId) {
		this.compraventavaloresId = compraventavaloresId;
	}
	
	public Date getFechaoperacion() {
	    return fechaoperacion;
	}
	public void setFechaoperacion(Date fechaoperacion) {
		this.fechaoperacion = fechaoperacion;
	}
	public String getGenerooperacion() {
	    return generooperacion;
	}
	public void setGenerooperacion(String generooperacion) {
	this.generooperacion = generooperacion;
	}
	public Subfiso getSubfisoId (){
	    return subfisoId;
	}
	public void setSubfisoId(Subfiso subfisoId) {
		this.subfisoId = subfisoId;
	}
	public Contratoinversion getContratoinversionId (){
	    return contratoinversionId;
	}
	public void setContratoinversionId(Contratoinversion contratoinversionId) {
		this.contratoinversionId = contratoinversionId;
	}
	public String getDescripcionoperacion() {
	    return descripcionoperacion;
	}
	public void setDescripcionoperacion(String descripcionoperacion) {
	this.descripcionoperacion = descripcionoperacion;
	}
	public String getOperacion(){
	    return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public String getMontooperacion() {
	    return montooperacion;
	}
	public void setMontooperacion(String montooperacion) {
	this.montooperacion = montooperacion;
	}
	public String getIntermediario() {
	    return intermediario;
	}
	public void setIntermediario(String intermediario) {
	this.intermediario = intermediario;
	}
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getDescripcionfideicomiso() {
	    return descripcionfideicomiso;
	}
	public void setDescripcionfideicomiso(String descripcionfideicomiso) {
	this.descripcionfideicomiso = descripcionfideicomiso;
	}
	public String getPoliticainversion() {
	    return politicainversion;
	}
	public void setPoliticainversion(String politicainversion) {
	this.politicainversion = politicainversion;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getEmergente(){
	    return emergente;
	}
	public void setEmergente(String emergente) {
		this.emergente = emergente;
	}

	// Se crea la entidad hija (Embebidos)			


}		
