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
@Table(name = "cuentacheques")
public class Cuentacheques implements Serializable {

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
	@Column(name = "cuentachequesId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  cuentachequesId;		

	@NotNull
	private UUID fideicomisoId;
	@NotNull
	private String tipopersona;
	@NotNull
	private UUID fideicomitenteId;
	@NotNull
	private String tipocuenta;
	@NotNull
	private String tipopago;
	@NotNull
	private String bancospei;
	@NotNull
	private String banco;
	@NotNull
	@Column(name = "dombanco")
	private String dombanco;
	
	@NotNull
	private String moneda;
	@NotNull
	private String clavevostro;
	@NotNull
	@Column(name = "numcuenta")
	private String numcuenta;
	
	@NotNull
	@Column(name = "dombeneficiario")
	private String dombeneficiario;
	
	@NotNull
	@Column(name = "plazainternacional")
	private String plazainternacional;
	
	@NotNull
	@Column(name = "pais")
	private String pais;
	
	@NotNull
	@Column(name = "clavesiacinst")
	private String clavesiacinst;
	
	@NotNull
	@Column(name = "conveniociedie")
	private String conveniociedie;
	
	@NotNull
	private String estatus;
	@NotNull
	@Column(name = "clabe")
	private String clabe;
	
	@NotNull
	@Column(name = "fechavence")
	private String fechavence;
	
	@NotNull
	@Column(name = "numabbasswift")
	private String numabbasswift;
	
	@NotNull
	@Column(name = "conceptosiac")
	private String conceptosiac;
	
	@NotNull
	@Column(name = "refciedie")
	private String refciedie;
	
	@NotNull
	private String autorizacion;

	public UUID getCuentachequesId() {
		return cuentachequesId;
	}

	public void setCuentachequesId(UUID cuentachequesId) {
		this.cuentachequesId = cuentachequesId;
	}
	
	public UUID getFideicomisoId () {
	    return fideicomisoId;
	    }
	public void setFideicomiso(UUID fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getTipopersona () {
	    return tipopersona;
	    }
	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	public UUID getFideicomitenteId () {
	    return fideicomitenteId;
	    }
	public void setFideicomitente(UUID fideicomitenteId) {
		this.fideicomitenteId = fideicomitenteId;
	}
	public String getTipocuenta () {
	    return tipocuenta;
	    }
	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}
	public String getTipopago () {
	    return tipopago;
	    }
	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}
	public String getBancospei () {
	    return bancospei;
	    }
	public void setBancospei(String bancospei) {
		this.bancospei = bancospei;
	}
	public String getBanco () {
	    return banco;
	    }
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getDombanco () {
	    return dombanco;
	    }
	public void setDombanco(String dombanco) {
		this.dombanco = dombanco;
	}
	public String getMoneda () {
	    return moneda;
	    }
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getClavevostro () {
	    return clavevostro;
	    }
	public void setClavevostro(String clavevostro) {
		this.clavevostro = clavevostro;
	}
	public String getNumcuenta () {
	    return numcuenta;
	    }
	public void setNumcuenta(String numcuenta) {
		this.numcuenta = numcuenta;
	}
	public String getDombeneficiario () {
	    return dombeneficiario;
	    }
	public void setDombeneficiario(String dombeneficiario) {
		this.dombeneficiario = dombeneficiario;
	}
	public String getPlazainternacional () {
	    return plazainternacional;
	    }
	public void setPlazainternacional(String plazainternacional) {
		this.plazainternacional = plazainternacional;
	}
	public String getPais () {
	    return pais;
	    }
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getClavesiacinst () {
	    return clavesiacinst;
	    }
	public void setClavesiacinst(String clavesiacinst) {
		this.clavesiacinst = clavesiacinst;
	}
	public String getConveniociedie () {
	    return conveniociedie;
	    }
	public void setConveniociedie(String conveniociedie) {
		this.conveniociedie = conveniociedie;
	}
	public String getEstatus () {
	    return estatus;
	    }
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getClabe () {
	    return clabe;
	    }
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}
	public String getFechavence () {
	    return fechavence;
	    }
	public void setFechavence(String fechavence) {
		this.fechavence = fechavence;
	}
	public String getNumabbasswift () {
	    return numabbasswift;
	    }
	public void setNumabbasswift(String numabbasswift) {
		this.numabbasswift = numabbasswift;
	}
	public String getConceptosiac () {
	    return conceptosiac;
	    }
	public void setConceptosiac(String conceptosiac) {
		this.conceptosiac = conceptosiac;
	}
	public String getRefciedie () {
	    return refciedie;
	    }
	public void setRefciedie(String refciedie) {
		this.refciedie = refciedie;
	}
	public String getAutorizacion () {
	    return autorizacion;
	    }
	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}
}		
