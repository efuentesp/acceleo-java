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
@Table(name = "domicilio")
public class Domicilio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "domicilioId")
	private Integer  domicilioId;


	@NotNull
	@Column(name = "ciudad") 
	private String ciudad;
	@NotNull
	@Column(name = "cp") 
	private String cp;
	@NotNull
	@Column(name = "estado") 
	private String estado;
	@NotNull
	@Column(name = "calle") 
	private String calle;


	@NotNull
	@Column(name = "socioId") 
	private Integer socioId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="socioId")
//	@IndexColumn(name="idx")
//	private List<SocioId> socioList;

	public Integer getDomicilioId() {
		return domicilioId;
	}

	public void setDomicilioId(Integer domicilioId) {
		this.domicilioId = domicilioId;
	}

	
	public String getCiudad () {
	    return ciudad;  		
    }
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getCp () {
	    return cp;  		
    }
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	public String getEstado () {
	    return estado;  		
    }
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCalle () {
	    return calle;  		
    }
	public void setCalle(String calle) {
		this.calle = calle;
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

}			
