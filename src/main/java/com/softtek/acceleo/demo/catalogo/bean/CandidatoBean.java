package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class CandidatoBean {

/**
 * Clase CandidatoBean.
 * @author PSG.
 *
 */
 
private UUID candidatoId; 
private String nombre;
private String apellidopaterno;
private String apellidomaterno;
private Date fecha;	
private String genero;
private String estatuscandidato;

	public UUID getCandidatoId () {
	    return candidatoId;  		
    }
	public void setCandidatoId (UUID candidatoId) {
		this.candidatoId = candidatoId;
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
public Date getFecha () {
    return fecha;
    }
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getGenero () {
    return genero;
    }
public void setGenero(String genero) {
	this.genero = genero;
}
public String getEstatuscandidato () {
    return estatuscandidato;
    }
public void setEstatuscandidato(String estatuscandidato) {
	this.estatuscandidato = estatuscandidato;
}
}
