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
@Table(name = "socio")
public class Socio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "socioId")
	private Integer  socioId;


	@NotNull
	@Column(name = "apellidopaterno") 
	private String apellidopaterno;
	@NotNull
	@Column(name = "numero") 
	private Integer numero;
	@NotNull
	@Column(name = "nombre") 
	private String nombre;
	@NotNull
	@Column(name = "apellidomaterno") 
	private String apellidomaterno;


	@NotNull
	@Column(name = "generoId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Genero generoId;
	@NotNull
	@Column(name = "tipoempleadoId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipoempleado tipoempleadoId;
	@NotNull
	@Column(name = "departamentoId") 
	private Integer departamentoId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="departamentoId")
//	@IndexColumn(name="idx")
//	private List<DepartamentoId> departamentoList;
	@NotNull
	@Column(name = "plantaId") 
	private Integer plantaId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="plantaId")
//	@IndexColumn(name="idx")
//	private List<PlantaId> plantaList;
	@Column(name = "correo") 
	private String correo;
	@Column(name = "telefono") 
	private String telefono;

	public Integer getSocioId() {
		return socioId;
	}

	public void setSocioId(Integer socioId) {
		this.socioId = socioId;
	}

	
	public String getApellidopaterno () {
	    return apellidopaterno;  		
    }
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	
	public Integer getNumero () {
	    return numero;  		
    }
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidomaterno () {
	    return apellidomaterno;  		
    }
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public Genero getGeneroId () {
	    return generoId;  		
    }
	public void setGeneroId (Genero generoId) {
		this.generoId = generoId;
	}
	public Tipoempleado getTipoempleadoId () {
	    return tipoempleadoId;  		
    }
	public void setTipoempleadoId (Tipoempleado tipoempleadoId) {
		this.tipoempleadoId = tipoempleadoId;
	}
	//public List<Departamento> getDepartamentoList () {
	//    return departamentoList;  		
    //}
	//public void setDepartamentoList (List<Departamento> departamentoList) {
	//	this.departamentoList = departamentoList;
	//}
	public Integer getDepartamentoId () {
	    return departamentoId;  		
    }
	public void setDepartamentoId (Integer departamentoId) {
		this.departamentoId = departamentoId;
	}
	//public List<Planta> getPlantaList () {
	//    return plantaList;  		
    //}
	//public void setPlantaList (List<Planta> plantaList) {
	//	this.plantaList = plantaList;
	//}
	public Integer getPlantaId () {
	    return plantaId;  		
    }
	public void setPlantaId (Integer plantaId) {
		this.plantaId = plantaId;
	}
	public String  getCorreo () {
	    return correo;  		
    }
	public void setCorreo (String correo) {
		this.correo = correo;
	}
	public String  getTelefono () {
	    return telefono;  		
    }
	public void setTelefono (String telefono) {
		this.telefono = telefono;
	}

}			
