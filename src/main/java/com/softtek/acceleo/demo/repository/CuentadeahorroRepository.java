
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Cuentadeahorro;

public interface CuentadeahorroRepository {

	
	 public void addCuentadeahorro(Cuentadeahorro cuentadeahorro);   
	 
	 public void editCuentadeahorro(Cuentadeahorro cuentadeahorro);
	   
	 public List<Cuentadeahorro> listCuentadeahorros(Cuentadeahorro cuentadeahorro);   
	    
	 public Cuentadeahorro getCuentadeahorro(int empid);   
	    
	 public void deleteCuentadeahorro(Cuentadeahorro cuentadeahorro); 

	 public List<Cuentadeahorro> listCuentadeahorrosQuery(Cuentadeahorro cuentadeahorro, String query, int page, int size);

	 public List<Cuentadeahorro> listCuentadeahorrosPagination(Cuentadeahorro cuentadeahorro, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

