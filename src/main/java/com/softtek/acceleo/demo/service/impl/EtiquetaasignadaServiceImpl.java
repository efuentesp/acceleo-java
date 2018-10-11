
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los etiquetaasignadas. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.EtiquetaasignadaRepository;
import com.softtek.acceleo.demo.domain.Etiquetaasignada;
import com.softtek.acceleo.demo.service.EtiquetaasignadaService;
/**
 * Clase EtiquetaasignadaServiceImpl.
 * @author PSG.
 *
 */
@Service("etiquetaasignadaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EtiquetaasignadaServiceImpl implements EtiquetaasignadaService {

	@Autowired
	private EtiquetaasignadaRepository etiquetaasignadaRepository;

	/**
	 * Agrega un etiquetaasignada.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEtiquetaasignada(Etiquetaasignada etiquetaasignada) {
		
		etiquetaasignadaRepository.addEtiquetaasignada(etiquetaasignada);
	}

	/**
	 * Edita un etiquetaasignada.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editEtiquetaasignada(Etiquetaasignada etiquetaasignada) {
		
		etiquetaasignadaRepository.editEtiquetaasignada(etiquetaasignada);
	}
	
	/**
	 * Consulta informacion de etiquetaasignadas.
	 */
	public List<Etiquetaasignada> listEtiquetaasignadas(Etiquetaasignada etiquetaasignada) {

		return etiquetaasignadaRepository.listEtiquetaasignadas(etiquetaasignada);
	}

	/**
	 * Obtiene informacion de un etiquetaasignada.
	 */
	public Etiquetaasignada getEtiquetaasignada(int empid) {

		return etiquetaasignadaRepository.getEtiquetaasignada(empid);
	}

	/**
	 * Elimina un etiquetaasignada.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteEtiquetaasignada(Etiquetaasignada etiquetaasignada) {
		System.out.println("Entrando al deleteEtiquetaasignada");

		 etiquetaasignadaRepository.deleteEtiquetaasignada(etiquetaasignada);
	}

	/**
	 * Consulta informacion de etiquetaasignadas y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Etiquetaasignada> listEtiquetaasignadasPagination(Etiquetaasignada etiquetaasignada, int page, int size) {

		return etiquetaasignadaRepository.listEtiquetaasignadasPagination(etiquetaasignada, page, size);
	}

	/**
	 * Obtiene el numero de etiquetaasignadas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return etiquetaasignadaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de etiquetaasignadas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return etiquetaasignadaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de etiquetaasignadas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return etiquetaasignadaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los etiquetaasignadas y la pagina.
	 */
	public List<Etiquetaasignada> listEtiquetaasignadasQuery(Etiquetaasignada etiquetaasignada, String query, int page, int size) {
		// TODO Auto-generated method stub
		return etiquetaasignadaRepository.listEtiquetaasignadasQuery(etiquetaasignada, query, page, size);
	}

}

