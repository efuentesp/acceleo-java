/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los pagos. 
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
import com.softtek.acceleo.demo.domain.Pagos;
import com.softtek.acceleo.demo.repository.PagosRepository;

/**
 * Clase pagosRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("pagosRepository")
public class PagosRepositoryImpl implements PagosRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un pagos.
	 */
	public void addPagos(Pagos pagos) {
		sessionFactory.getCurrentSession().persist(pagos);
	}
	/**
	 * Edita un pagos.
	 */
	public void editPagos(Pagos pagos) {
		sessionFactory.getCurrentSession().update(pagos);
		
	}
	/**
	 * Consulta informacion de pagos.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Pagos> listPagoss(Pagos pagos) {
		List<Pagos> pagoss = sessionFactory.getCurrentSession().createCriteria(Pagos.class).list();
		return pagoss;
	}
	
	/**
	 * Consulta informacion de pagos.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Pagos> listPagossByPagos(Pagos pagos, int id) {
		List<Pagos> pagoss = 
		sessionFactory.getCurrentSession().createCriteria(Pagos.class)
		.add(Restrictions.like("pagosId",id)).list();
		return pagoss;
	}
 
	/**
	 * Consulta informacion de pagos.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Pagos> listPagossByUsername(Pagos pagos, String id) {
		List<Pagos> pagoss = sessionFactory.getCurrentSession().createCriteria(Pagos.class).add(Restrictions.like("username",id)).list();
		return pagoss;
	}
	
	/**
	 * Consulta informacion de pagos y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Pagos> listPagossQuery(Pagos pagos, String query, int page, int size) {
		
		return (List<Pagos>) sessionFactory.getCurrentSession()
			.createCriteria(Pagos.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("pagos", "%" + query +"%"), 
			Restrictions.like("instruccionId", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("importeinstruccion", "%" + query +"%")),
			Restrictions.like("movimientos", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("conceptopago", "%" + query +"%")),
			Restrictions.like("clave", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("formaliquidacion", "%" + query +"%")),
			Restrictions.like("tipopago", "%" + query +"%")),
			Restrictions.like("datosconcentradora", "%" + query +"%")),
			Restrictions.like("descripcioncomplementaria", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("importetotal", "%" + query +"%")),
			Restrictions.like("estatusoperacion", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("fechaliquidar", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de pagos y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Pagos> listPagossPagination(Pagos pagos, int page, int size) {
			return (List<Pagos>) sessionFactory.getCurrentSession()
				.createCriteria(Pagos.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de pagos consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Pagos.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de pagos consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Pagos.class).setProjection(Projections.rowCount())
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
			Restrictions.like("pagos", "%" + query +"%"), 
			Restrictions.like("instruccionId", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("importeinstruccion", "%" + query +"%")),
			Restrictions.like("movimientos", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("conceptopago", "%" + query +"%")),
			Restrictions.like("clave", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("formaliquidacion", "%" + query +"%")),
			Restrictions.like("tipopago", "%" + query +"%")),
			Restrictions.like("datosconcentradora", "%" + query +"%")),
			Restrictions.like("descripcioncomplementaria", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("importetotal", "%" + query +"%")),
			Restrictions.like("estatusoperacion", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("fechaliquidar", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de pagos consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Pagos.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un pagos.
	 */
	public Pagos getPagos(UUID empid) {
		return (Pagos) sessionFactory.getCurrentSession().get(
				Pagos.class, empid);
	}

	/**
	 * Elimina un pagos.
	 */
	public void deletePagos(Pagos pagos) {
		sessionFactory.getCurrentSession().delete(pagos);
	}

}

