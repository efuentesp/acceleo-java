/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Documento.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class DocumentoBean {
/**
 * Clase DocumentoBean.
 * @author PSG.
 *
 */
	private Integer documentoId;

	private String nombre;
	private String descripcion;
	private Integer size;

	public Integer getDocumentoId() {
		return documentoId;
	}
	public void setDocumentoId(Integer documentoId) {
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
	public void setSize (Integer size) {
		this.size = size;
	}

}
