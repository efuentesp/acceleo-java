package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Fideicomiso;
import java.util.List;
import java.util.UUID;

public interface FideicomisoService {
	
  public void addFideicomiso(Fideicomiso fideicomiso);
  
  public void editFideicomiso(Fideicomiso fideicomiso);
 
  public List<Fideicomiso> listFideicomisos(Fideicomiso fideicomiso);   
    
  public Fideicomiso getFideicomiso(UUID empid);   
    
  public void deleteFideicomiso(Fideicomiso fideicomiso); 

  public List<Fideicomiso> listFideicomisosQuery(Fideicomiso fideicomiso, String query, int page, int size);

  public List<Fideicomiso> listFideicomisosPagination(Fideicomiso fideicomiso, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
