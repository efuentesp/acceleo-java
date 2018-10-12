/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los solicitud. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Solicitud;
import com.softtek.acceleo.demo.repository.SolicitudRepository;
/**
 * Clase solicitudRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("solicitudRepository")
public class SolicitudRepositoryImpl implements SolicitudRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un solicitud.
	 */
	public void addSolicitud(Solicitud solicitud) {
		sessionFactory.getCurrentSession().persist(solicitud);
	}
	/**
	 * Edita un solicitud.
	 */
	public void editSolicitud(Solicitud solicitud) {
		sessionFactory.getCurrentSession().update(solicitud);

	}
	/**
	 * Consulta informacion de solicitud.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Solicitud> listSolicituds(Solicitud solicitud) {

		return (List<Solicitud>) sessionFactory.getCurrentSession()
				.createCriteria(Solicitud.class).list();
	}

	/**
	 * Consulta informacion de solicitud y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Solicitud> listSolicitudsQuery(Solicitud solicitud, String query, int page, int size) {
		
		return (List<Solicitud>) sessionFactory.getCurrentSession()
			.createCriteria(Solicitud.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("solicitud", "%" + query +"%"),
Restrictions.like("solicitud", "%" + query +"%")),
Restrictions.like("solicitud", "%" + query +"%")),
Restrictions.like("salario", "%" + query +"%")),
Restrictions.like("correo", "%" + query +"%")),
Restrictions.like("solicitud", "%" + query +"%")),
Restrictions.like("candidato", "%" + query +"%")),
Restrictions.like("estado", "%" + query +"%")),
Restrictions.like("posicion", "%" + query +"%")),
Restrictions.like("solicitud", "%" + query +"%")),
Restrictions.like("fecha", "%" + query +"%")),
Restrictions.like("telefono", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de solicitud y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Solicitud> listSolicitudsPagination(Solicitud solicitud, int page, int size) {
			return (List<Solicitud>) sessionFactory.getCurrentSession()
				.createCriteria(Solicitud.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de solicitud consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Solicitud.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de solicitud consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Solicitud.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("solicitud", "%" + query +"%"),Restrictions.like("solicitud", "%" + query +"%")),Restrictions.like("solicitud", "%" + query +"%")),Restrictions.like("salario", "%" + query +"%")),Restrictions.like("correo", "%" + query +"%")),Restrictions.like("solicitud", "%" + query +"%")),Restrictions.like("candidato", "%" + query +"%")),Restrictions.like("estado", "%" + query +"%")),Restrictions.like("posicion", "%" + query +"%")),Restrictions.like("solicitud", "%" + query +"%")),Restrictions.like("fecha", "%" + query +"%")),Restrictions.like("telefono", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de solicitud consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Solicitud.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un solicitud.
	 */
	public Solicitud getSolicitud(int empid) {
		return (Solicitud) sessionFactory.getCurrentSession().get(
				Solicitud.class, empid);
	}

	/**
	 * Elimina un solicitud.
	 */
	public void deleteSolicitud(Solicitud solicitud) {
		sessionFactory.getCurrentSession().delete(solicitud);
	}

}
