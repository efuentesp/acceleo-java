/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los fideicomisos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.FideicomisoRepository;
import com.softtek.acceleo.demo.domain.Fideicomiso;
import com.softtek.acceleo.demo.service.FideicomisoService;
/**
 * Clase FideicomisoServiceImpl.
 * @author PSG.
 *
 */
@Service("fideicomisoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FideicomisoServiceImpl implements FideicomisoService {

	@Autowired
	private FideicomisoRepository fideicomisoRepository;

	/**
	 * Agrega un fideicomiso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFideicomiso(Fideicomiso fideicomiso) {
		fideicomisoRepository.addFideicomiso(fideicomiso);
	}

	/**
	 * Edita un fideicomiso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editFideicomiso(Fideicomiso fideicomiso) {
		fideicomisoRepository.editFideicomiso(fideicomiso);
	}
	
	/**
	 * Consulta informacion de fideicomisos.
	 */
	public List<Fideicomiso> listFideicomisos(Fideicomiso fideicomiso) {
		return fideicomisoRepository.listFideicomisos(fideicomiso);
	}

	/**
	 * Obtiene informacion de un fideicomiso.
	 */
	public Fideicomiso getFideicomiso(UUID empid) {
		return fideicomisoRepository.getFideicomiso(empid);
	}

	/**
	 * Elimina un fideicomiso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteFideicomiso(Fideicomiso fideicomiso) {
		 fideicomisoRepository.deleteFideicomiso(fideicomiso);
	}

	/**
	 * Consulta informacion de fideicomisos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Fideicomiso> listFideicomisosPagination(Fideicomiso fideicomiso, int page, int size) {
		return fideicomisoRepository.listFideicomisosPagination(fideicomiso, page, size);
	}

	/**
	 * Obtiene el numero de fideicomisos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return fideicomisoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de fideicomisos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return fideicomisoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de fideicomisos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return fideicomisoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los fideicomisos y la pagina.
	 */
	public List<Fideicomiso> listFideicomisosQuery(Fideicomiso fideicomiso, String query, int page, int size) {
		// TODO Auto-generated method stub
		return fideicomisoRepository.listFideicomisosQuery(fideicomiso, query, page, size);
	}
}	
