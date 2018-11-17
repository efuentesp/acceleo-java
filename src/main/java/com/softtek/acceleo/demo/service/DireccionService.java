package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Direccion;
import java.util.List;
import java.util.UUID;

public interface DireccionService {
	
  public void addDireccion(Direccion direccion);
  
  public void editDireccion(Direccion direccion);
 
  public List<Direccion> listDireccions(Direccion direccion);   
    
  public Direccion getDireccion(UUID empid);   
    
  public void deleteDireccion(Direccion direccion); 

  public List<Direccion> listDireccionsQuery(Direccion direccion, String query, int page, int size);

  public List<Direccion> listDireccionsPagination(Direccion direccion, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
