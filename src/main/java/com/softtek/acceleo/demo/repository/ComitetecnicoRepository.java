package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Comitetecnico;

public interface ComitetecnicoRepository {
	
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
