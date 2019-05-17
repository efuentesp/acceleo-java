/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los profesor. 
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
import com.softtek.acceleo.demo.domain.Profesor;
import com.softtek.acceleo.demo.repository.ProfesorRepository;

/**
 * Clase profesorRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("profesorRepository")
public class ProfesorRepositoryImpl implements ProfesorRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un profesor.
	 */
	public void addProfesor(Profesor profesor) {
		sessionFactory.getCurrentSession().persist(profesor);
	}
	/**
	 * Edita un profesor.
	 */
	public void editProfesor(Profesor profesor) {
		sessionFactory.getCurrentSession().update(profesor);
		
	}
	/**
	 * Consulta informacion de profesor.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Profesor> listProfesors(Profesor profesor) {
		List<Profesor> profesors = sessionFactory.getCurrentSession().createCriteria(Profesor.class).list();
		return profesors;
	}
	
	/**
	 * Consulta informacion de profesor.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Profesor> listProfesorsByProfesor(Profesor profesor, int id) {
		List<Profesor> profesors = 
		sessionFactory.getCurrentSession().createCriteria(Profesor.class)
		.add(Restrictions.like("profesorId",id)).list();
		return profesors;
	}
 
	/**
	 * Consulta informacion de profesor.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Profesor> listProfesorsByUsername(Profesor profesor, String id) {
		List<Profesor> profesors = sessionFactory.getCurrentSession().createCriteria(Profesor.class).add(Restrictions.like("username",id)).list();
		return profesors;
	}
	
	/**
	 * Consulta informacion de profesor y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Profesor> listProfesorsQuery(Profesor profesor, String query, int page, int size) {
		
		return (List<Profesor>) sessionFactory.getCurrentSession()
			.createCriteria(Profesor.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("profesor", "%" + query +"%"), 
			Restrictions.like("profesorId", "%" + query +"%")),
			Restrictions.like("noempleado", "%" + query +"%")),
			Restrictions.like("nombreprofesor", "%" + query +"%")),
			Restrictions.like("apellidopaterno", "%" + query +"%")),
			Restrictions.like("rfc", "%" + query +"%")),
			Restrictions.like("correopro", "%" + query +"%")),
			Restrictions.like("telefono", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de profesor y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Profesor> listProfesorsPagination(Profesor profesor, int page, int size) {
			return (List<Profesor>) sessionFactory.getCurrentSession()
				.createCriteria(Profesor.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de profesor consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Profesor.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de profesor consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Profesor.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("profesor", "%" + query +"%"), 
			Restrictions.like("profesorId", "%" + query +"%")),
			Restrictions.like("noempleado", "%" + query +"%")),
			Restrictions.like("nombreprofesor", "%" + query +"%")),
			Restrictions.like("apellidopaterno", "%" + query +"%")),
			Restrictions.like("rfc", "%" + query +"%")),
			Restrictions.like("correopro", "%" + query +"%")),
			Restrictions.like("telefono", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de profesor consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Profesor.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un profesor.
	 */
	public Profesor getProfesor(int empid) {
		return (Profesor) sessionFactory.getCurrentSession().get(
				Profesor.class, empid);
	}

	/**
	 * Elimina un profesor.
	 */
	public void deleteProfesor(Profesor profesor) {
		sessionFactory.getCurrentSession().delete(profesor);
	}

}

