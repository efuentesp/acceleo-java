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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente")
public class Cliente /**/implements Serializable/**/ {

	//private static final long serialVersionUID = 1L;

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
	
//-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
    //@ManyToOne(cascade={CascadeType.ALL})
    //@JoinColumn(name="cliente1Id")
	@Column(name="cliente1Id")
    //private Cliente cliente1Id;
	private Integer cliente1Id;
	
//	@Column (name = "clienteId")
//	private List<Cliente> clienteIdS;
	
	//	@Column (name = "etiquetaasignadaId")
//	private List<Etiquetaasignada> etiquetaasignadas;
//	@NotNull
//	@Column (name = "etiquetaasignada1Id")
//	private Integer etiquetaasignadas;
	@OneToMany (cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "etiquetaasignada1Id")
	@JsonIgnore 
	private List<Etiquetaasignada> etiquetaasignadas1Id;	
	
	
//	@Column (name = "ordensimplificada")
//	private List<Ordensimplificada> ordensimplificada;
//	@Column (name = "ordensimplificada1Id")
//	private Integer ordensimplificada;
	@OneToMany (cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ordensimplificada1Id")
	@JsonIgnore 
	private List<Ordensimplificada> ordensimplificada1Id;
	
//-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-	
	
	
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

//	public List<Cliente> getClienteIdS() {
//		return clienteIdS;
//	}
//
//	public void setClienteIdS(List<Cliente> clienteIdS) {
//		this.clienteIdS = clienteIdS;
//	}

//	public List<Etiquetaasignada> getEtiquetaasignadas() {
//		return etiquetaasignadas;
//	}
//
//	public void setEtiquetaasignadas(List<Etiquetaasignada> etiquetaasignadas) {
//		this.etiquetaasignadas = etiquetaasignadas;
//	}

	
//	public List<Ordensimplificada> getOrdensimplificada() {
//		return ordensimplificada;
//	}
//
//	public void setOrdensimplificada(List<Ordensimplificada> ordensimplificada) {
//		this.ordensimplificada = ordensimplificada;
//	}
	
	
	public Integer getCliente1Id() {
		return cliente1Id;
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

	public void setCliente1Id(Integer cliente1Id) {
		this.cliente1Id = cliente1Id;
	}
	
}			
