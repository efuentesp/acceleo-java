package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Contratoinversion;

public interface ContratoinversionRepository {
	
  public void addContratoinversion(Contratoinversion contratoinversion);
  
  public void editContratoinversion(Contratoinversion contratoinversion);
 
  public List<Contratoinversion> listContratoinversions(Contratoinversion contratoinversion);   
    
  public Contratoinversion getContratoinversion(UUID empid);   
    
  public void deleteContratoinversion(Contratoinversion contratoinversion); 

  public List<Contratoinversion> listContratoinversionsQuery(Contratoinversion contratoinversion, String query, int page, int size);

  public List<Contratoinversion> listContratoinversionsPagination(Contratoinversion contratoinversion, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
