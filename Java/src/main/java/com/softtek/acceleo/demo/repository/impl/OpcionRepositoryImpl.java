/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los opcion. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.softtek.acceleo.demo.domain.Opcion;
import com.softtek.acceleo.demo.repository.OpcionRepository;

/**
 * Clase opcionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("opcionRepository")
public class OpcionRepositoryImpl implements OpcionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un opcion.
	 */
	public void addOpcion(Opcion opcion) {
		sessionFactory.getCurrentSession().persist(opcion);
	}
	/**
	 * Edita un opcion.
	 */
	public void editOpcion(Opcion opcion) {
		sessionFactory.getCurrentSession().update(opcion);
		
	}
	/**
	 * Consulta informacion de opcion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Opcion> listOpcions(Opcion opcion) {
		List<Opcion> opcions = sessionFactory.getCurrentSession().createCriteria(Opcion.class).list();
		return opcions;
	}
	
	/**
	 * Consulta informacion de opcion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Opcion> listOpcionsByOpcion(Opcion opcion, int id) {
		List<Opcion> opcions = 
		sessionFactory.getCurrentSession().createCriteria(Opcion.class)
		.add(Restrictions.like("opcionId",id)).list();
		return opcions;
	}
 
	/**
	 * Consulta informacion de opcion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Opcion> listOpcionsByUsername(Opcion opcion, String id) {
		List<Opcion> opcions = sessionFactory.getCurrentSession().createCriteria(Opcion.class).add(Restrictions.like("username",id)).list();
		return opcions;
	}
	
	/**
	 * Consulta informacion de opcion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Opcion> listOpcionsQuery(Opcion opcion, String query, int page, int size) {
		
		return (List<Opcion>) sessionFactory.getCurrentSession()
			.createCriteria(Opcion.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("opcion", "%" + query +"%"), 
			Restrictions.like("paraId", "%" + query +"%")),
			Restrictions.like("descipcionopcion", "%" + query +"%")),
			Restrictions.like("puntos", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de opcion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Opcion> listOpcionsPagination(Opcion opcion, int page, int size) {
			return (List<Opcion>) sessionFactory.getCurrentSession()
				.createCriteria(Opcion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de opcion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Opcion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de opcion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Opcion.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("opcion", "%" + query +"%"), 
			Restrictions.like("paraId", "%" + query +"%")),
			Restrictions.like("descipcionopcion", "%" + query +"%")),
			Restrictions.like("puntos", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de opcion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Opcion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un opcion.
	 */
	public Opcion getOpcion(int empid) {
		return (Opcion) sessionFactory.getCurrentSession().get(
				Opcion.class, empid);
	}

	/**
	 * Elimina un opcion.
	 */
	public void deleteOpcion(Opcion opcion) {
		sessionFactory.getCurrentSession().delete(opcion);
	}

}

