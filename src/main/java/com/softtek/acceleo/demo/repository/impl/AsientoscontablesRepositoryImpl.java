/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los asientoscontables. 
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
import com.softtek.acceleo.demo.domain.Asientoscontables;
import com.softtek.acceleo.demo.repository.AsientoscontablesRepository;

/**
 * Clase asientoscontablesRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("asientoscontablesRepository")
public class AsientoscontablesRepositoryImpl implements AsientoscontablesRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un asientoscontables.
	 */
	public void addAsientoscontables(Asientoscontables asientoscontables) {
		sessionFactory.getCurrentSession().persist(asientoscontables);
	}
	/**
	 * Edita un asientoscontables.
	 */
	public void editAsientoscontables(Asientoscontables asientoscontables) {
		sessionFactory.getCurrentSession().update(asientoscontables);
		
	}
	/**
	 * Consulta informacion de asientoscontables.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Asientoscontables> listAsientoscontabless(Asientoscontables asientoscontables) {
		List<Asientoscontables> asientoscontabless = sessionFactory.getCurrentSession().createCriteria(Asientoscontables.class).list();
		return asientoscontabless;
	}
	
	/**
	 * Consulta informacion de asientoscontables.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Asientoscontables> listAsientoscontablessByAsientoscontables(Asientoscontables asientoscontables, int id) {
		List<Asientoscontables> asientoscontabless = 
		sessionFactory.getCurrentSession().createCriteria(Asientoscontables.class)
		.add(Restrictions.like("asientoscontablesId",id)).list();
		return asientoscontabless;
	}
 
	/**
	 * Consulta informacion de asientoscontables.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Asientoscontables> listAsientoscontablessByUsername(Asientoscontables asientoscontables, String id) {
		List<Asientoscontables> asientoscontabless = sessionFactory.getCurrentSession().createCriteria(Asientoscontables.class).add(Restrictions.like("username",id)).list();
		return asientoscontabless;
	}
	
	/**
	 * Consulta informacion de asientoscontables y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Asientoscontables> listAsientoscontablessQuery(Asientoscontables asientoscontables, String query, int page, int size) {
		
		return (List<Asientoscontables>) sessionFactory.getCurrentSession()
			.createCriteria(Asientoscontables.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("asientoscontables", "%" + query +"%"), 
			Restrictions.like("folio", "%" + query +"%")),
			Restrictions.like("operacion", "%" + query +"%")),
			Restrictions.like("fechaalta", "%" + query +"%")),
			Restrictions.like("transaccionId", "%" + query +"%")),
			Restrictions.like("fechacontable", "%" + query +"%")),
			Restrictions.like("cuenta", "%" + query +"%")),
			Restrictions.like("sct", "%" + query +"%")),
			Restrictions.like("ssct", "%" + query +"%")),
			Restrictions.like("sssct", "%" + query +"%")),
			Restrictions.like("ssssct", "%" + query +"%")),
			Restrictions.like("descripcioncta", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("aux1", "%" + query +"%")),
			Restrictions.like("aux2", "%" + query +"%")),
			Restrictions.like("aux3", "%" + query +"%")),
			Restrictions.like("cargoabono", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("descripcion", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de asientoscontables y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Asientoscontables> listAsientoscontablessPagination(Asientoscontables asientoscontables, int page, int size) {
			return (List<Asientoscontables>) sessionFactory.getCurrentSession()
				.createCriteria(Asientoscontables.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de asientoscontables consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Asientoscontables.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de asientoscontables consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Asientoscontables.class).setProjection(Projections.rowCount())
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
			Restrictions.like("asientoscontables", "%" + query +"%"), 
			Restrictions.like("folio", "%" + query +"%")),
			Restrictions.like("operacion", "%" + query +"%")),
			Restrictions.like("fechaalta", "%" + query +"%")),
			Restrictions.like("transaccionId", "%" + query +"%")),
			Restrictions.like("fechacontable", "%" + query +"%")),
			Restrictions.like("cuenta", "%" + query +"%")),
			Restrictions.like("sct", "%" + query +"%")),
			Restrictions.like("ssct", "%" + query +"%")),
			Restrictions.like("sssct", "%" + query +"%")),
			Restrictions.like("ssssct", "%" + query +"%")),
			Restrictions.like("descripcioncta", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("aux1", "%" + query +"%")),
			Restrictions.like("aux2", "%" + query +"%")),
			Restrictions.like("aux3", "%" + query +"%")),
			Restrictions.like("cargoabono", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("descripcion", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de asientoscontables consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Asientoscontables.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un asientoscontables.
	 */
	public Asientoscontables getAsientoscontables(UUID empid) {
		return (Asientoscontables) sessionFactory.getCurrentSession().get(
				Asientoscontables.class, empid);
	}

	/**
	 * Elimina un asientoscontables.
	 */
	public void deleteAsientoscontables(Asientoscontables asientoscontables) {
		sessionFactory.getCurrentSession().delete(asientoscontables);
	}

}

