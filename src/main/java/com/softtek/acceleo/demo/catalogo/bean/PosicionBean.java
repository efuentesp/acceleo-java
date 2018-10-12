/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Posicion.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class PosicionBean {
/**
 * Clase PosicionBean.
 * @author PSG.
 *
 */
	private Integer posicionId;

	private String descripcion;
	private String contacto;
	private Double salario;
	private Integer vacantes;
	private String nombre;
	private Date fecha;
	private Integer filialId;
	private Integer puestoId;
	private Tiponomina tipoId;
	private enum Tiponomina { c,b,a}
	private Integer reclutadorId;
	private Estatusposicion estadoId;
	private enum Estatusposicion { e3,e2,e4,e1}
	private Integer solicitudId;
	private Integer eventoId;

	public Integer getPosicionId() {
		return posicionId;
	}
	public void setPosicionId(Integer posicionId) {
		this.posicionId = posicionId;
	}
	public String getDescripcion () {
	    return descripcion;  		
    }
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getContacto () {
	    return contacto;  		
    }
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public Double getSalario () {
	    return salario;  		
    }
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer getVacantes () {
	    return vacantes;  		
    }
	public void setVacantes(Integer vacantes) {
		this.vacantes = vacantes;
	}
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha () {
	    return fecha;  		
    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getFilialId () {
	    return filialId;  		
    }
	public void setFilialId (Integer filialId) {
		this.filialId = filialId;
	}
	public Integer getPuestoId () {
	    return puestoId;  		
    }
	public void setPuestoId (Integer puestoId) {
		this.puestoId = puestoId;
	}
	public Tiponomina getTipoId () {
	    return tipoId;  		
    }
	public void setTipoId (Tiponomina tipoId) {
		this.tipoId = tipoId;
	}
	public Integer getReclutadorId () {
	    return reclutadorId;  		
    }
	public void setReclutadorId (Integer reclutadorId) {
		this.reclutadorId = reclutadorId;
	}
	public Estatusposicion getEstadoId () {
	    return estadoId;  		
    }
	public void setEstadoId (Estatusposicion estadoId) {
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
