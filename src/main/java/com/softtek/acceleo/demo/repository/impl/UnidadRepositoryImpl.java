/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los unidad. 
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
import com.softtek.acceleo.demo.domain.Unidad;
import com.softtek.acceleo.demo.repository.UnidadRepository;

/**
 * Clase unidadRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("unidadRepository")
public class UnidadRepositoryImpl implements UnidadRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un unidad.
	 */
	public void addUnidad(Unidad unidad) {
		sessionFactory.getCurrentSession().persist(unidad);
	}
	/**
	 * Edita un unidad.
	 */
	public void editUnidad(Unidad unidad) {
		sessionFactory.getCurrentSession().update(unidad);
		
	}
	/**
	 * Consulta informacion de unidad.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Unidad> listUnidads(Unidad unidad) {
		List<Unidad> unidads = sessionFactory.getCurrentSession().createCriteria(Unidad.class).list();
		return unidads;
	}
	
	/**
	 * Consulta informacion de unidad.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Unidad> listUnidadsByUnidad(Unidad unidad, int id) {
		List<Unidad> unidads = 
		sessionFactory.getCurrentSession().createCriteria(Unidad.class)
		.add(Restrictions.like("unidadId",id)).list();
		return unidads;
	}
 
	/**
	 * Consulta informacion de unidad.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Unidad> listUnidadsByUsername(Unidad unidad, String id) {
		List<Unidad> unidads = sessionFactory.getCurrentSession().createCriteria(Unidad.class).add(Restrictions.like("username",id)).list();
		return unidads;
	}
	
	/**
	 * Consulta informacion de unidad y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Unidad> listUnidadsQuery(Unidad unidad, String query, int page, int size) {
		
		return (List<Unidad>) sessionFactory.getCurrentSession()
			.createCriteria(Unidad.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("unidad", "%" + query +"%"), 
			Restrictions.like("competeId", "%" + query +"%")),
			Restrictions.like("nombreunidad", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de unidad y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Unidad> listUnidadsPagination(Unidad unidad, int page, int size) {
			return (List<Unidad>) sessionFactory.getCurrentSession()
				.createCriteria(Unidad.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de unidad consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Unidad.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de unidad consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Unidad.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("unidad", "%" + query +"%"), 
			Restrictions.like("competeId", "%" + query +"%")),
			Restrictions.like("nombreunidad", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de unidad consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Unidad.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un unidad.
	 */
	public Unidad getUnidad(int empid) {
		return (Unidad) sessionFactory.getCurrentSession().get(
				Unidad.class, empid);
	}

	/**
	 * Elimina un unidad.
	 */
	public void deleteUnidad(Unidad unidad) {
		sessionFactory.getCurrentSession().delete(unidad);
	}

}

