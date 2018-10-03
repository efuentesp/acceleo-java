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
@Table(name = "afiliado")
public class Afiliado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "afiliadoId")
	private Integer  afiliadoId;


	@NotNull
	@Column(name = "nss") 
	private String nss;
	@NotNull
	@Column(name = "nombre") 
	private String nombre;
	@NotNull
	@Column(name = "acta_nacimiento") 
	private Double acta_nacimiento;
	@NotNull
	@Column(name = "numero") 
	private Double numero;
	@NotNull
	@Column(name = "semanas_cotizadas") 
	private Integer semanas_cotizadas;
	@NotNull
	@Column(name = "correo") 
	private String correo;
	@NotNull
	@Column(name = "foto") 
	private Double foto;
	@NotNull
	@Column(name = "apellido_materno") 
	private String apellido_materno;
	@NotNull
	@Column(name = "apellido_paterno") 
	private String apellido_paterno;
	@NotNull
	@Column(name = "fecha_afiliacion") 
	private Date fecha_afiliacion;
	@NotNull
	@Column(name = "observaciones") 
	private String observaciones;


	@NotNull
	@Column(name = "genero1Id", nullable = false)
	@Enumerated(EnumType.STRING)
	private Genero genero1Id;
	@NotNull
	@Column(name = "beneficiario1Id") 
	private Integer beneficiario1Id;

	

	public Integer getAfiliadoId() {
		return afiliadoId;
	}

	public void setAfiliadoId(Integer afiliadoId) {
		this.afiliadoId = afiliadoId;
	}

	
	public String getNss () {
	    return nss;  		
    }
	public void setNss(String nss) {
		this.nss = nss;
	}
	
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getActa_nacimiento () {
	    return acta_nacimiento;  		
    }
	public void setActa_nacimiento(Double acta_nacimiento) {
		this.acta_nacimiento = acta_nacimiento;
	}
	
	public Double getNumero () {
	    return numero;  		
    }
	public void setNumero(Double numero) {
		this.numero = numero;
	}
	
	public Integer getSemanas_cotizadas () {
	    return semanas_cotizadas;  		
    }
	public void setSemanas_cotizadas(Integer semanas_cotizadas) {
		this.semanas_cotizadas = semanas_cotizadas;
	}
	
	public String getCorreo () {
	    return correo;  		
    }
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public Double getFoto () {
	    return foto;  		
    }
	public void setFoto(Double foto) {
		this.foto = foto;
	}
	
	public String getApellido_materno () {
	    return apellido_materno;  		
    }
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	
	public String getApellido_paterno () {
	    return apellido_paterno;  		
    }
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	
	public Date getFecha_afiliacion () {
	    return fecha_afiliacion;  		
    }
	public void setFecha_afiliacion(Date fecha_afiliacion) {
		this.fecha_afiliacion = fecha_afiliacion;
	}
	
	public String getObservaciones () {
	    return observaciones;  		
    }
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Genero getGenero1Id() {
		return genero1Id;
	}

	public void setGenero1Id(Genero genero1Id) {
		this.genero1Id = genero1Id;
	}

	public Integer getBeneficiario1Id() {
		return beneficiario1Id;
	}

	public void setBeneficiario1Id(Integer beneficiario1Id) {
		this.beneficiario1Id = beneficiario1Id;
	}


}			
