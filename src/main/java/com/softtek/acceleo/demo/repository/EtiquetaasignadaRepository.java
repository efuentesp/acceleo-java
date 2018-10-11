
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Etiquetaasignada;

public interface EtiquetaasignadaRepository {

	
	 public void addEtiquetaasignada(Etiquetaasignada etiquetaasignada);   
	 
	 public void editEtiquetaasignada(Etiquetaasignada etiquetaasignada);
	   
	 public List<Etiquetaasignada> listEtiquetaasignadas(Etiquetaasignada etiquetaasignada);   
	    
	 public Etiquetaasignada getEtiquetaasignada(int empid);   
	    
	 public void deleteEtiquetaasignada(Etiquetaasignada etiquetaasignada); 

	 public List<Etiquetaasignada> listEtiquetaasignadasQuery(Etiquetaasignada etiquetaasignada, String query, int page, int size);

	 public List<Etiquetaasignada> listEtiquetaasignadasPagination(Etiquetaasignada etiquetaasignada, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

