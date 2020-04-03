/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los parametroscomisioness. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ParametroscomisionesRepository;
import com.softtek.acceleo.demo.domain.Parametroscomisiones;
import com.softtek.acceleo.demo.service.ParametroscomisionesService;
/**
 * Clase ParametroscomisionesServiceImpl.
 * @author PSG.
 *
 */
@Service("parametroscomisionesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ParametroscomisionesServiceImpl implements ParametroscomisionesService {

	@Autowired
	private ParametroscomisionesRepository parametroscomisionesRepository;

	/**
	 * Agrega un parametroscomisiones.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addParametroscomisiones(Parametroscomisiones parametroscomisiones) {
		parametroscomisionesRepository.addParametroscomisiones(parametroscomisiones);
	}

	/**
	 * Edita un parametroscomisiones.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editParametroscomisiones(Parametroscomisiones parametroscomisiones) {
		parametroscomisionesRepository.editParametroscomisiones(parametroscomisiones);
	}
	
	/**
	 * Consulta informacion de parametroscomisioness.
	 */
	public List<Parametroscomisiones> listParametroscomisioness(Parametroscomisiones parametroscomisiones) {
		return parametroscomisionesRepository.listParametroscomisioness(parametroscomisiones);
	}

	/**
	 * Obtiene informacion de un parametroscomisiones.
	 */
	public Parametroscomisiones getParametroscomisiones(UUID empid) {
		return parametroscomisionesRepository.getParametroscomisiones(empid);
	}

	/**
	 * Elimina un parametroscomisiones.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteParametroscomisiones(Parametroscomisiones parametroscomisiones) {
		 parametroscomisionesRepository.deleteParametroscomisiones(parametroscomisiones);
	}

	/**
	 * Consulta informacion de parametroscomisioness y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Parametroscomisiones> listParametroscomisionessPagination(Parametroscomisiones parametroscomisiones, int page, int size) {
		return parametroscomisionesRepository.listParametroscomisionessPagination(parametroscomisiones, page, size);
	}

	/**
	 * Obtiene el numero de parametroscomisioness consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return parametroscomisionesRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de parametroscomisioness consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return parametroscomisionesRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de parametroscomisioness consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return parametroscomisionesRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los parametroscomisioness y la pagina.
	 */
	public List<Parametroscomisiones> listParametroscomisionessQuery(Parametroscomisiones parametroscomisiones, String query, int page, int size) {
		// TODO Auto-generated method stub
		return parametroscomisionesRepository.listParametroscomisionessQuery(parametroscomisiones, query, page, size);
	}
}	
