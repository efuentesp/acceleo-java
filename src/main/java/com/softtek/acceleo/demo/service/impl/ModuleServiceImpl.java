
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los modules. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ModuleRepository;
import com.softtek.acceleo.demo.domain.Module;
import com.softtek.acceleo.demo.service.ModuleService;
/**
 * Clase ModuleServiceImpl.
 * @author PSG.
 *
 */
@Service("moduleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	/**
	 * Agrega un module.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addModule(Module module) {
		
		moduleRepository.addModule(module);
	}

	/**
	 * Edita un module.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editModule(Module module) {
		
		moduleRepository.editModule(module);
	}
	
	/**
	 * Consulta informacion de modules.
	 */
	public List<Module> listModules(Module module) {

		return moduleRepository.listModules(module);
	}

	/**
	 * Obtiene informacion de un module.
	 */
	public Module getModule(int empid) {

		return moduleRepository.getModule(empid);
	}

	/**
	 * Elimina un module.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteModule(Module module) {
		System.out.println("Entrando al deleteModule");

		 moduleRepository.deleteModule(module);
	}

	/**
	 * Consulta informacion de modules y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Module> listModulesPagination(Module module, int page, int size) {

		return moduleRepository.listModulesPagination(module, page, size);
	}

	/**
	 * Obtiene el numero de modules consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return moduleRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de modules consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return moduleRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de modules consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return moduleRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los modules y la pagina.
	 */
	public List<Module> listModulesQuery(Module module, String query, int page, int size) {
		// TODO Auto-generated method stub
		return moduleRepository.listModulesQuery(module, query, page, size);
	}

}

