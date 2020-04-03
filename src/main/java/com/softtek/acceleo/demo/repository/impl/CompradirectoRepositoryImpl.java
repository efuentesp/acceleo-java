/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los compradirecto. 
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
import com.softtek.acceleo.demo.domain.Compradirecto;
import com.softtek.acceleo.demo.repository.CompradirectoRepository;

/**
 * Clase compradirectoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("compradirectoRepository")
public class CompradirectoRepositoryImpl implements CompradirectoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un compradirecto.
	 */
	public void addCompradirecto(Compradirecto compradirecto) {
		sessionFactory.getCurrentSession().persist(compradirecto);
	}
	/**
	 * Edita un compradirecto.
	 */
	public void editCompradirecto(Compradirecto compradirecto) {
		sessionFactory.getCurrentSession().update(compradirecto);
		
	}
	/**
	 * Consulta informacion de compradirecto.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Compradirecto> listCompradirectos(Compradirecto compradirecto) {
		List<Compradirecto> compradirectos = sessionFactory.getCurrentSession().createCriteria(Compradirecto.class).list();
		return compradirectos;
	}
	
	/**
	 * Consulta informacion de compradirecto.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Compradirecto> listCompradirectosByCompradirecto(Compradirecto compradirecto, int id) {
		List<Compradirecto> compradirectos = 
		sessionFactory.getCurrentSession().createCriteria(Compradirecto.class)
		.add(Restrictions.like("compradirectoId",id)).list();
		return compradirectos;
	}
 
	/**
	 * Consulta informacion de compradirecto.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Compradirecto> listCompradirectosByUsername(Compradirecto compradirecto, String id) {
		List<Compradirecto> compradirectos = sessionFactory.getCurrentSession().createCriteria(Compradirecto.class).add(Restrictions.like("username",id)).list();
		return compradirectos;
	}
	
	/**
	 * Consulta informacion de compradirecto y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Compradirecto> listCompradirectosQuery(Compradirecto compradirecto, String query, int page, int size) {
		
		return (List<Compradirecto>) sessionFactory.getCurrentSession()
			.createCriteria(Compradirecto.class).setFirstResult((page - 1) * size)
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
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("compradirecto", "%" + query +"%"), 
			Restrictions.like("instruccionId", "%" + query +"%")),
			Restrictions.like("fechavalor", "%" + query +"%")),
			Restrictions.like("titulosgarantia", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("operacionfutura", "%" + query +"%")),
			Restrictions.like("fechaoperacion", "%" + query +"%")),
			Restrictions.like("activos", "%" + query +"%")),
			Restrictions.like("tipomovimiento", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("custodio", "%" + query +"%")),
			Restrictions.like("comision", "%" + query +"%")),
			Restrictions.like("mercado", "%" + query +"%")),
			Restrictions.like("instrumento", "%" + query +"%")),
			Restrictions.like("isr", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("contratoinversionId", "%" + query +"%")),
			Restrictions.like("fechaliquidacion", "%" + query +"%")),
			Restrictions.like("emisiones", "%" + query +"%")),
			Restrictions.like("serie", "%" + query +"%")),
			Restrictions.like("notitulos", "%" + query +"%")),
			Restrictions.like("precio", "%" + query +"%")),
			Restrictions.like("desccomplementaria", "%" + query +"%")),
			Restrictions.like("intereses", "%" + query +"%")),
			Restrictions.like("pizarra", "%" + query +"%")),
			Restrictions.like("cupon", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de compradirecto y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Compradirecto> listCompradirectosPagination(Compradirecto compradirecto, int page, int size) {
			return (List<Compradirecto>) sessionFactory.getCurrentSession()
				.createCriteria(Compradirecto.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de compradirecto consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Compradirecto.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de compradirecto consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Compradirecto.class).setProjection(Projections.rowCount())
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
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("compradirecto", "%" + query +"%"), 
			Restrictions.like("instruccionId", "%" + query +"%")),
			Restrictions.like("fechavalor", "%" + query +"%")),
			Restrictions.like("titulosgarantia", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("operacionfutura", "%" + query +"%")),
			Restrictions.like("fechaoperacion", "%" + query +"%")),
			Restrictions.like("activos", "%" + query +"%")),
			Restrictions.like("tipomovimiento", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("custodio", "%" + query +"%")),
			Restrictions.like("comision", "%" + query +"%")),
			Restrictions.like("mercado", "%" + query +"%")),
			Restrictions.like("instrumento", "%" + query +"%")),
			Restrictions.like("isr", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("contratoinversionId", "%" + query +"%")),
			Restrictions.like("fechaliquidacion", "%" + query +"%")),
			Restrictions.like("emisiones", "%" + query +"%")),
			Restrictions.like("serie", "%" + query +"%")),
			Restrictions.like("notitulos", "%" + query +"%")),
			Restrictions.like("precio", "%" + query +"%")),
			Restrictions.like("desccomplementaria", "%" + query +"%")),
			Restrictions.like("intereses", "%" + query +"%")),
			Restrictions.like("pizarra", "%" + query +"%")),
			Restrictions.like("cupon", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de compradirecto consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Compradirecto.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un compradirecto.
	 */
	public Compradirecto getCompradirecto(UUID empid) {
		return (Compradirecto) sessionFactory.getCurrentSession().get(
				Compradirecto.class, empid);
	}

	/**
	 * Elimina un compradirecto.
	 */
	public void deleteCompradirecto(Compradirecto compradirecto) {
		sessionFactory.getCurrentSession().delete(compradirecto);
	}

}

