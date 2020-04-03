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
@Table(name = "movimiento")
public class Movimiento implements Serializable {

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
	@Column(name = "movimientoId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID movimientoId;

	@NotNull
	@Column(name = "fechacontable")
	@JsonProperty("fechacontable")
	private String fechacontable;
	@NotNull
	@Column(name = "fechaalta")
	@JsonProperty("fechaalta")
	private String fechaalta;
	@Column(name = "operacion")
	@JsonProperty("operacion")
	private String operacion;
	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
	@NotNull
	@Column(name = "folio")
	@JsonProperty("folio")
	private String folio;
	@NotNull
	@Column(name = "transaccion")
	@JsonProperty("transaccion")
	private String transaccion;
	@Column(name = "descripcion")
	@JsonProperty("descripcion")
	private String descripcion;
	@NotNull
	@Column(name = "importe")
	@JsonProperty("importe")
	private String importe;
	@NotNull
	@Column(name = "usuario")
	@JsonProperty("usuario")
	private String usuario;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;
	@Column(name = "factura")
	@JsonProperty("factura")
	private String factura;

	public UUID getMovimientoId() {
		return movimientoId;
	}

	public void setMovimientoId(UUID movimientoId) {
		this.movimientoId = movimientoId;
	}
	
	public String getFechacontable() {
	    return fechacontable;
	}
	public void setFechacontable(String fechacontable) {
	this.fechacontable = fechacontable;
	}
	public String getFechaalta() {
	    return fechaalta;
	}
	public void setFechaalta(String fechaalta) {
	this.fechaalta = fechaalta;
	}
	public String getOperacion() {
	    return operacion;
	}
	public void setOperacion(String operacion) {
	this.operacion = operacion;
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
	public String getTransaccion() {
	    return transaccion;
	}
	public void setTransaccion(String transaccion) {
	this.transaccion = transaccion;
	}
	public String getDescripcion() {
	    return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImporte() {
	    return importe;
	}
	public void setImporte(String importe) {
	this.importe = importe;
	}
	public String getUsuario() {
	    return usuario;
	}
	public void setUsuario(String usuario) {
	this.usuario = usuario;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getFactura() {
	    return factura;
	}
	public void setFactura(String factura) {
	this.factura = factura;
	}

	// Se crea la entidad hija (Embebidos)			


}		
