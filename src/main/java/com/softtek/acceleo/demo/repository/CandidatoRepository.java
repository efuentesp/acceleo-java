
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Candidato;

public interface CandidatoRepository {

	
	 public void addCandidato(Candidato candidato);   
	 
	 public void editCandidato(Candidato candidato);
	   
	 public List<Candidato> listCandidatos(Candidato candidato);   
	    
	 public Candidato getCandidato(int empid);   
	    
	 public void deleteCandidato(Candidato candidato); 

	 public List<Candidato> listCandidatosQuery(Candidato candidato, String query, int page, int size);

	 public List<Candidato> listCandidatosPagination(Candidato candidato, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

