package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Grupoa;
import java.util.List;

public interface GrupoaService {
	
  public void addGrupoa(Grupoa grupoa);
  
  public void editGrupoa(Grupoa grupoa);
 
  public List<Grupoa> listGrupoas(Grupoa grupoa);   
    
  public Grupoa getGrupoa(int empid);   
    
  public void deleteGrupoa(Grupoa grupoa); 

  public List<Grupoa> listGrupoasQuery(Grupoa grupoa, String query, int page, int size);

  public List<Grupoa> listGrupoasPagination(Grupoa grupoa, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
