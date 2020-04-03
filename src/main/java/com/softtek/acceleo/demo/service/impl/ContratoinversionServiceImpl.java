/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los contratoinversions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ContratoinversionRepository;
import com.softtek.acceleo.demo.domain.Contratoinversion;
import com.softtek.acceleo.demo.service.ContratoinversionService;
/**
 * Clase ContratoinversionServiceImpl.
 * @author PSG.
 *
 */
@Service("contratoinversionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ContratoinversionServiceImpl implements ContratoinversionService {

	@Autowired
	private ContratoinversionRepository contratoinversionRepository;

	/**
	 * Agrega un contratoinversion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addContratoinversion(Contratoinversion contratoinversion) {
		contratoinversionRepository.addContratoinversion(contratoinversion);
	}

	/**
	 * Edita un contratoinversion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editContratoinversion(Contratoinversion contratoinversion) {
		contratoinversionRepository.editContratoinversion(contratoinversion);
	}
	
	/**
	 * Consulta informacion de contratoinversions.
	 */
	public List<Contratoinversion> listContratoinversions(Contratoinversion contratoinversion) {
		return contratoinversionRepository.listContratoinversions(contratoinversion);
	}

	/**
	 * Obtiene informacion de un contratoinversion.
	 */
	public Contratoinversion getContratoinversion(UUID empid) {
		return contratoinversionRepository.getContratoinversion(empid);
	}

	/**
	 * Elimina un contratoinversion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteContratoinversion(Contratoinversion contratoinversion) {
		 contratoinversionRepository.deleteContratoinversion(contratoinversion);
	}

	/**
	 * Consulta informacion de contratoinversions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Contratoinversion> listContratoinversionsPagination(Contratoinversion contratoinversion, int page, int size) {
		return contratoinversionRepository.listContratoinversionsPagination(contratoinversion, page, size);
	}

	/**
	 * Obtiene el numero de contratoinversions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return contratoinversionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de contratoinversions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return contratoinversionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de contratoinversions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return contratoinversionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los contratoinversions y la pagina.
	 */
	public List<Contratoinversion> listContratoinversionsQuery(Contratoinversion contratoinversion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return contratoinversionRepository.listContratoinversionsQuery(contratoinversion, query, page, size);
	}
}	
