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
@Table(name = "fideicomisospendientesliberar")
public class Fideicomisospendientesliberar implements Serializable {

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
	@Column(name = "fideicomisospendientesliberarId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID fideicomisospendientesliberarId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@Column(name = "nombrefiso")
	@JsonProperty("nombrefiso")
	private String nombrefiso;
	@NotNull
	@JsonProperty("tiponegocio")
	private String tiponegocio;
	@NotNull
	@JsonProperty("clasifproducto")
	private String clasifproducto;
	@NotNull
	@JsonProperty("manejo")
	private String manejo;
	@NotNull
	@JsonProperty("tipopersona")
	private String tipopersona;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;

	public UUID getFideicomisospendientesliberarId() {
		return fideicomisospendientesliberarId;
	}

	public void setFideicomisospendientesliberarId(UUID fideicomisospendientesliberarId) {
		this.fideicomisospendientesliberarId = fideicomisospendientesliberarId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getNombrefiso() {
	    return nombrefiso;
	}
	public void setNombrefiso(String nombrefiso) {
	this.nombrefiso = nombrefiso;
	}
	public String getTiponegocio(){
	    return tiponegocio;
	}
	public void setTiponegocio(String tiponegocio) {
		this.tiponegocio = tiponegocio;
	}
	public String getClasifproducto(){
	    return clasifproducto;
	}
	public void setClasifproducto(String clasifproducto) {
		this.clasifproducto = clasifproducto;
	}
	public String getManejo(){
	    return manejo;
	}
	public void setManejo(String manejo) {
		this.manejo = manejo;
	}
	public String getTipopersona(){
	    return tipopersona;
	}
	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	// Se crea la entidad hija (Embebidos)			


}		
