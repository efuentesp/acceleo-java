
/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los filials. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.FilialRepository;
import com.softtek.acceleo.demo.domain.Filial;
import com.softtek.acceleo.demo.service.FilialService;
/**
 * Clase FilialServiceImpl.
 * @author PSG.
 *
 */
@Service("filialService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FilialServiceImpl implements FilialService {

	@Autowired
	private FilialRepository filialRepository;

	/**
	 * Agrega un filial.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFilial(Filial filial) {
		
		filialRepository.addFilial(filial);
	}

	/**
	 * Edita un filial.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editFilial(Filial filial) {
		
		filialRepository.editFilial(filial);
	}
	
	/**
	 * Consulta informacion de filials.
	 */
	public List<Filial> listFilials(Filial filial) {
		return filialRepository.listFilials(filial);
	}
	
	
	public List<Filial> listFilialsByCandidato(Filial filial, int id){
		return filialRepository.listFilialsByCandidato(filial, id);
	}

	/**
	 * Obtiene informacion de un filial.
	 */
	public Filial getFilial(int empid) {

		return filialRepository.getFilial(empid);
	}

	/**
	 * Elimina un filial.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteFilial(Filial filial) {
		System.out.println("Entrando al deleteFilial");

		 filialRepository.deleteFilial(filial);
	}

	/**
	 * Consulta informacion de filials y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Filial> listFilialsPagination(Filial filial, int page, int size) {

		return filialRepository.listFilialsPagination(filial, page, size);
	}

	/**
	 * Obtiene el numero de filials consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return filialRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de filials consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return filialRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de filials consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return filialRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los filials y la pagina.
	 */
	public List<Filial> listFilialsQuery(Filial filial, String query, int page, int size) {
		// TODO Auto-generated method stub
		return filialRepository.listFilialsQuery(filial, query, page, size);
	}

}

