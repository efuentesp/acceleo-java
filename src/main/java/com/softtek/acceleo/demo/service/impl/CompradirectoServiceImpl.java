/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los compradirectos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.CompradirectoRepository;
import com.softtek.acceleo.demo.domain.Compradirecto;
import com.softtek.acceleo.demo.service.CompradirectoService;
/**
 * Clase CompradirectoServiceImpl.
 * @author PSG.
 *
 */
@Service("compradirectoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CompradirectoServiceImpl implements CompradirectoService {

	@Autowired
	private CompradirectoRepository compradirectoRepository;

	/**
	 * Agrega un compradirecto.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCompradirecto(Compradirecto compradirecto) {
		compradirectoRepository.addCompradirecto(compradirecto);
	}

	/**
	 * Edita un compradirecto.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editCompradirecto(Compradirecto compradirecto) {
		compradirectoRepository.editCompradirecto(compradirecto);
	}
	
	/**
	 * Consulta informacion de compradirectos.
	 */
	public List<Compradirecto> listCompradirectos(Compradirecto compradirecto) {
		return compradirectoRepository.listCompradirectos(compradirecto);
	}

	/**
	 * Obtiene informacion de un compradirecto.
	 */
	public Compradirecto getCompradirecto(UUID empid) {
		return compradirectoRepository.getCompradirecto(empid);
	}

	/**
	 * Elimina un compradirecto.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCompradirecto(Compradirecto compradirecto) {
		 compradirectoRepository.deleteCompradirecto(compradirecto);
	}

	/**
	 * Consulta informacion de compradirectos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Compradirecto> listCompradirectosPagination(Compradirecto compradirecto, int page, int size) {
		return compradirectoRepository.listCompradirectosPagination(compradirecto, page, size);
	}

	/**
	 * Obtiene el numero de compradirectos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return compradirectoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de compradirectos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return compradirectoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de compradirectos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return compradirectoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los compradirectos y la pagina.
	 */
	public List<Compradirecto> listCompradirectosQuery(Compradirecto compradirecto, String query, int page, int size) {
		// TODO Auto-generated method stub
		return compradirectoRepository.listCompradirectosQuery(compradirecto, query, page, size);
	}
}	
