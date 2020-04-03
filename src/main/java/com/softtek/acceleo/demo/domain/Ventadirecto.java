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
@Table(name = "ventadirecto")
public class Ventadirecto implements Serializable {

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
	@Column(name = "ventadirectoId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID ventadirectoId;

	@NotNull
	@JoinColumn(name = "instruccionId")
	@OneToOne(fetch = FetchType.EAGER)
	private Instruccion instruccionId;
	@Column(name = "fechavalor")
	@JsonProperty("fechavalor")
	private String fechavalor;
	@NotNull
	@JsonProperty("titulosgarantia")
	private String titulosgarantia;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
	@NotNull
	@JsonProperty("operacionfutura")
	private String operacionfutura;
	@Column(name = "fechaoperacion")
	@JsonProperty("fechaoperacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaoperacion;
	@NotNull
	@JsonProperty("activos")
	private String activos;
	@Column(name = "tipomovimiento")
	@JsonProperty("tipomovimiento")
	private String tipomovimiento;
	@NotNull
	@Column(name = "importe")
	@JsonProperty("importe")
	private String importe;
	@Column(name = "custodio")
	@JsonProperty("custodio")
	private String custodio;
	@Column(name = "comision")
	@JsonProperty("comision")
	private String comision;
	@NotNull
	@JsonProperty("mercado")
	private String mercado;
	@NotNull
	@JsonProperty("instrumento")
	private String instrumento;
	@Column(name = "isr")
	@JsonProperty("isr")
	private String isr;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JoinColumn(name = "contratoinversionId")
	@OneToOne(fetch = FetchType.EAGER)
	private Contratoinversion contratoinversionId;
	@Column(name = "fechaliquidacion")
	@JsonProperty("fechaliquidacion")
	private String fechaliquidacion;
	@NotNull
	@JsonProperty("emisiones")
	private String emisiones;
	@NotNull
	@Column(name = "serie")
	@JsonProperty("serie")
	private String serie;
	@NotNull
	@Column(name = "notitulos")
	@JsonProperty("notitulos")
	private String notitulos;
	@NotNull
	@Column(name = "precio")
	@JsonProperty("precio")
	private String precio;
	@NotNull
	@Column(name = "desccomplementaria")
	@JsonProperty("desccomplementaria")
	private String desccomplementaria;
	@NotNull
	@Column(name = "intereses")
	@JsonProperty("intereses")
	private String intereses;
	@NotNull
	@Column(name = "pizarra")
	@JsonProperty("pizarra")
	private String pizarra;
	@NotNull
	@Column(name = "cupon")
	@JsonProperty("cupon")
	private String cupon;

	public UUID getVentadirectoId() {
		return ventadirectoId;
	}

	public void setVentadirectoId(UUID ventadirectoId) {
		this.ventadirectoId = ventadirectoId;
	}
	
	public Instruccion getInstruccionId (){
	    return instruccionId;
	}
	public void setInstruccionId(Instruccion instruccionId) {
		this.instruccionId = instruccionId;
	}
	public String getFechavalor() {
	    return fechavalor;
	}
	public void setFechavalor(String fechavalor) {
	this.fechavalor = fechavalor;
	}
	public String getTitulosgarantia(){
	    return titulosgarantia;
	}
	public void setTitulosgarantia(String titulosgarantia) {
		this.titulosgarantia = titulosgarantia;
	}
	public Subfiso getSubfisoId (){
	    return subfisoId;
	}
	public void setSubfisoId(Subfiso subfisoId) {
		this.subfisoId = subfisoId;
	}
	public String getOperacionfutura(){
	    return operacionfutura;
	}
	public void setOperacionfutura(String operacionfutura) {
		this.operacionfutura = operacionfutura;
	}
	public Date getFechaoperacion() {
	    return fechaoperacion;
	}
	public void setFechaoperacion(Date fechaoperacion) {
		this.fechaoperacion = fechaoperacion;
	}
	public String getActivos(){
	    return activos;
	}
	public void setActivos(String activos) {
		this.activos = activos;
	}
	public String getTipomovimiento() {
	    return tipomovimiento;
	}
	public void setTipomovimiento(String tipomovimiento) {
	this.tipomovimiento = tipomovimiento;
	}
	public String getImporte() {
	    return importe;
	}
	public void setImporte(String importe) {
	this.importe = importe;
	}
	public String getCustodio() {
	    return custodio;
	}
	public void setCustodio(String custodio) {
	this.custodio = custodio;
	}
	public String getComision() {
	    return comision;
	}
	public void setComision(String comision) {
	this.comision = comision;
	}
	public String getMercado(){
	    return mercado;
	}
	public void setMercado(String mercado) {
		this.mercado = mercado;
	}
	public String getInstrumento(){
	    return instrumento;
	}
	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}
	public String getIsr() {
	    return isr;
	}
	public void setIsr(String isr) {
	this.isr = isr;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public Contratoinversion getContratoinversionId (){
	    return contratoinversionId;
	}
	public void setContratoinversionId(Contratoinversion contratoinversionId) {
		this.contratoinversionId = contratoinversionId;
	}
	public String getFechaliquidacion() {
	    return fechaliquidacion;
	}
	public void setFechaliquidacion(String fechaliquidacion) {
	this.fechaliquidacion = fechaliquidacion;
	}
	public String getEmisiones(){
	    return emisiones;
	}
	public void setEmisiones(String emisiones) {
		this.emisiones = emisiones;
	}
	public String getSerie() {
	    return serie;
	}
	public void setSerie(String serie) {
	this.serie = serie;
	}
	public String getNotitulos() {
	    return notitulos;
	}
	public void setNotitulos(String notitulos) {
	this.notitulos = notitulos;
	}
	public String getPrecio() {
	    return precio;
	}
	public void setPrecio(String precio) {
	this.precio = precio;
	}
	public String getDesccomplementaria() {
	    return desccomplementaria;
	}
	public void setDesccomplementaria(String desccomplementaria) {
	this.desccomplementaria = desccomplementaria;
	}
	public String getIntereses() {
	    return intereses;
	}
	public void setIntereses(String intereses) {
	this.intereses = intereses;
	}
	public String getPizarra() {
	    return pizarra;
	}
	public void setPizarra(String pizarra) {
	this.pizarra = pizarra;
	}
	public String getCupon() {
	    return cupon;
	}
	public void setCupon(String cupon) {
	this.cupon = cupon;
	}

	// Se crea la entidad hija (Embebidos)			


}		
