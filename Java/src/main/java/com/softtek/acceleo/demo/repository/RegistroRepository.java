package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Registro;

public interface RegistroRepository {
	
  public void addRegistro(Registro registro);
  
  public void editRegistro(Registro registro);
 
  public List<Registro> listRegistros(Registro registro);   
    
  public Registro getRegistro(int empid);   
    
  public void deleteRegistro(Registro registro); 

  public List<Registro> listRegistrosQuery(Registro registro, String query, int page, int size);

  public List<Registro> listRegistrosPagination(Registro registro, int page, int size);
  
      public long getTotalRows();
  
      public long getTotalRows(String query);
  
      public long getTotalRowsSearch(String query);	

}  
