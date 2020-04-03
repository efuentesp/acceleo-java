package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Guia;
import java.util.List;
import java.util.UUID;

public interface GuiaService {
	
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
