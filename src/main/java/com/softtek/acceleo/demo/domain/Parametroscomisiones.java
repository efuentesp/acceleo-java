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
@Table(name = "parametroscomisiones")
public class Parametroscomisiones implements Serializable {

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
	@Column(name = "parametroscomisionesId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID parametroscomisionesId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JsonProperty("tipocalculo")
	private String tipocalculo;
	@NotNull
	@JsonProperty("aquiensecobra")
	private String aquiensecobra;
	@Column(name = "montoaceptacion")
	@JsonProperty("montoaceptacion")
	private Double montoaceptacion;
	@Column(name = "importeanualizado")
	@JsonProperty("importeanualizado")
	private String importeanualizado;
	@NotNull
	@JsonProperty("periodicidad")
	private String periodicidad;
	@NotNull
	@JsonProperty("calculoaldiaprimero")
	private String calculoaldiaprimero;
	@NotNull
	@JsonProperty("reevaluacion")
	private String reevaluacion;
	@Column(name = "fechaconstitucion")
	@JsonProperty("fechaconstitucion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaconstitucion;
	@Column(name = "fechapivote")
	@JsonProperty("fechapivote")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechapivote;
	@Column(name = "fechaproxcalculo")
	@JsonProperty("fechaproxcalculo")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaproxcalculo;
	@Column(name = "metodopago")
	@JsonProperty("metodopago")
	private String metodopago;
	@Column(name = "aquienfactura")
	@JsonProperty("aquienfactura")
	private String aquienfactura;
	@Column(name = "nombre")
	@JsonProperty("nombre")
	private String nombre;
	@Column(name = "comentario")
	@JsonProperty("comentario")
	private String comentario;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;
	@NotNull
	@JsonProperty("penasconvencionales")
	private String penasconvencionales;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@JsonProperty("interes")
	private String interes;
	@NotNull
	@JsonProperty("tipoiva")
	private String tipoiva;
	@NotNull
	@Column(name = "diacorte")
	@JsonProperty("diacorte")
	private Integer diacorte;
	@Column(name = "fechaprimercalculo")
	@JsonProperty("fechaprimercalculo")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaprimercalculo;
	@Column(name = "fechaultimocalculo")
	@JsonProperty("fechaultimocalculo")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaultimocalculo;
	@Column(name = "cuentapago")
	@JsonProperty("cuentapago")
	private String cuentapago;
	@Column(name = "numero")
	@JsonProperty("numero")
	private String numero;
	@NotNull
	@JsonProperty("situacionmorosidad")
	private String situacionmorosidad;

	public UUID getParametroscomisionesId() {
		return parametroscomisionesId;
	}

	public void setParametroscomisionesId(UUID parametroscomisionesId) {
		this.parametroscomisionesId = parametroscomisionesId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getTipocalculo(){
	    return tipocalculo;
	}
	public void setTipocalculo(String tipocalculo) {
		this.tipocalculo = tipocalculo;
	}
	public String getAquiensecobra(){
	    return aquiensecobra;
	}
	public void setAquiensecobra(String aquiensecobra) {
		this.aquiensecobra = aquiensecobra;
	}
	public Double getMontoaceptacion(){
	    return montoaceptacion;
	}
	public void setMontoaceptacion(Double montoaceptacion) {
		this.montoaceptacion = montoaceptacion;
	}
	public String getImporteanualizado() {
	    return importeanualizado;
	}
	public void setImporteanualizado(String importeanualizado) {
	this.importeanualizado = importeanualizado;
	}
	public String getPeriodicidad(){
	    return periodicidad;
	}
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}
	public String getCalculoaldiaprimero(){
	    return calculoaldiaprimero;
	}
	public void setCalculoaldiaprimero(String calculoaldiaprimero) {
		this.calculoaldiaprimero = calculoaldiaprimero;
	}
	public String getReevaluacion(){
	    return reevaluacion;
	}
	public void setReevaluacion(String reevaluacion) {
		this.reevaluacion = reevaluacion;
	}
	public Date getFechaconstitucion() {
	    return fechaconstitucion;
	}
	public void setFechaconstitucion(Date fechaconstitucion) {
		this.fechaconstitucion = fechaconstitucion;
	}
	public Date getFechapivote() {
	    return fechapivote;
	}
	public void setFechapivote(Date fechapivote) {
		this.fechapivote = fechapivote;
	}
	public Date getFechaproxcalculo() {
	    return fechaproxcalculo;
	}
	public void setFechaproxcalculo(Date fechaproxcalculo) {
		this.fechaproxcalculo = fechaproxcalculo;
	}
	public String getMetodopago() {
	    return metodopago;
	}
	public void setMetodopago(String metodopago) {
	this.metodopago = metodopago;
	}
	public String getAquienfactura() {
	    return aquienfactura;
	}
	public void setAquienfactura(String aquienfactura) {
	this.aquienfactura = aquienfactura;
	}
	public String getNombre() {
	    return nombre;
	}
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	public String getComentario() {
	    return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getPenasconvencionales(){
	    return penasconvencionales;
	}
	public void setPenasconvencionales(String penasconvencionales) {
		this.penasconvencionales = penasconvencionales;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getInteres(){
	    return interes;
	}
	public void setInteres(String interes) {
		this.interes = interes;
	}
	public String getTipoiva(){
	    return tipoiva;
	}
	public void setTipoiva(String tipoiva) {
		this.tipoiva = tipoiva;
	}
	public Integer getDiacorte(){
	    return diacorte;
	}
	public void setDiacorte(Integer diacorte) {
		this.diacorte = diacorte;
	}
	public Date getFechaprimercalculo() {
	    return fechaprimercalculo;
	}
	public void setFechaprimercalculo(Date fechaprimercalculo) {
		this.fechaprimercalculo = fechaprimercalculo;
	}
	public Date getFechaultimocalculo() {
	    return fechaultimocalculo;
	}
	public void setFechaultimocalculo(Date fechaultimocalculo) {
		this.fechaultimocalculo = fechaultimocalculo;
	}
	public String getCuentapago() {
	    return cuentapago;
	}
	public void setCuentapago(String cuentapago) {
	this.cuentapago = cuentapago;
	}
	public String getNumero() {
	    return numero;
	}
	public void setNumero(String numero) {
	this.numero = numero;
	}
	public String getSituacionmorosidad(){
	    return situacionmorosidad;
	}
	public void setSituacionmorosidad(String situacionmorosidad) {
		this.situacionmorosidad = situacionmorosidad;
	}

	// Se crea la entidad hija (Embebidos)			


}		
