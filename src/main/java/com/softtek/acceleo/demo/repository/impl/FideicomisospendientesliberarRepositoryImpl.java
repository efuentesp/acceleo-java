/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los fideicomisospendientesliberar. 
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
import com.softtek.acceleo.demo.domain.Fideicomisospendientesliberar;
import com.softtek.acceleo.demo.repository.FideicomisospendientesliberarRepository;

/**
 * Clase fideicomisospendientesliberarRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("fideicomisospendientesliberarRepository")
public class FideicomisospendientesliberarRepositoryImpl implements FideicomisospendientesliberarRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un fideicomisospendientesliberar.
	 */
	public void addFideicomisospendientesliberar(Fideicomisospendientesliberar fideicomisospendientesliberar) {
		sessionFactory.getCurrentSession().persist(fideicomisospendientesliberar);
	}
	/**
	 * Edita un fideicomisospendientesliberar.
	 */
	public void editFideicomisospendientesliberar(Fideicomisospendientesliberar fideicomisospendientesliberar) {
		sessionFactory.getCurrentSession().update(fideicomisospendientesliberar);
		
	}
	/**
	 * Consulta informacion de fideicomisospendientesliberar.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Fideicomisospendientesliberar> listFideicomisospendientesliberars(Fideicomisospendientesliberar fideicomisospendientesliberar) {
		List<Fideicomisospendientesliberar> fideicomisospendientesliberars = sessionFactory.getCurrentSession().createCriteria(Fideicomisospendientesliberar.class).list();
		return fideicomisospendientesliberars;
	}
	
	/**
	 * Consulta informacion de fideicomisospendientesliberar.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Fideicomisospendientesliberar> listFideicomisospendientesliberarsByFideicomisospendientesliberar(Fideicomisospendientesliberar fideicomisospendientesliberar, int id) {
		List<Fideicomisospendientesliberar> fideicomisospendientesliberars = 
		sessionFactory.getCurrentSession().createCriteria(Fideicomisospendientesliberar.class)
		.add(Restrictions.like("fideicomisospendientesliberarId",id)).list();
		return fideicomisospendientesliberars;
	}
 
	/**
	 * Consulta informacion de fideicomisospendientesliberar.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Fideicomisospendientesliberar> listFideicomisospendientesliberarsByUsername(Fideicomisospendientesliberar fideicomisospendientesliberar, String id) {
		List<Fideicomisospendientesliberar> fideicomisospendientesliberars = sessionFactory.getCurrentSession().createCriteria(Fideicomisospendientesliberar.class).add(Restrictions.like("username",id)).list();
		return fideicomisospendientesliberars;
	}
	
	/**
	 * Consulta informacion de fideicomisospendientesliberar y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Fideicomisospendientesliberar> listFideicomisospendientesliberarsQuery(Fideicomisospendientesliberar fideicomisospendientesliberar, String query, int page, int size) {
		
		return (List<Fideicomisospendientesliberar>) sessionFactory.getCurrentSession()
			.createCriteria(Fideicomisospendientesliberar.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("fideicomisospendientesliberar", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("nombrefiso", "%" + query +"%")),
			Restrictions.like("tiponegocio", "%" + query +"%")),
			Restrictions.like("clasifproducto", "%" + query +"%")),
			Restrictions.like("manejo", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de fideicomisospendientesliberar y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Fideicomisospendientesliberar> listFideicomisospendientesliberarsPagination(Fideicomisospendientesliberar fideicomisospendientesliberar, int page, int size) {
			return (List<Fideicomisospendientesliberar>) sessionFactory.getCurrentSession()
				.createCriteria(Fideicomisospendientesliberar.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de fideicomisospendientesliberar consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Fideicomisospendientesliberar.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de fideicomisospendientesliberar consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Fideicomisospendientesliberar.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("fideicomisospendientesliberar", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("nombrefiso", "%" + query +"%")),
			Restrictions.like("tiponegocio", "%" + query +"%")),
			Restrictions.like("clasifproducto", "%" + query +"%")),
			Restrictions.like("manejo", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de fideicomisospendientesliberar consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Fideicomisospendientesliberar.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un fideicomisospendientesliberar.
	 */
	public Fideicomisospendientesliberar getFideicomisospendientesliberar(UUID empid) {
		return (Fideicomisospendientesliberar) sessionFactory.getCurrentSession().get(
				Fideicomisospendientesliberar.class, empid);
	}

	/**
	 * Elimina un fideicomisospendientesliberar.
	 */
	public void deleteFideicomisospendientesliberar(Fideicomisospendientesliberar fideicomisospendientesliberar) {
		sessionFactory.getCurrentSession().delete(fideicomisospendientesliberar);
	}

}

