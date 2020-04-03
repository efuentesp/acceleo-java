/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los declaracionsats. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.DeclaracionsatRepository;
import com.softtek.acceleo.demo.domain.Declaracionsat;
import com.softtek.acceleo.demo.service.DeclaracionsatService;
/**
 * Clase DeclaracionsatServiceImpl.
 * @author PSG.
 *
 */
@Service("declaracionsatService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DeclaracionsatServiceImpl implements DeclaracionsatService {

	@Autowired
	private DeclaracionsatRepository declaracionsatRepository;

	/**
	 * Agrega un declaracionsat.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDeclaracionsat(Declaracionsat declaracionsat) {
		declaracionsatRepository.addDeclaracionsat(declaracionsat);
	}

	/**
	 * Edita un declaracionsat.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editDeclaracionsat(Declaracionsat declaracionsat) {
		declaracionsatRepository.editDeclaracionsat(declaracionsat);
	}
	
	/**
	 * Consulta informacion de declaracionsats.
	 */
	public List<Declaracionsat> listDeclaracionsats(Declaracionsat declaracionsat) {
		return declaracionsatRepository.listDeclaracionsats(declaracionsat);
	}

	/**
	 * Obtiene informacion de un declaracionsat.
	 */
	public Declaracionsat getDeclaracionsat(UUID empid) {
		return declaracionsatRepository.getDeclaracionsat(empid);
	}

	/**
	 * Elimina un declaracionsat.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteDeclaracionsat(Declaracionsat declaracionsat) {
		 declaracionsatRepository.deleteDeclaracionsat(declaracionsat);
	}

	/**
	 * Consulta informacion de declaracionsats y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Declaracionsat> listDeclaracionsatsPagination(Declaracionsat declaracionsat, int page, int size) {
		return declaracionsatRepository.listDeclaracionsatsPagination(declaracionsat, page, size);
	}

	/**
	 * Obtiene el numero de declaracionsats consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return declaracionsatRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de declaracionsats consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return declaracionsatRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de declaracionsats consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return declaracionsatRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los declaracionsats y la pagina.
	 */
	public List<Declaracionsat> listDeclaracionsatsQuery(Declaracionsat declaracionsat, String query, int page, int size) {
		// TODO Auto-generated method stub
		return declaracionsatRepository.listDeclaracionsatsQuery(declaracionsat, query, page, size);
	}
}	
