/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los ventadirectos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.VentadirectoRepository;
import com.softtek.acceleo.demo.domain.Ventadirecto;
import com.softtek.acceleo.demo.service.VentadirectoService;
/**
 * Clase VentadirectoServiceImpl.
 * @author PSG.
 *
 */
@Service("ventadirectoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VentadirectoServiceImpl implements VentadirectoService {

	@Autowired
	private VentadirectoRepository ventadirectoRepository;

	/**
	 * Agrega un ventadirecto.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addVentadirecto(Ventadirecto ventadirecto) {
		ventadirectoRepository.addVentadirecto(ventadirecto);
	}

	/**
	 * Edita un ventadirecto.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editVentadirecto(Ventadirecto ventadirecto) {
		ventadirectoRepository.editVentadirecto(ventadirecto);
	}
	
	/**
	 * Consulta informacion de ventadirectos.
	 */
	public List<Ventadirecto> listVentadirectos(Ventadirecto ventadirecto) {
		return ventadirectoRepository.listVentadirectos(ventadirecto);
	}

	/**
	 * Obtiene informacion de un ventadirecto.
	 */
	public Ventadirecto getVentadirecto(UUID empid) {
		return ventadirectoRepository.getVentadirecto(empid);
	}

	/**
	 * Elimina un ventadirecto.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteVentadirecto(Ventadirecto ventadirecto) {
		 ventadirectoRepository.deleteVentadirecto(ventadirecto);
	}

	/**
	 * Consulta informacion de ventadirectos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Ventadirecto> listVentadirectosPagination(Ventadirecto ventadirecto, int page, int size) {
		return ventadirectoRepository.listVentadirectosPagination(ventadirecto, page, size);
	}

	/**
	 * Obtiene el numero de ventadirectos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return ventadirectoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de ventadirectos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return ventadirectoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de ventadirectos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return ventadirectoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los ventadirectos y la pagina.
	 */
	public List<Ventadirecto> listVentadirectosQuery(Ventadirecto ventadirecto, String query, int page, int size) {
		// TODO Auto-generated method stub
		return ventadirectoRepository.listVentadirectosQuery(ventadirecto, query, page, size);
	}
}	
