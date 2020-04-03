/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los instruccions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.InstruccionRepository;
import com.softtek.acceleo.demo.domain.Instruccion;
import com.softtek.acceleo.demo.service.InstruccionService;
/**
 * Clase InstruccionServiceImpl.
 * @author PSG.
 *
 */
@Service("instruccionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InstruccionServiceImpl implements InstruccionService {

	@Autowired
	private InstruccionRepository instruccionRepository;

	/**
	 * Agrega un instruccion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addInstruccion(Instruccion instruccion) {
		instruccionRepository.addInstruccion(instruccion);
	}

	/**
	 * Edita un instruccion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editInstruccion(Instruccion instruccion) {
		instruccionRepository.editInstruccion(instruccion);
	}
	
	/**
	 * Consulta informacion de instruccions.
	 */
	public List<Instruccion> listInstruccions(Instruccion instruccion) {
		return instruccionRepository.listInstruccions(instruccion);
	}

	/**
	 * Obtiene informacion de un instruccion.
	 */
	public Instruccion getInstruccion(UUID empid) {
		return instruccionRepository.getInstruccion(empid);
	}

	/**
	 * Elimina un instruccion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteInstruccion(Instruccion instruccion) {
		 instruccionRepository.deleteInstruccion(instruccion);
	}

	/**
	 * Consulta informacion de instruccions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Instruccion> listInstruccionsPagination(Instruccion instruccion, int page, int size) {
		return instruccionRepository.listInstruccionsPagination(instruccion, page, size);
	}

	/**
	 * Obtiene el numero de instruccions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return instruccionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de instruccions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return instruccionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de instruccions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return instruccionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los instruccions y la pagina.
	 */
	public List<Instruccion> listInstruccionsQuery(Instruccion instruccion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return instruccionRepository.listInstruccionsQuery(instruccion, query, page, size);
	}
}	
