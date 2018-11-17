package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class FilialBean {

/**
 * Clase FilialBean.
 * @author PSG.
 *
 */
 
private UUID filialId; 
private String nombre;
private String ubicacion;
private String ciudad;
private String estado;
private String telefono;
private String sitio;
private String contacto;
private String notas;

	public UUID getFilialId () {
	    return filialId;  		
    }
	public void setFilialId (UUID filialId) {
		this.filialId = filialId;
	}

public String getNombre () {
    return nombre;
    }
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getUbicacion () {
    return ubicacion;
    }
public void setUbicacion(String ubicacion) {
	this.ubicacion = ubicacion;
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
public String getTelefono () {
    return telefono;
    }
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getSitio () {
    return sitio;
    }
public void setSitio(String sitio) {
	this.sitio = sitio;
}
public String getContacto () {
    return contacto;
    }
public void setContacto(String contacto) {
	this.contacto = contacto;
}
public String getNotas () {
    return notas;
    }
public void setNotas(String notas) {
	this.notas = notas;
}
}
