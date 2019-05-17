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
@Table(name = "evento")
public class Evento implements Serializable {

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
	@Column(name = "eventoId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  eventoId;		

	@NotNull
	private UUID organizadoporId;
	@NotNull
	private UUID impartidoporId;
	@NotNull
	@NotNull
	@Column(name = "clave")
	@Size(min = 10, max = 10)
	private String clave;
	
	@NotNull
	@Column(name = "fechaevento")
	private Date fechaevento;
	
	@NotNull
	@Column(name = "titulo")
	@Size(min = 80, max = 100)
	private String titulo;
	
	@NotNull
	@Column(name = "duracion")
	private Integer duracion;
	
	@NotNull
	@Column(name = "lugar")
	@Size(min = 150, max = 200) 
	private String lugar;
	
	@Column(name = "cartel")
	private String cartel;
	
	@NotNull
	private String tipoestatus;

	public UUID getEventoId() {
		return eventoId;
	}

	public void setEventoId(UUID eventoId) {
		this.eventoId = eventoId;
	}
	
	public UUID getOrganizadoporId () {
	    return organizadoporId;
	    }
	public void setOrganizadopor(UUID organizadoporId) {
		this.organizadoporId = organizadoporId;
	}
	public UUID getImpartidoporId () {
	    return impartidoporId;
	    }
	public void setImpartidopor(UUID impartidoporId) {
		this.impartidoporId = impartidoporId;
	}
	public String getClave () {
	    return clave;
	    }
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Date getFechaevento () {
	    return fechaevento;
	    }
	public void setFechaevento(Date fechaevento) {
		this.fechaevento = fechaevento;
	}
	public String getTitulo () {
	    return titulo;
	    }
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getDuracion () {
	    return duracion;
	    }
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}	
	public String getLugar () {
	    return lugar;
	    }
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}	
	public String getCartel () {
	    return cartel;
	    }
	public void setCartel(String cartel) {
		this.cartel = cartel;
	}
	public String getTipoestatus () {
	    return tipoestatus;
	    }
	public void setTipoestatus(String tipoestatus) {
		this.tipoestatus = tipoestatus;
	}
}		
