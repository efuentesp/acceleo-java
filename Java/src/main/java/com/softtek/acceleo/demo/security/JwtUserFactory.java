package com.softtek.acceleo.demo.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.Privilege;
import com.softtek.acceleo.demo.domain.User;

public final class JwtUserFactory {
	private static final Logger logger = Logger.getLogger(JwtUserFactory.class);
	private static final int CERO = 0; 

	private JwtUserFactory() {
	}

	public static JwtUser create(User user) {
		InfoUser infoUser = new InfoUser();
		infoUser.setUsername(user.getUserName());
		infoUser.setDisplay_name(user.getFirstname() + " " + user.getLastname());
		infoUser.setEmail(user.getEmail());
		infoUser.setUser_enabled(user.getEnabled());
		
		List<Authority> lstAuthority =  user.getAuthorities();
		Authority authority = lstAuthority.get(CERO);
		
		infoUser.setRole(authority.getName());
		infoUser.setRole_enabled(authority.getEnabled());
		
		
		return new JwtUser(user.getIdUser(), user.getUserName(), user.getFirstname(), user.getLastname(),
				user.getEmail(), user.getPassword(), user.getEnabled(),
				user.getLastPasswordResetDate(),
				infoUser, 
				mapToGrantedAuthorities(user.getAuthorities()),
				mapToJwtPermissions(user.getAuthorities()));
	}
	
	private static List<JwtPermission> mapToJwtPermissions(List<Authority> authorities){
		List<JwtPermission> lstJwtPermissions = new ArrayList<>();
		
		for( Authority authority : authorities ) {
			if( authority.getEnabled() ) {
				for( Privilege privilege : authority.getPrivileges() ) {
					JwtPermission jwtPermission = new JwtPermission();
					
					//jwtPermission.setId(privilege.getIdPrivilege());
					jwtPermission.setCode(privilege.getName());
					jwtPermission.setDescription(privilege.getName());
					
					lstJwtPermissions.add(jwtPermission);
				}
			}			
		}
		
		return lstJwtPermissions;
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
		// Barrer los autorities
		// Por cada Autority obtener privilegios
		// Y cada nombre de privilegio crear un arrglo de GrantedAuthority
		List<GrantedAuthority> listGrantedAuthority = new ArrayList<>();
		String prefijoRole = "ROLE_";

		logger.info(
				"/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");
		logger.info("Iniciando convert AUTHORITY --> PRIVILEGE:");
		for (Authority authority : authorities) {
			logger.info("JAAAAAS" + authority.getEnabled());
			//Si al obtener el rol (Authority) no esta habilitado
			//no se agregan los privilegios
			if (authority.getEnabled())
				for (Privilege privilege : authority.getPrivileges()) {
					listGrantedAuthority.add(new SimpleGrantedAuthority(prefijoRole + privilege.getName()));
					logger.info("Name: " + prefijoRole + privilege.getName());
				}
		}
		logger.info("Finalizando convert AUTHORITY --> PRIVILEGE:");
		logger.info(
				"/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");

		return listGrantedAuthority;
	}

}
