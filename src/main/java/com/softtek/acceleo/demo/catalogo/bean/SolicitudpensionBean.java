/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Solicitudpension.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class SolicitudpensionBean {
/**
 * Clase SolicitudpensionBean.
 * @author PSG.
 *
 */
	private Integer solicitudpensionId;

	private Integer numero;
	private Date fecha_solicitud;
	private Integer afiliadoId;
	private Integer tipopensionId;
	private String observaciones;

	public Integer getSolicitudpensionId() {
		return solicitudpensionId;
	}
	public void setSolicitudpensionId(Integer solicitudpensionId) {
		this.solicitudpensionId = solicitudpensionId;
	}
	public Integer getNumero () {
	    return numero;  		
    }
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getFecha_solicitud () {
	    return fecha_solicitud;  		
    }
	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public Integer getAfiliadoId () {
	    return afiliadoId;  		
    }
	public void setAfiliadoId (Integer afiliadoId) {
		this.afiliadoId = afiliadoId;
	}
	public Integer getTipopensionId () {
	    return tipopensionId;  		
    }
	public void setTipopensionId (Integer tipopensionId) {
		this.tipopensionId = tipopensionId;
	}

	public String getObservaciones () {
	    return observaciones;  		
    }
	public void setObservaciones (String observaciones) {
		this.observaciones = observaciones;
	}

}
