package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Ordensimplificada;
import java.util.List;

public interface OrdensimplificadaService {

	public void addOrdensimplificada(Ordensimplificada ordensimplificada);

	public void editOrdensimplificada(Ordensimplificada ordensimplificada);
	
	public List<Ordensimplificada> listOrdensimplificadas(Ordensimplificada ordensimplificada);

	public Ordensimplificada getOrdensimplificada(int empid);

	public void deleteOrdensimplificada(Ordensimplificada ordensimplificada);
	
	public List<Ordensimplificada> listOrdensimplificadasQuery(Ordensimplificada ordensimplificada, String query, int page, int size);

	public List<Ordensimplificada> listOrdensimplificadasPagination(Ordensimplificada ordensimplificada, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

