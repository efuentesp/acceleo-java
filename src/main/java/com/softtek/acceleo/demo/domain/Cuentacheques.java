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
@Table(name = "cuentacheques")
public class Cuentacheques implements Serializable {

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
	@Column(name = "cuentachequesId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID cuentachequesId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JsonProperty("tipopersona")
	private String tipopersona;
	@NotNull
	@JoinColumn(name = "fideicomitenteId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomitente fideicomitenteId;
	@NotNull
	@JsonProperty("tipocuenta")
	private String tipocuenta;
	@NotNull
	@JsonProperty("tipopago")
	private String tipopago;
	@NotNull
	@JsonProperty("bancospei")
	private String bancospei;
	@NotNull
	@JsonProperty("banco")
	private String banco;
	@Column(name = "dombanco")
	@JsonProperty("dombanco")
	private String dombanco;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@JsonProperty("clavevostro")
	private String clavevostro;
	@Column(name = "numcuenta")
	@JsonProperty("numcuenta")
	private String numcuenta;
	@Column(name = "dombeneficiario")
	@JsonProperty("dombeneficiario")
	private String dombeneficiario;
	@Column(name = "plazainternacional")
	@JsonProperty("plazainternacional")
	private String plazainternacional;
	@Column(name = "pais")
	@JsonProperty("pais")
	private String pais;
	@Column(name = "clavesiacinst")
	@JsonProperty("clavesiacinst")
	private String clavesiacinst;
	@Column(name = "conveniociedie")
	@JsonProperty("conveniociedie")
	private String conveniociedie;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;
	@Column(name = "clabe")
	@JsonProperty("clabe")
	private String clabe;
	@NotNull
	@JsonProperty("cuentachequera")
	private String cuentachequera;
	@Column(name = "fechavence")
	@JsonProperty("fechavence")
	private String fechavence;
	@Column(name = "numabbasswift")
	@JsonProperty("numabbasswift")
	private String numabbasswift;
	@Column(name = "conceptosiac")
	@JsonProperty("conceptosiac")
	private String conceptosiac;
	@Column(name = "refciedie")
	@JsonProperty("refciedie")
	private String refciedie;
	@NotNull
	@JsonProperty("autorizacion")
	private String autorizacion;

	public UUID getCuentachequesId() {
		return cuentachequesId;
	}

	public void setCuentachequesId(UUID cuentachequesId) {
		this.cuentachequesId = cuentachequesId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getTipopersona(){
	    return tipopersona;
	}
	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	public Fideicomitente getFideicomitenteId (){
	    return fideicomitenteId;
	}
	public void setFideicomitenteId(Fideicomitente fideicomitenteId) {
		this.fideicomitenteId = fideicomitenteId;
	}
	public String getTipocuenta(){
	    return tipocuenta;
	}
	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}
	public String getTipopago(){
	    return tipopago;
	}
	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}
	public String getBancospei(){
	    return bancospei;
	}
	public void setBancospei(String bancospei) {
		this.bancospei = bancospei;
	}
	public String getBanco(){
	    return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getDombanco() {
	    return dombanco;
	}
	public void setDombanco(String dombanco) {
	this.dombanco = dombanco;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getClavevostro(){
	    return clavevostro;
	}
	public void setClavevostro(String clavevostro) {
		this.clavevostro = clavevostro;
	}
	public String getNumcuenta() {
	    return numcuenta;
	}
	public void setNumcuenta(String numcuenta) {
	this.numcuenta = numcuenta;
	}
	public String getDombeneficiario() {
	    return dombeneficiario;
	}
	public void setDombeneficiario(String dombeneficiario) {
	this.dombeneficiario = dombeneficiario;
	}
	public String getPlazainternacional() {
	    return plazainternacional;
	}
	public void setPlazainternacional(String plazainternacional) {
	this.plazainternacional = plazainternacional;
	}
	public String getPais() {
	    return pais;
	}
	public void setPais(String pais) {
	this.pais = pais;
	}
	public String getClavesiacinst() {
	    return clavesiacinst;
	}
	public void setClavesiacinst(String clavesiacinst) {
	this.clavesiacinst = clavesiacinst;
	}
	public String getConveniociedie() {
	    return conveniociedie;
	}
	public void setConveniociedie(String conveniociedie) {
	this.conveniociedie = conveniociedie;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getClabe() {
	    return clabe;
	}
	public void setClabe(String clabe) {
	this.clabe = clabe;
	}
	public String getCuentachequera(){
	    return cuentachequera;
	}
	public void setCuentachequera(String cuentachequera) {
		this.cuentachequera = cuentachequera;
	}
	public String getFechavence() {
	    return fechavence;
	}
	public void setFechavence(String fechavence) {
	this.fechavence = fechavence;
	}
	public String getNumabbasswift() {
	    return numabbasswift;
	}
	public void setNumabbasswift(String numabbasswift) {
	this.numabbasswift = numabbasswift;
	}
	public String getConceptosiac() {
	    return conceptosiac;
	}
	public void setConceptosiac(String conceptosiac) {
	this.conceptosiac = conceptosiac;
	}
	public String getRefciedie() {
	    return refciedie;
	}
	public void setRefciedie(String refciedie) {
	this.refciedie = refciedie;
	}
	public String getAutorizacion(){
	    return autorizacion;
	}
	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}

	// Se crea la entidad hija (Embebidos)			


}		
