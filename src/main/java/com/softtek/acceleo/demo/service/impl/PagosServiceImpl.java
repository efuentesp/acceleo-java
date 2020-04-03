/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los pagoss. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.PagosRepository;
import com.softtek.acceleo.demo.domain.Pagos;
import com.softtek.acceleo.demo.service.PagosService;
/**
 * Clase PagosServiceImpl.
 * @author PSG.
 *
 */
@Service("pagosService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PagosServiceImpl implements PagosService {

	@Autowired
	private PagosRepository pagosRepository;

	/**
	 * Agrega un pagos.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPagos(Pagos pagos) {
		pagosRepository.addPagos(pagos);
	}

	/**
	 * Edita un pagos.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editPagos(Pagos pagos) {
		pagosRepository.editPagos(pagos);
	}
	
	/**
	 * Consulta informacion de pagoss.
	 */
	public List<Pagos> listPagoss(Pagos pagos) {
		return pagosRepository.listPagoss(pagos);
	}

	/**
	 * Obtiene informacion de un pagos.
	 */
	public Pagos getPagos(UUID empid) {
		return pagosRepository.getPagos(empid);
	}

	/**
	 * Elimina un pagos.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePagos(Pagos pagos) {
		 pagosRepository.deletePagos(pagos);
	}

	/**
	 * Consulta informacion de pagoss y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Pagos> listPagossPagination(Pagos pagos, int page, int size) {
		return pagosRepository.listPagossPagination(pagos, page, size);
	}

	/**
	 * Obtiene el numero de pagoss consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return pagosRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de pagoss consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return pagosRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de pagoss consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return pagosRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los pagoss y la pagina.
	 */
	public List<Pagos> listPagossQuery(Pagos pagos, String query, int page, int size) {
		// TODO Auto-generated method stub
		return pagosRepository.listPagossQuery(pagos, query, page, size);
	}
}	
