/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los formasliquidacion. 
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
import com.softtek.acceleo.demo.domain.Formasliquidacion;
import com.softtek.acceleo.demo.repository.FormasliquidacionRepository;

/**
 * Clase formasliquidacionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("formasliquidacionRepository")
public class FormasliquidacionRepositoryImpl implements FormasliquidacionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un formasliquidacion.
	 */
	public void addFormasliquidacion(Formasliquidacion formasliquidacion) {
		sessionFactory.getCurrentSession().persist(formasliquidacion);
	}
	/**
	 * Edita un formasliquidacion.
	 */
	public void editFormasliquidacion(Formasliquidacion formasliquidacion) {
		sessionFactory.getCurrentSession().update(formasliquidacion);
		
	}
	/**
	 * Consulta informacion de formasliquidacion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Formasliquidacion> listFormasliquidacions(Formasliquidacion formasliquidacion) {
		List<Formasliquidacion> formasliquidacions = sessionFactory.getCurrentSession().createCriteria(Formasliquidacion.class).list();
		return formasliquidacions;
	}
	
	/**
	 * Consulta informacion de formasliquidacion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Formasliquidacion> listFormasliquidacionsByFormasliquidacion(Formasliquidacion formasliquidacion, int id) {
		List<Formasliquidacion> formasliquidacions = 
		sessionFactory.getCurrentSession().createCriteria(Formasliquidacion.class)
		.add(Restrictions.like("formasliquidacionId",id)).list();
		return formasliquidacions;
	}
 
	/**
	 * Consulta informacion de formasliquidacion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Formasliquidacion> listFormasliquidacionsByUsername(Formasliquidacion formasliquidacion, String id) {
		List<Formasliquidacion> formasliquidacions = sessionFactory.getCurrentSession().createCriteria(Formasliquidacion.class).add(Restrictions.like("username",id)).list();
		return formasliquidacions;
	}
	
	/**
	 * Consulta informacion de formasliquidacion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Formasliquidacion> listFormasliquidacionsQuery(Formasliquidacion formasliquidacion, String query, int page, int size) {
		
		return (List<Formasliquidacion>) sessionFactory.getCurrentSession()
			.createCriteria(Formasliquidacion.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("formasliquidacion", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("participante", "%" + query +"%")),
			Restrictions.like("tipo", "%" + query +"%")),
			Restrictions.like("fideicomisario", "%" + query +"%")),
			Restrictions.like("formaliquidacion", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("seccuentaseleccionada", "%" + query +"%")),
			Restrictions.like("plprincipal", "%" + query +"%")),
			Restrictions.like("estado", "%" + query +"%")),
			Restrictions.like("secparamliq", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de formasliquidacion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Formasliquidacion> listFormasliquidacionsPagination(Formasliquidacion formasliquidacion, int page, int size) {
			return (List<Formasliquidacion>) sessionFactory.getCurrentSession()
				.createCriteria(Formasliquidacion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de formasliquidacion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Formasliquidacion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de formasliquidacion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Formasliquidacion.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("formasliquidacion", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("participante", "%" + query +"%")),
			Restrictions.like("tipo", "%" + query +"%")),
			Restrictions.like("fideicomisario", "%" + query +"%")),
			Restrictions.like("formaliquidacion", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("seccuentaseleccionada", "%" + query +"%")),
			Restrictions.like("plprincipal", "%" + query +"%")),
			Restrictions.like("estado", "%" + query +"%")),
			Restrictions.like("secparamliq", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de formasliquidacion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Formasliquidacion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un formasliquidacion.
	 */
	public Formasliquidacion getFormasliquidacion(UUID empid) {
		return (Formasliquidacion) sessionFactory.getCurrentSession().get(
				Formasliquidacion.class, empid);
	}

	/**
	 * Elimina un formasliquidacion.
	 */
	public void deleteFormasliquidacion(Formasliquidacion formasliquidacion) {
		sessionFactory.getCurrentSession().delete(formasliquidacion);
	}

}

