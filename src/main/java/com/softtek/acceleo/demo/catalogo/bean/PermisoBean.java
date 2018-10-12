/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Permiso.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class PermisoBean {
/**
 * Clase PermisoBean.
 * @author PSG.
 *
 */
	private Integer permisoId;

	private String ruta;
	private String funcion;
	private String nivelpermiso;
	private Integer rolId;

	public Integer getPermisoId() {
		return permisoId;
	}
	public void setPermisoId(Integer permisoId) {
		this.permisoId = permisoId;
	}
	public String getRuta () {
	    return ruta;  		
    }
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getFuncion () {
	    return funcion;  		
    }
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	public String getNivelpermiso () {
	    return nivelpermiso;  		
    }
	public void setNivelpermiso(String nivelpermiso) {
		this.nivelpermiso = nivelpermiso;
	}

	public Integer getRolId () {
	    return rolId;  		
    }
	public void setRolId (Integer rolId) {
		this.rolId = rolId;
	}


}
