/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los autodeclaracioncrss. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.AutodeclaracioncrsRepository;
import com.softtek.acceleo.demo.domain.Autodeclaracioncrs;
import com.softtek.acceleo.demo.service.AutodeclaracioncrsService;
/**
 * Clase AutodeclaracioncrsServiceImpl.
 * @author PSG.
 *
 */
@Service("autodeclaracioncrsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AutodeclaracioncrsServiceImpl implements AutodeclaracioncrsService {

	@Autowired
	private AutodeclaracioncrsRepository autodeclaracioncrsRepository;

	/**
	 * Agrega un autodeclaracioncrs.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAutodeclaracioncrs(Autodeclaracioncrs autodeclaracioncrs) {
		autodeclaracioncrsRepository.addAutodeclaracioncrs(autodeclaracioncrs);
	}

	/**
	 * Edita un autodeclaracioncrs.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAutodeclaracioncrs(Autodeclaracioncrs autodeclaracioncrs) {
		autodeclaracioncrsRepository.editAutodeclaracioncrs(autodeclaracioncrs);
	}
	
	/**
	 * Consulta informacion de autodeclaracioncrss.
	 */
	public List<Autodeclaracioncrs> listAutodeclaracioncrss(Autodeclaracioncrs autodeclaracioncrs) {
		return autodeclaracioncrsRepository.listAutodeclaracioncrss(autodeclaracioncrs);
	}

	/**
	 * Obtiene informacion de un autodeclaracioncrs.
	 */
	public Autodeclaracioncrs getAutodeclaracioncrs(UUID empid) {
		return autodeclaracioncrsRepository.getAutodeclaracioncrs(empid);
	}

	/**
	 * Elimina un autodeclaracioncrs.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAutodeclaracioncrs(Autodeclaracioncrs autodeclaracioncrs) {
		 autodeclaracioncrsRepository.deleteAutodeclaracioncrs(autodeclaracioncrs);
	}

	/**
	 * Consulta informacion de autodeclaracioncrss y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Autodeclaracioncrs> listAutodeclaracioncrssPagination(Autodeclaracioncrs autodeclaracioncrs, int page, int size) {
		return autodeclaracioncrsRepository.listAutodeclaracioncrssPagination(autodeclaracioncrs, page, size);
	}

	/**
	 * Obtiene el numero de autodeclaracioncrss consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return autodeclaracioncrsRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de autodeclaracioncrss consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return autodeclaracioncrsRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de autodeclaracioncrss consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return autodeclaracioncrsRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los autodeclaracioncrss y la pagina.
	 */
	public List<Autodeclaracioncrs> listAutodeclaracioncrssQuery(Autodeclaracioncrs autodeclaracioncrs, String query, int page, int size) {
		// TODO Auto-generated method stub
		return autodeclaracioncrsRepository.listAutodeclaracioncrssQuery(autodeclaracioncrs, query, page, size);
	}
}	
