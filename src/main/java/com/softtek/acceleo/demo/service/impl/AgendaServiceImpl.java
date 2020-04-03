/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los agendas. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.AgendaRepository;
import com.softtek.acceleo.demo.domain.Agenda;
import com.softtek.acceleo.demo.service.AgendaService;
/**
 * Clase AgendaServiceImpl.
 * @author PSG.
 *
 */
@Service("agendaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AgendaServiceImpl implements AgendaService {

	@Autowired
	private AgendaRepository agendaRepository;

	/**
	 * Agrega un agenda.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAgenda(Agenda agenda) {
		agendaRepository.addAgenda(agenda);
	}

	/**
	 * Edita un agenda.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAgenda(Agenda agenda) {
		agendaRepository.editAgenda(agenda);
	}
	
	/**
	 * Consulta informacion de agendas.
	 */
	public List<Agenda> listAgendas(Agenda agenda) {
		return agendaRepository.listAgendas(agenda);
	}

	/**
	 * Obtiene informacion de un agenda.
	 */
	public Agenda getAgenda(UUID empid) {
		return agendaRepository.getAgenda(empid);
	}

	/**
	 * Elimina un agenda.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAgenda(Agenda agenda) {
		 agendaRepository.deleteAgenda(agenda);
	}

	/**
	 * Consulta informacion de agendas y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Agenda> listAgendasPagination(Agenda agenda, int page, int size) {
		return agendaRepository.listAgendasPagination(agenda, page, size);
	}

	/**
	 * Obtiene el numero de agendas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return agendaRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de agendas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return agendaRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de agendas consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return agendaRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los agendas y la pagina.
	 */
	public List<Agenda> listAgendasQuery(Agenda agenda, String query, int page, int size) {
		// TODO Auto-generated method stub
		return agendaRepository.listAgendasQuery(agenda, query, page, size);
	}
}	
