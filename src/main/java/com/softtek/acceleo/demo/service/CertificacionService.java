package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Certificacion;
import java.util.List;

public interface CertificacionService {
	
  public void addCertificacion(Certificacion certificacion);
  
  public void editCertificacion(Certificacion certificacion);
 
  public List<Certificacion> listCertificacions(Certificacion certificacion);   
    
  public Certificacion getCertificacion(int empid);   
    
  public void deleteCertificacion(Certificacion certificacion); 

  public List<Certificacion> listCertificacionsQuery(Certificacion certificacion, String query, int page, int size);

  public List<Certificacion> listCertificacionsPagination(Certificacion certificacion, int page, int size);	

  public long getTotalRows();
  
  public long getTotalRows(String query);
  
  public long getTotalRowsSearch(String query);
}
