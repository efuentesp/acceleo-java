/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los documentosfideicomiso. 
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
import com.softtek.acceleo.demo.domain.Documentosfideicomiso;
import com.softtek.acceleo.demo.repository.DocumentosfideicomisoRepository;

/**
 * Clase documentosfideicomisoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("documentosfideicomisoRepository")
public class DocumentosfideicomisoRepositoryImpl implements DocumentosfideicomisoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un documentosfideicomiso.
	 */
	public void addDocumentosfideicomiso(Documentosfideicomiso documentosfideicomiso) {
		sessionFactory.getCurrentSession().persist(documentosfideicomiso);
	}
	/**
	 * Edita un documentosfideicomiso.
	 */
	public void editDocumentosfideicomiso(Documentosfideicomiso documentosfideicomiso) {
		sessionFactory.getCurrentSession().update(documentosfideicomiso);
		
	}
	/**
	 * Consulta informacion de documentosfideicomiso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Documentosfideicomiso> listDocumentosfideicomisos(Documentosfideicomiso documentosfideicomiso) {
		List<Documentosfideicomiso> documentosfideicomisos = sessionFactory.getCurrentSession().createCriteria(Documentosfideicomiso.class).list();
		return documentosfideicomisos;
	}
	
	/**
	 * Consulta informacion de documentosfideicomiso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Documentosfideicomiso> listDocumentosfideicomisosByDocumentosfideicomiso(Documentosfideicomiso documentosfideicomiso, int id) {
		List<Documentosfideicomiso> documentosfideicomisos = 
		sessionFactory.getCurrentSession().createCriteria(Documentosfideicomiso.class)
		.add(Restrictions.like("documentosfideicomisoId",id)).list();
		return documentosfideicomisos;
	}
 
	/**
	 * Consulta informacion de documentosfideicomiso.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Documentosfideicomiso> listDocumentosfideicomisosByUsername(Documentosfideicomiso documentosfideicomiso, String id) {
		List<Documentosfideicomiso> documentosfideicomisos = sessionFactory.getCurrentSession().createCriteria(Documentosfideicomiso.class).add(Restrictions.like("username",id)).list();
		return documentosfideicomisos;
	}
	
	/**
	 * Consulta informacion de documentosfideicomiso y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Documentosfideicomiso> listDocumentosfideicomisosQuery(Documentosfideicomiso documentosfideicomiso, String query, int page, int size) {
		
		return (List<Documentosfideicomiso>) sessionFactory.getCurrentSession()
			.createCriteria(Documentosfideicomiso.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("documentosfideicomiso", "%" + query +"%"), 
			Restrictions.like("campo", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("contratofideicomiso", "%" + query +"%")),
			Restrictions.like("actasconstitutivas", "%" + query +"%")),
			Restrictions.like("cedulafiscal", "%" + query +"%")),
			Restrictions.like("poderes", "%" + query +"%")),
			Restrictions.like("identificadores", "%" + query +"%")),
			Restrictions.like("comprobantesdomicilio", "%" + query +"%")),
			Restrictions.like("formatoskyc", "%" + query +"%")),
			Restrictions.like("formatoevaluacionriesgo", "%" + query +"%")),
			Restrictions.like("worldcheck", "%" + query +"%")),
			Restrictions.like("formatoinformacion", "%" + query +"%")),
			Restrictions.like("autorizacioncomite", "%" + query +"%")),
			Restrictions.like("firmascomite", "%" + query +"%")),
			Restrictions.like("curp", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de documentosfideicomiso y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Documentosfideicomiso> listDocumentosfideicomisosPagination(Documentosfideicomiso documentosfideicomiso, int page, int size) {
			return (List<Documentosfideicomiso>) sessionFactory.getCurrentSession()
				.createCriteria(Documentosfideicomiso.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de documentosfideicomiso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Documentosfideicomiso.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de documentosfideicomiso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Documentosfideicomiso.class).setProjection(Projections.rowCount())
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
			Restrictions.like("documentosfideicomiso", "%" + query +"%"), 
			Restrictions.like("campo", "%" + query +"%")),
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("contratofideicomiso", "%" + query +"%")),
			Restrictions.like("actasconstitutivas", "%" + query +"%")),
			Restrictions.like("cedulafiscal", "%" + query +"%")),
			Restrictions.like("poderes", "%" + query +"%")),
			Restrictions.like("identificadores", "%" + query +"%")),
			Restrictions.like("comprobantesdomicilio", "%" + query +"%")),
			Restrictions.like("formatoskyc", "%" + query +"%")),
			Restrictions.like("formatoevaluacionriesgo", "%" + query +"%")),
			Restrictions.like("worldcheck", "%" + query +"%")),
			Restrictions.like("formatoinformacion", "%" + query +"%")),
			Restrictions.like("autorizacioncomite", "%" + query +"%")),
			Restrictions.like("firmascomite", "%" + query +"%")),
			Restrictions.like("curp", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de documentosfideicomiso consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Documentosfideicomiso.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un documentosfideicomiso.
	 */
	public Documentosfideicomiso getDocumentosfideicomiso(UUID empid) {
		return (Documentosfideicomiso) sessionFactory.getCurrentSession().get(
				Documentosfideicomiso.class, empid);
	}

	/**
	 * Elimina un documentosfideicomiso.
	 */
	public void deleteDocumentosfideicomiso(Documentosfideicomiso documentosfideicomiso) {
		sessionFactory.getCurrentSession().delete(documentosfideicomiso);
	}

}

