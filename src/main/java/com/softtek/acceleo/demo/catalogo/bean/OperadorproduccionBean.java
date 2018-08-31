/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Operadorproduccion.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class OperadorproduccionBean {
/**
 * Clase OperadorproduccionBean.
 * @author PSG.
 *
 */
	private Integer operadorproduccionId;

	private String nombre;
	private Integer numeroempleado;

	public Integer getOperadorproduccionId() {
		return operadorproduccionId;
	}
	public void setOperadorproduccionId(Integer operadorproduccionId) {
		this.operadorproduccionId = operadorproduccionId;
	}
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getNumeroempleado () {
	    return numeroempleado;  		
    }
	public void setNumeroempleado(Integer numeroempleado) {
		this.numeroempleado = numeroempleado;
	}



}
