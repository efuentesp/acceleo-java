
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los operadorproduccions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.OperadorproduccionRepository;
import com.softtek.acceleo.demo.domain.Operadorproduccion;
import com.softtek.acceleo.demo.service.OperadorproduccionService;
/**
 * Clase OperadorproduccionServiceImpl.
 * @author PSG.
 *
 */
@Service("operadorproduccionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OperadorproduccionServiceImpl implements OperadorproduccionService {

	@Autowired
	private OperadorproduccionRepository operadorproduccionRepository;

	/**
	 * Agrega un operadorproduccion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addOperadorproduccion(Operadorproduccion operadorproduccion) {
		
		operadorproduccionRepository.addOperadorproduccion(operadorproduccion);
	}

	/**
	 * Edita un operadorproduccion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editOperadorproduccion(Operadorproduccion operadorproduccion) {
		
		operadorproduccionRepository.editOperadorproduccion(operadorproduccion);
	}
	
	/**
	 * Consulta informacion de operadorproduccions.
	 */
	public List<Operadorproduccion> listOperadorproduccions(Operadorproduccion operadorproduccion) {

		return operadorproduccionRepository.listOperadorproduccions(operadorproduccion);
	}

	/**
	 * Obtiene informacion de un operadorproduccion.
	 */
	public Operadorproduccion getOperadorproduccion(int empid) {

		return operadorproduccionRepository.getOperadorproduccion(empid);
	}

	/**
	 * Elimina un operadorproduccion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteOperadorproduccion(Operadorproduccion operadorproduccion) {
		System.out.println("Entrando al deleteOperadorproduccion");

		 operadorproduccionRepository.deleteOperadorproduccion(operadorproduccion);
	}

	/**
	 * Consulta informacion de operadorproduccions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Operadorproduccion> listOperadorproduccionsPagination(Operadorproduccion operadorproduccion, int page, int size) {

		return operadorproduccionRepository.listOperadorproduccionsPagination(operadorproduccion, page, size);
	}

	/**
	 * Obtiene el numero de operadorproduccions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return operadorproduccionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de operadorproduccions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return operadorproduccionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de operadorproduccions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return operadorproduccionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los operadorproduccions y la pagina.
	 */
	public List<Operadorproduccion> listOperadorproduccionsQuery(Operadorproduccion operadorproduccion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return operadorproduccionRepository.listOperadorproduccionsQuery(operadorproduccion, query, page, size);
	}

}

