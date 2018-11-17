package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "filial")
public class Filial implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@NotNull
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			          name = "UUID", 
	                  strategy = "org.hibernate.id.UUIDGenerator", 
	                  parameters = {
	                		@Parameter( 
	                				name = "uuid_gen_strategy_class", 
	                				value = "org.hibernate.id.uuid.CustomVersionOneStrategy" 
	                		) 
					  } 
					 )
	@Column(name = "filialId", columnDefinition = "VARBINARY(50)")
	private UUID filialId;

	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "ubicacion")
	private String ubicacion;
	
	@NotNull
	@Column(name = "ciudad")
	private String ciudad;
	
	@NotNull
	@Column(name = "estado")
	private String estado;
	
	@NotNull
	@Column(name = "telefono")
	private String telefono;
	
	@NotNull
	@Column(name = "sitio")
	private String sitio;
	
	@NotNull
	@Column(name = "contacto")
	private String contacto;
	
	@Column(name = "notas")
	private String notas;
	

	public UUID getFilialId() {
		return filialId;
	}

	public void setFilialId(UUID filialId) {
		this.filialId = filialId;
	}
	
	public String getNombre () {
	    return nombre;
	    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion () {
	    return ubicacion;
	    }
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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
	public String getTelefono () {
	    return telefono;
	    }
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getSitio () {
	    return sitio;
	    }
	public void setSitio(String sitio) {
		this.sitio = sitio;
	}
	public String getContacto () {
	    return contacto;
	    }
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getNotas () {
	    return notas;
	    }
	public void setNotas(String notas) {
		this.notas = notas;
	}
}		
