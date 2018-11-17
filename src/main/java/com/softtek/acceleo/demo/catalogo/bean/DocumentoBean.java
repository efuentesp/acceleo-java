package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class DocumentoBean {

/**
 * Clase DocumentoBean.
 * @author PSG.
 *
 */
 
private UUID documentoId; 
private String nombre;
private String descripcion;
private Integer size;	

	public UUID getDocumentoId () {
	    return documentoId;  		
    }
	public void setDocumentoId (UUID documentoId) {
		this.documentoId = documentoId;
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
public Integer getSize () {
    return size;
    }
public void setSize(Integer size) {
	this.size = size;
}	
}
