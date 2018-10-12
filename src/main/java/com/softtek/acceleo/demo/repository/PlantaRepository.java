
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Planta;

public interface PlantaRepository {

	
	 public void addPlanta(Planta planta);   
	 
	 public void editPlanta(Planta planta);
	   
	 public List<Planta> listPlantas(Planta planta);   
	    
	 public Planta getPlanta(int empid);   
	    
	 public void deletePlanta(Planta planta); 

	 public List<Planta> listPlantasQuery(Planta planta, String query, int page, int size);

	 public List<Planta> listPlantasPagination(Planta planta, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

