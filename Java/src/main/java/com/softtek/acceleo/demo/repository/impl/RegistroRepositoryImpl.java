/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los registro. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.softtek.acceleo.demo.domain.Registro;
import com.softtek.acceleo.demo.repository.RegistroRepository;

/**
 * Clase registroRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("registroRepository")
public class RegistroRepositoryImpl implements RegistroRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un registro.
	 */
	public void addRegistro(Registro registro) {
		sessionFactory.getCurrentSession().persist(registro);
	}
	/**
	 * Edita un registro.
	 */
	public void editRegistro(Registro registro) {
		sessionFactory.getCurrentSession().update(registro);
		
	}
	/**
	 * Consulta informacion de registro.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Registro> listRegistros(Registro registro) {
		List<Registro> registros = sessionFactory.getCurrentSession().createCriteria(Registro.class).list();
		return registros;
	}
	
	/**
	 * Consulta informacion de registro.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Registro> listRegistrosByRegistro(Registro registro, int id) {
		List<Registro> registros = 
		sessionFactory.getCurrentSession().createCriteria(Registro.class)
		.add(Restrictions.like("registroId",id)).list();
		return registros;
	}
 
	/**
	 * Consulta informacion de registro.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Registro> listRegistrosByUsername(Registro registro, String id) {
		List<Registro> registros = sessionFactory.getCurrentSession().createCriteria(Registro.class).add(Restrictions.like("username",id)).list();
		return registros;
	}
	
	/**
	 * Consulta informacion de registro y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Registro> listRegistrosQuery(Registro registro, String query, int page, int size) {
		
		return (List<Registro>) sessionFactory.getCurrentSession()
			.createCriteria(Registro.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("registro", "%" + query +"%"), 
			Restrictions.like("confirmadoId", "%" + query +"%")),
			Restrictions.like("inscritoporId", "%" + query +"%")),
			Restrictions.like("numconfirmacion", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de registro y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Registro> listRegistrosPagination(Registro registro, int page, int size) {
			return (List<Registro>) sessionFactory.getCurrentSession()
				.createCriteria(Registro.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de registro consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Registro.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de registro consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Registro.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("registro", "%" + query +"%"), 
			Restrictions.like("confirmadoId", "%" + query +"%")),
			Restrictions.like("inscritoporId", "%" + query +"%")),
			Restrictions.like("numconfirmacion", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de registro consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Registro.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un registro.
	 */
	public Registro getRegistro(int empid) {
		return (Registro) sessionFactory.getCurrentSession().get(
				Registro.class, empid);
	}

	/**
	 * Elimina un registro.
	 */
	public void deleteRegistro(Registro registro) {
		sessionFactory.getCurrentSession().delete(registro);
	}

}

