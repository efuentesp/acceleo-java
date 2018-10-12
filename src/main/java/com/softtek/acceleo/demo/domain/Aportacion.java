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
@Table(name = "aportacion")
public class Aportacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "aportacionId")
	private Integer  aportacionId;


	@NotNull
	@Column(name = "fecha") 
	private Date fecha;
	@NotNull
	@Column(name = "monto") 
	private Double monto;


	@NotNull
	@Column(name = "cuentadeahorroId") 
	private Integer cuentadeahorroId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="cuentadeahorroId")
//	@IndexColumn(name="idx")
//	private List<CuentadeahorroId> cuentadeahorroList;
	@NotNull
	@Column(name = "tipoaportacionId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipoaportacion tipoaportacionId;

	public Integer getAportacionId() {
		return aportacionId;
	}

	public void setAportacionId(Integer aportacionId) {
		this.aportacionId = aportacionId;
	}

	
	public Date getFecha () {
	    return fecha;  		
    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Double getMonto () {
	    return monto;  		
    }
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	//public List<Cuentadeahorro> getCuentadeahorroList () {
	//    return cuentadeahorroList;  		
    //}
	//public void setCuentadeahorroList (List<Cuentadeahorro> cuentadeahorroList) {
	//	this.cuentadeahorroList = cuentadeahorroList;
	//}
	public Integer getCuentadeahorroId () {
	    return cuentadeahorroId;  		
    }
	public void setCuentadeahorroId (Integer cuentadeahorroId) {
		this.cuentadeahorroId = cuentadeahorroId;
	}
	public Tipoaportacion getTipoaportacionId () {
	    return tipoaportacionId;  		
    }
	public void setTipoaportacionId (Tipoaportacion tipoaportacionId) {
		this.tipoaportacionId = tipoaportacionId;
	}

}			
