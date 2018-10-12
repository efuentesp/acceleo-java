/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los domicilio. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Domicilio;
import com.softtek.acceleo.demo.repository.DomicilioRepository;
/**
 * Clase domicilioRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("domicilioRepository")
public class DomicilioRepositoryImpl implements DomicilioRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un domicilio.
	 */
	public void addDomicilio(Domicilio domicilio) {
		sessionFactory.getCurrentSession().persist(domicilio);
	}
	/**
	 * Edita un domicilio.
	 */
	public void editDomicilio(Domicilio domicilio) {
		sessionFactory.getCurrentSession().update(domicilio);

	}
	/**
	 * Consulta informacion de domicilio.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Domicilio> listDomicilios(Domicilio domicilio) {

		return (List<Domicilio>) sessionFactory.getCurrentSession()
				.createCriteria(Domicilio.class).list();
	}

	/**
	 * Consulta informacion de domicilio y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Domicilio> listDomiciliosQuery(Domicilio domicilio, String query, int page, int size) {
		
		return (List<Domicilio>) sessionFactory.getCurrentSession()
			.createCriteria(Domicilio.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("domicilio", "%" + query +"%"),
Restrictions.like("domicilio", "%" + query +"%")),
Restrictions.like("domicilio", "%" + query +"%")),
Restrictions.like("ciudad", "%" + query +"%")),
Restrictions.like("de", "%" + query +"%")),
Restrictions.like("domicilio", "%" + query +"%")),
Restrictions.like("cp", "%" + query +"%")),
Restrictions.like("estado", "%" + query +"%")),
Restrictions.like("calle", "%" + query +"%")),
Restrictions.like("domicilio", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de domicilio y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Domicilio> listDomiciliosPagination(Domicilio domicilio, int page, int size) {
			return (List<Domicilio>) sessionFactory.getCurrentSession()
				.createCriteria(Domicilio.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de domicilio consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Domicilio.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de domicilio consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Domicilio.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("domicilio", "%" + query +"%"),Restrictions.like("domicilio", "%" + query +"%")),Restrictions.like("domicilio", "%" + query +"%")),Restrictions.like("ciudad", "%" + query +"%")),Restrictions.like("de", "%" + query +"%")),Restrictions.like("domicilio", "%" + query +"%")),Restrictions.like("cp", "%" + query +"%")),Restrictions.like("estado", "%" + query +"%")),Restrictions.like("calle", "%" + query +"%")),Restrictions.like("domicilio", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de domicilio consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Domicilio.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un domicilio.
	 */
	public Domicilio getDomicilio(int empid) {
		return (Domicilio) sessionFactory.getCurrentSession().get(
				Domicilio.class, empid);
	}

	/**
	 * Elimina un domicilio.
	 */
	public void deleteDomicilio(Domicilio domicilio) {
		sessionFactory.getCurrentSession().delete(domicilio);
	}

}
