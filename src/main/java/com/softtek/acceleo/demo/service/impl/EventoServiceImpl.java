
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los eventos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.EventoRepository;
import com.softtek.acceleo.demo.domain.Evento;
import com.softtek.acceleo.demo.domain.Solicitud;
import com.softtek.acceleo.demo.service.EventoService;
/**
 * Clase EventoServiceImpl.
 * @author PSG.
 *
 */
@Service("eventoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	/**
	 * Agrega un evento.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEvento(Evento evento) {
		
		eventoRepository.addEvento(evento);
	}

	/**
	 * Edita un evento.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editEvento(Evento evento) {
		
		eventoRepository.editEvento(evento);
	}
	
	/**
	 * Consulta informacion de eventos.
	 */
	public List<Evento> listEventos(Evento evento) {

		return eventoRepository.listEventos(evento);
	}
	
	/**
	 * Obtiene informacion de un evento.
	 */
	public Evento getEvento(int empid) {

		return eventoRepository.getEvento(empid);
	}

	/**
	 * Elimina un evento.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteEvento(Evento evento) {
		System.out.println("Entrando al deleteEvento");

		 eventoRepository.deleteEvento(evento);
	}

	/**
	 * Consulta informacion de eventos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Evento> listEventosPagination(Evento evento, int page, int size) {

		return eventoRepository.listEventosPagination(evento, page, size);
	}

	/**
	 * Obtiene el numero de eventos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return eventoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de eventos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return eventoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de eventos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return eventoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los eventos y la pagina.
	 */
	public List<Evento> listEventosQuery(Evento evento, String query, int page, int size) {
		// TODO Auto-generated method stub
		return eventoRepository.listEventosQuery(evento, query, page, size);
	}

	@Override
	public List<Evento> listEventosByCandidato(Evento evento, int candidatoId) {
		return eventoRepository.listEventosByCandidato(evento, candidatoId);
	}

}

