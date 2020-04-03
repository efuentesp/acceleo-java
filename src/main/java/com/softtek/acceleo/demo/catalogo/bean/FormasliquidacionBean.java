package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Fideicomiso;

public class FormasliquidacionBean {

/**
 * Clase FormasliquidacionBean.
 * @author PSG.
 *
 */
 
private UUID formasliquidacionId; 
private UUID fideicomisoId;
private String participante;
private String tipo;
private String fideicomisario;
private String formaliquidacion;
private String moneda;
private String seccuentaseleccionada;
private String plprincipal;
private String estado;
private String secparamliq;

public UUID getFormasLiquidacionId() {
    return formasliquidacionId;  		
   }
public void setFormasLiquidacionId(UUID formasliquidacionId) {
	this.formasliquidacionId = formasliquidacionId;
}

public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public String getParticipante() {
    return participante;
}
public void setParticipante(String participante) {
	this.participante = participante;
}
public String getTipo() {
    return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getFideicomisario() {
    return fideicomisario;
}
public void setFideicomisario(String fideicomisario) {
	this.fideicomisario = fideicomisario;
}
public String getFormaliquidacion() {
    return formaliquidacion;
}
public void setFormaliquidacion(String formaliquidacion) {
	this.formaliquidacion = formaliquidacion;
}
public String getMoneda() {
    return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public String getSeccuentaseleccionada() {
    return seccuentaseleccionada;
}
public void setSeccuentaseleccionada(String seccuentaseleccionada) {
	this.seccuentaseleccionada = seccuentaseleccionada;
}
public String getPlprincipal() {
    return plprincipal;
}
public void setPlprincipal(String plprincipal) {
	this.plprincipal = plprincipal;
}
public String getEstado() {
    return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public String getSecparamliq() {
    return secparamliq;
}
public void setSecparamliq(String secparamliq) {
	this.secparamliq = secparamliq;
}
}
