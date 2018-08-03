/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los application. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Application;
import com.softtek.acceleo.demo.repository.ApplicationRepository;
/**
 * Clase applicationRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("applicationRepository")
public class ApplicationRepositoryImpl implements ApplicationRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un application.
	 */
	public void addApplication(Application application) {
		sessionFactory.getCurrentSession().persist(application);
	}
	/**
	 * Edita un application.
	 */
	public void editApplication(Application application) {
		sessionFactory.getCurrentSession().update(application);

	}
	/**
	 * Consulta informacion de application.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Application> listApplications(Application application) {

		return (List<Application>) sessionFactory.getCurrentSession()
				.createCriteria(Application.class).list();
	}

	/**
	 * Consulta informacion de application y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Application> listApplicationsQuery(Application application, String query, int page, int size) {
		
		return (List<Application>) sessionFactory.getCurrentSession()
			.createCriteria(Application.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("application", "%" + query +"%"),
Restrictions.like("application", "%" + query +"%")),
Restrictions.like("application", "%" + query +"%")),
Restrictions.like("code", "%" + query +"%")),
Restrictions.like("name", "%" + query +"%")),
Restrictions.like("application", "%" + query +"%"))
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de application y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Application> listApplicationsPagination(Application application, int page, int size) {
			return (List<Application>) sessionFactory.getCurrentSession()
				.createCriteria(Application.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de application consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Application.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de application consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Application.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("application", "%" + query +"%"),Restrictions.like("application", "%" + query +"%")),Restrictions.like("application", "%" + query +"%")),Restrictions.like("code", "%" + query +"%")),Restrictions.like("name", "%" + query +"%")),Restrictions.like("application", "%" + query +"%"))	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de application consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Application.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un application.
	 */
	public Application getApplication(int empid) {
		return (Application) sessionFactory.getCurrentSession().get(
				Application.class, empid);
	}

	/**
	 * Elimina un application.
	 */
	public void deleteApplication(Application application) {
		sessionFactory.getCurrentSession().delete(application);
	}

}
