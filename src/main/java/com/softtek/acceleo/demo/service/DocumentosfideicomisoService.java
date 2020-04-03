package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Documentosfideicomiso;
import java.util.List;
import java.util.UUID;

public interface DocumentosfideicomisoService {
	
  public void addDocumentosfideicomiso(Documentosfideicomiso documentosfideicomiso);
  
  public void editDocumentosfideicomiso(Documentosfideicomiso documentosfideicomiso);
 
  public List<Documentosfideicomiso> listDocumentosfideicomisos(Documentosfideicomiso documentosfideicomiso);   
    
  public Documentosfideicomiso getDocumentosfideicomiso(UUID empid);   
    
  public void deleteDocumentosfideicomiso(Documentosfideicomiso documentosfideicomiso); 

  public List<Documentosfideicomiso> listDocumentosfideicomisosQuery(Documentosfideicomiso documentosfideicomiso, String query, int page, int size);

  public List<Documentosfideicomiso> listDocumentosfideicomisosPagination(Documentosfideicomiso documentosfideicomiso, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
