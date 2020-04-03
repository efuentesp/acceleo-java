/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los honorarioadministracion. 
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
import com.softtek.acceleo.demo.domain.Honorarioadministracion;
import com.softtek.acceleo.demo.repository.HonorarioadministracionRepository;

/**
 * Clase honorarioadministracionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("honorarioadministracionRepository")
public class HonorarioadministracionRepositoryImpl implements HonorarioadministracionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un honorarioadministracion.
	 */
	public void addHonorarioadministracion(Honorarioadministracion honorarioadministracion) {
		sessionFactory.getCurrentSession().persist(honorarioadministracion);
	}
	/**
	 * Edita un honorarioadministracion.
	 */
	public void editHonorarioadministracion(Honorarioadministracion honorarioadministracion) {
		sessionFactory.getCurrentSession().update(honorarioadministracion);
		
	}
	/**
	 * Consulta informacion de honorarioadministracion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Honorarioadministracion> listHonorarioadministracions(Honorarioadministracion honorarioadministracion) {
		List<Honorarioadministracion> honorarioadministracions = sessionFactory.getCurrentSession().createCriteria(Honorarioadministracion.class).list();
		return honorarioadministracions;
	}
	
	/**
	 * Consulta informacion de honorarioadministracion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Honorarioadministracion> listHonorarioadministracionsByHonorarioadministracion(Honorarioadministracion honorarioadministracion, int id) {
		List<Honorarioadministracion> honorarioadministracions = 
		sessionFactory.getCurrentSession().createCriteria(Honorarioadministracion.class)
		.add(Restrictions.like("honorarioadministracionId",id)).list();
		return honorarioadministracions;
	}
 
	/**
	 * Consulta informacion de honorarioadministracion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Honorarioadministracion> listHonorarioadministracionsByUsername(Honorarioadministracion honorarioadministracion, String id) {
		List<Honorarioadministracion> honorarioadministracions = sessionFactory.getCurrentSession().createCriteria(Honorarioadministracion.class).add(Restrictions.like("username",id)).list();
		return honorarioadministracions;
	}
	
	/**
	 * Consulta informacion de honorarioadministracion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Honorarioadministracion> listHonorarioadministracionsQuery(Honorarioadministracion honorarioadministracion, String query, int page, int size) {
		
		return (List<Honorarioadministracion>) sessionFactory.getCurrentSession()
			.createCriteria(Honorarioadministracion.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("honorarioadministracion", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("periodo", "%" + query +"%")),
			Restrictions.like("montopatrimonio", "%" + query +"%")),
			Restrictions.like("de", "%" + query +"%")),
			Restrictions.like("destinatario", "%" + query +"%")),
			Restrictions.like("honorarioatual", "%" + query +"%")),
			Restrictions.like("cuotaminima", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de honorarioadministracion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Honorarioadministracion> listHonorarioadministracionsPagination(Honorarioadministracion honorarioadministracion, int page, int size) {
			return (List<Honorarioadministracion>) sessionFactory.getCurrentSession()
				.createCriteria(Honorarioadministracion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de honorarioadministracion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Honorarioadministracion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de honorarioadministracion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Honorarioadministracion.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("honorarioadministracion", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("periodo", "%" + query +"%")),
			Restrictions.like("montopatrimonio", "%" + query +"%")),
			Restrictions.like("de", "%" + query +"%")),
			Restrictions.like("destinatario", "%" + query +"%")),
			Restrictions.like("honorarioatual", "%" + query +"%")),
			Restrictions.like("cuotaminima", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de honorarioadministracion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Honorarioadministracion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un honorarioadministracion.
	 */
	public Honorarioadministracion getHonorarioadministracion(UUID empid) {
		return (Honorarioadministracion) sessionFactory.getCurrentSession().get(
				Honorarioadministracion.class, empid);
	}

	/**
	 * Elimina un honorarioadministracion.
	 */
	public void deleteHonorarioadministracion(Honorarioadministracion honorarioadministracion) {
		sessionFactory.getCurrentSession().delete(honorarioadministracion);
	}

}

