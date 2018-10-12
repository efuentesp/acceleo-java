package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "planta")
public class Planta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "plantaId")
	private Integer  plantaId;


	@NotNull
	@Column(name = "direccion") 
	private String direccion;
	@NotNull
	@Column(name = "nombreplanta") 
	private String nombreplanta;
	@NotNull
	@Column(name = "maximo") 
	private Double maximo;
	@NotNull
	@Column(name = "diadepago") 
	private Integer diadepago;
	@NotNull
	@Column(name = "minimo") 
	private Double minimo;


	@NotNull
	@Column(name = "empresaId") 
	private Integer empresaId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="empresaId")
//	@IndexColumn(name="idx")
//	private List<EmpresaId> empresaList;

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
	//public List<Empresa> getEmpresaList () {
	//    return empresaList;  		
    //}
	//public void setEmpresaList (List<Empresa> empresaList) {
	//	this.empresaList = empresaList;
	//}
	public Integer getEmpresaId () {
	    return empresaId;  		
    }
	public void setEmpresaId (Integer empresaId) {
		this.empresaId = empresaId;
	}

}			
