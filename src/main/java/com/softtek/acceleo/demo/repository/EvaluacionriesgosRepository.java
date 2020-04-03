package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Evaluacionriesgos;

public interface EvaluacionriesgosRepository {
	
  public void addEvaluacionriesgos(Evaluacionriesgos evaluacionriesgos);
  
  public void editEvaluacionriesgos(Evaluacionriesgos evaluacionriesgos);
 
  public List<Evaluacionriesgos> listEvaluacionriesgoss(Evaluacionriesgos evaluacionriesgos);   
    
  public Evaluacionriesgos getEvaluacionriesgos(UUID empid);   
    
  public void deleteEvaluacionriesgos(Evaluacionriesgos evaluacionriesgos); 

  public List<Evaluacionriesgos> listEvaluacionriesgossQuery(Evaluacionriesgos evaluacionriesgos, String query, int page, int size);

  public List<Evaluacionriesgos> listEvaluacionriesgossPagination(Evaluacionriesgos evaluacionriesgos, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
