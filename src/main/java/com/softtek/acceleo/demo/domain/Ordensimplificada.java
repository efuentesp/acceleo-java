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
@Table(name = "ordensimplificada")
public class Ordensimplificada implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ordensimplificadaId")
	private Integer  ordensimplificadaId;

	@NotNull
	@Column(name = "sap") 
	private Integer sap;
	@NotNull
	@Column(name = "cantidadprogramada") 
	private Integer cantidadprogramada;
	@NotNull
	@Column(name = "ordentrabajo") 
	private Integer ordentrabajo;
	@NotNull
	@Column(name = "fechafinal") 
	private Date fechafinal;
	@NotNull
	@Column(name = "cantidadproducida") 
	private Integer cantidadproducida;
	@NotNull
	@Column(name = "fechainicial") 
	private Date fechainicial;
	@NotNull
	@Column(name = "linea1Id", nullable = false)
	@Enumerated(EnumType.STRING)
	private Linea lineaId;
	@NotNull
	@Column(name = "destino1Id", nullable = false)
	@Enumerated(EnumType.STRING)
	private Destino destinoId;
	@NotNull
	@Column(name = "estadoorden1Id", nullable = false)
	@Enumerated(EnumType.STRING)
	private Estadoorden estadoorden1Id;
	@NotNull
	@Column(name = "estadoorden2Id", nullable = false)
	@Enumerated(EnumType.STRING)
	private Estadoorden estadoorden2Id;
	@NotNull
	@Column(name = "operadorproduccion1Id") 
	private Operadorproduccion operadorproduccion1Id;
	@NotNull
	@Column(name = "operadorproduccion2Id") 
	private Operadorproduccion operadorproduccion2Id;
	@NotNull
	@Column(name = "cliente1Id") 
	private Integer cliente1Id;

	@Column(name = "comentario") 
	private String comentario;

	public Integer getOrdensimplificadaId() {
		return ordensimplificadaId;
	}

	public void setOrdensimplificadaId(Integer ordensimplificadaId) {
		this.ordensimplificadaId = ordensimplificadaId;
	}

	public Integer getSap() {
		return sap;
	}

	public void setSap(Integer sap) {
		this.sap = sap;
	}

	public Integer getCantidadprogramada() {
		return cantidadprogramada;
	}

	public void setCantidadprogramada(Integer cantidadprogramada) {
		this.cantidadprogramada = cantidadprogramada;
	}

	public Integer getOrdentrabajo() {
		return ordentrabajo;
	}

	public void setOrdentrabajo(Integer ordentrabajo) {
		this.ordentrabajo = ordentrabajo;
	}

	public Date getFechafinal() {
		return fechafinal;
	}

	public void setFechafinal(Date fechafinal) {
		this.fechafinal = fechafinal;
	}

	public Integer getCantidadproducida() {
		return cantidadproducida;
	}

	public void setCantidadproducida(Integer cantidadproducida) {
		this.cantidadproducida = cantidadproducida;
	}

	public Date getFechainicial() {
		return fechainicial;
	}

	public void setFechainicial(Date fechainicial) {
		this.fechainicial = fechainicial;
	}

	public Linea getLineaId() {
		return lineaId;
	}

	public void setLineaId(Linea lineaId) {
		this.lineaId = lineaId;
	}

	public Destino getDestinoId() {
		return destinoId;
	}

	public void setDestinoId(Destino destinoId) {
		this.destinoId = destinoId;
	}

	public Estadoorden getEstadoorden1Id() {
		return estadoorden1Id;
	}

	public void setEstadoorden1Id(Estadoorden estadoorden1Id) {
		this.estadoorden1Id = estadoorden1Id;
	}

	public Estadoorden getEstadoorden2Id() {
		return estadoorden2Id;
	}

	public void setEstadoorden2Id(Estadoorden estadoorden2Id) {
		this.estadoorden2Id = estadoorden2Id;
	}

	public Operadorproduccion getOperadorproduccion1Id() {
		return operadorproduccion1Id;
	}

	public void setOperadorproduccion1Id(Operadorproduccion operadorproduccion1Id) {
		this.operadorproduccion1Id = operadorproduccion1Id;
	}

	public Operadorproduccion getOperadorproduccion2Id() {
		return operadorproduccion2Id;
	}

	public void setOperadorproduccion2Id(Operadorproduccion operadorproduccion2Id) {
		this.operadorproduccion2Id = operadorproduccion2Id;
	}

	public Integer getCliente1Id() {
		return cliente1Id;
	}

	public void setCliente1Id(Integer cliente1Id) {
		this.cliente1Id = cliente1Id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}			
