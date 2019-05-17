package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Examen;
import java.util.List;

public interface ExamenService {
	
  public void addExamen(Examen examen);
  
  public void editExamen(Examen examen);
 
  public List<Examen> listExamens(Examen examen);   
    
  public Examen getExamen(int empid);   
    
  public void deleteExamen(Examen examen); 

  public List<Examen> listExamensQuery(Examen examen, String query, int page, int size);

  public List<Examen> listExamensPagination(Examen examen, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
