/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los instruccion. 
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
import com.softtek.acceleo.demo.domain.Instruccion;
import com.softtek.acceleo.demo.repository.InstruccionRepository;

/**
 * Clase instruccionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("instruccionRepository")
public class InstruccionRepositoryImpl implements InstruccionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un instruccion.
	 */
	public void addInstruccion(Instruccion instruccion) {
		sessionFactory.getCurrentSession().persist(instruccion);
	}
	/**
	 * Edita un instruccion.
	 */
	public void editInstruccion(Instruccion instruccion) {
		sessionFactory.getCurrentSession().update(instruccion);
		
	}
	/**
	 * Consulta informacion de instruccion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Instruccion> listInstruccions(Instruccion instruccion) {
		List<Instruccion> instruccions = sessionFactory.getCurrentSession().createCriteria(Instruccion.class).list();
		return instruccions;
	}
	
	/**
	 * Consulta informacion de instruccion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Instruccion> listInstruccionsByInstruccion(Instruccion instruccion, int id) {
		List<Instruccion> instruccions = 
		sessionFactory.getCurrentSession().createCriteria(Instruccion.class)
		.add(Restrictions.like("instruccionId",id)).list();
		return instruccions;
	}
 
	/**
	 * Consulta informacion de instruccion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Instruccion> listInstruccionsByUsername(Instruccion instruccion, String id) {
		List<Instruccion> instruccions = sessionFactory.getCurrentSession().createCriteria(Instruccion.class).add(Restrictions.like("username",id)).list();
		return instruccions;
	}
	
	/**
	 * Consulta informacion de instruccion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Instruccion> listInstruccionsQuery(Instruccion instruccion, String query, int page, int size) {
		
		return (List<Instruccion>) sessionFactory.getCurrentSession()
			.createCriteria(Instruccion.class).setFirstResult((page - 1) * size)
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
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("instruccion", "%" + query +"%"), 
			Restrictions.like("fechahoracaptura", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("folio", "%" + query +"%")),
			Restrictions.like("fechadocumeto", "%" + query +"%")),
			Restrictions.like("clasificacion", "%" + query +"%")),
			Restrictions.like("personalidadsolicitante", "%" + query +"%")),
			Restrictions.like("fechacambioestatus", "%" + query +"%")),
			Restrictions.like("subtipoinstruccion", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("importeaplicado", "%" + query +"%")),
			Restrictions.like("nombrefideicomiso", "%" + query +"%")),
			Restrictions.like("nombresubfiso", "%" + query +"%")),
			Restrictions.like("titularfideicomiso", "%" + query +"%")),
			Restrictions.like("fechacompromiso", "%" + query +"%")),
			Restrictions.like("formarecepcion", "%" + query +"%")),
			Restrictions.like("estatusinstruccion", "%" + query +"%")),
			Restrictions.like("tipoinstruccion", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("noeventos", "%" + query +"%")),
			Restrictions.like("noefectuados", "%" + query +"%")),
			Restrictions.like("infocomplementaria", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de instruccion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Instruccion> listInstruccionsPagination(Instruccion instruccion, int page, int size) {
			return (List<Instruccion>) sessionFactory.getCurrentSession()
				.createCriteria(Instruccion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de instruccion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Instruccion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de instruccion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Instruccion.class).setProjection(Projections.rowCount())
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
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("instruccion", "%" + query +"%"), 
			Restrictions.like("fechahoracaptura", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("folio", "%" + query +"%")),
			Restrictions.like("fechadocumeto", "%" + query +"%")),
			Restrictions.like("clasificacion", "%" + query +"%")),
			Restrictions.like("personalidadsolicitante", "%" + query +"%")),
			Restrictions.like("fechacambioestatus", "%" + query +"%")),
			Restrictions.like("subtipoinstruccion", "%" + query +"%")),
			Restrictions.like("importe", "%" + query +"%")),
			Restrictions.like("importeaplicado", "%" + query +"%")),
			Restrictions.like("nombrefideicomiso", "%" + query +"%")),
			Restrictions.like("nombresubfiso", "%" + query +"%")),
			Restrictions.like("titularfideicomiso", "%" + query +"%")),
			Restrictions.like("fechacompromiso", "%" + query +"%")),
			Restrictions.like("formarecepcion", "%" + query +"%")),
			Restrictions.like("estatusinstruccion", "%" + query +"%")),
			Restrictions.like("tipoinstruccion", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("noeventos", "%" + query +"%")),
			Restrictions.like("noefectuados", "%" + query +"%")),
			Restrictions.like("infocomplementaria", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de instruccion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Instruccion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un instruccion.
	 */
	public Instruccion getInstruccion(UUID empid) {
		return (Instruccion) sessionFactory.getCurrentSession().get(
				Instruccion.class, empid);
	}

	/**
	 * Elimina un instruccion.
	 */
	public void deleteInstruccion(Instruccion instruccion) {
		sessionFactory.getCurrentSession().delete(instruccion);
	}

}

