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
@Table(name = "aplicacionpagoscontrolados")
public class Aplicacionpagoscontrolados implements Serializable {

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
	@Column(name = "aplicacionpagoscontroladosId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID aplicacionpagoscontroladosId;

	@NotNull
	@JoinColumn(name = "fideicomisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Fideicomiso fideicomisoId;
	@NotNull
	@JoinColumn(name = "subfisoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Subfiso subfisoId;
	@NotNull
	@Column(name = "importe")
	@JsonProperty("importe")
	private String importe;
	@NotNull
	@Column(name = "importepago")
	@JsonProperty("importepago")
	private String importepago;
	@NotNull
	@JsonProperty("formapago")
	private String formapago;
	@NotNull
	@JsonProperty("tipocomision")
	private String tipocomision;
	@NotNull
	@Column(name = "iva")
	@JsonProperty("iva")
	private String iva;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;

	public UUID getAplicacionpagoscontroladosId() {
		return aplicacionpagoscontroladosId;
	}

	public void setAplicacionpagoscontroladosId(UUID aplicacionpagoscontroladosId) {
		this.aplicacionpagoscontroladosId = aplicacionpagoscontroladosId;
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
	public String getImporte() {
	    return importe;
	}
	public void setImporte(String importe) {
	this.importe = importe;
	}
	public String getImportepago() {
	    return importepago;
	}
	public void setImportepago(String importepago) {
	this.importepago = importepago;
	}
	public String getFormapago(){
	    return formapago;
	}
	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}
	public String getTipocomision(){
	    return tipocomision;
	}
	public void setTipocomision(String tipocomision) {
		this.tipocomision = tipocomision;
	}
	public String getIva() {
	    return iva;
	}
	public void setIva(String iva) {
	this.iva = iva;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	// Se crea la entidad hija (Embebidos)			


}		
