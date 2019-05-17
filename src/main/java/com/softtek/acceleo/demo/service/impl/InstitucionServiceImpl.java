/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los institucions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.InstitucionRepository;
import com.softtek.acceleo.demo.domain.Institucion;
import com.softtek.acceleo.demo.service.InstitucionService;
/**
 * Clase InstitucionServiceImpl.
 * @author PSG.
 *
 */
@Service("institucionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InstitucionServiceImpl implements InstitucionService {

	@Autowired
	private InstitucionRepository institucionRepository;

	/**
	 * Agrega un institucion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addInstitucion(Institucion institucion) {
		institucionRepository.addInstitucion(institucion);
	}

	/**
	 * Edita un institucion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editInstitucion(Institucion institucion) {
		institucionRepository.editInstitucion(institucion);
	}
	
	/**
	 * Consulta informacion de institucions.
	 */
	public List<Institucion> listInstitucions(Institucion institucion) {
		return institucionRepository.listInstitucions(institucion);
	}

	/**
	 * Obtiene informacion de un institucion.
	 */
	public Institucion getInstitucion(int empid) {
		return institucionRepository.getInstitucion(empid);
	}

	/**
	 * Elimina un institucion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteInstitucion(Institucion institucion) {
		 institucionRepository.deleteInstitucion(institucion);
	}

	/**
	 * Consulta informacion de institucions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Institucion> listInstitucionsPagination(Institucion institucion, int page, int size) {
		return institucionRepository.listInstitucionsPagination(institucion, page, size);
	}

	/**
	 * Obtiene el numero de institucions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return institucionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de institucions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return institucionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de institucions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return institucionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los institucions y la pagina.
	 */
	public List<Institucion> listInstitucionsQuery(Institucion institucion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return institucionRepository.listInstitucionsQuery(institucion, query, page, size);
	}
}	
