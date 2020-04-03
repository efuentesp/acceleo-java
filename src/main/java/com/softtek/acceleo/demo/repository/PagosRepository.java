package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Pagos;

public interface PagosRepository {
	
  public void addPagos(Pagos pagos);
  
  public void editPagos(Pagos pagos);
 
  public List<Pagos> listPagoss(Pagos pagos);   
    
  public Pagos getPagos(UUID empid);   
    
  public void deletePagos(Pagos pagos); 

  public List<Pagos> listPagossQuery(Pagos pagos, String query, int page, int size);

  public List<Pagos> listPagossPagination(Pagos pagos, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
