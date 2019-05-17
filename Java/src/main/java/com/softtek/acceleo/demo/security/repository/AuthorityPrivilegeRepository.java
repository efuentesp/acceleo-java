package com.softtek.acceleo.demo.security.repository;

import java.util.List;
import java.util.UUID;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.AuthorityPrivilege;
import com.softtek.acceleo.demo.domain.Privilege;

public interface AuthorityPrivilegeRepository {

	AuthorityPrivilege getAuthorityPrivilege(AuthorityPrivilege authorityPrivilege);
		
	List<AuthorityPrivilege> getAuthorityPrivilege();
	
	List<AuthorityPrivilege> getAuthorityPrivilegePorIdAuthority(Authority authority);
	
	List<AuthorityPrivilege> getAuthorityPrivilegePorIdPrivilege(Privilege privilege);
	
	void updateAuthorityPrivilege(AuthorityPrivilege authorityPrivilege);
	
	void updateRolePermission(AuthorityPrivilege authorityPrivilege);
	
	void insertAuthorityPrivilege(AuthorityPrivilege authorityPrivilege);
	
	void deleteAuthority(AuthorityPrivilege authorityPrivilege);
	
	void deleteAuthorities(Authority authority);
	
	AuthorityPrivilege getAuthorityPrivilege(UUID idAuthority, UUID idPrivilege );
	
}
