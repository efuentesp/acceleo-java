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
@Table(name = "unidad")
public class Unidad implements Serializable {

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
	@Column(name = "unidadId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  unidadId;		

	@NotNull
	private UUID competeId;
	@NotNull
	@Column(name = "nombreunidad")
	@Size(min = 150, max = 200) 
	private String nombreunidad;
	

	public UUID getUnidadId() {
		return unidadId;
	}

	public void setUnidadId(UUID unidadId) {
		this.unidadId = unidadId;
	}
	
	public UUID getCompeteId () {
	    return competeId;
	    }
	public void setCompete(UUID competeId) {
		this.competeId = competeId;
	}
	public String getNombreunidad () {
	    return nombreunidad;
	    }
	public void setNombreunidad(String nombreunidad) {
		this.nombreunidad = nombreunidad;
	}	
}		
