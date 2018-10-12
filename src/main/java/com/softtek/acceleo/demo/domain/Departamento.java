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
@Table(name = "departamento")
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "departamentoId")
	private Integer  departamentoId;


	@NotNull
	@Column(name = "representante") 
	private String representante;
	@NotNull
	@Column(name = "nombredepto") 
	private String nombredepto;


	@NotNull
	@Column(name = "empresaId") 
	private Integer empresaId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="empresaId")
//	@IndexColumn(name="idx")
//	private List<EmpresaId> empresaList;

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
