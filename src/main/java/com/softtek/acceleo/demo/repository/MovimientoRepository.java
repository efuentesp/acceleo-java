package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Movimiento;

public interface MovimientoRepository {
	
  public void addMovimiento(Movimiento movimiento);
  
  public void editMovimiento(Movimiento movimiento);
 
  public List<Movimiento> listMovimientos(Movimiento movimiento);   
    
  public Movimiento getMovimiento(UUID empid);   
    
  public void deleteMovimiento(Movimiento movimiento); 

  public List<Movimiento> listMovimientosQuery(Movimiento movimiento, String query, int page, int size);

  public List<Movimiento> listMovimientosPagination(Movimiento movimiento, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
