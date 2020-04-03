package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Retiro;
import java.util.List;
import java.util.UUID;

public interface RetiroService {
	
  public void addRetiro(Retiro retiro);
  
  public void editRetiro(Retiro retiro);
 
  public List<Retiro> listRetiros(Retiro retiro);   
    
  public Retiro getRetiro(UUID empid);   
    
  public void deleteRetiro(Retiro retiro); 

  public List<Retiro> listRetirosQuery(Retiro retiro, String query, int page, int size);

  public List<Retiro> listRetirosPagination(Retiro retiro, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
