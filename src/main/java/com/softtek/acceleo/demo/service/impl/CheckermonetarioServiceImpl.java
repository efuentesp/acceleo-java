/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los checkermonetarios. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.CheckermonetarioRepository;
import com.softtek.acceleo.demo.domain.Checkermonetario;
import com.softtek.acceleo.demo.service.CheckermonetarioService;
/**
 * Clase CheckermonetarioServiceImpl.
 * @author PSG.
 *
 */
@Service("checkermonetarioService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CheckermonetarioServiceImpl implements CheckermonetarioService {

	@Autowired
	private CheckermonetarioRepository checkermonetarioRepository;

	/**
	 * Agrega un checkermonetario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCheckermonetario(Checkermonetario checkermonetario) {
		checkermonetarioRepository.addCheckermonetario(checkermonetario);
	}

	/**
	 * Edita un checkermonetario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editCheckermonetario(Checkermonetario checkermonetario) {
		checkermonetarioRepository.editCheckermonetario(checkermonetario);
	}
	
	/**
	 * Consulta informacion de checkermonetarios.
	 */
	public List<Checkermonetario> listCheckermonetarios(Checkermonetario checkermonetario) {
		return checkermonetarioRepository.listCheckermonetarios(checkermonetario);
	}

	/**
	 * Obtiene informacion de un checkermonetario.
	 */
	public Checkermonetario getCheckermonetario(UUID empid) {
		return checkermonetarioRepository.getCheckermonetario(empid);
	}

	/**
	 * Elimina un checkermonetario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCheckermonetario(Checkermonetario checkermonetario) {
		 checkermonetarioRepository.deleteCheckermonetario(checkermonetario);
	}

	/**
	 * Consulta informacion de checkermonetarios y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Checkermonetario> listCheckermonetariosPagination(Checkermonetario checkermonetario, int page, int size) {
		return checkermonetarioRepository.listCheckermonetariosPagination(checkermonetario, page, size);
	}

	/**
	 * Obtiene el numero de checkermonetarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return checkermonetarioRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de checkermonetarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return checkermonetarioRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de checkermonetarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return checkermonetarioRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los checkermonetarios y la pagina.
	 */
	public List<Checkermonetario> listCheckermonetariosQuery(Checkermonetario checkermonetario, String query, int page, int size) {
		// TODO Auto-generated method stub
		return checkermonetarioRepository.listCheckermonetariosQuery(checkermonetario, query, page, size);
	}
}	
