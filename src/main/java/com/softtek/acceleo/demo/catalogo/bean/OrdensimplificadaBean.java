/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Ordensimplificada.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class OrdensimplificadaBean {
/**
 * Clase OrdensimplificadaBean.
 * @author PSG.
 *
 */
	private Integer ordensimplificadaId;

	private Integer sap;
	private Integer cantidadprogramada;
	private Integer ordentrabajo;
	private Date fechafinal;
	private Integer cantidadproducida;
	private Date fechainicial;
	private Linea lineaId;
	private enum Linea { c,d,e,g,a,b,f}
	private Destino destinomercanciaId;
	private enum Destino { xx,d1,d2}
	private Estadoorden estadoId;
	private enum Estadoorden { e1,e3,e2,xx,e4}
	private Estadoorden estado2Id;
	private Integer operadorproduccionId;
	private Integer clienteId;
	private String comentario;

	public Integer getOrdensimplificadaId() {
		return ordensimplificadaId;
	}
	public void setOrdensimplificadaId(Integer ordensimplificadaId) {
		this.ordensimplificadaId = ordensimplificadaId;
	}
	public Integer getSap () {
	    return sap;  		
    }
	public void setSap(Integer sap) {
		this.sap = sap;
	}
	public Integer getCantidadprogramada () {
	    return cantidadprogramada;  		
    }
	public void setCantidadprogramada(Integer cantidadprogramada) {
		this.cantidadprogramada = cantidadprogramada;
	}
	public Integer getOrdentrabajo () {
	    return ordentrabajo;  		
    }
	public void setOrdentrabajo(Integer ordentrabajo) {
		this.ordentrabajo = ordentrabajo;
	}
	public Date getFechafinal () {
	    return fechafinal;  		
    }
	public void setFechafinal(Date fechafinal) {
		this.fechafinal = fechafinal;
	}
	public Integer getCantidadproducida () {
	    return cantidadproducida;  		
    }
	public void setCantidadproducida(Integer cantidadproducida) {
		this.cantidadproducida = cantidadproducida;
	}
	public Date getFechainicial () {
	    return fechainicial;  		
    }
	public void setFechainicial(Date fechainicial) {
		this.fechainicial = fechainicial;
	}

	public Linea getLineaId () {
	    return lineaId;  		
    }
	public void setLineaId (Linea lineaId) {
		this.lineaId = lineaId;
	}
	public Destino getDestinomercanciaId () {
	    return destinomercanciaId;  		
    }
	public void setDestinomercanciaId (Destino destinomercanciaId) {
		this.destinomercanciaId = destinomercanciaId;
	}
	public Estadoorden getEstadoId () {
	    return estadoId;  		
    }
	public void setEstadoId (Estadoorden estadoId) {
		this.estadoId = estadoId;
	}
	public Estadoorden getEstado2Id () {
	    return estado2Id;  		
    }
	public void setEstado2Id (Estadoorden estado2Id) {
		this.estado2Id = estado2Id;
	}
	public Integer getOperadorproduccionId () {
	    return operadorproduccionId;  		
    }
	public void setOperadorproduccionId (Integer operadorproduccionId) {
		this.operadorproduccionId = operadorproduccionId;
	}

	public Integer getClienteId () {
	    return clienteId;  		
    }
	public void setClienteId (Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getComentario () {
	    return comentario;  		
    }
	public void setComentario (String comentario) {
		this.comentario = comentario;
	}

}
