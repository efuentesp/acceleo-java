package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public class MovimientoBean {

/**
 * Clase MovimientoBean.
 * @author PSG.
 *
 */
 
private UUID movimientoId; 
private String fechacontable;
private String fechaalta;
private String operacion;
private UUID fideicomisoId;
private UUID subfisoId;
private String folio;
private String transaccion;
private String descripcion;
private String importe;
private String usuario;
private String estatus;
private String factura;

public UUID getMovimientoId() {
    return movimientoId;  		
   }
public void setMovimientoId(UUID movimientoId) {
	this.movimientoId = movimientoId;
}

public String getFechacontable() {
    return fechacontable;
}
public void setFechacontable(String fechacontable) {
	this.fechacontable = fechacontable;
}
public String getFechaalta() {
    return fechaalta;
}
public void setFechaalta(String fechaalta) {
	this.fechaalta = fechaalta;
}
public String getOperacion() {
    return operacion;
}
public void setOperacion(String operacion) {
	this.operacion = operacion;
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
public String getFolio() {
    return folio;
}
public void setFolio(String folio) {
	this.folio = folio;
}
public String getTransaccion() {
    return transaccion;
}
public void setTransaccion(String transaccion) {
	this.transaccion = transaccion;
}
public String getDescripcion() {
    return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}	
public String getImporte() {
    return importe;
}
public void setImporte(String importe) {
	this.importe = importe;
}
public String getUsuario() {
    return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getEstatus() {
    return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
public String getFactura() {
    return factura;
}
public void setFactura(String factura) {
	this.factura = factura;
}
}
