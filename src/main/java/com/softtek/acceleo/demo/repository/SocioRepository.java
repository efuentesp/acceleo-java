
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Socio;

public interface SocioRepository {

	
	 public void addSocio(Socio socio);   
	 
	 public void editSocio(Socio socio);
	   
	 public List<Socio> listSocios(Socio socio);   
	    
	 public Socio getSocio(int empid);   
	    
	 public void deleteSocio(Socio socio); 

	 public List<Socio> listSociosQuery(Socio socio, String query, int page, int size);

	 public List<Socio> listSociosPagination(Socio socio, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

