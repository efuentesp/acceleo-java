/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los agenda. 
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
import com.softtek.acceleo.demo.domain.Agenda;
import com.softtek.acceleo.demo.repository.AgendaRepository;

/**
 * Clase agendaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("agendaRepository")
public class AgendaRepositoryImpl implements AgendaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un agenda.
	 */
	public void addAgenda(Agenda agenda) {
		sessionFactory.getCurrentSession().persist(agenda);
	}
	/**
	 * Edita un agenda.
	 */
	public void editAgenda(Agenda agenda) {
		sessionFactory.getCurrentSession().update(agenda);
		
	}
	/**
	 * Consulta informacion de agenda.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Agenda> listAgendas(Agenda agenda) {
		List<Agenda> agendas = sessionFactory.getCurrentSession().createCriteria(Agenda.class).list();
		return agendas;
	}
	
	/**
	 * Consulta informacion de agenda.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Agenda> listAgendasByAgenda(Agenda agenda, int id) {
		List<Agenda> agendas = 
		sessionFactory.getCurrentSession().createCriteria(Agenda.class)
		.add(Restrictions.like("agendaId",id)).list();
		return agendas;
	}
 
	/**
	 * Consulta informacion de agenda.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Agenda> listAgendasByUsername(Agenda agenda, String id) {
		List<Agenda> agendas = sessionFactory.getCurrentSession().createCriteria(Agenda.class).add(Restrictions.like("username",id)).list();
		return agendas;
	}
	
	/**
	 * Consulta informacion de agenda y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Agenda> listAgendasQuery(Agenda agenda, String query, int page, int size) {
		
		return (List<Agenda>) sessionFactory.getCurrentSession()
			.createCriteria(Agenda.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("agenda", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("evento", "%" + query +"%")),
			Restrictions.like("fecha", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("observacion", "%" + query +"%")),
			Restrictions.like("concovados", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de agenda y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Agenda> listAgendasPagination(Agenda agenda, int page, int size) {
			return (List<Agenda>) sessionFactory.getCurrentSession()
				.createCriteria(Agenda.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de agenda consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Agenda.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de agenda consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Agenda.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("agenda", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("evento", "%" + query +"%")),
			Restrictions.like("fecha", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("observacion", "%" + query +"%")),
			Restrictions.like("concovados", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de agenda consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Agenda.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un agenda.
	 */
	public Agenda getAgenda(UUID empid) {
		return (Agenda) sessionFactory.getCurrentSession().get(
				Agenda.class, empid);
	}

	/**
	 * Elimina un agenda.
	 */
	public void deleteAgenda(Agenda agenda) {
		sessionFactory.getCurrentSession().delete(agenda);
	}

}

