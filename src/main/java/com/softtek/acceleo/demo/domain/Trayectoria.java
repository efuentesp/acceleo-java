package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
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
	
	@OneToOne
	@JoinColumn(name="candidatoId")
	private Candidato candidato;
	
	@OneToOne
	@JoinColumn(name="documentoId")
	private Documento documento;
	
	@NotNull
	@Column(name = "tipotrayectoriaId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipotrayectoria tipotrayectoriaId;

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
	
	public Tipotrayectoria getTipotrayectoriaId () {
	    return tipotrayectoriaId;  		
    }
	public void setTipotrayectoriaId (Tipotrayectoria tipotrayectoriaId) {
		this.tipotrayectoriaId = tipotrayectoriaId;
	}
	
	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

}			
