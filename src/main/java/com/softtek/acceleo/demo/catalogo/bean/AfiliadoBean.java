/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Afiliado.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class AfiliadoBean {
/**
 * Clase AfiliadoBean.
 * @author PSG.
 *
 */
	private Integer afiliadoId;

	private String nss;
	private String nombre;
	private Double acta_nacimiento;
	private Double numero;
	private Integer semanas_cotizadas;
	private String correo;
	private Double foto;
	private String apellido_materno;
	private String apellido_paterno;
	private Date fecha_afiliacion;
	private String observaciones;
	private Genero generoId;
	private enum Genero { female,male}
	private Integer beneficiario1Id;

	
	public Integer getBeneficiario1Id() {
		return beneficiario1Id;
	}
	public void setBeneficiario1Id(Integer beneficiario1Id) {
		this.beneficiario1Id = beneficiario1Id;
	}
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

	public Genero getGeneroId () {
	    return generoId;  		
    }
	public void setGeneroId (Genero generoId) {
		this.generoId = generoId;
	}
	

}
