/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los transaccion. 
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
import com.softtek.acceleo.demo.domain.Transaccion;
import com.softtek.acceleo.demo.repository.TransaccionRepository;

/**
 * Clase transaccionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("transaccionRepository")
public class TransaccionRepositoryImpl implements TransaccionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un transaccion.
	 */
	public void addTransaccion(Transaccion transaccion) {
		sessionFactory.getCurrentSession().persist(transaccion);
	}
	/**
	 * Edita un transaccion.
	 */
	public void editTransaccion(Transaccion transaccion) {
		sessionFactory.getCurrentSession().update(transaccion);
		
	}
	/**
	 * Consulta informacion de transaccion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Transaccion> listTransaccions(Transaccion transaccion) {
		List<Transaccion> transaccions = sessionFactory.getCurrentSession().createCriteria(Transaccion.class).list();
		return transaccions;
	}
	
	/**
	 * Consulta informacion de transaccion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Transaccion> listTransaccionsByTransaccion(Transaccion transaccion, int id) {
		List<Transaccion> transaccions = 
		sessionFactory.getCurrentSession().createCriteria(Transaccion.class)
		.add(Restrictions.like("transaccionId",id)).list();
		return transaccions;
	}
 
	/**
	 * Consulta informacion de transaccion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Transaccion> listTransaccionsByUsername(Transaccion transaccion, String id) {
		List<Transaccion> transaccions = sessionFactory.getCurrentSession().createCriteria(Transaccion.class).add(Restrictions.like("username",id)).list();
		return transaccions;
	}
	
	/**
	 * Consulta informacion de transaccion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Transaccion> listTransaccionsQuery(Transaccion transaccion, String query, int page, int size) {
		
		return (List<Transaccion>) sessionFactory.getCurrentSession()
			.createCriteria(Transaccion.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("transaccion", "%" + query +"%"), 
			Restrictions.like("numoperacion", "%" + query +"%")),
			Restrictions.like("modulo", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("costoejecucion", "%" + query +"%")),
			Restrictions.like("estatustrans", "%" + query +"%")),
			Restrictions.like("notransaccion", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("columedocuenta", "%" + query +"%")),
			Restrictions.like("hora", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de transaccion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Transaccion> listTransaccionsPagination(Transaccion transaccion, int page, int size) {
			return (List<Transaccion>) sessionFactory.getCurrentSession()
				.createCriteria(Transaccion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de transaccion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Transaccion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de transaccion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Transaccion.class).setProjection(Projections.rowCount())
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
			Restrictions.like("transaccion", "%" + query +"%"), 
			Restrictions.like("numoperacion", "%" + query +"%")),
			Restrictions.like("modulo", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("costoejecucion", "%" + query +"%")),
			Restrictions.like("estatustrans", "%" + query +"%")),
			Restrictions.like("notransaccion", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("columedocuenta", "%" + query +"%")),
			Restrictions.like("hora", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de transaccion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Transaccion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un transaccion.
	 */
	public Transaccion getTransaccion(UUID empid) {
		return (Transaccion) sessionFactory.getCurrentSession().get(
				Transaccion.class, empid);
	}

	/**
	 * Elimina un transaccion.
	 */
	public void deleteTransaccion(Transaccion transaccion) {
		sessionFactory.getCurrentSession().delete(transaccion);
	}

}

