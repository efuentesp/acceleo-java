/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los compraventavaloress. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.CompraventavaloresRepository;
import com.softtek.acceleo.demo.domain.Compraventavalores;
import com.softtek.acceleo.demo.service.CompraventavaloresService;
/**
 * Clase CompraventavaloresServiceImpl.
 * @author PSG.
 *
 */
@Service("compraventavaloresService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CompraventavaloresServiceImpl implements CompraventavaloresService {

	@Autowired
	private CompraventavaloresRepository compraventavaloresRepository;

	/**
	 * Agrega un compraventavalores.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCompraventavalores(Compraventavalores compraventavalores) {
		compraventavaloresRepository.addCompraventavalores(compraventavalores);
	}

	/**
	 * Edita un compraventavalores.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editCompraventavalores(Compraventavalores compraventavalores) {
		compraventavaloresRepository.editCompraventavalores(compraventavalores);
	}
	
	/**
	 * Consulta informacion de compraventavaloress.
	 */
	public List<Compraventavalores> listCompraventavaloress(Compraventavalores compraventavalores) {
		return compraventavaloresRepository.listCompraventavaloress(compraventavalores);
	}

	/**
	 * Obtiene informacion de un compraventavalores.
	 */
	public Compraventavalores getCompraventavalores(UUID empid) {
		return compraventavaloresRepository.getCompraventavalores(empid);
	}

	/**
	 * Elimina un compraventavalores.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCompraventavalores(Compraventavalores compraventavalores) {
		 compraventavaloresRepository.deleteCompraventavalores(compraventavalores);
	}

	/**
	 * Consulta informacion de compraventavaloress y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Compraventavalores> listCompraventavaloressPagination(Compraventavalores compraventavalores, int page, int size) {
		return compraventavaloresRepository.listCompraventavaloressPagination(compraventavalores, page, size);
	}

	/**
	 * Obtiene el numero de compraventavaloress consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return compraventavaloresRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de compraventavaloress consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return compraventavaloresRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de compraventavaloress consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return compraventavaloresRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los compraventavaloress y la pagina.
	 */
	public List<Compraventavalores> listCompraventavaloressQuery(Compraventavalores compraventavalores, String query, int page, int size) {
		// TODO Auto-generated method stub
		return compraventavaloresRepository.listCompraventavaloressQuery(compraventavalores, query, page, size);
	}
}	
