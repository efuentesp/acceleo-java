
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los puestos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.PuestoRepository;
import com.softtek.acceleo.demo.domain.Puesto;
import com.softtek.acceleo.demo.service.PuestoService;
/**
 * Clase PuestoServiceImpl.
 * @author PSG.
 *
 */
@Service("puestoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PuestoServiceImpl implements PuestoService {

	@Autowired
	private PuestoRepository puestoRepository;

	/**
	 * Agrega un puesto.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPuesto(Puesto puesto) {
		
		puestoRepository.addPuesto(puesto);
	}

	/**
	 * Edita un puesto.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editPuesto(Puesto puesto) {
		
		puestoRepository.editPuesto(puesto);
	}
	
	/**
	 * Consulta informacion de puestos.
	 */
	public List<Puesto> listPuestos(Puesto puesto) {

		return puestoRepository.listPuestos(puesto);
	}
	
	/**
	 * Consulta informacion de puestos.
	 */
	public List<Puesto> listPuestosByCandidato(Puesto puesto, int id) {

		return puestoRepository.listPuestosByCandidato(puesto, id);
	}

	/**
	 * Obtiene informacion de un puesto.
	 */
	public Puesto getPuesto(int empid) {

		return puestoRepository.getPuesto(empid);
	}

	/**
	 * Elimina un puesto.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePuesto(Puesto puesto) {
		System.out.println("Entrando al deletePuesto");

		 puestoRepository.deletePuesto(puesto);
	}

	/**
	 * Consulta informacion de puestos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Puesto> listPuestosPagination(Puesto puesto, int page, int size) {

		return puestoRepository.listPuestosPagination(puesto, page, size);
	}

	/**
	 * Obtiene el numero de puestos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return puestoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de puestos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return puestoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de puestos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return puestoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los puestos y la pagina.
	 */
	public List<Puesto> listPuestosQuery(Puesto puesto, String query, int page, int size) {
		// TODO Auto-generated method stub
		return puestoRepository.listPuestosQuery(puesto, query, page, size);
	}

}

