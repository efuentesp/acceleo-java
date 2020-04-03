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
@Table(name = "carteraadeudo")
public class Carteraadeudo implements Serializable {

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
	@Column(name = "carteraadeudoId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")
	private UUID carteraadeudoId;

	@NotNull
	@JoinColumn(name = "honorarioscontratoId")
	@OneToOne(fetch = FetchType.EAGER)
	private Honorarioscontrato honorarioscontratoId;
	@NotNull
	@Column(name = "folioadeudo")
	@JsonProperty("folioadeudo")
	private String folioadeudo;
	@NotNull
	@JsonProperty("calificacion")
	private String calificacion;
	@NotNull
	@Column(name = "fechacalculo")
	@JsonProperty("fechacalculo")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacalculo;
	@NotNull
	@Column(name = "del")
	@JsonProperty("del")
	@Temporal(TemporalType.TIMESTAMP)
	private Date del;
	@NotNull
	@Column(name = "al")
	@JsonProperty("al")
	@Temporal(TemporalType.TIMESTAMP)
	private Date al;
	@NotNull
	@JsonProperty("moneda")
	private String moneda;
	@NotNull
	@Column(name = "importe")
	@JsonProperty("importe")
	private String importe;

	public UUID getCarteraadeudoId() {
		return carteraadeudoId;
	}

	public void setCarteraadeudoId(UUID carteraadeudoId) {
		this.carteraadeudoId = carteraadeudoId;
	}
	
	public Honorarioscontrato getHonorarioscontratoId (){
	    return honorarioscontratoId;
	}
	public void setHonorarioscontratoId(Honorarioscontrato honorarioscontratoId) {
		this.honorarioscontratoId = honorarioscontratoId;
	}
	public String getFolioadeudo() {
	    return folioadeudo;
	}
	public void setFolioadeudo(String folioadeudo) {
	this.folioadeudo = folioadeudo;
	}
	public String getCalificacion(){
	    return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public Date getFechacalculo() {
	    return fechacalculo;
	}
	public void setFechacalculo(Date fechacalculo) {
		this.fechacalculo = fechacalculo;
	}
	public Date getDel() {
	    return del;
	}
	public void setDel(Date del) {
		this.del = del;
	}
	public Date getAl() {
	    return al;
	}
	public void setAl(Date al) {
		this.al = al;
	}
	public String getMoneda(){
	    return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getImporte() {
	    return importe;
	}
	public void setImporte(String importe) {
	this.importe = importe;
	}

	// Se crea la entidad hija (Embebidos)			


}		
