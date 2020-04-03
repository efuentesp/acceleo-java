package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Agenda;

public interface AgendaRepository {
	
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
