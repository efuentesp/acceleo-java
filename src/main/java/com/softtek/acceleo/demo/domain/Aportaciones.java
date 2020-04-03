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
@Table(name = "aportaciones")
public class Aportaciones implements Serializable {

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
	@Column(name = "aportacionesId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID aportacionesId;

	@NotNull
	@JoinColumn(name = "instruccionId")
	@OneToOne(fetch = FetchType.EAGER)
	private Instruccion instruccionId;
	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
	@NotNull
	@Column(name = "totalimporte")
	@JsonProperty("totalimporte")
	private String totalimporte;
	@NotNull
	@JsonProperty("destinorecepcion")
	private String destinorecepcion;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@JsonProperty("formarecepcion")
	private String formarecepcion;
	@NotNull
	@JsonProperty("estatusoperacion")
	private String estatusoperacion;
	@NotNull
	@JsonProperty("tipopersona")
	private String tipopersona;
	@NotNull
	@Column(name = "fechacontabilizacion")
	@JsonProperty("fechacontabilizacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacontabilizacion;
	@NotNull
	@Column(name = "nombre")
	@JsonProperty("nombre")
	private String nombre;
	@NotNull
	@Column(name = "descripcioncomplementaria")
	@JsonProperty("descripcioncomplementaria")
	private String descripcioncomplementaria;
	@NotNull
	@Column(name = "nombrefideicomiso")
	@JsonProperty("nombrefideicomiso")
	private String nombrefideicomiso;
	@NotNull
	@Column(name = "eventos")
	@JsonProperty("eventos")
	private String eventos;
	@NotNull
	@Column(name = "totalaplicado")
	@JsonProperty("totalaplicado")
	private String totalaplicado;
	@NotNull
	@Column(name = "importerecepcion")
	@JsonProperty("importerecepcion")
	private String importerecepcion;
	@NotNull
	@JsonProperty("origenrecursos")
	private String origenrecursos;

	public UUID getAportacionesId() {
		return aportacionesId;
	}

	public void setAportacionesId(UUID aportacionesId) {
		this.aportacionesId = aportacionesId;
	}
	
	public Instruccion getInstruccionId (){
	    return instruccionId;
	}
	public void setInstruccionId(Instruccion instruccionId) {
		this.instruccionId = instruccionId;
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
	public String getTotalimporte() {
	    return totalimporte;
	}
	public void setTotalimporte(String totalimporte) {
	this.totalimporte = totalimporte;
	}
	public String getDestinorecepcion(){
	    return destinorecepcion;
	}
	public void setDestinorecepcion(String destinorecepcion) {
		this.destinorecepcion = destinorecepcion;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getFormarecepcion(){
	    return formarecepcion;
	}
	public void setFormarecepcion(String formarecepcion) {
		this.formarecepcion = formarecepcion;
	}
	public String getEstatusoperacion(){
	    return estatusoperacion;
	}
	public void setEstatusoperacion(String estatusoperacion) {
		this.estatusoperacion = estatusoperacion;
	}
	public String getTipopersona(){
	    return tipopersona;
	}
	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	public Date getFechacontabilizacion() {
	    return fechacontabilizacion;
	}
	public void setFechacontabilizacion(Date fechacontabilizacion) {
		this.fechacontabilizacion = fechacontabilizacion;
	}
	public String getNombre() {
	    return nombre;
	}
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	public String getDescripcioncomplementaria() {
	    return descripcioncomplementaria;
	}
	public void setDescripcioncomplementaria(String descripcioncomplementaria) {
	this.descripcioncomplementaria = descripcioncomplementaria;
	}
	public String getNombrefideicomiso() {
	    return nombrefideicomiso;
	}
	public void setNombrefideicomiso(String nombrefideicomiso) {
	this.nombrefideicomiso = nombrefideicomiso;
	}
	public String getEventos() {
	    return eventos;
	}
	public void setEventos(String eventos) {
	this.eventos = eventos;
	}
	public String getTotalaplicado() {
	    return totalaplicado;
	}
	public void setTotalaplicado(String totalaplicado) {
	this.totalaplicado = totalaplicado;
	}
	public String getImporterecepcion() {
	    return importerecepcion;
	}
	public void setImporterecepcion(String importerecepcion) {
	this.importerecepcion = importerecepcion;
	}
	public String getOrigenrecursos(){
	    return origenrecursos;
	}
	public void setOrigenrecursos(String origenrecursos) {
		this.origenrecursos = origenrecursos;
	}

	// Se crea la entidad hija (Embebidos)			


}		
