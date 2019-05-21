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
@Table(name = "comitetecnico")
public class Comitetecnico implements Serializable {

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
	@Column(name = "comitetecnicoId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  comitetecnicoId;		

	@NotNull
	private UUID fideicomisoId;
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "integracion")
	private String integracion;
	
	@NotNull
	@Column(name = "facultades")
	private String facultades;
	
	@NotNull
	@Column(name = "comentarios")
	private String comentarios;
	
	@NotNull
	@Column(name = "fechaconstitucion")
	private String fechaconstitucion;
	
	@NotNull
	@Column(name = "miembrosquorum")
	private Date miembrosquorum;
	
	@NotNull
	private String estatus;
	@NotNull
	@Column(name = "nombrepresidentepropietario")
	private String nombrepresidentepropietario;
	
	@NotNull
	@Column(name = "rfcpresidentepropietario")
	private String rfcpresidentepropietario;
	
	@NotNull
	@Column(name = "nacionalidadpresidentepropietario")
	private String nacionalidadpresidentepropietario;
	
	@NotNull
	@Column(name = "peppresidentepropietario")
	private String peppresidentepropietario;
	
	@NotNull
	@Column(name = "nombrepresidentesuplente")
	private String nombrepresidentesuplente;
	
	@NotNull
	@Column(name = "rfcpresidentesuplente")
	private String rfcpresidentesuplente;
	
	@NotNull
	@Column(name = "nacionalidadpresidentesuplente")
	private String nacionalidadpresidentesuplente;
	
	@NotNull
	@Column(name = "peppresidentesuplente")
	private String peppresidentesuplente;
	
	@NotNull
	@Column(name = "nombresecretariopropietario")
	private String nombresecretariopropietario;
	
	@NotNull
	@Column(name = "rfcsecretariopropietario")
	private String rfcsecretariopropietario;
	
	@NotNull
	@Column(name = "nacionalidadsecretariopropietario")
	private String nacionalidadsecretariopropietario;
	
	@NotNull
	@Column(name = "pepsecretariopropietario")
	private String pepsecretariopropietario;
	
	@NotNull
	@Column(name = "nombresecretariosuplente")
	private String nombresecretariosuplente;
	
	@NotNull
	@Column(name = "rfcsecretariosuplente")
	private String rfcsecretariosuplente;
	
	@NotNull
	@Column(name = "nacionalidadsecretariosuplente")
	private String nacionalidadsecretariosuplente;
	
	@NotNull
	@Column(name = "pepsecretariosuplente")
	private String pepsecretariosuplente;
	
	@NotNull
	@Column(name = "nombrevocalpropietario")
	private String nombrevocalpropietario;
	
	@NotNull
	@Column(name = "rfcvocalpropietario")
	private String rfcvocalpropietario;
	
	@NotNull
	@Column(name = "nacionalidadvocalpropietario")
	private String nacionalidadvocalpropietario;
	
	@NotNull
	@Column(name = "pepvocalpropietario")
	private String pepvocalpropietario;
	
	@NotNull
	@Column(name = "nombrevocalsuplente")
	private String nombrevocalsuplente;
	
	@NotNull
	@Column(name = "rfcvocalsuplente")
	private String rfcvocalsuplente;
	
	@NotNull
	@Column(name = "nacionalidadvocalsuplente")
	private String nacionalidadvocalsuplente;
	
	@NotNull
	@Column(name = "pepvocalsuplente")
	private String pepvocalsuplente;
	

	public UUID getComitetecnicoId() {
		return comitetecnicoId;
	}

	public void setComitetecnicoId(UUID comitetecnicoId) {
		this.comitetecnicoId = comitetecnicoId;
	}
	
