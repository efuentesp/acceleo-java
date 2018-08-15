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
@Table(name = "cuentadeahorro")
public class Cuentadeahorro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cuentadeahorroId")
	private Integer  cuentadeahorroId;


	@NotNull
	@Column(name = "numero") 
	private Integer numero;
	@NotNull
	@Column(name = "fechadisponibilidad") 
	private Date fechadisponibilidad;
	@NotNull
	@Column(name = "fechavencimiento") 
	private Date fechavencimiento;
	@NotNull
	@Column(name = "fechacontratacion") 
	private Date fechacontratacion;


	@NotNull
	@Column(name = "socioId") 
	private Integer socioId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="socioId")
//	@IndexColumn(name="idx")
//	private List<SocioId> socioList;
	@NotNull
	@Column(name = "tipoahorroId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipoahorro tipoahorroId;

	public Integer getCuentadeahorroId() {
		return cuentadeahorroId;
	}

	public void setCuentadeahorroId(Integer cuentadeahorroId) {
		this.cuentadeahorroId = cuentadeahorroId;
	}

	
	public Integer getNumero () {
	    return numero;  		
    }
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Date getFechadisponibilidad () {
	    return fechadisponibilidad;  		
    }
	public void setFechadisponibilidad(Date fechadisponibilidad) {
		this.fechadisponibilidad = fechadisponibilidad;
	}
	
	public Date getFechavencimiento () {
	    return fechavencimiento;  		
    }
	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	
	public Date getFechacontratacion () {
	    return fechacontratacion;  		
    }
	public void setFechacontratacion(Date fechacontratacion) {
		this.fechacontratacion = fechacontratacion;
	}
	//public List<Socio> getSocioList () {
	//    return socioList;  		
    //}
	//public void setSocioList (List<Socio> socioList) {
	//	this.socioList = socioList;
	//}
	public Integer getSocioId () {
	    return socioId;  		
    }
	public void setSocioId (Integer socioId) {
		this.socioId = socioId;
	}
	public Tipoahorro getTipoahorroId () {
	    return tipoahorroId;  		
    }
	public void setTipoahorroId (Tipoahorro tipoahorroId) {
		this.tipoahorroId = tipoahorroId;
	}

}			
