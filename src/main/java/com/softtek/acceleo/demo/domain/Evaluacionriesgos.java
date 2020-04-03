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
@Table(name = "evaluacionriesgos")
public class Evaluacionriesgos implements Serializable {

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
	@Column(name = "evaluacionriesgosId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID evaluacionriesgosId;

	@Column(name = "campo")
	@JsonProperty("campo")
	private String campo;
	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JsonProperty("cliente")
	private String cliente;
	@NotNull
	@JsonProperty("estructura")
	private String estructura;
	@NotNull
	@JsonProperty("resultadofinal")
	private String resultadofinal;

	public UUID getEvaluacionriesgosId() {
		return evaluacionriesgosId;
	}

	public void setEvaluacionriesgosId(UUID evaluacionriesgosId) {
		this.evaluacionriesgosId = evaluacionriesgosId;
	}
	
	public String getCampo() {
	    return campo;
	}
	public void setCampo(String campo) {
	this.campo = campo;
	}
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getCliente(){
	    return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getEstructura(){
	    return estructura;
	}
	public void setEstructura(String estructura) {
		this.estructura = estructura;
	}
	public String getResultadofinal(){
	    return resultadofinal;
	}
	public void setResultadofinal(String resultadofinal) {
		this.resultadofinal = resultadofinal;
	}

	// Se crea la entidad hija (Embebidos)			


}		
