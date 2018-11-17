package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Reclutador;

public interface ReclutadorRepository {
	
  public void addReclutador(Reclutador reclutador);
  
  public void editReclutador(Reclutador reclutador);
 
  public List<Reclutador> listReclutadors(Reclutador reclutador);   
    
  public Reclutador getReclutador(UUID empid);   
    
  public void deleteReclutador(Reclutador reclutador); 

  public List<Reclutador> listReclutadorsQuery(Reclutador reclutador, String query, int page, int size);

  public List<Reclutador> listReclutadorsPagination(Reclutador reclutador, int page, int size);
  
      public long getTotalRows();
  
      public long getTotalRows(String query);
  
      public long getTotalRowsSearch(String query);	

}  
