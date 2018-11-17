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
@Table(name = "documento")
public class Documento implements Serializable {

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
	@Column(name = "documentoId", columnDefinition = "VARBINARY(50)")
	private UUID documentoId;

	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "size")
	private Integer size;
	

	public UUID getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(UUID documentoId) {
		this.documentoId = documentoId;
	}
	
	public String getNombre () {
	    return nombre;
	    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion () {
	    return descripcion;
	    }
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getSize () {
	    return size;
	    }
	public void setSize(Integer size) {
		this.size = size;
	}	
}		
