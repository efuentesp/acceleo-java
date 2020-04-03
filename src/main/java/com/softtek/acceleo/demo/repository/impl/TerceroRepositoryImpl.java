/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los tercero. 
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
import com.softtek.acceleo.demo.domain.Tercero;
import com.softtek.acceleo.demo.repository.TerceroRepository;

/**
 * Clase terceroRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("terceroRepository")
public class TerceroRepositoryImpl implements TerceroRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un tercero.
	 */
	public void addTercero(Tercero tercero) {
		sessionFactory.getCurrentSession().persist(tercero);
	}
	/**
	 * Edita un tercero.
	 */
	public void editTercero(Tercero tercero) {
		sessionFactory.getCurrentSession().update(tercero);
		
	}
	/**
	 * Consulta informacion de tercero.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Tercero> listTerceros(Tercero tercero) {
		List<Tercero> terceros = sessionFactory.getCurrentSession().createCriteria(Tercero.class).list();
		return terceros;
	}
	
	/**
	 * Consulta informacion de tercero.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Tercero> listTercerosByTercero(Tercero tercero, int id) {
		List<Tercero> terceros = 
		sessionFactory.getCurrentSession().createCriteria(Tercero.class)
		.add(Restrictions.like("terceroId",id)).list();
		return terceros;
	}
 
	/**
	 * Consulta informacion de tercero.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Tercero> listTercerosByUsername(Tercero tercero, String id) {
		List<Tercero> terceros = sessionFactory.getCurrentSession().createCriteria(Tercero.class).add(Restrictions.like("username",id)).list();
		return terceros;
	}
	
	/**
	 * Consulta informacion de tercero y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Tercero> listTercerosQuery(Tercero tercero, String query, int page, int size) {
		
		return (List<Tercero>) sessionFactory.getCurrentSession()
			.createCriteria(Tercero.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("tercero", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("notercero", "%" + query +"%")),
			Restrictions.like("razonsocial", "%" + query +"%")),
			Restrictions.like("nacionalidad", "%" + query +"%")),
			Restrictions.like("actividadeconomica", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("fechaverfircosoft", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("rfc", "%" + query +"%")),
			Restrictions.like("correo", "%" + query +"%")),
			Restrictions.like("calidamigratoria", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitentepaiscasa", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitentepaisoficina", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitentepaiscelular", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitenteladacasa", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitenteladaoficina", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitenteladacelular", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitentenumerocasa", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitentenumerooficina", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitentenumerocelular", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitenteextoficina", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitenteextcelular", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de tercero y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Tercero> listTercerosPagination(Tercero tercero, int page, int size) {
			return (List<Tercero>) sessionFactory.getCurrentSession()
				.createCriteria(Tercero.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de tercero consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Tercero.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de tercero consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Tercero.class).setProjection(Projections.rowCount())
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
			Restrictions.like("tercero", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("notercero", "%" + query +"%")),
			Restrictions.like("razonsocial", "%" + query +"%")),
			Restrictions.like("nacionalidad", "%" + query +"%")),
			Restrictions.like("actividadeconomica", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("fechaverfircosoft", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("rfc", "%" + query +"%")),
			Restrictions.like("correo", "%" + query +"%")),
			Restrictions.like("calidamigratoria", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitentepaiscasa", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitentepaisoficina", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitentepaiscelular", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitenteladacasa", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitenteladaoficina", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitenteladacelular", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitentenumerocasa", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitentenumerooficina", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitentenumerocelular", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitenteextoficina", "%" + query +"%")),
			Restrictions.like("telefonosfideicomitenteextcelular", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de tercero consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Tercero.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un tercero.
	 */
	public Tercero getTercero(UUID empid) {
		return (Tercero) sessionFactory.getCurrentSession().get(
				Tercero.class, empid);
	}

	/**
	 * Elimina un tercero.
	 */
	public void deleteTercero(Tercero tercero) {
		sessionFactory.getCurrentSession().delete(tercero);
	}

}

