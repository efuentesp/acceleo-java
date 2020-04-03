package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Honorarioscontrato;

public interface HonorarioscontratoRepository {
	
  public void addHonorarioscontrato(Honorarioscontrato honorarioscontrato);
  
  public void editHonorarioscontrato(Honorarioscontrato honorarioscontrato);
 
  public List<Honorarioscontrato> listHonorarioscontratos(Honorarioscontrato honorarioscontrato);   
    
  public Honorarioscontrato getHonorarioscontrato(UUID empid);   
    
  public void deleteHonorarioscontrato(Honorarioscontrato honorarioscontrato); 

  public List<Honorarioscontrato> listHonorarioscontratosQuery(Honorarioscontrato honorarioscontrato, String query, int page, int size);

  public List<Honorarioscontrato> listHonorarioscontratosPagination(Honorarioscontrato honorarioscontrato, int page, int size);
  
  public long getTotalRows();

  public long getTotalRows(String query);

  public long getTotalRowsSearch(String query);	

}  
