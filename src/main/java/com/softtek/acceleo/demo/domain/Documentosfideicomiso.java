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
@Table(name = "documentosfideicomiso")
public class Documentosfideicomiso implements Serializable {

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
	@Column(name = "documentosfideicomisoId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID documentosfideicomisoId;

	@Column(name = "campo")
	@JsonProperty("campo")
	private String campo;
	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JsonProperty("contratofideicomiso")
	private String contratofideicomiso;
	@NotNull
	@JsonProperty("actasconstitutivas")
	private String actasconstitutivas;
	@NotNull
	@JsonProperty("cedulafiscal")
	private String cedulafiscal;
	@NotNull
	@JsonProperty("poderes")
	private String poderes;
	@NotNull
	@JsonProperty("identificadores")
	private String identificadores;
	@NotNull
	@JsonProperty("comprobantesdomicilio")
	private String comprobantesdomicilio;
	@NotNull
	@JsonProperty("formatoskyc")
	private String formatoskyc;
	@NotNull
	@JsonProperty("formatoevaluacionriesgo")
	private String formatoevaluacionriesgo;
	@NotNull
	@JsonProperty("worldcheck")
	private String worldcheck;
	@NotNull
	@JsonProperty("formatoinformacion")
	private String formatoinformacion;
	@NotNull
	@JsonProperty("autorizacioncomite")
	private String autorizacioncomite;
	@NotNull
	@JsonProperty("firmascomite")
	private String firmascomite;
	@NotNull
	@JsonProperty("curp")
	private String curp;

	public UUID getDocumentosfideicomisoId() {
		return documentosfideicomisoId;
	}

	public void setDocumentosfideicomisoId(UUID documentosfideicomisoId) {
		this.documentosfideicomisoId = documentosfideicomisoId;
	}
	
	public String getCampo() {
	    return campo;
	}
	public void setCampo(String campo) {
	this.campo = campo;
	}
	public Fideicomiso getFideicomisoId (){
	    return fideicomisoId;
	}
	public void setFideicomisoId(Fideicomiso fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getContratofideicomiso(){
	    return contratofideicomiso;
	}
	public void setContratofideicomiso(String contratofideicomiso) {
		this.contratofideicomiso = contratofideicomiso;
	}
	public String getActasconstitutivas(){
	    return actasconstitutivas;
	}
	public void setActasconstitutivas(String actasconstitutivas) {
		this.actasconstitutivas = actasconstitutivas;
	}
	public String getCedulafiscal(){
	    return cedulafiscal;
	}
	public void setCedulafiscal(String cedulafiscal) {
		this.cedulafiscal = cedulafiscal;
	}
	public String getPoderes(){
	    return poderes;
	}
	public void setPoderes(String poderes) {
		this.poderes = poderes;
	}
	public String getIdentificadores(){
	    return identificadores;
	}
	public void setIdentificadores(String identificadores) {
		this.identificadores = identificadores;
	}
	public String getComprobantesdomicilio(){
	    return comprobantesdomicilio;
	}
	public void setComprobantesdomicilio(String comprobantesdomicilio) {
		this.comprobantesdomicilio = comprobantesdomicilio;
	}
	public String getFormatoskyc(){
	    return formatoskyc;
	}
	public void setFormatoskyc(String formatoskyc) {
		this.formatoskyc = formatoskyc;
	}
	public String getFormatoevaluacionriesgo(){
	    return formatoevaluacionriesgo;
	}
	public void setFormatoevaluacionriesgo(String formatoevaluacionriesgo) {
		this.formatoevaluacionriesgo = formatoevaluacionriesgo;
	}
	public String getWorldcheck(){
	    return worldcheck;
	}
	public void setWorldcheck(String worldcheck) {
		this.worldcheck = worldcheck;
	}
	public String getFormatoinformacion(){
	    return formatoinformacion;
	}
	public void setFormatoinformacion(String formatoinformacion) {
		this.formatoinformacion = formatoinformacion;
	}
	public String getAutorizacioncomite(){
	    return autorizacioncomite;
	}
	public void setAutorizacioncomite(String autorizacioncomite) {
		this.autorizacioncomite = autorizacioncomite;
	}
	public String getFirmascomite(){
	    return firmascomite;
	}
	public void setFirmascomite(String firmascomite) {
		this.firmascomite = firmascomite;
	}
	public String getCurp(){
	    return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}

	// Se crea la entidad hija (Embebidos)			


}		
