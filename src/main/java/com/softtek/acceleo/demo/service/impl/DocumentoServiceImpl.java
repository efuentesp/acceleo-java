/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los documentos. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.DocumentoRepository;
import com.softtek.acceleo.demo.domain.Documento;
import com.softtek.acceleo.demo.service.DocumentoService;
/**
 * Clase DocumentoServiceImpl.
 * @author PSG.
 *
 */
@Service("documentoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DocumentoServiceImpl implements DocumentoService {

	@Autowired
	private DocumentoRepository documentoRepository;

	/**
	 * Agrega un documento.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDocumento(Documento documento) {
		documentoRepository.addDocumento(documento);
	}

	/**
	 * Edita un documento.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editDocumento(Documento documento) {
		documentoRepository.editDocumento(documento);
	}
	
	/**
	 * Consulta informacion de documentos.
	 */
	public List<Documento> listDocumentos(Documento documento) {
		return documentoRepository.listDocumentos(documento);
	}

	/**
	 * Obtiene informacion de un documento.
	 */
	public Documento getDocumento(UUID empid) {
		return documentoRepository.getDocumento(empid);
	}

	/**
	 * Elimina un documento.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteDocumento(Documento documento) {
		 documentoRepository.deleteDocumento(documento);
	}

	/**
	 * Consulta informacion de documentos y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Documento> listDocumentosPagination(Documento documento, int page, int size) {
		return documentoRepository.listDocumentosPagination(documento, page, size);
	}

	/**
	 * Obtiene el numero de documentos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return documentoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de documentos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return documentoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de documentos consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return documentoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los documentos y la pagina.
	 */
	public List<Documento> listDocumentosQuery(Documento documento, String query, int page, int size) {
		// TODO Auto-generated method stub
		return documentoRepository.listDocumentosQuery(documento, query, page, size);
	}
}	
