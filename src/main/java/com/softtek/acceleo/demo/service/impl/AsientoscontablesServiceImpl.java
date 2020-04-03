/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los asientoscontabless. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.AsientoscontablesRepository;
import com.softtek.acceleo.demo.domain.Asientoscontables;
import com.softtek.acceleo.demo.service.AsientoscontablesService;
/**
 * Clase AsientoscontablesServiceImpl.
 * @author PSG.
 *
 */
@Service("asientoscontablesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AsientoscontablesServiceImpl implements AsientoscontablesService {

	@Autowired
	private AsientoscontablesRepository asientoscontablesRepository;

	/**
	 * Agrega un asientoscontables.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAsientoscontables(Asientoscontables asientoscontables) {
		asientoscontablesRepository.addAsientoscontables(asientoscontables);
	}

	/**
	 * Edita un asientoscontables.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAsientoscontables(Asientoscontables asientoscontables) {
		asientoscontablesRepository.editAsientoscontables(asientoscontables);
	}
	
	/**
	 * Consulta informacion de asientoscontabless.
	 */
	public List<Asientoscontables> listAsientoscontabless(Asientoscontables asientoscontables) {
		return asientoscontablesRepository.listAsientoscontabless(asientoscontables);
	}

	/**
	 * Obtiene informacion de un asientoscontables.
	 */
	public Asientoscontables getAsientoscontables(UUID empid) {
		return asientoscontablesRepository.getAsientoscontables(empid);
	}

	/**
	 * Elimina un asientoscontables.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAsientoscontables(Asientoscontables asientoscontables) {
		 asientoscontablesRepository.deleteAsientoscontables(asientoscontables);
	}

	/**
	 * Consulta informacion de asientoscontabless y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Asientoscontables> listAsientoscontablessPagination(Asientoscontables asientoscontables, int page, int size) {
		return asientoscontablesRepository.listAsientoscontablessPagination(asientoscontables, page, size);
	}

	/**
	 * Obtiene el numero de asientoscontabless consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return asientoscontablesRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de asientoscontabless consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return asientoscontablesRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de asientoscontabless consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return asientoscontablesRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los asientoscontabless y la pagina.
	 */
	public List<Asientoscontables> listAsientoscontablessQuery(Asientoscontables asientoscontables, String query, int page, int size) {
		// TODO Auto-generated method stub
		return asientoscontablesRepository.listAsientoscontablessQuery(asientoscontables, query, page, size);
	}
}	
