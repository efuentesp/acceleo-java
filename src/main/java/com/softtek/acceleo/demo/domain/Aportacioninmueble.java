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
@Table(name = "aportacioninmueble")
public class Aportacioninmueble implements Serializable {

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
	@Column(name = "aportacioninmuebleId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID aportacioninmuebleId;

	@Column(name = "dummy")
	@JsonProperty("dummy")
	private String dummy;
	@NotNull
	@JoinColumn(name = "datosfideicomiso_fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso datosfideicomisofideicomisoId;
	@NotNull
	@JoinColumn(name = "datosfideicomiso_subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso datosfideicomisosubfisoId;
	@NotNull
	@Column(name = "datosfideicomisotiponegocio")
	@JsonProperty("datosfideicomiso_tiponegocio")
	private String datosfideicomisotiponegocio;
	@NotNull
	@Column(name = "datosfideicomisoproducto")
	@JsonProperty("datosfideicomiso_producto")
	private String datosfideicomisoproducto;
	@NotNull
	@Column(name = "identificacioninmuebleidinmueble")
	@JsonProperty("identificacioninmueble_idinmueble")
	private String identificacioninmuebleidinmueble;
	@Column(name = "identificacioninmueblefechaalta")
	@JsonProperty("identificacioninmueble_fechaalta")
	@Temporal(TemporalType.TIMESTAMP)
	private Date identificacioninmueblefechaalta;
	@NotNull
	@JsonProperty("identificacioninmueble_tipoinmueble")
	private String identificacioninmuebletipoinmueble;
	@Column(name = "identificacioninmueblearbol")
	@JsonProperty("identificacioninmueble_arbol")
	private String identificacioninmueblearbol;
	@Column(name = "identificacioninmueblefecharegistro")
	@JsonProperty("identificacioninmueble_fecharegistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date identificacioninmueblefecharegistro;
	@NotNull
	@JsonProperty("identificacioninmueble_tipofraccion")
	private String identificacioninmuebletipofraccion;
	@NotNull
	@Column(name = "identificacioninmuebledescripcion")
	@JsonProperty("identificacioninmueble_descripcion")
	private String identificacioninmuebledescripcion;
	@NotNull
	@Column(name = "generalesinmueblevalorinicial")
	@JsonProperty("generalesinmueble_valorinicial")
	private String generalesinmueblevalorinicial;
	@NotNull
	@Column(name = "generalesinmuebleubicacion")
	@JsonProperty("generalesinmueble_ubicacion")
	private String generalesinmuebleubicacion;
	@NotNull
	@JsonProperty("generalesinmueble_estado")
	private String generalesinmuebleestado;
	@Column(name = "generalesinmueblesuperficie")
	@JsonProperty("generalesinmueble_superficie")
	private String generalesinmueblesuperficie;
	@Column(name = "generalesinmuebleindivisos")
	@JsonProperty("generalesinmueble_indivisos")
	private String generalesinmuebleindivisos;
	@Column(name = "generalesinmuebledias")
	@JsonProperty("generalesinmueble_dias")
	private String generalesinmuebledias;
	@Column(name = "generalesinmuebleproyectoejecutivo")
	@JsonProperty("generalesinmueble_proyectoejecutivo")
	private String generalesinmuebleproyectoejecutivo;
	@Column(name = "generalesinmueblevaloractual")
	@JsonProperty("generalesinmueble_valoractual")
	private String generalesinmueblevaloractual;
	@NotNull
	@Column(name = "generalesinmuebleciudad")
	@JsonProperty("generalesinmueble_ciudad")
	private String generalesinmuebleciudad;
	@NotNull
	@Column(name = "generalesinmueblesuperficieconstruida")
	@JsonProperty("generalesinmueble_superficieconstruida")
	private String generalesinmueblesuperficieconstruida;
	@Column(name = "generalesinmueblefraccionamientounidad")
	@JsonProperty("generalesinmueble_fraccionamientounidad")
	private String generalesinmueblefraccionamientounidad;
	@Column(name = "generalesinmuebleclavecatastral")
	@JsonProperty("generalesinmueble_clavecatastral")
	private String generalesinmuebleclavecatastral;
	@Column(name = "generalesinmueblevalor")
	@JsonProperty("generalesinmueble_valor")
	private String generalesinmueblevalor;
	@NotNull
	@JsonProperty("generalesinmueble_estatus")
	private String generalesinmuebleestatus;
	@NotNull
	@JsonProperty("datosconstitucion_escritura")
	private String datosconstitucionescritura;
	@Column(name = "datosconstitucionnumescritura")
	@JsonProperty("datosconstitucion_numescritura")
	private String datosconstitucionnumescritura;
	@NotNull
	@JsonProperty("datosconstitucion_nombrenotario")
	private String datosconstitucionnombrenotario;
	@Column(name = "datosconstitucionestadonotario")
	@JsonProperty("datosconstitucion_estadonotario")
	private String datosconstitucionestadonotario;
	@Column(name = "datosconstituciontelefononotario")
	@JsonProperty("datosconstitucion_telefononotario")
	private String datosconstituciontelefononotario;
	@NotNull
	@Column(name = "datosconstitucionfecharpp")
	@JsonProperty("datosconstitucion_fecharpp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datosconstitucionfecharpp;
	@Column(name = "datosconstitucionfechaescritura")
	@JsonProperty("datosconstitucion_fechaescritura")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datosconstitucionfechaescritura;
	@NotNull
	@Column(name = "datosconstitucionnumnotaria")
	@JsonProperty("datosconstitucion_numnotaria")
	private String datosconstitucionnumnotaria;
	@Column(name = "datosconstitucionciudadnotario")
	@JsonProperty("datosconstitucion_ciudadnotario")
	private String datosconstitucionciudadnotario;
	@Column(name = "datosconstitucionemailnotario")
	@JsonProperty("datosconstitucion_emailnotario")
	private String datosconstitucionemailnotario;
	@Column(name = "datosconstitucionnumrpp")
	@JsonProperty("datosconstitucion_numrpp")
	private String datosconstitucionnumrpp;

	public UUID getAportacioninmuebleId() {
		return aportacioninmuebleId;
	}

	public void setAportacioninmuebleId(UUID aportacioninmuebleId) {
		this.aportacioninmuebleId = aportacioninmuebleId;
	}
	
	public String getDummy() {
	    return dummy;
	}
	public void setDummy(String dummy) {
	this.dummy = dummy;
	}
	public Fideicomiso getDatosfideicomisofideicomisoId (){
	    return datosfideicomisofideicomisoId;
	}
	public void setDatosfideicomisofideicomisoId(Fideicomiso datosfideicomisofideicomisoId) {
		this.datosfideicomisofideicomisoId = datosfideicomisofideicomisoId;
	}
	public Subfiso getDatosfideicomisosubfisoId (){
	    return datosfideicomisosubfisoId;
	}
	public void setDatosfideicomisosubfisoId(Subfiso datosfideicomisosubfisoId) {
		this.datosfideicomisosubfisoId = datosfideicomisosubfisoId;
	}
	public String getDatosfideicomisotiponegocio() {
	    return datosfideicomisotiponegocio;
	}
	public void setDatosfideicomisotiponegocio(String datosfideicomisotiponegocio) {
	this.datosfideicomisotiponegocio = datosfideicomisotiponegocio;
	}
	public String getDatosfideicomisoproducto() {
	    return datosfideicomisoproducto;
	}
	public void setDatosfideicomisoproducto(String datosfideicomisoproducto) {
	this.datosfideicomisoproducto = datosfideicomisoproducto;
	}
	public String getIdentificacioninmuebleidinmueble() {
	    return identificacioninmuebleidinmueble;
	}
	public void setIdentificacioninmuebleidinmueble(String identificacioninmuebleidinmueble) {
	this.identificacioninmuebleidinmueble = identificacioninmuebleidinmueble;
	}
	public Date getIdentificacioninmueblefechaalta() {
	    return identificacioninmueblefechaalta;
	}
	public void setIdentificacioninmueblefechaalta(Date identificacioninmueblefechaalta) {
		this.identificacioninmueblefechaalta = identificacioninmueblefechaalta;
	}
	public String getIdentificacioninmuebletipoinmueble(){
	    return identificacioninmuebletipoinmueble;
	}
	public void setIdentificacioninmuebletipoinmueble(String identificacioninmuebletipoinmueble) {
		this.identificacioninmuebletipoinmueble = identificacioninmuebletipoinmueble;
	}
	public String getIdentificacioninmueblearbol() {
	    return identificacioninmueblearbol;
	}
	public void setIdentificacioninmueblearbol(String identificacioninmueblearbol) {
	this.identificacioninmueblearbol = identificacioninmueblearbol;
	}
	public Date getIdentificacioninmueblefecharegistro() {
	    return identificacioninmueblefecharegistro;
	}
	public void setIdentificacioninmueblefecharegistro(Date identificacioninmueblefecharegistro) {
		this.identificacioninmueblefecharegistro = identificacioninmueblefecharegistro;
	}
	public String getIdentificacioninmuebletipofraccion(){
	    return identificacioninmuebletipofraccion;
	}
	public void setIdentificacioninmuebletipofraccion(String identificacioninmuebletipofraccion) {
		this.identificacioninmuebletipofraccion = identificacioninmuebletipofraccion;
	}
	public String getIdentificacioninmuebledescripcion() {
	    return identificacioninmuebledescripcion;
	}
	public void setIdentificacioninmuebledescripcion(String identificacioninmuebledescripcion) {
		this.identificacioninmuebledescripcion = identificacioninmuebledescripcion;
	}
	public String getGeneralesinmueblevalorinicial() {
	    return generalesinmueblevalorinicial;
	}
	public void setGeneralesinmueblevalorinicial(String generalesinmueblevalorinicial) {
	this.generalesinmueblevalorinicial = generalesinmueblevalorinicial;
	}
	public String getGeneralesinmuebleubicacion() {
	    return generalesinmuebleubicacion;
	}
	public void setGeneralesinmuebleubicacion(String generalesinmuebleubicacion) {
	this.generalesinmuebleubicacion = generalesinmuebleubicacion;
	}
	public String getGeneralesinmuebleestado(){
	    return generalesinmuebleestado;
	}
	public void setGeneralesinmuebleestado(String generalesinmuebleestado) {
		this.generalesinmuebleestado = generalesinmuebleestado;
	}
	public String getGeneralesinmueblesuperficie() {
	    return generalesinmueblesuperficie;
	}
	public void setGeneralesinmueblesuperficie(String generalesinmueblesuperficie) {
	this.generalesinmueblesuperficie = generalesinmueblesuperficie;
	}
	public String getGeneralesinmuebleindivisos() {
	    return generalesinmuebleindivisos;
	}
	public void setGeneralesinmuebleindivisos(String generalesinmuebleindivisos) {
	this.generalesinmuebleindivisos = generalesinmuebleindivisos;
	}
	public String getGeneralesinmuebledias() {
	    return generalesinmuebledias;
	}
	public void setGeneralesinmuebledias(String generalesinmuebledias) {
	this.generalesinmuebledias = generalesinmuebledias;
	}
	public String getGeneralesinmuebleproyectoejecutivo() {
	    return generalesinmuebleproyectoejecutivo;
	}
	public void setGeneralesinmuebleproyectoejecutivo(String generalesinmuebleproyectoejecutivo) {
	this.generalesinmuebleproyectoejecutivo = generalesinmuebleproyectoejecutivo;
	}
	public String getGeneralesinmueblevaloractual() {
	    return generalesinmueblevaloractual;
	}
	public void setGeneralesinmueblevaloractual(String generalesinmueblevaloractual) {
	this.generalesinmueblevaloractual = generalesinmueblevaloractual;
	}
	public String getGeneralesinmuebleciudad() {
	    return generalesinmuebleciudad;
	}
	public void setGeneralesinmuebleciudad(String generalesinmuebleciudad) {
	this.generalesinmuebleciudad = generalesinmuebleciudad;
	}
	public String getGeneralesinmueblesuperficieconstruida() {
	    return generalesinmueblesuperficieconstruida;
	}
	public void setGeneralesinmueblesuperficieconstruida(String generalesinmueblesuperficieconstruida) {
	this.generalesinmueblesuperficieconstruida = generalesinmueblesuperficieconstruida;
	}
	public String getGeneralesinmueblefraccionamientounidad() {
	    return generalesinmueblefraccionamientounidad;
	}
	public void setGeneralesinmueblefraccionamientounidad(String generalesinmueblefraccionamientounidad) {
	this.generalesinmueblefraccionamientounidad = generalesinmueblefraccionamientounidad;
	}
	public String getGeneralesinmuebleclavecatastral() {
	    return generalesinmuebleclavecatastral;
	}
	public void setGeneralesinmuebleclavecatastral(String generalesinmuebleclavecatastral) {
	this.generalesinmuebleclavecatastral = generalesinmuebleclavecatastral;
	}
	public String getGeneralesinmueblevalor() {
	    return generalesinmueblevalor;
	}
	public void setGeneralesinmueblevalor(String generalesinmueblevalor) {
	this.generalesinmueblevalor = generalesinmueblevalor;
	}
	public String getGeneralesinmuebleestatus(){
	    return generalesinmuebleestatus;
	}
	public void setGeneralesinmuebleestatus(String generalesinmuebleestatus) {
		this.generalesinmuebleestatus = generalesinmuebleestatus;
	}
	public String getDatosconstitucionescritura(){
	    return datosconstitucionescritura;
	}
	public void setDatosconstitucionescritura(String datosconstitucionescritura) {
		this.datosconstitucionescritura = datosconstitucionescritura;
	}
	public String getDatosconstitucionnumescritura() {
	    return datosconstitucionnumescritura;
	}
	public void setDatosconstitucionnumescritura(String datosconstitucionnumescritura) {
	this.datosconstitucionnumescritura = datosconstitucionnumescritura;
	}
	public String getDatosconstitucionnombrenotario(){
	    return datosconstitucionnombrenotario;
	}
	public void setDatosconstitucionnombrenotario(String datosconstitucionnombrenotario) {
		this.datosconstitucionnombrenotario = datosconstitucionnombrenotario;
	}
	public String getDatosconstitucionestadonotario() {
	    return datosconstitucionestadonotario;
	}
	public void setDatosconstitucionestadonotario(String datosconstitucionestadonotario) {
	this.datosconstitucionestadonotario = datosconstitucionestadonotario;
	}
	public String getDatosconstituciontelefononotario() {
	    return datosconstituciontelefononotario;
	}
	public void setDatosconstituciontelefononotario(String datosconstituciontelefononotario) {
	this.datosconstituciontelefononotario = datosconstituciontelefononotario;
	}
	public Date getDatosconstitucionfecharpp() {
	    return datosconstitucionfecharpp;
	}
	public void setDatosconstitucionfecharpp(Date datosconstitucionfecharpp) {
		this.datosconstitucionfecharpp = datosconstitucionfecharpp;
	}
	public Date getDatosconstitucionfechaescritura() {
	    return datosconstitucionfechaescritura;
	}
	public void setDatosconstitucionfechaescritura(Date datosconstitucionfechaescritura) {
		this.datosconstitucionfechaescritura = datosconstitucionfechaescritura;
	}
	public String getDatosconstitucionnumnotaria() {
	    return datosconstitucionnumnotaria;
	}
	public void setDatosconstitucionnumnotaria(String datosconstitucionnumnotaria) {
	this.datosconstitucionnumnotaria = datosconstitucionnumnotaria;
	}
	public String getDatosconstitucionciudadnotario() {
	    return datosconstitucionciudadnotario;
	}
	public void setDatosconstitucionciudadnotario(String datosconstitucionciudadnotario) {
	this.datosconstitucionciudadnotario = datosconstitucionciudadnotario;
	}
	public String getDatosconstitucionemailnotario() {
	    return datosconstitucionemailnotario;
	}
	public void setDatosconstitucionemailnotario(String datosconstitucionemailnotario) {
	this.datosconstitucionemailnotario = datosconstitucionemailnotario;
	}
	public String getDatosconstitucionnumrpp() {
	    return datosconstitucionnumrpp;
	}
	public void setDatosconstitucionnumrpp(String datosconstitucionnumrpp) {
	this.datosconstitucionnumrpp = datosconstitucionnumrpp;
	}

	// Se crea la entidad hija (Embebidos)			


}		
