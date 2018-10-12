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
@Table(name = "permiso")
public class Permiso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "permisoId")
	private Integer  permisoId;


	@NotNull
	@Column(name = "ruta") 
	private String ruta;
	@NotNull
	@Column(name = "funcion") 
	private String funcion;
	@NotNull
	@Column(name = "nivelpermiso") 
	private String nivelpermiso;


	@NotNull
	@Column(name = "rolId") 
	private Integer rolId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="rolId")
//	@IndexColumn(name="idx")
//	private List<RolId> rolList;

	public Integer getPermisoId() {
		return permisoId;
	}

	public void setPermisoId(Integer permisoId) {
		this.permisoId = permisoId;
	}

	
	public String getRuta () {
	    return ruta;  		
    }
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	public String getFuncion () {
	    return funcion;  		
    }
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	
	public String getNivelpermiso () {
	    return nivelpermiso;  		
    }
	public void setNivelpermiso(String nivelpermiso) {
		this.nivelpermiso = nivelpermiso;
	}
	//public List<Rol> getRolList () {
	//    return rolList;  		
    //}
	//public void setRolList (List<Rol> rolList) {
	//	this.rolList = rolList;
	//}
	public Integer getRolId () {
	    return rolId;  		
    }
	public void setRolId (Integer rolId) {
		this.rolId = rolId;
	}

}			
