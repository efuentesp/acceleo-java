package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Subfiso;
import java.util.List;
import java.util.UUID;

public interface SubfisoService {
	
  public void addSubfiso(Subfiso subfiso);
  
  public void editSubfiso(Subfiso subfiso);
 
  public List<Subfiso> listSubfisos(Subfiso subfiso);   
    
  public Subfiso getSubfiso(UUID empid);   
    
  public void deleteSubfiso(Subfiso subfiso); 

  public List<Subfiso> listSubfisosQuery(Subfiso subfiso, String query, int page, int size);

  public List<Subfiso> listSubfisosPagination(Subfiso subfiso, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
