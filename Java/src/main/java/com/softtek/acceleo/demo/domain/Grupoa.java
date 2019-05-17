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
@Table(name = "grupoa")
public class Grupoa implements Serializable {

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
	@Column(name = "grupoaId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  grupoaId;		

	@NotNull
	@Column(name = "nombregrupo")
	@Size(min = 20, max = 25)
	private String nombregrupo;
	
	@NotNull
	@Column(name = "descripciongrupo")
	@Size(min = 80, max = 100)
	private String descripciongrupo;
	
	@NotNull
	private String tipoestatus;

	public UUID getGrupoaId() {
		return grupoaId;
	}

	public void setGrupoaId(UUID grupoaId) {
		this.grupoaId = grupoaId;
	}
	
	public String getNombregrupo () {
	    return nombregrupo;
	    }
	public void setNombregrupo(String nombregrupo) {
		this.nombregrupo = nombregrupo;
	}
	public String getDescripciongrupo () {
	    return descripciongrupo;
	    }
	public void setDescripciongrupo(String descripciongrupo) {
		this.descripciongrupo = descripciongrupo;
	}
	public String getTipoestatus () {
	    return tipoestatus;
	    }
	public void setTipoestatus(String tipoestatus) {
		this.tipoestatus = tipoestatus;
	}
}		
