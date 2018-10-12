
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Aportacion;

public interface AportacionRepository {

	
	 public void addAportacion(Aportacion aportacion);   
	 
	 public void editAportacion(Aportacion aportacion);
	   
	 public List<Aportacion> listAportacions(Aportacion aportacion);   
	    
	 public Aportacion getAportacion(int empid);   
	    
	 public void deleteAportacion(Aportacion aportacion); 

	 public List<Aportacion> listAportacionsQuery(Aportacion aportacion, String query, int page, int size);

	 public List<Aportacion> listAportacionsPagination(Aportacion aportacion, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

