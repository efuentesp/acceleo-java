package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class ReclutadorBean {

/**
 * Clase ReclutadorBean.
 * @author PSG.
 *
 */
 
private UUID reclutadorId; 
private String nombre;
private String apellidopaterno;
private String apellidomaterno;
private String genero;

	public UUID getReclutadorId () {
	    return reclutadorId;  		
    }
	public void setReclutadorId (UUID reclutadorId) {
		this.reclutadorId = reclutadorId;
	}

public String getNombre () {
    return nombre;
    }
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellidopaterno () {
    return apellidopaterno;
    }
public void setApellidopaterno(String apellidopaterno) {
	this.apellidopaterno = apellidopaterno;
}
public String getApellidomaterno () {
    return apellidomaterno;
    }
public void setApellidomaterno(String apellidomaterno) {
	this.apellidomaterno = apellidomaterno;
}
public String getGenero () {
    return genero;
    }
public void setGenero(String genero) {
	this.genero = genero;
}
}
