/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los examen. 
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
import com.softtek.acceleo.demo.domain.Examen;
import com.softtek.acceleo.demo.repository.ExamenRepository;

/**
 * Clase examenRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("examenRepository")
public class ExamenRepositoryImpl implements ExamenRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un examen.
	 */
	public void addExamen(Examen examen) {
		sessionFactory.getCurrentSession().persist(examen);
	}
	/**
	 * Edita un examen.
	 */
	public void editExamen(Examen examen) {
		sessionFactory.getCurrentSession().update(examen);
		
	}
	/**
	 * Consulta informacion de examen.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Examen> listExamens(Examen examen) {
		List<Examen> examens = sessionFactory.getCurrentSession().createCriteria(Examen.class).list();
		return examens;
	}
	
	/**
	 * Consulta informacion de examen.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Examen> listExamensByExamen(Examen examen, int id) {
		List<Examen> examens = 
		sessionFactory.getCurrentSession().createCriteria(Examen.class)
		.add(Restrictions.like("examenId",id)).list();
		return examens;
	}
 
	/**
	 * Consulta informacion de examen.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Examen> listExamensByUsername(Examen examen, String id) {
		List<Examen> examens = sessionFactory.getCurrentSession().createCriteria(Examen.class).add(Restrictions.like("username",id)).list();
		return examens;
	}
	
	/**
	 * Consulta informacion de examen y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Examen> listExamensQuery(Examen examen, String query, int page, int size) {
		
		return (List<Examen>) sessionFactory.getCurrentSession()
			.createCriteria(Examen.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("examen", "%" + query +"%"), 
			Restrictions.like("correspondeId", "%" + query +"%")),
			Restrictions.like("nombreexamen", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de examen y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Examen> listExamensPagination(Examen examen, int page, int size) {
			return (List<Examen>) sessionFactory.getCurrentSession()
				.createCriteria(Examen.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de examen consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Examen.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de examen consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Examen.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("examen", "%" + query +"%"), 
			Restrictions.like("correspondeId", "%" + query +"%")),
			Restrictions.like("nombreexamen", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de examen consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Examen.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un examen.
	 */
	public Examen getExamen(int empid) {
		return (Examen) sessionFactory.getCurrentSession().get(
				Examen.class, empid);
	}

	/**
	 * Elimina un examen.
	 */
	public void deleteExamen(Examen examen) {
		sessionFactory.getCurrentSession().delete(examen);
	}

}

