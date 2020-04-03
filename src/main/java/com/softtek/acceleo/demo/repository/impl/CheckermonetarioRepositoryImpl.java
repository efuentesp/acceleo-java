/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los checkermonetario. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.softtek.acceleo.demo.domain.Checkermonetario;
import com.softtek.acceleo.demo.repository.CheckermonetarioRepository;

/**
 * Clase checkermonetarioRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("checkermonetarioRepository")
public class CheckermonetarioRepositoryImpl implements CheckermonetarioRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un checkermonetario.
	 */
	public void addCheckermonetario(Checkermonetario checkermonetario) {
		sessionFactory.getCurrentSession().persist(checkermonetario);
	}
	/**
	 * Edita un checkermonetario.
	 */
	public void editCheckermonetario(Checkermonetario checkermonetario) {
		sessionFactory.getCurrentSession().update(checkermonetario);
		
	}
	/**
	 * Consulta informacion de checkermonetario.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Checkermonetario> listCheckermonetarios(Checkermonetario checkermonetario) {
		List<Checkermonetario> checkermonetarios = sessionFactory.getCurrentSession().createCriteria(Checkermonetario.class).list();
		return checkermonetarios;
	}
	
	/**
	 * Consulta informacion de checkermonetario.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Checkermonetario> listCheckermonetariosByCheckermonetario(Checkermonetario checkermonetario, int id) {
		List<Checkermonetario> checkermonetarios = 
		sessionFactory.getCurrentSession().createCriteria(Checkermonetario.class)
		.add(Restrictions.like("checkermonetarioId",id)).list();
		return checkermonetarios;
	}
 
	/**
	 * Consulta informacion de checkermonetario.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Checkermonetario> listCheckermonetariosByUsername(Checkermonetario checkermonetario, String id) {
		List<Checkermonetario> checkermonetarios = sessionFactory.getCurrentSession().createCriteria(Checkermonetario.class).add(Restrictions.like("username",id)).list();
		return checkermonetarios;
	}
	
	/**
	 * Consulta informacion de checkermonetario y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Checkermonetario> listCheckermonetariosQuery(Checkermonetario checkermonetario, String query, int page, int size) {
		
		return (List<Checkermonetario>) sessionFactory.getCurrentSession()
			.createCriteria(Checkermonetario.class).setFirstResult((page - 1) * size)
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
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("checkermonetario", "%" + query +"%"), 
			Restrictions.like("foliooperacion", "%" + query +"%")),
			Restrictions.like("operador", "%" + query +"%")),
			Restrictions.like("tipoliquidacion", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("instruccionId", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("fechapago", "%" + query +"%")),
			Restrictions.like("numeroliquidaciones", "%" + query +"%")),
			Restrictions.like("transaccionId", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("fecha", "%" + query +"%")),
			Restrictions.like("operado", "%" + query +"%")),
			Restrictions.like("autorizo", "%" + query +"%")),
			Restrictions.like("fechaautorizado", "%" + query +"%")),
			Restrictions.like("numerofirma", "%" + query +"%")),
			Restrictions.like("nombrefirma", "%" + query +"%")),
			Restrictions.like("fechafirma", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de checkermonetario y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Checkermonetario> listCheckermonetariosPagination(Checkermonetario checkermonetario, int page, int size) {
			return (List<Checkermonetario>) sessionFactory.getCurrentSession()
				.createCriteria(Checkermonetario.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de checkermonetario consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Checkermonetario.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de checkermonetario consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Checkermonetario.class).setProjection(Projections.rowCount())
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
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("checkermonetario", "%" + query +"%"), 
			Restrictions.like("foliooperacion", "%" + query +"%")),
			Restrictions.like("operador", "%" + query +"%")),
			Restrictions.like("tipoliquidacion", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("instruccionId", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("fechapago", "%" + query +"%")),
			Restrictions.like("numeroliquidaciones", "%" + query +"%")),
			Restrictions.like("transaccionId", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("fecha", "%" + query +"%")),
			Restrictions.like("operado", "%" + query +"%")),
			Restrictions.like("autorizo", "%" + query +"%")),
			Restrictions.like("fechaautorizado", "%" + query +"%")),
			Restrictions.like("numerofirma", "%" + query +"%")),
			Restrictions.like("nombrefirma", "%" + query +"%")),
			Restrictions.like("fechafirma", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de checkermonetario consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Checkermonetario.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un checkermonetario.
	 */
	public Checkermonetario getCheckermonetario(UUID empid) {
		return (Checkermonetario) sessionFactory.getCurrentSession().get(
				Checkermonetario.class, empid);
	}

	/**
	 * Elimina un checkermonetario.
	 */
	public void deleteCheckermonetario(Checkermonetario checkermonetario) {
		sessionFactory.getCurrentSession().delete(checkermonetario);
	}

}

