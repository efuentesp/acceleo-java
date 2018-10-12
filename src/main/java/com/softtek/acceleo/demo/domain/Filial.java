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
@Table(name = "filial")
public class Filial implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "filialId")
	private Integer  filialId;


	@NotNull
	@Column(name = "sitio") 
	private String sitio;
	@NotNull
	@Column(name = "telefono") 
	private String telefono;
	@NotNull
	@Column(name = "nombre") 
	private String nombre;
	@NotNull
	@Column(name = "ciudad") 
	private String ciudad;
	@NotNull
	@Column(name = "estado") 
	private String estado;
	@NotNull
	@Column(name = "ubicacion") 
	private String ubicacion;
	@NotNull
	@Column(name = "contacto") 
	private String contacto;


	@Column(name = "notas") 
	private String notas;

	public Integer getFilialId() {
		return filialId;
	}

	public void setFilialId(Integer filialId) {
		this.filialId = filialId;
	}

	
	public String getSitio () {
	    return sitio;  		
    }
	public void setSitio(String sitio) {
		this.sitio = sitio;
	}
	
	public String getTelefono () {
	    return telefono;  		
    }
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCiudad () {
	    return ciudad;  		
    }
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getEstado () {
	    return estado;  		
    }
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getUbicacion () {
	    return ubicacion;  		
    }
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public String getContacto () {
	    return contacto;  		
    }
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String  getNotas () {
	    return notas;  		
    }
	public void setNotas (String notas) {
		this.notas = notas;
	}

}			
