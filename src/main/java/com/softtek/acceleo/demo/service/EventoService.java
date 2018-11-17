package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Evento;
import java.util.List;
import java.util.UUID;

public interface EventoService {
	
  public void addEvento(Evento evento);
  
  public void editEvento(Evento evento);
 
  public List<Evento> listEventos(Evento evento);   
    
  public Evento getEvento(UUID empid);   
    
  public void deleteEvento(Evento evento); 

  public List<Evento> listEventosQuery(Evento evento, String query, int page, int size);

  public List<Evento> listEventosPagination(Evento evento, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
