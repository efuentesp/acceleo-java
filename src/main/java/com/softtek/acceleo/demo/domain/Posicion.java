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
@Table(name = "posicion")
public class Posicion implements Serializable {

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
	@Column(name = "posicionId", columnDefinition = "VARBINARY(50)")
	private UUID posicionId;

	@NotNull
	private UUID filialId;
	@NotNull
	private String puestos;
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "descripcion")
	private String descripcion;
	
	@NotNull
	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@NotNull
	@Column(name = "contacto")
	private String contacto;
	
	@NotNull
	@Column(name = "salario")
	private Double salario;
	
	@NotNull
	@Column(name = "vacantes")
	private Integer vacantes;
	
	@NotNull
	private String tiponomina;
	@NotNull
	private UUID reclutadorId;
	@NotNull
	private String estatusposicion;
	@NotNull
	@NotNull

	public UUID getPosicionId() {
		return posicionId;
	}

	public void setPosicionId(UUID posicionId) {
		this.posicionId = posicionId;
	}
	
	public UUID getFilialId () {
	    return filialId;
	    }
	public void setFilialId(UUID filialId) {
		this.filialId = filialId;
	}
	public String getPuestos () {
	    return puestos;
	    }
	public void setPuestos(String puestos) {
		this.puestos = puestos;
	}
	public String getNombre () {
	    return nombre;
	    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion () {
	    return descripcion;
	    }
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha () {
	    return fecha;
	    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getContacto () {
	    return contacto;
	    }
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public Double getSalario () {
	    return salario;
	    }
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer getVacantes () {
	    return vacantes;
	    }
	public void setVacantes(Integer vacantes) {
		this.vacantes = vacantes;
	}	
	public String getTiponomina () {
	    return tiponomina;
	    }
	public void setTiponomina(String tiponomina) {
		this.tiponomina = tiponomina;
	}
	public UUID getReclutadorId () {
	    return reclutadorId;
	    }
	public void setReclutadorId(UUID reclutadorId) {
		this.reclutadorId = reclutadorId;
	}
	public String getEstatusposicion () {
	    return estatusposicion;
	    }
	public void setEstatusposicion(String estatusposicion) {
		this.estatusposicion = estatusposicion;
	}
}		
