
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los cuentabancarias. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.CuentabancariaRepository;
import com.softtek.acceleo.demo.domain.Cuentabancaria;
import com.softtek.acceleo.demo.service.CuentabancariaService;
/**
 * Clase CuentabancariaServiceImpl.
 * @author PSG.
 *
 */
@Service("cuentabancariaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CuentabancariaServiceImpl implements CuentabancariaService {

	@Autowired
	private CuentabancariaRepository cuentabancariaRepository;

	/**
	 * Agrega un cuentabancaria.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCuentabancaria(Cuentabancaria cuentabancaria) {
		
		cuentabancariaRepository.addCuentabancaria(cuentabancaria);
	}

	/**
	 * Edita un cuentabancaria.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editCuentabancaria(Cuentabancaria cuentabancaria) {
		
		cuentabancariaRepository.editCuentabancaria(cuentabancaria);
	}
	
	/**
	 * Consulta informacion de cuentabancarias.
	 */
	public List<Cuentabancaria> listCuentabancarias(Cuentabancaria cuentabancaria) {

		return cuentabancariaRepository.listCuentabancarias(cuentabancaria);
	}

	/**
	 * Obtiene informacion de un cuentabancaria.
	 */
	public Cuentabancaria getCuentabancaria(int empid) {

		return cuentabancariaRepository.getCuentabancaria(empid);
	}

	/**
	 * Elimina un cuentabancaria.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCuentabancaria(Cuentabancaria cuentabancaria) {
		System.out.println("Entrando al deleteCuentabancaria");

		 cuentabancariaRepository.deleteCuentabancaria(cuentabancaria);
	}

	/**
	 * Consulta informacion de cuentabancarias y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Cuentabancaria> listCuentabancariasPagination(Cuentabancaria cuentabancaria, int page, int size) {

		return cuentabancariaRepository.listCuentabancariasPagination(cuentabancaria, page, size);
	}

	/**
	 * Obtiene el numero de cuentabancarias consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return cuentabancariaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de cuentabancarias consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return cuentabancariaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de cuentabancarias consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return cuentabancariaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los cuentabancarias y la pagina.
	 */
	public List<Cuentabancaria> listCuentabancariasQuery(Cuentabancaria cuentabancaria, String query, int page, int size) {
		// TODO Auto-generated method stub
		return cuentabancariaRepository.listCuentabancariasQuery(cuentabancaria, query, page, size);
	}

}

