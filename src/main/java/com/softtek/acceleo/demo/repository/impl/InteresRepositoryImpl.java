/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los interes. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Interes;
import com.softtek.acceleo.demo.repository.InteresRepository;
/**
 * Clase interesRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("interesRepository")
public class InteresRepositoryImpl implements InteresRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un interes.
	 */
	public void addInteres(Interes interes) {
		sessionFactory.getCurrentSession().persist(interes);
	}
	/**
	 * Edita un interes.
	 */
	public void editInteres(Interes interes) {
		sessionFactory.getCurrentSession().update(interes);

	}
	/**
	 * Consulta informacion de interes.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Interes> listInteress(Interes interes) {

		return (List<Interes>) sessionFactory.getCurrentSession()
				.createCriteria(Interes.class).list();
	}

	/**
	 * Consulta informacion de interes y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Interes> listInteressQuery(Interes interes, String query, int page, int size) {
		
		return (List<Interes>) sessionFactory.getCurrentSession()
			.createCriteria(Interes.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("fecha", "%" + query +"%"),
Restrictions.like("interes", "%" + query +"%")),
Restrictions.like("para", "%" + query +"%")),
Restrictions.like("interes", "%" + query +"%")),
Restrictions.like("interes", "%" + query +"%")),
Restrictions.like("interes", "%" + query +"%")),
Restrictions.like("monto", "%" + query +"%")),
Restrictions.like("interes", "%" + query +"%"))
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de interes y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Interes> listInteressPagination(Interes interes, int page, int size) {
			return (List<Interes>) sessionFactory.getCurrentSession()
				.createCriteria(Interes.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de interes consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Interes.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de interes consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Interes.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("fecha", "%" + query +"%"),Restrictions.like("interes", "%" + query +"%")),Restrictions.like("para", "%" + query +"%")),Restrictions.like("interes", "%" + query +"%")),Restrictions.like("interes", "%" + query +"%")),Restrictions.like("interes", "%" + query +"%")),Restrictions.like("monto", "%" + query +"%")),Restrictions.like("interes", "%" + query +"%"))	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de interes consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Interes.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un interes.
	 */
	public Interes getInteres(int empid) {
		return (Interes) sessionFactory.getCurrentSession().get(
				Interes.class, empid);
	}

	/**
	 * Elimina un interes.
	 */
	public void deleteInteres(Interes interes) {
		sessionFactory.getCurrentSession().delete(interes);
	}

}
