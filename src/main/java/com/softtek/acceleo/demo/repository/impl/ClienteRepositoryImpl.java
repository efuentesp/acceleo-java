/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los cliente. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.Cliente;
import com.softtek.acceleo.demo.repository.ClienteRepository;
/**
 * Clase clienteRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("clienteRepository")
public class ClienteRepositoryImpl implements ClienteRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Agrega un cliente.
	 */
	public void addCliente(Cliente cliente) {
		sessionFactory.getCurrentSession().persist(cliente);
	}
	/**
	 * Edita un cliente.
	 */
	public void editCliente(Cliente cliente) {
		sessionFactory.getCurrentSession().update(cliente);

	}
	/**
	 * Consulta informacion de cliente.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Cliente> listClientes(Cliente cliente) {

		return (List<Cliente>) sessionFactory.getCurrentSession()
				.createCriteria(Cliente.class).list();
	}

	/**
	 * Consulta informacion de clientes.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Cliente> listAllClientes() {
		List<Cliente> lstClientes = new ArrayList<Cliente>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Cliente.class);
			lstClientes = (List<Cliente>) criteria.list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return lstClientes;
	}
	
/**
 * 	public List<Authority> getAuthority() {
		List<Authority> lstAuthority = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Authority.class);
			criteria.add(Restrictions.eq("enabled", Boolean.TRUE)).addOrder(Order.asc("name")).list();
			
			lstAuthority = (List<Authority>) criteria.list();
		}catch(Exception e) {
			logger.error("Error: ", e);
		}
		
		return lstAuthority;
	}
	
 */
	
	
	/**
	 * Consulta informacion de cliente y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Cliente> listClientesQuery(Cliente cliente, String query, int page, int size) {
		
		return (List<Cliente>) sessionFactory.getCurrentSession()
			.createCriteria(Cliente.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("nombre", "%" + query +"%"),
Restrictions.like("cliente", "%" + query +"%")),
Restrictions.like("sociedad", "%" + query +"%")),
Restrictions.like("cliente", "%" + query +"%")),
Restrictions.like("clave", "%" + query +"%")),
Restrictions.like("cliente", "%" + query +"%")),
Restrictions.like("cliente", "%" + query +"%")),
Restrictions.like("tiene", "%" + query +"%")),
Restrictions.like("cliente", "%" + query +"%")),
Restrictions.like("es", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
).list();
	}

	/**
	 * Consulta informacion de cliente y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Cliente> listClientesPagination(Cliente cliente, int page, int size) {
			return (List<Cliente>) sessionFactory.getCurrentSession()
				.createCriteria(Cliente.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de cliente consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Cliente.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de cliente consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Cliente.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("nombre", "%" + query +"%"),Restrictions.like("cliente", "%" + query +"%")),Restrictions.like("sociedad", "%" + query +"%")),Restrictions.like("cliente", "%" + query +"%")),Restrictions.like("clave", "%" + query +"%")),Restrictions.like("cliente", "%" + query +"%")),Restrictions.like("cliente", "%" + query +"%")),Restrictions.like("tiene", "%" + query +"%")),Restrictions.like("cliente", "%" + query +"%")),Restrictions.like("es", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de cliente consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Cliente.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Consulta informacion de un cliente.
	 */
	public Cliente getCliente(int empid) {
		return (Cliente) sessionFactory.getCurrentSession().get(
				Cliente.class, empid);
	}

	/**
	 * Elimina un cliente.
	 */
	public void deleteCliente(Cliente cliente) {
		sessionFactory.getCurrentSession().delete(cliente);
	}
	
	@Override
	public List<Cliente> listClientes(int idClientePadre) {
		List<Cliente> lstClientes = new ArrayList<>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Cliente.class);
			criteria.add(Restrictions.eq("cliente1Id", idClientePadre)).list();
			
			lstClientes = (List<Cliente>) criteria.list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return lstClientes;		
	}

}
