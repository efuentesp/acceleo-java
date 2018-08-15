/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Socio.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class SocioBean {
/**
 * Clase SocioBean.
 * @author PSG.
 *
 */
	private Integer socioId;

	private String apellidopaterno;
	private Integer numero;
	private String nombre;
	private String apellidomaterno;
	private Genero esId;
	private enum Genero { mas,fem}
	private Tipoempleado tipoId;
	private enum Tipoempleado { c,b,t,p}
	private Integer departamentoId;
	private Integer plantaId;
	private String correo;
	private String telefono;

	public Integer getSocioId() {
		return socioId;
	}
	public void setSocioId(Integer socioId) {
		this.socioId = socioId;
	}
	public String getApellidopaterno () {
	    return apellidopaterno;  		
    }
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public Integer getNumero () {
	    return numero;  		
    }
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidomaterno () {
	    return apellidomaterno;  		
    }
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	public Genero getEsId () {
	    return esId;  		
    }
	public void setEsId (Genero esId) {
		this.esId = esId;
	}
	public Tipoempleado getTipoId () {
	    return tipoId;  		
    }
	public void setTipoId (Tipoempleado tipoId) {
		this.tipoId = tipoId;
	}
	public Integer getDepartamentoId () {
	    return departamentoId;  		
    }
	public void setDepartamentoId (Integer departamentoId) {
		this.departamentoId = departamentoId;
	}
	public Integer getPlantaId () {
	    return plantaId;  		
    }
	public void setPlantaId (Integer plantaId) {
		this.plantaId = plantaId;
	}

	public String getCorreo () {
	    return correo;  		
    }
	public void setCorreo (String correo) {
		this.correo = correo;
	}
	public String getTelefono () {
	    return telefono;  		
    }
	public void setTelefono (String telefono) {
		this.telefono = telefono;
	}

}
