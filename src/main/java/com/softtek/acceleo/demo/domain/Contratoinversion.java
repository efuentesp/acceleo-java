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
@Table(name = "contratoinversion")
public class Contratoinversion implements Serializable {

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
	@Column(name = "contratoinversionId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID contratoinversionId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JsonProperty("tipocontrato")
	private String tipocontrato;
	@NotNull
	@JsonProperty("intermediario")
	private String intermediario;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@JsonProperty("resparamliq")
	private String resparamliq;
	@NotNull
	@JsonProperty("enviorecursosinv")
	private String enviorecursosinv;
	@NotNull
	@JsonProperty("transferenciarecdesinver")
	private String transferenciarecdesinver;
	@NotNull
	@JsonProperty("retenerisr")
	private String retenerisr;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
	@Column(name = "fechavencimiento")
	@JsonProperty("fechavencimiento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechavencimiento;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;
	@Column(name = "contratoiversion")
	@JsonProperty("contratoiversion")
	private String contratoiversion;
	@Column(name = "contratootrasinst")
	@JsonProperty("contratootrasinst")
	private String contratootrasinst;
	@Column(name = "nombre")
	@JsonProperty("nombre")
	private String nombre;
	@Column(name = "cuenta")
	@JsonProperty("cuenta")
	private String cuenta;
	@NotNull
	@JsonProperty("traspasoentresubfiso")
	private String traspasoentresubfiso;
	@Column(name = "fechaapertura")
	@JsonProperty("fechaapertura")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaapertura;
	@NotNull
	@JsonProperty("origenrecursos")
	private String origenrecursos;
	@ManyToMany
	@JoinTable(name = "contratoinversiontelefonocontacto", 
	        joinColumns = { @JoinColumn(name = "contratoinversionId") }, 
	        inverseJoinColumns = { @JoinColumn(name = "telefonocontactoId") })
	private Set<Telefonocontacto> _contacto = new HashSet<Telefonocontacto>();

	public UUID getContratoinversionId() {
		return contratoinversionId;
	}

	public void setContratoinversionId(UUID contratoinversionId) {
		this.contratoinversionId = contratoinversionId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getTipocontrato(){
	    return tipocontrato;
	}
	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}
	public String getIntermediario(){
	    return intermediario;
	}
	public void setIntermediario(String intermediario) {
		this.intermediario = intermediario;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getResparamliq(){
	    return resparamliq;
	}
	public void setResparamliq(String resparamliq) {
		this.resparamliq = resparamliq;
	}
	public String getEnviorecursosinv(){
	    return enviorecursosinv;
	}
	public void setEnviorecursosinv(String enviorecursosinv) {
		this.enviorecursosinv = enviorecursosinv;
	}
	public String getTransferenciarecdesinver(){
	    return transferenciarecdesinver;
	}
	public void setTransferenciarecdesinver(String transferenciarecdesinver) {
		this.transferenciarecdesinver = transferenciarecdesinver;
	}
	public String getRetenerisr(){
	    return retenerisr;
	}
	public void setRetenerisr(String retenerisr) {
		this.retenerisr = retenerisr;
	}
	public Subfiso getSubfisoId (){
	    return subfisoId;
	}
	public void setSubfisoId(Subfiso subfisoId) {
		this.subfisoId = subfisoId;
	}
	public Date getFechavencimiento() {
	    return fechavencimiento;
	}
	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getContratoiversion() {
	    return contratoiversion;
	}
	public void setContratoiversion(String contratoiversion) {
	this.contratoiversion = contratoiversion;
	}
	public String getContratootrasinst() {
	    return contratootrasinst;
	}
	public void setContratootrasinst(String contratootrasinst) {
	this.contratootrasinst = contratootrasinst;
	}
	public String getNombre() {
	    return nombre;
	}
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	public String getCuenta() {
	    return cuenta;
	}
	public void setCuenta(String cuenta) {
	this.cuenta = cuenta;
	}
	public String getTraspasoentresubfiso(){
	    return traspasoentresubfiso;
	}
	public void setTraspasoentresubfiso(String traspasoentresubfiso) {
		this.traspasoentresubfiso = traspasoentresubfiso;
	}
	public Date getFechaapertura() {
	    return fechaapertura;
	}
	public void setFechaapertura(Date fechaapertura) {
		this.fechaapertura = fechaapertura;
	}
	public String getOrigenrecursos(){
	    return origenrecursos;
	}
	public void setOrigenrecursos(String origenrecursos) {
		this.origenrecursos = origenrecursos;
	}
	public Set<Telefonocontacto> get_contacto() {
		return _contacto;
	}
		
	public void set_contacto(Set<Telefonocontacto> _contacto) {
		this._contacto = _contacto;
	}

	// Se crea la entidad hija (Embebidos)			


}		
