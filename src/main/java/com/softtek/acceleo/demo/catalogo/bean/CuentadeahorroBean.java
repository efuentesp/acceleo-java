/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Cuentadeahorro.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class CuentadeahorroBean {
/**
 * Clase CuentadeahorroBean.
 * @author PSG.
 *
 */
	private Integer cuentadeahorroId;

	private Integer numero;
	private Date fechadisponibilidad;
	private Date fechavencimiento;
	private Date fechacontratacion;
	private Integer socioId;
	private Tipoahorro tipoId;
	private enum Tipoahorro { v,m6,m3,nov,m1,esp2,esp1,fap}

	public Integer getCuentadeahorroId() {
		return cuentadeahorroId;
	}
	public void setCuentadeahorroId(Integer cuentadeahorroId) {
		this.cuentadeahorroId = cuentadeahorroId;
	}
	public Integer getNumero () {
	    return numero;  		
    }
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getFechadisponibilidad () {
	    return fechadisponibilidad;  		
    }
	public void setFechadisponibilidad(Date fechadisponibilidad) {
		this.fechadisponibilidad = fechadisponibilidad;
	}
	public Date getFechavencimiento () {
	    return fechavencimiento;  		
    }
	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	public Date getFechacontratacion () {
	    return fechacontratacion;  		
    }
	public void setFechacontratacion(Date fechacontratacion) {
		this.fechacontratacion = fechacontratacion;
	}

	public Integer getSocioId () {
	    return socioId;  		
    }
	public void setSocioId (Integer socioId) {
		this.socioId = socioId;
	}
	public Tipoahorro getTipoId () {
	    return tipoId;  		
    }
	public void setTipoId (Tipoahorro tipoId) {
		this.tipoId = tipoId;
	}


}
