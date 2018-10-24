package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
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

	@OneToOne
	@JoinColumn(name = "filialId")
	private Filial filial;
	
	@OneToOne
	@JoinColumn(name = "puestoId")
	private Puesto puesto;
	
	@OneToOne
	@JoinColumn(name = "reclutadorId")
	private Reclutador reclutador;
	
	@NotNull
	@Column(name = "tiponominaId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Tiponomina tiponominaId;
	@NotNull
	@Column(name = "estatusposicionId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Estatusposicion estatusposicionId;


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
	
	public Tiponomina getTiponominaId () {
	    return tiponominaId;  		
    }
	public void setTiponominaId (Tiponomina tiponominaId) {
		this.tiponominaId = tiponominaId;
	}
	
	public Estatusposicion getEstatusposicionId () {
	    return estatusposicionId;  		
    }
	public void setEstatusposicionId (Estatusposicion estatusposicionId) {
		this.estatusposicionId = estatusposicionId;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public Reclutador getReclutador() {
		return reclutador;
	}

	public void setReclutador(Reclutador reclutador) {
		this.reclutador = reclutador;
	}

}			
