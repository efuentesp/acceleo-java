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
@Table(name = "cuentabancaria")
public class Cuentabancaria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cuentabancariaId")
	private Integer  cuentabancariaId;


	@NotNull
	@Column(name = "clabe") 
	private Integer clabe;
	@NotNull
	@Column(name = "cuenta") 
	private Integer cuenta;


	@NotNull
	@Column(name = "socioId") 
	private Integer socioId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="socioId")
//	@IndexColumn(name="idx")
//	private List<SocioId> socioList;
	@NotNull
	@Column(name = "bancoId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Banco bancoId;

	public Integer getCuentabancariaId() {
		return cuentabancariaId;
	}

	public void setCuentabancariaId(Integer cuentabancariaId) {
		this.cuentabancariaId = cuentabancariaId;
	}

	
	public Integer getClabe () {
	    return clabe;  		
    }
	public void setClabe(Integer clabe) {
		this.clabe = clabe;
	}
	
	public Integer getCuenta () {
	    return cuenta;  		
    }
	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}
	//public List<Socio> getSocioList () {
	//    return socioList;  		
    //}
	//public void setSocioList (List<Socio> socioList) {
	//	this.socioList = socioList;
	//}
	public Integer getSocioId () {
	    return socioId;  		
    }
	public void setSocioId (Integer socioId) {
		this.socioId = socioId;
	}
	public Banco getBancoId () {
	    return bancoId;  		
    }
	public void setBancoId (Banco bancoId) {
		this.bancoId = bancoId;
	}

}			
