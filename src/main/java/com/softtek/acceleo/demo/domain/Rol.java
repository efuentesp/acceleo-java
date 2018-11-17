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
@Table(name = "rol")
public class Rol implements Serializable {

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
	@Column(name = "rolId", columnDefinition = "VARBINARY(50)")
	private UUID rolId;

	@NotNull
	@Column(name = "clave")
	private Integer clave;
	
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "activo")
	private Integer activo;
	

	public UUID getRolId() {
		return rolId;
	}

	public void setRolId(UUID rolId) {
		this.rolId = rolId;
	}
	
	public Integer getClave () {
	    return clave;
	    }
	public void setClave(Integer clave) {
		this.clave = clave;
	}	
	public String getNombre () {
	    return nombre;
	    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getActivo () {
	    return activo;
	    }
	public void setActivo(Integer activo) {
		this.activo = activo;
	}	
}		
