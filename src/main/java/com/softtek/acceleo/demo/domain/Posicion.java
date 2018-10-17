package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "posicion")
public class Posicion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "posicionId")
	private Integer  posicionId;


	@NotNull
	@Column(name = "descripcion") 
	private String descripcion;
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
	@Column(name = "nombre") 
	private String nombre;
	@NotNull
	@Column(name = "fecha") 
	private Date fecha;


	@NotNull
	@Column(name = "filialId") 
	private Integer filialId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="filialId")
//	@IndexColumn(name="idx")
//	private List<FilialId> filialList;
	@NotNull
	@Column(name = "puestoId") 
	private Integer puestoId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="puestoId")
//	@IndexColumn(name="idx")
//	private List<PuestoId> puestoList;
	@NotNull
	@Column(name = "tiponominaId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Tiponomina tiponominaId;
	@NotNull
	@Column(name = "reclutadorId") 
	private Integer reclutadorId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="reclutadorId")
//	@IndexColumn(name="idx")
//	private List<ReclutadorId> reclutadorList;
	@NotNull
	@Column(name = "estatusposicionId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Estatusposicion estatusposicionId;
//	@NotNull
//	@Column(name = "solicitudId") 
//	private Integer solicitudId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="solicitudId")
//	@IndexColumn(name="idx")
//	private List<SolicitudId> solicitudList;
//	@NotNull
//	@Column(name = "eventoId") 
//	private Integer eventoId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="eventoId")
//	@IndexColumn(name="idx")
//	private List<EventoId> eventoList;

	public Integer getPosicionId() {
		return posicionId;
	}

	public void setPosicionId(Integer posicionId) {
		this.posicionId = posicionId;
	}

	
	public String getDescripcion () {
	    return descripcion;  		
    }
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFecha () {
	    return fecha;  		
    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	//public List<Filial> getFilialList () {
	//    return filialList;  		
    //}
	//public void setFilialList (List<Filial> filialList) {
	//	this.filialList = filialList;
	//}
	public Integer getFilialId () {
	    return filialId;  		
    }
	public void setFilialId (Integer filialId) {
		this.filialId = filialId;
	}
	//public List<Puesto> getPuestoList () {
	//    return puestoList;  		
    //}
	//public void setPuestoList (List<Puesto> puestoList) {
	//	this.puestoList = puestoList;
	//}
	public Integer getPuestoId () {
	    return puestoId;  		
    }
	public void setPuestoId (Integer puestoId) {
		this.puestoId = puestoId;
	}
	public Tiponomina getTiponominaId () {
	    return tiponominaId;  		
    }
	public void setTiponominaId (Tiponomina tiponominaId) {
		this.tiponominaId = tiponominaId;
	}
	//public List<Reclutador> getReclutadorList () {
	//    return reclutadorList;  		
    //}
	//public void setReclutadorList (List<Reclutador> reclutadorList) {
	//	this.reclutadorList = reclutadorList;
	//}
	public Integer getReclutadorId () {
	    return reclutadorId;  		
    }
	public void setReclutadorId (Integer reclutadorId) {
		this.reclutadorId = reclutadorId;
	}
	public Estatusposicion getEstatusposicionId () {
	    return estatusposicionId;  		
    }
	public void setEstatusposicionId (Estatusposicion estatusposicionId) {
		this.estatusposicionId = estatusposicionId;
	}
	//public List<Solicitud> getSolicitudList () {
	//    return solicitudList;  		
    //}
	//public void setSolicitudList (List<Solicitud> solicitudList) {
	//	this.solicitudList = solicitudList;
	//}
//	public Integer getSolicitudId () {
//	    return solicitudId;  		
//    }
//	public void setSolicitudId (Integer solicitudId) {
//		this.solicitudId = solicitudId;
//	}
//	//public List<Evento> getEventoList () {
//	//    return eventoList;  		
//    //}
//	//public void setEventoList (List<Evento> eventoList) {
//	//	this.eventoList = eventoList;
//	//}
//	public Integer getEventoId () {
//	    return eventoId;  		
//    }
//	public void setEventoId (Integer eventoId) {
//		this.eventoId = eventoId;
//	}

}			
