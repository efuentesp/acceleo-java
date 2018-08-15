/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Tasadeinteres.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class TasadeinteresBean {
/**
 * Clase TasadeinteresBean.
 * @author PSG.
 *
 */
	private Integer tasadeinteresId;

	private Date fechafin;
	private Date fechainicio;
	private Double tasa;
	private Integer empresaId;

	public Integer getTasadeinteresId() {
		return tasadeinteresId;
	}
	public void setTasadeinteresId(Integer tasadeinteresId) {
		this.tasadeinteresId = tasadeinteresId;
	}
	public Date getFechafin () {
	    return fechafin;  		
    }
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	public Date getFechainicio () {
	    return fechainicio;  		
    }
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public Double getTasa () {
	    return tasa;  		
    }
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	public Integer getEmpresaId () {
	    return empresaId;  		
    }
	public void setEmpresaId (Integer empresaId) {
		this.empresaId = empresaId;
	}


}
