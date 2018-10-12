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

	private String estado;
	private String cp;
	private String ciudad;
	private String calle;
	private Integer candidatoId;

	public Integer getDireccionId() {
		return direccionId;
	}
	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}
	public String getEstado () {
	    return estado;  		
    }
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCp () {
	    return cp;  		
    }
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCiudad () {
	    return ciudad;  		
    }
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCalle () {
	    return calle;  		
    }
	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getCandidatoId () {
	    return candidatoId;  		
    }
	public void setCandidatoId (Integer candidatoId) {
		this.candidatoId = candidatoId;
	}


}
