/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los solicitud. 
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
import com.softtek.acceleo.demo.domain.Solicitud;
import com.softtek.acceleo.demo.repository.SolicitudRepository;

/**
 * Clase solicitudRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("solicitudRepository")
public class SolicitudRepositoryImpl implements SolicitudRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un solicitud.
	 */
	public void addSolicitud(Solicitud solicitud) {
		sessionFactory.getCurrentSession().persist(solicitud);
	}
	/**
	 * Edita un solicitud.
	 */
	public void editSolicitud(Solicitud solicitud) {
		sessionFactory.getCurrentSession().update(solicitud);
		
	}
	/**
	 * Consulta informacion de solicitud.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Solicitud> listSolicituds(Solicitud solicitud) {
		List<Solicitud> solicituds = sessionFactory.getCurrentSession().createCriteria(Solicitud.class).list();
		return solicituds;
	}
	
	/**
	 * Consulta informacion de solicitud.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Solicitud> listSolicitudsBySolicitud(Solicitud solicitud, int id) {
		List<Solicitud> solicituds = 
		sessionFactory.getCurrentSession().createCriteria(Solicitud.class)
		.add(Restrictions.like("solicitudId",id)).list();
		return solicituds;
	}
 
	/**
	 * Consulta informacion de solicitud.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Solicitud> listSolicitudsByUsername(Solicitud solicitud, String id) {
		List<Solicitud> solicituds = sessionFactory.getCurrentSession().createCriteria(Solicitud.class).add(Restrictions.like("username",id)).list();
		return solicituds;
	}
	
	/**
	 * Consulta informacion de solicitud y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Solicitud> listSolicitudsQuery(Solicitud solicitud, String query, int page, int size) {
		
		return (List<Solicitud>) sessionFactory.getCurrentSession()
			.createCriteria(Solicitud.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("solicitud", "%" + query +"%"), 
			Restrictions.like("posicionId", "%" + query +"%")),
			Restrictions.like("candidatoId", "%" + query +"%")),
			Restrictions.like("fecha", "%" + query +"%")),
			Restrictions.like("salario", "%" + query +"%")),
			Restrictions.like("correo", "%" + query +"%")),
			Restrictions.like("telefono", "%" + query +"%")),
			Restrictions.like("direccionId", "%" + query +"%")),
			Restrictions.like("trayectoria", "%" + query +"%")),
			Restrictions.like("estatussolicitud", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de solicitud y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Solicitud> listSolicitudsPagination(Solicitud solicitud, int page, int size) {
			return (List<Solicitud>) sessionFactory.getCurrentSession()
				.createCriteria(Solicitud.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de solicitud consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Solicitud.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de solicitud consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Solicitud.class).setProjection(Projections.rowCount())
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
			Restrictions.like("solicitud", "%" + query +"%"), 
			Restrictions.like("posicionId", "%" + query +"%")),
			Restrictions.like("candidatoId", "%" + query +"%")),
			Restrictions.like("fecha", "%" + query +"%")),
			Restrictions.like("salario", "%" + query +"%")),
			Restrictions.like("correo", "%" + query +"%")),
			Restrictions.like("telefono", "%" + query +"%")),
			Restrictions.like("direccionId", "%" + query +"%")),
			Restrictions.like("trayectoria", "%" + query +"%")),
			Restrictions.like("estatussolicitud", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de solicitud consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Solicitud.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un solicitud.
	 */
	public Solicitud getSolicitud(UUID empid) {
		return (Solicitud) sessionFactory.getCurrentSession().get(
				Solicitud.class, empid);
	}

	/**
	 * Elimina un solicitud.
	 */
	public void deleteSolicitud(Solicitud solicitud) {
		sessionFactory.getCurrentSession().delete(solicitud);
	}

}

