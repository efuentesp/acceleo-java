/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los accionista. 
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
import com.softtek.acceleo.demo.domain.Accionista;
import com.softtek.acceleo.demo.repository.AccionistaRepository;

/**
 * Clase accionistaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("accionistaRepository")
public class AccionistaRepositoryImpl implements AccionistaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un accionista.
	 */
	public void addAccionista(Accionista accionista) {
		sessionFactory.getCurrentSession().persist(accionista);
	}
	/**
	 * Edita un accionista.
	 */
	public void editAccionista(Accionista accionista) {
		sessionFactory.getCurrentSession().update(accionista);
		
	}
	/**
	 * Consulta informacion de accionista.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Accionista> listAccionistas(Accionista accionista) {
		List<Accionista> accionistas = sessionFactory.getCurrentSession().createCriteria(Accionista.class).list();
		return accionistas;
	}
	
	/**
	 * Consulta informacion de accionista.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Accionista> listAccionistasByAccionista(Accionista accionista, int id) {
		List<Accionista> accionistas = 
		sessionFactory.getCurrentSession().createCriteria(Accionista.class)
		.add(Restrictions.like("accionistaId",id)).list();
		return accionistas;
	}
 
	/**
	 * Consulta informacion de accionista.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Accionista> listAccionistasByUsername(Accionista accionista, String id) {
		List<Accionista> accionistas = sessionFactory.getCurrentSession().createCriteria(Accionista.class).add(Restrictions.like("username",id)).list();
		return accionistas;
	}
	
	/**
	 * Consulta informacion de accionista y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Accionista> listAccionistasQuery(Accionista accionista, String query, int page, int size) {
		
		return (List<Accionista>) sessionFactory.getCurrentSession()
			.createCriteria(Accionista.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("accionista", "%" + query +"%"), 
			Restrictions.like("accionistade", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("rfc", "%" + query +"%")),
			Restrictions.like("porcentajeparticipacionaccionaria", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("nacionalidad", "%" + query +"%")),
			Restrictions.like("pep", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de accionista y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Accionista> listAccionistasPagination(Accionista accionista, int page, int size) {
			return (List<Accionista>) sessionFactory.getCurrentSession()
				.createCriteria(Accionista.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de accionista consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Accionista.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de accionista consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Accionista.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("accionista", "%" + query +"%"), 
			Restrictions.like("accionistade", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("rfc", "%" + query +"%")),
			Restrictions.like("porcentajeparticipacionaccionaria", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("nacionalidad", "%" + query +"%")),
			Restrictions.like("pep", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de accionista consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Accionista.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un accionista.
	 */
	public Accionista getAccionista(UUID empid) {
		return (Accionista) sessionFactory.getCurrentSession().get(
				Accionista.class, empid);
	}

	/**
	 * Elimina un accionista.
	 */
	public void deleteAccionista(Accionista accionista) {
		sessionFactory.getCurrentSession().delete(accionista);
	}

}

