package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Fideicomisario;
import java.util.List;
import java.util.UUID;

public interface FideicomisarioService {
	
  public void addFideicomisario(Fideicomisario fideicomisario);
  
  public void editFideicomisario(Fideicomisario fideicomisario);
 
  public List<Fideicomisario> listFideicomisarios(Fideicomisario fideicomisario);   
    
  public Fideicomisario getFideicomisario(UUID empid);   
    
  public void deleteFideicomisario(Fideicomisario fideicomisario); 

  public List<Fideicomisario> listFideicomisariosQuery(Fideicomisario fideicomisario, String query, int page, int size);

  public List<Fideicomisario> listFideicomisariosPagination(Fideicomisario fideicomisario, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
