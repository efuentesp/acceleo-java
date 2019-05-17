package com.softtek.acceleo.demo.domain;

import java.util.List;
import java.util.UUID;

public class ConfigPermisos {
	private UUID idGrupo;
	private String nombreGrupo;
	private UUID idPrivilege;
	private String nombrePrivilege;
	private List<ConfigAuthority> lstConfigAuthority;
	private UUID activeUser;
		
	public UUID getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(UUID idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getNombreGrupo() {
		return nombreGrupo;
	}
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}
	public UUID getIdPrivilege() {
		return idPrivilege;
	}
	public void setIdPrivilege(UUID idPrivilege) {
		this.idPrivilege = idPrivilege;
	}
	public String getNombrePrivilege() {
		return nombrePrivilege;
	}
	public void setNombrePrivilege(String nombrePrivilege) {
		this.nombrePrivilege = nombrePrivilege;
	}
	public List<ConfigAuthority> getLstConfigAuthority() {
		return lstConfigAuthority;
	}
	public void setLstConfigAuthority(List<ConfigAuthority> lstConfigAuthority) {
		this.lstConfigAuthority = lstConfigAuthority;
	}
	public UUID getActiveUser() {
		return activeUser;
	}
	public void setActiveUser(UUID activeUser) {
		this.activeUser = activeUser;
	}

}
