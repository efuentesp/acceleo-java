package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Candidato;
import java.util.List;
import java.util.UUID;

public interface CandidatoService {
	
  public void addCandidato(Candidato candidato);
  
  public void editCandidato(Candidato candidato);
 
  public List<Candidato> listCandidatos(Candidato candidato);   
    
  public Candidato getCandidato(UUID empid);   
    
  public void deleteCandidato(Candidato candidato); 

  public List<Candidato> listCandidatosQuery(Candidato candidato, String query, int page, int size);

  public List<Candidato> listCandidatosPagination(Candidato candidato, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
