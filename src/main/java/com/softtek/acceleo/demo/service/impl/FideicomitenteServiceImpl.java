/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los fideicomitentes. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.FideicomitenteRepository;
import com.softtek.acceleo.demo.domain.Fideicomitente;
import com.softtek.acceleo.demo.service.FideicomitenteService;
/**
 * Clase FideicomitenteServiceImpl.
 * @author PSG.
 *
 */
@Service("fideicomitenteService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FideicomitenteServiceImpl implements FideicomitenteService {

	@Autowired
	private FideicomitenteRepository fideicomitenteRepository;

	/**
	 * Agrega un fideicomitente.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFideicomitente(Fideicomitente fideicomitente) {
		fideicomitenteRepository.addFideicomitente(fideicomitente);
	}

	/**
	 * Edita un fideicomitente.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editFideicomitente(Fideicomitente fideicomitente) {
		fideicomitenteRepository.editFideicomitente(fideicomitente);
	}
	
	/**
	 * Consulta informacion de fideicomitentes.
	 */
	public List<Fideicomitente> listFideicomitentes(Fideicomitente fideicomitente) {
		return fideicomitenteRepository.listFideicomitentes(fideicomitente);
	}

	/**
	 * Obtiene informacion de un fideicomitente.
	 */
	public Fideicomitente getFideicomitente(UUID empid) {
		return fideicomitenteRepository.getFideicomitente(empid);
	}

	/**
	 * Elimina un fideicomitente.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteFideicomitente(Fideicomitente fideicomitente) {
		 fideicomitenteRepository.deleteFideicomitente(fideicomitente);
	}

	/**
	 * Consulta informacion de fideicomitentes y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Fideicomitente> listFideicomitentesPagination(Fideicomitente fideicomitente, int page, int size) {
		return fideicomitenteRepository.listFideicomitentesPagination(fideicomitente, page, size);
	}

	/**
	 * Obtiene el numero de fideicomitentes consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return fideicomitenteRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de fideicomitentes consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return fideicomitenteRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de fideicomitentes consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return fideicomitenteRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los fideicomitentes y la pagina.
	 */
	public List<Fideicomitente> listFideicomitentesQuery(Fideicomitente fideicomitente, String query, int page, int size) {
		// TODO Auto-generated method stub
		return fideicomitenteRepository.listFideicomitentesQuery(fideicomitente, query, page, size);
	}
}	
