package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public class AgendaBean {

/**
 * Clase AgendaBean.
 * @author PSG.
 *
 */
 
private UUID agendaId; 
private UUID fideicomisoId;
private UUID subfisoId;
private String evento;
private String fecha;
private String estatus;
private String observacion;
private String concovados;

public UUID getAgendaId() {
    return agendaId;  		
   }
public void setAgendaId(UUID agendaId) {
	this.agendaId = agendaId;
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
public String getEvento() {
    return evento;
}
public void setEvento(String evento) {
	this.evento = evento;
}
public String getFecha() {
    return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getEstatus() {
    return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
public String getObservacion() {
    return observacion;
}
public void setObservacion(String observacion) {
	this.observacion = observacion;
}
public String getConcovados() {
    return concovados;
}
public void setConcovados(String concovados) {
	this.concovados = concovados;
}	
}
