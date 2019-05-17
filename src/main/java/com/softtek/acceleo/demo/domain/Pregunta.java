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
@Table(name = "pregunta")
public class Pregunta implements Serializable {

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
	@Column(name = "preguntaId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  preguntaId;		

	@NotNull
	private UUID peterneceId;
	@NotNull
	@Column(name = "descipcionpregunta")
	private String descipcionpregunta;
	

	public UUID getPreguntaId() {
		return preguntaId;
	}

	public void setPreguntaId(UUID preguntaId) {
		this.preguntaId = preguntaId;
	}
	
	public UUID getPeterneceId () {
	    return peterneceId;
	    }
	public void setPeternece(UUID peterneceId) {
		this.peterneceId = peterneceId;
	}
	public String getDescipcionpregunta () {
	    return descipcionpregunta;
	    }
	public void setDescipcionpregunta(String descipcionpregunta) {
		this.descipcionpregunta = descipcionpregunta;
	}
}		
