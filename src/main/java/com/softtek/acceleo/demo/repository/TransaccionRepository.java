package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Transaccion;

public interface TransaccionRepository {
	
  public void addTransaccion(Transaccion transaccion);
  
  public void editTransaccion(Transaccion transaccion);
 
  public List<Transaccion> listTransaccions(Transaccion transaccion);   
    
  public Transaccion getTransaccion(UUID empid);   
    
  public void deleteTransaccion(Transaccion transaccion); 

  public List<Transaccion> listTransaccionsQuery(Transaccion transaccion, String query, int page, int size);

  public List<Transaccion> listTransaccionsPagination(Transaccion transaccion, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
