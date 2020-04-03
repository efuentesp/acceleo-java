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
@Table(name = "declaracionsat")
public class Declaracionsat implements Serializable {

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
	@Column(name = "declaracionsatId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID declaracionsatId;

	@NotNull
	@Column(name = "inicioejerciciofiscal")
	@JsonProperty("inicioejerciciofiscal")
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicioejerciciofiscal;
	@NotNull
	@JsonProperty("tipodeclaracion")
	private String tipodeclaracion;
	@NotNull
	@Column(name = "finejerciciofiscal")
	@JsonProperty("finejerciciofiscal")
	@Temporal(TemporalType.TIMESTAMP)
	private Date finejerciciofiscal;
	@NotNull
	@Column(name = "declaracionanteriorfechadeclaracionanterior")
	@JsonProperty("declaracionanterior_fechadeclaracionanterior")
	@Temporal(TemporalType.TIMESTAMP)
	private Date declaracionanteriorfechadeclaracionanterior;
	@NotNull
	@Column(name = "declaracionanteriorfoliodeclaracionanterior")
	@JsonProperty("declaracionanterior_foliodeclaracionanterior")
	private String declaracionanteriorfoliodeclaracionanterior;
	@NotNull
	@Column(name = "declaracionanteriormensajesproceso")
	@JsonProperty("declaracionanterior_mensajesproceso")
	private String declaracionanteriormensajesproceso;
	@NotNull
	@Column(name = "declaracionanteriorarchivo")
	@JsonProperty("declaracionanterior_archivo")
	private String declaracionanteriorarchivo;

	public UUID getDeclaracionsatId() {
		return declaracionsatId;
	}

	public void setDeclaracionsatId(UUID declaracionsatId) {
		this.declaracionsatId = declaracionsatId;
	}
	
	public Date getInicioejerciciofiscal() {
	    return inicioejerciciofiscal;
	}
	public void setInicioejerciciofiscal(Date inicioejerciciofiscal) {
		this.inicioejerciciofiscal = inicioejerciciofiscal;
	}
	public String getTipodeclaracion(){
	    return tipodeclaracion;
	}
	public void setTipodeclaracion(String tipodeclaracion) {
		this.tipodeclaracion = tipodeclaracion;
	}
	public Date getFinejerciciofiscal() {
	    return finejerciciofiscal;
	}
	public void setFinejerciciofiscal(Date finejerciciofiscal) {
		this.finejerciciofiscal = finejerciciofiscal;
	}
	public Date getDeclaracionanteriorfechadeclaracionanterior() {
	    return declaracionanteriorfechadeclaracionanterior;
	}
	public void setDeclaracionanteriorfechadeclaracionanterior(Date declaracionanteriorfechadeclaracionanterior) {
		this.declaracionanteriorfechadeclaracionanterior = declaracionanteriorfechadeclaracionanterior;
	}
	public String getDeclaracionanteriorfoliodeclaracionanterior() {
	    return declaracionanteriorfoliodeclaracionanterior;
	}
	public void setDeclaracionanteriorfoliodeclaracionanterior(String declaracionanteriorfoliodeclaracionanterior) {
	this.declaracionanteriorfoliodeclaracionanterior = declaracionanteriorfoliodeclaracionanterior;
	}
	public String getDeclaracionanteriormensajesproceso() {
	    return declaracionanteriormensajesproceso;
	}
	public void setDeclaracionanteriormensajesproceso(String declaracionanteriormensajesproceso) {
		this.declaracionanteriormensajesproceso = declaracionanteriormensajesproceso;
	}
	public String getDeclaracionanteriorarchivo() {
	    return declaracionanteriorarchivo;
	}
	public void setDeclaracionanteriorarchivo(String declaracionanteriorarchivo) {
		this.declaracionanteriorarchivo = declaracionanteriorarchivo;
	}

	// Se crea la entidad hija (Embebidos)			


}		
