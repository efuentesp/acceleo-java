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
@Table(name = "permiso")
public class Permiso implements Serializable {

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
	@Column(name = "permisoId", columnDefinition = "VARBINARY(50)")
	private UUID permisoId;

	@NotNull
	private UUID rolId;
	@NotNull
	@Column(name = "funcion")
	private String funcion;
	
	@NotNull
	@Column(name = "ruta")
	private String ruta;
	
	@NotNull
	@Column(name = "nivelpermiso")
	private String nivelpermiso;
	

	public UUID getPermisoId() {
		return permisoId;
	}

	public void setPermisoId(UUID permisoId) {
		this.permisoId = permisoId;
	}
	
	public UUID getRolId () {
	    return rolId;
	    }
	public void setRolId(UUID rolId) {
		this.rolId = rolId;
	}
	public String getFuncion () {
	    return funcion;
	    }
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	public String getRuta () {
	    return ruta;
	    }
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getNivelpermiso () {
	    return nivelpermiso;
	    }
	public void setNivelpermiso(String nivelpermiso) {
		this.nivelpermiso = nivelpermiso;
	}
}		
