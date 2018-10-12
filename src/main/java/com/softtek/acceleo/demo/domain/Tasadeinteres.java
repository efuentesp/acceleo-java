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
@Table(name = "tasadeinteres")
public class Tasadeinteres implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tasadeinteresId")
	private Integer  tasadeinteresId;


	@NotNull
	@Column(name = "fechafin") 
	private Date fechafin;
	@NotNull
	@Column(name = "fechainicio") 
	private Date fechainicio;
	@NotNull
	@Column(name = "tasa") 
	private Double tasa;


	@NotNull
	@Column(name = "empresaId") 
	private Integer empresaId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="empresaId")
//	@IndexColumn(name="idx")
//	private List<EmpresaId> empresaList;

	public Integer getTasadeinteresId() {
		return tasadeinteresId;
	}

	public void setTasadeinteresId(Integer tasadeinteresId) {
		this.tasadeinteresId = tasadeinteresId;
	}

	
	public Date getFechafin () {
	    return fechafin;  		
    }
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	
	public Date getFechainicio () {
	    return fechainicio;  		
    }
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	
	public Double getTasa () {
	    return tasa;  		
    }
	public void setTasa(Double tasa) {
		this.tasa = tasa;
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
