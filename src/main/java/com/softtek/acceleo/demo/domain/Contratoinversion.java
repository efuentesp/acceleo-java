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
@Table(name = "contratoinversion")
public class Contratoinversion implements Serializable {

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
	@Column(name = "contratoinversionId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  contratoinversionId;		

	@NotNull
	private UUID fideicomisoId;
	@NotNull
	private String tipocontrato;
	@NotNull
	private String intermediario;
	@NotNull
	private String moneda;
	@NotNull
	@Column(name = "nombrecontacto1")
	private String nombrecontacto1;
	
	@NotNull
	@Column(name = "nombrecontacto2")
	private String nombrecontacto2;
	
	@NotNull
	@Column(name = "resparamliq")
	private String resparamliq;
	
	@NotNull
	@Column(name = "enviorecursosinv")
	private String enviorecursosinv;
	
	@NotNull
	@Column(name = "recrecdesinver")
	private String recrecdesinver;
	
	@NotNull
	@Column(name = "noretenerisr")
	private String noretenerisr;
	
	@NotNull
	private UUID subfisoId;
	@NotNull
	@Column(name = "fechavencimiento")
	private Date fechavencimiento;
	
	@NotNull
	private String estatus;
	@NotNull
	@Column(name = "contratoiversion")
	private String contratoiversion;
	
	@NotNull
	@Column(name = "contratootrasinst")
	private String contratootrasinst;
	
	@NotNull
	@Column(name = "contratoinv")
	private String contratoinv;
	
	@NotNull
	@Column(name = "contacto1lada")
	private String contacto1lada;
	
	@NotNull
	@Column(name = "contacto1telefono")
	private String contacto1telefono;
	
	@NotNull
	@Column(name = "contacto1ext")
	private String contacto1ext;
	
	@NotNull
	@Column(name = "contacto2lada")
	private String contacto2lada;
	
	@NotNull
	@Column(name = "contacto2telefono")
	private String contacto2telefono;
	
	@NotNull
	@Column(name = "contacto2ext")
	private String contacto2ext;
	
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "cuenta")
	private String cuenta;
	
	@NotNull
	@Column(name = "traspasoentresubfiso")
	private String traspasoentresubfiso;
	
	@NotNull
	@Column(name = "fechaapertura")
	private Date fechaapertura;
	
	@NotNull
	private String origenrecursos;

	public UUID getContratoinversionId() {
		return contratoinversionId;
	}

	public void setContratoinversionId(UUID contratoinversionId) {
		this.contratoinversionId = contratoinversionId;
	}
	
	public UUID getFideicomisoId () {
	    return fideicomisoId;
	    }
	public void setFideicomiso(UUID fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getTipocontrato () {
	    return tipocontrato;
	    }
	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}
	public String getIntermediario () {
	    return intermediario;
	    }
	public void setIntermediario(String intermediario) {
		this.intermediario = intermediario;
	}
	public String getMoneda () {
	    return moneda;
	    }
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getNombrecontacto1 () {
	    return nombrecontacto1;
	    }
	public void setNombrecontacto1(String nombrecontacto1) {
		this.nombrecontacto1 = nombrecontacto1;
	}
	public String getNombrecontacto2 () {
	    return nombrecontacto2;
	    }
	public void setNombrecontacto2(String nombrecontacto2) {
		this.nombrecontacto2 = nombrecontacto2;
	}
	public String getResparamliq () {
	    return resparamliq;
	    }
	public void setResparamliq(String resparamliq) {
		this.resparamliq = resparamliq;
	}
	public String getEnviorecursosinv () {
	    return enviorecursosinv;
	    }
	public void setEnviorecursosinv(String enviorecursosinv) {
		this.enviorecursosinv = enviorecursosinv;
	}
	public String getRecrecdesinver () {
	    return recrecdesinver;
	    }
	public void setRecrecdesinver(String recrecdesinver) {
		this.recrecdesinver = recrecdesinver;
	}
	public String getNoretenerisr () {
	    return noretenerisr;
	    }
	public void setNoretenerisr(String noretenerisr) {
		this.noretenerisr = noretenerisr;
	}
	public UUID getSubfisoId () {
	    return subfisoId;
	    }
	public void setSubfiso(UUID subfisoId) {
		this.subfisoId = subfisoId;
	}
	public Date getFechavencimiento () {
	    return fechavencimiento;
	    }
	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	public String getEstatus () {
	    return estatus;
	    }
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getContratoiversion () {
	    return contratoiversion;
	    }
	public void setContratoiversion(String contratoiversion) {
		this.contratoiversion = contratoiversion;
	}
	public String getContratootrasinst () {
	    return contratootrasinst;
	    }
	public void setContratootrasinst(String contratootrasinst) {
		this.contratootrasinst = contratootrasinst;
	}
	public String getContratoinv () {
	    return contratoinv;
	    }
	public void setContratoinv(String contratoinv) {
		this.contratoinv = contratoinv;
	}
	public String getContacto1lada () {
	    return contacto1lada;
	    }
	public void setContacto1lada(String contacto1lada) {
		this.contacto1lada = contacto1lada;
	}
	public String getContacto1telefono () {
	    return contacto1telefono;
	    }
	public void setContacto1telefono(String contacto1telefono) {
		this.contacto1telefono = contacto1telefono;
	}
	public String getContacto1ext () {
	    return contacto1ext;
	    }
	public void setContacto1ext(String contacto1ext) {
		this.contacto1ext = contacto1ext;
	}
	public String getContacto2lada () {
	    return contacto2lada;
	    }
	public void setContacto2lada(String contacto2lada) {
		this.contacto2lada = contacto2lada;
	}
	public String getContacto2telefono () {
	    return contacto2telefono;
	    }
	public void setContacto2telefono(String contacto2telefono) {
		this.contacto2telefono = contacto2telefono;
	}
	public String getContacto2ext () {
	    return contacto2ext;
	    }
	public void setContacto2ext(String contacto2ext) {
		this.contacto2ext = contacto2ext;
	}
	public String getNombre () {
	    return nombre;
	    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCuenta () {
	    return cuenta;
	    }
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getTraspasoentresubfiso () {
	    return traspasoentresubfiso;
	    }
	public void setTraspasoentresubfiso(String traspasoentresubfiso) {
		this.traspasoentresubfiso = traspasoentresubfiso;
	}
	public Date getFechaapertura () {
	    return fechaapertura;
	    }
	public void setFechaapertura(Date fechaapertura) {
		this.fechaapertura = fechaapertura;
	}
	public String getOrigenrecursos () {
	    return origenrecursos;
	    }
	public void setOrigenrecursos(String origenrecursos) {
		this.origenrecursos = origenrecursos;
	}
}		
