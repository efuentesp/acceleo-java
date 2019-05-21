package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.WhereJoinTable;

@Entity
@Table(name = "kyc")
public class Kyc implements Serializable {

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
	@Column(name = "kycId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  kycId;		

	@NotNull
	private UUID fideicomisoId;
	@NotNull
	@Column(name = "folio")
	private String folio;
	
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "numregistro")
	private String numregistro;
	
	@NotNull
	@Column(name = "oficina")
	private String oficina;
	
	@NotNull
	private String conceptoimpresion;
	@NotNull
	@Column(name = "crbanca")
	private String crbanca;
	

	public UUID getKycId() {
		return kycId;
	}

	public void setKycId(UUID kycId) {
		this.kycId = kycId;
	}
	
	public UUID getFideicomisoId () {
	    return fideicomisoId;
	    }
	public void setFideicomiso(UUID fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getFolio () {
	    return folio;
	    }
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getNombre () {
	    return nombre;
	    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumregistro () {
	    return numregistro;
	    }
	public void setNumregistro(String numregistro) {
		this.numregistro = numregistro;
	}
	public String getOficina () {
	    return oficina;
	    }
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	public String getConceptoimpresion () {
	    return conceptoimpresion;
	    }
	public void setConceptoimpresion(String conceptoimpresion) {
		this.conceptoimpresion = conceptoimpresion;
	}
	public String getCrbanca () {
	    return crbanca;
	    }
	public void setCrbanca(String crbanca) {
		this.crbanca = crbanca;
	}
}		
