/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los institucion. 
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
import com.softtek.acceleo.demo.domain.Institucion;
import com.softtek.acceleo.demo.repository.InstitucionRepository;

/**
 * Clase institucionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("institucionRepository")
public class InstitucionRepositoryImpl implements InstitucionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un institucion.
	 */
	public void addInstitucion(Institucion institucion) {
		sessionFactory.getCurrentSession().persist(institucion);
	}
	/**
	 * Edita un institucion.
	 */
	public void editInstitucion(Institucion institucion) {
		sessionFactory.getCurrentSession().update(institucion);
		
	}
	/**
	 * Consulta informacion de institucion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Institucion> listInstitucions(Institucion institucion) {
		List<Institucion> institucions = sessionFactory.getCurrentSession().createCriteria(Institucion.class).list();
		return institucions;
	}
	
	/**
	 * Consulta informacion de institucion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Institucion> listInstitucionsByInstitucion(Institucion institucion, int id) {
		List<Institucion> institucions = 
		sessionFactory.getCurrentSession().createCriteria(Institucion.class)
		.add(Restrictions.like("institucionId",id)).list();
		return institucions;
	}
 
	/**
	 * Consulta informacion de institucion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Institucion> listInstitucionsByUsername(Institucion institucion, String id) {
		List<Institucion> institucions = sessionFactory.getCurrentSession().createCriteria(Institucion.class).add(Restrictions.like("username",id)).list();
		return institucions;
	}
	
	/**
	 * Consulta informacion de institucion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Institucion> listInstitucionsQuery(Institucion institucion, String query, int page, int size) {
		
		return (List<Institucion>) sessionFactory.getCurrentSession()
			.createCriteria(Institucion.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("institucion", "%" + query +"%"), 
			Restrictions.like("institucionId", "%" + query +"%")),
			Restrictions.like("claveinstitucion", "%" + query +"%")),
			Restrictions.like("nombreinstitucion", "%" + query +"%")),
			Restrictions.like("representante", "%" + query +"%")),
			Restrictions.like("paginaweb", "%" + query +"%")),
			Restrictions.like("telefono", "%" + query +"%")),
			Restrictions.like("tipoestatus", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de institucion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Institucion> listInstitucionsPagination(Institucion institucion, int page, int size) {
			return (List<Institucion>) sessionFactory.getCurrentSession()
				.createCriteria(Institucion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de institucion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Institucion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de institucion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Institucion.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("institucion", "%" + query +"%"), 
			Restrictions.like("institucionId", "%" + query +"%")),
			Restrictions.like("claveinstitucion", "%" + query +"%")),
			Restrictions.like("nombreinstitucion", "%" + query +"%")),
			Restrictions.like("representante", "%" + query +"%")),
			Restrictions.like("paginaweb", "%" + query +"%")),
			Restrictions.like("telefono", "%" + query +"%")),
			Restrictions.like("tipoestatus", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de institucion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Institucion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un institucion.
	 */
	public Institucion getInstitucion(int empid) {
		return (Institucion) sessionFactory.getCurrentSession().get(
				Institucion.class, empid);
	}

	/**
	 * Elimina un institucion.
	 */
	public void deleteInstitucion(Institucion institucion) {
		sessionFactory.getCurrentSession().delete(institucion);
	}

}

