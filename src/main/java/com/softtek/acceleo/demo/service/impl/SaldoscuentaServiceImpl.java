/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los saldoscuentas. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.SaldoscuentaRepository;
import com.softtek.acceleo.demo.domain.Saldoscuenta;
import com.softtek.acceleo.demo.service.SaldoscuentaService;
/**
 * Clase SaldoscuentaServiceImpl.
 * @author PSG.
 *
 */
@Service("saldoscuentaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SaldoscuentaServiceImpl implements SaldoscuentaService {

	@Autowired
	private SaldoscuentaRepository saldoscuentaRepository;

	/**
	 * Agrega un saldoscuenta.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSaldoscuenta(Saldoscuenta saldoscuenta) {
		saldoscuentaRepository.addSaldoscuenta(saldoscuenta);
	}

	/**
	 * Edita un saldoscuenta.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editSaldoscuenta(Saldoscuenta saldoscuenta) {
		saldoscuentaRepository.editSaldoscuenta(saldoscuenta);
	}
	
	/**
	 * Consulta informacion de saldoscuentas.
	 */
	public List<Saldoscuenta> listSaldoscuentas(Saldoscuenta saldoscuenta) {
		return saldoscuentaRepository.listSaldoscuentas(saldoscuenta);
	}

	/**
	 * Obtiene informacion de un saldoscuenta.
	 */
	public Saldoscuenta getSaldoscuenta(UUID empid) {
		return saldoscuentaRepository.getSaldoscuenta(empid);
	}

	/**
	 * Elimina un saldoscuenta.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteSaldoscuenta(Saldoscuenta saldoscuenta) {
		 saldoscuentaRepository.deleteSaldoscuenta(saldoscuenta);
	}

	/**
	 * Consulta informacion de saldoscuentas y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Saldoscuenta> listSaldoscuentasPagination(Saldoscuenta saldoscuenta, int page, int size) {
		return saldoscuentaRepository.listSaldoscuentasPagination(saldoscuenta, page, size);
	}

	/**
	 * Obtiene el numero de saldoscuentas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return saldoscuentaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de saldoscuentas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return saldoscuentaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de saldoscuentas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return saldoscuentaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los saldoscuentas y la pagina.
	 */
	public List<Saldoscuenta> listSaldoscuentasQuery(Saldoscuenta saldoscuenta, String query, int page, int size) {
		// TODO Auto-generated method stub
		return saldoscuentaRepository.listSaldoscuentasQuery(saldoscuenta, query, page, size);
	}
}	
