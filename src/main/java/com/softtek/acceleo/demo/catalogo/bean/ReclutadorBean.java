/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Reclutador.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class ReclutadorBean {
/**
 * Clase ReclutadorBean.
 * @author PSG.
 *
 */
	private Integer reclutadorId;

	private String apellidomaterno;
	private String nombre;
	private String apellidopaterno;
	private Genero esId;
	private enum Genero { mas,fem}

	public Integer getReclutadorId() {
		return reclutadorId;
	}
	public void setReclutadorId(Integer reclutadorId) {
		this.reclutadorId = reclutadorId;
	}
	public String getApellidomaterno () {
	    return apellidomaterno;  		
    }
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
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

	public Genero getEsId () {
	    return esId;  		
    }
	public void setEsId (Genero esId) {
		this.esId = esId;
	}


}
