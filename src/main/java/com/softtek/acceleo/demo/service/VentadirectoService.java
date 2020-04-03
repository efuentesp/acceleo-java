package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Ventadirecto;
import java.util.List;
import java.util.UUID;

public interface VentadirectoService {
	
  public void addVentadirecto(Ventadirecto ventadirecto);
  
  public void editVentadirecto(Ventadirecto ventadirecto);
 
  public List<Ventadirecto> listVentadirectos(Ventadirecto ventadirecto);   
    
  public Ventadirecto getVentadirecto(UUID empid);   
    
  public void deleteVentadirecto(Ventadirecto ventadirecto); 

  public List<Ventadirecto> listVentadirectosQuery(Ventadirecto ventadirecto, String query, int page, int size);

  public List<Ventadirecto> listVentadirectosPagination(Ventadirecto ventadirecto, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
