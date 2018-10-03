/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los direccion. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Direccion;
import com.softtek.acceleo.demo.repository.DireccionRepository;
/**
 * Clase direccionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("direccionRepository")
public class DireccionRepositoryImpl implements DireccionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un direccion.
	 */
	public void addDireccion(Direccion direccion) {
		sessionFactory.getCurrentSession().persist(direccion);
	}
	/**
	 * Edita un direccion.
	 */
	public void editDireccion(Direccion direccion) {
		sessionFactory.getCurrentSession().update(direccion);

	}
	/**
	 * Consulta informacion de direccion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Direccion> listDireccions(Direccion direccion) {

		return (List<Direccion>) sessionFactory.getCurrentSession()
				.createCriteria(Direccion.class).list();
	}

	/**
	 * Consulta informacion de direccion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Direccion> listDireccionsQuery(Direccion direccion, String query, int page, int size) {
		
		return (List<Direccion>) sessionFactory.getCurrentSession()
			.createCriteria(Direccion.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("direccion", "%" + query +"%"),
Restrictions.like("numero", "%" + query +"%")),
Restrictions.like("direccion", "%" + query +"%")),
Restrictions.like("calle", "%" + query +"%")),
Restrictions.like("direccion", "%" + query +"%")),
Restrictions.like("direccion", "%" + query +"%"))
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de direccion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Direccion> listDireccionsPagination(Direccion direccion, int page, int size) {
			return (List<Direccion>) sessionFactory.getCurrentSession()
				.createCriteria(Direccion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de direccion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Direccion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de direccion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Direccion.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("direccion", "%" + query +"%"),Restrictions.like("numero", "%" + query +"%")),Restrictions.like("direccion", "%" + query +"%")),Restrictions.like("calle", "%" + query +"%")),Restrictions.like("direccion", "%" + query +"%")),Restrictions.like("direccion", "%" + query +"%"))	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de direccion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Direccion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un direccion.
	 */
	public Direccion getDireccion(int empid) {
		return (Direccion) sessionFactory.getCurrentSession().get(
				Direccion.class, empid);
	}

	/**
	 * Elimina un direccion.
	 */
	public void deleteDireccion(Direccion direccion) {
		sessionFactory.getCurrentSession().delete(direccion);
	}

}
