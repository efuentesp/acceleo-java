/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los preguntas. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.PreguntaRepository;
import com.softtek.acceleo.demo.domain.Pregunta;
import com.softtek.acceleo.demo.service.PreguntaService;
/**
 * Clase PreguntaServiceImpl.
 * @author PSG.
 *
 */
@Service("preguntaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PreguntaServiceImpl implements PreguntaService {

	@Autowired
	private PreguntaRepository preguntaRepository;

	/**
	 * Agrega un pregunta.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPregunta(Pregunta pregunta) {
		preguntaRepository.addPregunta(pregunta);
	}

	/**
	 * Edita un pregunta.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editPregunta(Pregunta pregunta) {
		preguntaRepository.editPregunta(pregunta);
	}
	
	/**
	 * Consulta informacion de preguntas.
	 */
	public List<Pregunta> listPreguntas(Pregunta pregunta) {
		return preguntaRepository.listPreguntas(pregunta);
	}

	/**
	 * Obtiene informacion de un pregunta.
	 */
	public Pregunta getPregunta(int empid) {
		return preguntaRepository.getPregunta(empid);
	}

	/**
	 * Elimina un pregunta.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePregunta(Pregunta pregunta) {
		 preguntaRepository.deletePregunta(pregunta);
	}

	/**
	 * Consulta informacion de preguntas y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Pregunta> listPreguntasPagination(Pregunta pregunta, int page, int size) {
		return preguntaRepository.listPreguntasPagination(pregunta, page, size);
	}

	/**
	 * Obtiene el numero de preguntas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return preguntaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de preguntas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return preguntaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de preguntas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return preguntaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los preguntas y la pagina.
	 */
	public List<Pregunta> listPreguntasQuery(Pregunta pregunta, String query, int page, int size) {
		// TODO Auto-generated method stub
		return preguntaRepository.listPreguntasQuery(pregunta, query, page, size);
	}
}	
