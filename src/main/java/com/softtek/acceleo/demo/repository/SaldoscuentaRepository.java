package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Saldoscuenta;

public interface SaldoscuentaRepository {
	
  public void addSaldoscuenta(Saldoscuenta saldoscuenta);
  
  public void editSaldoscuenta(Saldoscuenta saldoscuenta);
 
  public List<Saldoscuenta> listSaldoscuentas(Saldoscuenta saldoscuenta);   
    
  public Saldoscuenta getSaldoscuenta(UUID empid);   
    
  public void deleteSaldoscuenta(Saldoscuenta saldoscuenta); 

  public List<Saldoscuenta> listSaldoscuentasQuery(Saldoscuenta saldoscuenta, String query, int page, int size);

  public List<Saldoscuenta> listSaldoscuentasPagination(Saldoscuenta saldoscuenta, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
