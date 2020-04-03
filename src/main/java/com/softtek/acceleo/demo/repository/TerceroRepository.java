package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Tercero;

public interface TerceroRepository {
	
  public void addTercero(Tercero tercero);
  
  public void editTercero(Tercero tercero);
 
  public List<Tercero> listTerceros(Tercero tercero);   
    
  public Tercero getTercero(UUID empid);   
    
  public void deleteTercero(Tercero tercero); 

  public List<Tercero> listTercerosQuery(Tercero tercero, String query, int page, int size);

  public List<Tercero> listTercerosPagination(Tercero tercero, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
