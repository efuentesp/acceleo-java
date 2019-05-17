package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Institucion;
import java.util.List;

public interface InstitucionService {
	
  public void addInstitucion(Institucion institucion);
  
  public void editInstitucion(Institucion institucion);
 
  public List<Institucion> listInstitucions(Institucion institucion);   
    
  public Institucion getInstitucion(int empid);   
    
  public void deleteInstitucion(Institucion institucion); 

  public List<Institucion> listInstitucionsQuery(Institucion institucion, String query, int page, int size);

  public List<Institucion> listInstitucionsPagination(Institucion institucion, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
