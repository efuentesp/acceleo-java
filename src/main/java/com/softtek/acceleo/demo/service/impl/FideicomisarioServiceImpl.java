/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los fideicomisarios. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.FideicomisarioRepository;
import com.softtek.acceleo.demo.domain.Fideicomisario;
import com.softtek.acceleo.demo.service.FideicomisarioService;
/**
 * Clase FideicomisarioServiceImpl.
 * @author PSG.
 *
 */
@Service("fideicomisarioService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FideicomisarioServiceImpl implements FideicomisarioService {

	@Autowired
	private FideicomisarioRepository fideicomisarioRepository;

	/**
	 * Agrega un fideicomisario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFideicomisario(Fideicomisario fideicomisario) {
		fideicomisarioRepository.addFideicomisario(fideicomisario);
	}

	/**
	 * Edita un fideicomisario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editFideicomisario(Fideicomisario fideicomisario) {
		fideicomisarioRepository.editFideicomisario(fideicomisario);
	}
	
	/**
	 * Consulta informacion de fideicomisarios.
	 */
	public List<Fideicomisario> listFideicomisarios(Fideicomisario fideicomisario) {
		return fideicomisarioRepository.listFideicomisarios(fideicomisario);
	}

	/**
	 * Obtiene informacion de un fideicomisario.
	 */
	public Fideicomisario getFideicomisario(UUID empid) {
		return fideicomisarioRepository.getFideicomisario(empid);
	}

	/**
	 * Elimina un fideicomisario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteFideicomisario(Fideicomisario fideicomisario) {
		 fideicomisarioRepository.deleteFideicomisario(fideicomisario);
	}

	/**
	 * Consulta informacion de fideicomisarios y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Fideicomisario> listFideicomisariosPagination(Fideicomisario fideicomisario, int page, int size) {
		return fideicomisarioRepository.listFideicomisariosPagination(fideicomisario, page, size);
	}

	/**
	 * Obtiene el numero de fideicomisarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return fideicomisarioRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de fideicomisarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return fideicomisarioRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de fideicomisarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return fideicomisarioRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los fideicomisarios y la pagina.
	 */
	public List<Fideicomisario> listFideicomisariosQuery(Fideicomisario fideicomisario, String query, int page, int size) {
		// TODO Auto-generated method stub
		return fideicomisarioRepository.listFideicomisariosQuery(fideicomisario, query, page, size);
	}
}	
