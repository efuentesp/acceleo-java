/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los direccions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.DireccionRepository;
import com.softtek.acceleo.demo.domain.Direccion;
import com.softtek.acceleo.demo.service.DireccionService;
/**
 * Clase DireccionServiceImpl.
 * @author PSG.
 *
 */
@Service("direccionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DireccionServiceImpl implements DireccionService {

	@Autowired
	private DireccionRepository direccionRepository;

	/**
	 * Agrega un direccion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDireccion(Direccion direccion) {
		direccionRepository.addDireccion(direccion);
	}

	/**
	 * Edita un direccion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editDireccion(Direccion direccion) {
		direccionRepository.editDireccion(direccion);
	}
	
	/**
	 * Consulta informacion de direccions.
	 */
	public List<Direccion> listDireccions(Direccion direccion) {
		return direccionRepository.listDireccions(direccion);
	}

	/**
	 * Obtiene informacion de un direccion.
	 */
	public Direccion getDireccion(UUID empid) {
		return direccionRepository.getDireccion(empid);
	}

	/**
	 * Elimina un direccion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteDireccion(Direccion direccion) {
		 direccionRepository.deleteDireccion(direccion);
	}

	/**
	 * Consulta informacion de direccions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Direccion> listDireccionsPagination(Direccion direccion, int page, int size) {
		return direccionRepository.listDireccionsPagination(direccion, page, size);
	}

	/**
	 * Obtiene el numero de direccions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return direccionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de direccions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return direccionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de direccions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return direccionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los direccions y la pagina.
	 */
	public List<Direccion> listDireccionsQuery(Direccion direccion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return direccionRepository.listDireccionsQuery(direccion, query, page, size);
	}
}	
