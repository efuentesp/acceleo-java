
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los perfils. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.PerfilRepository;
import com.softtek.acceleo.demo.domain.Perfil;
import com.softtek.acceleo.demo.service.PerfilService;
/**
 * Clase PerfilServiceImpl.
 * @author PSG.
 *
 */
@Service("perfilService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	/**
	 * Agrega un perfil.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPerfil(Perfil perfil) {
		
		perfilRepository.addPerfil(perfil);
	}

	/**
	 * Edita un perfil.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editPerfil(Perfil perfil) {
		
		perfilRepository.editPerfil(perfil);
	}
	
	/**
	 * Consulta informacion de perfils.
	 */
	public List<Perfil> listPerfils(Perfil perfil) {

		return perfilRepository.listPerfils(perfil);
	}

	/**
	 * Obtiene informacion de un perfil.
	 */
	public Perfil getPerfil(int empid) {

		return perfilRepository.getPerfil(empid);
	}

	/**
	 * Elimina un perfil.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePerfil(Perfil perfil) {
		System.out.println("Entrando al deletePerfil");

		 perfilRepository.deletePerfil(perfil);
	}

	/**
	 * Consulta informacion de perfils y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Perfil> listPerfilsPagination(Perfil perfil, int page, int size) {

		return perfilRepository.listPerfilsPagination(perfil, page, size);
	}

	/**
	 * Obtiene el numero de perfils consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return perfilRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de perfils consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return perfilRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de perfils consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return perfilRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los perfils y la pagina.
	 */
	public List<Perfil> listPerfilsQuery(Perfil perfil, String query, int page, int size) {
		// TODO Auto-generated method stub
		return perfilRepository.listPerfilsQuery(perfil, query, page, size);
	}

}

