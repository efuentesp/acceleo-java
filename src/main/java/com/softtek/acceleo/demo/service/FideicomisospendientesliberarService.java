package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Fideicomisospendientesliberar;
import java.util.List;
import java.util.UUID;

public interface FideicomisospendientesliberarService {
	
  public void addFideicomisospendientesliberar(Fideicomisospendientesliberar fideicomisospendientesliberar);
  
  public void editFideicomisospendientesliberar(Fideicomisospendientesliberar fideicomisospendientesliberar);
 
  public List<Fideicomisospendientesliberar> listFideicomisospendientesliberars(Fideicomisospendientesliberar fideicomisospendientesliberar);   
    
  public Fideicomisospendientesliberar getFideicomisospendientesliberar(UUID empid);   
    
  public void deleteFideicomisospendientesliberar(Fideicomisospendientesliberar fideicomisospendientesliberar); 

  public List<Fideicomisospendientesliberar> listFideicomisospendientesliberarsQuery(Fideicomisospendientesliberar fideicomisospendientesliberar, String query, int page, int size);

  public List<Fideicomisospendientesliberar> listFideicomisospendientesliberarsPagination(Fideicomisospendientesliberar fideicomisospendientesliberar, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
