package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Programa;

public interface ProgramaRepository {
	
  public void addPrograma(Programa programa);
  
  public void editPrograma(Programa programa);
 
  public List<Programa> listProgramas(Programa programa);   
    
  public Programa getPrograma(int empid);   
    
  public void deletePrograma(Programa programa); 

  public List<Programa> listProgramasQuery(Programa programa, String query, int page, int size);

  public List<Programa> listProgramasPagination(Programa programa, int page, int size);
  
      public long getTotalRows();
  
      public long getTotalRows(String query);
  
      public long getTotalRowsSearch(String query);	

}  
