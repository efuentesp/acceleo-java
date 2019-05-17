/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los recursos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.RecursoRepository;
import com.softtek.acceleo.demo.domain.Recurso;
import com.softtek.acceleo.demo.service.RecursoService;
/**
 * Clase RecursoServiceImpl.
 * @author PSG.
 *
 */
@Service("recursoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RecursoServiceImpl implements RecursoService {

	@Autowired
	private RecursoRepository recursoRepository;

	/**
	 * Agrega un recurso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addRecurso(Recurso recurso) {
		recursoRepository.addRecurso(recurso);
	}

	/**
	 * Edita un recurso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editRecurso(Recurso recurso) {
		recursoRepository.editRecurso(recurso);
	}
	
	/**
	 * Consulta informacion de recursos.
	 */
	public List<Recurso> listRecursos(Recurso recurso) {
		return recursoRepository.listRecursos(recurso);
	}

	/**
	 * Obtiene informacion de un recurso.
	 */
	public Recurso getRecurso(int empid) {
		return recursoRepository.getRecurso(empid);
	}

	/**
	 * Elimina un recurso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteRecurso(Recurso recurso) {
		 recursoRepository.deleteRecurso(recurso);
	}

	/**
	 * Consulta informacion de recursos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Recurso> listRecursosPagination(Recurso recurso, int page, int size) {
		return recursoRepository.listRecursosPagination(recurso, page, size);
	}

	/**
	 * Obtiene el numero de recursos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return recursoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de recursos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return recursoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de recursos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return recursoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los recursos y la pagina.
	 */
	public List<Recurso> listRecursosQuery(Recurso recurso, String query, int page, int size) {
		// TODO Auto-generated method stub
		return recursoRepository.listRecursosQuery(recurso, query, page, size);
	}
}	
