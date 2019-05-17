/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los profesors. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ProfesorRepository;
import com.softtek.acceleo.demo.domain.Profesor;
import com.softtek.acceleo.demo.service.ProfesorService;
/**
 * Clase ProfesorServiceImpl.
 * @author PSG.
 *
 */
@Service("profesorService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorRepository profesorRepository;

	/**
	 * Agrega un profesor.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfesor(Profesor profesor) {
		profesorRepository.addProfesor(profesor);
	}

	/**
	 * Edita un profesor.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editProfesor(Profesor profesor) {
		profesorRepository.editProfesor(profesor);
	}
	
	/**
	 * Consulta informacion de profesors.
	 */
	public List<Profesor> listProfesors(Profesor profesor) {
		return profesorRepository.listProfesors(profesor);
	}

	/**
	 * Obtiene informacion de un profesor.
	 */
	public Profesor getProfesor(int empid) {
		return profesorRepository.getProfesor(empid);
	}

	/**
	 * Elimina un profesor.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteProfesor(Profesor profesor) {
		 profesorRepository.deleteProfesor(profesor);
	}

	/**
	 * Consulta informacion de profesors y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Profesor> listProfesorsPagination(Profesor profesor, int page, int size) {
		return profesorRepository.listProfesorsPagination(profesor, page, size);
	}

	/**
	 * Obtiene el numero de profesors consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return profesorRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de profesors consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return profesorRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de profesors consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return profesorRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los profesors y la pagina.
	 */
	public List<Profesor> listProfesorsQuery(Profesor profesor, String query, int page, int size) {
		// TODO Auto-generated method stub
		return profesorRepository.listProfesorsQuery(profesor, query, page, size);
	}
}	
