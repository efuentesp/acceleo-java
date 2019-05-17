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
@Table(name = "examen")
public class Examen implements Serializable {

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
	@Column(name = "examenId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  examenId;		

	@NotNull
	private UUID correspondeId;
	@NotNull
	@Column(name = "nombreexamen")
	private String nombreexamen;
	

	public UUID getExamenId() {
		return examenId;
	}

	public void setExamenId(UUID examenId) {
		this.examenId = examenId;
	}
	
	public UUID getCorrespondeId () {
	    return correspondeId;
	    }
	public void setCorresponde(UUID correspondeId) {
		this.correspondeId = correspondeId;
	}
	public String getNombreexamen () {
	    return nombreexamen;
	    }
	public void setNombreexamen(String nombreexamen) {
		this.nombreexamen = nombreexamen;
	}
}		
