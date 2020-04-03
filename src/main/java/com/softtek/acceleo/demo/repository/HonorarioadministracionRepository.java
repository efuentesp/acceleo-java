package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Honorarioadministracion;

public interface HonorarioadministracionRepository {
	
  public void addHonorarioadministracion(Honorarioadministracion honorarioadministracion);
  
  public void editHonorarioadministracion(Honorarioadministracion honorarioadministracion);
 
  public List<Honorarioadministracion> listHonorarioadministracions(Honorarioadministracion honorarioadministracion);   
    
  public Honorarioadministracion getHonorarioadministracion(UUID empid);   
    
  public void deleteHonorarioadministracion(Honorarioadministracion honorarioadministracion); 

  public List<Honorarioadministracion> listHonorarioadministracionsQuery(Honorarioadministracion honorarioadministracion, String query, int page, int size);

  public List<Honorarioadministracion> listHonorarioadministracionsPagination(Honorarioadministracion honorarioadministracion, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
