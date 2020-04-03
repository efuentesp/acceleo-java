/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los comitetecnicos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ComitetecnicoRepository;
import com.softtek.acceleo.demo.domain.Comitetecnico;
import com.softtek.acceleo.demo.service.ComitetecnicoService;
/**
 * Clase ComitetecnicoServiceImpl.
 * @author PSG.
 *
 */
@Service("comitetecnicoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ComitetecnicoServiceImpl implements ComitetecnicoService {

	@Autowired
	private ComitetecnicoRepository comitetecnicoRepository;

	/**
	 * Agrega un comitetecnico.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addComitetecnico(Comitetecnico comitetecnico) {
		comitetecnicoRepository.addComitetecnico(comitetecnico);
	}

	/**
	 * Edita un comitetecnico.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editComitetecnico(Comitetecnico comitetecnico) {
		comitetecnicoRepository.editComitetecnico(comitetecnico);
	}
	
	/**
	 * Consulta informacion de comitetecnicos.
	 */
	public List<Comitetecnico> listComitetecnicos(Comitetecnico comitetecnico) {
		return comitetecnicoRepository.listComitetecnicos(comitetecnico);
	}

	/**
	 * Obtiene informacion de un comitetecnico.
	 */
	public Comitetecnico getComitetecnico(UUID empid) {
		return comitetecnicoRepository.getComitetecnico(empid);
	}

	/**
	 * Elimina un comitetecnico.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteComitetecnico(Comitetecnico comitetecnico) {
		 comitetecnicoRepository.deleteComitetecnico(comitetecnico);
	}

	/**
	 * Consulta informacion de comitetecnicos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Comitetecnico> listComitetecnicosPagination(Comitetecnico comitetecnico, int page, int size) {
		return comitetecnicoRepository.listComitetecnicosPagination(comitetecnico, page, size);
	}

	/**
	 * Obtiene el numero de comitetecnicos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return comitetecnicoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de comitetecnicos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return comitetecnicoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de comitetecnicos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return comitetecnicoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los comitetecnicos y la pagina.
	 */
	public List<Comitetecnico> listComitetecnicosQuery(Comitetecnico comitetecnico, String query, int page, int size) {
		// TODO Auto-generated method stub
		return comitetecnicoRepository.listComitetecnicosQuery(comitetecnico, query, page, size);
	}
}	
