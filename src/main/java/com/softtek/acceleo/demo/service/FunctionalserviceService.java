package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Functionalservice;
import java.util.List;

public interface FunctionalserviceService {

	public void addFunctionalservice(Functionalservice functionalservice);

	public void editFunctionalservice(Functionalservice functionalservice);
	
	public List<Functionalservice> listFunctionalservices(Functionalservice functionalservice);

	public Functionalservice getFunctionalservice(int empid);

	public void deleteFunctionalservice(Functionalservice functionalservice);
	
	public List<Functionalservice> listFunctionalservicesQuery(Functionalservice functionalservice, String query, int page, int size);

	public List<Functionalservice> listFunctionalservicesPagination(Functionalservice functionalservice, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

