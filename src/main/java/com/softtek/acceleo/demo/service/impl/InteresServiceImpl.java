
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los interess. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.InteresRepository;
import com.softtek.acceleo.demo.domain.Interes;
import com.softtek.acceleo.demo.service.InteresService;
/**
 * Clase InteresServiceImpl.
 * @author PSG.
 *
 */
@Service("interesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InteresServiceImpl implements InteresService {

	@Autowired
	private InteresRepository interesRepository;

	/**
	 * Agrega un interes.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addInteres(Interes interes) {
		
		interesRepository.addInteres(interes);
	}

	/**
	 * Edita un interes.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editInteres(Interes interes) {
		
		interesRepository.editInteres(interes);
	}
	
	/**
	 * Consulta informacion de interess.
	 */
	public List<Interes> listInteress(Interes interes) {

		return interesRepository.listInteress(interes);
	}

	/**
	 * Obtiene informacion de un interes.
	 */
	public Interes getInteres(int empid) {

		return interesRepository.getInteres(empid);
	}

	/**
	 * Elimina un interes.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteInteres(Interes interes) {
		System.out.println("Entrando al deleteInteres");

		 interesRepository.deleteInteres(interes);
	}

	/**
	 * Consulta informacion de interess y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Interes> listInteressPagination(Interes interes, int page, int size) {

		return interesRepository.listInteressPagination(interes, page, size);
	}

	/**
	 * Obtiene el numero de interess consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return interesRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de interess consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return interesRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de interess consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return interesRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los interess y la pagina.
	 */
	public List<Interes> listInteressQuery(Interes interes, String query, int page, int size) {
		// TODO Auto-generated method stub
		return interesRepository.listInteressQuery(interes, query, page, size);
	}

}

