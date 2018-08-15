/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los tasadeinteres. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Tasadeinteres;
import com.softtek.acceleo.demo.repository.TasadeinteresRepository;
/**
 * Clase tasadeinteresRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("tasadeinteresRepository")
public class TasadeinteresRepositoryImpl implements TasadeinteresRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un tasadeinteres.
	 */
	public void addTasadeinteres(Tasadeinteres tasadeinteres) {
		sessionFactory.getCurrentSession().persist(tasadeinteres);
	}
	/**
	 * Edita un tasadeinteres.
	 */
	public void editTasadeinteres(Tasadeinteres tasadeinteres) {
		sessionFactory.getCurrentSession().update(tasadeinteres);

	}
	/**
	 * Consulta informacion de tasadeinteres.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Tasadeinteres> listTasadeinteress(Tasadeinteres tasadeinteres) {

		return (List<Tasadeinteres>) sessionFactory.getCurrentSession()
				.createCriteria(Tasadeinteres.class).list();
	}

	/**
	 * Consulta informacion de tasadeinteres y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Tasadeinteres> listTasadeinteressQuery(Tasadeinteres tasadeinteres, String query, int page, int size) {
		
		return (List<Tasadeinteres>) sessionFactory.getCurrentSession()
			.createCriteria(Tasadeinteres.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("tasadeinteres", "%" + query +"%"),
Restrictions.like("fechafin", "%" + query +"%")),
Restrictions.like("fechainicio", "%" + query +"%")),
Restrictions.like("tasadeinteres", "%" + query +"%")),
Restrictions.like("para", "%" + query +"%")),
Restrictions.like("tasadeinteres", "%" + query +"%")),
Restrictions.like("tasadeinteres", "%" + query +"%")),
Restrictions.like("tasadeinteres", "%" + query +"%")),
Restrictions.like("tasa", "%" + query +"%"))
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de tasadeinteres y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Tasadeinteres> listTasadeinteressPagination(Tasadeinteres tasadeinteres, int page, int size) {
			return (List<Tasadeinteres>) sessionFactory.getCurrentSession()
				.createCriteria(Tasadeinteres.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de tasadeinteres consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Tasadeinteres.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de tasadeinteres consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Tasadeinteres.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("tasadeinteres", "%" + query +"%"),Restrictions.like("fechafin", "%" + query +"%")),Restrictions.like("fechainicio", "%" + query +"%")),Restrictions.like("tasadeinteres", "%" + query +"%")),Restrictions.like("para", "%" + query +"%")),Restrictions.like("tasadeinteres", "%" + query +"%")),Restrictions.like("tasadeinteres", "%" + query +"%")),Restrictions.like("tasadeinteres", "%" + query +"%")),Restrictions.like("tasa", "%" + query +"%"))	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de tasadeinteres consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Tasadeinteres.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un tasadeinteres.
	 */
	public Tasadeinteres getTasadeinteres(int empid) {
		return (Tasadeinteres) sessionFactory.getCurrentSession().get(
				Tasadeinteres.class, empid);
	}

	/**
	 * Elimina un tasadeinteres.
	 */
	public void deleteTasadeinteres(Tasadeinteres tasadeinteres) {
		sessionFactory.getCurrentSession().delete(tasadeinteres);
	}

}
