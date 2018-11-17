package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Trayectoria;

public interface TrayectoriaRepository {
	
  public void addTrayectoria(Trayectoria trayectoria);
  
  public void editTrayectoria(Trayectoria trayectoria);
 
  public List<Trayectoria> listTrayectorias(Trayectoria trayectoria);   
    
  public Trayectoria getTrayectoria(UUID empid);   
    
  public void deleteTrayectoria(Trayectoria trayectoria); 

  public List<Trayectoria> listTrayectoriasQuery(Trayectoria trayectoria, String query, int page, int size);

  public List<Trayectoria> listTrayectoriasPagination(Trayectoria trayectoria, int page, int size);
  
      public long getTotalRows();
  
      public long getTotalRows(String query);
  
      public long getTotalRowsSearch(String query);	

}  
