/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Cliente.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class ClienteBean {
/**
 * Clase ClienteBean.
 * @author PSG.
 *
 */
	private Integer clienteId;

	private String nombre;
	private Integer clave;
	private Integer etiquetaasignadaId;
	private Integer ordensimplificadaId;

	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getClave () {
	    return clave;  		
    }
	public void setClave(Integer clave) {
		this.clave = clave;
	}

	public Integer getClienteId () {
	    return clienteId;  		
    }
	public void setClienteId (Integer clienteId) {
		this.clienteId = clienteId;
	}
	public Integer getEtiquetaasignadaId () {
	    return etiquetaasignadaId;  		
    }
	public void setEtiquetaasignadaId (Integer etiquetaasignadaId) {
		this.etiquetaasignadaId = etiquetaasignadaId;
	}
	public Integer getOrdensimplificadaId () {
	    return ordensimplificadaId;  		
    }
	public void setOrdensimplificadaId (Integer ordensimplificadaId) {
		this.ordensimplificadaId = ordensimplificadaId;
	}


}
