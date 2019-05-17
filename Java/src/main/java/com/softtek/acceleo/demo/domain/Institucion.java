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
@Table(name = "institucion")
public class Institucion implements Serializable {

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
	@Column(name = "institucionId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  institucionId;		

	@NotNull
	@NotNull
	@Column(name = "claveinstitucion")
	private Integer claveinstitucion;
	
	@NotNull
	@Column(name = "nombreinstitucion")
	@Size(min = 10, max = 50)
	private String nombreinstitucion;
	
	@Column(name = "representante")
	@Size(min = 150, max = 200) 
	private String representante;
	
	@Column(name = "paginaweb")
	@Size(min = 150, max = 200) 
	private String paginaweb;
	
	@Column(name = "telefono")
	@Size(min = 10, max = 20)
	private String telefono;
	
	@NotNull
	private String tipoestatus;

	public UUID getInstitucionId() {
		return institucionId;
	}

	public void setInstitucionId(UUID institucionId) {
		this.institucionId = institucionId;
	}
	
	public Integer getClaveinstitucion () {
	    return claveinstitucion;
	    }
	public void setClaveinstitucion(Integer claveinstitucion) {
		this.claveinstitucion = claveinstitucion;
	}	
	public String getNombreinstitucion () {
	    return nombreinstitucion;
	    }
	public void setNombreinstitucion(String nombreinstitucion) {
		this.nombreinstitucion = nombreinstitucion;
	}
	public String getRepresentante () {
	    return representante;
	    }
	public void setRepresentante(String representante) {
		this.representante = representante;
	}	
	public String getPaginaweb () {
	    return paginaweb;
	    }
	public void setPaginaweb(String paginaweb) {
		this.paginaweb = paginaweb;
	}	
	public String getTelefono () {
	    return telefono;
	    }
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipoestatus () {
	    return tipoestatus;
	    }
	public void setTipoestatus(String tipoestatus) {
		this.tipoestatus = tipoestatus;
	}
}		
