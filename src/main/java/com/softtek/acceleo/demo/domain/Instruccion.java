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
@Table(name = "instruccion")
public class Instruccion implements Serializable {

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
	@Column(name = "instruccionId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID instruccionId;

	@NotNull
	@Column(name = "fechahoracaptura")
	@JsonProperty("fechahoracaptura")
	private String fechahoracaptura;
	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
	@Column(name = "folio")
	@JsonProperty("folio")
	private String folio;
	@Column(name = "fechadocumeto")
	@JsonProperty("fechadocumeto")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechadocumeto;
	@NotNull
	@JsonProperty("clasificacion")
	private String clasificacion;
	@NotNull
	@JsonProperty("personalidadsolicitante")
	private String personalidadsolicitante;
	@Column(name = "fechacambioestatus")
	@JsonProperty("fechacambioestatus")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacambioestatus;
	@NotNull
	@JsonProperty("subtipoinstruccion")
	private String subtipoinstruccion;
	@NotNull
	@Column(name = "importe")
	@JsonProperty("importe")
	private String importe;
	@Column(name = "importeaplicado")
	@JsonProperty("importeaplicado")
	private String importeaplicado;
	@Column(name = "nombrefideicomiso")
	@JsonProperty("nombrefideicomiso")
	private String nombrefideicomiso;
	@Column(name = "nombresubfiso")
	@JsonProperty("nombresubfiso")
	private String nombresubfiso;
	@Column(name = "titularfideicomiso")
	@JsonProperty("titularfideicomiso")
	private String titularfideicomiso;
	@Column(name = "fechacompromiso")
	@JsonProperty("fechacompromiso")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacompromiso;
	@NotNull
	@JsonProperty("formarecepcion")
	private String formarecepcion;
	@NotNull
	@JsonProperty("estatusinstruccion")
	private String estatusinstruccion;
	@NotNull
	@JsonProperty("tipoinstruccion")
	private String tipoinstruccion;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@Column(name = "noeventos")
	@JsonProperty("noeventos")
	private String noeventos;
	@Column(name = "noefectuados")
	@JsonProperty("noefectuados")
	private String noefectuados;
	@NotNull
	@Column(name = "infocomplementaria")
	@JsonProperty("infocomplementaria")
	private String infocomplementaria;

	public UUID getInstruccionId() {
		return instruccionId;
	}

	public void setInstruccionId(UUID instruccionId) {
		this.instruccionId = instruccionId;
	}
	
	public String getFechahoracaptura() {
	    return fechahoracaptura;
	}
	public void setFechahoracaptura(String fechahoracaptura) {
	this.fechahoracaptura = fechahoracaptura;
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
	public String getFolio() {
	    return folio;
	}
	public void setFolio(String folio) {
	this.folio = folio;
	}
	public Date getFechadocumeto() {
	    return fechadocumeto;
	}
	public void setFechadocumeto(Date fechadocumeto) {
		this.fechadocumeto = fechadocumeto;
	}
	public String getClasificacion(){
	    return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getPersonalidadsolicitante(){
	    return personalidadsolicitante;
	}
	public void setPersonalidadsolicitante(String personalidadsolicitante) {
		this.personalidadsolicitante = personalidadsolicitante;
	}
	public Date getFechacambioestatus() {
	    return fechacambioestatus;
	}
	public void setFechacambioestatus(Date fechacambioestatus) {
		this.fechacambioestatus = fechacambioestatus;
	}
	public String getSubtipoinstruccion(){
	    return subtipoinstruccion;
	}
	public void setSubtipoinstruccion(String subtipoinstruccion) {
		this.subtipoinstruccion = subtipoinstruccion;
	}
	public String getImporte() {
	    return importe;
	}
	public void setImporte(String importe) {
	this.importe = importe;
	}
	public String getImporteaplicado() {
	    return importeaplicado;
	}
	public void setImporteaplicado(String importeaplicado) {
	this.importeaplicado = importeaplicado;
	}
	public String getNombrefideicomiso() {
	    return nombrefideicomiso;
	}
	public void setNombrefideicomiso(String nombrefideicomiso) {
	this.nombrefideicomiso = nombrefideicomiso;
	}
	public String getNombresubfiso() {
	    return nombresubfiso;
	}
	public void setNombresubfiso(String nombresubfiso) {
	this.nombresubfiso = nombresubfiso;
	}
	public String getTitularfideicomiso() {
	    return titularfideicomiso;
	}
	public void setTitularfideicomiso(String titularfideicomiso) {
	this.titularfideicomiso = titularfideicomiso;
	}
	public Date getFechacompromiso() {
	    return fechacompromiso;
	}
	public void setFechacompromiso(Date fechacompromiso) {
		this.fechacompromiso = fechacompromiso;
	}
	public String getFormarecepcion(){
	    return formarecepcion;
	}
	public void setFormarecepcion(String formarecepcion) {
		this.formarecepcion = formarecepcion;
	}
	public String getEstatusinstruccion(){
	    return estatusinstruccion;
	}
	public void setEstatusinstruccion(String estatusinstruccion) {
		this.estatusinstruccion = estatusinstruccion;
	}
	public String getTipoinstruccion(){
	    return tipoinstruccion;
	}
	public void setTipoinstruccion(String tipoinstruccion) {
		this.tipoinstruccion = tipoinstruccion;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getNoeventos() {
	    return noeventos;
	}
	public void setNoeventos(String noeventos) {
	this.noeventos = noeventos;
	}
	public String getNoefectuados() {
	    return noefectuados;
	}
	public void setNoefectuados(String noefectuados) {
	this.noefectuados = noefectuados;
	}
	public String getInfocomplementaria() {
	    return infocomplementaria;
	}
	public void setInfocomplementaria(String infocomplementaria) {
		this.infocomplementaria = infocomplementaria;
	}

	// Se crea la entidad hija (Embebidos)			


}		
