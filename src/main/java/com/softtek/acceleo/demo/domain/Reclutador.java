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
import org.hibernate.annotations.Type;


@Entity
@Table(name = "reclutador")
public class Reclutador implements Serializable {

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
	@Column(name = "reclutadorId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID reclutadorId;

	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "apellidopaterno")
	private String apellidopaterno;
	
	@NotNull
	@Column(name = "apellidomaterno")
	private String apellidomaterno;
	
	@NotNull
	private String genero;

	public UUID getReclutadorId() {
		return reclutadorId;
	}

	public void setReclutadorId(UUID reclutadorId) {
		this.reclutadorId = reclutadorId;
	}
	
	public String getNombre () {
	    return nombre;
	    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidopaterno () {
	    return apellidopaterno;
	    }
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getApellidomaterno () {
	    return apellidomaterno;
	    }
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public String getGenero () {
	    return genero;
	    }
	public void setGenero(String genero) {
		this.genero = genero;
	}
}		
