/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los registros. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.RegistroRepository;
import com.softtek.acceleo.demo.domain.Registro;
import com.softtek.acceleo.demo.service.RegistroService;
/**
 * Clase RegistroServiceImpl.
 * @author PSG.
 *
 */
@Service("registroService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RegistroServiceImpl implements RegistroService {

	@Autowired
	private RegistroRepository registroRepository;

	/**
	 * Agrega un registro.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addRegistro(Registro registro) {
		registroRepository.addRegistro(registro);
	}

	/**
	 * Edita un registro.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editRegistro(Registro registro) {
		registroRepository.editRegistro(registro);
	}
	
	/**
	 * Consulta informacion de registros.
	 */
	public List<Registro> listRegistros(Registro registro) {
		return registroRepository.listRegistros(registro);
	}

	/**
	 * Obtiene informacion de un registro.
	 */
	public Registro getRegistro(int empid) {
		return registroRepository.getRegistro(empid);
	}

	/**
	 * Elimina un registro.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteRegistro(Registro registro) {
		 registroRepository.deleteRegistro(registro);
	}

	/**
	 * Consulta informacion de registros y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Registro> listRegistrosPagination(Registro registro, int page, int size) {
		return registroRepository.listRegistrosPagination(registro, page, size);
	}

	/**
	 * Obtiene el numero de registros consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return registroRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de registros consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return registroRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de registros consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return registroRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los registros y la pagina.
	 */
	public List<Registro> listRegistrosQuery(Registro registro, String query, int page, int size) {
		// TODO Auto-generated method stub
		return registroRepository.listRegistrosQuery(registro, query, page, size);
	}
}	
