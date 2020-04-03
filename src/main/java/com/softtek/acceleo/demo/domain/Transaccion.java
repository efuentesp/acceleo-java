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
@Table(name = "transaccion")
public class Transaccion implements Serializable {

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
	@Column(name = "transaccionId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID transaccionId;

	@NotNull
	@Column(name = "numoperacion")
	@JsonProperty("numoperacion")
	private String numoperacion;
	@NotNull
	@JsonProperty("modulo")
	private String modulo;
	@NotNull
	@Column(name = "nombre")
	@JsonProperty("nombre")
	private String nombre;
	@NotNull
	@Column(name = "costoejecucion")
	@JsonProperty("costoejecucion")
	private String costoejecucion;
	@NotNull
	@JsonProperty("estatustrans")
	private String estatustrans;
	@NotNull
	@Column(name = "notransaccion")
	@JsonProperty("notransaccion")
	private String notransaccion;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@JsonProperty("columedocuenta")
	private String columedocuenta;
	@Column(name = "hora")
	@JsonProperty("hora")
	private String hora;

	public UUID getTransaccionId() {
		return transaccionId;
	}

	public void setTransaccionId(UUID transaccionId) {
		this.transaccionId = transaccionId;
	}
	
	public String getNumoperacion() {
	    return numoperacion;
	}
	public void setNumoperacion(String numoperacion) {
	this.numoperacion = numoperacion;
	}
	public String getModulo(){
	    return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getNombre() {
	    return nombre;
	}
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	public String getCostoejecucion() {
	    return costoejecucion;
	}
	public void setCostoejecucion(String costoejecucion) {
	this.costoejecucion = costoejecucion;
	}
	public String getEstatustrans(){
	    return estatustrans;
	}
	public void setEstatustrans(String estatustrans) {
		this.estatustrans = estatustrans;
	}
	public String getNotransaccion() {
	    return notransaccion;
	}
	public void setNotransaccion(String notransaccion) {
	this.notransaccion = notransaccion;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getColumedocuenta(){
	    return columedocuenta;
	}
	public void setColumedocuenta(String columedocuenta) {
		this.columedocuenta = columedocuenta;
	}
	public String getHora() {
	    return hora;
	}
	public void setHora(String hora) {
	this.hora = hora;
	}

	// Se crea la entidad hija (Embebidos)			


}		
