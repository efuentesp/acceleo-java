/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los honorarioadministracions. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.HonorarioadministracionRepository;
import com.softtek.acceleo.demo.domain.Honorarioadministracion;
import com.softtek.acceleo.demo.service.HonorarioadministracionService;
/**
 * Clase HonorarioadministracionServiceImpl.
 * @author PSG.
 *
 */
@Service("honorarioadministracionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HonorarioadministracionServiceImpl implements HonorarioadministracionService {

	@Autowired
	private HonorarioadministracionRepository honorarioadministracionRepository;

	/**
	 * Agrega un honorarioadministracion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addHonorarioadministracion(Honorarioadministracion honorarioadministracion) {
		honorarioadministracionRepository.addHonorarioadministracion(honorarioadministracion);
	}

	/**
	 * Edita un honorarioadministracion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editHonorarioadministracion(Honorarioadministracion honorarioadministracion) {
		honorarioadministracionRepository.editHonorarioadministracion(honorarioadministracion);
	}
	
	/**
	 * Consulta informacion de honorarioadministracions.
	 */
	public List<Honorarioadministracion> listHonorarioadministracions(Honorarioadministracion honorarioadministracion) {
		return honorarioadministracionRepository.listHonorarioadministracions(honorarioadministracion);
	}

	/**
	 * Obtiene informacion de un honorarioadministracion.
	 */
	public Honorarioadministracion getHonorarioadministracion(UUID empid) {
		return honorarioadministracionRepository.getHonorarioadministracion(empid);
	}

	/**
	 * Elimina un honorarioadministracion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteHonorarioadministracion(Honorarioadministracion honorarioadministracion) {
		 honorarioadministracionRepository.deleteHonorarioadministracion(honorarioadministracion);
	}

	/**
	 * Consulta informacion de honorarioadministracions y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Honorarioadministracion> listHonorarioadministracionsPagination(Honorarioadministracion honorarioadministracion, int page, int size) {
		return honorarioadministracionRepository.listHonorarioadministracionsPagination(honorarioadministracion, page, size);
	}

	/**
	 * Obtiene el numero de honorarioadministracions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return honorarioadministracionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de honorarioadministracions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return honorarioadministracionRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de honorarioadministracions consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return honorarioadministracionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los honorarioadministracions y la pagina.
	 */
	public List<Honorarioadministracion> listHonorarioadministracionsQuery(Honorarioadministracion honorarioadministracion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return honorarioadministracionRepository.listHonorarioadministracionsQuery(honorarioadministracion, query, page, size);
	}
}	
