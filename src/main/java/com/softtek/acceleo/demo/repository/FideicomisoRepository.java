package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Fideicomiso;

public interface FideicomisoRepository {
	
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
