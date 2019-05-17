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
@Table(name = "opcion")
public class Opcion implements Serializable {

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
	@Column(name = "opcionId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  opcionId;		

	@NotNull
	private UUID paraId;
	@NotNull
	@Column(name = "descipcionopcion")
	private String descipcionopcion;
	
	@NotNull
	@Column(name = "puntos")
	private Integer puntos;
	

	public UUID getOpcionId() {
		return opcionId;
	}

	public void setOpcionId(UUID opcionId) {
		this.opcionId = opcionId;
	}
	
	public UUID getParaId () {
	    return paraId;
	    }
	public void setPara(UUID paraId) {
		this.paraId = paraId;
	}
	public String getDescipcionopcion () {
	    return descipcionopcion;
	    }
	public void setDescipcionopcion(String descipcionopcion) {
		this.descipcionopcion = descipcionopcion;
	}
	public Integer getPuntos () {
	    return puntos;
	    }
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}	
}		
