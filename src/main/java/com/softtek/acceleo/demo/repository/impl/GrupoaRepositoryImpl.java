/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los grupoa. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.softtek.acceleo.demo.domain.Grupoa;
import com.softtek.acceleo.demo.repository.GrupoaRepository;

/**
 * Clase grupoaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("grupoaRepository")
public class GrupoaRepositoryImpl implements GrupoaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un grupoa.
	 */
	public void addGrupoa(Grupoa grupoa) {
		sessionFactory.getCurrentSession().persist(grupoa);
	}
	/**
	 * Edita un grupoa.
	 */
	public void editGrupoa(Grupoa grupoa) {
		sessionFactory.getCurrentSession().update(grupoa);
		
	}
	/**
	 * Consulta informacion de grupoa.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Grupoa> listGrupoas(Grupoa grupoa) {
		List<Grupoa> grupoas = sessionFactory.getCurrentSession().createCriteria(Grupoa.class).list();
		return grupoas;
	}
	
	/**
	 * Consulta informacion de grupoa.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Grupoa> listGrupoasByGrupoa(Grupoa grupoa, int id) {
		List<Grupoa> grupoas = 
		sessionFactory.getCurrentSession().createCriteria(Grupoa.class)
		.add(Restrictions.like("grupoaId",id)).list();
		return grupoas;
	}
 
	/**
	 * Consulta informacion de grupoa.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Grupoa> listGrupoasByUsername(Grupoa grupoa, String id) {
		List<Grupoa> grupoas = sessionFactory.getCurrentSession().createCriteria(Grupoa.class).add(Restrictions.like("username",id)).list();
		return grupoas;
	}
	
	/**
	 * Consulta informacion de grupoa y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Grupoa> listGrupoasQuery(Grupoa grupoa, String query, int page, int size) {
		
		return (List<Grupoa>) sessionFactory.getCurrentSession()
			.createCriteria(Grupoa.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("grupoa", "%" + query +"%"), 
			Restrictions.like("nombregrupo", "%" + query +"%")),
			Restrictions.like("descripciongrupo", "%" + query +"%")),
			Restrictions.like("tipoestatus", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de grupoa y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Grupoa> listGrupoasPagination(Grupoa grupoa, int page, int size) {
			return (List<Grupoa>) sessionFactory.getCurrentSession()
				.createCriteria(Grupoa.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de grupoa consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Grupoa.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de grupoa consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Grupoa.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("grupoa", "%" + query +"%"), 
			Restrictions.like("nombregrupo", "%" + query +"%")),
			Restrictions.like("descripciongrupo", "%" + query +"%")),
			Restrictions.like("tipoestatus", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de grupoa consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Grupoa.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un grupoa.
	 */
	public Grupoa getGrupoa(int empid) {
		return (Grupoa) sessionFactory.getCurrentSession().get(
				Grupoa.class, empid);
	}

	/**
	 * Elimina un grupoa.
	 */
	public void deleteGrupoa(Grupoa grupoa) {
		sessionFactory.getCurrentSession().delete(grupoa);
	}

}

