package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.domain.Instruccion;
import com.softtek.acceleo.demo.domain.Transaccion;

public class CheckermonetarioBean {

/**
 * Clase CheckermonetarioBean.
 * @author PSG.
 *
 */
 
private UUID checkermonetarioId; 
private String foliooperacion;
private String operador;
private String tipoliquidacion;
private UUID fideicomisoId;
private UUID subfisoId;
private UUID instruccionId;
private String importe;
private String fechapago;
private String numeroliquidaciones;
private UUID transaccionId;
private String moneda;
private String estatus;
private String fecha;
private String operado;
private String autorizo;
private String fechaautorizado;
private String numerofirma;
private String nombrefirma;
private String fechafirma;

public UUID getCheckerMonetarioId() {
    return checkermonetarioId;  		
   }
public void setCheckerMonetarioId(UUID checkermonetarioId) {
	this.checkermonetarioId = checkermonetarioId;
}

public String getFoliooperacion() {
    return foliooperacion;
}
public void setFoliooperacion(String foliooperacion) {
	this.foliooperacion = foliooperacion;
}
public String getOperador() {
    return operador;
}
public void setOperador(String operador) {
	this.operador = operador;
}
public String getTipoliquidacion() {
    return tipoliquidacion;
}
public void setTipoliquidacion(String tipoliquidacion) {
	this.tipoliquidacion = tipoliquidacion;
}
public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public UUID getSubfisoId() {
    return subfisoId;
}
public void setSubfiso(UUID subfisoId) {
	this.subfisoId = subfisoId;
}
public UUID getInstruccionId() {
    return instruccionId;
}
public void setInstruccion(UUID instruccionId) {
	this.instruccionId = instruccionId;
}
public String getImporte() {
    return importe;
}
public void setImporte(String importe) {
	this.importe = importe;
}
public String getFechapago() {
    return fechapago;
}
public void setFechapago(String fechapago) {
	this.fechapago = fechapago;
}
public String getNumeroliquidaciones() {
    return numeroliquidaciones;
}
public void setNumeroliquidaciones(String numeroliquidaciones) {
	this.numeroliquidaciones = numeroliquidaciones;
}
public UUID getTransaccionId() {
    return transaccionId;
}
public void setTransaccion(UUID transaccionId) {
	this.transaccionId = transaccionId;
}
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public String getEstatus() {
    return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
public String getFecha() {
    return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getOperado() {
    return operado;
}
public void setOperado(String operado) {
	this.operado = operado;
}
public String getAutorizo() {
    return autorizo;
}
public void setAutorizo(String autorizo) {
	this.autorizo = autorizo;
}
public String getFechaautorizado() {
    return fechaautorizado;
}
public void setFechaautorizado(String fechaautorizado) {
	this.fechaautorizado = fechaautorizado;
}
public String getNumerofirma() {
    return numerofirma;
}
public void setNumerofirma(String numerofirma) {
	this.numerofirma = numerofirma;
}
public String getNombrefirma() {
    return nombrefirma;
}
public void setNombrefirma(String nombrefirma) {
	this.nombrefirma = nombrefirma;
}
public String getFechafirma() {
    return fechafirma;
}
public void setFechafirma(String fechafirma) {
	this.fechafirma = fechafirma;
}
}
