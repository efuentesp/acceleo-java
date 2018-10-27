
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Posicion;

public interface PosicionRepository {

	
	 public void addPosicion(Posicion posicion);   
	 
	 public void editPosicion(Posicion posicion);
	   
	 public List<Posicion> listPosicions(Posicion posicion);   
	 
	 public List<Posicion> listPosicionsByCandidato(Posicion posicion, int id);
	    
	 public Posicion getPosicion(int empid);   
	    
	 public void deletePosicion(Posicion posicion); 

	 public List<Posicion> listPosicionsQuery(Posicion posicion, String query, int page, int size);

	 public List<Posicion> listPosicionsPagination(Posicion posicion, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

