/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los aportacioninmuebles. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.AportacioninmuebleRepository;
import com.softtek.acceleo.demo.domain.Aportacioninmueble;
import com.softtek.acceleo.demo.service.AportacioninmuebleService;
/**
 * Clase AportacioninmuebleServiceImpl.
 * @author PSG.
 *
 */
@Service("aportacioninmuebleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AportacioninmuebleServiceImpl implements AportacioninmuebleService {

	@Autowired
	private AportacioninmuebleRepository aportacioninmuebleRepository;

	/**
	 * Agrega un aportacioninmueble.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAportacioninmueble(Aportacioninmueble aportacioninmueble) {
		aportacioninmuebleRepository.addAportacioninmueble(aportacioninmueble);
	}

	/**
	 * Edita un aportacioninmueble.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAportacioninmueble(Aportacioninmueble aportacioninmueble) {
		aportacioninmuebleRepository.editAportacioninmueble(aportacioninmueble);
	}
	
	/**
	 * Consulta informacion de aportacioninmuebles.
	 */
	public List<Aportacioninmueble> listAportacioninmuebles(Aportacioninmueble aportacioninmueble) {
		return aportacioninmuebleRepository.listAportacioninmuebles(aportacioninmueble);
	}

	/**
	 * Obtiene informacion de un aportacioninmueble.
	 */
	public Aportacioninmueble getAportacioninmueble(UUID empid) {
		return aportacioninmuebleRepository.getAportacioninmueble(empid);
	}

	/**
	 * Elimina un aportacioninmueble.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAportacioninmueble(Aportacioninmueble aportacioninmueble) {
		 aportacioninmuebleRepository.deleteAportacioninmueble(aportacioninmueble);
	}

	/**
	 * Consulta informacion de aportacioninmuebles y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Aportacioninmueble> listAportacioninmueblesPagination(Aportacioninmueble aportacioninmueble, int page, int size) {
		return aportacioninmuebleRepository.listAportacioninmueblesPagination(aportacioninmueble, page, size);
	}

	/**
	 * Obtiene el numero de aportacioninmuebles consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return aportacioninmuebleRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de aportacioninmuebles consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return aportacioninmuebleRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de aportacioninmuebles consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return aportacioninmuebleRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los aportacioninmuebles y la pagina.
	 */
	public List<Aportacioninmueble> listAportacioninmueblesQuery(Aportacioninmueble aportacioninmueble, String query, int page, int size) {
		// TODO Auto-generated method stub
		return aportacioninmuebleRepository.listAportacioninmueblesQuery(aportacioninmueble, query, page, size);
	}
}	
