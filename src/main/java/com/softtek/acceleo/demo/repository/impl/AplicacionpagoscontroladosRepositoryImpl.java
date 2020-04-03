/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los aplicacionpagoscontrolados. 
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
import com.softtek.acceleo.demo.domain.Aplicacionpagoscontrolados;
import com.softtek.acceleo.demo.repository.AplicacionpagoscontroladosRepository;

/**
 * Clase aplicacionpagoscontroladosRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("aplicacionpagoscontroladosRepository")
public class AplicacionpagoscontroladosRepositoryImpl implements AplicacionpagoscontroladosRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un aplicacionpagoscontrolados.
	 */
	public void addAplicacionpagoscontrolados(Aplicacionpagoscontrolados aplicacionpagoscontrolados) {
		sessionFactory.getCurrentSession().persist(aplicacionpagoscontrolados);
	}
	/**
	 * Edita un aplicacionpagoscontrolados.
	 */
	public void editAplicacionpagoscontrolados(Aplicacionpagoscontrolados aplicacionpagoscontrolados) {
		sessionFactory.getCurrentSession().update(aplicacionpagoscontrolados);
		
	}
	/**
	 * Consulta informacion de aplicacionpagoscontrolados.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Aplicacionpagoscontrolados> listAplicacionpagoscontroladoss(Aplicacionpagoscontrolados aplicacionpagoscontrolados) {
		List<Aplicacionpagoscontrolados> aplicacionpagoscontroladoss = sessionFactory.getCurrentSession().createCriteria(Aplicacionpagoscontrolados.class).list();
		return aplicacionpagoscontroladoss;
	}
	
	/**
	 * Consulta informacion de aplicacionpagoscontrolados.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Aplicacionpagoscontrolados> listAplicacionpagoscontroladossByAplicacionpagoscontrolados(Aplicacionpagoscontrolados aplicacionpagoscontrolados, int id) {
		List<Aplicacionpagoscontrolados> aplicacionpagoscontroladoss = 
		sessionFactory.getCurrentSession().createCriteria(Aplicacionpagoscontrolados.class)
		.add(Restrictions.like("aplicacionpagoscontroladosId",id)).list();
		return aplicacionpagoscontroladoss;
	}
 
	/**
	 * Consulta informacion de aplicacionpagoscontrolados.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Aplicacionpagoscontrolados> listAplicacionpagoscontroladossByUsername(Aplicacionpagoscontrolados aplicacionpagoscontrolados, String id) {
		List<Aplicacionpagoscontrolados> aplicacionpagoscontroladoss = sessionFactory.getCurrentSession().createCriteria(Aplicacionpagoscontrolados.class).add(Restrictions.like("username",id)).list();
		return aplicacionpagoscontroladoss;
	}
	
	/**
	 * Consulta informacion de aplicacionpagoscontrolados y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Aplicacionpagoscontrolados> listAplicacionpagoscontroladossQuery(Aplicacionpagoscontrolados aplicacionpagoscontrolados, String query, int page, int size) {
		
		return (List<Aplicacionpagoscontrolados>) sessionFactory.getCurrentSession()
			.createCriteria(Aplicacionpagoscontrolados.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("aplicacionpagoscontrolados", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("importepago", "%" + query +"%")),
			Restrictions.like("formapago", "%" + query +"%")),
			Restrictions.like("tipocomision", "%" + query +"%")),
			Restrictions.like("iva", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de aplicacionpagoscontrolados y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Aplicacionpagoscontrolados> listAplicacionpagoscontroladossPagination(Aplicacionpagoscontrolados aplicacionpagoscontrolados, int page, int size) {
			return (List<Aplicacionpagoscontrolados>) sessionFactory.getCurrentSession()
				.createCriteria(Aplicacionpagoscontrolados.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de aplicacionpagoscontrolados consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Aplicacionpagoscontrolados.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de aplicacionpagoscontrolados consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Aplicacionpagoscontrolados.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("aplicacionpagoscontrolados", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("importepago", "%" + query +"%")),
			Restrictions.like("formapago", "%" + query +"%")),
			Restrictions.like("tipocomision", "%" + query +"%")),
			Restrictions.like("iva", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de aplicacionpagoscontrolados consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Aplicacionpagoscontrolados.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un aplicacionpagoscontrolados.
	 */
	public Aplicacionpagoscontrolados getAplicacionpagoscontrolados(UUID empid) {
		return (Aplicacionpagoscontrolados) sessionFactory.getCurrentSession().get(
				Aplicacionpagoscontrolados.class, empid);
	}

	/**
	 * Elimina un aplicacionpagoscontrolados.
	 */
	public void deleteAplicacionpagoscontrolados(Aplicacionpagoscontrolados aplicacionpagoscontrolados) {
		sessionFactory.getCurrentSession().delete(aplicacionpagoscontrolados);
	}

}

