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
@Table(name = "checkermonetario")
public class Checkermonetario implements Serializable {

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
	@Column(name = "checkermonetarioId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID checkermonetarioId;

	@NotNull
	@Column(name = "foliooperacion")
	@JsonProperty("foliooperacion")
	private String foliooperacion;
	@NotNull
	@Column(name = "operador")
	@JsonProperty("operador")
	private String operador;
	@NotNull
	@Column(name = "tipoliquidacion")
	@JsonProperty("tipoliquidacion")
	private String tipoliquidacion;
	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
	@NotNull
	@JoinColumn(name = "instruccionId")
	@OneToOne(fetch = FetchType.EAGER)
	private Instruccion instruccionId;
	@NotNull
	@Column(name = "importe")
	@JsonProperty("importe")
	private String importe;
	@NotNull
	@Column(name = "fechapago")
	@JsonProperty("fechapago")
	private String fechapago;
	@NotNull
	@Column(name = "numeroliquidaciones")
	@JsonProperty("numeroliquidaciones")
	private String numeroliquidaciones;
	@NotNull
	@JoinColumn(name = "transaccionId")
	@OneToOne(fetch = FetchType.EAGER)
	private Transaccion transaccionId;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;
	@NotNull
	@Column(name = "fecha")
	@JsonProperty("fecha")
	private String fecha;
	@NotNull
	@Column(name = "operado")
	@JsonProperty("operado")
	private String operado;
	@NotNull
	@Column(name = "autorizo")
	@JsonProperty("autorizo")
	private String autorizo;
	@NotNull
	@Column(name = "fechaautorizado")
	@JsonProperty("fechaautorizado")
	private String fechaautorizado;
	@NotNull
	@Column(name = "numerofirma")
	@JsonProperty("numerofirma")
	private String numerofirma;
	@NotNull
	@Column(name = "nombrefirma")
	@JsonProperty("nombrefirma")
	private String nombrefirma;
	@NotNull
	@Column(name = "fechafirma")
	@JsonProperty("fechafirma")
	private String fechafirma;

	public UUID getCheckermonetarioId() {
		return checkermonetarioId;
	}

	public void setCheckermonetarioId(UUID checkermonetarioId) {
		this.checkermonetarioId = checkermonetarioId;
	}
	
	public String getFoliooperacion() {
	    return foliooperacion;
	}
	public void setFoliooperacion(String foliooperacion) {
	this.foliooperacion = foliooperacion;
	}
	public String getOperador() {
	    return operador;
	}
	public void setOperador(String operador) {
	this.operador = operador;
	}
	public String getTipoliquidacion() {
	    return tipoliquidacion;
	}
	public void setTipoliquidacion(String tipoliquidacion) {
	this.tipoliquidacion = tipoliquidacion;
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
	public Instruccion getInstruccionId (){
	    return instruccionId;
	}
	public void setInstruccionId(Instruccion instruccionId) {
		this.instruccionId = instruccionId;
	}
	public String getImporte() {
	    return importe;
	}
	public void setImporte(String importe) {
	this.importe = importe;
	}
	public String getFechapago() {
	    return fechapago;
	}
	public void setFechapago(String fechapago) {
	this.fechapago = fechapago;
	}
	public String getNumeroliquidaciones() {
	    return numeroliquidaciones;
	}
	public void setNumeroliquidaciones(String numeroliquidaciones) {
	this.numeroliquidaciones = numeroliquidaciones;
	}
	public Transaccion getTransaccionId (){
	    return transaccionId;
	}
	public void setTransaccionId(Transaccion transaccionId) {
		this.transaccionId = transaccionId;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getFecha() {
	    return fecha;
	}
	public void setFecha(String fecha) {
	this.fecha = fecha;
	}
	public String getOperado() {
	    return operado;
	}
	public void setOperado(String operado) {
	this.operado = operado;
	}
	public String getAutorizo() {
	    return autorizo;
	}
	public void setAutorizo(String autorizo) {
	this.autorizo = autorizo;
	}
	public String getFechaautorizado() {
	    return fechaautorizado;
	}
	public void setFechaautorizado(String fechaautorizado) {
	this.fechaautorizado = fechaautorizado;
	}
	public String getNumerofirma() {
	    return numerofirma;
	}
	public void setNumerofirma(String numerofirma) {
	this.numerofirma = numerofirma;
	}
	public String getNombrefirma() {
	    return nombrefirma;
	}
	public void setNombrefirma(String nombrefirma) {
	this.nombrefirma = nombrefirma;
	}
	public String getFechafirma() {
	    return fechafirma;
	}
	public void setFechafirma(String fechafirma) {
	this.fechafirma = fechafirma;
	}

	// Se crea la entidad hija (Embebidos)			


}		
