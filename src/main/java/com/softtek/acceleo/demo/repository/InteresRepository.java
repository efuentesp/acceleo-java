
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Interes;

public interface InteresRepository {

	
	 public void addInteres(Interes interes);   
	 
	 public void editInteres(Interes interes);
	   
	 public List<Interes> listInteress(Interes interes);   
	    
	 public Interes getInteres(int empid);   
	    
	 public void deleteInteres(Interes interes); 

	 public List<Interes> listInteressQuery(Interes interes, String query, int page, int size);

	 public List<Interes> listInteressPagination(Interes interes, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

