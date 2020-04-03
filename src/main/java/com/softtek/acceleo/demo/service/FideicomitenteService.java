package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Fideicomitente;
import java.util.List;
import java.util.UUID;

public interface FideicomitenteService {
	
  public void addFideicomitente(Fideicomitente fideicomitente);
  
  public void editFideicomitente(Fideicomitente fideicomitente);
 
  public List<Fideicomitente> listFideicomitentes(Fideicomitente fideicomitente);   
    
  public Fideicomitente getFideicomitente(UUID empid);   
    
  public void deleteFideicomitente(Fideicomitente fideicomitente); 

  public List<Fideicomitente> listFideicomitentesQuery(Fideicomitente fideicomitente, String query, int page, int size);

  public List<Fideicomitente> listFideicomitentesPagination(Fideicomitente fideicomitente, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
