
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los trayectorias. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.TrayectoriaRepository;
import com.softtek.acceleo.demo.domain.Trayectoria;
import com.softtek.acceleo.demo.service.TrayectoriaService;
/**
 * Clase TrayectoriaServiceImpl.
 * @author PSG.
 *
 */
@Service("trayectoriaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrayectoriaServiceImpl implements TrayectoriaService {

	@Autowired
	private TrayectoriaRepository trayectoriaRepository;

	/**
	 * Agrega un trayectoria.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTrayectoria(Trayectoria trayectoria) {
		
		trayectoriaRepository.addTrayectoria(trayectoria);
	}

	/**
	 * Edita un trayectoria.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editTrayectoria(Trayectoria trayectoria) {
		
		trayectoriaRepository.editTrayectoria(trayectoria);
	}
	
	/**
	 * Consulta informacion de trayectorias.
	 */
	public List<Trayectoria> listTrayectorias(Trayectoria trayectoria) {

		return trayectoriaRepository.listTrayectorias(trayectoria);
	}
	
	/**
	 * Consulta informacion de trayectorias.
	 */
	public List<Trayectoria> listTrayectoriasByCandidato(Trayectoria trayectoria, int id) {

		return trayectoriaRepository.listTrayectoriasByCandidato(trayectoria, id);
	}

	/**
	 * Obtiene informacion de un trayectoria.
	 */
	public Trayectoria getTrayectoria(int empid) {

		return trayectoriaRepository.getTrayectoria(empid);
	}

	/**
	 * Elimina un trayectoria.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteTrayectoria(Trayectoria trayectoria) {
		System.out.println("Entrando al deleteTrayectoria");

		 trayectoriaRepository.deleteTrayectoria(trayectoria);
	}

	/**
	 * Consulta informacion de trayectorias y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Trayectoria> listTrayectoriasPagination(Trayectoria trayectoria, int page, int size) {

		return trayectoriaRepository.listTrayectoriasPagination(trayectoria, page, size);
	}

	/**
	 * Obtiene el numero de trayectorias consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return trayectoriaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de trayectorias consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return trayectoriaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de trayectorias consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return trayectoriaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los trayectorias y la pagina.
	 */
	public List<Trayectoria> listTrayectoriasQuery(Trayectoria trayectoria, String query, int page, int size) {
		// TODO Auto-generated method stub
		return trayectoriaRepository.listTrayectoriasQuery(trayectoria, query, page, size);
	}

}

