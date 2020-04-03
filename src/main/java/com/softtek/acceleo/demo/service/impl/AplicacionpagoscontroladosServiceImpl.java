/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los aplicacionpagoscontroladoss. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.AplicacionpagoscontroladosRepository;
import com.softtek.acceleo.demo.domain.Aplicacionpagoscontrolados;
import com.softtek.acceleo.demo.service.AplicacionpagoscontroladosService;
/**
 * Clase AplicacionpagoscontroladosServiceImpl.
 * @author PSG.
 *
 */
@Service("aplicacionpagoscontroladosService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AplicacionpagoscontroladosServiceImpl implements AplicacionpagoscontroladosService {

	@Autowired
	private AplicacionpagoscontroladosRepository aplicacionpagoscontroladosRepository;

	/**
	 * Agrega un aplicacionpagoscontrolados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAplicacionpagoscontrolados(Aplicacionpagoscontrolados aplicacionpagoscontrolados) {
		aplicacionpagoscontroladosRepository.addAplicacionpagoscontrolados(aplicacionpagoscontrolados);
	}

	/**
	 * Edita un aplicacionpagoscontrolados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAplicacionpagoscontrolados(Aplicacionpagoscontrolados aplicacionpagoscontrolados) {
		aplicacionpagoscontroladosRepository.editAplicacionpagoscontrolados(aplicacionpagoscontrolados);
	}
	
	/**
	 * Consulta informacion de aplicacionpagoscontroladoss.
	 */
	public List<Aplicacionpagoscontrolados> listAplicacionpagoscontroladoss(Aplicacionpagoscontrolados aplicacionpagoscontrolados) {
		return aplicacionpagoscontroladosRepository.listAplicacionpagoscontroladoss(aplicacionpagoscontrolados);
	}

	/**
	 * Obtiene informacion de un aplicacionpagoscontrolados.
	 */
	public Aplicacionpagoscontrolados getAplicacionpagoscontrolados(UUID empid) {
		return aplicacionpagoscontroladosRepository.getAplicacionpagoscontrolados(empid);
	}

	/**
	 * Elimina un aplicacionpagoscontrolados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAplicacionpagoscontrolados(Aplicacionpagoscontrolados aplicacionpagoscontrolados) {
		 aplicacionpagoscontroladosRepository.deleteAplicacionpagoscontrolados(aplicacionpagoscontrolados);
	}

	/**
	 * Consulta informacion de aplicacionpagoscontroladoss y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Aplicacionpagoscontrolados> listAplicacionpagoscontroladossPagination(Aplicacionpagoscontrolados aplicacionpagoscontrolados, int page, int size) {
		return aplicacionpagoscontroladosRepository.listAplicacionpagoscontroladossPagination(aplicacionpagoscontrolados, page, size);
	}

	/**
	 * Obtiene el numero de aplicacionpagoscontroladoss consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return aplicacionpagoscontroladosRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de aplicacionpagoscontroladoss consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return aplicacionpagoscontroladosRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de aplicacionpagoscontroladoss consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return aplicacionpagoscontroladosRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los aplicacionpagoscontroladoss y la pagina.
	 */
	public List<Aplicacionpagoscontrolados> listAplicacionpagoscontroladossQuery(Aplicacionpagoscontrolados aplicacionpagoscontrolados, String query, int page, int size) {
		// TODO Auto-generated method stub
		return aplicacionpagoscontroladosRepository.listAplicacionpagoscontroladossQuery(aplicacionpagoscontrolados, query, page, size);
	}
}	
