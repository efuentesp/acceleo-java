/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los autodeclaracioncrs. 
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
import com.softtek.acceleo.demo.domain.Autodeclaracioncrs;
import com.softtek.acceleo.demo.repository.AutodeclaracioncrsRepository;

/**
 * Clase autodeclaracioncrsRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("autodeclaracioncrsRepository")
public class AutodeclaracioncrsRepositoryImpl implements AutodeclaracioncrsRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un autodeclaracioncrs.
	 */
	public void addAutodeclaracioncrs(Autodeclaracioncrs autodeclaracioncrs) {
		sessionFactory.getCurrentSession().persist(autodeclaracioncrs);
	}
	/**
	 * Edita un autodeclaracioncrs.
	 */
	public void editAutodeclaracioncrs(Autodeclaracioncrs autodeclaracioncrs) {
		sessionFactory.getCurrentSession().update(autodeclaracioncrs);
		
	}
	/**
	 * Consulta informacion de autodeclaracioncrs.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Autodeclaracioncrs> listAutodeclaracioncrss(Autodeclaracioncrs autodeclaracioncrs) {
		List<Autodeclaracioncrs> autodeclaracioncrss = sessionFactory.getCurrentSession().createCriteria(Autodeclaracioncrs.class).list();
		return autodeclaracioncrss;
	}
	
	/**
	 * Consulta informacion de autodeclaracioncrs.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Autodeclaracioncrs> listAutodeclaracioncrssByAutodeclaracioncrs(Autodeclaracioncrs autodeclaracioncrs, int id) {
		List<Autodeclaracioncrs> autodeclaracioncrss = 
		sessionFactory.getCurrentSession().createCriteria(Autodeclaracioncrs.class)
		.add(Restrictions.like("autodeclaracioncrsId",id)).list();
		return autodeclaracioncrss;
	}
 
	/**
	 * Consulta informacion de autodeclaracioncrs.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Autodeclaracioncrs> listAutodeclaracioncrssByUsername(Autodeclaracioncrs autodeclaracioncrs, String id) {
		List<Autodeclaracioncrs> autodeclaracioncrss = sessionFactory.getCurrentSession().createCriteria(Autodeclaracioncrs.class).add(Restrictions.like("username",id)).list();
		return autodeclaracioncrss;
	}
	
	/**
	 * Consulta informacion de autodeclaracioncrs y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Autodeclaracioncrs> listAutodeclaracioncrssQuery(Autodeclaracioncrs autodeclaracioncrs, String query, int page, int size) {
		
		return (List<Autodeclaracioncrs>) sessionFactory.getCurrentSession()
			.createCriteria(Autodeclaracioncrs.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("autodeclaracioncrs", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("numero", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("tipoparticipante", "%" + query +"%")),
			Restrictions.like("formatocrs", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de autodeclaracioncrs y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Autodeclaracioncrs> listAutodeclaracioncrssPagination(Autodeclaracioncrs autodeclaracioncrs, int page, int size) {
			return (List<Autodeclaracioncrs>) sessionFactory.getCurrentSession()
				.createCriteria(Autodeclaracioncrs.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de autodeclaracioncrs consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Autodeclaracioncrs.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de autodeclaracioncrs consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Autodeclaracioncrs.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("autodeclaracioncrs", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("numero", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("tipoparticipante", "%" + query +"%")),
			Restrictions.like("formatocrs", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de autodeclaracioncrs consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Autodeclaracioncrs.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un autodeclaracioncrs.
	 */
	public Autodeclaracioncrs getAutodeclaracioncrs(UUID empid) {
		return (Autodeclaracioncrs) sessionFactory.getCurrentSession().get(
				Autodeclaracioncrs.class, empid);
	}

	/**
	 * Elimina un autodeclaracioncrs.
	 */
	public void deleteAutodeclaracioncrs(Autodeclaracioncrs autodeclaracioncrs) {
		sessionFactory.getCurrentSession().delete(autodeclaracioncrs);
	}

}

