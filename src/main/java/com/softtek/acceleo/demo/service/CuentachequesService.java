package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Cuentacheques;
import java.util.List;
import java.util.UUID;

public interface CuentachequesService {
	
  public void addCuentacheques(Cuentacheques cuentacheques);
  
  public void editCuentacheques(Cuentacheques cuentacheques);
 
  public List<Cuentacheques> listCuentachequess(Cuentacheques cuentacheques);   
    
  public Cuentacheques getCuentacheques(UUID empid);   
    
  public void deleteCuentacheques(Cuentacheques cuentacheques); 

  public List<Cuentacheques> listCuentachequessQuery(Cuentacheques cuentacheques, String query, int page, int size);

  public List<Cuentacheques> listCuentachequessPagination(Cuentacheques cuentacheques, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
