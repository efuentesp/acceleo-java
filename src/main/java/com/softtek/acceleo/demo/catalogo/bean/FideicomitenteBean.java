package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.domain.Cuentaskyc;

public class FideicomitenteBean {

/**
 * Clase FideicomitenteBean.
 * @author PSG.
 *
 */
 
private UUID fideicomitenteId; 
private String numerofideicomitente;
private String tipopersona;
private String participante;
private UUID fideicomisoId;
private String regimenfiscal;
private String generales_controladorfideicomiso;
private String generales_nacionalidad;
private String generales_paisorigen;
private String generales_actividad;
private String generales_aportarecursos;
private String generales_paisresidencia;
private String generales_clientescotiabank;
private String generales_pep;
private String generales_estatus;
private String generales_grupofilial;
private String generales_calidadmigratoria;
private String generales_lugaroperacion;
private String generales_operacuentaterceros;
private String generales_nivelparticipante;
private String generales_clienterelacionpep;
private String generales_grado;
private String informacionpldkyc_honorarios;
private String informacionpldkyc_comisiones;
private String informacionpldkyc_otros;
private String informacionpldkyc_sueldos;
private String informacionpldkyc_venta;
private String informacionpldkyc_inversiones;
private String informacionpldkyc_arrendamiento;
private String informacionpldkyc_tipopatrimonio;
private String informacionpldkyc_instrumento;
private String informacionpldkyc_razonapertura;
private String informacionpldkyc_comentarios;
private String informacionpldkyc_nivelriesgo;
private String informacionpldkyc_estatuscalculopld;
private Date informacionpldkyc_fechaveriffircosoft;
private String identificacion_rfc;
private String identificacion_curp;
private String identificacion_noserieefirma;
private String identificacion_correo;
private Date identificacion_fechaconstitucion;
private String identificacion_sexo;
private Date identificacion_fechainiciorelneg;
private String identificacion_noidentificacion;
private String identificacion_comprobaciondomicilio;
private String identificacion_actividadempresarial;
private String identificacion_clasificacionfatca;
private String identificacion_identoficialvig;
private String identificacion_vigencia;
private String identificacion_resideciafiscal_paisresidfisc1;
private String identificacion_resideciafiscal_identificacionnoidentfisc1;
private String identificacion_telefonosfideicomitente_paiscasa;
private String identificacion_telefonosfideicomitente_paisoficina;
private String identificacion_telefonosfideicomitente_paiscelular;
private String identificacion_telefonosfideicomitente_ladacasa;
private String identificacion_telefonosfideicomitente_ladaoficina;
private String identificacion_telefonosfideicomitente_ladacelular;
private String identificacion_telefonosfideicomitente_numerocasa;
private String identificacion_telefonosfideicomitente_numerooficina;
private String identificacion_telefonosfideicomitente_numerocelular;
private String identificacion_telefonosfideicomitente_extoficina;
private String identificacion_telefonosfideicomitente_extcelular;
private String escritura_noescritura;
private String escritura_notario;
private String escritura_nonotaria;
private String escritura_ciudad;
private String escritura_estado;
private Date escritura_fecha;
private String escritura_telefono;
private String escritura_correo;
private Set<Cuentaskyc> _cuentaskyc;

public UUID getFideicomitenteId() {
    return fideicomitenteId;  		
   }
public void setFideicomitenteId(UUID fideicomitenteId) {
	this.fideicomitenteId = fideicomitenteId;
}

public String getNumerofideicomitente() {
    return numerofideicomitente;
}
public void setNumerofideicomitente(String numerofideicomitente) {
	this.numerofideicomitente = numerofideicomitente;
}
public String getTipopersona() {
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
public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public String getRegimenfiscal() {
    return regimenfiscal;
}
public void setRegimenfiscal(String regimenfiscal) {
	this.regimenfiscal = regimenfiscal;
}
public String getGenerales_controladorfideicomiso() {
    return generales_controladorfideicomiso;
}
public void setGenerales_controladorfideicomiso(String generales_controladorfideicomiso) {
	this.generales_controladorfideicomiso = generales_controladorfideicomiso;
}
public String getGenerales_nacionalidad() {
    return generales_nacionalidad;
}
public void setGenerales_nacionalidad(String generales_nacionalidad) {
	this.generales_nacionalidad = generales_nacionalidad;
}
public String getGenerales_paisorigen() {
    return generales_paisorigen;
}
public void setGenerales_paisorigen(String generales_paisorigen) {
	this.generales_paisorigen = generales_paisorigen;
}
public String getGenerales_actividad() {
    return generales_actividad;
}
public void setGenerales_actividad(String generales_actividad) {
	this.generales_actividad = generales_actividad;
}
public String getGenerales_aportarecursos() {
    return generales_aportarecursos;
}
public void setGenerales_aportarecursos(String generales_aportarecursos) {
	this.generales_aportarecursos = generales_aportarecursos;
}
public String getGenerales_paisresidencia() {
    return generales_paisresidencia;
}
public void setGenerales_paisresidencia(String generales_paisresidencia) {
	this.generales_paisresidencia = generales_paisresidencia;
}
public String getGenerales_clientescotiabank() {
    return generales_clientescotiabank;
}
public void setGenerales_clientescotiabank(String generales_clientescotiabank) {
	this.generales_clientescotiabank = generales_clientescotiabank;
}
public String getGenerales_pep() {
    return generales_pep;
}
public void setGenerales_pep(String generales_pep) {
	this.generales_pep = generales_pep;
}
public String getGenerales_estatus() {
    return generales_estatus;
}
public void setGenerales_estatus(String generales_estatus) {
	this.generales_estatus = generales_estatus;
}
public String getGenerales_grupofilial() {
    return generales_grupofilial;
}
public void setGenerales_grupofilial(String generales_grupofilial) {
	this.generales_grupofilial = generales_grupofilial;
}
public String getGenerales_calidadmigratoria() {
    return generales_calidadmigratoria;
}
public void setGenerales_calidadmigratoria(String generales_calidadmigratoria) {
	this.generales_calidadmigratoria = generales_calidadmigratoria;
}
public String getGenerales_lugaroperacion() {
    return generales_lugaroperacion;
}
public void setGenerales_lugaroperacion(String generales_lugaroperacion) {
	this.generales_lugaroperacion = generales_lugaroperacion;
}
public String getGenerales_operacuentaterceros() {
    return generales_operacuentaterceros;
}
public void setGenerales_operacuentaterceros(String generales_operacuentaterceros) {
	this.generales_operacuentaterceros = generales_operacuentaterceros;
}
public String getGenerales_nivelparticipante() {
    return generales_nivelparticipante;
}
public void setGenerales_nivelparticipante(String generales_nivelparticipante) {
	this.generales_nivelparticipante = generales_nivelparticipante;
}
public String getGenerales_clienterelacionpep() {
    return generales_clienterelacionpep;
}
public void setGenerales_clienterelacionpep(String generales_clienterelacionpep) {
	this.generales_clienterelacionpep = generales_clienterelacionpep;
}
public String getGenerales_grado() {
    return generales_grado;
}
public void setGenerales_grado(String generales_grado) {
	this.generales_grado = generales_grado;
}
public String getInformacionpldkyc_honorarios() {
    return informacionpldkyc_honorarios;
}
public void setInformacionpldkyc_honorarios(String informacionpldkyc_honorarios) {
	this.informacionpldkyc_honorarios = informacionpldkyc_honorarios;
}
public String getInformacionpldkyc_comisiones() {
    return informacionpldkyc_comisiones;
}
public void setInformacionpldkyc_comisiones(String informacionpldkyc_comisiones) {
	this.informacionpldkyc_comisiones = informacionpldkyc_comisiones;
}
public String getInformacionpldkyc_otros() {
    return informacionpldkyc_otros;
}
public void setInformacionpldkyc_otros(String informacionpldkyc_otros) {
	this.informacionpldkyc_otros = informacionpldkyc_otros;
}
public String getInformacionpldkyc_sueldos() {
    return informacionpldkyc_sueldos;
}
public void setInformacionpldkyc_sueldos(String informacionpldkyc_sueldos) {
	this.informacionpldkyc_sueldos = informacionpldkyc_sueldos;
}
public String getInformacionpldkyc_venta() {
    return informacionpldkyc_venta;
}
public void setInformacionpldkyc_venta(String informacionpldkyc_venta) {
	this.informacionpldkyc_venta = informacionpldkyc_venta;
}
public String getInformacionpldkyc_inversiones() {
    return informacionpldkyc_inversiones;
}
public void setInformacionpldkyc_inversiones(String informacionpldkyc_inversiones) {
	this.informacionpldkyc_inversiones = informacionpldkyc_inversiones;
}
public String getInformacionpldkyc_arrendamiento() {
    return informacionpldkyc_arrendamiento;
}
public void setInformacionpldkyc_arrendamiento(String informacionpldkyc_arrendamiento) {
	this.informacionpldkyc_arrendamiento = informacionpldkyc_arrendamiento;
}
public String getInformacionpldkyc_tipopatrimonio() {
    return informacionpldkyc_tipopatrimonio;
}
public void setInformacionpldkyc_tipopatrimonio(String informacionpldkyc_tipopatrimonio) {
	this.informacionpldkyc_tipopatrimonio = informacionpldkyc_tipopatrimonio;
}
public String getInformacionpldkyc_instrumento() {
    return informacionpldkyc_instrumento;
}
public void setInformacionpldkyc_instrumento(String informacionpldkyc_instrumento) {
	this.informacionpldkyc_instrumento = informacionpldkyc_instrumento;
}
public String getInformacionpldkyc_razonapertura() {
    return informacionpldkyc_razonapertura;
}
public void setInformacionpldkyc_razonapertura(String informacionpldkyc_razonapertura) {
	this.informacionpldkyc_razonapertura = informacionpldkyc_razonapertura;
}	
public String getInformacionpldkyc_comentarios() {
    return informacionpldkyc_comentarios;
}
public void setInformacionpldkyc_comentarios(String informacionpldkyc_comentarios) {
	this.informacionpldkyc_comentarios = informacionpldkyc_comentarios;
}	
public String getInformacionpldkyc_nivelriesgo() {
    return informacionpldkyc_nivelriesgo;
}
public void setInformacionpldkyc_nivelriesgo(String informacionpldkyc_nivelriesgo) {
	this.informacionpldkyc_nivelriesgo = informacionpldkyc_nivelriesgo;
}
public String getInformacionpldkyc_estatuscalculopld() {
    return informacionpldkyc_estatuscalculopld;
}
public void setInformacionpldkyc_estatuscalculopld(String informacionpldkyc_estatuscalculopld) {
	this.informacionpldkyc_estatuscalculopld = informacionpldkyc_estatuscalculopld;
}
public Date getInformacionpldkyc_fechaveriffircosoft() {
    return informacionpldkyc_fechaveriffircosoft;
}
public void setInformacionpldkyc_fechaveriffircosoft(Date informacionpldkyc_fechaveriffircosoft) {
	this.informacionpldkyc_fechaveriffircosoft = informacionpldkyc_fechaveriffircosoft;
}
public String getIdentificacion_rfc() {
    return identificacion_rfc;
}
public void setIdentificacion_rfc(String identificacion_rfc) {
	this.identificacion_rfc = identificacion_rfc;
}
public String getIdentificacion_curp() {
    return identificacion_curp;
}
public void setIdentificacion_curp(String identificacion_curp) {
	this.identificacion_curp = identificacion_curp;
}
public String getIdentificacion_noserieefirma() {
    return identificacion_noserieefirma;
}
public void setIdentificacion_noserieefirma(String identificacion_noserieefirma) {
	this.identificacion_noserieefirma = identificacion_noserieefirma;
}
public String getIdentificacion_correo() {
    return identificacion_correo;
}
public void setIdentificacion_correo(String identificacion_correo) {
	this.identificacion_correo = identificacion_correo;
}
public Date getIdentificacion_fechaconstitucion() {
    return identificacion_fechaconstitucion;
}
public void setIdentificacion_fechaconstitucion(Date identificacion_fechaconstitucion) {
	this.identificacion_fechaconstitucion = identificacion_fechaconstitucion;
}
public String getIdentificacion_sexo() {
    return identificacion_sexo;
}
public void setIdentificacion_sexo(String identificacion_sexo) {
	this.identificacion_sexo = identificacion_sexo;
}
public Date getIdentificacion_fechainiciorelneg() {
    return identificacion_fechainiciorelneg;
}
public void setIdentificacion_fechainiciorelneg(Date identificacion_fechainiciorelneg) {
	this.identificacion_fechainiciorelneg = identificacion_fechainiciorelneg;
}
public String getIdentificacion_noidentificacion() {
    return identificacion_noidentificacion;
}
public void setIdentificacion_noidentificacion(String identificacion_noidentificacion) {
	this.identificacion_noidentificacion = identificacion_noidentificacion;
}
public String getIdentificacion_comprobaciondomicilio() {
    return identificacion_comprobaciondomicilio;
}
public void setIdentificacion_comprobaciondomicilio(String identificacion_comprobaciondomicilio) {
	this.identificacion_comprobaciondomicilio = identificacion_comprobaciondomicilio;
}
public String getIdentificacion_actividadempresarial() {
    return identificacion_actividadempresarial;
}
public void setIdentificacion_actividadempresarial(String identificacion_actividadempresarial) {
	this.identificacion_actividadempresarial = identificacion_actividadempresarial;
}
public String getIdentificacion_clasificacionfatca() {
    return identificacion_clasificacionfatca;
}
public void setIdentificacion_clasificacionfatca(String identificacion_clasificacionfatca) {
	this.identificacion_clasificacionfatca = identificacion_clasificacionfatca;
}
public String getIdentificacion_identoficialvig() {
    return identificacion_identoficialvig;
}
public void setIdentificacion_identoficialvig(String identificacion_identoficialvig) {
	this.identificacion_identoficialvig = identificacion_identoficialvig;
}
public String getIdentificacion_vigencia() {
    return identificacion_vigencia;
}
public void setIdentificacion_vigencia(String identificacion_vigencia) {
	this.identificacion_vigencia = identificacion_vigencia;
}
public String getIdentificacion_resideciafiscal_paisresidfisc1() {
    return identificacion_resideciafiscal_paisresidfisc1;
}
public void setIdentificacion_resideciafiscal_paisresidfisc1(String identificacion_resideciafiscal_paisresidfisc1) {
	this.identificacion_resideciafiscal_paisresidfisc1 = identificacion_resideciafiscal_paisresidfisc1;
}
public String getIdentificacion_resideciafiscal_identificacionnoidentfisc1() {
    return identificacion_resideciafiscal_identificacionnoidentfisc1;
}
public void setIdentificacion_resideciafiscal_identificacionnoidentfisc1(String identificacion_resideciafiscal_identificacionnoidentfisc1) {
	this.identificacion_resideciafiscal_identificacionnoidentfisc1 = identificacion_resideciafiscal_identificacionnoidentfisc1;
}
public String getIdentificacion_telefonosfideicomitente_paiscasa() {
    return identificacion_telefonosfideicomitente_paiscasa;
}
public void setIdentificacion_telefonosfideicomitente_paiscasa(String identificacion_telefonosfideicomitente_paiscasa) {
	this.identificacion_telefonosfideicomitente_paiscasa = identificacion_telefonosfideicomitente_paiscasa;
}
public String getIdentificacion_telefonosfideicomitente_paisoficina() {
    return identificacion_telefonosfideicomitente_paisoficina;
}
public void setIdentificacion_telefonosfideicomitente_paisoficina(String identificacion_telefonosfideicomitente_paisoficina) {
	this.identificacion_telefonosfideicomitente_paisoficina = identificacion_telefonosfideicomitente_paisoficina;
}
public String getIdentificacion_telefonosfideicomitente_paiscelular() {
    return identificacion_telefonosfideicomitente_paiscelular;
}
public void setIdentificacion_telefonosfideicomitente_paiscelular(String identificacion_telefonosfideicomitente_paiscelular) {
	this.identificacion_telefonosfideicomitente_paiscelular = identificacion_telefonosfideicomitente_paiscelular;
}
public String getIdentificacion_telefonosfideicomitente_ladacasa() {
    return identificacion_telefonosfideicomitente_ladacasa;
}
public void setIdentificacion_telefonosfideicomitente_ladacasa(String identificacion_telefonosfideicomitente_ladacasa) {
	this.identificacion_telefonosfideicomitente_ladacasa = identificacion_telefonosfideicomitente_ladacasa;
}
public String getIdentificacion_telefonosfideicomitente_ladaoficina() {
    return identificacion_telefonosfideicomitente_ladaoficina;
}
public void setIdentificacion_telefonosfideicomitente_ladaoficina(String identificacion_telefonosfideicomitente_ladaoficina) {
	this.identificacion_telefonosfideicomitente_ladaoficina = identificacion_telefonosfideicomitente_ladaoficina;
}
public String getIdentificacion_telefonosfideicomitente_ladacelular() {
    return identificacion_telefonosfideicomitente_ladacelular;
}
public void setIdentificacion_telefonosfideicomitente_ladacelular(String identificacion_telefonosfideicomitente_ladacelular) {
	this.identificacion_telefonosfideicomitente_ladacelular = identificacion_telefonosfideicomitente_ladacelular;
}
public String getIdentificacion_telefonosfideicomitente_numerocasa() {
    return identificacion_telefonosfideicomitente_numerocasa;
}
public void setIdentificacion_telefonosfideicomitente_numerocasa(String identificacion_telefonosfideicomitente_numerocasa) {
	this.identificacion_telefonosfideicomitente_numerocasa = identificacion_telefonosfideicomitente_numerocasa;
}
public String getIdentificacion_telefonosfideicomitente_numerooficina() {
    return identificacion_telefonosfideicomitente_numerooficina;
}
public void setIdentificacion_telefonosfideicomitente_numerooficina(String identificacion_telefonosfideicomitente_numerooficina) {
	this.identificacion_telefonosfideicomitente_numerooficina = identificacion_telefonosfideicomitente_numerooficina;
}
public String getIdentificacion_telefonosfideicomitente_numerocelular() {
    return identificacion_telefonosfideicomitente_numerocelular;
}
public void setIdentificacion_telefonosfideicomitente_numerocelular(String identificacion_telefonosfideicomitente_numerocelular) {
	this.identificacion_telefonosfideicomitente_numerocelular = identificacion_telefonosfideicomitente_numerocelular;
}
public String getIdentificacion_telefonosfideicomitente_extoficina() {
    return identificacion_telefonosfideicomitente_extoficina;
}
public void setIdentificacion_telefonosfideicomitente_extoficina(String identificacion_telefonosfideicomitente_extoficina) {
	this.identificacion_telefonosfideicomitente_extoficina = identificacion_telefonosfideicomitente_extoficina;
}
public String getIdentificacion_telefonosfideicomitente_extcelular() {
    return identificacion_telefonosfideicomitente_extcelular;
}
public void setIdentificacion_telefonosfideicomitente_extcelular(String identificacion_telefonosfideicomitente_extcelular) {
	this.identificacion_telefonosfideicomitente_extcelular = identificacion_telefonosfideicomitente_extcelular;
}
public String getEscritura_noescritura() {
    return escritura_noescritura;
}
public void setEscritura_noescritura(String escritura_noescritura) {
	this.escritura_noescritura = escritura_noescritura;
}
public String getEscritura_notario() {
    return escritura_notario;
}
public void setEscritura_notario(String escritura_notario) {
	this.escritura_notario = escritura_notario;
}
public String getEscritura_nonotaria() {
    return escritura_nonotaria;
}
public void setEscritura_nonotaria(String escritura_nonotaria) {
	this.escritura_nonotaria = escritura_nonotaria;
}
public String getEscritura_ciudad() {
    return escritura_ciudad;
}
public void setEscritura_ciudad(String escritura_ciudad) {
	this.escritura_ciudad = escritura_ciudad;
}
public String getEscritura_estado() {
    return escritura_estado;
}
public void setEscritura_estado(String escritura_estado) {
	this.escritura_estado = escritura_estado;
}
public Date getEscritura_fecha() {
    return escritura_fecha;
}
public void setEscritura_fecha(Date escritura_fecha) {
	this.escritura_fecha = escritura_fecha;
}
public String getEscritura_telefono() {
    return escritura_telefono;
}
public void setEscritura_telefono(String escritura_telefono) {
	this.escritura_telefono = escritura_telefono;
}
public String getEscritura_correo() {
    return escritura_correo;
}
public void setEscritura_correo(String escritura_correo) {
	this.escritura_correo = escritura_correo;
}
public Set<Cuentaskyc> get_cuentaskyc() {
	return _cuentaskyc;
}
		
public void set_cuentaskyc(Set<Cuentaskyc> _cuentaskyc) {
	this._cuentaskyc = _cuentaskyc;
}		
}
