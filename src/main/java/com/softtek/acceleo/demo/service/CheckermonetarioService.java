package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Checkermonetario;
import java.util.List;
import java.util.UUID;

public interface CheckermonetarioService {
	
  public void addCheckermonetario(Checkermonetario checkermonetario);
  
  public void editCheckermonetario(Checkermonetario checkermonetario);
 
  public List<Checkermonetario> listCheckermonetarios(Checkermonetario checkermonetario);   
    
  public Checkermonetario getCheckermonetario(UUID empid);   
    
  public void deleteCheckermonetario(Checkermonetario checkermonetario); 

  public List<Checkermonetario> listCheckermonetariosQuery(Checkermonetario checkermonetario, String query, int page, int size);

  public List<Checkermonetario> listCheckermonetariosPagination(Checkermonetario checkermonetario, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
