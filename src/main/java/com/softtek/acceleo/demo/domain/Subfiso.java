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
	private UUID subfisoId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@Column(name = "numero")
	@JsonProperty("numero")
	private Integer numero;
	@NotNull
	@Column(name = "nombre")
	@JsonProperty("nombre")
	private String nombre;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;
	@NotNull
	@Column(name = "fecharegistro")
	@JsonProperty("fecharegistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecharegistro;
	@Column(name = "identificador")
	@JsonProperty("identificador")
	private String identificador;

	public UUID getSubfisoId() {
		return subfisoId;
	}

	public void setSubfisoId(UUID subfisoId) {
		this.subfisoId = subfisoId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public Integer getNumero(){
	    return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNombre() {
	    return nombre;
	}
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Date getFecharegistro() {
	    return fecharegistro;
	}
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public String getIdentificador() {
	    return identificador;
	}
	public void setIdentificador(String identificador) {
	this.identificador = identificador;
	}

	// Se crea la entidad hija (Embebidos)			


}		
