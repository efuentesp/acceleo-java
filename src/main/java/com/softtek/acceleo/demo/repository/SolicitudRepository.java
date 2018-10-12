
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Solicitud;

public interface SolicitudRepository {

	
	 public void addSolicitud(Solicitud solicitud);   
	 
	 public void editSolicitud(Solicitud solicitud);
	   
	 public List<Solicitud> listSolicituds(Solicitud solicitud);   
	    
	 public Solicitud getSolicitud(int empid);   
	    
	 public void deleteSolicitud(Solicitud solicitud); 

	 public List<Solicitud> listSolicitudsQuery(Solicitud solicitud, String query, int page, int size);

	 public List<Solicitud> listSolicitudsPagination(Solicitud solicitud, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

