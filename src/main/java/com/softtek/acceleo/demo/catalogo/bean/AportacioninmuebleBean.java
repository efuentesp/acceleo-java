package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public class AportacioninmuebleBean {

/**
 * Clase AportacioninmuebleBean.
 * @author PSG.
 *
 */
 
private UUID aportacioninmuebleId; 
private String dummy;
private UUID datosfideicomiso_fideicomisoId;
private UUID datosfideicomiso_subfisoId;
private String datosfideicomiso_tiponegocio;
private String datosfideicomiso_producto;
private String identificacioninmueble_idinmueble;
private Date identificacioninmueble_fechaalta;
private String identificacioninmueble_tipoinmueble;
private String identificacioninmueble_arbol;
private Date identificacioninmueble_fecharegistro;
private String identificacioninmueble_tipofraccion;
private String identificacioninmueble_descripcion;
private String generalesinmueble_valorinicial;
private String generalesinmueble_ubicacion;
private String generalesinmueble_estado;
private String generalesinmueble_superficie;
private String generalesinmueble_indivisos;
private String generalesinmueble_dias;
private String generalesinmueble_proyectoejecutivo;
private String generalesinmueble_valoractual;
private String generalesinmueble_ciudad;
private String generalesinmueble_superficieconstruida;
private String generalesinmueble_fraccionamientounidad;
private String generalesinmueble_clavecatastral;
private String generalesinmueble_valor;
private String generalesinmueble_estatus;
private String datosconstitucion_escritura;
private String datosconstitucion_numescritura;
private String datosconstitucion_nombrenotario;
private String datosconstitucion_estadonotario;
private String datosconstitucion_telefononotario;
private Date datosconstitucion_fecharpp;
private Date datosconstitucion_fechaescritura;
private String datosconstitucion_numnotaria;
private String datosconstitucion_ciudadnotario;
private String datosconstitucion_emailnotario;
private String datosconstitucion_numrpp;

public UUID getAportacionInmuebleId() {
    return aportacioninmuebleId;  		
   }
public void setAportacionInmuebleId(UUID aportacioninmuebleId) {
	this.aportacioninmuebleId = aportacioninmuebleId;
}

public String getDummy() {
    return dummy;
}
public void setDummy(String dummy) {
	this.dummy = dummy;
}
public UUID getDatosfideicomiso_fideicomisoId() {
    return datosfideicomiso_fideicomisoId;
}
public void setDatosfideicomiso_fideicomiso(UUID datosfideicomiso_fideicomisoId) {
	this.datosfideicomiso_fideicomisoId = datosfideicomiso_fideicomisoId;
}
public UUID getDatosfideicomiso_subfisoId() {
    return datosfideicomiso_subfisoId;
}
public void setDatosfideicomiso_subfiso(UUID datosfideicomiso_subfisoId) {
	this.datosfideicomiso_subfisoId = datosfideicomiso_subfisoId;
}
public String getDatosfideicomiso_tiponegocio() {
    return datosfideicomiso_tiponegocio;
}
public void setDatosfideicomiso_tiponegocio(String datosfideicomiso_tiponegocio) {
	this.datosfideicomiso_tiponegocio = datosfideicomiso_tiponegocio;
}
public String getDatosfideicomiso_producto() {
    return datosfideicomiso_producto;
}
public void setDatosfideicomiso_producto(String datosfideicomiso_producto) {
	this.datosfideicomiso_producto = datosfideicomiso_producto;
}
public String getIdentificacioninmueble_idinmueble() {
    return identificacioninmueble_idinmueble;
}
public void setIdentificacioninmueble_idinmueble(String identificacioninmueble_idinmueble) {
	this.identificacioninmueble_idinmueble = identificacioninmueble_idinmueble;
}
public Date getIdentificacioninmueble_fechaalta() {
    return identificacioninmueble_fechaalta;
}
public void setIdentificacioninmueble_fechaalta(Date identificacioninmueble_fechaalta) {
	this.identificacioninmueble_fechaalta = identificacioninmueble_fechaalta;
}
public String getIdentificacioninmueble_tipoinmueble() {
    return identificacioninmueble_tipoinmueble;
}
public void setIdentificacioninmueble_tipoinmueble(String identificacioninmueble_tipoinmueble) {
	this.identificacioninmueble_tipoinmueble = identificacioninmueble_tipoinmueble;
}
public String getIdentificacioninmueble_arbol() {
    return identificacioninmueble_arbol;
}
public void setIdentificacioninmueble_arbol(String identificacioninmueble_arbol) {
	this.identificacioninmueble_arbol = identificacioninmueble_arbol;
}
public Date getIdentificacioninmueble_fecharegistro() {
    return identificacioninmueble_fecharegistro;
}
public void setIdentificacioninmueble_fecharegistro(Date identificacioninmueble_fecharegistro) {
	this.identificacioninmueble_fecharegistro = identificacioninmueble_fecharegistro;
}
public String getIdentificacioninmueble_tipofraccion() {
    return identificacioninmueble_tipofraccion;
}
public void setIdentificacioninmueble_tipofraccion(String identificacioninmueble_tipofraccion) {
	this.identificacioninmueble_tipofraccion = identificacioninmueble_tipofraccion;
}
public String getIdentificacioninmueble_descripcion() {
    return identificacioninmueble_descripcion;
}
public void setIdentificacioninmueble_descripcion(String identificacioninmueble_descripcion) {
	this.identificacioninmueble_descripcion = identificacioninmueble_descripcion;
}	
public String getGeneralesinmueble_valorinicial() {
    return generalesinmueble_valorinicial;
}
public void setGeneralesinmueble_valorinicial(String generalesinmueble_valorinicial) {
	this.generalesinmueble_valorinicial = generalesinmueble_valorinicial;
}
public String getGeneralesinmueble_ubicacion() {
    return generalesinmueble_ubicacion;
}
public void setGeneralesinmueble_ubicacion(String generalesinmueble_ubicacion) {
	this.generalesinmueble_ubicacion = generalesinmueble_ubicacion;
}
public String getGeneralesinmueble_estado() {
    return generalesinmueble_estado;
}
public void setGeneralesinmueble_estado(String generalesinmueble_estado) {
	this.generalesinmueble_estado = generalesinmueble_estado;
}
public String getGeneralesinmueble_superficie() {
    return generalesinmueble_superficie;
}
public void setGeneralesinmueble_superficie(String generalesinmueble_superficie) {
	this.generalesinmueble_superficie = generalesinmueble_superficie;
}
public String getGeneralesinmueble_indivisos() {
    return generalesinmueble_indivisos;
}
public void setGeneralesinmueble_indivisos(String generalesinmueble_indivisos) {
	this.generalesinmueble_indivisos = generalesinmueble_indivisos;
}
public String getGeneralesinmueble_dias() {
    return generalesinmueble_dias;
}
public void setGeneralesinmueble_dias(String generalesinmueble_dias) {
	this.generalesinmueble_dias = generalesinmueble_dias;
}
public String getGeneralesinmueble_proyectoejecutivo() {
    return generalesinmueble_proyectoejecutivo;
}
public void setGeneralesinmueble_proyectoejecutivo(String generalesinmueble_proyectoejecutivo) {
	this.generalesinmueble_proyectoejecutivo = generalesinmueble_proyectoejecutivo;
}
public String getGeneralesinmueble_valoractual() {
    return generalesinmueble_valoractual;
}
public void setGeneralesinmueble_valoractual(String generalesinmueble_valoractual) {
	this.generalesinmueble_valoractual = generalesinmueble_valoractual;
}
public String getGeneralesinmueble_ciudad() {
    return generalesinmueble_ciudad;
}
public void setGeneralesinmueble_ciudad(String generalesinmueble_ciudad) {
	this.generalesinmueble_ciudad = generalesinmueble_ciudad;
}
public String getGeneralesinmueble_superficieconstruida() {
    return generalesinmueble_superficieconstruida;
}
public void setGeneralesinmueble_superficieconstruida(String generalesinmueble_superficieconstruida) {
	this.generalesinmueble_superficieconstruida = generalesinmueble_superficieconstruida;
}
public String getGeneralesinmueble_fraccionamientounidad() {
    return generalesinmueble_fraccionamientounidad;
}
public void setGeneralesinmueble_fraccionamientounidad(String generalesinmueble_fraccionamientounidad) {
	this.generalesinmueble_fraccionamientounidad = generalesinmueble_fraccionamientounidad;
}
public String getGeneralesinmueble_clavecatastral() {
    return generalesinmueble_clavecatastral;
}
public void setGeneralesinmueble_clavecatastral(String generalesinmueble_clavecatastral) {
	this.generalesinmueble_clavecatastral = generalesinmueble_clavecatastral;
}
public String getGeneralesinmueble_valor() {
    return generalesinmueble_valor;
}
public void setGeneralesinmueble_valor(String generalesinmueble_valor) {
	this.generalesinmueble_valor = generalesinmueble_valor;
}
public String getGeneralesinmueble_estatus() {
    return generalesinmueble_estatus;
}
public void setGeneralesinmueble_estatus(String generalesinmueble_estatus) {
	this.generalesinmueble_estatus = generalesinmueble_estatus;
}
public String getDatosconstitucion_escritura() {
    return datosconstitucion_escritura;
}
public void setDatosconstitucion_escritura(String datosconstitucion_escritura) {
	this.datosconstitucion_escritura = datosconstitucion_escritura;
}
public String getDatosconstitucion_numescritura() {
    return datosconstitucion_numescritura;
}
public void setDatosconstitucion_numescritura(String datosconstitucion_numescritura) {
	this.datosconstitucion_numescritura = datosconstitucion_numescritura;
}
public String getDatosconstitucion_nombrenotario() {
    return datosconstitucion_nombrenotario;
}
public void setDatosconstitucion_nombrenotario(String datosconstitucion_nombrenotario) {
	this.datosconstitucion_nombrenotario = datosconstitucion_nombrenotario;
}
public String getDatosconstitucion_estadonotario() {
    return datosconstitucion_estadonotario;
}
public void setDatosconstitucion_estadonotario(String datosconstitucion_estadonotario) {
	this.datosconstitucion_estadonotario = datosconstitucion_estadonotario;
}
public String getDatosconstitucion_telefononotario() {
    return datosconstitucion_telefononotario;
}
public void setDatosconstitucion_telefononotario(String datosconstitucion_telefononotario) {
	this.datosconstitucion_telefononotario = datosconstitucion_telefononotario;
}
public Date getDatosconstitucion_fecharpp() {
    return datosconstitucion_fecharpp;
}
public void setDatosconstitucion_fecharpp(Date datosconstitucion_fecharpp) {
	this.datosconstitucion_fecharpp = datosconstitucion_fecharpp;
}
public Date getDatosconstitucion_fechaescritura() {
    return datosconstitucion_fechaescritura;
}
public void setDatosconstitucion_fechaescritura(Date datosconstitucion_fechaescritura) {
	this.datosconstitucion_fechaescritura = datosconstitucion_fechaescritura;
}
public String getDatosconstitucion_numnotaria() {
    return datosconstitucion_numnotaria;
}
public void setDatosconstitucion_numnotaria(String datosconstitucion_numnotaria) {
	this.datosconstitucion_numnotaria = datosconstitucion_numnotaria;
}
public String getDatosconstitucion_ciudadnotario() {
    return datosconstitucion_ciudadnotario;
}
public void setDatosconstitucion_ciudadnotario(String datosconstitucion_ciudadnotario) {
	this.datosconstitucion_ciudadnotario = datosconstitucion_ciudadnotario;
}
public String getDatosconstitucion_emailnotario() {
    return datosconstitucion_emailnotario;
}
public void setDatosconstitucion_emailnotario(String datosconstitucion_emailnotario) {
	this.datosconstitucion_emailnotario = datosconstitucion_emailnotario;
}
public String getDatosconstitucion_numrpp() {
    return datosconstitucion_numrpp;
}
public void setDatosconstitucion_numrpp(String datosconstitucion_numrpp) {
	this.datosconstitucion_numrpp = datosconstitucion_numrpp;
}
}
