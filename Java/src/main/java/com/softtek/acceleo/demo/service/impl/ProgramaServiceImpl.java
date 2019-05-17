/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los programas. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ProgramaRepository;
import com.softtek.acceleo.demo.domain.Programa;
import com.softtek.acceleo.demo.service.ProgramaService;
/**
 * Clase ProgramaServiceImpl.
 * @author PSG.
 *
 */
@Service("programaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProgramaServiceImpl implements ProgramaService {

	@Autowired
	private ProgramaRepository programaRepository;

	/**
	 * Agrega un programa.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPrograma(Programa programa) {
		programaRepository.addPrograma(programa);
	}

	/**
	 * Edita un programa.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editPrograma(Programa programa) {
		programaRepository.editPrograma(programa);
	}
	
	/**
	 * Consulta informacion de programas.
	 */
	public List<Programa> listProgramas(Programa programa) {
		return programaRepository.listProgramas(programa);
	}

	/**
	 * Obtiene informacion de un programa.
	 */
	public Programa getPrograma(int empid) {
		return programaRepository.getPrograma(empid);
	}

	/**
	 * Elimina un programa.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePrograma(Programa programa) {
		 programaRepository.deletePrograma(programa);
	}

	/**
	 * Consulta informacion de programas y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Programa> listProgramasPagination(Programa programa, int page, int size) {
		return programaRepository.listProgramasPagination(programa, page, size);
	}

	/**
	 * Obtiene el numero de programas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return programaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de programas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return programaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de programas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return programaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los programas y la pagina.
	 */
	public List<Programa> listProgramasQuery(Programa programa, String query, int page, int size) {
		// TODO Auto-generated method stub
		return programaRepository.listProgramasQuery(programa, query, page, size);
	}
}	
