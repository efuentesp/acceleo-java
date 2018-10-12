/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Rol.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class RolBean {
/**
 * Clase RolBean.
 * @author PSG.
 *
 */
	private Integer rolId;

	private Integer activo;
	private Integer clave;
	private String nombre;

	public Integer getRolId() {
		return rolId;
	}
	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}
	public Integer getActivo () {
	    return activo;  		
    }
	public void setActivo(Integer activo) {
		this.activo = activo;
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



}
