/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los transaccions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.TransaccionRepository;
import com.softtek.acceleo.demo.domain.Transaccion;
import com.softtek.acceleo.demo.service.TransaccionService;
/**
 * Clase TransaccionServiceImpl.
 * @author PSG.
 *
 */
@Service("transaccionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TransaccionServiceImpl implements TransaccionService {

	@Autowired
	private TransaccionRepository transaccionRepository;

	/**
	 * Agrega un transaccion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTransaccion(Transaccion transaccion) {
		transaccionRepository.addTransaccion(transaccion);
	}

	/**
	 * Edita un transaccion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editTransaccion(Transaccion transaccion) {
		transaccionRepository.editTransaccion(transaccion);
	}
	
	/**
	 * Consulta informacion de transaccions.
	 */
	public List<Transaccion> listTransaccions(Transaccion transaccion) {
		return transaccionRepository.listTransaccions(transaccion);
	}

	/**
	 * Obtiene informacion de un transaccion.
	 */
	public Transaccion getTransaccion(UUID empid) {
		return transaccionRepository.getTransaccion(empid);
	}

	/**
	 * Elimina un transaccion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteTransaccion(Transaccion transaccion) {
		 transaccionRepository.deleteTransaccion(transaccion);
	}

	/**
	 * Consulta informacion de transaccions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Transaccion> listTransaccionsPagination(Transaccion transaccion, int page, int size) {
		return transaccionRepository.listTransaccionsPagination(transaccion, page, size);
	}

	/**
	 * Obtiene el numero de transaccions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return transaccionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de transaccions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return transaccionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de transaccions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return transaccionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los transaccions y la pagina.
	 */
	public List<Transaccion> listTransaccionsQuery(Transaccion transaccion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return transaccionRepository.listTransaccionsQuery(transaccion, query, page, size);
	}
}	
