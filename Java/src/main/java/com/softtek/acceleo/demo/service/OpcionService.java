package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Opcion;
import java.util.List;

public interface OpcionService {
	
  public void addOpcion(Opcion opcion);
  
  public void editOpcion(Opcion opcion);
 
  public List<Opcion> listOpcions(Opcion opcion);   
    
  public Opcion getOpcion(int empid);   
    
  public void deleteOpcion(Opcion opcion); 

  public List<Opcion> listOpcionsQuery(Opcion opcion, String query, int page, int size);

  public List<Opcion> listOpcionsPagination(Opcion opcion, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
