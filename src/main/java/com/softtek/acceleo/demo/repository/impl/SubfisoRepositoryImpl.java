/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los subfiso. 
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
import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.repository.SubfisoRepository;

/**
 * Clase subfisoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("subfisoRepository")
public class SubfisoRepositoryImpl implements SubfisoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un subfiso.
	 */
	public void addSubfiso(Subfiso subfiso) {
		sessionFactory.getCurrentSession().persist(subfiso);
	}
	/**
	 * Edita un subfiso.
	 */
	public void editSubfiso(Subfiso subfiso) {
		sessionFactory.getCurrentSession().update(subfiso);
		
	}
	/**
	 * Consulta informacion de subfiso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Subfiso> listSubfisos(Subfiso subfiso) {
		List<Subfiso> subfisos = sessionFactory.getCurrentSession().createCriteria(Subfiso.class).list();
		return subfisos;
	}
	
	/**
	 * Consulta informacion de subfiso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Subfiso> listSubfisosBySubfiso(Subfiso subfiso, int id) {
		List<Subfiso> subfisos = 
		sessionFactory.getCurrentSession().createCriteria(Subfiso.class)
		.add(Restrictions.like("subfisoId",id)).list();
		return subfisos;
	}
 
	/**
	 * Consulta informacion de subfiso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Subfiso> listSubfisosByUsername(Subfiso subfiso, String id) {
		List<Subfiso> subfisos = sessionFactory.getCurrentSession().createCriteria(Subfiso.class).add(Restrictions.like("username",id)).list();
		return subfisos;
	}
	
	/**
	 * Consulta informacion de subfiso y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Subfiso> listSubfisosQuery(Subfiso subfiso, String query, int page, int size) {
		
		return (List<Subfiso>) sessionFactory.getCurrentSession()
			.createCriteria(Subfiso.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("subfiso", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("numero", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("fecharegistro", "%" + query +"%")),
			Restrictions.like("identificador", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de subfiso y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Subfiso> listSubfisosPagination(Subfiso subfiso, int page, int size) {
			return (List<Subfiso>) sessionFactory.getCurrentSession()
				.createCriteria(Subfiso.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de subfiso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Subfiso.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de subfiso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Subfiso.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("subfiso", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("numero", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("fecharegistro", "%" + query +"%")),
			Restrictions.like("identificador", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de subfiso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Subfiso.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un subfiso.
	 */
	public Subfiso getSubfiso(UUID empid) {
		return (Subfiso) sessionFactory.getCurrentSession().get(
				Subfiso.class, empid);
	}

	/**
	 * Elimina un subfiso.
	 */
	public void deleteSubfiso(Subfiso subfiso) {
		sessionFactory.getCurrentSession().delete(subfiso);
	}

}

