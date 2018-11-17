package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class EventoBean {

/**
 * Clase EventoBean.
 * @author PSG.
 *
 */
 
private UUID eventoId; 
private String tipoevento;
private String nombre;
private UUID posicionId;
private UUID candidatoId;
private Date fecha;	
private String responsable;
private String notas;
private Date fechareal;	
private String responsablereal;
private String feedback;
private String comentarios;
private String estatusevento;

	public UUID getEventoId () {
	    return eventoId;  		
    }
	public void setEventoId (UUID eventoId) {
		this.eventoId = eventoId;
	}

public String getTipoevento () {
    return tipoevento;
    }
public void setTipoevento(String tipoevento) {
	this.tipoevento = tipoevento;
}
public String getNombre () {
    return nombre;
    }
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public UUID getPosicionId () {
    return posicionId;
    }
public void setPosicion(UUID posicionId) {
	this.posicionId = posicionId;
}
public UUID getCandidatoId () {
    return candidatoId;
    }
public void setCandidato(UUID candidatoId) {
	this.candidatoId = candidatoId;
}
public Date getFecha () {
    return fecha;
    }
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getResponsable () {
    return responsable;
    }
public void setResponsable(String responsable) {
	this.responsable = responsable;
}
public String getNotas () {
    return notas;
    }
public void setNotas(String notas) {
	this.notas = notas;
}
public Date getFechareal () {
    return fechareal;
    }
public void setFechareal(Date fechareal) {
	this.fechareal = fechareal;
}
public String getResponsablereal () {
    return responsablereal;
    }
public void setResponsablereal(String responsablereal) {
	this.responsablereal = responsablereal;
}
public String getFeedback () {
    return feedback;
    }
public void setFeedback(String feedback) {
	this.feedback = feedback;
}
public String getComentarios () {
    return comentarios;
    }
public void setComentarios(String comentarios) {
	this.comentarios = comentarios;
}
public String getEstatusevento () {
    return estatusevento;
    }
public void setEstatusevento(String estatusevento) {
	this.estatusevento = estatusevento;
}
}
