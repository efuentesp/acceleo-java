/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los etiquetaasignada. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Etiquetaasignada;
import com.softtek.acceleo.demo.repository.EtiquetaasignadaRepository;
/**
 * Clase etiquetaasignadaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("etiquetaasignadaRepository")
public class EtiquetaasignadaRepositoryImpl implements EtiquetaasignadaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un etiquetaasignada.
	 */
	public void addEtiquetaasignada(Etiquetaasignada etiquetaasignada) {
		sessionFactory.getCurrentSession().persist(etiquetaasignada);
	}
	/**
	 * Edita un etiquetaasignada.
	 */
	public void editEtiquetaasignada(Etiquetaasignada etiquetaasignada) {
		sessionFactory.getCurrentSession().update(etiquetaasignada);

	}
	/**
	 * Consulta informacion de etiquetaasignada.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Etiquetaasignada> listEtiquetaasignadas(Etiquetaasignada etiquetaasignada) {

		return (List<Etiquetaasignada>) sessionFactory.getCurrentSession()
				.createCriteria(Etiquetaasignada.class).list();
	}

	/**
	 * Consulta informacion de etiquetaasignada y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Etiquetaasignada> listEtiquetaasignadasQuery(Etiquetaasignada etiquetaasignada, String query, int page, int size) {
		
		return (List<Etiquetaasignada>) sessionFactory.getCurrentSession()
			.createCriteria(Etiquetaasignada.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("f5", "%" + query +"%"),
Restrictions.like("etiquetaasignada", "%" + query +"%")),
Restrictions.like("para", "%" + query +"%")),
Restrictions.like("sap", "%" + query +"%")),
Restrictions.like("etiquetaasignada", "%" + query +"%")),
Restrictions.like("etiquetaasignada", "%" + query +"%")),
Restrictions.like("etiquetaasignadasxpalet", "%" + query +"%")),
Restrictions.like("multiplo1", "%" + query +"%")),
Restrictions.like("multiplo2", "%" + query +"%")),
Restrictions.like("de", "%" + query +"%")),
Restrictions.like("etiquetaasignada", "%" + query +"%")),
Restrictions.like("multiplo3", "%" + query +"%")),
Restrictions.like("etiquetaasignada", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de etiquetaasignada y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Etiquetaasignada> listEtiquetaasignadasPagination(Etiquetaasignada etiquetaasignada, int page, int size) {
			return (List<Etiquetaasignada>) sessionFactory.getCurrentSession()
				.createCriteria(Etiquetaasignada.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de etiquetaasignada consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Etiquetaasignada.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de etiquetaasignada consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Etiquetaasignada.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("f5", "%" + query +"%"),Restrictions.like("etiquetaasignada", "%" + query +"%")),Restrictions.like("para", "%" + query +"%")),Restrictions.like("sap", "%" + query +"%")),Restrictions.like("etiquetaasignada", "%" + query +"%")),Restrictions.like("etiquetaasignada", "%" + query +"%")),Restrictions.like("etiquetaasignadasxpalet", "%" + query +"%")),Restrictions.like("multiplo1", "%" + query +"%")),Restrictions.like("multiplo2", "%" + query +"%")),Restrictions.like("de", "%" + query +"%")),Restrictions.like("etiquetaasignada", "%" + query +"%")),Restrictions.like("multiplo3", "%" + query +"%")),Restrictions.like("etiquetaasignada", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de etiquetaasignada consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Etiquetaasignada.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un etiquetaasignada.
	 */
	public Etiquetaasignada getEtiquetaasignada(int empid) {
		return (Etiquetaasignada) sessionFactory.getCurrentSession().get(
				Etiquetaasignada.class, empid);
	}

	/**
	 * Elimina un etiquetaasignada.
	 */
	public void deleteEtiquetaasignada(Etiquetaasignada etiquetaasignada) {
		sessionFactory.getCurrentSession().delete(etiquetaasignada);
	}

}
