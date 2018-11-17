package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class UsuarioBean {

/**
 * Clase UsuarioBean.
 * @author PSG.
 *
 */
 
private UUID usuarioId; 
private String nombreclave;
private String password;
private Integer activo;	
private UUID rolId;

	public UUID getUsuarioId () {
	    return usuarioId;  		
    }
	public void setUsuarioId (UUID usuarioId) {
		this.usuarioId = usuarioId;
	}

public String getNombreclave () {
    return nombreclave;
    }
public void setNombreclave(String nombreclave) {
	this.nombreclave = nombreclave;
}
public String getPassword () {
    return password;
    }
public void setPassword(String password) {
	this.password = password;
}
public Integer getActivo () {
    return activo;
    }
public void setActivo(Integer activo) {
	this.activo = activo;
}	
public UUID getRolId () {
    return rolId;
    }
public void setRol(UUID rolId) {
	this.rolId = rolId;
}
}
