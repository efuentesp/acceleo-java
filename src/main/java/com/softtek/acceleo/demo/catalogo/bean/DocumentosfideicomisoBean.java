package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Fideicomiso;

public class DocumentosfideicomisoBean {

/**
 * Clase DocumentosfideicomisoBean.
 * @author PSG.
 *
 */
 
private UUID documentosfideicomisoId; 
private String campo;
private UUID fideicomisoId;
private String contratofideicomiso;
private String actasconstitutivas;
private String cedulafiscal;
private String poderes;
private String identificadores;
private String comprobantesdomicilio;
private String formatoskyc;
private String formatoevaluacionriesgo;
private String worldcheck;
private String formatoinformacion;
private String autorizacioncomite;
private String firmascomite;
private String curp;

public UUID getDocumentosFideicomisoId() {
    return documentosfideicomisoId;  		
   }
public void setDocumentosFideicomisoId(UUID documentosfideicomisoId) {
	this.documentosfideicomisoId = documentosfideicomisoId;
}

public String getCampo() {
    return campo;
}
public void setCampo(String campo) {
	this.campo = campo;
}
public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public String getContratofideicomiso() {
    return contratofideicomiso;
}
public void setContratofideicomiso(String contratofideicomiso) {
	this.contratofideicomiso = contratofideicomiso;
}
public String getActasconstitutivas() {
    return actasconstitutivas;
}
public void setActasconstitutivas(String actasconstitutivas) {
	this.actasconstitutivas = actasconstitutivas;
}
public String getCedulafiscal() {
    return cedulafiscal;
}
public void setCedulafiscal(String cedulafiscal) {
	this.cedulafiscal = cedulafiscal;
}
public String getPoderes() {
    return poderes;
}
public void setPoderes(String poderes) {
	this.poderes = poderes;
}
public String getIdentificadores() {
    return identificadores;
}
public void setIdentificadores(String identificadores) {
	this.identificadores = identificadores;
}
public String getComprobantesdomicilio() {
    return comprobantesdomicilio;
}
public void setComprobantesdomicilio(String comprobantesdomicilio) {
	this.comprobantesdomicilio = comprobantesdomicilio;
}
public String getFormatoskyc() {
    return formatoskyc;
}
public void setFormatoskyc(String formatoskyc) {
	this.formatoskyc = formatoskyc;
}
public String getFormatoevaluacionriesgo() {
    return formatoevaluacionriesgo;
}
public void setFormatoevaluacionriesgo(String formatoevaluacionriesgo) {
	this.formatoevaluacionriesgo = formatoevaluacionriesgo;
}
public String getWorldcheck() {
    return worldcheck;
}
public void setWorldcheck(String worldcheck) {
	this.worldcheck = worldcheck;
}
public String getFormatoinformacion() {
    return formatoinformacion;
}
public void setFormatoinformacion(String formatoinformacion) {
	this.formatoinformacion = formatoinformacion;
}
public String getAutorizacioncomite() {
    return autorizacioncomite;
}
public void setAutorizacioncomite(String autorizacioncomite) {
	this.autorizacioncomite = autorizacioncomite;
}
public String getFirmascomite() {
    return firmascomite;
}
public void setFirmascomite(String firmascomite) {
	this.firmascomite = firmascomite;
}
public String getCurp() {
    return curp;
}
public void setCurp(String curp) {
	this.curp = curp;
}
}
