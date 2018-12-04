package com.softtek.acceleo.demo.security.repository;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.Privilege;

@Repository("privilegeRepository")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PrivilegeRepositoryImpl implements PrivilegeRepository{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Privilege> getPrivilege() {
		List<Privilege> lstPrivilege = null;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Privilege.class);
			lstPrivilege = (List<Privilege>) criteria.list();
		}catch(Exception e) {
			logger.error("Error: ", e);
		}
		
		return lstPrivilege;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Privilege getPrivilege(UUID idPrivilege) {
		Privilege privilege = null;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			privilege = (Privilege) session.get(Privilege.class, idPrivilege);
		}catch(Exception e) {
			logger.error("---->> Error: ", e);
		}
		
		return privilege;
	}
}
