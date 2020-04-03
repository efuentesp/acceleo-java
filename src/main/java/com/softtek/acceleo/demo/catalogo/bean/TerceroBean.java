package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Fideicomiso;

public class TerceroBean {

/**
 * Clase TerceroBean.
 * @author PSG.
 *
 */
 
private UUID terceroId; 
private UUID fideicomisoId;
private Integer notercero;
private String razonsocial;
private String nacionalidad;
private String actividadeconomica;
private String estatus;
private Date fechaverfircosoft;
private String tipopersona;
private String rfc;
private String correo;
private String calidamigratoria;
private String telefonosfideicomitente_paiscasa;
private String telefonosfideicomitente_paisoficina;
private String telefonosfideicomitente_paiscelular;
private String telefonosfideicomitente_ladacasa;
private String telefonosfideicomitente_ladaoficina;
private String telefonosfideicomitente_ladacelular;
private String telefonosfideicomitente_numerocasa;
private String telefonosfideicomitente_numerooficina;
private String telefonosfideicomitente_numerocelular;
private String telefonosfideicomitente_extoficina;
private String telefonosfideicomitente_extcelular;

public UUID getTerceroId() {
    return terceroId;  		
   }
public void setTerceroId(UUID terceroId) {
	this.terceroId = terceroId;
}

public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public Integer getNotercero() {
    return notercero;
}
public void setNotercero(Integer notercero) {
	this.notercero = notercero;
}	
public String getRazonsocial() {
    return razonsocial;
}
public void setRazonsocial(String razonsocial) {
	this.razonsocial = razonsocial;
}
public String getNacionalidad() {
    return nacionalidad;
}
public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}
public String getActividadeconomica() {
    return actividadeconomica;
}
public void setActividadeconomica(String actividadeconomica) {
	this.actividadeconomica = actividadeconomica;
}
public String getEstatus() {
    return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
public Date getFechaverfircosoft() {
    return fechaverfircosoft;
}
public void setFechaverfircosoft(Date fechaverfircosoft) {
	this.fechaverfircosoft = fechaverfircosoft;
}
public String getTipopersona() {
    return tipopersona;
}
public void setTipopersona(String tipopersona) {
	this.tipopersona = tipopersona;
}
public String getRfc() {
    return rfc;
}
public void setRfc(String rfc) {
	this.rfc = rfc;
}
public String getCorreo() {
    return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getCalidamigratoria() {
    return calidamigratoria;
}
public void setCalidamigratoria(String calidamigratoria) {
	this.calidamigratoria = calidamigratoria;
}
public String getTelefonosfideicomitente_paiscasa() {
    return telefonosfideicomitente_paiscasa;
}
public void setTelefonosfideicomitente_paiscasa(String telefonosfideicomitente_paiscasa) {
	this.telefonosfideicomitente_paiscasa = telefonosfideicomitente_paiscasa;
}
public String getTelefonosfideicomitente_paisoficina() {
    return telefonosfideicomitente_paisoficina;
}
public void setTelefonosfideicomitente_paisoficina(String telefonosfideicomitente_paisoficina) {
	this.telefonosfideicomitente_paisoficina = telefonosfideicomitente_paisoficina;
}
public String getTelefonosfideicomitente_paiscelular() {
    return telefonosfideicomitente_paiscelular;
}
public void setTelefonosfideicomitente_paiscelular(String telefonosfideicomitente_paiscelular) {
	this.telefonosfideicomitente_paiscelular = telefonosfideicomitente_paiscelular;
}
public String getTelefonosfideicomitente_ladacasa() {
    return telefonosfideicomitente_ladacasa;
}
public void setTelefonosfideicomitente_ladacasa(String telefonosfideicomitente_ladacasa) {
	this.telefonosfideicomitente_ladacasa = telefonosfideicomitente_ladacasa;
}
public String getTelefonosfideicomitente_ladaoficina() {
    return telefonosfideicomitente_ladaoficina;
}
public void setTelefonosfideicomitente_ladaoficina(String telefonosfideicomitente_ladaoficina) {
	this.telefonosfideicomitente_ladaoficina = telefonosfideicomitente_ladaoficina;
}
public String getTelefonosfideicomitente_ladacelular() {
    return telefonosfideicomitente_ladacelular;
}
public void setTelefonosfideicomitente_ladacelular(String telefonosfideicomitente_ladacelular) {
	this.telefonosfideicomitente_ladacelular = telefonosfideicomitente_ladacelular;
}
public String getTelefonosfideicomitente_numerocasa() {
    return telefonosfideicomitente_numerocasa;
}
public void setTelefonosfideicomitente_numerocasa(String telefonosfideicomitente_numerocasa) {
	this.telefonosfideicomitente_numerocasa = telefonosfideicomitente_numerocasa;
}
public String getTelefonosfideicomitente_numerooficina() {
    return telefonosfideicomitente_numerooficina;
}
public void setTelefonosfideicomitente_numerooficina(String telefonosfideicomitente_numerooficina) {
	this.telefonosfideicomitente_numerooficina = telefonosfideicomitente_numerooficina;
}
public String getTelefonosfideicomitente_numerocelular() {
    return telefonosfideicomitente_numerocelular;
}
public void setTelefonosfideicomitente_numerocelular(String telefonosfideicomitente_numerocelular) {
	this.telefonosfideicomitente_numerocelular = telefonosfideicomitente_numerocelular;
}
public String getTelefonosfideicomitente_extoficina() {
    return telefonosfideicomitente_extoficina;
}
public void setTelefonosfideicomitente_extoficina(String telefonosfideicomitente_extoficina) {
	this.telefonosfideicomitente_extoficina = telefonosfideicomitente_extoficina;
}
public String getTelefonosfideicomitente_extcelular() {
    return telefonosfideicomitente_extcelular;
}
public void setTelefonosfideicomitente_extcelular(String telefonosfideicomitente_extcelular) {
	this.telefonosfideicomitente_extcelular = telefonosfideicomitente_extcelular;
}
}
