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
@Table(name = "accionista")
public class Accionista implements Serializable {

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
	@Column(name = "accionistaId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID accionistaId;

	@NotNull
	@Column(name = "accionistade")
	@JsonProperty("accionistade")
	private String accionistade;
	@NotNull
	@Column(name = "nombre")
	@JsonProperty("nombre")
	private String nombre;
	@NotNull
	@Column(name = "rfc")
	@JsonProperty("rfc")
	private String rfc;
	@NotNull
	@Column(name = "porcentajeparticipacionaccionaria")
	@JsonProperty("porcentajeparticipacionaccionaria")
	private String porcentajeparticipacionaccionaria;
	@NotNull
	@JsonProperty("tipopersona")
	private String tipopersona;
	@NotNull
	@JsonProperty("nacionalidad")
	private String nacionalidad;
	@NotNull
	@JsonProperty("pep")
	private String pep;

	public UUID getAccionistaId() {
		return accionistaId;
	}

	public void setAccionistaId(UUID accionistaId) {
		this.accionistaId = accionistaId;
	}
	
	public String getAccionistade() {
	    return accionistade;
	}
	public void setAccionistade(String accionistade) {
		this.accionistade = accionistade;
	}
	public String getNombre() {
	    return nombre;
	}
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	public String getRfc() {
	    return rfc;
	}
	public void setRfc(String rfc) {
	this.rfc = rfc;
	}
	public String getPorcentajeparticipacionaccionaria() {
	    return porcentajeparticipacionaccionaria;
	}
	public void setPorcentajeparticipacionaccionaria(String porcentajeparticipacionaccionaria) {
	this.porcentajeparticipacionaccionaria = porcentajeparticipacionaccionaria;
	}
	public String getTipopersona(){
	    return tipopersona;
	}
	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	public String getNacionalidad(){
	    return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getPep(){
	    return pep;
	}
	public void setPep(String pep) {
		this.pep = pep;
	}

	// Se crea la entidad hija (Embebidos)			


}		
