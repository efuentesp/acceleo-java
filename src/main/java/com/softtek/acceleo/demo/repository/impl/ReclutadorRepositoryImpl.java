/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los reclutador. 
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
import com.softtek.acceleo.demo.domain.Reclutador;
import com.softtek.acceleo.demo.repository.ReclutadorRepository;

/**
 * Clase reclutadorRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("reclutadorRepository")
public class ReclutadorRepositoryImpl implements ReclutadorRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un reclutador.
	 */
	public void addReclutador(Reclutador reclutador) {
		sessionFactory.getCurrentSession().persist(reclutador);
	}
	/**
	 * Edita un reclutador.
	 */
	public void editReclutador(Reclutador reclutador) {
		sessionFactory.getCurrentSession().update(reclutador);
		
	}
	/**
	 * Consulta informacion de reclutador.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Reclutador> listReclutadors(Reclutador reclutador) {
		List<Reclutador> reclutadors = sessionFactory.getCurrentSession().createCriteria(Reclutador.class).list();
		return reclutadors;
	}
	
	/**
	 * Consulta informacion de reclutador.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Reclutador> listReclutadorsByReclutador(Reclutador reclutador, int id) {
		List<Reclutador> reclutadors = 
		sessionFactory.getCurrentSession().createCriteria(Reclutador.class)
		.add(Restrictions.like("reclutadorId",id)).list();
		return reclutadors;
	}
 
	/**
	 * Consulta informacion de reclutador.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Reclutador> listReclutadorsByUsername(Reclutador reclutador, String id) {
		List<Reclutador> reclutadors = sessionFactory.getCurrentSession().createCriteria(Reclutador.class).add(Restrictions.like("username",id)).list();
		return reclutadors;
	}
	
	/**
	 * Consulta informacion de reclutador y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Reclutador> listReclutadorsQuery(Reclutador reclutador, String query, int page, int size) {
		
		return (List<Reclutador>) sessionFactory.getCurrentSession()
			.createCriteria(Reclutador.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("reclutador", "%" + query +"%"), 
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("apellidopaterno", "%" + query +"%")),
			Restrictions.like("apellidomaterno", "%" + query +"%")),
			Restrictions.like("genero", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de reclutador y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Reclutador> listReclutadorsPagination(Reclutador reclutador, int page, int size) {
			return (List<Reclutador>) sessionFactory.getCurrentSession()
				.createCriteria(Reclutador.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de reclutador consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Reclutador.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de reclutador consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Reclutador.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("reclutador", "%" + query +"%"), 
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("apellidopaterno", "%" + query +"%")),
			Restrictions.like("apellidomaterno", "%" + query +"%")),
			Restrictions.like("genero", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de reclutador consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Reclutador.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un reclutador.
	 */
	public Reclutador getReclutador(UUID empid) {
		return (Reclutador) sessionFactory.getCurrentSession().get(
				Reclutador.class, empid);
	}

	/**
	 * Elimina un reclutador.
	 */
	public void deleteReclutador(Reclutador reclutador) {
		sessionFactory.getCurrentSession().delete(reclutador);
	}

}

