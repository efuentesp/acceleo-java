/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los posicions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.PosicionRepository;
import com.softtek.acceleo.demo.domain.Posicion;
import com.softtek.acceleo.demo.service.PosicionService;
/**
 * Clase PosicionServiceImpl.
 * @author PSG.
 *
 */
@Service("posicionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PosicionServiceImpl implements PosicionService {

	@Autowired
	private PosicionRepository posicionRepository;

	/**
	 * Agrega un posicion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPosicion(Posicion posicion) {
		posicionRepository.addPosicion(posicion);
	}

	/**
	 * Edita un posicion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editPosicion(Posicion posicion) {
		posicionRepository.editPosicion(posicion);
	}
	
	/**
	 * Consulta informacion de posicions.
	 */
	public List<Posicion> listPosicions(Posicion posicion) {
		return posicionRepository.listPosicions(posicion);
	}

	/**
	 * Obtiene informacion de un posicion.
	 */
	public Posicion getPosicion(UUID empid) {
		return posicionRepository.getPosicion(empid);
	}

	/**
	 * Elimina un posicion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePosicion(Posicion posicion) {
		 posicionRepository.deletePosicion(posicion);
	}

	/**
	 * Consulta informacion de posicions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Posicion> listPosicionsPagination(Posicion posicion, int page, int size) {
		return posicionRepository.listPosicionsPagination(posicion, page, size);
	}

	/**
	 * Obtiene el numero de posicions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return posicionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de posicions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return posicionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de posicions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return posicionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los posicions y la pagina.
	 */
	public List<Posicion> listPosicionsQuery(Posicion posicion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return posicionRepository.listPosicionsQuery(posicion, query, page, size);
	}
}	
