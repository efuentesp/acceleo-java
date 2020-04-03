package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Parametroscomisiones;

public interface ParametroscomisionesRepository {
	
  public void addParametroscomisiones(Parametroscomisiones parametroscomisiones);
  
  public void editParametroscomisiones(Parametroscomisiones parametroscomisiones);
 
  public List<Parametroscomisiones> listParametroscomisioness(Parametroscomisiones parametroscomisiones);   
    
  public Parametroscomisiones getParametroscomisiones(UUID empid);   
    
  public void deleteParametroscomisiones(Parametroscomisiones parametroscomisiones); 

  public List<Parametroscomisiones> listParametroscomisionessQuery(Parametroscomisiones parametroscomisiones, String query, int page, int size);

  public List<Parametroscomisiones> listParametroscomisionessPagination(Parametroscomisiones parametroscomisiones, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
