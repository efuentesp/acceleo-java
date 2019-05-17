/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los publicacions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.PublicacionRepository;
import com.softtek.acceleo.demo.domain.Publicacion;
import com.softtek.acceleo.demo.service.PublicacionService;
/**
 * Clase PublicacionServiceImpl.
 * @author PSG.
 *
 */
@Service("publicacionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PublicacionServiceImpl implements PublicacionService {

	@Autowired
	private PublicacionRepository publicacionRepository;

	/**
	 * Agrega un publicacion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPublicacion(Publicacion publicacion) {
		publicacionRepository.addPublicacion(publicacion);
	}

	/**
	 * Edita un publicacion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editPublicacion(Publicacion publicacion) {
		publicacionRepository.editPublicacion(publicacion);
	}
	
	/**
	 * Consulta informacion de publicacions.
	 */
	public List<Publicacion> listPublicacions(Publicacion publicacion) {
		return publicacionRepository.listPublicacions(publicacion);
	}

	/**
	 * Obtiene informacion de un publicacion.
	 */
	public Publicacion getPublicacion(int empid) {
		return publicacionRepository.getPublicacion(empid);
	}

	/**
	 * Elimina un publicacion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePublicacion(Publicacion publicacion) {
		 publicacionRepository.deletePublicacion(publicacion);
	}

	/**
	 * Consulta informacion de publicacions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Publicacion> listPublicacionsPagination(Publicacion publicacion, int page, int size) {
		return publicacionRepository.listPublicacionsPagination(publicacion, page, size);
	}

	/**
	 * Obtiene el numero de publicacions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return publicacionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de publicacions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return publicacionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de publicacions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return publicacionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los publicacions y la pagina.
	 */
	public List<Publicacion> listPublicacionsQuery(Publicacion publicacion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return publicacionRepository.listPublicacionsQuery(publicacion, query, page, size);
	}
}	
