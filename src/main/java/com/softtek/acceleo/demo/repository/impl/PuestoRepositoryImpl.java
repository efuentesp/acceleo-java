/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los puesto. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Puesto;
import com.softtek.acceleo.demo.repository.PuestoRepository;
/**
 * Clase puestoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("puestoRepository")
public class PuestoRepositoryImpl implements PuestoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un puesto.
	 */
	public void addPuesto(Puesto puesto) {
		sessionFactory.getCurrentSession().persist(puesto);
	}
	/**
	 * Edita un puesto.
	 */
	public void editPuesto(Puesto puesto) {
		sessionFactory.getCurrentSession().update(puesto);

	}
	/**
	 * Consulta informacion de puesto.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Puesto> listPuestos(Puesto puesto) {

		return (List<Puesto>) sessionFactory.getCurrentSession()
				.createCriteria(Puesto.class).list();
	}

	/**
	 * Consulta informacion de puesto y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Puesto> listPuestosQuery(Puesto puesto, String query, int page, int size) {
		
		return (List<Puesto>) sessionFactory.getCurrentSession()
			.createCriteria(Puesto.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("puesto", "%" + query +"%"),
Restrictions.like("descripcion", "%" + query +"%")),
Restrictions.like("puesto", "%" + query +"%")),
Restrictions.like("puesto", "%" + query +"%")),
Restrictions.like("puesto", "%" + query +"%")),
Restrictions.like("nombre", "%" + query +"%")),
Restrictions.like("puesto", "%" + query +"%"))
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de puesto y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Puesto> listPuestosPagination(Puesto puesto, int page, int size) {
			return (List<Puesto>) sessionFactory.getCurrentSession()
				.createCriteria(Puesto.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de puesto consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Puesto.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de puesto consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Puesto.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("puesto", "%" + query +"%"),Restrictions.like("descripcion", "%" + query +"%")),Restrictions.like("puesto", "%" + query +"%")),Restrictions.like("puesto", "%" + query +"%")),Restrictions.like("puesto", "%" + query +"%")),Restrictions.like("nombre", "%" + query +"%")),Restrictions.like("puesto", "%" + query +"%"))	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de puesto consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Puesto.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un puesto.
	 */
	public Puesto getPuesto(int empid) {
		return (Puesto) sessionFactory.getCurrentSession().get(
				Puesto.class, empid);
	}

	/**
	 * Elimina un puesto.
	 */
	public void deletePuesto(Puesto puesto) {
		sessionFactory.getCurrentSession().delete(puesto);
	}

}
