
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Cuentabancaria;

public interface CuentabancariaRepository {

	
	 public void addCuentabancaria(Cuentabancaria cuentabancaria);   
	 
	 public void editCuentabancaria(Cuentabancaria cuentabancaria);
	   
	 public List<Cuentabancaria> listCuentabancarias(Cuentabancaria cuentabancaria);   
	    
	 public Cuentabancaria getCuentabancaria(int empid);   
	    
	 public void deleteCuentabancaria(Cuentabancaria cuentabancaria); 

	 public List<Cuentabancaria> listCuentabancariasQuery(Cuentabancaria cuentabancaria, String query, int page, int size);

	 public List<Cuentabancaria> listCuentabancariasPagination(Cuentabancaria cuentabancaria, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

