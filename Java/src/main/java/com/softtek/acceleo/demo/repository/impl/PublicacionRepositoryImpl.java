/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los publicacion. 
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
import com.softtek.acceleo.demo.domain.Publicacion;
import com.softtek.acceleo.demo.repository.PublicacionRepository;

/**
 * Clase publicacionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("publicacionRepository")
public class PublicacionRepositoryImpl implements PublicacionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un publicacion.
	 */
	public void addPublicacion(Publicacion publicacion) {
		sessionFactory.getCurrentSession().persist(publicacion);
	}
	/**
	 * Edita un publicacion.
	 */
	public void editPublicacion(Publicacion publicacion) {
		sessionFactory.getCurrentSession().update(publicacion);
		
	}
	/**
	 * Consulta informacion de publicacion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Publicacion> listPublicacions(Publicacion publicacion) {
		List<Publicacion> publicacions = sessionFactory.getCurrentSession().createCriteria(Publicacion.class).list();
		return publicacions;
	}
	
	/**
	 * Consulta informacion de publicacion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Publicacion> listPublicacionsByPublicacion(Publicacion publicacion, int id) {
		List<Publicacion> publicacions = 
		sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
		.add(Restrictions.like("publicacionId",id)).list();
		return publicacions;
	}
 
	/**
	 * Consulta informacion de publicacion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Publicacion> listPublicacionsByUsername(Publicacion publicacion, String id) {
		List<Publicacion> publicacions = sessionFactory.getCurrentSession().createCriteria(Publicacion.class).add(Restrictions.like("username",id)).list();
		return publicacions;
	}
	
	/**
	 * Consulta informacion de publicacion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Publicacion> listPublicacionsQuery(Publicacion publicacion, String query, int page, int size) {
		
		return (List<Publicacion>) sessionFactory.getCurrentSession()
			.createCriteria(Publicacion.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("publicacion", "%" + query +"%"), 
			Restrictions.like("nombreobra", "%" + query +"%")),
			Restrictions.like("tiposubsistema", "%" + query +"%")),
			Restrictions.like("tiponivel", "%" + query +"%")),
			Restrictions.like("tipoarea", "%" + query +"%")),
			Restrictions.like("fechapublicacion", "%" + query +"%")),
			Restrictions.like("autor", "%" + query +"%")),
			Restrictions.like("familiarizaId", "%" + query +"%")),
			Restrictions.like("comunicadoId", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de publicacion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Publicacion> listPublicacionsPagination(Publicacion publicacion, int page, int size) {
			return (List<Publicacion>) sessionFactory.getCurrentSession()
				.createCriteria(Publicacion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de publicacion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Publicacion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de publicacion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Publicacion.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("publicacion", "%" + query +"%"), 
			Restrictions.like("nombreobra", "%" + query +"%")),
			Restrictions.like("tiposubsistema", "%" + query +"%")),
			Restrictions.like("tiponivel", "%" + query +"%")),
			Restrictions.like("tipoarea", "%" + query +"%")),
			Restrictions.like("fechapublicacion", "%" + query +"%")),
			Restrictions.like("autor", "%" + query +"%")),
			Restrictions.like("familiarizaId", "%" + query +"%")),
			Restrictions.like("comunicadoId", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de publicacion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Publicacion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un publicacion.
	 */
	public Publicacion getPublicacion(int empid) {
		return (Publicacion) sessionFactory.getCurrentSession().get(
				Publicacion.class, empid);
	}

	/**
	 * Elimina un publicacion.
	 */
	public void deletePublicacion(Publicacion publicacion) {
		sessionFactory.getCurrentSession().delete(publicacion);
	}

}

