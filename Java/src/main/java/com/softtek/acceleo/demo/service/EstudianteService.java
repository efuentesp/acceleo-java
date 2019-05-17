package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Estudiante;
import java.util.List;

public interface EstudianteService {
	
  public void addEstudiante(Estudiante estudiante);
  
  public void editEstudiante(Estudiante estudiante);
 
  public List<Estudiante> listEstudiantes(Estudiante estudiante);   
    
  public Estudiante getEstudiante(int empid);   
    
  public void deleteEstudiante(Estudiante estudiante); 

  public List<Estudiante> listEstudiantesQuery(Estudiante estudiante, String query, int page, int size);

  public List<Estudiante> listEstudiantesPagination(Estudiante estudiante, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
