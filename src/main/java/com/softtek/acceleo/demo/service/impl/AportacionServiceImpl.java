
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los aportacions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.AportacionRepository;
import com.softtek.acceleo.demo.domain.Aportacion;
import com.softtek.acceleo.demo.service.AportacionService;
/**
 * Clase AportacionServiceImpl.
 * @author PSG.
 *
 */
@Service("aportacionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AportacionServiceImpl implements AportacionService {

	@Autowired
	private AportacionRepository aportacionRepository;

	/**
	 * Agrega un aportacion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAportacion(Aportacion aportacion) {
		
		aportacionRepository.addAportacion(aportacion);
	}

	/**
	 * Edita un aportacion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAportacion(Aportacion aportacion) {
		
		aportacionRepository.editAportacion(aportacion);
	}
	
	/**
	 * Consulta informacion de aportacions.
	 */
	public List<Aportacion> listAportacions(Aportacion aportacion) {

		return aportacionRepository.listAportacions(aportacion);
	}

	/**
	 * Obtiene informacion de un aportacion.
	 */
	public Aportacion getAportacion(int empid) {

		return aportacionRepository.getAportacion(empid);
	}

	/**
	 * Elimina un aportacion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAportacion(Aportacion aportacion) {
		System.out.println("Entrando al deleteAportacion");

		 aportacionRepository.deleteAportacion(aportacion);
	}

	/**
	 * Consulta informacion de aportacions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Aportacion> listAportacionsPagination(Aportacion aportacion, int page, int size) {

		return aportacionRepository.listAportacionsPagination(aportacion, page, size);
	}

	/**
	 * Obtiene el numero de aportacions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return aportacionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de aportacions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return aportacionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de aportacions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return aportacionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los aportacions y la pagina.
	 */
	public List<Aportacion> listAportacionsQuery(Aportacion aportacion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return aportacionRepository.listAportacionsQuery(aportacion, query, page, size);
	}

}

