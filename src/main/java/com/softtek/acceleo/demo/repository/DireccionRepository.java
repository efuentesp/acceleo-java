
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Direccion;

public interface DireccionRepository {

	
	 public void addDireccion(Direccion direccion);   
	 
	 public void editDireccion(Direccion direccion);
	   
	 public List<Direccion> listDireccions(Direccion direccion);   
	    
	 public Direccion getDireccion(int empid);   
	    
	 public void deleteDireccion(Direccion direccion); 

	 public List<Direccion> listDireccionsQuery(Direccion direccion, String query, int page, int size);

	 public List<Direccion> listDireccionsPagination(Direccion direccion, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

