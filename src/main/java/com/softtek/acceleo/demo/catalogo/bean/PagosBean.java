package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Instruccion;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public class PagosBean {

/**
 * Clase PagosBean.
 * @author PSG.
 *
 */
 
private UUID pagosId; 
private UUID instruccionId;
private UUID fideicomisoId;
private String importeinstruccion;
private String movimientos;
private String tipopersona;
private String conceptopago;
private String clave;
private String nombre;
private String formaliquidacion;
private String tipopago;
private String datosconcentradora;
private String descripcioncomplementaria;
private UUID subfisoId;
private String importetotal;
private String estatusoperacion;
private String importe;
private Date fechaliquidar;
private String estatus;

public UUID getPagosId() {
    return pagosId;  		
   }
public void setPagosId(UUID pagosId) {
	this.pagosId = pagosId;
}

public UUID getInstruccionId() {
    return instruccionId;
}
public void setInstruccion(UUID instruccionId) {
	this.instruccionId = instruccionId;
}
public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public String getImporteinstruccion() {
    return importeinstruccion;
}
public void setImporteinstruccion(String importeinstruccion) {
	this.importeinstruccion = importeinstruccion;
}
public String getMovimientos() {
    return movimientos;
}
public void setMovimientos(String movimientos) {
	this.movimientos = movimientos;
}
public String getTipopersona() {
    return tipopersona;
}
public void setTipopersona(String tipopersona) {
	this.tipopersona = tipopersona;
}
public String getConceptopago() {
    return conceptopago;
}
public void setConceptopago(String conceptopago) {
	this.conceptopago = conceptopago;
}
public String getClave() {
    return clave;
}
public void setClave(String clave) {
	this.clave = clave;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getFormaliquidacion() {
    return formaliquidacion;
}
public void setFormaliquidacion(String formaliquidacion) {
	this.formaliquidacion = formaliquidacion;
}
public String getTipopago() {
    return tipopago;
}
public void setTipopago(String tipopago) {
	this.tipopago = tipopago;
}
public String getDatosconcentradora() {
    return datosconcentradora;
}
public void setDatosconcentradora(String datosconcentradora) {
	this.datosconcentradora = datosconcentradora;
}
public String getDescripcioncomplementaria() {
    return descripcioncomplementaria;
}
public void setDescripcioncomplementaria(String descripcioncomplementaria) {
	this.descripcioncomplementaria = descripcioncomplementaria;
}
public UUID getSubfisoId() {
    return subfisoId;
}
public void setSubfiso(UUID subfisoId) {
	this.subfisoId = subfisoId;
}
public String getImportetotal() {
    return importetotal;
}
public void setImportetotal(String importetotal) {
	this.importetotal = importetotal;
}
public String getEstatusoperacion() {
    return estatusoperacion;
}
public void setEstatusoperacion(String estatusoperacion) {
	this.estatusoperacion = estatusoperacion;
}
public String getImporte() {
    return importe;
}
public void setImporte(String importe) {
	this.importe = importe;
}
public Date getFechaliquidar() {
    return fechaliquidar;
}
public void setFechaliquidar(Date fechaliquidar) {
	this.fechaliquidar = fechaliquidar;
}
public String getEstatus() {
    return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
}
