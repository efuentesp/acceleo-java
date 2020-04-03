/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los honorarioscontrato. 
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
import com.softtek.acceleo.demo.domain.Honorarioscontrato;
import com.softtek.acceleo.demo.repository.HonorarioscontratoRepository;

/**
 * Clase honorarioscontratoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("honorarioscontratoRepository")
public class HonorarioscontratoRepositoryImpl implements HonorarioscontratoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un honorarioscontrato.
	 */
	public void addHonorarioscontrato(Honorarioscontrato honorarioscontrato) {
		sessionFactory.getCurrentSession().persist(honorarioscontrato);
	}
	/**
	 * Edita un honorarioscontrato.
	 */
	public void editHonorarioscontrato(Honorarioscontrato honorarioscontrato) {
		sessionFactory.getCurrentSession().update(honorarioscontrato);
		
	}
	/**
	 * Consulta informacion de honorarioscontrato.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Honorarioscontrato> listHonorarioscontratos(Honorarioscontrato honorarioscontrato) {
		List<Honorarioscontrato> honorarioscontratos = sessionFactory.getCurrentSession().createCriteria(Honorarioscontrato.class).list();
		return honorarioscontratos;
	}
	
	/**
	 * Consulta informacion de honorarioscontrato.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Honorarioscontrato> listHonorarioscontratosByHonorarioscontrato(Honorarioscontrato honorarioscontrato, int id) {
		List<Honorarioscontrato> honorarioscontratos = 
		sessionFactory.getCurrentSession().createCriteria(Honorarioscontrato.class)
		.add(Restrictions.like("honorarioscontratoId",id)).list();
		return honorarioscontratos;
	}
 
	/**
	 * Consulta informacion de honorarioscontrato.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Honorarioscontrato> listHonorarioscontratosByUsername(Honorarioscontrato honorarioscontrato, String id) {
		List<Honorarioscontrato> honorarioscontratos = sessionFactory.getCurrentSession().createCriteria(Honorarioscontrato.class).add(Restrictions.like("username",id)).list();
		return honorarioscontratos;
	}
	
	/**
	 * Consulta informacion de honorarioscontrato y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Honorarioscontrato> listHonorarioscontratosQuery(Honorarioscontrato honorarioscontrato, String query, int page, int size) {
		
		return (List<Honorarioscontrato>) sessionFactory.getCurrentSession()
			.createCriteria(Honorarioscontrato.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("honorarioscontrato", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("persona", "%" + query +"%")),
			Restrictions.like("comisiones", "%" + query +"%")),
			Restrictions.like("iva", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de honorarioscontrato y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Honorarioscontrato> listHonorarioscontratosPagination(Honorarioscontrato honorarioscontrato, int page, int size) {
			return (List<Honorarioscontrato>) sessionFactory.getCurrentSession()
				.createCriteria(Honorarioscontrato.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de honorarioscontrato consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Honorarioscontrato.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de honorarioscontrato consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Honorarioscontrato.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("honorarioscontrato", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("persona", "%" + query +"%")),
			Restrictions.like("comisiones", "%" + query +"%")),
			Restrictions.like("iva", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de honorarioscontrato consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Honorarioscontrato.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un honorarioscontrato.
	 */
	public Honorarioscontrato getHonorarioscontrato(UUID empid) {
		return (Honorarioscontrato) sessionFactory.getCurrentSession().get(
				Honorarioscontrato.class, empid);
	}

	/**
	 * Elimina un honorarioscontrato.
	 */
	public void deleteHonorarioscontrato(Honorarioscontrato honorarioscontrato) {
		sessionFactory.getCurrentSession().delete(honorarioscontrato);
	}

}

