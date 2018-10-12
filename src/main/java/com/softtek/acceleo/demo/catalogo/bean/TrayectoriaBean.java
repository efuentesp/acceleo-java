/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Trayectoria.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class TrayectoriaBean {
/**
 * Clase TrayectoriaBean.
 * @author PSG.
 *
 */
	private Integer trayectoriaId;

	private String clave;
	private String descripcion;
	private Integer candidato1Id;
	private Tipotrayectoria trayectoria1Id;
	private enum Tipotrayectoria { c,a,g,f,b,e,d}
	private Integer documento1Id;
	
	public Integer getTrayectoriaId() {
		return trayectoriaId;
	}
	public void setTrayectoriaId(Integer trayectoriaId) {
		this.trayectoriaId = trayectoriaId;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCandidato1Id() {
		return candidato1Id;
	}
	public void setCandidato1Id(Integer candidato1Id) {
		this.candidato1Id = candidato1Id;
	}
	public Tipotrayectoria getTrayectoria1Id() {
		return trayectoria1Id;
	}
	public void setTrayectoria1Id(Tipotrayectoria trayectoria1Id) {
		this.trayectoria1Id = trayectoria1Id;
	}
	public Integer getDocumento1Id() {
		return documento1Id;
	}
	public void setDocumento1Id(Integer documento1Id) {
		this.documento1Id = documento1Id;
	}

	


}
