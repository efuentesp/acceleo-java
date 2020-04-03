package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Formasliquidacion;
import java.util.List;
import java.util.UUID;

public interface FormasliquidacionService {
	
  public void addFormasliquidacion(Formasliquidacion formasliquidacion);
  
  public void editFormasliquidacion(Formasliquidacion formasliquidacion);
 
  public List<Formasliquidacion> listFormasliquidacions(Formasliquidacion formasliquidacion);   
    
  public Formasliquidacion getFormasliquidacion(UUID empid);   
    
  public void deleteFormasliquidacion(Formasliquidacion formasliquidacion); 

  public List<Formasliquidacion> listFormasliquidacionsQuery(Formasliquidacion formasliquidacion, String query, int page, int size);

  public List<Formasliquidacion> listFormasliquidacionsPagination(Formasliquidacion formasliquidacion, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
