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
@Table(name = "candidato")
public class Candidato implements Serializable {

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
	@Column(name = "candidatoId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID candidatoId;

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
	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@NotNull
	private String genero;
	@NotNull
	private String estatuscandidato;

	public UUID getCandidatoId() {
		return candidatoId;
	}

	public void setCandidatoId(UUID candidatoId) {
		this.candidatoId = candidatoId;
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
	public Date getFecha () {
	    return fecha;
	    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getGenero () {
	    return genero;
	    }
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEstatuscandidato () {
	    return estatuscandidato;
	    }
	public void setEstatuscandidato(String estatuscandidato) {
		this.estatuscandidato = estatuscandidato;
	}
}		
