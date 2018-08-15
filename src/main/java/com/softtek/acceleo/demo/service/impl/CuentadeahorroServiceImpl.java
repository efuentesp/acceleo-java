
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los cuentadeahorros. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.CuentadeahorroRepository;
import com.softtek.acceleo.demo.domain.Cuentadeahorro;
import com.softtek.acceleo.demo.service.CuentadeahorroService;
/**
 * Clase CuentadeahorroServiceImpl.
 * @author PSG.
 *
 */
@Service("cuentadeahorroService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CuentadeahorroServiceImpl implements CuentadeahorroService {

	@Autowired
	private CuentadeahorroRepository cuentadeahorroRepository;

	/**
	 * Agrega un cuentadeahorro.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCuentadeahorro(Cuentadeahorro cuentadeahorro) {
		
		cuentadeahorroRepository.addCuentadeahorro(cuentadeahorro);
	}

	/**
	 * Edita un cuentadeahorro.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editCuentadeahorro(Cuentadeahorro cuentadeahorro) {
		
		cuentadeahorroRepository.editCuentadeahorro(cuentadeahorro);
	}
	
	/**
	 * Consulta informacion de cuentadeahorros.
	 */
	public List<Cuentadeahorro> listCuentadeahorros(Cuentadeahorro cuentadeahorro) {

		return cuentadeahorroRepository.listCuentadeahorros(cuentadeahorro);
	}

	/**
	 * Obtiene informacion de un cuentadeahorro.
	 */
	public Cuentadeahorro getCuentadeahorro(int empid) {

		return cuentadeahorroRepository.getCuentadeahorro(empid);
	}

	/**
	 * Elimina un cuentadeahorro.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCuentadeahorro(Cuentadeahorro cuentadeahorro) {
		System.out.println("Entrando al deleteCuentadeahorro");

		 cuentadeahorroRepository.deleteCuentadeahorro(cuentadeahorro);
	}

	/**
	 * Consulta informacion de cuentadeahorros y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Cuentadeahorro> listCuentadeahorrosPagination(Cuentadeahorro cuentadeahorro, int page, int size) {

		return cuentadeahorroRepository.listCuentadeahorrosPagination(cuentadeahorro, page, size);
	}

	/**
	 * Obtiene el numero de cuentadeahorros consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return cuentadeahorroRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de cuentadeahorros consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return cuentadeahorroRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de cuentadeahorros consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return cuentadeahorroRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los cuentadeahorros y la pagina.
	 */
	public List<Cuentadeahorro> listCuentadeahorrosQuery(Cuentadeahorro cuentadeahorro, String query, int page, int size) {
		// TODO Auto-generated method stub
		return cuentadeahorroRepository.listCuentadeahorrosQuery(cuentadeahorro, query, page, size);
	}

}

