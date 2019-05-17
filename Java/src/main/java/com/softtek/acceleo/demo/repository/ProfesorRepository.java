package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Profesor;

public interface ProfesorRepository {
	
  public void addProfesor(Profesor profesor);
  
  public void editProfesor(Profesor profesor);
 
  public List<Profesor> listProfesors(Profesor profesor);   
    
  public Profesor getProfesor(int empid);   
    
  public void deleteProfesor(Profesor profesor); 

  public List<Profesor> listProfesorsQuery(Profesor profesor, String query, int page, int size);

  public List<Profesor> listProfesorsPagination(Profesor profesor, int page, int size);
  
      public long getTotalRows();
  
      public long getTotalRows(String query);
  
      public long getTotalRowsSearch(String query);	

}  
