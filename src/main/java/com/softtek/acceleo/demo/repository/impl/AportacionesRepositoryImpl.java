/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los aportaciones. 
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
import com.softtek.acceleo.demo.domain.Aportaciones;
import com.softtek.acceleo.demo.repository.AportacionesRepository;

/**
 * Clase aportacionesRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("aportacionesRepository")
public class AportacionesRepositoryImpl implements AportacionesRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un aportaciones.
	 */
	public void addAportaciones(Aportaciones aportaciones) {
		sessionFactory.getCurrentSession().persist(aportaciones);
	}
	/**
	 * Edita un aportaciones.
	 */
	public void editAportaciones(Aportaciones aportaciones) {
		sessionFactory.getCurrentSession().update(aportaciones);
		
	}
	/**
	 * Consulta informacion de aportaciones.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Aportaciones> listAportacioness(Aportaciones aportaciones) {
		List<Aportaciones> aportacioness = sessionFactory.getCurrentSession().createCriteria(Aportaciones.class).list();
		return aportacioness;
	}
	
	/**
	 * Consulta informacion de aportaciones.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Aportaciones> listAportacionessByAportaciones(Aportaciones aportaciones, int id) {
		List<Aportaciones> aportacioness = 
		sessionFactory.getCurrentSession().createCriteria(Aportaciones.class)
		.add(Restrictions.like("aportacionesId",id)).list();
		return aportacioness;
	}
 
	/**
	 * Consulta informacion de aportaciones.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Aportaciones> listAportacionessByUsername(Aportaciones aportaciones, String id) {
		List<Aportaciones> aportacioness = sessionFactory.getCurrentSession().createCriteria(Aportaciones.class).add(Restrictions.like("username",id)).list();
		return aportacioness;
	}
	
	/**
	 * Consulta informacion de aportaciones y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Aportaciones> listAportacionessQuery(Aportaciones aportaciones, String query, int page, int size) {
		
		return (List<Aportaciones>) sessionFactory.getCurrentSession()
			.createCriteria(Aportaciones.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("aportaciones", "%" + query +"%"), 
			Restrictions.like("instruccionId", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("totalimporte", "%" + query +"%")),
			Restrictions.like("destinorecepcion", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("formarecepcion", "%" + query +"%")),
			Restrictions.like("estatusoperacion", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("fechacontabilizacion", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("descripcioncomplementaria", "%" + query +"%")),
			Restrictions.like("nombrefideicomiso", "%" + query +"%")),
			Restrictions.like("eventos", "%" + query +"%")),
			Restrictions.like("totalaplicado", "%" + query +"%")),
			Restrictions.like("importerecepcion", "%" + query +"%")),
			Restrictions.like("origenrecursos", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de aportaciones y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Aportaciones> listAportacionessPagination(Aportaciones aportaciones, int page, int size) {
			return (List<Aportaciones>) sessionFactory.getCurrentSession()
				.createCriteria(Aportaciones.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de aportaciones consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Aportaciones.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de aportaciones consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Aportaciones.class).setProjection(Projections.rowCount())
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
			Restrictions.like("aportaciones", "%" + query +"%"), 
			Restrictions.like("instruccionId", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("totalimporte", "%" + query +"%")),
			Restrictions.like("destinorecepcion", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("formarecepcion", "%" + query +"%")),
			Restrictions.like("estatusoperacion", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("fechacontabilizacion", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("descripcioncomplementaria", "%" + query +"%")),
			Restrictions.like("nombrefideicomiso", "%" + query +"%")),
			Restrictions.like("eventos", "%" + query +"%")),
			Restrictions.like("totalaplicado", "%" + query +"%")),
			Restrictions.like("importerecepcion", "%" + query +"%")),
			Restrictions.like("origenrecursos", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de aportaciones consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Aportaciones.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un aportaciones.
	 */
	public Aportaciones getAportaciones(UUID empid) {
		return (Aportaciones) sessionFactory.getCurrentSession().get(
				Aportaciones.class, empid);
	}

	/**
	 * Elimina un aportaciones.
	 */
	public void deleteAportaciones(Aportaciones aportaciones) {
		sessionFactory.getCurrentSession().delete(aportaciones);
	}

}

