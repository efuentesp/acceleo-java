
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los solicitudpensions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.SolicitudpensionRepository;
import com.softtek.acceleo.demo.domain.Solicitudpension;
import com.softtek.acceleo.demo.service.SolicitudpensionService;
/**
 * Clase SolicitudpensionServiceImpl.
 * @author PSG.
 *
 */
@Service("solicitudpensionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SolicitudpensionServiceImpl implements SolicitudpensionService {

	@Autowired
	private SolicitudpensionRepository solicitudpensionRepository;

	/**
	 * Agrega un solicitudpension.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSolicitudpension(Solicitudpension solicitudpension) {
		
		solicitudpensionRepository.addSolicitudpension(solicitudpension);
	}

	/**
	 * Edita un solicitudpension.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editSolicitudpension(Solicitudpension solicitudpension) {
		
		solicitudpensionRepository.editSolicitudpension(solicitudpension);
	}
	
	/**
	 * Consulta informacion de solicitudpensions.
	 */
	public List<Solicitudpension> listSolicitudpensions(Solicitudpension solicitudpension) {

		return solicitudpensionRepository.listSolicitudpensions(solicitudpension);
	}

	/**
	 * Obtiene informacion de un solicitudpension.
	 */
	public Solicitudpension getSolicitudpension(int empid) {

		return solicitudpensionRepository.getSolicitudpension(empid);
	}

	/**
	 * Elimina un solicitudpension.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteSolicitudpension(Solicitudpension solicitudpension) {
		System.out.println("Entrando al deleteSolicitudpension");

		 solicitudpensionRepository.deleteSolicitudpension(solicitudpension);
	}

	/**
	 * Consulta informacion de solicitudpensions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Solicitudpension> listSolicitudpensionsPagination(Solicitudpension solicitudpension, int page, int size) {

		return solicitudpensionRepository.listSolicitudpensionsPagination(solicitudpension, page, size);
	}

	/**
	 * Obtiene el numero de solicitudpensions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return solicitudpensionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de solicitudpensions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return solicitudpensionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de solicitudpensions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return solicitudpensionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los solicitudpensions y la pagina.
	 */
	public List<Solicitudpension> listSolicitudpensionsQuery(Solicitudpension solicitudpension, String query, int page, int size) {
		// TODO Auto-generated method stub
		return solicitudpensionRepository.listSolicitudpensionsQuery(solicitudpension, query, page, size);
	}

}

