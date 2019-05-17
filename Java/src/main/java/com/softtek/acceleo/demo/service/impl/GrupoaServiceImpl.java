/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los grupoas. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.GrupoaRepository;
import com.softtek.acceleo.demo.domain.Grupoa;
import com.softtek.acceleo.demo.service.GrupoaService;
/**
 * Clase GrupoaServiceImpl.
 * @author PSG.
 *
 */
@Service("grupoaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GrupoaServiceImpl implements GrupoaService {

	@Autowired
	private GrupoaRepository grupoaRepository;

	/**
	 * Agrega un grupoa.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addGrupoa(Grupoa grupoa) {
		grupoaRepository.addGrupoa(grupoa);
	}

	/**
	 * Edita un grupoa.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editGrupoa(Grupoa grupoa) {
		grupoaRepository.editGrupoa(grupoa);
	}
	
	/**
	 * Consulta informacion de grupoas.
	 */
	public List<Grupoa> listGrupoas(Grupoa grupoa) {
		return grupoaRepository.listGrupoas(grupoa);
	}

	/**
	 * Obtiene informacion de un grupoa.
	 */
	public Grupoa getGrupoa(int empid) {
		return grupoaRepository.getGrupoa(empid);
	}

	/**
	 * Elimina un grupoa.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteGrupoa(Grupoa grupoa) {
		 grupoaRepository.deleteGrupoa(grupoa);
	}

	/**
	 * Consulta informacion de grupoas y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Grupoa> listGrupoasPagination(Grupoa grupoa, int page, int size) {
		return grupoaRepository.listGrupoasPagination(grupoa, page, size);
	}

	/**
	 * Obtiene el numero de grupoas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return grupoaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de grupoas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return grupoaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de grupoas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return grupoaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los grupoas y la pagina.
	 */
	public List<Grupoa> listGrupoasQuery(Grupoa grupoa, String query, int page, int size) {
		// TODO Auto-generated method stub
		return grupoaRepository.listGrupoasQuery(grupoa, query, page, size);
	}
}	
