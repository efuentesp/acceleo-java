/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los ventadirecto. 
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
import com.softtek.acceleo.demo.domain.Ventadirecto;
import com.softtek.acceleo.demo.repository.VentadirectoRepository;

/**
 * Clase ventadirectoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("ventadirectoRepository")
public class VentadirectoRepositoryImpl implements VentadirectoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un ventadirecto.
	 */
	public void addVentadirecto(Ventadirecto ventadirecto) {
		sessionFactory.getCurrentSession().persist(ventadirecto);
	}
	/**
	 * Edita un ventadirecto.
	 */
	public void editVentadirecto(Ventadirecto ventadirecto) {
		sessionFactory.getCurrentSession().update(ventadirecto);
		
	}
	/**
	 * Consulta informacion de ventadirecto.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Ventadirecto> listVentadirectos(Ventadirecto ventadirecto) {
		List<Ventadirecto> ventadirectos = sessionFactory.getCurrentSession().createCriteria(Ventadirecto.class).list();
		return ventadirectos;
	}
	
	/**
	 * Consulta informacion de ventadirecto.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Ventadirecto> listVentadirectosByVentadirecto(Ventadirecto ventadirecto, int id) {
		List<Ventadirecto> ventadirectos = 
		sessionFactory.getCurrentSession().createCriteria(Ventadirecto.class)
		.add(Restrictions.like("ventadirectoId",id)).list();
		return ventadirectos;
	}
 
	/**
	 * Consulta informacion de ventadirecto.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Ventadirecto> listVentadirectosByUsername(Ventadirecto ventadirecto, String id) {
		List<Ventadirecto> ventadirectos = sessionFactory.getCurrentSession().createCriteria(Ventadirecto.class).add(Restrictions.like("username",id)).list();
		return ventadirectos;
	}
	
	/**
	 * Consulta informacion de ventadirecto y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Ventadirecto> listVentadirectosQuery(Ventadirecto ventadirecto, String query, int page, int size) {
		
		return (List<Ventadirecto>) sessionFactory.getCurrentSession()
			.createCriteria(Ventadirecto.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("ventadirecto", "%" + query +"%"), 
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
	 * Consulta informacion de ventadirecto y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Ventadirecto> listVentadirectosPagination(Ventadirecto ventadirecto, int page, int size) {
			return (List<Ventadirecto>) sessionFactory.getCurrentSession()
				.createCriteria(Ventadirecto.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de ventadirecto consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Ventadirecto.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de ventadirecto consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Ventadirecto.class).setProjection(Projections.rowCount())
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
			Restrictions.like("ventadirecto", "%" + query +"%"), 
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
	 * Obtiene el numero de ventadirecto consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Ventadirecto.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un ventadirecto.
	 */
	public Ventadirecto getVentadirecto(UUID empid) {
		return (Ventadirecto) sessionFactory.getCurrentSession().get(
				Ventadirecto.class, empid);
	}

	/**
	 * Elimina un ventadirecto.
	 */
	public void deleteVentadirecto(Ventadirecto ventadirecto) {
		sessionFactory.getCurrentSession().delete(ventadirecto);
	}

}

