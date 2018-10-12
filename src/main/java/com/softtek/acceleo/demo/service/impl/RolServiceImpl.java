
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los rols. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.RolRepository;
import com.softtek.acceleo.demo.domain.Rol;
import com.softtek.acceleo.demo.service.RolService;
/**
 * Clase RolServiceImpl.
 * @author PSG.
 *
 */
@Service("rolService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;

	/**
	 * Agrega un rol.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addRol(Rol rol) {
		
		rolRepository.addRol(rol);
	}

	/**
	 * Edita un rol.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editRol(Rol rol) {
		
		rolRepository.editRol(rol);
	}
	
	/**
	 * Consulta informacion de rols.
	 */
	public List<Rol> listRols(Rol rol) {

		return rolRepository.listRols(rol);
	}

	/**
	 * Obtiene informacion de un rol.
	 */
	public Rol getRol(int empid) {

		return rolRepository.getRol(empid);
	}

	/**
	 * Elimina un rol.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteRol(Rol rol) {
		System.out.println("Entrando al deleteRol");

		 rolRepository.deleteRol(rol);
	}

	/**
	 * Consulta informacion de rols y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Rol> listRolsPagination(Rol rol, int page, int size) {

		return rolRepository.listRolsPagination(rol, page, size);
	}

	/**
	 * Obtiene el numero de rols consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return rolRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de rols consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return rolRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de rols consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return rolRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los rols y la pagina.
	 */
	public List<Rol> listRolsQuery(Rol rol, String query, int page, int size) {
		// TODO Auto-generated method stub
		return rolRepository.listRolsQuery(rol, query, page, size);
	}

}

