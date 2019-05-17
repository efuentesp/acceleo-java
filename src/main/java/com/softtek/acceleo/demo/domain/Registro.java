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
@Table(name = "registro")
public class Registro implements Serializable {

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
	@Column(name = "registroId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  registroId;		

	@NotNull
	private UUID confirmadoId;
	@NotNull
	private UUID inscritoporId;
	@NotNull
	@Column(name = "numconfirmacion")
	private Integer numconfirmacion;
	

	public UUID getRegistroId() {
		return registroId;
	}

	public void setRegistroId(UUID registroId) {
		this.registroId = registroId;
	}
	
	public UUID getConfirmadoId () {
	    return confirmadoId;
	    }
	public void setConfirmado(UUID confirmadoId) {
		this.confirmadoId = confirmadoId;
	}
	public UUID getInscritoporId () {
	    return inscritoporId;
	    }
	public void setInscritopor(UUID inscritoporId) {
		this.inscritoporId = inscritoporId;
	}
	public Integer getNumconfirmacion () {
	    return numconfirmacion;
	    }
	public void setNumconfirmacion(Integer numconfirmacion) {
		this.numconfirmacion = numconfirmacion;
	}	
}		
