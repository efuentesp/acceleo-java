
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los reclutadors. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ReclutadorRepository;
import com.softtek.acceleo.demo.domain.Reclutador;
import com.softtek.acceleo.demo.service.ReclutadorService;
/**
 * Clase ReclutadorServiceImpl.
 * @author PSG.
 *
 */
@Service("reclutadorService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReclutadorServiceImpl implements ReclutadorService {

	@Autowired
	private ReclutadorRepository reclutadorRepository;

	/**
	 * Agrega un reclutador.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addReclutador(Reclutador reclutador) {
		
		reclutadorRepository.addReclutador(reclutador);
	}

	/**
	 * Edita un reclutador.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editReclutador(Reclutador reclutador) {
		
		reclutadorRepository.editReclutador(reclutador);
	}
	
	/**
	 * Consulta informacion de reclutadors.
	 */
	public List<Reclutador> listReclutadors(Reclutador reclutador) {

		return reclutadorRepository.listReclutadors(reclutador);
	}

	/**
	 * Obtiene informacion de un reclutador.
	 */
	public Reclutador getReclutador(int empid) {

		return reclutadorRepository.getReclutador(empid);
	}

	/**
	 * Elimina un reclutador.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteReclutador(Reclutador reclutador) {
		System.out.println("Entrando al deleteReclutador");

		 reclutadorRepository.deleteReclutador(reclutador);
	}

	/**
	 * Consulta informacion de reclutadors y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Reclutador> listReclutadorsPagination(Reclutador reclutador, int page, int size) {

		return reclutadorRepository.listReclutadorsPagination(reclutador, page, size);
	}

	/**
	 * Obtiene el numero de reclutadors consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return reclutadorRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de reclutadors consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return reclutadorRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de reclutadors consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return reclutadorRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los reclutadors y la pagina.
	 */
	public List<Reclutador> listReclutadorsQuery(Reclutador reclutador, String query, int page, int size) {
		// TODO Auto-generated method stub
		return reclutadorRepository.listReclutadorsQuery(reclutador, query, page, size);
	}

}

