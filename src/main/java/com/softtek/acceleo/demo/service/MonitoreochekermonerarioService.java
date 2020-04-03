package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Monitoreochekermonerario;
import java.util.List;
import java.util.UUID;

public interface MonitoreochekermonerarioService {
	
  public void addMonitoreochekermonerario(Monitoreochekermonerario monitoreochekermonerario);
  
  public void editMonitoreochekermonerario(Monitoreochekermonerario monitoreochekermonerario);
 
  public List<Monitoreochekermonerario> listMonitoreochekermonerarios(Monitoreochekermonerario monitoreochekermonerario);   
    
  public Monitoreochekermonerario getMonitoreochekermonerario(UUID empid);   
    
  public void deleteMonitoreochekermonerario(Monitoreochekermonerario monitoreochekermonerario); 

  public List<Monitoreochekermonerario> listMonitoreochekermonerariosQuery(Monitoreochekermonerario monitoreochekermonerario, String query, int page, int size);

  public List<Monitoreochekermonerario> listMonitoreochekermonerariosPagination(Monitoreochekermonerario monitoreochekermonerario, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
