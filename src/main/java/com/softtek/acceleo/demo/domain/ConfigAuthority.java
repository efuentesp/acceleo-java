package com.softtek.acceleo.demo.domain;

import java.util.UUID;

/**
 * Clase para almacenar la configuracion de los authority.
 * @author javier.perezb
 *
 */
public class ConfigAuthority {
	private UUID idAuthority;
	private String nameAuthority;
	private UUID idPrivilege;
	private Boolean enabled;
	
	public UUID getIdAuthority() {
		return idAuthority;
	}
	public void setIdAuthority(UUID idAuthority) {
		this.idAuthority = idAuthority;
	}
	public String getNameAuthority() {
		return nameAuthority;
	}
	public void setNameAuthority(String nameAuthority) {
		this.nameAuthority = nameAuthority;
	}	
	public UUID getIdPrivilege() {
		return idPrivilege;
	}
	public void setIdPrivilege(UUID idPrivilege) {
		this.idPrivilege = idPrivilege;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
}
