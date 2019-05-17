/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los opcions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.OpcionRepository;
import com.softtek.acceleo.demo.domain.Opcion;
import com.softtek.acceleo.demo.service.OpcionService;
/**
 * Clase OpcionServiceImpl.
 * @author PSG.
 *
 */
@Service("opcionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OpcionServiceImpl implements OpcionService {

	@Autowired
	private OpcionRepository opcionRepository;

	/**
	 * Agrega un opcion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addOpcion(Opcion opcion) {
		opcionRepository.addOpcion(opcion);
	}

	/**
	 * Edita un opcion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editOpcion(Opcion opcion) {
		opcionRepository.editOpcion(opcion);
	}
	
	/**
	 * Consulta informacion de opcions.
	 */
	public List<Opcion> listOpcions(Opcion opcion) {
		return opcionRepository.listOpcions(opcion);
	}

	/**
	 * Obtiene informacion de un opcion.
	 */
	public Opcion getOpcion(int empid) {
		return opcionRepository.getOpcion(empid);
	}

	/**
	 * Elimina un opcion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteOpcion(Opcion opcion) {
		 opcionRepository.deleteOpcion(opcion);
	}

	/**
	 * Consulta informacion de opcions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Opcion> listOpcionsPagination(Opcion opcion, int page, int size) {
		return opcionRepository.listOpcionsPagination(opcion, page, size);
	}

	/**
	 * Obtiene el numero de opcions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return opcionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de opcions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return opcionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de opcions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return opcionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los opcions y la pagina.
	 */
	public List<Opcion> listOpcionsQuery(Opcion opcion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return opcionRepository.listOpcionsQuery(opcion, query, page, size);
	}
}	
