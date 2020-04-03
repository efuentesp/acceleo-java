/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los formasliquidacions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.FormasliquidacionRepository;
import com.softtek.acceleo.demo.domain.Formasliquidacion;
import com.softtek.acceleo.demo.service.FormasliquidacionService;
/**
 * Clase FormasliquidacionServiceImpl.
 * @author PSG.
 *
 */
@Service("formasliquidacionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FormasliquidacionServiceImpl implements FormasliquidacionService {

	@Autowired
	private FormasliquidacionRepository formasliquidacionRepository;

	/**
	 * Agrega un formasliquidacion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFormasliquidacion(Formasliquidacion formasliquidacion) {
		formasliquidacionRepository.addFormasliquidacion(formasliquidacion);
	}

	/**
	 * Edita un formasliquidacion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editFormasliquidacion(Formasliquidacion formasliquidacion) {
		formasliquidacionRepository.editFormasliquidacion(formasliquidacion);
	}
	
	/**
	 * Consulta informacion de formasliquidacions.
	 */
	public List<Formasliquidacion> listFormasliquidacions(Formasliquidacion formasliquidacion) {
		return formasliquidacionRepository.listFormasliquidacions(formasliquidacion);
	}

	/**
	 * Obtiene informacion de un formasliquidacion.
	 */
	public Formasliquidacion getFormasliquidacion(UUID empid) {
		return formasliquidacionRepository.getFormasliquidacion(empid);
	}

	/**
	 * Elimina un formasliquidacion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteFormasliquidacion(Formasliquidacion formasliquidacion) {
		 formasliquidacionRepository.deleteFormasliquidacion(formasliquidacion);
	}

	/**
	 * Consulta informacion de formasliquidacions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Formasliquidacion> listFormasliquidacionsPagination(Formasliquidacion formasliquidacion, int page, int size) {
		return formasliquidacionRepository.listFormasliquidacionsPagination(formasliquidacion, page, size);
	}

	/**
	 * Obtiene el numero de formasliquidacions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return formasliquidacionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de formasliquidacions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return formasliquidacionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de formasliquidacions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return formasliquidacionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los formasliquidacions y la pagina.
	 */
	public List<Formasliquidacion> listFormasliquidacionsQuery(Formasliquidacion formasliquidacion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return formasliquidacionRepository.listFormasliquidacionsQuery(formasliquidacion, query, page, size);
	}
}	
