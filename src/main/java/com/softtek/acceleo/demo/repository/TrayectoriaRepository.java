
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Trayectoria;

public interface TrayectoriaRepository {

	
	 public void addTrayectoria(Trayectoria trayectoria);   
	 
	 public void editTrayectoria(Trayectoria trayectoria);
	   
	 public List<Trayectoria> listTrayectorias(Trayectoria trayectoria); 
	 
	 public List<Trayectoria> listTrayectoriasByCandidato(Trayectoria trayectoria, int id); 
	    
	 public Trayectoria getTrayectoria(int empid);   
	    
	 public void deleteTrayectoria(Trayectoria trayectoria); 

	 public List<Trayectoria> listTrayectoriasQuery(Trayectoria trayectoria, String query, int page, int size);

	 public List<Trayectoria> listTrayectoriasPagination(Trayectoria trayectoria, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

