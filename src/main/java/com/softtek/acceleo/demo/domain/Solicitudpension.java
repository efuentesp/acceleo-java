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
@Table(name = "solicitudpension")
public class Solicitudpension implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "solicitudpensionId")
	private Integer  solicitudpensionId;


	@NotNull
	@Column(name = "numero") 
	private Integer numero;
	@NotNull
	@Column(name = "fecha_solicitud") 
	private Date fecha_solicitud;


	@NotNull
	@Column(name = "afiliadoId") 
	private Integer afiliadoId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="afiliadoId")
//	@IndexColumn(name="idx")
//	private List<AfiliadoId> afiliadoList;
	@NotNull
	@Column(name = "tipopensionId") 
	private Integer tipopensionId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="tipopensionId")
//	@IndexColumn(name="idx")
//	private List<TipopensionId> tipopensionList;
	@Column(name = "observaciones") 
	private String observaciones;

	public Integer getSolicitudpensionId() {
		return solicitudpensionId;
	}

	public void setSolicitudpensionId(Integer solicitudpensionId) {
		this.solicitudpensionId = solicitudpensionId;
	}

	
	public Integer getNumero () {
	    return numero;  		
    }
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Date getFecha_solicitud () {
	    return fecha_solicitud;  		
    }
	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}
	//public List<Afiliado> getAfiliadoList () {
	//    return afiliadoList;  		
    //}
	//public void setAfiliadoList (List<Afiliado> afiliadoList) {
	//	this.afiliadoList = afiliadoList;
	//}
	public Integer getAfiliadoId () {
	    return afiliadoId;  		
    }
	public void setAfiliadoId (Integer afiliadoId) {
		this.afiliadoId = afiliadoId;
	}
	//public List<Tipopension> getTipopensionList () {
	//    return tipopensionList;  		
    //}
	//public void setTipopensionList (List<Tipopension> tipopensionList) {
	//	this.tipopensionList = tipopensionList;
	//}
	public Integer getTipopensionId () {
	    return tipopensionId;  		
    }
	public void setTipopensionId (Integer tipopensionId) {
		this.tipopensionId = tipopensionId;
	}
	public String  getObservaciones () {
	    return observaciones;  		
    }
	public void setObservaciones (String observaciones) {
		this.observaciones = observaciones;
	}

}			
