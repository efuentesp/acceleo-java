package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Autodeclaracioncrs;
import java.util.List;
import java.util.UUID;

public interface AutodeclaracioncrsService {
	
  public void addAutodeclaracioncrs(Autodeclaracioncrs autodeclaracioncrs);
  
  public void editAutodeclaracioncrs(Autodeclaracioncrs autodeclaracioncrs);
 
  public List<Autodeclaracioncrs> listAutodeclaracioncrss(Autodeclaracioncrs autodeclaracioncrs);   
    
  public Autodeclaracioncrs getAutodeclaracioncrs(UUID empid);   
    
  public void deleteAutodeclaracioncrs(Autodeclaracioncrs autodeclaracioncrs); 

  public List<Autodeclaracioncrs> listAutodeclaracioncrssQuery(Autodeclaracioncrs autodeclaracioncrs, String query, int page, int size);

  public List<Autodeclaracioncrs> listAutodeclaracioncrssPagination(Autodeclaracioncrs autodeclaracioncrs, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
