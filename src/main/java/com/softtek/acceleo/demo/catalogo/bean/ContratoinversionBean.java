package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.domain.Telefonocontacto;

public class ContratoinversionBean {

/**
 * Clase ContratoinversionBean.
 * @author PSG.
 *
 */
 
private UUID contratoinversionId; 
private UUID fideicomisoId;
private String tipocontrato;
private String intermediario;
private String moneda;
private String resparamliq;
private String enviorecursosinv;
private String transferenciarecdesinver;
private String retenerisr;
private UUID subfisoId;
private Date fechavencimiento;
private String estatus;
private String contratoiversion;
private String contratootrasinst;
private String nombre;
private String cuenta;
private String traspasoentresubfiso;
private Date fechaapertura;
private String origenrecursos;
private Set<Telefonocontacto> _contacto;

public UUID getContratoInversionId() {
    return contratoinversionId;  		
   }
public void setContratoInversionId(UUID contratoinversionId) {
	this.contratoinversionId = contratoinversionId;
}

public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public String getTipocontrato() {
    return tipocontrato;
}
public void setTipocontrato(String tipocontrato) {
	this.tipocontrato = tipocontrato;
}
public String getIntermediario() {
    return intermediario;
}
public void setIntermediario(String intermediario) {
	this.intermediario = intermediario;
}
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public String getResparamliq() {
    return resparamliq;
}
public void setResparamliq(String resparamliq) {
	this.resparamliq = resparamliq;
}
public String getEnviorecursosinv() {
    return enviorecursosinv;
}
public void setEnviorecursosinv(String enviorecursosinv) {
	this.enviorecursosinv = enviorecursosinv;
}
public String getTransferenciarecdesinver() {
    return transferenciarecdesinver;
}
public void setTransferenciarecdesinver(String transferenciarecdesinver) {
	this.transferenciarecdesinver = transferenciarecdesinver;
}
public String getRetenerisr() {
    return retenerisr;
}
public void setRetenerisr(String retenerisr) {
	this.retenerisr = retenerisr;
}
public UUID getSubfisoId() {
    return subfisoId;
}
public void setSubfiso(UUID subfisoId) {
	this.subfisoId = subfisoId;
}
public Date getFechavencimiento() {
    return fechavencimiento;
}
public void setFechavencimiento(Date fechavencimiento) {
	this.fechavencimiento = fechavencimiento;
}
public String getEstatus() {
    return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
public String getContratoiversion() {
    return contratoiversion;
}
public void setContratoiversion(String contratoiversion) {
	this.contratoiversion = contratoiversion;
}
public String getContratootrasinst() {
    return contratootrasinst;
}
public void setContratootrasinst(String contratootrasinst) {
	this.contratootrasinst = contratootrasinst;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getCuenta() {
    return cuenta;
}
public void setCuenta(String cuenta) {
	this.cuenta = cuenta;
}
public String getTraspasoentresubfiso() {
    return traspasoentresubfiso;
}
public void setTraspasoentresubfiso(String traspasoentresubfiso) {
	this.traspasoentresubfiso = traspasoentresubfiso;
}
public Date getFechaapertura() {
    return fechaapertura;
}
public void setFechaapertura(Date fechaapertura) {
	this.fechaapertura = fechaapertura;
}
public String getOrigenrecursos() {
    return origenrecursos;
}
public void setOrigenrecursos(String origenrecursos) {
	this.origenrecursos = origenrecursos;
}
public Set<Telefonocontacto> get_contacto() {
	return _contacto;
}
		
public void set_contacto(Set<Telefonocontacto> _contacto) {
	this._contacto = _contacto;
}		
}
