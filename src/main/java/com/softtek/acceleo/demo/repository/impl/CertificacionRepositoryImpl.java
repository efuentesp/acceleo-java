/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los certificacion. 
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
import com.softtek.acceleo.demo.domain.Certificacion;
import com.softtek.acceleo.demo.repository.CertificacionRepository;

/**
 * Clase certificacionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("certificacionRepository")
public class CertificacionRepositoryImpl implements CertificacionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un certificacion.
	 */
	public void addCertificacion(Certificacion certificacion) {
		sessionFactory.getCurrentSession().persist(certificacion);
	}
	/**
	 * Edita un certificacion.
	 */
	public void editCertificacion(Certificacion certificacion) {
		sessionFactory.getCurrentSession().update(certificacion);
		
	}
	/**
	 * Consulta informacion de certificacion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Certificacion> listCertificacions(Certificacion certificacion) {
		List<Certificacion> certificacions = sessionFactory.getCurrentSession().createCriteria(Certificacion.class).list();
		return certificacions;
	}
	
	/**
	 * Consulta informacion de certificacion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Certificacion> listCertificacionsByCertificacion(Certificacion certificacion, int id) {
		List<Certificacion> certificacions = 
		sessionFactory.getCurrentSession().createCriteria(Certificacion.class)
		.add(Restrictions.like("certificacionId",id)).list();
		return certificacions;
	}
 
	/**
	 * Consulta informacion de certificacion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Certificacion> listCertificacionsByUsername(Certificacion certificacion, String id) {
		List<Certificacion> certificacions = sessionFactory.getCurrentSession().createCriteria(Certificacion.class).add(Restrictions.like("username",id)).list();
		return certificacions;
	}
	
	/**
	 * Consulta informacion de certificacion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Certificacion> listCertificacionsQuery(Certificacion certificacion, String query, int page, int size) {
		
		return (List<Certificacion>) sessionFactory.getCurrentSession()
			.createCriteria(Certificacion.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("certificacion", "%" + query +"%"), 
			Restrictions.like("tieneId", "%" + query +"%")),
			Restrictions.like("sonId", "%" + query +"%")),
			Restrictions.like("idcertificacion", "%" + query +"%")),
			Restrictions.like("fechacertificacion", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de certificacion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Certificacion> listCertificacionsPagination(Certificacion certificacion, int page, int size) {
			return (List<Certificacion>) sessionFactory.getCurrentSession()
				.createCriteria(Certificacion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de certificacion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Certificacion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de certificacion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Certificacion.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("certificacion", "%" + query +"%"), 
			Restrictions.like("tieneId", "%" + query +"%")),
			Restrictions.like("sonId", "%" + query +"%")),
			Restrictions.like("idcertificacion", "%" + query +"%")),
			Restrictions.like("fechacertificacion", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de certificacion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Certificacion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un certificacion.
	 */
	public Certificacion getCertificacion(int empid) {
		return (Certificacion) sessionFactory.getCurrentSession().get(
				Certificacion.class, empid);
	}

	/**
	 * Elimina un certificacion.
	 */
	public void deleteCertificacion(Certificacion certificacion) {
		sessionFactory.getCurrentSession().delete(certificacion);
	}

}

