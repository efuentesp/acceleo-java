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
@Table(name = "fideicomisario")
public class Fideicomisario implements Serializable {

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
	@Column(name = "fideicomisarioId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID fideicomisarioId;

	@NotNull
	@Column(name = "numerofideicomisario")
	@JsonProperty("numerofideicomisario")
	private String numerofideicomisario;
	@NotNull
	@JsonProperty("tipopersona")
	private String tipopersona;
	@NotNull
	@Column(name = "participante")
	@JsonProperty("participante")
	private String participante;
	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JsonProperty("regimenfiscal")
	private String regimenfiscal;
	@NotNull
	@JsonProperty("generales_controladorfideicomiso")
	private String generalescontroladorfideicomiso;
	@NotNull
	@JsonProperty("generales_nacionalidad")
	private String generalesnacionalidad;
	@NotNull
	@JsonProperty("generales_paisorigen")
	private String generalespaisorigen;
	@NotNull
	@JsonProperty("generales_actividad")
	private String generalesactividad;
	@NotNull
	@JsonProperty("generales_aportarecursos")
	private String generalesaportarecursos;
	@NotNull
	@JsonProperty("generales_paisresidencia")
	private String generalespaisresidencia;
	@NotNull
	@JsonProperty("generales_clientescotiabank")
	private String generalesclientescotiabank;
	@NotNull
	@JsonProperty("generales_pep")
	private String generalespep;
	@NotNull
	@JsonProperty("generales_estatus")
	private String generalesestatus;
	@Column(name = "generalesgrupofilial")
	@JsonProperty("generales_grupofilial")
	private String generalesgrupofilial;
	@NotNull
	@JsonProperty("generales_calidadmigratoria")
	private String generalescalidadmigratoria;
	@NotNull
	@JsonProperty("generales_lugaroperacion")
	private String generaleslugaroperacion;
	@NotNull
	@JsonProperty("generales_operacuentaterceros")
	private String generalesoperacuentaterceros;
	@NotNull
	@JsonProperty("generales_nivelparticipante")
	private String generalesnivelparticipante;
	@NotNull
	@JsonProperty("generales_clienterelacionpep")
	private String generalesclienterelacionpep;
	@Column(name = "generalesgrado")
	@JsonProperty("generales_grado")
	private String generalesgrado;
	@Column(name = "informacionpldkychonorarios")
	@JsonProperty("informacionpldkyc_honorarios")
	private String informacionpldkychonorarios;
	@NotNull
	@JsonProperty("informacionpldkyc_comisiones")
	private String informacionpldkyccomisiones;
	@NotNull
	@JsonProperty("informacionpldkyc_otros")
	private String informacionpldkycotros;
	@NotNull
	@JsonProperty("informacionpldkyc_sueldos")
	private String informacionpldkycsueldos;
	@NotNull
	@JsonProperty("informacionpldkyc_venta")
	private String informacionpldkycventa;
	@NotNull
	@JsonProperty("informacionpldkyc_inversiones")
	private String informacionpldkycinversiones;
	@NotNull
	@JsonProperty("informacionpldkyc_arrendamiento")
	private String informacionpldkycarrendamiento;
	@Column(name = "informacionpldkyctipopatrimonio")
	@JsonProperty("informacionpldkyc_tipopatrimonio")
	private String informacionpldkyctipopatrimonio;
	@NotNull
	@JsonProperty("informacionpldkyc_instrumento")
	private String informacionpldkycinstrumento;
	@Column(name = "informacionpldkycrazonapertura")
	@JsonProperty("informacionpldkyc_razonapertura")
	private String informacionpldkycrazonapertura;
	@Column(name = "informacionpldkyccomentarios")
	@JsonProperty("informacionpldkyc_comentarios")
	private String informacionpldkyccomentarios;
	@NotNull
	@JsonProperty("informacionpldkyc_nivelriesgo")
	private String informacionpldkycnivelriesgo;
	@Column(name = "informacionpldkycestatuscalculopld")
	@JsonProperty("informacionpldkyc_estatuscalculopld")
	private String informacionpldkycestatuscalculopld;
	@Column(name = "informacionpldkycfechaveriffircosoft")
	@JsonProperty("informacionpldkyc_fechaveriffircosoft")
	@Temporal(TemporalType.TIMESTAMP)
	private Date informacionpldkycfechaveriffircosoft;
	@Column(name = "identificacionrfc")
	@JsonProperty("identificacion_rfc")
	private String identificacionrfc;
	@Column(name = "identificacioncurp")
	@JsonProperty("identificacion_curp")
	private String identificacioncurp;
	@Column(name = "identificacionnoserieefirma")
	@JsonProperty("identificacion_noserieefirma")
	private String identificacionnoserieefirma;
	@Column(name = "identificacioncorreo")
	@JsonProperty("identificacion_correo")
	private String identificacioncorreo;
	@Column(name = "identificacionfechaconstitucion")
	@JsonProperty("identificacion_fechaconstitucion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date identificacionfechaconstitucion;
	@NotNull
	@JsonProperty("identificacion_sexo")
	private String identificacionsexo;
	@Column(name = "identificacionfechainiciorelneg")
	@JsonProperty("identificacion_fechainiciorelneg")
	@Temporal(TemporalType.TIMESTAMP)
	private Date identificacionfechainiciorelneg;
	@Column(name = "identificacionnoidentificacion")
	@JsonProperty("identificacion_noidentificacion")
	private String identificacionnoidentificacion;
	@Column(name = "identificacioncomprobaciondomicilio")
	@JsonProperty("identificacion_comprobaciondomicilio")
	private String identificacioncomprobaciondomicilio;
	@NotNull
	@JsonProperty("identificacion_actividadempresarial")
	private String identificacionactividadempresarial;
	@Column(name = "identificacionclasificacionfatca")
	@JsonProperty("identificacion_clasificacionfatca")
	private String identificacionclasificacionfatca;
	@Column(name = "identificacionidentoficialvig")
	@JsonProperty("identificacion_identoficialvig")
	private String identificacionidentoficialvig;
	@Column(name = "identificacionvigencia")
	@JsonProperty("identificacion_vigencia")
	private String identificacionvigencia;
	@NotNull
	@JsonProperty("identificacion_resideciafiscal_paisresidfisc1")
	private String identificacionresideciafiscalpaisresidfisc1;
	@Column(name = "identificacionresideciafiscalidentificacionnoidentfisc1")
	@JsonProperty("identificacion_resideciafiscal_identificacionnoidentfisc1")
	private String identificacionresideciafiscalidentificacionnoidentfisc1;
	@NotNull
	@JsonProperty("identificacion_telefonosfideicomitente_paiscasa")
	private String identificaciontelefonosfideicomitentepaiscasa;
	@NotNull
	@JsonProperty("identificacion_telefonosfideicomitente_paisoficina")
	private String identificaciontelefonosfideicomitentepaisoficina;
	@NotNull
	@JsonProperty("identificacion_telefonosfideicomitente_paiscelular")
	private String identificaciontelefonosfideicomitentepaiscelular;
	@Column(name = "identificaciontelefonosfideicomitenteladacasa")
	@JsonProperty("identificacion_telefonosfideicomitente_ladacasa")
	private String identificaciontelefonosfideicomitenteladacasa;
	@Column(name = "identificaciontelefonosfideicomitenteladaoficina")
	@JsonProperty("identificacion_telefonosfideicomitente_ladaoficina")
	private String identificaciontelefonosfideicomitenteladaoficina;
	@Column(name = "identificaciontelefonosfideicomitenteladacelular")
	@JsonProperty("identificacion_telefonosfideicomitente_ladacelular")
	private String identificaciontelefonosfideicomitenteladacelular;
	@Column(name = "identificaciontelefonosfideicomitentenumerocasa")
	@JsonProperty("identificacion_telefonosfideicomitente_numerocasa")
	private String identificaciontelefonosfideicomitentenumerocasa;
	@Column(name = "identificaciontelefonosfideicomitentenumerooficina")
	@JsonProperty("identificacion_telefonosfideicomitente_numerooficina")
	private String identificaciontelefonosfideicomitentenumerooficina;
	@Column(name = "identificaciontelefonosfideicomitentenumerocelular")
	@JsonProperty("identificacion_telefonosfideicomitente_numerocelular")
	private String identificaciontelefonosfideicomitentenumerocelular;
	@Column(name = "identificaciontelefonosfideicomitenteextoficina")
	@JsonProperty("identificacion_telefonosfideicomitente_extoficina")
	private String identificaciontelefonosfideicomitenteextoficina;
	@Column(name = "identificaciontelefonosfideicomitenteextcelular")
	@JsonProperty("identificacion_telefonosfideicomitente_extcelular")
	private String identificaciontelefonosfideicomitenteextcelular;
	@Column(name = "escrituranoescritura")
	@JsonProperty("escritura_noescritura")
	private String escrituranoescritura;
	@NotNull
	@JsonProperty("escritura_notario")
	private String escrituranotario;
	@Column(name = "escrituranonotaria")
	@JsonProperty("escritura_nonotaria")
	private String escrituranonotaria;
	@Column(name = "escrituraciudad")
	@JsonProperty("escritura_ciudad")
	private String escrituraciudad;
	@Column(name = "escrituraestado")
	@JsonProperty("escritura_estado")
	private String escrituraestado;
	@Column(name = "escriturafecha")
	@JsonProperty("escritura_fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date escriturafecha;
	@Column(name = "escrituratelefono")
	@JsonProperty("escritura_telefono")
	private String escrituratelefono;
	@Column(name = "escrituracorreo")
	@JsonProperty("escritura_correo")
	private String escrituracorreo;
	@ManyToMany
	@JoinTable(name = "fideicomisariocuentaskyc", 
	        joinColumns = { @JoinColumn(name = "fideicomisarioId") }, 
	        inverseJoinColumns = { @JoinColumn(name = "cuentaskycId") })
	private Set<Cuentaskyc> _cuentaskyc = new HashSet<Cuentaskyc>();

	public UUID getFideicomisarioId() {
		return fideicomisarioId;
	}

	public void setFideicomisarioId(UUID fideicomisarioId) {
		this.fideicomisarioId = fideicomisarioId;
	}
	
	public String getNumerofideicomisario() {
	    return numerofideicomisario;
	}
	public void setNumerofideicomisario(String numerofideicomisario) {
	this.numerofideicomisario = numerofideicomisario;
	}
	public String getTipopersona(){
	    return tipopersona;
	}
	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	public String getParticipante() {
	    return participante;
	}
	public void setParticipante(String participante) {
	this.participante = participante;
	}
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getRegimenfiscal(){
	    return regimenfiscal;
	}
	public void setRegimenfiscal(String regimenfiscal) {
		this.regimenfiscal = regimenfiscal;
	}
	public String getGeneralescontroladorfideicomiso(){
	    return generalescontroladorfideicomiso;
	}
	public void setGeneralescontroladorfideicomiso(String generalescontroladorfideicomiso) {
		this.generalescontroladorfideicomiso = generalescontroladorfideicomiso;
	}
	public String getGeneralesnacionalidad(){
	    return generalesnacionalidad;
	}
	public void setGeneralesnacionalidad(String generalesnacionalidad) {
		this.generalesnacionalidad = generalesnacionalidad;
	}
	public String getGeneralespaisorigen(){
	    return generalespaisorigen;
	}
	public void setGeneralespaisorigen(String generalespaisorigen) {
		this.generalespaisorigen = generalespaisorigen;
	}
	public String getGeneralesactividad(){
	    return generalesactividad;
	}
	public void setGeneralesactividad(String generalesactividad) {
		this.generalesactividad = generalesactividad;
	}
	public String getGeneralesaportarecursos(){
	    return generalesaportarecursos;
	}
	public void setGeneralesaportarecursos(String generalesaportarecursos) {
		this.generalesaportarecursos = generalesaportarecursos;
	}
	public String getGeneralespaisresidencia(){
	    return generalespaisresidencia;
	}
	public void setGeneralespaisresidencia(String generalespaisresidencia) {
		this.generalespaisresidencia = generalespaisresidencia;
	}
	public String getGeneralesclientescotiabank(){
	    return generalesclientescotiabank;
	}
	public void setGeneralesclientescotiabank(String generalesclientescotiabank) {
		this.generalesclientescotiabank = generalesclientescotiabank;
	}
	public String getGeneralespep(){
	    return generalespep;
	}
	public void setGeneralespep(String generalespep) {
		this.generalespep = generalespep;
	}
	public String getGeneralesestatus(){
	    return generalesestatus;
	}
	public void setGeneralesestatus(String generalesestatus) {
		this.generalesestatus = generalesestatus;
	}
	public String getGeneralesgrupofilial() {
	    return generalesgrupofilial;
	}
	public void setGeneralesgrupofilial(String generalesgrupofilial) {
	this.generalesgrupofilial = generalesgrupofilial;
	}
	public String getGeneralescalidadmigratoria(){
	    return generalescalidadmigratoria;
	}
	public void setGeneralescalidadmigratoria(String generalescalidadmigratoria) {
		this.generalescalidadmigratoria = generalescalidadmigratoria;
	}
	public String getGeneraleslugaroperacion(){
	    return generaleslugaroperacion;
	}
	public void setGeneraleslugaroperacion(String generaleslugaroperacion) {
		this.generaleslugaroperacion = generaleslugaroperacion;
	}
	public String getGeneralesoperacuentaterceros(){
	    return generalesoperacuentaterceros;
	}
	public void setGeneralesoperacuentaterceros(String generalesoperacuentaterceros) {
		this.generalesoperacuentaterceros = generalesoperacuentaterceros;
	}
	public String getGeneralesnivelparticipante(){
	    return generalesnivelparticipante;
	}
	public void setGeneralesnivelparticipante(String generalesnivelparticipante) {
		this.generalesnivelparticipante = generalesnivelparticipante;
	}
	public String getGeneralesclienterelacionpep(){
	    return generalesclienterelacionpep;
	}
	public void setGeneralesclienterelacionpep(String generalesclienterelacionpep) {
		this.generalesclienterelacionpep = generalesclienterelacionpep;
	}
	public String getGeneralesgrado() {
	    return generalesgrado;
	}
	public void setGeneralesgrado(String generalesgrado) {
	this.generalesgrado = generalesgrado;
	}
	public String getInformacionpldkychonorarios() {
	    return informacionpldkychonorarios;
	}
	public void setInformacionpldkychonorarios(String informacionpldkychonorarios) {
	this.informacionpldkychonorarios = informacionpldkychonorarios;
	}
	public String getInformacionpldkyccomisiones(){
	    return informacionpldkyccomisiones;
	}
	public void setInformacionpldkyccomisiones(String informacionpldkyccomisiones) {
		this.informacionpldkyccomisiones = informacionpldkyccomisiones;
	}
	public String getInformacionpldkycotros(){
	    return informacionpldkycotros;
	}
	public void setInformacionpldkycotros(String informacionpldkycotros) {
		this.informacionpldkycotros = informacionpldkycotros;
	}
	public String getInformacionpldkycsueldos(){
	    return informacionpldkycsueldos;
	}
	public void setInformacionpldkycsueldos(String informacionpldkycsueldos) {
		this.informacionpldkycsueldos = informacionpldkycsueldos;
	}
	public String getInformacionpldkycventa(){
	    return informacionpldkycventa;
	}
	public void setInformacionpldkycventa(String informacionpldkycventa) {
		this.informacionpldkycventa = informacionpldkycventa;
	}
	public String getInformacionpldkycinversiones(){
	    return informacionpldkycinversiones;
	}
	public void setInformacionpldkycinversiones(String informacionpldkycinversiones) {
		this.informacionpldkycinversiones = informacionpldkycinversiones;
	}
	public String getInformacionpldkycarrendamiento(){
	    return informacionpldkycarrendamiento;
	}
	public void setInformacionpldkycarrendamiento(String informacionpldkycarrendamiento) {
		this.informacionpldkycarrendamiento = informacionpldkycarrendamiento;
	}
	public String getInformacionpldkyctipopatrimonio() {
	    return informacionpldkyctipopatrimonio;
	}
	public void setInformacionpldkyctipopatrimonio(String informacionpldkyctipopatrimonio) {
	this.informacionpldkyctipopatrimonio = informacionpldkyctipopatrimonio;
	}
	public String getInformacionpldkycinstrumento(){
	    return informacionpldkycinstrumento;
	}
	public void setInformacionpldkycinstrumento(String informacionpldkycinstrumento) {
		this.informacionpldkycinstrumento = informacionpldkycinstrumento;
	}
	public String getInformacionpldkycrazonapertura() {
	    return informacionpldkycrazonapertura;
	}
	public void setInformacionpldkycrazonapertura(String informacionpldkycrazonapertura) {
		this.informacionpldkycrazonapertura = informacionpldkycrazonapertura;
	}
	public String getInformacionpldkyccomentarios() {
	    return informacionpldkyccomentarios;
	}
	public void setInformacionpldkyccomentarios(String informacionpldkyccomentarios) {
		this.informacionpldkyccomentarios = informacionpldkyccomentarios;
	}
	public String getInformacionpldkycnivelriesgo(){
	    return informacionpldkycnivelriesgo;
	}
	public void setInformacionpldkycnivelriesgo(String informacionpldkycnivelriesgo) {
		this.informacionpldkycnivelriesgo = informacionpldkycnivelriesgo;
	}
	public String getInformacionpldkycestatuscalculopld() {
	    return informacionpldkycestatuscalculopld;
	}
	public void setInformacionpldkycestatuscalculopld(String informacionpldkycestatuscalculopld) {
	this.informacionpldkycestatuscalculopld = informacionpldkycestatuscalculopld;
	}
	public Date getInformacionpldkycfechaveriffircosoft() {
	    return informacionpldkycfechaveriffircosoft;
	}
	public void setInformacionpldkycfechaveriffircosoft(Date informacionpldkycfechaveriffircosoft) {
		this.informacionpldkycfechaveriffircosoft = informacionpldkycfechaveriffircosoft;
	}
	public String getIdentificacionrfc() {
	    return identificacionrfc;
	}
	public void setIdentificacionrfc(String identificacionrfc) {
	this.identificacionrfc = identificacionrfc;
	}
	public String getIdentificacioncurp() {
	    return identificacioncurp;
	}
	public void setIdentificacioncurp(String identificacioncurp) {
	this.identificacioncurp = identificacioncurp;
	}
	public String getIdentificacionnoserieefirma() {
	    return identificacionnoserieefirma;
	}
	public void setIdentificacionnoserieefirma(String identificacionnoserieefirma) {
	this.identificacionnoserieefirma = identificacionnoserieefirma;
	}
	public String getIdentificacioncorreo() {
	    return identificacioncorreo;
	}
	public void setIdentificacioncorreo(String identificacioncorreo) {
		this.identificacioncorreo = identificacioncorreo;
	}
	public Date getIdentificacionfechaconstitucion() {
	    return identificacionfechaconstitucion;
	}
	public void setIdentificacionfechaconstitucion(Date identificacionfechaconstitucion) {
		this.identificacionfechaconstitucion = identificacionfechaconstitucion;
	}
	public String getIdentificacionsexo(){
	    return identificacionsexo;
	}
	public void setIdentificacionsexo(String identificacionsexo) {
		this.identificacionsexo = identificacionsexo;
	}
	public Date getIdentificacionfechainiciorelneg() {
	    return identificacionfechainiciorelneg;
	}
	public void setIdentificacionfechainiciorelneg(Date identificacionfechainiciorelneg) {
		this.identificacionfechainiciorelneg = identificacionfechainiciorelneg;
	}
	public String getIdentificacionnoidentificacion() {
	    return identificacionnoidentificacion;
	}
	public void setIdentificacionnoidentificacion(String identificacionnoidentificacion) {
	this.identificacionnoidentificacion = identificacionnoidentificacion;
	}
	public String getIdentificacioncomprobaciondomicilio() {
	    return identificacioncomprobaciondomicilio;
	}
	public void setIdentificacioncomprobaciondomicilio(String identificacioncomprobaciondomicilio) {
	this.identificacioncomprobaciondomicilio = identificacioncomprobaciondomicilio;
	}
	public String getIdentificacionactividadempresarial(){
	    return identificacionactividadempresarial;
	}
	public void setIdentificacionactividadempresarial(String identificacionactividadempresarial) {
		this.identificacionactividadempresarial = identificacionactividadempresarial;
	}
	public String getIdentificacionclasificacionfatca() {
	    return identificacionclasificacionfatca;
	}
	public void setIdentificacionclasificacionfatca(String identificacionclasificacionfatca) {
	this.identificacionclasificacionfatca = identificacionclasificacionfatca;
	}
	public String getIdentificacionidentoficialvig() {
	    return identificacionidentoficialvig;
	}
	public void setIdentificacionidentoficialvig(String identificacionidentoficialvig) {
	this.identificacionidentoficialvig = identificacionidentoficialvig;
	}
	public String getIdentificacionvigencia() {
	    return identificacionvigencia;
	}
	public void setIdentificacionvigencia(String identificacionvigencia) {
	this.identificacionvigencia = identificacionvigencia;
	}
	public String getIdentificacionresideciafiscalpaisresidfisc1(){
	    return identificacionresideciafiscalpaisresidfisc1;
	}
	public void setIdentificacionresideciafiscalpaisresidfisc1(String identificacionresideciafiscalpaisresidfisc1) {
		this.identificacionresideciafiscalpaisresidfisc1 = identificacionresideciafiscalpaisresidfisc1;
	}
	public String getIdentificacionresideciafiscalidentificacionnoidentfisc1() {
	    return identificacionresideciafiscalidentificacionnoidentfisc1;
	}
	public void setIdentificacionresideciafiscalidentificacionnoidentfisc1(String identificacionresideciafiscalidentificacionnoidentfisc1) {
	this.identificacionresideciafiscalidentificacionnoidentfisc1 = identificacionresideciafiscalidentificacionnoidentfisc1;
	}
	public String getIdentificaciontelefonosfideicomitentepaiscasa(){
	    return identificaciontelefonosfideicomitentepaiscasa;
	}
	public void setIdentificaciontelefonosfideicomitentepaiscasa(String identificaciontelefonosfideicomitentepaiscasa) {
		this.identificaciontelefonosfideicomitentepaiscasa = identificaciontelefonosfideicomitentepaiscasa;
	}
	public String getIdentificaciontelefonosfideicomitentepaisoficina(){
	    return identificaciontelefonosfideicomitentepaisoficina;
	}
	public void setIdentificaciontelefonosfideicomitentepaisoficina(String identificaciontelefonosfideicomitentepaisoficina) {
		this.identificaciontelefonosfideicomitentepaisoficina = identificaciontelefonosfideicomitentepaisoficina;
	}
	public String getIdentificaciontelefonosfideicomitentepaiscelular(){
	    return identificaciontelefonosfideicomitentepaiscelular;
	}
	public void setIdentificaciontelefonosfideicomitentepaiscelular(String identificaciontelefonosfideicomitentepaiscelular) {
		this.identificaciontelefonosfideicomitentepaiscelular = identificaciontelefonosfideicomitentepaiscelular;
	}
	public String getIdentificaciontelefonosfideicomitenteladacasa() {
	    return identificaciontelefonosfideicomitenteladacasa;
	}
	public void setIdentificaciontelefonosfideicomitenteladacasa(String identificaciontelefonosfideicomitenteladacasa) {
	this.identificaciontelefonosfideicomitenteladacasa = identificaciontelefonosfideicomitenteladacasa;
	}
	public String getIdentificaciontelefonosfideicomitenteladaoficina() {
	    return identificaciontelefonosfideicomitenteladaoficina;
	}
	public void setIdentificaciontelefonosfideicomitenteladaoficina(String identificaciontelefonosfideicomitenteladaoficina) {
	this.identificaciontelefonosfideicomitenteladaoficina = identificaciontelefonosfideicomitenteladaoficina;
	}
	public String getIdentificaciontelefonosfideicomitenteladacelular() {
	    return identificaciontelefonosfideicomitenteladacelular;
	}
	public void setIdentificaciontelefonosfideicomitenteladacelular(String identificaciontelefonosfideicomitenteladacelular) {
	this.identificaciontelefonosfideicomitenteladacelular = identificaciontelefonosfideicomitenteladacelular;
	}
	public String getIdentificaciontelefonosfideicomitentenumerocasa() {
	    return identificaciontelefonosfideicomitentenumerocasa;
	}
	public void setIdentificaciontelefonosfideicomitentenumerocasa(String identificaciontelefonosfideicomitentenumerocasa) {
	this.identificaciontelefonosfideicomitentenumerocasa = identificaciontelefonosfideicomitentenumerocasa;
	}
	public String getIdentificaciontelefonosfideicomitentenumerooficina() {
	    return identificaciontelefonosfideicomitentenumerooficina;
	}
	public void setIdentificaciontelefonosfideicomitentenumerooficina(String identificaciontelefonosfideicomitentenumerooficina) {
	this.identificaciontelefonosfideicomitentenumerooficina = identificaciontelefonosfideicomitentenumerooficina;
	}
	public String getIdentificaciontelefonosfideicomitentenumerocelular() {
	    return identificaciontelefonosfideicomitentenumerocelular;
	}
	public void setIdentificaciontelefonosfideicomitentenumerocelular(String identificaciontelefonosfideicomitentenumerocelular) {
	this.identificaciontelefonosfideicomitentenumerocelular = identificaciontelefonosfideicomitentenumerocelular;
	}
	public String getIdentificaciontelefonosfideicomitenteextoficina() {
	    return identificaciontelefonosfideicomitenteextoficina;
	}
	public void setIdentificaciontelefonosfideicomitenteextoficina(String identificaciontelefonosfideicomitenteextoficina) {
	this.identificaciontelefonosfideicomitenteextoficina = identificaciontelefonosfideicomitenteextoficina;
	}
	public String getIdentificaciontelefonosfideicomitenteextcelular() {
	    return identificaciontelefonosfideicomitenteextcelular;
	}
	public void setIdentificaciontelefonosfideicomitenteextcelular(String identificaciontelefonosfideicomitenteextcelular) {
	this.identificaciontelefonosfideicomitenteextcelular = identificaciontelefonosfideicomitenteextcelular;
	}
	public String getEscrituranoescritura() {
	    return escrituranoescritura;
	}
	public void setEscrituranoescritura(String escrituranoescritura) {
	this.escrituranoescritura = escrituranoescritura;
	}
	public String getEscrituranotario(){
	    return escrituranotario;
	}
	public void setEscrituranotario(String escrituranotario) {
		this.escrituranotario = escrituranotario;
	}
	public String getEscrituranonotaria() {
	    return escrituranonotaria;
	}
	public void setEscrituranonotaria(String escrituranonotaria) {
	this.escrituranonotaria = escrituranonotaria;
	}
	public String getEscrituraciudad() {
	    return escrituraciudad;
	}
	public void setEscrituraciudad(String escrituraciudad) {
	this.escrituraciudad = escrituraciudad;
	}
	public String getEscrituraestado() {
	    return escrituraestado;
	}
	public void setEscrituraestado(String escrituraestado) {
	this.escrituraestado = escrituraestado;
	}
	public Date getEscriturafecha() {
	    return escriturafecha;
	}
	public void setEscriturafecha(Date escriturafecha) {
		this.escriturafecha = escriturafecha;
	}
	public String getEscrituratelefono() {
	    return escrituratelefono;
	}
	public void setEscrituratelefono(String escrituratelefono) {
	this.escrituratelefono = escrituratelefono;
	}
	public String getEscrituracorreo() {
	    return escrituracorreo;
	}
	public void setEscrituracorreo(String escrituracorreo) {
		this.escrituracorreo = escrituracorreo;
	}
	public Set<Cuentaskyc> get_cuentaskyc() {
		return _cuentaskyc;
	}
		
	public void set_cuentaskyc(Set<Cuentaskyc> _cuentaskyc) {
		this._cuentaskyc = _cuentaskyc;
	}

	// Se crea la entidad hija (Embebidos)			


}		
