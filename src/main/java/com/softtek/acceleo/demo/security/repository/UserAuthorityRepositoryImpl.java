package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.AuthorityPrivilege;
import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.domain.UserAuthority;

@Repository("userAuthorityRepository")
@Transactional
public class UserAuthorityRepositoryImpl implements UserAuthorityRepository{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<UserAuthority> findByUsername(User user) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserAuthority.class);
        //criteria.add(Restrictions.eq("idUser", user)).list();
		List<UserAuthority> userAuthority = (List<UserAuthority>) criteria.list();
		
		return userAuthority;
	}


	@Override
	public List<UserAuthority> findUserAuthorityByIdAuthority(Authority authority) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserAuthority.class);
        criteria.add(Restrictions.eq("idAuthority.idAuthority", authority.getIdAuthority())).list();
		List<UserAuthority> userAuthority = (List<UserAuthority>) criteria.list();
		
		return userAuthority;
	}

	
	@Override
	public void updateUserAuthority(UserAuthority userAuthority) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.clear();
			session.flush();
			session.saveOrUpdate(userAuthority);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
/**
 * 	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateRolePermission(AuthorityPrivilege authorityPrivilege){
		Session session = sessionFactory.getCurrentSession();
		String hql = "update AuthorityPrivilege set enabled = :enabled where idAuthority.idAuthority = :idAuthority and idPrivilege.idPrivilege = :idPrivilege";
		Query query = null;
		
	    query = session.createQuery(hql);
	    query.setBoolean("enabled", authorityPrivilege.getEnabled());
	    query.setString("idAuthority", authorityPrivilege.getIdAuthority().getIdAuthority().toString());
	    query.setString("idPrivilege", authorityPrivilege.getIdPrivilege().getIdPrivilege().toString());
	    query.executeUpdate(); 			
	}	
 */

	@Override
	public void addUserAuthority(UserAuthority userAuthority) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.clear();
			session.flush();
			session.persist(userAuthority);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
//		try {
//			Session session = sessionFactory.getCurrentSession();
//			//"delete from AuthorityPrivilege where idAuthority.idAuthority = :idAuthority";
//			//String hql = "insert into UserAuthority(idUser, idAuthority, idUserAuthority, enabled) values('"+userAuthority.getIdUser().getIdUser()+"', '"+userAuthority.getIdAuthority().getIdAuthority()+"', '"+userAuthority.getIdUserAuthority()+"', "+userAuthority.getEnabled()+")";
//			String hql = "insert into UserAuthority(idUser.idUser, idAuthority.idAuthority, idUserAuthority, enabled) values(\'"+userAuthority.getIdUser().getIdUser()+"\', \'"+userAuthority.getIdAuthority().getIdAuthority()+"\', \'"+userAuthority.getIdUserAuthority()+"\', "+userAuthority.getEnabled()+")";
//			
//			Query query = null;
//			
//		    query = session.createQuery(hql);
////		    query.setString(1, userAuthority.getIdUser().getIdUser().toString());
////		    query.setString(2, userAuthority.getIdAuthority().getIdAuthority().toString());
////		    query.setString(3, userAuthority.getIdUserAuthority().toString());
////		    query.setBoolean(4, userAuthority.getEnabled());
//		    query.executeUpdate(); 			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}

	
}
