package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Retiro;

public interface RetiroRepository {
	
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
