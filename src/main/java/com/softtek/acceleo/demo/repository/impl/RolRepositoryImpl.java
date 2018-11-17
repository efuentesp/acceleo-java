/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los rol. 
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
import com.softtek.acceleo.demo.domain.Rol;
import com.softtek.acceleo.demo.repository.RolRepository;

/**
 * Clase rolRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("rolRepository")
public class RolRepositoryImpl implements RolRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un rol.
	 */
	public void addRol(Rol rol) {
		sessionFactory.getCurrentSession().persist(rol);
	}
	/**
	 * Edita un rol.
	 */
	public void editRol(Rol rol) {
		sessionFactory.getCurrentSession().update(rol);
		
	}
	/**
	 * Consulta informacion de rol.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Rol> listRols(Rol rol) {
		List<Rol> rols = sessionFactory.getCurrentSession().createCriteria(Rol.class).list();
		return rols;
	}
	
	/**
	 * Consulta informacion de rol.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Rol> listRolsByRol(Rol rol, int id) {
		List<Rol> rols = 
		sessionFactory.getCurrentSession().createCriteria(Rol.class)
		.add(Restrictions.like("rolId",id)).list();
		return rols;
	}
 
	/**
	 * Consulta informacion de rol.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Rol> listRolsByUsername(Rol rol, String id) {
		List<Rol> rols = sessionFactory.getCurrentSession().createCriteria(Rol.class).add(Restrictions.like("username",id)).list();
		return rols;
	}
	
	/**
	 * Consulta informacion de rol y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Rol> listRolsQuery(Rol rol, String query, int page, int size) {
		
		return (List<Rol>) sessionFactory.getCurrentSession()
			.createCriteria(Rol.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("rol", "%" + query +"%"), 
			Restrictions.like("clave", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("activo", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de rol y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Rol> listRolsPagination(Rol rol, int page, int size) {
			return (List<Rol>) sessionFactory.getCurrentSession()
				.createCriteria(Rol.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de rol consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Rol.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de rol consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Rol.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("rol", "%" + query +"%"), 
			Restrictions.like("clave", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("activo", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de rol consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Rol.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un rol.
	 */
	public Rol getRol(UUID empid) {
		return (Rol) sessionFactory.getCurrentSession().get(
				Rol.class, empid);
	}

	/**
	 * Elimina un rol.
	 */
	public void deleteRol(Rol rol) {
		sessionFactory.getCurrentSession().delete(rol);
	}

}

