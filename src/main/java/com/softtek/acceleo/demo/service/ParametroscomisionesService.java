package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Parametroscomisiones;
import java.util.List;
import java.util.UUID;

public interface ParametroscomisionesService {
	
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
