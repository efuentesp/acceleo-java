package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Tasadeinteres;
import java.util.List;

public interface TasadeinteresService {

	public void addTasadeinteres(Tasadeinteres tasadeinteres);

	public void editTasadeinteres(Tasadeinteres tasadeinteres);
	
	public List<Tasadeinteres> listTasadeinteress(Tasadeinteres tasadeinteres);

	public Tasadeinteres getTasadeinteres(int empid);

	public void deleteTasadeinteres(Tasadeinteres tasadeinteres);
	
	public List<Tasadeinteres> listTasadeinteressQuery(Tasadeinteres tasadeinteres, String query, int page, int size);

	public List<Tasadeinteres> listTasadeinteressPagination(Tasadeinteres tasadeinteres, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

