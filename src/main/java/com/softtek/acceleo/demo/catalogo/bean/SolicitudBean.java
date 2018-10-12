/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Solicitud.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class SolicitudBean {
/**
 * Clase SolicitudBean.
 * @author PSG.
 *
 */
	private Integer solicitudId;

	private Double salario;
	private String correo;
	private String telefono;
	private Integer posicionId;
	private Integer candidatoId;
	private Estatussolicitud estadoId;
	private enum Estatussolicitud { e1,e4,e3,e2}
	private Date fecha;

	public Integer getSolicitudId() {
		return solicitudId;
	}
	public void setSolicitudId(Integer solicitudId) {
		this.solicitudId = solicitudId;
	}
	public Double getSalario () {
	    return salario;  		
    }
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getCorreo () {
	    return correo;  		
    }
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono () {
	    return telefono;  		
    }
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getPosicionId () {
	    return posicionId;  		
    }
	public void setPosicionId (Integer posicionId) {
		this.posicionId = posicionId;
	}
	public Integer getCandidatoId () {
	    return candidatoId;  		
    }
	public void setCandidatoId (Integer candidatoId) {
		this.candidatoId = candidatoId;
	}
	public Estatussolicitud getEstadoId () {
	    return estadoId;  		
    }
	public void setEstadoId (Estatussolicitud estadoId) {
		this.estadoId = estadoId;
	}

	public Date getFecha () {
	    return fecha;  		
    }
	public void setFecha (Date fecha) {
		this.fecha = fecha;
	}

}
