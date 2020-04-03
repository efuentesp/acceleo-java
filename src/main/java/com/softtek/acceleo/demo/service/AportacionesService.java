package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Aportaciones;
import java.util.List;
import java.util.UUID;

public interface AportacionesService {
	
  public void addAportaciones(Aportaciones aportaciones);
  
  public void editAportaciones(Aportaciones aportaciones);
 
  public List<Aportaciones> listAportacioness(Aportaciones aportaciones);   
    
  public Aportaciones getAportaciones(UUID empid);   
    
  public void deleteAportaciones(Aportaciones aportaciones); 

  public List<Aportaciones> listAportacionessQuery(Aportaciones aportaciones, String query, int page, int size);

  public List<Aportaciones> listAportacionessPagination(Aportaciones aportaciones, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
