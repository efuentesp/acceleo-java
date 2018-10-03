/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Direccion.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class DireccionBean {
/**
 * Clase DireccionBean.
 * @author PSG.
 *
 */
	private Integer direccionId;

	private String numero;
	private String calle;

	public Integer getDireccionId() {
		return direccionId;
	}
	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}
	public String getNumero () {
	    return numero;  		
    }
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCalle () {
	    return calle;  		
    }
	public void setCalle(String calle) {
		this.calle = calle;
	}



}
