package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class DireccionBean {

/**
 * Clase DireccionBean.
 * @author PSG.
 *
 */
 
private UUID direccionId; 
private String calle;
private String cp;
private String ciudad;
private String estado;

	public UUID getDireccionId () {
	    return direccionId;  		
    }
	public void setDireccionId (UUID direccionId) {
		this.direccionId = direccionId;
	}

public String getCalle () {
    return calle;
    }
public void setCalle(String calle) {
	this.calle = calle;
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
public String getEstado () {
    return estado;
    }
public void setEstado(String estado) {
	this.estado = estado;
}
}
