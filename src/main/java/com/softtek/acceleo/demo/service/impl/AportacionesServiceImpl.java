/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los aportacioness. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.AportacionesRepository;
import com.softtek.acceleo.demo.domain.Aportaciones;
import com.softtek.acceleo.demo.service.AportacionesService;
/**
 * Clase AportacionesServiceImpl.
 * @author PSG.
 *
 */
@Service("aportacionesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AportacionesServiceImpl implements AportacionesService {

	@Autowired
	private AportacionesRepository aportacionesRepository;

	/**
	 * Agrega un aportaciones.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAportaciones(Aportaciones aportaciones) {
		aportacionesRepository.addAportaciones(aportaciones);
	}

	/**
	 * Edita un aportaciones.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAportaciones(Aportaciones aportaciones) {
		aportacionesRepository.editAportaciones(aportaciones);
	}
	
	/**
	 * Consulta informacion de aportacioness.
	 */
	public List<Aportaciones> listAportacioness(Aportaciones aportaciones) {
		return aportacionesRepository.listAportacioness(aportaciones);
	}

	/**
	 * Obtiene informacion de un aportaciones.
	 */
	public Aportaciones getAportaciones(UUID empid) {
		return aportacionesRepository.getAportaciones(empid);
	}

	/**
	 * Elimina un aportaciones.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAportaciones(Aportaciones aportaciones) {
		 aportacionesRepository.deleteAportaciones(aportaciones);
	}

	/**
	 * Consulta informacion de aportacioness y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Aportaciones> listAportacionessPagination(Aportaciones aportaciones, int page, int size) {
		return aportacionesRepository.listAportacionessPagination(aportaciones, page, size);
	}

	/**
	 * Obtiene el numero de aportacioness consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return aportacionesRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de aportacioness consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return aportacionesRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de aportacioness consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return aportacionesRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los aportacioness y la pagina.
	 */
	public List<Aportaciones> listAportacionessQuery(Aportaciones aportaciones, String query, int page, int size) {
		// TODO Auto-generated method stub
		return aportacionesRepository.listAportacionessQuery(aportaciones, query, page, size);
	}
}	
