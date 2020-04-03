package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Fideicomiso;

public class AutodeclaracioncrsBean {

/**
 * Clase AutodeclaracioncrsBean.
 * @author PSG.
 *
 */
 
private UUID autodeclaracioncrsId; 
private UUID fideicomisoId;
private String numero;
private String nombre;
private String tipopersona;
private String tipoparticipante;
private String formatocrs;

public UUID getAutodeclaracionCrsId() {
    return autodeclaracioncrsId;  		
   }
public void setAutodeclaracionCrsId(UUID autodeclaracioncrsId) {
	this.autodeclaracioncrsId = autodeclaracioncrsId;
}

public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public String getNumero() {
    return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getTipopersona() {
    return tipopersona;
}
public void setTipopersona(String tipopersona) {
	this.tipopersona = tipopersona;
}
public String getTipoparticipante() {
    return tipoparticipante;
}
public void setTipoparticipante(String tipoparticipante) {
	this.tipoparticipante = tipoparticipante;
}
public String getFormatocrs() {
    return formatocrs;
}
public void setFormatocrs(String formatocrs) {
	this.formatocrs = formatocrs;
}
}
