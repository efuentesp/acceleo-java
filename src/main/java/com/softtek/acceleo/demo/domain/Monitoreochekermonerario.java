package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.WhereJoinTable;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "monitoreochekermonerario")
public class Monitoreochekermonerario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		          name = "UUID", 
		                strategy = "org.hibernate.id.UUIDGenerator", 
		                parameters = {
		                @Parameter( 
		                		name = "uuid_gen_strategy_class", 
		                		value = "org.hibernate.id.uuid.CustomVersionOneStrategy" 
		                ) 
					  } 
					 )
	@Column(name = "monitoreochekermonerarioId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID monitoreochekermonerarioId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
	@NotNull
	@Column(name = "foliooperacion")
	@JsonProperty("foliooperacion")
	private String foliooperacion;
	@NotNull
	@Column(name = "importe")
	@JsonProperty("importe")
	private String importe;
	@NotNull
	@Column(name = "fechaoperacion")
	@JsonProperty("fechaoperacion")
	private String fechaoperacion;
	@NotNull
	@Column(name = "totalpagos")
	@JsonProperty("totalpagos")
	private String totalpagos;
	@NotNull
	@Column(name = "liquidados")
	@JsonProperty("liquidados")
	private Integer liquidados;
	@NotNull
	@Column(name = "contabilizados")
	@JsonProperty("contabilizados")
	private Integer contabilizados;
	@NotNull
	@Column(name = "pendientes")
	@JsonProperty("pendientes")
	private Integer pendientes;
	@NotNull
	@Column(name = "error")
	@JsonProperty("error")
	private Integer error;
	@NotNull
	@JsonProperty("estatus")
	private String estatus;

	public UUID getMonitoreochekermonerarioId() {
		return monitoreochekermonerarioId;
	}

	public void setMonitoreochekermonerarioId(UUID monitoreochekermonerarioId) {
		this.monitoreochekermonerarioId = monitoreochekermonerarioId;
	}
	
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public Subfiso getSubfisoId (){
	    return subfisoId;
	}
	public void setSubfisoId(Subfiso subfisoId) {
		this.subfisoId = subfisoId;
	}
	public String getFoliooperacion() {
	    return foliooperacion;
	}
	public void setFoliooperacion(String foliooperacion) {
	this.foliooperacion = foliooperacion;
	}
	public String getImporte() {
	    return importe;
	}
	public void setImporte(String importe) {
	this.importe = importe;
	}
	public String getFechaoperacion() {
	    return fechaoperacion;
	}
	public void setFechaoperacion(String fechaoperacion) {
	this.fechaoperacion = fechaoperacion;
	}
	public String getTotalpagos() {
	    return totalpagos;
	}
	public void setTotalpagos(String totalpagos) {
	this.totalpagos = totalpagos;
	}
	public Integer getLiquidados(){
	    return liquidados;
	}
	public void setLiquidados(Integer liquidados) {
		this.liquidados = liquidados;
	}
	public Integer getContabilizados(){
	    return contabilizados;
	}
	public void setContabilizados(Integer contabilizados) {
		this.contabilizados = contabilizados;
	}
	public Integer getPendientes(){
	    return pendientes;
	}
	public void setPendientes(Integer pendientes) {
		this.pendientes = pendientes;
	}
	public Integer getError(){
	    return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public String getEstatus(){
	    return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	// Se crea la entidad hija (Embebidos)			


}		
