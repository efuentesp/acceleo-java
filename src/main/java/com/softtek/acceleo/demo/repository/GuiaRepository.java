package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Guia;

public interface GuiaRepository {
	
  public void addGuia(Guia guia);
  
  public void editGuia(Guia guia);
 
  public List<Guia> listGuias(Guia guia);   
    
  public Guia getGuia(UUID empid);   
    
  public void deleteGuia(Guia guia); 

  public List<Guia> listGuiasQuery(Guia guia, String query, int page, int size);

  public List<Guia> listGuiasPagination(Guia guia, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
