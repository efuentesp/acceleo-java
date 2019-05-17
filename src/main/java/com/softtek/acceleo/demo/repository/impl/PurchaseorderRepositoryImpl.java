/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los purchaseorder. 
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
import com.softtek.acceleo.demo.domain.Purchaseorder;
import com.softtek.acceleo.demo.repository.PurchaseorderRepository;

/**
 * Clase purchaseorderRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("purchaseorderRepository")
public class PurchaseorderRepositoryImpl implements PurchaseorderRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un purchaseorder.
	 */
	public void addPurchaseorder(Purchaseorder purchaseorder) {
		sessionFactory.getCurrentSession().persist(purchaseorder);
	}
	/**
	 * Edita un purchaseorder.
	 */
	public void editPurchaseorder(Purchaseorder purchaseorder) {
		sessionFactory.getCurrentSession().update(purchaseorder);
		
	}
	/**
	 * Consulta informacion de purchaseorder.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Purchaseorder> listPurchaseorders(Purchaseorder purchaseorder) {
		List<Purchaseorder> purchaseorders = sessionFactory.getCurrentSession().createCriteria(Purchaseorder.class).list();
		return purchaseorders;
	}
	
	/**
	 * Consulta informacion de purchaseorder.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Purchaseorder> listPurchaseordersByPurchaseorder(Purchaseorder purchaseorder, int id) {
		List<Purchaseorder> purchaseorders = 
		sessionFactory.getCurrentSession().createCriteria(Purchaseorder.class)
		.add(Restrictions.like("purchaseorderId",id)).list();
		return purchaseorders;
	}
 
	/**
	 * Consulta informacion de purchaseorder.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Purchaseorder> listPurchaseordersByUsername(Purchaseorder purchaseorder, String id) {
		List<Purchaseorder> purchaseorders = sessionFactory.getCurrentSession().createCriteria(Purchaseorder.class).add(Restrictions.like("username",id)).list();
		return purchaseorders;
	}
	
	/**
	 * Consulta informacion de purchaseorder y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Purchaseorder> listPurchaseordersQuery(Purchaseorder purchaseorder, String query, int page, int size) {
		
		return (List<Purchaseorder>) sessionFactory.getCurrentSession()
			.createCriteria(Purchaseorder.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("purchaseorder", "%" + query +"%"), 
			Restrictions.like("customerId", "%" + query +"%")),
			Restrictions.like("number", "%" + query +"%")),
			Restrictions.like("postatus", "%" + query +"%")),
			Restrictions.like("totalamount", "%" + query +"%")),
			Restrictions.like("totalweight", "%" + query +"%")),
			Restrictions.like("totalitems", "%" + query +"%")),
			Restrictions.like("purchaseorderId", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de purchaseorder y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Purchaseorder> listPurchaseordersPagination(Purchaseorder purchaseorder, int page, int size) {
			return (List<Purchaseorder>) sessionFactory.getCurrentSession()
				.createCriteria(Purchaseorder.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de purchaseorder consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Purchaseorder.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de purchaseorder consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Purchaseorder.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("purchaseorder", "%" + query +"%"), 
			Restrictions.like("customerId", "%" + query +"%")),
			Restrictions.like("number", "%" + query +"%")),
			Restrictions.like("postatus", "%" + query +"%")),
			Restrictions.like("totalamount", "%" + query +"%")),
			Restrictions.like("totalweight", "%" + query +"%")),
			Restrictions.like("totalitems", "%" + query +"%")),
			Restrictions.like("purchaseorderId", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de purchaseorder consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Purchaseorder.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un purchaseorder.
	 */
	public Purchaseorder getPurchaseorder(int empid) {
		return (Purchaseorder) sessionFactory.getCurrentSession().get(
				Purchaseorder.class, empid);
	}

	/**
	 * Elimina un purchaseorder.
	 */
	public void deletePurchaseorder(Purchaseorder purchaseorder) {
		sessionFactory.getCurrentSession().delete(purchaseorder);
	}

}

