package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Puesto;
import java.util.List;

public interface PuestoService {

	public void addPuesto(Puesto puesto);

	public void editPuesto(Puesto puesto);
	
	public List<Puesto> listPuestos(Puesto puesto);

	public Puesto getPuesto(int empid);

	public void deletePuesto(Puesto puesto);
	
	public List<Puesto> listPuestosQuery(Puesto puesto, String query, int page, int size);

	public List<Puesto> listPuestosPagination(Puesto puesto, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

