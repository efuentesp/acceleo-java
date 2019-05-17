/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los pregunta. 
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
import com.softtek.acceleo.demo.domain.Pregunta;
import com.softtek.acceleo.demo.repository.PreguntaRepository;

/**
 * Clase preguntaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("preguntaRepository")
public class PreguntaRepositoryImpl implements PreguntaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un pregunta.
	 */
	public void addPregunta(Pregunta pregunta) {
		sessionFactory.getCurrentSession().persist(pregunta);
	}
	/**
	 * Edita un pregunta.
	 */
	public void editPregunta(Pregunta pregunta) {
		sessionFactory.getCurrentSession().update(pregunta);
		
	}
	/**
	 * Consulta informacion de pregunta.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Pregunta> listPreguntas(Pregunta pregunta) {
		List<Pregunta> preguntas = sessionFactory.getCurrentSession().createCriteria(Pregunta.class).list();
		return preguntas;
	}
	
	/**
	 * Consulta informacion de pregunta.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Pregunta> listPreguntasByPregunta(Pregunta pregunta, int id) {
		List<Pregunta> preguntas = 
		sessionFactory.getCurrentSession().createCriteria(Pregunta.class)
		.add(Restrictions.like("preguntaId",id)).list();
		return preguntas;
	}
 
	/**
	 * Consulta informacion de pregunta.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Pregunta> listPreguntasByUsername(Pregunta pregunta, String id) {
		List<Pregunta> preguntas = sessionFactory.getCurrentSession().createCriteria(Pregunta.class).add(Restrictions.like("username",id)).list();
		return preguntas;
	}
	
	/**
	 * Consulta informacion de pregunta y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Pregunta> listPreguntasQuery(Pregunta pregunta, String query, int page, int size) {
		
		return (List<Pregunta>) sessionFactory.getCurrentSession()
			.createCriteria(Pregunta.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("pregunta", "%" + query +"%"), 
			Restrictions.like("peterneceId", "%" + query +"%")),
			Restrictions.like("descipcionpregunta", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de pregunta y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Pregunta> listPreguntasPagination(Pregunta pregunta, int page, int size) {
			return (List<Pregunta>) sessionFactory.getCurrentSession()
				.createCriteria(Pregunta.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de pregunta consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Pregunta.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de pregunta consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Pregunta.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("pregunta", "%" + query +"%"), 
			Restrictions.like("peterneceId", "%" + query +"%")),
			Restrictions.like("descipcionpregunta", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de pregunta consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Pregunta.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un pregunta.
	 */
	public Pregunta getPregunta(int empid) {
		return (Pregunta) sessionFactory.getCurrentSession().get(
				Pregunta.class, empid);
	}

	/**
	 * Elimina un pregunta.
	 */
	public void deletePregunta(Pregunta pregunta) {
		sessionFactory.getCurrentSession().delete(pregunta);
	}

}

