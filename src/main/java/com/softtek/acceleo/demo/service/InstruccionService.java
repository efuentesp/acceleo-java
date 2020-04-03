package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Instruccion;
import java.util.List;
import java.util.UUID;

public interface InstruccionService {
	
  public void addInstruccion(Instruccion instruccion);
  
  public void editInstruccion(Instruccion instruccion);
 
  public List<Instruccion> listInstruccions(Instruccion instruccion);   
    
  public Instruccion getInstruccion(UUID empid);   
    
  public void deleteInstruccion(Instruccion instruccion); 

  public List<Instruccion> listInstruccionsQuery(Instruccion instruccion, String query, int page, int size);

  public List<Instruccion> listInstruccionsPagination(Instruccion instruccion, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
