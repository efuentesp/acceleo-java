package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Contratoinversion;
import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public class CompraventavaloresBean {

/**
 * Clase CompraventavaloresBean.
 * @author PSG.
 *
 */
 
private UUID compraventavaloresId; 
private Date fechaoperacion;
private String generooperacion;
private UUID subfisoId;
private UUID contratoinversionId;
private String descripcionoperacion;
private String operacion;
private String montooperacion;
private String intermediario;
private UUID fideicomisoId;
private String descripcionfideicomiso;
private String politicainversion;
private String moneda;
private String emergente;

public UUID getCompraVentaValoresId() {
    return compraventavaloresId;  		
   }
public void setCompraVentaValoresId(UUID compraventavaloresId) {
	this.compraventavaloresId = compraventavaloresId;
}

public Date getFechaoperacion() {
    return fechaoperacion;
}
public void setFechaoperacion(Date fechaoperacion) {
	this.fechaoperacion = fechaoperacion;
}
public String getGenerooperacion() {
    return generooperacion;
}
public void setGenerooperacion(String generooperacion) {
	this.generooperacion = generooperacion;
}
public UUID getSubfisoId() {
    return subfisoId;
}
public void setSubfiso(UUID subfisoId) {
	this.subfisoId = subfisoId;
}
public UUID getContratoinversionId() {
    return contratoinversionId;
}
public void setContratoinversion(UUID contratoinversionId) {
	this.contratoinversionId = contratoinversionId;
}
public String getDescripcionoperacion() {
    return descripcionoperacion;
}
public void setDescripcionoperacion(String descripcionoperacion) {
	this.descripcionoperacion = descripcionoperacion;
}
public String getOperacion() {
    return operacion;
}
public void setOperacion(String operacion) {
	this.operacion = operacion;
}
public String getMontooperacion() {
    return montooperacion;
}
public void setMontooperacion(String montooperacion) {
	this.montooperacion = montooperacion;
}
public String getIntermediario() {
    return intermediario;
}
public void setIntermediario(String intermediario) {
	this.intermediario = intermediario;
}
public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public String getDescripcionfideicomiso() {
    return descripcionfideicomiso;
}
public void setDescripcionfideicomiso(String descripcionfideicomiso) {
	this.descripcionfideicomiso = descripcionfideicomiso;
}
public String getPoliticainversion() {
    return politicainversion;
}
public void setPoliticainversion(String politicainversion) {
	this.politicainversion = politicainversion;
}
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public String getEmergente() {
    return emergente;
}
public void setEmergente(String emergente) {
	this.emergente = emergente;
}
}
