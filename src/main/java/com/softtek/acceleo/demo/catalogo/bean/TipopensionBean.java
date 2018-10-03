/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Tipopension.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class TipopensionBean {
/**
 * Clase TipopensionBean.
 * @author PSG.
 *
 */
	private Integer tipopensionId;

	private String clave;
	private String nombre;

	public Integer getTipopensionId() {
		return tipopensionId;
	}
	public void setTipopensionId(Integer tipopensionId) {
		this.tipopensionId = tipopensionId;
	}
	public String getClave () {
	    return clave;  		
    }
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



}
