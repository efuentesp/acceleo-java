/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los retiros. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.RetiroRepository;
import com.softtek.acceleo.demo.domain.Retiro;
import com.softtek.acceleo.demo.service.RetiroService;
/**
 * Clase RetiroServiceImpl.
 * @author PSG.
 *
 */
@Service("retiroService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RetiroServiceImpl implements RetiroService {

	@Autowired
	private RetiroRepository retiroRepository;

	/**
	 * Agrega un retiro.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addRetiro(Retiro retiro) {
		retiroRepository.addRetiro(retiro);
	}

	/**
	 * Edita un retiro.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editRetiro(Retiro retiro) {
		retiroRepository.editRetiro(retiro);
	}
	
	/**
	 * Consulta informacion de retiros.
	 */
	public List<Retiro> listRetiros(Retiro retiro) {
		return retiroRepository.listRetiros(retiro);
	}

	/**
	 * Obtiene informacion de un retiro.
	 */
	public Retiro getRetiro(UUID empid) {
		return retiroRepository.getRetiro(empid);
	}

	/**
	 * Elimina un retiro.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteRetiro(Retiro retiro) {
		 retiroRepository.deleteRetiro(retiro);
	}

	/**
	 * Consulta informacion de retiros y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Retiro> listRetirosPagination(Retiro retiro, int page, int size) {
		return retiroRepository.listRetirosPagination(retiro, page, size);
	}

	/**
	 * Obtiene el numero de retiros consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return retiroRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de retiros consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return retiroRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de retiros consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return retiroRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los retiros y la pagina.
	 */
	public List<Retiro> listRetirosQuery(Retiro retiro, String query, int page, int size) {
		// TODO Auto-generated method stub
		return retiroRepository.listRetirosQuery(retiro, query, page, size);
	}
}	
