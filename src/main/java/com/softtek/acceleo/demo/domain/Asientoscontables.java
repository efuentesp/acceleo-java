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
@Table(name = "asientoscontables")
public class Asientoscontables implements Serializable {

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
	@Column(name = "asientoscontablesId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID asientoscontablesId;

	@NotNull
	@Column(name = "folio")
	@JsonProperty("folio")
	private String folio;
	@NotNull
	@Column(name = "operacion")
	@JsonProperty("operacion")
	private String operacion;
	@NotNull
	@Column(name = "fechaalta")
	@JsonProperty("fechaalta")
	private String fechaalta;
	@NotNull
	@JoinColumn(name = "transaccionId")
	@OneToOne(fetch = FetchType.EAGER)
	private Transaccion transaccionId;
	@NotNull
	@Column(name = "fechacontable")
	@JsonProperty("fechacontable")
	private String fechacontable;
	@NotNull
	@Column(name = "cuenta")
	@JsonProperty("cuenta")
	private String cuenta;
	@NotNull
	@Column(name = "sct")
	@JsonProperty("sct")
	private String sct;
	@NotNull
	@Column(name = "ssct")
	@JsonProperty("ssct")
	private String ssct;
	@NotNull
	@Column(name = "sssct")
	@JsonProperty("sssct")
	private String sssct;
	@NotNull
	@Column(name = "ssssct")
	@JsonProperty("ssssct")
	private String ssssct;
	@NotNull
	@Column(name = "descripcioncta")
	@JsonProperty("descripcioncta")
	private String descripcioncta;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@Column(name = "aux1")
	@JsonProperty("aux1")
	private String aux1;
	@NotNull
	@Column(name = "aux2")
	@JsonProperty("aux2")
	private String aux2;
	@Column(name = "aux3")
	@JsonProperty("aux3")
	private String aux3;
	@NotNull
	@JsonProperty("cargoabono")
	private String cargoabono;
	@NotNull
	@Column(name = "importe")
	@JsonProperty("importe")
	private String importe;
	@Column(name = "descripcion")
	@JsonProperty("descripcion")
	private String descripcion;

	public UUID getAsientoscontablesId() {
		return asientoscontablesId;
	}

	public void setAsientoscontablesId(UUID asientoscontablesId) {
		this.asientoscontablesId = asientoscontablesId;
	}
	
	public String getFolio() {
	    return folio;
	}
	public void setFolio(String folio) {
	this.folio = folio;
	}
	public String getOperacion() {
	    return operacion;
	}
	public void setOperacion(String operacion) {
	this.operacion = operacion;
	}
	public String getFechaalta() {
	    return fechaalta;
	}
	public void setFechaalta(String fechaalta) {
	this.fechaalta = fechaalta;
	}
	public Transaccion getTransaccionId (){
	    return transaccionId;
	}
	public void setTransaccionId(Transaccion transaccionId) {
		this.transaccionId = transaccionId;
	}
	public String getFechacontable() {
	    return fechacontable;
	}
	public void setFechacontable(String fechacontable) {
	this.fechacontable = fechacontable;
	}
	public String getCuenta() {
	    return cuenta;
	}
	public void setCuenta(String cuenta) {
	this.cuenta = cuenta;
	}
	public String getSct() {
	    return sct;
	}
	public void setSct(String sct) {
	this.sct = sct;
	}
	public String getSsct() {
	    return ssct;
	}
	public void setSsct(String ssct) {
	this.ssct = ssct;
	}
	public String getSssct() {
	    return sssct;
	}
	public void setSssct(String sssct) {
	this.sssct = sssct;
	}
	public String getSsssct() {
	    return ssssct;
	}
	public void setSsssct(String ssssct) {
	this.ssssct = ssssct;
	}
	public String getDescripcioncta() {
	    return descripcioncta;
	}
	public void setDescripcioncta(String descripcioncta) {
	this.descripcioncta = descripcioncta;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getAux1() {
	    return aux1;
	}
	public void setAux1(String aux1) {
	this.aux1 = aux1;
	}
	public String getAux2() {
	    return aux2;
	}
	public void setAux2(String aux2) {
	this.aux2 = aux2;
	}
	public String getAux3() {
	    return aux3;
	}
	public void setAux3(String aux3) {
	this.aux3 = aux3;
	}
	public String getCargoabono(){
	    return cargoabono;
	}
	public void setCargoabono(String cargoabono) {
		this.cargoabono = cargoabono;
	}
	public String getImporte() {
	    return importe;
	}
	public void setImporte(String importe) {
	this.importe = importe;
	}
	public String getDescripcion() {
	    return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// Se crea la entidad hija (Embebidos)			


}		
