/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los subfisos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.SubfisoRepository;
import com.softtek.acceleo.demo.domain.Subfiso;
import com.softtek.acceleo.demo.service.SubfisoService;
/**
 * Clase SubfisoServiceImpl.
 * @author PSG.
 *
 */
@Service("subfisoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SubfisoServiceImpl implements SubfisoService {

	@Autowired
	private SubfisoRepository subfisoRepository;

	/**
	 * Agrega un subfiso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSubfiso(Subfiso subfiso) {
		subfisoRepository.addSubfiso(subfiso);
	}

	/**
	 * Edita un subfiso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editSubfiso(Subfiso subfiso) {
		subfisoRepository.editSubfiso(subfiso);
	}
	
	/**
	 * Consulta informacion de subfisos.
	 */
	public List<Subfiso> listSubfisos(Subfiso subfiso) {
		return subfisoRepository.listSubfisos(subfiso);
	}

	/**
	 * Obtiene informacion de un subfiso.
	 */
	public Subfiso getSubfiso(UUID empid) {
		return subfisoRepository.getSubfiso(empid);
	}

	/**
	 * Elimina un subfiso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteSubfiso(Subfiso subfiso) {
		 subfisoRepository.deleteSubfiso(subfiso);
	}

	/**
	 * Consulta informacion de subfisos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Subfiso> listSubfisosPagination(Subfiso subfiso, int page, int size) {
		return subfisoRepository.listSubfisosPagination(subfiso, page, size);
	}

	/**
	 * Obtiene el numero de subfisos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return subfisoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de subfisos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return subfisoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de subfisos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return subfisoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los subfisos y la pagina.
	 */
	public List<Subfiso> listSubfisosQuery(Subfiso subfiso, String query, int page, int size) {
		// TODO Auto-generated method stub
		return subfisoRepository.listSubfisosQuery(subfiso, query, page, size);
	}
}	
