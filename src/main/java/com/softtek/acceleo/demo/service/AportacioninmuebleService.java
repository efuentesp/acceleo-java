package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Aportacioninmueble;
import java.util.List;
import java.util.UUID;

public interface AportacioninmuebleService {
	
  public void addAportacioninmueble(Aportacioninmueble aportacioninmueble);
  
  public void editAportacioninmueble(Aportacioninmueble aportacioninmueble);
 
  public List<Aportacioninmueble> listAportacioninmuebles(Aportacioninmueble aportacioninmueble);   
    
  public Aportacioninmueble getAportacioninmueble(UUID empid);   
    
  public void deleteAportacioninmueble(Aportacioninmueble aportacioninmueble); 

  public List<Aportacioninmueble> listAportacioninmueblesQuery(Aportacioninmueble aportacioninmueble, String query, int page, int size);

  public List<Aportacioninmueble> listAportacioninmueblesPagination(Aportacioninmueble aportacioninmueble, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
