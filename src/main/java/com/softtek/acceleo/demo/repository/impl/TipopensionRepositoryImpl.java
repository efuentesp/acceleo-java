/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los tipopension. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Tipopension;
import com.softtek.acceleo.demo.repository.TipopensionRepository;
/**
 * Clase tipopensionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("tipopensionRepository")
public class TipopensionRepositoryImpl implements TipopensionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un tipopension.
	 */
	public void addTipopension(Tipopension tipopension) {
		sessionFactory.getCurrentSession().persist(tipopension);
	}
	/**
	 * Edita un tipopension.
	 */
	public void editTipopension(Tipopension tipopension) {
		sessionFactory.getCurrentSession().update(tipopension);

	}
	/**
	 * Consulta informacion de tipopension.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Tipopension> listTipopensions(Tipopension tipopension) {

		return (List<Tipopension>) sessionFactory.getCurrentSession()
				.createCriteria(Tipopension.class).list();
	}

	/**
	 * Consulta informacion de tipopension y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Tipopension> listTipopensionsQuery(Tipopension tipopension, String query, int page, int size) {
		
		return (List<Tipopension>) sessionFactory.getCurrentSession()
			.createCriteria(Tipopension.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("clave", "%" + query +"%"),
Restrictions.like("nombre", "%" + query +"%")),
Restrictions.like("tipopension", "%" + query +"%")),
Restrictions.like("tipopension", "%" + query +"%")),
Restrictions.like("tipopension", "%" + query +"%")),
Restrictions.like("tipopension", "%" + query +"%"))
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de tipopension y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Tipopension> listTipopensionsPagination(Tipopension tipopension, int page, int size) {
			return (List<Tipopension>) sessionFactory.getCurrentSession()
				.createCriteria(Tipopension.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de tipopension consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Tipopension.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de tipopension consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Tipopension.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("clave", "%" + query +"%"),Restrictions.like("nombre", "%" + query +"%")),Restrictions.like("tipopension", "%" + query +"%")),Restrictions.like("tipopension", "%" + query +"%")),Restrictions.like("tipopension", "%" + query +"%")),Restrictions.like("tipopension", "%" + query +"%"))	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de tipopension consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Tipopension.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un tipopension.
	 */
	public Tipopension getTipopension(int empid) {
		return (Tipopension) sessionFactory.getCurrentSession().get(
				Tipopension.class, empid);
	}

	/**
	 * Elimina un tipopension.
	 */
	public void deleteTipopension(Tipopension tipopension) {
		sessionFactory.getCurrentSession().delete(tipopension);
	}

}
