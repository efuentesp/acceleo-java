/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los honorarioscontratos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.HonorarioscontratoRepository;
import com.softtek.acceleo.demo.domain.Honorarioscontrato;
import com.softtek.acceleo.demo.service.HonorarioscontratoService;
/**
 * Clase HonorarioscontratoServiceImpl.
 * @author PSG.
 *
 */
@Service("honorarioscontratoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HonorarioscontratoServiceImpl implements HonorarioscontratoService {

	@Autowired
	private HonorarioscontratoRepository honorarioscontratoRepository;

	/**
	 * Agrega un honorarioscontrato.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addHonorarioscontrato(Honorarioscontrato honorarioscontrato) {
		honorarioscontratoRepository.addHonorarioscontrato(honorarioscontrato);
	}

	/**
	 * Edita un honorarioscontrato.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editHonorarioscontrato(Honorarioscontrato honorarioscontrato) {
		honorarioscontratoRepository.editHonorarioscontrato(honorarioscontrato);
	}
	
	/**
	 * Consulta informacion de honorarioscontratos.
	 */
	public List<Honorarioscontrato> listHonorarioscontratos(Honorarioscontrato honorarioscontrato) {
		return honorarioscontratoRepository.listHonorarioscontratos(honorarioscontrato);
	}

	/**
	 * Obtiene informacion de un honorarioscontrato.
	 */
	public Honorarioscontrato getHonorarioscontrato(UUID empid) {
		return honorarioscontratoRepository.getHonorarioscontrato(empid);
	}

	/**
	 * Elimina un honorarioscontrato.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteHonorarioscontrato(Honorarioscontrato honorarioscontrato) {
		 honorarioscontratoRepository.deleteHonorarioscontrato(honorarioscontrato);
	}

	/**
	 * Consulta informacion de honorarioscontratos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Honorarioscontrato> listHonorarioscontratosPagination(Honorarioscontrato honorarioscontrato, int page, int size) {
		return honorarioscontratoRepository.listHonorarioscontratosPagination(honorarioscontrato, page, size);
	}

	/**
	 * Obtiene el numero de honorarioscontratos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return honorarioscontratoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de honorarioscontratos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return honorarioscontratoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de honorarioscontratos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return honorarioscontratoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los honorarioscontratos y la pagina.
	 */
	public List<Honorarioscontrato> listHonorarioscontratosQuery(Honorarioscontrato honorarioscontrato, String query, int page, int size) {
		// TODO Auto-generated method stub
		return honorarioscontratoRepository.listHonorarioscontratosQuery(honorarioscontrato, query, page, size);
	}
}	
