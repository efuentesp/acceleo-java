package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Instruccion;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public class AportacionesBean {

/**
 * Clase AportacionesBean.
 * @author PSG.
 *
 */
 
private UUID aportacionesId; 
private UUID instruccionId;
private UUID fideicomisoId;
private UUID subfisoId;
private String totalimporte;
private String destinorecepcion;
private String estatus;
private String moneda;
private String formarecepcion;
private String estatusoperacion;
private String tipopersona;
private Date fechacontabilizacion;
private String nombre;
private String descripcioncomplementaria;
private String nombrefideicomiso;
private String eventos;
private String totalaplicado;
private String importerecepcion;
private String origenrecursos;

public UUID getAportacionesId() {
    return aportacionesId;  		
   }
public void setAportacionesId(UUID aportacionesId) {
	this.aportacionesId = aportacionesId;
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
public UUID getSubfisoId() {
    return subfisoId;
}
public void setSubfiso(UUID subfisoId) {
	this.subfisoId = subfisoId;
}
public String getTotalimporte() {
    return totalimporte;
}
public void setTotalimporte(String totalimporte) {
	this.totalimporte = totalimporte;
}
public String getDestinorecepcion() {
    return destinorecepcion;
}
public void setDestinorecepcion(String destinorecepcion) {
	this.destinorecepcion = destinorecepcion;
}
public String getEstatus() {
    return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public String getFormarecepcion() {
    return formarecepcion;
}
public void setFormarecepcion(String formarecepcion) {
	this.formarecepcion = formarecepcion;
}
public String getEstatusoperacion() {
    return estatusoperacion;
}
public void setEstatusoperacion(String estatusoperacion) {
	this.estatusoperacion = estatusoperacion;
}
public String getTipopersona() {
    return tipopersona;
}
public void setTipopersona(String tipopersona) {
	this.tipopersona = tipopersona;
}
public Date getFechacontabilizacion() {
    return fechacontabilizacion;
}
public void setFechacontabilizacion(Date fechacontabilizacion) {
	this.fechacontabilizacion = fechacontabilizacion;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDescripcioncomplementaria() {
    return descripcioncomplementaria;
}
public void setDescripcioncomplementaria(String descripcioncomplementaria) {
	this.descripcioncomplementaria = descripcioncomplementaria;
}
public String getNombrefideicomiso() {
    return nombrefideicomiso;
}
public void setNombrefideicomiso(String nombrefideicomiso) {
	this.nombrefideicomiso = nombrefideicomiso;
}
public String getEventos() {
    return eventos;
}
public void setEventos(String eventos) {
	this.eventos = eventos;
}
public String getTotalaplicado() {
    return totalaplicado;
}
public void setTotalaplicado(String totalaplicado) {
	this.totalaplicado = totalaplicado;
}
public String getImporterecepcion() {
    return importerecepcion;
}
public void setImporterecepcion(String importerecepcion) {
	this.importerecepcion = importerecepcion;
}
public String getOrigenrecursos() {
    return origenrecursos;
}
public void setOrigenrecursos(String origenrecursos) {
	this.origenrecursos = origenrecursos;
}
}
