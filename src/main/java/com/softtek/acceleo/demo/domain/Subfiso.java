package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.WhereJoinTable;

@Entity
@Table(name = "subfiso")
public class Subfiso implements Serializable {

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
	@Column(name = "subfisoId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  subfisoId;		

	@NotNull
	private UUID fideicomisoId;
	@NotNull
	@Column(name = "numero")
	private Integer numero;
	
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	private String estatus;
	@NotNull
	@Column(name = "fecharegistro")
	private Date fecharegistro;
	
	@NotNull
	@Column(name = "identificador")
	private String identificador;
	

	public UUID getSubfisoId() {
		return subfisoId;
	}

	public void setSubfisoId(UUID subfisoId) {
		this.subfisoId = subfisoId;
	}
	
	public UUID getFideicomisoId () {
	    return fideicomisoId;
	    }
	public void setFideicomiso(UUID fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public Integer getNumero () {
	    return numero;
	    }
	public void setNumero(Integer numero) {
		this.numero = numero;
	}	
	public String getNombre () {
	    return nombre;
	    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstatus () {
	    return estatus;
	    }
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Date getFecharegistro () {
	    return fecharegistro;
	    }
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public String getIdentificador () {
	    return identificador;
	    }
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
}		
