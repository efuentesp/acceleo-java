/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los evaluacionriesgos. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.softtek.acceleo.demo.domain.Evaluacionriesgos;
import com.softtek.acceleo.demo.repository.EvaluacionriesgosRepository;

/**
 * Clase evaluacionriesgosRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("evaluacionriesgosRepository")
public class EvaluacionriesgosRepositoryImpl implements EvaluacionriesgosRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un evaluacionriesgos.
	 */
	public void addEvaluacionriesgos(Evaluacionriesgos evaluacionriesgos) {
		sessionFactory.getCurrentSession().persist(evaluacionriesgos);
	}
	/**
	 * Edita un evaluacionriesgos.
	 */
	public void editEvaluacionriesgos(Evaluacionriesgos evaluacionriesgos) {
		sessionFactory.getCurrentSession().update(evaluacionriesgos);
		
	}
	/**
	 * Consulta informacion de evaluacionriesgos.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Evaluacionriesgos> listEvaluacionriesgoss(Evaluacionriesgos evaluacionriesgos) {
		List<Evaluacionriesgos> evaluacionriesgoss = sessionFactory.getCurrentSession().createCriteria(Evaluacionriesgos.class).list();
		return evaluacionriesgoss;
	}
	
	/**
	 * Consulta informacion de evaluacionriesgos.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Evaluacionriesgos> listEvaluacionriesgossByEvaluacionriesgos(Evaluacionriesgos evaluacionriesgos, int id) {
		List<Evaluacionriesgos> evaluacionriesgoss = 
		sessionFactory.getCurrentSession().createCriteria(Evaluacionriesgos.class)
		.add(Restrictions.like("evaluacionriesgosId",id)).list();
		return evaluacionriesgoss;
	}
 
	/**
	 * Consulta informacion de evaluacionriesgos.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Evaluacionriesgos> listEvaluacionriesgossByUsername(Evaluacionriesgos evaluacionriesgos, String id) {
		List<Evaluacionriesgos> evaluacionriesgoss = sessionFactory.getCurrentSession().createCriteria(Evaluacionriesgos.class).add(Restrictions.like("username",id)).list();
		return evaluacionriesgoss;
	}
	
	/**
	 * Consulta informacion de evaluacionriesgos y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Evaluacionriesgos> listEvaluacionriesgossQuery(Evaluacionriesgos evaluacionriesgos, String query, int page, int size) {
		
		return (List<Evaluacionriesgos>) sessionFactory.getCurrentSession()
			.createCriteria(Evaluacionriesgos.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("evaluacionriesgos", "%" + query +"%"), 
			Restrictions.like("campo", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("cliente", "%" + query +"%")),
			Restrictions.like("estructura", "%" + query +"%")),
			Restrictions.like("resultadofinal", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de evaluacionriesgos y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Evaluacionriesgos> listEvaluacionriesgossPagination(Evaluacionriesgos evaluacionriesgos, int page, int size) {
			return (List<Evaluacionriesgos>) sessionFactory.getCurrentSession()
				.createCriteria(Evaluacionriesgos.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de evaluacionriesgos consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Evaluacionriesgos.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de evaluacionriesgos consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Evaluacionriesgos.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("evaluacionriesgos", "%" + query +"%"), 
			Restrictions.like("campo", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("cliente", "%" + query +"%")),
			Restrictions.like("estructura", "%" + query +"%")),
			Restrictions.like("resultadofinal", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de evaluacionriesgos consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Evaluacionriesgos.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un evaluacionriesgos.
	 */
	public Evaluacionriesgos getEvaluacionriesgos(UUID empid) {
		return (Evaluacionriesgos) sessionFactory.getCurrentSession().get(
				Evaluacionriesgos.class, empid);
	}

	/**
	 * Elimina un evaluacionriesgos.
	 */
	public void deleteEvaluacionriesgos(Evaluacionriesgos evaluacionriesgos) {
		sessionFactory.getCurrentSession().delete(evaluacionriesgos);
	}

}

