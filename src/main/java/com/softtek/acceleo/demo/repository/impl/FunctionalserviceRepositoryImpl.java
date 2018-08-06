/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los functionalservice. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Functionalservice;
import com.softtek.acceleo.demo.repository.FunctionalserviceRepository;
/**
 * Clase functionalserviceRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("functionalserviceRepository")
public class FunctionalserviceRepositoryImpl implements FunctionalserviceRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un functionalservice.
	 */
	public void addFunctionalservice(Functionalservice functionalservice) {
		sessionFactory.getCurrentSession().persist(functionalservice);
	}
	/**
	 * Edita un functionalservice.
	 */
	public void editFunctionalservice(Functionalservice functionalservice) {
		sessionFactory.getCurrentSession().update(functionalservice);

	}
	/**
	 * Consulta informacion de functionalservice.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Functionalservice> listFunctionalservices(Functionalservice functionalservice) {

		return (List<Functionalservice>) sessionFactory.getCurrentSession()
				.createCriteria(Functionalservice.class).list();
	}

	/**
	 * Consulta informacion de functionalservice y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Functionalservice> listFunctionalservicesQuery(Functionalservice functionalservice, String query, int page, int size) {
		
		return (List<Functionalservice>) sessionFactory.getCurrentSession()
			.createCriteria(Functionalservice.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("functionalservice", "%" + query +"%"),
Restrictions.like("size", "%" + query +"%")),
Restrictions.like("description", "%" + query +"%")),
Restrictions.like("functionalservice", "%" + query +"%")),
Restrictions.like("menu", "%" + query +"%")),
Restrictions.like("name", "%" + query +"%")),
Restrictions.like("repository", "%" + query +"%")),
Restrictions.like("reusability", "%" + query +"%")),
Restrictions.like("functionalservice", "%" + query +"%")),
Restrictions.like("code", "%" + query +"%")),
Restrictions.like("complexity", "%" + query +"%")),
Restrictions.like("data", "%" + query +"%")),
Restrictions.like("algorithmtype", "%" + query +"%")),
Restrictions.like("repetitions", "%" + query +"%")),
Restrictions.like("functionalservice", "%" + query +"%")),
Restrictions.like("comments", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de functionalservice y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Functionalservice> listFunctionalservicesPagination(Functionalservice functionalservice, int page, int size) {
			return (List<Functionalservice>) sessionFactory.getCurrentSession()
				.createCriteria(Functionalservice.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de functionalservice consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Functionalservice.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de functionalservice consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Functionalservice.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("functionalservice", "%" + query +"%"),Restrictions.like("size", "%" + query +"%")),Restrictions.like("description", "%" + query +"%")),Restrictions.like("functionalservice", "%" + query +"%")),Restrictions.like("menu", "%" + query +"%")),Restrictions.like("name", "%" + query +"%")),Restrictions.like("repository", "%" + query +"%")),Restrictions.like("reusability", "%" + query +"%")),Restrictions.like("functionalservice", "%" + query +"%")),Restrictions.like("code", "%" + query +"%")),Restrictions.like("complexity", "%" + query +"%")),Restrictions.like("data", "%" + query +"%")),Restrictions.like("algorithmtype", "%" + query +"%")),Restrictions.like("repetitions", "%" + query +"%")),Restrictions.like("functionalservice", "%" + query +"%")),Restrictions.like("comments", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de functionalservice consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Functionalservice.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un functionalservice.
	 */
	public Functionalservice getFunctionalservice(int empid) {
		return (Functionalservice) sessionFactory.getCurrentSession().get(
				Functionalservice.class, empid);
	}

	/**
	 * Elimina un functionalservice.
	 */
	public void deleteFunctionalservice(Functionalservice functionalservice) {
		sessionFactory.getCurrentSession().delete(functionalservice);
	}

}
