
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los socios. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.SocioRepository;
import com.softtek.acceleo.demo.domain.Socio;
import com.softtek.acceleo.demo.service.SocioService;
/**
 * Clase SocioServiceImpl.
 * @author PSG.
 *
 */
@Service("socioService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SocioServiceImpl implements SocioService {

	@Autowired
	private SocioRepository socioRepository;

	/**
	 * Agrega un socio.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSocio(Socio socio) {
		
		socioRepository.addSocio(socio);
	}

	/**
	 * Edita un socio.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editSocio(Socio socio) {
		
		socioRepository.editSocio(socio);
	}
	
	/**
	 * Consulta informacion de socios.
	 */
	public List<Socio> listSocios(Socio socio) {

		return socioRepository.listSocios(socio);
	}

	/**
	 * Obtiene informacion de un socio.
	 */
	public Socio getSocio(int empid) {

		return socioRepository.getSocio(empid);
	}

	/**
	 * Elimina un socio.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteSocio(Socio socio) {
		System.out.println("Entrando al deleteSocio");

		 socioRepository.deleteSocio(socio);
	}

	/**
	 * Consulta informacion de socios y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Socio> listSociosPagination(Socio socio, int page, int size) {

		return socioRepository.listSociosPagination(socio, page, size);
	}

	/**
	 * Obtiene el numero de socios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return socioRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de socios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return socioRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de socios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return socioRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los socios y la pagina.
	 */
	public List<Socio> listSociosQuery(Socio socio, String query, int page, int size) {
		// TODO Auto-generated method stub
		return socioRepository.listSociosQuery(socio, query, page, size);
	}

}

