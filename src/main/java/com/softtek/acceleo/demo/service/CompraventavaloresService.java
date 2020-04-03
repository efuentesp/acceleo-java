package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Compraventavalores;
import java.util.List;
import java.util.UUID;

public interface CompraventavaloresService {
	
  public void addCompraventavalores(Compraventavalores compraventavalores);
  
  public void editCompraventavalores(Compraventavalores compraventavalores);
 
  public List<Compraventavalores> listCompraventavaloress(Compraventavalores compraventavalores);   
    
  public Compraventavalores getCompraventavalores(UUID empid);   
    
  public void deleteCompraventavalores(Compraventavalores compraventavalores); 

  public List<Compraventavalores> listCompraventavaloressQuery(Compraventavalores compraventavalores, String query, int page, int size);

  public List<Compraventavalores> listCompraventavaloressPagination(Compraventavalores compraventavalores, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
