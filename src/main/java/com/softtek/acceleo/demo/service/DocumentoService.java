package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Documento;
import java.util.List;

public interface DocumentoService {

	public void addDocumento(Documento documento);

	public void editDocumento(Documento documento);
	
	public List<Documento> listDocumentos(Documento documento);

	public Documento getDocumento(int empid);

	public void deleteDocumento(Documento documento);
	
	public List<Documento> listDocumentosQuery(Documento documento, String query, int page, int size);

	public List<Documento> listDocumentosPagination(Documento documento, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

