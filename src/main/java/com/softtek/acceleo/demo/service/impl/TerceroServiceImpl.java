/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los terceros. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.TerceroRepository;
import com.softtek.acceleo.demo.domain.Tercero;
import com.softtek.acceleo.demo.service.TerceroService;
/**
 * Clase TerceroServiceImpl.
 * @author PSG.
 *
 */
@Service("terceroService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TerceroServiceImpl implements TerceroService {

	@Autowired
	private TerceroRepository terceroRepository;

	/**
	 * Agrega un tercero.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTercero(Tercero tercero) {
		terceroRepository.addTercero(tercero);
	}

	/**
	 * Edita un tercero.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editTercero(Tercero tercero) {
		terceroRepository.editTercero(tercero);
	}
	
	/**
	 * Consulta informacion de terceros.
	 */
	public List<Tercero> listTerceros(Tercero tercero) {
		return terceroRepository.listTerceros(tercero);
	}

	/**
	 * Obtiene informacion de un tercero.
	 */
	public Tercero getTercero(UUID empid) {
		return terceroRepository.getTercero(empid);
	}

	/**
	 * Elimina un tercero.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteTercero(Tercero tercero) {
		 terceroRepository.deleteTercero(tercero);
	}

	/**
	 * Consulta informacion de terceros y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Tercero> listTercerosPagination(Tercero tercero, int page, int size) {
		return terceroRepository.listTercerosPagination(tercero, page, size);
	}

	/**
	 * Obtiene el numero de terceros consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return terceroRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de terceros consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return terceroRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de terceros consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return terceroRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los terceros y la pagina.
	 */
	public List<Tercero> listTercerosQuery(Tercero tercero, String query, int page, int size) {
		// TODO Auto-generated method stub
		return terceroRepository.listTercerosQuery(tercero, query, page, size);
	}
}	
