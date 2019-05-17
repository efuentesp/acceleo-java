package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Publicacion;

public interface PublicacionRepository {
	
  public void addPublicacion(Publicacion publicacion);
  
  public void editPublicacion(Publicacion publicacion);
 
  public List<Publicacion> listPublicacions(Publicacion publicacion);   
    
  public Publicacion getPublicacion(int empid);   
    
  public void deletePublicacion(Publicacion publicacion); 

  public List<Publicacion> listPublicacionsQuery(Publicacion publicacion, String query, int page, int size);

  public List<Publicacion> listPublicacionsPagination(Publicacion publicacion, int page, int size);
  
      public long getTotalRows();
  
      public long getTotalRows(String query);
  
      public long getTotalRowsSearch(String query);	

}  
