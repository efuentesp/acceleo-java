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
@Table(name = "beneficiario")
public class Beneficiario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "beneficiarioId")
	private Integer  beneficiarioId;


	@NotNull
	@Column(name = "nombre") 
	private String nombre;
	@NotNull
	@Column(name = "apellidopaterno") 
	private String apellidopaterno;
	@NotNull
	@Column(name = "apellidomaterno") 
	private String apellidomaterno;
	@NotNull
	@Column(name = "fechanacimiento") 
	private Date fechanacimiento;


	@NotNull
	@Column(name = "cuentadeahorroId") 
	private Integer cuentadeahorroId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="cuentadeahorroId")
//	@IndexColumn(name="idx")
//	private List<CuentadeahorroId> cuentadeahorroList;
	@NotNull
	@Column(name = "generoId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Genero generoId;
	@NotNull
	@Column(name = "parentescoId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Parentesco parentescoId;

	public Integer getBeneficiarioId() {
		return beneficiarioId;
	}

	public void setBeneficiarioId(Integer beneficiarioId) {
		this.beneficiarioId = beneficiarioId;
	}

	
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidopaterno () {
	    return apellidopaterno;  		
    }
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	
	public String getApellidomaterno () {
	    return apellidomaterno;  		
    }
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	
	public Date getFechanacimiento () {
	    return fechanacimiento;  		
    }
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	//public List<Cuentadeahorro> getCuentadeahorroList () {
	//    return cuentadeahorroList;  		
    //}
	//public void setCuentadeahorroList (List<Cuentadeahorro> cuentadeahorroList) {
	//	this.cuentadeahorroList = cuentadeahorroList;
	//}
	public Integer getCuentadeahorroId () {
	    return cuentadeahorroId;  		
    }
	public void setCuentadeahorroId (Integer cuentadeahorroId) {
		this.cuentadeahorroId = cuentadeahorroId;
	}
	public Genero getGeneroId () {
	    return generoId;  		
    }
	public void setGeneroId (Genero generoId) {
		this.generoId = generoId;
	}
	public Parentesco getParentescoId () {
	    return parentescoId;  		
    }
	public void setParentescoId (Parentesco parentescoId) {
		this.parentescoId = parentescoId;
	}

}			
