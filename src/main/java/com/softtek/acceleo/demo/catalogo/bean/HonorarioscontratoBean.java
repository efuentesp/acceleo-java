package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;
import java.util.Set;

import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public class HonorarioscontratoBean {

/**
 * Clase HonorarioscontratoBean.
 * @author PSG.
 *
 */
 
private UUID honorarioscontratoId; 
private UUID fideicomisoId;
private UUID subfisoId;
private String nombre;
private String persona;
private String comisiones;
private String iva;

public UUID getHonorariosContratoId() {
    return honorarioscontratoId;  		
   }
public void setHonorariosContratoId(UUID honorarioscontratoId) {
	this.honorarioscontratoId = honorarioscontratoId;
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
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getPersona() {
    return persona;
}
public void setPersona(String persona) {
	this.persona = persona;
}
public String getComisiones() {
    return comisiones;
}
public void setComisiones(String comisiones) {
	this.comisiones = comisiones;
}
public String getIva() {
    return iva;
}
public void setIva(String iva) {
	this.iva = iva;
}
}
