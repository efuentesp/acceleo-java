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
@Table(name = "honorarioscontrato")
public class Honorarioscontrato implements Serializable {

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
	@Column(name = "honorarioscontratoId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID honorarioscontratoId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
	@NotNull
	@Column(name = "nombre")
	@JsonProperty("nombre")
	private String nombre;
	@NotNull
	@Column(name = "persona")
	@JsonProperty("persona")
	private String persona;
	@NotNull
	@Column(name = "comisiones")
	@JsonProperty("comisiones")
	private String comisiones;
	@NotNull
	@Column(name = "iva")
	@JsonProperty("iva")
	private String iva;

	public UUID getHonorarioscontratoId() {
		return honorarioscontratoId;
	}

	public void setHonorarioscontratoId(UUID honorarioscontratoId) {
		this.honorarioscontratoId = honorarioscontratoId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public Subfiso getSubfisoId (){
	    return subfisoId;
	}
	public void setSubfisoId(Subfiso subfisoId) {
		this.subfisoId = subfisoId;
	}
	public String getNombre() {
	    return nombre;
	}
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	public String getPersona() {
	    return persona;
	}
	public void setPersona(String persona) {
	this.persona = persona;
	}
	public String getComisiones() {
	    return comisiones;
	}
	public void setComisiones(String comisiones) {
	this.comisiones = comisiones;
	}
	public String getIva() {
	    return iva;
	}
	public void setIva(String iva) {
	this.iva = iva;
	}

	// Se crea la entidad hija (Embebidos)			


}		
