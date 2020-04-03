package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public class InstruccionBean {

/**
 * Clase InstruccionBean.
 * @author PSG.
 *
 */
 
private UUID instruccionId; 
private String fechahoracaptura;
private UUID fideicomisoId;
private UUID subfisoId;
private String folio;
private Date fechadocumeto;
private String clasificacion;
private String personalidadsolicitante;
private Date fechacambioestatus;
private String subtipoinstruccion;
private String importe;
private String importeaplicado;
private String nombrefideicomiso;
private String nombresubfiso;
private String titularfideicomiso;
private Date fechacompromiso;
private String formarecepcion;
private String estatusinstruccion;
private String tipoinstruccion;
private String moneda;
private String noeventos;
private String noefectuados;
private String infocomplementaria;

public UUID getInstruccionId() {
    return instruccionId;  		
   }
public void setInstruccionId(UUID instruccionId) {
	this.instruccionId = instruccionId;
}

public String getFechahoracaptura() {
    return fechahoracaptura;
}
public void setFechahoracaptura(String fechahoracaptura) {
	this.fechahoracaptura = fechahoracaptura;
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
public Date getFechadocumeto() {
    return fechadocumeto;
}
public void setFechadocumeto(Date fechadocumeto) {
	this.fechadocumeto = fechadocumeto;
}
public String getClasificacion() {
    return clasificacion;
}
public void setClasificacion(String clasificacion) {
	this.clasificacion = clasificacion;
}
public String getPersonalidadsolicitante() {
    return personalidadsolicitante;
}
public void setPersonalidadsolicitante(String personalidadsolicitante) {
	this.personalidadsolicitante = personalidadsolicitante;
}
public Date getFechacambioestatus() {
    return fechacambioestatus;
}
public void setFechacambioestatus(Date fechacambioestatus) {
	this.fechacambioestatus = fechacambioestatus;
}
public String getSubtipoinstruccion() {
    return subtipoinstruccion;
}
public void setSubtipoinstruccion(String subtipoinstruccion) {
	this.subtipoinstruccion = subtipoinstruccion;
}
public String getImporte() {
    return importe;
}
public void setImporte(String importe) {
	this.importe = importe;
}
public String getImporteaplicado() {
    return importeaplicado;
}
public void setImporteaplicado(String importeaplicado) {
	this.importeaplicado = importeaplicado;
}
public String getNombrefideicomiso() {
    return nombrefideicomiso;
}
public void setNombrefideicomiso(String nombrefideicomiso) {
	this.nombrefideicomiso = nombrefideicomiso;
}
public String getNombresubfiso() {
    return nombresubfiso;
}
public void setNombresubfiso(String nombresubfiso) {
	this.nombresubfiso = nombresubfiso;
}
public String getTitularfideicomiso() {
    return titularfideicomiso;
}
public void setTitularfideicomiso(String titularfideicomiso) {
	this.titularfideicomiso = titularfideicomiso;
}
public Date getFechacompromiso() {
    return fechacompromiso;
}
public void setFechacompromiso(Date fechacompromiso) {
	this.fechacompromiso = fechacompromiso;
}
public String getFormarecepcion() {
    return formarecepcion;
}
public void setFormarecepcion(String formarecepcion) {
	this.formarecepcion = formarecepcion;
}
public String getEstatusinstruccion() {
    return estatusinstruccion;
}
public void setEstatusinstruccion(String estatusinstruccion) {
	this.estatusinstruccion = estatusinstruccion;
}
public String getTipoinstruccion() {
    return tipoinstruccion;
}
public void setTipoinstruccion(String tipoinstruccion) {
	this.tipoinstruccion = tipoinstruccion;
}
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public String getNoeventos() {
    return noeventos;
}
public void setNoeventos(String noeventos) {
	this.noeventos = noeventos;
}
public String getNoefectuados() {
    return noefectuados;
}
public void setNoefectuados(String noefectuados) {
	this.noefectuados = noefectuados;
}
public String getInfocomplementaria() {
    return infocomplementaria;
}
public void setInfocomplementaria(String infocomplementaria) {
	this.infocomplementaria = infocomplementaria;
}	
}
