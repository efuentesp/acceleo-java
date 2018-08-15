/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Cuentabancaria.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class CuentabancariaBean {
/**
 * Clase CuentabancariaBean.
 * @author PSG.
 *
 */
	private Integer cuentabancariaId;

	private Integer clabe;
	private Integer cuenta;
	private Integer socioId;
	private Banco emitidaporId;
	private enum Banco { b3,b1,b4,b5,b2}

	public Integer getCuentabancariaId() {
		return cuentabancariaId;
	}
	public void setCuentabancariaId(Integer cuentabancariaId) {
		this.cuentabancariaId = cuentabancariaId;
	}
	public Integer getClabe () {
	    return clabe;  		
    }
	public void setClabe(Integer clabe) {
		this.clabe = clabe;
	}
	public Integer getCuenta () {
	    return cuenta;  		
    }
	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public Integer getSocioId () {
	    return socioId;  		
    }
	public void setSocioId (Integer socioId) {
		this.socioId = socioId;
	}
	public Banco getEmitidaporId () {
	    return emitidaporId;  		
    }
	public void setEmitidaporId (Banco emitidaporId) {
		this.emitidaporId = emitidaporId;
	}


}
