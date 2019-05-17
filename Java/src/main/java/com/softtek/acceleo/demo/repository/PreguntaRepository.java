package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Pregunta;

public interface PreguntaRepository {
	
  public void addPregunta(Pregunta pregunta);
  
  public void editPregunta(Pregunta pregunta);
 
  public List<Pregunta> listPreguntas(Pregunta pregunta);   
    
  public Pregunta getPregunta(int empid);   
    
  public void deletePregunta(Pregunta pregunta); 

  public List<Pregunta> listPreguntasQuery(Pregunta pregunta, String query, int page, int size);

  public List<Pregunta> listPreguntasPagination(Pregunta pregunta, int page, int size);
  
      public long getTotalRows();
  
      public long getTotalRows(String query);
  
      public long getTotalRowsSearch(String query);	

}  
