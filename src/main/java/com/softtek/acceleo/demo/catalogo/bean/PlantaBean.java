/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Planta.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class PlantaBean {
/**
 * Clase PlantaBean.
 * @author PSG.
 *
 */
	private Integer plantaId;

	private String direccion;
	private String nombreplanta;
	private Double maximo;
	private Integer diadepago;
	private Double minimo;
	private Integer empresaId;

	public Integer getPlantaId() {
		return plantaId;
	}
	public void setPlantaId(Integer plantaId) {
		this.plantaId = plantaId;
	}
	public String getDireccion () {
	    return direccion;  		
    }
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombreplanta () {
	    return nombreplanta;  		
    }
	public void setNombreplanta(String nombreplanta) {
		this.nombreplanta = nombreplanta;
	}
	public Double getMaximo () {
	    return maximo;  		
    }
	public void setMaximo(Double maximo) {
		this.maximo = maximo;
	}
	public Integer getDiadepago () {
	    return diadepago;  		
    }
	public void setDiadepago(Integer diadepago) {
		this.diadepago = diadepago;
	}
	public Double getMinimo () {
	    return minimo;  		
    }
	public void setMinimo(Double minimo) {
		this.minimo = minimo;
	}

	public Integer getEmpresaId () {
	    return empresaId;  		
    }
	public void setEmpresaId (Integer empresaId) {
		this.empresaId = empresaId;
	}


}
