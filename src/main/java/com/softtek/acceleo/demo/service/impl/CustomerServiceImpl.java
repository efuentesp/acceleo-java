/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los customers. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.CustomerRepository;
import com.softtek.acceleo.demo.domain.Customer;
import com.softtek.acceleo.demo.service.CustomerService;
/**
 * Clase CustomerServiceImpl.
 * @author PSG.
 *
 */
@Service("customerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Agrega un customer.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCustomer(Customer customer) {
		customerRepository.addCustomer(customer);
	}

	/**
	 * Edita un customer.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editCustomer(Customer customer) {
		customerRepository.editCustomer(customer);
	}
	
	/**
	 * Consulta informacion de customers.
	 */
	public List<Customer> listCustomers(Customer customer) {
		return customerRepository.listCustomers(customer);
	}

	/**
	 * Obtiene informacion de un customer.
	 */
	public Customer getCustomer(int empid) {
		return customerRepository.getCustomer(empid);
	}

	/**
	 * Elimina un customer.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCustomer(Customer customer) {
		 customerRepository.deleteCustomer(customer);
	}

	/**
	 * Consulta informacion de customers y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Customer> listCustomersPagination(Customer customer, int page, int size) {
		return customerRepository.listCustomersPagination(customer, page, size);
	}

	/**
	 * Obtiene el numero de customers consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return customerRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de customers consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return customerRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de customers consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return customerRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los customers y la pagina.
	 */
	public List<Customer> listCustomersQuery(Customer customer, String query, int page, int size) {
		// TODO Auto-generated method stub
		return customerRepository.listCustomersQuery(customer, query, page, size);
	}
}	
