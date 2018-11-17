package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class RolBean {

/**
 * Clase RolBean.
 * @author PSG.
 *
 */
 
private UUID rolId; 
private Integer clave;	
private String nombre;
private Integer activo;	

	public UUID getRolId () {
	    return rolId;  		
    }
	public void setRolId (UUID rolId) {
		this.rolId = rolId;
	}

public Integer getClave () {
    return clave;
    }
public void setClave(Integer clave) {
	this.clave = clave;
}	
public String getNombre () {
    return nombre;
    }
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Integer getActivo () {
    return activo;
    }
public void setActivo(Integer activo) {
	this.activo = activo;
}	
}
