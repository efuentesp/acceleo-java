/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los posicion. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Posicion;
import com.softtek.acceleo.demo.repository.PosicionRepository;
/**
 * Clase posicionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("posicionRepository")
public class PosicionRepositoryImpl implements PosicionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un posicion.
	 */
	public void addPosicion(Posicion posicion) {
		sessionFactory.getCurrentSession().persist(posicion);
	}
	/**
	 * Edita un posicion.
	 */
	public void editPosicion(Posicion posicion) {
		sessionFactory.getCurrentSession().update(posicion);

	}
	/**
	 * Consulta informacion de posicion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Posicion> listPosicions(Posicion posicion) {

		return (List<Posicion>) sessionFactory.getCurrentSession()
				.createCriteria(Posicion.class).list();
	}

	/**
	 * Consulta informacion de posicion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Posicion> listPosicionsQuery(Posicion posicion, String query, int page, int size) {
		
		return (List<Posicion>) sessionFactory.getCurrentSession()
			.createCriteria(Posicion.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("reclutador", "%" + query +"%"),
Restrictions.like("posicion", "%" + query +"%")),
Restrictions.like("descripcion", "%" + query +"%")),
Restrictions.like("posicion", "%" + query +"%")),
Restrictions.like("contacto", "%" + query +"%")),
Restrictions.like("evento", "%" + query +"%")),
Restrictions.like("salario", "%" + query +"%")),
Restrictions.like("posicion", "%" + query +"%")),
Restrictions.like("puesto", "%" + query +"%")),
Restrictions.like("vacantes", "%" + query +"%")),
Restrictions.like("solicitud", "%" + query +"%")),
Restrictions.like("tipo", "%" + query +"%")),
Restrictions.like("posicion", "%" + query +"%")),
Restrictions.like("nombre", "%" + query +"%")),
Restrictions.like("fecha", "%" + query +"%")),
Restrictions.like("estado", "%" + query +"%")),
Restrictions.like("filial", "%" + query +"%")),
Restrictions.like("posicion", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de posicion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Posicion> listPosicionsPagination(Posicion posicion, int page, int size) {
			return (List<Posicion>) sessionFactory.getCurrentSession()
				.createCriteria(Posicion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de posicion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Posicion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de posicion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Posicion.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("reclutador", "%" + query +"%"),Restrictions.like("posicion", "%" + query +"%")),Restrictions.like("descripcion", "%" + query +"%")),Restrictions.like("posicion", "%" + query +"%")),Restrictions.like("contacto", "%" + query +"%")),Restrictions.like("evento", "%" + query +"%")),Restrictions.like("salario", "%" + query +"%")),Restrictions.like("posicion", "%" + query +"%")),Restrictions.like("puesto", "%" + query +"%")),Restrictions.like("vacantes", "%" + query +"%")),Restrictions.like("solicitud", "%" + query +"%")),Restrictions.like("tipo", "%" + query +"%")),Restrictions.like("posicion", "%" + query +"%")),Restrictions.like("nombre", "%" + query +"%")),Restrictions.like("fecha", "%" + query +"%")),Restrictions.like("estado", "%" + query +"%")),Restrictions.like("filial", "%" + query +"%")),Restrictions.like("posicion", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de posicion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Posicion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un posicion.
	 */
	public Posicion getPosicion(int empid) {
		return (Posicion) sessionFactory.getCurrentSession().get(
				Posicion.class, empid);
	}

	/**
	 * Elimina un posicion.
	 */
	public void deletePosicion(Posicion posicion) {
		sessionFactory.getCurrentSession().delete(posicion);
	}

}
