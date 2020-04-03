/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los guia. 
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
import com.softtek.acceleo.demo.domain.Guia;
import com.softtek.acceleo.demo.repository.GuiaRepository;

/**
 * Clase guiaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("guiaRepository")
public class GuiaRepositoryImpl implements GuiaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un guia.
	 */
	public void addGuia(Guia guia) {
		sessionFactory.getCurrentSession().persist(guia);
	}
	/**
	 * Edita un guia.
	 */
	public void editGuia(Guia guia) {
		sessionFactory.getCurrentSession().update(guia);
		
	}
	/**
	 * Consulta informacion de guia.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Guia> listGuias(Guia guia) {
		List<Guia> guias = sessionFactory.getCurrentSession().createCriteria(Guia.class).list();
		return guias;
	}
	
	/**
	 * Consulta informacion de guia.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Guia> listGuiasByGuia(Guia guia, int id) {
		List<Guia> guias = 
		sessionFactory.getCurrentSession().createCriteria(Guia.class)
		.add(Restrictions.like("guiaId",id)).list();
		return guias;
	}
 
	/**
	 * Consulta informacion de guia.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Guia> listGuiasByUsername(Guia guia, String id) {
		List<Guia> guias = sessionFactory.getCurrentSession().createCriteria(Guia.class).add(Restrictions.like("username",id)).list();
		return guias;
	}
	
	/**
	 * Consulta informacion de guia y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Guia> listGuiasQuery(Guia guia, String query, int page, int size) {
		
		return (List<Guia>) sessionFactory.getCurrentSession()
			.createCriteria(Guia.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("guia", "%" + query +"%"), 
			Restrictions.like("transaccionId", "%" + query +"%")),
			Restrictions.like("sec", "%" + query +"%")),
			Restrictions.like("nombrecuenta", "%" + query +"%")),
			Restrictions.like("ctamayor", "%" + query +"%")),
			Restrictions.like("scta", "%" + query +"%")),
			Restrictions.like("sscta", "%" + query +"%")),
			Restrictions.like("sssctacopia", "%" + query +"%")),
			Restrictions.like("sssscta", "%" + query +"%")),
			Restrictions.like("auxiliar1", "%" + query +"%")),
			Restrictions.like("auxiliar2", "%" + query +"%")),
			Restrictions.like("auxiliar3", "%" + query +"%")),
			Restrictions.like("aplicadato", "%" + query +"%")),
			Restrictions.like("ca", "%" + query +"%")),
			Restrictions.like("descripcion", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de guia y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Guia> listGuiasPagination(Guia guia, int page, int size) {
			return (List<Guia>) sessionFactory.getCurrentSession()
				.createCriteria(Guia.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de guia consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Guia.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de guia consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Guia.class).setProjection(Projections.rowCount())
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
			Restrictions.like("guia", "%" + query +"%"), 
			Restrictions.like("transaccionId", "%" + query +"%")),
			Restrictions.like("sec", "%" + query +"%")),
			Restrictions.like("nombrecuenta", "%" + query +"%")),
			Restrictions.like("ctamayor", "%" + query +"%")),
			Restrictions.like("scta", "%" + query +"%")),
			Restrictions.like("sscta", "%" + query +"%")),
			Restrictions.like("sssctacopia", "%" + query +"%")),
			Restrictions.like("sssscta", "%" + query +"%")),
			Restrictions.like("auxiliar1", "%" + query +"%")),
			Restrictions.like("auxiliar2", "%" + query +"%")),
			Restrictions.like("auxiliar3", "%" + query +"%")),
			Restrictions.like("aplicadato", "%" + query +"%")),
			Restrictions.like("ca", "%" + query +"%")),
			Restrictions.like("descripcion", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de guia consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Guia.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un guia.
	 */
	public Guia getGuia(UUID empid) {
		return (Guia) sessionFactory.getCurrentSession().get(
				Guia.class, empid);
	}

	/**
	 * Elimina un guia.
	 */
	public void deleteGuia(Guia guia) {
		sessionFactory.getCurrentSession().delete(guia);
	}

}

