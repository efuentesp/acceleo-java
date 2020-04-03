package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;


public class TransaccionBean {

/**
 * Clase TransaccionBean.
 * @author PSG.
 *
 */
 
private UUID transaccionId; 
private String numoperacion;
private String modulo;
private String nombre;
private String costoejecucion;
private String estatustrans;
private String notransaccion;
private String moneda;
private String columedocuenta;
private String hora;

public UUID getTransaccionId() {
    return transaccionId;  		
   }
public void setTransaccionId(UUID transaccionId) {
	this.transaccionId = transaccionId;
}

public String getNumoperacion() {
    return numoperacion;
}
public void setNumoperacion(String numoperacion) {
	this.numoperacion = numoperacion;
}
public String getModulo() {
    return modulo;
}
public void setModulo(String modulo) {
	this.modulo = modulo;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getCostoejecucion() {
    return costoejecucion;
}
public void setCostoejecucion(String costoejecucion) {
	this.costoejecucion = costoejecucion;
}
public String getEstatustrans() {
    return estatustrans;
}
public void setEstatustrans(String estatustrans) {
	this.estatustrans = estatustrans;
}
public String getNotransaccion() {
    return notransaccion;
}
public void setNotransaccion(String notransaccion) {
	this.notransaccion = notransaccion;
}
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public String getColumedocuenta() {
    return columedocuenta;
}
public void setColumedocuenta(String columedocuenta) {
	this.columedocuenta = columedocuenta;
}
public String getHora() {
    return hora;
}
public void setHora(String hora) {
	this.hora = hora;
}
}
