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
@Table(name = "recurso")
public class Recurso implements Serializable {

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
	@Column(name = "recursoId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  recursoId;		

	@NotNull
	private UUID relacionaId;
	@NotNull
	@Column(name = "descripcionrecurso")
	@Size(min = 100, max = 200) 
	private String descripcionrecurso;
	
	@NotNull
	@Column(name = "ruta")
	@Size(min = 100, max = 200) 
	private String ruta;
	
	@NotNull
	private String tiporecurso;
	@Column(name = "tamano")
	private Integer tamano;
	

	public UUID getRecursoId() {
		return recursoId;
	}

	public void setRecursoId(UUID recursoId) {
		this.recursoId = recursoId;
	}
	
	public UUID getRelacionaId () {
	    return relacionaId;
	    }
	public void setRelaciona(UUID relacionaId) {
		this.relacionaId = relacionaId;
	}
	public String getDescripcionrecurso () {
	    return descripcionrecurso;
	    }
	public void setDescripcionrecurso(String descripcionrecurso) {
		this.descripcionrecurso = descripcionrecurso;
	}	
	public String getRuta () {
	    return ruta;
	    }
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}	
	public String getTiporecurso () {
	    return tiporecurso;
	    }
	public void setTiporecurso(String tiporecurso) {
		this.tiporecurso = tiporecurso;
	}
	public Integer getTamano () {
	    return tamano;
	    }
	public void setTamano(Integer tamano) {
		this.tamano = tamano;
	}	
}		
