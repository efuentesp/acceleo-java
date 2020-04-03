/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los kyc. 
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
import com.softtek.acceleo.demo.domain.Kyc;
import com.softtek.acceleo.demo.repository.KycRepository;

/**
 * Clase kycRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("kycRepository")
public class KycRepositoryImpl implements KycRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un kyc.
	 */
	public void addKyc(Kyc kyc) {
		sessionFactory.getCurrentSession().persist(kyc);
	}
	/**
	 * Edita un kyc.
	 */
	public void editKyc(Kyc kyc) {
		sessionFactory.getCurrentSession().update(kyc);
		
	}
	/**
	 * Consulta informacion de kyc.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Kyc> listKycs(Kyc kyc) {
		List<Kyc> kycs = sessionFactory.getCurrentSession().createCriteria(Kyc.class).list();
		return kycs;
	}
	
	/**
	 * Consulta informacion de kyc.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Kyc> listKycsByKyc(Kyc kyc, int id) {
		List<Kyc> kycs = 
		sessionFactory.getCurrentSession().createCriteria(Kyc.class)
		.add(Restrictions.like("kycId",id)).list();
		return kycs;
	}
 
	/**
	 * Consulta informacion de kyc.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Kyc> listKycsByUsername(Kyc kyc, String id) {
		List<Kyc> kycs = sessionFactory.getCurrentSession().createCriteria(Kyc.class).add(Restrictions.like("username",id)).list();
		return kycs;
	}
	
	/**
	 * Consulta informacion de kyc y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Kyc> listKycsQuery(Kyc kyc, String query, int page, int size) {
		
		return (List<Kyc>) sessionFactory.getCurrentSession()
			.createCriteria(Kyc.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("kyc", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("numregistro", "%" + query +"%")),
			Restrictions.like("oficina", "%" + query +"%")),
			Restrictions.like("conceptoimpresion", "%" + query +"%")),
			Restrictions.like("crbanca", "%" + query +"%")),
			Restrictions.like("folio", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de kyc y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Kyc> listKycsPagination(Kyc kyc, int page, int size) {
			return (List<Kyc>) sessionFactory.getCurrentSession()
				.createCriteria(Kyc.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de kyc consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Kyc.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de kyc consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Kyc.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(	
			Restrictions.like("kyc", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("nombre", "%" + query +"%")),
			Restrictions.like("numregistro", "%" + query +"%")),
			Restrictions.like("oficina", "%" + query +"%")),
			Restrictions.like("conceptoimpresion", "%" + query +"%")),
			Restrictions.like("crbanca", "%" + query +"%")),
			Restrictions.like("folio", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de kyc consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Kyc.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un kyc.
	 */
	public Kyc getKyc(UUID empid) {
		return (Kyc) sessionFactory.getCurrentSession().get(
				Kyc.class, empid);
	}

	/**
	 * Elimina un kyc.
	 */
	public void deleteKyc(Kyc kyc) {
		sessionFactory.getCurrentSession().delete(kyc);
	}

}

