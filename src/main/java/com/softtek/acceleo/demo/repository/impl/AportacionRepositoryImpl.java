/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los aportacion. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Aportacion;
import com.softtek.acceleo.demo.repository.AportacionRepository;
/**
 * Clase aportacionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("aportacionRepository")
public class AportacionRepositoryImpl implements AportacionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un aportacion.
	 */
	public void addAportacion(Aportacion aportacion) {
		sessionFactory.getCurrentSession().persist(aportacion);
	}
	/**
	 * Edita un aportacion.
	 */
	public void editAportacion(Aportacion aportacion) {
		sessionFactory.getCurrentSession().update(aportacion);

	}
	/**
	 * Consulta informacion de aportacion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Aportacion> listAportacions(Aportacion aportacion) {

		return (List<Aportacion>) sessionFactory.getCurrentSession()
				.createCriteria(Aportacion.class).list();
	}

	/**
	 * Consulta informacion de aportacion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Aportacion> listAportacionsQuery(Aportacion aportacion, String query, int page, int size) {
		
		return (List<Aportacion>) sessionFactory.getCurrentSession()
			.createCriteria(Aportacion.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("concepto", "%" + query +"%"),
Restrictions.like("para", "%" + query +"%")),
Restrictions.like("fecha", "%" + query +"%")),
Restrictions.like("aportacion", "%" + query +"%")),
Restrictions.like("monto", "%" + query +"%")),
Restrictions.like("aportacion", "%" + query +"%")),
Restrictions.like("aportacion", "%" + query +"%")),
Restrictions.like("aportacion", "%" + query +"%")),
Restrictions.like("aportacion", "%" + query +"%"))
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de aportacion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Aportacion> listAportacionsPagination(Aportacion aportacion, int page, int size) {
			return (List<Aportacion>) sessionFactory.getCurrentSession()
				.createCriteria(Aportacion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de aportacion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Aportacion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de aportacion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Aportacion.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("concepto", "%" + query +"%"),Restrictions.like("para", "%" + query +"%")),Restrictions.like("fecha", "%" + query +"%")),Restrictions.like("aportacion", "%" + query +"%")),Restrictions.like("monto", "%" + query +"%")),Restrictions.like("aportacion", "%" + query +"%")),Restrictions.like("aportacion", "%" + query +"%")),Restrictions.like("aportacion", "%" + query +"%")),Restrictions.like("aportacion", "%" + query +"%"))	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de aportacion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Aportacion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un aportacion.
	 */
	public Aportacion getAportacion(int empid) {
		return (Aportacion) sessionFactory.getCurrentSession().get(
				Aportacion.class, empid);
	}

	/**
	 * Elimina un aportacion.
	 */
	public void deleteAportacion(Aportacion aportacion) {
		sessionFactory.getCurrentSession().delete(aportacion);
	}

}
