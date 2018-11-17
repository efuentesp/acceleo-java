/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los trayectoria. 
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
import com.softtek.acceleo.demo.domain.Trayectoria;
import com.softtek.acceleo.demo.repository.TrayectoriaRepository;

/**
 * Clase trayectoriaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("trayectoriaRepository")
public class TrayectoriaRepositoryImpl implements TrayectoriaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un trayectoria.
	 */
	public void addTrayectoria(Trayectoria trayectoria) {
		sessionFactory.getCurrentSession().persist(trayectoria);
	}
	/**
	 * Edita un trayectoria.
	 */
	public void editTrayectoria(Trayectoria trayectoria) {
		sessionFactory.getCurrentSession().update(trayectoria);
		
	}
	/**
	 * Consulta informacion de trayectoria.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Trayectoria> listTrayectorias(Trayectoria trayectoria) {
		List<Trayectoria> trayectorias = sessionFactory.getCurrentSession().createCriteria(Trayectoria.class).list();
		return trayectorias;
	}
	
	/**
	 * Consulta informacion de trayectoria.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Trayectoria> listTrayectoriasByTrayectoria(Trayectoria trayectoria, int id) {
		List<Trayectoria> trayectorias = 
		sessionFactory.getCurrentSession().createCriteria(Trayectoria.class)
		.add(Restrictions.like("trayectoriaId",id)).list();
		return trayectorias;
	}
 
	/**
	 * Consulta informacion de trayectoria.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Trayectoria> listTrayectoriasByUsername(Trayectoria trayectoria, String id) {
		List<Trayectoria> trayectorias = sessionFactory.getCurrentSession().createCriteria(Trayectoria.class).add(Restrictions.like("username",id)).list();
		return trayectorias;
	}
	
	/**
	 * Consulta informacion de trayectoria y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Trayectoria> listTrayectoriasQuery(Trayectoria trayectoria, String query, int page, int size) {
		
		return (List<Trayectoria>) sessionFactory.getCurrentSession()
			.createCriteria(Trayectoria.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("trayectoria", "%" + query +"%"), 
			Restrictions.like("trayectoria", "%" + query +"%")),
			Restrictions.like("descripcion", "%" + query +"%")),
			Restrictions.like("clave", "%" + query +"%")),
			Restrictions.like("documentoId", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de trayectoria y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Trayectoria> listTrayectoriasPagination(Trayectoria trayectoria, int page, int size) {
			return (List<Trayectoria>) sessionFactory.getCurrentSession()
				.createCriteria(Trayectoria.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de trayectoria consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Trayectoria.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de trayectoria consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Trayectoria.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("trayectoria", "%" + query +"%"), 
			Restrictions.like("trayectoria", "%" + query +"%")),
			Restrictions.like("descripcion", "%" + query +"%")),
			Restrictions.like("clave", "%" + query +"%")),
			Restrictions.like("documentoId", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de trayectoria consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Trayectoria.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un trayectoria.
	 */
	public Trayectoria getTrayectoria(UUID empid) {
		return (Trayectoria) sessionFactory.getCurrentSession().get(
				Trayectoria.class, empid);
	}

	/**
	 * Elimina un trayectoria.
	 */
	public void deleteTrayectoria(Trayectoria trayectoria) {
		sessionFactory.getCurrentSession().delete(trayectoria);
	}

}

