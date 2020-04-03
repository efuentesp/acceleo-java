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
@Table(name = "comitetecnico")
public class Comitetecnico implements Serializable {

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
	@Column(name = "comitetecnicoId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID comitetecnicoId;

	@Column(name = "dummy")
	@JsonProperty("dummy")
	private String dummy;
	@NotNull
	@JoinColumn(name = "generales_fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso generalesfideicomisoId;
	@NotNull
	@Column(name = "generalesnombre")
	@JsonProperty("generales_nombre")
	private String generalesnombre;
	@Column(name = "generalesintegracion")
	@JsonProperty("generales_integracion")
	private String generalesintegracion;
	@Column(name = "generalesfacultades")
	@JsonProperty("generales_facultades")
	private String generalesfacultades;
	@Column(name = "generalescomentarios")
	@JsonProperty("generales_comentarios")
	private String generalescomentarios;
	@NotNull
	@Column(name = "generalesfechaconstitucion")
	@JsonProperty("generales_fechaconstitucion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date generalesfechaconstitucion;
	@Column(name = "generalesmiembrosquorum")
	@JsonProperty("generales_miembrosquorum")
	private Integer generalesmiembrosquorum;
	@NotNull
	@JsonProperty("generales_estatus")
	private String generalesestatus;
	@Column(name = "presidentepropietarionombre")
	@JsonProperty("presidente_propietario_nombre")
	private String presidentepropietarionombre;
	@Column(name = "presidentepropietariopropietario")
	@JsonProperty("presidente_propietario_propietario")
	private String presidentepropietariopropietario;
	@NotNull
	@JsonProperty("presidente_propietario_propietarionacionalidad")
	private String presidentepropietariopropietarionacionalidad;
	@NotNull
	@JsonProperty("presidente_propietario_propietariosino")
	private String presidentepropietariopropietariosino;
	@Column(name = "presidentesuplentenombre")
	@JsonProperty("presidente_suplente_nombre")
	private String presidentesuplentenombre;
	@Column(name = "presidentesuplentepropietario")
	@JsonProperty("presidente_suplente_propietario")
	private String presidentesuplentepropietario;
	@NotNull
	@JsonProperty("presidente_suplente_propietarionacionalidad")
	private String presidentesuplentepropietarionacionalidad;
	@NotNull
	@JsonProperty("presidente_suplente_propietariosino")
	private String presidentesuplentepropietariosino;
	@Column(name = "secretariopropietarionombre")
	@JsonProperty("secretario_propietario_nombre")
	private String secretariopropietarionombre;
	@Column(name = "secretariopropietariopropietario")
	@JsonProperty("secretario_propietario_propietario")
	private String secretariopropietariopropietario;
	@NotNull
	@JsonProperty("secretario_propietario_propietarionacionalidad")
	private String secretariopropietariopropietarionacionalidad;
	@NotNull
	@JsonProperty("secretario_propietario_propietariosino")
	private String secretariopropietariopropietariosino;
	@Column(name = "secretariosuplentenombre")
	@JsonProperty("secretario_suplente_nombre")
	private String secretariosuplentenombre;
	@Column(name = "secretariosuplentepropietario")
	@JsonProperty("secretario_suplente_propietario")
	private String secretariosuplentepropietario;
	@NotNull
	@JsonProperty("secretario_suplente_propietarionacionalidad")
	private String secretariosuplentepropietarionacionalidad;
	@NotNull
	@JsonProperty("secretario_suplente_propietariosino")
	private String secretariosuplentepropietariosino;
	@Column(name = "vocalpropietarionombre")
	@JsonProperty("vocal_propietario_nombre")
	private String vocalpropietarionombre;
	@Column(name = "vocalpropietariopropietario")
	@JsonProperty("vocal_propietario_propietario")
	private String vocalpropietariopropietario;
	@NotNull
	@JsonProperty("vocal_propietario_propietarionacionalidad")
	private String vocalpropietariopropietarionacionalidad;
	@NotNull
	@JsonProperty("vocal_propietario_propietariosino")
	private String vocalpropietariopropietariosino;
	@Column(name = "vocalsuplentenombre")
	@JsonProperty("vocal_suplente_nombre")
	private String vocalsuplentenombre;
	@Column(name = "vocalsuplentepropietario")
	@JsonProperty("vocal_suplente_propietario")
	private String vocalsuplentepropietario;
	@NotNull
	@JsonProperty("vocal_suplente_propietarionacionalidad")
	private String vocalsuplentepropietarionacionalidad;
	@NotNull
	@JsonProperty("vocal_suplente_propietariosino")
	private String vocalsuplentepropietariosino;

	public UUID getComitetecnicoId() {
		return comitetecnicoId;
	}

	public void setComitetecnicoId(UUID comitetecnicoId) {
		this.comitetecnicoId = comitetecnicoId;
	}
	
	public String getDummy() {
	    return dummy;
	}
	public void setDummy(String dummy) {
	this.dummy = dummy;
	}
	public Fideicomiso getGeneralesfideicomisoId (){
	    return generalesfideicomisoId;
	}
	public void setGeneralesfideicomisoId(Fideicomiso generalesfideicomisoId) {
		this.generalesfideicomisoId = generalesfideicomisoId;
	}
	public String getGeneralesnombre() {
	    return generalesnombre;
	}
	public void setGeneralesnombre(String generalesnombre) {
	this.generalesnombre = generalesnombre;
	}
	public String getGeneralesintegracion() {
	    return generalesintegracion;
	}
	public void setGeneralesintegracion(String generalesintegracion) {
		this.generalesintegracion = generalesintegracion;
	}
	public String getGeneralesfacultades() {
	    return generalesfacultades;
	}
	public void setGeneralesfacultades(String generalesfacultades) {
		this.generalesfacultades = generalesfacultades;
	}
	public String getGeneralescomentarios() {
	    return generalescomentarios;
	}
	public void setGeneralescomentarios(String generalescomentarios) {
		this.generalescomentarios = generalescomentarios;
	}
	public Date getGeneralesfechaconstitucion() {
	    return generalesfechaconstitucion;
	}
	public void setGeneralesfechaconstitucion(Date generalesfechaconstitucion) {
		this.generalesfechaconstitucion = generalesfechaconstitucion;
	}
	public Integer getGeneralesmiembrosquorum(){
	    return generalesmiembrosquorum;
	}
	public void setGeneralesmiembrosquorum(Integer generalesmiembrosquorum) {
		this.generalesmiembrosquorum = generalesmiembrosquorum;
	}
	public String getGeneralesestatus(){
	    return generalesestatus;
	}
	public void setGeneralesestatus(String generalesestatus) {
		this.generalesestatus = generalesestatus;
	}
	public String getPresidentepropietarionombre() {
	    return presidentepropietarionombre;
	}
	public void setPresidentepropietarionombre(String presidentepropietarionombre) {
	this.presidentepropietarionombre = presidentepropietarionombre;
	}
	public String getPresidentepropietariopropietario() {
	    return presidentepropietariopropietario;
	}
	public void setPresidentepropietariopropietario(String presidentepropietariopropietario) {
	this.presidentepropietariopropietario = presidentepropietariopropietario;
	}
	public String getPresidentepropietariopropietarionacionalidad(){
	    return presidentepropietariopropietarionacionalidad;
	}
	public void setPresidentepropietariopropietarionacionalidad(String presidentepropietariopropietarionacionalidad) {
		this.presidentepropietariopropietarionacionalidad = presidentepropietariopropietarionacionalidad;
	}
	public String getPresidentepropietariopropietariosino(){
	    return presidentepropietariopropietariosino;
	}
	public void setPresidentepropietariopropietariosino(String presidentepropietariopropietariosino) {
		this.presidentepropietariopropietariosino = presidentepropietariopropietariosino;
	}
	public String getPresidentesuplentenombre() {
	    return presidentesuplentenombre;
	}
	public void setPresidentesuplentenombre(String presidentesuplentenombre) {
	this.presidentesuplentenombre = presidentesuplentenombre;
	}
	public String getPresidentesuplentepropietario() {
	    return presidentesuplentepropietario;
	}
	public void setPresidentesuplentepropietario(String presidentesuplentepropietario) {
	this.presidentesuplentepropietario = presidentesuplentepropietario;
	}
	public String getPresidentesuplentepropietarionacionalidad(){
	    return presidentesuplentepropietarionacionalidad;
	}
	public void setPresidentesuplentepropietarionacionalidad(String presidentesuplentepropietarionacionalidad) {
		this.presidentesuplentepropietarionacionalidad = presidentesuplentepropietarionacionalidad;
	}
	public String getPresidentesuplentepropietariosino(){
	    return presidentesuplentepropietariosino;
	}
	public void setPresidentesuplentepropietariosino(String presidentesuplentepropietariosino) {
		this.presidentesuplentepropietariosino = presidentesuplentepropietariosino;
	}
	public String getSecretariopropietarionombre() {
	    return secretariopropietarionombre;
	}
	public void setSecretariopropietarionombre(String secretariopropietarionombre) {
	this.secretariopropietarionombre = secretariopropietarionombre;
	}
	public String getSecretariopropietariopropietario() {
	    return secretariopropietariopropietario;
	}
	public void setSecretariopropietariopropietario(String secretariopropietariopropietario) {
	this.secretariopropietariopropietario = secretariopropietariopropietario;
	}
	public String getSecretariopropietariopropietarionacionalidad(){
	    return secretariopropietariopropietarionacionalidad;
	}
	public void setSecretariopropietariopropietarionacionalidad(String secretariopropietariopropietarionacionalidad) {
		this.secretariopropietariopropietarionacionalidad = secretariopropietariopropietarionacionalidad;
	}
	public String getSecretariopropietariopropietariosino(){
	    return secretariopropietariopropietariosino;
	}
	public void setSecretariopropietariopropietariosino(String secretariopropietariopropietariosino) {
		this.secretariopropietariopropietariosino = secretariopropietariopropietariosino;
	}
	public String getSecretariosuplentenombre() {
	    return secretariosuplentenombre;
	}
	public void setSecretariosuplentenombre(String secretariosuplentenombre) {
	this.secretariosuplentenombre = secretariosuplentenombre;
	}
	public String getSecretariosuplentepropietario() {
	    return secretariosuplentepropietario;
	}
	public void setSecretariosuplentepropietario(String secretariosuplentepropietario) {
	this.secretariosuplentepropietario = secretariosuplentepropietario;
	}
	public String getSecretariosuplentepropietarionacionalidad(){
	    return secretariosuplentepropietarionacionalidad;
	}
	public void setSecretariosuplentepropietarionacionalidad(String secretariosuplentepropietarionacionalidad) {
		this.secretariosuplentepropietarionacionalidad = secretariosuplentepropietarionacionalidad;
	}
	public String getSecretariosuplentepropietariosino(){
	    return secretariosuplentepropietariosino;
	}
	public void setSecretariosuplentepropietariosino(String secretariosuplentepropietariosino) {
		this.secretariosuplentepropietariosino = secretariosuplentepropietariosino;
	}
	public String getVocalpropietarionombre() {
	    return vocalpropietarionombre;
	}
	public void setVocalpropietarionombre(String vocalpropietarionombre) {
	this.vocalpropietarionombre = vocalpropietarionombre;
	}
	public String getVocalpropietariopropietario() {
	    return vocalpropietariopropietario;
	}
	public void setVocalpropietariopropietario(String vocalpropietariopropietario) {
	this.vocalpropietariopropietario = vocalpropietariopropietario;
	}
	public String getVocalpropietariopropietarionacionalidad(){
	    return vocalpropietariopropietarionacionalidad;
	}
	public void setVocalpropietariopropietarionacionalidad(String vocalpropietariopropietarionacionalidad) {
		this.vocalpropietariopropietarionacionalidad = vocalpropietariopropietarionacionalidad;
	}
	public String getVocalpropietariopropietariosino(){
	    return vocalpropietariopropietariosino;
	}
	public void setVocalpropietariopropietariosino(String vocalpropietariopropietariosino) {
		this.vocalpropietariopropietariosino = vocalpropietariopropietariosino;
	}
	public String getVocalsuplentenombre() {
	    return vocalsuplentenombre;
	}
	public void setVocalsuplentenombre(String vocalsuplentenombre) {
	this.vocalsuplentenombre = vocalsuplentenombre;
	}
	public String getVocalsuplentepropietario() {
	    return vocalsuplentepropietario;
	}
	public void setVocalsuplentepropietario(String vocalsuplentepropietario) {
	this.vocalsuplentepropietario = vocalsuplentepropietario;
	}
	public String getVocalsuplentepropietarionacionalidad(){
	    return vocalsuplentepropietarionacionalidad;
	}
	public void setVocalsuplentepropietarionacionalidad(String vocalsuplentepropietarionacionalidad) {
		this.vocalsuplentepropietarionacionalidad = vocalsuplentepropietarionacionalidad;
	}
	public String getVocalsuplentepropietariosino(){
	    return vocalsuplentepropietariosino;
	}
	public void setVocalsuplentepropietariosino(String vocalsuplentepropietariosino) {
		this.vocalsuplentepropietariosino = vocalsuplentepropietariosino;
	}

	// Se crea la entidad hija (Embebidos)			


}		
