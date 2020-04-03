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
@Table(name = "saldoscuenta")
public class Saldoscuenta implements Serializable {

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
	@Column(name = "saldoscuentaId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID saldoscuentaId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
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
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@Column(name = "auxiliar1")
	@JsonProperty("auxiliar1")
	private String auxiliar1;
	@NotNull
	@Column(name = "auxiliar2")
	@JsonProperty("auxiliar2")
	private String auxiliar2;
	@Column(name = "auxiliar3")
	@JsonProperty("auxiliar3")
	private String auxiliar3;
	@NotNull
	@Column(name = "saldoinicial")
	@JsonProperty("saldoinicial")
	private String saldoinicial;
	@NotNull
	@Column(name = "cargos")
	@JsonProperty("cargos")
	private String cargos;
	@NotNull
	@Column(name = "abonos")
	@JsonProperty("abonos")
	private String abonos;
	@NotNull
	@Column(name = "saldoactual")
	@JsonProperty("saldoactual")
	private String saldoactual;

	public UUID getSaldoscuentaId() {
		return saldoscuentaId;
	}

	public void setSaldoscuentaId(UUID saldoscuentaId) {
		this.saldoscuentaId = saldoscuentaId;
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
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getAuxiliar1() {
	    return auxiliar1;
	}
	public void setAuxiliar1(String auxiliar1) {
	this.auxiliar1 = auxiliar1;
	}
	public String getAuxiliar2() {
	    return auxiliar2;
	}
	public void setAuxiliar2(String auxiliar2) {
	this.auxiliar2 = auxiliar2;
	}
	public String getAuxiliar3() {
	    return auxiliar3;
	}
	public void setAuxiliar3(String auxiliar3) {
	this.auxiliar3 = auxiliar3;
	}
	public String getSaldoinicial() {
	    return saldoinicial;
	}
	public void setSaldoinicial(String saldoinicial) {
	this.saldoinicial = saldoinicial;
	}
	public String getCargos() {
	    return cargos;
	}
	public void setCargos(String cargos) {
	this.cargos = cargos;
	}
	public String getAbonos() {
	    return abonos;
	}
	public void setAbonos(String abonos) {
	this.abonos = abonos;
	}
	public String getSaldoactual() {
	    return saldoactual;
	}
	public void setSaldoactual(String saldoactual) {
	this.saldoactual = saldoactual;
	}

	// Se crea la entidad hija (Embebidos)			


}		
