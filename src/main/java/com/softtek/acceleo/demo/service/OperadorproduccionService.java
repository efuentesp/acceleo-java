package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Operadorproduccion;
import java.util.List;

public interface OperadorproduccionService {

	public void addOperadorproduccion(Operadorproduccion operadorproduccion);

	public void editOperadorproduccion(Operadorproduccion operadorproduccion);
	
	public List<Operadorproduccion> listOperadorproduccions(Operadorproduccion operadorproduccion);

	public Operadorproduccion getOperadorproduccion(int empid);

	public void deleteOperadorproduccion(Operadorproduccion operadorproduccion);
	
	public List<Operadorproduccion> listOperadorproduccionsQuery(Operadorproduccion operadorproduccion, String query, int page, int size);

	public List<Operadorproduccion> listOperadorproduccionsPagination(Operadorproduccion operadorproduccion, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

