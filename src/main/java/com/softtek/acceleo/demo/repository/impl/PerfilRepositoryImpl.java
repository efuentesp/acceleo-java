/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los perfil. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Perfil;
import com.softtek.acceleo.demo.repository.PerfilRepository;
/**
 * Clase perfilRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("perfilRepository")
public class PerfilRepositoryImpl implements PerfilRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un perfil.
	 */
	public void addPerfil(Perfil perfil) {
		sessionFactory.getCurrentSession().persist(perfil);
	}
	/**
	 * Edita un perfil.
	 */
	public void editPerfil(Perfil perfil) {
		sessionFactory.getCurrentSession().update(perfil);

	}
	/**
	 * Consulta informacion de perfil.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Perfil> listPerfils(Perfil perfil) {

		return (List<Perfil>) sessionFactory.getCurrentSession()
				.createCriteria(Perfil.class).list();
	}

	/**
	 * Consulta informacion de perfil y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Perfil> listPerfilsQuery(Perfil perfil, String query, int page, int size) {
		
		return (List<Perfil>) sessionFactory.getCurrentSession()
			.createCriteria(Perfil.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("perfil", "%" + query +"%"),
Restrictions.like("nip", "%" + query +"%")),
Restrictions.like("perfil", "%" + query +"%")),
Restrictions.like("perfil", "%" + query +"%")),
Restrictions.like("perfil", "%" + query +"%")),
Restrictions.like("de", "%" + query +"%")),
Restrictions.like("usuario", "%" + query +"%")),
Restrictions.like("perfil", "%" + query +"%"))
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de perfil y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Perfil> listPerfilsPagination(Perfil perfil, int page, int size) {
			return (List<Perfil>) sessionFactory.getCurrentSession()
				.createCriteria(Perfil.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de perfil consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Perfil.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de perfil consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Perfil.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("perfil", "%" + query +"%"),Restrictions.like("nip", "%" + query +"%")),Restrictions.like("perfil", "%" + query +"%")),Restrictions.like("perfil", "%" + query +"%")),Restrictions.like("perfil", "%" + query +"%")),Restrictions.like("de", "%" + query +"%")),Restrictions.like("usuario", "%" + query +"%")),Restrictions.like("perfil", "%" + query +"%"))	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de perfil consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Perfil.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un perfil.
	 */
	public Perfil getPerfil(int empid) {
		return (Perfil) sessionFactory.getCurrentSession().get(
				Perfil.class, empid);
	}

	/**
	 * Elimina un perfil.
	 */
	public void deletePerfil(Perfil perfil) {
		sessionFactory.getCurrentSession().delete(perfil);
	}

}
