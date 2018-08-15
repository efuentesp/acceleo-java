
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los domicilios. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.DomicilioRepository;
import com.softtek.acceleo.demo.domain.Domicilio;
import com.softtek.acceleo.demo.service.DomicilioService;
/**
 * Clase DomicilioServiceImpl.
 * @author PSG.
 *
 */
@Service("domicilioService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DomicilioServiceImpl implements DomicilioService {

	@Autowired
	private DomicilioRepository domicilioRepository;

	/**
	 * Agrega un domicilio.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDomicilio(Domicilio domicilio) {
		
		domicilioRepository.addDomicilio(domicilio);
	}

	/**
	 * Edita un domicilio.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editDomicilio(Domicilio domicilio) {
		
		domicilioRepository.editDomicilio(domicilio);
	}
	
	/**
	 * Consulta informacion de domicilios.
	 */
	public List<Domicilio> listDomicilios(Domicilio domicilio) {

		return domicilioRepository.listDomicilios(domicilio);
	}

	/**
	 * Obtiene informacion de un domicilio.
	 */
	public Domicilio getDomicilio(int empid) {

		return domicilioRepository.getDomicilio(empid);
	}

	/**
	 * Elimina un domicilio.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteDomicilio(Domicilio domicilio) {
		System.out.println("Entrando al deleteDomicilio");

		 domicilioRepository.deleteDomicilio(domicilio);
	}

	/**
	 * Consulta informacion de domicilios y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Domicilio> listDomiciliosPagination(Domicilio domicilio, int page, int size) {

		return domicilioRepository.listDomiciliosPagination(domicilio, page, size);
	}

	/**
	 * Obtiene el numero de domicilios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return domicilioRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de domicilios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return domicilioRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de domicilios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return domicilioRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los domicilios y la pagina.
	 */
	public List<Domicilio> listDomiciliosQuery(Domicilio domicilio, String query, int page, int size) {
		// TODO Auto-generated method stub
		return domicilioRepository.listDomiciliosQuery(domicilio, query, page, size);
	}

}

