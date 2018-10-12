/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Filial.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class FilialBean {
/**
 * Clase FilialBean.
 * @author PSG.
 *
 */
	private Integer filialId;

	private String sitio;
	private String telefono;
	private String nombre;
	private String ciudad;
	private String estado;
	private String ubicacion;
	private String contacto;
	private String notas;

	public Integer getFilialId() {
		return filialId;
	}
	public void setFilialId(Integer filialId) {
		this.filialId = filialId;
	}
	public String getSitio () {
	    return sitio;  		
    }
	public void setSitio(String sitio) {
		this.sitio = sitio;
	}
	public String getTelefono () {
	    return telefono;  		
    }
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getUbicacion () {
	    return ubicacion;  		
    }
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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
	public void setNotas (String notas) {
		this.notas = notas;
	}

}
