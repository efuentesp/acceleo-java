
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los tasadeinteress. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.TasadeinteresRepository;
import com.softtek.acceleo.demo.domain.Tasadeinteres;
import com.softtek.acceleo.demo.service.TasadeinteresService;
/**
 * Clase TasadeinteresServiceImpl.
 * @author PSG.
 *
 */
@Service("tasadeinteresService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TasadeinteresServiceImpl implements TasadeinteresService {

	@Autowired
	private TasadeinteresRepository tasadeinteresRepository;

	/**
	 * Agrega un tasadeinteres.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTasadeinteres(Tasadeinteres tasadeinteres) {
		
		tasadeinteresRepository.addTasadeinteres(tasadeinteres);
	}

	/**
	 * Edita un tasadeinteres.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editTasadeinteres(Tasadeinteres tasadeinteres) {
		
		tasadeinteresRepository.editTasadeinteres(tasadeinteres);
	}
	
	/**
	 * Consulta informacion de tasadeinteress.
	 */
	public List<Tasadeinteres> listTasadeinteress(Tasadeinteres tasadeinteres) {

		return tasadeinteresRepository.listTasadeinteress(tasadeinteres);
	}

	/**
	 * Obtiene informacion de un tasadeinteres.
	 */
	public Tasadeinteres getTasadeinteres(int empid) {

		return tasadeinteresRepository.getTasadeinteres(empid);
	}

	/**
	 * Elimina un tasadeinteres.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteTasadeinteres(Tasadeinteres tasadeinteres) {
		System.out.println("Entrando al deleteTasadeinteres");

		 tasadeinteresRepository.deleteTasadeinteres(tasadeinteres);
	}

	/**
	 * Consulta informacion de tasadeinteress y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Tasadeinteres> listTasadeinteressPagination(Tasadeinteres tasadeinteres, int page, int size) {

		return tasadeinteresRepository.listTasadeinteressPagination(tasadeinteres, page, size);
	}

	/**
	 * Obtiene el numero de tasadeinteress consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return tasadeinteresRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de tasadeinteress consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return tasadeinteresRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de tasadeinteress consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return tasadeinteresRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los tasadeinteress y la pagina.
	 */
	public List<Tasadeinteres> listTasadeinteressQuery(Tasadeinteres tasadeinteres, String query, int page, int size) {
		// TODO Auto-generated method stub
		return tasadeinteresRepository.listTasadeinteressQuery(tasadeinteres, query, page, size);
	}

}

