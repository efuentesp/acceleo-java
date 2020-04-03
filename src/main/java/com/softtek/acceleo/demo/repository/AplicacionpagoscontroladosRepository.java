package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Aplicacionpagoscontrolados;

public interface AplicacionpagoscontroladosRepository {
	
  public void addAplicacionpagoscontrolados(Aplicacionpagoscontrolados aplicacionpagoscontrolados);
  
  public void editAplicacionpagoscontrolados(Aplicacionpagoscontrolados aplicacionpagoscontrolados);
 
  public List<Aplicacionpagoscontrolados> listAplicacionpagoscontroladoss(Aplicacionpagoscontrolados aplicacionpagoscontrolados);   
    
  public Aplicacionpagoscontrolados getAplicacionpagoscontrolados(UUID empid);   
    
  public void deleteAplicacionpagoscontrolados(Aplicacionpagoscontrolados aplicacionpagoscontrolados); 

  public List<Aplicacionpagoscontrolados> listAplicacionpagoscontroladossQuery(Aplicacionpagoscontrolados aplicacionpagoscontrolados, String query, int page, int size);

  public List<Aplicacionpagoscontrolados> listAplicacionpagoscontroladossPagination(Aplicacionpagoscontrolados aplicacionpagoscontrolados, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
