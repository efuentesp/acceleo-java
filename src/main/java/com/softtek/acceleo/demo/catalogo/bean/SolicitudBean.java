package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class SolicitudBean {

/**
 * Clase SolicitudBean.
 * @author PSG.
 *
 */
 
private UUID solicitudId; 
private UUID posicionId;
private UUID candidatoId;
private Date fecha;	
private Double salario;	
private String correo;
private String telefono;
private UUID direccionId;
private String trayectoria;
private String estatussolicitud;

	public UUID getSolicitudId () {
	    return solicitudId;  		
    }
	public void setSolicitudId (UUID solicitudId) {
		this.solicitudId = solicitudId;
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
public UUID getDireccionId () {
    return direccionId;
    }
public void setDireccion(UUID direccionId) {
	this.direccionId = direccionId;
}
public String getTrayectoria () {
    return trayectoria;
    }
public void setTrayectoria(String trayectoria) {
	this.trayectoria = trayectoria;
}
public String getEstatussolicitud () {
    return estatussolicitud;
    }
public void setEstatussolicitud(String estatussolicitud) {
	this.estatussolicitud = estatussolicitud;
}
}
