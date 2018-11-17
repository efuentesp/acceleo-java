package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Solicitud;
import java.util.List;
import java.util.UUID;

public interface SolicitudService {
	
  public void addSolicitud(Solicitud solicitud);
  
  public void editSolicitud(Solicitud solicitud);
 
  public List<Solicitud> listSolicituds(Solicitud solicitud);   
    
  public Solicitud getSolicitud(UUID empid);   
    
  public void deleteSolicitud(Solicitud solicitud); 

  public List<Solicitud> listSolicitudsQuery(Solicitud solicitud, String query, int page, int size);

  public List<Solicitud> listSolicitudsPagination(Solicitud solicitud, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
