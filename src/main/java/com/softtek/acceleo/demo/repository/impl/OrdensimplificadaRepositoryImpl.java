/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los ordensimplificada. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Ordensimplificada;
import com.softtek.acceleo.demo.repository.OrdensimplificadaRepository;
/**
 * Clase ordensimplificadaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("ordensimplificadaRepository")
public class OrdensimplificadaRepositoryImpl implements OrdensimplificadaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un ordensimplificada.
	 */
	public void addOrdensimplificada(Ordensimplificada ordensimplificada) {
		sessionFactory.getCurrentSession().persist(ordensimplificada);
	}
	/**
	 * Edita un ordensimplificada.
	 */
	public void editOrdensimplificada(Ordensimplificada ordensimplificada) {
		sessionFactory.getCurrentSession().update(ordensimplificada);

	}
	/**
	 * Consulta informacion de ordensimplificada.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Ordensimplificada> listOrdensimplificadas(Ordensimplificada ordensimplificada) {

		return (List<Ordensimplificada>) sessionFactory.getCurrentSession()
				.createCriteria(Ordensimplificada.class).list();
	}

	/**
	 * Consulta informacion de ordensimplificada y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Ordensimplificada> listOrdensimplificadasQuery(Ordensimplificada ordensimplificada, String query, int page, int size) {
		
		return (List<Ordensimplificada>) sessionFactory.getCurrentSession()
			.createCriteria(Ordensimplificada.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("sap", "%" + query +"%"),
Restrictions.like("ordensimplificada", "%" + query +"%")),
Restrictions.like("estado2", "%" + query +"%")),
Restrictions.like("ordensimplificada", "%" + query +"%")),
Restrictions.like("de", "%" + query +"%")),
Restrictions.like("ordensimplificada", "%" + query +"%")),
Restrictions.like("ordensimplificada", "%" + query +"%")),
Restrictions.like("destinomercancia", "%" + query +"%")),
Restrictions.like("comentario", "%" + query +"%")),
Restrictions.like("linea", "%" + query +"%")),
Restrictions.like("cantidadprogramada", "%" + query +"%")),
Restrictions.like("ordensimplificada", "%" + query +"%")),
Restrictions.like("ordentrabajo", "%" + query +"%")),
Restrictions.like("operador", "%" + query +"%")),
Restrictions.like("estado", "%" + query +"%")),
Restrictions.like("supervisor", "%" + query +"%")),
Restrictions.like("fechafinal", "%" + query +"%")),
Restrictions.like("cantidadproducida", "%" + query +"%")),
Restrictions.like("fechainicial", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de ordensimplificada y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Ordensimplificada> listOrdensimplificadasPagination(Ordensimplificada ordensimplificada, int page, int size) {
			return (List<Ordensimplificada>) sessionFactory.getCurrentSession()
				.createCriteria(Ordensimplificada.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de ordensimplificada consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Ordensimplificada.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de ordensimplificada consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Ordensimplificada.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("sap", "%" + query +"%"),Restrictions.like("ordensimplificada", "%" + query +"%")),Restrictions.like("estado2", "%" + query +"%")),Restrictions.like("ordensimplificada", "%" + query +"%")),Restrictions.like("de", "%" + query +"%")),Restrictions.like("ordensimplificada", "%" + query +"%")),Restrictions.like("ordensimplificada", "%" + query +"%")),Restrictions.like("destinomercancia", "%" + query +"%")),Restrictions.like("comentario", "%" + query +"%")),Restrictions.like("linea", "%" + query +"%")),Restrictions.like("cantidadprogramada", "%" + query +"%")),Restrictions.like("ordensimplificada", "%" + query +"%")),Restrictions.like("ordentrabajo", "%" + query +"%")),Restrictions.like("operador", "%" + query +"%")),Restrictions.like("estado", "%" + query +"%")),Restrictions.like("supervisor", "%" + query +"%")),Restrictions.like("fechafinal", "%" + query +"%")),Restrictions.like("cantidadproducida", "%" + query +"%")),Restrictions.like("fechainicial", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de ordensimplificada consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Ordensimplificada.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un ordensimplificada.
	 */
	public Ordensimplificada getOrdensimplificada(int empid) {
		return (Ordensimplificada) sessionFactory.getCurrentSession().get(
				Ordensimplificada.class, empid);
	}

	/**
	 * Elimina un ordensimplificada.
	 */
	public void deleteOrdensimplificada(Ordensimplificada ordensimplificada) {
		sessionFactory.getCurrentSession().delete(ordensimplificada);
	}

}
