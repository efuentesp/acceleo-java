/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los candidatos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.CandidatoRepository;
import com.softtek.acceleo.demo.domain.Candidato;
import com.softtek.acceleo.demo.service.CandidatoService;
/**
 * Clase CandidatoServiceImpl.
 * @author PSG.
 *
 */
@Service("candidatoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CandidatoServiceImpl implements CandidatoService {

	@Autowired
	private CandidatoRepository candidatoRepository;

	/**
	 * Agrega un candidato.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCandidato(Candidato candidato) {
		candidatoRepository.addCandidato(candidato);
	}

	/**
	 * Edita un candidato.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editCandidato(Candidato candidato) {
		candidatoRepository.editCandidato(candidato);
	}
	
	/**
	 * Consulta informacion de candidatos.
	 */
	public List<Candidato> listCandidatos(Candidato candidato) {
		return candidatoRepository.listCandidatos(candidato);
	}

	/**
	 * Obtiene informacion de un candidato.
	 */
	public Candidato getCandidato(UUID empid) {
		return candidatoRepository.getCandidato(empid);
	}

	/**
	 * Elimina un candidato.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCandidato(Candidato candidato) {
		 candidatoRepository.deleteCandidato(candidato);
	}

	/**
	 * Consulta informacion de candidatos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Candidato> listCandidatosPagination(Candidato candidato, int page, int size) {
		return candidatoRepository.listCandidatosPagination(candidato, page, size);
	}

	/**
	 * Obtiene el numero de candidatos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return candidatoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de candidatos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return candidatoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de candidatos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return candidatoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los candidatos y la pagina.
	 */
	public List<Candidato> listCandidatosQuery(Candidato candidato, String query, int page, int size) {
		// TODO Auto-generated method stub
		return candidatoRepository.listCandidatosQuery(candidato, query, page, size);
	}
}	
