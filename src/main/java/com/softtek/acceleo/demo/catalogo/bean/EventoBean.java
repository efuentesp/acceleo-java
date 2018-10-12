/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Evento.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class EventoBean {
/**
 * Clase EventoBean.
 * @author PSG.
 *
 */
	private Integer eventoId;

	private String responsable;
	private Date fecha;
	private String nombre;
	private Tipoevento tipoId;
	private enum Tipoevento { f,e,i,c,h,a,d,g,b}
	private Integer posicionId;
	private Integer candidatoId;
	private Estatusevento estadoId;
	private enum Estatusevento { e2,e6,e1,e3,e5,e4}
	private String feedback;
	private String responsablereal;
	private Date fechareal;
	private String comentarios;
	private String notas;

	public Integer getEventoId() {
		return eventoId;
	}
	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}
	public String getResponsable () {
	    return responsable;  		
    }
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public Date getFecha () {
	    return fecha;  		
    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipoevento getTipoId () {
	    return tipoId;  		
    }
	public void setTipoId (Tipoevento tipoId) {
		this.tipoId = tipoId;
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
	public Estatusevento getEstadoId () {
	    return estadoId;  		
    }
	public void setEstadoId (Estatusevento estadoId) {
		this.estadoId = estadoId;
	}

	public String getFeedback () {
	    return feedback;  		
    }
	public void setFeedback (String feedback) {
		this.feedback = feedback;
	}
	public String getResponsablereal () {
	    return responsablereal;  		
    }
	public void setResponsablereal (String responsablereal) {
		this.responsablereal = responsablereal;
	}
	public Date getFechareal () {
	    return fechareal;  		
    }
	public void setFechareal (Date fechareal) {
		this.fechareal = fechareal;
	}
	public String getComentarios () {
	    return comentarios;  		
    }
	public void setComentarios (String comentarios) {
		this.comentarios = comentarios;
	}
	public String getNotas () {
	    return notas;  		
    }
	public void setNotas (String notas) {
		this.notas = notas;
	}

}
