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
@Table(name = "direccion")
public class Direccion implements Serializable {

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
	@Column(name = "direccionId", columnDefinition = "VARBINARY(50)")
	private UUID direccionId;

	@NotNull
	@Column(name = "calle")
	private String calle;
	
	@NotNull
	@Column(name = "cp")
	private String cp;
	
	@NotNull
	@Column(name = "ciudad")
	private String ciudad;
	
	@NotNull
	@Column(name = "estado")
	private String estado;
	

	public UUID getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(UUID direccionId) {
		this.direccionId = direccionId;
	}
	
	public String getCalle () {
	    return calle;
	    }
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCp () {
	    return cp;
	    }
	public void setCp(String cp) {
		this.cp = cp;
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
}		
