/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los movimientos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.MovimientoRepository;
import com.softtek.acceleo.demo.domain.Movimiento;
import com.softtek.acceleo.demo.service.MovimientoService;
/**
 * Clase MovimientoServiceImpl.
 * @author PSG.
 *
 */
@Service("movimientoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MovimientoServiceImpl implements MovimientoService {

	@Autowired
	private MovimientoRepository movimientoRepository;

	/**
	 * Agrega un movimiento.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addMovimiento(Movimiento movimiento) {
		movimientoRepository.addMovimiento(movimiento);
	}

	/**
	 * Edita un movimiento.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editMovimiento(Movimiento movimiento) {
		movimientoRepository.editMovimiento(movimiento);
	}
	
	/**
	 * Consulta informacion de movimientos.
	 */
	public List<Movimiento> listMovimientos(Movimiento movimiento) {
		return movimientoRepository.listMovimientos(movimiento);
	}

	/**
	 * Obtiene informacion de un movimiento.
	 */
	public Movimiento getMovimiento(UUID empid) {
		return movimientoRepository.getMovimiento(empid);
	}

	/**
	 * Elimina un movimiento.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteMovimiento(Movimiento movimiento) {
		 movimientoRepository.deleteMovimiento(movimiento);
	}

	/**
	 * Consulta informacion de movimientos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Movimiento> listMovimientosPagination(Movimiento movimiento, int page, int size) {
		return movimientoRepository.listMovimientosPagination(movimiento, page, size);
	}

	/**
	 * Obtiene el numero de movimientos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return movimientoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de movimientos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return movimientoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de movimientos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return movimientoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los movimientos y la pagina.
	 */
	public List<Movimiento> listMovimientosQuery(Movimiento movimiento, String query, int page, int size) {
		// TODO Auto-generated method stub
		return movimientoRepository.listMovimientosQuery(movimiento, query, page, size);
	}
}	
