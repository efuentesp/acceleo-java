package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Fideicomisospendientesliberar;

public interface FideicomisospendientesliberarRepository {
	
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
