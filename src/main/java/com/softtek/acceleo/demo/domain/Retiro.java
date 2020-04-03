package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.WhereJoinTable;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "retiro")
public class Retiro implements Serializable {

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
	@Column(name = "retiroId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID retiroId;

	@NotNull
	@Column(name = "usuario")
	@JsonProperty("usuario")
	private String usuario;
	@NotNull
	@Column(name = "fechahora")
	@JsonProperty("fechahora")
	private String fechahora;
	@NotNull
	@Column(name = "archivo")
	@JsonProperty("archivo")
	private String archivo;

	public UUID getRetiroId() {
		return retiroId;
	}

	public void setRetiroId(UUID retiroId) {
		this.retiroId = retiroId;
	}
	
	public String getUsuario() {
	    return usuario;
	}
	public void setUsuario(String usuario) {
	this.usuario = usuario;
	}
	public String getFechahora() {
	    return fechahora;
	}
	public void setFechahora(String fechahora) {
	this.fechahora = fechahora;
	}
	public String getArchivo() {
	    return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	// Se crea la entidad hija (Embebidos)			


}		
