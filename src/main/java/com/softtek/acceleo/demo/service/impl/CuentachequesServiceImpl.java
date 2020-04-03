/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los cuentachequess. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.CuentachequesRepository;
import com.softtek.acceleo.demo.domain.Cuentacheques;
import com.softtek.acceleo.demo.service.CuentachequesService;
/**
 * Clase CuentachequesServiceImpl.
 * @author PSG.
 *
 */
@Service("cuentachequesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CuentachequesServiceImpl implements CuentachequesService {

	@Autowired
	private CuentachequesRepository cuentachequesRepository;

	/**
	 * Agrega un cuentacheques.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCuentacheques(Cuentacheques cuentacheques) {
		cuentachequesRepository.addCuentacheques(cuentacheques);
	}

	/**
	 * Edita un cuentacheques.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editCuentacheques(Cuentacheques cuentacheques) {
		cuentachequesRepository.editCuentacheques(cuentacheques);
	}
	
	/**
	 * Consulta informacion de cuentachequess.
	 */
	public List<Cuentacheques> listCuentachequess(Cuentacheques cuentacheques) {
		return cuentachequesRepository.listCuentachequess(cuentacheques);
	}

	/**
	 * Obtiene informacion de un cuentacheques.
	 */
	public Cuentacheques getCuentacheques(UUID empid) {
		return cuentachequesRepository.getCuentacheques(empid);
	}

	/**
	 * Elimina un cuentacheques.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCuentacheques(Cuentacheques cuentacheques) {
		 cuentachequesRepository.deleteCuentacheques(cuentacheques);
	}

	/**
	 * Consulta informacion de cuentachequess y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Cuentacheques> listCuentachequessPagination(Cuentacheques cuentacheques, int page, int size) {
		return cuentachequesRepository.listCuentachequessPagination(cuentacheques, page, size);
	}

	/**
	 * Obtiene el numero de cuentachequess consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return cuentachequesRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de cuentachequess consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return cuentachequesRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de cuentachequess consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return cuentachequesRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los cuentachequess y la pagina.
	 */
	public List<Cuentacheques> listCuentachequessQuery(Cuentacheques cuentacheques, String query, int page, int size) {
		// TODO Auto-generated method stub
		return cuentachequesRepository.listCuentachequessQuery(cuentacheques, query, page, size);
	}
}	
