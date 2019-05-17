package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Unidad;
import java.util.List;

public interface UnidadService {
	
  public void addUnidad(Unidad unidad);
  
  public void editUnidad(Unidad unidad);
 
  public List<Unidad> listUnidads(Unidad unidad);   
    
  public Unidad getUnidad(int empid);   
    
  public void deleteUnidad(Unidad unidad); 

  public List<Unidad> listUnidadsQuery(Unidad unidad, String query, int page, int size);

  public List<Unidad> listUnidadsPagination(Unidad unidad, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
