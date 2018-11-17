package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "solicitud")
public class Solicitud implements Serializable {

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
	@Column(name = "solicitudId", columnDefinition = "VARBINARY(50)")
	private UUID solicitudId;

	@NotNull
	private UUID posicionId;
	private UUID candidatoId;
	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@NotNull
	@Column(name = "salario")
	private Double salario;
	
	@NotNull
	@Column(name = "correo")
	private String correo;
	
	@NotNull
	@Column(name = "telefono")
	private String telefono;
	
	private UUID direccionId;
	private String trayectoria;
	@NotNull
	private String estatussolicitud;

	public UUID getSolicitudId() {
		return solicitudId;
	}

	public void setSolicitudId(UUID solicitudId) {
		this.solicitudId = solicitudId;
	}
	
	public UUID getPosicionId () {
	    return posicionId;
	    }
	public void setPosicionId(UUID posicionId) {
		this.posicionId = posicionId;
	}
	public UUID getCandidatoId () {
	    return candidatoId;
	    }
	public void setCandidatoId(UUID candidatoId) {
		this.candidatoId = candidatoId;
	}
	public Date getFecha () {
	    return fecha;
	    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getSalario () {
	    return salario;
	    }
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getCorreo () {
	    return correo;
	    }
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono () {
	    return telefono;
	    }
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public UUID getDireccionId () {
	    return direccionId;
	    }
	public void setDireccionId(UUID direccionId) {
		this.direccionId = direccionId;
	}
	public String getTrayectoria () {
	    return trayectoria;
	    }
	public void setTrayectoria(String trayectoria) {
		this.trayectoria = trayectoria;
	}
	public String getEstatussolicitud () {
	    return estatussolicitud;
	    }
	public void setEstatussolicitud(String estatussolicitud) {
		this.estatussolicitud = estatussolicitud;
	}
}		
