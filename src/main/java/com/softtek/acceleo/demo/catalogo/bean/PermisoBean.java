package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class PermisoBean {

/**
 * Clase PermisoBean.
 * @author PSG.
 *
 */
 
private UUID permisoId; 
private UUID rolId;
private String funcion;
private String ruta;
private String nivelpermiso;

	public UUID getPermisoId () {
	    return permisoId;  		
    }
	public void setPermisoId (UUID permisoId) {
		this.permisoId = permisoId;
	}

public UUID getRolId () {
    return rolId;
    }
public void setRol(UUID rolId) {
	this.rolId = rolId;
}
public String getFuncion () {
    return funcion;
    }
public void setFuncion(String funcion) {
	this.funcion = funcion;
}
public String getRuta () {
    return ruta;
    }
public void setRuta(String ruta) {
	this.ruta = ruta;
}
public String getNivelpermiso () {
    return nivelpermiso;
    }
public void setNivelpermiso(String nivelpermiso) {
	this.nivelpermiso = nivelpermiso;
}
}
