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
@Table(name = "parametroscomisiones")
public class Parametroscomisiones implements Serializable {

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
	@Column(name = "parametroscomisionesId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  parametroscomisionesId;		

	@NotNull
	private UUID fideicomisoId;
	@NotNull
	private String tipocalculo;
	@NotNull
	private String aquiensecobra;
	@NotNull
	@Column(name = "montoaceptacion")
	private Double montoaceptacion;
	
	@NotNull
	@Column(name = "importeanualizado")
	private String importeanualizado;
	
	@NotNull
	private String periodicidad;
	@NotNull
	@Column(name = "calculoaldiaprimero")
	private String calculoaldiaprimero;
	
	@NotNull
	private String reevaluacion;
	@NotNull
	@Column(name = "fechaconstitucion")
	private Date fechaconstitucion;
	
	@NotNull
	@Column(name = "fechapivote")
	private Date fechapivote;
	
	@NotNull
	@Column(name = "fechaproxcalculo")
	private Date fechaproxcalculo;
	
	@NotNull
	@Column(name = "metodopago")
	private String metodopago;
	
	@NotNull
	@Column(name = "aquienfactura")
	private String aquienfactura;
	
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "comentario")
	private String comentario;
	
	@NotNull
	private String estatus;
	@NotNull
	@Column(name = "penasconvencionales")
	private String penasconvencionales;
	
	@NotNull
	private String interes;
	@NotNull
	private String tipoiva;
	@NotNull
	@Column(name = "diacorte")
	private Integer diacorte;
	
	@NotNull
	@Column(name = "fechaprimercalculo")
	private Date fechaprimercalculo;
	
	@NotNull
	@Column(name = "fechaultimocalculo")
	private Date fechaultimocalculo;
	
	@NotNull
	@Column(name = "cuentapago")
	private String cuentapago;
	
	@NotNull
	@Column(name = "numero")
	private String numero;
	
	@NotNull
	private String situacionmorosidad;

	public UUID getParametroscomisionesId() {
		return parametroscomisionesId;
	}

	public void setParametroscomisionesId(UUID parametroscomisionesId) {
		this.parametroscomisionesId = parametroscomisionesId;
	}
	
	public UUID getFideicomisoId () {
	    return fideicomisoId;
	    }
	public void setFideicomiso(UUID fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getTipocalculo () {
	    return tipocalculo;
	    }
	public void setTipocalculo(String tipocalculo) {
		this.tipocalculo = tipocalculo;
	}
	public String getAquiensecobra () {
	    return aquiensecobra;
	    }
	public void setAquiensecobra(String aquiensecobra) {
		this.aquiensecobra = aquiensecobra;
	}
	public Double getMontoaceptacion () {
	    return montoaceptacion;
	    }
	public void setMontoaceptacion(Double montoaceptacion) {
		this.montoaceptacion = montoaceptacion;
	}
	public String getImporteanualizado () {
	    return importeanualizado;
	    }
	public void setImporteanualizado(String importeanualizado) {
		this.importeanualizado = importeanualizado;
	}
	public String getPeriodicidad () {
	    return periodicidad;
	    }
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}
	public String getCalculoaldiaprimero () {
	    return calculoaldiaprimero;
	    }
	public void setCalculoaldiaprimero(String calculoaldiaprimero) {
		this.calculoaldiaprimero = calculoaldiaprimero;
	}
	public String getReevaluacion () {
	    return reevaluacion;
	    }
	public void setReevaluacion(String reevaluacion) {
		this.reevaluacion = reevaluacion;
	}
	public Date getFechaconstitucion () {
	    return fechaconstitucion;
	    }
	public void setFechaconstitucion(Date fechaconstitucion) {
		this.fechaconstitucion = fechaconstitucion;
	}
	public Date getFechapivote () {
	    return fechapivote;
	    }
	public void setFechapivote(Date fechapivote) {
		this.fechapivote = fechapivote;
	}
	public Date getFechaproxcalculo () {
	    return fechaproxcalculo;
	    }
	public void setFechaproxcalculo(Date fechaproxcalculo) {
		this.fechaproxcalculo = fechaproxcalculo;
	}
	public String getMetodopago () {
	    return metodopago;
	    }
	public void setMetodopago(String metodopago) {
		this.metodopago = metodopago;
	}
	public String getAquienfactura () {
	    return aquienfactura;
	    }
	public void setAquienfactura(String aquienfactura) {
		this.aquienfactura = aquienfactura;
	}
	public String getNombre () {
	    return nombre;
	    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getComentario () {
	    return comentario;
	    }
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}	
	public String getEstatus () {
	    return estatus;
	    }
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getPenasconvencionales () {
	    return penasconvencionales;
	    }
	public void setPenasconvencionales(String penasconvencionales) {
		this.penasconvencionales = penasconvencionales;
	}
	public String getInteres () {
	    return interes;
	    }
	public void setInteres(String interes) {
		this.interes = interes;
	}
	public String getTipoiva () {
	    return tipoiva;
	    }
	public void setTipoiva(String tipoiva) {
		this.tipoiva = tipoiva;
	}
	public Integer getDiacorte () {
	    return diacorte;
	    }
	public void setDiacorte(Integer diacorte) {
		this.diacorte = diacorte;
	}	
	public Date getFechaprimercalculo () {
	    return fechaprimercalculo;
	    }
	public void setFechaprimercalculo(Date fechaprimercalculo) {
		this.fechaprimercalculo = fechaprimercalculo;
	}
	public Date getFechaultimocalculo () {
	    return fechaultimocalculo;
	    }
	public void setFechaultimocalculo(Date fechaultimocalculo) {
		this.fechaultimocalculo = fechaultimocalculo;
	}
	public String getCuentapago () {
	    return cuentapago;
	    }
	public void setCuentapago(String cuentapago) {
		this.cuentapago = cuentapago;
	}
	public String getNumero () {
	    return numero;
	    }
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getSituacionmorosidad () {
	    return situacionmorosidad;
	    }
	public void setSituacionmorosidad(String situacionmorosidad) {
		this.situacionmorosidad = situacionmorosidad;
	}
}		
