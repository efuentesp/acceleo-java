
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Filial;

public interface FilialRepository {

	
	 public void addFilial(Filial filial);   
	 
	 public void editFilial(Filial filial);
	   
	 public List<Filial> listFilials(Filial filial);   
	 
	 public List<Filial> listFilialsByCandidato(Filial filial, int id);
	    
	 public Filial getFilial(int empid);   
	    
	 public void deleteFilial(Filial filial); 

	 public List<Filial> listFilialsQuery(Filial filial, String query, int page, int size);

	 public List<Filial> listFilialsPagination(Filial filial, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

