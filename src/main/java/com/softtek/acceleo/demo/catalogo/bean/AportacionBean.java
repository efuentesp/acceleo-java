/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Aportacion.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class AportacionBean {
/**
 * Clase AportacionBean.
 * @author PSG.
 *
 */
	private Integer aportacionId;

	private Double monto;
	private Date fecha;
	private Integer cuentadeahorroId;
	private Tipoaportacion conceptoId;
	private enum Tipoaportacion { ag,ut,fa,cf}

	public Integer getAportacionId() {
		return aportacionId;
	}
	public void setAportacionId(Integer aportacionId) {
		this.aportacionId = aportacionId;
	}
	public Double getMonto () {
	    return monto;  		
    }
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Date getFecha () {
	    return fecha;  		
    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getCuentadeahorroId () {
	    return cuentadeahorroId;  		
    }
	public void setCuentadeahorroId (Integer cuentadeahorroId) {
		this.cuentadeahorroId = cuentadeahorroId;
	}
	public Tipoaportacion getConceptoId () {
	    return conceptoId;  		
    }
	public void setConceptoId (Tipoaportacion conceptoId) {
		this.conceptoId = conceptoId;
	}


}
