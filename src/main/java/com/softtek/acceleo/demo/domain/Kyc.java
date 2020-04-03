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
@Table(name = "kyc")
public class Kyc implements Serializable {

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
	@Column(name = "kycId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID kycId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@Column(name = "nombre")
	@JsonProperty("nombre")
	private String nombre;
	@Column(name = "numregistro")
	@JsonProperty("numregistro")
	private String numregistro;
	@Column(name = "oficina")
	@JsonProperty("oficina")
	private String oficina;
	@NotNull
	@JsonProperty("conceptoimpresion")
	private String conceptoimpresion;
	@Column(name = "crbanca")
	@JsonProperty("crbanca")
	private String crbanca;
	@Column(name = "folio")
	@JsonProperty("folio")
	private String folio;

	public UUID getKycId() {
		return kycId;
	}

	public void setKycId(UUID kycId) {
		this.kycId = kycId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getNombre() {
	    return nombre;
	}
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	public String getNumregistro() {
	    return numregistro;
	}
	public void setNumregistro(String numregistro) {
	this.numregistro = numregistro;
	}
	public String getOficina() {
	    return oficina;
	}
	public void setOficina(String oficina) {
	this.oficina = oficina;
	}
	public String getConceptoimpresion(){
	    return conceptoimpresion;
	}
	public void setConceptoimpresion(String conceptoimpresion) {
		this.conceptoimpresion = conceptoimpresion;
	}
	public String getCrbanca() {
	    return crbanca;
	}
	public void setCrbanca(String crbanca) {
	this.crbanca = crbanca;
	}
	public String getFolio() {
	    return folio;
	}
	public void setFolio(String folio) {
	this.folio = folio;
	}

	// Se crea la entidad hija (Embebidos)			


}		
