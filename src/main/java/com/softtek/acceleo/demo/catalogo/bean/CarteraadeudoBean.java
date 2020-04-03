package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Honorarioscontrato;

public class CarteraadeudoBean {

/**
 * Clase CarteraadeudoBean.
 * @author PSG.
 *
 */
 
private UUID carteraadeudoId; 
private UUID honorarioscontratoId;
private String folioadeudo;
private String calificacion;
private Date fechacalculo;
private Date del;
private Date al;
private String moneda;
private String importe;

public UUID getCarteraAdeudoId() {
    return carteraadeudoId;  		
   }
public void setCarteraAdeudoId(UUID carteraadeudoId) {
	this.carteraadeudoId = carteraadeudoId;
}

public UUID getHonorarioscontratoId() {
    return honorarioscontratoId;
}
public void setHonorarioscontrato(UUID honorarioscontratoId) {
	this.honorarioscontratoId = honorarioscontratoId;
}
public String getFolioadeudo() {
    return folioadeudo;
}
public void setFolioadeudo(String folioadeudo) {
	this.folioadeudo = folioadeudo;
}
public String getCalificacion() {
    return calificacion;
}
public void setCalificacion(String calificacion) {
	this.calificacion = calificacion;
}
public Date getFechacalculo() {
    return fechacalculo;
}
public void setFechacalculo(Date fechacalculo) {
	this.fechacalculo = fechacalculo;
}
public Date getDel() {
    return del;
}
public void setDel(Date del) {
	this.del = del;
}
public Date getAl() {
    return al;
}
public void setAl(Date al) {
	this.al = al;
}
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public String getImporte() {
    return importe;
}
public void setImporte(String importe) {
	this.importe = importe;
}
}
