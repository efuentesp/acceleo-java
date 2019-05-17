/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los customer. 
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
import com.softtek.acceleo.demo.domain.Customer;
import com.softtek.acceleo.demo.repository.CustomerRepository;

/**
 * Clase customerRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Agrega un customer.
	 */
	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().persist(customer);
	}
	/**
	 * Edita un customer.
	 */
	public void editCustomer(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
		
	}
	/**
	 * Consulta informacion de customer.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Customer> listCustomers(Customer customer) {
		List<Customer> customers = sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
		return customers;
	}
	
	/**
	 * Consulta informacion de customer.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Customer> listCustomersByCustomer(Customer customer, int id) {
		List<Customer> customers = 
		sessionFactory.getCurrentSession().createCriteria(Customer.class)
		.add(Restrictions.like("customerId",id)).list();
		return customers;
	}
 
	/**
	 * Consulta informacion de customer.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Customer> listCustomersByUsername(Customer customer, String id) {
		List<Customer> customers = sessionFactory.getCurrentSession().createCriteria(Customer.class).add(Restrictions.like("username",id)).list();
		return customers;
	}
	
	/**
	 * Consulta informacion de customer y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> listCustomersQuery(Customer customer, String query, int page, int size) {
		
		return (List<Customer>) sessionFactory.getCurrentSession()
			.createCriteria(Customer.class).setFirstResult((page - 1) * size)
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("customer", "%" + query +"%"), 
			Restrictions.like("number", "%" + query +"%")),
			Restrictions.like("name", "%" + query +"%")),
			Restrictions.like("customertype", "%" + query +"%")),
			Restrictions.like("email", "%" + query +"%")),
			Restrictions.like("photologo", "%" + query +"%")),
			Restrictions.like("charterdocument", "%" + query +"%")),
			Restrictions.like("dateregistered", "%" + query +"%")),
			Restrictions.like("comments", "%" + query +"%"))
			).list();
	}

	/**
	 * Consulta informacion de customer y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> listCustomersPagination(Customer customer, int page, int size) {
			return (List<Customer>) sessionFactory.getCurrentSession()
				.createCriteria(Customer.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de customer consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Customer.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de customer consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Customer.class).setProjection(Projections.rowCount())
			.add(
			Restrictions.or(
			Restrictions.or(	
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.or(
			Restrictions.like("customer", "%" + query +"%"), 
			Restrictions.like("number", "%" + query +"%")),
			Restrictions.like("name", "%" + query +"%")),
			Restrictions.like("customertype", "%" + query +"%")),
			Restrictions.like("email", "%" + query +"%")),
			Restrictions.like("photologo", "%" + query +"%")),
			Restrictions.like("charterdocument", "%" + query +"%")),
			Restrictions.like("dateregistered", "%" + query +"%")),
			Restrictions.like("comments", "%" + query +"%"))
			).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de customer consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Customer.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un customer.
	 */
	public Customer getCustomer(int empid) {
		return (Customer) sessionFactory.getCurrentSession().get(
				Customer.class, empid);
	}

	/**
	 * Elimina un customer.
	 */
	public void deleteCustomer(Customer customer) {
		sessionFactory.getCurrentSession().delete(customer);
	}

}

