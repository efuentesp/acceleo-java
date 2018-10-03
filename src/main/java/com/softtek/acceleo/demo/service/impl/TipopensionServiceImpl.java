
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los tipopensions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.TipopensionRepository;
import com.softtek.acceleo.demo.domain.Tipopension;
import com.softtek.acceleo.demo.service.TipopensionService;
/**
 * Clase TipopensionServiceImpl.
 * @author PSG.
 *
 */
@Service("tipopensionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TipopensionServiceImpl implements TipopensionService {

	@Autowired
	private TipopensionRepository tipopensionRepository;

	/**
	 * Agrega un tipopension.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTipopension(Tipopension tipopension) {
		
		tipopensionRepository.addTipopension(tipopension);
	}

	/**
	 * Edita un tipopension.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editTipopension(Tipopension tipopension) {
		
		tipopensionRepository.editTipopension(tipopension);
	}
	
	/**
	 * Consulta informacion de tipopensions.
	 */
	public List<Tipopension> listTipopensions(Tipopension tipopension) {

		return tipopensionRepository.listTipopensions(tipopension);
	}

	/**
	 * Obtiene informacion de un tipopension.
	 */
	public Tipopension getTipopension(int empid) {

		return tipopensionRepository.getTipopension(empid);
	}

	/**
	 * Elimina un tipopension.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteTipopension(Tipopension tipopension) {
		System.out.println("Entrando al deleteTipopension");

		 tipopensionRepository.deleteTipopension(tipopension);
	}

	/**
	 * Consulta informacion de tipopensions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Tipopension> listTipopensionsPagination(Tipopension tipopension, int page, int size) {

		return tipopensionRepository.listTipopensionsPagination(tipopension, page, size);
	}

	/**
	 * Obtiene el numero de tipopensions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return tipopensionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de tipopensions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return tipopensionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de tipopensions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return tipopensionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los tipopensions y la pagina.
	 */
	public List<Tipopension> listTipopensionsQuery(Tipopension tipopension, String query, int page, int size) {
		// TODO Auto-generated method stub
		return tipopensionRepository.listTipopensionsQuery(tipopension, query, page, size);
	}

}

