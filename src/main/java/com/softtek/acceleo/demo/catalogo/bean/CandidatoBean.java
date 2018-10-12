/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Candidato.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class CandidatoBean {
/**
 * Clase CandidatoBean.
 * @author PSG.
 *
 */
	private Integer candidatoId;

	private Date fecha;
	private String apellidomaterno;
	private String apellidopaterno;
	private String nombre;
	private Genero esId;
	private enum Genero { mas,fem}
	private Estatuscandidato estadoId;
	private enum Estatuscandidato { e4,e1,e6,e2,e5,e3,e7}
	private Integer solicitudId;
	private Integer eventoId;

	public Integer getCandidatoId() {
		return candidatoId;
	}
	public void setCandidatoId(Integer candidatoId) {
		this.candidatoId = candidatoId;
	}
	public Date getFecha () {
	    return fecha;  		
    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getApellidomaterno () {
	    return apellidomaterno;  		
    }
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public String getApellidopaterno () {
	    return apellidopaterno;  		
    }
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Genero getEsId () {
	    return esId;  		
    }
	public void setEsId (Genero esId) {
		this.esId = esId;
	}
	public Estatuscandidato getEstadoId () {
	    return estadoId;  		
    }
	public void setEstadoId (Estatuscandidato estadoId) {
		this.estadoId = estadoId;
	}
	public Integer getSolicitudId () {
	    return solicitudId;  		
    }
	public void setSolicitudId (Integer solicitudId) {
		this.solicitudId = solicitudId;
	}
	public Integer getEventoId () {
	    return eventoId;  		
    }
	public void setEventoId (Integer eventoId) {
		this.eventoId = eventoId;
	}


}
