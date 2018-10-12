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
@Table(name = "trayectoria")
public class Trayectoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trayectoriaId")
	private Integer  trayectoriaId;


	@NotNull
	@Column(name = "clave") 
	private String clave;
	@NotNull
	@Column(name = "descripcion") 
	private String descripcion;


	@NotNull
	@Column(name = "candidatoId") 
	private Integer candidatoId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="candidatoId")
//	@IndexColumn(name="idx")
//	private List<CandidatoId> candidatoList;
	@NotNull
	@Column(name = "tipotrayectoriaId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipotrayectoria tipotrayectoriaId;
	@NotNull
	@Column(name = "documentoId") 
	private Integer documentoId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="documentoId")
//	@IndexColumn(name="idx")
//	private List<DocumentoId> documentoList;

	public Integer getTrayectoriaId() {
		return trayectoriaId;
	}

	public void setTrayectoriaId(Integer trayectoriaId) {
		this.trayectoriaId = trayectoriaId;
	}

	
	public String getClave () {
	    return clave;  		
    }
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getDescripcion () {
	    return descripcion;  		
    }
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	//public List<Candidato> getCandidatoList () {
	//    return candidatoList;  		
    //}
	//public void setCandidatoList (List<Candidato> candidatoList) {
	//	this.candidatoList = candidatoList;
	//}
	public Integer getCandidatoId () {
	    return candidatoId;  		
    }
	public void setCandidatoId (Integer candidatoId) {
		this.candidatoId = candidatoId;
	}
	public Tipotrayectoria getTipotrayectoriaId () {
	    return tipotrayectoriaId;  		
    }
	public void setTipotrayectoriaId (Tipotrayectoria tipotrayectoriaId) {
		this.tipotrayectoriaId = tipotrayectoriaId;
	}
	//public List<Documento> getDocumentoList () {
	//    return documentoList;  		
    //}
	//public void setDocumentoList (List<Documento> documentoList) {
	//	this.documentoList = documentoList;
	//}
	public Integer getDocumentoId () {
	    return documentoId;  		
    }
	public void setDocumentoId (Integer documentoId) {
		this.documentoId = documentoId;
	}

}			
