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

	private String nombre;
	private String apellidopaterno;
	private String apellidomaterno;
	private Date fechanacimiento;
	private Integer cuentadeahorroId;
	private Genero esId;
	private enum Genero { mas,fem}
	private Parentesco deId;
	private enum Parentesco { h1,hj2,hj1,ma,pa,cy,h2}

	public Integer getBeneficiarioId() {
		return beneficiarioId;
	}
	public void setBeneficiarioId(Integer beneficiarioId) {
		this.beneficiarioId = beneficiarioId;
	}
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidopaterno () {
	    return apellidopaterno;  		
    }
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getApellidomaterno () {
	    return apellidomaterno;  		
    }
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public Date getFechanacimiento () {
	    return fechanacimiento;  		
    }
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public Integer getCuentadeahorroId () {
	    return cuentadeahorroId;  		
    }
	public void setCuentadeahorroId (Integer cuentadeahorroId) {
		this.cuentadeahorroId = cuentadeahorroId;
	}
	public Genero getEsId () {
	    return esId;  		
    }
	public void setEsId (Genero esId) {
		this.esId = esId;
	}
	public Parentesco getDeId () {
	    return deId;  		
    }
	public void setDeId (Parentesco deId) {
		this.deId = deId;
	}


}
