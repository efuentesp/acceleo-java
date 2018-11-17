/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los filial. 
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
import com.softtek.acceleo.demo.domain.Filial;
import com.softtek.acceleo.demo.repository.FilialRepository;

/**
 * Clase filialRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("filialRepository")
public class FilialRepositoryImpl implements FilialRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un filial.
	 */
	public void addFilial(Filial filial) {
		sessionFactory.getCurrentSession().persist(filial);
	}
	/**
	 * Edita un filial.
	 */
	public void editFilial(Filial filial) {
		sessionFactory.getCurrentSession().update(filial);
		
	}
	/**
	 * Consulta informacion de filial.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Filial> listFilials(Filial filial) {
		List<Filial> filials = sessionFactory.getCurrentSession().createCriteria(Filial.class).list();
		return filials;
	}
	
	/**
	 * Consulta informacion de filial.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Filial> listFilialsByFilial(Filial filial, int id) {
		List<Filial> filials = 
		sessionFactory.getCurrentSession().createCriteria(Filial.class)
		.add(Restrictions.like("filialId",id)).list();
		return filials;
	}
 
	/**
	 * Consulta informacion de filial.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Filial> listFilialsByUsername(Filial filial, String id) {
		List<Filial> filials = sessionFactory.getCurrentSession().createCriteria(Filial.class).add(Restrictions.like("username",id)).list();
		return filials;
	}
	
	/**
	 * Consulta informacion de filial y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Filial> listFilialsQuery(Filial filial, String query, int page, int size) {
		
		return (List<Filial>) sessionFactory.getCurrentSession()
			.createCriteria(Filial.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("filial", "%" + query +"%"), 
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("ubicacion", "%" + query +"%")),
			Restrictions.like("ciudad", "%" + query +"%")),
			Restrictions.like("estado", "%" + query +"%")),
			Restrictions.like("telefono", "%" + query +"%")),
			Restrictions.like("sitio", "%" + query +"%")),
			Restrictions.like("contacto", "%" + query +"%")),
			Restrictions.like("notas", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de filial y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Filial> listFilialsPagination(Filial filial, int page, int size) {
			return (List<Filial>) sessionFactory.getCurrentSession()
				.createCriteria(Filial.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de filial consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Filial.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de filial consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Filial.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("filial", "%" + query +"%"), 
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("ubicacion", "%" + query +"%")),
			Restrictions.like("ciudad", "%" + query +"%")),
			Restrictions.like("estado", "%" + query +"%")),
			Restrictions.like("telefono", "%" + query +"%")),
			Restrictions.like("sitio", "%" + query +"%")),
			Restrictions.like("contacto", "%" + query +"%")),
			Restrictions.like("notas", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de filial consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Filial.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un filial.
	 */
	public Filial getFilial(UUID empid) {
		return (Filial) sessionFactory.getCurrentSession().get(
				Filial.class, empid);
	}

	/**
	 * Elimina un filial.
	 */
	public void deleteFilial(Filial filial) {
		sessionFactory.getCurrentSession().delete(filial);
	}

}

