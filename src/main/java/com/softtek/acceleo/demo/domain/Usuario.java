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
@Table(name = "usuario")
public class Usuario implements Serializable {

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
	@Column(name = "usuarioId", columnDefinition = "VARBINARY(50)")
	private UUID usuarioId;

	@NotNull
	@Column(name = "nombreclave")
	private String nombreclave;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "activo")
	private Integer activo;
	
	@NotNull
	private UUID rolId;

	public UUID getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(UUID usuarioId) {
		this.usuarioId = usuarioId;
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
	public Integer getActivo () {
	    return activo;
	    }
	public void setActivo(Integer activo) {
		this.activo = activo;
	}	
	public UUID getRolId () {
	    return rolId;
	    }
	public void setRolId(UUID rolId) {
		this.rolId = rolId;
	}
}		
