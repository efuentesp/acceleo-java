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

	private Date fechadisponibilidad;
	private Date fechacontratacion;
	private Integer numero;
	private Date fechavencimiento;
	private Tipoahorro tipoId;
	private enum Tipoahorro { v,m6,m3,nov,m1,esp2,esp1,fap}

	public Integer getCuentadeahorroId() {
		return cuentadeahorroId;
	}
	public void setCuentadeahorroId(Integer cuentadeahorroId) {
		this.cuentadeahorroId = cuentadeahorroId;
	}
	public Date getFechadisponibilidad () {
	    return fechadisponibilidad;  		
    }
	public void setFechadisponibilidad(Date fechadisponibilidad) {
		this.fechadisponibilidad = fechadisponibilidad;
	}
	public Date getFechacontratacion () {
	    return fechacontratacion;  		
    }
	public void setFechacontratacion(Date fechacontratacion) {
		this.fechacontratacion = fechacontratacion;
	}
	public Integer getNumero () {
	    return numero;  		
    }
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getFechavencimiento () {
	    return fechavencimiento;  		
    }
	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public Tipoahorro getTipoId () {
	    return tipoId;  		
    }
	public void setTipoId (Tipoahorro tipoId) {
		this.tipoId = tipoId;
	}


}
