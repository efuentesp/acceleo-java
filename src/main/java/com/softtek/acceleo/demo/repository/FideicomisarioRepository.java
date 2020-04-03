package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Fideicomisario;

public interface FideicomisarioRepository {
	
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
