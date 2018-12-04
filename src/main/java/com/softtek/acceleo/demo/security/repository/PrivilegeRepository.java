package com.softtek.acceleo.demo.security.repository;

import java.util.List;
import java.util.UUID;

import com.softtek.acceleo.demo.domain.Privilege;

public interface PrivilegeRepository {
	Privilege getPrivilege(UUID idPrivilege);
	
	List<Privilege> getPrivilege();
}
