/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los retiro. 
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
import com.softtek.acceleo.demo.domain.Retiro;
import com.softtek.acceleo.demo.repository.RetiroRepository;

/**
 * Clase retiroRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("retiroRepository")
public class RetiroRepositoryImpl implements RetiroRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un retiro.
	 */
	public void addRetiro(Retiro retiro) {
		sessionFactory.getCurrentSession().persist(retiro);
	}
	/**
	 * Edita un retiro.
	 */
	public void editRetiro(Retiro retiro) {
		sessionFactory.getCurrentSession().update(retiro);
		
	}
	/**
	 * Consulta informacion de retiro.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Retiro> listRetiros(Retiro retiro) {
		List<Retiro> retiros = sessionFactory.getCurrentSession().createCriteria(Retiro.class).list();
		return retiros;
	}
	
	/**
	 * Consulta informacion de retiro.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Retiro> listRetirosByRetiro(Retiro retiro, int id) {
		List<Retiro> retiros = 
		sessionFactory.getCurrentSession().createCriteria(Retiro.class)
		.add(Restrictions.like("retiroId",id)).list();
		return retiros;
	}
 
	/**
	 * Consulta informacion de retiro.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Retiro> listRetirosByUsername(Retiro retiro, String id) {
		List<Retiro> retiros = sessionFactory.getCurrentSession().createCriteria(Retiro.class).add(Restrictions.like("username",id)).list();
		return retiros;
	}
	
	/**
	 * Consulta informacion de retiro y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Retiro> listRetirosQuery(Retiro retiro, String query, int page, int size) {
		
		return (List<Retiro>) sessionFactory.getCurrentSession()
			.createCriteria(Retiro.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("retiro", "%" + query +"%"), 
			Restrictions.like("usuario", "%" + query +"%")),
			Restrictions.like("fechahora", "%" + query +"%")),
			Restrictions.like("archivo", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de retiro y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Retiro> listRetirosPagination(Retiro retiro, int page, int size) {
			return (List<Retiro>) sessionFactory.getCurrentSession()
				.createCriteria(Retiro.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de retiro consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Retiro.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de retiro consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Retiro.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("retiro", "%" + query +"%"), 
			Restrictions.like("usuario", "%" + query +"%")),
			Restrictions.like("fechahora", "%" + query +"%")),
			Restrictions.like("archivo", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de retiro consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Retiro.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un retiro.
	 */
	public Retiro getRetiro(UUID empid) {
		return (Retiro) sessionFactory.getCurrentSession().get(
				Retiro.class, empid);
	}

	/**
	 * Elimina un retiro.
	 */
	public void deleteRetiro(Retiro retiro) {
		sessionFactory.getCurrentSession().delete(retiro);
	}

}

