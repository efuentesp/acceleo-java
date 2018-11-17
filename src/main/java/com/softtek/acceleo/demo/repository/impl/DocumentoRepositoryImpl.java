/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los documento. 
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
import com.softtek.acceleo.demo.domain.Documento;
import com.softtek.acceleo.demo.repository.DocumentoRepository;

/**
 * Clase documentoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("documentoRepository")
public class DocumentoRepositoryImpl implements DocumentoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un documento.
	 */
	public void addDocumento(Documento documento) {
		sessionFactory.getCurrentSession().persist(documento);
	}
	/**
	 * Edita un documento.
	 */
	public void editDocumento(Documento documento) {
		sessionFactory.getCurrentSession().update(documento);
		
	}
	/**
	 * Consulta informacion de documento.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Documento> listDocumentos(Documento documento) {
		List<Documento> documentos = sessionFactory.getCurrentSession().createCriteria(Documento.class).list();
		return documentos;
	}
	
	/**
	 * Consulta informacion de documento.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Documento> listDocumentosByDocumento(Documento documento, int id) {
		List<Documento> documentos = 
		sessionFactory.getCurrentSession().createCriteria(Documento.class)
		.add(Restrictions.like("documentoId",id)).list();
		return documentos;
	}
 
	/**
	 * Consulta informacion de documento.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Documento> listDocumentosByUsername(Documento documento, String id) {
		List<Documento> documentos = sessionFactory.getCurrentSession().createCriteria(Documento.class).add(Restrictions.like("username",id)).list();
		return documentos;
	}
	
	/**
	 * Consulta informacion de documento y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Documento> listDocumentosQuery(Documento documento, String query, int page, int size) {
		
		return (List<Documento>) sessionFactory.getCurrentSession()
			.createCriteria(Documento.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("documento", "%" + query +"%"), 
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("descripcion", "%" + query +"%")),
			Restrictions.like("size", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de documento y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Documento> listDocumentosPagination(Documento documento, int page, int size) {
			return (List<Documento>) sessionFactory.getCurrentSession()
				.createCriteria(Documento.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de documento consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Documento.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de documento consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Documento.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("documento", "%" + query +"%"), 
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("descripcion", "%" + query +"%")),
			Restrictions.like("size", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de documento consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Documento.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un documento.
	 */
	public Documento getDocumento(UUID empid) {
		return (Documento) sessionFactory.getCurrentSession().get(
				Documento.class, empid);
	}

	/**
	 * Elimina un documento.
	 */
	public void deleteDocumento(Documento documento) {
		sessionFactory.getCurrentSession().delete(documento);
	}

}

