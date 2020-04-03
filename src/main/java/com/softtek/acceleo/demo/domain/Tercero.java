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
@Table(name = "tercero")
public class Tercero implements Serializable {

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
	@Column(name = "terceroId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID terceroId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@Column(name = "notercero")
	@JsonProperty("notercero")
	private Integer notercero;
	@NotNull
	@Column(name = "razonsocial")
	@JsonProperty("razonsocial")
	private String razonsocial;
	@NotNull
	@JsonProperty("nacionalidad")
	private String nacionalidad;
	@NotNull
	@JsonProperty("actividadeconomica")
	private String actividadeconomica;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;
	@Column(name = "fechaverfircosoft")
	@JsonProperty("fechaverfircosoft")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaverfircosoft;
	@NotNull
	@JsonProperty("tipopersona")
	private String tipopersona;
	@NotNull
	@Column(name = "rfc")
	@JsonProperty("rfc")
	private String rfc;
	@Column(name = "correo")
	@JsonProperty("correo")
	private String correo;
	@NotNull
	@JsonProperty("calidamigratoria")
	private String calidamigratoria;
	@NotNull
	@JsonProperty("telefonosfideicomitente_paiscasa")
	private String telefonosfideicomitentepaiscasa;
	@NotNull
	@JsonProperty("telefonosfideicomitente_paisoficina")
	private String telefonosfideicomitentepaisoficina;
	@NotNull
	@JsonProperty("telefonosfideicomitente_paiscelular")
	private String telefonosfideicomitentepaiscelular;
	@Column(name = "telefonosfideicomitenteladacasa")
	@JsonProperty("telefonosfideicomitente_ladacasa")
	private String telefonosfideicomitenteladacasa;
	@Column(name = "telefonosfideicomitenteladaoficina")
	@JsonProperty("telefonosfideicomitente_ladaoficina")
	private String telefonosfideicomitenteladaoficina;
	@Column(name = "telefonosfideicomitenteladacelular")
	@JsonProperty("telefonosfideicomitente_ladacelular")
	private String telefonosfideicomitenteladacelular;
	@Column(name = "telefonosfideicomitentenumerocasa")
	@JsonProperty("telefonosfideicomitente_numerocasa")
	private String telefonosfideicomitentenumerocasa;
	@Column(name = "telefonosfideicomitentenumerooficina")
	@JsonProperty("telefonosfideicomitente_numerooficina")
	private String telefonosfideicomitentenumerooficina;
	@Column(name = "telefonosfideicomitentenumerocelular")
	@JsonProperty("telefonosfideicomitente_numerocelular")
	private String telefonosfideicomitentenumerocelular;
	@Column(name = "telefonosfideicomitenteextoficina")
	@JsonProperty("telefonosfideicomitente_extoficina")
	private String telefonosfideicomitenteextoficina;
	@Column(name = "telefonosfideicomitenteextcelular")
	@JsonProperty("telefonosfideicomitente_extcelular")
	private String telefonosfideicomitenteextcelular;

	public UUID getTerceroId() {
		return terceroId;
	}

	public void setTerceroId(UUID terceroId) {
		this.terceroId = terceroId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public Integer getNotercero(){
	    return notercero;
	}
	public void setNotercero(Integer notercero) {
		this.notercero = notercero;
	}
	public String getRazonsocial() {
	    return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
	this.razonsocial = razonsocial;
	}
	public String getNacionalidad(){
	    return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getActividadeconomica(){
	    return actividadeconomica;
	}
	public void setActividadeconomica(String actividadeconomica) {
		this.actividadeconomica = actividadeconomica;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Date getFechaverfircosoft() {
	    return fechaverfircosoft;
	}
	public void setFechaverfircosoft(Date fechaverfircosoft) {
		this.fechaverfircosoft = fechaverfircosoft;
	}
	public String getTipopersona(){
	    return tipopersona;
	}
	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	public String getRfc() {
	    return rfc;
	}
	public void setRfc(String rfc) {
	this.rfc = rfc;
	}
	public String getCorreo() {
	    return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCalidamigratoria(){
	    return calidamigratoria;
	}
	public void setCalidamigratoria(String calidamigratoria) {
		this.calidamigratoria = calidamigratoria;
	}
	public String getTelefonosfideicomitentepaiscasa(){
	    return telefonosfideicomitentepaiscasa;
	}
	public void setTelefonosfideicomitentepaiscasa(String telefonosfideicomitentepaiscasa) {
		this.telefonosfideicomitentepaiscasa = telefonosfideicomitentepaiscasa;
	}
	public String getTelefonosfideicomitentepaisoficina(){
	    return telefonosfideicomitentepaisoficina;
	}
	public void setTelefonosfideicomitentepaisoficina(String telefonosfideicomitentepaisoficina) {
		this.telefonosfideicomitentepaisoficina = telefonosfideicomitentepaisoficina;
	}
	public String getTelefonosfideicomitentepaiscelular(){
	    return telefonosfideicomitentepaiscelular;
	}
	public void setTelefonosfideicomitentepaiscelular(String telefonosfideicomitentepaiscelular) {
		this.telefonosfideicomitentepaiscelular = telefonosfideicomitentepaiscelular;
	}
	public String getTelefonosfideicomitenteladacasa() {
	    return telefonosfideicomitenteladacasa;
	}
	public void setTelefonosfideicomitenteladacasa(String telefonosfideicomitenteladacasa) {
	this.telefonosfideicomitenteladacasa = telefonosfideicomitenteladacasa;
	}
	public String getTelefonosfideicomitenteladaoficina() {
	    return telefonosfideicomitenteladaoficina;
	}
	public void setTelefonosfideicomitenteladaoficina(String telefonosfideicomitenteladaoficina) {
	this.telefonosfideicomitenteladaoficina = telefonosfideicomitenteladaoficina;
	}
	public String getTelefonosfideicomitenteladacelular() {
	    return telefonosfideicomitenteladacelular;
	}
	public void setTelefonosfideicomitenteladacelular(String telefonosfideicomitenteladacelular) {
	this.telefonosfideicomitenteladacelular = telefonosfideicomitenteladacelular;
	}
	public String getTelefonosfideicomitentenumerocasa() {
	    return telefonosfideicomitentenumerocasa;
	}
	public void setTelefonosfideicomitentenumerocasa(String telefonosfideicomitentenumerocasa) {
	this.telefonosfideicomitentenumerocasa = telefonosfideicomitentenumerocasa;
	}
	public String getTelefonosfideicomitentenumerooficina() {
	    return telefonosfideicomitentenumerooficina;
	}
	public void setTelefonosfideicomitentenumerooficina(String telefonosfideicomitentenumerooficina) {
	this.telefonosfideicomitentenumerooficina = telefonosfideicomitentenumerooficina;
	}
	public String getTelefonosfideicomitentenumerocelular() {
	    return telefonosfideicomitentenumerocelular;
	}
	public void setTelefonosfideicomitentenumerocelular(String telefonosfideicomitentenumerocelular) {
	this.telefonosfideicomitentenumerocelular = telefonosfideicomitentenumerocelular;
	}
	public String getTelefonosfideicomitenteextoficina() {
	    return telefonosfideicomitenteextoficina;
	}
	public void setTelefonosfideicomitenteextoficina(String telefonosfideicomitenteextoficina) {
	this.telefonosfideicomitenteextoficina = telefonosfideicomitenteextoficina;
	}
	public String getTelefonosfideicomitenteextcelular() {
	    return telefonosfideicomitenteextcelular;
	}
	public void setTelefonosfideicomitenteextcelular(String telefonosfideicomitenteextcelular) {
	this.telefonosfideicomitenteextcelular = telefonosfideicomitenteextcelular;
	}

	// Se crea la entidad hija (Embebidos)			


}		
