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
@Table(name = "certificacion")
public class Certificacion implements Serializable {

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
	@Column(name = "certificacionId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  certificacionId;		

	@NotNull
	private UUID tieneId;
	@NotNull
	private UUID sonId;
	@NotNull
	@Column(name = "idcertificacion")
	private Integer idcertificacion;
	
	@NotNull
	@Column(name = "fechacertificacion")
	private Date fechacertificacion;
	

	public UUID getCertificacionId() {
		return certificacionId;
	}

	public void setCertificacionId(UUID certificacionId) {
		this.certificacionId = certificacionId;
	}
	
	public UUID getTieneId () {
	    return tieneId;
	    }
	public void setTiene(UUID tieneId) {
		this.tieneId = tieneId;
	}
	public UUID getSonId () {
	    return sonId;
	    }
	public void setSon(UUID sonId) {
		this.sonId = sonId;
	}
	public Integer getIdcertificacion () {
	    return idcertificacion;
	    }
	public void setIdcertificacion(Integer idcertificacion) {
		this.idcertificacion = idcertificacion;
	}	
	public Date getFechacertificacion () {
	    return fechacertificacion;
	    }
	public void setFechacertificacion(Date fechacertificacion) {
		this.fechacertificacion = fechacertificacion;
	}
}		
