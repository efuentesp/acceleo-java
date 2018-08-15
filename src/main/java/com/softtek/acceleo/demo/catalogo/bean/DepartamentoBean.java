/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Departamento.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class DepartamentoBean {
/**
 * Clase DepartamentoBean.
 * @author PSG.
 *
 */
	private Integer departamentoId;

	private String representante;
	private String nombredepto;
	private Integer empresaId;

	public Integer getDepartamentoId() {
		return departamentoId;
	}
	public void setDepartamentoId(Integer departamentoId) {
		this.departamentoId = departamentoId;
	}
	public String getRepresentante () {
	    return representante;  		
    }
	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	public String getNombredepto () {
	    return nombredepto;  		
    }
	public void setNombredepto(String nombredepto) {
		this.nombredepto = nombredepto;
	}

	public Integer getEmpresaId () {
	    return empresaId;  		
    }
	public void setEmpresaId (Integer empresaId) {
		this.empresaId = empresaId;
	}


}
