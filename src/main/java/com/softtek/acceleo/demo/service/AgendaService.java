package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Agenda;
import java.util.List;
import java.util.UUID;

public interface AgendaService {
	
  public void addAgenda(Agenda agenda);
  
  public void editAgenda(Agenda agenda);
 
  public List<Agenda> listAgendas(Agenda agenda);   
    
  public Agenda getAgenda(UUID empid);   
    
  public void deleteAgenda(Agenda agenda); 

  public List<Agenda> listAgendasQuery(Agenda agenda, String query, int page, int size);

  public List<Agenda> listAgendasPagination(Agenda agenda, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
