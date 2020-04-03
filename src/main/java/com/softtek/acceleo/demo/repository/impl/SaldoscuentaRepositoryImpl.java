/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los saldoscuenta. 
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
import com.softtek.acceleo.demo.domain.Saldoscuenta;
import com.softtek.acceleo.demo.repository.SaldoscuentaRepository;

/**
 * Clase saldoscuentaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("saldoscuentaRepository")
public class SaldoscuentaRepositoryImpl implements SaldoscuentaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un saldoscuenta.
	 */
	public void addSaldoscuenta(Saldoscuenta saldoscuenta) {
		sessionFactory.getCurrentSession().persist(saldoscuenta);
	}
	/**
	 * Edita un saldoscuenta.
	 */
	public void editSaldoscuenta(Saldoscuenta saldoscuenta) {
		sessionFactory.getCurrentSession().update(saldoscuenta);
		
	}
	/**
	 * Consulta informacion de saldoscuenta.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Saldoscuenta> listSaldoscuentas(Saldoscuenta saldoscuenta) {
		List<Saldoscuenta> saldoscuentas = sessionFactory.getCurrentSession().createCriteria(Saldoscuenta.class).list();
		return saldoscuentas;
	}
	
	/**
	 * Consulta informacion de saldoscuenta.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Saldoscuenta> listSaldoscuentasBySaldoscuenta(Saldoscuenta saldoscuenta, int id) {
		List<Saldoscuenta> saldoscuentas = 
		sessionFactory.getCurrentSession().createCriteria(Saldoscuenta.class)
		.add(Restrictions.like("saldoscuentaId",id)).list();
		return saldoscuentas;
	}
 
	/**
	 * Consulta informacion de saldoscuenta.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Saldoscuenta> listSaldoscuentasByUsername(Saldoscuenta saldoscuenta, String id) {
		List<Saldoscuenta> saldoscuentas = sessionFactory.getCurrentSession().createCriteria(Saldoscuenta.class).add(Restrictions.like("username",id)).list();
		return saldoscuentas;
	}
	
	/**
	 * Consulta informacion de saldoscuenta y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Saldoscuenta> listSaldoscuentasQuery(Saldoscuenta saldoscuenta, String query, int page, int size) {
		
		return (List<Saldoscuenta>) sessionFactory.getCurrentSession()
			.createCriteria(Saldoscuenta.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("saldoscuenta", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("cuenta", "%" + query +"%")),
			Restrictions.like("sct", "%" + query +"%")),
			Restrictions.like("ssct", "%" + query +"%")),
			Restrictions.like("sssct", "%" + query +"%")),
			Restrictions.like("ssssct", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("auxiliar1", "%" + query +"%")),
			Restrictions.like("auxiliar2", "%" + query +"%")),
			Restrictions.like("auxiliar3", "%" + query +"%")),
			Restrictions.like("saldoinicial", "%" + query +"%")),
			Restrictions.like("cargos", "%" + query +"%")),
			Restrictions.like("abonos", "%" + query +"%")),
			Restrictions.like("saldoactual", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de saldoscuenta y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Saldoscuenta> listSaldoscuentasPagination(Saldoscuenta saldoscuenta, int page, int size) {
			return (List<Saldoscuenta>) sessionFactory.getCurrentSession()
				.createCriteria(Saldoscuenta.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de saldoscuenta consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Saldoscuenta.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de saldoscuenta consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Saldoscuenta.class).setProjection(Projections.rowCount())
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
			Restrictions.like("saldoscuenta", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("cuenta", "%" + query +"%")),
			Restrictions.like("sct", "%" + query +"%")),
			Restrictions.like("ssct", "%" + query +"%")),
			Restrictions.like("sssct", "%" + query +"%")),
			Restrictions.like("ssssct", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("auxiliar1", "%" + query +"%")),
			Restrictions.like("auxiliar2", "%" + query +"%")),
			Restrictions.like("auxiliar3", "%" + query +"%")),
			Restrictions.like("saldoinicial", "%" + query +"%")),
			Restrictions.like("cargos", "%" + query +"%")),
			Restrictions.like("abonos", "%" + query +"%")),
			Restrictions.like("saldoactual", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de saldoscuenta consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Saldoscuenta.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un saldoscuenta.
	 */
	public Saldoscuenta getSaldoscuenta(UUID empid) {
		return (Saldoscuenta) sessionFactory.getCurrentSession().get(
				Saldoscuenta.class, empid);
	}

	/**
	 * Elimina un saldoscuenta.
	 */
	public void deleteSaldoscuenta(Saldoscuenta saldoscuenta) {
		sessionFactory.getCurrentSession().delete(saldoscuenta);
	}

}

