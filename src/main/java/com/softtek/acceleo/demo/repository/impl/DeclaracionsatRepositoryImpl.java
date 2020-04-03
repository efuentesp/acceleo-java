/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los declaracionsat. 
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
import com.softtek.acceleo.demo.domain.Declaracionsat;
import com.softtek.acceleo.demo.repository.DeclaracionsatRepository;

/**
 * Clase declaracionsatRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("declaracionsatRepository")
public class DeclaracionsatRepositoryImpl implements DeclaracionsatRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un declaracionsat.
	 */
	public void addDeclaracionsat(Declaracionsat declaracionsat) {
		sessionFactory.getCurrentSession().persist(declaracionsat);
	}
	/**
	 * Edita un declaracionsat.
	 */
	public void editDeclaracionsat(Declaracionsat declaracionsat) {
		sessionFactory.getCurrentSession().update(declaracionsat);
		
	}
	/**
	 * Consulta informacion de declaracionsat.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Declaracionsat> listDeclaracionsats(Declaracionsat declaracionsat) {
		List<Declaracionsat> declaracionsats = sessionFactory.getCurrentSession().createCriteria(Declaracionsat.class).list();
		return declaracionsats;
	}
	
	/**
	 * Consulta informacion de declaracionsat.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Declaracionsat> listDeclaracionsatsByDeclaracionsat(Declaracionsat declaracionsat, int id) {
		List<Declaracionsat> declaracionsats = 
		sessionFactory.getCurrentSession().createCriteria(Declaracionsat.class)
		.add(Restrictions.like("declaracionsatId",id)).list();
		return declaracionsats;
	}
 
	/**
	 * Consulta informacion de declaracionsat.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Declaracionsat> listDeclaracionsatsByUsername(Declaracionsat declaracionsat, String id) {
		List<Declaracionsat> declaracionsats = sessionFactory.getCurrentSession().createCriteria(Declaracionsat.class).add(Restrictions.like("username",id)).list();
		return declaracionsats;
	}
	
	/**
	 * Consulta informacion de declaracionsat y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Declaracionsat> listDeclaracionsatsQuery(Declaracionsat declaracionsat, String query, int page, int size) {
		
		return (List<Declaracionsat>) sessionFactory.getCurrentSession()
			.createCriteria(Declaracionsat.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("declaracionsat", "%" + query +"%"), 
			Restrictions.like("inicioejerciciofiscal", "%" + query +"%")),
			Restrictions.like("tipodeclaracion", "%" + query +"%")),
			Restrictions.like("finejerciciofiscal", "%" + query +"%")),
			Restrictions.like("declaracionanteriorfechadeclaracionanterior", "%" + query +"%")),
			Restrictions.like("declaracionanteriorfoliodeclaracionanterior", "%" + query +"%")),
			Restrictions.like("declaracionanteriormensajesproceso", "%" + query +"%")),
			Restrictions.like("declaracionanteriorarchivo", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de declaracionsat y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Declaracionsat> listDeclaracionsatsPagination(Declaracionsat declaracionsat, int page, int size) {
			return (List<Declaracionsat>) sessionFactory.getCurrentSession()
				.createCriteria(Declaracionsat.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de declaracionsat consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Declaracionsat.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de declaracionsat consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Declaracionsat.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("declaracionsat", "%" + query +"%"), 
			Restrictions.like("inicioejerciciofiscal", "%" + query +"%")),
			Restrictions.like("tipodeclaracion", "%" + query +"%")),
			Restrictions.like("finejerciciofiscal", "%" + query +"%")),
			Restrictions.like("declaracionanteriorfechadeclaracionanterior", "%" + query +"%")),
			Restrictions.like("declaracionanteriorfoliodeclaracionanterior", "%" + query +"%")),
			Restrictions.like("declaracionanteriormensajesproceso", "%" + query +"%")),
			Restrictions.like("declaracionanteriorarchivo", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de declaracionsat consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Declaracionsat.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un declaracionsat.
	 */
	public Declaracionsat getDeclaracionsat(UUID empid) {
		return (Declaracionsat) sessionFactory.getCurrentSession().get(
				Declaracionsat.class, empid);
	}

	/**
	 * Elimina un declaracionsat.
	 */
	public void deleteDeclaracionsat(Declaracionsat declaracionsat) {
		sessionFactory.getCurrentSession().delete(declaracionsat);
	}

}

