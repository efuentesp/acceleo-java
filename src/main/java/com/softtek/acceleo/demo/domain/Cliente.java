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
	
	@Column (name = "clienteIdS")
	private Cliente clienteIdS;
	
	@Column (name = "etiquetaasignadaId")
	private List<Etiquetaasignada> etiquetaasignadas;
	
	@Column (name = "ordensimplificada")
	private List<Ordensimplificada> ordensimplificada;

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

	public Cliente getClienteIdS() {
		return clienteIdS;
	}

	public void setClienteIdS(Cliente clienteIdS) {
		this.clienteIdS = clienteIdS;
	}

	public List<Etiquetaasignada> getEtiquetaasignadas() {
		return etiquetaasignadas;
	}

	public void setEtiquetaasignadas(List<Etiquetaasignada> etiquetaasignadas) {
		this.etiquetaasignadas = etiquetaasignadas;
	}

	public List<Ordensimplificada> getOrdensimplificada() {
		return ordensimplificada;
	}

	public void setOrdensimplificada(List<Ordensimplificada> ordensimplificada) {
		this.ordensimplificada = ordensimplificada;
	}
	
}			
