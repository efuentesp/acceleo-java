/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los permisos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.PermisoRepository;
import com.softtek.acceleo.demo.domain.Permiso;
import com.softtek.acceleo.demo.service.PermisoService;
/**
 * Clase PermisoServiceImpl.
 * @author PSG.
 *
 */
@Service("permisoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PermisoServiceImpl implements PermisoService {

	@Autowired
	private PermisoRepository permisoRepository;

	/**
	 * Agrega un permiso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPermiso(Permiso permiso) {
		permisoRepository.addPermiso(permiso);
	}

	/**
	 * Edita un permiso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editPermiso(Permiso permiso) {
		permisoRepository.editPermiso(permiso);
	}
	
	/**
	 * Consulta informacion de permisos.
	 */
	public List<Permiso> listPermisos(Permiso permiso) {
		return permisoRepository.listPermisos(permiso);
	}

	/**
	 * Obtiene informacion de un permiso.
	 */
	public Permiso getPermiso(UUID empid) {
		return permisoRepository.getPermiso(empid);
	}

	/**
	 * Elimina un permiso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePermiso(Permiso permiso) {
		 permisoRepository.deletePermiso(permiso);
	}

	/**
	 * Consulta informacion de permisos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Permiso> listPermisosPagination(Permiso permiso, int page, int size) {
		return permisoRepository.listPermisosPagination(permiso, page, size);
	}

	/**
	 * Obtiene el numero de permisos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return permisoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de permisos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return permisoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de permisos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return permisoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los permisos y la pagina.
	 */
	public List<Permiso> listPermisosQuery(Permiso permiso, String query, int page, int size) {
		// TODO Auto-generated method stub
		return permisoRepository.listPermisosQuery(permiso, query, page, size);
	}
}	
