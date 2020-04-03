package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Transaccion;

public class GuiaBean {

/**
 * Clase GuiaBean.
 * @author PSG.
 *
 */
 
private UUID guiaId; 
private UUID transaccionId;
private String sec;
private String nombrecuenta;
private String ctamayor;
private String scta;
private String sscta;
private String sssctacopia;
private String sssscta;
private String auxiliar1;
private String auxiliar2;
private String auxiliar3;
private String aplicadato;
private String ca;
private String descripcion;
private String estatus;

public UUID getGuiaId() {
    return guiaId;  		
   }
public void setGuiaId(UUID guiaId) {
	this.guiaId = guiaId;
}

public UUID getTransaccionId() {
    return transaccionId;
}
public void setTransaccion(UUID transaccionId) {
	this.transaccionId = transaccionId;
}
public String getSec() {
    return sec;
}
public void setSec(String sec) {
	this.sec = sec;
}
public String getNombrecuenta() {
    return nombrecuenta;
}
public void setNombrecuenta(String nombrecuenta) {
	this.nombrecuenta = nombrecuenta;
}
public String getCtamayor() {
    return ctamayor;
}
public void setCtamayor(String ctamayor) {
	this.ctamayor = ctamayor;
}
public String getScta() {
    return scta;
}
public void setScta(String scta) {
	this.scta = scta;
}
public String getSscta() {
    return sscta;
}
public void setSscta(String sscta) {
	this.sscta = sscta;
}
public String getSssctacopia() {
    return sssctacopia;
}
public void setSssctacopia(String sssctacopia) {
	this.sssctacopia = sssctacopia;
}
public String getSssscta() {
    return sssscta;
}
public void setSssscta(String sssscta) {
	this.sssscta = sssscta;
}
public String getAuxiliar1() {
    return auxiliar1;
}
public void setAuxiliar1(String auxiliar1) {
	this.auxiliar1 = auxiliar1;
}
public String getAuxiliar2() {
    return auxiliar2;
}
public void setAuxiliar2(String auxiliar2) {
	this.auxiliar2 = auxiliar2;
}
public String getAuxiliar3() {
    return auxiliar3;
}
public void setAuxiliar3(String auxiliar3) {
	this.auxiliar3 = auxiliar3;
}
public String getAplicadato() {
    return aplicadato;
}
public void setAplicadato(String aplicadato) {
	this.aplicadato = aplicadato;
}
public String getCa() {
    return ca;
}
public void setCa(String ca) {
	this.ca = ca;
}
public String getDescripcion() {
    return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getEstatus() {
    return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
}
