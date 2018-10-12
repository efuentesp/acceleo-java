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
@Table(name = "perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "perfilId")
	private Integer  perfilId;


	@NotNull
	@Column(name = "nip") 
	private String nip;
	@NotNull
	@Column(name = "usuario") 
	private String usuario;


	@NotNull
	@Column(name = "socioId") 
	private Integer socioId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="socioId")
//	@IndexColumn(name="idx")
//	private List<SocioId> socioList;

	public Integer getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}

	
	public String getNip () {
	    return nip;  		
    }
	public void setNip(String nip) {
		this.nip = nip;
	}
	
	public String getUsuario () {
	    return usuario;  		
    }
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
