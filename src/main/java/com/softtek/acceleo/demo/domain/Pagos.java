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
@Table(name = "pagos")
public class Pagos implements Serializable {

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
	@Column(name = "pagosId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID pagosId;

	@NotNull
	@JoinColumn(name = "instruccionId")
	@OneToOne(fetch = FetchType.EAGER)
	private Instruccion instruccionId;
	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@Column(name = "importeinstruccion")
	@JsonProperty("importeinstruccion")
	private String importeinstruccion;
	@NotNull
	@Column(name = "movimientos")
	@JsonProperty("movimientos")
	private String movimientos;
	@NotNull
	@JsonProperty("tipopersona")
	private String tipopersona;
	@NotNull
	@JsonProperty("conceptopago")
	private String conceptopago;
	@NotNull
	@Column(name = "clave")
	@JsonProperty("clave")
	private String clave;
	@NotNull
	@Column(name = "nombre")
	@JsonProperty("nombre")
	private String nombre;
	@NotNull
	@Column(name = "formaliquidacion")
	@JsonProperty("formaliquidacion")
	private String formaliquidacion;
	@NotNull
	@Column(name = "tipopago")
	@JsonProperty("tipopago")
	private String tipopago;
	@NotNull
	@Column(name = "datosconcentradora")
	@JsonProperty("datosconcentradora")
	private String datosconcentradora;
	@NotNull
	@Column(name = "descripcioncomplementaria")
	@JsonProperty("descripcioncomplementaria")
	private String descripcioncomplementaria;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
	@NotNull
	@Column(name = "importetotal")
	@JsonProperty("importetotal")
	private String importetotal;
	@NotNull
	@JsonProperty("estatusoperacion")
	private String estatusoperacion;
	@NotNull
	@Column(name = "importe")
	@JsonProperty("importe")
	private String importe;
	@NotNull
	@Column(name = "fechaliquidar")
	@JsonProperty("fechaliquidar")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaliquidar;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;

	public UUID getPagosId() {
		return pagosId;
	}

	public void setPagosId(UUID pagosId) {
		this.pagosId = pagosId;
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
	public String getImporteinstruccion() {
	    return importeinstruccion;
	}
	public void setImporteinstruccion(String importeinstruccion) {
	this.importeinstruccion = importeinstruccion;
	}
	public String getMovimientos() {
	    return movimientos;
	}
	public void setMovimientos(String movimientos) {
	this.movimientos = movimientos;
	}
	public String getTipopersona(){
	    return tipopersona;
	}
	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	public String getConceptopago(){
	    return conceptopago;
	}
	public void setConceptopago(String conceptopago) {
		this.conceptopago = conceptopago;
	}
	public String getClave() {
	    return clave;
	}
	public void setClave(String clave) {
	this.clave = clave;
	}
	public String getNombre() {
	    return nombre;
	}
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	public String getFormaliquidacion() {
	    return formaliquidacion;
	}
	public void setFormaliquidacion(String formaliquidacion) {
	this.formaliquidacion = formaliquidacion;
	}
	public String getTipopago() {
	    return tipopago;
	}
	public void setTipopago(String tipopago) {
	this.tipopago = tipopago;
	}
	public String getDatosconcentradora() {
	    return datosconcentradora;
	}
	public void setDatosconcentradora(String datosconcentradora) {
	this.datosconcentradora = datosconcentradora;
	}
	public String getDescripcioncomplementaria() {
	    return descripcioncomplementaria;
	}
	public void setDescripcioncomplementaria(String descripcioncomplementaria) {
	this.descripcioncomplementaria = descripcioncomplementaria;
	}
	public Subfiso getSubfisoId (){
	    return subfisoId;
	}
	public void setSubfisoId(Subfiso subfisoId) {
		this.subfisoId = subfisoId;
	}
	public String getImportetotal() {
	    return importetotal;
	}
	public void setImportetotal(String importetotal) {
	this.importetotal = importetotal;
	}
	public String getEstatusoperacion(){
	    return estatusoperacion;
	}
	public void setEstatusoperacion(String estatusoperacion) {
		this.estatusoperacion = estatusoperacion;
	}
	public String getImporte() {
	    return importe;
	}
	public void setImporte(String importe) {
	this.importe = importe;
	}
	public Date getFechaliquidar() {
	    return fechaliquidar;
	}
	public void setFechaliquidar(Date fechaliquidar) {
		this.fechaliquidar = fechaliquidar;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	// Se crea la entidad hija (Embebidos)			


}		
