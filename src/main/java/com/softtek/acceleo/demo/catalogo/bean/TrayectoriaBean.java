package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;
import java.util.UUID;

public class TrayectoriaBean {

/**
 * Clase TrayectoriaBean.
 * @author PSG.
 *
 */
 
private UUID trayectoriaId; 
private String trayectoria;
private String descripcion;
private String clave;
private UUID documentoId;

	public UUID getTrayectoriaId () {
	    return trayectoriaId;  		
    }
	public void setTrayectoriaId (UUID trayectoriaId) {
		this.trayectoriaId = trayectoriaId;
	}

public String getTrayectoria () {
    return trayectoria;
    }
public void setTrayectoria(String trayectoria) {
	this.trayectoria = trayectoria;
}
public String getDescripcion () {
    return descripcion;
    }
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getClave () {
    return clave;
    }
public void setClave(String clave) {
	this.clave = clave;
}
public UUID getDocumentoId () {
    return documentoId;
    }
public void setDocumento(UUID documentoId) {
	this.documentoId = documentoId;
}
}
