package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Aportaciones;

public interface AportacionesRepository {
	
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
