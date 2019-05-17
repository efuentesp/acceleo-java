package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Recurso;

public interface RecursoRepository {
	
  public void addRecurso(Recurso recurso);
  
  public void editRecurso(Recurso recurso);
 
  public List<Recurso> listRecursos(Recurso recurso);   
    
  public Recurso getRecurso(int empid);   
    
  public void deleteRecurso(Recurso recurso); 

  public List<Recurso> listRecursosQuery(Recurso recurso, String query, int page, int size);

  public List<Recurso> listRecursosPagination(Recurso recurso, int page, int size);
  
      public long getTotalRows();
  
      public long getTotalRows(String query);
  
      public long getTotalRowsSearch(String query);	

}  
