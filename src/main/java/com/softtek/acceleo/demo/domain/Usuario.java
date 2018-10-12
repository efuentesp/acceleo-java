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
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usuarioId")
	private Integer  usuarioId;


	@NotNull
	@Column(name = "activo") 
	private Integer activo;
	@NotNull
	@Column(name = "nombreclave") 
	private String nombreclave;
	@NotNull
	@Column(name = "password") 
	private String password;


	@NotNull
	@Column(name = "rolId") 
	private Integer rolId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="rolId")
//	@IndexColumn(name="idx")
//	private List<RolId> rolList;

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	
	public Integer getActivo () {
	    return activo;  		
    }
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	public String getNombreclave () {
	    return nombreclave;  		
    }
	public void setNombreclave(String nombreclave) {
		this.nombreclave = nombreclave;
	}
	
	public String getPassword () {
	    return password;  		
    }
	public void setPassword(String password) {
		this.password = password;
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
