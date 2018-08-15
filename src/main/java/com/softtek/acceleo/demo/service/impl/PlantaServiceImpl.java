
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los plantas. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.PlantaRepository;
import com.softtek.acceleo.demo.domain.Planta;
import com.softtek.acceleo.demo.service.PlantaService;
/**
 * Clase PlantaServiceImpl.
 * @author PSG.
 *
 */
@Service("plantaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PlantaServiceImpl implements PlantaService {

	@Autowired
	private PlantaRepository plantaRepository;

	/**
	 * Agrega un planta.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPlanta(Planta planta) {
		
		plantaRepository.addPlanta(planta);
	}

	/**
	 * Edita un planta.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editPlanta(Planta planta) {
		
		plantaRepository.editPlanta(planta);
	}
	
	/**
	 * Consulta informacion de plantas.
	 */
	public List<Planta> listPlantas(Planta planta) {

		return plantaRepository.listPlantas(planta);
	}

	/**
	 * Obtiene informacion de un planta.
	 */
	public Planta getPlanta(int empid) {

		return plantaRepository.getPlanta(empid);
	}

	/**
	 * Elimina un planta.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePlanta(Planta planta) {
		System.out.println("Entrando al deletePlanta");

		 plantaRepository.deletePlanta(planta);
	}

	/**
	 * Consulta informacion de plantas y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Planta> listPlantasPagination(Planta planta, int page, int size) {

		return plantaRepository.listPlantasPagination(planta, page, size);
	}

	/**
	 * Obtiene el numero de plantas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return plantaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de plantas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return plantaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de plantas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return plantaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los plantas y la pagina.
	 */
	public List<Planta> listPlantasQuery(Planta planta, String query, int page, int size) {
		// TODO Auto-generated method stub
		return plantaRepository.listPlantasQuery(planta, query, page, size);
	}

}

