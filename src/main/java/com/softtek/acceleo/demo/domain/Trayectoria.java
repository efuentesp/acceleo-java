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
@Table(name = "trayectoria")
public class Trayectoria implements Serializable {

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
	@Column(name = "trayectoriaId", columnDefinition = "VARBINARY(50)")
	private UUID trayectoriaId;

	@NotNull
	private String trayectoria;
	@NotNull
	@Column(name = "descripcion")
	private String descripcion;
	
	@NotNull
	@Column(name = "clave")
	private String clave;
	
	private UUID documentoId;

	public UUID getTrayectoriaId() {
		return trayectoriaId;
	}

	public void setTrayectoriaId(UUID trayectoriaId) {
		this.trayectoriaId = trayectoriaId;
	}
	
	public String getTrayectoria () {
	    return trayectoria;
	    }
	public void setTrayectoria(String trayectoria) {
		this.trayectoria = trayectoria;
	}
	public String getDescripcion () {
	    return descripcion;
	    }
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getClave () {
	    return clave;
	    }
	public void setClave(String clave) {
		this.clave = clave;
	}
	public UUID getDocumentoId () {
	    return documentoId;
	    }
	public void setDocumentoId(UUID documentoId) {
		this.documentoId = documentoId;
	}
}		
