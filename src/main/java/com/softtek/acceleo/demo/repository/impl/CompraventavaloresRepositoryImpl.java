/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los compraventavalores. 
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
import com.softtek.acceleo.demo.domain.Compraventavalores;
import com.softtek.acceleo.demo.repository.CompraventavaloresRepository;

/**
 * Clase compraventavaloresRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("compraventavaloresRepository")
public class CompraventavaloresRepositoryImpl implements CompraventavaloresRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un compraventavalores.
	 */
	public void addCompraventavalores(Compraventavalores compraventavalores) {
		sessionFactory.getCurrentSession().persist(compraventavalores);
	}
	/**
	 * Edita un compraventavalores.
	 */
	public void editCompraventavalores(Compraventavalores compraventavalores) {
		sessionFactory.getCurrentSession().update(compraventavalores);
		
	}
	/**
	 * Consulta informacion de compraventavalores.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Compraventavalores> listCompraventavaloress(Compraventavalores compraventavalores) {
		List<Compraventavalores> compraventavaloress = sessionFactory.getCurrentSession().createCriteria(Compraventavalores.class).list();
		return compraventavaloress;
	}
	
	/**
	 * Consulta informacion de compraventavalores.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Compraventavalores> listCompraventavaloressByCompraventavalores(Compraventavalores compraventavalores, int id) {
		List<Compraventavalores> compraventavaloress = 
		sessionFactory.getCurrentSession().createCriteria(Compraventavalores.class)
		.add(Restrictions.like("compraventavaloresId",id)).list();
		return compraventavaloress;
	}
 
	/**
	 * Consulta informacion de compraventavalores.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Compraventavalores> listCompraventavaloressByUsername(Compraventavalores compraventavalores, String id) {
		List<Compraventavalores> compraventavaloress = sessionFactory.getCurrentSession().createCriteria(Compraventavalores.class).add(Restrictions.like("username",id)).list();
		return compraventavaloress;
	}
	
	/**
	 * Consulta informacion de compraventavalores y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Compraventavalores> listCompraventavaloressQuery(Compraventavalores compraventavalores, String query, int page, int size) {
		
		return (List<Compraventavalores>) sessionFactory.getCurrentSession()
			.createCriteria(Compraventavalores.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("compraventavalores", "%" + query +"%"), 
			Restrictions.like("fechaoperacion", "%" + query +"%")),
			Restrictions.like("generooperacion", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("contratoinversionId", "%" + query +"%")),
			Restrictions.like("descripcionoperacion", "%" + query +"%")),
			Restrictions.like("operacion", "%" + query +"%")),
			Restrictions.like("montooperacion", "%" + query +"%")),
			Restrictions.like("intermediario", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("descripcionfideicomiso", "%" + query +"%")),
			Restrictions.like("politicainversion", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("emergente", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de compraventavalores y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Compraventavalores> listCompraventavaloressPagination(Compraventavalores compraventavalores, int page, int size) {
			return (List<Compraventavalores>) sessionFactory.getCurrentSession()
				.createCriteria(Compraventavalores.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de compraventavalores consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Compraventavalores.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de compraventavalores consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Compraventavalores.class).setProjection(Projections.rowCount())
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
			Restrictions.like("compraventavalores", "%" + query +"%"), 
			Restrictions.like("fechaoperacion", "%" + query +"%")),
			Restrictions.like("generooperacion", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("contratoinversionId", "%" + query +"%")),
			Restrictions.like("descripcionoperacion", "%" + query +"%")),
			Restrictions.like("operacion", "%" + query +"%")),
			Restrictions.like("montooperacion", "%" + query +"%")),
			Restrictions.like("intermediario", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("descripcionfideicomiso", "%" + query +"%")),
			Restrictions.like("politicainversion", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("emergente", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de compraventavalores consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Compraventavalores.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un compraventavalores.
	 */
	public Compraventavalores getCompraventavalores(UUID empid) {
		return (Compraventavalores) sessionFactory.getCurrentSession().get(
				Compraventavalores.class, empid);
	}

	/**
	 * Elimina un compraventavalores.
	 */
	public void deleteCompraventavalores(Compraventavalores compraventavalores) {
		sessionFactory.getCurrentSession().delete(compraventavalores);
	}

}