	public UUID getFideicomisoId () {
	    return fideicomisoId;
	    }
	public void setFideicomiso(UUID fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getNombre () {
	    return nombre;
	    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIntegracion () {
	    return integracion;
	    }
	public void setIntegracion(String integracion) {
		this.integracion = integracion;
	}	
	public String getFacultades () {
	    return facultades;
	    }
	public void setFacultades(String facultades) {
		this.facultades = facultades;
	}	
	public String getComentarios () {
	    return comentarios;
	    }
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}	
	public String getFechaconstitucion () {
	    return fechaconstitucion;
	    }
	public void setFechaconstitucion(String fechaconstitucion) {
		this.fechaconstitucion = fechaconstitucion;
	}
	public Date getMiembrosquorum () {
	    return miembrosquorum;
	    }
	public void setMiembrosquorum(Date miembrosquorum) {
		this.miembrosquorum = miembrosquorum;
	}
	public String getEstatus () {
	    return estatus;
	    }
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getNombrepresidentepropietario () {
	    return nombrepresidentepropietario;
	    }
	public void setNombrepresidentepropietario(String nombrepresidentepropietario) {
		this.nombrepresidentepropietario = nombrepresidentepropietario;
	}
	public String getRfcpresidentepropietario () {
	    return rfcpresidentepropietario;
	    }
	public void setRfcpresidentepropietario(String rfcpresidentepropietario) {
		this.rfcpresidentepropietario = rfcpresidentepropietario;
	}
	public String getNacionalidadpresidentepropietario () {
	    return nacionalidadpresidentepropietario;
	    }
	public void setNacionalidadpresidentepropietario(String nacionalidadpresidentepropietario) {
		this.nacionalidadpresidentepropietario = nacionalidadpresidentepropietario;
	}
	public String getPeppresidentepropietario () {
	    return peppresidentepropietario;
	    }
	public void setPeppresidentepropietario(String peppresidentepropietario) {
		this.peppresidentepropietario = peppresidentepropietario;
	}
	public String getNombrepresidentesuplente () {
	    return nombrepresidentesuplente;
	    }
	public void setNombrepresidentesuplente(String nombrepresidentesuplente) {
		this.nombrepresidentesuplente = nombrepresidentesuplente;
	}
	public String getRfcpresidentesuplente () {
	    return rfcpresidentesuplente;
	    }
	public void setRfcpresidentesuplente(String rfcpresidentesuplente) {
		this.rfcpresidentesuplente = rfcpresidentesuplente;
	}
	public String getNacionalidadpresidentesuplente () {
	    return nacionalidadpresidentesuplente;
	    }
	public void setNacionalidadpresidentesuplente(String nacionalidadpresidentesuplente) {
		this.nacionalidadpresidentesuplente = nacionalidadpresidentesuplente;
	}
	public String getPeppresidentesuplente () {
	    return peppresidentesuplente;
	    }
	public void setPeppresidentesuplente(String peppresidentesuplente) {
		this.peppresidentesuplente = peppresidentesuplente;
	}
	public String getNombresecretariopropietario () {
	    return nombresecretariopropietario;
	    }
	public void setNombresecretariopropietario(String nombresecretariopropietario) {
		this.nombresecretariopropietario = nombresecretariopropietario;
	}
	public String getRfcsecretariopropietario () {
	    return rfcsecretariopropietario;
	    }
	public void setRfcsecretariopropietario(String rfcsecretariopropietario) {
		this.rfcsecretariopropietario = rfcsecretariopropietario;
	}
	public String getNacionalidadsecretariopropietario () {
	    return nacionalidadsecretariopropietario;
	    }
	public void setNacionalidadsecretariopropietario(String nacionalidadsecretariopropietario) {
		this.nacionalidadsecretariopropietario = nacionalidadsecretariopropietario;
	}
	public String getPepsecretariopropietario () {
	    return pepsecretariopropietario;
	    }
	public void setPepsecretariopropietario(String pepsecretariopropietario) {
		this.pepsecretariopropietario = pepsecretariopropietario;
	}
	public String getNombresecretariosuplente () {
	    return nombresecretariosuplente;
	    }
	public void setNombresecretariosuplente(String nombresecretariosuplente) {
		this.nombresecretariosuplente = nombresecretariosuplente;
	}
	public String getRfcsecretariosuplente () {
	    return rfcsecretariosuplente;
	    }
	public void setRfcsecretariosuplente(String rfcsecretariosuplente) {
		this.rfcsecretariosuplente = rfcsecretariosuplente;
	}
	public String getNacionalidadsecretariosuplente () {
	    return nacionalidadsecretariosuplente;
	    }
	public void setNacionalidadsecretariosuplente(String nacionalidadsecretariosuplente) {
		this.nacionalidadsecretariosuplente = nacionalidadsecretariosuplente;
	}
	public String getPepsecretariosuplente () {
	    return pepsecretariosuplente;
	    }
	public void setPepsecretariosuplente(String pepsecretariosuplente) {
		this.pepsecretariosuplente = pepsecretariosuplente;
	}
	public String getNombrevocalpropietario () {
	    return nombrevocalpropietario;
	    }
	public void setNombrevocalpropietario(String nombrevocalpropietario) {
		this.nombrevocalpropietario = nombrevocalpropietario;
	}
	public String getRfcvocalpropietario () {
	    return rfcvocalpropietario;
	    }
	public void setRfcvocalpropietario(String rfcvocalpropietario) {
		this.rfcvocalpropietario = rfcvocalpropietario;
	}
	public String getNacionalidadvocalpropietario () {
	    return nacionalidadvocalpropietario;
	    }
	public void setNacionalidadvocalpropietario(String nacionalidadvocalpropietario) {
		this.nacionalidadvocalpropietario = nacionalidadvocalpropietario;
	}
	public String getPepvocalpropietario () {
	    return pepvocalpropietario;
	    }
	public void setPepvocalpropietario(String pepvocalpropietario) {
		this.pepvocalpropietario = pepvocalpropietario;
	}
	public String getNombrevocalsuplente () {
	    return nombrevocalsuplente;
	    }
	public void setNombrevocalsuplente(String nombrevocalsuplente) {
		this.nombrevocalsuplente = nombrevocalsuplente;
	}
	public String getRfcvocalsuplente () {
	    return rfcvocalsuplente;
	    }
	public void setRfcvocalsuplente(String rfcvocalsuplente) {
		this.rfcvocalsuplente = rfcvocalsuplente;
	}
	public String getNacionalidadvocalsuplente () {
	    return nacionalidadvocalsuplente;
	    }
	public void setNacionalidadvocalsuplente(String nacionalidadvocalsuplente) {
		this.nacionalidadvocalsuplente = nacionalidadvocalsuplente;
	}
	public String getPepvocalsuplente () {
	    return pepvocalsuplente;
	    }
	public void setPepvocalsuplente(String pepvocalsuplente) {
		this.pepvocalsuplente = pepvocalsuplente;
	}
}		
