/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los guias. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.GuiaRepository;
import com.softtek.acceleo.demo.domain.Guia;
import com.softtek.acceleo.demo.service.GuiaService;
/**
 * Clase GuiaServiceImpl.
 * @author PSG.
 *
 */
@Service("guiaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GuiaServiceImpl implements GuiaService {

	@Autowired
	private GuiaRepository guiaRepository;

	/**
	 * Agrega un guia.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addGuia(Guia guia) {
		guiaRepository.addGuia(guia);
	}

	/**
	 * Edita un guia.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editGuia(Guia guia) {
		guiaRepository.editGuia(guia);
	}
	
	/**
	 * Consulta informacion de guias.
	 */
	public List<Guia> listGuias(Guia guia) {
		return guiaRepository.listGuias(guia);
	}

	/**
	 * Obtiene informacion de un guia.
	 */
	public Guia getGuia(UUID empid) {
		return guiaRepository.getGuia(empid);
	}

	/**
	 * Elimina un guia.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteGuia(Guia guia) {
		 guiaRepository.deleteGuia(guia);
	}

	/**
	 * Consulta informacion de guias y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Guia> listGuiasPagination(Guia guia, int page, int size) {
		return guiaRepository.listGuiasPagination(guia, page, size);
	}

	/**
	 * Obtiene el numero de guias consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return guiaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de guias consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return guiaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de guias consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return guiaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los guias y la pagina.
	 */
	public List<Guia> listGuiasQuery(Guia guia, String query, int page, int size) {
		// TODO Auto-generated method stub
		return guiaRepository.listGuiasQuery(guia, query, page, size);
	}
}	
