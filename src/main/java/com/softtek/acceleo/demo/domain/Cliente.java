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
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "clienteId")
	private Integer  clienteId;

	@NotNull
	@Column(name = "nombre") 
	private String nombre;
	@NotNull
	@Column(name = "clave") 
	private Integer clave;
	
	@Column (name = "cliente1Id")
	private Cliente cliente1Id;
	
	@Column (name = "etiquetaasignada1Id")
	private List<Etiquetaasignada> etiquetaasignadas1Id;
	
	@Column (name = "ordensimplificada1Id")
	private List<Ordensimplificada> ordensimplificada1Id;

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getClave() {
		return clave;
	}

	public void setClave(Integer clave) {
		this.clave = clave;
	}

	public Cliente getCliente1Id() {
		return cliente1Id;
	}

	public void setCliente1Id(Cliente cliente1Id) {
		this.cliente1Id = cliente1Id;
	}

	public List<Etiquetaasignada> getEtiquetaasignadas1Id() {
		return etiquetaasignadas1Id;
	}

	public void setEtiquetaasignadas1Id(List<Etiquetaasignada> etiquetaasignadas1Id) {
		this.etiquetaasignadas1Id = etiquetaasignadas1Id;
	}

	public List<Ordensimplificada> getOrdensimplificada1Id() {
		return ordensimplificada1Id;
	}

	public void setOrdensimplificada1Id(List<Ordensimplificada> ordensimplificada1Id) {
		this.ordensimplificada1Id = ordensimplificada1Id;
	}

	@Override
	public String toString() {
		return "Cliente [clienteId=" + clienteId + ", nombre=" + nombre + ", clave=" + clave + ", cliente1Id="
				+ cliente1Id + ", etiquetaasignadas1Id=" + etiquetaasignadas1Id + ", ordensimplificada1Id="
				+ ordensimplificada1Id + "]";
	}

	
}			
