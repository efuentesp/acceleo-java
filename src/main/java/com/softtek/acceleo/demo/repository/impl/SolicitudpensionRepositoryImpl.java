/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los solicitudpension. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Solicitudpension;
import com.softtek.acceleo.demo.repository.SolicitudpensionRepository;
/**
 * Clase solicitudpensionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("solicitudpensionRepository")
public class SolicitudpensionRepositoryImpl implements SolicitudpensionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un solicitudpension.
	 */
	public void addSolicitudpension(Solicitudpension solicitudpension) {
		sessionFactory.getCurrentSession().persist(solicitudpension);
	}
	/**
	 * Edita un solicitudpension.
	 */
	public void editSolicitudpension(Solicitudpension solicitudpension) {
		sessionFactory.getCurrentSession().update(solicitudpension);

	}
	/**
	 * Consulta informacion de solicitudpension.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Solicitudpension> listSolicitudpensions(Solicitudpension solicitudpension) {

		return (List<Solicitudpension>) sessionFactory.getCurrentSession()
				.createCriteria(Solicitudpension.class).list();
	}

	/**
	 * Consulta informacion de solicitudpension y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Solicitudpension> listSolicitudpensionsQuery(Solicitudpension solicitudpension, String query, int page, int size) {
		
		return (List<Solicitudpension>) sessionFactory.getCurrentSession()
			.createCriteria(Solicitudpension.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("numero", "%" + query +"%"),
Restrictions.like("observaciones", "%" + query +"%")),
Restrictions.like("solicitudpension", "%" + query +"%")),
Restrictions.like("afiliado", "%" + query +"%")),
Restrictions.like("solicitudpension", "%" + query +"%")),
Restrictions.like("solicitudpension", "%" + query +"%")),
Restrictions.like("fecha_solicitud", "%" + query +"%")),
Restrictions.like("tipo", "%" + query +"%")),
Restrictions.like("solicitudpension", "%" + query +"%"))
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de solicitudpension y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Solicitudpension> listSolicitudpensionsPagination(Solicitudpension solicitudpension, int page, int size) {
			return (List<Solicitudpension>) sessionFactory.getCurrentSession()
				.createCriteria(Solicitudpension.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de solicitudpension consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Solicitudpension.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de solicitudpension consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Solicitudpension.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("numero", "%" + query +"%"),Restrictions.like("observaciones", "%" + query +"%")),Restrictions.like("solicitudpension", "%" + query +"%")),Restrictions.like("afiliado", "%" + query +"%")),Restrictions.like("solicitudpension", "%" + query +"%")),Restrictions.like("solicitudpension", "%" + query +"%")),Restrictions.like("fecha_solicitud", "%" + query +"%")),Restrictions.like("tipo", "%" + query +"%")),Restrictions.like("solicitudpension", "%" + query +"%"))	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de solicitudpension consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Solicitudpension.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un solicitudpension.
	 */
	public Solicitudpension getSolicitudpension(int empid) {
		return (Solicitudpension) sessionFactory.getCurrentSession().get(
				Solicitudpension.class, empid);
	}

	/**
	 * Elimina un solicitudpension.
	 */
	public void deleteSolicitudpension(Solicitudpension solicitudpension) {
		sessionFactory.getCurrentSession().delete(solicitudpension);
	}

}
