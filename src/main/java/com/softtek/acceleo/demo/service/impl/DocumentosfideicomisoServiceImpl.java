/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los documentosfideicomisos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.DocumentosfideicomisoRepository;
import com.softtek.acceleo.demo.domain.Documentosfideicomiso;
import com.softtek.acceleo.demo.service.DocumentosfideicomisoService;
/**
 * Clase DocumentosfideicomisoServiceImpl.
 * @author PSG.
 *
 */
@Service("documentosfideicomisoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DocumentosfideicomisoServiceImpl implements DocumentosfideicomisoService {

	@Autowired
	private DocumentosfideicomisoRepository documentosfideicomisoRepository;

	/**
	 * Agrega un documentosfideicomiso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDocumentosfideicomiso(Documentosfideicomiso documentosfideicomiso) {
		documentosfideicomisoRepository.addDocumentosfideicomiso(documentosfideicomiso);
	}

	/**
	 * Edita un documentosfideicomiso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editDocumentosfideicomiso(Documentosfideicomiso documentosfideicomiso) {
		documentosfideicomisoRepository.editDocumentosfideicomiso(documentosfideicomiso);
	}
	
	/**
	 * Consulta informacion de documentosfideicomisos.
	 */
	public List<Documentosfideicomiso> listDocumentosfideicomisos(Documentosfideicomiso documentosfideicomiso) {
		return documentosfideicomisoRepository.listDocumentosfideicomisos(documentosfideicomiso);
	}

	/**
	 * Obtiene informacion de un documentosfideicomiso.
	 */
	public Documentosfideicomiso getDocumentosfideicomiso(UUID empid) {
		return documentosfideicomisoRepository.getDocumentosfideicomiso(empid);
	}

	/**
	 * Elimina un documentosfideicomiso.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteDocumentosfideicomiso(Documentosfideicomiso documentosfideicomiso) {
		 documentosfideicomisoRepository.deleteDocumentosfideicomiso(documentosfideicomiso);
	}

	/**
	 * Consulta informacion de documentosfideicomisos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Documentosfideicomiso> listDocumentosfideicomisosPagination(Documentosfideicomiso documentosfideicomiso, int page, int size) {
		return documentosfideicomisoRepository.listDocumentosfideicomisosPagination(documentosfideicomiso, page, size);
	}

	/**
	 * Obtiene el numero de documentosfideicomisos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return documentosfideicomisoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de documentosfideicomisos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return documentosfideicomisoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de documentosfideicomisos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return documentosfideicomisoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los documentosfideicomisos y la pagina.
	 */
	public List<Documentosfideicomiso> listDocumentosfideicomisosQuery(Documentosfideicomiso documentosfideicomiso, String query, int page, int size) {
		// TODO Auto-generated method stub
		return documentosfideicomisoRepository.listDocumentosfideicomisosQuery(documentosfideicomiso, query, page, size);
	}
}	
