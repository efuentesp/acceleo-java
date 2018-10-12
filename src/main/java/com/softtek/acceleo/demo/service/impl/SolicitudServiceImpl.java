
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los solicituds. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.SolicitudRepository;
import com.softtek.acceleo.demo.domain.Solicitud;
import com.softtek.acceleo.demo.service.SolicitudService;
/**
 * Clase SolicitudServiceImpl.
 * @author PSG.
 *
 */
@Service("solicitudService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SolicitudServiceImpl implements SolicitudService {

	@Autowired
	private SolicitudRepository solicitudRepository;

	/**
	 * Agrega un solicitud.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSolicitud(Solicitud solicitud) {
		
		solicitudRepository.addSolicitud(solicitud);
	}

	/**
	 * Edita un solicitud.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editSolicitud(Solicitud solicitud) {
		
		solicitudRepository.editSolicitud(solicitud);
	}
	
	/**
	 * Consulta informacion de solicituds.
	 */
	public List<Solicitud> listSolicituds(Solicitud solicitud) {

		return solicitudRepository.listSolicituds(solicitud);
	}

	/**
	 * Obtiene informacion de un solicitud.
	 */
	public Solicitud getSolicitud(int empid) {

		return solicitudRepository.getSolicitud(empid);
	}

	/**
	 * Elimina un solicitud.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteSolicitud(Solicitud solicitud) {
		System.out.println("Entrando al deleteSolicitud");

		 solicitudRepository.deleteSolicitud(solicitud);
	}

	/**
	 * Consulta informacion de solicituds y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Solicitud> listSolicitudsPagination(Solicitud solicitud, int page, int size) {

		return solicitudRepository.listSolicitudsPagination(solicitud, page, size);
	}

	/**
	 * Obtiene el numero de solicituds consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return solicitudRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de solicituds consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return solicitudRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de solicituds consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return solicitudRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los solicituds y la pagina.
	 */
	public List<Solicitud> listSolicitudsQuery(Solicitud solicitud, String query, int page, int size) {
		// TODO Auto-generated method stub
		return solicitudRepository.listSolicitudsQuery(solicitud, query, page, size);
	}

}

