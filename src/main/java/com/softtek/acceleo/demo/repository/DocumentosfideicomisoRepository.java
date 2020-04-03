package com.softtek.acceleo.demo.repository;

import java.util.List;
import java.util.UUID;
import com.softtek.acceleo.demo.domain.Documentosfideicomiso;

public interface DocumentosfideicomisoRepository {
	
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
