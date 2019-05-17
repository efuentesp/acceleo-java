/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los unidads. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.UnidadRepository;
import com.softtek.acceleo.demo.domain.Unidad;
import com.softtek.acceleo.demo.service.UnidadService;
/**
 * Clase UnidadServiceImpl.
 * @author PSG.
 *
 */
@Service("unidadService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UnidadServiceImpl implements UnidadService {

	@Autowired
	private UnidadRepository unidadRepository;

	/**
	 * Agrega un unidad.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUnidad(Unidad unidad) {
		unidadRepository.addUnidad(unidad);
	}

	/**
	 * Edita un unidad.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editUnidad(Unidad unidad) {
		unidadRepository.editUnidad(unidad);
	}
	
	/**
	 * Consulta informacion de unidads.
	 */
	public List<Unidad> listUnidads(Unidad unidad) {
		return unidadRepository.listUnidads(unidad);
	}

	/**
	 * Obtiene informacion de un unidad.
	 */
	public Unidad getUnidad(int empid) {
		return unidadRepository.getUnidad(empid);
	}

	/**
	 * Elimina un unidad.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUnidad(Unidad unidad) {
		 unidadRepository.deleteUnidad(unidad);
	}

	/**
	 * Consulta informacion de unidads y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Unidad> listUnidadsPagination(Unidad unidad, int page, int size) {
		return unidadRepository.listUnidadsPagination(unidad, page, size);
	}

	/**
	 * Obtiene el numero de unidads consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return unidadRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de unidads consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return unidadRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de unidads consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return unidadRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los unidads y la pagina.
	 */
	public List<Unidad> listUnidadsQuery(Unidad unidad, String query, int page, int size) {
		// TODO Auto-generated method stub
		return unidadRepository.listUnidadsQuery(unidad, query, page, size);
	}
}	
