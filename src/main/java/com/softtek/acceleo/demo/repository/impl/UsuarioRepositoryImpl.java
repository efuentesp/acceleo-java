/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los usuario. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Usuario;
import com.softtek.acceleo.demo.repository.UsuarioRepository;
/**
 * Clase usuarioRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("usuarioRepository")
public class UsuarioRepositoryImpl implements UsuarioRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un usuario.
	 */
	public void addUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().persist(usuario);
	}
	/**
	 * Edita un usuario.
	 */
	public void editUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().update(usuario);

	}
	/**
	 * Consulta informacion de usuario.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Usuario> listUsuarios(Usuario usuario) {

		return (List<Usuario>) sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class).list();
	}

	/**
	 * Consulta informacion de usuario y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> listUsuariosQuery(Usuario usuario, String query, int page, int size) {
		
		return (List<Usuario>) sessionFactory.getCurrentSession()
			.createCriteria(Usuario.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("usuario", "%" + query +"%"),
Restrictions.like("activo", "%" + query +"%")),
Restrictions.like("usuario", "%" + query +"%")),
Restrictions.like("usuario", "%" + query +"%")),
Restrictions.like("usuario", "%" + query +"%")),
Restrictions.like("nombreclave", "%" + query +"%")),
Restrictions.like("usuario", "%" + query +"%")),
Restrictions.like("rol", "%" + query +"%")),
Restrictions.like("password", "%" + query +"%"))
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de usuario y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> listUsuariosPagination(Usuario usuario, int page, int size) {
			return (List<Usuario>) sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de usuario consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Usuario.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de usuario consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Usuario.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("usuario", "%" + query +"%"),Restrictions.like("activo", "%" + query +"%")),Restrictions.like("usuario", "%" + query +"%")),Restrictions.like("usuario", "%" + query +"%")),Restrictions.like("usuario", "%" + query +"%")),Restrictions.like("nombreclave", "%" + query +"%")),Restrictions.like("usuario", "%" + query +"%")),Restrictions.like("rol", "%" + query +"%")),Restrictions.like("password", "%" + query +"%"))	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de usuario consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Usuario.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un usuario.
	 */
	public Usuario getUsuario(int empid) {
		return (Usuario) sessionFactory.getCurrentSession().get(
				Usuario.class, empid);
	}

	/**
	 * Elimina un usuario.
	 */
	public void deleteUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().delete(usuario);
	}

}
