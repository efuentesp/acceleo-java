/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los movimiento. 
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
import com.softtek.acceleo.demo.domain.Movimiento;
import com.softtek.acceleo.demo.repository.MovimientoRepository;

/**
 * Clase movimientoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("movimientoRepository")
public class MovimientoRepositoryImpl implements MovimientoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un movimiento.
	 */
	public void addMovimiento(Movimiento movimiento) {
		sessionFactory.getCurrentSession().persist(movimiento);
	}
	/**
	 * Edita un movimiento.
	 */
	public void editMovimiento(Movimiento movimiento) {
		sessionFactory.getCurrentSession().update(movimiento);
		
	}
	/**
	 * Consulta informacion de movimiento.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Movimiento> listMovimientos(Movimiento movimiento) {
		List<Movimiento> movimientos = sessionFactory.getCurrentSession().createCriteria(Movimiento.class).list();
		return movimientos;
	}
	
	/**
	 * Consulta informacion de movimiento.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Movimiento> listMovimientosByMovimiento(Movimiento movimiento, int id) {
		List<Movimiento> movimientos = 
		sessionFactory.getCurrentSession().createCriteria(Movimiento.class)
		.add(Restrictions.like("movimientoId",id)).list();
		return movimientos;
	}
 
	/**
	 * Consulta informacion de movimiento.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Movimiento> listMovimientosByUsername(Movimiento movimiento, String id) {
		List<Movimiento> movimientos = sessionFactory.getCurrentSession().createCriteria(Movimiento.class).add(Restrictions.like("username",id)).list();
		return movimientos;
	}
	
	/**
	 * Consulta informacion de movimiento y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Movimiento> listMovimientosQuery(Movimiento movimiento, String query, int page, int size) {
		
		return (List<Movimiento>) sessionFactory.getCurrentSession()
			.createCriteria(Movimiento.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("movimiento", "%" + query +"%"), 
			Restrictions.like("fechacontable", "%" + query +"%")),
			Restrictions.like("fechaalta", "%" + query +"%")),
			Restrictions.like("operacion", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("folio", "%" + query +"%")),
			Restrictions.like("transaccion", "%" + query +"%")),
			Restrictions.like("descripcion", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("usuario", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("factura", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de movimiento y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Movimiento> listMovimientosPagination(Movimiento movimiento, int page, int size) {
			return (List<Movimiento>) sessionFactory.getCurrentSession()
				.createCriteria(Movimiento.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de movimiento consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Movimiento.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de movimiento consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Movimiento.class).setProjection(Projections.rowCount())
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
			Restrictions.like("movimiento", "%" + query +"%"), 
			Restrictions.like("fechacontable", "%" + query +"%")),
			Restrictions.like("fechaalta", "%" + query +"%")),
			Restrictions.like("operacion", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("folio", "%" + query +"%")),
			Restrictions.like("transaccion", "%" + query +"%")),
			Restrictions.like("descripcion", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("usuario", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("factura", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de movimiento consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Movimiento.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un movimiento.
	 */
	public Movimiento getMovimiento(UUID empid) {
		return (Movimiento) sessionFactory.getCurrentSession().get(
				Movimiento.class, empid);
	}

	/**
	 * Elimina un movimiento.
	 */
	public void deleteMovimiento(Movimiento movimiento) {
		sessionFactory.getCurrentSession().delete(movimiento);
	}

}

