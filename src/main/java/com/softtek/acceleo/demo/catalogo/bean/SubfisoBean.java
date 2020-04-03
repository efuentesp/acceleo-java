package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Fideicomiso;

public class SubfisoBean {

/**
 * Clase SubfisoBean.
 * @author PSG.
 *
 */
 
private UUID subfisoId; 
private UUID fideicomisoId;
private Integer numero;
private String nombre;
private String estatus;
private Date fecharegistro;
private String identificador;

public UUID getSubfisoId() {
    return subfisoId;  		
   }
public void setSubfisoId(UUID subfisoId) {
	this.subfisoId = subfisoId;
}

public UUID getFideicomisoId() {
    return fideicomisoId;
}
public void setFideicomiso(UUID fideicomisoId) {
	this.fideicomisoId = fideicomisoId;
}
public Integer getNumero() {
    return numero;
}
public void setNumero(Integer numero) {
	this.numero = numero;
}	
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getEstatus() {
    return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
public Date getFecharegistro() {
    return fecharegistro;
}
public void setFecharegistro(Date fecharegistro) {
	this.fecharegistro = fecharegistro;
}
public String getIdentificador() {
    return identificador;
}
public void setIdentificador(String identificador) {
	this.identificador = identificador;
}
}
