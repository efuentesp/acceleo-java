package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class PosicionBean {

/**
 * Clase PosicionBean.
 * @author PSG.
 *
 */
 
private UUID posicionId; 
private UUID filialId;
private String puestos;
private String nombre;
private String descripcion;
private Date fecha;	
private String contacto;
private Double salario;	
private Integer vacantes;	
private String tiponomina;
private UUID reclutadorId;
private String estatusposicion;

	public UUID getPosicionId () {
	    return posicionId;  		
    }
	public void setPosicionId (UUID posicionId) {
		this.posicionId = posicionId;
	}

public UUID getFilialId () {
    return filialId;
    }
public void setFilial(UUID filialId) {
	this.filialId = filialId;
}
public String getPuestos () {
    return puestos;
    }
public void setPuestos(String puestos) {
	this.puestos = puestos;
}
public String getNombre () {
    return nombre;
    }
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDescripcion () {
    return descripcion;
    }
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Date getFecha () {
    return fecha;
    }
public void setFecha(Date fecha) {
	this.fecha = fecha;
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
public String getTiponomina () {
    return tiponomina;
    }
public void setTiponomina(String tiponomina) {
	this.tiponomina = tiponomina;
}
public UUID getReclutadorId () {
    return reclutadorId;
    }
public void setReclutador(UUID reclutadorId) {
	this.reclutadorId = reclutadorId;
}
public String getEstatusposicion () {
    return estatusposicion;
    }
public void setEstatusposicion(String estatusposicion) {
	this.estatusposicion = estatusposicion;
}
}
