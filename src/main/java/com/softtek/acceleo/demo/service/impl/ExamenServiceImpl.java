/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los examens. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ExamenRepository;
import com.softtek.acceleo.demo.domain.Examen;
import com.softtek.acceleo.demo.service.ExamenService;
/**
 * Clase ExamenServiceImpl.
 * @author PSG.
 *
 */
@Service("examenService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ExamenServiceImpl implements ExamenService {

	@Autowired
	private ExamenRepository examenRepository;

	/**
	 * Agrega un examen.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addExamen(Examen examen) {
		examenRepository.addExamen(examen);
	}

	/**
	 * Edita un examen.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editExamen(Examen examen) {
		examenRepository.editExamen(examen);
	}
	
	/**
	 * Consulta informacion de examens.
	 */
	public List<Examen> listExamens(Examen examen) {
		return examenRepository.listExamens(examen);
	}

	/**
	 * Obtiene informacion de un examen.
	 */
	public Examen getExamen(int empid) {
		return examenRepository.getExamen(empid);
	}

	/**
	 * Elimina un examen.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteExamen(Examen examen) {
		 examenRepository.deleteExamen(examen);
	}

	/**
	 * Consulta informacion de examens y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Examen> listExamensPagination(Examen examen, int page, int size) {
		return examenRepository.listExamensPagination(examen, page, size);
	}

	/**
	 * Obtiene el numero de examens consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return examenRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de examens consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return examenRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de examens consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return examenRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los examens y la pagina.
	 */
	public List<Examen> listExamensQuery(Examen examen, String query, int page, int size) {
		// TODO Auto-generated method stub
		return examenRepository.listExamensQuery(examen, query, page, size);
	}
}	
