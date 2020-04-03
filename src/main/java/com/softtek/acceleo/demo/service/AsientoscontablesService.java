package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Asientoscontables;
import java.util.List;
import java.util.UUID;

public interface AsientoscontablesService {
	
  public void addAsientoscontables(Asientoscontables asientoscontables);
  
  public void editAsientoscontables(Asientoscontables asientoscontables);
 
  public List<Asientoscontables> listAsientoscontabless(Asientoscontables asientoscontables);   
    
  public Asientoscontables getAsientoscontables(UUID empid);   
    
  public void deleteAsientoscontables(Asientoscontables asientoscontables); 

  public List<Asientoscontables> listAsientoscontablessQuery(Asientoscontables asientoscontables, String query, int page, int size);

  public List<Asientoscontables> listAsientoscontablessPagination(Asientoscontables asientoscontables, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
