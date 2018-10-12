
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los empresas. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.EmpresaRepository;
import com.softtek.acceleo.demo.domain.Empresa;
import com.softtek.acceleo.demo.service.EmpresaService;
/**
 * Clase EmpresaServiceImpl.
 * @author PSG.
 *
 */
@Service("empresaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	/**
	 * Agrega un empresa.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmpresa(Empresa empresa) {
		
		empresaRepository.addEmpresa(empresa);
	}

	/**
	 * Edita un empresa.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editEmpresa(Empresa empresa) {
		
		empresaRepository.editEmpresa(empresa);
	}
	
	/**
	 * Consulta informacion de empresas.
	 */
	public List<Empresa> listEmpresas(Empresa empresa) {

		return empresaRepository.listEmpresas(empresa);
	}

	/**
	 * Obtiene informacion de un empresa.
	 */
	public Empresa getEmpresa(int empid) {

		return empresaRepository.getEmpresa(empid);
	}

	/**
	 * Elimina un empresa.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteEmpresa(Empresa empresa) {
		System.out.println("Entrando al deleteEmpresa");

		 empresaRepository.deleteEmpresa(empresa);
	}

	/**
	 * Consulta informacion de empresas y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Empresa> listEmpresasPagination(Empresa empresa, int page, int size) {

		return empresaRepository.listEmpresasPagination(empresa, page, size);
	}

	/**
	 * Obtiene el numero de empresas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return empresaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de empresas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return empresaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de empresas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return empresaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los empresas y la pagina.
	 */
	public List<Empresa> listEmpresasQuery(Empresa empresa, String query, int page, int size) {
		// TODO Auto-generated method stub
		return empresaRepository.listEmpresasQuery(empresa, query, page, size);
	}

}

