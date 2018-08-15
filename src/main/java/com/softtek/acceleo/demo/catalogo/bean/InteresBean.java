/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Interes.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class InteresBean {
/**
 * Clase InteresBean.
 * @author PSG.
 *
 */
	private Integer interesId;

	private Date fecha;
	private Double monto;
	private Integer cuentadeahorroId;

	public Integer getInteresId() {
		return interesId;
	}
	public void setInteresId(Integer interesId) {
		this.interesId = interesId;
	}
	public Date getFecha () {
	    return fecha;  		
    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getMonto () {
	    return monto;  		
    }
	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Integer getCuentadeahorroId () {
	    return cuentadeahorroId;  		
    }
	public void setCuentadeahorroId (Integer cuentadeahorroId) {
		this.cuentadeahorroId = cuentadeahorroId;
	}


}
