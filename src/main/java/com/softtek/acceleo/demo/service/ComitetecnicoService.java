package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Comitetecnico;
import java.util.List;
import java.util.UUID;

public interface ComitetecnicoService {
	
  public void addComitetecnico(Comitetecnico comitetecnico);
  
  public void editComitetecnico(Comitetecnico comitetecnico);
 
  public List<Comitetecnico> listComitetecnicos(Comitetecnico comitetecnico);   
    
  public Comitetecnico getComitetecnico(UUID empid);   
    
  public void deleteComitetecnico(Comitetecnico comitetecnico); 

  public List<Comitetecnico> listComitetecnicosQuery(Comitetecnico comitetecnico, String query, int page, int size);

  public List<Comitetecnico> listComitetecnicosPagination(Comitetecnico comitetecnico, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
