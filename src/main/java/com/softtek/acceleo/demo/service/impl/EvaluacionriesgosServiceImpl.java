/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los evaluacionriesgoss. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.EvaluacionriesgosRepository;
import com.softtek.acceleo.demo.domain.Evaluacionriesgos;
import com.softtek.acceleo.demo.service.EvaluacionriesgosService;
/**
 * Clase EvaluacionriesgosServiceImpl.
 * @author PSG.
 *
 */
@Service("evaluacionriesgosService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EvaluacionriesgosServiceImpl implements EvaluacionriesgosService {

	@Autowired
	private EvaluacionriesgosRepository evaluacionriesgosRepository;

	/**
	 * Agrega un evaluacionriesgos.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEvaluacionriesgos(Evaluacionriesgos evaluacionriesgos) {
		evaluacionriesgosRepository.addEvaluacionriesgos(evaluacionriesgos);
	}

	/**
	 * Edita un evaluacionriesgos.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editEvaluacionriesgos(Evaluacionriesgos evaluacionriesgos) {
		evaluacionriesgosRepository.editEvaluacionriesgos(evaluacionriesgos);
	}
	
	/**
	 * Consulta informacion de evaluacionriesgoss.
	 */
	public List<Evaluacionriesgos> listEvaluacionriesgoss(Evaluacionriesgos evaluacionriesgos) {
		return evaluacionriesgosRepository.listEvaluacionriesgoss(evaluacionriesgos);
	}

	/**
	 * Obtiene informacion de un evaluacionriesgos.
	 */
	public Evaluacionriesgos getEvaluacionriesgos(UUID empid) {
		return evaluacionriesgosRepository.getEvaluacionriesgos(empid);
	}

	/**
	 * Elimina un evaluacionriesgos.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteEvaluacionriesgos(Evaluacionriesgos evaluacionriesgos) {
		 evaluacionriesgosRepository.deleteEvaluacionriesgos(evaluacionriesgos);
	}

	/**
	 * Consulta informacion de evaluacionriesgoss y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Evaluacionriesgos> listEvaluacionriesgossPagination(Evaluacionriesgos evaluacionriesgos, int page, int size) {
		return evaluacionriesgosRepository.listEvaluacionriesgossPagination(evaluacionriesgos, page, size);
	}

	/**
	 * Obtiene el numero de evaluacionriesgoss consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return evaluacionriesgosRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de evaluacionriesgoss consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return evaluacionriesgosRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de evaluacionriesgoss consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return evaluacionriesgosRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los evaluacionriesgoss y la pagina.
	 */
	public List<Evaluacionriesgos> listEvaluacionriesgossQuery(Evaluacionriesgos evaluacionriesgos, String query, int page, int size) {
		// TODO Auto-generated method stub
		return evaluacionriesgosRepository.listEvaluacionriesgossQuery(evaluacionriesgos, query, page, size);
	}
}	
