
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los clientes. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ClienteRepository;
import com.softtek.acceleo.demo.domain.Cliente;
import com.softtek.acceleo.demo.service.ClienteService;
/**
 * Clase ClienteServiceImpl.
 * @author PSG.
 *
 */
@Service("clienteService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	/**
	 * Agrega un cliente.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCliente(Cliente cliente) {
		
		clienteRepository.addCliente(cliente);
	}

	/**
	 * Edita un cliente.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editCliente(Cliente cliente) {
		
		clienteRepository.editCliente(cliente);
	}
	
	/**
	 * Consulta informacion de clientes.
	 */
	public List<Cliente> listClientes(Cliente cliente) {

		return clienteRepository.listClientes(cliente);
	}

	/**
	 * Obtiene informacion de un cliente.
	 */
	public Cliente getCliente(int empid) {

		return clienteRepository.getCliente(empid);
	}

	/**
	 * Elimina un cliente.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCliente(Cliente cliente) {
		System.out.println("Entrando al deleteCliente");

		 clienteRepository.deleteCliente(cliente);
	}

	/**
	 * Consulta informacion de clientes y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Cliente> listClientesPagination(Cliente cliente, int page, int size) {

		return clienteRepository.listClientesPagination(cliente, page, size);
	}

	/**
	 * Obtiene el numero de clientes consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return clienteRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de clientes consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return clienteRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de clientes consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return clienteRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los clientes y la pagina.
	 */
	public List<Cliente> listClientesQuery(Cliente cliente, String query, int page, int size) {
		// TODO Auto-generated method stub
		return clienteRepository.listClientesQuery(cliente, query, page, size);
	}

}

