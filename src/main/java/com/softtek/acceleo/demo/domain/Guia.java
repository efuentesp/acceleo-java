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
@Table(name = "guia")
public class Guia implements Serializable {

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
	@Column(name = "guiaId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID guiaId;

	@NotNull
	@JoinColumn(name = "transaccionId")
	@OneToOne(fetch = FetchType.EAGER)
	private Transaccion transaccionId;
	@NotNull
	@Column(name = "sec")
	@JsonProperty("sec")
	private String sec;
	@NotNull
	@Column(name = "nombrecuenta")
	@JsonProperty("nombrecuenta")
	private String nombrecuenta;
	@NotNull
	@Column(name = "ctamayor")
	@JsonProperty("ctamayor")
	private String ctamayor;
	@NotNull
	@Column(name = "scta")
	@JsonProperty("scta")
	private String scta;
	@NotNull
	@Column(name = "sscta")
	@JsonProperty("sscta")
	private String sscta;
	@NotNull
	@Column(name = "sssctacopia")
	@JsonProperty("sssctacopia")
	private String sssctacopia;
	@NotNull
	@Column(name = "sssscta")
	@JsonProperty("sssscta")
	private String sssscta;
	@NotNull
	@Column(name = "auxiliar1")
	@JsonProperty("auxiliar1")
	private String auxiliar1;
	@NotNull
	@Column(name = "auxiliar2")
	@JsonProperty("auxiliar2")
	private String auxiliar2;
	@NotNull
	@Column(name = "auxiliar3")
	@JsonProperty("auxiliar3")
	private String auxiliar3;
	@NotNull
	@JsonProperty("aplicadato")
	private String aplicadato;
	@NotNull
	@JsonProperty("ca")
	private String ca;
	@NotNull
	@Column(name = "descripcion")
	@JsonProperty("descripcion")
	private String descripcion;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;

	public UUID getGuiaId() {
		return guiaId;
	}

	public void setGuiaId(UUID guiaId) {
		this.guiaId = guiaId;
	}
	
	public Transaccion getTransaccionId (){
	    return transaccionId;
	}
	public void setTransaccionId(Transaccion transaccionId) {
		this.transaccionId = transaccionId;
	}
	public String getSec() {
	    return sec;
	}
	public void setSec(String sec) {
	this.sec = sec;
	}
	public String getNombrecuenta() {
	    return nombrecuenta;
	}
	public void setNombrecuenta(String nombrecuenta) {
	this.nombrecuenta = nombrecuenta;
	}
	public String getCtamayor() {
	    return ctamayor;
	}
	public void setCtamayor(String ctamayor) {
	this.ctamayor = ctamayor;
	}
	public String getScta() {
	    return scta;
	}
	public void setScta(String scta) {
	this.scta = scta;
	}
	public String getSscta() {
	    return sscta;
	}
	public void setSscta(String sscta) {
	this.sscta = sscta;
	}
	public String getSssctacopia() {
	    return sssctacopia;
	}
	public void setSssctacopia(String sssctacopia) {
	this.sssctacopia = sssctacopia;
	}
	public String getSssscta() {
	    return sssscta;
	}
	public void setSssscta(String sssscta) {
	this.sssscta = sssscta;
	}
	public String getAuxiliar1() {
	    return auxiliar1;
	}
	public void setAuxiliar1(String auxiliar1) {
	this.auxiliar1 = auxiliar1;
	}
	public String getAuxiliar2() {
	    return auxiliar2;
	}
	public void setAuxiliar2(String auxiliar2) {
	this.auxiliar2 = auxiliar2;
	}
	public String getAuxiliar3() {
	    return auxiliar3;
	}
	public void setAuxiliar3(String auxiliar3) {
	this.auxiliar3 = auxiliar3;
	}
	public String getAplicadato(){
	    return aplicadato;
	}
	public void setAplicadato(String aplicadato) {
		this.aplicadato = aplicadato;
	}
	public String getCa(){
	    return ca;
	}
	public void setCa(String ca) {
		this.ca = ca;
	}
	public String getDescripcion() {
	    return descripcion;
	}
	public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	// Se crea la entidad hija (Embebidos)			


}		
