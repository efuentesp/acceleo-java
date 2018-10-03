/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Beneficiario.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class BeneficiarioBean {
/**
 * Clase BeneficiarioBean.
 * @author PSG.
 *
 */
	private Integer beneficiarioId;

	private String apellido_paterno;
	private String apellido_materno;
	private String curp;
	private Date fecha_nacimiento;
	private String nombre;
	private Parentesco parentescoId;
	private enum Parentesco { conyuge,hijo,ascendiente}
	private Integer afiliadoId;

	public Integer getBeneficiarioId() {
		return beneficiarioId;
	}
	public void setBeneficiarioId(Integer beneficiarioId) {
		this.beneficiarioId = beneficiarioId;
	}
	public String getApellido_paterno () {
	    return apellido_paterno;  		
    }
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getApellido_materno () {
	    return apellido_materno;  		
    }
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public String getCurp () {
	    return curp;  		
    }
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public Date getFecha_nacimiento () {
	    return fecha_nacimiento;  		
    }
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Parentesco getParentescoId () {
	    return parentescoId;  		
    }
	public void setParentescoId (Parentesco parentescoId) {
		this.parentescoId = parentescoId;
	}
	public Integer getAfiliadoId () {
	    return afiliadoId;  		
    }
	public void setAfiliadoId (Integer afiliadoId) {
		this.afiliadoId = afiliadoId;
	}


}
