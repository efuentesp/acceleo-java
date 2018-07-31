
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los functionalservices. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.FunctionalserviceRepository;
import com.softtek.acceleo.demo.domain.Functionalservice;
import com.softtek.acceleo.demo.service.FunctionalserviceService;
/**
 * Clase FunctionalserviceServiceImpl.
 * @author PSG.
 *
 */
@Service("functionalserviceService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FunctionalserviceServiceImpl implements FunctionalserviceService {

	@Autowired
	private FunctionalserviceRepository functionalserviceRepository;

	/**
	 * Agrega un functionalservice.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFunctionalservice(Functionalservice functionalservice) {
		
		functionalserviceRepository.addFunctionalservice(functionalservice);
	}

	/**
	 * Edita un functionalservice.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editFunctionalservice(Functionalservice functionalservice) {
		
		functionalserviceRepository.editFunctionalservice(functionalservice);
	}
	
	/**
	 * Consulta informacion de functionalservices.
	 */
	public List<Functionalservice> listFunctionalservices(Functionalservice functionalservice) {

		return functionalserviceRepository.listFunctionalservices(functionalservice);
	}

	/**
	 * Obtiene informacion de un functionalservice.
	 */
	public Functionalservice getFunctionalservice(int empid) {

		return functionalserviceRepository.getFunctionalservice(empid);
	}

	/**
	 * Elimina un functionalservice.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteFunctionalservice(Functionalservice functionalservice) {
		System.out.println("Entrando al deleteFunctionalservice");

		 functionalserviceRepository.deleteFunctionalservice(functionalservice);
	}

	/**
	 * Consulta informacion de functionalservices y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Functionalservice> listFunctionalservicesPagination(Functionalservice functionalservice, int page, int size) {

		return functionalserviceRepository.listFunctionalservicesPagination(functionalservice, page, size);
	}

	/**
	 * Obtiene el numero de functionalservices consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return functionalserviceRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de functionalservices consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return functionalserviceRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de functionalservices consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return functionalserviceRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los functionalservices y la pagina.
	 */
	public List<Functionalservice> listFunctionalservicesQuery(Functionalservice functionalservice, String query, int page, int size) {
		// TODO Auto-generated method stub
		return functionalserviceRepository.listFunctionalservicesQuery(functionalservice, query, page, size);
	}

}

