package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Fideicomiso;

public class HonorarioadministracionBean {

/**
 * Clase HonorarioadministracionBean.
 * @author PSG.
 *
 */
 
private UUID honorarioadministracionId; 
private UUID fideicomisoId;
private String periodo;
private String montopatrimonio;
private String de;
private String destinatario;
private String honorarioatual;
private String cuotaminima;

public UUID getHonorarioAdministracionId() {
    return honorarioadministracionId;  		
   }
public void setHonorarioAdministracionId(UUID honorarioadministracionId) {
	this.honorarioadministracionId = honorarioadministracionId;
}

public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public String getPeriodo() {
    return periodo;
}
public void setPeriodo(String periodo) {
	this.periodo = periodo;
}
public String getMontopatrimonio() {
    return montopatrimonio;
}
public void setMontopatrimonio(String montopatrimonio) {
	this.montopatrimonio = montopatrimonio;
}
public String getDe() {
    return de;
}
public void setDe(String de) {
	this.de = de;
}
public String getDestinatario() {
    return destinatario;
}
public void setDestinatario(String destinatario) {
	this.destinatario = destinatario;
}
public String getHonorarioatual() {
    return honorarioatual;
}
public void setHonorarioatual(String honorarioatual) {
	this.honorarioatual = honorarioatual;
}
public String getCuotaminima() {
    return cuotaminima;
}
public void setCuotaminima(String cuotaminima) {
	this.cuotaminima = cuotaminima;
}
}
