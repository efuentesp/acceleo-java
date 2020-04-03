/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los fideicomisospendientesliberars. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.FideicomisospendientesliberarRepository;
import com.softtek.acceleo.demo.domain.Fideicomisospendientesliberar;
import com.softtek.acceleo.demo.service.FideicomisospendientesliberarService;
/**
 * Clase FideicomisospendientesliberarServiceImpl.
 * @author PSG.
 *
 */
@Service("fideicomisospendientesliberarService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FideicomisospendientesliberarServiceImpl implements FideicomisospendientesliberarService {

	@Autowired
	private FideicomisospendientesliberarRepository fideicomisospendientesliberarRepository;

	/**
	 * Agrega un fideicomisospendientesliberar.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFideicomisospendientesliberar(Fideicomisospendientesliberar fideicomisospendientesliberar) {
		fideicomisospendientesliberarRepository.addFideicomisospendientesliberar(fideicomisospendientesliberar);
	}

	/**
	 * Edita un fideicomisospendientesliberar.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editFideicomisospendientesliberar(Fideicomisospendientesliberar fideicomisospendientesliberar) {
		fideicomisospendientesliberarRepository.editFideicomisospendientesliberar(fideicomisospendientesliberar);
	}
	
	/**
	 * Consulta informacion de fideicomisospendientesliberars.
	 */
	public List<Fideicomisospendientesliberar> listFideicomisospendientesliberars(Fideicomisospendientesliberar fideicomisospendientesliberar) {
		return fideicomisospendientesliberarRepository.listFideicomisospendientesliberars(fideicomisospendientesliberar);
	}

	/**
	 * Obtiene informacion de un fideicomisospendientesliberar.
	 */
	public Fideicomisospendientesliberar getFideicomisospendientesliberar(UUID empid) {
		return fideicomisospendientesliberarRepository.getFideicomisospendientesliberar(empid);
	}

	/**
	 * Elimina un fideicomisospendientesliberar.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteFideicomisospendientesliberar(Fideicomisospendientesliberar fideicomisospendientesliberar) {
		 fideicomisospendientesliberarRepository.deleteFideicomisospendientesliberar(fideicomisospendientesliberar);
	}

	/**
	 * Consulta informacion de fideicomisospendientesliberars y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Fideicomisospendientesliberar> listFideicomisospendientesliberarsPagination(Fideicomisospendientesliberar fideicomisospendientesliberar, int page, int size) {
		return fideicomisospendientesliberarRepository.listFideicomisospendientesliberarsPagination(fideicomisospendientesliberar, page, size);
	}

	/**
	 * Obtiene el numero de fideicomisospendientesliberars consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return fideicomisospendientesliberarRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de fideicomisospendientesliberars consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return fideicomisospendientesliberarRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de fideicomisospendientesliberars consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return fideicomisospendientesliberarRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los fideicomisospendientesliberars y la pagina.
	 */
	public List<Fideicomisospendientesliberar> listFideicomisospendientesliberarsQuery(Fideicomisospendientesliberar fideicomisospendientesliberar, String query, int page, int size) {
		// TODO Auto-generated method stub
		return fideicomisospendientesliberarRepository.listFideicomisospendientesliberarsQuery(fideicomisospendientesliberar, query, page, size);
	}
}	
