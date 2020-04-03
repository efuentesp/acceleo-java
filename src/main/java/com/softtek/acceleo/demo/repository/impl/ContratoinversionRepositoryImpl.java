/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los contratoinversion. 
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
import com.softtek.acceleo.demo.domain.Contratoinversion;
import com.softtek.acceleo.demo.repository.ContratoinversionRepository;

/**
 * Clase contratoinversionRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("contratoinversionRepository")
public class ContratoinversionRepositoryImpl implements ContratoinversionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un contratoinversion.
	 */
	public void addContratoinversion(Contratoinversion contratoinversion) {
		sessionFactory.getCurrentSession().persist(contratoinversion);
	}
	/**
	 * Edita un contratoinversion.
	 */
	public void editContratoinversion(Contratoinversion contratoinversion) {
		sessionFactory.getCurrentSession().update(contratoinversion);
		
	}
	/**
	 * Consulta informacion de contratoinversion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Contratoinversion> listContratoinversions(Contratoinversion contratoinversion) {
		System.out.println("++++++++++  contratoinversion.getContratoiversion(): " + contratoinversion.getContratoiversion());
		List<Contratoinversion> contratoinversions = sessionFactory.getCurrentSession().createCriteria(Contratoinversion.class).list();
		return contratoinversions;
	}
	
	/**
	 * Consulta informacion de contratoinversion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Contratoinversion> listContratoinversionsByContratoinversion(Contratoinversion contratoinversion, int id) {
		List<Contratoinversion> contratoinversions = 
		sessionFactory.getCurrentSession().createCriteria(Contratoinversion.class)
		.add(Restrictions.like("contratoinversionId",id)).list();
		return contratoinversions;
	}
 
	/**
	 * Consulta informacion de contratoinversion.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Contratoinversion> listContratoinversionsByUsername(Contratoinversion contratoinversion, String id) {
		List<Contratoinversion> contratoinversions = sessionFactory.getCurrentSession().createCriteria(Contratoinversion.class).add(Restrictions.like("username",id)).list();
		return contratoinversions;
	}
	
	/**
	 * Consulta informacion de contratoinversion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Contratoinversion> listContratoinversionsQuery(Contratoinversion contratoinversion, String query, int page, int size) {
		
		return (List<Contratoinversion>) sessionFactory.getCurrentSession()
			.createCriteria(Contratoinversion.class).setFirstResult((page - 1) * size)
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
			Restrictions.like("contratoinversion", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("tipocontrato", "%" + query +"%")),
			Restrictions.like("intermediario", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("resparamliq", "%" + query +"%")),
			Restrictions.like("enviorecursosinv", "%" + query +"%")),
			Restrictions.like("transferenciarecdesinver", "%" + query +"%")),
			Restrictions.like("retenerisr", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("fechavencimiento", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("contratoiversion", "%" + query +"%")),
			Restrictions.like("contratootrasinst", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("cuenta", "%" + query +"%")),
			Restrictions.like("traspasoentresubfiso", "%" + query +"%")),
			Restrictions.like("fechaapertura", "%" + query +"%")),
			Restrictions.like("origenrecursos", "%" + query +"%")),
			Restrictions.like("contactonombre", "%" + query +"%")),
			Restrictions.like("contactolada", "%" + query +"%")),
			Restrictions.like("contactotelefono", "%" + query +"%")),
			Restrictions.like("contactoextension", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de contratoinversion y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Contratoinversion> listContratoinversionsPagination(Contratoinversion contratoinversion, int page, int size) {
			return (List<Contratoinversion>) sessionFactory.getCurrentSession()
				.createCriteria(Contratoinversion.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de contratoinversion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Contratoinversion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de contratoinversion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Contratoinversion.class).setProjection(Projections.rowCount())
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
			Restrictions.like("contratoinversion", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("tipocontrato", "%" + query +"%")),
			Restrictions.like("intermediario", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("resparamliq", "%" + query +"%")),
			Restrictions.like("enviorecursosinv", "%" + query +"%")),
			Restrictions.like("transferenciarecdesinver", "%" + query +"%")),
			Restrictions.like("retenerisr", "%" + query +"%")),
			Restrictions.like("subfisoId", "%" + query +"%")),
			Restrictions.like("fechavencimiento", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("contratoiversion", "%" + query +"%")),
			Restrictions.like("contratootrasinst", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("cuenta", "%" + query +"%")),
			Restrictions.like("traspasoentresubfiso", "%" + query +"%")),
			Restrictions.like("fechaapertura", "%" + query +"%")),
			Restrictions.like("origenrecursos", "%" + query +"%")),
			Restrictions.like("contactonombre", "%" + query +"%")),
			Restrictions.like("contactolada", "%" + query +"%")),
			Restrictions.like("contactotelefono", "%" + query +"%")),
			Restrictions.like("contactoextension", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de contratoinversion consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Contratoinversion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un contratoinversion.
	 */
	public Contratoinversion getContratoinversion(UUID empid) {
		return (Contratoinversion) sessionFactory.getCurrentSession().get(
				Contratoinversion.class, empid);
	}

	/**
	 * Elimina un contratoinversion.
	 */
	public void deleteContratoinversion(Contratoinversion contratoinversion) {
		sessionFactory.getCurrentSession().delete(contratoinversion);
	}

}

