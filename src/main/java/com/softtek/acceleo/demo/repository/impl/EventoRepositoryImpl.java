/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los evento. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Evento;
import com.softtek.acceleo.demo.domain.Solicitud;
import com.softtek.acceleo.demo.repository.EventoRepository;
/**
 * Clase eventoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("eventoRepository")
public class EventoRepositoryImpl implements EventoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un evento.
	 */
	public void addEvento(Evento evento) {
		sessionFactory.getCurrentSession().persist(evento);
	}
	/**
	 * Edita un evento.
	 */
	public void editEvento(Evento evento) {
		sessionFactory.getCurrentSession().update(evento);

	}
	/**
	 * Consulta informacion de evento.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Evento> listEventos(Evento evento) {

		return (List<Evento>) sessionFactory.getCurrentSession()
				.createCriteria(Evento.class).list();
	}
	
	/**
	 * Consulta informacion de evento.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Evento> listEventosByCandidato(Evento evento, int candidatoId) {

		List<Evento> eventos = sessionFactory.getCurrentSession().createCriteria(Evento.class).add(Restrictions.like("candidato.candidatoId", candidatoId)).list();
//		for (Solicitud s: solicitudes) {
//			Hibernate.initialize(s.getCandidatos());
//		}
		return eventos;
	}

	/**
	 * Consulta informacion de evento y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Evento> listEventosQuery(Evento evento, String query, int page, int size) {
		
		return (List<Evento>) sessionFactory.getCurrentSession()
			.createCriteria(Evento.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("notas", "%" + query +"%"),
Restrictions.like("posicion", "%" + query +"%")),
Restrictions.like("estado", "%" + query +"%")),
Restrictions.like("evento", "%" + query +"%")),
Restrictions.like("comentarios", "%" + query +"%")),
Restrictions.like("responsable", "%" + query +"%")),
Restrictions.like("tipo", "%" + query +"%")),
Restrictions.like("evento", "%" + query +"%")),
Restrictions.like("fecha", "%" + query +"%")),
Restrictions.like("evento", "%" + query +"%")),
Restrictions.like("feedback", "%" + query +"%")),
Restrictions.like("evento", "%" + query +"%")),
Restrictions.like("fechareal", "%" + query +"%")),
Restrictions.like("responsablereal", "%" + query +"%")),
Restrictions.like("candidato", "%" + query +"%")),
Restrictions.like("nombre", "%" + query +"%")),
Restrictions.like("evento", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de evento y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Evento> listEventosPagination(Evento evento, int page, int size) {
			return (List<Evento>) sessionFactory.getCurrentSession()
				.createCriteria(Evento.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de evento consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Evento.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de evento consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Evento.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("notas", "%" + query +"%"),Restrictions.like("posicion", "%" + query +"%")),Restrictions.like("estado", "%" + query +"%")),Restrictions.like("evento", "%" + query +"%")),Restrictions.like("comentarios", "%" + query +"%")),Restrictions.like("responsable", "%" + query +"%")),Restrictions.like("tipo", "%" + query +"%")),Restrictions.like("evento", "%" + query +"%")),Restrictions.like("fecha", "%" + query +"%")),Restrictions.like("evento", "%" + query +"%")),Restrictions.like("feedback", "%" + query +"%")),Restrictions.like("evento", "%" + query +"%")),Restrictions.like("fechareal", "%" + query +"%")),Restrictions.like("responsablereal", "%" + query +"%")),Restrictions.like("candidato", "%" + query +"%")),Restrictions.like("nombre", "%" + query +"%")),Restrictions.like("evento", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de evento consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Evento.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un evento.
	 */
	public Evento getEvento(int empid) {
		return (Evento) sessionFactory.getCurrentSession().get(
				Evento.class, empid);
	}

	/**
	 * Elimina un evento.
	 */
	public void deleteEvento(Evento evento) {
		sessionFactory.getCurrentSession().delete(evento);
	}

}
