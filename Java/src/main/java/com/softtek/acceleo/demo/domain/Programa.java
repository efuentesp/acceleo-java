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
@Table(name = "programa")
public class Programa implements Serializable {

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
	@Column(name = "programaId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  programaId;		

	@NotNull
	@NotNull
	@Column(name = "clave")
	private Integer clave;
	
	@NotNull
	@Column(name = "nombreprograma")
	@Size(min = 100, max = 200) 
	private String nombreprograma;
	
	@NotNull
	private String tipoestatus;

	public UUID getProgramaId() {
		return programaId;
	}

	public void setProgramaId(UUID programaId) {
		this.programaId = programaId;
	}
	
	public Integer getClave () {
	    return clave;
	    }
	public void setClave(Integer clave) {
		this.clave = clave;
	}	
	public String getNombreprograma () {
	    return nombreprograma;
	    }
	public void setNombreprograma(String nombreprograma) {
		this.nombreprograma = nombreprograma;
	}	
	public String getTipoestatus () {
	    return tipoestatus;
	    }
	public void setTipoestatus(String tipoestatus) {
		this.tipoestatus = tipoestatus;
	}
}		
