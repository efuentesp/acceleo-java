/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los carteraadeudos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.CarteraadeudoRepository;
import com.softtek.acceleo.demo.domain.Carteraadeudo;
import com.softtek.acceleo.demo.service.CarteraadeudoService;
/**
 * Clase CarteraadeudoServiceImpl.
 * @author PSG.
 *
 */
@Service("carteraadeudoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CarteraadeudoServiceImpl implements CarteraadeudoService {

	@Autowired
	private CarteraadeudoRepository carteraadeudoRepository;

	/**
	 * Agrega un carteraadeudo.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCarteraadeudo(Carteraadeudo carteraadeudo) {
		carteraadeudoRepository.addCarteraadeudo(carteraadeudo);
	}

	/**
	 * Edita un carteraadeudo.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editCarteraadeudo(Carteraadeudo carteraadeudo) {
		carteraadeudoRepository.editCarteraadeudo(carteraadeudo);
	}
	
	/**
	 * Consulta informacion de carteraadeudos.
	 */
	public List<Carteraadeudo> listCarteraadeudos(Carteraadeudo carteraadeudo) {
		return carteraadeudoRepository.listCarteraadeudos(carteraadeudo);
	}

	/**
	 * Obtiene informacion de un carteraadeudo.
	 */
	public Carteraadeudo getCarteraadeudo(UUID empid) {
		return carteraadeudoRepository.getCarteraadeudo(empid);
	}

	/**
	 * Elimina un carteraadeudo.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCarteraadeudo(Carteraadeudo carteraadeudo) {
		 carteraadeudoRepository.deleteCarteraadeudo(carteraadeudo);
	}

	/**
	 * Consulta informacion de carteraadeudos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Carteraadeudo> listCarteraadeudosPagination(Carteraadeudo carteraadeudo, int page, int size) {
		return carteraadeudoRepository.listCarteraadeudosPagination(carteraadeudo, page, size);
	}

	/**
	 * Obtiene el numero de carteraadeudos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return carteraadeudoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de carteraadeudos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return carteraadeudoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de carteraadeudos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return carteraadeudoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los carteraadeudos y la pagina.
	 */
	public List<Carteraadeudo> listCarteraadeudosQuery(Carteraadeudo carteraadeudo, String query, int page, int size) {
		// TODO Auto-generated method stub
		return carteraadeudoRepository.listCarteraadeudosQuery(carteraadeudo, query, page, size);
	}
}	
