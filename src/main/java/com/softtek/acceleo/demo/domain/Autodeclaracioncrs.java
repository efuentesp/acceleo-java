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
@Table(name = "autodeclaracioncrs")
public class Autodeclaracioncrs implements Serializable {

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
	@Column(name = "autodeclaracioncrsId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID autodeclaracioncrsId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@Column(name = "numero")
	@JsonProperty("numero")
	private String numero;
	@NotNull
	@Column(name = "nombre")
	@JsonProperty("nombre")
	private String nombre;
	@NotNull
	@JsonProperty("tipopersona")
	private String tipopersona;
	@NotNull
	@JsonProperty("tipoparticipante")
	private String tipoparticipante;
	@NotNull
	@Column(name = "formatocrs")
	@JsonProperty("formatocrs")
	private String formatocrs;

	public UUID getAutodeclaracioncrsId() {
		return autodeclaracioncrsId;
	}

	public void setAutodeclaracioncrsId(UUID autodeclaracioncrsId) {
		this.autodeclaracioncrsId = autodeclaracioncrsId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getNumero() {
	    return numero;
	}
	public void setNumero(String numero) {
	this.numero = numero;
	}
	public String getNombre() {
	    return nombre;
	}
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	public String getTipopersona(){
	    return tipopersona;
	}
	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	public String getTipoparticipante(){
	    return tipoparticipante;
	}
	public void setTipoparticipante(String tipoparticipante) {
		this.tipoparticipante = tipoparticipante;
	}
	public String getFormatocrs() {
	    return formatocrs;
	}
	public void setFormatocrs(String formatocrs) {
	this.formatocrs = formatocrs;
	}

	// Se crea la entidad hija (Embebidos)			


}		
