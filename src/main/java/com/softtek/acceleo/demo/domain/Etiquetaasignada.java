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
@Table(name = "etiquetaasignada")
public class Etiquetaasignada implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "etiquetaasignadaId")
	private Integer  etiquetaasignadaId;

	@NotNull
	@Column(name = "f5") 
	private Integer f5;
	@NotNull
	@Column(name = "sap") 
	private Integer sap;
	@NotNull
	@Column(name = "etiquetaasignadasxpalet") 
	private Integer etiquetaasignadasxpalet;
	@NotNull
	@Column(name = "multiplo1") 
	private Integer multiplo1;
	@NotNull
	@Column(name = "multiplo2") 
	private Integer multiplo2;
	@NotNull
	@Column(name = "multiplo3") 
	private Integer multiplo3;
	@NotNull
	@Column(name = "clienteId") 
	private Cliente clienteId;
	@NotNull
	@Column(name = "ordenSimplificadaId") 
	private Ordensimplificada ordenSimplificadaId;
	
	public Integer getEtiquetaasignadaId() {
		return etiquetaasignadaId;
	}
	public void setEtiquetaasignadaId(Integer etiquetaasignadaId) {
		this.etiquetaasignadaId = etiquetaasignadaId;
	}
	public Integer getF5() {
		return f5;
	}
	public void setF5(Integer f5) {
		this.f5 = f5;
	}
	public Integer getSap() {
		return sap;
	}
	public void setSap(Integer sap) {
		this.sap = sap;
	}
	public Integer getEtiquetaasignadasxpalet() {
		return etiquetaasignadasxpalet;
	}
	public void setEtiquetaasignadasxpalet(Integer etiquetaasignadasxpalet) {
		this.etiquetaasignadasxpalet = etiquetaasignadasxpalet;
	}
	public Integer getMultiplo1() {
		return multiplo1;
	}
	public void setMultiplo1(Integer multiplo1) {
		this.multiplo1 = multiplo1;
	}
	public Integer getMultiplo2() {
		return multiplo2;
	}
	public void setMultiplo2(Integer multiplo2) {
		this.multiplo2 = multiplo2;
	}
	public Integer getMultiplo3() {
		return multiplo3;
	}
	public void setMultiplo3(Integer multiplo3) {
		this.multiplo3 = multiplo3;
	}
	public Cliente getClienteId() {
		return clienteId;
	}
	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}
	public Ordensimplificada getOrdenSimplificadaId() {
		return ordenSimplificadaId;
	}
	public void setOrdenSimplificadaId(Ordensimplificada ordenSimplificadaId) {
		this.ordenSimplificadaId = ordenSimplificadaId;
	}

}			
