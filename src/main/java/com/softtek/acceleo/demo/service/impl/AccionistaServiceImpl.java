/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los accionistas. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.AccionistaRepository;
import com.softtek.acceleo.demo.domain.Accionista;
import com.softtek.acceleo.demo.service.AccionistaService;
/**
 * Clase AccionistaServiceImpl.
 * @author PSG.
 *
 */
@Service("accionistaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccionistaServiceImpl implements AccionistaService {

	@Autowired
	private AccionistaRepository accionistaRepository;

	/**
	 * Agrega un accionista.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAccionista(Accionista accionista) {
		accionistaRepository.addAccionista(accionista);
	}

	/**
	 * Edita un accionista.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAccionista(Accionista accionista) {
		accionistaRepository.editAccionista(accionista);
	}
	
	/**
	 * Consulta informacion de accionistas.
	 */
	public List<Accionista> listAccionistas(Accionista accionista) {
		return accionistaRepository.listAccionistas(accionista);
	}

	/**
	 * Obtiene informacion de un accionista.
	 */
	public Accionista getAccionista(UUID empid) {
		return accionistaRepository.getAccionista(empid);
	}

	/**
	 * Elimina un accionista.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAccionista(Accionista accionista) {
		 accionistaRepository.deleteAccionista(accionista);
	}

	/**
	 * Consulta informacion de accionistas y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Accionista> listAccionistasPagination(Accionista accionista, int page, int size) {
		return accionistaRepository.listAccionistasPagination(accionista, page, size);
	}

	/**
	 * Obtiene el numero de accionistas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return accionistaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de accionistas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return accionistaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de accionistas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return accionistaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los accionistas y la pagina.
	 */
	public List<Accionista> listAccionistasQuery(Accionista accionista, String query, int page, int size) {
		// TODO Auto-generated method stub
		return accionistaRepository.listAccionistasQuery(accionista, query, page, size);
	}
}	
