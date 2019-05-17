/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los programa. 
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
import com.softtek.acceleo.demo.domain.Programa;
import com.softtek.acceleo.demo.repository.ProgramaRepository;

/**
 * Clase programaRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("programaRepository")
public class ProgramaRepositoryImpl implements ProgramaRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un programa.
	 */
	public void addPrograma(Programa programa) {
		sessionFactory.getCurrentSession().persist(programa);
	}
	/**
	 * Edita un programa.
	 */
	public void editPrograma(Programa programa) {
		sessionFactory.getCurrentSession().update(programa);
		
	}
	/**
	 * Consulta informacion de programa.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Programa> listProgramas(Programa programa) {
		List<Programa> programas = sessionFactory.getCurrentSession().createCriteria(Programa.class).list();
		return programas;
	}
	
	/**
	 * Consulta informacion de programa.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Programa> listProgramasByPrograma(Programa programa, int id) {
		List<Programa> programas = 
		sessionFactory.getCurrentSession().createCriteria(Programa.class)
		.add(Restrictions.like("programaId",id)).list();
		return programas;
	}
 
	/**
	 * Consulta informacion de programa.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Programa> listProgramasByUsername(Programa programa, String id) {
		List<Programa> programas = sessionFactory.getCurrentSession().createCriteria(Programa.class).add(Restrictions.like("username",id)).list();
		return programas;
	}
	
	/**
	 * Consulta informacion de programa y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Programa> listProgramasQuery(Programa programa, String query, int page, int size) {
		
		return (List<Programa>) sessionFactory.getCurrentSession()
			.createCriteria(Programa.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("programa", "%" + query +"%"), 
			Restrictions.like("programaId", "%" + query +"%")),
			Restrictions.like("programaId", "%" + query +"%")),
			Restrictions.like("clave", "%" + query +"%")),
			Restrictions.like("nombreprograma", "%" + query +"%")),
			Restrictions.like("tipoestatus", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de programa y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Programa> listProgramasPagination(Programa programa, int page, int size) {
			return (List<Programa>) sessionFactory.getCurrentSession()
				.createCriteria(Programa.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de programa consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Programa.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de programa consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Programa.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("programa", "%" + query +"%"), 
			Restrictions.like("programaId", "%" + query +"%")),
			Restrictions.like("programaId", "%" + query +"%")),
			Restrictions.like("clave", "%" + query +"%")),
			Restrictions.like("nombreprograma", "%" + query +"%")),
			Restrictions.like("tipoestatus", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de programa consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Programa.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un programa.
	 */
	public Programa getPrograma(int empid) {
		return (Programa) sessionFactory.getCurrentSession().get(
				Programa.class, empid);
	}

	/**
	 * Elimina un programa.
	 */
	public void deletePrograma(Programa programa) {
		sessionFactory.getCurrentSession().delete(programa);
	}

}

