/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los estudiante. 
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
import com.softtek.acceleo.demo.domain.Estudiante;
import com.softtek.acceleo.demo.repository.EstudianteRepository;

/**
 * Clase estudianteRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("estudianteRepository")
public class EstudianteRepositoryImpl implements EstudianteRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un estudiante.
	 */
	public void addEstudiante(Estudiante estudiante) {
		sessionFactory.getCurrentSession().persist(estudiante);
	}
	/**
	 * Edita un estudiante.
	 */
	public void editEstudiante(Estudiante estudiante) {
		sessionFactory.getCurrentSession().update(estudiante);
		
	}
	/**
	 * Consulta informacion de estudiante.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Estudiante> listEstudiantes(Estudiante estudiante) {
		List<Estudiante> estudiantes = sessionFactory.getCurrentSession().createCriteria(Estudiante.class).list();
		return estudiantes;
	}
	
	/**
	 * Consulta informacion de estudiante.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Estudiante> listEstudiantesByEstudiante(Estudiante estudiante, int id) {
		List<Estudiante> estudiantes = 
		sessionFactory.getCurrentSession().createCriteria(Estudiante.class)
		.add(Restrictions.like("estudianteId",id)).list();
		return estudiantes;
	}
 
	/**
	 * Consulta informacion de estudiante.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Estudiante> listEstudiantesByUsername(Estudiante estudiante, String id) {
		List<Estudiante> estudiantes = sessionFactory.getCurrentSession().createCriteria(Estudiante.class).add(Restrictions.like("username",id)).list();
		return estudiantes;
	}
	
	/**
	 * Consulta informacion de estudiante y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Estudiante> listEstudiantesQuery(Estudiante estudiante, String query, int page, int size) {
		
		return (List<Estudiante>) sessionFactory.getCurrentSession()
			.createCriteria(Estudiante.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("estudiante", "%" + query +"%"), 
			Restrictions.like("concierneporId", "%" + query +"%")),
			Restrictions.like("estudianteId", "%" + query +"%")),
			Restrictions.like("matricula", "%" + query +"%")),
			Restrictions.like("nombreestudiante", "%" + query +"%")),
			Restrictions.like("apellidopaterno", "%" + query +"%")),
			Restrictions.like("fechanacimiento", "%" + query +"%")),
			Restrictions.like("genero", "%" + query +"%")),
			Restrictions.like("tiponivel", "%" + query +"%")),
			Restrictions.like("tipoarea", "%" + query +"%")),
			Restrictions.like("correoest", "%" + query +"%")),
			Restrictions.like("telefono", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de estudiante y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Estudiante> listEstudiantesPagination(Estudiante estudiante, int page, int size) {
			return (List<Estudiante>) sessionFactory.getCurrentSession()
				.createCriteria(Estudiante.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de estudiante consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Estudiante.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de estudiante consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Estudiante.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.like("estudiante", "%" + query +"%"), 
			Restrictions.like("concierneporId", "%" + query +"%")),
			Restrictions.like("estudianteId", "%" + query +"%")),
			Restrictions.like("matricula", "%" + query +"%")),
			Restrictions.like("nombreestudiante", "%" + query +"%")),
			Restrictions.like("apellidopaterno", "%" + query +"%")),
			Restrictions.like("fechanacimiento", "%" + query +"%")),
			Restrictions.like("genero", "%" + query +"%")),
			Restrictions.like("tiponivel", "%" + query +"%")),
			Restrictions.like("tipoarea", "%" + query +"%")),
			Restrictions.like("correoest", "%" + query +"%")),
			Restrictions.like("telefono", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de estudiante consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Estudiante.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un estudiante.
	 */
	public Estudiante getEstudiante(int empid) {
		return (Estudiante) sessionFactory.getCurrentSession().get(
				Estudiante.class, empid);
	}

	/**
	 * Elimina un estudiante.
	 */
	public void deleteEstudiante(Estudiante estudiante) {
		sessionFactory.getCurrentSession().delete(estudiante);
	}

}

