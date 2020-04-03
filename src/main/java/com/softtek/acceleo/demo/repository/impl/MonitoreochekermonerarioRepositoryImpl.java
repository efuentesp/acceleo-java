/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los monitoreochekermonerario. 
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
import com.softtek.acceleo.demo.domain.Monitoreochekermonerario;
import com.softtek.acceleo.demo.repository.MonitoreochekermonerarioRepository;

/**
 * Clase monitoreochekermonerarioRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("monitoreochekermonerarioRepository")
public class MonitoreochekermonerarioRepositoryImpl implements MonitoreochekermonerarioRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un monitoreochekermonerario.
	 */
	public void addMonitoreochekermonerario(Monitoreochekermonerario monitoreochekermonerario) {
		sessionFactory.getCurrentSession().persist(monitoreochekermonerario);
	}
	/**
	 * Edita un monitoreochekermonerario.
	 */
	public void editMonitoreochekermonerario(Monitoreochekermonerario monitoreochekermonerario) {
		sessionFactory.getCurrentSession().update(monitoreochekermonerario);
		
	}
	/**
	 * Consulta informacion de monitoreochekermonerario.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Monitoreochekermonerario> listMonitoreochekermonerarios(Monitoreochekermonerario monitoreochekermonerario) {
		List<Monitoreochekermonerario> monitoreochekermonerarios = sessionFactory.getCurrentSession().createCriteria(Monitoreochekermonerario.class).list();
		return monitoreochekermonerarios;
	}
	
	/**
	 * Consulta informacion de monitoreochekermonerario.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Monitoreochekermonerario> listMonitoreochekermonerariosByMonitoreochekermonerario(Monitoreochekermonerario monitoreochekermonerario, int id) {
		List<Monitoreochekermonerario> monitoreochekermonerarios = 
		sessionFactory.getCurrentSession().createCriteria(Monitoreochekermonerario.class)
		.add(Restrictions.like("monitoreochekermonerarioId",id)).list();
		return monitoreochekermonerarios;
	}
 
	/**
	 * Consulta informacion de monitoreochekermonerario.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Monitoreochekermonerario> listMonitoreochekermonerariosByUsername(Monitoreochekermonerario monitoreochekermonerario, String id) {
		List<Monitoreochekermonerario> monitoreochekermonerarios = sessionFactory.getCurrentSession().createCriteria(Monitoreochekermonerario.class).add(Restrictions.like("username",id)).list();
		return monitoreochekermonerarios;
	}
	
	/**
	 * Consulta informacion de monitoreochekermonerario y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Monitoreochekermonerario> listMonitoreochekermonerariosQuery(Monitoreochekermonerario monitoreochekermonerario, String query, int page, int size) {
		
		return (List<Monitoreochekermonerario>) sessionFactory.getCurrentSession()
			.createCriteria(Monitoreochekermonerario.class).setFirstResult((page - 1) * size)
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
			Restrictions.or(
			Restrictions.like("monitoreochekermonerario", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("foliooperacion", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("fechaoperacion", "%" + query +"%")),
			Restrictions.like("totalpagos", "%" + query +"%")),
			Restrictions.like("liquidados", "%" + query +"%")),
			Restrictions.like("contabilizados", "%" + query +"%")),
			Restrictions.like("pendientes", "%" + query +"%")),
			Restrictions.like("error", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de monitoreochekermonerario y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Monitoreochekermonerario> listMonitoreochekermonerariosPagination(Monitoreochekermonerario monitoreochekermonerario, int page, int size) {
			return (List<Monitoreochekermonerario>) sessionFactory.getCurrentSession()
				.createCriteria(Monitoreochekermonerario.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de monitoreochekermonerario consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Monitoreochekermonerario.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de monitoreochekermonerario consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Monitoreochekermonerario.class).setProjection(Projections.rowCount())
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
			Restrictions.or(
			Restrictions.like("monitoreochekermonerario", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("foliooperacion", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("fechaoperacion", "%" + query +"%")),
			Restrictions.like("totalpagos", "%" + query +"%")),
			Restrictions.like("liquidados", "%" + query +"%")),
			Restrictions.like("contabilizados", "%" + query +"%")),
			Restrictions.like("pendientes", "%" + query +"%")),
			Restrictions.like("error", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de monitoreochekermonerario consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Monitoreochekermonerario.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un monitoreochekermonerario.
	 */
	public Monitoreochekermonerario getMonitoreochekermonerario(UUID empid) {
		return (Monitoreochekermonerario) sessionFactory.getCurrentSession().get(
				Monitoreochekermonerario.class, empid);
	}

	/**
	 * Elimina un monitoreochekermonerario.
	 */
	public void deleteMonitoreochekermonerario(Monitoreochekermonerario monitoreochekermonerario) {
		sessionFactory.getCurrentSession().delete(monitoreochekermonerario);
	}

}

