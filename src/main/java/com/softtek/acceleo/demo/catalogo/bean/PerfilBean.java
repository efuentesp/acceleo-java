/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Perfil.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class PerfilBean {
/**
 * Clase PerfilBean.
 * @author PSG.
 *
 */
	private Integer perfilId;

	private String nip;
	private String usuario;
	private Integer socioId;

	public Integer getPerfilId() {
		return perfilId;
	}
	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}
	public String getNip () {
	    return nip;  		
    }
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getUsuario () {
	    return usuario;  		
    }
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getSocioId () {
	    return socioId;  		
    }
	public void setSocioId (Integer socioId) {
		this.socioId = socioId;
	}


}
