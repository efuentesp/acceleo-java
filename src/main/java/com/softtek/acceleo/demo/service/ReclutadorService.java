package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Reclutador;
import java.util.List;

public interface ReclutadorService {

	public void addReclutador(Reclutador reclutador);

	public void editReclutador(Reclutador reclutador);
	
	public List<Reclutador> listReclutadors(Reclutador reclutador);

	public Reclutador getReclutador(int empid);

	public void deleteReclutador(Reclutador reclutador);
	
	public List<Reclutador> listReclutadorsQuery(Reclutador reclutador, String query, int page, int size);

	public List<Reclutador> listReclutadorsPagination(Reclutador reclutador, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

