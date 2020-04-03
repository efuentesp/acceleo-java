package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Declaracionsat;

public interface DeclaracionsatRepository {
	
  public void addDeclaracionsat(Declaracionsat declaracionsat);
  
  public void editDeclaracionsat(Declaracionsat declaracionsat);
 
  public List<Declaracionsat> listDeclaracionsats(Declaracionsat declaracionsat);   
    
  public Declaracionsat getDeclaracionsat(UUID empid);   
    
  public void deleteDeclaracionsat(Declaracionsat declaracionsat); 

  public List<Declaracionsat> listDeclaracionsatsQuery(Declaracionsat declaracionsat, String query, int page, int size);

  public List<Declaracionsat> listDeclaracionsatsPagination(Declaracionsat declaracionsat, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
