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
@Table(name = "tercero")
public class Tercero implements Serializable {

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
	@Column(name = "terceroId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  terceroId;		

	@NotNull
	private UUID fideicomisoId;
	@NotNull
	@Column(name = "notercero")
	private Integer notercero;
	
	@NotNull
	@Column(name = "razonsocial")
	private String razonsocial;
	
	@NotNull
	@Column(name = "nacionalidad")
	private String nacionalidad;
	
	@NotNull
	@Column(name = "actividadeconomica")
	private String actividadeconomica;
	
	@NotNull
	@Column(name = "ladacasa")
	private String ladacasa;
	
	@NotNull
	@Column(name = "ladaoficina")
	private String ladaoficina;
	
	@NotNull
	@Column(name = "ladafax")
	private String ladafax;
	
	@NotNull
	@Column(name = "telefonocasa")
	private String telefonocasa;
	
	@NotNull
	@Column(name = "telefonooficina")
	private String telefonooficina;
	
	@NotNull
	@Column(name = "telefonofax")
	private String telefonofax;
	
	@NotNull
	@Column(name = "extoficina")
	private String extoficina;
	
	@NotNull
	@Column(name = "extfax")
	private String extfax;
	
	@NotNull
	private String estatus;
	@NotNull
	@Column(name = "fechaverfircosoft")
	private Date fechaverfircosoft;
	

	public UUID getTerceroId() {
		return terceroId;
	}

	public void setTerceroId(UUID terceroId) {
		this.terceroId = terceroId;
	}
	
	public UUID getFideicomisoId () {
	    return fideicomisoId;
	    }
	public void setFideicomiso(UUID fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public Integer getNotercero () {
	    return notercero;
	    }
	public void setNotercero(Integer notercero) {
		this.notercero = notercero;
	}	
	public String getRazonsocial () {
	    return razonsocial;
	    }
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public String getNacionalidad () {
	    return nacionalidad;
	    }
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getActividadeconomica () {
	    return actividadeconomica;
	    }
	public void setActividadeconomica(String actividadeconomica) {
		this.actividadeconomica = actividadeconomica;
	}
	public String getLadacasa () {
	    return ladacasa;
	    }
	public void setLadacasa(String ladacasa) {
		this.ladacasa = ladacasa;
	}
	public String getLadaoficina () {
	    return ladaoficina;
	    }
	public void setLadaoficina(String ladaoficina) {
		this.ladaoficina = ladaoficina;
	}
	public String getLadafax () {
	    return ladafax;
	    }
	public void setLadafax(String ladafax) {
		this.ladafax = ladafax;
	}
	public String getTelefonocasa () {
	    return telefonocasa;
	    }
	public void setTelefonocasa(String telefonocasa) {
		this.telefonocasa = telefonocasa;
	}
	public String getTelefonooficina () {
	    return telefonooficina;
	    }
	public void setTelefonooficina(String telefonooficina) {
		this.telefonooficina = telefonooficina;
	}
	public String getTelefonofax () {
	    return telefonofax;
	    }
	public void setTelefonofax(String telefonofax) {
		this.telefonofax = telefonofax;
	}
	public String getExtoficina () {
	    return extoficina;
	    }
	public void setExtoficina(String extoficina) {
		this.extoficina = extoficina;
	}
	public String getExtfax () {
	    return extfax;
	    }
	public void setExtfax(String extfax) {
		this.extfax = extfax;
	}
	public String getEstatus () {
	    return estatus;
	    }
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Date getFechaverfircosoft () {
	    return fechaverfircosoft;
	    }
	public void setFechaverfircosoft(Date fechaverfircosoft) {
		this.fechaverfircosoft = fechaverfircosoft;
	}
}		
