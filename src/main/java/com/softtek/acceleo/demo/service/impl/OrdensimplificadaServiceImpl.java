
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los ordensimplificadas. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.OrdensimplificadaRepository;
import com.softtek.acceleo.demo.domain.Ordensimplificada;
import com.softtek.acceleo.demo.service.OrdensimplificadaService;
/**
 * Clase OrdensimplificadaServiceImpl.
 * @author PSG.
 *
 */
@Service("ordensimplificadaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OrdensimplificadaServiceImpl implements OrdensimplificadaService {

	@Autowired
	private OrdensimplificadaRepository ordensimplificadaRepository;

	/**
	 * Agrega un ordensimplificada.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addOrdensimplificada(Ordensimplificada ordensimplificada) {
		
		ordensimplificadaRepository.addOrdensimplificada(ordensimplificada);
	}

	/**
	 * Edita un ordensimplificada.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editOrdensimplificada(Ordensimplificada ordensimplificada) {
		
		ordensimplificadaRepository.editOrdensimplificada(ordensimplificada);
	}
	
	/**
	 * Consulta informacion de ordensimplificadas.
	 */
	public List<Ordensimplificada> listOrdensimplificadas(Ordensimplificada ordensimplificada) {

		return ordensimplificadaRepository.listOrdensimplificadas(ordensimplificada);
	}

	/**
	 * Obtiene informacion de un ordensimplificada.
	 */
	public Ordensimplificada getOrdensimplificada(int empid) {

		return ordensimplificadaRepository.getOrdensimplificada(empid);
	}

	/**
	 * Elimina un ordensimplificada.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteOrdensimplificada(Ordensimplificada ordensimplificada) {
		System.out.println("Entrando al deleteOrdensimplificada");

		 ordensimplificadaRepository.deleteOrdensimplificada(ordensimplificada);
	}

	/**
	 * Consulta informacion de ordensimplificadas y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Ordensimplificada> listOrdensimplificadasPagination(Ordensimplificada ordensimplificada, int page, int size) {

		return ordensimplificadaRepository.listOrdensimplificadasPagination(ordensimplificada, page, size);
	}

	/**
	 * Obtiene el numero de ordensimplificadas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return ordensimplificadaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de ordensimplificadas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return ordensimplificadaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de ordensimplificadas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return ordensimplificadaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los ordensimplificadas y la pagina.
	 */
	public List<Ordensimplificada> listOrdensimplificadasQuery(Ordensimplificada ordensimplificada, String query, int page, int size) {
		// TODO Auto-generated method stub
		return ordensimplificadaRepository.listOrdensimplificadasQuery(ordensimplificada, query, page, size);
	}

}

