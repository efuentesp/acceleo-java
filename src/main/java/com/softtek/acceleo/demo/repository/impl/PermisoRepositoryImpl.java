/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los permiso. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Permiso;
import com.softtek.acceleo.demo.repository.PermisoRepository;
/**
 * Clase permisoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("permisoRepository")
public class PermisoRepositoryImpl implements PermisoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un permiso.
	 */
	public void addPermiso(Permiso permiso) {
		sessionFactory.getCurrentSession().persist(permiso);
	}
	/**
	 * Edita un permiso.
	 */
	public void editPermiso(Permiso permiso) {
		sessionFactory.getCurrentSession().update(permiso);

	}
	/**
	 * Consulta informacion de permiso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Permiso> listPermisos(Permiso permiso) {

		return (List<Permiso>) sessionFactory.getCurrentSession()
				.createCriteria(Permiso.class).list();
	}

	/**
	 * Consulta informacion de permiso y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Permiso> listPermisosQuery(Permiso permiso, String query, int page, int size) {
		
		return (List<Permiso>) sessionFactory.getCurrentSession()
			.createCriteria(Permiso.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("permiso", "%" + query +"%"),
Restrictions.like("ruta", "%" + query +"%")),
Restrictions.like("permiso", "%" + query +"%")),
Restrictions.like("permiso", "%" + query +"%")),
Restrictions.like("rol", "%" + query +"%")),
Restrictions.like("permiso", "%" + query +"%")),
Restrictions.like("funcion", "%" + query +"%")),
Restrictions.like("nivelpermiso", "%" + query +"%")),
Restrictions.like("permiso", "%" + query +"%"))
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de permiso y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Permiso> listPermisosPagination(Permiso permiso, int page, int size) {
			return (List<Permiso>) sessionFactory.getCurrentSession()
				.createCriteria(Permiso.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de permiso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Permiso.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de permiso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Permiso.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("permiso", "%" + query +"%"),Restrictions.like("ruta", "%" + query +"%")),Restrictions.like("permiso", "%" + query +"%")),Restrictions.like("permiso", "%" + query +"%")),Restrictions.like("rol", "%" + query +"%")),Restrictions.like("permiso", "%" + query +"%")),Restrictions.like("funcion", "%" + query +"%")),Restrictions.like("nivelpermiso", "%" + query +"%")),Restrictions.like("permiso", "%" + query +"%"))	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de permiso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Permiso.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un permiso.
	 */
	public Permiso getPermiso(int empid) {
		return (Permiso) sessionFactory.getCurrentSession().get(
				Permiso.class, empid);
	}

	/**
	 * Elimina un permiso.
	 */
	public void deletePermiso(Permiso permiso) {
		sessionFactory.getCurrentSession().delete(permiso);
	}

}
