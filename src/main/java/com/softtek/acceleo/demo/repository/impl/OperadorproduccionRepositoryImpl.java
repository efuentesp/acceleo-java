/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los operadorproduccion. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Operadorproduccion;
import com.softtek.acceleo.demo.repository.OperadorproduccionRepository;
/**
 * Clase operadorproduccionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("operadorproduccionRepository")
public class OperadorproduccionRepositoryImpl implements OperadorproduccionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un operadorproduccion.
	 */
	public void addOperadorproduccion(Operadorproduccion operadorproduccion) {
		sessionFactory.getCurrentSession().persist(operadorproduccion);
	}
	/**
	 * Edita un operadorproduccion.
	 */
	public void editOperadorproduccion(Operadorproduccion operadorproduccion) {
		sessionFactory.getCurrentSession().update(operadorproduccion);

	}
	/**
	 * Consulta informacion de operadorproduccion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Operadorproduccion> listOperadorproduccions(Operadorproduccion operadorproduccion) {

		return (List<Operadorproduccion>) sessionFactory.getCurrentSession()
				.createCriteria(Operadorproduccion.class).list();
	}

	/**
	 * Consulta informacion de operadorproduccion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Operadorproduccion> listOperadorproduccionsQuery(Operadorproduccion operadorproduccion, String query, int page, int size) {
		
		return (List<Operadorproduccion>) sessionFactory.getCurrentSession()
			.createCriteria(Operadorproduccion.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("nombre", "%" + query +"%"),
Restrictions.like("operadorproduccion", "%" + query +"%")),
Restrictions.like("operadorproduccion", "%" + query +"%")),
Restrictions.like("numeroempleado", "%" + query +"%")),
Restrictions.like("operadorproduccion", "%" + query +"%")),
Restrictions.like("operadorproduccion", "%" + query +"%")),
Restrictions.like("operadorproduccion", "%" + query +"%"))
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de operadorproduccion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Operadorproduccion> listOperadorproduccionsPagination(Operadorproduccion operadorproduccion, int page, int size) {
			return (List<Operadorproduccion>) sessionFactory.getCurrentSession()
				.createCriteria(Operadorproduccion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de operadorproduccion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Operadorproduccion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de operadorproduccion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Operadorproduccion.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("nombre", "%" + query +"%"),Restrictions.like("operadorproduccion", "%" + query +"%")),Restrictions.like("operadorproduccion", "%" + query +"%")),Restrictions.like("numeroempleado", "%" + query +"%")),Restrictions.like("operadorproduccion", "%" + query +"%")),Restrictions.like("operadorproduccion", "%" + query +"%")),Restrictions.like("operadorproduccion", "%" + query +"%"))	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de operadorproduccion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Operadorproduccion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un operadorproduccion.
	 */
	public Operadorproduccion getOperadorproduccion(int empid) {
		return (Operadorproduccion) sessionFactory.getCurrentSession().get(
				Operadorproduccion.class, empid);
	}

	/**
	 * Elimina un operadorproduccion.
	 */
	public void deleteOperadorproduccion(Operadorproduccion operadorproduccion) {
		sessionFactory.getCurrentSession().delete(operadorproduccion);
	}

}
