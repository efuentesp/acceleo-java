
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Operadorproduccion;

public interface OperadorproduccionRepository {

	
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

