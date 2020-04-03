/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los cuentacheques. 
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
import com.softtek.acceleo.demo.domain.Cuentacheques;
import com.softtek.acceleo.demo.repository.CuentachequesRepository;

/**
 * Clase cuentachequesRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("cuentachequesRepository")
public class CuentachequesRepositoryImpl implements CuentachequesRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un cuentacheques.
	 */
	public void addCuentacheques(Cuentacheques cuentacheques) {
		sessionFactory.getCurrentSession().persist(cuentacheques);
	}
	/**
	 * Edita un cuentacheques.
	 */
	public void editCuentacheques(Cuentacheques cuentacheques) {
		sessionFactory.getCurrentSession().update(cuentacheques);
		
	}
	/**
	 * Consulta informacion de cuentacheques.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Cuentacheques> listCuentachequess(Cuentacheques cuentacheques) {
		List<Cuentacheques> cuentachequess = sessionFactory.getCurrentSession().createCriteria(Cuentacheques.class).list();
		return cuentachequess;
	}
	
	/**
	 * Consulta informacion de cuentacheques.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Cuentacheques> listCuentachequessByCuentacheques(Cuentacheques cuentacheques, int id) {
		List<Cuentacheques> cuentachequess = 
		sessionFactory.getCurrentSession().createCriteria(Cuentacheques.class)
		.add(Restrictions.like("cuentachequesId",id)).list();
		return cuentachequess;
	}
 
	/**
	 * Consulta informacion de cuentacheques.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Cuentacheques> listCuentachequessByUsername(Cuentacheques cuentacheques, String id) {
		List<Cuentacheques> cuentachequess = sessionFactory.getCurrentSession().createCriteria(Cuentacheques.class).add(Restrictions.like("username",id)).list();
		return cuentachequess;
	}
	
	/**
	 * Consulta informacion de cuentacheques y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Cuentacheques> listCuentachequessQuery(Cuentacheques cuentacheques, String query, int page, int size) {
		
		return (List<Cuentacheques>) sessionFactory.getCurrentSession()
			.createCriteria(Cuentacheques.class).setFirstResult((page - 1) * size)
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
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("cuentacheques", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("fideicomitenteId", "%" + query +"%")),
			Restrictions.like("tipocuenta", "%" + query +"%")),
			Restrictions.like("tipopago", "%" + query +"%")),
			Restrictions.like("bancospei", "%" + query +"%")),
			Restrictions.like("banco", "%" + query +"%")),
			Restrictions.like("dombanco", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("clavevostro", "%" + query +"%")),
			Restrictions.like("numcuenta", "%" + query +"%")),
			Restrictions.like("dombeneficiario", "%" + query +"%")),
			Restrictions.like("plazainternacional", "%" + query +"%")),
			Restrictions.like("pais", "%" + query +"%")),
			Restrictions.like("clavesiacinst", "%" + query +"%")),
			Restrictions.like("conveniociedie", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("clabe", "%" + query +"%")),
			Restrictions.like("cuentachequera", "%" + query +"%")),
			Restrictions.like("fechavence", "%" + query +"%")),
			Restrictions.like("numabbasswift", "%" + query +"%")),
			Restrictions.like("conceptosiac", "%" + query +"%")),
			Restrictions.like("refciedie", "%" + query +"%")),
			Restrictions.like("autorizacion", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de cuentacheques y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Cuentacheques> listCuentachequessPagination(Cuentacheques cuentacheques, int page, int size) {
			return (List<Cuentacheques>) sessionFactory.getCurrentSession()
				.createCriteria(Cuentacheques.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de cuentacheques consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Cuentacheques.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de cuentacheques consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Cuentacheques.class).setProjection(Projections.rowCount())
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
			Restrictions.or(	
			Restrictions.or(
			Restrictions.like("cuentacheques", "%" + query +"%"), 
			Restrictions.like("fideicomisoId", "%" + query +"%")),
			Restrictions.like("tipopersona", "%" + query +"%")),
			Restrictions.like("fideicomitenteId", "%" + query +"%")),
			Restrictions.like("tipocuenta", "%" + query +"%")),
			Restrictions.like("tipopago", "%" + query +"%")),
			Restrictions.like("bancospei", "%" + query +"%")),
			Restrictions.like("banco", "%" + query +"%")),
			Restrictions.like("dombanco", "%" + query +"%")),
			Restrictions.like("moneda", "%" + query +"%")),
			Restrictions.like("clavevostro", "%" + query +"%")),
			Restrictions.like("numcuenta", "%" + query +"%")),
			Restrictions.like("dombeneficiario", "%" + query +"%")),
			Restrictions.like("plazainternacional", "%" + query +"%")),
			Restrictions.like("pais", "%" + query +"%")),
			Restrictions.like("clavesiacinst", "%" + query +"%")),
			Restrictions.like("conveniociedie", "%" + query +"%")),
			Restrictions.like("estatus", "%" + query +"%")),
			Restrictions.like("clabe", "%" + query +"%")),
			Restrictions.like("cuentachequera", "%" + query +"%")),
			Restrictions.like("fechavence", "%" + query +"%")),
			Restrictions.like("numabbasswift", "%" + query +"%")),
			Restrictions.like("conceptosiac", "%" + query +"%")),
			Restrictions.like("refciedie", "%" + query +"%")),
			Restrictions.like("autorizacion", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de cuentacheques consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Cuentacheques.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un cuentacheques.
	 */
	public Cuentacheques getCuentacheques(UUID empid) {
		return (Cuentacheques) sessionFactory.getCurrentSession().get(
				Cuentacheques.class, empid);
	}

	/**
	 * Elimina un cuentacheques.
	 */
	public void deleteCuentacheques(Cuentacheques cuentacheques) {
		sessionFactory.getCurrentSession().delete(cuentacheques);
	}

}

