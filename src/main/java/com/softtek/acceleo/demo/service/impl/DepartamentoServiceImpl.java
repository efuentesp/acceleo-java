
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los departamentos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.DepartamentoRepository;
import com.softtek.acceleo.demo.domain.Departamento;
import com.softtek.acceleo.demo.service.DepartamentoService;
/**
 * Clase DepartamentoServiceImpl.
 * @author PSG.
 *
 */
@Service("departamentoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	/**
	 * Agrega un departamento.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDepartamento(Departamento departamento) {
		
		departamentoRepository.addDepartamento(departamento);
	}

	/**
	 * Edita un departamento.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editDepartamento(Departamento departamento) {
		
		departamentoRepository.editDepartamento(departamento);
	}
	
	/**
	 * Consulta informacion de departamentos.
	 */
	public List<Departamento> listDepartamentos(Departamento departamento) {

		return departamentoRepository.listDepartamentos(departamento);
	}

	/**
	 * Obtiene informacion de un departamento.
	 */
	public Departamento getDepartamento(int empid) {

		return departamentoRepository.getDepartamento(empid);
	}

	/**
	 * Elimina un departamento.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteDepartamento(Departamento departamento) {
		System.out.println("Entrando al deleteDepartamento");

		 departamentoRepository.deleteDepartamento(departamento);
	}

	/**
	 * Consulta informacion de departamentos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Departamento> listDepartamentosPagination(Departamento departamento, int page, int size) {

		return departamentoRepository.listDepartamentosPagination(departamento, page, size);
	}

	/**
	 * Obtiene el numero de departamentos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return departamentoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de departamentos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return departamentoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de departamentos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return departamentoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los departamentos y la pagina.
	 */
	public List<Departamento> listDepartamentosQuery(Departamento departamento, String query, int page, int size) {
		// TODO Auto-generated method stub
		return departamentoRepository.listDepartamentosQuery(departamento, query, page, size);
	}

}

