/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Puesto.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class PuestoBean {
/**
 * Clase PuestoBean.
 * @author PSG.
 *
 */
	private Integer puestoId;

	private String descripcion;
	private Puestos nombreId;
	private enum Puestos { d,b,g,c,a,f,e}

	public Integer getPuestoId() {
		return puestoId;
	}
	public void setPuestoId(Integer puestoId) {
		this.puestoId = puestoId;
	}
	public String getDescripcion () {
	    return descripcion;  		
    }
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Puestos getNombreId () {
	    return nombreId;  		
    }
	public void setNombreId (Puestos nombreId) {
		this.nombreId = nombreId;
	}


}
