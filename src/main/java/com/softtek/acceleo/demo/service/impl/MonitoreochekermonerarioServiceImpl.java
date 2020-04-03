/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los monitoreochekermonerarios. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.MonitoreochekermonerarioRepository;
import com.softtek.acceleo.demo.domain.Monitoreochekermonerario;
import com.softtek.acceleo.demo.service.MonitoreochekermonerarioService;
/**
 * Clase MonitoreochekermonerarioServiceImpl.
 * @author PSG.
 *
 */
@Service("monitoreochekermonerarioService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MonitoreochekermonerarioServiceImpl implements MonitoreochekermonerarioService {

	@Autowired
	private MonitoreochekermonerarioRepository monitoreochekermonerarioRepository;

	/**
	 * Agrega un monitoreochekermonerario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addMonitoreochekermonerario(Monitoreochekermonerario monitoreochekermonerario) {
		monitoreochekermonerarioRepository.addMonitoreochekermonerario(monitoreochekermonerario);
	}

	/**
	 * Edita un monitoreochekermonerario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editMonitoreochekermonerario(Monitoreochekermonerario monitoreochekermonerario) {
		monitoreochekermonerarioRepository.editMonitoreochekermonerario(monitoreochekermonerario);
	}
	
	/**
	 * Consulta informacion de monitoreochekermonerarios.
	 */
	public List<Monitoreochekermonerario> listMonitoreochekermonerarios(Monitoreochekermonerario monitoreochekermonerario) {
		return monitoreochekermonerarioRepository.listMonitoreochekermonerarios(monitoreochekermonerario);
	}

	/**
	 * Obtiene informacion de un monitoreochekermonerario.
	 */
	public Monitoreochekermonerario getMonitoreochekermonerario(UUID empid) {
		return monitoreochekermonerarioRepository.getMonitoreochekermonerario(empid);
	}

	/**
	 * Elimina un monitoreochekermonerario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteMonitoreochekermonerario(Monitoreochekermonerario monitoreochekermonerario) {
		 monitoreochekermonerarioRepository.deleteMonitoreochekermonerario(monitoreochekermonerario);
	}

	/**
	 * Consulta informacion de monitoreochekermonerarios y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Monitoreochekermonerario> listMonitoreochekermonerariosPagination(Monitoreochekermonerario monitoreochekermonerario, int page, int size) {
		return monitoreochekermonerarioRepository.listMonitoreochekermonerariosPagination(monitoreochekermonerario, page, size);
	}

	/**
	 * Obtiene el numero de monitoreochekermonerarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return monitoreochekermonerarioRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de monitoreochekermonerarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return monitoreochekermonerarioRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de monitoreochekermonerarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return monitoreochekermonerarioRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los monitoreochekermonerarios y la pagina.
	 */
	public List<Monitoreochekermonerario> listMonitoreochekermonerariosQuery(Monitoreochekermonerario monitoreochekermonerario, String query, int page, int size) {
		// TODO Auto-generated method stub
		return monitoreochekermonerarioRepository.listMonitoreochekermonerariosQuery(monitoreochekermonerario, query, page, size);
	}
}	
