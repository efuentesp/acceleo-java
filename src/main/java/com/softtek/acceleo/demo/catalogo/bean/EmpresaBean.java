/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Empresa.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class EmpresaBean {
/**
 * Clase EmpresaBean.
 * @author PSG.
 *
 */
	private Integer empresaId;

	private String clave;
	private String nombrecorto;
	private String razonsocial;

	public Integer getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}
	public String getClave () {
	    return clave;  		
    }
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombrecorto () {
	    return nombrecorto;  		
    }
	public void setNombrecorto(String nombrecorto) {
		this.nombrecorto = nombrecorto;
	}
	public String getRazonsocial () {
	    return razonsocial;  		
    }
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}



}
