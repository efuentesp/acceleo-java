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
@Table(name = "publicacion")
public class Publicacion implements Serializable {

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
	@Column(name = "publicacionId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  publicacionId;		

	@NotNull
	@Column(name = "nombreobra")
	@Size(min = 100, max = 200) 
	private String nombreobra;
	
	@NotNull
	private String tiposubsistema;
	@NotNull
	private String tiponivel;
	@NotNull
	private String tipoarea;
	@NotNull
	@Column(name = "fechapublicacion")
	private Date fechapublicacion;
	
	@NotNull
	@Column(name = "autor")
	@Size(min = 100, max = 200) 
	private String autor;
	
	@NotNull
	private UUID familiarizaId;
	@NotNull
	private UUID comunicadoId;

	public UUID getPublicacionId() {
		return publicacionId;
	}

	public void setPublicacionId(UUID publicacionId) {
		this.publicacionId = publicacionId;
	}
	
	public String getNombreobra () {
	    return nombreobra;
	    }
	public void setNombreobra(String nombreobra) {
		this.nombreobra = nombreobra;
	}	
	public String getTiposubsistema () {
	    return tiposubsistema;
	    }
	public void setTiposubsistema(String tiposubsistema) {
		this.tiposubsistema = tiposubsistema;
	}
	public String getTiponivel () {
	    return tiponivel;
	    }
	public void setTiponivel(String tiponivel) {
		this.tiponivel = tiponivel;
	}
	public String getTipoarea () {
	    return tipoarea;
	    }
	public void setTipoarea(String tipoarea) {
		this.tipoarea = tipoarea;
	}
	public Date getFechapublicacion () {
	    return fechapublicacion;
	    }
	public void setFechapublicacion(Date fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}
	public String getAutor () {
	    return autor;
	    }
	public void setAutor(String autor) {
		this.autor = autor;
	}	
	public UUID getFamiliarizaId () {
	    return familiarizaId;
	    }
	public void setFamiliariza(UUID familiarizaId) {
		this.familiarizaId = familiarizaId;
	}
	public UUID getComunicadoId () {
	    return comunicadoId;
	    }
	public void setComunicado(UUID comunicadoId) {
		this.comunicadoId = comunicadoId;
	}
}		
