/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los estudiantes. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.EstudianteRepository;
import com.softtek.acceleo.demo.domain.Estudiante;
import com.softtek.acceleo.demo.service.EstudianteService;
/**
 * Clase EstudianteServiceImpl.
 * @author PSG.
 *
 */
@Service("estudianteService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	/**
	 * Agrega un estudiante.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEstudiante(Estudiante estudiante) {
		estudianteRepository.addEstudiante(estudiante);
	}

	/**
	 * Edita un estudiante.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editEstudiante(Estudiante estudiante) {
		estudianteRepository.editEstudiante(estudiante);
	}
	
	/**
	 * Consulta informacion de estudiantes.
	 */
	public List<Estudiante> listEstudiantes(Estudiante estudiante) {
		return estudianteRepository.listEstudiantes(estudiante);
	}

	/**
	 * Obtiene informacion de un estudiante.
	 */
	public Estudiante getEstudiante(int empid) {
		return estudianteRepository.getEstudiante(empid);
	}

	/**
	 * Elimina un estudiante.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteEstudiante(Estudiante estudiante) {
		 estudianteRepository.deleteEstudiante(estudiante);
	}

	/**
	 * Consulta informacion de estudiantes y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Estudiante> listEstudiantesPagination(Estudiante estudiante, int page, int size) {
		return estudianteRepository.listEstudiantesPagination(estudiante, page, size);
	}

	/**
	 * Obtiene el numero de estudiantes consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return estudianteRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de estudiantes consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return estudianteRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de estudiantes consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return estudianteRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los estudiantes y la pagina.
	 */
	public List<Estudiante> listEstudiantesQuery(Estudiante estudiante, String query, int page, int size) {
		// TODO Auto-generated method stub
		return estudianteRepository.listEstudiantesQuery(estudiante, query, page, size);
	}
}	
