/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Usuario.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class UsuarioBean {
/**
 * Clase UsuarioBean.
 * @author PSG.
 *
 */
	private Integer usuarioId;

	private Integer activo;
	private String nombreclave;
	private String password;
	private Integer rolId;

	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Integer getActivo () {
	    return activo;  		
    }
	public void setActivo(Integer activo) {
		this.activo = activo;
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

	public Integer getRolId () {
	    return rolId;  		
    }
	public void setRolId (Integer rolId) {
		this.rolId = rolId;
	}


}
