
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Puesto;

public interface PuestoRepository {

	
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

