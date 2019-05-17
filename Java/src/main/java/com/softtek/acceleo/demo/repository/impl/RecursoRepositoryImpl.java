/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los recurso. 
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
import com.softtek.acceleo.demo.domain.Recurso;
import com.softtek.acceleo.demo.repository.RecursoRepository;

/**
 * Clase recursoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("recursoRepository")
public class RecursoRepositoryImpl implements RecursoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un recurso.
	 */
	public void addRecurso(Recurso recurso) {
		sessionFactory.getCurrentSession().persist(recurso);
	}
	/**
	 * Edita un recurso.
	 */
	public void editRecurso(Recurso recurso) {
		sessionFactory.getCurrentSession().update(recurso);
		
	}
	/**
	 * Consulta informacion de recurso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Recurso> listRecursos(Recurso recurso) {
		List<Recurso> recursos = sessionFactory.getCurrentSession().createCriteria(Recurso.class).list();
		return recursos;
	}
	
	/**
	 * Consulta informacion de recurso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Recurso> listRecursosByRecurso(Recurso recurso, int id) {
		List<Recurso> recursos = 
		sessionFactory.getCurrentSession().createCriteria(Recurso.class)
		.add(Restrictions.like("recursoId",id)).list();
		return recursos;
	}
 
	/**
	 * Consulta informacion de recurso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Recurso> listRecursosByUsername(Recurso recurso, String id) {
		List<Recurso> recursos = sessionFactory.getCurrentSession().createCriteria(Recurso.class).add(Restrictions.like("username",id)).list();
		return recursos;
	}
	
	/**
	 * Consulta informacion de recurso y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Recurso> listRecursosQuery(Recurso recurso, String query, int page, int size) {
		
		return (List<Recurso>) sessionFactory.getCurrentSession()
			.createCriteria(Recurso.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("recurso", "%" + query +"%"), 
			Restrictions.like("relacionaId", "%" + query +"%")),
			Restrictions.like("descripcionrecurso", "%" + query +"%")),
			Restrictions.like("ruta", "%" + query +"%")),
			Restrictions.like("tiporecurso", "%" + query +"%")),
			Restrictions.like("tamano", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de recurso y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Recurso> listRecursosPagination(Recurso recurso, int page, int size) {
			return (List<Recurso>) sessionFactory.getCurrentSession()
				.createCriteria(Recurso.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de recurso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Recurso.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de recurso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Recurso.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("recurso", "%" + query +"%"), 
			Restrictions.like("relacionaId", "%" + query +"%")),
			Restrictions.like("descripcionrecurso", "%" + query +"%")),
			Restrictions.like("ruta", "%" + query +"%")),
			Restrictions.like("tiporecurso", "%" + query +"%")),
			Restrictions.like("tamano", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de recurso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Recurso.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un recurso.
	 */
	public Recurso getRecurso(int empid) {
		return (Recurso) sessionFactory.getCurrentSession().get(
				Recurso.class, empid);
	}

	/**
	 * Elimina un recurso.
	 */
	public void deleteRecurso(Recurso recurso) {
		sessionFactory.getCurrentSession().delete(recurso);
	}

}

