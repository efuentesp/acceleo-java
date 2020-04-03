/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los parametroscomisiones. 
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
import com.softtek.acceleo.demo.domain.Parametroscomisiones;
import com.softtek.acceleo.demo.repository.ParametroscomisionesRepository;

/**
 * Clase parametroscomisionesRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("parametroscomisionesRepository")
public class ParametroscomisionesRepositoryImpl implements ParametroscomisionesRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un parametroscomisiones.
	 */
	public void addParametroscomisiones(Parametroscomisiones parametroscomisiones) {
		sessionFactory.getCurrentSession().persist(parametroscomisiones);
	}
	/**
	 * Edita un parametroscomisiones.
	 */
	public void editParametroscomisiones(Parametroscomisiones parametroscomisiones) {
		sessionFactory.getCurrentSession().update(parametroscomisiones);
		
	}
	/**
	 * Consulta informacion de parametroscomisiones.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Parametroscomisiones> listParametroscomisioness(Parametroscomisiones parametroscomisiones) {
		List<Parametroscomisiones> parametroscomisioness = sessionFactory.getCurrentSession().createCriteria(Parametroscomisiones.class).list();
		return parametroscomisioness;
	}
	
	/**
	 * Consulta informacion de parametroscomisiones.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Parametroscomisiones> listParametroscomisionessByParametroscomisiones(Parametroscomisiones parametroscomisiones, int id) {
		List<Parametroscomisiones> parametroscomisioness = 
		sessionFactory.getCurrentSession().createCriteria(Parametroscomisiones.class)
		.add(Restrictions.like("parametroscomisionesId",id)).list();
		return parametroscomisioness;
	}
 
	/**
	 * Consulta informacion de parametroscomisiones.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Parametroscomisiones> listParametroscomisionessByUsername(Parametroscomisiones parametroscomisiones, String id) {
		List<Parametroscomisiones> parametroscomisioness = sessionFactory.getCurrentSession().createCriteria(Parametroscomisiones.class).add(Restrictions.like("username",id)).list();
		return parametroscomisioness;
	}
	
	/**
	 * Consulta informacion de parametroscomisiones y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Parametroscomisiones> listParametroscomisionessQuery(Parametroscomisiones parametroscomisiones, String query, int page, int size) {
		
		return (List<Parametroscomisiones>) sessionFactory.getCurrentSession()
			.createCriteria(Parametroscomisiones.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("parametroscomisiones", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("tipocalculo", "%" + query +"%")),
			Restrictions.like("aquiensecobra", "%" + query +"%")),
			Restrictions.like("montoaceptacion", "%" + query +"%")),
			Restrictions.like("importeanualizado", "%" + query +"%")),
			Restrictions.like("periodicidad", "%" + query +"%")),
			Restrictions.like("calculoaldiaprimero", "%" + query +"%")),
			Restrictions.like("reevaluacion", "%" + query +"%")),
			Restrictions.like("fechaconstitucion", "%" + query +"%")),
			Restrictions.like("fechapivote", "%" + query +"%")),
			Restrictions.like("fechaproxcalculo", "%" + query +"%")),
			Restrictions.like("metodopago", "%" + query +"%")),
			Restrictions.like("aquienfactura", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("comentario", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("penasconvencionales", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("interes", "%" + query +"%")),
			Restrictions.like("tipoiva", "%" + query +"%")),
			Restrictions.like("diacorte", "%" + query +"%")),
			Restrictions.like("fechaprimercalculo", "%" + query +"%")),
			Restrictions.like("fechaultimocalculo", "%" + query +"%")),
			Restrictions.like("cuentapago", "%" + query +"%")),
			Restrictions.like("numero", "%" + query +"%")),
			Restrictions.like("situacionmorosidad", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de parametroscomisiones y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Parametroscomisiones> listParametroscomisionessPagination(Parametroscomisiones parametroscomisiones, int page, int size) {
			return (List<Parametroscomisiones>) sessionFactory.getCurrentSession()
				.createCriteria(Parametroscomisiones.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de parametroscomisiones consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Parametroscomisiones.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de parametroscomisiones consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Parametroscomisiones.class).setProjection(Projections.rowCount())
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
			Restrictions.like("parametroscomisiones", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("tipocalculo", "%" + query +"%")),
			Restrictions.like("aquiensecobra", "%" + query +"%")),
			Restrictions.like("montoaceptacion", "%" + query +"%")),
			Restrictions.like("importeanualizado", "%" + query +"%")),
			Restrictions.like("periodicidad", "%" + query +"%")),
			Restrictions.like("calculoaldiaprimero", "%" + query +"%")),
			Restrictions.like("reevaluacion", "%" + query +"%")),
			Restrictions.like("fechaconstitucion", "%" + query +"%")),
			Restrictions.like("fechapivote", "%" + query +"%")),
			Restrictions.like("fechaproxcalculo", "%" + query +"%")),
			Restrictions.like("metodopago", "%" + query +"%")),
			Restrictions.like("aquienfactura", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("comentario", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("penasconvencionales", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("interes", "%" + query +"%")),
			Restrictions.like("tipoiva", "%" + query +"%")),
			Restrictions.like("diacorte", "%" + query +"%")),
			Restrictions.like("fechaprimercalculo", "%" + query +"%")),
			Restrictions.like("fechaultimocalculo", "%" + query +"%")),
			Restrictions.like("cuentapago", "%" + query +"%")),
			Restrictions.like("numero", "%" + query +"%")),
			Restrictions.like("situacionmorosidad", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de parametroscomisiones consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Parametroscomisiones.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un parametroscomisiones.
	 */
	public Parametroscomisiones getParametroscomisiones(UUID empid) {
		return (Parametroscomisiones) sessionFactory.getCurrentSession().get(
				Parametroscomisiones.class, empid);
	}

	/**
	 * Elimina un parametroscomisiones.
	 */
	public void deleteParametroscomisiones(Parametroscomisiones parametroscomisiones) {
		sessionFactory.getCurrentSession().delete(parametroscomisiones);
	}

}

