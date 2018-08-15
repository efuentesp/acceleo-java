/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Domicilio.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class DomicilioBean {
/**
 * Clase DomicilioBean.
 * @author PSG.
 *
 */
	private Integer domicilioId;

	private String ciudad;
	private String cp;
	private String estado;
	private String calle;
	private Integer socioId;

	public Integer getDomicilioId() {
		return domicilioId;
	}
	public void setDomicilioId(Integer domicilioId) {
		this.domicilioId = domicilioId;
	}
	public String getCiudad () {
	    return ciudad;  		
    }
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCp () {
	    return cp;  		
    }
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getEstado () {
	    return estado;  		
    }
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCalle () {
	    return calle;  		
    }
	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getSocioId () {
	    return socioId;  		
    }
	public void setSocioId (Integer socioId) {
		this.socioId = socioId;
	}


}
